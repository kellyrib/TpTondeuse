package com.inetum.TpTondeuse.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.inetum.TpTondeuse.beans.Pelouse;
import com.inetum.TpTondeuse.beans.Tondeuse;
import com.inetum.TpTondeuse.enums.InstructionsEnum;
import com.inetum.TpTondeuse.enums.OrientationEnum;

public class TextFileTondeuseReader implements TondeuseReader {

	// liste de tondeuse
	private List<Tondeuse> listTondeuse;

	// map contenant un id de tondeuse et une liste d'instruction
	private Map<Tondeuse, List<InstructionsEnum>> instructionParTondeuse;

	// une tondeuse
	private Tondeuse tondeuse;

	// une pelouse
	private Pelouse pelouse;

	// liste d'instruction
	private ArrayList<InstructionsEnum> instruction;

	// récupération ligne pelouse
	private static final String LIGNE_PELOUSE = "^(\\d+)\\s+(\\d+)$";
	private static final Pattern PATTERN_LIGNE_PELOUSE;
	static {
		PATTERN_LIGNE_PELOUSE = Pattern.compile(LIGNE_PELOUSE);
	}
	// recup ligne tondeuse
	private static final String LIGNE_TONDEUSE = "^(\\d+)\\s+(\\d+)\\s+([NSWE]+)$";
	private static final Pattern PATTERN_LIGNE_TONDEUSE = Pattern.compile(LIGNE_TONDEUSE);

	// recup ligne instruction
	private static final String LIGNE_INSTRUCTION = "^([AGD]*)$";
	private static final Pattern PATTERN_LIGNE_INSTRUCTIONS = Pattern.compile(LIGNE_INSTRUCTION);

	// constructeur textFileTondeuseReader
	public TextFileTondeuseReader() {
		this.listTondeuse = new ArrayList<Tondeuse>();
		this.instructionParTondeuse = new HashMap<Tondeuse, List<InstructionsEnum>>();
		this.instruction = new ArrayList<InstructionsEnum>();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws FileNotFoundException
	 */
	@Override
	public void readFile(String filePath) throws FileNotFoundException {

		Scanner scan = new Scanner(new File(filePath));

		// recuperation des coordonnées de la pelouse
		String lignePelouse = scan.nextLine();

		Matcher matcherPelouse = PATTERN_LIGNE_PELOUSE.matcher(lignePelouse);

		int xPelouse = 0;
		int yPelouse = 0;

		if (matcherPelouse.matches()) {
			matcherPelouse.groupCount();
			xPelouse = Integer.valueOf(matcherPelouse.group(1));
			yPelouse = Integer.valueOf(matcherPelouse.group(2));

		}

		pelouse = new Pelouse(xPelouse, yPelouse);

		// boucle tant que pour recuperer la position initiale et les instructions

		while (scan.hasNextLine()) {
			// recup ligne tondeuse
			String ligneTondeuseOuInstruction = scan.nextLine();

			Matcher matcherTondeuse = PATTERN_LIGNE_TONDEUSE.matcher(ligneTondeuseOuInstruction);
			int xTondeuse = 0;
			int yTondeuse = 0;
			OrientationEnum OrientationTondeuse = null;
			if (matcherTondeuse.matches()) {
				matcherTondeuse.groupCount();
				xTondeuse = Integer.valueOf(matcherTondeuse.group(1));
				yTondeuse = Integer.valueOf(matcherTondeuse.group(2));
				OrientationTondeuse = OrientationEnum.valueOf(matcherTondeuse.group(3));
				Tondeuse tondeuse = new Tondeuse(xTondeuse, yTondeuse, OrientationTondeuse);
				listTondeuse.add(tondeuse);
			}
			// recup ligne instruction

			Matcher matcherInstructions = PATTERN_LIGNE_INSTRUCTIONS.matcher(ligneTondeuseOuInstruction);

			if (matcherInstructions.matches()) {
				matcherInstructions.groupCount();
				String chaineInstructions = matcherInstructions.group(1);

				for (int i = 0; i < chaineInstructions.length(); i++) {

					instructionParTondeuse.put(tondeuse, null);

					instruction.add(InstructionsEnum.valueOf(String.valueOf(chaineInstructions.charAt(i))));

				}

			}

		}

		System.out.println(pelouse);
		System.out.println(listTondeuse);
		System.out.println(instruction);

//		String instruction = scan.next();
//
//		String[] lettres = instruction.split("");

	}
}
