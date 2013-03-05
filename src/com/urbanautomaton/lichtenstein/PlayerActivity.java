package com.urbanautomaton.lichtenstein;

import android.annotation.TargetApi;
import android.app.Activity;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class PlayerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player);
		// Show the Up button in the action bar.
		setupActionBar();
		Button button_pause = (Button) findViewById(R.id.button_pause);
		button_pause.setVisibility(View.GONE);
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.player, menu);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void audioPlay(View view) {
		togglePlayPause();
 	}

	public void audioPause(View view) {
		togglePlayPause();
	}
	
	public void audioRewind(View view) {
		
	}
	
	public void audioFastForward(View view) {
		
	}
	
	private void togglePlayPause() {
		Button button_pause = (Button) findViewById(R.id.button_pause);
		Button button_play = (Button) findViewById(R.id.button_play);
		int pause_visibility = button_pause.getVisibility();
		button_pause.setVisibility(button_play.getVisibility());
		button_play.setVisibility(pause_visibility);
	}
	
}
