package interfaces;

//Constants used by TextFindActions
public interface FtaConstants {
	
	//Message exceptions
	public enum Exceptions{
		JTA_NULL("L'istanza di JTextArea è null"), //JTextArea instance is null
		SEARCH_NULL(""); //Search string is null
		
		private final String msg;
		
		Exceptions(final String msg){this.msg = msg;}
		
		@Override
		public String toString() {return this.msg;}
	}

}
