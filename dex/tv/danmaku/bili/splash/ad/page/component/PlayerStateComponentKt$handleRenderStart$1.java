package tv.danmaku.bili.splash.ad.page.component;

import com.bilibili.app.comm.list.common.widget.PromoToast;
import com.bilibili.gripper.api.ad.core.player.report.IPlayerReportTracker;
import com.bilibili.gripper.api.ad.core.player.report.TrackState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.page.BaseSplash;
import tv.danmaku.bili.splash.ad.page.ISplashEvent;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;
import tv.danmaku.bili.splash.ad.state.actions.SplashRealReadyAction;
import tv.danmaku.bili.splash.ad.utils.SplashUtilsKt;

/* compiled from: PlayerStateComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.page.component.PlayerStateComponentKt$handleRenderStart$1", f = "PlayerStateComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
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

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                this.$this_handleRenderStart.getViewModel$adsplash_debug().update(new SplashRealReadyAction("render_start"));
                SplashAdHelper.INSTANCE.reportVideoFirstRenderCostMs$adsplash_debug(this.$this_handleRenderStart.getSplash$adsplash_debug(), System.currentTimeMillis() - this.$this_handleRenderStart.getComponentHolder$adsplash_debug().getViewCreateTimeMs());
                if (PrepareComponentKt.needPrepare(this.$this_handleRenderStart) || ExtSplashOrderKt.isEggSplash(this.$this_handleRenderStart.getSplash$adsplash_debug()) || ExtSplashOrderKt.getHasSecondPageEggVideo(this.$this_handleRenderStart.getSplash$adsplash_debug())) {
                    ISplashEvent.CC.onSplashReady$default(this.$this_handleRenderStart, false, 1, null);
                }
                IPlayerReportTracker playerReporter = this.$this_handleRenderStart.getComponentHolder$adsplash_debug().getPlayerReporter();
                if (playerReporter != null) {
                    playerReporter.updateState(TrackState.Playing.INSTANCE);
                }
                if (SplashUtilsKt.isDebug()) {
                    PromoToast.showMidToast(this.$this_handleRenderStart.getContext(), "闪屏视频首帧成功");
                }
                SplashCustomReporterKt.reportVideoRenderTime(this.$this_handleRenderStart.getSplash$adsplash_debug(), System.currentTimeMillis() - this.$this_handleRenderStart.getComponentHolder$adsplash_debug().getViewCreateTimeMs());
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}