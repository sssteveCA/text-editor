package classes.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import classes.dialogs.About;

/**
 * Click Event listener of About.java dialog
 */
public class AboutClickEvent implements ActionListener {
	
	private About ab; //About dialog handle
	
	public AboutClickEvent(About ab) {
		this.ab = ab;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object fired = e.getSource();
		if(fired.equals(this.ab.jb_ok)) {
			//Close dialog on OK button click
			this.ab.dispose();
			
		}
		
	}

}
