package classes.frames;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import classes.events.TeCaretEvent;
import classes.events.TeClickEvent;
import classes.events.TeMouseEvent;
import interfaces.Constants;
import interfaces.MenuVals;
import interfaces.PopupVals;

/**
 * Text Editor main window
 */
public class TextEditor extends JFrame implements Constants,MenuVals{

	private static final long serialVersionUID = 1L;
	private JScrollPane jsp_text; //Scroll bars for Text Editor window textarea
	private String title; //title of the window
	
	
	public JMenuItem miAutoWrap; //Needed for change the label on click
	public JTextArea textarea;
	//Right click 'Edit' popup menu
	public JPopupMenu pm_edit;
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
		//this.setSize(TE_WINDOW_WIDTH,TE_WINDOW_HEIGHT);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * Create the menu of the window
	 * @return The menu instance
	 */
	private JMenuBar menu() {
		JMenuBar mb = new JMenuBar();
		JMenu mFile = this.menuFile();
		mb.add(mFile);
		JMenu mEdit = this.menuEdit();
		mb.add(mEdit);
		JMenu mFormat = this.menuFormat();
		mb.add(mFormat);
		JMenu mView = this.menuView();
		mb.add(mView);
		JMenu mAbout = this.menuAbout();
		mb.add(mAbout);
		this.pm_edit = this.rightClickMenu();
		return mb;
	}
	
	/**
	 * Get the text from window textarea
	 * @return
	 */
	public String getText() {
		String str="";
		for(String line : this.textarea.getText().split("\n")) {
			str+=line+"\n";
		}
		return str;
	}

	/**
	 * Dropdown menu 'About'
	 * @return 
	 */
	private JMenu menuAbout(){
		JMenu mAbout = new JMenu(Menu.ABOUT.toString());
		JMenuItem mAboutTe = new JMenuItem(Menu.mAbout.ABOUT_TE.toString());
		mAboutTe.addActionListener(new TeClickEvent(this));
		mAbout.add(mAboutTe);
		return mAbout;
	}

	/**
	 * Dropdown menu 'Edit'
	 * @return
	 */
	private JMenu menuEdit(){
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
		return mEdit;
	}

	/**
	 * Dropdown menu 'Format'
	 * @return
	 */
	private JMenu menuFormat(){
		JMenu mFormat = new JMenu(Menu.FORMAT.toString());
		this.miAutoWrap = new JMenuItem(Menu.mFormat.AUTO_WRAP.toString());
		JMenuItem miFont = new JMenuItem(Menu.mFormat.FONT.toString());
		this.miAutoWrap.addActionListener(new TeClickEvent(this));
		miFont.addActionListener(new TeClickEvent(this));
		mFormat.add(miAutoWrap);
		mFormat.add(miFont);
		return mFormat;
	}

	/**
	 * Dprodown menu 'File'
	 */
	private JMenu menuFile(){
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
		return mFile;
	}

	/**
	 * Dropdown menu 'View'
	 * @return
	 */
	private JMenu menuView(){
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
		return mView;
	}

	/**
	 * Popup menu shown when user clicks the right button
	 * @return
	 */
	private JPopupMenu rightClickMenu(){
		JPopupMenu pm_edit = new JPopupMenu(TE_PM1);
		JMenuItem pm_cut = new JMenuItem(PopupVals.popMenu.CUT.toString());
		JMenuItem pm_copy = new JMenuItem(PopupVals.popMenu.COPY.toString());
		JMenuItem pm_paste = new JMenuItem(PopupVals.popMenu.PASTE.toString());
		JMenuItem pm_selectAll = new JMenuItem(PopupVals.popMenu.SELECT_ALL.toString());
		pm_cut.addActionListener(new TeClickEvent(this));
		pm_copy.addActionListener(new TeClickEvent(this));
		pm_paste.addActionListener(new TeClickEvent(this));
		pm_selectAll.addActionListener(new TeClickEvent(this));
		pm_edit.add(pm_cut);
		pm_edit.add(pm_copy);
		pm_edit.add(pm_paste);
		pm_edit.addSeparator();
		pm_edit.add(pm_selectAll);
		return pm_edit;
	}
}
