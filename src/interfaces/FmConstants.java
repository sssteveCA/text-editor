package interfaces;

/**
 * Constants of FileManager class
 */
public interface FmConstants {
	
	//error codes
	int OPEN_ERROR = 1; 
	int OPEN_IOERROR = 2;
	int OPEN_NOTFOUND = 3;
	int OPEN_CANCEL = 4;
	int SAVE_CANCEL = 10;
	int SAVE_ERROR = 11;
	int UNKNOWN_ERROR = 1000;
	
	public enum Open{
		CANCEL("Operazione di apertura del file cancellata"),
		ERROR("Errore durante l'apertura del file"),
		IOERROR("Errore I/O durante l'apertura del file"),
		NOTFOUND("File non trovato");
		
		private final String msg;
		
		Open(final String msg){this.msg = msg;}
		
		@Override
		public String toString() {return this.msg;}
	}

	public enum Save{
		CANCEL("Operazione di salvataggio cancellata"),
		ERROR("Errore durante il salvataggio del file"),
		SAVED("File salvato");
		
		private final String msg;
		
		Save(final String msg){this.msg = msg;}
		
		@Override
		public String toString() {return this.msg;}
	}
}
