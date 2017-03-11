package Bytecode.OneParameter;

import Bytecode.ByteCode;
import CPU.CPU;
import Excepciones.StackException;

public class Load extends ByteCodeOneParameter{
	/**
	 * Carga las instrucciones en memoria
	 */
	public Load() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Load(int p) {
		super(p);
	}
	
	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if(string1.equalsIgnoreCase("LOAD")) return new Load(Integer.parseInt(string2));
		return null;
	}

	@Override
	protected String toStringAux() {
		return "LOAD ";
	}

	@Override
	public void execute(CPU cpu) throws StackException {
		cpu.push(cpu.read(this.param));
	}
}