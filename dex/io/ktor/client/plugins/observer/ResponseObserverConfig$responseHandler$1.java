package io.ktor.client.plugins.observer;

import io.ktor.client.statement.HttpResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: ResponseObserver.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lio/ktor/client/statement/HttpResponse;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.observer.ResponseObserverConfig$responseHandler$1", f = "ResponseObserver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ResponseObserverConfig$responseHandler$1 extends SuspendLambda implements Function2<HttpResponse, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResponseObserverConfig$responseHandler$1(Continuation<? super ResponseObserverConfig$responseHandler$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ResponseObserverConfig$responseHandler$1(continuation);
    }

    public final Object invoke(HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        return create(httpResponse, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}