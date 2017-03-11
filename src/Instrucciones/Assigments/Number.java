package Instrucciones.Assigments;

import Bytecode.ByteCode;
import Bytecode.OneParameter.Push;
import Excepciones.LexicalAnalysis;


public class Number implements Term {
private int num;
/**
 * Clase number, asigna numeros a terminos
 * @param num
 */
	public Number(int num){
		this.num =num;
	}
	public Number() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Term parse(String term) throws LexicalAnalysis{
		try{
		num = Integer.parseInt(term);
		}catch(NumberFormatException e){
			throw new LexicalAnalysis("ERROR: Analisis sintactico incorrecto.");
			
		}
		return new Number(num);
	}

	@Override
	public ByteCode compile(CPU.Compiler compiler) {
		return new Push(this.num);
	}
}
