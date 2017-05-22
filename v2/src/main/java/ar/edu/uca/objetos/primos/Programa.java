package ar.edu.uca.objetos.primos;

public class Programa{
	
	public static void main( String[] args ){
		int numero = Integer.parseInt(args[0]);
		String formato = args[1].substring(9);
		
		FactorPrimoPrimo factorPrimo = new FactorPrimoPrimo();
		factorPrimo.obtenerFactor(numero, formato);
	}
}
