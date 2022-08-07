package classes.dialogs;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.util.Properties;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import classes.frames.TextEditor;

//Print Dialog GUI and events
public class PrintDialog implements Printable {
	
	//Upper left coordinates of the string to print
	public static final int cX = 100;
	public static final int cY = 100;
	private final static Logger log = Logger.getLogger("classes.dialogs.PrintDialog");
	
	public TextEditor te;
	public PrinterJob pj;
	public PageFormat pf;
	
	public PrintDialog(TextEditor te) {
		this.te = te;
		Properties prop = new Properties();
		try {
			prop.load((PrintDialog.class).getResourceAsStream("../../log4j.properties"));
			PropertyConfigurator.configure(prop);
			log.setLevel(Level.ALL);
			this.setPrintDialog();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	//User prints the document
	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		// TODO Auto-generated method stub
		this.showPrintInfo(graphics, pageFormat, pageIndex);
		if(pageIndex > 0) {
			return NO_SUCH_PAGE;
		}
		
		Graphics2D g2d = (Graphics2D)graphics;
		double pfX = pageFormat.getImageableX();
		double pfY = pageFormat.getImageableY();
		g2d.translate(pfX,pfY);
		graphics.drawString(this.te.textarea.getText(), PrintDialog.cX, PrintDialog.cY );
		
		return PAGE_EXISTS;
	}
	
	//Set and display the print dialog
	private void setPrintDialog() {
		this.pj = PrinterJob.getPrinterJob();
		PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
		this.pf = this.pj.pageDialog(pras);
		this.pj.setPrintable(this,this.pf);
		boolean ok = this.pj.printDialog(pras);
		if(ok) {
			//User wants print the document
			try {
				this.pj.print(pras);
			} catch (PrinterException e) {
				// TODO Auto-generated catch block
				System.err.println("PrinterException");
				e.printStackTrace();
			}
		}//if(ok) {
	}
	
	//show print info when user click print button
	private void showPrintInfo(Graphics g, PageFormat pf, int pi) {
		System.out.println("Larghezza pagina => "+pf.getWidth());
		System.out.println("Altezza pagina => "+pf.getHeight());
		System.out.println("Punto X del primo carattere da stampare => "+pf.getImageableX());
		System.out.println("Punto Y del primo carattere da stampare => "+pf.getImageableY());
		System.out.println("Larghezza dell'area di stampa => "+pf.getImageableWidth());
		System.out.println("Altezza dell'area di stampa => "+pf.getImageableHeight());
		int orientation = pf.getOrientation();
		String strOrientation = "";
		switch(orientation) {
			case PageFormat.PORTRAIT:
				strOrientation = "Verticale";
				break;
			case PageFormat.LANDSCAPE:
				strOrientation = "Orizzontale";
				break;
			case PageFormat.REVERSE_LANDSCAPE:
				strOrientation = "Orizzontale capovolto";
				break;
			default:
				strOrientation = "Sconosciuto";
				break;
		}
		System.out.println("Orientamento => "+strOrientation);
		Font font = g.getFont();
		System.out.println("Nome del font utilizzato => "+font.getFontName());
		System.out.println("Famiglia del font => "+font.getFamily());
		System.out.println("Dimensione del font => "+font.getSize());
		int style = font.getStyle();
		String strStyle = "";
		switch(style) {
			case Font.BOLD:
				strStyle = "Grassetto ";
				break;
			case Font.ITALIC:
				strStyle = "Corsivo ";
				break;
			case Font.PLAIN:
				strStyle = "Normale ";
				break;
			default:
				strStyle = "Sconosciuto";
				break;
		}
		System.out.println("Stile del font => "+strStyle);
	}
}
