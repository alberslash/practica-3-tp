package Instrucciones.Conditionals;

import Bytecode.OneParameter.Goto;
import CPU.LexicalParser;
import CPU.ParsedProgram;
import Excepciones.ArrayException;
import Excepciones.LexicalAnalysis;
import Excepciones.ParsedProgramException;
import Instrucciones.Instruction;

public class While implements Instruction {
	/**
	 * clase para la implementacion del bucle while
	 */
	private ParsedProgram whileBody;
	private Condition condition;

	public While(Condition condition2, ParsedProgram wb) {
		this.condition = condition2;
		this.whileBody = wb;
	}

	public While() {}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysis, ParsedProgramException {
		if(words.length != 4) return null;
		else{
			Condition metodo;

			if(words.length == 4 && words[0].toUpperCase().equalsIgnoreCase("WHILE")){
				metodo = ConditionParser.parse(words[1], words[2], words[3], lexParser);
			}
			else return null;
			ParsedProgram wb = new ParsedProgram();
			lexParser.lexicalParser(wb,"endwhile");
			lexParser.increaseProgramCounter();
			return new While(metodo, wb);
		}
	}


	@Override
	public void compile(CPU.Compiler compilerBC) throws ArrayException {
		int comeBanck = compilerBC.getCurrentNumberOfByteCodes();
		this.condition.compile(compilerBC);
		compilerBC.compile(this.whileBody);
		int jump= compilerBC.getCurrentNumberOfByteCodes();
		this.condition.setJump(jump +1);
		compilerBC.addByteCode(new Goto(comeBanck));

	}

}
