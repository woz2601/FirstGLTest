package com.woz.FirstGLTest;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created: Woz
 * Date: 1/2/13 *
 */

public class WozGLSurfaceView extends GLSurfaceView {

	public WozGLSurfaceView(Context context) {
		super(context);

		setEGLContextClientVersion(2);
		setRenderer(new WozRenderer());

		setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
	}
}
