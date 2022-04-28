package classes.dialogs;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import classes.events.FcClickEvent;
import classes.frames.TextEditor;
import interfaces.Constants;
import interfaces.FcLists;

//Custom Font chooser dialog
public class MyFontChooser extends JDialog implements Constants,FcLists {
	
	private static final long serialVersionUID = 1L;
	
	public final JButton jb_ok = new JButton(FC_BTN1);
	public final JButton jb_reset = new JButton(FC_BTN2);
	public final JList<String> jlist_font = new JList<String>(fl_fonts);
	public final JList<Byte> jlist_size = new JList<Byte>(fl_sizes);
	public final JList<String> jlist_style = new JList<String>(fl_styles);
	public JScrollPane jsp_font;
	public JScrollPane jsp_size;
	public JScrollPane jsp_style;
	public final JTextField jtf_font = new JTextField();
	public final JTextField jtf_style = new JTextField();
	public final JTextField jtf_size = new JTextField();
	private JLabel jl_font; //label "Tipi di carattere:"
	private JLabel jl_style; //label "Stile:"
	private JLabel jl_size; //label "Dimensione:"
	private JPanel jp_example; //panel "Esempio"
	private JPanel jp_font; //JPanel for fonts list
	private JPanel jp_size; //JPanel for sizes list
	private JPanel jp_style; //JPanel for styles list

	public MyFontChooser(TextEditor te, String title, boolean modal) {
		super(te,title,modal);
		this.setJButtons();
		this.setJLabels();
		this.setJPanels();
		this.setJTextFields();
		this.setScrollLists();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(FC_WINDOW_WIDTH, FC_WINDOW_HEIGHT);
		this.setLocation(FC_WINDOW_X,FC_WINDOW_Y);
		this.setLayout(null);
		this.setVisible(true);
	}
	
	//Set JButton objects properties
	private void setJButtons() {
		this.jb_ok.setBounds(FC_BTN1_X,FC_BTN1_Y,FC_BTN1_WIDTH,FC_BTN1_HEIGHT);
		this.jb_reset.setBounds(FC_BTN2_X,FC_BTN2_Y,FC_BTN2_WIDTH,FC_BTN2_HEIGHT);
		this.jb_ok.addActionListener(new FcClickEvent(this));
		this.jb_reset.addActionListener(new FcClickEvent(this));
		this.add(jb_ok);
		this.add(jb_reset);
	}
	
	//Set JLabel objects properties
	private void setJLabels() {
		this.jl_font = new JLabel(FC_JLAB1);
		this.jl_font.setBounds(FC_JLAB1_X,FC_JLAB1_Y,FC_JLAB1_WIDTH,FC_JLAB1_HEIGHT);
		this.jl_style = new JLabel(FC_JLAB2);
		this.jl_style.setBounds(FC_JLAB2_X,FC_JLAB2_Y,FC_JLAB2_WIDTH,FC_JLAB2_HEIGHT);
		this.jl_size = new JLabel(FC_JLAB3);
		this.jl_size.setBounds(FC_JLAB3_X,FC_JLAB3_Y,FC_JLAB3_WIDTH,FC_JLAB3_HEIGHT);
		this.add(jl_font);
		this.add(jl_style);
		this.add(jl_size);
	}
	
	//Set JPanel objects properties
	private void setJPanels() {
		this.jp_example = new JPanel();
		this.jp_example.setBounds(FC_JP1_X,FC_JP1_Y,FC_JP1_WIDTH,FC_JP1_HEIGHT);
		this.jp_example.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),FC_JP1));
		this.add(jp_example);
	}
	
	//Set JTextField objects properties
	private void setJTextFields() {
		this.jtf_font.setBounds(FC_TFIELD1_X,FC_TFIELD1_Y,FC_TFIELD1_WIDTH,FC_TFIELD1_HEIGHT);
		this.jtf_style.setBounds(FC_TFIELD2_X,FC_TFIELD2_Y,FC_TFIELD2_WIDTH,FC_TFIELD2_HEIGHT);
		this.jtf_size.setBounds(FC_TFIELD3_X,FC_TFIELD3_Y,FC_TFIELD3_WIDTH,FC_TFIELD3_HEIGHT);
		this.add(jtf_font);
		this.add(jtf_style);
		this.add(jtf_size);
	}
	
	//Set scroll lists properties
	private void setScrollLists() {
		this.jp_font = new JPanel(new BorderLayout());
		this.jp_font.setBounds(FC_JP2_X,FC_JP2_Y,FC_JP2_WIDTH,FC_JP2_HEIGHT);
		this.jlist_font.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.jsp_font = new JScrollPane();
		this.jsp_font.setViewportView(jlist_font);
		this.jlist_font.setLayoutOrientation(JList.VERTICAL);
		this.jp_font.add(jsp_font);
		this.add(jp_font);
		this.jp_style = new JPanel(new BorderLayout());
		this.jp_style.setBounds(FC_JP3_X,FC_JP3_Y,FC_JP3_WIDTH,FC_JP3_HEIGHT);
		this.jlist_style.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.jsp_style = new JScrollPane();
		this.jsp_style.setViewportView(jlist_style);
		this.jsp_style.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.jsp_style.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.jlist_style.setLayoutOrientation(JList.VERTICAL);
		this.jp_style.add(jsp_style);
		this.add(jp_style);
		this.jp_size = new JPanel(new BorderLayout());
		this.jp_size.setBounds(FC_JP4_X,FC_JP4_Y,FC_JP4_WIDTH,FC_JP4_HEIGHT);
		this.jlist_size.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.jsp_size = new JScrollPane();
		this.jsp_size.setViewportView(jlist_size);
		this.jlist_size.setLayoutOrientation(JList.VERTICAL);
		this.jp_size.add(jsp_size);
		this.add(jp_size);
		
	}
	
}
