package cs.mobile.penguinpalace;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {

	private GameThread _gthread;
	private float x = 0;
	private Player player;
	
	public GamePanel(Context context) {
		super(context);
		getHolder().addCallback(this);
		_gthread = new GameThread(getHolder(), this);
		setFocusable(true);
	}

	public void surfaceCreated(SurfaceHolder holder) {
		// LOAD LEVEL
		player = new Player(,0,0);
    }
	
	public void startGame() {
        _gthread.setGameRun(true);
		_gthread.start();
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
        boolean shutdown = true;
        while (shutdown) {
            try {
                _gthread.join();
                shutdown = false;
            } catch (InterruptedException e) {
                // do nothing, but keep trying to stop the thread
            }
        }
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
	}
	
	public void update() {
		
	}
	
	public void render(Canvas canvas) {
		canvas.drawColor(Color.BLACK);
		
	}

	public void setX(float x) {
		this.x = x;
	}
}
