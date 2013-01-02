package com.woz.FirstGLTest.shapes;

import android.opengl.GLES20;
import com.woz.FirstGLTest.WozRenderer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class Triangle {

	static final int COORDS_PER_VERTEX = 3;

	static float _triangleCoords[];
	float _color[];

	private final String _vertexShaderCode =
			"attribute vec4 vPosition;" +
					"void main() {" +
					"  gl_Position = vPosition;" +
					"}";
	private final String _fragmentShaderCode =
			"precision mediump float;" +
					"uniform vec4 vColor;" +
					"void main() {" +
					"  gl_FragColor = vColor;" +
					"}";

	private int _positionHandle;

	private final FloatBuffer _vertexBuffer;
	private final int _program;
	private int _colorHandle;
	private final int _vertexCount;
	private final int _vertexStride;

	public Triangle() {
		_triangleCoords = new float[]{
				0.0f,  0.622008459f, 0.0f,
				-0.5f, -0.311004243f, 0.0f,
				0.5f, -0.311004243f, 0.0f,
		};

		_color = new float[] { 0.63671875f, 0.76953125f, 0.22265625f, 1.0f };

		_vertexCount = _triangleCoords.length / COORDS_PER_VERTEX;
		_vertexStride = COORDS_PER_VERTEX * 4;

		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_triangleCoords.length * 4);
		byteBuffer.order(ByteOrder.nativeOrder());

		_vertexBuffer = byteBuffer.asFloatBuffer();
		_vertexBuffer.put(_triangleCoords);
		_vertexBuffer.position(0);

		int vertexShader = WozRenderer.loadShader(GLES20.GL_VERTEX_SHADER, _vertexShaderCode);
		int fragmentShader = WozRenderer.loadShader(GLES20.GL_FRAGMENT_SHADER, _fragmentShaderCode);

		_program = GLES20.glCreateProgram();
		GLES20.glAttachShader(_program, vertexShader);
		GLES20.glAttachShader(_program, fragmentShader);
		GLES20.glLinkProgram(_program);
	}

	public void draw() {
		GLES20.glUseProgram(_program);

		_positionHandle = GLES20.glGetAttribLocation(_program, "vPosition");

		GLES20.glEnableVertexAttribArray(_positionHandle);
		GLES20.glVertexAttribPointer(_positionHandle, COORDS_PER_VERTEX, GLES20.GL_FLOAT, false, _vertexStride, _vertexBuffer);

		_colorHandle = GLES20.glGetUniformLocation(_program, "vColor");

		GLES20.glUniform4fv(_colorHandle, 1, _color, 0);
		GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, _vertexCount);
		GLES20.glDisableVertexAttribArray(_positionHandle);
	}
}
