package classes;

import java.util.HashMap;

import javax.swing.JTextArea;

import interfaces.FtaConstants;


//This class contains actions done by Text Find dialog
public class FindTextActions implements FtaConstants{
	
	private JTextArea jta_content; //JTextArea box that contains text for search
	private HashMap<String, Object> options; 
	private String search; //String to search in JTextArea
	private String content; //JTextArea string content
	private byte errno; //error code
	private String error; //error message
	
	public FindTextActions(JTextArea jta_content, String search, HashMap<String, Object> options) throws Exception {
		if(jta_content == null)throw new Exception(Exceptions.JTA_NULL.toString());
		this.jta_content = jta_content;
		if(search == null)throw new Exception(Exceptions.SEARCH_NULL.toString());
		this.search = search;
		this.content = this.jta_content.getText();
		this.setHashmap(options);
		this.errno = 0;
		this.error = null;
		
	}
	
	//Set HashMap property values
	private void setHashmap(HashMap<String, Object> options) {
		if(options == null)options = new HashMap<String, Object>();
		this.options = new HashMap<String, Object>();
		if(options.containsKey("insensitive"))
			this.options.put("caseInsensitive",options.get("caseInsensitive"));
		else
			this.options.put("caseInsensitive", false);
		if(options.containsKey("downSelected"))
			this.options.put("downSelected", options.get("downSelected"));
		else
			this.options.put("downSelected", true);
		
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
