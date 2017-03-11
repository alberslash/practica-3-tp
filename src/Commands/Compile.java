package Commands;

import Excepciones.ArrayException;
import Excepciones.ComienzaLoad;
import Excepciones.LexicalAnalysis;
import Main.Engine;

public class Compile implements Command{
	/**
	 * clase compile, ejecuta el comando compile
	 */

	@Override
	public void execute(Engine engine) throws ArrayException, LexicalAnalysis,ComienzaLoad {
		engine.compile();
	}

	@Override
	public Command parse(String[] s) {
		if(s.length!= 1 || !s[0].equalsIgnoreCase("COMPILE")) return null;
		else return new Compile();
	}

	@Override
	public String textHelp() {
		return " COMPILE :  ";
	}
	
	public String toString(){
		return "COMPILE";
	}
}
