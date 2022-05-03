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
		int firstIndex = e.getFirstIndex();
		int lastIndex = e.getLastIndex();
		/*System.out.println("firstIndex => "+firstIndex);
		System.out.println("lastIndex => "+lastIndex);*/
		if(fired.equals(this.mfc.jlist_font)) {
			//Value changed in font name list
			String fontName = this.mfc.jlist_font.getSelectedValue().toString();
			System.out.println("fontName => "+fontName);
		}else if(fired.equals(this.mfc.jlist_style)) {
			//Value changed in font style list
			String fontStyle = this.mfc.jlist_style.getSelectedValue().toString();
			System.out.println("fontStyle => "+fontStyle);
		}
		else if(fired.equals(this.mfc.jlist_size)) {
			//Value changed in font size list
			String fontSize = this.mfc.jlist_size.getSelectedValue().toString();
			System.out.println("fontSize => "+fontSize);
		}
		
		
	}

}
