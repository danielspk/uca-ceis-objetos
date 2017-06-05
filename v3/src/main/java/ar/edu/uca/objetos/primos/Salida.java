package ar.edu.uca.objetos.primos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Salida {
	public void guardarTexto(String texto, String archivo) {
		try {
			Files.write(Paths.get("./" + archivo), texto.getBytes());
		} catch (IOException e) {
			System.out.println("Error en la generación del archivo de salida.");
		}
	}
}
