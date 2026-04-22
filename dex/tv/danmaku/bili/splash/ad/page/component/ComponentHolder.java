package tv.danmaku.bili.splash.ad.page.component;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bilibili.gripper.api.ad.core.player.report.IPlayerReportTracker;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.moduleservice.splash.SplashCoreService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.Job;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.button.SplashButtonHelper;
import tv.danmaku.bili.splash.ad.player.SplashAlphaPlayer;
import tv.danmaku.bili.splash.ad.utils.SplashAudioManager;

/* compiled from: ComponentHolder.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u001a\u0010,\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010.\"\u0004\b9\u00100R\u001a\u0010:\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010.\"\u0004\b<\u00100R\u001c\u0010=\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010 \"\u0004\b?\u0010\"R\u001a\u0010@\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010.\"\u0004\bA\u00100R\u001a\u0010B\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010.\"\u0004\bC\u00100R\u001c\u0010D\u001a\u0004\u0018\u00010EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001c\u0010J\u001a\u0004\u0018\u00010KX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001a\u0010P\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010.\"\u0004\bQ\u00100R\u001c\u0010R\u001a\u0004\u0018\u00010EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010G\"\u0004\bT\u0010IR\u001b\u0010U\u001a\u00020V8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\t\u001a\u0004\bW\u0010XR\u001a\u0010Z\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010.\"\u0004\b\\\u00100R\u001c\u0010]\u001a\u0004\u0018\u00010^X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001c\u0010c\u001a\u0004\u0018\u00010dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001c\u0010i\u001a\u0004\u0018\u00010EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010G\"\u0004\bk\u0010IR\u001a\u0010l\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010.\"\u0004\bn\u00100R\u001c\u0010o\u001a\u0004\u0018\u00010pX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010t¨\u0006u"}, d2 = {"Ltv/danmaku/bili/splash/ad/page/component/ComponentHolder;", "", "<init>", "()V", "splashCoreService", "Lcom/bilibili/moduleservice/splash/SplashCoreService;", "getSplashCoreService", "()Lcom/bilibili/moduleservice/splash/SplashCoreService;", "splashCoreService$delegate", "Lkotlin/Lazy;", "buttonHelper", "Ltv/danmaku/bili/splash/ad/button/SplashButtonHelper;", "getButtonHelper", "()Ltv/danmaku/bili/splash/ad/button/SplashButtonHelper;", "skipSS", "Landroid/text/SpannableString;", "getSkipSS", "()Landroid/text/SpannableString;", "setSkipSS", "(Landroid/text/SpannableString;)V", "countdownSS", "getCountdownSS", "setCountdownSS", "countdownTextColorSpan", "Landroid/text/style/ForegroundColorSpan;", "getCountdownTextColorSpan", "()Landroid/text/style/ForegroundColorSpan;", "setCountdownTextColorSpan", "(Landroid/text/style/ForegroundColorSpan;)V", "countDownJob", "Lkotlinx/coroutines/Job;", "getCountDownJob", "()Lkotlinx/coroutines/Job;", "setCountDownJob", "(Lkotlinx/coroutines/Job;)V", "splashStartTimeMs", "", "getSplashStartTimeMs", "()J", "setSplashStartTimeMs", "(J)V", "viewCreateTimeMs", "getViewCreateTimeMs", "setViewCreateTimeMs", "isShowAnimator", "", "()Z", "setShowAnimator", "(Z)V", "splashId", "", "getSplashId", "()Ljava/lang/String;", "setSplashId", "(Ljava/lang/String;)V", "clickJump", "getClickJump", "setClickJump", "executeAnim", "getExecuteAnim", "setExecuteAnim", "prepareJob", "getPrepareJob", "setPrepareJob", "isReady", "setReady", "isEggPlayFinished", "setEggPlayFinished", "eggPlayer", "Ltv/danmaku/bili/splash/ad/player/SplashAlphaPlayer;", "getEggPlayer", "()Ltv/danmaku/bili/splash/ad/player/SplashAlphaPlayer;", "setEggPlayer", "(Ltv/danmaku/bili/splash/ad/player/SplashAlphaPlayer;)V", "eggCountdownView", "Landroid/view/View;", "getEggCountdownView", "()Landroid/view/View;", "setEggCountdownView", "(Landroid/view/View;)V", "isSecondPageTriggered", "setSecondPageTriggered", "secondPageEggVideoPlayer", "getSecondPageEggVideoPlayer", "setSecondPageEggVideoPlayer", "audioManager", "Ltv/danmaku/bili/splash/ad/utils/SplashAudioManager;", "getAudioManager", "()Ltv/danmaku/bili/splash/ad/utils/SplashAudioManager;", "audioManager$delegate", "openSound", "getOpenSound", "setOpenSound", "topContainer", "Landroid/view/ViewGroup;", "getTopContainer", "()Landroid/view/ViewGroup;", "setTopContainer", "(Landroid/view/ViewGroup;)V", "halfCustomButtonLayer", "Landroid/widget/LinearLayout;", "getHalfCustomButtonLayer", "()Landroid/widget/LinearLayout;", "setHalfCustomButtonLayer", "(Landroid/widget/LinearLayout;)V", "topViewTransitionPlayer", "getTopViewTransitionPlayer", "setTopViewTransitionPlayer", "topViewTransitionCanPlay", "getTopViewTransitionCanPlay", "setTopViewTransitionCanPlay", "playerReporter", "Lcom/bilibili/gripper/api/ad/core/player/report/IPlayerReportTracker;", "getPlayerReporter", "()Lcom/bilibili/gripper/api/ad/core/player/report/IPlayerReportTracker;", "setPlayerReporter", "(Lcom/bilibili/gripper/api/ad/core/player/report/IPlayerReportTracker;)V", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ComponentHolder {
    public static final int $stable = 8;
    private boolean clickJump;
    private Job countDownJob;
    private SpannableString countdownSS;
    private ForegroundColorSpan countdownTextColorSpan;
    private View eggCountdownView;
    private SplashAlphaPlayer eggPlayer;
    private boolean executeAnim;
    private LinearLayout halfCustomButtonLayer;
    private boolean isEggPlayFinished;
    private boolean isReady;
    private boolean isSecondPageTriggered;
    private boolean isShowAnimator;
    private boolean openSound;
    private IPlayerReportTracker playerReporter;
    private Job prepareJob;
    private SplashAlphaPlayer secondPageEggVideoPlayer;
    private SpannableString skipSS;
    private String splashId;
    private long splashStartTimeMs;
    private ViewGroup topContainer;
    private boolean topViewTransitionCanPlay;
    private SplashAlphaPlayer topViewTransitionPlayer;
    private long viewCreateTimeMs;
    private final Lazy splashCoreService$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.splash.ad.page.component.ComponentHolder$$ExternalSyntheticLambda0
        public final Object invoke() {
            SplashCoreService splashCoreService_delegate$lambda$0;
            splashCoreService_delegate$lambda$0 = ComponentHolder.splashCoreService_delegate$lambda$0();
            return splashCoreService_delegate$lambda$0;
        }
    });
    private final SplashButtonHelper buttonHelper = new SplashButtonHelper();
    private final Lazy audioManager$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.splash.ad.page.component.ComponentHolder$$ExternalSyntheticLambda1
        public final Object invoke() {
            SplashAudioManager audioManager_delegate$lambda$0;
            audioManager_delegate$lambda$0 = ComponentHolder.audioManager_delegate$lambda$0();
            return audioManager_delegate$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final SplashCoreService splashCoreService_delegate$lambda$0() {
        return (SplashCoreService) BLRouter.get$default(BLRouter.INSTANCE, SplashCoreService.class, (String) null, 2, (Object) null);
    }

    public final SplashCoreService getSplashCoreService() {
        return (SplashCoreService) this.splashCoreService$delegate.getValue();
    }

    public final SplashButtonHelper getButtonHelper() {
        return this.buttonHelper;
    }

    public final SpannableString getSkipSS() {
        return this.skipSS;
    }

    public final void setSkipSS(SpannableString spannableString) {
        this.skipSS = spannableString;
    }

    public final SpannableString getCountdownSS() {
        return this.countdownSS;
    }

    public final void setCountdownSS(SpannableString spannableString) {
        this.countdownSS = spannableString;
    }

    public final ForegroundColorSpan getCountdownTextColorSpan() {
        return this.countdownTextColorSpan;
    }

    public final void setCountdownTextColorSpan(ForegroundColorSpan foregroundColorSpan) {
        this.countdownTextColorSpan = foregroundColorSpan;
    }

    public final Job getCountDownJob() {
        return this.countDownJob;
    }

    public final void setCountDownJob(Job job) {
        this.countDownJob = job;
    }

    public final long getSplashStartTimeMs() {
        return this.splashStartTimeMs;
    }

    public final void setSplashStartTimeMs(long j) {
        this.splashStartTimeMs = j;
    }

    public final long getViewCreateTimeMs() {
        return this.viewCreateTimeMs;
    }

    public final void setViewCreateTimeMs(long j) {
        this.viewCreateTimeMs = j;
    }

    public final boolean isShowAnimator() {
        return this.isShowAnimator;
    }

    public final void setShowAnimator(boolean z) {
        this.isShowAnimator = z;
    }

    public final String getSplashId() {
        return this.splashId;
    }

    public final void setSplashId(String str) {
        this.splashId = str;
    }

    public final boolean getClickJump() {
        return this.clickJump;
    }

    public final void setClickJump(boolean z) {
        this.clickJump = z;
    }

    public final boolean getExecuteAnim() {
        return this.executeAnim;
    }

    public final void setExecuteAnim(boolean z) {
        this.executeAnim = z;
    }

    public final Job getPrepareJob() {
        return this.prepareJob;
    }

    public final void setPrepareJob(Job job) {
        this.prepareJob = job;
    }

    public final boolean isReady() {
        return this.isReady;
    }

    public final void setReady(boolean z) {
        this.isReady = z;
    }

    public final boolean isEggPlayFinished() {
        return this.isEggPlayFinished;
    }

    public final void setEggPlayFinished(boolean z) {
        this.isEggPlayFinished = z;
    }

    public final SplashAlphaPlayer getEggPlayer() {
        return this.eggPlayer;
    }

    public final void setEggPlayer(SplashAlphaPlayer splashAlphaPlayer) {
        this.eggPlayer = splashAlphaPlayer;
    }

    public final View getEggCountdownView() {
        return this.eggCountdownView;
    }

    public final void setEggCountdownView(View view) {
        this.eggCountdownView = view;
    }

    public final boolean isSecondPageTriggered() {
        return this.isSecondPageTriggered;
    }

    public final void setSecondPageTriggered(boolean z) {
        this.isSecondPageTriggered = z;
    }

    public final SplashAlphaPlayer getSecondPageEggVideoPlayer() {
        return this.secondPageEggVideoPlayer;
    }

    public final void setSecondPageEggVideoPlayer(SplashAlphaPlayer splashAlphaPlayer) {
        this.secondPageEggVideoPlayer = splashAlphaPlayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SplashAudioManager audioManager_delegate$lambda$0() {
        return new SplashAudioManager();
    }

    public final SplashAudioManager getAudioManager() {
        return (SplashAudioManager) this.audioManager$delegate.getValue();
    }

    public final boolean getOpenSound() {
        return this.openSound;
    }

    public final void setOpenSound(boolean z) {
        this.openSound = z;
    }

    public final ViewGroup getTopContainer() {
        return this.topContainer;
    }

    public final void setTopContainer(ViewGroup viewGroup) {
        this.topContainer = viewGroup;
    }

    public final LinearLayout getHalfCustomButtonLayer() {
        return this.halfCustomButtonLayer;
    }

    public final void setHalfCustomButtonLayer(LinearLayout linearLayout) {
        this.halfCustomButtonLayer = linearLayout;
    }

    public final SplashAlphaPlayer getTopViewTransitionPlayer() {
        return this.topViewTransitionPlayer;
    }

    public final void setTopViewTransitionPlayer(SplashAlphaPlayer splashAlphaPlayer) {
        this.topViewTransitionPlayer = splashAlphaPlayer;
    }

    public final boolean getTopViewTransitionCanPlay() {
        return this.topViewTransitionCanPlay;
    }

    public final void setTopViewTransitionCanPlay(boolean z) {
        this.topViewTransitionCanPlay = z;
    }

    public final IPlayerReportTracker getPlayerReporter() {
        return this.playerReporter;
    }

    public final void setPlayerReporter(IPlayerReportTracker iPlayerReportTracker) {
        this.playerReporter = iPlayerReportTracker;
    }
}