package teko.ss;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import GUI.Button;
import GUI.Gui;
import GUI.Upgrade;

public class MouseHandler implements MouseListener, MouseMotionListener, MouseWheelListener {

	Gui gui = new Gui();
	MouseCollision mc = new MouseCollision();

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

		// Upgradebutton
		if (mc.inside(e.getX(), e.getY(), Gui.bUpgrades)) {
			Button.setActive(Gui.bUpgrades);
		}

		// Achievmentsbutton
		if (mc.inside(e.getX(), e.getY(), Gui.bAchievements)) {
			Button.setActive(Gui.bAchievements);
		}

		// Optionsbutton
		if (mc.inside(e.getX(), e.getY(), Gui.bOptions)) {
			Button.setActive(Gui.bOptions);
		}

		// Bitcoin Button/Bild
		if (mc.inside(e.getX(), e.getY(), Gui.bBitcoin)) {
			Gui.bBitcoin.setActive(true);
			BitcoinMain.bitcoin += BitcoinMain.bpc;
			BitcoinMain.ClickCount ++;
		}

		// Upgrade Buttons
		for (int i = 0; i < Gui.upgrade.length; i++) {
			if (mc.inside(e.getX(), e.getY(), Gui.ugButton[i])) {

				if (BitcoinMain.bitcoin >= Gui.upgrade[i].getCost()) {
					BitcoinMain.bitcoin -= Gui.upgrade[i].getCost();

					int anzahl = Gui.upgrade[i].getAnzahl();
					Gui.upgrade[i].setAnzahl(anzahl += 1);
					int cost = Gui.upgrade[i].getCost();
					Gui.upgrade[i].setCost(cost += cost / 0.5);
					Upgrade.bpsUpgrade(i);
				}
			}
		}

		// Upgrade Clickerbutton
		if (mc.inside(e.getX(), e.getY(), Gui.ugClicker)) {
			if (BitcoinMain.bitcoin >= BitcoinMain.ugClickerCost) {
				BitcoinMain.bitcoin -= BitcoinMain.ugClickerCost;

				BitcoinMain.ugClickerCost *= 2;
				BitcoinMain.bpc += BitcoinMain.bpc / 2;
			}
		}

		// Save Button
		if (mc.inside(e.getX(), e.getY(), Gui.bSave)) {
			Data.safeData();
		}

		// Load Button
		if (mc.inside(e.getX(), e.getY(), Gui.bLoad)) {
			Data.loadData();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		// Bitcoin Button/Bild
		if (Gui.bBitcoin.isActive()) {
			Gui.bBitcoin.setActive(false);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {

		// Upgrade Button
		if (mc.inside(e.getX(), e.getY(), Gui.bUpgrades)) {
			Gui.bUpgrades.setHover(true);
		} else {
			Gui.bUpgrades.setHover(false);
		}

		// Achievements Button
		if (mc.inside(e.getX(), e.getY(), Gui.bAchievements)) {
			Gui.bAchievements.setHover(true);
		} else {
			Gui.bAchievements.setHover(false);
		}

		// Options Button
		if (mc.inside(e.getX(), e.getY(), Gui.bOptions)) {
			Gui.bOptions.setHover(true);
		} else {
			Gui.bOptions.setHover(false);
		}

		// Upgrade Button
		for (int i = 0; i < Gui.ugButton.length; i++) {
			if (mc.inside(e.getX(), e.getY(), Gui.ugButton[i])) {
				Gui.ugButton[i].setHover(true);
			} else {
				Gui.ugButton[i].setHover(false);
			}
		}

		// Upgrade Clicker

		if (mc.inside(e.getX(), e.getY(), Gui.ugClicker)) {
			Gui.ugClicker.setHover(true);
		} else {
			Gui.ugClicker.setHover(false);
		}

		// Ladenbutton

		if (mc.inside(e.getX(), e.getY(), Gui.bLoad)) {
			Gui.bLoad.setHover(true);
		} else {
			Gui.bLoad.setHover(false);
		}

		// Speicherbutton

		if (mc.inside(e.getX(), e.getY(), Gui.bSave)) {
			Gui.bSave.setHover(true);
		} else {
			Gui.bSave.setHover(false);
		}
		
		
		///////////////////////////////////////////////
		//Achievements
		//////////////////////////////////////////////
		
		for (int i = 0; i < BitcoinMain.achievementAnzahl; i++) {
			if(mc.inside(e.getX(), e.getY(), Gui.achievement[i])) {	
				Gui.achievement[i].setHover(true);
			} else {
				Gui.achievement[i].setHover(false);
			}
		}
		
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {

		if (Gui.bUpgrades.isActive()) {

			if (e.getX() > gui.width / 2) {

				// Runterscrollen -> Upgrades nach oben
				if (e.getWheelRotation() == 1) {
					Gui.actualHeight -= 20;

					// Grenze
					if (Gui.actualHeight >= -(Gui.maxHeight - 550)) {
						for (int i = 0; i < Gui.upgrade.length; i++) {
							int y1 = Gui.upgrade[i].getY() - 20;
							int y2 = Gui.ugButton[i].getY() - 20;

							Gui.upgrade[i].setY(y1);
							Gui.ugButton[i].setY(y2);

						}
					} else {
						Gui.actualHeight = -(Gui.maxHeight - 550);

					}
				}
			
				// Hochscrollen -> Upgrades nach unten

				if (e.getWheelRotation() == -1) {
					Gui.actualHeight += 20;

					if (Gui.actualHeight <= 0) {
						for (int i = 0; i < Gui.upgrade.length; i++) {
							int y1 = Gui.upgrade[i].getY() + 20;
							int y2 = Gui.ugButton[i].getY() + 20;
							
							Gui.upgrade[i].setY(y1);
							Gui.ugButton[i].setY(y2);
							
						}
					} else {
						Gui.actualHeight = 0;
						
					}
				}

			}
		}

	}

}
