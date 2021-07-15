package GUI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import teko.ss.BitcoinMain;

public class IL {

	public BufferedImage ibg;
	public BufferedImage iup[] = new BufferedImage[BitcoinMain.anzahlUpgrade];
	public BufferedImage ibitcoin1, ibitcoin2;
	public BufferedImage iachievement[] = new BufferedImage[BitcoinMain.achievementAnzahl];
		
	
	public IL() {
		
		try {
			// Background
			ibg = ImageIO.read(new File("rsc/bg.png"));
			
			// Coin
			ibitcoin1 = ImageIO.read(new File("rsc/bitcoin1.png"));
			ibitcoin2 = ImageIO.read(new File("rsc/bitcoin2.png"));
			
			// Upgrades
			for(int i = 0; i < iup.length; i++) {
				iup[i] = ImageIO.read(new File("rsc/up" + (i+1) + ".png"));
			}
			
			for(int i = 0; i < iachievement.length; i++) {
				iachievement[i] = ImageIO.read(new File("rsc/achievement" + (i+1) + ".png"));
			}
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
