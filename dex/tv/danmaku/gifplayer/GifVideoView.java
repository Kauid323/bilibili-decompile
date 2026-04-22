package tv.danmaku.gifplayer;

import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.fd_service.FreeDataManager;
import com.bilibili.lib.tf.TfResource;
import com.bilibili.lib.tf.TfTransformResp;
import com.bilibili.lib.tf.freedata.util.TfTransformKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkAssetUpdateReason;
import tv.danmaku.ijk.media.player.IjkMediaAsset;
import tv.danmaku.ijk.media.player.IjkMediaConfigParams;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayerItem;
import tv.danmaku.ijk.media.player.IjkNetworkUtils;
import tv.danmaku.player.plugin.mod.X86IjkRequest;

/* compiled from: GifVideoView.kt */
@Metadata(d1 = {"\u0000£\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t*\u0001$\b\u0001\u0018\u0000 W2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002WXB\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010&\u001a\u00020\u000fH\u0002J\u0014\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010(H\u0003J \u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001bH\u0007J\u0010\u00100\u001a\u0002012\u0006\u0010,\u001a\u00020\u0017H\u0002J \u00102\u001a\u00020+2\u0006\u00103\u001a\u00020 2\u0006\u00104\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000bH\u0016J \u00106\u001a\u00020+2\u0006\u00103\u001a\u00020 2\u0006\u00104\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000bH\u0016J\u0010\u00107\u001a\u00020+2\u0006\u00103\u001a\u00020 H\u0016J\u0010\u00108\u001a\u00020\u000f2\u0006\u00103\u001a\u00020 H\u0016J\b\u00109\u001a\u00020+H\u0014J\u0018\u0010:\u001a\u00020+2\b\b\u0002\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u000fJ\u000e\u0010=\u001a\u00020+2\u0006\u0010>\u001a\u00020\u000bJ\u000e\u0010?\u001a\u00020+2\u0006\u0010@\u001a\u00020\u000fJ\"\u0010A\u001a\u00020\u000f2\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020\u000bH\u0016J,\u0010F\u001a\u00020\u000f2\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020\u000b2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\b\u0010I\u001a\u00020+H\u0002J\u0012\u0010J\u001a\u00020+2\b\u0010K\u001a\u0004\u0018\u00010CH\u0016J\u0018\u0010L\u001a\u00020+2\u0006\u0010M\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u000bH\u0014J(\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u00152\u0006\u0010S\u001a\u00020\u000b2\u0006\u0010T\u001a\u00020\u000bH\u0002J0\u0010U\u001a\u00020+2\u0006\u0010V\u001a\u00020\u00132\u0006\u0010Q\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u00152\u0006\u0010S\u001a\u00020\u000b2\u0006\u0010T\u001a\u00020\u000bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%¨\u0006Y"}, d2 = {"Ltv/danmaku/gifplayer/GifVideoView;", "Landroid/view/TextureView;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnInfoListener;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPreparedListener;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mFillType", "", "mMediaPlayer", "Ltv/danmaku/ijk/media/player/IjkMediaPlayer;", "mInitialed", "", "mVideoWidth", "mVideoHeight", "mTempPoint", "Landroid/graphics/Point;", "mTempViewPort", "Landroid/graphics/Rect;", "mResources", "Ltv/danmaku/gifplayer/Resources;", "mMediaPlayerItemCache", "Ltv/danmaku/gifplayer/MediaPlayerItemCache;", "mListener", "Ltv/danmaku/gifplayer/GifVideoView$Listener;", "mIsPrepared", "mCachedSurface", "Landroid/view/Surface;", "mCachedSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "mIsPaused", "mIsLoop", "mOnAssetUpdateListener", "tv/danmaku/gifplayer/GifVideoView$mOnAssetUpdateListener$1", "Ltv/danmaku/gifplayer/GifVideoView$mOnAssetUpdateListener$1;", "shouldProcessUrl", "processUrl", "", "originUrl", "start", "", "resources", "container", "Landroid/widget/FrameLayout;", "listener", "createIjkMediaItem", "Ltv/danmaku/ijk/media/player/IjkMediaPlayerItem;", "onSurfaceTextureAvailable", "surface", "width", "height", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "onSurfaceTextureDestroyed", "onAttachedToWindow", "stop", "byOther", "release", "setFillType", "type", "setPlayLoopMode", "isLoop", "onError", "p0", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "what", "extra", "onInfo", "bundle", "Landroid/os/Bundle;", "onFirstRender", "onPrepared", X86IjkRequest.POOL, "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "getVideoDisplayRatio", "", "fillType", "viewPort", "videoWidth", "videoHeight", "calculateVideoDisplaySize", "point", "Companion", "Listener", "biligifplayer_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class GifVideoView extends TextureView implements IMediaPlayer.OnErrorListener, IMediaPlayer.OnInfoListener, IMediaPlayer.OnPreparedListener, TextureView.SurfaceTextureListener {
    public static final Companion Companion = new Companion(null);
    private static final String GIF_VIDEO_VIEW_FRAGMENT_TAG = "gif_video_view_fragment_tag";
    private static final int MODE_NET = 7;
    private static final int MODE_OFFLINE = 701;
    private static final int PLAY_COMPLETED = 6;
    private static final String TAG = "GifVideoView";
    private static WeakReference<GifVideoView> sCurrentVideo;
    private Surface mCachedSurface;
    private SurfaceTexture mCachedSurfaceTexture;
    private int mFillType;
    private boolean mInitialed;
    private boolean mIsLoop;
    private boolean mIsPaused;
    private boolean mIsPrepared;
    private Listener mListener;
    private IjkMediaPlayer mMediaPlayer;
    private final MediaPlayerItemCache mMediaPlayerItemCache;
    private final GifVideoView$mOnAssetUpdateListener$1 mOnAssetUpdateListener;
    private Resources mResources;
    private Point mTempPoint;
    private Rect mTempViewPort;
    private int mVideoHeight;
    private int mVideoWidth;

    /* compiled from: GifVideoView.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/gifplayer/GifVideoView$Listener;", "", "onFirstRender", "", "onError", "onStop", "byOther", "", "onComplete", "biligifplayer_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface Listener {
        void onComplete();

        void onError();

        void onFirstRender();

        void onStop(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v6, types: [tv.danmaku.gifplayer.GifVideoView$mOnAssetUpdateListener$1] */
    public GifVideoView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mFillType = 2;
        this.mTempPoint = new Point();
        this.mTempViewPort = new Rect();
        this.mMediaPlayerItemCache = new MediaPlayerItemCache();
        this.mIsLoop = true;
        this.mOnAssetUpdateListener = new IjkMediaPlayerItem.IjkMediaPlayerItemAssetUpdateListener() { // from class: tv.danmaku.gifplayer.GifVideoView$mOnAssetUpdateListener$1
            @Override // tv.danmaku.ijk.media.player.IjkMediaPlayerItem.IjkMediaPlayerItemAssetUpdateListener
            public IjkMediaAsset onAssetUpdate(IjkAssetUpdateReason p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                return null;
            }

            @Override // tv.danmaku.ijk.media.player.IjkMediaPlayerItem.IjkMediaPlayerItemAssetUpdateListener
            public String onMeteredNetworkUrlHook(String url, IjkNetworkUtils.NetWorkType type, int reasonType) {
                boolean shouldProcessUrl;
                String processedUrl;
                Intrinsics.checkNotNullParameter(url, "url");
                if (type != null) {
                    shouldProcessUrl = GifVideoView.this.shouldProcessUrl();
                    if (shouldProcessUrl) {
                        processedUrl = GifVideoView.this.processUrl(url);
                        if (TextUtils.isEmpty(processedUrl)) {
                            return url;
                        }
                        return processedUrl;
                    }
                    return url;
                }
                BLog.w("GifVideoView", "onMeteredNetworkUrlHook network type is null!");
                return url;
            }
        };
        setSurfaceTextureListener(this);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-1, -1);
        params.gravity = 17;
        setLayoutParams(params);
    }

    /* compiled from: GifVideoView.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/gifplayer/GifVideoView$Companion;", "", "<init>", "()V", "GIF_VIDEO_VIEW_FRAGMENT_TAG", "", "TAG", "MODE_NET", "", "MODE_OFFLINE", "PLAY_COMPLETED", "sCurrentVideo", "Ljava/lang/ref/WeakReference;", "Ltv/danmaku/gifplayer/GifVideoView;", "with", "activity", "Landroidx/fragment/app/FragmentActivity;", "biligifplayer_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GifVideoView with(FragmentActivity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            GifVideoViewFragment findFragmentByTag = activity.getSupportFragmentManager().findFragmentByTag(GifVideoView.GIF_VIDEO_VIEW_FRAGMENT_TAG);
            GifVideoViewFragment fragment = findFragmentByTag instanceof GifVideoViewFragment ? findFragmentByTag : null;
            GifVideoView gifVideoView = null;
            if (fragment != null) {
                gifVideoView = fragment.getGifVideoView$biligifplayer_debug();
            } else {
                fragment = new GifVideoViewFragment();
                activity.getSupportFragmentManager().beginTransaction().add((Fragment) fragment, GifVideoView.GIF_VIDEO_VIEW_FRAGMENT_TAG).commitNowAllowingStateLoss();
            }
            if (gifVideoView != null) {
                return gifVideoView;
            }
            GifVideoView gifVideoView2 = new GifVideoView((Context) activity);
            fragment.setGifVideoView$biligifplayer_debug(gifVideoView2);
            return gifVideoView2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldProcessUrl() {
        return FreeDataManager.getInstance().checkConditionMatched(TfResource.RES_VIDEO).getIsValid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String processUrl(String originUrl) {
        Application context = BiliContext.application();
        if (context == null) {
            return "";
        }
        TfTransformResp result = FreeDataManager.getInstance().processMediaUrl(context, originUrl);
        Intrinsics.checkNotNullExpressionValue(result, "processMediaUrl(...)");
        return TfTransformKt.isSuccessful(result) ? result.getUrl() : "";
    }

    public final void start(Resources resources, FrameLayout container, Listener listener) {
        IjkMediaPlayer ijkMediaPlayer;
        IjkMediaPlayer ijkMediaPlayer2;
        GifVideoView it;
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(listener, "listener");
        WeakReference<GifVideoView> weakReference = sCurrentVideo;
        if (weakReference != null && (it = weakReference.get()) != null && !Intrinsics.areEqual(it, this)) {
            it.stop(true, true);
        }
        ViewParent parent = getParent();
        FrameLayout oldContainer = parent instanceof FrameLayout ? (FrameLayout) parent : null;
        if (!Intrinsics.areEqual(container, oldContainer)) {
            if (oldContainer != null) {
                oldContainer.removeView(this);
            }
            container.addView(this, 0);
            BLog.i(GifVideoViewKt.LOG_TAG, "start ]\n" + container + "\n @" + resources.getPlayUrl());
            Listener listener2 = this.mListener;
            if (listener2 != null) {
                listener2.onStop(true);
            }
        }
        this.mListener = listener;
        sCurrentVideo = new WeakReference<>(this);
        if (!this.mInitialed) {
            this.mMediaPlayer = new IjkMediaPlayer(getContext(), false);
            IjkMediaPlayer ijkMediaPlayer3 = this.mMediaPlayer;
            if (ijkMediaPlayer3 != null) {
                ijkMediaPlayer3.setOnErrorListener(this);
            }
            IjkMediaPlayer ijkMediaPlayer4 = this.mMediaPlayer;
            if (ijkMediaPlayer4 != null) {
                ijkMediaPlayer4.setOnPreparedListener(this);
            }
            IjkMediaPlayer ijkMediaPlayer5 = this.mMediaPlayer;
            if (ijkMediaPlayer5 != null) {
                ijkMediaPlayer5.setOnInfoListener(this);
            }
            this.mInitialed = true;
            this.mIsPrepared = false;
        }
        if (this.mIsPaused) {
            Resources resources2 = this.mResources;
            if (TextUtils.equals(resources2 != null ? resources2.getPlayUrl() : null, resources.getPlayUrl())) {
                IjkMediaPlayer ijkMediaPlayer6 = this.mMediaPlayer;
                if (ijkMediaPlayer6 != null) {
                    ijkMediaPlayer6.start();
                }
                Listener listener3 = this.mListener;
                if (listener3 != null) {
                    listener3.onFirstRender();
                    return;
                }
                return;
            }
        }
        setAlpha(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        IjkMediaPlayerItem newPlayerItem = createIjkMediaItem(resources);
        IjkMediaPlayer ijkMediaPlayer7 = this.mMediaPlayer;
        IjkMediaPlayerItem oldPlayerItem = ijkMediaPlayer7 != null ? ijkMediaPlayer7.getIjkMediaPlayerItem() : null;
        if (oldPlayerItem != null && (ijkMediaPlayer2 = this.mMediaPlayer) != null) {
            ijkMediaPlayer2.removeIjkMediaPlayerItem(oldPlayerItem);
        }
        if (this.mIsPrepared) {
            IjkMediaPlayer ijkMediaPlayer8 = this.mMediaPlayer;
            if (ijkMediaPlayer8 != null) {
                ijkMediaPlayer8.replaceCurrentItem(newPlayerItem);
            }
        } else {
            IjkMediaPlayer ijkMediaPlayer9 = this.mMediaPlayer;
            if (ijkMediaPlayer9 != null) {
                ijkMediaPlayer9.setIjkMediaPlayerItem(newPlayerItem);
            }
            IjkMediaPlayer ijkMediaPlayer10 = this.mMediaPlayer;
            if (ijkMediaPlayer10 != null) {
                ijkMediaPlayer10.prepareAsync();
            }
            this.mIsPrepared = true;
        }
        if (getSurfaceTexture() != null && (ijkMediaPlayer = this.mMediaPlayer) != null) {
            ijkMediaPlayer.setSurface(new Surface(getSurfaceTexture()));
        }
        IjkMediaPlayer ijkMediaPlayer11 = this.mMediaPlayer;
        if (ijkMediaPlayer11 != null) {
            ijkMediaPlayer11.setVolume(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        }
        Resources oldResources = this.mResources;
        if (oldPlayerItem != null && oldResources != null && !TextUtils.equals(oldResources.getPlayUrl(), resources.getPlayUrl())) {
            this.mMediaPlayerItemCache.put(oldResources.getPlayUrl(), oldPlayerItem);
        }
        this.mResources = resources;
    }

    private final IjkMediaPlayerItem createIjkMediaItem(Resources resources) {
        int i;
        IjkMediaPlayerItem cache = (IjkMediaPlayerItem) this.mMediaPlayerItemCache.get(resources.getPlayUrl());
        if (cache != null) {
            BLog.i(TAG, "so lucky hit cache@" + cache + " !!!");
            return cache;
        }
        IjkPluginLibLoader ijkPluginLibLoader = IjkPluginLibLoader.getInstance(getContext());
        Context context = getContext();
        Looper looper = HandlerThreads.getLooper(2);
        if (resources.type() == 2) {
            i = 7;
        } else {
            i = 8;
        }
        IjkMediaPlayerItem ijkMediaPlayerItem = new IjkMediaPlayerItem(ijkPluginLibLoader, context, looper, i);
        ijkMediaPlayerItem.setAssetUpdateListener(this.mOnAssetUpdateListener);
        IjkMediaConfigParams ijkMediaConfigParams = new IjkMediaConfigParams();
        ijkMediaConfigParams.mStartOnPrepared = false;
        ijkMediaConfigParams.mRenderAfterPrepare = false;
        ijkMediaConfigParams.mLoop = !this.mIsLoop ? 1 : 0;
        ijkMediaConfigParams.mEnableHwCodec = true;
        char c = resources.type() != 2 ? (char) 701 : (char) 7;
        IjkMediaAsset.MediaAssertSegment mediaAssertSegment = new IjkMediaAsset.MediaAssertSegment.Builder(resources.getPlayUrl(), 0).build();
        Intrinsics.checkNotNullExpressionValue(mediaAssertSegment, "build(...)");
        ArrayList streams = new ArrayList();
        ArrayList segments = new ArrayList();
        segments.add(mediaAssertSegment);
        IjkMediaAsset.MediaAssetStream mediaAssetStream = new IjkMediaAsset.MediaAssetStream.Builder(IjkMediaAsset.StreamType.NORMAL, IjkMediaAsset.VideoCodecType.H264, 0).setMediaAssertSegments(segments).build();
        Intrinsics.checkNotNullExpressionValue(mediaAssetStream, "build(...)");
        streams.add(mediaAssetStream);
        IjkMediaAsset asset = new IjkMediaAsset.Builder(streams, 0, 0).build();
        Intrinsics.checkNotNullExpressionValue(asset, "build(...)");
        ijkMediaPlayerItem.init(asset, ijkMediaConfigParams);
        ijkMediaPlayerItem.setRenderAfterPrepared(true);
        return ijkMediaPlayerItem;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        SurfaceTexture it = this.mCachedSurfaceTexture;
        if (it != null && !Intrinsics.areEqual(surface, it)) {
            Surface surface2 = this.mCachedSurface;
            if (surface2 != null) {
                surface2.release();
            }
            this.mCachedSurface = null;
            this.mCachedSurfaceTexture = null;
        }
        this.mCachedSurface = new Surface(surface);
        this.mCachedSurfaceTexture = surface;
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.setSurface(this.mCachedSurface);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        Intrinsics.checkNotNullParameter(surface, "surface");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        Intrinsics.checkNotNullParameter(surface, "surface");
        return false;
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mCachedSurface != null) {
            Surface surface = this.mCachedSurface;
            boolean z = false;
            if (surface != null && surface.isValid()) {
                z = true;
            }
            if (z && getSurfaceTexture() == null) {
                SurfaceTexture surfaceTexture = this.mCachedSurfaceTexture;
                Intrinsics.checkNotNull(surfaceTexture);
                setSurfaceTexture(surfaceTexture);
            }
        }
    }

    public static /* synthetic */ void stop$default(GifVideoView gifVideoView, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        gifVideoView.stop(z, z2);
    }

    public final void stop(boolean byOther, boolean release) {
        IjkMediaPlayer ijkMediaPlayer;
        if (!this.mInitialed) {
            return;
        }
        IjkMediaPlayer ijkMediaPlayer2 = this.mMediaPlayer;
        IjkMediaPlayerItem currentItem = ijkMediaPlayer2 != null ? ijkMediaPlayer2.getIjkMediaPlayerItem() : null;
        if (release) {
            if (currentItem != null) {
                currentItem.release();
            }
            if (currentItem != null) {
                currentItem.setAssetUpdateListener(null);
            }
            this.mMediaPlayerItemCache.evictAll();
            IjkMediaPlayer ijkMediaPlayer3 = this.mMediaPlayer;
            if (ijkMediaPlayer3 != null) {
                ijkMediaPlayer3.release();
            }
            Surface surface = this.mCachedSurface;
            if (surface != null) {
                surface.release();
            }
            this.mInitialed = false;
            this.mIsPaused = false;
            this.mMediaPlayer = null;
        } else {
            this.mIsPaused = true;
            if (!this.mIsLoop && (ijkMediaPlayer = this.mMediaPlayer) != null) {
                ijkMediaPlayer.seekTo(0L);
            }
            IjkMediaPlayer ijkMediaPlayer4 = this.mMediaPlayer;
            if (ijkMediaPlayer4 != null) {
                ijkMediaPlayer4.pause();
            }
        }
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onStop(byOther);
        }
    }

    public final void setFillType(int type) {
        this.mFillType = type;
    }

    public final void setPlayLoopMode(boolean isLoop) {
        this.mIsLoop = isLoop;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
    public boolean onError(IMediaPlayer p0, int what, int extra) {
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onError();
            return true;
        }
        return true;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
    public boolean onInfo(IMediaPlayer p0, int what, int extra, Bundle bundle) {
        if (extra == 6) {
            BLog.i(GifVideoViewKt.LOG_TAG, "onInfo player is complete, extra is " + extra + " ,what is " + what + " ");
            Listener listener = this.mListener;
            if (listener != null) {
                listener.onComplete();
            }
        }
        if (what == 3) {
            onFirstRender();
            return true;
        }
        return true;
    }

    private final void onFirstRender() {
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onFirstRender();
        }
        setAlpha(1.0f);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
    public void onPrepared(IMediaPlayer player) {
        this.mVideoWidth = player != null ? player.getVideoWidth() : 0;
        this.mVideoHeight = player != null ? player.getVideoHeight() : 0;
        IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.start();
        }
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.mVideoHeight <= 0 || this.mVideoWidth <= 0) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int maxWidth = View.MeasureSpec.getSize(widthMeasureSpec);
        int maxHeight = View.MeasureSpec.getSize(heightMeasureSpec);
        this.mTempViewPort.set(0, 0, maxWidth, maxHeight);
        calculateVideoDisplaySize(this.mTempPoint, this.mFillType, this.mTempViewPort, this.mVideoWidth, this.mVideoHeight);
        setMeasuredDimension(this.mTempPoint.x, this.mTempPoint.y);
    }

    private final float getVideoDisplayRatio(int fillType, Rect viewPort, int videoWidth, int videoHeight) {
        float videoRatio;
        float viewPortRatio = viewPort.width() / viewPort.height();
        switch (fillType) {
            case 2:
            case 3:
                videoRatio = videoWidth / videoHeight;
                break;
            default:
                videoRatio = viewPortRatio;
                break;
        }
        float displayRatio = videoRatio;
        return displayRatio;
    }

    private final void calculateVideoDisplaySize(Point point, int fillType, Rect viewPort, int videoWidth, int videoHeight) {
        int width;
        int height;
        float displayRatio = getVideoDisplayRatio(fillType, viewPort, videoWidth, videoHeight);
        int viewPortWidth = viewPort.width();
        int viewPortHeight = viewPort.height();
        float viewPortRatio = viewPortWidth / viewPortHeight;
        if (fillType != 3) {
            width = viewPortRatio <= displayRatio ? viewPortWidth : (int) ((viewPortHeight * displayRatio) + 0.5d);
            height = viewPortRatio > displayRatio ? viewPortHeight : (int) ((viewPortWidth / displayRatio) + 0.5d);
        } else {
            width = viewPortRatio > displayRatio ? viewPortWidth : (int) ((viewPortHeight * displayRatio) + 0.5d);
            height = viewPortRatio <= displayRatio ? viewPortHeight : (int) ((viewPortWidth / displayRatio) + 0.5d);
        }
        point.set(width, height);
    }
}