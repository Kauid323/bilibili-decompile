package tv.danmaku.bili;

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

/* compiled from: MainActivitySplashComponentExt.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.MainActivitySplashComponentExtKt$hideSplash$1", f = "MainActivitySplashComponentExt.kt", i = {}, l = {BR.imageWidth}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class MainActivitySplashComponentExtKt$hideSplash$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayTime;
    final /* synthetic */ MainActivityV2 $this_hideSplash;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivitySplashComponentExtKt$hideSplash$1(long j, MainActivityV2 mainActivityV2, Continuation<? super MainActivitySplashComponentExtKt$hideSplash$1> continuation) {
        super(2, continuation);
        this.$delayTime = j;
        this.$this_hideSplash = mainActivityV2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivitySplashComponentExtKt$hideSplash$1(this.$delayTime, this.$this_hideSplash, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (DelayKt.delay(this.$delayTime, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        BLog.i("[Main]MainActivitySplashComponent", "mDelayJumpRunnable hideSplashFragment");
        this.$this_hideSplash.hideSplashFragment(true);
        return Unit.INSTANCE;
    }
}