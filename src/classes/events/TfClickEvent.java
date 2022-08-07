package classes.events;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import classes.FindTextActions;
import classes.dialogs.TextFind;
import classes.frames.TextEditor;
import interfaces.Constants;
import interfaces.FtaConstants;

//Click events listener of Text Find dialog
public class TfClickEvent implements ActionListener,Constants,FtaConstants{
	
	private final static Logger log = Logger.getLogger("classes.events.TfClickEvent");
	TextFind tf;
	TextEditor te;
	
	public TfClickEvent(TextFind tf,TextEditor te) {
		this.tf = tf;
		this.te = te;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		try {
			prop.load((TfClickEvent.class).getResourceAsStream("../../log4j.properties"));
			PropertyConfigurator.configure(prop);
			log.setLevel(Level.ALL);
			this.textFindAction(e);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
	
	//executed when user click on Find Next or Find Previous menu items
	private void textFindAction(ActionEvent e) {
		Object fired = e.getSource();
		if(fired.equals(this.tf.jb_findNext)) {
			JTextArea jta_content = this.te.textarea;
			String search = this.tf.jt_field.getText();
			this.te.searchString = search;
			boolean caseInsensitive = this.tf.jc_textCase.isSelected();
			this.te.caseInsensitive = caseInsensitive;
			boolean downSelected = this.tf.jr_down.isSelected();
			//Immutable Map
			Map<String, Object>options = Map.ofEntries(
					new AbstractMap.SimpleEntry<String, Object>("caseInsensitive",(boolean)caseInsensitive),
					new AbstractMap.SimpleEntry<String,Object>("downSelected",downSelected)
					);
			try {
				FindTextActions fta = new FindTextActions(jta_content,search,options);
				boolean searched = fta.checkSearch();
				if(searched) {
					//Search string found in JTextArea box
					this.te.textarea = fta.getJtaContent();
				}//if(searched) {
				else {
					byte errno = fta.getErrno();
					if(errno == FTA_SEARCHNOTFOUND)
						JOptionPane.showMessageDialog(this.te, "Impossibile trovare '"+search+"'",TF_JOP1_TITLE,JOptionPane.WARNING_MESSAGE);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(this.te, e1.getMessage());
			}
			
		}//if(fired.equals(this.tf.jb_findNext)) {
		else if(fired.equals(this.tf.jb_cancel)) {
			//Cancel button pressed
			this.tf.dispose();
		}
	}

}
