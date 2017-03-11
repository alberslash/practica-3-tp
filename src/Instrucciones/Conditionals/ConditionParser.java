package Instrucciones.Conditionals;

import CPU.LexicalParser;
import Excepciones.LexicalAnalysis;
/**
 * parseo de las condiciones
 * @author User
 *
 */
public class ConditionParser {
	private final static Condition[] cd = {new Less(), new LessEq(), new NotEqual(), new Equal()};
	
      public static Condition parse(String t1, String op, String t2, LexicalParser LexParser) throws LexicalAnalysis{
 
    		boolean found = false;
    		int i = 0;
    		Condition c =null;
    		while(i < cd.length && !found){
    			c = cd[i].parse(t1, op, t2, LexParser);
    			if (c != null) found = true;
    			else i++;
    		}
    		return c;
      }
}
