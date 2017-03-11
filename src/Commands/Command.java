package Commands;

import java.io.FileNotFoundException;

import Excepciones.ArrayException;
import Excepciones.BadFormaByteCode;
import Excepciones.ComienzaLoad;
import Excepciones.ExecutionError;
import Excepciones.LexicalAnalysis;
import Excepciones.StackException;
import Main.Engine;
/**
 * interfaz
 * Llama a los metodos abstractos de la clase commandparser
 * @throws ExecutionError 
 * 
 */
public interface Command {
	public void execute(Engine engine) throws ArrayException, FileNotFoundException, StackException, ExecutionError, LexicalAnalysis,ComienzaLoad, BadFormaByteCode;
	public Command parse(String [] s);	
	public String textHelp();
}
