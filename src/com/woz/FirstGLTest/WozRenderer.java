package com.woz.FirstGLTest;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import com.woz.FirstGLTest.shapes.*;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class WozRenderer implements Renderer {

	private Triangle _triangle;

	@Override
	public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
		GLES20.glClearColor(0.2f, 0.2f, 0.2f, 1f);

		_triangle = new Triangle();
	}

	@Override
	public void onDrawFrame(GL10 gl10) {
		GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
		_triangle.draw();
	}

	@Override
	public void onSurfaceChanged(GL10 gl10, int width, int height) {
		GLES20.glViewport(0, 0, width, height);
	}

	public static int loadShader(int type, String shaderCode) {

		int shader = GLES20.glCreateShader(type);

		GLES20.glShaderSource(shader, shaderCode);
		GLES20.glCreateShader(shader);

		return shader;
	}
}
