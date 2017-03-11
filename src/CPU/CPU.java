package CPU;
import Main.ByteCodeProgram;
/**
 * Paquete CPU, clase CPU.
 */
import Bytecode.ByteCode;
import Excepciones.DivisionByZero;
import Excepciones.StackException;
public class CPU {
	
	private Memory memory = new Memory();
	private OperandStack stack = new OperandStack();
	private boolean end = false;
	private int programCounter = 0;
	private ByteCodeProgram bcProgram = new ByteCodeProgram();
	
	public CPU(ByteCodeProgram program){this.bcProgram = program;}
	/**
	 * ejecuta las instrucciones hasta llegar la la ultima
	 * y muestra el estado de la maquina y de la pila
	 * tras la ejecucion de todas las instrucciones 
	 * 
	 */
	
	public void run() throws StackException{
		ByteCode bc;
		//boolean out= true;
		this.programCounter = 0;
		while(this.programCounter < this.bcProgram.getNumberOfByteCode() ){
			bc = this.bcProgram.getByteCode(this.programCounter);
			try {
		        bc.execute(this); 
		        this.increaseProgramCounter();
		      } catch (DivisionByZero e) {
		        // TODO Auto-generated catch block
		        System.out.println(e.getLocalizedMessage());
		      } 	
		}
		 System.out.println(this.toString());
	}
	
	public void push(int i) throws StackException{ 
	    this.stack.push(i);
	  } 
	
	   
	public int pop() {return this.stack.pop();}
	
	
	public int read(int param){
		return memory.read(param);
	}
	
	
	public boolean write (int param, int value){
		return memory.write(param, value);
	}
	
	public boolean comprobarSalto(int param){
		if(param < this.bcProgram.getNumberOfByteCode()) return true;
		else return false;
	}
	
	public int getProgramCounter(){
		return this.programCounter;
	}
	public void setProgramCounter(int jump){
		this.programCounter = jump - 1;
	}
	
	
	public boolean halt(){ return this.end = true;} //En las diapositivas pone que es void
	
	
	public String toString(){
		String s = System.getProperty("line.separator") + 
				"Estado de la CPU: " + System.getProperty("line.separator") +
				"	Memoria: " + memory.toString() + System.getProperty("line.separator") +
				"	Pila: " + stack.toString() + System.getProperty("line.separator");
		return s;
	}
	
	public int getSizeStack() {return this.stack.getNumElems();}
	
	
	public void increaseProgramCounter() {this.programCounter++;}
	
	
	public boolean out() {
		if(!stack.isEmpty()) {
			System.out.println("Consola: "+ stack.getCima());
			pop();
			return true;
		}
		else return false;
	}
	
	public int getNumProg(){
		return bcProgram.getNumberOfByteCode();
	}
	
	public void inicializa(){
		this.memory.vaciarArray();
		this.stack.vaciarArray();
		//this.memory.setSize();
		this.stack.setOStack();
	}
	public void increaseIntFromMemory(int num, int value) {
		value++;
		this.memory.write(num, value);
		
	}
}
