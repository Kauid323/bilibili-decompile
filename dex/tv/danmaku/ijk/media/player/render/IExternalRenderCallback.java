package tv.danmaku.ijk.media.player.render;

import android.view.Surface;
import tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface;

public interface IExternalRenderCallback {

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface IExternalWindow {
        boolean enableWindowHDR(boolean z);

        void refreshWindow();

        void refreshWindowNow();
    }

    boolean drawFrame(int i, long j);

    IJKEXTRendererInterface.OnFirstFrameListener getOnFirstFrameListener();

    void glesSupportHdrVivid(boolean z);

    void onImageSizeChange(int i, int i2);

    void onSurfaceChange(int i, int i2);

    void onSurfaceCreate(IExternalWindow iExternalWindow, Surface surface, Surface surface2);

    void onSurfaceDestroyed();

    void setBackgroundColor(float f, float f2, float f3, float f4);

    void setSurfaceTextureMatrix(float[] fArr);
}