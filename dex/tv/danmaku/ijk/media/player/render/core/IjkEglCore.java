package tv.danmaku.ijk.media.player.render.core;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.GLES30;
import android.text.TextUtils;
import android.view.Surface;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import tv.danmaku.android.log.BLog;

public final class IjkEglCore {
    private static final String EGL_EXT_gl_colorspace_bt2020_pq = "EGL_EXT_gl_colorspace_bt2020_pq";
    public static final int EGL_GL_COLORSPACE = 12445;
    public static final int EGL_GL_COLORSPACE_BT2020_PQ_EXT = 13120;
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final int FLAG_RECORDABLE = 1;
    public static final int FLAG_TRY_GLES3 = 2;
    private static final String GL_OES_EGL_image_external_essl3 = "GL_OES_EGL_image_external_essl3";
    private static final String TAG = "IjkEgl";
    private int EGL_CONTEXT_CLIENT_VERSION;
    private boolean isOpenHDR;
    private EGLConfig mEGLConfig;
    private EGLContext mEGLContext;
    private EGLDisplay mEGLDisplay;
    private EGL10 mEgl;
    private int mGlVersion;

    public IjkEglCore() {
        this(null, 2);
    }

    public IjkEglCore(IjkEglCore sharedContext, int flags) {
        EGLConfig config;
        this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        this.mEGLDisplay = EGL10.EGL_NO_DISPLAY;
        this.mEGLContext = EGL10.EGL_NO_CONTEXT;
        this.mEGLConfig = null;
        this.mGlVersion = -1;
        this.mEgl = (EGL10) EGLContext.getEGL();
        if (this.mEGLDisplay != EGL10.EGL_NO_DISPLAY) {
            BLog.e("IjkEgl", "EGL already set up");
        }
        if (sharedContext == null) {
            this.mEGLContext = EGL10.EGL_NO_CONTEXT;
        } else {
            this.mEGLContext = sharedContext.mEGLContext;
        }
        this.mEGLDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.mEGLDisplay == EGL10.EGL_NO_DISPLAY) {
            BLog.e("IjkEgl", "unable to get EGL14 display");
        }
        int[] version = new int[2];
        if (!this.mEgl.eglInitialize(this.mEGLDisplay, version)) {
            this.mEGLDisplay = null;
            BLog.e("IjkEgl", "unable to initialize EGL14");
        }
        if ((flags & 2) != 0 && (config = getConfig(flags, 3)) != null) {
            int[] attrib3_list = {this.EGL_CONTEXT_CLIENT_VERSION, 3, 12344};
            EGLContext context = this.mEgl.eglCreateContext(this.mEGLDisplay, config, this.mEGLContext, attrib3_list);
            if (this.mEgl.eglGetError() == 12288) {
                this.mEGLConfig = config;
                this.mEGLContext = context;
                this.mGlVersion = 3;
            }
        }
        if (this.mEGLContext == EGL10.EGL_NO_CONTEXT) {
            EGLConfig config2 = getConfig(flags, 2);
            if (config2 == null) {
                BLog.e("IjkEgl", "Unable to find a suitable EGLConfig");
            }
            int[] attrib2_list = {this.EGL_CONTEXT_CLIENT_VERSION, 2, 12344};
            EGLContext context2 = this.mEgl.eglCreateContext(this.mEGLDisplay, config2, this.mEGLContext, attrib2_list);
            checkEglError("eglCreateContext");
            this.mEGLConfig = config2;
            this.mEGLContext = context2;
            this.mGlVersion = 2;
        }
        int[] values = new int[1];
        this.mEgl.eglQueryContext(this.mEGLDisplay, this.mEGLContext, 12440, values);
        BLog.i("IjkEgl", "EGLContext created, client version " + values[0]);
    }

    public IjkEglCore(EGLContext context, EGLDisplay display, String version) {
        this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        this.mEGLDisplay = EGL10.EGL_NO_DISPLAY;
        this.mEGLContext = EGL10.EGL_NO_CONTEXT;
        this.mEGLConfig = null;
        this.mGlVersion = -1;
        this.mEGLContext = context;
        this.mEGLDisplay = display;
        this.mGlVersion = Double.valueOf(version).doubleValue() > 3.0d ? 3 : 2;
    }

    private EGLConfig getConfig(int flags, int version) {
        int renderableType = version >= 3 ? 4 | 64 : 4;
        int[] attribList = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, renderableType, 12344, 0, 12344};
        EGLConfig[] configs = new EGLConfig[1];
        int[] numConfig = new int[1];
        if (!this.mEgl.eglChooseConfig(this.mEGLDisplay, attribList, configs, configs.length, numConfig)) {
            BLog.e("IjkEgl", "unable to find RGB8888 / " + version + " EGLConfig");
            return null;
        }
        return configs[0];
    }

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public void release() {
        if (this.mEGLDisplay != EGL10.EGL_NO_DISPLAY) {
            this.mEgl.eglMakeCurrent(this.mEGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            this.mEgl.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
            EGL14.eglReleaseThread();
            this.mEgl.eglTerminate(this.mEGLDisplay);
        }
        this.mEGLDisplay = EGL10.EGL_NO_DISPLAY;
        this.mEGLContext = EGL10.EGL_NO_CONTEXT;
        this.mEGLConfig = null;
    }

    public void releaseSurface(EGLSurface eglSurface) {
        this.mEgl.eglDestroySurface(this.mEGLDisplay, eglSurface);
    }

    public EGLSurface createWindowSurface(Object surface) {
        if (!(surface instanceof Surface) && !(surface instanceof SurfaceTexture)) {
            BLog.e("IjkEgl", "invalid surface: " + surface);
            return EGL10.EGL_NO_SURFACE;
        } else if ((surface instanceof Surface) && !((Surface) surface).isValid()) {
            BLog.e("IjkEgl", "invalid surface: " + surface);
            return EGL10.EGL_NO_SURFACE;
        } else {
            int[] surfaceAttribs = {12344, 12344, 12344};
            if (this.isOpenHDR && supportBT202PQ()) {
                surfaceAttribs[0] = 12445;
                surfaceAttribs[1] = 13120;
            }
            EGLSurface eglSurface = this.mEgl.eglCreateWindowSurface(this.mEGLDisplay, this.mEGLConfig, surface, surfaceAttribs);
            checkEglError("eglCreateWindowSurface");
            if (eglSurface == null) {
                BLog.e("IjkEgl", "surface was null");
                return EGL10.EGL_NO_SURFACE;
            }
            return eglSurface;
        }
    }

    public EGLSurface createOffscreenSurface(int width, int height) {
        int[] surfaceAttribs = {12375, width, 12374, height, 12344};
        EGLSurface eglSurface = this.mEgl.eglCreatePbufferSurface(this.mEGLDisplay, this.mEGLConfig, surfaceAttribs);
        checkEglError("eglCreatePbufferSurface");
        if (eglSurface == null) {
            BLog.e("IjkEgl", "surface was null");
        }
        return eglSurface;
    }

    public boolean makeCurrent(EGLSurface eglSurface) {
        if (this.mEGLDisplay == EGL10.EGL_NO_DISPLAY) {
            BLog.e("IjkEgl", "NOTE: makeCurrent w/o display");
            return false;
        } else if (!this.mEgl.eglMakeCurrent(this.mEGLDisplay, eglSurface, eglSurface, this.mEGLContext)) {
            BLog.e("IjkEgl", "eglMakeCurrent failed");
            return false;
        } else {
            return true;
        }
    }

    public boolean makeCurrent(EGLSurface drawSurface, EGLSurface readSurface) {
        if (this.mEGLDisplay == EGL10.EGL_NO_DISPLAY) {
            BLog.e("IjkEgl", "NOTE: makeCurrent w/o display");
            return false;
        } else if (!this.mEgl.eglMakeCurrent(this.mEGLDisplay, drawSurface, readSurface, this.mEGLContext)) {
            BLog.e("IjkEgl", "eglMakeCurrent(draw,read) failed");
            return false;
        } else {
            return true;
        }
    }

    public void makeNothingCurrent() {
        if (this.mEGLDisplay != EGL10.EGL_NO_DISPLAY && !this.mEgl.eglMakeCurrent(this.mEGLDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT)) {
            BLog.e("IjkEgl", "eglMakeCurrent failed");
        }
    }

    public boolean swapBuffers(EGLSurface eglSurface) {
        if (this.mEGLDisplay == EGL10.EGL_NO_DISPLAY) {
            BLog.w("IjkEgl", "EGLDisplay is EGL_NO_DISPLAY !");
            return false;
        } else if (this.mEgl.eglGetCurrentContext() == EGL10.EGL_NO_CONTEXT) {
            BLog.w("IjkEgl", "Current Context is EGL_NO_CONTEXT !");
            return false;
        } else {
            return this.mEgl.eglSwapBuffers(this.mEGLDisplay, eglSurface);
        }
    }

    public boolean isCurrent(EGLSurface eglSurface) {
        return this.mEGLContext.equals(this.mEgl.eglGetCurrentContext()) && eglSurface.equals(this.mEgl.eglGetCurrentSurface(12377));
    }

    public int querySurface(EGLSurface eglSurface, int what) {
        int[] value = new int[1];
        this.mEgl.eglQuerySurface(this.mEGLDisplay, eglSurface, what, value);
        return value[0];
    }

    public String queryString(int what) {
        return this.mEgl.eglQueryString(this.mEGLDisplay, what);
    }

    public int getGlVersion() {
        return this.mGlVersion;
    }

    public static void logCurrent(String msg) {
        EGL10 egl = (EGL10) EGLContext.getEGL();
        EGLDisplay display = egl.eglGetCurrentDisplay();
        EGLContext context = egl.eglGetCurrentContext();
        EGLSurface surface = egl.eglGetCurrentSurface(12377);
        BLog.e("IjkEgl", "Current EGL (" + msg + "): display=" + display + ", context=" + context + ", surface=" + surface);
    }

    private void checkEglError(String msg) {
        int error = this.mEgl.eglGetError();
        if (error != 12288) {
            BLog.e("IjkEgl", "[PlayProblem] " + msg + ": ijkExternalRenderError=eglError 0x" + Integer.toHexString(error));
        }
    }

    public boolean supportBT202PQ() {
        boolean support = false;
        String extensions = queryString(12373);
        String[] result = extensions.split(" ");
        for (String s : result) {
            if (!TextUtils.isEmpty(s) && EGL_EXT_gl_colorspace_bt2020_pq.toLowerCase().trim().equals(s.toLowerCase().trim())) {
                support = true;
            }
        }
        return support;
    }

    public boolean supportExternal_essl3() {
        boolean support = false;
        String extensions = GLES30.glGetString(7939);
        String[] result = extensions.split(" ");
        for (String s : result) {
            if (!TextUtils.isEmpty(s) && GL_OES_EGL_image_external_essl3.toLowerCase().trim().equals(s.toLowerCase().trim())) {
                support = true;
            }
        }
        BLog.i("IjkEgl", "supportExternal_essl3:" + support);
        return support;
    }

    protected void finalize() throws Throwable {
        try {
            if (this.mEGLDisplay != EGL10.EGL_NO_DISPLAY) {
                BLog.w("IjkEgl", "WARNING: EglCore was not explicitly released -- state may be leaked");
                release();
            }
        } finally {
            super.finalize();
        }
    }

    public void setNeedOpenHDR(boolean enable) {
        this.isOpenHDR = enable;
    }

    public boolean isNeedOpenHDR() {
        return this.isOpenHDR;
    }
}