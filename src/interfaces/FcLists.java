package interfaces;

/**
 * Font Chooser dialog JLists
 */
public interface FcLists {
	String fl_fonts[] = {
			"Arial" , "Comic Sans MS","Consolas",
			"Georgia" , "Microsoft Sans Serif", "Montserrat Subrayada",
			"Tahoma", "Times New Roman" ,"Verdana"
	};
	Byte fl_sizes[] = {
			11,12,14,16,18,20,22,24,26,28,36,48,72
	};
	String fl_styles[] = {
			"Normale","Corsivo","Grassetto","Grassetto corsivo"
	};
	String fl_writing[] = {
			"Occidentale","Greco","Turco","Baltico",
			"Europa centrale","Cirillico","Vietnamita"
	};

}
