package tv.danmaku.bili.splash.ad.page.component;

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
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.SplashEgg;
import tv.danmaku.bili.splash.ad.page.BaseSplash;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AlphaEggLayerComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.page.component.AlphaEggLayerComponentKt$triggerTransportEgg$1", f = "AlphaEggLayerComponent.kt", i = {}, l = {BR.constraintSetModifier}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AlphaEggLayerComponentKt$triggerTransportEgg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BaseSplash $this_triggerTransportEgg;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlphaEggLayerComponentKt$triggerTransportEgg$1(BaseSplash baseSplash, Continuation<? super AlphaEggLayerComponentKt$triggerTransportEgg$1> continuation) {
        super(2, continuation);
        this.$this_triggerTransportEgg = baseSplash;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AlphaEggLayerComponentKt$triggerTransportEgg$1(this.$this_triggerTransportEgg, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                SplashEgg splashEgg = this.$this_triggerTransportEgg.getSplash$adsplash_debug().getSplashEgg();
                long duration = splashEgg != null ? splashEgg.getDuration() : 0L;
                this.label = 1;
                if (DelayKt.delay(duration, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!this.$this_triggerTransportEgg.getComponentHolder$adsplash_debug().isEggPlayFinished()) {
            AlphaEggLayerComponentKt.handleEggPlayFinishEvent(this.$this_triggerTransportEgg);
        }
        return Unit.INSTANCE;
    }
}