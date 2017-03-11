package Instrucciones;

import CPU.LexicalParser;
import Excepciones.LexicalAnalysis;
import Excepciones.ParsedProgramException;
import Instrucciones.Assigments.CompoundAssigments;
import Instrucciones.Assigments.SimpleAssigment;
import Instrucciones.Conditionals.DoWhile;
import Instrucciones.Conditionals.For;
import Instrucciones.Conditionals.IfThen;
import Instrucciones.Conditionals.While;

public class ParserInstruction {
/**
 * Parsea las instrucciones de los archivos
 */
	private final static Instruction[] inst = {new DoWhile(), new For(), new Return(), new SimpleAssigment(), new CompoundAssigments(), 
			new While(), new IfThen(), new Write()};

	public static Instruction parse(String instr, LexicalParser lexicalParser) throws LexicalAnalysis, ParsedProgramException {
		instr = instr.trim();
		String []words = instr.split(" +");
		boolean found = false;
		int i = 0;
		Instruction instruc =null;
		while(i < inst.length && !found){
			instruc = inst[i].lexParse(words, lexicalParser);
				if (instruc != null) found = true;
				else i++;
			
		}
		return instruc;
	}

}
