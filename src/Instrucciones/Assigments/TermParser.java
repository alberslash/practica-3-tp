package Instrucciones.Assigments;

import Excepciones.LexicalAnalysis;

public class TermParser {
	private final static Term[] tr = {new Variable(), new Number()};
/**
 * Parseo de los terminos
 * @param string
 * @return
 * @throws LexicalAnalysis
 */
	public static Term parse(String string)throws LexicalAnalysis{
		boolean found = false;
		int i = 0;
		Term t = null;
		while(i < tr.length && !found){
			t = tr[i].parse(string);
			if (t != null) found = true;
			else i++;
		}
		return t;
	}

}
