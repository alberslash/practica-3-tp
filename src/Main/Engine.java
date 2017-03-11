package Main;
import java.util.Scanner;
import Commands.Command;
import Commands.CommandParser;
import Excepciones.ArrayException;
import Excepciones.BadFormaByteCode;
import Excepciones.ComienzaLoad;
import Excepciones.ExecutionError;
import Excepciones.LexicalAnalysis;
import Excepciones.ParsedProgramException;
import Excepciones.SouceProgramException;
import Excepciones.StackException;
import Bytecode.ByteCodeParser;
import Bytecode.ByteCode;
import CPU.*;
import CPU.Compiler;

import java.io.File;
import java.io.FileNotFoundException;

public class Engine {
/**
 * Comienzo de la aplicacion, lleva a todo su funcionamiento
 */
	private ByteCodeProgram program;
	private boolean end;
	private static Scanner in = new Scanner(System.in);

	private CPU cpu;
	private SourceProgram sProgram;
	private ParsedProgram pProgram;
	private LexicalParser lexParser;
	private Compiler comp;

	public Engine(){
		this.sProgram = new SourceProgram();
		this.program = new ByteCodeProgram();
		this.pProgram = new ParsedProgram();
		this.cpu = new CPU(this.program);
		this.end =false;  
	}

	public void start(){ 
		this.end=false;
		while(!end){
			String line = " ";
			Command comando = null;
			System.out.print("> ");
			line = in.nextLine();
					try {
						comando = CommandParser.parse(line);
					} catch (LexicalAnalysis e1) {
						// TODO Auto-generated catch block
						System.out.println(e1.getMessage());
					}
			if(!(comando == null)){
				System.out.println("Comienza la ejecución de " + comando );
				try {
					comando.execute(this);
				} catch (ArrayException e) {
					// TODO Auto-generated catch block
					this.program.reset();
					System.out.println(e.getMessage());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("Archivo no encontrado.");
				} catch (StackException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				} catch (ExecutionError e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				} catch (LexicalAnalysis e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				} catch (ComienzaLoad e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				} catch (BadFormaByteCode e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				if (program.getNumberOfByteCode() != 0){
					if(!line.toUpperCase().equalsIgnoreCase("LOAD"))
						System.out.println("Programa almacenado: " + System.getProperty("line.separator") + sProgram.toString());
						System.out.print(comp.toString());
						
				}
			}
		}
		System.out.println("Fin de la ejecucion....");
		in.close();
	}

	public void executeCommandRun() throws ExecutionError{
		if(program.getNumberOfByteCode() > 0){
		 cpu.run();
		} else throw new ExecutionError("ERROR: No has realizado compile.");
	}


	public boolean endExecution(){ 
		return this.end=true;
	}


	public void addByteCodeInstruction(ByteCode bc) throws ArrayException{
		System.out.println("Programa almacenado: ");
			program.addBCInstruction(bc);
			System.out.println(program.toString());
	}

	public boolean resetProgram(){ 
		cpu.inicializa();
		program.reset();
		return true;
	}

	public static boolean showHelp(){ 
		CommandParser parse = null;
		parse.ShowHelp();
		return true;

	}

	public void replaceByteCode(int replace)throws BadFormaByteCode{
	    System.out.print("Nueva instruccion: ");
	    String s1 = in.nextLine();
	    ByteCode instr = null;
		instr = ByteCodeParser.parse(s1);
		if(instr==null){
			throw new BadFormaByteCode("ERROR:Formato bytecode erroneo.");
		}else{
			try{
				program.addBCInstruction(instr);
				//System.out.println(cpu.p);
			}catch(ArrayException e){
				System.out.println("ERROR:No queda mas espacio.");
			}
		} 
		
  }

	public void executeLoad(String fichName) throws FileNotFoundException, ArrayException, SouceProgramException{

		this.pProgram.reset();
		this.program.reset();
		this.sProgram.reset();
		this.resetProgram();
		Scanner sc=new Scanner(new File(fichName));
		String ins = sc.nextLine();
		while(sc.hasNext()){
			this.sProgram.addsProgram(ins);
			ins = sc.nextLine();
		}
		if (ins != null) this.sProgram.addsProgram(ins);
		sc.close();
		System.out.println(sProgram.toString());
	}

	
	public void compile() throws LexicalAnalysis, ArrayException, ComienzaLoad {
		try {
			this.lexicalAnalysis();
			System.out.println(sProgram.toString());
			this.generateByteCode();
		}
		catch (LexicalAnalysis e) {
			this.pProgram.reset();
			throw e;
		}
		catch (ArrayException e) {
			this.pProgram.reset();
			this.program.reset();
			throw e;
		}
	}
	
	

	private void generateByteCode() throws ArrayException {
		this.comp = new Compiler(program);
		this.comp.compile(pProgram);
	}

	private void lexicalAnalysis() throws LexicalAnalysis,ComienzaLoad{
		lexParser = new LexicalParser(this.sProgram);
		//por razones de eficiencia se controla que tenga end fuera del lexicalParser
		if(sProgram.getsProgram(sProgram.getNumberOfsPrograms() - 1).equalsIgnoreCase("end")){
		try {
			this.lexParser.lexicalParser(pProgram, "end");
		} catch (ParsedProgramException e) {
			end=true;
			System.out.println(e.getMessage());
		}
		}else throw new LexicalAnalysis("ERROR:No hay END al final del programa.");
		if(pProgram.getNumberOfsPrograms()==0) throw new ComienzaLoad("ERROR: No existe programa");
	}

}



