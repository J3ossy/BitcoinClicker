package GUI;

import java.awt.image.BufferedImage;

import teko.ss.BitcoinMain;

public class Upgrade {

	Gui gui = new Gui();
	
	int x, y;
	int width = gui.width/2;
	int height = 150;
	String name;
	BufferedImage image;
	int anzahl;
	int cost;
	
	
	public Upgrade(String name, BufferedImage image, int cost) {
		this.x = gui.width/2;
		this.name = name;
		this.image = image;
		this.anzahl = 0;
		this.cost = cost;
	}
	
	// setzen der Y-Koordinate 
	public static int setYCoord(int index) {
		return 150 + index * 200;
	}
	
	// Ereignis jedes Upgrades, Index ist das jeweilige Upgrade
	public static void bpsUpgrade(int index) {
		switch(index) {
		case 0:
			BitcoinMain.bps += 2;
			break;
		case 1:
			BitcoinMain.bps += 7;
			break;
		case 2:
			BitcoinMain.bps += 15;
			break;
		case 3:
			BitcoinMain.bps += 25;
			break;
		}		
	}

	// Getters und Setters	
	public Gui getGui() {
		return gui;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String getName() {
		return name;
	}

	public BufferedImage getImage() {
		return image;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public int getCost() {
		return cost;
	}

	public void setGui(Gui gui) {
		this.gui = gui;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}		
}
