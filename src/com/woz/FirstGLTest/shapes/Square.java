package com.woz.FirstGLTest.shapes;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class Square {
	private FloatBuffer _vertexBuffer;
	private ShortBuffer _drawListBuffer;

	private static final int COORDS_PER_VERTEX = 3;
	private static float _squareCoords[];
	private short _drawOrder[];

	public Square() {
		_squareCoords = new float[] {
				-0.5f,  0.5f, 0.0f,
				-0.5f, -0.5f, 0.0f,
				 0.5f, -0.5f, 0.0f,
				 0.5f,  0.5f, 0.0f,
		};

		_drawOrder = new short[] { 0, 1, 2, 0, 2, 3 };

		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_squareCoords.length * 4);
		byteBuffer.order(ByteOrder.nativeOrder());
		_vertexBuffer = byteBuffer.asFloatBuffer();
		_vertexBuffer.put(_squareCoords);
		_vertexBuffer.position(0);

		ByteBuffer drawListBuffer = ByteBuffer.allocateDirect(_drawOrder.length * 2);
		drawListBuffer.order(ByteOrder.nativeOrder());
		_drawListBuffer = drawListBuffer.asShortBuffer();
		_drawListBuffer.put(_drawOrder);
		_drawListBuffer.position(0);
	}


}
