package cs.mobile.penguinpalace;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;

public class StartScreen extends Activity {
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_screen);

		findViewById(R.id.play_button).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent play_game = new Intent(getApplicationContext(), GameActivity.class);
				startActivity(play_game);
			}
		});
	}
}
