package Instrucciones.Conditionals;

import CPU.LexicalParser;
import CPU.ParsedProgram;
import Excepciones.ArrayException;
import Excepciones.LexicalAnalysis;
import Excepciones.ParsedProgramException;
import Instrucciones.Instruction;

public class IfThen implements Instruction {
	/**
	 * clase para la operacion if
	 */
	private Condition condition;
	private ParsedProgram ifBody;

	public IfThen(Condition condition2, ParsedProgram ib) {
		this.condition = condition2;
		this.ifBody = ib;
	}

	public IfThen() {}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysis, ParsedProgramException {
		if(words.length == 4 && words[0].toUpperCase().equalsIgnoreCase("IF")){
			condition = ConditionParser.parse(words[1], words[2], words[3], lexParser);
		}
		else return null;
		ParsedProgram ib = new ParsedProgram();
		lexParser.lexicalParser(ib,"endif".toUpperCase());
		lexParser.increaseProgramCounter();
		return new IfThen(condition, ib);
	}

	@Override
	public void compile(CPU.Compiler compile) throws ArrayException{
		this.condition.compile(compile);
		compile.compile(this.ifBody);
		int jump = compile.getCurrentNumberOfByteCodes();
		this.condition.setJump(jump);	
	}
}
