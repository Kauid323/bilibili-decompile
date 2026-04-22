package tv.danmaku.ijk.media.player.render;

import android.opengl.GLES20;
import android.view.Surface;
import tv.danmaku.android.log.BLog;
import tv.danmaku.ijk.media.player.render.core.BiliWindowSurface;
import tv.danmaku.ijk.media.player.render.core.EglCore;
import tv.danmaku.ijk.media.player.render.tools.BiliSize;

public class IjkNativeWindowHelper {
    public static final String IJK_WINDOW_HEIGHT = "NHeight";
    public static final String IJK_WINDOW_WIDTH = "NWidth";
    private static final String TAG = "IjkNativeWindowHelper";
    private static float mBackgroundColorAlpha = 1.0f;
    private static float mBackgroundColorBlue;
    private static float mBackgroundColorGreen;
    private static float mBackgroundColorRed;

    private static native int _nativeGetSurfaceHeight(Surface surface);

    private static native int _nativeGetSurfaceWidth(Surface surface);

    public static BiliSize getNativeWindowSize(Surface surface) {
        int width = _nativeGetSurfaceWidth(surface);
        int height = _nativeGetSurfaceHeight(surface);
        return BiliSize.create(width, height);
    }

    public static void flushSurface(Surface surface) {
        if (surface == null || !surface.isValid()) {
            return;
        }
        try {
            EglCore core = new EglCore();
            BiliWindowSurface windowSurface = new BiliWindowSurface(core, surface, false);
            windowSurface.makeCurrent();
            GLES20.glClearColor(mBackgroundColorRed, mBackgroundColorGreen, mBackgroundColorBlue, mBackgroundColorAlpha);
            GLES20.glClear(16640);
            windowSurface.swapBuffers();
            GLES20.glFinish();
            core.makeNothingCurrent();
            windowSurface.release();
            core.release();
        } catch (Exception e) {
            BLog.e(TAG, e);
        }
    }

    public static void setBackgroundColor(float red, float green, float blue, float alpha) {
        mBackgroundColorRed = red;
        mBackgroundColorGreen = green;
        mBackgroundColorBlue = blue;
        mBackgroundColorAlpha = alpha;
    }

    public static int getSurfaceWidth(Surface surface) {
        return _nativeGetSurfaceWidth(surface);
    }

    public static int getSurfaceHeight(Surface surface) {
        return _nativeGetSurfaceHeight(surface);
    }
}