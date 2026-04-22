package io.ktor.client.plugins;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;

/* compiled from: HttpRequestRetry.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpRequestRetryConfig$delay$1", f = "HttpRequestRetry.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
final class HttpRequestRetryConfig$delay$1 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {
    /* synthetic */ long J$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpRequestRetryConfig$delay$1(Continuation<? super HttpRequestRetryConfig$delay$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> httpRequestRetryConfig$delay$1 = new HttpRequestRetryConfig$delay$1(continuation);
        httpRequestRetryConfig$delay$1.J$0 = ((Number) obj).longValue();
        return httpRequestRetryConfig$delay$1;
    }

    public final Object invoke(long j, Continuation<? super Unit> continuation) {
        return create(Long.valueOf(j), continuation).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).longValue(), (Continuation) obj2);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                long it = this.J$0;
                this.label = 1;
                if (DelayKt.delay(it, (Continuation) this) == coroutine_suspended) {
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