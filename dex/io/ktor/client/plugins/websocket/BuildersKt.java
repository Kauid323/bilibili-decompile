package io.ktor.client.plugins.websocket;

import com.tencent.open.SocialConstants;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.plugins.websocket.WebSockets;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLParserKt;
import io.ktor.http.URLProtocol;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.CloseReason;
import io.ktor.websocket.WebSocketSessionKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ReceiveChannel;

/* compiled from: builders.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u001a.\u0010\u0006\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a-\u0010\f\u001a\u00020\u000b*\u00020\b2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b\f\u0010\r\u001a]\u0010\f\u001a\u00020\u000b*\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0019\b\u0002\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b\f\u0010\u0015\u001a7\u0010\f\u001a\u00020\u000b*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00102\u0019\b\u0002\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b\f\u0010\u0017\u001aV\u0010\u001c\u001a\u00020\u0003*\u00020\b2\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0086\u0001\u0010\u001c\u001a\u00020\u0003*\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b\u001c\u0010\u001e\u001a`\u0010\u001c\u001a\u00020\u0003*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00102\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b\u001c\u0010\u001f\u001a\u0086\u0001\u0010 \u001a\u00020\u0003*\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b \u0010\u001e\u001aV\u0010 \u001a\u00020\u0003*\u00020\b2\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b \u0010\u001d\u001a`\u0010 \u001a\u00020\u0003*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00102\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b \u0010\u001f\u001aV\u0010!\u001a\u00020\u0003*\u00020\b2\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b!\u0010\u001d\u001a`\u0010!\u001a\u00020\u0003*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00102\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b!\u0010\u001f\u001a\u0086\u0001\u0010!\u001a\u00020\u0003*\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042'\u0010\n\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b!\u0010\u001e¨\u0006\""}, d2 = {"Lio/ktor/client/HttpClientConfig;", "Lkotlin/Function1;", "Lio/ktor/client/plugins/websocket/WebSockets$Config;", "", "Lkotlin/ExtensionFunctionType;", "config", "WebSockets", "(Lio/ktor/client/HttpClientConfig;Lkotlin/jvm/functions/Function1;)V", "Lio/ktor/client/HttpClient;", "Lio/ktor/client/request/HttpRequestBuilder;", "block", "Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;", "webSocketSession", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/http/HttpMethod;", "method", "", "host", "", "port", "path", "(Lio/ktor/client/HttpClient;Lio/ktor/http/HttpMethod;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urlString", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", SocialConstants.TYPE_REQUEST, "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "webSocket", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/client/HttpClient;Lio/ktor/http/HttpMethod;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ws", "wss", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BuildersKt {
    public static final void WebSockets(HttpClientConfig<?> httpClientConfig, final Function1<? super WebSockets.Config, Unit> function1) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "<this>");
        Intrinsics.checkNotNullParameter(function1, "config");
        httpClientConfig.install(WebSockets.Plugin, new Function1() { // from class: io.ktor.client.plugins.websocket.BuildersKt$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                Unit WebSockets$lambda$0;
                WebSockets$lambda$0 = BuildersKt.WebSockets$lambda$0(function1, (WebSockets.Config) obj);
                return WebSockets$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WebSockets$lambda$0(Function1 $config, WebSockets.Config $this$install) {
        Intrinsics.checkNotNullParameter($this$install, "$this$install");
        $config.invoke($this$install);
        return Unit.INSTANCE;
    }

    public static final Object webSocketSession(HttpClient $this$webSocketSession, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super DefaultClientWebSocketSession> continuation) {
        HttpClientPluginKt.plugin($this$webSocketSession, WebSockets.Plugin);
        CompletableDeferred sessionDeferred = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        HttpRequestBuilder $this$webSocketSession_u24lambda_u242 = new HttpRequestBuilder();
        $this$webSocketSession_u24lambda_u242.url(new Function2() { // from class: io.ktor.client.plugins.websocket.BuildersKt$$ExternalSyntheticLambda8
            public final Object invoke(Object obj, Object obj2) {
                Unit webSocketSession$lambda$2$lambda$1;
                webSocketSession$lambda$2$lambda$1 = BuildersKt.webSocketSession$lambda$2$lambda$1((URLBuilder) obj, (URLBuilder) obj2);
                return webSocketSession$lambda$2$lambda$1;
            }
        });
        function1.invoke($this$webSocketSession_u24lambda_u242);
        HttpStatement statement = new HttpStatement($this$webSocketSession_u24lambda_u242, $this$webSocketSession);
        kotlinx.coroutines.BuildersKt.launch$default($this$webSocketSession, (CoroutineContext) null, (CoroutineStart) null, new BuildersKt$webSocketSession$2(statement, sessionDeferred, null), 3, (Object) null);
        return sessionDeferred.await(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit webSocketSession$lambda$2$lambda$1(URLBuilder $this$url, URLBuilder it) {
        Intrinsics.checkNotNullParameter($this$url, "$this$url");
        Intrinsics.checkNotNullParameter(it, "it");
        $this$url.setProtocol(URLProtocol.Companion.getWS());
        $this$url.setPort($this$url.getProtocol().getDefaultPort());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit webSocketSession$lambda$3(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final Object webSocketSession(HttpClient $this$webSocketSession, final HttpMethod method, final String host2, final Integer port, final String path, final Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super DefaultClientWebSocketSession> continuation) {
        return webSocketSession($this$webSocketSession, new Function1() { // from class: io.ktor.client.plugins.websocket.BuildersKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit webSocketSession$lambda$4;
                webSocketSession$lambda$4 = BuildersKt.webSocketSession$lambda$4(HttpMethod.this, host2, port, path, function1, (HttpRequestBuilder) obj);
                return webSocketSession$lambda$4;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit webSocketSession$lambda$4(HttpMethod $method, String $host, Integer $port, String $path, Function1 $block, HttpRequestBuilder $this$webSocketSession) {
        Intrinsics.checkNotNullParameter($this$webSocketSession, "$this$webSocketSession");
        $this$webSocketSession.setMethod($method);
        HttpRequestKt.url$default($this$webSocketSession, "ws", $host, $port, $path, null, 16, null);
        $block.invoke($this$webSocketSession);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object webSocketSession$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.plugins.websocket.BuildersKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj2) {
                    Unit webSocketSession$lambda$5;
                    webSocketSession$lambda$5 = BuildersKt.webSocketSession$lambda$5((HttpRequestBuilder) obj2);
                    return webSocketSession$lambda$5;
                }
            };
        }
        return webSocketSession(httpClient, str, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit webSocketSession$lambda$5(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final Object webSocketSession(HttpClient $this$webSocketSession, final String urlString, final Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super DefaultClientWebSocketSession> continuation) {
        return webSocketSession($this$webSocketSession, new Function1() { // from class: io.ktor.client.plugins.websocket.BuildersKt$$ExternalSyntheticLambda17
            public final Object invoke(Object obj) {
                Unit webSocketSession$lambda$6;
                webSocketSession$lambda$6 = BuildersKt.webSocketSession$lambda$6(urlString, function1, (HttpRequestBuilder) obj);
                return webSocketSession$lambda$6;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit webSocketSession$lambda$6(String $urlString, Function1 $block, HttpRequestBuilder $this$webSocketSession) {
        Intrinsics.checkNotNullParameter($this$webSocketSession, "$this$webSocketSession");
        URLParserKt.takeFrom($this$webSocketSession.getUrl(), $urlString);
        $block.invoke($this$webSocketSession);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(3:(2:3|(4:5|6|7|8))|7|8) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b7, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b8, code lost:
        r6 = r0;
     */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x01fc: MOVE  (r4 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$i$f$body' int)]), block:B:98:0x01fc */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x00b9: MOVE  (r5 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$i$f$unwrapRequestTimeoutException' int)]), block:B:35:0x00b8 */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x00ba: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = 
      (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('$i$a$-unwrapRequestTimeoutException-HttpStatement$body$4$iv' int)])
    , block:B:35:0x00b8 */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0151 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0159 A[Catch: all -> 0x00b7, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x00b7, blocks: (B:21:0x005f, B:85:0x01ce, B:86:0x01d7, B:24:0x0076, B:67:0x0175, B:82:0x01b7, B:32:0x00b0, B:60:0x0159, B:87:0x01d8, B:88:0x01e0), top: B:109:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0189 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01cd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01d8 A[Catch: all -> 0x00b7, TryCatch #6 {all -> 0x00b7, blocks: (B:21:0x005f, B:85:0x01ce, B:86:0x01d7, B:24:0x0076, B:67:0x0175, B:82:0x01b7, B:32:0x00b0, B:60:0x0159, B:87:0x01d8, B:88:0x01e0), top: B:109:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01f7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object webSocket(HttpClient $this$webSocket, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        BuildersKt$webSocket$1 buildersKt$webSocket$1;
        BuildersKt$webSocket$1 buildersKt$webSocket$12;
        Throwable th;
        HttpStatement this_$iv;
        HttpResponse response$iv;
        boolean z;
        boolean z2;
        Object fetchStreamingResponse;
        Function2 block;
        boolean z3;
        KType kType;
        Object bodyNullable;
        Function2 block2;
        boolean z4;
        Throwable th2;
        DefaultClientWebSocketSession it;
        DefaultClientWebSocketSession it2;
        try {
            try {
                if (continuation instanceof BuildersKt$webSocket$1) {
                    buildersKt$webSocket$1 = (BuildersKt$webSocket$1) continuation;
                    if ((buildersKt$webSocket$1.label & Integer.MIN_VALUE) != 0) {
                        buildersKt$webSocket$1.label -= Integer.MIN_VALUE;
                        buildersKt$webSocket$12 = buildersKt$webSocket$1;
                        Object $result = buildersKt$webSocket$12.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (buildersKt$webSocket$12.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                HttpClientPluginKt.plugin($this$webSocket, WebSockets.Plugin);
                                HttpRequestBuilder $this$webSocket_u24lambda_u248 = new HttpRequestBuilder();
                                $this$webSocket_u24lambda_u248.url(new Function2() { // from class: io.ktor.client.plugins.websocket.BuildersKt$$ExternalSyntheticLambda4
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit webSocket$lambda$8$lambda$7;
                                        webSocket$lambda$8$lambda$7 = BuildersKt.webSocket$lambda$8$lambda$7((URLBuilder) obj, (URLBuilder) obj2);
                                        return webSocket$lambda$8$lambda$7;
                                    }
                                });
                                function1.invoke($this$webSocket_u24lambda_u248);
                                HttpStatement this_$iv2 = new HttpStatement($this$webSocket_u24lambda_u248, $this$webSocket);
                                z2 = false;
                                try {
                                    buildersKt$webSocket$12.L$0 = function2;
                                    buildersKt$webSocket$12.L$1 = this_$iv2;
                                    buildersKt$webSocket$12.label = 1;
                                    fetchStreamingResponse = this_$iv2.fetchStreamingResponse(buildersKt$webSocket$12);
                                    if (fetchStreamingResponse == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    this_$iv = this_$iv2;
                                    block = function2;
                                    z = false;
                                    z3 = false;
                                    response$iv = (HttpResponse) fetchStreamingResponse;
                                    try {
                                        HttpClientCall call = response$iv.getCall();
                                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(DefaultClientWebSocketSession.class);
                                        try {
                                            kType = Reflection.typeOf(DefaultClientWebSocketSession.class);
                                        } catch (Throwable th3) {
                                            kType = null;
                                        }
                                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                                        buildersKt$webSocket$12.L$0 = block;
                                        buildersKt$webSocket$12.L$1 = this_$iv;
                                        buildersKt$webSocket$12.L$2 = response$iv;
                                        buildersKt$webSocket$12.label = 2;
                                        bodyNullable = call.bodyNullable(typeInfo, buildersKt$webSocket$12);
                                        if (bodyNullable != coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        boolean z5 = z2;
                                        block2 = block;
                                        z4 = z5;
                                        if (bodyNullable != null) {
                                            throw new NullPointerException("null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession");
                                        }
                                        DefaultClientWebSocketSession defaultClientWebSocketSession = (DefaultClientWebSocketSession) bodyNullable;
                                        Continuation<? super HttpResponse> continuation2 = (Continuation) buildersKt$webSocket$12;
                                        try {
                                            buildersKt$webSocket$12.L$0 = this_$iv;
                                            buildersKt$webSocket$12.L$1 = response$iv;
                                            buildersKt$webSocket$12.L$2 = defaultClientWebSocketSession;
                                            buildersKt$webSocket$12.label = 3;
                                            if (block2.invoke(defaultClientWebSocketSession, buildersKt$webSocket$12) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            it2 = defaultClientWebSocketSession;
                                            buildersKt$webSocket$12.L$0 = this_$iv;
                                            buildersKt$webSocket$12.L$1 = response$iv;
                                            buildersKt$webSocket$12.L$2 = it2;
                                            buildersKt$webSocket$12.label = 4;
                                            if (WebSocketSessionKt.close$default(it2, (CloseReason) null, buildersKt$webSocket$12, 1, (Object) null) != coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            try {
                                                ReceiveChannel.DefaultImpls.cancel$default(it2.getIncoming(), (CancellationException) null, 1, (Object) null);
                                                buildersKt$webSocket$12.L$0 = Unit.INSTANCE;
                                                buildersKt$webSocket$12.L$1 = null;
                                                buildersKt$webSocket$12.L$2 = null;
                                                buildersKt$webSocket$12.label = 6;
                                                return this_$iv.cleanup(response$iv, buildersKt$webSocket$12) != coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                                            } catch (Throwable th4) {
                                                th = th4;
                                                buildersKt$webSocket$12.L$0 = th;
                                                buildersKt$webSocket$12.L$1 = null;
                                                buildersKt$webSocket$12.L$2 = null;
                                                buildersKt$webSocket$12.L$3 = null;
                                                buildersKt$webSocket$12.label = 7;
                                                if (this_$iv.cleanup(response$iv, buildersKt$webSocket$12) != coroutine_suspended) {
                                                }
                                            }
                                        } catch (Throwable th5) {
                                            th2 = th5;
                                            it = defaultClientWebSocketSession;
                                            buildersKt$webSocket$12.L$0 = this_$iv;
                                            buildersKt$webSocket$12.L$1 = response$iv;
                                            buildersKt$webSocket$12.L$2 = it;
                                            buildersKt$webSocket$12.L$3 = th2;
                                            buildersKt$webSocket$12.label = 5;
                                            if (WebSocketSessionKt.close$default(it, (CloseReason) null, buildersKt$webSocket$12, 1, (Object) null) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            ReceiveChannel.DefaultImpls.cancel$default(it.getIncoming(), (CancellationException) null, 1, (Object) null);
                                            throw th2;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        buildersKt$webSocket$12.L$0 = th;
                                        buildersKt$webSocket$12.L$1 = null;
                                        buildersKt$webSocket$12.L$2 = null;
                                        buildersKt$webSocket$12.L$3 = null;
                                        buildersKt$webSocket$12.label = 7;
                                        if (this_$iv.cleanup(response$iv, buildersKt$webSocket$12) != coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        throw th;
                                    }
                                } catch (CancellationException e2) {
                                    cause$iv$iv = e2;
                                    throw ExceptionUtilsJvmKt.unwrapCancellationException(cause$iv$iv);
                                }
                            case 1:
                                z = false;
                                z3 = false;
                                HttpStatement this_$iv3 = (HttpStatement) buildersKt$webSocket$12.L$1;
                                Function2 block3 = (Function2) buildersKt$webSocket$12.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    fetchStreamingResponse = $result;
                                    this_$iv = this_$iv3;
                                    block = block3;
                                    z2 = false;
                                    response$iv = (HttpResponse) fetchStreamingResponse;
                                    HttpClientCall call2 = response$iv.getCall();
                                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(DefaultClientWebSocketSession.class);
                                    kType = Reflection.typeOf(DefaultClientWebSocketSession.class);
                                    TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                                    buildersKt$webSocket$12.L$0 = block;
                                    buildersKt$webSocket$12.L$1 = this_$iv;
                                    buildersKt$webSocket$12.L$2 = response$iv;
                                    buildersKt$webSocket$12.label = 2;
                                    bodyNullable = call2.bodyNullable(typeInfo2, buildersKt$webSocket$12);
                                    if (bodyNullable != coroutine_suspended) {
                                    }
                                } catch (CancellationException e3) {
                                    cause$iv$iv = e3;
                                    throw ExceptionUtilsJvmKt.unwrapCancellationException(cause$iv$iv);
                                }
                                break;
                            case 2:
                                z = false;
                                z3 = false;
                                z4 = false;
                                response$iv = (HttpResponse) buildersKt$webSocket$12.L$2;
                                this_$iv = (HttpStatement) buildersKt$webSocket$12.L$1;
                                block2 = (Function2) buildersKt$webSocket$12.L$0;
                                ResultKt.throwOnFailure($result);
                                bodyNullable = $result;
                                if (bodyNullable != null) {
                                }
                                break;
                            case 3:
                                z = false;
                                z3 = false;
                                z4 = false;
                                it = (DefaultClientWebSocketSession) buildersKt$webSocket$12.L$2;
                                response$iv = (HttpResponse) buildersKt$webSocket$12.L$1;
                                this_$iv = (HttpStatement) buildersKt$webSocket$12.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    it2 = it;
                                    buildersKt$webSocket$12.L$0 = this_$iv;
                                    buildersKt$webSocket$12.L$1 = response$iv;
                                    buildersKt$webSocket$12.L$2 = it2;
                                    buildersKt$webSocket$12.label = 4;
                                    if (WebSocketSessionKt.close$default(it2, (CloseReason) null, buildersKt$webSocket$12, 1, (Object) null) != coroutine_suspended) {
                                    }
                                } catch (Throwable th7) {
                                    th2 = th7;
                                    buildersKt$webSocket$12.L$0 = this_$iv;
                                    buildersKt$webSocket$12.L$1 = response$iv;
                                    buildersKt$webSocket$12.L$2 = it;
                                    buildersKt$webSocket$12.L$3 = th2;
                                    buildersKt$webSocket$12.label = 5;
                                    if (WebSocketSessionKt.close$default(it, (CloseReason) null, buildersKt$webSocket$12, 1, (Object) null) == coroutine_suspended) {
                                    }
                                    ReceiveChannel.DefaultImpls.cancel$default(it.getIncoming(), (CancellationException) null, 1, (Object) null);
                                    throw th2;
                                }
                                break;
                            case 4:
                                z = false;
                                z4 = false;
                                it2 = (DefaultClientWebSocketSession) buildersKt$webSocket$12.L$2;
                                response$iv = (HttpResponse) buildersKt$webSocket$12.L$1;
                                this_$iv = (HttpStatement) buildersKt$webSocket$12.L$0;
                                ResultKt.throwOnFailure($result);
                                ReceiveChannel.DefaultImpls.cancel$default(it2.getIncoming(), (CancellationException) null, 1, (Object) null);
                                buildersKt$webSocket$12.L$0 = Unit.INSTANCE;
                                buildersKt$webSocket$12.L$1 = null;
                                buildersKt$webSocket$12.L$2 = null;
                                buildersKt$webSocket$12.label = 6;
                                if (this_$iv.cleanup(response$iv, buildersKt$webSocket$12) != coroutine_suspended) {
                                }
                                break;
                            case 5:
                                th2 = (Throwable) buildersKt$webSocket$12.L$3;
                                it = (DefaultClientWebSocketSession) buildersKt$webSocket$12.L$2;
                                HttpResponse httpResponse = (HttpResponse) buildersKt$webSocket$12.L$1;
                                HttpStatement httpStatement = (HttpStatement) buildersKt$webSocket$12.L$0;
                                ResultKt.throwOnFailure($result);
                                ReceiveChannel.DefaultImpls.cancel$default(it.getIncoming(), (CancellationException) null, 1, (Object) null);
                                throw th2;
                            case 6:
                                Unit unit = (Unit) buildersKt$webSocket$12.L$0;
                                ResultKt.throwOnFailure($result);
                            case 7:
                                th = (Throwable) buildersKt$webSocket$12.L$0;
                                ResultKt.throwOnFailure($result);
                                throw th;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }
                switch (buildersKt$webSocket$12.label) {
                }
            } catch (CancellationException e4) {
                cause$iv$iv = e4;
            }
        } catch (CancellationException e5) {
            cause$iv$iv = e5;
        }
        buildersKt$webSocket$1 = new BuildersKt$webSocket$1(continuation);
        buildersKt$webSocket$12 = buildersKt$webSocket$1;
        Object $result2 = buildersKt$webSocket$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit webSocket$lambda$8$lambda$7(URLBuilder $this$url, URLBuilder it) {
        Intrinsics.checkNotNullParameter($this$url, "$this$url");
        Intrinsics.checkNotNullParameter(it, "it");
        $this$url.setProtocol(URLProtocol.Companion.getWS());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit webSocket$lambda$10(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final Object webSocket(HttpClient $this$webSocket, final HttpMethod method, final String host2, final Integer port, final String path, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object webSocket = webSocket($this$webSocket, new Function1() { // from class: io.ktor.client.plugins.websocket.BuildersKt$$ExternalSyntheticLambda15
            public final Object invoke(Object obj) {
                Unit webSocket$lambda$11;
                webSocket$lambda$11 = BuildersKt.webSocket$lambda$11(HttpMethod.this, host2, port, path, function1, (HttpRequestBuilder) obj);
                return webSocket$lambda$11;
            }
        }, function2, continuation);
        return webSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? webSocket : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit webSocket$lambda$11(HttpMethod $method, String $host, Integer $port, String $path, Function1 $request, HttpRequestBuilder $this$webSocket) {
        Intrinsics.checkNotNullParameter($this$webSocket, "$this$webSocket");
        $this$webSocket.setMethod($method);
        HttpRequestKt.url$default($this$webSocket, "ws", $host, $port, $path, null, 16, null);
        $request.invoke($this$webSocket);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object webSocket$default(HttpClient httpClient, String str, Function1 function1, Function2 function2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.plugins.websocket.BuildersKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj2) {
                    Unit webSocket$lambda$12;
                    webSocket$lambda$12 = BuildersKt.webSocket$lambda$12((HttpRequestBuilder) obj2);
                    return webSocket$lambda$12;
                }
            };
        }
        return webSocket(httpClient, str, function1, function2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit webSocket$lambda$12(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final Object webSocket(HttpClient $this$webSocket, final String urlString, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object webSocket = webSocket($this$webSocket, HttpMethod.Companion.getGet(), null, null, null, new Function1() { // from class: io.ktor.client.plugins.websocket.BuildersKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit webSocket$lambda$13;
                webSocket$lambda$13 = BuildersKt.webSocket$lambda$13(urlString, function1, (HttpRequestBuilder) obj);
                return webSocket$lambda$13;
            }
        }, function2, continuation);
        return webSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? webSocket : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit webSocket$lambda$13(String $urlString, Function1 $request, HttpRequestBuilder $this$webSocket) {
        Intrinsics.checkNotNullParameter($this$webSocket, "$this$webSocket");
        $this$webSocket.getUrl().setProtocol(URLProtocol.Companion.getWS());
        $this$webSocket.getUrl().setPort(UtilsKt.getPort($this$webSocket));
        URLParserKt.takeFrom($this$webSocket.getUrl(), $urlString);
        $request.invoke($this$webSocket);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ws$lambda$14(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final Object ws(HttpClient $this$ws, HttpMethod method, String host2, Integer port, String path, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object webSocket = webSocket($this$ws, method, host2, port, path, function1, function2, continuation);
        return webSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? webSocket : Unit.INSTANCE;
    }

    public static final Object ws(HttpClient $this$ws, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object webSocket = webSocket($this$ws, function1, function2, continuation);
        return webSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? webSocket : Unit.INSTANCE;
    }

    public static /* synthetic */ Object ws$default(HttpClient httpClient, String str, Function1 function1, Function2 function2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.plugins.websocket.BuildersKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj2) {
                    Unit ws$lambda$15;
                    ws$lambda$15 = BuildersKt.ws$lambda$15((HttpRequestBuilder) obj2);
                    return ws$lambda$15;
                }
            };
        }
        return ws(httpClient, str, function1, function2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ws$lambda$15(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final Object ws(HttpClient $this$ws, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object webSocket = webSocket($this$ws, urlString, function1, function2, continuation);
        return webSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? webSocket : Unit.INSTANCE;
    }

    public static final Object wss(HttpClient $this$wss, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object webSocket = webSocket($this$wss, new Function1() { // from class: io.ktor.client.plugins.websocket.BuildersKt$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                Unit wss$lambda$16;
                wss$lambda$16 = BuildersKt.wss$lambda$16(function1, (HttpRequestBuilder) obj);
                return wss$lambda$16;
            }
        }, function2, continuation);
        return webSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? webSocket : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit wss$lambda$16(Function1 $request, HttpRequestBuilder $this$webSocket) {
        Intrinsics.checkNotNullParameter($this$webSocket, "$this$webSocket");
        $this$webSocket.getUrl().setProtocol(URLProtocol.Companion.getWSS());
        $this$webSocket.getUrl().setPort($this$webSocket.getUrl().getProtocol().getDefaultPort());
        $request.invoke($this$webSocket);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object wss$default(HttpClient httpClient, String str, Function1 function1, Function2 function2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.plugins.websocket.BuildersKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj2) {
                    Unit wss$lambda$17;
                    wss$lambda$17 = BuildersKt.wss$lambda$17((HttpRequestBuilder) obj2);
                    return wss$lambda$17;
                }
            };
        }
        return wss(httpClient, str, function1, function2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit wss$lambda$17(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final Object wss(HttpClient $this$wss, final String urlString, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object wss = wss($this$wss, new Function1() { // from class: io.ktor.client.plugins.websocket.BuildersKt$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                Unit wss$lambda$18;
                wss$lambda$18 = BuildersKt.wss$lambda$18(urlString, function1, (HttpRequestBuilder) obj);
                return wss$lambda$18;
            }
        }, function2, continuation);
        return wss == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? wss : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit wss$lambda$18(String $urlString, Function1 $request, HttpRequestBuilder $this$wss) {
        Intrinsics.checkNotNullParameter($this$wss, "$this$wss");
        URLParserKt.takeFrom($this$wss.getUrl(), $urlString);
        $request.invoke($this$wss);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit wss$lambda$19(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final Object wss(HttpClient $this$wss, HttpMethod method, String host2, final Integer port, String path, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object webSocket = webSocket($this$wss, method, host2, port, path, new Function1() { // from class: io.ktor.client.plugins.websocket.BuildersKt$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                Unit wss$lambda$20;
                wss$lambda$20 = BuildersKt.wss$lambda$20(port, function1, (HttpRequestBuilder) obj);
                return wss$lambda$20;
            }
        }, function2, continuation);
        return webSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? webSocket : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit wss$lambda$20(Integer $port, Function1 $request, HttpRequestBuilder $this$webSocket) {
        Intrinsics.checkNotNullParameter($this$webSocket, "$this$webSocket");
        $this$webSocket.getUrl().setProtocol(URLProtocol.Companion.getWSS());
        if ($port != null) {
            $this$webSocket.getUrl().setPort($port.intValue());
        }
        $request.invoke($this$webSocket);
        return Unit.INSTANCE;
    }
}