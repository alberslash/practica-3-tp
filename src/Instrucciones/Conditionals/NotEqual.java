package Instrucciones.Conditionals;

import Bytecode.OneParameter.Conditional_Jumps.ConditionalJumps;
import Bytecode.OneParameter.Conditional_Jumps.IFNEQ;
import CPU.LexicalParser;
import Instrucciones.Assigments.Term;
/**
 * clase para las operaciones de los saltos ifneq
 * @author User
 *
 */
public class NotEqual extends Condition {

	@Override
	protected Condition parseAux(Term t1, String op, Term t2, LexicalParser parser) {
		if(op.equalsIgnoreCase("!=")){
			parser.increaseProgramCounter();
			return new LessEq(t1, t2);
		}
		else return null;
	}

	@Override
	protected ConditionalJumps compileAux() {
		return new IFNEQ();
	}

}
