package ar.edu.uca.objetos.primos;

import java.util.ArrayList;

public class Programa{
	
	public static void main( String[] args ){
		int numero = Integer.parseInt(args[0]);
		String formato = "pretty";
		String orden = "asc";
		String archivo = null;
		
		for (int i = 1; i < args.length; i++) {
			String[] parametro = args[i].split("=");
			
			switch (parametro[0]) {
			case "--format":
				formato = parametro[1].toLowerCase();
				break;
			case "--sort":
				orden = parametro[1].toLowerCase();
				break;
			case "--output-file":
				archivo = parametro[1];
				break;
			}
		}

		ArrayList<Integer> factoresPrimos = null;
		String impresion = "";
		
		FactorPrimo factorPrimo = new FactorPrimo();
		factoresPrimos = factorPrimo.getFactores(numero);
		impresion = factorPrimo.imprimirFactoresPrimos(numero, factoresPrimos, formato, orden, archivo);
		
		if (archivo != null) {
			factorPrimo.guardarImpresion(impresion, archivo);
		}
	}
}
