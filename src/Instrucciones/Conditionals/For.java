package Instrucciones.Conditionals;

import Bytecode.Arithmetics.Add;
import Bytecode.OneParameter.Goto;
import Bytecode.OneParameter.Load;
import Bytecode.OneParameter.Push;
import Bytecode.OneParameter.Store;
import CPU.Compiler;
import CPU.LexicalParser;
import CPU.ParsedProgram;
import Excepciones.ArrayException;
import Excepciones.LexicalAnalysis;
import Excepciones.ParsedProgramException;
import Instrucciones.Instruction;
import Instrucciones.Assigments.SimpleAssigment;
import Instrucciones.Assigments.Term;
import Instrucciones.Assigments.TermParser;

public class For implements Instruction {

	private ParsedProgram forBody;
	private Condition condition;
	private ParsedProgram simple = new ParsedProgram();
	private String variable;
	
	public For(Condition metodo, ParsedProgram bf, ParsedProgram simp, String var ) {
		this.forBody = bf;
		this.condition = metodo;
		this.simple = simp;
		this.variable = var;
	}
	
	public For() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser)
			throws LexicalAnalysis, ParsedProgramException {
		Condition metodo;
		if(words.length == 10 && words[0].toUpperCase().equalsIgnoreCase("FOR")){
			ParsedProgram fb = new ParsedProgram();
			lexParser.increaseProgramCounter();
			lexParser.lexicalParser(fb, "endFor");
			metodo = ConditionParser.parse(words[5], words[6], words[7], lexParser);
			Term t1 =TermParser.parse(words[3]);
			simple.addsProgram(new SimpleAssigment(words[1],t1));
			
			return new For (metodo, fb, simple, words[1]);
		}
		else return null;
	}
	
	@Override
	public void compile(Compiler compilerBC) throws ArrayException {
		int comeBanck = compilerBC.getCurrentNumberOfByteCodes();
		compilerBC.compile(this.simple);
		
		this.condition.compile(compilerBC);
		compilerBC.compile(this.forBody);
		int cont = compilerBC.getIndex(this.variable);
		compilerBC.addByteCode(new Load(cont));
		compilerBC.addByteCode(new Push (1));
		compilerBC.addByteCode(new Add());
		compilerBC.addByteCode(new Store(cont));
		int jump= compilerBC.getCurrentNumberOfByteCodes();
		this.condition.setJump(jump + 1);
		compilerBC.addByteCode(new Goto(comeBanck + 2));
		
	}

}
