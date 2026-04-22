package io.ktor.client.plugins;

import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpCallValidator.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B>\u00125\u0010\u000b\u001a1\b\u0001\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0002j\u0002`\n¢\u0006\u0004\b\f\u0010\rRF\u0010\u000b\u001a1\b\u0001\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0002j\u0002`\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/client/plugins/ExceptionHandlerWrapper;", "Lio/ktor/client/plugins/HandlerWrapper;", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", ContentDisposition.Parameters.Name, "cause", "Lkotlin/coroutines/Continuation;", "", "", "Lio/ktor/client/plugins/CallExceptionHandler;", "handler", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "getHandler", "()Lkotlin/jvm/functions/Function2;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExceptionHandlerWrapper implements HandlerWrapper {
    private final Function2<Throwable, Continuation<? super Unit>, Object> handler;

    /* JADX WARN: Multi-variable type inference failed */
    public ExceptionHandlerWrapper(Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, "handler");
        this.handler = function2;
    }

    public final Function2<Throwable, Continuation<? super Unit>, Object> getHandler() {
        return this.handler;
    }
}