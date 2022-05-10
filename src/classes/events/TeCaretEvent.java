package classes.events;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import classes.frames.TextEditor;

//This class waits for text selection change in TextEditor frame
public class TeCaretEvent implements CaretListener {

	private TextEditor te;
	
	public TeCaretEvent(TextEditor te) {
		this.te = te;
	}
	
	@Override
	public void caretUpdate(CaretEvent e) {
		// TODO Auto-generated method stub
		
	}

}
