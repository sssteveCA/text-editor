package classes.common;

import java.awt.Font;
import java.util.List;

import javax.swing.ListModel;

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
	
	//Get the index position of specified value in ListModel<Byte>
		public static int getIndexByByte(ListModel<Byte> listModel, Byte value) {
			int index = -1; //-1 if value not found
			for(int i = 0; i < listModel.getSize(); i++) {
				Byte elem = listModel.getElementAt(i);
				if(elem.equals(value)) {
					index = i;
					break;
				}
			}
			return index;
		}
	
	//Get the index position of specified value in ListModel<String>
	public static int getIndexByString(ListModel<String> listModel, String value) {
		int index = -1; //-1 if value not found
		for(int i = 0; i < listModel.getSize(); i++) {
			String elem = listModel.getElementAt(i);
			if(elem.equals(value)) {
				index = i;
				break;
			}
		}
		return index;
	}

}
