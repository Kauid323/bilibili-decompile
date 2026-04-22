package tv.danmaku.ijk.media.player.render.output;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import java.util.List;
import tv.danmaku.ijk.media.player.render.core.BiliImageOrientation;
import tv.danmaku.ijk.media.player.render.output.IImageCapture;
import tv.danmaku.ijk.media.player.render.tools.BiliDaltonizer;
import tv.danmaku.ijk.media.player.render.tools.BiliSize;

public interface IJKEXTRendererInterface {
    public static final int CAPTURE_ALL_APPLAY = 6;
    public static final int CAPTURE_NO_APPLAY = 0;
    public static final int CAPTURE_ONLY_ASPECT_RATIO = 5;
    public static final int CAPTURE_ONLY_MIRROR = 4;
    public static final int CAPTURE_ONLY_ROTATE = 3;
    public static final int CAPTURE_ONLY_SCALE = 1;
    public static final int CAPTURE_ONLY_TRANSLATE = 2;
    public static final int NORMAL = 1;
    public static final int PANORAMA = 2;
    public static final int PANORAMA_GYROSCOPE = 1;
    public static final int PANORAMA_GYROSCOPE_TOUCH = 3;
    public static final int PANORAMA_NONE = 0;
    public static final int PANORAMA_TOUCH = 2;
    public static final int VERTICES_FOR_IMAGE = 0;
    public static final int VERTICES_FOR_INPUT = 1;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnFirstFrameListener {
        void onFirstFrame();
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnFrameRenderedListener {
        void invoke(int i, int i2, int i3, long j);
    }

    void aspectRatio(int i);

    void captureOneImage();

    void captureOneImage(BiliSize biliSize);

    void captureOneImage(BiliSize biliSize, float[] fArr);

    void clearBlurRect();

    void closeGyroSensor();

    int getCaptureModel();

    BiliDaltonizer.ColorBlindnessType getDaltonismType();

    BiliSize getTransformSize();

    void mirror(int i, boolean z);

    void openGyroSensor();

    void resetAxis(int i);

    void rotate(float f);

    void rotate(float f, float f2, float f3);

    void scale(float f);

    void scale(float f, float f2);

    void setBackgroundImage(Bitmap bitmap, boolean z, Rect rect);

    void setBlurRectList(List<RectF> list);

    void setCaptureFrameAvailableListener(IImageCapture.OnCaptureFrameAvailableListener onCaptureFrameAvailableListener);

    void setCaptureModel(int i);

    void setDaltonismType(BiliDaltonizer.ColorBlindnessType colorBlindnessType);

    void setDisplayRect(Rect rect);

    void setEnhance(boolean z, IjkEnhanceType ijkEnhanceType);

    void setOnFirstFrameListener(OnFirstFrameListener onFirstFrameListener);

    void setOnFrameRenderedListener(OnFrameRenderedListener onFrameRenderedListener);

    void setOperationModel(int i);

    void setPanoramaRotation(float f, float f2);

    void setPerspective(float f);

    void setSensorContext(Context context);

    void setVerticesModel(int i);

    void setWindowOrientation(BiliImageOrientation biliImageOrientation);

    void switchRenderer(int i);

    void translate(int i, int i2);

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum IjkEnhanceType {
        Shader(0),
        ShaderPlus(1);
        
        private final int value;

        IjkEnhanceType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }
}