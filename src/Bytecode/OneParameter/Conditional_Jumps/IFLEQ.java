package Bytecode.OneParameter.Conditional_Jumps;

import Bytecode.ByteCode;

public class IFLEQ extends ConditionalJumps{
	/**
	 * comprueba que la subcima es menor o igual que la cima
	 *si la condicion se cumple e salto se raliza sino sigue con la siguiente instruccion
	 */
 public IFLEQ() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IFLEQ(int j) {
		super(j);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected boolean compare(int sc, int c) {
		if (sc <= c) return true;
		else return false;
	}

	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if(string1.equalsIgnoreCase("IFLEQ")) return new IFLEQ(Integer.parseInt(string2));
		else return null;
	}

	@Override
	protected String toStringAux() {
		return "IFLEQ ";
	}
	

}
