package GUI;

import java.awt.image.BufferedImage;

public class Achievement {

	int x, y;
	int width = 50, height = 50;
	boolean hover = false, unlocked = false;

	BufferedImage image;
	String name, text;

	// Konstruktor
	public Achievement(int x, int y, BufferedImage image) {

		this.x = x;
		this.y = y;
		this.image = image;

	}

	
	// Getter und Setter
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

	public boolean isHover() {
		return hover;
	}

	public boolean isUnlocked() {
		return unlocked;
	}

	public BufferedImage getImage() {
		return image;
	}

	public String getName() {
		return name;
	}

	public String getText() {
		return text;
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

	public void setHover(boolean hover) {
		this.hover = hover;
	}

	public void setUnlocked(boolean unlocked) {
		this.unlocked = unlocked;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setText(String text) {
		this.text = text;
	}

}
