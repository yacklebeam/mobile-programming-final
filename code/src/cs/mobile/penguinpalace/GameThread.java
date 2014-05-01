package cs.mobile.penguinpalace;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameThread extends Thread {
	
	private boolean is_running;
	private SurfaceHolder sh;
	private GamePanel gp;
	
	public GameThread(SurfaceHolder shin, GamePanel gpin) {
		this.is_running = false;
		this.gp = gpin;
		this.sh = shin;
	}
	
	public void setGameRun(boolean run) {
		this.is_running = run;
	}
	
	public void run() {
		Canvas canvas;
		while (this.is_running) {
			canvas = null;
			try {
				canvas = this.sh.lockCanvas();
				synchronized (sh) {
					this.gp.update();
					this.gp.render(canvas);
				}
			} finally {
				if (canvas != null) {
					sh.unlockCanvasAndPost(canvas);
				}
			}
		}
	}
}
