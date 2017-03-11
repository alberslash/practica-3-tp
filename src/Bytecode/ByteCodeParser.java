package Bytecode;

import Bytecode.Arithmetics.*;
import Bytecode.OneParameter.*;
import Bytecode.OneParameter.Conditional_Jumps.*;

public class ByteCodeParser {
		/**
		 * clase bytecodeparser,paquete bytecode, parsea los bytecode hasta encontrar un end
		 */
	private final static ByteCode[] bc = {new Add(), new Sub(), new Div(), new Mul(), 
			new Goto(), new Load(), new Push(), new Store(),
			new IFEQ(), new IFLE(), new IFLEQ(), new IFNEQ(), new Halt(), new Out()};
	
      public static ByteCode parse(String line){
    		line = line.trim();
    		String []words = line.split(" +");
    		boolean found = false;
    		int i = 0;
    		ByteCode c =null;
    		while(i < bc.length && !found && words[0] != "END"){
    			c = bc[i].parse(words);
    			if (c != null) found = true;
    			else i++;
    		}
    		return c;
      }
     
    }
