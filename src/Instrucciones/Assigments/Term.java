package Instrucciones.Assigments;

import Bytecode.ByteCode;
import CPU.Compiler;
import Excepciones.LexicalAnalysis;

public interface Term {
/**
 * Interfaz para los terminos
 * @param term
 * @return
 * @throws LexicalAnalysis
 */
	abstract public Term parse(String term) throws LexicalAnalysis;
	abstract public ByteCode compile(Compiler compiler); 
	
}
