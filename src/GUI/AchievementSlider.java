package GUI;

import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class AchievementSlider {

	Gui gui = new Gui();

	int x = 0, y, width = 200, height = 50;
	BufferedImage image;
	String text;
	boolean visible = false;

	public AchievementSlider(Achievement achievment) {

		this.y = gui.height;
		this.image = achievment.getImage();
		this.text = achievment.getText();

	}

	public static void slideIn(AchievementSlider achievementslider) {
		Timer time = new Timer();
		time.scheduleAtFixedRate(new TimerTask() {
			int temp = 0;

			@Override
			public void run() {

				if (temp < 85) {
					achievementslider.y -= 1;
					temp++;
				} else {
					slideOut(achievementslider);
					try {
						time.cancel();
					} catch (Exception e) {

						e.printStackTrace();
					}
				}
			}

		}, 0, 30);
	}

	public static void slideOut(AchievementSlider achievementslider) {
		Timer time = new Timer();
		time.scheduleAtFixedRate(new TimerTask() {
			int temp = 85;

			@Override
			public void run() {

				if (temp > 0) {
					achievementslider.y += 1;
					temp--;
				} else {
					achievementslider.setVisible(false);
					try {
						time.cancel();
					} catch (Exception e) {

						e.printStackTrace();
					}
				}
			}

		}, 2000, 30);
	}

	// Getter / Setter

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

	public BufferedImage getImage() {
		return image;
	}

	public String getText() {
		return text;
	}

	public boolean isVisible() {
		return visible;
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

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

}
