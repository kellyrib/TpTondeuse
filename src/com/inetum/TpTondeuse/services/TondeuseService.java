package com.inetum.TpTondeuse.services;

import com.inetum.TpTondeuse.beans.Pelouse;
import com.inetum.TpTondeuse.beans.Tondeuse;
import com.inetum.TpTondeuse.enums.InstructionsEnum;
import com.inetum.TpTondeuse.enums.OrientationEnum;

public class TondeuseService {

	

	private Tondeuse tondeuse;
	private Pelouse pelouse;
	private OrientationEnum orientation;
	private InstructionsEnum instruction;

	public static void avancer(Tondeuse tondeuse, Pelouse pelouse) {
		
		switch (tondeuse.getOrientation()) {
		case N:

			if (tondeuse.getY() < pelouse.getyMax()) {

				tondeuse.setY(tondeuse.getY() + 1);
			}
			
			break;

		case S:
			if (tondeuse.getY() >= 0) {

				tondeuse.setY(tondeuse.getY() - 1);
			}

			break;
		case E:
			if (tondeuse.getX() < pelouse.getxMax()) {
				tondeuse.setX(tondeuse.getX() + 1);
			}

			break;
		case W:
			if (tondeuse.getX() >= 0) {
				tondeuse.setX(tondeuse.getX() - 1);
			}

			break;
		default:
			break;
		}

	}
	
	public static void tourner(Pelouse pelouse, Tondeuse tondeuse, String instruction) {

		switch (instruction) {
		case "G":
			switch (tondeuse.getOrientation()) {
			case N:

				tondeuse.setOrientation(OrientationEnum.W);

				break;

			case S:
				tondeuse.setOrientation(OrientationEnum.E);

				break;
			case E:
				tondeuse.setOrientation(OrientationEnum.N);

				break;
			case W:
				tondeuse.setOrientation(OrientationEnum.S);
				break;
			default:
				break;
			}

			break;
		case "D":
			switch (tondeuse.getOrientation()) {
			case N:

				tondeuse.setOrientation(OrientationEnum.E);

				break;

			case S:
				tondeuse.setOrientation(OrientationEnum.W);
				break;
			case E:
				tondeuse.setOrientation(OrientationEnum.S);

				break;
			case W:
				tondeuse.setOrientation(OrientationEnum.N);

				break;
			default:
				break;
			}

			break;

		default:
			break;
		}

	}
	
	
}
