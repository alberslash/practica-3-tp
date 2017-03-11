package Commands;

import Main.Engine;


public class Help implements Command{
	
	/**
	 * Clase help, muestra la ayuda de los comandos
	 */
	@Override
	public void execute(Engine engine) {
		 engine.showHelp();
	}

	@Override
	public Command parse(String[] s) {
		if(s.length!= 1 || !s[0].equalsIgnoreCase("HELP")) return null;
		else return new Help();
	}

	@Override
	public String textHelp() {
		return "  HELP: Muestra la ayuda  ";
	}
	
	public String toString(){
		return "HELP";
	}
}
