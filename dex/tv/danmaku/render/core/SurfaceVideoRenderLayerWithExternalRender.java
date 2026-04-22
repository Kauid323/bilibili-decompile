package tv.danmaku.render.core;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.bilibili.base.BiliContext;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.render.IjkExternalRenderThread;
import tv.danmaku.player.plugin.mod.X86IjkRequest;
import tv.danmaku.render.core.IVideoRenderLayer;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.videoview.AspectRatio;
import tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext;
import tv.danmaku.videoplayer.coreV2.VideoDisplay;
import tv.danmaku.videoplayer.coreV2.adapter.CoordinateAxis;
import tv.danmaku.videoplayer.coreV2.adapter.IMediaPlayAdapter;
import tv.danmaku.videoplayer.coreV2.adapter.ScreenOrientation;

/* compiled from: SurfaceVideoRenderLayerWithExternalRender.kt */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 r2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001rB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u0016H\u0016J\u0018\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\"H\u0016J\u0018\u00101\u001a\u00020'2\u0006\u0010/\u001a\u00020\b2\u0006\u00102\u001a\u00020\"H\u0016J\b\u00103\u001a\u00020'H\u0016J \u00104\u001a\u00020'2\u0006\u00105\u001a\u0002062\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u0016H\u0016J\b\u00107\u001a\u00020\u0016H\u0016J\b\u00108\u001a\u00020\u0016H\u0016J\u0010\u00109\u001a\u00020'2\u0006\u0010:\u001a\u00020\rH\u0016J\u0010\u0010;\u001a\u00020'2\u0006\u0010:\u001a\u00020\rH\u0016J\u0010\u0010<\u001a\u00020'2\u0006\u0010:\u001a\u00020\u000fH\u0016J\u0010\u0010=\u001a\u00020'2\u0006\u0010:\u001a\u00020\u000fH\u0016J\u0012\u0010>\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u00010?H\u0016J(\u0010@\u001a\u00020'2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u0016H\u0016J\u0010\u0010D\u001a\u00020'2\u0006\u0010A\u001a\u00020BH\u0016J\u0010\u0010E\u001a\u00020'2\u0006\u0010A\u001a\u00020BH\u0016J\u0010\u0010F\u001a\u00020'2\u0006\u0010G\u001a\u00020\u0016H\u0014J\b\u0010H\u001a\u00020'H\u0014J\u0010\u0010I\u001a\u00020'2\u0006\u0010I\u001a\u00020\u0013H\u0016J\u0018\u0010J\u001a\u00020'2\u0006\u0010K\u001a\u00020\u00162\u0006\u0010L\u001a\u00020\u0016H\u0016J\u0010\u0010M\u001a\u00020'2\u0006\u0010N\u001a\u00020\u0013H\u0016J(\u0010O\u001a\u00020'2\u0006\u0010I\u001a\u00020\u00132\u0006\u0010K\u001a\u00020\u00162\u0006\u0010L\u001a\u00020\u00162\u0006\u0010N\u001a\u00020\u0013H\u0016J\b\u0010P\u001a\u00020\u0013H\u0016J\b\u0010Q\u001a\u00020\u0013H\u0016J\u0014\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160SH\u0016J\u0010\u0010T\u001a\u00020'2\u0006\u0010U\u001a\u00020VH\u0016J\u0010\u0010W\u001a\u00020'2\u0006\u0010X\u001a\u00020\u001fH\u0016J\b\u0010Y\u001a\u00020'H\u0002J\b\u0010Z\u001a\u00020\u0011H\u0016J\u0010\u0010[\u001a\u00020'2\u0006\u0010\\\u001a\u00020\"H\u0016J\b\u0010]\u001a\u00020\u001fH\u0016J\n\u0010^\u001a\u0004\u0018\u00010_H\u0016J\u0010\u0010`\u001a\u00020'2\u0006\u0010a\u001a\u00020\u0011H\u0016J\u0010\u0010b\u001a\u00020'2\u0006\u0010a\u001a\u00020\u0011H\u0016J\b\u0010c\u001a\u00020\"H\u0016J\b\u0010d\u001a\u00020\"H\u0016J\u0018\u0010e\u001a\u00020'2\u0006\u0010f\u001a\u00020\u00132\u0006\u0010g\u001a\u00020\u0013H\u0016J\b\u0010h\u001a\u00020'H\u0016J\b\u0010i\u001a\u00020'H\u0016J\u0010\u0010j\u001a\u00020'2\u0006\u0010k\u001a\u00020lH\u0016J\b\u0010m\u001a\u00020'H\u0016J\b\u0010n\u001a\u00020'H\u0016J\u0010\u0010o\u001a\u00020'2\u0006\u0010p\u001a\u00020qH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006s"}, d2 = {"Ltv/danmaku/render/core/SurfaceVideoRenderLayerWithExternalRender;", "Landroid/view/SurfaceView;", "Ltv/danmaku/render/core/IVideoRenderLayer;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnVideoSizeChangedListener;", "Landroid/view/SurfaceHolder$Callback;", "<init>", "()V", "mRenderContext", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext;", "mVideoDisplay", "Ltv/danmaku/videoplayer/coreV2/VideoDisplay;", "mVideoSizeChangedListeners", "Ljava/util/LinkedList;", "Ltv/danmaku/render/core/IVideoRenderLayer$OnVideoSizeChangedListener;", "mVideoRenderLayerStateList", "Ltv/danmaku/render/core/IVideoRenderLayer$VideoRenderLayerStateObserver;", "mAlignLayers", "Landroid/view/View;", "mCurScale", "", "mCurRotate", "mCurTranslateX", "", "mCurTranslateY", "mVideoWidth", "mVideoHeight", "mRenderLayerChangedDispatcher", "Ltv/danmaku/render/core/RenderLayerChangedDispatcher;", "mExternalRenderHelper", "Ltv/danmaku/render/core/ExternalRenderHelper;", "mLayoutFrame", "Landroid/graphics/Rect;", "mViewPortToRender", "mIsFlip", "", "mRenderLayerVisibilityChangedDispatcher", "Ltv/danmaku/render/core/RenderLayerVisibilityChangedDispatcher;", "mKeepViewportUntilSurfaceCreated", "onVideoSizeChanged", "", X86IjkRequest.POOL, "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "width", "height", "sarNum", "sarDen", "bindRenderContext", "renderContext", "keepViewportUntilSurfaceCreated", "unbindRenderContext", "keepSurfaceForShare", "release", "takeVideoCapture", "callback", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext$OnTakeVideoCapture;", "getVideoHeight", "getVideoWidth", "addVideoSizeChangedListener", "listener", "removeVideoSizeChangedListener", "addVideoRenderLayerStateObserver", "removeVideoRenderLayerStateObserver", "setVideoRenderLayerChangedListener", "Ltv/danmaku/render/core/IVideoRenderLayer$OnVideoRenderLayerChangedListener;", "surfaceChanged", "holder", "Landroid/view/SurfaceHolder;", IjkMediaMeta.IJKM_KEY_FORMAT, "surfaceDestroyed", "surfaceCreated", "onWindowVisibilityChanged", "visibility", "onDetachedFromWindow", "scale", "translate", "tX", "tY", "rotate", "degree", "transform", "currentRotate", "currentScale", "currentTranslate", "Lkotlin/Pair;", "setAspectRatio", "ratio", "Ltv/danmaku/videoplayer/core/videoview/AspectRatio;", "updateViewPort", "viewPort", "relayoutIfNeed", "getView", "flipVideo", "reversal", "getBounds", "getTransformParams", "Ltv/danmaku/render/core/TransformParams;", "addAlignLayer", "layer", "removeAlignLayer", "useExternalRender", "supportWholeScene", "notifyWholeSceneOffset", "offsetX", "offsetY", "enterWholeSceneMode", "exitWholeSceneMode", "notifyScreenOrientation", "orientation", "Ltv/danmaku/videoplayer/coreV2/adapter/ScreenOrientation;", "closeSensorGyroscope", "openSensorGyroscope", "resetGyroscope", "axis", "Ltv/danmaku/videoplayer/coreV2/adapter/CoordinateAxis;", "Companion", "rendercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SurfaceVideoRenderLayerWithExternalRender extends SurfaceView implements IVideoRenderLayer, IMediaPlayer.OnVideoSizeChangedListener, SurfaceHolder.Callback {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "Render::SurfaceVideoRenderLayerWithExternalRender";
    private final LinkedList<View> mAlignLayers;
    private float mCurRotate;
    private float mCurScale;
    private int mCurTranslateX;
    private int mCurTranslateY;
    private final ExternalRenderHelper mExternalRenderHelper;
    private boolean mIsFlip;
    private boolean mKeepViewportUntilSurfaceCreated;
    private final Rect mLayoutFrame;
    private IMediaPlayRenderContext mRenderContext;
    private final RenderLayerChangedDispatcher mRenderLayerChangedDispatcher;
    private RenderLayerVisibilityChangedDispatcher mRenderLayerVisibilityChangedDispatcher;
    private VideoDisplay mVideoDisplay;
    private int mVideoHeight;
    private final LinkedList<IVideoRenderLayer.VideoRenderLayerStateObserver> mVideoRenderLayerStateList;
    private final LinkedList<IVideoRenderLayer.OnVideoSizeChangedListener> mVideoSizeChangedListeners;
    private int mVideoWidth;
    private final Rect mViewPortToRender;

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public /* synthetic */ boolean supportCaptureVideo() {
        return IVideoRenderLayer.CC.$default$supportCaptureVideo(this);
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public /* synthetic */ boolean supportFlip() {
        return IVideoRenderLayer.CC.$default$supportFlip(this);
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public /* synthetic */ boolean supportTransform() {
        return IVideoRenderLayer.CC.$default$supportTransform(this);
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public /* synthetic */ Bitmap takeVideoCaptureEffectively() {
        return IVideoRenderLayer.CC.$default$takeVideoCaptureEffectively(this);
    }

    public SurfaceVideoRenderLayerWithExternalRender() {
        super(BiliContext.application());
        this.mVideoSizeChangedListeners = new LinkedList<>();
        this.mVideoRenderLayerStateList = new LinkedList<>();
        this.mAlignLayers = new LinkedList<>();
        this.mCurScale = 1.0f;
        this.mRenderLayerChangedDispatcher = new RenderLayerChangedDispatcher();
        this.mExternalRenderHelper = new ExternalRenderHelper(this);
        this.mLayoutFrame = new Rect();
        this.mViewPortToRender = new Rect();
    }

    /* compiled from: SurfaceVideoRenderLayerWithExternalRender.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/render/core/SurfaceVideoRenderLayerWithExternalRender$Companion;", "", "<init>", "()V", "TAG", "", "rendercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
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
        PlayerLog.i(TAG, "onVideoSizeChanged width:" + width + " height:" + height + " sarNum:" + sarNum + " sarDen:" + sarDen);
        this.mVideoWidth = width;
        this.mVideoHeight = height;
        Iterable $this$forEach$iv = this.mVideoSizeChangedListeners;
        for (Object element$iv : $this$forEach$iv) {
            IVideoRenderLayer.OnVideoSizeChangedListener it = (IVideoRenderLayer.OnVideoSizeChangedListener) element$iv;
            it.onChanged(width, height);
        }
        this.mExternalRenderHelper.setVideoSize(width, height, sarNum, sarDen);
        if (Intrinsics.areEqual(this.mLayoutFrame, this.mExternalRenderHelper.getLayoutFrame())) {
            return;
        }
        this.mLayoutFrame.set(this.mExternalRenderHelper.getLayoutFrame());
        relayoutIfNeed();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    @Override // tv.danmaku.render.core.IVideoRenderLayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bindRenderContext(IMediaPlayRenderContext renderContext, boolean keepViewportUntilSurfaceCreated) {
        int videoWidth;
        int videoHeight;
        IMediaPlayRenderContext iMediaPlayRenderContext;
        RenderLayerVisibilityChangedDispatcher renderLayerVisibilityChangedDispatcher;
        VideoDisplay videoDisplay;
        Intrinsics.checkNotNullParameter(renderContext, "renderContext");
        renderContext.setOnVideoSizeChangedListener(this);
        this.mRenderContext = renderContext;
        boolean z = false;
        if (IVideoRenderLayer.Companion.choreographerEnable()) {
            IjkExternalRenderThread.EXTERNAL_RENDER_TYPE = 1;
            PlayerLog.i(TAG, "use CHOREOGRAPHER mode");
        } else {
            IjkExternalRenderThread.EXTERNAL_RENDER_TYPE = 0;
            PlayerLog.i(TAG, "use NORMAL mode");
        }
        getHolder().addCallback(this);
        IMediaPlayRenderContext iMediaPlayRenderContext2 = this.mRenderContext;
        Rect ijkDisplayRect = iMediaPlayRenderContext2 != null ? iMediaPlayRenderContext2.getDisplayViewPort() : null;
        if (ijkDisplayRect == null || !ijkDisplayRect.equals(this.mLayoutFrame)) {
            BLog.i(TAG, "IJK viewport:" + ijkDisplayRect + ", local viewport:" + this.mLayoutFrame + ", clear local.");
            this.mLayoutFrame.setEmpty();
        }
        VideoDisplay videoDisplay2 = this.mVideoDisplay;
        if (videoDisplay2 != null && videoDisplay2.isValid()) {
            IMediaPlayRenderContext iMediaPlayRenderContext3 = this.mRenderContext;
            SurfaceHolder surfaceHolder = (iMediaPlayRenderContext3 == null || (videoDisplay = iMediaPlayRenderContext3.getVideoDisplay()) == null) ? null : videoDisplay.getSurfaceHolder();
            VideoDisplay videoDisplay3 = this.mVideoDisplay;
            if (!Intrinsics.areEqual(surfaceHolder, videoDisplay3 != null ? videoDisplay3.getSurfaceHolder() : null)) {
                IMediaPlayRenderContext iMediaPlayRenderContext4 = this.mRenderContext;
                if (iMediaPlayRenderContext4 != null) {
                    VideoDisplay videoDisplay4 = this.mVideoDisplay;
                    Intrinsics.checkNotNull(videoDisplay4);
                    iMediaPlayRenderContext4.setVideoDisPlay(videoDisplay4);
                }
                this.mKeepViewportUntilSurfaceCreated = z;
                videoWidth = renderContext.getVideoWidth();
                videoHeight = renderContext.getVideoHeight();
                int videoSarDen = renderContext.getVideoSarDen();
                int videoSarNum = renderContext.getVideoSarNum();
                if (videoHeight <= 0 || videoWidth > 0) {
                    onVideoSizeChanged(null, videoWidth, videoHeight, videoSarNum, videoSarDen);
                }
                renderContext.invokeOp(IMediaPlayAdapter.Ops.OpenExternalRender, null);
                iMediaPlayRenderContext = this.mRenderContext;
                if (iMediaPlayRenderContext != null) {
                    iMediaPlayRenderContext.setVerticesModel(1);
                }
                this.mRenderLayerVisibilityChangedDispatcher = new RenderLayerVisibilityChangedDispatcher(renderContext);
                renderLayerVisibilityChangedDispatcher = this.mRenderLayerVisibilityChangedDispatcher;
                if (renderLayerVisibilityChangedDispatcher == null) {
                    renderLayerVisibilityChangedDispatcher.dispatchVisibilityChanged(getWindowVisibility());
                    return;
                }
                return;
            }
        }
        z = keepViewportUntilSurfaceCreated;
        this.mKeepViewportUntilSurfaceCreated = z;
        videoWidth = renderContext.getVideoWidth();
        videoHeight = renderContext.getVideoHeight();
        int videoSarDen2 = renderContext.getVideoSarDen();
        int videoSarNum2 = renderContext.getVideoSarNum();
        if (videoHeight <= 0) {
        }
        onVideoSizeChanged(null, videoWidth, videoHeight, videoSarNum2, videoSarDen2);
        renderContext.invokeOp(IMediaPlayAdapter.Ops.OpenExternalRender, null);
        iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
        }
        this.mRenderLayerVisibilityChangedDispatcher = new RenderLayerVisibilityChangedDispatcher(renderContext);
        renderLayerVisibilityChangedDispatcher = this.mRenderLayerVisibilityChangedDispatcher;
        if (renderLayerVisibilityChangedDispatcher == null) {
        }
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void unbindRenderContext(IMediaPlayRenderContext renderContext, boolean keepSurfaceForShare) {
        Intrinsics.checkNotNullParameter(renderContext, "renderContext");
        PlayerLog.i(TAG, "unbindRenderContext");
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
        IMediaPlayRenderContext renderContext = this.mRenderContext;
        if (renderContext == null) {
            return;
        }
        Pair targetSize = new Pair(Integer.valueOf(width), Integer.valueOf(height));
        boolean ignoreModelChange = IVideoRenderLayer.Companion.ignoreModelChange(targetSize);
        int videoWidth = getVideoWidth();
        int videoHeight = getVideoHeight();
        if (videoWidth > 0 && videoHeight > 0) {
            targetSize = IVideoRenderLayer.Companion.adjustCaptureSize(width, height, videoWidth, videoHeight);
        }
        renderContext.takeVideoCapture(callback, ((Number) targetSize.getFirst()).intValue(), ((Number) targetSize.getSecond()).intValue(), ignoreModelChange);
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
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            iMediaPlayRenderContext.notifyRefreshFrame();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        PlayerLog.i(TAG, "surfaceDestroyed:" + (this.mRenderContext != null));
        VideoDisplay videoDisplay = new VideoDisplay((Surface) null, (SurfaceHolder) null, 1, 1, (DefaultConstructorMarker) null);
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            iMediaPlayRenderContext.setVideoDisPlay(videoDisplay);
        }
        this.mVideoDisplay = null;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        PlayerLog.i(TAG, "surfaceCreated");
        VideoDisplay videoDisplay = new VideoDisplay((Surface) null, holder, 1, 1, (DefaultConstructorMarker) null);
        this.mVideoDisplay = videoDisplay;
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            iMediaPlayRenderContext.setVideoDisPlay(videoDisplay);
        }
        if (this.mKeepViewportUntilSurfaceCreated && !this.mViewPortToRender.isEmpty()) {
            IMediaPlayRenderContext iMediaPlayRenderContext2 = this.mRenderContext;
            if (iMediaPlayRenderContext2 != null) {
                iMediaPlayRenderContext2.setDisplayViewPort(this.mViewPortToRender);
            }
            this.mKeepViewportUntilSurfaceCreated = false;
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

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mExternalRenderHelper.onRenderDetachedFromWindow();
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void scale(float scale) {
        this.mCurScale = scale;
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            iMediaPlayRenderContext.scale(scale);
        }
        Iterable $this$forEach$iv = this.mAlignLayers;
        for (Object element$iv : $this$forEach$iv) {
            View it = (View) element$iv;
            it.setScaleX(scale);
            it.setScaleY(scale);
        }
        this.mRenderLayerChangedDispatcher.dispatchRenderLayerChanged();
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void translate(int tX, int tY) {
        this.mCurTranslateX = tX;
        this.mCurTranslateY = tY;
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            iMediaPlayRenderContext.translate(tX, tY);
        }
        Iterable $this$forEach$iv = this.mAlignLayers;
        for (Object element$iv : $this$forEach$iv) {
            View it = (View) element$iv;
            it.setTranslationX(tX);
            it.setTranslationY(tY);
        }
        this.mRenderLayerChangedDispatcher.dispatchRenderLayerChanged();
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void rotate(float degree) {
        this.mCurRotate = degree;
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            iMediaPlayRenderContext.rotate(degree);
        }
        Iterable $this$forEach$iv = this.mAlignLayers;
        for (Object element$iv : $this$forEach$iv) {
            View it = (View) element$iv;
            it.setRotation(degree);
        }
        this.mRenderLayerChangedDispatcher.dispatchRenderLayerChanged();
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void transform(float scale, int tX, int tY, float degree) {
        this.mCurScale = scale;
        this.mCurTranslateX = tX;
        this.mCurTranslateY = tY;
        this.mCurRotate = degree;
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            iMediaPlayRenderContext.transform(scale, tX, tY, degree);
        }
        Iterable $this$forEach$iv = this.mAlignLayers;
        for (Object element$iv : $this$forEach$iv) {
            View it = (View) element$iv;
            it.setScaleX(scale);
            it.setScaleY(scale);
        }
        Iterable $this$forEach$iv2 = this.mAlignLayers;
        for (Object element$iv2 : $this$forEach$iv2) {
            View it2 = (View) element$iv2;
            it2.setTranslationX(tX);
            it2.setTranslationY(tY);
        }
        Iterable $this$forEach$iv3 = this.mAlignLayers;
        for (Object element$iv3 : $this$forEach$iv3) {
            ((View) element$iv3).setRotation(degree);
        }
        this.mRenderLayerChangedDispatcher.dispatchRenderLayerChanged();
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
        this.mExternalRenderHelper.setAspectRatio(ratio);
        if (Intrinsics.areEqual(this.mLayoutFrame, this.mExternalRenderHelper.getLayoutFrame())) {
            return;
        }
        this.mLayoutFrame.set(this.mExternalRenderHelper.getLayoutFrame());
        relayoutIfNeed();
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void updateViewPort(Rect viewPort) {
        Intrinsics.checkNotNullParameter(viewPort, "viewPort");
        this.mExternalRenderHelper.updateViewPort(viewPort);
        if (Intrinsics.areEqual(this.mLayoutFrame, this.mExternalRenderHelper.getLayoutFrame())) {
            return;
        }
        this.mLayoutFrame.set(this.mExternalRenderHelper.getLayoutFrame());
        relayoutIfNeed();
    }

    private final void relayoutIfNeed() {
        IMediaPlayRenderContext iMediaPlayRenderContext;
        Iterator<View> it = this.mAlignLayers.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            View next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            View view2 = next;
            int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mLayoutFrame.width(), 1073741824);
            int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mLayoutFrame.height(), 1073741824);
            view2.measure(widthMeasureSpec, heightMeasureSpec);
            view2.layout(this.mLayoutFrame.left, this.mLayoutFrame.top, this.mLayoutFrame.right, this.mLayoutFrame.bottom);
        }
        this.mViewPortToRender.set(this.mLayoutFrame);
        if ((!this.mKeepViewportUntilSurfaceCreated || this.mVideoDisplay != null) && (iMediaPlayRenderContext = this.mRenderContext) != null) {
            iMediaPlayRenderContext.setDisplayViewPort(this.mViewPortToRender);
        }
        this.mRenderLayerChangedDispatcher.dispatchRenderLayerChanged();
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public View getView() {
        return this;
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void flipVideo(boolean reversal) {
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            iMediaPlayRenderContext.flipVideo(reversal);
        }
        this.mIsFlip = reversal;
        this.mRenderLayerChangedDispatcher.dispatchRenderLayerChanged();
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public Rect getBounds() {
        return this.mLayoutFrame;
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public TransformParams getTransformParams() {
        TransformParams transformParams = new TransformParams();
        transformParams.setPivotX(this.mLayoutFrame.centerX());
        transformParams.setPivotY(this.mLayoutFrame.centerY());
        transformParams.setRotation(currentRotate());
        transformParams.setScaleX(this.mIsFlip ? -currentScale() : currentScale());
        transformParams.setScaleY(currentScale());
        Pair pair = currentTranslate();
        transformParams.setTranslationX(((Number) pair.getFirst()).intValue());
        transformParams.setTranslationY(((Number) pair.getSecond()).intValue());
        return transformParams;
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void addAlignLayer(View layer) {
        Intrinsics.checkNotNullParameter(layer, "layer");
        this.mAlignLayers.add(layer);
        relayoutIfNeed();
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void removeAlignLayer(View layer) {
        Intrinsics.checkNotNullParameter(layer, "layer");
        this.mAlignLayers.remove(layer);
        relayoutIfNeed();
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public boolean useExternalRender() {
        return true;
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public boolean supportWholeScene() {
        Boolean bool;
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext == null || (bool = (Boolean) iMediaPlayRenderContext.invokeOp(IMediaPlayAdapter.Ops.SupportWholeScene, null)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void notifyWholeSceneOffset(float offsetX, float offsetY) {
        float[] params = {offsetX, offsetY};
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            iMediaPlayRenderContext.invokeOp(IMediaPlayAdapter.Ops.NotifyWholeSceneOffset, params);
        }
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void enterWholeSceneMode() {
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            iMediaPlayRenderContext.invokeOp(IMediaPlayAdapter.Ops.EnterWholeScene, null);
        }
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void exitWholeSceneMode() {
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            iMediaPlayRenderContext.invokeOp(IMediaPlayAdapter.Ops.ExitWholeScene, null);
        }
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void notifyScreenOrientation(ScreenOrientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            iMediaPlayRenderContext.invokeOp(IMediaPlayAdapter.Ops.NotifyScreenOrientation, orientation);
        }
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void closeSensorGyroscope() {
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            iMediaPlayRenderContext.invokeOp(IMediaPlayAdapter.Ops.CloseSensorGyroscope, null);
        }
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void openSensorGyroscope() {
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            iMediaPlayRenderContext.invokeOp(IMediaPlayAdapter.Ops.OpenSensorGyroscope, null);
        }
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void resetGyroscope(CoordinateAxis axis) {
        Intrinsics.checkNotNullParameter(axis, "axis");
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            iMediaPlayRenderContext.invokeOp(IMediaPlayAdapter.Ops.ResetGyroscope, axis);
        }
    }
}