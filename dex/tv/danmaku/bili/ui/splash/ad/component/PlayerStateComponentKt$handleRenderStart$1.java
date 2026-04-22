package tv.danmaku.bili.ui.splash.ad.component;

import com.bilibili.app.comm.list.common.widget.PromoToast;
import com.bilibili.gripper.api.ad.core.player.report.IPlayerReportTracker;
import com.bilibili.gripper.api.ad.core.player.report.TrackState;
import com.bilibili.lib.homepage.splash.SplashViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.splash.ad.state.actions.SplashRealReadyAction;
import tv.danmaku.bili.ui.splash.SplashAdHelper;
import tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.model.SplashEggKt;
import tv.danmaku.bili.ui.splash.ad.page.BaseSplash;
import tv.danmaku.bili.ui.splash.utils.SplashUtilsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerStateComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.ad.component.PlayerStateComponentKt$handleRenderStart$1", f = "PlayerStateComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class PlayerStateComponentKt$handleRenderStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BaseSplash $this_handleRenderStart;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerStateComponentKt$handleRenderStart$1(BaseSplash baseSplash, Continuation<? super PlayerStateComponentKt$handleRenderStart$1> continuation) {
        super(2, continuation);
        this.$this_handleRenderStart = baseSplash;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayerStateComponentKt$handleRenderStart$1(this.$this_handleRenderStart, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005f, code lost:
        if (r1 != false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                SplashViewModel splashViewModel = this.$this_handleRenderStart.mSplashViewModel;
                if (splashViewModel != null) {
                    splashViewModel.update(new SplashRealReadyAction("render_start"));
                }
                SplashAdHelper.INSTANCE.reportVideoFirstRenderCostMs$splash_debug(this.$this_handleRenderStart.getSplash(), System.currentTimeMillis() - this.$this_handleRenderStart.mViewCreateTime);
                if (!this.$this_handleRenderStart.needPrepare() && !SplashEggKt.isEggSplash(this.$this_handleRenderStart.getSplash())) {
                    Splash splash = this.$this_handleRenderStart.getSplash();
                    boolean z = false;
                    if (splash != null && splash.hasSecondPageEggVideo()) {
                        z = true;
                        break;
                    }
                }
                this.$this_handleRenderStart.onSplashReady();
                IPlayerReportTracker iPlayerReportTracker = this.$this_handleRenderStart.playerReporter;
                if (iPlayerReportTracker != null) {
                    iPlayerReportTracker.updateState(TrackState.Playing.INSTANCE);
                }
                if (SplashUtilsKt.isDebug()) {
                    PromoToast.showMidToast(this.$this_handleRenderStart.getContext(), "闪屏视频首帧成功");
                }
                SplashCustomReporterKt.reportVideoRenderTime(this.$this_handleRenderStart.getSplash(), System.currentTimeMillis() - this.$this_handleRenderStart.mViewCreateTime);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}