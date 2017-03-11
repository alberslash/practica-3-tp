package Instrucciones.Conditionals;

import Bytecode.OneParameter.Conditional_Jumps.ConditionalJumps;
import Bytecode.OneParameter.Conditional_Jumps.IFLEQ;
import CPU.LexicalParser;
import Instrucciones.Assigments.Term;
/**
 * clase para el salto ifleq
 * @author User
 *
 */
public  class LessEq extends Condition{

	public LessEq(Term t1, Term t2) {
		super(t1, t2);
	}

	public LessEq() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Condition parseAux(Term t1, String op, Term t2, LexicalParser parser) {
		if(op.equalsIgnoreCase("<=")){
			parser.increaseProgramCounter();
			return new LessEq(t1, t2);
		}
		else return null;
	}

	protected ConditionalJumps compileAux(){
		return new IFLEQ();
	}






}
