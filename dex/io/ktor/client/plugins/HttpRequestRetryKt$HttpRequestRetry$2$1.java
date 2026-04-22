package io.ktor.client.plugins;

import com.tencent.open.SocialConstants;
import com.tencent.smtt.sdk.TbsListener;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.ReadersKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.slf4j.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpRequestRetry.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/plugins/api/Send$Sender;", SocialConstants.TYPE_REQUEST, "Lio/ktor/client/request/HttpRequestBuilder;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpRequestRetryKt$HttpRequestRetry$2$1", f = "HttpRequestRetry.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {296, TbsListener.ErrorCode.ERROR_CODE_LOAD_BASE, 317}, m = "invokeSuspend", n = {"$this$on", SocialConstants.TYPE_REQUEST, "shouldRetry", "shouldRetryOnException", "delayMillis", "modifyRequest", "subRequest", "retryCount", "maxRetries", "$this$on", SocialConstants.TYPE_REQUEST, "shouldRetry", "shouldRetryOnException", "delayMillis", "modifyRequest", "call", "subRequest", "retryCount", "maxRetries", "$this$on", SocialConstants.TYPE_REQUEST, "shouldRetry", "shouldRetryOnException", "delayMillis", "modifyRequest", "lastRetryData", "retryCount", "maxRetries"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1"})
public final class HttpRequestRetryKt$HttpRequestRetry$2$1 extends SuspendLambda implements Function3<Send.Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {
    final /* synthetic */ Function2<Long, Continuation<? super Unit>, Object> $delay;
    final /* synthetic */ Function2<HttpRetryDelayContext, Integer, Long> $delayMillis;
    final /* synthetic */ int $maxRetries;
    final /* synthetic */ Function2<HttpRetryModifyRequestContext, HttpRequestBuilder, Unit> $modifyRequest;
    final /* synthetic */ Function3<HttpRetryShouldRetryContext, HttpRequest, HttpResponse, Boolean> $shouldRetry;
    final /* synthetic */ Function3<HttpRetryShouldRetryContext, HttpRequestBuilder, Throwable, Boolean> $shouldRetryOnException;
    final /* synthetic */ ClientPluginBuilder<HttpRequestRetryConfig> $this_createClientPlugin;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HttpRequestRetryKt$HttpRequestRetry$2$1(Function3<? super HttpRetryShouldRetryContext, ? super HttpRequest, ? super HttpResponse, Boolean> function3, Function3<? super HttpRetryShouldRetryContext, ? super HttpRequestBuilder, ? super Throwable, Boolean> function32, int i2, Function2<? super HttpRetryDelayContext, ? super Integer, Long> function2, Function2<? super HttpRetryModifyRequestContext, ? super HttpRequestBuilder, Unit> function22, ClientPluginBuilder<HttpRequestRetryConfig> clientPluginBuilder, Function2<? super Long, ? super Continuation<? super Unit>, ? extends Object> function23, Continuation<? super HttpRequestRetryKt$HttpRequestRetry$2$1> continuation) {
        super(3, continuation);
        this.$shouldRetry = function3;
        this.$shouldRetryOnException = function32;
        this.$maxRetries = i2;
        this.$delayMillis = function2;
        this.$modifyRequest = function22;
        this.$this_createClientPlugin = clientPluginBuilder;
        this.$delay = function23;
    }

    public final Object invoke(Send.Sender sender, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpClientCall> continuation) {
        HttpRequestRetryKt$HttpRequestRetry$2$1 httpRequestRetryKt$HttpRequestRetry$2$1 = new HttpRequestRetryKt$HttpRequestRetry$2$1(this.$shouldRetry, this.$shouldRetryOnException, this.$maxRetries, this.$delayMillis, this.$modifyRequest, this.$this_createClientPlugin, this.$delay, continuation);
        httpRequestRetryKt$HttpRequestRetry$2$1.L$0 = sender;
        httpRequestRetryKt$HttpRequestRetry$2$1.L$1 = httpRequestBuilder;
        return httpRequestRetryKt$HttpRequestRetry$2$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:58|(1:60)|61|(1:63)|64|(1:66)(1:74)|67|(1:69)|70|(1:72)|73|9|(2:48|49)|11|12|(1:14)(7:15|16|17|(3:19|(4:23|24|25|(1:27))|38)(5:39|40|41|33|(1:35)(7:36|8|9|(0)|11|12|(0)(0)))|29|30|(3:32|33|(0)(0))(1:37))) */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01c2, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01c3, code lost:
        r3 = r7;
        r7 = r14;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x015b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0166 A[Catch: all -> 0x01bf, TryCatch #4 {all -> 0x01bf, blocks: (B:43:0x015e, B:45:0x0166, B:47:0x0170, B:49:0x017e), top: B:80:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x022a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v4, types: [io.ktor.client.plugins.HttpRequestRetryKt$HttpRequestRetry$2$1] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x022b -> B:71:0x0238). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        HttpRequestRetryKt$HttpRequestRetry$2$1 httpRequestRetryKt$HttpRequestRetry$2$1;
        Send.Sender sender;
        HttpRequestBuilder httpRequestBuilder;
        Function3<HttpRetryShouldRetryContext, HttpRequest, HttpResponse, Boolean> function3;
        Function3<HttpRetryShouldRetryContext, HttpRequestBuilder, Throwable, Boolean> function32;
        Function2<HttpRetryDelayContext, Integer, Long> function2;
        Function2<HttpRetryModifyRequestContext, HttpRequestBuilder, Unit> function22;
        HttpRequestBuilder httpRequestBuilder2;
        int i2;
        int i3;
        HttpClientCall httpClientCall;
        Send.Sender sender2;
        HttpRequestBuilder httpRequestBuilder3;
        Function3<HttpRetryShouldRetryContext, HttpRequest, HttpResponse, Boolean> function33;
        Function3<HttpRetryShouldRetryContext, HttpRequestBuilder, Throwable, Boolean> function34;
        Function2<HttpRetryDelayContext, Integer, Long> function23;
        Function2<HttpRetryModifyRequestContext, HttpRequestBuilder, Unit> function24;
        HttpRetryEventData httpRetryEventData;
        int i4;
        HttpRequestRetryKt$HttpRequestRetry$2$1 httpRequestRetryKt$HttpRequestRetry$2$12;
        int i5;
        Function2<Long, Continuation<? super Unit>, Object> function25;
        Object invoke;
        HttpRequestRetryKt$HttpRequestRetry$2$1 httpRequestRetryKt$HttpRequestRetry$2$13;
        HttpRetryEventData httpRetryEventData2;
        boolean HttpRequestRetry$lambda$1$shouldRetryOnException;
        Object obj2;
        boolean HttpRequestRetry$lambda$1$shouldRetry;
        HttpRequestBuilder HttpRequestRetry$lambda$1$prepareRequest;
        Logger logger;
        AttributeKey attributeKey;
        AttributeKey attributeKey2;
        AttributeKey attributeKey3;
        AttributeKey attributeKey4;
        AttributeKey attributeKey5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Throwable th) {
            th = th;
            httpRequestRetryKt$HttpRequestRetry$2$1 = this;
            HttpRequestRetry$lambda$1$shouldRetryOnException = HttpRequestRetryKt.HttpRequestRetry$lambda$1$shouldRetryOnException(i2, i3, function32, httpRequestBuilder2, th);
            if (!HttpRequestRetry$lambda$1$shouldRetryOnException) {
            }
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Send.Sender sender3 = (Send.Sender) this.L$0;
                HttpRequestBuilder httpRequestBuilder4 = (HttpRequestBuilder) this.L$1;
                Attributes attributes = httpRequestBuilder4.getAttributes();
                attributeKey = HttpRequestRetryKt.ShouldRetryPerRequestAttributeKey;
                Function3<HttpRetryShouldRetryContext, HttpRequest, HttpResponse, Boolean> function35 = (Function3) attributes.getOrNull(attributeKey);
                if (function35 == null) {
                    function35 = this.$shouldRetry;
                }
                Attributes attributes2 = httpRequestBuilder4.getAttributes();
                attributeKey2 = HttpRequestRetryKt.ShouldRetryOnExceptionPerRequestAttributeKey;
                Function3<HttpRetryShouldRetryContext, HttpRequestBuilder, Throwable, Boolean> function36 = (Function3) attributes2.getOrNull(attributeKey2);
                if (function36 == null) {
                    function36 = this.$shouldRetryOnException;
                }
                Attributes attributes3 = httpRequestBuilder4.getAttributes();
                attributeKey3 = HttpRequestRetryKt.MaxRetriesPerRequestAttributeKey;
                Integer num = (Integer) attributes3.getOrNull(attributeKey3);
                int intValue = num != null ? num.intValue() : this.$maxRetries;
                Attributes attributes4 = httpRequestBuilder4.getAttributes();
                attributeKey4 = HttpRequestRetryKt.RetryDelayPerRequestAttributeKey;
                function2 = (Function2) attributes4.getOrNull(attributeKey4);
                if (function2 == null) {
                    function2 = this.$delayMillis;
                }
                Attributes attributes5 = httpRequestBuilder4.getAttributes();
                attributeKey5 = HttpRequestRetryKt.ModifyRequestPerRequestAttributeKey;
                Function2<HttpRetryModifyRequestContext, HttpRequestBuilder, Unit> function26 = (Function2) attributes5.getOrNull(attributeKey5);
                if (function26 == null) {
                    function26 = this.$modifyRequest;
                }
                sender = sender3;
                httpRequestBuilder = httpRequestBuilder4;
                function3 = function35;
                i3 = intValue;
                function22 = function26;
                httpRetryEventData2 = null;
                i2 = 0;
                function32 = function36;
                httpRequestRetryKt$HttpRequestRetry$2$13 = this;
                HttpRequestRetry$lambda$1$prepareRequest = HttpRequestRetryKt.HttpRequestRetry$lambda$1$prepareRequest(httpRequestBuilder);
                if (httpRetryEventData2 != null) {
                    try {
                    } catch (Throwable th2) {
                        th = th2;
                        httpRequestRetryKt$HttpRequestRetry$2$1 = httpRequestRetryKt$HttpRequestRetry$2$13;
                        httpRequestBuilder2 = HttpRequestRetry$lambda$1$prepareRequest;
                        HttpRequestRetry$lambda$1$shouldRetryOnException = HttpRequestRetryKt.HttpRequestRetry$lambda$1$shouldRetryOnException(i2, i3, function32, httpRequestBuilder2, th);
                        if (!HttpRequestRetry$lambda$1$shouldRetryOnException) {
                        }
                    }
                    function22.invoke(new HttpRetryModifyRequestContext(httpRequestBuilder, httpRetryEventData2.getResponse(), httpRetryEventData2.getCause(), httpRetryEventData2.getRetryCount()), HttpRequestRetry$lambda$1$prepareRequest);
                }
                httpRequestRetryKt$HttpRequestRetry$2$13.L$0 = sender;
                httpRequestRetryKt$HttpRequestRetry$2$13.L$1 = httpRequestBuilder;
                httpRequestRetryKt$HttpRequestRetry$2$13.L$2 = function3;
                httpRequestRetryKt$HttpRequestRetry$2$13.L$3 = function32;
                httpRequestRetryKt$HttpRequestRetry$2$13.L$4 = function2;
                httpRequestRetryKt$HttpRequestRetry$2$13.L$5 = function22;
                httpRequestRetryKt$HttpRequestRetry$2$13.L$6 = HttpRequestRetry$lambda$1$prepareRequest;
                httpRequestRetryKt$HttpRequestRetry$2$13.I$0 = i2;
                httpRequestRetryKt$HttpRequestRetry$2$13.I$1 = i3;
                httpRequestRetryKt$HttpRequestRetry$2$13.label = 1;
                obj2 = sender.proceed(HttpRequestRetry$lambda$1$prepareRequest, (Continuation) httpRequestRetryKt$HttpRequestRetry$2$13);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                httpRequestRetryKt$HttpRequestRetry$2$1 = httpRequestRetryKt$HttpRequestRetry$2$13;
                httpRequestBuilder2 = HttpRequestRetry$lambda$1$prepareRequest;
                try {
                } catch (Throwable th3) {
                    th = th3;
                    HttpRequestRetry$lambda$1$shouldRetryOnException = HttpRequestRetryKt.HttpRequestRetry$lambda$1$shouldRetryOnException(i2, i3, function32, httpRequestBuilder2, th);
                    if (!HttpRequestRetry$lambda$1$shouldRetryOnException) {
                    }
                }
                httpClientCall = (HttpClientCall) obj2;
                HttpRequestRetry$lambda$1$shouldRetry = HttpRequestRetryKt.HttpRequestRetry$lambda$1$shouldRetry(i2, i3, function3, httpClientCall);
                if (HttpRequestRetry$lambda$1$shouldRetry) {
                    if (DoubleReceivePluginKt.isSaved(httpClientCall.getResponse()) && !httpClientCall.getResponse().getRawContent().isClosedForRead()) {
                        HttpResponse response = httpClientCall.getResponse();
                        Continuation continuation = httpRequestRetryKt$HttpRequestRetry$2$1;
                        httpRequestRetryKt$HttpRequestRetry$2$1.L$0 = sender;
                        httpRequestRetryKt$HttpRequestRetry$2$1.L$1 = httpRequestBuilder;
                        httpRequestRetryKt$HttpRequestRetry$2$1.L$2 = function3;
                        httpRequestRetryKt$HttpRequestRetry$2$1.L$3 = function32;
                        httpRequestRetryKt$HttpRequestRetry$2$1.L$4 = function2;
                        httpRequestRetryKt$HttpRequestRetry$2$1.L$5 = function22;
                        httpRequestRetryKt$HttpRequestRetry$2$1.L$6 = httpClientCall;
                        httpRequestRetryKt$HttpRequestRetry$2$1.L$7 = httpRequestBuilder2;
                        httpRequestRetryKt$HttpRequestRetry$2$1.I$0 = i2;
                        httpRequestRetryKt$HttpRequestRetry$2$1.I$1 = i3;
                        httpRequestRetryKt$HttpRequestRetry$2$1.label = 2;
                        httpRequestRetryKt$HttpRequestRetry$2$1 = ReadersKt.readBytes(response, 0, continuation);
                        if (httpRequestRetryKt$HttpRequestRetry$2$1 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return httpClientCall;
                }
                try {
                } catch (Throwable th4) {
                    th = th4;
                }
                int i6 = i2 + 1;
                HttpRetryEventData httpRetryEventData3 = new HttpRetryEventData(httpRequestBuilder2, i6, httpClientCall.getResponse(), null);
                i5 = i3;
                i4 = i6;
                function24 = function22;
                function23 = function2;
                function34 = function32;
                function33 = function3;
                httpRequestBuilder3 = httpRequestBuilder;
                sender2 = sender;
                httpRetryEventData = httpRetryEventData3;
                httpRequestRetryKt$HttpRequestRetry$2$12 = httpRequestRetryKt$HttpRequestRetry$2$1;
                httpRequestRetryKt$HttpRequestRetry$2$12.$this_createClientPlugin.getClient().getMonitor().raise(HttpRequestRetryKt.getHttpRequestRetryEvent(), httpRetryEventData);
                HttpRetryDelayContext httpRetryDelayContext = new HttpRetryDelayContext(httpRetryEventData.getRequest(), httpRetryEventData.getResponse(), httpRetryEventData.getCause());
                function25 = httpRequestRetryKt$HttpRequestRetry$2$12.$delay;
                invoke = function23.invoke(httpRetryDelayContext, Boxing.boxInt(i4));
                httpRequestRetryKt$HttpRequestRetry$2$12.L$0 = sender2;
                httpRequestRetryKt$HttpRequestRetry$2$12.L$1 = httpRequestBuilder3;
                httpRequestRetryKt$HttpRequestRetry$2$12.L$2 = function33;
                httpRequestRetryKt$HttpRequestRetry$2$12.L$3 = function34;
                httpRequestRetryKt$HttpRequestRetry$2$12.L$4 = function23;
                httpRequestRetryKt$HttpRequestRetry$2$12.L$5 = function24;
                httpRequestRetryKt$HttpRequestRetry$2$12.L$6 = httpRetryEventData;
                httpRequestRetryKt$HttpRequestRetry$2$12.L$7 = null;
                httpRequestRetryKt$HttpRequestRetry$2$12.I$0 = i4;
                httpRequestRetryKt$HttpRequestRetry$2$12.I$1 = i5;
                httpRequestRetryKt$HttpRequestRetry$2$12.label = 3;
                if (function25.invoke(invoke, httpRequestRetryKt$HttpRequestRetry$2$12) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                sender = sender2;
                httpRequestBuilder = httpRequestBuilder3;
                function3 = function33;
                function32 = function34;
                function2 = function23;
                function22 = function24;
                httpRequestRetryKt$HttpRequestRetry$2$13 = httpRequestRetryKt$HttpRequestRetry$2$12;
                int i7 = i4;
                i3 = i5;
                httpRetryEventData2 = httpRetryEventData;
                i2 = i7;
                logger = HttpRequestRetryKt.LOGGER;
                logger.trace("Retrying request " + httpRequestBuilder.getUrl() + " attempt: " + i2);
                HttpRequestRetry$lambda$1$prepareRequest = HttpRequestRetryKt.HttpRequestRetry$lambda$1$prepareRequest(httpRequestBuilder);
                if (httpRetryEventData2 != null) {
                }
                httpRequestRetryKt$HttpRequestRetry$2$13.L$0 = sender;
                httpRequestRetryKt$HttpRequestRetry$2$13.L$1 = httpRequestBuilder;
                httpRequestRetryKt$HttpRequestRetry$2$13.L$2 = function3;
                httpRequestRetryKt$HttpRequestRetry$2$13.L$3 = function32;
                httpRequestRetryKt$HttpRequestRetry$2$13.L$4 = function2;
                httpRequestRetryKt$HttpRequestRetry$2$13.L$5 = function22;
                httpRequestRetryKt$HttpRequestRetry$2$13.L$6 = HttpRequestRetry$lambda$1$prepareRequest;
                httpRequestRetryKt$HttpRequestRetry$2$13.I$0 = i2;
                httpRequestRetryKt$HttpRequestRetry$2$13.I$1 = i3;
                httpRequestRetryKt$HttpRequestRetry$2$13.label = 1;
                obj2 = sender.proceed(HttpRequestRetry$lambda$1$prepareRequest, (Continuation) httpRequestRetryKt$HttpRequestRetry$2$13);
                if (obj2 == coroutine_suspended) {
                }
                th = th4;
                HttpRequestRetry$lambda$1$shouldRetryOnException = HttpRequestRetryKt.HttpRequestRetry$lambda$1$shouldRetryOnException(i2, i3, function32, httpRequestBuilder2, th);
                if (!HttpRequestRetry$lambda$1$shouldRetryOnException) {
                    throw th;
                }
                int i8 = i2 + 1;
                HttpRetryEventData httpRetryEventData4 = new HttpRetryEventData(httpRequestBuilder2, i8, null, th);
                i5 = i3;
                i4 = i8;
                function24 = function22;
                function23 = function2;
                function34 = function32;
                function33 = function3;
                httpRequestBuilder3 = httpRequestBuilder;
                sender2 = sender;
                httpRetryEventData = httpRetryEventData4;
                httpRequestRetryKt$HttpRequestRetry$2$12 = httpRequestRetryKt$HttpRequestRetry$2$1;
                httpRequestRetryKt$HttpRequestRetry$2$12.$this_createClientPlugin.getClient().getMonitor().raise(HttpRequestRetryKt.getHttpRequestRetryEvent(), httpRetryEventData);
                HttpRetryDelayContext httpRetryDelayContext2 = new HttpRetryDelayContext(httpRetryEventData.getRequest(), httpRetryEventData.getResponse(), httpRetryEventData.getCause());
                function25 = httpRequestRetryKt$HttpRequestRetry$2$12.$delay;
                invoke = function23.invoke(httpRetryDelayContext2, Boxing.boxInt(i4));
                httpRequestRetryKt$HttpRequestRetry$2$12.L$0 = sender2;
                httpRequestRetryKt$HttpRequestRetry$2$12.L$1 = httpRequestBuilder3;
                httpRequestRetryKt$HttpRequestRetry$2$12.L$2 = function33;
                httpRequestRetryKt$HttpRequestRetry$2$12.L$3 = function34;
                httpRequestRetryKt$HttpRequestRetry$2$12.L$4 = function23;
                httpRequestRetryKt$HttpRequestRetry$2$12.L$5 = function24;
                httpRequestRetryKt$HttpRequestRetry$2$12.L$6 = httpRetryEventData;
                httpRequestRetryKt$HttpRequestRetry$2$12.L$7 = null;
                httpRequestRetryKt$HttpRequestRetry$2$12.I$0 = i4;
                httpRequestRetryKt$HttpRequestRetry$2$12.I$1 = i5;
                httpRequestRetryKt$HttpRequestRetry$2$12.label = 3;
                if (function25.invoke(invoke, httpRequestRetryKt$HttpRequestRetry$2$12) != coroutine_suspended) {
                }
                break;
            case 1:
                i3 = this.I$1;
                i2 = this.I$0;
                httpRequestBuilder2 = (HttpRequestBuilder) this.L$6;
                function22 = (Function2) this.L$5;
                function2 = (Function2) this.L$4;
                function32 = (Function3) this.L$3;
                function3 = (Function3) this.L$2;
                httpRequestBuilder = (HttpRequestBuilder) this.L$1;
                sender = (Send.Sender) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj2 = obj;
                httpRequestRetryKt$HttpRequestRetry$2$1 = this;
                httpClientCall = (HttpClientCall) obj2;
                HttpRequestRetry$lambda$1$shouldRetry = HttpRequestRetryKt.HttpRequestRetry$lambda$1$shouldRetry(i2, i3, function3, httpClientCall);
                if (HttpRequestRetry$lambda$1$shouldRetry) {
                }
                th = th4;
                HttpRequestRetry$lambda$1$shouldRetryOnException = HttpRequestRetryKt.HttpRequestRetry$lambda$1$shouldRetryOnException(i2, i3, function32, httpRequestBuilder2, th);
                if (!HttpRequestRetry$lambda$1$shouldRetryOnException) {
                }
                break;
            case 2:
                int i9 = this.I$1;
                int i10 = this.I$0;
                HttpRequestBuilder httpRequestBuilder5 = (HttpRequestBuilder) this.L$7;
                httpClientCall = (HttpClientCall) this.L$6;
                Function2 function27 = (Function2) this.L$5;
                Function2 function28 = (Function2) this.L$4;
                Function3 function37 = (Function3) this.L$3;
                Function3 function38 = (Function3) this.L$2;
                HttpRequestBuilder httpRequestBuilder6 = (HttpRequestBuilder) this.L$1;
                Send.Sender sender4 = (Send.Sender) this.L$0;
                ResultKt.throwOnFailure(obj);
                return httpClientCall;
            case 3:
                int i11 = this.I$1;
                int i12 = this.I$0;
                ResultKt.throwOnFailure(obj);
                sender = (Send.Sender) this.L$0;
                httpRequestBuilder = (HttpRequestBuilder) this.L$1;
                function3 = (Function3) this.L$2;
                function32 = (Function3) this.L$3;
                function2 = (Function2) this.L$4;
                function22 = (Function2) this.L$5;
                httpRequestRetryKt$HttpRequestRetry$2$13 = this;
                i3 = i11;
                httpRetryEventData2 = (HttpRetryEventData) this.L$6;
                i2 = i12;
                logger = HttpRequestRetryKt.LOGGER;
                logger.trace("Retrying request " + httpRequestBuilder.getUrl() + " attempt: " + i2);
                HttpRequestRetry$lambda$1$prepareRequest = HttpRequestRetryKt.HttpRequestRetry$lambda$1$prepareRequest(httpRequestBuilder);
                if (httpRetryEventData2 != null) {
                }
                httpRequestRetryKt$HttpRequestRetry$2$13.L$0 = sender;
                httpRequestRetryKt$HttpRequestRetry$2$13.L$1 = httpRequestBuilder;
                httpRequestRetryKt$HttpRequestRetry$2$13.L$2 = function3;
                httpRequestRetryKt$HttpRequestRetry$2$13.L$3 = function32;
                httpRequestRetryKt$HttpRequestRetry$2$13.L$4 = function2;
                httpRequestRetryKt$HttpRequestRetry$2$13.L$5 = function22;
                httpRequestRetryKt$HttpRequestRetry$2$13.L$6 = HttpRequestRetry$lambda$1$prepareRequest;
                httpRequestRetryKt$HttpRequestRetry$2$13.I$0 = i2;
                httpRequestRetryKt$HttpRequestRetry$2$13.I$1 = i3;
                httpRequestRetryKt$HttpRequestRetry$2$13.label = 1;
                obj2 = sender.proceed(HttpRequestRetry$lambda$1$prepareRequest, (Continuation) httpRequestRetryKt$HttpRequestRetry$2$13);
                if (obj2 == coroutine_suspended) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}