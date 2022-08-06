package classes.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeListener;

import classes.frames.TextEditor;

public class CcClickEvent implements ActionListener{

	private TextEditor te;
	
	public CcClickEvent(TextEditor te) {
		this.te = te;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		switch(command) {
			case "OK":
				break;
			case "cancel":
				break;
		}
	}
	

}
