package tv.danmaku.ijk.media.player.render.core;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

public class BiliVertexBuffer {
    public static final String TAG = "BiliVertexBuffer";
    private FloatBuffer mBuffer;
    private boolean mDestoried = false;
    private BiliEGLContext mEglContext;
    private int mVertexbuffer;

    public int getVertexbuffer() {
        return this.mVertexbuffer;
    }

    public BiliEGLContext getEglContext() {
        return this.mEglContext;
    }

    public int length() {
        if (this.mBuffer == null) {
            return 0;
        }
        return this.mBuffer.limit();
    }

    public void flagDestroy() {
        this.mDestoried = true;
    }

    public BiliVertexBuffer(FloatBuffer buffer) {
        this.mVertexbuffer = 0;
        if (buffer == null) {
            return;
        }
        this.mBuffer = buffer;
        this.mEglContext = new BiliEGLContext();
        int[] temp = new int[1];
        GLES20.glGenBuffers(1, temp, 0);
        this.mVertexbuffer = temp[0];
        GLES20.glBindBuffer(34962, this.mVertexbuffer);
        GLES20.glBufferData(34962, this.mBuffer.limit() * 4, buffer, 35048);
    }

    public void fresh(int offset, int length) {
        fresh(offset, length, this.mBuffer);
    }

    public void fresh(int offset, int length, FloatBuffer buffer) {
        if (buffer == null) {
            buffer = this.mBuffer;
        }
        GLES20.glBindBuffer(34962, this.mVertexbuffer);
        GLES20.glBufferSubData(34962, offset * 4, length * 4, buffer);
    }

    public void activateVertexbuffer() {
        GLES20.glBindBuffer(34962, this.mVertexbuffer);
    }

    public void disableVertexbuffer() {
        GLES20.glBindBuffer(34962, 0);
    }

    public void destory() {
        if (this.mDestoried) {
            return;
        }
        this.mDestoried = true;
    }

    public void deleteBuffer() {
        int[] temps = {this.mVertexbuffer};
        GLES20.glDeleteBuffers(temps.length, temps, 0);
    }

    protected void finalize() throws Throwable {
        destory();
        super.finalize();
    }
}