package classes.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import classes.dialogs.TextFind;
import classes.frames.TextEditor;

//Click events listener of Text Find dialog
public class TfClickEvent implements ActionListener{
	
	TextFind tf;
	TextEditor te;
	
	public TfClickEvent(TextFind tf,TextEditor te) {
		this.tf = tf;
		this.te = te;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object fired = e.getSource();
		if(fired.equals(this.tf.jb_findNext)) {
			//Find Next button pressed
			//get JTextArea mark position
			int markPos = this.te.textarea.getCaretPosition();
			//JTextArea content
			String text = this.te.textarea.getText();
			//get start index
		}//if(fired.equals(this.tf.jb_findNext)) {
		else if(fired.equals(this.tf.jb_cancel)) {
			//Cancel button pressed
			this.tf.dispose();
		}
		
	}

}
