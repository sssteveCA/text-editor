package classes.frames;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;

import classes.events.TeCaretEvent;
import classes.events.TeClickEvent;
import classes.events.TeMouseEvent;
import interfaces.Constants;
import interfaces.MenuVals;
import interfaces.PopupVals;

public class TextEditor extends JFrame implements Constants,MenuVals{

	private static final long serialVersionUID = 1L;
	private String title; //title of the window
	
	public JTextArea textarea;
	//Right click 'Edit' popup menu
	public final JPopupMenu pm_edit = new JPopupMenu(TE_PM1);
	
	public TextEditor(String title) {
		super(title);
		this.textarea = new JTextArea();
		this.textarea.addMouseListener(new TeMouseEvent(this));
		this.textarea.addCaretListener(new TeCaretEvent(this));
		this.add(this.textarea);
		this.setJMenuBar(this.menu());
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
				JMenuItem miFindNext = new JMenuItem(Menu.mEdit.FIND_NEXT.toString());
				JMenuItem miSelectAll = new JMenuItem(Menu.mEdit.SELECT_ALL.toString());
				miCut.addActionListener(new TeClickEvent(this));
				miCopy.addActionListener(new TeClickEvent(this));
				miPaste.addActionListener(new TeClickEvent(this));
				miFind.addActionListener(new TeClickEvent(this));
				miSelectAll.addActionListener(new TeClickEvent(this));
			mEdit.add(miCut);
			mEdit.add(miCopy);
			mEdit.add(miPaste);
			mEdit.addSeparator();
			mEdit.add(miFind);
			mEdit.add(miFindNext);
			mEdit.addSeparator();
			mEdit.add(miSelectAll);
		mb.add(mEdit);
			JMenu mFormat = new JMenu(Menu.FORMAT.toString());
				JMenuItem miAutoWrap = new JMenuItem(Menu.mFormat.AUTO_WRAP.toString());
				JMenuItem miFont = new JMenuItem(Menu.mFormat.FONT.toString());
				miAutoWrap.addActionListener(new TeClickEvent(this));
				miFont.addActionListener(new TeClickEvent(this));
			mFormat.add(miAutoWrap);
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
				JMenuItem mStatusBar = new JMenuItem(Menu.mView.STATUS_BAR.toString());
				mStatusBar.addActionListener(new TeClickEvent(this));
			mView.add(mStatusBar);
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
}
