package ar.edu.uca.objetos.primos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FactorPrimo {
	public ArrayList<Integer> getFactores(int numero) {
		ArrayList<Integer> numerosPrimos = this.getNumerosPrimos(numero);
		
		return this.getFactoresPrimos(numero, numerosPrimos);
	}
	
	public String imprimirFactoresPrimos(
			int numero, ArrayList<Integer> factoresPrimos, 
			String formato, String orden, String archivo
	) {
		String resultados = "";
		
		switch (formato) {
		case "pretty":
			resultados = (new ImpresorPretty()).imprimir(numero, factoresPrimos, orden);
			break;
		case "quiet":
			resultados = (new ImpresorQuiet()).imprimir(numero, factoresPrimos, orden);
			break;
		default:
			System.out.println("Formato no aceptado. Las opciones posibles son: pretty o quiet.");
			break;
		}
		
		return resultados;
	}
	
	public void guardarImpresion(String impresion, String archivo) {
		try {
			Files.write(Paths.get("./" + archivo), impresion.getBytes());
		} catch (IOException e) {
			System.out.println("Error en la generación del archivo de salida.");
		}
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
}
