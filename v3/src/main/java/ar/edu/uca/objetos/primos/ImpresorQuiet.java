package ar.edu.uca.objetos.primos;

import java.util.ArrayList;
import java.util.Collections;

public class ImpresorQuiet implements Impresor {
	public String imprimir(int numero, ArrayList<Integer> factoresPrimos, String orden) {
		String resultado = "";
		
		if (orden.equals("desc")) {
			Collections.reverse(factoresPrimos);
		}
		
		for (Integer num : factoresPrimos) {
			resultado += num + "\n";
		}
		
		System.out.println(resultado);
		
		return resultado;
	}
}
