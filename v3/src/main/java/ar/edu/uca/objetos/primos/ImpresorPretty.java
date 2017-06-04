package ar.edu.uca.objetos.primos;

import java.util.ArrayList;
import java.util.Collections;

public class ImpresorPretty implements Impresor {
	public String imprimir(int numero, ArrayList<Integer> factoresPrimos, String orden) {
		String resultado = "";
		
		resultado += "Factores primos " + numero + ":";

		if (orden.equals("desc")) {
			Collections.reverse(factoresPrimos);
		}
		
		for (Integer num : factoresPrimos) {
			resultado += " " + num;
		}
		
		System.out.println(resultado);
		
		return resultado;
	}
}
