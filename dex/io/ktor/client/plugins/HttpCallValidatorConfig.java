package io.ktor.client.plugins;

import com.tencent.open.SocialConstants;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.ContentDisposition;
import io.ktor.utils.io.KtorDsl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpCallValidator.kt */
@KtorDsl
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JY\u0010\u000f\u001a\u00020\f2J\u0010\u000e\u001aF\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\r¢\u0006\u0004\b\u000f\u0010\u0010JY\u0010\u0011\u001a\u00020\f2J\u0010\u000e\u001aF\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004j\u0002`\r¢\u0006\u0004\b\u0011\u0010\u0010JD\u0010\u0016\u001a\u00020\f25\u0010\u000e\u001a1\b\u0001\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012j\u0002`\u0015¢\u0006\u0004\b\u0016\u0010\u0017RO\u0010\u0019\u001a7\u00123\u00121\b\u0001\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012j\u0002`\u00150\u00188\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00188\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\"\u0010!\u001a\u00020 8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lio/ktor/client/plugins/HttpCallValidatorConfig;", "", "<init>", "()V", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", ContentDisposition.Parameters.Name, "cause", "Lio/ktor/client/request/HttpRequest;", SocialConstants.TYPE_REQUEST, "Lkotlin/coroutines/Continuation;", "", "Lio/ktor/client/plugins/CallRequestExceptionHandler;", "block", "handleResponseException", "(Lkotlin/jvm/functions/Function3;)V", "handleResponseExceptionWithRequest", "Lkotlin/Function2;", "Lio/ktor/client/statement/HttpResponse;", "response", "Lio/ktor/client/plugins/ResponseValidator;", "validateResponse", "(Lkotlin/jvm/functions/Function2;)V", "", "responseValidators", "Ljava/util/List;", "getResponseValidators$ktor_client_core", "()Ljava/util/List;", "Lio/ktor/client/plugins/HandlerWrapper;", "responseExceptionHandlers", "getResponseExceptionHandlers$ktor_client_core", "", "expectSuccess", "Z", "getExpectSuccess$ktor_client_core", "()Z", "setExpectSuccess$ktor_client_core", "(Z)V", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HttpCallValidatorConfig {
    private final List<Function2<HttpResponse, Continuation<? super Unit>, Object>> responseValidators = new ArrayList();
    private final List<HandlerWrapper> responseExceptionHandlers = new ArrayList();
    private boolean expectSuccess = true;

    public final List<Function2<HttpResponse, Continuation<? super Unit>, Object>> getResponseValidators$ktor_client_core() {
        return this.responseValidators;
    }

    public final List<HandlerWrapper> getResponseExceptionHandlers$ktor_client_core() {
        return this.responseExceptionHandlers;
    }

    public final boolean getExpectSuccess$ktor_client_core() {
        return this.expectSuccess;
    }

    public final void setExpectSuccess$ktor_client_core(boolean z) {
        this.expectSuccess = z;
    }

    public final void handleResponseException(Function3<? super Throwable, ? super HttpRequest, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(function3, "block");
        this.responseExceptionHandlers.add(new RequestExceptionHandlerWrapper(function3));
    }

    public final void handleResponseExceptionWithRequest(Function3<? super Throwable, ? super HttpRequest, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(function3, "block");
        this.responseExceptionHandlers.add(new RequestExceptionHandlerWrapper(function3));
    }

    public final void validateResponse(Function2<? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        this.responseValidators.add(function2);
    }
}