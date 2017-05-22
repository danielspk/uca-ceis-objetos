package ar.edu.uca.objetos.primos;

import java.util.ArrayList;

public class ImpresorPretty implements Impresor {
	public void imprimir(int numero, ArrayList<Integer> factoresPrimos){
		String resultado = "";
		
		resultado += "Factores primos " + numero + ":";

		for (Integer num : factoresPrimos) {
			resultado += " " + num;
		}
		
		System.out.println(resultado);
	}
}
