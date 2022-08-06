package classes.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;

import classes.frames.TextEditor;

public class ColorChooser{
	
	private TextEditor te;
	private JColorChooser jcc;
	private JDialog colorDialog;
	
	public ColorChooser(TextEditor te) {
		this.te = te;
		this.setDialog(this.te);
	}
	
	public void setDialog(TextEditor te) {
		this.jcc = new JColorChooser();
		this.jcc.setColor(Color.BLACK);
		this.jcc.getSelectionModel().addChangeListener(null);
		this.colorDialog = JColorChooser.createDialog(te, "Scegli un colore", true, jcc, null, null);
		this.colorDialog.setVisible(true);
	}
}
