package teko.ss;

import GUI.Gui;

public class BitcoinMain {
	
	public static double bitcoin = 999;
	public static double bps = 0;
	public static double bpc = 1;
	public static int anzahlUpgrade = 4;
	public static int ugClickerCost = 10;
	public static int achievementAnzahl = 7;
	public static int ClickCount = 0;

	public static void main(String[] args) {
	
		//Fenster öffnen
		Gui g = new Gui();
		g.createGui();
		
		new BitcoinCounter();
		
		// Timer starten
		new AchievementCheck();
		
	}

}
