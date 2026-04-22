package tv.danmaku.render.core;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
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

/* compiled from: TextureVideoRenderLayerWithExternalRender.kt */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 e2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001eB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\fH\u0016J\u0018\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\u001cH\u0016J\u0018\u00101\u001a\u00020'2\u0006\u0010/\u001a\u00020\b2\u0006\u00102\u001a\u00020\u001cH\u0016J\b\u00103\u001a\u00020'H\u0016J\u0010\u00104\u001a\u00020'2\u0006\u00105\u001a\u00020\u001eH\u0016J\u0010\u00106\u001a\u00020'2\u0006\u00105\u001a\u00020\u001eH\u0016J\u0010\u00107\u001a\u00020'2\u0006\u00105\u001a\u00020 H\u0016J\u0010\u00108\u001a\u00020'2\u0006\u00105\u001a\u00020 H\u0016J\u0012\u00109\u001a\u00020'2\b\u00105\u001a\u0004\u0018\u00010:H\u0016J \u0010;\u001a\u00020'2\u0006\u0010<\u001a\u00020=2\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\fH\u0016J\u0010\u0010>\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020=H\u0016J\u0010\u0010?\u001a\u00020'2\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010@\u001a\u00020'H\u0014J\b\u0010A\u001a\u00020'H\u0014J\u0010\u0010B\u001a\u00020'2\u0006\u0010C\u001a\u00020\fH\u0014J \u0010D\u001a\u00020'2\u0006\u0010<\u001a\u00020=2\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\fH\u0016J\u0010\u0010E\u001a\u00020'2\u0006\u0010E\u001a\u00020\u000fH\u0016J\u0018\u0010F\u001a\u00020'2\u0006\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020\fH\u0016J\u0010\u0010I\u001a\u00020'2\u0006\u0010J\u001a\u00020\u000fH\u0016J(\u0010K\u001a\u00020'2\u0006\u0010E\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020\f2\u0006\u0010J\u001a\u00020\u000fH\u0016J\b\u0010L\u001a\u00020\u000fH\u0016J\u0014\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0NH\u0016J\b\u0010O\u001a\u00020\u000fH\u0016J\u0010\u0010P\u001a\u00020'2\u0006\u0010Q\u001a\u00020RH\u0016J\u0010\u0010S\u001a\u00020'2\u0006\u0010T\u001a\u00020\u001cH\u0016J\b\u0010U\u001a\u00020\u0016H\u0016J\b\u0010V\u001a\u00020WH\u0016J\u0010\u0010X\u001a\u00020'2\u0006\u0010Y\u001a\u00020\u0016H\u0016J\b\u0010Z\u001a\u00020'H\u0002J\b\u0010[\u001a\u00020\u001aH\u0016J\b\u0010\\\u001a\u00020\fH\u0016J\b\u0010]\u001a\u00020\fH\u0016J\u0010\u0010^\u001a\u00020'2\u0006\u0010_\u001a\u00020\u001aH\u0016J\u0010\u0010`\u001a\u00020'2\u0006\u0010_\u001a\u00020\u001aH\u0016J\b\u0010a\u001a\u00020\u001cH\u0016J \u0010b\u001a\u00020'2\u0006\u0010c\u001a\u00020d2\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\fH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Ltv/danmaku/render/core/TextureVideoRenderLayerWithExternalRender;", "Landroid/view/TextureView;", "Ltv/danmaku/render/core/IVideoRenderLayer;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnVideoSizeChangedListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "<init>", "()V", "mRenderContext", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext;", "mExternalRenderHelper", "Ltv/danmaku/render/core/ExternalRenderHelper;", "mVideoHeight", "", "mVideoWidth", "mCurrentScale", "", "mCurrentTranslateX", "mCurrentTranslateY", "mCurrentRotate", "mVideoDisplay", "Ltv/danmaku/videoplayer/coreV2/VideoDisplay;", "mLayoutFrame", "Landroid/graphics/Rect;", "mViewPortToRender", "mAlignLayers", "Ljava/util/LinkedList;", "Landroid/view/View;", "mIsFlip", "", "mVideoSizeChangedListeners", "Ltv/danmaku/render/core/IVideoRenderLayer$OnVideoSizeChangedListener;", "mVideoRenderLayerStateList", "Ltv/danmaku/render/core/IVideoRenderLayer$VideoRenderLayerStateObserver;", "mRenderLayerChangedDispatcher", "Ltv/danmaku/render/core/RenderLayerChangedDispatcher;", "mRenderLayerVisibilityChangedDispatcher", "Ltv/danmaku/render/core/RenderLayerVisibilityChangedDispatcher;", "mKeepViewportUntilSurfaceCreated", "onVideoSizeChanged", "", X86IjkRequest.POOL, "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "width", "height", "sarNum", "sarDen", "bindRenderContext", "renderContext", "keepViewportUntilSurfaceCreated", "unbindRenderContext", "keepSurfaceForShare", "release", "addVideoSizeChangedListener", "listener", "removeVideoSizeChangedListener", "addVideoRenderLayerStateObserver", "removeVideoRenderLayerStateObserver", "setVideoRenderLayerChangedListener", "Ltv/danmaku/render/core/IVideoRenderLayer$OnVideoRenderLayerChangedListener;", "onSurfaceTextureSizeChanged", "surface", "Landroid/graphics/SurfaceTexture;", "onSurfaceTextureDestroyed", "onSurfaceTextureUpdated", "onAttachedToWindow", "onDetachedFromWindow", "onWindowVisibilityChanged", "visibility", "onSurfaceTextureAvailable", "scale", "translate", "tX", "tY", "rotate", "degree", "transform", "currentScale", "currentTranslate", "Lkotlin/Pair;", "currentRotate", "setAspectRatio", "ratio", "Ltv/danmaku/videoplayer/core/videoview/AspectRatio;", "flipVideo", "reversal", "getBounds", "getTransformParams", "Ltv/danmaku/render/core/TransformParams;", "updateViewPort", "viewPort", "relayoutIfNeed", "getView", "getVideoHeight", "getVideoWidth", "addAlignLayer", "layer", "removeAlignLayer", "useExternalRender", "takeVideoCapture", "callback", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext$OnTakeVideoCapture;", "Companion", "rendercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class TextureVideoRenderLayerWithExternalRender extends TextureView implements IVideoRenderLayer, IMediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "Render::TextureVideoRenderLayerRender";
    private final LinkedList<View> mAlignLayers;
    private float mCurrentRotate;
    private float mCurrentScale;
    private int mCurrentTranslateX;
    private int mCurrentTranslateY;
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
    public /* synthetic */ boolean supportWholeScene() {
        return IVideoRenderLayer.CC.$default$supportWholeScene(this);
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public /* synthetic */ Bitmap takeVideoCaptureEffectively() {
        return IVideoRenderLayer.CC.$default$takeVideoCaptureEffectively(this);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TextureVideoRenderLayerWithExternalRender() {
        super(r0);
        Application application = BiliContext.application();
        Intrinsics.checkNotNull(application);
        this.mExternalRenderHelper = new ExternalRenderHelper(this);
        this.mCurrentScale = 1.0f;
        this.mLayoutFrame = new Rect();
        this.mViewPortToRender = new Rect();
        this.mAlignLayers = new LinkedList<>();
        this.mVideoSizeChangedListeners = new LinkedList<>();
        this.mVideoRenderLayerStateList = new LinkedList<>();
        this.mRenderLayerChangedDispatcher = new RenderLayerChangedDispatcher();
    }

    /* compiled from: TextureVideoRenderLayerWithExternalRender.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/render/core/TextureVideoRenderLayerWithExternalRender$Companion;", "", "<init>", "()V", "TAG", "", "rendercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
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
        if (width == this.mVideoWidth && height == this.mVideoHeight) {
            return;
        }
        this.mExternalRenderHelper.setVideoSize(width, height, sarNum, sarDen);
        this.mVideoHeight = height;
        this.mVideoWidth = width;
        Iterable $this$forEach$iv = this.mVideoSizeChangedListeners;
        for (Object element$iv : $this$forEach$iv) {
            IVideoRenderLayer.OnVideoSizeChangedListener it = (IVideoRenderLayer.OnVideoSizeChangedListener) element$iv;
            it.onChanged(width, height);
        }
        if (Intrinsics.areEqual(this.mLayoutFrame, this.mExternalRenderHelper.getLayoutFrame())) {
            return;
        }
        this.mLayoutFrame.set(this.mExternalRenderHelper.getLayoutFrame());
        relayoutIfNeed();
        this.mRenderLayerChangedDispatcher.dispatchRenderLayerChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    @Override // tv.danmaku.render.core.IVideoRenderLayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bindRenderContext(IMediaPlayRenderContext renderContext, boolean keepViewportUntilSurfaceCreated) {
        boolean z;
        int videoWidth;
        int videoHeight;
        IMediaPlayRenderContext iMediaPlayRenderContext;
        RenderLayerVisibilityChangedDispatcher renderLayerVisibilityChangedDispatcher;
        VideoDisplay videoDisplay;
        IMediaPlayRenderContext iMediaPlayRenderContext2;
        VideoDisplay videoDisplay2;
        VideoDisplay videoDisplay3;
        Intrinsics.checkNotNullParameter(renderContext, "renderContext");
        PlayerLog.i(TAG, "bindRenderContext");
        this.mRenderContext = renderContext;
        IMediaPlayRenderContext iMediaPlayRenderContext3 = this.mRenderContext;
        if (iMediaPlayRenderContext3 != null) {
            iMediaPlayRenderContext3.setOnVideoSizeChangedListener(this);
        }
        boolean z2 = true;
        if (IVideoRenderLayer.Companion.choreographerEnable()) {
            IjkExternalRenderThread.EXTERNAL_RENDER_TYPE = 1;
            PlayerLog.i(TAG, "use CHOREOGRAPHER mode");
        } else {
            IjkExternalRenderThread.EXTERNAL_RENDER_TYPE = 0;
            PlayerLog.i(TAG, "use NROMAL mode");
        }
        setSurfaceTextureListener(this);
        IMediaPlayRenderContext iMediaPlayRenderContext4 = this.mRenderContext;
        Rect ijkDisplayRect = iMediaPlayRenderContext4 != null ? iMediaPlayRenderContext4.getDisplayViewPort() : null;
        if (ijkDisplayRect == null || !Intrinsics.areEqual(ijkDisplayRect, this.mLayoutFrame)) {
            BLog.i(TAG, "IJK viewport:" + ijkDisplayRect + ", local viewport:" + this.mLayoutFrame + ", clear local.");
            this.mLayoutFrame.setEmpty();
        }
        VideoDisplay videoDisplay4 = this.mVideoDisplay;
        if (videoDisplay4 != null && videoDisplay4.isValid()) {
            IMediaPlayRenderContext iMediaPlayRenderContext5 = this.mRenderContext;
            SurfaceHolder surfaceHolder = (iMediaPlayRenderContext5 == null || (videoDisplay3 = iMediaPlayRenderContext5.getVideoDisplay()) == null) ? null : videoDisplay3.getSurfaceHolder();
            VideoDisplay videoDisplay5 = this.mVideoDisplay;
            if (!Intrinsics.areEqual(surfaceHolder, videoDisplay5 != null ? videoDisplay5.getSurfaceHolder() : null)) {
                IMediaPlayRenderContext iMediaPlayRenderContext6 = this.mRenderContext;
                if (iMediaPlayRenderContext6 != null) {
                    VideoDisplay videoDisplay6 = this.mVideoDisplay;
                    Intrinsics.checkNotNull(videoDisplay6);
                    iMediaPlayRenderContext6.setVideoDisPlay(videoDisplay6);
                }
                z = false;
                this.mKeepViewportUntilSurfaceCreated = z;
                videoWidth = renderContext.getVideoWidth();
                videoHeight = renderContext.getVideoHeight();
                int videoSarDen = renderContext.getVideoSarDen();
                int videoSarNum = renderContext.getVideoSarNum();
                if (videoHeight <= 0 || videoWidth > 0) {
                    onVideoSizeChanged(null, videoWidth, videoHeight, videoSarNum, videoSarDen);
                }
                iMediaPlayRenderContext = this.mRenderContext;
                if (iMediaPlayRenderContext != null) {
                    iMediaPlayRenderContext.setVerticesModel(1);
                }
                renderContext.invokeOp(IMediaPlayAdapter.Ops.OpenExternalRender, null);
                this.mRenderLayerVisibilityChangedDispatcher = new RenderLayerVisibilityChangedDispatcher(renderContext);
                renderLayerVisibilityChangedDispatcher = this.mRenderLayerVisibilityChangedDispatcher;
                if (renderLayerVisibilityChangedDispatcher != null) {
                    renderLayerVisibilityChangedDispatcher.dispatchVisibilityChanged(getWindowVisibility());
                }
                videoDisplay = this.mVideoDisplay;
                if (videoDisplay != null || !videoDisplay.isValid()) {
                    z2 = false;
                }
                if (z2) {
                    return;
                }
                IMediaPlayRenderContext iMediaPlayRenderContext7 = this.mRenderContext;
                Surface surface = (iMediaPlayRenderContext7 == null || (videoDisplay2 = iMediaPlayRenderContext7.getVideoDisplay()) == null) ? null : videoDisplay2.getSurface();
                VideoDisplay videoDisplay7 = this.mVideoDisplay;
                if (Intrinsics.areEqual(surface, videoDisplay7 != null ? videoDisplay7.getSurface() : null) || (iMediaPlayRenderContext2 = this.mRenderContext) == null) {
                    return;
                }
                VideoDisplay videoDisplay8 = this.mVideoDisplay;
                Intrinsics.checkNotNull(videoDisplay8);
                iMediaPlayRenderContext2.setVideoDisPlay(videoDisplay8);
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
        iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
        }
        renderContext.invokeOp(IMediaPlayAdapter.Ops.OpenExternalRender, null);
        this.mRenderLayerVisibilityChangedDispatcher = new RenderLayerVisibilityChangedDispatcher(renderContext);
        renderLayerVisibilityChangedDispatcher = this.mRenderLayerVisibilityChangedDispatcher;
        if (renderLayerVisibilityChangedDispatcher != null) {
        }
        videoDisplay = this.mVideoDisplay;
        if (videoDisplay != null) {
        }
        z2 = false;
        if (z2) {
        }
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void unbindRenderContext(IMediaPlayRenderContext renderContext, boolean keepSurfaceForShare) {
        Intrinsics.checkNotNullParameter(renderContext, "renderContext");
        PlayerLog.i(TAG, "unbindRenderContext");
        VideoDisplay videoDisplay = this.mVideoDisplay;
        boolean z = false;
        if (videoDisplay != null && videoDisplay.isValid()) {
            z = true;
        }
        if (z && !keepSurfaceForShare) {
            VideoDisplay videoDisplay2 = new VideoDisplay((Surface) null, (SurfaceHolder) null, 2, 2, (DefaultConstructorMarker) null);
            IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
            if (iMediaPlayRenderContext != null) {
                iMediaPlayRenderContext.setVideoDisPlay(videoDisplay2);
            }
            this.mLayoutFrame.setEmpty();
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
        PlayerLog.i(TAG, "release");
        VideoDisplay videoDisplay = new VideoDisplay((Surface) null, (SurfaceHolder) null, 2, 2, (DefaultConstructorMarker) null);
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            iMediaPlayRenderContext.setVideoDisPlay(videoDisplay);
        }
        VideoDisplay videoDisplay2 = this.mVideoDisplay;
        if (videoDisplay2 != null) {
            videoDisplay2.release();
        }
        this.mVideoDisplay = null;
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

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        PlayerLog.i(TAG, "surface size changed: width: " + width + ", height: " + height);
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            iMediaPlayRenderContext.notifyRefreshFrame();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        PlayerLog.i(TAG, "onSurfaceTextureDestroyed:" + (this.mRenderContext != null));
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        VideoDisplay videoDisplay;
        SurfaceTexture surfaceTexture;
        PlayerLog.i(TAG, "onAttachedToWindow");
        if (getSurfaceTexture() == null) {
            VideoDisplay videoDisplay2 = this.mVideoDisplay;
            boolean z = false;
            if (videoDisplay2 != null && videoDisplay2.isValid()) {
                z = true;
            }
            if (z && (videoDisplay = this.mVideoDisplay) != null && (surfaceTexture = videoDisplay.getSurfaceTexture()) != null) {
                setSurfaceTexture(surfaceTexture);
            }
        }
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mExternalRenderHelper.onRenderDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        VideoDisplay videoDisplay;
        SurfaceTexture surfaceTexture;
        PlayerLog.i(TAG, "onWindowVisibilityChanged");
        if (visibility == 0 && getSurfaceTexture() == null) {
            VideoDisplay videoDisplay2 = this.mVideoDisplay;
            boolean z = false;
            if (videoDisplay2 != null && videoDisplay2.isValid()) {
                z = true;
            }
            if (z && (videoDisplay = this.mVideoDisplay) != null && (surfaceTexture = videoDisplay.getSurfaceTexture()) != null) {
                setSurfaceTexture(surfaceTexture);
            }
        }
        super.onWindowVisibilityChanged(visibility);
        RenderLayerVisibilityChangedDispatcher renderLayerVisibilityChangedDispatcher = this.mRenderLayerVisibilityChangedDispatcher;
        if (renderLayerVisibilityChangedDispatcher != null) {
            renderLayerVisibilityChangedDispatcher.dispatchVisibilityChanged(visibility);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0065, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2 != null ? r2.getSurfaceTexture() : null, r9) == false) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a8 A[LOOP:0: B:37:0x00a2->B:39:0x00a8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    @Override // android.view.TextureView.SurfaceTextureListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        VideoDisplay oldDisplay;
        VideoDisplay display;
        IMediaPlayRenderContext iMediaPlayRenderContext;
        IMediaPlayRenderContext iMediaPlayRenderContext2;
        Intrinsics.checkNotNullParameter(surface, "surface");
        PlayerLog.i(TAG, "surface available: width: " + width + ", height: " + height + " :" + surface);
        VideoDisplay videoDisplay = this.mVideoDisplay;
        if ((videoDisplay != null ? videoDisplay.getSurfaceTexture() : null) != null) {
            VideoDisplay videoDisplay2 = this.mVideoDisplay;
            if (!Intrinsics.areEqual(videoDisplay2 != null ? videoDisplay2.getSurfaceTexture() : null, surface)) {
                oldDisplay = this.mVideoDisplay;
                if (this.mVideoDisplay != null) {
                    VideoDisplay videoDisplay3 = this.mVideoDisplay;
                }
                this.mVideoDisplay = new VideoDisplay(surface, (SurfaceHolder) null, 2, 2, (DefaultConstructorMarker) null);
                display = this.mVideoDisplay;
                if (display != null && (iMediaPlayRenderContext2 = this.mRenderContext) != null) {
                    iMediaPlayRenderContext2.setVideoDisPlay(display);
                }
                if (this.mKeepViewportUntilSurfaceCreated && !this.mViewPortToRender.isEmpty()) {
                    iMediaPlayRenderContext = this.mRenderContext;
                    if (iMediaPlayRenderContext != null) {
                        iMediaPlayRenderContext.setDisplayViewPort(this.mViewPortToRender);
                    }
                    this.mKeepViewportUntilSurfaceCreated = false;
                }
                Iterable $this$forEach$iv = this.mVideoRenderLayerStateList;
                for (Object element$iv : $this$forEach$iv) {
                    IVideoRenderLayer.VideoRenderLayerStateObserver it = (IVideoRenderLayer.VideoRenderLayerStateObserver) element$iv;
                    it.onCreate();
                }
                if (oldDisplay == null) {
                    oldDisplay.release();
                    return;
                }
                return;
            }
        }
        oldDisplay = null;
        if (this.mVideoDisplay != null) {
        }
        this.mVideoDisplay = new VideoDisplay(surface, (SurfaceHolder) null, 2, 2, (DefaultConstructorMarker) null);
        display = this.mVideoDisplay;
        if (display != null) {
            iMediaPlayRenderContext2.setVideoDisPlay(display);
        }
        if (this.mKeepViewportUntilSurfaceCreated) {
            iMediaPlayRenderContext = this.mRenderContext;
            if (iMediaPlayRenderContext != null) {
            }
            this.mKeepViewportUntilSurfaceCreated = false;
        }
        Iterable $this$forEach$iv2 = this.mVideoRenderLayerStateList;
        while (r3.hasNext()) {
        }
        if (oldDisplay == null) {
        }
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void scale(float scale) {
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            iMediaPlayRenderContext.scale(scale);
        }
        this.mCurrentScale = scale;
        this.mRenderLayerChangedDispatcher.dispatchRenderLayerChanged();
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void translate(int tX, int tY) {
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            iMediaPlayRenderContext.translate(tX, tY);
        }
        this.mCurrentTranslateX = tX;
        this.mCurrentTranslateY = tY;
        this.mRenderLayerChangedDispatcher.dispatchRenderLayerChanged();
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void rotate(float degree) {
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            iMediaPlayRenderContext.rotate(degree);
        }
        this.mCurrentRotate = degree;
        this.mRenderLayerChangedDispatcher.dispatchRenderLayerChanged();
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void transform(float scale, int tX, int tY, float degree) {
        this.mCurrentTranslateX = tX;
        this.mCurrentTranslateY = tY;
        this.mCurrentScale = scale;
        this.mCurrentRotate = degree;
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            iMediaPlayRenderContext.transform(scale, tX, tY, degree);
        }
        this.mRenderLayerChangedDispatcher.dispatchRenderLayerChanged();
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public float currentScale() {
        return this.mCurrentScale;
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public Pair<Integer, Integer> currentTranslate() {
        return new Pair<>(Integer.valueOf(this.mCurrentTranslateX), Integer.valueOf(this.mCurrentTranslateY));
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public float currentRotate() {
        return this.mCurrentRotate;
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
        this.mRenderLayerChangedDispatcher.dispatchRenderLayerChanged();
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
        Rect bounds = getBounds();
        transformParams.setPivotX(bounds.centerX());
        transformParams.setPivotY(bounds.centerY());
        transformParams.setRotation(currentRotate());
        transformParams.setScaleX(this.mIsFlip ? -currentScale() : currentScale());
        transformParams.setScaleY(currentScale());
        Pair pair = currentTranslate();
        transformParams.setTranslationX(((Number) pair.getFirst()).intValue());
        transformParams.setTranslationY(((Number) pair.getSecond()).intValue());
        return transformParams;
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
        this.mRenderLayerChangedDispatcher.dispatchRenderLayerChanged();
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
    public void takeVideoCapture(IMediaPlayRenderContext.OnTakeVideoCapture callback, int width, int height) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Pair targetSize = new Pair(Integer.valueOf(width), Integer.valueOf(height));
        boolean ignoreModelChange = IVideoRenderLayer.Companion.ignoreModelChange(targetSize);
        int videoWidth = getVideoWidth();
        int videoHeight = getVideoHeight();
        if (videoWidth > 0 && videoHeight > 0) {
            targetSize = IVideoRenderLayer.Companion.adjustCaptureSize(width, height, videoWidth, videoHeight);
        }
        IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
        if (iMediaPlayRenderContext != null) {
            iMediaPlayRenderContext.takeVideoCapture(callback, ((Number) targetSize.getFirst()).intValue(), ((Number) targetSize.getSecond()).intValue(), ignoreModelChange);
        }
    }
}