package classes;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.DefaultHighlighter.DefaultHighlightPainter;
import javax.swing.text.Highlighter;

import interfaces.FtaConstants;


//This class contains actions done by Text Find dialog
public class FindTextActions implements FtaConstants{
	
	private JTextArea jta_content; //JTextArea box that contains text for search
	private Map<String, Object> options; 
	private String search; //String to search in JTextArea
	private String content; //JTextArea string content
	private byte errno; //error code
	private String error; //error message
	
	public FindTextActions(JTextArea jta_content, String search, Map<String, Object> options) throws Exception {
		if(jta_content == null)throw new Exception(Exceptions.JTA_NULL.toString());
		this.jta_content = jta_content;
		if(search == null)throw new Exception(Exceptions.SEARCH_NULL.toString());
		this.search = search;
		this.content = this.jta_content.getText();
		this.setMap(options);
		this.errno = 0;
		this.error = null;
		
	}
	
	public JTextArea getJtaContent() {return this.jta_content;}
	public Map getOptions() {return this.options;}
	public String getSearch() {return this.search;}
	public String getContent() {return this.content;}
	public byte getErrno() {return this.errno;}
	public String getError() {
		switch(this.errno) {
			case FTA_UNKNOWNERROR:
				this.error = Messages.UNKNOWNERROR.toString();
				break;
			default:
				this.error = null;
				break;
		}
		return this.error;
	}
	
	//Set Map property values
	private void setMap(Map<String, Object> options) {
		if(options == null)options = Map.ofEntries();
		//Mutable Map
		this.options = new HashMap<String,Object>();
		if(options.containsKey("caseInsensitive"))
			this.options.put("caseInsensitive",options.get("caseInsensitive"));
		else
			this.options.put("caseInsensitive", false);
		if(options.containsKey("downSelected"))
			this.options.put("downSelected", options.get("downSelected"));
		else
			this.options.put("downSelected", true);
	}
	
	//Check the search string in JTextArea content
	public boolean checkSearch() {
		boolean ok = false;
		//JTextArea of parent frame needs the focus
		this.jta_content.requestFocus();
		//get JTextArea mark position
		int markPos = this.jta_content.getCaretPosition();
		int index = -1;
		//Check if search direction is downward
		boolean downSelected = (boolean) this.options.get("downSelected");
		//Check if the search must be case insentive
		boolean caseInsensitive = (boolean) this.options.get("caseInsensitive");
		if(downSelected) {
			//check if search is case Sensitive
			if(!caseInsensitive) {
				index = this.content.toLowerCase().indexOf(this.search.toLowerCase(),markPos);
			}
			else {
				//case insensitive search
				index = this.content.indexOf(this.search,markPos);
			}
		}//if(downSelected) {
		else {
			if(!caseInsensitive) {
				index = this.content.toLowerCase().lastIndexOf(this.search.toLowerCase(),markPos-1);
			}
			else {
				index = this.content.lastIndexOf(this.search,markPos);
			}
		}//else di if(downSelected) {
		if(index > -1) {
			//Substring found
			//Get length of search string
			int searchLen = this.search.length();
			int start = index;
			//Underline the substring search found in text
			int end = index+searchLen;
			this.jta_content.setSelectionColor(Color.BLUE);
			Highlighter hg = this.jta_content.getHighlighter();
			hg.removeAllHighlights();
			this.jta_content.setHighlighter(hg);
			try {
				this.jta_content.getHighlighter().addHighlight(start, end, new DefaultHighlighter.DefaultHighlightPainter(Color.LIGHT_GRAY));
				if(downSelected) {
					//If the search is downward the caret is set at the end of substring found
					this.jta_content.setCaretPosition(end);
				}//if(downSelected) {
				else {
					//If the search is upward the caret is set at the start of substring found
					this.jta_content.setCaretPosition(start);
				}
				ok = true;
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				this.errno = FTA_UNKNOWNERROR;
			}
		}//if(index > -1) {
		else this.errno = FTA_SEARCHNOTFOUND;
		return ok;
	}
}
