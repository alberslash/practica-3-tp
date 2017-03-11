package CPU;

import Excepciones.ParsedProgramException;
import Instrucciones.Instruction;
/**
 * Parsea el programa comprueba el numero de instrucciones
 * @author User
 *
 */
public class ParsedProgram {
	private Instruction [] pProgram;
	private int numP = 0;
	
	private static final int MAX_INSTR = 25;

	public ParsedProgram(){
		this.pProgram = new Instruction[MAX_INSTR];
	}

	public boolean addsProgram (Instruction instr)throws ParsedProgramException{ 
		if (this.numP < MAX_INSTR){
			pProgram[numP] = instr;
			numP++;
			return true;
		}
		else throw new ParsedProgramException("ERROR: Programa parseado lleno, no caben mas instrucciones.");
	}
	
	public int getNumberOfsPrograms(){
		return this.numP;
		
	}
	
	public Instruction getpProgram (int i){
		return this.pProgram[i];
	}
	
	public String toString(){ 
		String mensaje = "";
		for(int i = 0; i < this.numP; i++){
			mensaje += i + ": " + pProgram[i].toString() + System.getProperty("line.separator");
		}
		return mensaje;
	}
	
	public void reset(){
		this.numP = 0;
	}
	
	public void replace (int replace, Instruction inst) //Cambio de instrucciones
	{
		if (this.numP < MAX_INSTR){
			pProgram[replace] = inst;
		}

	}

}
