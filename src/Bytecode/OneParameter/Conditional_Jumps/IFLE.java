package Bytecode.OneParameter.Conditional_Jumps;

import Bytecode.ByteCode;

public class IFLE extends ConditionalJumps{
	/**
	 * comprueba que la subcima es menor que la cima
	 * si la condicion se cumple e salto se raliza sino sigue con la siguiente instruccion
	 */
	public IFLE() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IFLE(int j) {
		super(j);
	}

	@Override
	protected boolean compare(int sc, int c) {
		if(sc < c) return true;
		else return false;
	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if(string1.equalsIgnoreCase("IFLE")) return new IFLE(Integer.parseInt(string2));
		else return null;
	}

	@Override
	protected String toStringAux() {
		return "IFLE ";
	}
}
