import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.SwingUtilities;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import classes.frames.TextEditor;
import interfaces.Constants;

public class Main implements Constants {
	
	final static Logger log = Logger.getLogger("Main");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Properties prop = new Properties();
				try {
					prop.load((Main.class).getResourceAsStream("./log4j.properties"));
					PropertyConfigurator.configure(prop);
					log.setLevel(Level.ALL);
					new Main().createTextEditorFrame();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}		
		});
	}

	
	public void createTextEditorFrame() {
		TextEditor te = new TextEditor(TE_WINDOW_NAME);
	}
}

