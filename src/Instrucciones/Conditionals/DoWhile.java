package Instrucciones.Conditionals;

import Bytecode.OneParameter.Goto;
import CPU.LexicalParser;
import CPU.ParsedProgram;
import Excepciones.ArrayException;
import Excepciones.LexicalAnalysis;
import Excepciones.ParsedProgramException;
import Instrucciones.Instruction;

public class DoWhile implements Instruction {

	private ParsedProgram cuerpo;
	public DoWhile(){}

	public DoWhile(ParsedProgram pProgram) {
		// TODO Auto-generated constructor stub
		this.cuerpo = pProgram;
	}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser)throws LexicalAnalysis, ParsedProgramException {
		if(words[0].equalsIgnoreCase("DO")){
			ParsedProgram pProgram= new ParsedProgram();
			lexParser.increaseProgramCounter();
			lexParser.lexicalParser(pProgram, "enddo");
			lexParser.increaseProgramCounter();
			return new DoWhile(pProgram);
		}
		return null;
	}

	@Override
	public void compile(CPU.Compiler compiler) throws ArrayException {
		// TODO Auto-generated method stub
		int back = compiler.getCurrentNumberOfByteCodes();
		compiler.compile(this.cuerpo);
		compiler.changeBC(new Goto(back), compiler.getCurrentNumberOfByteCodes()-1);
	}

}
