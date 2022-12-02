package classes.dialogs;

import java.awt.Color;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JColorChooser;
import javax.swing.JDialog;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import classes.events.CcClickEvent;
import classes.frames.TextEditor;
import interfaces.Constants;

public class ColorChooser implements Constants{
	
	private final static Logger log = Logger.getLogger("classes.dialogs.ColorChooser");
	
	private TextEditor te;
	private JColorChooser jcc;
	private JDialog colorDialog;
	
	public ColorChooser(TextEditor te) {
		this.te = te;
		Properties prop = new Properties();
		try {
			prop.load((ColorChooser.class).getResourceAsStream("../../log4j.properties"));
			PropertyConfigurator.configure(prop);
			log.setLevel(Level.ALL);
			this.setDialog(this.te);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setDialog(TextEditor te) {
		this.jcc = new JColorChooser();
		this.jcc.setColor(Color.BLACK);
		CcClickEvent cce = new CcClickEvent(te,this.jcc);
		this.colorDialog = JColorChooser.createDialog(te, CC_DIALOG_TITLE, true, jcc, cce, cce);
		this.colorDialog.setVisible(true);
	}
}
