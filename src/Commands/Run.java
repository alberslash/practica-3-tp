package Commands;

import Excepciones.ExecutionError;
import Main.Engine;


public class Run implements Command{
	/**
	 * Resetea el programa
	 * @throws ExecutionError 
	 */
	
	@Override
	public void execute(Engine engine) throws ExecutionError {
		 engine.executeCommandRun();
	}

	@Override
	public Command parse(String[] s) {
		if(s.length!= 1 || !s[0].equalsIgnoreCase("RUN")) return null;
		else return new Run();
	}

	@Override
	public String textHelp() {
		return "  RUN : Ejecuta las instrucciones ByteCode almacenadas  ";
	}
	
	public String toString(){
		return "RUN ";
	}
}
