package classes;

import javax.swing.JTextArea;


//This class contains actions done by Text Find dialog
public class FindTextActions {
	
	private JTextArea jta_content; //JTextArea box that contains text for search
	private String search; //String to search in JTextArea
	private String content; //JTextArea string content
	private byte errno; //error code
	private String error; //error message
	
	public FindTextActions(JTextArea jta_content, String search) {
		this.jta_content = jta_content;
		if(this.jta_content != null) {
			
		}
		this.search = search;
	}
	
	public JTextArea getJtaContent() {return this.jta_content;}
	public String getSearch() {return this.search;}
	public String getContent() {return this.content;}
	public byte getErrno() {return this.errno;}
	public String getError() {
		switch(this.errno) {
			default:
				this.error = null;
		}
		return this.error;
	}
}
