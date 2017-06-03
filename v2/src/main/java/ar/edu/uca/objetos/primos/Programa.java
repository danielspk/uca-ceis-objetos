package ar.edu.uca.objetos.primos;

public class Programa{
	
	public static void main( String[] args ){
		int numero = Integer.parseInt(args[0]);
		String formato = "pretty";
		
		if (args.length > 1) {
			formato = args[1].substring(9).toLowerCase();
		}
		
		FactorPrimo factorPrimo = new FactorPrimo();
		factorPrimo.obtenerFactor(numero, formato);
	}
}
