package classes.dialogs;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import classes.events.TfChangeEvent;
import classes.events.TfClickEvent;
import classes.frames.TextEditor;
import interfaces.Constants;

//Find text dialog in Edit -> Find
public class TextFind extends JDialog implements Constants{
	
	private static final long serialVersionUID = 1L;
	
	private TextEditor te;
	
	public final ButtonGroup group = new ButtonGroup();
	public final JButton jb_findNext = new JButton(TF_BTN1); //Button 'Trova successivo'
	public final JButton jb_cancel = new JButton(TF_BTN2); //Button 'Annulla'
	public final JCheckBox jc_textCase = new JCheckBox(TF_JC1);
	public final JCheckBox jc_textAround = new JCheckBox(TF_JC2);
	public final JRadioButton jr_up = new JRadioButton(TF_RB1); //RadioButton 'Su'
	public final JRadioButton jr_down = new JRadioButton(TF_RB2); //RadioButton 'Giù'
	public final JTextField jt_field = new JTextField();
	private JLabel jl_find; //Label 'Trova:'
	private JPanel jp_direction; //JPanel 'Direzione'
	
	public TextFind(TextEditor te,String title) {
		super(te,title);
		this.te = te;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(TF_WINDOW_WIDTH,TF_WINDOW_HEIGHT);
		this.setLocation(TF_WINDOW_X, TF_WINDOW_Y);
		this.setVisible(true);
		this.jl_find = new JLabel(TF_JLAB1);
		this.jl_find.setBounds(TF_JLAB1_X,TF_JLAB1_Y,TF_JLAB1_WIDTH,TF_JLAB1_HEIGHT);
		this.jt_field.setBounds(TF_TFIELD1_X,TF_TFIELD1_Y,TF_TFIELD1_WIDTH,TF_TFIELD1_HEIGHT);
		this.jt_field.getDocument().addDocumentListener(new TfChangeEvent(this));
		this.jb_findNext.setBounds(TF_BTN1_X,TF_BTN1_Y,TF_BTN1_WIDTH,TF_BTN1_HEIGHT);
		this.jb_findNext.addActionListener(new TfClickEvent(this,this.te));
		this.jb_cancel.setBounds(TF_BTN2_X,TF_BTN2_Y,TF_BTN2_WIDTH,TF_BTN2_HEIGHT);
		this.jb_cancel.addActionListener(new TfClickEvent(this,this.te));
		this.jr_up.setBounds(TF_RB1_X,TF_RB1_Y,TF_RB1_WIDTH,TF_RB1_HEIGHT);
		this.jr_down.setBounds(TF_RB2_X,TF_RB2_Y,TF_RB2_WIDTH,TF_RB2_HEIGHT);
		this.jr_down.setSelected(true);
		this.group.add(jr_up);
		this.group.add(jr_down);
		this.jp_direction = new JPanel();
		this.jp_direction.setBounds(TF_JP1_X,TF_JP1_Y,TF_JP1_WIDTH,TF_JP1_HEIGHT);
		this.jp_direction.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),TF_JP1));
		this.jp_direction.add(this.jr_up);
		this.jp_direction.add(this.jr_down);
		this.jc_textCase.setBounds(TF_JC1_X,TF_JC1_Y,TF_JC1_WIDTH,TF_JC1_HEIGHT);
		this.jc_textAround.setBounds(TF_JC2_X,TF_JC2_Y,TF_JC2_WIDTH,TF_JC2_HEIGHT);
		this.add(jl_find);
		this.add(jt_field);
		this.add(jb_findNext);
		this.add(jb_cancel);
		this.add(jp_direction);
		this.add(jc_textCase);
		this.add(jc_textAround);
	}
}
