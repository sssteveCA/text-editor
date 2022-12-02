package classes.events;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JColorChooser;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import classes.frames.TextEditor;

public class CcClickEvent implements ActionListener{

	private TextEditor te;
	private JColorChooser jcc;
	private final static Logger log = Logger.getLogger("classes.events.CcClickEvent");
	
	public CcClickEvent(TextEditor te, JColorChooser jcc) {
		this.te = te;
		this.jcc = jcc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		try {
			prop.load((CcClickEvent.class).getResourceAsStream("../../log4j.properties"));
			PropertyConfigurator.configure(prop);
			log.setLevel(Level.ALL);
			String command = e.getActionCommand();
			switch(command) {
				case "OK":
					Color selColor = this.jcc.getColor(); //Get the selected color
					this.te.textarea.setForeground(selColor);
					break;
				case "cancel":
					break;
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	

}
