package com.inetum.TpTondeuse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import com.inetum.TpTondeuse.beans.Pelouse;
import com.inetum.TpTondeuse.beans.Tondeuse;
import com.inetum.TpTondeuse.enums.InstructionsEnum;
import com.inetum.TpTondeuse.enums.OrientationEnum;
import com.inetum.TpTondeuse.reader.TextFileTondeuseReader;
import com.inetum.TpTondeuse.reader.TondeuseReader;
import com.inetum.TpTondeuse.services.TondeuseService;

public class TpTondeuse {

	public static void main(String[] args) throws FileNotFoundException {
		
		// lecture du fichier qui sera rappelé dans textFileTondeuse
		
		TondeuseReader tondeuseReader= new TextFileTondeuseReader();
		
		URL url = TpTondeuse.class.getResource("/fichierText.txt");
		
		tondeuseReader.readFile(url.getFile());
		
		
		
//		TondeuseService tondeuseService = new TondeuseService();
//
//		for (String lettre : lettres) {
//			if (lettre.equals("A")) {
//				tondeuseService.avancer(tondeuse, pelouse);
//
//			} else if (lettre.equals("G") || lettre.equals("D")) {
//				tondeuseService.tourner(pelouse, tondeuse, lettre);
//
//			}
//			System.out.println("x" + tondeuse.getX() + "y" + tondeuse.getY() + tondeuse.getOrientation());
//
//		}
//		System.out.println(tondeuse);
//
//		Tondeuse tondeuse2 = new Tondeuse(3, 3, OrientationEnum.E);
//		System.out.println("tondeuse1 :" + tondeuse);
//
//		String instruction2 = "AADAADADDA ";
//
//		String[] lettres2 = instruction2.split("");
//
//		for (String lettre : lettres2) {
//			if (lettre.equals("A")) {
//				tondeuseService.avancer(tondeuse2, pelouse);
//
//			} else if (lettre.equals("G") || lettre.equals("D")) {
//				tondeuseService.tourner(pelouse, tondeuse2, lettre);
//
//			}
//			System.out.println("x" + tondeuse2.getX() + "y" + tondeuse2.getY() + tondeuse2.getOrientation());
//
//		}
//		System.out.println("tondeuse2 :" + tondeuse2);
//
	}

	

}
