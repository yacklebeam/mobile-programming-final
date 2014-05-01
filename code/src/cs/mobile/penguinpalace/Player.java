package cs.mobile.penguinpalace;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Player {
	private Bitmap sprite;
	private int x;
	private int y;
	
	public Player(Bitmap bitmap, int x, int y) {
		this.sprite = bitmap;
		this.x = x;
		this.y = y;
	}
	
	public void update (float val) {
		this.x += (int)val;
	}
	
	public void render(Canvas canvas) {
		canvas.drawBitmap(sprite, x - (sprite.getWidth() / 2), y - (sprite.getHeight() / 2), null);
	}
}
