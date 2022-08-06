package classes;

import java.awt.Font;

import classes.frames.TextEditor;

//Font options for TextEditor window
public class FontUtils {
	
	public static final byte ACTION_DECREASE = 0; //changeSize method decrease font size
	public static final byte ACTION_INCREASE = 1; //changeSize method increase font size
	public static final byte ACTION_DEFAULTSIZE = 2; //Reset font size to its default
	private static final float DEFAULT_SIZE = 12f; //default font size
	private static final float MIN_SIZE = 8f; //min font size
	private static final float MAX_SIZE = 72f; //max font size
	//Increase/decrease actual font size by adding/reducing with HOP value
	private static final float HOP = 3f; 
	
	private TextEditor te;
	private Font font; //object for manipulate textarea font
	private float size; //size of the font
	
	public FontUtils(TextEditor te) {
		this.te = te;
		this.font = this.te.textarea.getFont();
		this.size = this.font.getSize2D();
	}
	
	public float getSize() {return this.size;}
	public Font getFont() {return this.font;}
	
	//Change font size. If operation = 0 decrease, else increase
	public void changeSize(byte op) {
		if(op == FontUtils.ACTION_DECREASE) {
			if(this.size >= (FontUtils.MIN_SIZE + FontUtils.HOP)) {
				this.size -= FontUtils.HOP;	
			}
		}
		else if(op == FontUtils.ACTION_INCREASE) {
			if(this.size <= (FontUtils.MAX_SIZE - FontUtils.HOP)) {
				this.size += FontUtils.HOP;
			}
		}
		else this.size = FontUtils.DEFAULT_SIZE;
		this.te.textarea.setFont(this.font.deriveFont(this.size));
		this.font = this.te.textarea.getFont();
	}
	
	//Get the relative font size (%)
	public static int getFontRelativeSize(Font font, int defaultSize) {
		int fontSize = font.getSize();
		double relativeSizeDecimal = (double)fontSize / defaultSize;
		int relativeSize = (int)(relativeSizeDecimal * 100);
		return relativeSize;
	}
}
