package tv.danmaku.bili.ui.main2.widget;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoRefreshQueue.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.widget.AutoRefreshQueue$requestUntil$1", f = "AutoRefreshQueue.kt", i = {}, l = {BR.bgImg}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AutoRefreshQueue$requestUntil$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Integer, Unit> $requestInvoker;
    final /* synthetic */ long $time;
    final /* synthetic */ int $type;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AutoRefreshQueue$requestUntil$1(long j, Function1<? super Integer, Unit> function1, int i, Continuation<? super AutoRefreshQueue$requestUntil$1> continuation) {
        super(2, continuation);
        this.$time = j;
        this.$requestInvoker = function1;
        this.$type = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AutoRefreshQueue$requestUntil$1(this.$time, this.$requestInvoker, this.$type, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    BLog.d(AutoRefreshQueue.TAG, "launchWhenResumed");
                    this.label = 1;
                    if (DelayKt.delay(this.$time, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            BLog.d(AutoRefreshQueue.TAG, "getDefaultKeyword");
            this.$requestInvoker.invoke(Boxing.boxInt(this.$type));
        } catch (CancellationException e) {
            AutoRefreshQueue.INSTANCE.handleCancellation();
        } catch (Exception e2) {
            AutoRefreshQueue.INSTANCE.handleError(e2);
        }
        return Unit.INSTANCE;
    }
}