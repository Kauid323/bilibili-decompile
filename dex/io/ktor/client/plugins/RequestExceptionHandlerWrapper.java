package io.ktor.client.plugins;

import com.tencent.open.SocialConstants;
import io.ktor.client.request.HttpRequest;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpCallValidator.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001BS\u0012J\u0010\r\u001aF\b\u0001\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0002j\u0002`\f¢\u0006\u0004\b\u000e\u0010\u000fR[\u0010\r\u001aF\b\u0001\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0002j\u0002`\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/client/plugins/RequestExceptionHandlerWrapper;", "Lio/ktor/client/plugins/HandlerWrapper;", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", ContentDisposition.Parameters.Name, "cause", "Lio/ktor/client/request/HttpRequest;", SocialConstants.TYPE_REQUEST, "Lkotlin/coroutines/Continuation;", "", "", "Lio/ktor/client/plugins/CallRequestExceptionHandler;", "handler", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "Lkotlin/jvm/functions/Function3;", "getHandler", "()Lkotlin/jvm/functions/Function3;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RequestExceptionHandlerWrapper implements HandlerWrapper {
    private final Function3<Throwable, HttpRequest, Continuation<? super Unit>, Object> handler;

    /* JADX WARN: Multi-variable type inference failed */
    public RequestExceptionHandlerWrapper(Function3<? super Throwable, ? super HttpRequest, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(function3, "handler");
        this.handler = function3;
    }

    public final Function3<Throwable, HttpRequest, Continuation<? super Unit>, Object> getHandler() {
        return this.handler;
    }
}