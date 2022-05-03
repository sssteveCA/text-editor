package classes.events;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import classes.dialogs.MyFontChooser;

//When a selection in JList changes
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
		if(fired.equals(this.mfc.jlist_font)) {
			//Value changed in font name list
			String fontName = this.mfc.jlist_font.getSelectedValue().toString();
			this.mfc.jtf_font.setText(fontName);
		}else if(fired.equals(this.mfc.jlist_style)) {
			//Value changed in font style list
			String fontStyle = this.mfc.jlist_style.getSelectedValue().toString();
			this.mfc.jtf_style.setText(fontStyle);
		}
		else if(fired.equals(this.mfc.jlist_size)) {
			//Value changed in font size list
			String fontSize = this.mfc.jlist_size.getSelectedValue().toString();
			this.mfc.jtf_size.setText(fontSize);
		}
		
		
	}

}
