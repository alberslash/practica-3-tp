package Bytecode.OneParameter;

import Bytecode.ByteCode;

public abstract class ByteCodeOneParameter implements ByteCode {
	/**
	 * De esta clase heredan las instrucciones bytecode con un 
	 * parametro incluidas por tanto las instrucciones condicionales
 * Clase bytecodeOneParameter paquete bytecode y oneParameter
 * 
 *
	 */
	 protected int param;
	 
	 public ByteCodeOneParameter(){};	 
	 public ByteCodeOneParameter(int p){ this.param = p; }
	 @Override

	public ByteCode parse(String[] words) {
		 if (words.length!=2) return null;
		 else return this.parseAux(words[0],words[1]);
	 }
	 abstract protected ByteCode parseAux(String string1, String string2);
	 
	 public String toString(){
		 return this.toStringAux() + " " + this.param;
	 }
	 
	 abstract protected String toStringAux();	 
}


