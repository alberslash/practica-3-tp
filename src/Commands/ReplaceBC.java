package Commands;

import Excepciones.ArrayException;
import Excepciones.BadFormaByteCode;
import Main.Engine;

public class ReplaceBC implements Command{

	
	public ReplaceBC() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Reemplaza las instrucciones bytecode
	 */

	private int param;
	public ReplaceBC(int parseInt) {
		this.param = parseInt;
	}

	@Override
	public void execute(Engine engine)throws BadFormaByteCode, ArrayException{
		 engine.replaceByteCode(this.param);
	}

	@Override
	public Command parse(String[] s) {
		if(s.length!= 2 || !s[0].equalsIgnoreCase("REPLACEBC")) return null;
		else return new ReplaceBC(Integer.parseInt(s[1]));
	}

	@Override
	public String textHelp() {
		return "  REPLACE : Remplaza el Bytecode numero N por otra instruccion ByteCode  ";
	}
	
	public String toString(){
		return "REPLACE";
	}
}
