package classes.dialogs;

import javax.swing.JColorChooser;

import classes.frames.TextEditor;

public class ColorChooser extends JColorChooser {
	
	private TextEditor te;
	
	public ColorChooser(TextEditor te) {
		super();
		this.te = te;
	}
}
