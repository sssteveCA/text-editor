package classes.events;

import java.awt.Font;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import classes.common.Functions;
import classes.dialogs.MyFontChooser;

/**
 * When a selection in JList changes
 */
public class FcSelectionEvent implements ListSelectionListener {
	
	private MyFontChooser mfc;
	
	public FcSelectionEvent(MyFontChooser mfc) {
		this.mfc = mfc;
	}

	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		//get element when event occurred
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
