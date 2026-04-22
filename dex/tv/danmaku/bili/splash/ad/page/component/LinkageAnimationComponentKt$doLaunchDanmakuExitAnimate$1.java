package tv.danmaku.bili.splash.ad.page.component;

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
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.page.BaseSplash;
import tv.danmaku.bili.splash.ad.page.ISplashEvent;
import tv.danmaku.bili.splash.ad.utils.SplashConfigKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LinkageAnimationComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.page.component.LinkageAnimationComponentKt$doLaunchDanmakuExitAnimate$1", f = "LinkageAnimationComponent.kt", i = {}, l = {BR.leftTextColor}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class LinkageAnimationComponentKt$doLaunchDanmakuExitAnimate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BaseSplash $this_doLaunchDanmakuExitAnimate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkageAnimationComponentKt$doLaunchDanmakuExitAnimate$1(BaseSplash baseSplash, Continuation<? super LinkageAnimationComponentKt$doLaunchDanmakuExitAnimate$1> continuation) {
        super(2, continuation);
        this.$this_doLaunchDanmakuExitAnimate = baseSplash;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LinkageAnimationComponentKt$doLaunchDanmakuExitAnimate$1(this.$this_doLaunchDanmakuExitAnimate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PlayerShareData playerShareData = ((SplashState) this.$this_doLaunchDanmakuExitAnimate.getViewModel$adsplash_debug().getState().getValue()).getPlayerShareData();
                boolean z = false;
                if ((playerShareData != null ? playerShareData.getShareId() : 0) <= 0 && !((SplashState) this.$this_doLaunchDanmakuExitAnimate.getViewModel$adsplash_debug().getState().getValue()).getSkipClick() && !((SplashState) this.$this_doLaunchDanmakuExitAnimate.getViewModel$adsplash_debug().getState().getValue()).getJumpClick()) {
                    z = true;
                }
                boolean delayExit = z;
                if (delayExit) {
                    this.label = 1;
                    if (DelayKt.delay(SplashConfigKt.getDanmakuSplashExitDelay(), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    BLog.i("[Splash]LinkageComponent", "doLaunchDanmakuExitAnimate, after delay");
                    break;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                BLog.i("[Splash]LinkageComponent", "doLaunchDanmakuExitAnimate, after delay");
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ISplashEvent.CC.exitSplash$default(this.$this_doLaunchDanmakuExitAnimate, false, null, null, 6, null);
        return Unit.INSTANCE;
    }
}