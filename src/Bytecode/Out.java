package Bytecode;

import CPU.CPU;

public class Out implements ByteCode {
	
	/**
	 * Clase out, paquete bytecode
	 * Escribe el entero almacenado en la cima de la pila
	 */

	public Out() {
		super();
	}

	@Override
	public void execute(CPU cpu) {
		 cpu.out();
	}

	@Override
	public ByteCode parse(String[] words) {
		if(words.length != 1 || !words[0].equalsIgnoreCase("OUT")) return null;
		else return new Out();
	}
		
	public String toString(){
		return "OUT";
	}
}
