package tv.danmaku.ijk.media.player.render.core;

import android.opengl.GLES20;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLSurface;
import tv.danmaku.android.log.BLog;

public class IjkEglSurfaceBase {
    protected static final String TAG = "IjkEgl";
    protected IjkEglCore mIjkEglCore;
    private EGLSurface mEGLSurface = EGL10.EGL_NO_SURFACE;
    private int mWidth = -1;
    private int mHeight = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    public IjkEglSurfaceBase(IjkEglCore ijkEglCore) {
        this.mIjkEglCore = ijkEglCore;
    }

    public boolean createWindowSurface(Object surface) {
        if (this.mEGLSurface != EGL10.EGL_NO_SURFACE) {
            BLog.e("IjkEgl", "surface already created");
            return true;
        }
        this.mEGLSurface = this.mIjkEglCore.createWindowSurface(surface);
        if (this.mEGLSurface == EGL10.EGL_NO_SURFACE) {
            BLog.e("IjkEgl", "createWindowSurface failed , eglSurface is EGL_NO_SURFACE !!!");
            return false;
        }
        return true;
    }

    public void setEGLSurface(EGLSurface eglSurface, int width, int height) {
        this.mEGLSurface = eglSurface;
        this.mWidth = width;
        this.mHeight = height;
    }

    public void createOffscreenSurface(int width, int height) {
        if (this.mEGLSurface != EGL10.EGL_NO_SURFACE) {
            BLog.e("IjkEgl", "surface already created");
            return;
        }
        this.mEGLSurface = this.mIjkEglCore.createOffscreenSurface(width, height);
        this.mWidth = width;
        this.mHeight = height;
    }

    public int getWidth() {
        return this.mIjkEglCore.querySurface(this.mEGLSurface, 12375);
    }

    public int getHeight() {
        return this.mIjkEglCore.querySurface(this.mEGLSurface, 12374);
    }

    public void releaseEglSurface() {
        this.mIjkEglCore.releaseSurface(this.mEGLSurface);
        this.mEGLSurface = EGL10.EGL_NO_SURFACE;
        this.mHeight = -1;
        this.mWidth = -1;
        GLES20.glFinish();
    }

    public boolean makeCurrent() {
        if (this.mIjkEglCore == null || this.mEGLSurface == EGL10.EGL_NO_SURFACE) {
            return false;
        }
        return this.mIjkEglCore.makeCurrent(this.mEGLSurface);
    }

    public void makeCurrentReadFrom(IjkEglSurfaceBase readSurface) {
        this.mIjkEglCore.makeCurrent(this.mEGLSurface, readSurface.mEGLSurface);
    }

    public boolean swapBuffers() {
        if (this.mIjkEglCore == null || this.mEGLSurface == EGL10.EGL_NO_SURFACE) {
            BLog.w("IjkEgl", "glCore or Surface is invalid !");
            return false;
        }
        boolean result = this.mIjkEglCore.swapBuffers(this.mEGLSurface);
        if (!result) {
            BLog.e("IjkEgl", "WARNING: swapBuffers() failed");
        }
        return result;
    }
}