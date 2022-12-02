package interfaces;

/**
 * Constants used by TextFindActions
 */
public interface FtaConstants {
	
	//error number constants
	byte FTA_SEARCHNOTFOUND = 1;
	byte FTA_UNKNOWNERROR = 2;
	
	//error string messages
	public enum Messages{
		UNKNOWNERROR("Errore durante la selezione della stringa cercata");
		
		private final String msg;
		
		Messages(final String msg){this.msg = msg;}
		
		@Override
		public String toString() {return this.msg;}
	}
	
	
	//Message exceptions
	public enum Exceptions{
		JTA_NULL("L'istanza di JTextArea è null"), //JTextArea instance is null
		SEARCH_NULL("Nessun testo da cercare inserito"); //Search string is null
		
		private final String msg;
		
		Exceptions(final String msg){this.msg = msg;}
		
		@Override
		public String toString() {return this.msg;}
	}

}
