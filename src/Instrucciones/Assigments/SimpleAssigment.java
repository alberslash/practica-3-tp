package Instrucciones.Assigments;


import Bytecode.OneParameter.Store;
import CPU.LexicalParser;
import Excepciones.ArrayException;
import Excepciones.LexicalAnalysis;
import Instrucciones.Instruction;

/**
 * clase para las instruccione simples, una asignacion
 * @author User
 *
 */
public class SimpleAssigment implements Instruction{

	private String varName;
	private Term term1;

	public SimpleAssigment(String string, Term term) {
		this.varName = string;
		this.term1 = term;
	}

	public SimpleAssigment(){}

	@Override
	public Instruction lexParse(String[] words, LexicalParser lexical) throws LexicalAnalysis{
		if (words.length != 3) return null;
		else {
			if (!words[1].equalsIgnoreCase("=")) throw new LexicalAnalysis("ERROR: La Instruccion "+ lexical.getProgramCounter() + " es incorrecta");
			else{
				char name = words[0].charAt(0);
				if ('a' <= name && name <='z'){
					Term term = TermParser.parse(words[2]);
					if (term == null) throw new LexicalAnalysis("ERROR: La Instruccion "+ lexical.getProgramCounter() + " es incorrecta");
					else {
						lexical.increaseProgramCounter();
						return new SimpleAssigment(words[0], term);

					}
				}
				else throw new LexicalAnalysis("ERROR: La Instruccion "+ lexical.getProgramCounter() + " es incorrecta");
			}
		}
	}

	@Override
	public void compile(CPU.Compiler compiler) throws ArrayException {
		Bytecode.ByteCode b1 = this.term1.compile(compiler);
		int index = compiler.getIndex(this.varName);
		Store b2 = new Store(index);
		compiler.addByteCode(b1);
		compiler.addByteCode(b2);
	}

}
