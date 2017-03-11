package Instrucciones.Conditionals;

import Bytecode.ByteCode;
import Bytecode.OneParameter.Conditional_Jumps.ConditionalJumps;
import CPU.LexicalParser;
import Excepciones.ArrayException;
import Excepciones.LexicalAnalysis;
import Instrucciones.Assigments.Term;
import Instrucciones.Assigments.TermParser;
/**
 * clase abstracta para parseas las condiciones de los bucles
 * @author User
 *
 */
public abstract class Condition  {
	private Term t1;
	private Term t2;
	private ConditionalJumps condition;

	public Condition(){}

	public Condition(Term t1, Term t2){
		this.t1=t1;
		this.t2=t2;
	}
	public Condition parse(String t1, String op, String t2, LexicalParser parse) throws LexicalAnalysis{
		Term term1= TermParser.parse(t1);
		if(term1==null) return null;
		else{
			Term term2=TermParser.parse(t2);
			if(term2==null) return null;
			else return this.parseAux(term1, op, term2, parse);
		}
	}
	
	protected abstract Condition parseAux(Term t1, String op, Term t2, LexicalParser parser);
	protected abstract ConditionalJumps compileAux();

	public void compile(CPU.Compiler compiler) throws ArrayException{
		ByteCode b1= t1.compile(compiler);
		ByteCode b2 = t2.compile(compiler);
		this.condition = this.compileAux();
		compiler.addByteCode(b1);
		compiler.addByteCode(b2);;
		compiler.addByteCode(this.condition);
	}

	public void setJump(int jump){
		this.condition.setJum(jump);
	}

}
