package tv.danmaku.bili.splash.ad.page.component;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.page.BaseSplash;
import tv.danmaku.bili.splash.ad.vm.actions.SplashCountDownAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CountdownComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.splash.ad.page.component.CountdownComponentKt$startCountDown$1", f = "CountdownComponent.kt", i = {0, 0}, l = {BR.currentItem}, m = "invokeSuspend", n = {"leftTime", "duration"}, s = {"L$0", "I$0"}, v = 1)
public final class CountdownComponentKt$startCountDown$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BaseSplash $this_startCountDown;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountdownComponentKt$startCountDown$1(BaseSplash baseSplash, Continuation<? super CountdownComponentKt$startCountDown$1> continuation) {
        super(2, continuation);
        this.$this_startCountDown = baseSplash;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CountdownComponentKt$startCountDown$1(this.$this_startCountDown, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0044  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0074 -> B:12:0x0077). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Ref.IntRef leftTime;
        BaseSplash baseSplash;
        int duration;
        int i;
        CountdownComponentKt$startCountDown$1 countdownComponentKt$startCountDown$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                int duration2 = (int) this.$this_startCountDown.getSplash$adsplash_debug().getDuration();
                Ref.IntRef leftTime2 = new Ref.IntRef();
                leftTime2.element = duration2;
                leftTime = leftTime2;
                baseSplash = this.$this_startCountDown;
                duration = duration2;
                i = 0;
                countdownComponentKt$startCountDown$1 = this;
                break;
            case 1:
                i = this.I$1;
                duration = this.I$0;
                baseSplash = (BaseSplash) this.L$1;
                leftTime = (Ref.IntRef) this.L$0;
                ResultKt.throwOnFailure($result);
                countdownComponentKt$startCountDown$1 = this;
                if (leftTime.element <= 0) {
                    CountdownComponentKt.updateCountdownText(baseSplash, 0);
                    baseSplash.getViewModel$adsplash_debug().update(new SplashCountDownAction(duration * 1000, leftTime.element * 1000));
                    baseSplash.onCountdownEnd();
                }
                i++;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (i >= duration) {
            CountdownComponentKt.updateCountdownText(baseSplash, leftTime.element);
            baseSplash.getViewModel$adsplash_debug().update(new SplashCountDownAction(duration * 1000, leftTime.element * 1000));
            leftTime.element--;
            countdownComponentKt$startCountDown$1.L$0 = leftTime;
            countdownComponentKt$startCountDown$1.L$1 = baseSplash;
            countdownComponentKt$startCountDown$1.I$0 = duration;
            countdownComponentKt$startCountDown$1.I$1 = i;
            countdownComponentKt$startCountDown$1.label = 1;
            if (DelayKt.delay(1000L, countdownComponentKt$startCountDown$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            if (leftTime.element <= 0) {
            }
            i++;
            if (i >= duration) {
                return Unit.INSTANCE;
            }
        }
    }
}