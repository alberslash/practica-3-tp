package Bytecode.OneParameter;

import Bytecode.ByteCode;
import CPU.CPU;


public class Goto extends ByteCodeOneParameter{
	/**
	 * Salto incondicional, provoca un cambio en el contador de programa
	 * de la cpu, que pasa a ser n.
	 * Es decir el efecto de esta instrucción es pasar a ejecutar la instrucción N.
	 */
	
	public Goto() {
		super();
	}

	public Goto(int p) {
		super(p);
	}
	
	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if(string1.equalsIgnoreCase("GOTO")){
			return new Goto (Integer.parseInt(string2));
		}
		else return null;
	}

	@Override
	protected String toStringAux() {
		return "GOTO ";
	}

	@Override
	public void execute(CPU cpu){ 
		if(cpu.getNumProg() != 0 && cpu.comprobarSalto(this.param)){
			cpu.setProgramCounter(this.param);
		}
	}
}

