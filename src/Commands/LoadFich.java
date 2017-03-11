package Commands;

import java.io.FileNotFoundException;

import Excepciones.ArrayException;
import Excepciones.SouceProgramException;
import Main.Engine;

public class LoadFich implements Command{
	/**
	 * Clase loadFich carga del fichero
	 */
	private String fichero;
	public LoadFich() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoadFich (String FichName){
		this.fichero = FichName;
	}
	@Override
	public void execute(Engine engine) throws  ArrayException, FileNotFoundException  {
			try {
				engine.executeLoad(this.fichero);
			} catch (SouceProgramException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}		
	}
	@Override
	public Command parse(String[] s) {
		if(s.length!= 2 || !s[0].equalsIgnoreCase("LOAD")) return null;
		else return new LoadFich(s[1]);
	}

	@Override
	public String textHelp() {
		return "  LOAD :  ";
	}
	
	public String toString(){
		return "LOAD";
	}
}
