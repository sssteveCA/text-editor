package classes.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import classes.dialogs.About;

//Click Event for About.java dialog
public class AboutClickEvent implements ActionListener {
	
	private About ab; //About dialog handle
	private final static Logger log = Logger.getLogger("classes.events.AboutClickEvent");
	
	public AboutClickEvent(About ab) {
		this.ab = ab;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		Object fired = e.getSource();
		if(fired.equals(this.ab.jb_ok)) {
			//Close dialog on OK button click
			try {
				prop.load((AboutClickEvent.class).getResourceAsStream("../../log4j.properties"));
				PropertyConfigurator.configure(prop);
				log.setLevel(Level.ALL);
				this.ab.dispose();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

}
