package Bytecode.OneParameter.Conditional_Jumps;

import Bytecode.ByteCode;



public class IFNEQ extends ConditionalJumps {
	/**
	 * comprueba que la subcima es distinta de la cima
	 * si la condicion se cumple e salto se raliza sino sigue con la siguiente instruccion
	 */
	public IFNEQ() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IFNEQ(int j) {
		super(j);
	}

	@Override
	protected boolean compare(int sc, int s) {
		if(sc != s) return true;
		else return false;
	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if(string1.equalsIgnoreCase("IFNEQ")) return new IFNEQ(Integer.parseInt(string2));
		else return null;
	}

	@Override
	protected String toStringAux(){
		return "IFNEQ ";
	}
}
