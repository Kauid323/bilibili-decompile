package tv.danmaku.bili.splash.ad.player.component;

import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bilibili.app.comm.list.common.widget.PromoToast;
import com.bilibili.lib.homepage.splash.SplashViewModel;
import com.bilibili.lib.homepage.splash.actions.PlayerEvent;
import com.bilibili.lib.media.resource.MediaResource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.utils.SplashUtilKt;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.video.bilicardplayer.ICardPlaySateChangedCallback;
import tv.danmaku.video.bilicardplayer.ICardPlayerContext;
import tv.danmaku.video.bilicardplayer.ICardPlayerInfoListener;
import tv.danmaku.video.bilicardplayer.player.BiliCardPlayerScene;

/* compiled from: PlayerCallbackRegisterComponent.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u001c\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u001a\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006\"\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"registerIjkPlayerStateCallback", "", "Landroidx/fragment/app/Fragment;", "player", "Ltv/danmaku/ijk/media/player/IjkMediaPlayer;", "viewModel", "Lcom/bilibili/lib/homepage/splash/SplashViewModel;", "registerMediaPlayerStateCallback", "Landroid/media/MediaPlayer;", "registerCardPlayerStateCallback", "task", "Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene$CardPlayTask;", "TAG", "", "splashwidget_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PlayerCallbackRegisterComponentKt {
    private static final String TAG = "[Splash]PlayerStateComponent";

    public static final void registerIjkPlayerStateCallback(Fragment $this$registerIjkPlayerStateCallback, IjkMediaPlayer player, final SplashViewModel viewModel) {
        Intrinsics.checkNotNullParameter($this$registerIjkPlayerStateCallback, "<this>");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (player == null) {
            return;
        }
        BLog.i(TAG, "setVideoPrepareCallback");
        viewModel.update(PlayerEvent.OnPreparing.INSTANCE);
        if (SplashUtilKt.isDebug()) {
            PromoToast.showMidToast($this$registerIjkPlayerStateCallback.getContext(), "闪屏视频开始加载");
        }
        player.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() { // from class: tv.danmaku.bili.splash.ad.player.component.PlayerCallbackRegisterComponentKt$$ExternalSyntheticLambda0
            public final void onPrepared(IMediaPlayer iMediaPlayer) {
                PlayerCallbackRegisterComponentKt.registerIjkPlayerStateCallback$lambda$0(viewModel, iMediaPlayer);
            }
        });
        player.setOnCompletionListener(new IMediaPlayer.OnCompletionListener() { // from class: tv.danmaku.bili.splash.ad.player.component.PlayerCallbackRegisterComponentKt$$ExternalSyntheticLambda1
            public final void onCompletion(IMediaPlayer iMediaPlayer) {
                PlayerCallbackRegisterComponentKt.registerIjkPlayerStateCallback$lambda$1(viewModel, iMediaPlayer);
            }
        });
        player.setOnInfoListener(new IMediaPlayer.OnInfoListener() { // from class: tv.danmaku.bili.splash.ad.player.component.PlayerCallbackRegisterComponentKt$$ExternalSyntheticLambda2
            public final boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2, Bundle bundle) {
                boolean registerIjkPlayerStateCallback$lambda$2;
                registerIjkPlayerStateCallback$lambda$2 = PlayerCallbackRegisterComponentKt.registerIjkPlayerStateCallback$lambda$2(viewModel, iMediaPlayer, i, i2, bundle);
                return registerIjkPlayerStateCallback$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerIjkPlayerStateCallback$lambda$0(SplashViewModel $viewModel, IMediaPlayer it) {
        $viewModel.update(PlayerEvent.OnPrepared.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerIjkPlayerStateCallback$lambda$1(SplashViewModel $viewModel, IMediaPlayer it) {
        $viewModel.update(PlayerEvent.OnCompleted.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean registerIjkPlayerStateCallback$lambda$2(SplashViewModel $viewModel, IMediaPlayer iMediaPlayer, int what, int extra, Bundle bundle) {
        if (what == 3) {
            $viewModel.update(PlayerEvent.OnRenderStart.INSTANCE);
            return false;
        }
        return false;
    }

    public static final void registerMediaPlayerStateCallback(Fragment $this$registerMediaPlayerStateCallback, final MediaPlayer player, final SplashViewModel viewModel) {
        Intrinsics.checkNotNullParameter($this$registerMediaPlayerStateCallback, "<this>");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (player == null) {
            return;
        }
        BLog.i(TAG, "setVideoPrepareCallback");
        viewModel.update(PlayerEvent.OnPreparing.INSTANCE);
        if (SplashUtilKt.isDebug()) {
            PromoToast.showMidToast($this$registerMediaPlayerStateCallback.getContext(), "闪屏视频开始加载");
        }
        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: tv.danmaku.bili.splash.ad.player.component.PlayerCallbackRegisterComponentKt$$ExternalSyntheticLambda3
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer) {
                PlayerCallbackRegisterComponentKt.registerMediaPlayerStateCallback$lambda$0(viewModel, player, mediaPlayer);
            }
        });
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: tv.danmaku.bili.splash.ad.player.component.PlayerCallbackRegisterComponentKt$$ExternalSyntheticLambda4
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer) {
                PlayerCallbackRegisterComponentKt.registerMediaPlayerStateCallback$lambda$1(viewModel, mediaPlayer);
            }
        });
        player.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: tv.danmaku.bili.splash.ad.player.component.PlayerCallbackRegisterComponentKt$$ExternalSyntheticLambda5
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                boolean registerMediaPlayerStateCallback$lambda$2;
                registerMediaPlayerStateCallback$lambda$2 = PlayerCallbackRegisterComponentKt.registerMediaPlayerStateCallback$lambda$2(viewModel, mediaPlayer, i, i2);
                return registerMediaPlayerStateCallback$lambda$2;
            }
        });
        player.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: tv.danmaku.bili.splash.ad.player.component.PlayerCallbackRegisterComponentKt$$ExternalSyntheticLambda6
            @Override // android.media.MediaPlayer.OnInfoListener
            public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                boolean registerMediaPlayerStateCallback$lambda$3;
                registerMediaPlayerStateCallback$lambda$3 = PlayerCallbackRegisterComponentKt.registerMediaPlayerStateCallback$lambda$3(viewModel, mediaPlayer, i, i2);
                return registerMediaPlayerStateCallback$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerMediaPlayerStateCallback$lambda$0(SplashViewModel $viewModel, MediaPlayer $player, MediaPlayer it) {
        $viewModel.update(PlayerEvent.OnPrepared.INSTANCE);
        $player.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerMediaPlayerStateCallback$lambda$1(SplashViewModel $viewModel, MediaPlayer it) {
        $viewModel.update(PlayerEvent.OnCompleted.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean registerMediaPlayerStateCallback$lambda$2(SplashViewModel $viewModel, MediaPlayer mediaPlayer, int what, int i) {
        $viewModel.update(new PlayerEvent.OnError("errcode = " + what));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean registerMediaPlayerStateCallback$lambda$3(SplashViewModel $viewModel, MediaPlayer mediaPlayer, int what, int i) {
        if (what == 3) {
            $viewModel.update(PlayerEvent.OnRenderStart.INSTANCE);
            return false;
        }
        return false;
    }

    public static final void registerCardPlayerStateCallback(Fragment $this$registerCardPlayerStateCallback, BiliCardPlayerScene.CardPlayTask task, final SplashViewModel viewModel) {
        Intrinsics.checkNotNullParameter($this$registerCardPlayerStateCallback, "<this>");
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        viewModel.update(PlayerEvent.OnPreparing.INSTANCE);
        task.addCardPlayInfoListener(new ICardPlayerInfoListener() { // from class: tv.danmaku.bili.splash.ad.player.component.PlayerCallbackRegisterComponentKt$registerCardPlayerStateCallback$1
            public void onInfo(int what, Object params) {
                if (what == 2) {
                    viewModel.update(PlayerEvent.OnRenderStart.INSTANCE);
                }
            }
        }).addPlayerStateChangedCallback(new ICardPlaySateChangedCallback() { // from class: tv.danmaku.bili.splash.ad.player.component.PlayerCallbackRegisterComponentKt$registerCardPlayerStateCallback$2
            public /* synthetic */ void onPreparing(ICardPlayerContext iCardPlayerContext) {
                ICardPlaySateChangedCallback.-CC.$default$onPreparing(this, iCardPlayerContext);
            }

            public /* synthetic */ boolean onSourcePlayable(ICardPlayerContext iCardPlayerContext, MediaResource mediaResource) {
                return ICardPlaySateChangedCallback.-CC.$default$onSourcePlayable(this, iCardPlayerContext, mediaResource);
            }

            public void onStart(ICardPlayerContext context) {
                Intrinsics.checkNotNullParameter(context, "context");
                ICardPlaySateChangedCallback.-CC.$default$onStart(this, context);
                BLog.i("[Splash]PlayerStateComponent", "addPlayerStateChangedCallback, onStart");
            }

            public void onPrepared(ICardPlayerContext context) {
                Intrinsics.checkNotNullParameter(context, "context");
                ICardPlaySateChangedCallback.-CC.$default$onPrepared(this, context);
                BLog.i("[Splash]PlayerStateComponent", "addPlayerStateChangedCallback, onPrepared");
                viewModel.update(PlayerEvent.OnPrepared.INSTANCE);
            }

            public void onResume(ICardPlayerContext context) {
                Intrinsics.checkNotNullParameter(context, "context");
                ICardPlaySateChangedCallback.-CC.$default$onResume(this, context);
                BLog.i("[Splash]PlayerStateComponent", "addPlayerStateChangedCallback, onResume");
            }

            public void onPause(ICardPlayerContext context) {
                Intrinsics.checkNotNullParameter(context, "context");
                ICardPlaySateChangedCallback.-CC.$default$onPause(this, context);
                BLog.i("[Splash]PlayerStateComponent", "addPlayerStateChangedCallback, onPause");
                viewModel.update(PlayerEvent.OnPause.INSTANCE);
            }

            public void onCompleted(ICardPlayerContext context) {
                Intrinsics.checkNotNullParameter(context, "context");
                ICardPlaySateChangedCallback.-CC.$default$onCompleted(this, context);
                BLog.i("[Splash]PlayerStateComponent", "addPlayerStateChangedCallback, onCompleted");
                viewModel.update(PlayerEvent.OnCompleted.INSTANCE);
            }

            public void onStop(ICardPlayerContext context) {
                Intrinsics.checkNotNullParameter(context, "context");
                ICardPlaySateChangedCallback.-CC.$default$onStop(this, context);
                BLog.i("[Splash]PlayerStateComponent", "addPlayerStateChangedCallback, onStop");
            }

            public void onError(ICardPlayerContext context) {
                Intrinsics.checkNotNullParameter(context, "context");
                ICardPlaySateChangedCallback.-CC.$default$onError(this, context);
                BLog.i("[Splash]PlayerStateComponent", "addPlayerStateChangedCallback, onError");
                viewModel.update(new PlayerEvent.OnError("card player error"));
            }
        });
    }
}