package tv.danmaku.ijk.media.player.render.cache;

import android.opengl.GLES20;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.android.log.BLog;
import tv.danmaku.ijk.media.player.render.core.BiliPixelBuffer;
import tv.danmaku.ijk.media.player.render.core.BiliRenderContext;
import tv.danmaku.ijk.media.player.render.core.BiliVertexBuffer;
import tv.danmaku.ijk.media.player.render.tools.ArrayHelper;
import tv.danmaku.ijk.media.player.render.tools.BiliSize;

public class BiliEGLBufferCache {
    private static final String TAG = "BiliEGLBufferCache";
    private final List<BiliVertexBuffer> mVBOCaches = new ArrayList();
    private final List<BiliPixelBuffer> mPBOCaches = new ArrayList();
    private final List<Integer> mRecycle = new ArrayList();

    public BiliVertexBuffer fetchVertexbuffer(FloatBuffer buffer) {
        clearRecycle();
        if (buffer == null) {
            return null;
        }
        BiliVertexBuffer vbo = new BiliVertexBuffer(buffer);
        this.mVBOCaches.add(vbo);
        return vbo;
    }

    public void recycleVertexbuffer(BiliVertexBuffer vbo) {
        if (vbo == null) {
            return;
        }
        this.mVBOCaches.remove(vbo);
        appendRecycle(vbo);
        if (vbo.getEglContext().equalsCurrent()) {
            clearRecycle();
        }
    }

    public BiliPixelBuffer fetchPixelBuffer(BiliSize size, int total) {
        clearRecycle();
        if (size == null || !size.isSize() || total < 1) {
            return null;
        }
        BiliPixelBuffer pbo = new BiliPixelBuffer(size, total);
        this.mPBOCaches.add(pbo);
        return pbo;
    }

    public void recyclePixelbuffer(BiliPixelBuffer pbo) {
        if (pbo == null) {
            return;
        }
        this.mPBOCaches.remove(pbo);
        appendRecycle(pbo);
        if (pbo.getEglContext().equalsCurrent()) {
            clearRecycle();
        }
    }

    private void appendRecycle(BiliVertexBuffer vbo) {
        if (vbo == null) {
            return;
        }
        vbo.flagDestroy();
        if (vbo.getVertexbuffer() == 0 || this.mRecycle.contains(Integer.valueOf(vbo.getVertexbuffer()))) {
            return;
        }
        this.mRecycle.add(Integer.valueOf(vbo.getVertexbuffer()));
    }

    private void appendRecycle(BiliPixelBuffer pbo) {
        if (pbo == null) {
            return;
        }
        pbo.flagDestroy();
        if (pbo.getPixelbuffers() == null) {
            return;
        }
        int j = pbo.getPixelbuffers().length;
        for (int i = 0; i < j; i++) {
            if (this.mRecycle.contains(Integer.valueOf(pbo.getPixelbuffers()[i]))) {
                this.mRecycle.add(Integer.valueOf(pbo.getPixelbuffers()[i]));
            }
        }
    }

    public void clearRecycle() {
        if (this.mRecycle.size() < 1) {
            return;
        }
        int[] temps = ArrayHelper.toIntArray(this.mRecycle);
        this.mRecycle.clear();
        GLES20.glDeleteBuffers(temps.length, temps, 0);
    }

    public void destroy() {
        for (BiliVertexBuffer item : this.mVBOCaches) {
            appendRecycle(item);
        }
        this.mVBOCaches.clear();
        for (BiliPixelBuffer item2 : this.mPBOCaches) {
            appendRecycle(item2);
        }
        this.mPBOCaches.clear();
        clearRecycle();
        BLog.i(TAG, String.format("%s destory() %s|%s", getClass().getSimpleName(), this, BiliRenderContext.currentEGLContext()));
    }
}