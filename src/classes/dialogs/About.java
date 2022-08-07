package classes.dialogs;

import java.awt.Color;
import java.io.IOException;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import classes.events.AboutClickEvent;
import classes.frames.TextEditor;
import interfaces.Constants;

//About Text Editor dialog
public class About extends JDialog implements Constants {
	
	public final JButton jb_ok = new JButton(AB_BTN1);
	private final static Logger log = Logger.getLogger("classes.dialogs.About");
	
	private TextEditor te;
	private JTextArea ta_info; //Text Editor information text
	private JPanel jpanel;
	
	public About(TextEditor te, String title) {
		super(te,title);
		Properties prop = new Properties();
		try {
			prop.load((About.class).getResourceAsStream("../../log4j.properties"));
			PropertyConfigurator.configure(prop);
			log.setLevel(Level.ALL);
			this.setAboutDialog();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setAboutDialog() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(AB_WINDOW_WIDTH,AB_WINDOW_HEIGHT);
		this.setLocation(AB_WINDOW_X,AB_WINDOW_Y);
		this.setLayout(null);
		this.setVisible(true);
		this.jpanel = new JPanel();
		this.jpanel.setBounds(AB_JP1_X,AB_JP1_Y,AB_JP1_WIDTH,AB_JP1_HEIGHT);
		this.jpanel.setBorder(BorderFactory.createEtchedBorder());
		this.ta_info = new JTextArea(AB_TA1);
		this.ta_info.setBounds(AB_TA1_X,AB_TA1_Y,AB_TA1_WIDTH,AB_TA1_HEIGHT);
		this.ta_info.setEditable(false);
		this.ta_info.setLineWrap(true); //Lines wrap if they are too long for container
		this.ta_info.setWrapStyleWord(true); //If word is too long for container it wraps
		this.ta_info.setOpaque(false);
		this.ta_info.setBorder(null);
		this.ta_info.setFocusable(false);
		this.jpanel.add(this.ta_info);
		this.jb_ok.setBounds(AB_BTN1_X,AB_BTN1_Y,AB_BTN1_WIDTH,AB_BTN1_HEIGHT);
		this.jb_ok.addActionListener(new AboutClickEvent(this));
		this.add(this.jpanel);
		this.add(this.jb_ok);
	}

}
