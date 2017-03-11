package Bytecode.OneParameter.Conditional_Jumps;

import Bytecode.ByteCode;


public class IFEQ extends ConditionalJumps{

	/**
	 * comprueba que la subcima es igual a la cima
	 * si la condicion se cumple e salto se raliza sino sigue con la siguiente instruccion
	 */
	public IFEQ() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IFEQ(int p) {
		super(p);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected boolean compare(int sc, int c) {
		if (c == sc) return true;
		else return false;
	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if(string1.equalsIgnoreCase("IFEQ")) return new IFEQ(Integer.parseInt(string2));
		else return null;
	}

	@Override
	protected String toStringAux() {
		return "IFEQ ";
	}

}
