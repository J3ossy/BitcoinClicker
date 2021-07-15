package teko.ss;

import java.util.Timer;
import java.util.TimerTask;

import GUI.Achievement;
import GUI.AchievementSlider;
import GUI.Gui;

public class AchievementCheck {

	Timer time;

	public AchievementCheck() {

		time = new Timer();
		time.schedule(new TimerTask() {

			@Override
			public void run() {

				// Achievement 1
				if (!Gui.achievement[0].isUnlocked()) {
					if (BitcoinMain.bitcoin >= 1000) {
						unlock(Gui.achievement[0], Gui.achievementSlider[0]);
					}
				}
				
				// Achievement 2
				if (!Gui.achievement[1].isUnlocked()) {
					if (BitcoinMain.bitcoin >= 10000) {
						unlock(Gui.achievement[1], Gui.achievementSlider[1]);
					}
				}
				
				// Achievement 3
				if (!Gui.achievement[2].isUnlocked()) {
					if (BitcoinMain.bitcoin >= 100000) {
						unlock(Gui.achievement[2], Gui.achievementSlider[2]);
					}
				}

				// Achievement 4
				if (!Gui.achievement[3].isUnlocked()) {
					if (BitcoinMain.bitcoin >= 500000) {
						unlock(Gui.achievement[3], Gui.achievementSlider[3]);
					}
				}
				
				// Achievement 5
				if (!Gui.achievement[4].isUnlocked()) {
					if (BitcoinMain.bitcoin >= 2000000) {
						unlock(Gui.achievement[4], Gui.achievementSlider[4]);
					}
				}
				
				// Achievement 6
				if (!Gui.achievement[5].isUnlocked()) {
					if (BitcoinMain.bitcoin >= 10000000) {
						unlock(Gui.achievement[5], Gui.achievementSlider[5]);
					}
				}
				// Achievement 7
				if (!Gui.achievement[6].isUnlocked()) {
					if (BitcoinMain.bitcoin >= 21000000) {
						unlock(Gui.achievement[6], Gui.achievementSlider[6]);
					}
				}
			}
		}, 1000, 1000);
	}

	public static void unlock(Achievement achievement, AchievementSlider slider) {

		achievement.setUnlocked(true);
		slider.setVisible(true);
		AchievementSlider.slideIn(slider);
	}

}
