package classes.events;

import java.awt.Font;
import java.io.IOException;
import java.util.Properties;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import classes.common.Functions;
import classes.dialogs.MyFontChooser;

//When a selection in JList changes
public class FcSelectionEvent implements ListSelectionListener {
	
	private final static Logger log = Logger.getLogger("classes.frames.TextEditor");
	private MyFontChooser mfc;
	
	public FcSelectionEvent(MyFontChooser mfc) {
		this.mfc = mfc;
	}

	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		//get element when event occurred
		Properties prop = new Properties();
		try {
			prop.load((FcSelectionEvent.class).getResourceAsStream("../../log4j.properties"));
			PropertyConfigurator.configure(prop);
			log.setLevel(Level.ALL);
			this.setFont(e);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	//Change font style preview in FontChooser dialog after params changed
	private void setFont(ListSelectionEvent e) {
		Object fired = e.getSource();
		Font font = this.mfc.jl_preview.getFont();
		String fontName = font.getFamily();
		int nFontStyle = font.getStyle();
		int nFontSize = font.getSize();
		if(fired.equals(this.mfc.jlist_font)) {
			//Value changed in font name list
			fontName = this.mfc.jlist_font.getSelectedValue().toString();
			this.mfc.jtf_font.setText(fontName);
			
		}else if(fired.equals(this.mfc.jlist_style)) {
			//Value changed in font style list
			String fontStyle = this.mfc.jlist_style.getSelectedValue().toString();
			nFontStyle = Functions.getFontStyleInt(fontStyle);
			this.mfc.jtf_style.setText(fontStyle);
		}
		else if(fired.equals(this.mfc.jlist_size)) {
			//Value changed in font size list
			String fontSize = this.mfc.jlist_size.getSelectedValue().toString();
			nFontSize = Integer.valueOf(fontSize);
			this.mfc.jtf_size.setText(fontSize);
		}
		font = new Font(fontName,nFontStyle,nFontSize);
		this.mfc.jl_preview.setFont(font);
	}

}
