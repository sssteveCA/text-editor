package classes.events;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import classes.dialogs.TextFind;
import classes.frames.TextEditor;

//Click events listener of Text Find dialog
public class TfClickEvent implements ActionListener{
	
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
			//Find Next button pressed
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
				index = text.indexOf(search,markPos);
			}//if(downSelected) {
			else {
				index = text.lastIndexOf(search,markPos);
			}
			if(index > -1) {
				//Substring found
				//Get length of search string
				int searchLen = search.length();
				int start = index;
				//Underline the substring search found in text
				this.te.textarea.setSelectionStart(start);
				int end = index+searchLen;
				this.te.textarea.setSelectionEnd(end);
				this.te.textarea.setSelectionColor(Color.blue);
				this.te.textarea.select(start, end);
				if(downSelected) {
					//If the search is downward the caret is set at the end of substring found
					this.te.textarea.setCaretPosition(end);
				}
				else {
					//If the search is upward the caret is set at the start of substring found
					this.te.textarea.setCaretPosition(start);
				}
				//Move position of textarea caret to index
			}//if(index > -1) {
			else {
				//No substring found in the search direction selected
			}
			
		}//if(fired.equals(this.tf.jb_findNext)) {
		else if(fired.equals(this.tf.jb_cancel)) {
			//Cancel button pressed
			this.tf.dispose();
		}
		
	}

}
