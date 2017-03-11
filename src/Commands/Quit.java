package Commands;

import Main.Engine;


public class Quit implements Command{

	
	/**
	 * Cierra la aplicacion
	 */
	@Override
	public void execute(Engine engine) {
		 engine.endExecution();
	}

	@Override
	public Command parse(String[] s) {
		if(s.length!= 1 || !s[0].equalsIgnoreCase("QUIT")) return null;
		else return new Quit();
	}

	@Override
	public String textHelp() {
		return "  QUIT : Cierra la aplicacion  ";
	}
	
	public String toString(){
		return "QUIT";
	}
}
