package classes.common;

import java.awt.Component;
import java.awt.Font;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ListModel;

import interfaces.FcLists;

//This class contains common static methods
public class Functions implements FcLists {
	
	//Get the font style int representation
	public static int getFontStyleInt(String style) {
		int styleInt = Font.PLAIN;
		if(style.equals(fl_styles[1]))styleInt = Font.ITALIC;
		else if(style.equals(fl_styles[2]))styleInt = Font.BOLD;
		else if(style.equals(fl_styles[3]))styleInt = Font.BOLD|Font.ITALIC;
		return styleInt;
	}
	
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
	
	//Get menu item by String label
	public static JMenuItem getMenuItem(JMenuBar jmBar,String label) {
		JMenuItem item = null;
		//Get number of JMenu in JMenuBar
		int jMenuCount = jmBar.getMenuCount();
		for(int i = 0; i < jMenuCount; i++) {
			//JMenu item child of JMenuBar
			JMenu jMenu = jmBar.getMenu(i);
			//Numbers of jMenuItem in jMenu object
			int jMenuItemCount = jMenu.getMenuComponentCount();
			for(int j = 0; j < jMenuItemCount; j++) {
				//JMenu children
				Component comp = jMenu.getMenuComponent(j);
				if(comp instanceof JMenuItem) {
					item = (JMenuItem) comp;
					if(item.getText().equals(label)) {
						//Found a JMenuItem with label param
						return item;
					}
				}//if(comp instanceof JMenuItem) {
			}//for(int j = 0; j < jMenuItemCount; j++) {
		}//for(int i = 0; i < jMenuCount; i++) {
		return item;
	}

}
