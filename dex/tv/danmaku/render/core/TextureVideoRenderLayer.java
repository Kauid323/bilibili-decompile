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
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.player.plugin.mod.X86IjkRequest;
import tv.danmaku.render.core.IVideoRenderLayer;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.videoview.AspectRatio;
import tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext;
import tv.danmaku.videoplayer.coreV2.VideoDisplay;
import tv.danmaku.videoplayer.coreV2.adapter.CoordinateAxis;
import tv.danmaku.videoplayer.coreV2.adapter.IMediaPlayAdapter;
import tv.danmaku.videoplayer.coreV2.adapter.ScreenOrientation;

/* compiled from: TextureVideoRenderLayer.kt */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 a2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001aB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\fH\u0016J\u0018\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u0016H\u0016J\u0018\u0010+\u001a\u00020!2\u0006\u0010)\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u0016H\u0016J\b\u0010-\u001a\u00020!H\u0016J\u0010\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00020\u0019H\u0016J\u0010\u00100\u001a\u00020!2\u0006\u0010/\u001a\u00020\u0019H\u0016J\u0010\u00101\u001a\u00020!2\u0006\u0010/\u001a\u00020\u001bH\u0016J\u0010\u00102\u001a\u00020!2\u0006\u0010/\u001a\u00020\u001bH\u0016J\u0012\u00103\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u000104H\u0016J \u00105\u001a\u00020!2\u0006\u00106\u001a\u0002072\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\fH\u0016J\u0010\u00108\u001a\u00020\u00162\u0006\u00106\u001a\u000207H\u0016J\u0010\u00109\u001a\u00020!2\u0006\u00106\u001a\u000207H\u0016J\b\u0010:\u001a\u00020!H\u0014J\u0010\u0010;\u001a\u00020!2\u0006\u0010<\u001a\u00020\fH\u0014J \u0010=\u001a\u00020!2\u0006\u00106\u001a\u0002072\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\fH\u0016J\u0010\u0010>\u001a\u00020!2\u0006\u0010>\u001a\u00020\u000fH\u0016J\u0018\u0010?\u001a\u00020!2\u0006\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\fH\u0016J\u0010\u0010B\u001a\u00020!2\u0006\u0010C\u001a\u00020\u000fH\u0016J(\u0010D\u001a\u00020!2\u0006\u0010>\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\f2\u0006\u0010C\u001a\u00020\u000fH\u0016J\b\u0010E\u001a\u00020\u000fH\u0016J\u0014\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0GH\u0016J\b\u0010H\u001a\u00020\u000fH\u0016J\u0010\u0010I\u001a\u00020!2\u0006\u0010J\u001a\u00020KH\u0016J\u0010\u0010L\u001a\u00020!2\u0006\u0010M\u001a\u00020\u0016H\u0016J\b\u0010N\u001a\u00020OH\u0016J\n\u0010P\u001a\u0004\u0018\u00010QH\u0016J\u0010\u0010R\u001a\u00020!2\u0006\u0010S\u001a\u00020OH\u0016J\b\u0010T\u001a\u00020UH\u0016J\b\u0010V\u001a\u00020\fH\u0016J\b\u0010W\u001a\u00020\fH\u0016J\u0010\u0010X\u001a\u00020!2\u0006\u0010Y\u001a\u00020UH\u0016J\u0010\u0010Z\u001a\u00020!2\u0006\u0010Y\u001a\u00020UH\u0016J\b\u0010[\u001a\u00020\u0016H\u0016J \u0010\\\u001a\u00020!2\u0006\u0010]\u001a\u00020^2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\fH\u0016J\n\u0010_\u001a\u0004\u0018\u00010`H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Ltv/danmaku/render/core/TextureVideoRenderLayer;", "Landroid/view/TextureView;", "Ltv/danmaku/render/core/IVideoRenderLayer;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnVideoSizeChangedListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "<init>", "()V", "mRenderContext", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext;", "mVideoRenderLayoutHelper", "Ltv/danmaku/render/core/VideoRenderLayoutHelper;", "mVideoHeight", "", "mVideoWidth", "mCurrentScale", "", "mCurrentTranslateX", "mCurrentTranslateY", "mCurrentRotate", "mVideoDisplay", "Ltv/danmaku/videoplayer/coreV2/VideoDisplay;", "mIsFlip", "", "mVideoSizeChangedListeners", "Ljava/util/LinkedList;", "Ltv/danmaku/render/core/IVideoRenderLayer$OnVideoSizeChangedListener;", "mVideoRenderLayerStateList", "Ltv/danmaku/render/core/IVideoRenderLayer$VideoRenderLayerStateObserver;", "mRenderLayerChangedDispatcher", "Ltv/danmaku/render/core/RenderLayerChangedDispatcher;", "mRenderLayerVisibilityChangedDispatcher", "Ltv/danmaku/render/core/RenderLayerVisibilityChangedDispatcher;", "onVideoSizeChanged", "", X86IjkRequest.POOL, "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "width", "height", "sarNum", "sarDen", "bindRenderContext", "renderContext", "keepViewportUntilSurfaceCreated", "unbindRenderContext", "keepSurfaceForShare", "release", "addVideoSizeChangedListener", "listener", "removeVideoSizeChangedListener", "addVideoRenderLayerStateObserver", "removeVideoRenderLayerStateObserver", "setVideoRenderLayerChangedListener", "Ltv/danmaku/render/core/IVideoRenderLayer$OnVideoRenderLayerChangedListener;", "onSurfaceTextureSizeChanged", "surface", "Landroid/graphics/SurfaceTexture;", "onSurfaceTextureDestroyed", "onSurfaceTextureUpdated", "onAttachedToWindow", "onWindowVisibilityChanged", "visibility", "onSurfaceTextureAvailable", "scale", "translate", "tX", "tY", "rotate", "degree", "transform", "currentScale", "currentTranslate", "Lkotlin/Pair;", "currentRotate", "setAspectRatio", "ratio", "Ltv/danmaku/videoplayer/core/videoview/AspectRatio;", "flipVideo", "reversal", "getBounds", "Landroid/graphics/Rect;", "getTransformParams", "Ltv/danmaku/render/core/TransformParams;", "updateViewPort", "viewPort", "getView", "Landroid/view/View;", "getVideoHeight", "getVideoWidth", "addAlignLayer", "layer", "removeAlignLayer", "useExternalRender", "takeVideoCapture", "callback", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext$OnTakeVideoCapture;", "takeVideoCaptureEffectively", "Landroid/graphics/Bitmap;", "Companion", "rendercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class TextureVideoRenderLayer extends TextureView implements IVideoRenderLayer, IMediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "Render::TextureVideoRenderLayer";
    private float mCurrentRotate;
    private float mCurrentScale;
    private int mCurrentTranslateX;
    private int mCurrentTranslateY;
    private boolean mIsFlip;
    private IMediaPlayRenderContext mRenderContext;
    private final RenderLayerChangedDispatcher mRenderLayerChangedDispatcher;
    private RenderLayerVisibilityChangedDispatcher mRenderLayerVisibilityChangedDispatcher;
    private VideoDisplay mVideoDisplay;
    private int mVideoHeight;
    private final LinkedList<IVideoRenderLayer.VideoRenderLayerStateObserver> mVideoRenderLayerStateList;
    private VideoRenderLayoutHelper mVideoRenderLayoutHelper;
    private final LinkedList<IVideoRenderLayer.OnVideoSizeChangedListener> mVideoSizeChangedListeners;
    private int mVideoWidth;

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

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TextureVideoRenderLayer() {
        super(r0);
        Application application = BiliContext.application();
        Intrinsics.checkNotNull(application);
        this.mCurrentScale = 1.0f;
        this.mVideoSizeChangedListeners = new LinkedList<>();
        this.mVideoRenderLayerStateList = new LinkedList<>();
        this.mRenderLayerChangedDispatcher = new RenderLayerChangedDispatcher();
    }

    /* compiled from: TextureVideoRenderLayer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/render/core/TextureVideoRenderLayer$Companion;", "", "<init>", "()V", "TAG", "", "rendercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
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
        VideoRenderLayoutHelper videoRenderLayoutHelper = this.mVideoRenderLayoutHelper;
        if (videoRenderLayoutHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoRenderLayoutHelper");
            videoRenderLayoutHelper = null;
        }
        videoRenderLayoutHelper.updateVideoSize(width, height, sarNum, sarDen);
        this.mVideoHeight = height;
        this.mVideoWidth = width;
        Iterable $this$forEach$iv = this.mVideoSizeChangedListeners;
        for (Object element$iv : $this$forEach$iv) {
            IVideoRenderLayer.OnVideoSizeChangedListener it = (IVideoRenderLayer.OnVideoSizeChangedListener) element$iv;
            it.onChanged(width, height);
        }
        this.mRenderLayerChangedDispatcher.dispatchRenderLayerChanged();
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void bindRenderContext(IMediaPlayRenderContext renderContext, boolean keepViewportUntilSurfaceCreated) {
        IMediaPlayRenderContext iMediaPlayRenderContext;
        VideoDisplay videoDisplay;
        Intrinsics.checkNotNullParameter(renderContext, "renderContext");
        this.mRenderContext = renderContext;
        IMediaPlayRenderContext iMediaPlayRenderContext2 = this.mRenderContext;
        if (iMediaPlayRenderContext2 != null) {
            iMediaPlayRenderContext2.setOnVideoSizeChangedListener(this);
        }
        this.mVideoRenderLayoutHelper = new VideoRenderLayoutHelper(this);
        setSurfaceTextureListener(this);
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
        VideoDisplay videoDisplay2 = this.mVideoDisplay;
        boolean z = false;
        if (videoDisplay2 != null && videoDisplay2.isValid()) {
            z = true;
        }
        if (z) {
            IMediaPlayRenderContext iMediaPlayRenderContext3 = this.mRenderContext;
            Surface surface = (iMediaPlayRenderContext3 == null || (videoDisplay = iMediaPlayRenderContext3.getVideoDisplay()) == null) ? null : videoDisplay.getSurface();
            VideoDisplay videoDisplay3 = this.mVideoDisplay;
            if (Intrinsics.areEqual(surface, videoDisplay3 != null ? videoDisplay3.getSurface() : null) || (iMediaPlayRenderContext = this.mRenderContext) == null) {
                return;
            }
            VideoDisplay videoDisplay4 = this.mVideoDisplay;
            Intrinsics.checkNotNull(videoDisplay4);
            iMediaPlayRenderContext.setVideoDisPlay(videoDisplay4);
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
        if (z) {
            VideoDisplay videoDisplay2 = new VideoDisplay((Surface) null, (SurfaceHolder) null, 2, 2, (DefaultConstructorMarker) null);
            IMediaPlayRenderContext iMediaPlayRenderContext = this.mRenderContext;
            if (iMediaPlayRenderContext != null) {
                iMediaPlayRenderContext.setVideoDisPlay(videoDisplay2);
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
        PlayerLog.i(TAG, "surface texture destroyed and set null video display");
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
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2 != null ? r2.getSurfaceTexture() : null, r9) == false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0090 A[LOOP:0: B:29:0x008a->B:31:0x0090, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    @Override // android.view.TextureView.SurfaceTextureListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        VideoDisplay oldDisplay;
        VideoDisplay display;
        IMediaPlayRenderContext iMediaPlayRenderContext;
        Intrinsics.checkNotNullParameter(surface, "surface");
        PlayerLog.i(TAG, "surface available: width: " + width + ", height: " + height + " " + surface);
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
                if (display != null && (iMediaPlayRenderContext = this.mRenderContext) != null) {
                    iMediaPlayRenderContext.setVideoDisPlay(display);
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
            iMediaPlayRenderContext.setVideoDisPlay(display);
        }
        Iterable $this$forEach$iv2 = this.mVideoRenderLayerStateList;
        while (r3.hasNext()) {
        }
        if (oldDisplay == null) {
        }
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void scale(float scale) {
        VideoRenderLayoutHelper videoRenderLayoutHelper = this.mVideoRenderLayoutHelper;
        if (videoRenderLayoutHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoRenderLayoutHelper");
            videoRenderLayoutHelper = null;
        }
        videoRenderLayoutHelper.userScale(scale);
        this.mCurrentScale = scale;
        this.mRenderLayerChangedDispatcher.dispatchRenderLayerChanged();
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void translate(int tX, int tY) {
        VideoRenderLayoutHelper videoRenderLayoutHelper = this.mVideoRenderLayoutHelper;
        if (videoRenderLayoutHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoRenderLayoutHelper");
            videoRenderLayoutHelper = null;
        }
        videoRenderLayoutHelper.userTranslate(tX, tY);
        this.mCurrentTranslateX = tX;
        this.mCurrentTranslateY = tY;
        this.mRenderLayerChangedDispatcher.dispatchRenderLayerChanged();
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void rotate(float degree) {
        setRotation(degree);
        this.mCurrentRotate = degree;
        this.mRenderLayerChangedDispatcher.dispatchRenderLayerChanged();
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void transform(float scale, int tX, int tY, float degree) {
        this.mCurrentScale = scale;
        this.mCurrentTranslateX = tX;
        this.mCurrentTranslateY = tY;
        this.mCurrentRotate = degree;
        VideoRenderLayoutHelper videoRenderLayoutHelper = this.mVideoRenderLayoutHelper;
        VideoRenderLayoutHelper videoRenderLayoutHelper2 = null;
        if (videoRenderLayoutHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoRenderLayoutHelper");
            videoRenderLayoutHelper = null;
        }
        videoRenderLayoutHelper.userScale(scale);
        VideoRenderLayoutHelper videoRenderLayoutHelper3 = this.mVideoRenderLayoutHelper;
        if (videoRenderLayoutHelper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoRenderLayoutHelper");
        } else {
            videoRenderLayoutHelper2 = videoRenderLayoutHelper3;
        }
        videoRenderLayoutHelper2.userTranslate(tX, tY);
        setRotation(degree);
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
        VideoRenderLayoutHelper videoRenderLayoutHelper = this.mVideoRenderLayoutHelper;
        if (videoRenderLayoutHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoRenderLayoutHelper");
            videoRenderLayoutHelper = null;
        }
        videoRenderLayoutHelper.setAspectRatio(ratio);
        this.mRenderLayerChangedDispatcher.dispatchRenderLayerChanged();
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void flipVideo(boolean reversal) {
        VideoRenderLayoutHelper videoRenderLayoutHelper = this.mVideoRenderLayoutHelper;
        if (videoRenderLayoutHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoRenderLayoutHelper");
            videoRenderLayoutHelper = null;
        }
        videoRenderLayoutHelper.flip(reversal);
        this.mIsFlip = reversal;
        this.mRenderLayerChangedDispatcher.dispatchRenderLayerChanged();
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public Rect getBounds() {
        VideoRenderLayoutHelper videoRenderLayoutHelper = this.mVideoRenderLayoutHelper;
        if (videoRenderLayoutHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoRenderLayoutHelper");
            videoRenderLayoutHelper = null;
        }
        return videoRenderLayoutHelper.getVideoViewBounds();
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
        VideoRenderLayoutHelper videoRenderLayoutHelper = this.mVideoRenderLayoutHelper;
        if (videoRenderLayoutHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoRenderLayoutHelper");
            videoRenderLayoutHelper = null;
        }
        videoRenderLayoutHelper.updateViewPort(viewPort);
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
        VideoRenderLayoutHelper videoRenderLayoutHelper = this.mVideoRenderLayoutHelper;
        if (videoRenderLayoutHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoRenderLayoutHelper");
            videoRenderLayoutHelper = null;
        }
        videoRenderLayoutHelper.addAlignView(layer);
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void removeAlignLayer(View layer) {
        Intrinsics.checkNotNullParameter(layer, "layer");
        VideoRenderLayoutHelper videoRenderLayoutHelper = this.mVideoRenderLayoutHelper;
        if (videoRenderLayoutHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVideoRenderLayoutHelper");
            videoRenderLayoutHelper = null;
        }
        videoRenderLayoutHelper.removeAlignView(layer);
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public boolean useExternalRender() {
        return false;
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public void takeVideoCapture(IMediaPlayRenderContext.OnTakeVideoCapture callback, int width, int height) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        Bitmap tmpBitmap = getBitmap();
        if (tmpBitmap == null) {
            return;
        }
        Pair targetSize = new Pair(Integer.valueOf(width), Integer.valueOf(height));
        int videoWidth = getVideoWidth();
        int videoHeight = getVideoHeight();
        if (videoWidth > 0 && videoHeight > 0) {
            float videoRatio = videoWidth / videoHeight;
            int aspectHeight = tmpBitmap.getHeight();
            int aspectWidth = (int) (aspectHeight * videoRatio);
            targetSize = IVideoRenderLayer.Companion.adjustCaptureSize(aspectWidth, aspectHeight, videoWidth, videoHeight);
        }
        if (((Number) targetSize.getFirst()).intValue() > 0 && ((Number) targetSize.getSecond()).intValue() > 0) {
            bitmap = IVideoRenderLayer.Companion.resizeVideoCapture(tmpBitmap, ((Number) targetSize.getFirst()).intValue(), ((Number) targetSize.getSecond()).intValue());
        } else {
            bitmap = Bitmap.createBitmap(tmpBitmap);
            Intrinsics.checkNotNull(bitmap);
        }
        tmpBitmap.recycle();
        callback.onResult(bitmap);
    }

    @Override // tv.danmaku.render.core.IVideoRenderLayer
    public Bitmap takeVideoCaptureEffectively() {
        Pair targetSize;
        int videoWidth = getVideoWidth();
        int videoHeight = getVideoHeight();
        if (videoWidth > 0 && videoHeight > 0) {
            float videoRatio = videoWidth / videoHeight;
            int aspectHeight = getHeight();
            int aspectWidth = (int) (aspectHeight * videoRatio);
            targetSize = IVideoRenderLayer.Companion.adjustCaptureSize(aspectWidth, aspectHeight, videoWidth, videoHeight);
        } else {
            targetSize = null;
        }
        if (targetSize != null && ((Number) targetSize.getFirst()).intValue() > 0 && ((Number) targetSize.getSecond()).intValue() > 0) {
            return getBitmap(Bitmap.createBitmap(getResources().getDisplayMetrics(), ((Number) targetSize.getFirst()).intValue(), ((Number) targetSize.getSecond()).intValue(), Bitmap.Config.ARGB_8888));
        }
        return getBitmap();
    }
}