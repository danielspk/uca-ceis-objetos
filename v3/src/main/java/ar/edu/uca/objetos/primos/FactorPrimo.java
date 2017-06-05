package ar.edu.uca.objetos.primos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FactorPrimo {
	public ArrayList<Integer> getFactoresPrimos(int numero) {
		int descomposicion = numero;
		int numeroPrimo = 2;
		ArrayList<Integer> factoresPrimos = new ArrayList<Integer>();
		
		while (descomposicion > 1) {
			if (descomposicion % numeroPrimo == 0) {
				descomposicion /= numeroPrimo;
				factoresPrimos.add(numeroPrimo);
				
				continue;
			}
			
			numeroPrimo++;
			
			for (int aux = 2; aux < numeroPrimo; aux++) {
				if (numeroPrimo % aux == 0) {
					numeroPrimo++;
					
					continue;
				}
			}
		}
		
		return factoresPrimos;
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
}
