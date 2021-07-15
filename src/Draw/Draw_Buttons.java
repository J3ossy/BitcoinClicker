package Draw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

import GUI.Gui;
import GUI.IL;

@SuppressWarnings("serial")
public class Draw_Buttons extends JLabel {

	Gui gui = new Gui();
	IL il = new IL();
	int textWidth;

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		// Kantenglättung
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		// Bitcoin Button / Bilder klein und gross um den klick-effekt hervorzuheben
		if (Gui.bBitcoin.isActive()) {
			g.drawImage(il.ibitcoin2, Gui.bBitcoin.getX() + 15, Gui.bBitcoin.getY() + 15, Gui.bBitcoin.getWidth() - 30, Gui.bBitcoin.getHeight() - 30, null);
		} else {
			g.drawImage(il.ibitcoin1, Gui.bBitcoin.getX(), Gui.bBitcoin.getY(), Gui.bBitcoin.getWidth(), Gui.bBitcoin.getHeight(), null);
		}

		/* 
		 * Menuleiste
		 */
		
		g.setFont(new Font("Arial", Font.BOLD, 32));

		// Button Upgrades
		if (Gui.bUpgrades.isHover()) {
			g.setColor(new Color(84, 84, 84, 150));
			g.fillRect(Gui.bUpgrades.getX(), Gui.bUpgrades.getY(), Gui.bUpgrades.getWidth(), Gui.bUpgrades.getHeight());
		} else {
			g.setColor(Color.WHITE);
		}

		if (Gui.bUpgrades.isActive()) {
			g.setColor(new Color(22, 153, 128));
			g.fillRect(Gui.bUpgrades.getX(), Gui.bUpgrades.getY(), Gui.bUpgrades.getWidth(), Gui.bUpgrades.getHeight());
		}

		g.setColor(Color.WHITE);
		g.drawString("Upgrades", gui.width / 2 + 25, 60);

		// Button Achievments
		if (Gui.bAchievements.isHover()) {
			g.setColor(new Color(84, 84, 84, 150));
			g.fillRect(Gui.bAchievements.getX(), Gui.bAchievements.getY(), Gui.bAchievements.getWidth(), Gui.bAchievements.getHeight());
		} else {
			g.setColor(Color.WHITE);
		}

		if (Gui.bAchievements.isActive()) {
			g.setColor(new Color(22, 153, 128));
			g.fillRect(Gui.bAchievements.getX(), Gui.bAchievements.getY(), Gui.bAchievements.getWidth(), Gui.bAchievements.getHeight());
		}

		g.setColor(Color.WHITE);
		textWidth = g.getFontMetrics().stringWidth("Achievements");
		g.drawString("Achievements", 3 * (gui.width / 4) - (textWidth / 2) + 10, 60);

		// Button Options
		if (Gui.bOptions.isHover()) {
			g.setColor(new Color(84, 84, 84, 150));
			g.fillRect(Gui.bOptions.getX(), Gui.bOptions.getY(), Gui.bOptions.getWidth(), Gui.bOptions.getHeight());
		} else {
			g.setColor(Color.WHITE);
		}

		if (Gui.bOptions.isActive()) {
			g.setColor(new Color(22, 153, 128));
			g.fillRect(Gui.bOptions.getX(), Gui.bOptions.getY(), Gui.bOptions.getWidth(), Gui.bOptions.getHeight());
		}

		g.setColor(Color.WHITE);
		textWidth = g.getFontMetrics().stringWidth("Options");
		g.drawString("Options", gui.width - textWidth - 25, 60);

		repaint();
	}
}
