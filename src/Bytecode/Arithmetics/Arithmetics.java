package Bytecode.Arithmetics;

import Bytecode.ByteCode;

/**
 * Clase arithmetics paquete bytecode
 */
import CPU.CPU;
import Excepciones.DivisionByZero;
import Excepciones.StackException;

public abstract class Arithmetics implements ByteCode{
	/**
	 * Clase abstracta para las operaciones arithmeticas
	 * parsea cada una de ellas
	 */


	public Arithmetics() {
		super();
	}
	
	abstract protected void execute(int n1,int n2, CPU cpu)throws DivisionByZero, StackException;

	public void execute( CPU cpu) throws DivisionByZero, StackException{
		
		if(cpu.getSizeStack() >= 2){
			int n1 = cpu.pop();
			int n2 = cpu.pop();
			 this.execute(n1, n2, cpu);
		}
		
	}
	
	
/*	@Override
	public void execute(CPU cpu) throws StackException, DivisionByZero {
		if (cpu.getSizeStack() >= 2){
			int n1 = cpu.pop();
			int n2 = cpu.pop();
			try {
			   this.execute(n1, n2, cpu);
			   cpu.increaseProgramCounter();
			}
			catch (DivisionByZero e){
				throw new DivisionByZero("Excepcion-bytecode DIV: Division entre 0");
			}
		}
		else throw new StackException("Excepcion-bytecode " + this.toString() + ": Tamaño de pila insuficiente");
		
	}*/
	
	public ByteCode parse(String[] words){
		if(words.length != 1) return null;
		else return this.parseAux(words[0]);
	}
	
	abstract protected ByteCode parseAux(String words);

}
