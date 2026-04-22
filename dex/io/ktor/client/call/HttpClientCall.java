package io.ktor.client.call;

import com.tencent.open.SocialConstants;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.DoubleReceivePluginKt;
import io.ktor.client.request.DefaultHttpRequest;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.statement.DefaultHttpResponse;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.content.NullBody;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.util.reflect.TypeInfoJvmKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.InternalAPI;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: HttpClientCall.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u0000 92\u00020\u0001:\u00019B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B!\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0004\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u0094@¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010!\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001dH\u0000¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0011\u0010,\u001a\u00020)8F¢\u0006\u0006\u001a\u0004\b*\u0010+R*\u0010\u001e\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u001d8\u0006@DX\u0086.¢\u0006\u0012\n\u0004\b\u001e\u0010.\u001a\u0004\b/\u00100\"\u0004\b!\u0010 R*\u0010\u0018\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u00178\u0006@DX\u0086.¢\u0006\u0012\n\u0004\b\u0018\u00101\u001a\u0004\b2\u00103\"\u0004\b\u001c\u0010\u001bR\u001a\u00105\u001a\u0002048\u0014X\u0094D¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108¨\u0006:"}, d2 = {"Lio/ktor/client/call/HttpClientCall;", "Lkotlinx/coroutines/CoroutineScope;", "Lio/ktor/client/HttpClient;", "client", "<init>", "(Lio/ktor/client/HttpClient;)V", "Lio/ktor/client/request/HttpRequestData;", "requestData", "Lio/ktor/client/request/HttpResponseData;", "responseData", "(Lio/ktor/client/HttpClient;Lio/ktor/client/request/HttpRequestData;Lio/ktor/client/request/HttpResponseData;)V", "Lio/ktor/utils/io/ByteReadChannel;", "getResponseContent", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/util/reflect/TypeInfo;", "info", "", "bodyNullable", "(Lio/ktor/util/reflect/TypeInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "body", "", "toString", "()Ljava/lang/String;", "Lio/ktor/client/statement/HttpResponse;", "response", "", "setResponse$ktor_client_core", "(Lio/ktor/client/statement/HttpResponse;)V", "setResponse", "Lio/ktor/client/request/HttpRequest;", SocialConstants.TYPE_REQUEST, "setRequest$ktor_client_core", "(Lio/ktor/client/request/HttpRequest;)V", "setRequest", "Lio/ktor/client/HttpClient;", "getClient", "()Lio/ktor/client/HttpClient;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/util/Attributes;", "getAttributes", "()Lio/ktor/util/Attributes;", "attributes", "value", "Lio/ktor/client/request/HttpRequest;", "getRequest", "()Lio/ktor/client/request/HttpRequest;", "Lio/ktor/client/statement/HttpResponse;", "getResponse", "()Lio/ktor/client/statement/HttpResponse;", "", "allowDoubleReceive", "Z", "getAllowDoubleReceive", "()Z", "Companion", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class HttpClientCall implements CoroutineScope {
    public static final Companion Companion = new Companion(null);
    private static final AttributeKey<Object> CustomResponse;
    private static final /* synthetic */ AtomicIntegerFieldUpdater received$FU;
    private final boolean allowDoubleReceive;
    private final HttpClient client;
    private volatile /* synthetic */ int received;
    protected HttpRequest request;
    protected HttpResponse response;

    protected Object getResponseContent(Continuation<? super ByteReadChannel> continuation) {
        return getResponseContent$suspendImpl(this, continuation);
    }

    public HttpClientCall(HttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
        this.received = 0;
    }

    public final HttpClient getClient() {
        return this.client;
    }

    public CoroutineContext getCoroutineContext() {
        return getResponse().getCoroutineContext();
    }

    public final Attributes getAttributes() {
        return getRequest().getAttributes();
    }

    public final HttpRequest getRequest() {
        HttpRequest httpRequest = this.request;
        if (httpRequest != null) {
            return httpRequest;
        }
        Intrinsics.throwUninitializedPropertyAccessException(SocialConstants.TYPE_REQUEST);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setRequest(HttpRequest httpRequest) {
        Intrinsics.checkNotNullParameter(httpRequest, "<set-?>");
        this.request = httpRequest;
    }

    public final HttpResponse getResponse() {
        HttpResponse httpResponse = this.response;
        if (httpResponse != null) {
            return httpResponse;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setResponse(HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpResponse, "<set-?>");
        this.response = httpResponse;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @InternalAPI
    public HttpClientCall(HttpClient client, HttpRequestData requestData, HttpResponseData responseData) {
        this(client);
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(requestData, "requestData");
        Intrinsics.checkNotNullParameter(responseData, "responseData");
        setRequest(new DefaultHttpRequest(this, requestData));
        setResponse(new DefaultHttpResponse(this, responseData));
        if (!(responseData.getBody() instanceof ByteReadChannel)) {
            getAttributes().put(CustomResponse, responseData.getBody());
        }
    }

    protected boolean getAllowDoubleReceive() {
        return this.allowDoubleReceive;
    }

    static /* synthetic */ Object getResponseContent$suspendImpl(HttpClientCall $this, Continuation<? super ByteReadChannel> continuation) {
        return $this.getResponse().getRawContent();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cd  */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object bodyNullable(TypeInfo info, Continuation<Object> continuation) {
        HttpClientCall$bodyNullable$1 httpClientCall$bodyNullable$1;
        ?? r3;
        HttpClientCall httpClientCall;
        HttpClientCall httpClientCall2;
        Object responseData;
        Object execute;
        Object result;
        try {
            if (continuation instanceof HttpClientCall$bodyNullable$1) {
                httpClientCall$bodyNullable$1 = (HttpClientCall$bodyNullable$1) continuation;
                if ((httpClientCall$bodyNullable$1.label & Integer.MIN_VALUE) != 0) {
                    httpClientCall$bodyNullable$1.label -= Integer.MIN_VALUE;
                    Object $result = httpClientCall$bodyNullable$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    r3 = httpClientCall$bodyNullable$1.label;
                    switch (r3) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            httpClientCall2 = this;
                            if (TypeInfoJvmKt.instanceOf(httpClientCall2.getResponse(), info.getType())) {
                                return httpClientCall2.getResponse();
                            }
                            if (!httpClientCall2.getAllowDoubleReceive() && !DoubleReceivePluginKt.isSaved(httpClientCall2.getResponse()) && !received$FU.compareAndSet(httpClientCall2, 0, 1)) {
                                throw new DoubleReceiveException(httpClientCall2);
                            }
                            responseData = httpClientCall2.getAttributes().getOrNull(CustomResponse);
                            if (responseData == null) {
                                httpClientCall$bodyNullable$1.L$0 = httpClientCall2;
                                httpClientCall$bodyNullable$1.L$1 = info;
                                httpClientCall$bodyNullable$1.label = 1;
                                responseData = httpClientCall2.getResponseContent(httpClientCall$bodyNullable$1);
                                if (responseData == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            HttpResponseContainer subject = new HttpResponseContainer(info, responseData);
                            HttpResponsePipeline responsePipeline = httpClientCall2.client.getResponsePipeline();
                            httpClientCall$bodyNullable$1.L$0 = httpClientCall2;
                            httpClientCall$bodyNullable$1.L$1 = info;
                            httpClientCall$bodyNullable$1.label = 2;
                            execute = responsePipeline.execute(httpClientCall2, subject, httpClientCall$bodyNullable$1);
                            if (execute != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            httpClientCall = httpClientCall2;
                            result = ((HttpResponseContainer) execute).getResponse();
                            if (Intrinsics.areEqual(result, NullBody.INSTANCE) ? false : true) {
                                result = null;
                            }
                            if (result != null && !TypeInfoJvmKt.instanceOf(result, info.getType())) {
                                KClass from = Reflection.getOrCreateKotlinClass(result.getClass());
                                KClass to = info.getType();
                                throw new NoTransformationFoundException(httpClientCall.getResponse(), from, to);
                            }
                            return result;
                        case 1:
                            info = (TypeInfo) httpClientCall$bodyNullable$1.L$1;
                            httpClientCall2 = (HttpClientCall) httpClientCall$bodyNullable$1.L$0;
                            ResultKt.throwOnFailure($result);
                            responseData = $result;
                            HttpResponseContainer subject2 = new HttpResponseContainer(info, responseData);
                            HttpResponsePipeline responsePipeline2 = httpClientCall2.client.getResponsePipeline();
                            httpClientCall$bodyNullable$1.L$0 = httpClientCall2;
                            httpClientCall$bodyNullable$1.L$1 = info;
                            httpClientCall$bodyNullable$1.label = 2;
                            execute = responsePipeline2.execute(httpClientCall2, subject2, httpClientCall$bodyNullable$1);
                            if (execute != coroutine_suspended) {
                            }
                            break;
                        case 2:
                            info = (TypeInfo) httpClientCall$bodyNullable$1.L$1;
                            httpClientCall = (HttpClientCall) httpClientCall$bodyNullable$1.L$0;
                            try {
                                ResultKt.throwOnFailure($result);
                                execute = $result;
                                result = ((HttpResponseContainer) execute).getResponse();
                                if (Intrinsics.areEqual(result, NullBody.INSTANCE) ? false : true) {
                                }
                                if (result != null) {
                                    KClass from2 = Reflection.getOrCreateKotlinClass(result.getClass());
                                    KClass to2 = info.getType();
                                    throw new NoTransformationFoundException(httpClientCall.getResponse(), from2, to2);
                                }
                                return result;
                            } catch (Throwable th) {
                                cause = th;
                                CoroutineScopeKt.cancel(httpClientCall.getResponse(), "Receive failed", cause);
                                throw cause;
                            }
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (r3) {
            }
        } catch (Throwable th2) {
            cause = th2;
            httpClientCall = r3;
        }
        httpClientCall$bodyNullable$1 = new HttpClientCall$bodyNullable$1(this, continuation);
        Object $result2 = httpClientCall$bodyNullable$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r3 = httpClientCall$bodyNullable$1.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object body(TypeInfo info, Continuation<Object> continuation) {
        HttpClientCall$body$1 httpClientCall$body$1;
        Object bodyNullable;
        if (continuation instanceof HttpClientCall$body$1) {
            httpClientCall$body$1 = (HttpClientCall$body$1) continuation;
            if ((httpClientCall$body$1.label & Integer.MIN_VALUE) != 0) {
                httpClientCall$body$1.label -= Integer.MIN_VALUE;
                Object $result = httpClientCall$body$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (httpClientCall$body$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        httpClientCall$body$1.label = 1;
                        bodyNullable = bodyNullable(info, httpClientCall$body$1);
                        if (bodyNullable == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        bodyNullable = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Intrinsics.checkNotNull(bodyNullable);
                return bodyNullable;
            }
        }
        httpClientCall$body$1 = new HttpClientCall$body$1(this, continuation);
        Object $result2 = httpClientCall$body$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (httpClientCall$body$1.label) {
        }
        Intrinsics.checkNotNull(bodyNullable);
        return bodyNullable;
    }

    public String toString() {
        return "HttpClientCall[" + getRequest().getUrl() + ", " + getResponse().getStatus() + ']';
    }

    public final void setResponse$ktor_client_core(HttpResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        setResponse(response);
    }

    public final void setRequest$ktor_client_core(HttpRequest request) {
        Intrinsics.checkNotNullParameter(request, SocialConstants.TYPE_REQUEST);
        setRequest(request);
    }

    /* compiled from: HttpClientCall.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/client/call/HttpClientCall$Companion;", "", "<init>", "()V", "Lio/ktor/util/AttributeKey;", "CustomResponse", "Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        KType kType = null;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        try {
            kType = Reflection.typeOf(Object.class);
        } catch (Throwable th) {
        }
        CustomResponse = new AttributeKey<>("CustomResponse", new TypeInfo(orCreateKotlinClass, kType));
        received$FU = AtomicIntegerFieldUpdater.newUpdater(HttpClientCall.class, "received");
    }
}