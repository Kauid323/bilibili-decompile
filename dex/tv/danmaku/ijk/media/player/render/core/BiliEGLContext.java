package tv.danmaku.ijk.media.player.render.core;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

public class BiliEGLContext {
    private static final String TAG = "BiliEGLContext";
    private EGLContext mEGLContext = currentEGLContext();
    private long mThreadID = Thread.currentThread().getId();
    private String mHashKey = String.format("%s", this.mEGLContext);

    public EGLContext getEGLContext() {
        return this.mEGLContext;
    }

    public long getThreadID() {
        return this.mThreadID;
    }

    public String getHashKey() {
        return this.mHashKey;
    }

    public boolean equalsCurrent() {
        return this.mEGLContext.equals(currentEGLContext()) && this.mThreadID == Thread.currentThread().getId();
    }

    public boolean equalsCurrentThread() {
        return this.mThreadID == Thread.currentThread().getId();
    }

    public static boolean equalsCurrent(EGLContext eglContext) {
        if (eglContext == null) {
            return false;
        }
        return eglContext.equals(currentEGLContext());
    }

    public static EGLContext currentEGLContext() {
        EGL10 mEGL = (EGL10) EGLContext.getEGL();
        EGLContext eglContext = mEGL.eglGetCurrentContext();
        return eglContext;
    }

    public static GL10 currentGL() {
        EGLContext context = currentEGLContext();
        if (context == null || context == EGL10.EGL_NO_CONTEXT) {
            return null;
        }
        return (GL10) context.getGL();
    }

    public static String currentHashKey() {
        return currentHashKey(currentEGLContext());
    }

    public static String currentHashKey(EGLContext eglContext) {
        return String.format("%s", eglContext);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BiliEGLContext)) {
            return false;
        }
        BiliEGLContext input = (BiliEGLContext) obj;
        return this.mEGLContext == input.mEGLContext && this.mThreadID == input.mThreadID;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(TAG).append("{");
        sb.append("EGL: ").append(this.mEGLContext).append(", ");
        sb.append("Thread: ").append(this.mThreadID).append(", ");
        sb.append("Current EGL: ").append(currentEGLContext()).append(",");
        sb.append("Current Thread: ").append(Thread.currentThread().getId()).append(",");
        sb.append("}");
        return sb.toString();
    }
}