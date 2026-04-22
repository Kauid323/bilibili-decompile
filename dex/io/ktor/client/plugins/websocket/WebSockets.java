package io.ktor.client.plugins.websocket;

import faceverify.q;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.HttpHeaders;
import io.ktor.serialization.WebsocketContentConverter;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.KtorDsl;
import io.ktor.websocket.DefaultWebSocketSession;
import io.ktor.websocket.DefaultWebSocketSessionKt;
import io.ktor.websocket.WebSocketExtension;
import io.ktor.websocket.WebSocketExtensionHeader;
import io.ktor.websocket.WebSocketExtensionHeaderKt;
import io.ktor.websocket.WebSocketExtensionsConfig;
import io.ktor.websocket.WebSocketSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: WebSockets.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 *2\u00020\u0001:\u0002+*B-\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nB\u001d\b\u0016\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u000bB\t\b\u0016¢\u0006\u0004\b\t\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0014H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010!\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0000¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\"\u001a\u0004\b%\u0010$R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010&R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lio/ktor/client/plugins/websocket/WebSockets;", "", "", "pingIntervalMillis", "maxFrameSize", "Lio/ktor/websocket/WebSocketExtensionsConfig;", "extensionsConfig", "Lio/ktor/serialization/WebsocketContentConverter;", "contentConverter", "<init>", "(JJLio/ktor/websocket/WebSocketExtensionsConfig;Lio/ktor/serialization/WebsocketContentConverter;)V", "(JJ)V", "()V", "Lio/ktor/client/request/HttpRequestBuilder;", "context", "", "installExtensions", "(Lio/ktor/client/request/HttpRequestBuilder;)V", "Lio/ktor/client/call/HttpClientCall;", "call", "", "Lio/ktor/websocket/WebSocketExtension;", "completeNegotiation", "(Lio/ktor/client/call/HttpClientCall;)Ljava/util/List;", "Lio/ktor/websocket/WebSocketExtensionHeader;", "protocols", "addNegotiatedProtocols", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/util/List;)V", "Lio/ktor/websocket/WebSocketSession;", "session", "Lio/ktor/websocket/DefaultWebSocketSession;", "convertSessionToDefault$ktor_client_core", "(Lio/ktor/websocket/WebSocketSession;)Lio/ktor/websocket/DefaultWebSocketSession;", "convertSessionToDefault", "J", "getPingIntervalMillis", "()J", "getMaxFrameSize", "Lio/ktor/websocket/WebSocketExtensionsConfig;", "Lio/ktor/serialization/WebsocketContentConverter;", "getContentConverter", "()Lio/ktor/serialization/WebsocketContentConverter;", "Plugin", "Config", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WebSockets {
    public static final Plugin Plugin = new Plugin(null);
    private static final AttributeKey<WebSockets> key;
    private final WebsocketContentConverter contentConverter;
    private final WebSocketExtensionsConfig extensionsConfig;
    private final long maxFrameSize;
    private final long pingIntervalMillis;

    public WebSockets(long pingIntervalMillis, long maxFrameSize, WebSocketExtensionsConfig extensionsConfig, WebsocketContentConverter contentConverter) {
        Intrinsics.checkNotNullParameter(extensionsConfig, "extensionsConfig");
        this.pingIntervalMillis = pingIntervalMillis;
        this.maxFrameSize = maxFrameSize;
        this.extensionsConfig = extensionsConfig;
        this.contentConverter = contentConverter;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ WebSockets(long j, long j2, WebSocketExtensionsConfig webSocketExtensionsConfig, WebsocketContentConverter websocketContentConverter, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, webSocketExtensionsConfig, r6);
        WebsocketContentConverter websocketContentConverter2;
        if ((i2 & 8) == 0) {
            websocketContentConverter2 = websocketContentConverter;
        } else {
            websocketContentConverter2 = null;
        }
    }

    public final long getPingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    public final long getMaxFrameSize() {
        return this.maxFrameSize;
    }

    public final WebsocketContentConverter getContentConverter() {
        return this.contentConverter;
    }

    public /* synthetic */ WebSockets(long j, long j2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? 2147483647L : j2);
    }

    public WebSockets(long pingIntervalMillis, long maxFrameSize) {
        this(pingIntervalMillis, maxFrameSize, new WebSocketExtensionsConfig(), null, 8, null);
    }

    public WebSockets() {
        this(0L, 2147483647L, new WebSocketExtensionsConfig(), null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void installExtensions(HttpRequestBuilder context) {
        Iterable installed = this.extensionsConfig.build();
        context.getAttributes().put(WebSocketsKt.access$getREQUEST_EXTENSIONS_KEY$p(), installed);
        Iterable $this$flatMap$iv = installed;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            WebSocketExtension it = (WebSocketExtension) element$iv$iv;
            Iterable list$iv$iv = it.getProtocols();
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        List protocols = (List) destination$iv$iv;
        addNegotiatedProtocols(context, protocols);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<WebSocketExtension<?>> completeNegotiation(HttpClientCall call) {
        List serverExtensions;
        String it = call.getResponse().getHeaders().get(HttpHeaders.INSTANCE.getSecWebSocketExtensions());
        if (it == null || (serverExtensions = WebSocketExtensionHeaderKt.parseWebSocketExtensions(it)) == null) {
            serverExtensions = CollectionsKt.emptyList();
        }
        Iterable clientExtensions = (List) call.getAttributes().get(WebSocketsKt.access$getREQUEST_EXTENSIONS_KEY$p());
        Iterable $this$filter$iv = clientExtensions;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (((WebSocketExtension) element$iv$iv).clientNegotiation(serverExtensions)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    private final void addNegotiatedProtocols(HttpRequestBuilder context, List<WebSocketExtensionHeader> list) {
        if (list.isEmpty()) {
            return;
        }
        String headerValue = CollectionsKt.joinToString$default(list, ";", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        UtilsKt.header(context, HttpHeaders.INSTANCE.getSecWebSocketExtensions(), headerValue);
    }

    public final DefaultWebSocketSession convertSessionToDefault$ktor_client_core(WebSocketSession session) {
        Intrinsics.checkNotNullParameter(session, "session");
        if (session instanceof DefaultWebSocketSession) {
            return (DefaultWebSocketSession) session;
        }
        DefaultWebSocketSession it = DefaultWebSocketSessionKt.DefaultWebSocketSession(session, this.pingIntervalMillis, this.pingIntervalMillis * 2);
        it.setMaxFrameSize(this.maxFrameSize);
        return it;
    }

    /* compiled from: WebSockets.kt */
    @KtorDsl
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\t\u001a\u00020\u00062\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lio/ktor/client/plugins/websocket/WebSockets$Config;", "", "<init>", "()V", "Lkotlin/Function1;", "Lio/ktor/websocket/WebSocketExtensionsConfig;", "", "Lkotlin/ExtensionFunctionType;", "block", "extensions", "(Lkotlin/jvm/functions/Function1;)V", "extensionsConfig", "Lio/ktor/websocket/WebSocketExtensionsConfig;", "getExtensionsConfig$ktor_client_core", "()Lio/ktor/websocket/WebSocketExtensionsConfig;", "", "pingIntervalMillis", "J", "getPingIntervalMillis", "()J", "setPingIntervalMillis", "(J)V", "maxFrameSize", "getMaxFrameSize", "setMaxFrameSize", "Lio/ktor/serialization/WebsocketContentConverter;", "contentConverter", "Lio/ktor/serialization/WebsocketContentConverter;", "getContentConverter", "()Lio/ktor/serialization/WebsocketContentConverter;", "setContentConverter", "(Lio/ktor/serialization/WebsocketContentConverter;)V", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Config {
        private WebsocketContentConverter contentConverter;
        private final WebSocketExtensionsConfig extensionsConfig = new WebSocketExtensionsConfig();
        private long maxFrameSize = 2147483647L;
        private long pingIntervalMillis;

        public final WebSocketExtensionsConfig getExtensionsConfig$ktor_client_core() {
            return this.extensionsConfig;
        }

        public final long getPingIntervalMillis() {
            return this.pingIntervalMillis;
        }

        public final void setPingIntervalMillis(long j) {
            this.pingIntervalMillis = j;
        }

        public final long getMaxFrameSize() {
            return this.maxFrameSize;
        }

        public final void setMaxFrameSize(long j) {
            this.maxFrameSize = j;
        }

        public final WebsocketContentConverter getContentConverter() {
            return this.contentConverter;
        }

        public final void setContentConverter(WebsocketContentConverter websocketContentConverter) {
            this.contentConverter = websocketContentConverter;
        }

        public final void extensions(Function1<? super WebSocketExtensionsConfig, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            function1.invoke(this.extensionsConfig);
        }
    }

    /* compiled from: WebSockets.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\n\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00118\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/client/plugins/websocket/WebSockets$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/websocket/WebSockets$Config;", "Lio/ktor/client/plugins/websocket/WebSockets;", "<init>", "()V", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "prepare", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/websocket/WebSockets;", "plugin", "Lio/ktor/client/HttpClient;", "scope", "install", "(Lio/ktor/client/plugins/websocket/WebSockets;Lio/ktor/client/HttpClient;)V", "Lio/ktor/util/AttributeKey;", q.KEY_RES_9_KEY, "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Plugin implements HttpClientPlugin<Config, WebSockets> {
        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Plugin() {
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<WebSockets> getKey() {
            return WebSockets.key;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public WebSockets prepare(Function1<? super Config, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            Config config = new Config();
            function1.invoke(config);
            return new WebSockets(config.getPingIntervalMillis(), config.getMaxFrameSize(), config.getExtensionsConfig$ktor_client_core(), config.getContentConverter());
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public void install(WebSockets plugin, HttpClient scope) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            boolean extensionsSupported = scope.getEngine().getSupportedCapabilities().contains(WebSocketExtensionsCapability.INSTANCE);
            scope.getRequestPipeline().intercept(HttpRequestPipeline.Phases.getRender(), new WebSockets$Plugin$install$1(extensionsSupported, plugin, null));
            scope.getResponsePipeline().intercept(HttpResponsePipeline.Phases.getTransform(), new WebSockets$Plugin$install$2(plugin, extensionsSupported, null));
        }
    }

    static {
        KType kType = null;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(WebSockets.class);
        try {
            kType = Reflection.typeOf(WebSockets.class);
        } catch (Throwable th) {
        }
        key = new AttributeKey<>("Websocket", new TypeInfo(orCreateKotlinClass, kType));
    }
}