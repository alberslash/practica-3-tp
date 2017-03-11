package Instrucciones;

import Bytecode.Halt;
import CPU.LexicalParser;
import Excepciones.ArrayException;

public class Return implements Instruction {
/**
 * Clase return
 */
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) {
		if(words.length != 1) return null;
		else{
			if(words[0].toLowerCase().equalsIgnoreCase("return")){
				lexParser.increaseProgramCounter();
				return new Return();
			}
		}
		return null;
	}

	@Override
	public void compile(CPU.Compiler compiler) throws ArrayException {
		Bytecode.ByteCode halt = new Halt();
		compiler.addByteCode(halt);
		
	}

}
