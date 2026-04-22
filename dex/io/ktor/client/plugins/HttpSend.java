package io.ktor.client.plugins;

import faceverify.q;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.KtorDsl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: HttpSend.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0004\u0016\u0015\u0017\u0018B\u0013\b\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J@\u0010\u000f\u001a\u00020\u000e21\u0010\r\u001a-\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006j\u0002`\u000b¢\u0006\u0002\b\f¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011RE\u0010\u0013\u001a3\u0012/\u0012-\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006j\u0002`\u000b¢\u0006\u0002\b\f0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lio/ktor/client/plugins/HttpSend;", "", "", "maxSendCount", "<init>", "(I)V", "Lkotlin/Function3;", "Lio/ktor/client/plugins/Sender;", "Lio/ktor/client/request/HttpRequestBuilder;", "Lkotlin/coroutines/Continuation;", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/plugins/HttpSendInterceptor;", "Lkotlin/ExtensionFunctionType;", "block", "", "intercept", "(Lkotlin/jvm/functions/Function3;)V", "I", "", "interceptors", "Ljava/util/List;", "Plugin", "Config", "InterceptedSender", "DefaultSender", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HttpSend {
    public static final Plugin Plugin = new Plugin(null);
    private static final AttributeKey<HttpSend> key;
    private final List<Function3<Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object>> interceptors;
    private final int maxSendCount;

    public /* synthetic */ HttpSend(int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2);
    }

    private HttpSend(int maxSendCount) {
        this.maxSendCount = maxSendCount;
        this.interceptors = new ArrayList();
    }

    /* synthetic */ HttpSend(int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 20 : i2);
    }

    /* compiled from: HttpSend.kt */
    @KtorDsl
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/client/plugins/HttpSend$Config;", "", "<init>", "()V", "", "maxSendCount", "I", "getMaxSendCount", "()I", "setMaxSendCount", "(I)V", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Config {
        private int maxSendCount = 20;

        public final int getMaxSendCount() {
            return this.maxSendCount;
        }

        public final void setMaxSendCount(int i2) {
            this.maxSendCount = i2;
        }
    }

    public final void intercept(Function3<? super Sender, ? super HttpRequestBuilder, ? super Continuation<? super HttpClientCall>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(function3, "block");
        this.interceptors.add(function3);
    }

    /* compiled from: HttpSend.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\n\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00118\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/client/plugins/HttpSend$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/HttpSend$Config;", "Lio/ktor/client/plugins/HttpSend;", "<init>", "()V", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "prepare", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/HttpSend;", "plugin", "Lio/ktor/client/HttpClient;", "scope", "install", "(Lio/ktor/client/plugins/HttpSend;Lio/ktor/client/HttpClient;)V", "Lio/ktor/util/AttributeKey;", q.KEY_RES_9_KEY, "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Plugin implements HttpClientPlugin<Config, HttpSend> {
        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Plugin() {
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<HttpSend> getKey() {
            return HttpSend.key;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public HttpSend prepare(Function1<? super Config, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            Config config = new Config();
            function1.invoke(config);
            return new HttpSend(config.getMaxSendCount(), null);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public void install(HttpSend plugin, HttpClient scope) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.getRequestPipeline().intercept(HttpRequestPipeline.Phases.getSend(), new HttpSend$Plugin$install$1(plugin, scope, null));
        }
    }

    static {
        KType kType = null;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(HttpSend.class);
        try {
            kType = Reflection.typeOf(HttpSend.class);
        } catch (Throwable th) {
        }
        key = new AttributeKey<>("HttpSend", new TypeInfo(orCreateKotlinClass, kType));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpSend.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001BB\u00121\u0010\t\u001a-\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0002j\u0002`\u0007¢\u0006\u0002\b\b\u0012\u0006\u0010\n\u001a\u00020\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0003H\u0096@¢\u0006\u0004\b\u000e\u0010\u000fR?\u0010\t\u001a-\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0002j\u0002`\u0007¢\u0006\u0002\b\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0010R\u0014\u0010\n\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/client/plugins/HttpSend$InterceptedSender;", "Lio/ktor/client/plugins/Sender;", "Lkotlin/Function3;", "Lio/ktor/client/request/HttpRequestBuilder;", "Lkotlin/coroutines/Continuation;", "Lio/ktor/client/call/HttpClientCall;", "", "Lio/ktor/client/plugins/HttpSendInterceptor;", "Lkotlin/ExtensionFunctionType;", "interceptor", "nextSender", "<init>", "(Lkotlin/jvm/functions/Function3;Lio/ktor/client/plugins/Sender;)V", "requestBuilder", "execute", "(Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/jvm/functions/Function3;", "Lio/ktor/client/plugins/Sender;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class InterceptedSender implements Sender {
        private final Function3<Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> interceptor;
        private final Sender nextSender;

        /* JADX WARN: Multi-variable type inference failed */
        public InterceptedSender(Function3<? super Sender, ? super HttpRequestBuilder, ? super Continuation<? super HttpClientCall>, ? extends Object> function3, Sender nextSender) {
            Intrinsics.checkNotNullParameter(function3, "interceptor");
            Intrinsics.checkNotNullParameter(nextSender, "nextSender");
            this.interceptor = function3;
            this.nextSender = nextSender;
        }

        @Override // io.ktor.client.plugins.Sender
        public Object execute(HttpRequestBuilder requestBuilder, Continuation<? super HttpClientCall> continuation) {
            return this.interceptor.invoke(this.nextSender, requestBuilder, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpSend.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/client/plugins/HttpSend$DefaultSender;", "Lio/ktor/client/plugins/Sender;", "", "maxSendCount", "Lio/ktor/client/HttpClient;", "client", "<init>", "(ILio/ktor/client/HttpClient;)V", "Lio/ktor/client/request/HttpRequestBuilder;", "requestBuilder", "Lio/ktor/client/call/HttpClientCall;", "execute", "(Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "I", "Lio/ktor/client/HttpClient;", "sentCount", "currentCall", "Lio/ktor/client/call/HttpClientCall;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class DefaultSender implements Sender {
        private final HttpClient client;
        private HttpClientCall currentCall;
        private final int maxSendCount;
        private int sentCount;

        public DefaultSender(int maxSendCount, HttpClient client) {
            Intrinsics.checkNotNullParameter(client, "client");
            this.maxSendCount = maxSendCount;
            this.client = client;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0074  */
        @Override // io.ktor.client.plugins.Sender
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object execute(HttpRequestBuilder requestBuilder, Continuation<? super HttpClientCall> continuation) {
            HttpSend$DefaultSender$execute$1 httpSend$DefaultSender$execute$1;
            DefaultSender defaultSender;
            Object sendResult;
            HttpClientCall httpClientCall;
            if (continuation instanceof HttpSend$DefaultSender$execute$1) {
                httpSend$DefaultSender$execute$1 = (HttpSend$DefaultSender$execute$1) continuation;
                if ((httpSend$DefaultSender$execute$1.label & Integer.MIN_VALUE) != 0) {
                    httpSend$DefaultSender$execute$1.label -= Integer.MIN_VALUE;
                    Object $result = httpSend$DefaultSender$execute$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (httpSend$DefaultSender$execute$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            defaultSender = this;
                            HttpClientCall httpClientCall2 = defaultSender.currentCall;
                            if (httpClientCall2 != null) {
                                CoroutineScopeKt.cancel$default(httpClientCall2, (CancellationException) null, 1, (Object) null);
                            }
                            if (defaultSender.sentCount >= defaultSender.maxSendCount) {
                                throw new SendCountExceedException("Max send count " + defaultSender.maxSendCount + " exceeded. Consider increasing the property maxSendCount if more is required.");
                            }
                            defaultSender.sentCount++;
                            HttpSendPipeline sendPipeline = defaultSender.client.getSendPipeline();
                            Object body = requestBuilder.getBody();
                            httpSend$DefaultSender$execute$1.L$0 = defaultSender;
                            httpSend$DefaultSender$execute$1.label = 1;
                            sendResult = sendPipeline.execute(requestBuilder, body, httpSend$DefaultSender$execute$1);
                            if (sendResult == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            ResultKt.throwOnFailure($result);
                            defaultSender = (DefaultSender) httpSend$DefaultSender$execute$1.L$0;
                            sendResult = $result;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    httpClientCall = sendResult instanceof HttpClientCall ? (HttpClientCall) sendResult : null;
                    if (httpClientCall != null) {
                        throw new IllegalStateException(("Failed to execute send pipeline. Expected [HttpClientCall], but received " + sendResult).toString());
                    }
                    HttpClientCall call = httpClientCall;
                    defaultSender.currentCall = call;
                    return call;
                }
            }
            httpSend$DefaultSender$execute$1 = new HttpSend$DefaultSender$execute$1(this, continuation);
            Object $result2 = httpSend$DefaultSender$execute$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (httpSend$DefaultSender$execute$1.label) {
            }
            if (sendResult instanceof HttpClientCall) {
            }
            if (httpClientCall != null) {
            }
        }
    }
}