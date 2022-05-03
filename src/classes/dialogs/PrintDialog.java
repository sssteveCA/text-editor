package classes.dialogs;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

import classes.frames.TextEditor;

//Print Dialog GUI and events
public class PrintDialog implements Printable {
	
	//Upper left coordinates of the string to print
	public static final int cX = 100;
	public static final int cY = 100;
	
	public TextEditor te;
	public PrinterJob pj;
	public PageFormat pf;
	
	public PrintDialog(TextEditor te) {
		this.te = te;
		this.setPrintDialog();
	}

	//User prints the document
	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		// TODO Auto-generated method stub
		System.out.println("PrintDialog print");
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
				System.out.println("PrintDialog pj.print");
				this.pj.print(pras);
			} catch (PrinterException e) {
				// TODO Auto-generated catch block
				System.err.println("PrinterException");
				e.printStackTrace();
			}
		}//if(ok) {
	}
}
