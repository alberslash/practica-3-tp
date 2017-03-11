package Bytecode.Arithmetics;

import Bytecode.ByteCode;
import CPU.CPU;
import Excepciones.StackException;

public class Sub extends Arithmetics{
	/**
	 * Clase que realiza las restas de las operaciones arithmeticas
	 */


	public Sub() {
		super();
	}
	
	@Override
	protected void execute(int n1, int n2, CPU cpu) throws StackException {
		cpu.push((n2 - n1));
		
	}

	@Override
	protected ByteCode parseAux(String words) {
		if(words.equalsIgnoreCase("SUB")) return new Sub();
		else return null;
	}
	public String toString() {
		return "SUB";
	}







}
