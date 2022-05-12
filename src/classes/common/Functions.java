package classes.common;

import java.awt.Font;

import interfaces.FcLists;

//This class contains common static methods
public class Functions implements FcLists {
	
	//Get the font style String representation
	public static String getFontStyleStr(int style) {
		String styleName = null;
		switch(style) {
			case Font.BOLD:
				styleName = fl_styles[2];
				break;
			case Font.ITALIC:
				styleName = fl_styles[1];
				break;
			case Font.PLAIN:
				styleName = fl_styles[0];
				break;
			case Font.BOLD|Font.ITALIC:
				styleName = fl_styles[3];
				break;
		}
		return styleName;
	}

}
