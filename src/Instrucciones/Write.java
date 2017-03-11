package Instrucciones;

import Bytecode.Out;
import Bytecode.OneParameter.Load;
import CPU.LexicalParser;
import Excepciones.ArrayException;
import Excepciones.LexicalAnalysis;
import Instrucciones.Assigments.Term;
import Instrucciones.Assigments.TermParser;

public class Write implements Instruction {

	private String varName;
	/**
	 * Clase write parsea y compila lo escritp
	 * @param string
	 */
	public Write(String string) {
		this.varName = string;
	}

	public Write() {}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysis{
		if(words.length != 2) return null;
		else{
			if(words[0].toLowerCase().equalsIgnoreCase("write")){
				Term term = TermParser.parse(words[1]);
				if(term == null) return null;
				else{
					lexParser.increaseProgramCounter();
					return new Write(words[1]);
				}
			}
		}
		return null;
	}

	@Override
	public void compile(CPU.Compiler compiler) throws ArrayException {
		int index = compiler.getIndex(this.varName);
		compiler.addByteCode(new Load(index));
		compiler.addByteCode(new Out());
	}

}
