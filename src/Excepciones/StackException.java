package Excepciones;

public class StackException  extends ExecutionError{
	private static final long serialVersionUID = 1L;

	public StackException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StackException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public StackException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public StackException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public StackException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	/*StackException: error de ejecución al superar
el tamaño permitido para la pila*/

}
