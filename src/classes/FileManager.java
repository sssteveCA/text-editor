package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

import interfaces.Constants;
import interfaces.FmConstants;

/**
 * This class perform text file operations
 */
public class FileManager implements FmConstants, Constants {
	
	private String text;
	private int errno; //error code
	private String error; //error message
	
	//Get path of current class dir
	private final File path = new File(FileManager.class.getProtectionDomain().getCodeSource().getLocation().getPath());
	
	public FileManager(String text) {
		this.text = text;
		this.errno = 0;
		this.error = null;
	}
	
	public String getText() {return this.text;}
	public int getErrno() {return this.errno;}
	public String getError() {
		switch(this.errno) {
			case 0:
				this.error = null;
				break;
			case OPEN_ERROR:
				this.error = Open.ERROR.toString();
				break;
			case OPEN_IOERROR:
				this.error = Open.IOERROR.toString();
				break;
			case OPEN_NOTFOUND:
				this.error = Open.NOTFOUND.toString();
				break;
			case OPEN_CANCEL:
				this.error = Open.CANCEL.toString();
				break;
			case SAVE_CANCEL:
				this.error = Save.CANCEL.toString();
				break;
			case SAVE_ERROR:
				this.error = Save.ERROR.toString();
				break;
			default:
				this.error = ERR_UNKNOWN;
				break;
		}//switch(this.errno) {
		return this.error;
	}
	
	/**
	 * Open file dialog
	 * @return 
	 */
	public boolean open() {
		boolean opened = false;
		this.errno = 0;
		JFileChooser fc = new JFileChooser(this.path);
		int r = fc.showOpenDialog(null);
		if(r == JFileChooser.APPROVE_OPTION) {
			String path = fc.getSelectedFile().getAbsolutePath();
			try {
				//Get chosen file content
				this.text = this.getFile(path);
				opened = true;
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				this.errno = OPEN_NOTFOUND;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				this.errno = OPEN_IOERROR;
			}
			
		}//if(r == JFileChooser.APPROVE_OPTION) {
		else if(r == JFileChooser.CANCEL_OPTION) {
			System.out.println("FileManager open CANCEL_OPTION");
			this.errno = OPEN_CANCEL;
		}
		else if(r == JFileChooser.ERROR_OPTION) {
			System.err.println("Errore in FileManager open() r == JFileChooser.ERROR_OPTION");
			this.errno = OPEN_ERROR;
		}
		return opened;
	}
	
	/**
	 * Open Save file dialog
	 * @return
	 */
	public boolean save() {
		boolean save = false;
		this.errno = 0;
		JFileChooser fc = new JFileChooser(this.path);
		int r = fc.showSaveDialog(null);
		if(r == JFileChooser.APPROVE_OPTION) {
			//User click 'Save'
			String path = fc.getSelectedFile().getAbsolutePath()+".txt";
			//write the content to file
			boolean fSave = this.fileSave(path, this.text);
			if(fSave) {
				save = true;
			}
			else {
				System.err.println("Errore in FileManager save() fSave = false");
				this.errno = SAVE_ERROR;
			}
		}//if(r == JFileChooser.APPROVE_OPTION) {
		else if(r == JFileChooser.CANCEL_OPTION) {
			System.out.println("FileManager save() CANCEL_OPTION");
			this.errno = SAVE_CANCEL;
		}
		else if(r == JFileChooser.ERROR_OPTION) {
			System.err.println("Errore in FileManager save() r == JFileChooser.ERROR_OPTION");
			this.errno = SAVE_ERROR;
		} 		
		else {
			System.err.println("Errore in FileManager save() UNKNOWN_ERROR");
			this.errno = UNKNOWN_ERROR;
		}
		return save;
	}
	
	/**
	 * Open file stream and get its content
	 * @param path the path of the file to open
	 * @return the content of the file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private String getFile(String path) throws FileNotFoundException, IOException {
		String content = "";
		File file = new File(path);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		StringBuilder sb = new StringBuilder();
		String line = "";
		while((line = br.readLine()) != null) {
			//Read line per line until file ends
			sb.append(line).append(System.lineSeparator());
		}
		content = sb.toString();
		br.close();
		fr.close();
		return content;
	}
	
	/**
	 * Save the content to a file
	 * @param path the file to be saved
	 * @param content the content to insert to the file
	 * @return
	 */
	private boolean fileSave(String path, String content) {
		boolean saved = false;
		FileWriter fw;
		PrintWriter pw;
		try {
			File file = new File(path);
			fw = new FileWriter(file);
			pw = new PrintWriter(fw);
			pw.write(content);
			pw.flush();
			fw.flush();
			pw.close();
			fw.close();
			saved = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return saved;
	}
	
}
