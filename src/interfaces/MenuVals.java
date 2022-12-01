package interfaces;

/**
 * This interface contains menu constants
 */
public interface MenuVals {
	/**
	 * Main menu items
	 */
	public enum Menu{
		FILE("File"),
		EDIT("Modifica"),
		FORMAT("Formato"),
		VIEW("Visualizza"),
		ABOUT("?");
		
		/**
		 * Menu -> File items
		 */
		public enum mFile{
			NEW("Nuovo"),
			OPEN("Apri"),
			SAVE("Salva"),
			PRINT("Stampa"),
			EXIT("Esci");
			
			private final String text;
			
			mFile(final String text){this.text = text;}
			
			@Override
			public String toString() {return this.text;}
		}//public enum MenuFile{
		
		/**
		 * Menu -> Edit items
		 */
		public enum mEdit{
			CUT("Taglia"),
			COPY("Copia"),
			PASTE("Incolla"),
			FIND("Trova"),
			FIND_PRE("Trova precedente"),
			FIND_NEXT("Trova successivo"),
			SELECT_ALL("Seleziona tutto");
			
			private final String text;
			
			mEdit(final String text){this.text = text;}
			
			@Override
			public String toString() {return this.text;}
		}//public enum mEdit{
		
		/**
		 * Menu -> Format items
		 */
		public enum mFormat{
			AUTO_WRAP("A capo automatico"),
			FONT("Carattere...");
			
			private final String text;
			
			mFormat(final String text){this.text = text;}
			
			@Override
			public String toString() {return this.text;}
		}//public enum mFormat{
		
		/**
		 * Menu -> View items
		 */
		public enum mView{
			ZOOM("Zoom"),
			STATUS_BAR("Barra di stato");
			
			public enum mZoom{
				ZOOM_IN("Zoom avanti"),
				ZOOM_OUT("Zoom indietro"),
				DEFAULT_ZOOM("Zoom predefinito");
				
				private final String text;
				
				mZoom(final String text){this.text = text;}
				
				@Override
				public String toString() {return this.text;}
			}//public enum Zoom{
			
			private final String text;
			
			mView(final String text){this.text = text;}
			
			@Override
			public String toString() {return this.text;}
		}//public enum mView{
		
		/**
		 * Menu -> ? items
		 */
		public enum mAbout{
			ABOUT_TE("Informazioni su Text Editor");
			
			private final String text;
			
			mAbout(final String text){this.text = text;}
			
			@Override
			public String toString() {return this.text;}
		}//public enum mAbout{
		
		private final String text;
		
		Menu(final String text){this.text=text;}
		
		@Override
		public String toString() {return this.text;}
	}
	
}
