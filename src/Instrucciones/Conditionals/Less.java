package Instrucciones.Conditionals;

import Bytecode.OneParameter.Conditional_Jumps.ConditionalJumps;
import Bytecode.OneParameter.Conditional_Jumps.IFLE;
import CPU.LexicalParser;
import Instrucciones.Assigments.Term;
/**
 * clase para el salto ifle
 * 
 * @author User
 *
 */

public class Less extends Condition{

	public Less(Term t1, Term t2) {
		super(t1,t2);
	}

	public Less() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Condition parseAux(Term t1, String op, Term t2, LexicalParser parser) {
		if(op.equalsIgnoreCase("<")) {
			parser.increaseProgramCounter();
			return new Less(t1, t2);
		}
		else return null;
	}

	@Override
	protected ConditionalJumps compileAux() {
		return new IFLE();
	}

}
