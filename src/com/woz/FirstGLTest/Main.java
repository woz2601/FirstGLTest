package com.woz.FirstGLTest;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class Main extends Activity {
	private GLSurfaceView _surfaceView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		_surfaceView = new WozGLSurfaceView(this);

		setContentView(_surfaceView);
	}

	public void onPause() {
		super.onPause();
		_surfaceView.onPause();
	}

	public void onResume() {
		super.onPause();
		_surfaceView.onResume();
	}
}
