package com.inetum.TpTondeuse.reader;

import java.io.FileNotFoundException;

public interface TondeuseReader {

	/**
	 * methode permettant de lire le fichier tondeuse
	 * 
	 * @param filePath chemin vers le fichier à lire
	 * @throws FileNotFoundException dans le cas où le fichier n'est pas trouvé
	 */
	void readFile(String filePath) throws FileNotFoundException;
	
	
}
