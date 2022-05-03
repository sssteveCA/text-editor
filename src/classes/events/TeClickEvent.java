package classes.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import classes.FileManager;
import classes.FontUtils;
import classes.dialogs.TextFind;
import classes.dialogs.About;
import classes.dialogs.MyFontChooser;
import classes.dialogs.PrintDialog;
import classes.frames.TextEditor;
import interfaces.Constants;
import interfaces.FmConstants;
import interfaces.MenuVals;
import interfaces.PopupVals;

//Click events for Text Editor window
public class TeClickEvent implements ActionListener,MenuVals,FmConstants,Constants{
	
	private TextEditor te;
	
	public TeClickEvent(TextEditor te) {
		this.te = te;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//Get Text from textarea
		FileManager fm = new FileManager(this.te.textarea.getText());
		String cmd = e.getActionCommand();
		if(cmd == Menu.mFile.NEW.toString()) {
			//File -> New
			this.te.textarea.setText("");
		}
		else if(cmd == Menu.mFile.OPEN.toString()) {
			//File -> Open
			if(fm.open()) {
				//File content readed
				this.te.textarea.setText("");
				this.te.textarea.setText(fm.getText());
			}
			else {
				//Error while opening file
				int errno = fm.getErrno();
				if(errno != OPEN_CANCEL) {
					//Don't show dialog message if user cancel operation
					JOptionPane.showMessageDialog(null,fm.getError(),DLG_OPENFILE_TITLE,JOptionPane.ERROR_MESSAGE);
				}//if(errno != OPEN_CANCEL) {
			}
		}//else if(cmd == Menu.mFile.OPEN.toString()) {
		else if(cmd == Menu.mFile.SAVE.toString()) {
			//File -> Save
			if(fm.save()) {
				//File saved
				JOptionPane.showMessageDialog(null, FILE_SAVED,DLG_SAVEFILE_TITLE,JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				int errno = fm.getErrno();
				if(errno != SAVE_CANCEL) {
					//Don't show dialog message if user cancel operation
					JOptionPane.showMessageDialog(null, fm.getError(), DLG_SAVEFILE_TITLE, JOptionPane.ERROR_MESSAGE);
				}
			}
		}//else if(cmd == Menu.mFile.SAVE.toString()) {
		else if(cmd == Menu.mFile.SETPAGE.toString()) {
			//File -> Set Page
		}//else if(cmd == Menu.mFile.SETPAGE.toString()) {
		else if(cmd == Menu.mFile.PRINT.toString()) {
			//File -> Print
			PrintDialog pd = new PrintDialog(this.te);
		}//else if(cmd == Menu.mFile.PRINT.toString) {
		else if(cmd == Menu.mFile.EXIT.toString()) {
			//File -> Exit
			int r = JOptionPane.showConfirmDialog(null, MSG_EXIT, DLG_EXIT_TITLE, JOptionPane.YES_NO_OPTION);
			if(r == JOptionPane.YES_OPTION) {
				//User chose YES
				te.dispose();
			}
		}//else if(cmd == Menu.mFile.EXIT.toString()) {
		else if(cmd == Menu.mEdit.CUT.toString()) {
			//Edit -> Cut
			this.te.textarea.cut();
		}
		else if(cmd == Menu.mEdit.COPY.toString()) {
			//Edit -> Copy
			this.te.textarea.copy();
		}
		else if(cmd == Menu.mEdit.PASTE.toString()) {
			//Edit -> Paste
			this.te.textarea.paste();
		}
		else if(cmd == Menu.mEdit.FIND.toString()) {
			//Edit -> Find
			TextFind tf = new TextFind(this.te,DLG_TEXTFIND_TITLE);
		}
		else if(cmd == Menu.mEdit.FIND_NEXT.toString()) {
			//Edit -> Find Next
		}
		else if(cmd == Menu.mEdit.SELECT_ALL.toString()) {
			//Edit -> Select All
			this.te.textarea.selectAll();
		}
		else if(cmd == Menu.mFormat.AUTO_WRAP.toString()) {
			//Format -> Auto Wrap
		}
		else if(cmd == Menu.mFormat.FONT.toString()) {
			//Format -> Font
			MyFontChooser mfc = new MyFontChooser(this.te,DLG_FONTCHOOSER_TITLE,true);
		}
		else if(cmd == Menu.mView.mZoom.ZOOM_IN.toString()) {
			//View -> Zoom -> Zoom In
			FontUtils fu = new FontUtils(this.te);
			fu.changeSize(FontUtils.ACTION_INCREASE);
		}
		else if(cmd == Menu.mView.mZoom.ZOOM_OUT.toString()) {
			//View -> Zoom -> Zoom out
			FontUtils fu = new FontUtils(this.te);
			fu.changeSize(FontUtils.ACTION_DECREASE);
		}
		else if(cmd == Menu.mView.mZoom.DEFAULT_ZOOM.toString()) {
			//View -> Zoom -> Default zoom
			FontUtils fu = new FontUtils(this.te);
			fu.changeSize(FontUtils.ACTION_DEFAULTSIZE);
		}
		else if(cmd == Menu.mAbout.ABOUT_TE.toString()) {
			//? -> About Text Editor
			About ab = new About(this.te,DLG_ABOUT_TITLE);
		}
		else if(cmd == PopupVals.popMenu.CUT.toString()) {
			//Right click -> Cut
			this.te.textarea.cut();
		}
		else if(cmd == PopupVals.popMenu.COPY.toString()) {
			//Right click -> Copy
			this.te.textarea.copy();
		}
		else if(cmd == PopupVals.popMenu.PASTE.toString()) {
			//Right click -> Paste
			this.te.textarea.paste();
		}
		else if(cmd == PopupVals.popMenu.SELECT_ALL.toString()) {
			//Right click -> Select All
			this.te.textarea.selectAll();
		}
		else {
		}
		
	}
	
}
