package tv.danmaku.ijk.media.player.render.core;

import android.opengl.GLES30;
import android.os.Build;
import java.nio.Buffer;
import tv.danmaku.android.log.BLog;
import tv.danmaku.ijk.media.player.render.tools.BiliSize;

public class BiliPixelBuffer {
    public static final String TAG = "BiliPixelBuffer";
    private int[] mArgs;
    private int mBufferLength;
    private BiliEGLContext mEglContext;
    private int[] mPixelbuffers;
    private int mRowStride;
    private BiliSize mSize;
    private final int PIXELBUFFERS_ALIGN_LENGTH = 128;
    private int mIndex = 0;
    private boolean mDestroied = false;

    public int[] getPixelbuffers() {
        return this.mPixelbuffers;
    }

    public BiliEGLContext getEglContext() {
        return this.mEglContext;
    }

    public int length() {
        return this.mBufferLength;
    }

    public BiliSize getSize() {
        return this.mSize;
    }

    public void flagDestroy() {
        this.mDestroied = true;
    }

    public BiliPixelBuffer(BiliSize size, int total) {
        this.mBufferLength = 0;
        this.mRowStride = 0;
        if (size == null || !size.isSize() || total < 1) {
            return;
        }
        this.mSize = size;
        this.mEglContext = new BiliEGLContext();
        this.mRowStride = ((this.mSize.getWidth() * 4) + 127) & (-128);
        this.mBufferLength = this.mRowStride * this.mSize.getHeight();
        this.mPixelbuffers = new int[total];
        GLES30.glGenBuffers(total, this.mPixelbuffers, 0);
        for (int i = 0; i < this.mPixelbuffers.length; i++) {
            GLES30.glBindBuffer(34962, this.mPixelbuffers[i]);
            GLES30.glBufferData(34962, this.mBufferLength, null, 35049);
        }
        GLES30.glBindBuffer(34962, 0);
    }

    public void bindPackIndex(int index) {
        if (this.mPixelbuffers == null || index >= this.mPixelbuffers.length) {
            BLog.e(TAG, String.format("%s bindPackIndex faile[%d]: %s", TAG, Integer.valueOf(index), this.mPixelbuffers));
        } else {
            GLES30.glBindBuffer(35051, this.mPixelbuffers[index]);
        }
    }

    public void disablePackBuffer() {
        GLES30.glBindBuffer(35051, 0);
    }

    public void preparePackBuffer() {
        if (Build.VERSION.SDK_INT < 24 || this.mPixelbuffers == null || this.mBufferLength < 128 || this.mDestroied) {
            return;
        }
        next();
        GLES30.glBindBuffer(35051, this.mArgs[5]);
        GLES30.glReadPixels(0, 0, this.mArgs[3], this.mArgs[4], 6408, 5121, 0);
        disablePackBuffer();
    }

    public Buffer readPackBuffer() {
        if (this.mPixelbuffers == null || this.mBufferLength < 128 || this.mDestroied || this.mArgs == null || this.mArgs[0] == 0) {
            return null;
        }
        GLES30.glBindBuffer(35051, this.mArgs[6]);
        Buffer buffer = GLES30.glMapBufferRange(35051, 0, this.mBufferLength, 1);
        if (buffer == null) {
            BLog.w(TAG, String.format("%s readPackBuffer can not read data.", TAG));
            return null;
        }
        GLES30.glUnmapBuffer(35051);
        disablePackBuffer();
        return buffer;
    }

    public void next() {
        if (this.mDestroied || this.mPixelbuffers == null) {
            return;
        }
        if (this.mArgs == null) {
            this.mArgs = new int[7];
            this.mArgs[0] = 0;
            this.mArgs[1] = this.mBufferLength;
            this.mArgs[2] = this.mRowStride;
            this.mArgs[3] = this.mSize.getHeight();
            this.mArgs[4] = this.mSize.getHeight();
        } else {
            this.mArgs[0] = 1;
        }
        this.mIndex %= this.mPixelbuffers.length;
        this.mArgs[5] = this.mPixelbuffers[this.mIndex];
        this.mArgs[6] = this.mPixelbuffers[(this.mIndex + 1) % this.mPixelbuffers.length];
        this.mIndex++;
    }
}