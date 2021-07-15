package teko.ss;

import java.util.Timer;
import java.util.TimerTask;

public class BitcoinCounter {

	Timer count;

	public BitcoinCounter() {

		count = new Timer();
		count.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {

				BitcoinMain.bitcoin += BitcoinMain.bps / 100;

			}
		}, 0, 10);

	}

}
