package Commands;

import Excepciones.LexicalAnalysis;

public class CommandParser {
	
	private final static Command[] commands = {new Help(), new Quit(), new ReplaceBC(),
			   new Run(), new LoadFich(), new Compile()};
	
	/**
	 * Parsea los comandos, en caso de fallo lanza una excepcion
	 */
	public static Command parse(String line)throws LexicalAnalysis {
		line = line.trim();
		String []words = line.split(" +");
		boolean found = false;
		int i = 0;
		Command c =null;
		while(i < commands.length && !found){
			c = commands[i].parse(words);
			if (c != null) found = true;
			else i++;
		}
		if(c == null) throw new LexicalAnalysis("ERROR: Analisis sintactico fallido.");
		return c;
	}
	
	public static void ShowHelp(){
		for(int i = 0; i < commands.length; i++){
			System.out.println(CommandParser.commands[i].textHelp());
		}
	}
}


