package CPU;


public class Memory {

	private Integer [] memory;
	private int size;
	private boolean empty;
	public static final int MAX_MEM=100;



	public Memory(){
		this.empty=true;
		this.memory = new Integer[Memory.MAX_MEM]; /*Creamos un nuevo array con su capacidad*/
		this.size = Memory.MAX_MEM;
		for( int i=0;  i< this.size ;i++)
			this.memory[i] = null; /*Ponemos a null todo el array*/
	}
	void resize(int pos){
		if(pos >= this.size){ /*Si el array está lleno*/
			Integer[] mem_aux = new Integer[pos*2]; /*Creamos array auxiliar con el doble del tamaño*/
			for(int i =0; i < pos*2; i++) mem_aux[i]= null;
			for(int i=0; i < this.size; i++)
				mem_aux[i]=this.memory[i]; /*Copiamos el array en el auxiliar*/
			this.memory=mem_aux;  /*Copiamos el array aux en el array original*/
			this.size=pos*2; /*Duplicamos su capacidad*/

		}

	}
	/**
	 * En caso de que la memoria se quede sin espacio, el resize lo amplia 
	 * para ello multiplicamos la posicion que le entra por parametro por dos.
	 * Lo primero comprobamos que el array este lleno en caso de estarlo creamos uno auxiliar con el 
	 * doble del tamaño, copiamos el array en el auxiliar y luego el auxiliar en el original
	 * finalmemte duplicamos su capacidad.
	 * @param pos
	 */

	public boolean write(int pos, int value){
		this.empty=false;
		if(pos < 0) return false; 
		/*Si esta vacio la pila no podemos entrar */
		else{

			this.resize(pos); /*le pasamos la posicion */
			this.memory[pos]= value; /*Guardamos en esa posicion el valor de value*/
			return true;
		}
	}
	/**
	 * En la funcion write le entra por parametro una posicion
	 * y el valor que queremos introducir en esa pos.
	 * Para que salga con exito deberemos comprobar que la pila no este vacia y 
	 * que exista esa posicion en el array.
	 */

	public int getPos(){
		int i = 0;
		boolean salir = false;
		while(salir)
		{
			if (memory[i] != null)
			{
				salir = false;
				i++;
			}
			else salir = true;
		}
		return i;
	}


	public int read (int pos){
		this.empty = false;
		this.resize(pos); //Comprobamos a ver si hace falta aumentar el array
		if(this.memory[pos] == null){ //Comprobamos si es null

			this.memory[pos]=0;
			return 0;
		}
		else  {
			//System.err.println("valor de la pos " + pos + " es " + this.memory[pos]);
			return this.memory[pos]; //Devuelve lo contenido en esa pos
		}
	}

	public void setSize(){
		this.size = 0;
	}

	/*	public boolean read (int pos){
	        this.empty = false;
			this.resize(pos); /*Comprobamos a ver si hace falta aumentar el array
			if(this.memory[pos] == null){ /*Comprobamos si es null
				this.memory[pos]=0;
				return false;
			}else{
				  this.memory[pos]=pos; /*cambiado
				return true;/*Devuelve lo contenido en esa pos
			}

		}*/

	int getPos(int pos){
		return memory[pos];
	}


	public String toString(){
		String mensaje = "";
		if (this.empty)  mensaje = "<vacia>" + System.getProperty("line.separator");
		else{
			for (int i = 0; i < this.size; i++){
				if (memory[i] != null){
					if (i != this.size)	mensaje += "[" + i + "]: "+ memory[i] + "  ";
					else  mensaje += "[" + i + "]" + memory[i];
				}

			}
		}
		return mensaje;
	}

	public void vaciarArray(){
		for(int i = 0; i < this.size; i++){
			memory[i] = null;
		}
		//this.size = 0;
	}
}
