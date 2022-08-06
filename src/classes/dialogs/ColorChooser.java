package classes.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;

import classes.events.CcClickEvent;
import classes.frames.TextEditor;
import interfaces.Constants;

public class ColorChooser implements Constants{
	
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
		CcClickEvent cce = new CcClickEvent(te,this.jcc);
		this.colorDialog = JColorChooser.createDialog(te, CC_DIALOG_TITLE, true, jcc, cce, cce);
		this.colorDialog.setVisible(true);
	}
}
