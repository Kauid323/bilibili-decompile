package tv.danmaku.bili.splash.ad.player;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.net.Uri;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bilibili.gripper.api.ad.core.GAdCoreKt;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.ui.util.StatusBarCompat;
import com.bilibili.moduleservice.story.StoryUIProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.model.SplashVideoInfo;
import tv.danmaku.bili.splash.ad.player.dataprovider.SplashCardPlayerConfigKt;
import tv.danmaku.bili.splash.ad.player.dataprovider.SplashPlayableParams;
import tv.danmaku.bili.splash.ad.utils.ui.BezierInterpolator;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;
import tv.danmaku.biliplayerv2.PlayerSharingType;
import tv.danmaku.biliplayerv2.panel.BuiltInLayer;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.video.bilicardplayer.BiliCardPlayerManager;
import tv.danmaku.video.bilicardplayer.player.BiliCardPlayerScene;
import tv.danmaku.video.bilicardplayer.player.PlayerExtraConfiguration;
import tv.danmaku.videoplayer.core.videoview.AspectRatio;

/* compiled from: SplashCardPlayer.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\n0\t\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u001f\u001a\u00020\nJ\u0006\u0010&\u001a\u00020\nJ\u001c\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\n0+J\u0010\u0010,\u001a\u00020\n2\u0006\u0010(\u001a\u00020)H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b%\u0010#¨\u0006-"}, d2 = {"Ltv/danmaku/bili/splash/ad/player/SplashCardPlayer;", "", "fragment", "Landroidx/fragment/app/Fragment;", "container", "Landroid/view/ViewGroup;", UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH, "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "onInitPlayerReporter", "Lkotlin/Function1;", "", "onRegisterStateCallback", "<init>", "(Landroidx/fragment/app/Fragment;Landroid/view/ViewGroup;Ltv/danmaku/bili/splash/ad/model/SplashOrder;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "getContainer", "()Landroid/view/ViewGroup;", "getSplash", "()Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "token", "Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene$CardPlayTask$Token;", "playerScene", "Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene;", "isPlayerShared", "", "value", "Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene$CardPlayTask;", "task", "getTask", "()Ltv/danmaku/video/bilicardplayer/player/BiliCardPlayerScene$CardPlayTask;", "play", "currentPosition", "", "getCurrentPosition", "()J", "duration", "getDuration", "stop", "sharePlayer", "jumpUrl", "", "onEnd", "Lkotlin/Function0;", "jumpToStory", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashCardPlayer {
    public static final int $stable = 8;
    private final ViewGroup container;
    private final Fragment fragment;
    private boolean isPlayerShared;
    private BiliCardPlayerScene playerScene;
    private final SplashOrder splash;
    private BiliCardPlayerScene.CardPlayTask task;
    private BiliCardPlayerScene.CardPlayTask.Token token;

    public SplashCardPlayer(Fragment fragment, ViewGroup container, SplashOrder splash, Function1<? super SplashCardPlayer, Unit> function1, Function1<? super SplashCardPlayer, Unit> function12) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        Intrinsics.checkNotNullParameter(function1, "onInitPlayerReporter");
        Intrinsics.checkNotNullParameter(function12, "onRegisterStateCallback");
        this.fragment = fragment;
        this.container = container;
        this.splash = splash;
        this.task = BiliCardPlayerScene.CardPlayTask.Companion.obtain();
        function1.invoke(this);
        function12.invoke(this);
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    public final ViewGroup getContainer() {
        return this.container;
    }

    public final SplashOrder getSplash() {
        return this.splash;
    }

    public final BiliCardPlayerScene.CardPlayTask getTask() {
        return this.task;
    }

    public final void play() {
        BiliCardPlayerScene.CardPlayTask task = this.task;
        if (task == null) {
            return;
        }
        task.setContainer(this.container).setShowWhenFirstRender(true).setMute(true).setNetworkToastEnable(false).setCommonResolveTaskProvider(GAdCoreKt.getGAdPlayer().getResolveTaskProvider()).addPlayableParams(new SplashPlayableParams(this.splash));
        BiliCardPlayerScene $this$play_u24lambda_u240 = BiliCardPlayerManager.INSTANCE.with(this.fragment);
        PlayerExtraConfiguration $this$play_u24lambda_u240_u240 = new PlayerExtraConfiguration();
        $this$play_u24lambda_u240_u240.setKeepRender(true ^ SplashCardPlayerConfigKt.isDeviceInPlayerBlackList());
        $this$play_u24lambda_u240.setPlayerExtraConfiguration($this$play_u24lambda_u240_u240);
        this.playerScene = $this$play_u24lambda_u240;
        BiliCardPlayerScene scene = this.playerScene;
        if (scene == null) {
            return;
        }
        BiliCardPlayerScene.CardPlayTask.Token $this$play_u24lambda_u241 = scene.commit(task);
        $this$play_u24lambda_u241.hideBufferingView();
        $this$play_u24lambda_u241.setAspectRatio(AspectRatio.RATIO_CENTER_CROP);
        this.token = $this$play_u24lambda_u241;
    }

    public final long getCurrentPosition() {
        BiliCardPlayerScene.CardPlayTask.Token token = this.token;
        if (token != null) {
            return token.getCurrentPosition();
        }
        return 0L;
    }

    public final long getDuration() {
        BiliCardPlayerScene.CardPlayTask.Token token = this.token;
        if (token != null) {
            return token.getDuration();
        }
        return 0L;
    }

    public final void stop() {
        BiliCardPlayerScene.CardPlayTask.Token token = this.token;
        if (token != null) {
            token.stop();
        }
        BiliCardPlayerScene biliCardPlayerScene = this.playerScene;
        if (biliCardPlayerScene != null) {
            biliCardPlayerScene.release();
        }
        this.playerScene = null;
        this.task = null;
    }

    public final void sharePlayer(final String jumpUrl, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(function0, "onEnd");
        StoryUIProvider storyUIProvider = (StoryUIProvider) BLRouter.get$default(BLRouter.INSTANCE, StoryUIProvider.class, (String) null, 2, (Object) null);
        int unusableHeight = storyUIProvider != null ? storyUIProvider.getBottomBarHeight(this.fragment.getActivity()) : 0;
        final int statusBarDrawHeight = StatusBarCompat.getStatusBarHeight(this.container.getContext());
        final int videoStartHeight = this.container.getHeight();
        int videoTargetHeight = (this.container.getHeight() - unusableHeight) - statusBarDrawHeight;
        final int videoInterval = videoTargetHeight - videoStartHeight;
        final Rect rect = new Rect(0, 0, this.container.getWidth(), videoStartHeight);
        ValueAnimator $this$sharePlayer_u24lambda_u240 = ValueAnimator.ofFloat(0.0f, 1.0f);
        $this$sharePlayer_u24lambda_u240.setInterpolator(new BezierInterpolator(0.4f, -0.57f, 0.74f, 1.0f));
        $this$sharePlayer_u24lambda_u240.setDuration(400L);
        $this$sharePlayer_u24lambda_u240.addListener(new Animator.AnimatorListener() { // from class: tv.danmaku.bili.splash.ad.player.SplashCardPlayer$sharePlayer$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                BLog.i("[Splash]SplashCardPlayer", "onAnimationEnd");
                SplashCardPlayer.this.jumpToStory(jumpUrl);
                function0.invoke();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        });
        $this$sharePlayer_u24lambda_u240.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.splash.ad.player.SplashCardPlayer$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SplashCardPlayer.sharePlayer$lambda$1(statusBarDrawHeight, r2, videoStartHeight, videoInterval, rect, this, valueAnimator);
            }
        });
        $this$sharePlayer_u24lambda_u240.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sharePlayer$lambda$1(int $statusBarDrawHeight, int $storyVideoOffset, int $videoStartHeight, int $videoInterval, Rect $rect, SplashCardPlayer this$0, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float percent = ((Float) animatedValue).floatValue();
        int top = (int) (($statusBarDrawHeight - $storyVideoOffset) * percent);
        int bottom = top + $videoStartHeight + ((int) ($videoInterval * percent));
        $rect.top = top;
        $rect.bottom = bottom;
        BiliCardPlayerScene biliCardPlayerScene = this$0.playerScene;
        if (biliCardPlayerScene != null) {
            BiliCardPlayerScene.updateViewPort$default(biliCardPlayerScene, $rect, CollectionsKt.listOf(BuiltInLayer.LayerRender), (List) null, true, 4, (Object) null);
        }
        BLog.i("[Splash]SplashCardPlayer", "percent " + percent + ", offset " + top + ", rect " + $rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void jumpToStory(String jumpUrl) {
        Video.PlayableParams currentPlayableParams;
        Video.DisplayParams displayParams;
        BiliCardPlayerScene biliCardPlayerScene = this.playerScene;
        final Integer shareId = biliCardPlayerScene != null ? Integer.valueOf(BiliCardPlayerScene.prepareForShare$default(biliCardPlayerScene, false, 1, (Object) null)) : null;
        BiliCardPlayerScene.CardPlayTask.Token token = this.token;
        final Object aspect = (token == null || (currentPlayableParams = token.getCurrentPlayableParams()) == null || (displayParams = currentPlayableParams.getDisplayParams()) == null) ? AspectRatio.RATIO_CENTER_CROP : Float.valueOf(displayParams.getDisplayRotate());
        RouteRequest.Builder routeRequest = new RouteRequest.Builder(jumpUrl);
        Uri originUri = routeRequest.getTargetUri();
        if (Intrinsics.areEqual(originUri.getScheme(), "bilibili") && Intrinsics.areEqual(originUri.getAuthority(), AppConfig.HOST_STORY)) {
            Uri build = originUri.buildUpon().authority(AppConfig.HOST_TRANSLUCENT_STORY).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            routeRequest.setTargetUri(build);
        }
        BLRouter.routeTo(routeRequest.extras(new Function1() { // from class: tv.danmaku.bili.splash.ad.player.SplashCardPlayer$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit jumpToStory$lambda$0;
                jumpToStory$lambda$0 = SplashCardPlayer.jumpToStory$lambda$0(SplashCardPlayer.this, shareId, aspect, (MutableBundleLike) obj);
                return jumpToStory$lambda$0;
            }
        }).overridePendingTransition(0, 0).build(), this.fragment.getActivity());
        this.isPlayerShared = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit jumpToStory$lambda$0(SplashCardPlayer this$0, Integer $shareId, Object $aspect, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        SplashVideoInfo splashStoryInfo = this$0.splash.getSplashStoryInfo();
        $this$extras.put("avid", String.valueOf(splashStoryInfo != null ? splashStoryInfo.getAvid() : 0L));
        $this$extras.put("player_share", "1");
        $this$extras.put("bundle_key_player_shared_type", String.valueOf(PlayerSharingType.NORMAL.ordinal()));
        $this$extras.put("bundle_key_player_shared_id", String.valueOf($shareId));
        $this$extras.put("video_aspect", $aspect.toString());
        $this$extras.put("player_height", String.valueOf(this$0.splash.getVideoHeight()));
        $this$extras.put("player_width", String.valueOf(this$0.splash.getVideoWidth()));
        $this$extras.put("player_rotate", "0");
        $this$extras.put("from_spmid", BusinessSplashDefineKt.SPLASH_SPMID);
        return Unit.INSTANCE;
    }
}