package Main;
import Bytecode.ByteCode;
import Excepciones.ArrayException;

public class ByteCodeProgram {
	
	private static final int MAX_INSTR = 80;
	private ByteCode[] bcprogram;
	private int numBc = 0;
	
	public ByteCodeProgram(){
		this.bcprogram = new ByteCode[MAX_INSTR];
	}
	/**
	 * añade las instrucciones al progrma siempre que no haya llegado al maimo, e ese caso laza una excepcion
	 * @param instr
	 * @throws ArrayException
	 */
	public void addBCInstruction (ByteCode instr)throws ArrayException{ 
		if (this.numBc < MAX_INSTR){
			bcprogram[numBc] = instr;
			numBc++;
			//return true;
		}else throw new ArrayException("ERROR: Numero maximo de instrucciones.");		
	}
	
	public int getNumberOfByteCode(){
		return this.numBc;
		
	}
	
	public ByteCode getByteCode (int i){
		return this.bcprogram[i];
	}
	
	public String toString(){ 
		String mensaje = "";
		for(int i = 0; i < this.numBc; i++){
			mensaje += i + ": " + bcprogram[i].toString() + System.getProperty("line.separator");
		}
		return mensaje;
	}
	
	public void reset(){
		this.numBc = 0;
	}
	
	public void replace (int replace, ByteCode bc) //Cambio de instrucciones
	{
		if (this.numBc < MAX_INSTR){
			bcprogram[replace] = bc;
		}

	}
}
