package ar.edu.uca.objetos.primos;

import java.util.ArrayList;

public class ImpresorQuiet implements Impresor {
	public void imprimir(int numero, ArrayList<Integer> factoresPrimos){
		String resultado = "";
		
		for (int i = factoresPrimos.size() - 1; i >= 0; i--) {
			resultado += factoresPrimos.get(i)+"\n";
		}
		
		System.out.println(resultado);
	}
}
