package GUI;

public class Button {

	int x, y, width, height;
	boolean hover = false, active = false;

	// Konstruktor mit Uebergabeparametern (Platzierung) für Button
	public Button(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Button() {
	}

	// setzt entsprechenden Button auf aktiv
	public static void setActive(Button btn) {

		Gui.bUpgrades.active = false;
		Gui.bAchievements.active = false;
		Gui.bOptions.active = false;

		btn.active = true;
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

	public boolean isActive() {
		return active;
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

	public void setActive(boolean active) {
		this.active = active;
	}

}
