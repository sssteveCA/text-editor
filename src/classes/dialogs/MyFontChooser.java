package classes.dialogs;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import classes.frames.TextEditor;
import interfaces.Constants;

//Custom Font chooser dialog
public class MyFontChooser extends JDialog implements Constants {
	
	private static final long serialVersionUID = 1L;
	
	public final JButton jb_ok = new JButton(FC_BTN1);
	public final JButton jb_reset = new JButton(FC_BTN2);
	
	private JLabel jl_font;
	private JLabel jl_style;
	private JLabel jl_size;

	public MyFontChooser(TextEditor te, String title, boolean modal) {
		super(te,title,modal);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(FC_WINDOW_WIDTH, FC_WINDOW_HEIGHT);
		this.setLocation(FC_WINDOW_X,FC_WINDOW_Y);
		this.setLayout(null);
		this.setVisible(true);
		this.jl_font = new JLabel(FC_JLAB1);
		this.jl_font.setBounds(FC_JLAB1_X,FC_JLAB1_Y,FC_JLAB1_WIDTH,FC_JLAB1_HEIGHT);
		this.jl_style = new JLabel(FC_JLAB2);
		this.jl_style.setBounds(FC_JLAB2_X,FC_JLAB2_Y,FC_JLAB2_WIDTH,FC_JLAB2_HEIGHT);
		this.jl_size = new JLabel(FC_JLAB3);
		this.jl_size.setBounds(FC_JLAB3_X,FC_JLAB3_Y,FC_JLAB3_WIDTH,FC_JLAB3_HEIGHT);
		this.jb_ok.setBounds(FC_BTN1_X,FC_BTN1_Y,FC_BTN1_WIDTH,FC_BTN1_HEIGHT);
		this.jb_reset.setBounds(FC_BTN2_X,FC_BTN2_Y,FC_BTN2_WIDTH,FC_BTN2_HEIGHT);
		this.add(jl_font);
		this.add(jl_style);
		this.add(jl_size);
		this.add(jb_ok);
		this.add(jb_reset);
	}
}
