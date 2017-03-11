package CPU;

import Excepciones.LexicalAnalysis;
import Excepciones.ParsedProgramException;
import Instrucciones.Instruction;
import Instrucciones.ParserInstruction;
import Main.SourceProgram;

public class LexicalParser {
	/**
	 * Analiza en formato lexico, parsea las instrucciones en caso de no ser correctas salta la excepcion
	 */
	private SourceProgram sProgram;
	private int programCounter;
	boolean stop = false;

	public LexicalParser(SourceProgram sProgram2) {
		this.sProgram = sProgram2;
		this.programCounter = 0;
	}
	public void lexicalParser(ParsedProgram pProgram, String stopKey)throws LexicalAnalysis, ParsedProgramException{
		while (this.programCounter < sProgram.getNumberOfsPrograms() && !stop){
			String instr = sProgram.getsProgram(this.programCounter);
			instr = instr.trim();
			if (instr.equalsIgnoreCase(stopKey)){
				stop = true;
			}
			else {
				Instruction inst = ParserInstruction.parse(instr,this); // parseamos cada instruccion del archivo hasta que finalice
				if (inst == null) throw new LexicalAnalysis("ERROR: La Instruccion "+ this.programCounter + " es incorrecta");
				else{
					pProgram.addsProgram(inst);
					if (this.programCounter < sProgram.getNumberOfsPrograms()) stop = false;
				}
			}
		}
	}	

	
	
//	public void lexicalParser(ParseredProgram pProgram, String stopKey) throws LexicalAnalysisException{
//		boolean error = false;
//		boolean stop = false;
//		try {
//			while (this.programCounter < program.getNumeroInstrucciones() && !error && !stop) {
//				String instr = program.getInstruction(this.programCounter);
//				instr = instr.trim();
//				if (instr.equalsIgnoreCase(stopKey)){
//					stop = true;
//				}
//				else {
//					Instruction instruction = ParserInstruction.parse(instr, this);
//					if (instruction == null)
//						error = true;
//					else {
//						if (!pProgram.addInstruction(instruction)) {
//							error = true;
//						}
//					}
//				}
//			}
//			if (error) throw new LexicalAnalysisException("Excepcion-Analisis lexico: La instruccion " + this.programCounter + " es incorrecta");
//			else if (!stop) throw new LexicalAnalysisException("Excepcion-Analisis lexico: Falta la isntruccion END del final");
//	

	public int getProgramCounter(){
		return this.programCounter;
	}


	public void increaseProgramCounter(){
		this.programCounter++;
	}


}