package classes.dialogs;

import javax.swing.JDialog;

import classes.frames.TextEditor;
import interfaces.Constants;

//Custom Font chooser dialog
public class MyFontChooser extends JDialog implements Constants {
	
	private static final long serialVersionUID = 1L;

	public MyFontChooser(TextEditor te, String title, boolean modal) {
		super(te,title,modal);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(FC_WINDOW_WIDTH, FC_WINDOW_HEIGHT);
		this.setLocation(FC_WINDOW_X,FC_WINDOW_Y);
		this.setVisible(true);
	}
}
