package Bytecode;
import CPU.CPU;
import Excepciones.DivisionByZero;
import Excepciones.StackException;

public interface ByteCode {
/**
 * 
 * interfaz bytecode paquete bytecode
 */
	 public void execute(CPU cpu) throws DivisionByZero, StackException;
	 public ByteCode parse(String[] words);

}
