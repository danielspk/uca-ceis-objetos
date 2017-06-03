package ar.edu.uca.objetos.primos;

import java.util.ArrayList;

public class FactorPrimo {
	public void obtenerFactor(int numero, String formato) {
		ArrayList<Integer> numerosPrimos = this.getNumerosPrimos(numero);
		ArrayList<Integer> factoresPrimos = this.getFactoresPrimos(numero, numerosPrimos);
		this.imprimirFactoresPrimos(numero, factoresPrimos, formato);
	}
	
	private ArrayList<Integer> getNumerosPrimos(int numero) {
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
		
		return numerosPrimos;
	}
	
	private ArrayList<Integer> getFactoresPrimos(int numero, ArrayList<Integer> numerosPrimos) {
		int descomposicion = numero;
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
		
		return factoresPrimos;
	}
	
	private void imprimirFactoresPrimos(int numero, ArrayList<Integer> factoresPrimos, String formato) {
		switch (formato) {
		case "pretty":
			(new ImpresorPretty()).imprimir(numero, factoresPrimos);
			break;
		case "quiet":
			(new ImpresorQuiet()).imprimir(numero, factoresPrimos);
			break;
		default:
			System.out.println("Formato no aceptado. Las opciones posibles son: pretty o quiet.");
			break;
		}
	}
}
