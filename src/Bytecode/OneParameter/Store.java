package Bytecode.OneParameter;

import Bytecode.ByteCode;

/**
 * Clase store, paquete bytecode y opneParameter
 */
import CPU.CPU;

public class Store extends ByteCodeOneParameter {
	
	/**
	 * Almacena el valor en memoria
	 */
	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Store(int p) {
		super(p);
	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if(string1.equalsIgnoreCase("STORE")) return new Store(Integer.parseInt(string2));
		else return null;
	}

	@Override
	protected String toStringAux() {
		return "STORE ";
	}

	@Override
	public void execute(CPU cpu) {
		 cpu.write(this.param, cpu.pop());
	}


}
