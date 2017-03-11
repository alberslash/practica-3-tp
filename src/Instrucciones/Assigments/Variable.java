package Instrucciones.Assigments;

import Bytecode.ByteCode;
import Bytecode.OneParameter.Load;

public class Variable implements Term {
	/**
	 * Clase variable, debde de ser de la a  la z
	 */
	private String varName;
	public Variable(String term) { /* creado para que no de error en return new variable(term)*/
		this.varName = term;
	}

	public Variable() {}

	@Override
	public Term parse(String term) {
		if (term.length()!=1) return null;
		else{
			char name = term.charAt(0);
			if ('a' <= name && name <='z') return new Variable(term);
			else return null;
		}
	}

	@Override
	public ByteCode compile(CPU.Compiler compiler){
		int index = compiler.getIndex(varName);
		return new Load(index); 
	}
}