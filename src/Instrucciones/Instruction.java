package Instrucciones;

import CPU.LexicalParser;
import Excepciones.ArrayException;
import Excepciones.LexicalAnalysis;
import Excepciones.ParsedProgramException;

/**
 * Interfaz de instrucciones
 * @author User
 *
 */
public interface Instruction {
	Instruction lexParse(String[] words, LexicalParser lexParser) throws LexicalAnalysis, ParsedProgramException;
	void compile(CPU.Compiler compiler) throws ArrayException;
}
