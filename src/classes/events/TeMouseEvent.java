package classes.events;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import classes.frames.TextEditor;

//Mouse event listeners for Text Editor window
public class TeMouseEvent implements MouseListener{
	
	private final static Logger log = Logger.getLogger("classes.events.TeMouseEvent");
	private TextEditor te;
	
	public TeMouseEvent(TextEditor te) {
		this.te = te;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		try {
			prop.load((TeMouseEvent.class).getResourceAsStream("../../log4j.properties"));
			PropertyConfigurator.configure(prop);
			log.setLevel(Level.ALL);
			Object fired = e.getSource();
			if(fired.equals(this.te.textarea)) {
				if(e.getButton() == MouseEvent.BUTTON3) {
					//User does right click on textarea
					int x = e.getX();
					int y = e.getY();
					this.te.pm_edit.show(this.te,x,y);
				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
