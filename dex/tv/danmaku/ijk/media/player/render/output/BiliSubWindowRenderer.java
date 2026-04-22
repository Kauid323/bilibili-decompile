package tv.danmaku.ijk.media.player.render.output;

import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import javax.microedition.khronos.egl.EGLContext;
import tv.danmaku.android.log.BLog;
import tv.danmaku.ijk.media.player.render.core.BiliWindowSurface;
import tv.danmaku.ijk.media.player.render.core.EglCore;
import tv.danmaku.ijk.media.player.render.core.GlUtil;

public class BiliSubWindowRenderer {
    private static final String TAG = "BiliSubWindowRenderer";
    private EglCore mGLCore;
    private Handler mRenderHandler;
    private HandlerThread mRenderThread;
    private Surface mSurface;
    private BiliWindowSurface mWindowSurface;

    public void prepare(final EGLContext shareEGLContext) {
        BLog.i(TAG, "prepare()");
        this.mRenderThread = new HandlerThread("ijk_sub_render");
        this.mRenderThread.start();
        this.mRenderHandler = new Handler(this.mRenderThread.getLooper());
        this.mRenderHandler.post(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.output.BiliSubWindowRenderer.1
            @Override // java.lang.Runnable
            public void run() {
                if (BiliSubWindowRenderer.this.mWindowSurface != null) {
                    BiliSubWindowRenderer.this.mWindowSurface.release();
                    BiliSubWindowRenderer.this.mWindowSurface = null;
                    BiliSubWindowRenderer.this.mSurface = null;
                }
                if (BiliSubWindowRenderer.this.mGLCore != null) {
                    BiliSubWindowRenderer.this.mGLCore.release();
                }
                BiliSubWindowRenderer.this.mGLCore = new EglCore(shareEGLContext, 2);
            }
        });
        BLog.i(TAG, "prepare() end()");
    }

    public void setSurface(final Surface surface) {
        BLog.i(TAG, "setSurface() " + surface);
        this.mRenderHandler.post(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.output.BiliSubWindowRenderer.2
            @Override // java.lang.Runnable
            public void run() {
                if (BiliSubWindowRenderer.this.mSurface != null && BiliSubWindowRenderer.this.mSurface != surface && BiliSubWindowRenderer.this.mWindowSurface != null) {
                    BiliSubWindowRenderer.this.mWindowSurface.release();
                    BiliSubWindowRenderer.this.mWindowSurface = null;
                    BiliSubWindowRenderer.this.mSurface = null;
                    BLog.i(BiliSubWindowRenderer.TAG, "release pre window surface");
                }
                if (surface == null || !surface.isValid()) {
                    BLog.i(BiliSubWindowRenderer.TAG, "set surface is null or invalid : " + surface);
                    if (BiliSubWindowRenderer.this.mWindowSurface != null) {
                        BiliSubWindowRenderer.this.mWindowSurface.release();
                        BiliSubWindowRenderer.this.mWindowSurface = null;
                        BLog.i(BiliSubWindowRenderer.TAG, "mWindowSurface released");
                    }
                } else if (BiliSubWindowRenderer.this.mSurface != null && BiliSubWindowRenderer.this.mSurface.equals(surface)) {
                    BLog.i(BiliSubWindowRenderer.TAG, "equal surface!" + surface);
                } else {
                    BiliSubWindowRenderer.this.mWindowSurface = new BiliWindowSurface(BiliSubWindowRenderer.this.mGLCore, surface, false);
                    BiliSubWindowRenderer.this.mSurface = surface;
                    BiliSubWindowRenderer.this.mWindowSurface.makeCurrent();
                    GlUtil.checkGlError("BiliSubWindowRenderer makeCurrent()");
                    BLog.i(BiliSubWindowRenderer.TAG, "create surface and attach:" + surface);
                }
            }
        });
        BLog.i(TAG, "setSurface() " + surface + " end()");
    }

    public void renderTextureWidthRect(final Runnable runnable) {
        this.mRenderHandler.post(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.output.BiliSubWindowRenderer.3
            @Override // java.lang.Runnable
            public void run() {
                if (BiliSubWindowRenderer.this.mWindowSurface == null) {
                    return;
                }
                if (BiliSubWindowRenderer.this.mSurface == null || !BiliSubWindowRenderer.this.mSurface.isValid()) {
                    BLog.i(BiliSubWindowRenderer.TAG, "set surface is null or invalid : " + BiliSubWindowRenderer.this.mSurface);
                } else if (runnable == null) {
                } else {
                    BiliSubWindowRenderer.this.mWindowSurface.makeCurrent();
                    GlUtil.checkGlError("BiliSubWindowRenderer makeCurrent()");
                    GLES20.glViewport(0, 0, BiliSubWindowRenderer.this.mWindowSurface.getWidth(), BiliSubWindowRenderer.this.mWindowSurface.getHeight());
                    GlUtil.checkGlError("BiliSubWindowRenderer glViewport w:" + BiliSubWindowRenderer.this.mWindowSurface.getWidth() + " h:" + BiliSubWindowRenderer.this.mWindowSurface.getHeight());
                    runnable.run();
                    BiliSubWindowRenderer.this.mWindowSurface.swapBuffers();
                    GlUtil.checkGlError("BiliSubWindowRenderer swapBuffers");
                }
            }
        });
    }

    public void release() {
        BLog.i(TAG, "release()");
        this.mRenderHandler.post(new Runnable() { // from class: tv.danmaku.ijk.media.player.render.output.BiliSubWindowRenderer.4
            @Override // java.lang.Runnable
            public void run() {
                if (BiliSubWindowRenderer.this.mWindowSurface != null) {
                    BiliSubWindowRenderer.this.mWindowSurface.release();
                    BiliSubWindowRenderer.this.mWindowSurface = null;
                    BLog.i(BiliSubWindowRenderer.TAG, "mWindowSurface released");
                }
                if (BiliSubWindowRenderer.this.mGLCore != null) {
                    BiliSubWindowRenderer.this.mGLCore.release();
                    BiliSubWindowRenderer.this.mGLCore = null;
                    BLog.i(BiliSubWindowRenderer.TAG, "mGLCore released");
                }
                BiliSubWindowRenderer.this.mSurface = null;
            }
        });
        BLog.i(TAG, "quitSafely()");
        this.mRenderThread.quitSafely();
        BLog.i(TAG, "quitSafely() end()");
        BLog.i(TAG, "release() end()");
    }
}