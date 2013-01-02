package com.woz.FirstGLTest;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import com.woz.FirstGLTest.shapes.*;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class WozRenderer implements Renderer {

	private Triangle _triangle;

	@Override
	public void onSurfaceCreated(GL10 unused, EGLConfig config) {

		// Set the background frame color
		GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

		_triangle = new Triangle();
	}

	@Override
	public void onDrawFrame(GL10 unused) {

		// Draw background color
		GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);

		// Draw triangle
		_triangle.draw();
	}

	@Override
	public void onSurfaceChanged(GL10 unused, int width, int height) {
		// Adjust the viewport based on geometry changes,
		// such as screen rotation
		GLES20.glViewport(0, 0, width, height);
	}

	public static int loadShader(int type, String shaderCode) {

		int shader = GLES20.glCreateShader(type);

		GLES20.glShaderSource(shader, shaderCode);
		GLES20.glCompileShader(shader);

		return shader;


	}
}
