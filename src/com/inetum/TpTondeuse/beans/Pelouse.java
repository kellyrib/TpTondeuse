package com.inetum.TpTondeuse.beans;

public class Pelouse {
	//creation des attributs x pour les abscisses , y pour les ordonnées
	private int xMax;
	private int yMax;
	
	// constructeur par défaut
	public Pelouse() {
		super();
	}

	// constructeur avec les arguments
	public Pelouse(int xMax, int yMax) {
		super();
		this.xMax = xMax;
		this.yMax = yMax;
	}

	// getter 
	public int getxMax() {
		return xMax;
	}


	public int getyMax() {
		return yMax;
	}


	// to string

	@Override
	public String toString() {
		return "Pelouse [xMax=" + xMax + ", yMax=" + yMax + "]";
	}
	
	

}
