package com.inetum.TpTondeuse;

import com.inetum.TpTondeuse.beans.Pelouse;
import com.inetum.TpTondeuse.beans.Tondeuse;
import com.inetum.TpTondeuse.enums.InstructionsEnum;
import com.inetum.TpTondeuse.enums.OrientationEnum;
import com.inetum.TpTondeuse.services.TondeuseService;

public class TpTondeuse {

	



	public static void main(String[] args) {
		
		
		

		TondeuseService tondeuseService= new TondeuseService();

		Tondeuse tondeuse = new Tondeuse(1, 2, OrientationEnum.N);
		System.out.println(tondeuse);

		Pelouse pelouse = new Pelouse(5, 5);
		System.out.println(pelouse);

		String instruction = "GAGAGAGAA";

		String[] lettres = instruction.split("");

		for (String lettre : lettres) {
			if (lettre.equals("A") ) {
				tondeuseService.avancer(tondeuse, pelouse);
				
				
			} else if(lettre.equals("G")|| lettre.equals("D")){
				tondeuseService.tourner(pelouse, tondeuse, lettre);

			}
			System.out.println("x" +tondeuse.getX()+"y"+tondeuse.getY()+ tondeuse.getOrientation());

		}
		System.out.println(tondeuse);
		
		

	}

}
