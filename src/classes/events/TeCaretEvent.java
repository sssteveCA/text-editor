package classes.events;

import java.io.IOException;
import java.util.Properties;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import classes.frames.TextEditor;

//This class waits for text selection change in TextEditor frame
public class TeCaretEvent implements CaretListener {

	private final static Logger log = Logger.getLogger("classes.events.TeCaretEvent");
	private TextEditor te;
	
	public TeCaretEvent(TextEditor te) {
		this.te = te;
	}
	
	@Override
	public void caretUpdate(CaretEvent e) {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		try {
			prop.load((TeCaretEvent.class).getResourceAsStream("../../log4j.properties"));
			PropertyConfigurator.configure(prop);
			log.setLevel(Level.ALL);
			Object fired = e.getSource();
			if(fired.equals(this.te.textarea)) {
				int start = this.te.textarea.getSelectionStart();
				int end = this.te.textarea.getSelectionEnd();
				if(end > start) {
					//Text selected
				}	
			}//if(fired.equals(this.te.textarea)) {
		this.te.setStatusBarLabels();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
}
