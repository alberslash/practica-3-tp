package CPU;

import Excepciones.StackException;

public class OperandStack {
	/**
	 * Clase operandStack opera con la pila
	 */
	
	public static final int MAX_STACK = 3;
	private int [] stack; /*Creamos un array*/
	private int numElems;

	public OperandStack () { /*constructora */
		this.numElems = 0;
		this.stack = new int[OperandStack.MAX_STACK]; /*Creamos un nuevo objeto con la capacidad maxima*/
	}
	
	
	public boolean isEmpty() { /*Comprueba que está vacio*/
		if (this.numElems >= 1) return false;
		else return true;
	}
	
	
	public void push(int value) throws StackException{
	    if (this.numElems < OperandStack.MAX_STACK){ /*Comprobamos que hay espacio*/
	      this.stack[this.numElems] = value;/*Guardamos en la primero pos libre el valor*/
	      this.numElems++; 
	    }
	    else throw new StackException("ERROR: Pila llena."); /*Si está llena devuelve false */
	  
	  }
	
	public int pop(){
	
		if (!isEmpty()){ /*Comprobamos si esta vacia*/
		this.numElems--; /*Liberamos un espacio */
		return this.stack[this.numElems]; /*Devolvemos la capacidad del array*/
		}
		else return 0; /*revisar*/
	
	}
	

	public int getCima(){ 
		
		int value= this.stack[numElems - 1];
		
		return value;
			
	}
	
	public void setOStack(){
		this.numElems = 0;
	}
	public int getNumElems(){
		return this.numElems;
	}
	
	public boolean checkNumber(){
		if (getCima() == 0) return false;
		else return true;
	}
	public String toString(){
		String mensaje = "";
		if (this.numElems > 0){
			for (int i = 0; i < this.numElems; i++){
			mensaje += stack[i] + "  ";
			}
		}
		else mensaje = "<vacia>" + System.getProperty("line.separator");
		return mensaje;
	}
	
	public void vaciarArray(){
		for(int i = 0; i < this.numElems;i++){
			stack[i] = 0;
		}
		this.numElems = 0;
	}
	
}
