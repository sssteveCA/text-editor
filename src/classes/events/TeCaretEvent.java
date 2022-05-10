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
		Object fired = e.getSource();
		if(fired.equals(this.te.textarea)) {
			int start = this.te.textarea.getSelectionStart();
			int end = this.te.textarea.getSelectionEnd();
			if(end > start) {
				//Text selected
				System.out.println("Inizio selezione => "+this.te.textarea.getSelectionStart());
				System.out.println("Fine selezione => "+this.te.textarea.getSelectionEnd());
				System.out.println("Testo selezionato => "+this.te.textarea.getSelectedText());
			}
			
		}//if(fired.equals(this.te.textarea)) {
	}

}
