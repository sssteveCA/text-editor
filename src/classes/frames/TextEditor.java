package classes.frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import classes.FontUtils;
import classes.common.Functions;
import classes.events.TeCaretEvent;
import classes.events.TeClickEvent;
import classes.events.TeMouseEvent;
import interfaces.Constants;
import interfaces.MenuVals;
import interfaces.PopupVals;

public class TextEditor extends JFrame implements Constants,MenuVals{

	private static final long serialVersionUID = 1L;
	private JScrollPane jsp_text; //Scroll bars for Text Editor window textarea
	private String title; //title of the window
	
	
	public JMenuItem miAutoWrap; //Needed for change the label on click
	public JMenuItem miStatusBar; //Needed for change the label on click
	public JPanel statusBar; //This panel appears at the bottom of the window when user clicks on statusBar menu item
	public LinkedHashMap<String, JLabel> statusBarLabels;
	public JTextArea textarea;
	//Right click 'Edit' popup menu
	public final JPopupMenu pm_edit = new JPopupMenu(TE_PM1);
	public String searchString = null; //Search string passed from Text Find dialog
	public boolean caseInsensitive = false; //String search sensitive option from Text Find dialog(default false)
	
	
	public TextEditor(String title) {
		super(title);
		this.textarea = new JTextArea();
		this.textarea.addMouseListener(new TeMouseEvent(this));
		this.textarea.addCaretListener(new TeCaretEvent(this));
		this.jsp_text = new JScrollPane(this.textarea);
		//this.add(this.textarea);
		this.add(jsp_text);
		this.setJMenuBar(this.menu());
		this.setStatusBar();
		this.setSize(TE_WINDOW_WIDTH,TE_WINDOW_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	//create the menu for the window
	private JMenuBar menu() {
		JMenuBar mb = new JMenuBar();
			JMenu mFile = new JMenu(Menu.FILE.toString());
				JMenuItem miNew = new JMenuItem(Menu.mFile.NEW.toString());
				JMenuItem miOpen = new JMenuItem(Menu.mFile.OPEN.toString());
				JMenuItem miSave = new JMenuItem(Menu.mFile.SAVE.toString());
				JMenuItem miPrint = new JMenuItem(Menu.mFile.PRINT.toString());
				JMenuItem miExit = new JMenuItem(Menu.mFile.EXIT.toString());
				miNew.addActionListener(new TeClickEvent(this));
				miOpen.addActionListener(new TeClickEvent(this));
				miSave.addActionListener(new TeClickEvent(this));
				miPrint.addActionListener(new TeClickEvent(this));
				miExit.addActionListener(new TeClickEvent(this));
			mFile.add(miNew);
			mFile.add(miOpen);
			mFile.add(miSave);
			mFile.addSeparator();
			mFile.add(miPrint);
			mFile.addSeparator();
			mFile.add(miExit);
		mb.add(mFile);
			JMenu mEdit = new JMenu(Menu.EDIT.toString());
				JMenuItem miCut = new JMenuItem(Menu.mEdit.CUT.toString());
				JMenuItem miCopy = new JMenuItem(Menu.mEdit.COPY.toString());
				JMenuItem miPaste = new JMenuItem(Menu.mEdit.PASTE.toString());
				JMenuItem miFind = new JMenuItem(Menu.mEdit.FIND.toString());
				JMenuItem miFindPre = new JMenuItem(Menu.mEdit.FIND_PRE.toString());
				JMenuItem miFindNext = new JMenuItem(Menu.mEdit.FIND_NEXT.toString());
				JMenuItem miSelectAll = new JMenuItem(Menu.mEdit.SELECT_ALL.toString());
				miCut.addActionListener(new TeClickEvent(this));
				miCopy.addActionListener(new TeClickEvent(this));
				miPaste.addActionListener(new TeClickEvent(this));
				miFind.addActionListener(new TeClickEvent(this));
				miFindPre.addActionListener(new TeClickEvent(this));
				miFindNext.addActionListener(new TeClickEvent(this));
				miSelectAll.addActionListener(new TeClickEvent(this));
			mEdit.add(miCut);
			mEdit.add(miCopy);
			mEdit.add(miPaste);
			mEdit.addSeparator();
			mEdit.add(miFind);
			mEdit.add(miFindPre);
			mEdit.add(miFindNext);
			mEdit.addSeparator();
			mEdit.add(miSelectAll);
		mb.add(mEdit);
			JMenu mFormat = new JMenu(Menu.FORMAT.toString());
				this.miAutoWrap = new JMenuItem(Menu.mFormat.AUTO_WRAP.toString());
				JMenuItem miFont = new JMenuItem(Menu.mFormat.FONT.toString());
				this.miAutoWrap.addActionListener(new TeClickEvent(this));
				miFont.addActionListener(new TeClickEvent(this));
			mFormat.add(this.miAutoWrap);
			mFormat.add(miFont);
		mb.add(mFormat);
			JMenu mView = new JMenu(Menu.VIEW.toString());
				JMenu mZoom = new JMenu(Menu.mView.ZOOM.toString());
					JMenuItem mZoomIn = new JMenuItem(Menu.mView.mZoom.ZOOM_IN.toString());
					JMenuItem mZoomOut = new JMenuItem(Menu.mView.mZoom.ZOOM_OUT.toString());
					JMenuItem mDefaultZoom = new JMenuItem(Menu.mView.mZoom.DEFAULT_ZOOM.toString());
					mZoomIn.addActionListener(new TeClickEvent(this));
					mZoomOut.addActionListener(new TeClickEvent(this));
					mDefaultZoom.addActionListener(new TeClickEvent(this));
				mZoom.add(mZoomIn);
				mZoom.add(mZoomOut);
				mZoom.add(mDefaultZoom);
				mView.add(mZoom);
				this.miStatusBar = new JMenuItem(Menu.mView.STATUS_BAR.toString());
				this.miStatusBar.addActionListener(new TeClickEvent(this));
			mView.add(this.miStatusBar);
		mb.add(mView);
			JMenu mAbout = new JMenu(Menu.ABOUT.toString());
				JMenuItem mAboutTe = new JMenuItem(Menu.mAbout.ABOUT_TE.toString());
				mAboutTe.addActionListener(new TeClickEvent(this));
			mAbout.add(mAboutTe);
		mb.add(mAbout);
			JMenuItem pm_cut = new JMenuItem(PopupVals.popMenu.CUT.toString());
			JMenuItem pm_copy = new JMenuItem(PopupVals.popMenu.COPY.toString());
			JMenuItem pm_paste = new JMenuItem(PopupVals.popMenu.PASTE.toString());
			JMenuItem pm_selectAll = new JMenuItem(PopupVals.popMenu.SELECT_ALL.toString());
			pm_cut.addActionListener(new TeClickEvent(this));
			pm_copy.addActionListener(new TeClickEvent(this));
			pm_paste.addActionListener(new TeClickEvent(this));
			pm_selectAll.addActionListener(new TeClickEvent(this));
			this.pm_edit.add(pm_cut);
			this.pm_edit.add(pm_copy);
			this.pm_edit.add(pm_paste);
			this.pm_edit.addSeparator();
			this.pm_edit.add(pm_selectAll);
		return mb;
	}
	
	//Get the text from window textarea
	public String getText() {
		String str="";
		for(String line : this.textarea.getText().split("\n")) {
			str+=line+"\n";
		}
		return str;
	}
	
	//Create/Set the JPanel status bar 
	/*
	 * visible - show/hide the JPanel
	 * row - row number of the caret in JTextArea
	 * column - number of the caret in JTextArea
	 * zoom - zoom level in percentage
	 * cr - carriage return type
	 * charset - charset encoding
	 * */
	public void setStatusBar() {
		if(this.statusBar == null)
			this.statusBar = new JPanel();
		//Set status bar style
		this.statusBar.setBorder(new BevelBorder(BevelBorder.LOWERED));
		this.add(this.statusBar,BorderLayout.SOUTH);
		this.statusBar.setPreferredSize(new Dimension(this.getWidth(),TE_JP1_HEIGHT));
		this.statusBar.setLayout(new BoxLayout(this.statusBar,BoxLayout.X_AXIS));
		//Create HashMap with Jlabels for container
		this.statusBarLabels = new LinkedHashMap<String, JLabel>();
		//this.statusBarLabels.clear();
		this.statusBarLabels.put(TE_JLAB_JP1_VOID, new JLabel(""));
		this.statusBarLabels.put(TE_JLAB_JP1_CARETPOSITION, new JLabel(""));
		this.statusBarLabels.put(TE_JLAB_JP1_ZOOM, new JLabel(""));
		this.statusBarLabels.put(TE_JLAB_JP1_CARRIAGERETURN, new JLabel(""));
		this.statusBarLabels.put(TE_JLAB_JP1_CHARSET,new JLabel(""));
		//Add Jlabels to container with loop
		this.statusBarLabels.forEach((key, value) -> {
			value.setSize(new Dimension(this.statusBar.getWidth() / 5, this.statusBar.getHeight()));
			System.out.println(key);
			this.statusBar.add(value);
			this.statusBar.add(Box.createGlue());
		});
		//Set the text for JLabels
		this.setStatusBarLabels();
		//The bar is invible at the beginning
		this.statusBar.setVisible(false);
	}
	
	public void setStatusBarLabels() {
		int row = Functions.getCaretRow(this.textarea);
		int column = Functions.getCaretColumn(this.textarea);
		this.statusBarLabels.get(TE_JLAB_JP1_CARETPOSITION).setText("Linea "+row+", colonna "+column);
		Font font = this.textarea.getFont();
		int zoom = FontUtils.getFontRelativeSize(font, FONT_DEFAULT_SIZE);
		this.statusBarLabels.get(TE_JLAB_JP1_ZOOM).setText(zoom+"%");
		String cr = System.lineSeparator();
		this.statusBarLabels.get(TE_JLAB_JP1_CARRIAGERETURN).setText(cr);
		String charset = Charset.defaultCharset().name();
		this.statusBarLabels.get(TE_JLAB_JP1_CHARSET).setText(charset);
	}
}
