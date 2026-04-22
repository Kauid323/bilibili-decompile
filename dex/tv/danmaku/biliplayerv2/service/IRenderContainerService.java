package tv.danmaku.biliplayerv2.service;

import android.animation.AnimatorListenerAdapter;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.ScreenModeType;
import tv.danmaku.biliplayerv2.panel.IPanelContainer;
import tv.danmaku.biliplayerv2.service.IRenderLayer;
import tv.danmaku.biliplayerv2.service.render.wholescene.WholeSceneModeChangeObserver;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface;
import tv.danmaku.ijk.media.player.render.tools.BiliDaltonizer;
import tv.danmaku.render.core.IVideoRenderLayer;
import tv.danmaku.videoplayer.core.videoview.AspectRatio;
import tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext;

/* compiled from: IRenderContainerService.kt */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 {2\u00020\u0001:\u0001{J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000eH&J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0003H&J$\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&J\b\u0010\u001c\u001a\u00020\u0003H&J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0003H&J\u001a\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u0003H&J\u001c\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010$H&J\u001a\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H&J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010'\u001a\u00020,H&J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(H&J\u0012\u0010-\u001a\u00020\u00052\b\u0010.\u001a\u0004\u0018\u00010/H&J\b\u00100\u001a\u00020\u001bH&J2\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020*2\u0006\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020*2\u0006\u00105\u001a\u00020*2\b\b\u0002\u0010!\u001a\u00020\u0003H&J&\u00106\u001a\u00020\u00052\b\b\u0002\u00107\u001a\u00020*2\b\b\u0002\u00108\u001a\u00020*2\b\b\u0002\u0010!\u001a\u00020\u0003H&J\b\u00109\u001a\u00020*H&J\b\u0010:\u001a\u00020*H&J\u0010\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020=H&J\b\u0010>\u001a\u00020\u0005H&J\b\u0010?\u001a\u00020@H&J\b\u0010A\u001a\u00020*H&J\b\u0010B\u001a\u00020*H&J$\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020E2\b\b\u0002\u0010F\u001a\u00020*2\b\b\u0002\u0010G\u001a\u00020*H&J\n\u0010H\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010I\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\u0003H\u0016J\b\u0010K\u001a\u00020\u0003H\u0016J\b\u0010L\u001a\u00020\u0003H\u0016J\b\u0010M\u001a\u00020\u0003H\u0016J\b\u0010N\u001a\u00020\u0003H\u0016J\u0010\u0010O\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020PH\u0016J\u0010\u0010Q\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020PH\u0016J\u0010\u0010R\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020SH&J\u0010\u0010T\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020SH&J\u0010\u0010U\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020VH&J\u0010\u0010W\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020VH&J\u0012\u0010X\u001a\u00020\u00052\b\b\u0002\u0010Y\u001a\u00020\u0003H\u0016J\u0012\u0010Z\u001a\u00020\u00052\b\b\u0002\u0010Y\u001a\u00020\u0003H\u0016J\u0018\u0010[\u001a\u00020\u00052\u0006\u00107\u001a\u00020@2\u0006\u00108\u001a\u00020@H&J\b\u0010\\\u001a\u00020\u0003H\u0016J\u0012\u0010]\u001a\u00020\u00052\b\u0010^\u001a\u0004\u0018\u00010_H\u0016J\n\u0010`\u001a\u0004\u0018\u00010_H&J\u0010\u0010a\u001a\u00020b2\u0006\u0010^\u001a\u00020_H&J\n\u0010c\u001a\u0004\u0018\u00010dH&J\u0010\u0010e\u001a\u00020\u00032\u0006\u0010f\u001a\u00020dH&J\u0010\u0010g\u001a\u00020\u00052\u0006\u0010h\u001a\u00020@H&J\u0010\u0010i\u001a\u00020\u00052\u0006\u0010j\u001a\u00020@H&J\u0018\u0010k\u001a\u00020\u00052\u0006\u0010l\u001a\u00020*2\u0006\u0010m\u001a\u00020*H&J(\u0010n\u001a\u00020\u00052\u0006\u0010j\u001a\u00020@2\u0006\u0010o\u001a\u00020*2\u0006\u0010p\u001a\u00020*2\u0006\u0010h\u001a\u00020@H&J\u0010\u0010q\u001a\u00020\u00052\u0006\u0010^\u001a\u00020rH&J\n\u0010s\u001a\u0004\u0018\u00010tH&J\u001e\u0010u\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020w\u0012\u0004\u0012\u00020\u0005\u0018\u00010vH&J\u0010\u0010x\u001a\u00020\u00052\u0006\u0010y\u001a\u00020\u0003H&J\b\u0010z\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006|À\u0006\u0003"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IRenderContainerService;", "Ltv/danmaku/biliplayerv2/service/IWithViewPlayerService;", "isRenderLayerSupportTransform", "", "setFirstFrameListener", "", "listener", "Ltv/danmaku/ijk/media/player/render/output/IJKEXTRendererInterface$OnFirstFrameListener;", "dispatchMatrixChanged", "addRenderContainerChangedObserver", "observer", "Ltv/danmaku/biliplayerv2/service/RenderContainerMatrixChangedObserver;", "removeRenderContainerChangedObserver", "addVideoLayerAttachedObserver", "Ltv/danmaku/biliplayerv2/service/OnVideoLayerAttachedObserver;", "removeVideoLayerAttachedObserver", "setAspectRatio", "ratio", "Ltv/danmaku/videoplayer/core/videoview/AspectRatio;", "getAspectRatio", "setLayerAlpha", "alpha", "setBackgroundImage", "bitmap", "Landroid/graphics/Bitmap;", "recycle", "rect", "Landroid/graphics/Rect;", "supportFlipVideo", "flipVideo", "reversal", "updateViewPort", "containerRect", "immediately", "resetRenderContainer", "withAnim", "Landroid/animation/AnimatorListenerAdapter;", "addRenderLayer", "Ltv/danmaku/biliplayerv2/service/IRenderLayer$Type;", "layer", "Ltv/danmaku/biliplayerv2/service/IRenderLayer;", "index", "", "removeRenderLayer", "Landroid/view/View;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "getRenderViewBounds", "setViewportPadding", "left", "top", "right", "bottom", "setViewportOffset", "offsetX", "offsetY", "getViewportOffsetY", "getViewportOffsetX", "notifyScreenModeTypeChanged", "screenModeType", "Ltv/danmaku/biliplayerv2/ScreenModeType;", "notifyVideoChanged", "getVideoRatio", "", "getVideoHeight", "getVideoWidth", "takeVideoCapture", "callback", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext$OnTakeVideoCapture;", "width", "height", "takeVideoCaptureEffectively", "setKeepScreenOn", "keep", "useExternalRender", "supportVideoCapture", "supportWholeScene", "isInWholeSceneMode", "addWholeSceneModeChangeObserver", "Ltv/danmaku/biliplayerv2/service/render/wholescene/WholeSceneModeChangeObserver;", "removeWholeSceneModeChangObserver", "addVideoSizeChangedListener", "Ltv/danmaku/render/core/IVideoRenderLayer$OnVideoSizeChangedListener;", "removeVideoSizeChangedListener", "addVideoRenderLayerStateObserver", "Ltv/danmaku/render/core/IVideoRenderLayer$VideoRenderLayerStateObserver;", "removeVideoRenderLayerStateObserver", "enterWholeSceneMode", "fromUser", "exitWholeSceneMode", "notifyWholeSceneOffset", "shouldAutoEnterWholeSceneMode", "setExactlyVideoLayerType", "type", "Ltv/danmaku/render/core/IVideoRenderLayer$Type;", "getCurrentLayerType", "createVideoLayer", "Ltv/danmaku/render/core/IVideoRenderLayer;", "getCurrentLayerTransform", "Ltv/danmaku/biliplayerv2/service/RenderLayerTransform;", "applyCurrentLayerTransform", "transform", "rotateCurrentLayer", "degree", "scaleCurrentLayer", "scale", "translateCurrentLayer", "translationX", "translationY", "transformCurrentLayer", "tX", "tY", "setDaltonism", "Ltv/danmaku/ijk/media/player/render/tools/BiliDaltonizer$ColorBlindnessType;", "getPanelContainer", "Ltv/danmaku/biliplayerv2/panel/IPanelContainer;", "setFrameRenderedListener", "Lkotlin/Function1;", "Ltv/danmaku/biliplayerv2/service/FrameRenderedInfo;", "secureVideoScreen", "videoScreenNeedSecured", "enableSecureVideoScreen", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IRenderContainerService extends IWithViewPlayerService {
    public static final int ALIGN_WITH_RENDER_CONTAINER = 2;
    public static final int ALIGN_WITH_VIDEO_RENDER_LAYER = 1;
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String KEY_SHARE_PLAYER_ADJUST_LAYER_TYPE = "key_share_player_adjust_layer_type";
    public static final String KEY_SHARE_PLAYER_FLIP = "key_share_player_flip";
    public static final String KEY_SHARE_PLAYER_KEEP_TRANSFORM = "key_share_player_transform_until_shared";
    public static final String KEY_SHARE_PLAYER_KEEP_VIEWPORT = "key_share_player_viewport_until_surface_created";
    public static final String KEY_SHARE_PLAYER_VIEWPORT = "key_share_player_viewport";

    void addRenderContainerChangedObserver(RenderContainerMatrixChangedObserver renderContainerMatrixChangedObserver);

    IRenderLayer.Type addRenderLayer(IRenderLayer iRenderLayer, int i);

    void addVideoLayerAttachedObserver(OnVideoLayerAttachedObserver onVideoLayerAttachedObserver);

    void addVideoRenderLayerStateObserver(IVideoRenderLayer.VideoRenderLayerStateObserver videoRenderLayerStateObserver);

    void addVideoSizeChangedListener(IVideoRenderLayer.OnVideoSizeChangedListener onVideoSizeChangedListener);

    void addWholeSceneModeChangeObserver(WholeSceneModeChangeObserver wholeSceneModeChangeObserver);

    boolean applyCurrentLayerTransform(RenderLayerTransform renderLayerTransform);

    IVideoRenderLayer createVideoLayer(IVideoRenderLayer.Type type);

    void dispatchMatrixChanged();

    void dispatchTouchEvent(MotionEvent motionEvent);

    boolean enableSecureVideoScreen();

    void enterWholeSceneMode(boolean z);

    void exitWholeSceneMode(boolean z);

    void flipVideo(boolean z);

    AspectRatio getAspectRatio();

    RenderLayerTransform getCurrentLayerTransform();

    IVideoRenderLayer.Type getCurrentLayerType();

    IPanelContainer getPanelContainer();

    Rect getRenderViewBounds();

    int getVideoHeight();

    float getVideoRatio();

    int getVideoWidth();

    int getViewportOffsetX();

    int getViewportOffsetY();

    boolean isInWholeSceneMode();

    boolean isRenderLayerSupportTransform();

    void notifyScreenModeTypeChanged(ScreenModeType screenModeType);

    void notifyVideoChanged();

    void notifyWholeSceneOffset(float f, float f2);

    void removeRenderContainerChangedObserver(RenderContainerMatrixChangedObserver renderContainerMatrixChangedObserver);

    void removeRenderLayer(View view2);

    void removeRenderLayer(IRenderLayer iRenderLayer);

    void removeVideoLayerAttachedObserver(OnVideoLayerAttachedObserver onVideoLayerAttachedObserver);

    void removeVideoRenderLayerStateObserver(IVideoRenderLayer.VideoRenderLayerStateObserver videoRenderLayerStateObserver);

    void removeVideoSizeChangedListener(IVideoRenderLayer.OnVideoSizeChangedListener onVideoSizeChangedListener);

    void removeWholeSceneModeChangObserver(WholeSceneModeChangeObserver wholeSceneModeChangeObserver);

    void resetRenderContainer(boolean z, AnimatorListenerAdapter animatorListenerAdapter);

    void rotateCurrentLayer(float f);

    void scaleCurrentLayer(float f);

    void secureVideoScreen(boolean z);

    void setAspectRatio(AspectRatio aspectRatio);

    void setBackgroundImage(Bitmap bitmap, boolean z, Rect rect);

    void setDaltonism(BiliDaltonizer.ColorBlindnessType colorBlindnessType);

    void setExactlyVideoLayerType(IVideoRenderLayer.Type type);

    void setFirstFrameListener(IJKEXTRendererInterface.OnFirstFrameListener onFirstFrameListener);

    void setFrameRenderedListener(Function1<? super FrameRenderedInfo, Unit> function1);

    void setKeepScreenOn(boolean z);

    void setLayerAlpha(boolean z);

    void setViewportOffset(int i, int i2, boolean z);

    void setViewportPadding(int i, int i2, int i3, int i4, boolean z);

    boolean shouldAutoEnterWholeSceneMode();

    boolean supportFlipVideo();

    boolean supportVideoCapture();

    boolean supportWholeScene();

    void takeVideoCapture(IMediaPlayRenderContext.OnTakeVideoCapture onTakeVideoCapture, int i, int i2);

    Bitmap takeVideoCaptureEffectively();

    void transformCurrentLayer(float f, int i, int i2, float f2);

    void translateCurrentLayer(int i, int i2);

    void updateViewPort(Rect rect, boolean z);

    boolean useExternalRender();

    /* compiled from: IRenderContainerService.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.IRenderContainerService$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        static {
            Companion companion = IRenderContainerService.Companion;
        }

        public static /* synthetic */ void updateViewPort$default(IRenderContainerService iRenderContainerService, Rect rect, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateViewPort");
            }
            if ((i & 2) != 0) {
                z = false;
            }
            iRenderContainerService.updateViewPort(rect, z);
        }

        public static /* synthetic */ void resetRenderContainer$default(IRenderContainerService iRenderContainerService, boolean z, AnimatorListenerAdapter animatorListenerAdapter, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resetRenderContainer");
            }
            if ((i & 2) != 0) {
                animatorListenerAdapter = null;
            }
            iRenderContainerService.resetRenderContainer(z, animatorListenerAdapter);
        }

        public static /* synthetic */ IRenderLayer.Type addRenderLayer$default(IRenderContainerService iRenderContainerService, IRenderLayer iRenderLayer, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    i = -1;
                }
                return iRenderContainerService.addRenderLayer(iRenderLayer, i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRenderLayer");
        }

        public static /* synthetic */ void setViewportPadding$default(IRenderContainerService iRenderContainerService, int i, int i2, int i3, int i4, boolean z, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setViewportPadding");
            }
            if ((i5 & 16) != 0) {
                z = true;
            }
            iRenderContainerService.setViewportPadding(i, i2, i3, i4, z);
        }

        public static /* synthetic */ void setViewportOffset$default(IRenderContainerService iRenderContainerService, int i, int i2, boolean z, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setViewportOffset");
            }
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            if ((i3 & 4) != 0) {
                z = true;
            }
            iRenderContainerService.setViewportOffset(i, i2, z);
        }

        public static /* synthetic */ void takeVideoCapture$default(IRenderContainerService iRenderContainerService, IMediaPlayRenderContext.OnTakeVideoCapture onTakeVideoCapture, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeVideoCapture");
            }
            if ((i3 & 2) != 0) {
                i = -1;
            }
            if ((i3 & 4) != 0) {
                i2 = -1;
            }
            iRenderContainerService.takeVideoCapture(onTakeVideoCapture, i, i2);
        }

        public static Bitmap $default$takeVideoCaptureEffectively(IRenderContainerService _this) {
            return null;
        }

        public static void $default$setKeepScreenOn(IRenderContainerService _this, boolean keep) {
        }

        public static boolean $default$useExternalRender(IRenderContainerService _this) {
            return true;
        }

        public static boolean $default$supportVideoCapture(IRenderContainerService _this) {
            return false;
        }

        public static boolean $default$supportWholeScene(IRenderContainerService _this) {
            return false;
        }

        public static boolean $default$isInWholeSceneMode(IRenderContainerService _this) {
            return false;
        }

        public static void $default$enterWholeSceneMode(IRenderContainerService _this, boolean fromUser) {
        }

        public static /* synthetic */ void enterWholeSceneMode$default(IRenderContainerService iRenderContainerService, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enterWholeSceneMode");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            iRenderContainerService.enterWholeSceneMode(z);
        }

        public static void $default$exitWholeSceneMode(IRenderContainerService _this, boolean fromUser) {
        }

        public static /* synthetic */ void exitWholeSceneMode$default(IRenderContainerService iRenderContainerService, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exitWholeSceneMode");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            iRenderContainerService.exitWholeSceneMode(z);
        }

        public static boolean $default$shouldAutoEnterWholeSceneMode(IRenderContainerService _this) {
            return false;
        }

        public static void $default$setExactlyVideoLayerType(IRenderContainerService _this, IVideoRenderLayer.Type type) {
        }
    }

    /* compiled from: IRenderContainerService.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IRenderContainerService$Companion;", "", "<init>", "()V", "ALIGN_WITH_VIDEO_RENDER_LAYER", "", "ALIGN_WITH_RENDER_CONTAINER", "KEY_SHARE_PLAYER_FLIP", "", "KEY_SHARE_PLAYER_VIEWPORT", "KEY_SHARE_PLAYER_KEEP_VIEWPORT", "KEY_SHARE_PLAYER_KEEP_TRANSFORM", "KEY_SHARE_PLAYER_ADJUST_LAYER_TYPE", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int ALIGN_WITH_RENDER_CONTAINER = 2;
        public static final int ALIGN_WITH_VIDEO_RENDER_LAYER = 1;
        public static final String KEY_SHARE_PLAYER_ADJUST_LAYER_TYPE = "key_share_player_adjust_layer_type";
        public static final String KEY_SHARE_PLAYER_FLIP = "key_share_player_flip";
        public static final String KEY_SHARE_PLAYER_KEEP_TRANSFORM = "key_share_player_transform_until_shared";
        public static final String KEY_SHARE_PLAYER_KEEP_VIEWPORT = "key_share_player_viewport_until_surface_created";
        public static final String KEY_SHARE_PLAYER_VIEWPORT = "key_share_player_viewport";

        private Companion() {
        }
    }

    /* compiled from: IRenderContainerService.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static Bitmap takeVideoCaptureEffectively(IRenderContainerService $this) {
            return CC.$default$takeVideoCaptureEffectively($this);
        }

        @Deprecated
        public static void setKeepScreenOn(IRenderContainerService $this, boolean keep) {
            CC.$default$setKeepScreenOn($this, keep);
        }

        @Deprecated
        public static boolean useExternalRender(IRenderContainerService $this) {
            return CC.$default$useExternalRender($this);
        }

        @Deprecated
        public static boolean supportVideoCapture(IRenderContainerService $this) {
            return CC.$default$supportVideoCapture($this);
        }

        @Deprecated
        public static boolean supportWholeScene(IRenderContainerService $this) {
            return CC.$default$supportWholeScene($this);
        }

        @Deprecated
        public static boolean isInWholeSceneMode(IRenderContainerService $this) {
            return CC.$default$isInWholeSceneMode($this);
        }

        @Deprecated
        public static void addWholeSceneModeChangeObserver(IRenderContainerService $this, WholeSceneModeChangeObserver observer) {
            Intrinsics.checkNotNullParameter(observer, "observer");
            Intrinsics.checkNotNullParameter(observer, "observer");
        }

        @Deprecated
        public static void removeWholeSceneModeChangObserver(IRenderContainerService $this, WholeSceneModeChangeObserver observer) {
            Intrinsics.checkNotNullParameter(observer, "observer");
            Intrinsics.checkNotNullParameter(observer, "observer");
        }

        @Deprecated
        public static void enterWholeSceneMode(IRenderContainerService $this, boolean fromUser) {
            CC.$default$enterWholeSceneMode($this, fromUser);
        }

        @Deprecated
        public static void exitWholeSceneMode(IRenderContainerService $this, boolean fromUser) {
            CC.$default$exitWholeSceneMode($this, fromUser);
        }

        @Deprecated
        public static boolean shouldAutoEnterWholeSceneMode(IRenderContainerService $this) {
            return CC.$default$shouldAutoEnterWholeSceneMode($this);
        }

        @Deprecated
        public static void setExactlyVideoLayerType(IRenderContainerService $this, IVideoRenderLayer.Type type) {
            CC.$default$setExactlyVideoLayerType($this, type);
        }
    }
}