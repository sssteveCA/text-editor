package interfaces;

/**
 * Popup menu values
 */
public interface PopupVals {
	/**
	 * Right click popup menu
	 */
	public enum popMenu{
		CUT("Taglia"),
		COPY("Copia"),
		PASTE("Incolla"),
		SELECT_ALL("Seleziona tutto");
		
		private final String text;
		
		popMenu(final String text){this.text = text;}
		
		@Override
		public String toString() {return this.text;}
	}//public enum popMenu{
}
