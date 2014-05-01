package cs.mobile.penguinpalace;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.WindowManager;

public class GameActivity extends Activity implements SensorEventListener {

	private SensorManager _smanager;
	private Sensor _accmeter;
	private GamePanel gp;
	private float x = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		_smanager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		_accmeter= _smanager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		_smanager.registerListener(this, _accmeter, SensorManager.SENSOR_DELAY_NORMAL);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		gp = new GamePanel(this);
		setContentView(gp);
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		x = event.values[0];
		gp.setX(x);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}
}
