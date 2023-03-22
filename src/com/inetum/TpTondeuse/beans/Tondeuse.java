package com.inetum.TpTondeuse.beans;

import com.inetum.TpTondeuse.enums.OrientationEnum;

public class Tondeuse {
	
	//creation des attributs x pour les abscisses , y pour les ordonnées et enum orientation

	private int x;
	private int y;
	private OrientationEnum orientation;
	
	
	// constructeur par défaut
	
	public Tondeuse() {
		super();
	}

	// constructeur avec les arguments
	public Tondeuse(int x, int y, OrientationEnum orientation) {
		super();
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}

	// getter et setters
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public OrientationEnum getOrientation() {
		return orientation;
	}

	
	public void setOrientation(OrientationEnum orientation) {
		this.orientation = orientation;
	}


	@Override
	public String toString() {
		return "Tondeuse [x=" + x + ", y=" + y + ", orientation=" + orientation + "]";
	}
	
	
	
	
	
	
	
}
