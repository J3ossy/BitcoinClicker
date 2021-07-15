package teko.ss;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

import javax.swing.JFileChooser;

import GUI.Gui;

public class Data {

	// Ordner und Datei
	File folder = new File("data");
	File file = new File("data/save.txt");

	// Setzt die einzelnen Speicherzustaende zusammen
	StringBuilder sb = new StringBuilder();

	// Speichern-Methode
	public static void safeData() {

		Data data = new Data();

		// Erstellen des Ordners und der Datei, sofern noch nicht vorhanden
		if (!data.folder.exists()) {
			data.folder.mkdirs();
		}
		if (!data.file.exists()) {
			try {
				data.file.createNewFile();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}

		// Speichern der einzelnen Variabeln 
		data.sb.append(BitcoinMain.bitcoin);
		data.sb.append("\n");
		data.sb.append(BitcoinMain.bps);
		data.sb.append("\n");
		data.sb.append(BitcoinMain.bpc);
		data.sb.append("\n");
		data.sb.append(BitcoinMain.ugClickerCost);
		data.sb.append("\n");
		data.sb.append(BitcoinMain.ClickCount);
		data.sb.append("\n");
		
		// Speichern der Upgrades
		for (int i = 0; i < Gui.upgrade.length; i++) {
			data.sb.append(Gui.upgrade[i].getAnzahl());
			data.sb.append("\n");
			data.sb.append(Gui.upgrade[i].getCost());
			data.sb.append("\n");
		}
		
		// Speichern der Achievements
		for (int i = 0; i < BitcoinMain.achievementAnzahl; i++) {
			if (Gui.achievement[i].isUnlocked()) {
				data.sb.append("1");
				data.sb.append("\n");
			} else {
				data.sb.append("0");
				data.sb.append("\n");
			}
		}

		// In die Textdatei schreiben
		try {
			OutputStream stream = new FileOutputStream(data.file);
			String s = data.sb.toString();

			stream.write(s.getBytes());
			stream.close();

			System.out.println("Daten gespeichert!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Laden-Methode
	public static void loadData() {

		JFileChooser chooser = new JFileChooser();

		int temp = chooser.showOpenDialog(null);
		if (temp == JFileChooser.APPROVE_OPTION) {
			String s = chooser.getSelectedFile().getAbsolutePath();
			if (s.endsWith("save.txt")) {

				File file = new File(s);
				try {
					Scanner sc = new Scanner(file);
					// lesen und zuweisen der Werte
					BitcoinMain.bitcoin = Double.parseDouble(sc.nextLine());
					BitcoinMain.bps = Double.parseDouble(sc.nextLine());
					BitcoinMain.bpc = Double.parseDouble(sc.nextLine());
					BitcoinMain.ugClickerCost = Integer.parseInt(sc.nextLine());
					BitcoinMain.ClickCount = Integer.parseInt(sc.nextLine());
					// Upgrades
					for (int i = 0; i < Gui.upgrade.length; i++) {
						Gui.upgrade[i].setAnzahl(Integer.parseInt(sc.nextLine()));
						Gui.upgrade[i].setCost(Integer.parseInt(sc.nextLine()));
					}
					// Achievements
					for (int i = 0; i < BitcoinMain.achievementAnzahl; i++) {
						if (sc.nextLine().equals("1")) {
							Gui.achievement[i].setUnlocked(true);
						} else {
							Gui.achievement[i].setUnlocked(false);
						}
					}
					sc.close();

				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
				}

			} else {
				System.out.println("Fehler beim Einlesen!");
			}
		}
	}

	// Setzt die Texte der Achievements
	public static void setAchievementName() {

		File achText = new File("data/achtext.txt");

		if (achText != null) {
			try {
				Scanner sc = new Scanner(achText);
				for (int i = 0; i < BitcoinMain.achievementAnzahl; i++) {
					Gui.achievement[i].setText(sc.nextLine());
				}
				sc.close();
			} catch (FileNotFoundException e) {
				System.out.println("Achievementtexte konnten nicht eingelesen werden!");
				System.out.println(e.getMessage());
			}
		}

	}

	// Setzt die Namen der Achievements
	public static void setAchievementText() {

		File achName = new File("data/achname.txt");

		if (achName != null) {
			try {
				Scanner sc = new Scanner(achName);
				for (int i = 0; i < BitcoinMain.achievementAnzahl; i++) {
					Gui.achievement[i].setName(sc.nextLine());
				}
				sc.close();
			} catch (FileNotFoundException e) {
				System.out.println("Achievementnamen konnten nicht eingelesen werden!");
				e.printStackTrace();
			}
		}
	}
}
