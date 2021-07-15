package Draw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

import GUI.Gui;

@SuppressWarnings("serial")
public class Draw_Options extends JLabel {

	Gui gui = new Gui();
	int textWidth;

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		// Kantenglättung
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (Gui.bOptions.isActive()) {

			// Speichern
			g.setColor(new Color(43, 61, 79, 150));
			g.fillRect(gui.width / 2 + 1, 150, gui.width, 150);

			g.setColor(new Color(255, 255, 255, 150));
			g.drawLine(gui.width / 2 + 1, 150, gui.width, 150);
			g.drawLine(gui.width / 2 + 1, 150 + 150, gui.width, 150 + 150);

			g.drawRect(Gui.bSave.getX(), Gui.bSave.getY(), Gui.bSave.getWidth(), Gui.bSave.getHeight());

			// Hover-Effekt
			if (Gui.bSave.isHover()) {
				g.setColor(new Color(84, 84, 84, 150));
				g.fillRect(Gui.bSave.getX() + 1, Gui.bSave.getY() + 1, Gui.bSave.getWidth() - 1,
						Gui.bSave.getHeight() - 1);
			} else {
				g.setColor(Color.WHITE);
			}

			// Text Speichern
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.PLAIN, 25));
			textWidth = g.getFontMetrics().stringWidth("Save");
			g.drawString("Save", (gui.width / 4) * 3 - textWidth / 2, 233);

			// Laden
			g.setColor(new Color(43, 61, 79, 150));
			g.fillRect(gui.width / 2 + 1, 350, gui.width, 150);

			g.setColor(new Color(255, 255, 255, 150));
			g.drawLine(gui.width / 2 + 1, 350, gui.width, 350);
			g.drawLine(gui.width / 2 + 1, 350 + 150, gui.width, 350 + 150);

			g.drawRect(Gui.bLoad.getX(), Gui.bLoad.getY(), Gui.bLoad.getWidth(), Gui.bLoad.getHeight());

			// Hover-Effekt
			if (Gui.bLoad.isHover()) {
				g.setColor(new Color(84, 84, 84, 150));
				g.fillRect(Gui.bLoad.getX() + 1, Gui.bLoad.getY() + 1, Gui.bLoad.getWidth() - 1,
						Gui.bLoad.getHeight() - 1);
			} else {
				g.setColor(Color.WHITE);
			}

			// Text Laden
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.PLAIN, 25));
			textWidth = g.getFontMetrics().stringWidth("Load");
			g.drawString("Load", (gui.width / 4) * 3 - textWidth / 2, 433);
		}

		repaint();
	}

}
