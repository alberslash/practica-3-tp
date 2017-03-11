package Instrucciones.Conditionals;

import Bytecode.OneParameter.Conditional_Jumps.ConditionalJumps;
import Bytecode.OneParameter.Conditional_Jumps.IFEQ;
import CPU.LexicalParser;
import Instrucciones.Assigments.Term;

public class Equal extends Condition{
/**
 * operacion para los saltos ifeq
 */
	@Override
	protected Condition parseAux(Term t1, String op, Term t2, LexicalParser parser) {
		if(op.equalsIgnoreCase("=")) {
			parser.increaseProgramCounter();
			return new Less(t1, t2);
		}
		else return null;
	}

	@Override
	protected ConditionalJumps compileAux() {
		return new IFEQ();
	}

}
