package tv.danmaku.bili.splash.ad.player;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.log.BuildConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.v2.InnerPushReceiverKt;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefine;
import tv.danmaku.bili.splash.ad.utils.ui.SplashLayoutUtilsKt;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayerItem;
import tv.danmaku.ijk.media.player.utils.IjkMediaPlayerItemBuilder;

/* compiled from: SplashAlphaPlayer.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B{\b\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\u0004\b\u0016\u0010\u0017J \u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\rH\u0016J \u00102\u001a\u00020\u00122\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\rH\u0016J\u0010\u00103\u001a\u00020)2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00104\u001a\u00020\u00122\u0006\u0010.\u001a\u00020/H\u0016J,\u00105\u001a\u00020)2\b\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u00020\r2\u0006\u00109\u001a\u00020\r2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u0012\u0010<\u001a\u00020\u00122\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0012\u0010=\u001a\u00020\u00122\b\u00106\u001a\u0004\u0018\u000107H\u0016J\"\u0010\u0015\u001a\u00020)2\b\u00106\u001a\u0004\u0018\u0001072\u0006\u0010>\u001a\u00020\r2\u0006\u0010?\u001a\u00020\rH\u0016J2\u0010A\u001a\u00020\u00122\b\u00106\u001a\u0004\u0018\u0001072\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\r2\u0006\u0010B\u001a\u00020\r2\u0006\u0010C\u001a\u00020\rH\u0016J\u0006\u0010D\u001a\u00020#J\b\u0010F\u001a\u00020%H\u0002J\u0010\u0010G\u001a\u00020H2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0006\u0010I\u001a\u00020\u0012J\u0006\u0010J\u001a\u00020\u0012J\u0006\u0010K\u001a\u00020\u0012J\u0006\u0010L\u001a\u00020\u0012J\u0006\u0010M\u001a\u00020\u0012J\u0006\u0010N\u001a\u00020\u0012J\u0006\u0010O\u001a\u00020)J\b\u0010T\u001a\u00020\u0012H\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010*\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u000e\u0010@\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010P\u001a\u00020Q8F¢\u0006\u0006\u001a\u0004\bR\u0010S¨\u0006U"}, d2 = {"Ltv/danmaku/bili/splash/ad/player/SplashAlphaPlayer;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/TextureView$SurfaceTextureListener;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnInfoListener;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnPreparedListener;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnCompletionListener;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnErrorListener;", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnVideoSizeChangedListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "url", "", "onFirstFrameRenderingStart", "Lkotlin/Function0;", "", "onCompletionListener", "onSurfaceTextureDestroyedListener", "onError", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getOnFirstFrameRenderingStart", "()Lkotlin/jvm/functions/Function0;", "setOnFirstFrameRenderingStart", "(Lkotlin/jvm/functions/Function0;)V", "getOnCompletionListener", "setOnCompletionListener", "getOnSurfaceTextureDestroyedListener", "setOnSurfaceTextureDestroyedListener", "getOnError", "setOnError", "textureView", "Landroid/view/TextureView;", "mediaPlayer", "Ltv/danmaku/ijk/media/player/IjkMediaPlayer;", "surface", "Landroid/view/Surface;", "mFirstFrameHasRender", "", "firstFrameHasRender", "getFirstFrameHasRender", "()Z", "onSurfaceTextureAvailable", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "height", "onSurfaceTextureSizeChanged", "onSurfaceTextureDestroyed", "onSurfaceTextureUpdated", "onInfo", "player", "Ltv/danmaku/ijk/media/player/IMediaPlayer;", "what", InnerPushReceiverKt.KEY_EXTRA, "bundle", "Landroid/os/Bundle;", "onPrepared", "onCompletion", "p1", "p2", "sizeChanged", "onVideoSizeChanged", "sarNum", "sarDen", "getTextureView", "isPrepared", "createMediaPlayer", "createIjkMediaItem", "Ltv/danmaku/ijk/media/player/IjkMediaPlayerItem;", "play", "restart", "pause", "resume", "stop", BuildConfig.BUILD_TYPE, "hasPrepared", "currentPlayTime", "", "getCurrentPlayTime", "()J", "innerStart", "splashwidget_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashAlphaPlayer extends ConstraintLayout implements TextureView.SurfaceTextureListener, IMediaPlayer.OnInfoListener, IMediaPlayer.OnPreparedListener, IMediaPlayer.OnCompletionListener, IMediaPlayer.OnErrorListener, IMediaPlayer.OnVideoSizeChangedListener {
    public static final int $stable = 8;
    private boolean isPrepared;
    private boolean mFirstFrameHasRender;
    private IjkMediaPlayer mediaPlayer;
    private Function0<Unit> onCompletionListener;
    private Function0<Unit> onError;
    private Function0<Unit> onFirstFrameRenderingStart;
    private Function0<Unit> onSurfaceTextureDestroyedListener;
    private boolean sizeChanged;
    private Surface surface;
    private final TextureView textureView;
    private final String url;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SplashAlphaPlayer(Context context) {
        this(context, null, 0, null, null, null, null, null, BR.half, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SplashAlphaPlayer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, null, null, null, null, null, BR.guideBarPaddingTop, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SplashAlphaPlayer(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, null, null, null, null, null, BR.guestPureEnjoyMsgList, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SplashAlphaPlayer(Context context, AttributeSet attributeSet, int i, String str) {
        this(context, attributeSet, i, str, null, null, null, null, BR.foregroundViewVisible, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SplashAlphaPlayer(Context context, AttributeSet attributeSet, int i, String str, Function0<Unit> function0) {
        this(context, attributeSet, i, str, function0, null, null, null, BR.followIconDrawable, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SplashAlphaPlayer(Context context, AttributeSet attributeSet, int i, String str, Function0<Unit> function0, Function0<Unit> function02) {
        this(context, attributeSet, i, str, function0, function02, null, null, 192, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SplashAlphaPlayer(Context context, AttributeSet attributeSet, int i, String str, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03) {
        this(context, attributeSet, i, str, function0, function02, function03, null, BR.cover, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashAlphaPlayer(Context context, AttributeSet attrs, int defStyleAttr, String url, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function0<Unit> function04) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.url = url;
        this.onFirstFrameRenderingStart = function0;
        this.onCompletionListener = function02;
        this.onSurfaceTextureDestroyedListener = function03;
        this.onError = function04;
        TextureView $this$textureView_u24lambda_u240 = new TextureView(context);
        $this$textureView_u24lambda_u240.setSurfaceTextureListener(this);
        $this$textureView_u24lambda_u240.setOpaque(false);
        $this$textureView_u24lambda_u240.setLayoutParams(SplashLayoutUtilsKt.createMatchParentLayoutParams((ViewGroup) this));
        this.textureView = $this$textureView_u24lambda_u240;
        addView(this.textureView);
    }

    public /* synthetic */ SplashAlphaPlayer(Context context, AttributeSet attributeSet, int i, String str, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? null : str, (i2 & 16) != 0 ? null : function0, (i2 & 32) != 0 ? null : function02, (i2 & 64) != 0 ? null : function03, (i2 & BR.cover) == 0 ? function04 : null);
    }

    public final Function0<Unit> getOnFirstFrameRenderingStart() {
        return this.onFirstFrameRenderingStart;
    }

    public final void setOnFirstFrameRenderingStart(Function0<Unit> function0) {
        this.onFirstFrameRenderingStart = function0;
    }

    public final Function0<Unit> getOnCompletionListener() {
        return this.onCompletionListener;
    }

    public final void setOnCompletionListener(Function0<Unit> function0) {
        this.onCompletionListener = function0;
    }

    public final Function0<Unit> getOnSurfaceTextureDestroyedListener() {
        return this.onSurfaceTextureDestroyedListener;
    }

    public final void setOnSurfaceTextureDestroyedListener(Function0<Unit> function0) {
        this.onSurfaceTextureDestroyedListener = function0;
    }

    public final Function0<Unit> getOnError() {
        return this.onError;
    }

    public final void setOnError(Function0<Unit> function0) {
        this.onError = function0;
    }

    public final boolean getFirstFrameHasRender() {
        return this.mFirstFrameHasRender;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        if (this.url == null) {
            return;
        }
        this.surface = new Surface(surfaceTexture);
        BLog.i("[Splash]SplashAlphaPlayerView", "onSurfaceTextureAvailable");
        if (this.mediaPlayer == null) {
            this.mediaPlayer = createMediaPlayer();
        }
        IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.setIjkMediaPlayerItem(createIjkMediaItem(this.url));
        }
        IjkMediaPlayer ijkMediaPlayer2 = this.mediaPlayer;
        if (ijkMediaPlayer2 != null) {
            ijkMediaPlayer2.prepareAsync();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int width, int height) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
        Function0<Unit> function0 = this.onSurfaceTextureDestroyedListener;
        if (function0 != null) {
            function0.invoke();
        }
        release();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        Intrinsics.checkNotNullParameter(surfaceTexture, "surfaceTexture");
    }

    public boolean onInfo(IMediaPlayer player, int what, int extra, Bundle bundle) {
        if (what == 3) {
            BLog.i("[Splash]SplashAlphaPlayerView", "first frame");
            setAlpha(1.0f);
            this.mFirstFrameHasRender = true;
            Function0<Unit> function0 = this.onFirstFrameRenderingStart;
            if (function0 != null) {
                function0.invoke();
                return false;
            }
            return false;
        }
        return false;
    }

    public void onPrepared(IMediaPlayer player) {
        BLog.i("[Splash]SplashAlphaPlayerView", "onPrepared, vWidth = " + (player != null ? Integer.valueOf(player.getVideoWidth()) : null) + ", vHeight = " + (player != null ? Integer.valueOf(player.getVideoHeight()) : null));
        this.isPrepared = true;
    }

    public void onCompletion(IMediaPlayer player) {
        BLog.i("[Splash]SplashAlphaPlayerView", "onCompletion");
        BLog.i("[Splash]SplashAlphaPlayerView", "onCompletion");
        Function0<Unit> function0 = this.onCompletionListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public boolean onError(IMediaPlayer player, int p1, int p2) {
        Function0<Unit> function0 = this.onError;
        if (function0 != null) {
            function0.invoke();
            return true;
        }
        return true;
    }

    public void onVideoSizeChanged(IMediaPlayer player, int width, int height, int sarNum, int sarDen) {
        int width2 = this.textureView.getWidth();
        BLog.i("[Splash]SplashAlphaPlayerView", "onVideoSizeChanged, vWidth = " + width + ", vHeight = " + height + ", cWidth = " + width2 + ", cHeight = " + this.textureView.getHeight());
        if (this.sizeChanged) {
            return;
        }
        this.sizeChanged = true;
        SplashPlayerHelperKt.centerCropVideo(this.textureView.getWidth(), this.textureView.getHeight(), width, height, this.textureView);
    }

    public final TextureView getTextureView() {
        return this.textureView;
    }

    private final IjkMediaPlayer createMediaPlayer() {
        IjkMediaPlayer $this$createMediaPlayer_u24lambda_u240 = new IjkMediaPlayer(getContext());
        $this$createMediaPlayer_u24lambda_u240.setOnInfoListener(this);
        $this$createMediaPlayer_u24lambda_u240.setOnPreparedListener(this);
        $this$createMediaPlayer_u24lambda_u240.setOnCompletionListener(this);
        $this$createMediaPlayer_u24lambda_u240.setOnErrorListener(this);
        $this$createMediaPlayer_u24lambda_u240.setOnVideoSizeChangedListener(this);
        $this$createMediaPlayer_u24lambda_u240.setVolume(0.0f, 0.0f);
        $this$createMediaPlayer_u24lambda_u240.setSurface(this.surface);
        return $this$createMediaPlayer_u24lambda_u240;
    }

    private final IjkMediaPlayerItem createIjkMediaItem(String url) {
        int scheme = StringsKt.startsWith$default(url, BusinessSplashDefine.FILE_URI_PREFIX, false, 2, (Object) null) ? 5 : 2;
        IjkMediaPlayerItemBuilder $this$createIjkMediaItem_u24lambda_u240 = new IjkMediaPlayerItemBuilder(getContext(), scheme);
        $this$createIjkMediaItem_u24lambda_u240.getConfig().mEnableAlphaLayer = true;
        $this$createIjkMediaItem_u24lambda_u240.getConfig().mStartOnPrepared = false;
        $this$createIjkMediaItem_u24lambda_u240.getConfig().mRenderAfterPrepare = true;
        $this$createIjkMediaItem_u24lambda_u240.getConfig().mForceRenderLastFrame = true;
        $this$createIjkMediaItem_u24lambda_u240.addNormalStream(url);
        IjkMediaPlayerItem build = $this$createIjkMediaItem_u24lambda_u240.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    public final void play() {
        BLog.i("[Splash]SplashAlphaPlayerView", "play");
        IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.start();
        }
    }

    public final void restart() {
        IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.reset();
        }
        IjkMediaPlayer ijkMediaPlayer2 = this.mediaPlayer;
        if (ijkMediaPlayer2 != null) {
            ijkMediaPlayer2.setSurface(this.surface);
        }
        innerStart();
    }

    public final void pause() {
        IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.pause();
        }
    }

    public final void resume() {
        innerStart();
    }

    public final void stop() {
        IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer;
        if (ijkMediaPlayer != null) {
            ijkMediaPlayer.stop();
        }
        IjkMediaPlayer ijkMediaPlayer2 = this.mediaPlayer;
        if (ijkMediaPlayer2 != null) {
            ijkMediaPlayer2.reset();
        }
        IjkMediaPlayer ijkMediaPlayer3 = this.mediaPlayer;
        if (ijkMediaPlayer3 != null) {
            ijkMediaPlayer3.release();
        }
        this.mediaPlayer = null;
        setAlpha(0.0f);
        this.mFirstFrameHasRender = false;
        this.isPrepared = false;
    }

    public final void release() {
        Surface surface = this.surface;
        if (surface != null) {
            surface.release();
        }
        this.surface = null;
        stop();
    }

    public final boolean hasPrepared() {
        return this.isPrepared;
    }

    public final long getCurrentPlayTime() {
        Number number;
        IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer;
        Number $this$orZero$iv = ijkMediaPlayer != null ? Long.valueOf(ijkMediaPlayer.getCurrentPosition()) : null;
        if ($this$orZero$iv != null) {
            number = $this$orZero$iv;
        } else {
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                number = (Long) Double.valueOf(0.0d);
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                number = (Long) Float.valueOf(0.0f);
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                number = (Number) 0L;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                number = (Long) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                number = (Long) (char) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                number = (Long) (short) 0;
            } else if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                throw new RuntimeException("not primitive number type");
            } else {
                number = (Long) (byte) 0;
            }
        }
        return number.longValue();
    }

    private final void innerStart() {
        Number number;
        Number number2;
        IjkMediaPlayer ijkMediaPlayer = this.mediaPlayer;
        Number $this$orZero$iv = ijkMediaPlayer != null ? Long.valueOf(ijkMediaPlayer.getDuration()) : null;
        if ($this$orZero$iv != null) {
            number = $this$orZero$iv;
        } else {
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Long.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                number = (Long) Double.valueOf(0.0d);
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                number = (Long) Float.valueOf(0.0f);
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                number = (Number) 0L;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                number = (Long) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                number = (Long) (char) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                number = (Long) (short) 0;
            } else if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                throw new RuntimeException("not primitive number type");
            } else {
                number = (Long) (byte) 0;
            }
        }
        long duration = number.longValue();
        IjkMediaPlayer ijkMediaPlayer2 = this.mediaPlayer;
        Number $this$orZero$iv2 = ijkMediaPlayer2 != null ? Long.valueOf(ijkMediaPlayer2.getCurrentPosition()) : null;
        if ($this$orZero$iv2 != null) {
            number2 = $this$orZero$iv2;
        } else {
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Long.class);
            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                number2 = (Long) Double.valueOf(0.0d);
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                number2 = (Long) Float.valueOf(0.0f);
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                number2 = (Number) 0L;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                number2 = (Long) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Character.TYPE))) {
                number2 = (Long) (char) 0;
            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                number2 = (Long) (short) 0;
            } else if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                throw new RuntimeException("not primitive number type");
            } else {
                number2 = (Long) (byte) 0;
            }
        }
        long ipCurrentPos = number2.longValue();
        if (ipCurrentPos != duration) {
            IjkMediaPlayer ijkMediaPlayer3 = this.mediaPlayer;
            if (ijkMediaPlayer3 != null) {
                ijkMediaPlayer3.seekTo(duration);
            }
            IjkMediaPlayer ijkMediaPlayer4 = this.mediaPlayer;
            if (ijkMediaPlayer4 != null) {
                ijkMediaPlayer4.start();
            }
        }
    }
}