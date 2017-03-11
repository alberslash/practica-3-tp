package Bytecode;

import CPU.CPU;


public class Halt implements ByteCode {
/**
 * clase halt paquete bytecode. 
 * para la maquina virtual
 */
	public Halt() {
		super();
	}

	@Override
	public void execute(CPU cpu) {
		cpu.halt();
		
	}

	@Override
	public ByteCode parse(String[] words) {
		if(words.length != 1 || !words[0].equalsIgnoreCase("HALT")) return null;
		else return new Halt();
	}
	
	public String toString(){
		return "HALT";
	}

}
