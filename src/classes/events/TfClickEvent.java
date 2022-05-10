package classes.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import classes.dialogs.TextFind;

//Click events listener of Text Find dialog
public class TfClickEvent implements ActionListener{
	
	TextFind tf;
	
	public TfClickEvent(TextFind tf) {
		this.tf = tf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object fired = e.getSource();
		if(fired.equals(this.tf.jb_findNext)) {
			//Find Next button pressed
		}//if(fired.equals(this.tf.jb_findNext)) {
		else if(fired.equals(this.tf.jb_cancel)) {
			//Cancel button pressed
			this.tf.dispose();
		}
		
	}

}
