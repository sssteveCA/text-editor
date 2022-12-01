import javax.swing.SwingUtilities;

import classes.frames.TextEditor;
import interfaces.Constants;

public class Main implements Constants {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				new Main().createTextEditorFrame();
			}		
		});
	}

	
	public void createTextEditorFrame() {
		TextEditor te = new TextEditor(TE_WINDOW_NAME);
	}
}

