package classes.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import classes.dialogs.MyFontChooser;
import classes.frames.TextEditor;

//Click events of MyFontChooser dialog
public class FcClickEvent implements ActionListener{
	
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
		String fontName = this.mfc.jlist_font.getSelectedValue().toString();
		String fontStyle = this.mfc.jlist_style.getSelectedValue().toString();
		String fontSize = this.mfc.jlist_size.getSelectedValue().toString();
		String writing = this.mfc.jbb_writing.getSelectedItem().toString();
		System.out.println("fontName => "+fontName);
		System.out.println("fontStyle => "+fontStyle);
		System.out.println("fontSize => "+fontSize);
		System.out.println("writing => "+writing);
	}

}
