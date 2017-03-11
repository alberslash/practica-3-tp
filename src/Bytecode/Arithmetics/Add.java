package Bytecode.Arithmetics;

import Bytecode.ByteCode;
import CPU.CPU;
import Excepciones.StackException;
/**
 * Clase Add paquete bytecode y arithmetics
 * @author User
 *
 */

public class Add extends Arithmetics {
	/**
	 * Realiza la suma de las operaciones arithmetics
	 */
	
	public Add() {
		super();
	}

	protected ByteCode parseAux(String line){
		if(line.equalsIgnoreCase("ADD")) return new Add();
		else return null;
	}

	@Override
	protected void execute(int n1, int n2, CPU cpu) throws StackException{
		 cpu.push((n1 + n2));
		 
	}
	public String toString(){
		return "ADD";
	}
}
	
