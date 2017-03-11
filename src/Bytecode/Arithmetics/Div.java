package Bytecode.Arithmetics;

import Bytecode.ByteCode;

/**
 * Clase div, paquete bytecode y arithmetics
 */
import CPU.CPU;
import Excepciones.DivisionByZero;
import Excepciones.StackException;


public class Div extends Arithmetics{
  /**
   * Realiza la division de las operaciones arithmeticas
   */
/* —--------- CONSTRUCTORA —----------*/
  public Div() {
    super();
  }
  
/*------------ METODOS —--------------*/
  
  @Override
  protected void execute(int n1, int n2, CPU cpu) throws DivisionByZero, StackException {
    if(n1 != 0){
      cpu.push((n2/n1));
      
    }
    else throw new DivisionByZero("ERROR: Division por 0.");
  }

  @Override
  protected ByteCode parseAux(String words) {
    if(words.equalsIgnoreCase("DIV")) return new Div();
    else return null;
  }
  
  public String toString(){
    return "DIV";
  }
}