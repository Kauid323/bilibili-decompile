package tv.danmaku.bili.ui.splash.ad.page;

import com.bilibili.lib.homepage.splash.SplashViewModel;
import com.bilibili.lib.homepage.splash.model.PlayerShareData;
import com.bilibili.lib.homepage.splash.model.SplashState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.utils.SplashConfigKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AlphaEggLayerComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.ad.page.AlphaEggLayerComponentKt$doLaunchDanmakuExitAnimate$1", f = "AlphaEggLayerComponent.kt", i = {}, l = {271}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AlphaEggLayerComponentKt$doLaunchDanmakuExitAnimate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BaseSplash $this_doLaunchDanmakuExitAnimate;
    final /* synthetic */ SplashViewModel $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlphaEggLayerComponentKt$doLaunchDanmakuExitAnimate$1(SplashViewModel splashViewModel, BaseSplash baseSplash, Continuation<? super AlphaEggLayerComponentKt$doLaunchDanmakuExitAnimate$1> continuation) {
        super(2, continuation);
        this.$viewModel = splashViewModel;
        this.$this_doLaunchDanmakuExitAnimate = baseSplash;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AlphaEggLayerComponentKt$doLaunchDanmakuExitAnimate$1(this.$viewModel, this.$this_doLaunchDanmakuExitAnimate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PlayerShareData playerShareData = ((SplashState) this.$viewModel.getState().getValue()).getPlayerShareData();
                boolean delayExit = ((playerShareData != null ? playerShareData.getShareId() : 0) > 0 || ((SplashState) this.$viewModel.getState().getValue()).getSkipClick() || ((SplashState) this.$viewModel.getState().getValue()).getJumpClick()) ? false : true;
                if (delayExit) {
                    this.label = 1;
                    if (DelayKt.delay(SplashConfigKt.getDanmakuSplashExitDelay(), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    BLog.i("[Splash]FullImageSplash", "doLaunchDanmakuExitAnimate, after delay");
                    break;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                BLog.i("[Splash]FullImageSplash", "doLaunchDanmakuExitAnimate, after delay");
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$this_doLaunchDanmakuExitAnimate.exitSplash(false);
        return Unit.INSTANCE;
    }
}