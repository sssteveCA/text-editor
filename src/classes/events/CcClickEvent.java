package classes.events;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.event.ChangeListener;

import classes.frames.TextEditor;

public class CcClickEvent implements ActionListener{

	private TextEditor te;
	private JColorChooser jcc;
	
	public CcClickEvent(TextEditor te, JColorChooser jcc) {
		this.te = te;
		this.jcc = jcc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		switch(command) {
			case "OK":
				Color selColor = this.jcc.getColor(); //Get the selected color
				this.te.textarea.setForeground(selColor);
				break;
			case "cancel":
				break;
		}
	}
	

}
