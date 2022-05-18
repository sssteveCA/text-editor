package classes.events;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import classes.FindTextActions;
import classes.dialogs.TextFind;
import classes.frames.TextEditor;
import interfaces.Constants;
import interfaces.FtaConstants;

//Click events listener of Text Find dialog
public class TfClickEvent implements ActionListener,Constants,FtaConstants{
	
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
			JTextArea jta_content = this.te.textarea;
			String search = this.tf.jt_field.getText();
			boolean caseInsensitive = this.tf.jc_textCase.isSelected();
			boolean downSelected = this.tf.jr_down.isSelected();
			HashMap<String, Object>options = (HashMap<String, Object>) Map.ofEntries(
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
			/*//Find Next button pressed
			//JTextArea of parent frame needs the focus
			this.te.textarea.requestFocus();
			//Check if the search must be case insentive
			boolean caseInsensitive = this.tf.jc_textCase.isSelected();
			//Check which JRadioButton is selected(if down is not checked,the down JRadioButton is selected)
			boolean downSelected = this.tf.jr_down.isSelected();
			//get JTextArea mark position
			int markPos = this.te.textarea.getCaretPosition();
			System.out.println("TfClickEvent markPos => "+markPos);
			//JTextArea content
			String text = this.te.textarea.getText();
			//get search string from Text Find dialog
			String search = this.tf.jt_field.getText();
			//get index of substring(if JRadioButton down is selected the search of substring will be forwards otherwise backwards)
			int index = -1;
			if(downSelected) {
				if(!caseInsensitive) index = text.toLowerCase().indexOf(search.toLowerCase(),markPos);
				else index = text.indexOf(search,markPos);
			}//if(downSelected) {
			else {
				if(!caseInsensitive) index = text.toLowerCase().lastIndexOf(search.toLowerCase(),markPos-1);
				else index = text.lastIndexOf(search,markPos-1);
			}
			if(index > -1) {
				//Substring found
				//Get length of search string
				int searchLen = search.length();
				int start = index;
				//Underline the substring search found in text
				int end = index+searchLen;
				this.te.textarea.setSelectionColor(Color.BLUE);
				
				try {
					Highlighter hg = this.te.textarea.getHighlighter();
					hg.removeAllHighlights();
					this.te.textarea.setHighlighter(hg);
					this.te.textarea.getHighlighter().addHighlight(start, end, new DefaultHighlighter.DefaultHighlightPainter(Color.LIGHT_GRAY));
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(downSelected) {
					//If the search is downward the caret is set at the end of substring found
					this.te.textarea.setCaretPosition(end);
				}
				else {
					System.out.println("Direzione su");
					System.out.println("Start => "+start);
					System.out.println("End => "+end);
					//If the search is upward the caret is set at the start of substring found
					this.te.textarea.setCaretPosition(start);
				}
				//Move position of textarea caret to index
			}//if(index > -1) {
			else {
				//No substring found in the search direction selected
				JOptionPane.showMessageDialog(this.te, "Impossibile trovare '"+search+"'",TF_JOP1_TITLE,JOptionPane.WARNING_MESSAGE);
			}*/
			
		}//if(fired.equals(this.tf.jb_findNext)) {
		else if(fired.equals(this.tf.jb_cancel)) {
			//Cancel button pressed
			this.tf.dispose();
		}
		
	}

}
