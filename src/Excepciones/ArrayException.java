package Excepciones;

public class ArrayException extends Exception  {

	private static final long serialVersionUID = 1L;
	
	public ArrayException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ArrayException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ArrayException(String message) {//usamos este
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ArrayException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
