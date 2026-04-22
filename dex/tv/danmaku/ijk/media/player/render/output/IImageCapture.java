package tv.danmaku.ijk.media.player.render.output;

import android.graphics.Bitmap;
import javax.microedition.khronos.egl.EGLContext;
import tv.danmaku.ijk.media.player.render.core.BiliFrameBuffer;
import tv.danmaku.ijk.media.player.render.tools.BiliSize;
import tv.danmaku.ijk.media.player.render.transform.BiliMVPMatrix;

public interface IImageCapture {

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnCaptureFrameAvailableListener {
        void onCaptureFrameAvailable(Bitmap bitmap);
    }

    void captureOneImage();

    BiliMVPMatrix getMatrix();

    BiliSize getSurfaceSize();

    void prepare();

    void prepare(EGLContext eGLContext);

    void prepare(EGLContext eGLContext, int i);

    void release();

    void setCaptureFrameAvailableListener(OnCaptureFrameAvailableListener onCaptureFrameAvailableListener);

    void setInputFrameBuffer(BiliFrameBuffer biliFrameBuffer);

    void setInputImageSize(int i, int i2);

    void setSurfaceSize(int i, int i2);

    void setSurfaceTextureMatrix(float[] fArr);
}