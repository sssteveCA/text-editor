package classes.events;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import classes.dialogs.TextFind;

//Change text listener for Text Find dialog
public class TfChangeEvent implements DocumentListener {
	
	private TextFind tf;
	
	public TfChangeEvent(TextFind tf) {
		this.tf = tf;
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		System.out.println("TfChangeEvent inserimento");
		javax.swing.text.Document doc = e.getDocument();
		try {
			System.out.println("Testo => "+doc.getText(0,doc.getLength() - 1));
			System.out.println("Lunghezza => "+doc.getLength());
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		System.out.println("TfChangeEvent rimozione");
		javax.swing.text.Document doc = e.getDocument();
		try {
			System.out.println("Testo => "+doc.getText(0,doc.getLength() - 1));
			System.out.println("Lunghezza => "+doc.getLength());
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		System.out.println("TfChangeEvent uno o più attributi cambiati");
		javax.swing.text.Document doc = e.getDocument();
		try {
			System.out.println("Testo => "+doc.getText(0,doc.getLength() - 1));
			System.out.println("Lunghezza => "+doc.getLength());
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

}
