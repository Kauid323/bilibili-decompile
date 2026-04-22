package tv.danmaku.render.core;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.util.CpuUtils;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkCpuInfo;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.media.ijk.IjkOptionsHelper;
import tv.danmaku.videoplayer.core.videoview.AspectRatio;
import tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext;
import tv.danmaku.videoplayer.coreV2.adapter.CoordinateAxis;
import tv.danmaku.videoplayer.coreV2.adapter.ScreenOrientation;

/* compiled from: IVideoRenderLayer.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 L2\u00020\u0001:\u0005LMNOPJ\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0010H&J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0015H&J(\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0015H&J\b\u0010\u001d\u001a\u00020\u0015H&J\u0014\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u001fH&J\b\u0010 \u001a\u00020\u0015H&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H&J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0007H&J\b\u0010&\u001a\u00020'H&J\n\u0010(\u001a\u0004\u0018\u00010)H&J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020'H&J\b\u0010,\u001a\u00020-H&J\b\u0010.\u001a\u00020\u0018H&J\b\u0010/\u001a\u00020\u0018H&J\u0010\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020-H&J\u0010\u00102\u001a\u00020\u00032\u0006\u00101\u001a\u00020-H&J\b\u00103\u001a\u00020\u0007H&J$\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u00020\u00182\b\b\u0002\u00108\u001a\u00020\u0018H&J\n\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020\u0007H\u0016J\b\u0010<\u001a\u00020\u0007H\u0016J\b\u0010=\u001a\u00020\u0007H\u0016J\b\u0010>\u001a\u00020\u0007H\u0016J\u0018\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\u00152\u0006\u0010A\u001a\u00020\u0015H\u0016J\b\u0010B\u001a\u00020\u0003H\u0016J\b\u0010C\u001a\u00020\u0003H\u0016J\u0010\u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u00020FH\u0016J\b\u0010G\u001a\u00020\u0003H\u0016J\b\u0010H\u001a\u00020\u0003H\u0016J\u0010\u0010I\u001a\u00020\u00032\u0006\u0010J\u001a\u00020KH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006QÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/render/core/IVideoRenderLayer;", "", "bindRenderContext", "", "renderContext", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext;", "keepViewportUntilSurfaceCreated", "", "unbindRenderContext", "keepSurfaceForShare", "release", "addVideoSizeChangedListener", "listener", "Ltv/danmaku/render/core/IVideoRenderLayer$OnVideoSizeChangedListener;", "removeVideoSizeChangedListener", "addVideoRenderLayerStateObserver", "Ltv/danmaku/render/core/IVideoRenderLayer$VideoRenderLayerStateObserver;", "removeVideoRenderLayerStateObserver", "setVideoRenderLayerChangedListener", "Ltv/danmaku/render/core/IVideoRenderLayer$OnVideoRenderLayerChangedListener;", "scale", "", "translate", "tX", "", "tY", "rotate", "degree", "transform", "currentScale", "currentTranslate", "Lkotlin/Pair;", "currentRotate", "setAspectRatio", "ratio", "Ltv/danmaku/videoplayer/core/videoview/AspectRatio;", "flipVideo", "reversal", "getBounds", "Landroid/graphics/Rect;", "getTransformParams", "Ltv/danmaku/render/core/TransformParams;", "updateViewPort", "viewPort", "getView", "Landroid/view/View;", "getVideoHeight", "getVideoWidth", "addAlignLayer", "layer", "removeAlignLayer", "useExternalRender", "takeVideoCapture", "callback", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext$OnTakeVideoCapture;", "width", "height", "takeVideoCaptureEffectively", "Landroid/graphics/Bitmap;", "supportTransform", "supportCaptureVideo", "supportFlip", "supportWholeScene", "notifyWholeSceneOffset", "offsetX", "offsetY", "enterWholeSceneMode", "exitWholeSceneMode", "notifyScreenOrientation", "orientation", "Ltv/danmaku/videoplayer/coreV2/adapter/ScreenOrientation;", "closeSensorGyroscope", "openSensorGyroscope", "resetGyroscope", "axis", "Ltv/danmaku/videoplayer/coreV2/adapter/CoordinateAxis;", "Companion", "OnVideoSizeChangedListener", "OnVideoRenderLayerChangedListener", "VideoRenderLayerStateObserver", "Type", "rendercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IVideoRenderLayer {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int SIZE_ADJUST_VIDEO = -2;
    public static final int SIZE_IGNORE_MODEL_CHANGE = -3;
    public static final int SIZE_UNDEFINE = -1;

    /* compiled from: IVideoRenderLayer.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Ltv/danmaku/render/core/IVideoRenderLayer$OnVideoRenderLayerChangedListener;", "", "onChanged", "", "rendercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnVideoRenderLayerChangedListener {
        void onChanged();
    }

    /* compiled from: IVideoRenderLayer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Ltv/danmaku/render/core/IVideoRenderLayer$OnVideoSizeChangedListener;", "", "onChanged", "", "width", "", "height", "rendercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnVideoSizeChangedListener {
        void onChanged(int i, int i2);
    }

    /* compiled from: IVideoRenderLayer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/render/core/IVideoRenderLayer$Type;", "", "<init>", "(Ljava/lang/String;I)V", "TypeSurfaceView", "TypeTextureView", "TypeSurfaceViewWithExternalRender", "TypeTextureViewWithExternalRender", "rendercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum Type {
        TypeSurfaceView,
        TypeTextureView,
        TypeSurfaceViewWithExternalRender,
        TypeTextureViewWithExternalRender;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }
    }

    /* compiled from: IVideoRenderLayer.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Ltv/danmaku/render/core/IVideoRenderLayer$VideoRenderLayerStateObserver;", "", "onCreate", "", "rendercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface VideoRenderLayerStateObserver {
        void onCreate();
    }

    void addAlignLayer(View view2);

    void addVideoRenderLayerStateObserver(VideoRenderLayerStateObserver videoRenderLayerStateObserver);

    void addVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    void bindRenderContext(IMediaPlayRenderContext iMediaPlayRenderContext, boolean z);

    void closeSensorGyroscope();

    float currentRotate();

    float currentScale();

    Pair<Integer, Integer> currentTranslate();

    void enterWholeSceneMode();

    void exitWholeSceneMode();

    void flipVideo(boolean z);

    Rect getBounds();

    TransformParams getTransformParams();

    int getVideoHeight();

    int getVideoWidth();

    View getView();

    void notifyScreenOrientation(ScreenOrientation screenOrientation);

    void notifyWholeSceneOffset(float f, float f2);

    void openSensorGyroscope();

    void release();

    void removeAlignLayer(View view2);

    void removeVideoRenderLayerStateObserver(VideoRenderLayerStateObserver videoRenderLayerStateObserver);

    void removeVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    void resetGyroscope(CoordinateAxis coordinateAxis);

    void rotate(float f);

    void scale(float f);

    void setAspectRatio(AspectRatio aspectRatio);

    void setVideoRenderLayerChangedListener(OnVideoRenderLayerChangedListener onVideoRenderLayerChangedListener);

    boolean supportCaptureVideo();

    boolean supportFlip();

    boolean supportTransform();

    boolean supportWholeScene();

    void takeVideoCapture(IMediaPlayRenderContext.OnTakeVideoCapture onTakeVideoCapture, int i, int i2);

    Bitmap takeVideoCaptureEffectively();

    void transform(float f, int i, int i2, float f2);

    void translate(int i, int i2);

    void unbindRenderContext(IMediaPlayRenderContext iMediaPlayRenderContext, boolean z);

    void updateViewPort(Rect rect);

    boolean useExternalRender();

    /* compiled from: IVideoRenderLayer.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0015J2\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005J\u0016\u0010\u001e\u001a\u00020\u0015*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0019J\u001e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005J*\u0010$\u001a\u0004\u0018\u00010 2\b\u0010%\u001a\u0004\u0018\u00010 2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)J\"\u0010*\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Ltv/danmaku/render/core/IVideoRenderLayer$Companion;", "", "<init>", "()V", "SIZE_IGNORE_MODEL_CHANGE", "", "SIZE_ADJUST_VIDEO", "SIZE_UNDEFINE", "TAG", "", "BLACK_MODEL1", "BLACK_MODEL2", "BLACK_MODEL3", "BLACK_MODEL4", "BLACK_CPU1", "BLACK_CPU2", "sPhoneModel", "sCpuName", "ensurePhoneInfo", "", "enableExternalRender", "", "externalRenderSwitch", "choreographerEnable", "adjustCaptureSize", "Lkotlin/Pair;", "width", "height", "videoWidth", "videoHeight", "ignoreModelChange", "resizeVideoCapture", "Landroid/graphics/Bitmap;", "resource", "newWidth", "newHeight", "generateWYSIWYGCapture", "capture", "panelWidth", "panelHeight", "aspectRatio", "Ltv/danmaku/videoplayer/core/videoview/AspectRatio;", "cropVideoCapture", "rendercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String BLACK_CPU1 = "MT6762V/CA";
        private static final String BLACK_CPU2 = "MT6762V/CB";
        private static final String BLACK_MODEL1 = "V1818CA";
        private static final String BLACK_MODEL2 = "vivo Y83A";
        private static final String BLACK_MODEL3 = "V1732A";
        private static final String BLACK_MODEL4 = "vivo Y83";
        public static final int SIZE_ADJUST_VIDEO = -2;
        public static final int SIZE_IGNORE_MODEL_CHANGE = -3;
        public static final int SIZE_UNDEFINE = -1;
        private static final String TAG = "IVideoRenderLayer";
        private static String sCpuName;
        private static String sPhoneModel;

        /* compiled from: IVideoRenderLayer.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AspectRatio.values().length];
                try {
                    iArr[AspectRatio.RATIO_ADJUST_SCREEN.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[AspectRatio.RATIO_16_9_INSIDE.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[AspectRatio.RATIO_4_3_INSIDE.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[AspectRatio.RATIO_CENTER_CROP.ordinal()] = 4;
                } catch (NoSuchFieldError e4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Companion() {
        }

        private final void ensurePhoneInfo() {
            if (sPhoneModel != null) {
                return;
            }
            try {
                sCpuName = IjkCpuInfo.getCpuName();
                sPhoneModel = Build.MODEL;
            } catch (Exception e) {
            }
        }

        public final boolean enableExternalRender() {
            return IjkOptionsHelper.getIjkEnableAndroidVariableCodec() && !CpuUtils.isX86(BiliContext.application()) && externalRenderSwitch();
        }

        public final boolean externalRenderSwitch() {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            ensurePhoneInfo();
            String str6 = null;
            if (Intrinsics.areEqual(Contract.-CC.get$default(ConfigManager.Companion.ab(), "enable_external_render_black_phone", (Object) null, 2, (Object) null), false)) {
                String str7 = sCpuName;
                if (str7 != null) {
                    Locale locale = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
                    str = str7.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
                } else {
                    str = null;
                }
                Locale locale2 = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(locale2, "ROOT");
                String lowerCase = BLACK_CPU1.toLowerCase(locale2);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (!TextUtils.equals(str, lowerCase)) {
                    String str8 = sCpuName;
                    if (str8 != null) {
                        Locale locale3 = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(locale3, "ROOT");
                        str5 = str8.toLowerCase(locale3);
                        Intrinsics.checkNotNullExpressionValue(str5, "toLowerCase(...)");
                    } else {
                        str5 = null;
                    }
                    Locale locale4 = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(locale4, "ROOT");
                    String lowerCase2 = BLACK_CPU2.toLowerCase(locale4);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    if (!TextUtils.equals(str5, lowerCase2)) {
                        return true;
                    }
                }
                String str9 = sPhoneModel;
                if (str9 != null) {
                    Locale locale5 = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(locale5, "ROOT");
                    str2 = str9.toLowerCase(locale5);
                    Intrinsics.checkNotNullExpressionValue(str2, "toLowerCase(...)");
                } else {
                    str2 = null;
                }
                Locale locale6 = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(locale6, "ROOT");
                String lowerCase3 = BLACK_MODEL1.toLowerCase(locale6);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                if (!TextUtils.equals(str2, lowerCase3)) {
                    String str10 = sPhoneModel;
                    if (str10 != null) {
                        Locale locale7 = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(locale7, "ROOT");
                        str3 = str10.toLowerCase(locale7);
                        Intrinsics.checkNotNullExpressionValue(str3, "toLowerCase(...)");
                    } else {
                        str3 = null;
                    }
                    Locale locale8 = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(locale8, "ROOT");
                    String lowerCase4 = BLACK_MODEL2.toLowerCase(locale8);
                    Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                    if (!TextUtils.equals(str3, lowerCase4)) {
                        String str11 = sPhoneModel;
                        if (str11 != null) {
                            Locale locale9 = Locale.ROOT;
                            Intrinsics.checkNotNullExpressionValue(locale9, "ROOT");
                            str4 = str11.toLowerCase(locale9);
                            Intrinsics.checkNotNullExpressionValue(str4, "toLowerCase(...)");
                        } else {
                            str4 = null;
                        }
                        Locale locale10 = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(locale10, "ROOT");
                        String lowerCase5 = BLACK_MODEL3.toLowerCase(locale10);
                        Intrinsics.checkNotNullExpressionValue(lowerCase5, "toLowerCase(...)");
                        if (!TextUtils.equals(str4, lowerCase5)) {
                            String str12 = sPhoneModel;
                            if (str12 != null) {
                                Locale locale11 = Locale.ROOT;
                                Intrinsics.checkNotNullExpressionValue(locale11, "ROOT");
                                str6 = str12.toLowerCase(locale11);
                                Intrinsics.checkNotNullExpressionValue(str6, "toLowerCase(...)");
                            }
                            Locale locale12 = Locale.ROOT;
                            Intrinsics.checkNotNullExpressionValue(locale12, "ROOT");
                            String lowerCase6 = BLACK_MODEL4.toLowerCase(locale12);
                            Intrinsics.checkNotNullExpressionValue(lowerCase6, "toLowerCase(...)");
                            if (!TextUtils.equals(str6, lowerCase6)) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0073, code lost:
            if (android.text.TextUtils.equals(r0, r5) != false) goto L14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean choreographerEnable() {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            ensurePhoneInfo();
            String str6 = null;
            if (Intrinsics.areEqual(Contract.-CC.get$default(ConfigManager.Companion.ab(), "disable_choreographer_black_phone", (Object) null, 2, (Object) null), true)) {
                String str7 = sCpuName;
                if (str7 != null) {
                    Locale locale = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
                    str = str7.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
                } else {
                    str = null;
                }
                Locale locale2 = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(locale2, "ROOT");
                String lowerCase = BLACK_CPU1.toLowerCase(locale2);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (!TextUtils.equals(str, lowerCase)) {
                    String str8 = sCpuName;
                    if (str8 != null) {
                        Locale locale3 = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(locale3, "ROOT");
                        str5 = str8.toLowerCase(locale3);
                        Intrinsics.checkNotNullExpressionValue(str5, "toLowerCase(...)");
                    } else {
                        str5 = null;
                    }
                    Locale locale4 = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(locale4, "ROOT");
                    String lowerCase2 = BLACK_CPU2.toLowerCase(locale4);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                }
                String str9 = sPhoneModel;
                if (str9 != null) {
                    Locale locale5 = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(locale5, "ROOT");
                    str2 = str9.toLowerCase(locale5);
                    Intrinsics.checkNotNullExpressionValue(str2, "toLowerCase(...)");
                } else {
                    str2 = null;
                }
                Locale locale6 = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(locale6, "ROOT");
                String lowerCase3 = BLACK_MODEL1.toLowerCase(locale6);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                if (!TextUtils.equals(str2, lowerCase3)) {
                    String str10 = sPhoneModel;
                    if (str10 != null) {
                        Locale locale7 = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(locale7, "ROOT");
                        str3 = str10.toLowerCase(locale7);
                        Intrinsics.checkNotNullExpressionValue(str3, "toLowerCase(...)");
                    } else {
                        str3 = null;
                    }
                    Locale locale8 = Locale.ROOT;
                    Intrinsics.checkNotNullExpressionValue(locale8, "ROOT");
                    String lowerCase4 = BLACK_MODEL2.toLowerCase(locale8);
                    Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                    if (!TextUtils.equals(str3, lowerCase4)) {
                        String str11 = sPhoneModel;
                        if (str11 != null) {
                            Locale locale9 = Locale.ROOT;
                            Intrinsics.checkNotNullExpressionValue(locale9, "ROOT");
                            str4 = str11.toLowerCase(locale9);
                            Intrinsics.checkNotNullExpressionValue(str4, "toLowerCase(...)");
                        } else {
                            str4 = null;
                        }
                        Locale locale10 = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(locale10, "ROOT");
                        String lowerCase5 = BLACK_MODEL3.toLowerCase(locale10);
                        Intrinsics.checkNotNullExpressionValue(lowerCase5, "toLowerCase(...)");
                        if (!TextUtils.equals(str4, lowerCase5)) {
                            String str12 = sPhoneModel;
                            if (str12 != null) {
                                Locale locale11 = Locale.ROOT;
                                Intrinsics.checkNotNullExpressionValue(locale11, "ROOT");
                                str6 = str12.toLowerCase(locale11);
                                Intrinsics.checkNotNullExpressionValue(str6, "toLowerCase(...)");
                            }
                            Locale locale12 = Locale.ROOT;
                            Intrinsics.checkNotNullExpressionValue(locale12, "ROOT");
                            String lowerCase6 = BLACK_MODEL4.toLowerCase(locale12);
                            Intrinsics.checkNotNullExpressionValue(lowerCase6, "toLowerCase(...)");
                            if (TextUtils.equals(str6, lowerCase6)) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return true;
        }

        public final Pair<Integer, Integer> adjustCaptureSize(int width, int height, int videoWidth, int videoHeight) {
            int retWidth = width;
            int retHeight = height;
            float videoRatio = videoWidth / videoHeight;
            if (width < 0 && height < 0 && (width == -3 || height == -3)) {
                retWidth = videoWidth;
                retHeight = videoHeight;
            } else if ((width == -2 || width == -3) && height > 0) {
                retHeight = videoHeight > height ? height : videoHeight;
                retWidth = (int) (retHeight * videoRatio);
            } else if ((height == -2 || height == -3) && width > 0) {
                retWidth = videoWidth > width ? width : videoWidth;
                retHeight = (int) (retWidth / videoRatio);
            } else if (retHeight <= 0 || retWidth <= 0) {
                retHeight = -1;
                retWidth = -1;
            }
            return new Pair<>(Integer.valueOf(retWidth), Integer.valueOf(retHeight));
        }

        public final boolean ignoreModelChange(Pair<Integer, Integer> pair) {
            Intrinsics.checkNotNullParameter(pair, "<this>");
            return ((Number) pair.getFirst()).intValue() == -3 || ((Number) pair.getSecond()).intValue() == -3;
        }

        public final Bitmap resizeVideoCapture(Bitmap resource, int newWidth, int newHeight) {
            Intrinsics.checkNotNullParameter(resource, "resource");
            int width = resource.getWidth();
            int height = resource.getHeight();
            float scaleWidth = newWidth / width;
            float scaleHeight = newHeight / height;
            Matrix matrix = new Matrix();
            matrix.postScale(scaleWidth, scaleHeight);
            Bitmap createBitmap = Bitmap.createBitmap(resource, 0, 0, width, height, matrix, true);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
            return createBitmap;
        }

        public final Bitmap generateWYSIWYGCapture(Bitmap capture, int panelWidth, int panelHeight, AspectRatio aspectRatio) {
            int newWidth;
            int newHeight;
            Intrinsics.checkNotNullParameter(aspectRatio, "aspectRatio");
            if (capture == null || capture.isRecycled()) {
                return null;
            }
            int captureWidth = capture.getWidth();
            int captureHeight = capture.getHeight();
            if (captureHeight <= 1 || captureWidth <= 1) {
                return null;
            }
            if (panelHeight < 1 || panelWidth < 1) {
                return capture;
            }
            Bitmap result = null;
            switch (WhenMappings.$EnumSwitchMapping$0[aspectRatio.ordinal()]) {
                case 1:
                    if (panelWidth != captureWidth || panelHeight != captureHeight) {
                        float ratio = panelWidth / panelHeight;
                        float newWidth2 = captureHeight * ratio;
                        result = resizeVideoCapture(capture, (int) newWidth2, captureHeight);
                        break;
                    }
                case 2:
                    float ratio2 = captureWidth / captureHeight;
                    if (!(ratio2 == 1.7777778f)) {
                        float newWidth3 = captureHeight * 1.7777778f;
                        result = resizeVideoCapture(capture, (int) newWidth3, captureHeight);
                        break;
                    }
                    break;
                case 3:
                    float captureRatio = captureWidth;
                    float ratio3 = captureRatio / captureHeight;
                    if (!(ratio3 == 1.3333334f)) {
                        float newWidth4 = captureHeight * 1.3333334f;
                        result = resizeVideoCapture(capture, (int) newWidth4, captureHeight);
                        break;
                    }
                    break;
                case 4:
                    if (panelWidth != captureWidth || panelHeight != captureHeight) {
                        float panelRatio = panelWidth / panelHeight;
                        float captureRatio2 = captureWidth / captureHeight;
                        if (captureRatio2 > panelRatio) {
                            newHeight = captureHeight;
                            newWidth = (int) (newHeight * panelRatio);
                        } else {
                            newWidth = captureWidth;
                            newHeight = (int) (newWidth / panelRatio);
                        }
                        result = cropVideoCapture(capture, newWidth, newHeight);
                        break;
                    }
            }
            if (result == null) {
                return capture;
            }
            if (!capture.isRecycled()) {
                capture.recycle();
            }
            return result;
        }

        private final Bitmap cropVideoCapture(Bitmap resource, int newWidth, int newHeight) {
            int tmpWidth;
            int tmpHeight;
            int width = resource.getWidth();
            int height = resource.getHeight();
            if (height >= 1 && newHeight >= 1) {
                float newRatio = newWidth / newHeight;
                float sourceRatio = width / height;
                if (sourceRatio > newRatio) {
                    int tmpWidth2 = (int) (newHeight * sourceRatio);
                    tmpWidth = tmpWidth2;
                    tmpHeight = newHeight;
                } else {
                    int tmpHeight2 = (int) (newWidth / sourceRatio);
                    tmpWidth = newWidth;
                    tmpHeight = tmpHeight2;
                }
                Bitmap tmpBitmap = resizeVideoCapture(resource, tmpWidth, tmpHeight);
                int offsetX = (tmpWidth - newWidth) / 2;
                int offsetY = (tmpHeight - newHeight) / 2;
                Bitmap result = Bitmap.createBitmap(tmpBitmap, offsetX, offsetY, newWidth, newHeight, (Matrix) null, false);
                Intrinsics.checkNotNullExpressionValue(result, "createBitmap(...)");
                tmpBitmap.recycle();
                return result;
            }
            return null;
        }
    }

    /* compiled from: IVideoRenderLayer.kt */
    /* renamed from: tv.danmaku.render.core.IVideoRenderLayer$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        static {
            Companion companion = IVideoRenderLayer.Companion;
        }

        public static /* synthetic */ void bindRenderContext$default(IVideoRenderLayer iVideoRenderLayer, IMediaPlayRenderContext iMediaPlayRenderContext, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindRenderContext");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            iVideoRenderLayer.bindRenderContext(iMediaPlayRenderContext, z);
        }

        public static /* synthetic */ void unbindRenderContext$default(IVideoRenderLayer iVideoRenderLayer, IMediaPlayRenderContext iMediaPlayRenderContext, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unbindRenderContext");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            iVideoRenderLayer.unbindRenderContext(iMediaPlayRenderContext, z);
        }

        public static /* synthetic */ void takeVideoCapture$default(IVideoRenderLayer iVideoRenderLayer, IMediaPlayRenderContext.OnTakeVideoCapture onTakeVideoCapture, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeVideoCapture");
            }
            if ((i3 & 2) != 0) {
                i = -1;
            }
            if ((i3 & 4) != 0) {
                i2 = -1;
            }
            iVideoRenderLayer.takeVideoCapture(onTakeVideoCapture, i, i2);
        }

        public static Bitmap $default$takeVideoCaptureEffectively(IVideoRenderLayer _this) {
            return null;
        }

        public static boolean $default$supportTransform(IVideoRenderLayer _this) {
            return true;
        }

        public static boolean $default$supportCaptureVideo(IVideoRenderLayer _this) {
            return true;
        }

        public static boolean $default$supportFlip(IVideoRenderLayer _this) {
            return true;
        }

        public static boolean $default$supportWholeScene(IVideoRenderLayer _this) {
            return false;
        }

        public static void $default$notifyWholeSceneOffset(IVideoRenderLayer _this, float offsetX, float offsetY) {
            if (BuildConfig.DEBUG) {
                throw new UnsupportedOperationException("layer: " + _this + " do not support whole-scene");
            }
            PlayerLog.e("IVideoRenderLayer", "layer: " + _this + " do not support whole-scene");
        }

        public static void $default$enterWholeSceneMode(IVideoRenderLayer _this) {
            if (BuildConfig.DEBUG) {
                throw new UnsupportedOperationException("layer: " + _this + " do not support whole-scene");
            }
            PlayerLog.e("IVideoRenderLayer", "layer: " + _this + " do not support whole-scene");
        }

        public static void $default$exitWholeSceneMode(IVideoRenderLayer _this) {
            if (BuildConfig.DEBUG) {
                throw new UnsupportedOperationException("layer: " + _this + " do not support whole-scene");
            }
            PlayerLog.e("IVideoRenderLayer", "layer: " + _this + " do not support whole-scene");
        }

        public static void $default$notifyScreenOrientation(IVideoRenderLayer _this, ScreenOrientation orientation) {
            Intrinsics.checkNotNullParameter(orientation, "orientation");
            if (BuildConfig.DEBUG) {
                throw new UnsupportedOperationException("layer: " + _this + " do not support whole-scene");
            }
            PlayerLog.e("IVideoRenderLayer", "layer: " + _this + " do not support whole-scene");
        }

        public static void $default$closeSensorGyroscope(IVideoRenderLayer _this) {
            if (BuildConfig.DEBUG) {
                throw new UnsupportedOperationException("layer: " + _this + " do not support whole-scene");
            }
            PlayerLog.e("IVideoRenderLayer", "layer: " + _this + " do not support whole-scene");
        }

        public static void $default$openSensorGyroscope(IVideoRenderLayer _this) {
            if (BuildConfig.DEBUG) {
                throw new UnsupportedOperationException("layer: " + _this + " do not support whole-scene");
            }
            PlayerLog.e("IVideoRenderLayer", "layer: " + _this + " do not support whole-scene");
        }

        public static void $default$resetGyroscope(IVideoRenderLayer _this, CoordinateAxis axis) {
            Intrinsics.checkNotNullParameter(axis, "axis");
            if (BuildConfig.DEBUG) {
                throw new UnsupportedOperationException("layer: " + _this + " do not support whole-scene");
            }
            PlayerLog.e("IVideoRenderLayer", "layer: " + _this + " do not support whole-scene");
        }
    }
}