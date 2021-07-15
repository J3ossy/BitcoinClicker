package GUI;

import javax.swing.JFrame;

import Draw.Draw_Main;
import Draw.Draw_Options;
import Draw.Draw_Achievement;
import Draw.Draw_Buttons;
import Draw.Draw_Upgrades;
import teko.ss.BitcoinMain;
import teko.ss.Data;
import teko.ss.MouseHandler;

public class Gui {

	JFrame jf;
	Draw_Main d;
	Draw_Buttons db;
	Draw_Upgrades du;
	Draw_Options dop;
	Draw_Achievement da;

	IL il = new IL();

	// Fenstergroesse
	public final int width = 1280;
	public final int height = 720;

	// Scrollpanel
	public static int maxHeight, actualHeight = 0;

	// Buttons Menueleiste
	public static Button bUpgrades, bAchievements, bOptions;

	// Button Speichern-Laden
	public static Button bSave, bLoad;

	// Button Bitcoin
	public static Button ugClicker, bBitcoin;

	// Achievements
	public static Achievement achievement[] = new Achievement[BitcoinMain.achievementAnzahl];
	public static AchievementSlider achievementSlider[] = new AchievementSlider[BitcoinMain.achievementAnzahl];

	// Array UpdateButton
	public static Button ugButton[] = new Button[BitcoinMain.anzahlUpgrade];

	// Array fuer die Upgrades
	public static Upgrade upgrade[] = new Upgrade[BitcoinMain.anzahlUpgrade];

	// Erstellung des Fensters
	public void createGui() {

		bUpgrades = new Button(width / 2, 0, 146 + 50, 100);
		bUpgrades.active = true;
		bAchievements = new Button(width / 2 + 196, 0, 219 + 50, 100);
		bOptions = new Button(width - 175, 0, 175, 100);

		bBitcoin = new Button(width / 4 - 100, 150, 200, 200);
		ugClicker = new Button(width / 4 - 75, 500, 150, 50);

		bSave = new Button((width / 4) * 3 - 100, 200, 200, 50);
		bLoad = new Button((width / 4) * 3 - 100, 400, 200, 50);

		// Upgrade Buttons
		for (int i = 0; i < upgrade.length; i++) {
			ugButton[i] = new Button();
			ugButton[i].y = 150 + (i * 200) + 85;
			ugButton[i].x = (width / 2) + (((width / 2) / 3) * 2) + 20;
			ugButton[i].width = 170;
			ugButton[i].height = 40;
		}

		// Upgrades
		upgrade[0] = new Upgrade("Miningpool", il.iup[0], 10);
		upgrade[1] = new Upgrade("New Hardware", il.iup[1], 100);
		upgrade[2] = new Upgrade("Energy Efficiency", il.iup[2], 500);
		upgrade[3] = new Upgrade("Software Upgrade", il.iup[3], 1000);

		for (int i = 0; i < upgrade.length; i++) {
			upgrade[i].setY(Upgrade.setYCoord(i));
		}

		maxHeight = (upgrade.length * (150 + 50));

		// Achievements
		int temp = 0;
		int yShift = 0;
		int xShift = 0;

		for (int i = 0; i < achievement.length; i++) {
			achievement[i] = new Achievement(width / 2 + 7 + xShift, 107 + yShift, il.iachievement[i]);

			// Zeilenumbruch nach 12 Upgrades
			temp++;
			if (temp % 12 == 0) {
				temp = 0;
				yShift += 52;
			}

			xShift = temp * 50 + temp * 2;
		}

		Data.setAchievementName();
		Data.setAchievementText();
		
		// Inizialisierung der AchievementSlider
		for (int i = 0; i < achievementSlider.length; i++) {
			achievementSlider[i] = new AchievementSlider(achievement[i]);
		}

		// Fenster
		jf = new JFrame("Bitcoin Clicker");
		jf.setSize(width, height);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Fenster zentrieren
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);

		jf.addMouseWheelListener(new MouseHandler());

		// Buttons
		db = new Draw_Buttons();
		db.setSize(width, height);
		db.setVisible(true);
		db.requestFocus();
		db.addMouseListener(new MouseHandler());
		db.addMouseMotionListener(new MouseHandler());
		jf.add(db);

		// Upgrades
		du = new Draw_Upgrades();
		du.setSize(width, height);
		du.setVisible(true);
		du.requestFocus();
		du.addMouseListener(new MouseHandler());
		du.addMouseMotionListener(new MouseHandler());
		jf.add(du);

		// Achievements
		da = new Draw_Achievement();
		da.setSize(width, height);
		da.setVisible(true);
		da.requestFocus();
		da.addMouseListener(new MouseHandler());
		da.addMouseMotionListener(new MouseHandler());
		jf.add(da);

		// Options
		dop = new Draw_Options();
		dop.setSize(width, height);
		dop.setVisible(true);
		dop.requestFocus();
		dop.addMouseListener(new MouseHandler());
		dop.addMouseMotionListener(new MouseHandler());
		jf.add(dop);

		// Draw Main
		d = new Draw_Main();
		d.setSize(width, height);
		d.setVisible(true);
		d.requestFocus();
		d.addMouseListener(new MouseHandler());
		d.addMouseMotionListener(new MouseHandler());	
		jf.add(d);

		// Fenster sichbarmachen, nachdem alles zuvor ausgeführt wurde
		jf.setVisible(true);
	}

}
