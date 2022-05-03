package classes.events;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import classes.dialogs.MyFontChooser;
import classes.frames.TextEditor;
import interfaces.FcLists;

//Click events of MyFontChooser dialog
public class FcClickEvent implements ActionListener,FcLists{
	
	private MyFontChooser mfc;
	private TextEditor te;
	
	public FcClickEvent(MyFontChooser mfc,TextEditor te) {
		this.mfc = mfc;
		this.te = te;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object fired = e.getSource(); //object when event occurred
		if(fired.equals(this.mfc.jb_ok)) {
			//Ok button pressed
			this.okClickActions();
			this.mfc.dispose();
		}
		else if(fired.equals(this.mfc.jb_reset)) {
			//Reset button pressed
			this.mfc.dispose();
		}
		
	}
	
	//Actions when user press OK button in Font Chooser dialog
	private void okClickActions() {
		Font font = this.te.textarea.getFont();
		String fontName = this.mfc.jlist_font.getSelectedValue() != null ? this.mfc.jlist_font.getSelectedValue().toString() : null;
		String fontStyle = this.mfc.jlist_style.getSelectedValue() != null ? this.mfc.jlist_style.getSelectedValue().toString() : null;
		String fontSize = this.mfc.jlist_size.getSelectedValue() != null ? this.mfc.jlist_size.getSelectedValue().toString() : null;
		String writing = this.mfc.jbb_writing.getSelectedItem().toString();
		System.out.println("fontName => "+fontName);
		System.out.println("fontStyle => "+fontStyle);
		System.out.println("fontSize => "+fontSize);
		System.out.println("writing => "+writing);
		if(fontStyle != null) {
			//font style selected in list
			if(fontStyle.equals(fl_styles[0])) {
				//Normal style
				font = font.deriveFont(Font.PLAIN);
			}
			else if(fontStyle.equals(fl_styles[1])) {
				//Italic style
				font = font.deriveFont(Font.ITALIC);
			}
			if(fontStyle.equals(fl_styles[2])) {
				//Bold style
				font = font.deriveFont(Font.BOLD);
			}
			if(fontStyle.equals(fl_styles[0])) {
				//Italic bold style
				font = font.deriveFont(Font.BOLD|Font.ITALIC);
			}
		}//if(fontStyle != null) {
		if(fontSize != null) {
			//font size selected in list
			font = font.deriveFont(Float.parseFloat(fontSize));
		}
		this.te.textarea.setFont(font);
	}

}
