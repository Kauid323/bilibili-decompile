package tv.danmaku.render.core;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.bilibili.base.BiliContext;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.player.plugin.mod.X86IjkRequest;
import tv.danmaku.render.core.IVideoRenderLayer;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.videoview.AspectRatio;
import tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext;
import tv.danmaku.videoplayer.coreV2.VideoDisplay;
import tv.danmaku.videoplayer.coreV2.adapter.CoordinateAxis;
import tv.danmaku.videoplayer.coreV2.adapter.IMediaPlayAdapter;
import tv.danmaku.videoplayer.coreV2.adapter.ScreenOrientation;

/* compiled from: SurfaceVideoRenderLayer.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u0000 d2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001dB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u0011H\u0016J\u0018\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\u001fH\u0016J\u0018\u00101\u001a\u00020'2\u0006\u0010/\u001a\u00020\b2\u0006\u00102\u001a\u00020\u001fH\u0016J\b\u00103\u001a\u00020'H\u0016J \u00104\u001a\u00020'2\u0006\u00105\u001a\u0002062\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u0011H\u0016J\b\u00107\u001a\u00020\u0011H\u0016J\b\u00108\u001a\u00020\u0011H\u0016J\u0010\u00109\u001a\u00020'2\u0006\u0010:\u001a\u00020\u000bH\u0016J\u0010\u0010;\u001a\u00020'2\u0006\u0010:\u001a\u00020\u000bH\u0016J\u0010\u0010<\u001a\u00020'2\u0006\u0010:\u001a\u00020\rH\u0016J\u0010\u0010=\u001a\u00020'2\u0006\u0010:\u001a\u00020\rH\u0016J\u0012\u0010>\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u00010?H\u0016J(\u0010@\u001a\u00020'2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u0011H\u0016J\u0010\u0010D\u001a\u00020'2\u0006\u0010A\u001a\u00020BH\u0016J\u0010\u0010E\u001a\u00020'2\u0006\u0010A\u001a\u00020BH\u0016J\u0010\u0010F\u001a\u00020'2\u0006\u0010G\u001a\u00020\u0011H\u0014J\u0010\u0010H\u001a\u00020'2\u0006\u0010H\u001a\u00020\u0016H\u0016J\u0018\u0010I\u001a\u00020'2\u0006\u0010J\u001a\u00020\u00112\u0006\u0010K\u001a\u00020\u0011H\u0016J\u0010\u0010L\u001a\u00020'2\u0006\u0010M\u001a\u00020\u0016H\u0016J(\u0010N\u001a\u00020'2\u0006\u0010H\u001a\u00020\u00162\u0006\u0010J\u001a\u00020\u00112\u0006\u0010K\u001a\u00020\u00112\u0006\u0010M\u001a\u00020\u0016H\u0016J\b\u0010O\u001a\u00020\u0016H\u0016J\b\u0010P\u001a\u00020\u0016H\u0016J\u0014\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110RH\u0016J\u0010\u0010S\u001a\u00020'2\u0006\u0010T\u001a\u00020\u001bH\u0016J\u0010\u0010U\u001a\u00020'2\u0006\u0010V\u001a\u00020\u001dH\u0016J\b\u0010W\u001a\u00020'H\u0002J\b\u0010X\u001a\u00020\u000fH\u0016J\u0010\u0010Y\u001a\u00020'2\u0006\u0010Z\u001a\u00020\u001fH\u0016J\b\u0010[\u001a\u00020\u001dH\u0016J\n\u0010\\\u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010]\u001a\u00020'2\u0006\u0010^\u001a\u00020\u000fH\u0016J\u0010\u0010_\u001a\u00020'2\u0006\u0010^\u001a\u00020\u000fH\u0016J\b\u0010`\u001a\u00020\u001fH\u0016J\b\u0010a\u001a\u00020\u001fH\u0016J\b\u0010b\u001a\u00020\u001fH\u0016J\b\u0010c\u001a\u00020\u001fH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006e"}, d2 = {"Ltv/danmaku/render/core/SurfaceVideoRenderLayer;", "Landroid/view/SurfaceView;", "Ltv/danmaku/render/core/IVideoRenderLayer;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnVideoSizeChangedListener;", "Landroid/view/SurfaceHolder$Callback;", "<init>", "()V", "mRenderContext", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext;", "mVideoSizeChangedListeners", "Ljava/util/LinkedList;", "Ltv/danmaku/render/core/IVideoRenderLayer$OnVideoSizeChangedListener;", "mVideoRenderLayerStateList", "Ltv/danmaku/render/core/IVideoRenderLayer$VideoRenderLayerStateObserver;", "mAlignLayers", "Landroid/view/View;", "mVideoWidth", "", "mVideoHeight", "mVideoSarNum", "mVideoSarDen", "mCurScale", "", "mCurRotate", "mCurTranslateX", "mCurTranslateY", "mAspectRatio", "Ltv/danmaku/videoplayer/core/videoview/AspectRatio;", "mViewPort", "Landroid/graphics/Rect;", "mShouldLayout", "", "mTransformParams", "Ltv/danmaku/render/core/TransformParams;", "mRenderLayerChangedDispatcher", "Ltv/danmaku/render/core/RenderLayerChangedDispatcher;", "mRenderLayerVisibilityChangedDispatcher", "Ltv/danmaku/render/core/RenderLayerVisibilityChangedDispatcher;", "onVideoSizeChanged", "", X86IjkRequest.POOL, "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "width", "height", "sarNum", "sarDen", "bindRenderContext", "renderContext", "keepViewportUntilSurfaceCreated", "unbindRenderContext", "keepSurfaceForShare", "release", "takeVideoCapture", "callback", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext$OnTakeVideoCapture;", "getVideoHeight", "getVideoWidth", "addVideoSizeChangedListener", "listener", "removeVideoSizeChangedListener", "addVideoRenderLayerStateObserver", "removeVideoRenderLayerStateObserver", "setVideoRenderLayerChangedListener", "Ltv/danmaku/render/core/IVideoRenderLayer$OnVideoRenderLayerChangedListener;", "surfaceChanged", "holder", "Landroid/view/SurfaceHolder;", IjkMediaMeta.IJKM_KEY_FORMAT, "surfaceDestroyed", "surfaceCreated", "onWindowVisibilityChanged", "visibility", "scale", "translate", "tX", "tY", "rotate", "degree", "transform", "currentRotate", "currentScale", "currentTranslate", "Lkotlin/Pair;", "setAspectRatio", "ratio", "updateViewPort", "viewPort", "relayoutIfNeed", "getView", "flipVideo", "reversal", "getBounds", "getTransformParams", "addAlignLayer", "layer", "removeAlignLayer", "useExternalRender", "supportCaptureVideo", "supportTransform", "supportFlip", "Companion", "rendercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SurfaceVideoRenderLayer extends SurfaceView implements IVideoRenderLayer, IMediaPlayer.OnVideoSizeChangedListener, SurfaceHolder.Callback {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "Render::SurfaceVideoRenderLayer";
    private final LinkedList<View> mAlignLayers;
    private AspectRatio mAspectRatio;
    private float mCurRotate;
    private float mCurScale;
    private int mCurTranslateX;
    private int mCurTranslateY;
    private IMediaPlayRenderContext mRenderContext;
    private final RenderLayerChangedDispatcher mRenderLayerChangedDispatcher;
    private RenderLayerVisibilityChangedDispatcher mRenderLayerVisibilityChangedDispatcher;
    private boolean mShouldLayout;
    private final TransformParams mTransformParams;
    private int mVideoHeight;
    private final LinkedList<IVideoRenderLayer.VideoRenderLayerStateObserver> mVideoRenderLayerStateList;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private final LinkedList<IVideoRenderLayer.OnVideoSizeChangedListener> mVideoSizeChangedListeners;
    private int mVideoWidth;
    private Rect mViewPort;

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public /* synthetic */ void closeSensorGyroscope() {
        IVideoRenderLayer.CC.$default$closeSensorGyroscope(this);
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public /* synthetic */ void enterWholeSceneMode() {
        IVideoRenderLayer.CC.$default$enterWholeSceneMode(this);
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public /* synthetic */ void exitWholeSceneMode() {
        IVideoRenderLayer.CC.$default$exitWholeSceneMode(this);
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public /* synthetic */ void notifyScreenOrientation(ScreenOrientation screenOrientation) {
        IVideoRenderLayer.CC.$default$notifyScreenOrientation(this, screenOrientation);
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public /* synthetic */ void notifyWholeSceneOffset(float f, float f2) {
        IVideoRenderLayer.CC.$default$notifyWholeSceneOffset(this, f, f2);
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public /* synthetic */ void openSensorGyroscope() {
        IVideoRenderLayer.CC.$default$openSensorGyroscope(this);
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public /* synthetic */ void resetGyroscope(CoordinateAxis coordinateAxis) {
        IVideoRenderLayer.CC.$default$resetGyroscope(this, coordinateAxis);
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public /* synthetic */ boolean supportWholeScene() {
        return IVideoRenderLayer.CC.$default$supportWholeScene(this);
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public /* synthetic */ Bitmap takeVideoCaptureEffectively() {
        return IVideoRenderLayer.CC.$default$takeVideoCaptureEffectively(this);
    }

    public SurfaceVideoRenderLayer() {
        super(BiliContext.application());
        this.mVideoSizeChangedListeners = new LinkedList<>();
        this.mVideoRenderLayerStateList = new LinkedList<>();
        this.mAlignLayers = new LinkedList<>();
        this.mVideoSarNum = 1;
        this.mVideoSarDen = 1;
        this.mCurScale = 1.0f;
        this.mAspectRatio = AspectRatio.RATIO_ADJUST_CONTENT;
        this.mViewPort = new Rect();
        this.mTransformParams = new TransformParams();
        this.mRenderLayerChangedDispatcher = new RenderLayerChangedDispatcher();
    }

    /* compiled from: SurfaceVideoRenderLayer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/render/core/SurfaceVideoRenderLayer$Companion;", "", "<init>", "()V", "TAG", "", "rendercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(IMediaPlayer player, int width, int height, int sarNum, int sarDen) {
        if (this.mVideoHeight == height && this.mVideoWidth == width && this.mVideoSarDen == sarDen && this.mVideoSarNum == sarNum) {
            return;
        }
        this.mVideoWidth = width;
        this.mVideoHeight = height;
        this.mVideoSarNum = sarNum;
        this.mVideoSarDen = sarDen;
        Iterable $this$forEach$iv = this.mVideoSizeChangedListeners;
        for (Object element$iv : $this$forEach$iv) {
            IVideoRenderLayer.OnVideoSizeChangedListener it = (IVideoRenderLayer.OnVideoSizeChangedListener) element$iv;
            it.onChanged(width, height);
        }
        this.mShouldLayout = true;
        relayoutIfNeed();
        this.mRenderLayerChangedDispatcher.dispatchRenderLayerChanged();
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void bindRenderContext(IMediaPlayRenderContext renderContext, boolean keepViewportUntilSurfaceCreated) {
        Intrinsics.checkNotNullParameter(renderContext, "renderContext");
        renderContext.setOnVideoSizeChangedListener(this);
        this.mRenderContext = renderContext;
        getHolder().addCallback(this);
        int videoWidth = renderContext.getVideoWidth();
        int videoHeight = renderContext.getVideoHeight();
        int videoSarDen = renderContext.getVideoSarDen();
        int videoSarNum = renderContext.getVideoSarNum();
        if (videoHeight > 0 || videoWidth > 0) {
            onVideoSizeChanged(null, videoWidth, videoHeight, videoSarNum, videoSarDen);
        }
        renderContext.invokeOp(IMediaPlayAdapter.Ops.CloseExternalRender, null);
        this.mRenderLayerVisibilityChangedDispatcher = new RenderLayerVisibilityChangedDispatcher(renderContext);
        RenderLayerVisibilityChangedDispatcher renderLayerVisibilityChangedDispatcher = this.mRenderLayerVisibilityChangedDispatcher;
        if (renderLayerVisibilityChangedDispatcher != null) {
            renderLayerVisibilityChangedDispatcher.dispatchVisibilityChanged(getWindowVisibility());
        }
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void unbindRenderContext(IMediaPlayRenderContext renderContext, boolean keepSurfaceForShare) {
        Intrinsics.checkNotNullParameter(renderContext, "renderContext");
        if (!keepSurfaceForShare) {
            VideoDisplay videoDisplay = new VideoDisplay((Surface) null, (SurfaceHolder) null, 1, 2, (DefaultConstructorMarker) null);
            IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
            if (iMediaPlayRenderContext != null) {
                iMediaPlayRenderContext.setVideoDisPlay(videoDisplay);
            }
        }
        IMediaPlayRenderContext iMediaPlayRenderContext2 = this.mRenderContext;
        if (iMediaPlayRenderContext2 != null) {
            iMediaPlayRenderContext2.setOnVideoSizeChangedListener(null);
        }
        this.mRenderContext = null;
        this.mRenderLayerVisibilityChangedDispatcher = null;
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void release() {
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void takeVideoCapture(IMediaPlayRenderContext.OnTakeVideoCapture callback, int width, int height) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (BuildConfig.DEBUG) {
            throw new UnsupportedOperationException("do not support takeVideoCapture");
        }
        PlayerLog.e(TAG, "do not support takeVideoCapture");
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public int getVideoHeight() {
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        return iMediaPlayRenderContext != null ? iMediaPlayRenderContext.getVideoHeight() : this.mVideoHeight;
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public int getVideoWidth() {
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        return iMediaPlayRenderContext != null ? iMediaPlayRenderContext.getVideoWidth() : this.mVideoWidth;
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void addVideoSizeChangedListener(IVideoRenderLayer.OnVideoSizeChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mVideoSizeChangedListeners.add(listener);
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void removeVideoSizeChangedListener(IVideoRenderLayer.OnVideoSizeChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mVideoSizeChangedListeners.remove(listener);
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void addVideoRenderLayerStateObserver(IVideoRenderLayer.VideoRenderLayerStateObserver listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mVideoRenderLayerStateList.add(listener);
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void removeVideoRenderLayerStateObserver(IVideoRenderLayer.VideoRenderLayerStateObserver listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mVideoRenderLayerStateList.remove(listener);
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void setVideoRenderLayerChangedListener(IVideoRenderLayer.OnVideoRenderLayerChangedListener listener) {
        this.mRenderLayerChangedDispatcher.setVideoRenderLayerChangedListener(listener);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        PlayerLog.i(TAG, "surfaceChanged size width:" + width + " height:" + height);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        PlayerLog.i(TAG, "surfaceDestroyed");
        VideoDisplay videoDisplay = new VideoDisplay((Surface) null, (SurfaceHolder) null, 1, 1, (DefaultConstructorMarker) null);
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            iMediaPlayRenderContext.setVideoDisPlay(videoDisplay);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        VideoDisplay videoDisplay = new VideoDisplay((Surface) null, holder, 1, 1, (DefaultConstructorMarker) null);
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            iMediaPlayRenderContext.setVideoDisPlay(videoDisplay);
        }
        Iterable $this$forEach$iv = this.mVideoRenderLayerStateList;
        for (Object element$iv : $this$forEach$iv) {
            IVideoRenderLayer.VideoRenderLayerStateObserver it = (IVideoRenderLayer.VideoRenderLayerStateObserver) element$iv;
            it.onCreate();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        RenderLayerVisibilityChangedDispatcher renderLayerVisibilityChangedDispatcher = this.mRenderLayerVisibilityChangedDispatcher;
        if (renderLayerVisibilityChangedDispatcher != null) {
            renderLayerVisibilityChangedDispatcher.dispatchVisibilityChanged(visibility);
        }
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void scale(float scale) {
        if (BuildConfig.DEBUG) {
            throw new UnsupportedOperationException("do not support scale");
        }
        PlayerLog.e(TAG, "do not support scale");
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void translate(int tX, int tY) {
        if (BuildConfig.DEBUG) {
            throw new UnsupportedOperationException("do not support translate");
        }
        PlayerLog.e(TAG, "do not support translate");
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void rotate(float degree) {
        if (BuildConfig.DEBUG) {
            throw new UnsupportedOperationException("do not support degree");
        }
        PlayerLog.e(TAG, "do not support degree");
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void transform(float scale, int tX, int tY, float degree) {
        if (BuildConfig.DEBUG) {
            throw new UnsupportedOperationException("do not support degree");
        }
        PlayerLog.e(TAG, "do not support transform");
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public float currentRotate() {
        return this.mCurRotate;
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public float currentScale() {
        return this.mCurScale;
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public Pair<Integer, Integer> currentTranslate() {
        return new Pair<>(Integer.valueOf(this.mCurTranslateX), Integer.valueOf(this.mCurTranslateY));
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void setAspectRatio(AspectRatio ratio) {
        Intrinsics.checkNotNullParameter(ratio, "ratio");
        if (ratio == this.mAspectRatio) {
            return;
        }
        this.mAspectRatio = ratio;
        this.mShouldLayout = true;
        relayoutIfNeed();
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void updateViewPort(Rect viewPort) {
        Intrinsics.checkNotNullParameter(viewPort, "viewPort");
        if (Intrinsics.areEqual(viewPort, this.mViewPort)) {
            return;
        }
        this.mViewPort.set(viewPort);
        this.mShouldLayout = true;
        relayoutIfNeed();
    }

    private final void relayoutIfNeed() {
        if (!this.mShouldLayout) {
            return;
        }
        this.mShouldLayout = false;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(0, 0);
            setLayoutParams(layoutParams);
        }
        Point point = new Point();
        VideoRenderLayoutHelper.Companion.calculateVideoDisplaySize(point, this.mAspectRatio, this.mViewPort, this.mVideoWidth, this.mVideoHeight, this.mVideoSarNum, this.mVideoSarDen);
        layoutParams.width = point.x;
        layoutParams.height = point.y;
        int measureSpecWidth = View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
        int measureSpecHeight = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
        measure(measureSpecWidth, measureSpecHeight);
        Iterator<View> it = this.mAlignLayers.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            View next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            View view2 = next;
            view2.measure(measureSpecWidth, measureSpecHeight);
        }
        int childWidth = getMeasuredWidth();
        int childHeight = getMeasuredHeight();
        int containerWidth = this.mViewPort.width();
        int containerHeight = this.mViewPort.height();
        int childLeft = ((containerWidth - childWidth) / 2) + this.mViewPort.left;
        int childTop = ((containerHeight - childHeight) / 2) + this.mViewPort.top;
        layout(childLeft, childTop, childWidth + childLeft, childHeight + childTop);
        Iterator<View> it2 = this.mAlignLayers.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            View next2 = it2.next();
            Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
            View view3 = next2;
            view3.layout(childLeft, childTop, childWidth + childLeft, childHeight + childTop);
        }
        this.mRenderLayerChangedDispatcher.dispatchRenderLayerChanged();
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public View getView() {
        return this;
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void flipVideo(boolean reversal) {
        if (BuildConfig.DEBUG) {
            throw new UnsupportedOperationException("do not support flip video");
        }
        PlayerLog.e(TAG, "do not support flip video");
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public Rect getBounds() {
        return new Rect(getLeft(), getTop(), getRight(), getBottom());
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public TransformParams getTransformParams() {
        this.mTransformParams.setPivotX(getPivotX());
        this.mTransformParams.setPivotY(getPivotY());
        this.mTransformParams.setRotation(currentRotate());
        this.mTransformParams.setScaleX(currentScale());
        this.mTransformParams.setScaleY(currentScale());
        Pair pair = currentTranslate();
        this.mTransformParams.setTranslationX(((Number) pair.getFirst()).intValue());
        this.mTransformParams.setTranslationY(((Number) pair.getSecond()).intValue());
        return this.mTransformParams;
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void addAlignLayer(View layer) {
        Intrinsics.checkNotNullParameter(layer, "layer");
        this.mAlignLayers.add(layer);
        this.mShouldLayout = true;
        relayoutIfNeed();
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void removeAlignLayer(View layer) {
        Intrinsics.checkNotNullParameter(layer, "layer");
        this.mAlignLayers.remove(layer);
        this.mShouldLayout = true;
        relayoutIfNeed();
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public boolean useExternalRender() {
        return false;
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public boolean supportCaptureVideo() {
        return false;
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public boolean supportTransform() {
        return false;
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public boolean supportFlip() {
        return false;
    }
}