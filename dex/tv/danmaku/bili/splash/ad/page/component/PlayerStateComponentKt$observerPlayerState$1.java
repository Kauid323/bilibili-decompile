package tv.danmaku.bili.splash.ad.page.component;

import com.bilibili.droid.ToastHelper;
import com.bilibili.gripper.api.ad.core.player.report.IPlayerReportTracker;
import com.bilibili.gripper.api.ad.core.player.report.TrackState;
import com.bilibili.lib.homepage.splash.actions.PlayerEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.page.BaseSplash;
import tv.danmaku.bili.splash.ad.page.ISplashEvent;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;
import tv.danmaku.bili.splash.ad.utils.SplashUtilsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PlayerStateComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.page.component.PlayerStateComponentKt$observerPlayerState$1", f = "PlayerStateComponent.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PlayerStateComponentKt$observerPlayerState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BaseSplash $this_observerPlayerState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerStateComponentKt$observerPlayerState$1(BaseSplash baseSplash, Continuation<? super PlayerStateComponentKt$observerPlayerState$1> continuation) {
        super(2, continuation);
        this.$this_observerPlayerState = baseSplash;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayerStateComponentKt$observerPlayerState$1(this.$this_observerPlayerState, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Flow playerEventFlow = this.$this_observerPlayerState.getViewModel$adsplash_debug().getPlayerEventFlow();
                final BaseSplash baseSplash = this.$this_observerPlayerState;
                this.label = 1;
                if (playerEventFlow.collect(new FlowCollector() { // from class: tv.danmaku.bili.splash.ad.page.component.PlayerStateComponentKt$observerPlayerState$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((PlayerEvent) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(PlayerEvent action, Continuation<? super Unit> continuation) {
                        boolean reporterNotInit = BaseSplash.this.getComponentHolder$adsplash_debug().getPlayerReporter() == null;
                        BLog.i("[Splash]PlayerStateComponent", "observerPlayerState, event = " + action + ", reporter not init = " + reporterNotInit);
                        if (SplashUtilsKt.isDebug() && reporterNotInit) {
                            ToastHelper.showToast(BaseSplash.this.getContext(), "PlayerReporter Not Init!", 0);
                        }
                        if (action instanceof PlayerEvent.OnPreparing) {
                            IPlayerReportTracker playerReporter = BaseSplash.this.getComponentHolder$adsplash_debug().getPlayerReporter();
                            if (playerReporter != null) {
                                playerReporter.updateState(TrackState.Idle.INSTANCE);
                            }
                        } else if (action instanceof PlayerEvent.OnPrepared) {
                            SplashCustomReporterKt.reportVideoPrepareTime(BaseSplash.this.getSplash$adsplash_debug(), System.currentTimeMillis() - BaseSplash.this.getComponentHolder$adsplash_debug().getViewCreateTimeMs());
                            IPlayerReportTracker playerReporter2 = BaseSplash.this.getComponentHolder$adsplash_debug().getPlayerReporter();
                            if (playerReporter2 != null) {
                                playerReporter2.updateState(TrackState.Prepared.INSTANCE);
                            }
                        } else if (action instanceof PlayerEvent.OnRenderStart) {
                            PlayerStateComponentKt.handleRenderStart(BaseSplash.this);
                        } else if (action instanceof PlayerEvent.OnPause) {
                            IPlayerReportTracker playerReporter3 = BaseSplash.this.getComponentHolder$adsplash_debug().getPlayerReporter();
                            if (playerReporter3 != null) {
                                playerReporter3.updateState(TrackState.Paused.INSTANCE);
                            }
                        } else if (action instanceof PlayerEvent.OnStop) {
                            IPlayerReportTracker playerReporter4 = BaseSplash.this.getComponentHolder$adsplash_debug().getPlayerReporter();
                            if (playerReporter4 != null) {
                                playerReporter4.updateState(TrackState.Stop.INSTANCE);
                            }
                        } else if (action instanceof PlayerEvent.OnCompleted) {
                            IPlayerReportTracker playerReporter5 = BaseSplash.this.getComponentHolder$adsplash_debug().getPlayerReporter();
                            if (playerReporter5 != null) {
                                playerReporter5.updateState(TrackState.Stop.INSTANCE);
                            }
                            IPlayerReportTracker playerReporter6 = BaseSplash.this.getComponentHolder$adsplash_debug().getPlayerReporter();
                            if (playerReporter6 != null) {
                                playerReporter6.updateState(TrackState.Completed.INSTANCE);
                            }
                            if (BaseSplash.this.getComponentHolder$adsplash_debug().isSecondPageTriggered()) {
                                ISplashEvent.CC.onPageJump$default(BaseSplash.this, true, "2", null, 4, null);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}