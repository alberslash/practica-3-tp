package CPU;

import Bytecode.ByteCode;
import Excepciones.ArrayException;
import Instrucciones.Instruction;
import Main.ByteCodeProgram;
/**
 *  clase encargada de generar el programa bytecode
 * @author User
 *
 */
public class Compiler {
	private ByteCodeProgram bcProgram;
	private String[] varTable;
	private int numVars;
	private final int MAX_INSTR = 100;

	public Compiler(ByteCodeProgram bcProgram2) {
		this.bcProgram = bcProgram2;
		this.varTable = new String[MAX_INSTR];
	}

	public void compile(ParsedProgram pProgram) throws ArrayException {
		int i = 0;
		try {
			while (i < pProgram.getNumberOfsPrograms()) {
				Instruction instr = pProgram.getpProgram(i);
				instr.compile(this);
				i++;
			}
		}
		catch (ArrayException e){
			throw new ArrayException("Excepcion en la generacion del bytecode: Se excede la capacidad máxima del array");
		}
	}

	public void changeBC(ByteCode bc, int pos){
		bcProgram.replace(pos, bc);
	}

	public void addByteCode(ByteCode b) throws ArrayException{
		bcProgram.addBCInstruction(b);

	};

	public int getIndex(String varName) {
		int i = 0;
		boolean encontrado = false;
		while( i < this.numVars && !encontrado){
			if (varTable[i].equalsIgnoreCase(varName))encontrado = true;
			else i++;
		}
		if (!encontrado){
			this.varTable[this.numVars] = varName;
			this.numVars++;
			return this.numVars - 1;
		}
		else return i;
	}


	public int getProgramCounter() {
		return 0;
	}
	public int getCurrentNumberOfByteCodes() {
		return bcProgram.getNumberOfByteCode();
	}

	public ByteCode getProgram(int i){
		return bcProgram.getByteCode(i);
	}

	public String toString(){
		return "Programa Bytecode almacenado: " + System.getProperty("line.separator") + bcProgram.toString();	
	}

}