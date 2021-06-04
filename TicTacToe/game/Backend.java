package game;

import java.util.ArrayList;

public class Backend {
	
	private static int counter = 1; //dient der Bestimmung welcher Spieler dran ist
	//Spielfeldvorlage
	private static final char[][] leeresFeld = new char[][]{{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
	
	static char[][] Spielfeld = new char[][]{{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
	
	static StringBuilder  s = new StringBuilder();
	static String Spiel;
	static private char Winner;
	static private int Runde = 1;
	
	private static ArrayList<Integer> Felder = new ArrayList<Integer>(9);
	
	/*
	 * Funktion: gibt alle leeren Felder an (in die gestzt werden kann)
	 */
	static final void parametrieren() {
		for(int i = 1; i<= 9; i++) {
			Felder.add(i-1, i);
		}//Ende Schleife
	}//Ende void
	
	/*
	 * Parameter: Feld 
	 * 
	 * Funktion: prüft ob das angegebene Feld schon besetzt ist
	 */
	static final boolean prüfeGültigkeit(int Feld) {
		if(Felder.get(Feld-1) == Feld) {
			Felder.set(Feld-1, 0);
			return true;
		}else {
			return false;
		}
	}//Ende boolean
	
	/*
	 * Parameter a und b
	 * a bestimmt das Array im Array
	 * b bestimmt die Postion im inneren Array
	 * die Parameter kommen aus setzen()
	 * 
	 * Funktion: setzt ein X oder O in das Spielfeld
	 */
 	static final void eintragen(int a, int b) {
		if (counter == 1) {
			Spielfeld[a][b] = 'X';
			counter+= 1;
		}else {
			Spielfeld[a][b] = 'O';
			counter-= 1;
		}
	}//Ende void
	
 	/*
 	 * Funktion: ermittelt welcher Spieler an der Reihe ist
 	 */
 	static final String getPlayer() {
 		if (counter == 2) {
 			return "Spieler 1 (O) ist an der Reihe.";
 		}else {
 			return "Spieler 2 (X) ist an der Reihe";
 		}
 	}
 	/*
 	 * Funktion: zeigt das Spielfeld
 	 */
 	static final String zeigen() {
		for (int i = 0; i <3; i++) {
			for (int j = 0; j<3; j++) {
				s.append(Spielfeld[i][j] + " | ");
			}//Ende innere Schleife]
			s.append("\n");
			//System.out.print("\n");
		}//Ende äußere Schleife
		Spiel = s.toString();
		s.delete(0,  s.length());
		return Spiel;
	}//Ende void

	//erstellt ein neues leeres Spielfeld
	static void kopieren() {
		for (int i = 0; i < leeresFeld.length; i++) {
			for (int j = 0; j < leeresFeld[i].length; j++) {
				Spielfeld[i][j] = leeresFeld[i][j];
			}//Ende innere Schleife
		}//Ende äußere Schleife
	}//Ende void
	
	/*
	 * Parameter: Feld
	 * Feld steht für das angegebene Feld in das eingesetzt werden sollen
	 * 
	 * Funktion: bestimmt aus dem nummerischen Wert die Postion in der Array-Matrix
	 */
	static final void setzen(int Feld) {
		if (Feld == 1) {
			eintragen(0,0);
		}else if (Feld == 2) {
			eintragen(0,1);
		}else if (Feld == 3) {
			eintragen(0,2);
		}else if (Feld == 4) {
			eintragen(1,0);
		}else if (Feld == 5) {
			eintragen(1,1);
		}else if (Feld == 6) {
			eintragen(1,2);
		}else if (Feld == 7) {
			eintragen(2,0);
		}else if (Feld == 8) {
			eintragen(2,1);
		}else if (Feld == 9) {
			eintragen(2,2);
		}
		
	}
	
	/*
	 * Funktion: bestimmt ob jemand gewonnen hat
	 */
	static final boolean getWin() {
		if(Spielfeld[0][0] == Spielfeld[0][1] &&  Spielfeld[0][0] == Spielfeld[0][2] && (Spielfeld[0][0] == 'X' || Spielfeld[0][0] == 'O')) {	//Felder 1, 2 und 3
			Winner = Spielfeld[0][0];
			return true;
		}else if (Spielfeld[1][0] == Spielfeld[1][1] &&  Spielfeld[1][0] == Spielfeld[1][2] && (Spielfeld[1][0] == 'X' || Spielfeld[1][0] == 'O')) {  //Felder 4, 5 und 6
			Winner = Spielfeld[1][0];
			return true;
		}else if (Spielfeld[2][0] == Spielfeld[2][1] &&  Spielfeld[2][0] == Spielfeld[2][2] && (Spielfeld[2][0] == 'X' || Spielfeld[2][0] == 'O')) {  //Felder 7, 8 und 9
			Winner = Spielfeld[2][0];
			return true;
		}else if (Spielfeld[0][0] == Spielfeld[1][0] &&  Spielfeld[0][0] == Spielfeld[2][0] && (Spielfeld[0][0] == 'X' || Spielfeld[0][0] == 'O')) {  //Felder 1, 4 und 7
			Winner = Spielfeld[0][0];
			return true;
		}else if (Spielfeld[0][1] == Spielfeld[1][1] &&  Spielfeld[0][1] == Spielfeld[2][1] && (Spielfeld[0][1] == 'X' || Spielfeld[0][1] == 'O')) {  //Felder 2, 5 und 8
			Winner = Spielfeld[0][1];
			return true;
		}else if (Spielfeld[0][2] == Spielfeld[1][2] &&  Spielfeld[0][2] == Spielfeld[2][2] && (Spielfeld[0][2] == 'X' || Spielfeld[0][2] == 'O')) {  //Felder 3, 6 und 9
			Winner = Spielfeld[0][2];
			return true;
		}else if (Spielfeld[0][0] == Spielfeld[1][1] &&  Spielfeld[0][0] == Spielfeld[2][2] && (Spielfeld[0][0] == 'X' || Spielfeld[0][0] == 'O')) {  //Felder 1, 5 und 9
			Winner = Spielfeld[0][0];
			return true;
		}else if (Spielfeld[0][2] == Spielfeld[1][1] &&  Spielfeld[0][2] == Spielfeld[2][0] && (Spielfeld[0][2] == 'X' || Spielfeld[2][0] == 'O')) {  //Felder 3, 5 und 7
			Winner = Spielfeld[0][2];
			return true;
		}else if (Runde == 9) {
			Winner = 'U';
			return true;
		}else {
			return false;
		}
		
		
	}//Ende char

	static final char getWinner() {
		return Winner;
	}//Ende char
	
	/*
	 * Funktion: zählt die Runden
	 */
	static final void setRunde() {
		Runde += 1;
	}//Ende void
	
	/*
	 * Funktion: fragt die Runde ab
	 */
	static final int getRunde() {
		return Runde;
	}
	
	/*
	 * Funktion: setzt die Runde auf 1
	 */
	static final void setRundeToBegin() {
		Runde = 1;
	}
}//Ende Klasse
