package Instrucciones.Assigments;

import Bytecode.Arithmetics.Add;
import Bytecode.Arithmetics.Div;
import Bytecode.Arithmetics.Mul;
import Bytecode.Arithmetics.Sub;
import Bytecode.OneParameter.Store;
import CPU.LexicalParser;
import Excepciones.ArrayException;
import Excepciones.LexicalAnalysis;
import Instrucciones.Instruction;

/**
 * Clase para las instrucciones compuestas, es decir con una operacion
 * @author User
 *
 */
public class CompoundAssigments implements Instruction {

	private String varName;
	private String operator;
	private Term term1;
	private Term term2;

	public CompoundAssigments(String string1, Term t1, String string2, Term t2) {
		this.varName = string1;
		this.operator = string2;
		this.term1 = t1;
		this.term2 = t2;
	}

	public CompoundAssigments() {}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysis{
		if(words.length != 5) return null;
		else{
			if(!words[1].equalsIgnoreCase("=")) throw new LexicalAnalysis("ERROR: La Instruccion "+ lexParser.getProgramCounter() + " es incorrecta");
			{
				if(!this.operator(words[3])) throw new LexicalAnalysis("ERROR: La Instruccion "+ lexParser.getProgramCounter() + " es incorrecta");
				else{
					char name = words[0].charAt(0);
					if ('a' <= name && name <='z'){
						Term t1 = TermParser.parse(words[2]);
						if(t1 == null) return null;
						else{
							Term t2 = TermParser.parse(words[4]);
							if(t2 == null) return null;
							else{
								lexParser.increaseProgramCounter();
								return new CompoundAssigments(words[0], t1, words[3], t2);
							}
						}
					}
					else throw new LexicalAnalysis("ERROR: La Instruccion "+ lexParser.getProgramCounter() + " es incorrecta");
				}
			}
		}
	}


	private boolean operator(String operacion) {
		if(operacion.equalsIgnoreCase("+") || operacion.equalsIgnoreCase("*") 
				|| operacion.equalsIgnoreCase("/") || operacion.equalsIgnoreCase("-")) return true;
		else return false;
	}


	@Override
	public void compile(CPU.Compiler compiler) throws ArrayException {
		Bytecode.ByteCode b1 = this.term1.compile(compiler);
		Bytecode.ByteCode b2 = this.term2.compile(compiler);
		compiler.addByteCode(b1);
		compiler.addByteCode(b2);
		if(this.operator.equalsIgnoreCase("+")){
			Add b4 = new Add ();
			compiler.addByteCode(b4);
		}
		else if (this.operator.equalsIgnoreCase("-")){
			Sub b4 = new Sub();
			compiler.addByteCode(b4);
		}
		else if (this.operator.equalsIgnoreCase("/")){
			Div b4 = new Div();
			compiler.addByteCode(b4);
		}
		else{
			Mul b4 = new Mul();
			compiler.addByteCode(b4);
		}
		int index = compiler.getIndex(varName);
		Store b3 = new Store(index);
		compiler.addByteCode(b3);
	}

}
