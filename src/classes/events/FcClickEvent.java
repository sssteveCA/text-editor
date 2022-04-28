package classes.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import classes.dialogs.MyFontChooser;

//Click events of MyFontChooser dialog
public class FcClickEvent implements ActionListener{
	
	private MyFontChooser mfc;
	
	public FcClickEvent(MyFontChooser mfc) {
		this.mfc = mfc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object fired = e.getSource(); //object when event occurred
		if(fired.equals(this.mfc.jb_ok)) {
			//Ok button pressed
			this.mfc.dispose();
		}
		else if(fired.equals(this.mfc.jb_reset)) {
			//Reset button pressed
			this.mfc.dispose();
		}
		
	}

}
