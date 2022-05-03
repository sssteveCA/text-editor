package classes.dialogs;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

//Print Dialog GUI and events
public class PrintDialog implements Printable {
	
	public PrinterJob pj;
	public PageFormat pf;
	
	public PrintDialog() {
		this.pj = PrinterJob.getPrinterJob();
		PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
		this.pf = this.pj.pageDialog(pras);
		this.pj.setPrintable(this,this.pf);
		boolean ok = this.pj.printDialog(pras);
		if(ok) {
			try {
				this.pj.print(pras);
			} catch (PrinterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		System.out.println("Print Dialog graphics => "+graphics);
		System.out.println("Print Dialog PageFormat => "+pageFormat);
		System.out.println("Print Dialog pageIndex => "+pageIndex);
		// TODO Auto-generated method stub
		return 0;
	}
}
