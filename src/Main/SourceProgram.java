package Main;

import Excepciones.SouceProgramException;

public class SourceProgram {
	/**
	 * Almacenamiento del ficherp
	 */
	private String[] sProgram;
	private static final int MAX_INSTR = 30;
	private int numssP = 0;

	public SourceProgram(){
		this.sProgram = new String[MAX_INSTR];
	}

	public boolean addsProgram (String instr) throws SouceProgramException{ 
		if (this.numssP < MAX_INSTR){
			sProgram[numssP] = instr;
			numssP++;
			return true;
		}else throw new SouceProgramException("ERROR: Programa lleno.");
		
			
	}
	
	public int getNumberOfsPrograms(){
		return this.numssP;
		
	}
	
	public String getsProgram (int i){
		return this.sProgram[i];
	}
	
	public String toString(){ 
		String mensaje = "";
		for(int i = 0; i < this.numssP; i++){
			mensaje += i + ": " + sProgram[i].toString() + System.getProperty("line.separator");
		}
		return mensaje;
	}
	
	
	public void reset(){
		this.numssP = 0;
	}
	

	public void replace (int replace, String sp) //Cambio de instrucciones
	{
		if (this.numssP < MAX_INSTR){
			sProgram[replace] = sp;
		}

	}

}
