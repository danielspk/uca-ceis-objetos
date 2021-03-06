package ar.edu.uca.objetos.primos;

import java.util.ArrayList;

public class Programa{
	
	public static void main( String[] args ){
		int numero = Integer.parseInt(args[0]);
		int descomposicion = numero;
		
		// se crea una lista de numeros primos menores o iguales a la entrada
		ArrayList<Integer> numerosPrimos = new ArrayList<Integer>();
		
		for (int i = 0; i <= numero; i++) {
			int casos = 0;
			
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					casos++;
				}
			}
			
			if (casos == 2) {
				numerosPrimos.add(i);
			}
		}

		// se buscan factores primos
		ArrayList<Integer> factoresPrimos = new ArrayList<Integer>();
		
		for (Integer num : numerosPrimos) {
			boolean esFactor = true;
			
			while (esFactor) {
				if (descomposicion % num == 0) {
					descomposicion /= num;
					factoresPrimos.add(num);
				} else {
					esFactor = false;
				}
			}
			
			if (descomposicion <= 1) {
				break;
			}
		}
		
		// se imprimen los resultados
		String resultado = "Factores primos " + numero + ":";

		for (Integer num : factoresPrimos) {
			resultado += " " + num;
		}
		
		System.out.println(resultado);
	}
}
