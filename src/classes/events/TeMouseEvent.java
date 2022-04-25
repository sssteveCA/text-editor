package classes.events;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import classes.frames.TextEditor;

//Mouse event listeners for Text Editor window
public class TeMouseEvent implements MouseListener{
	
	private TextEditor te;
	
	public TeMouseEvent(TextEditor te) {
		this.te = te;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object fired = e.getSource();
		if(fired.equals(this.te.textarea)) {
			if(e.getButton() == MouseEvent.BUTTON3) {
				//User does right click on textarea
				int x = e.getX();
				int y = e.getY();
				this.te.pm_edit.show(this.te,x,y);
			}
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
