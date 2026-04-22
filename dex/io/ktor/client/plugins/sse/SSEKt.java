package io.ktor.client.plugins.sse;

import com.tencent.open.SocialConstants;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;

/* compiled from: SSE.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a1\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\"\u001e\u0010\n\u001a\u00060\bj\u0002`\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"#\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"", "T", "Lio/ktor/client/request/HttpRequestBuilder;", SocialConstants.TYPE_REQUEST, "Lio/ktor/util/AttributeKey;", "attributeKey", "getAttributeValue", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/util/AttributeKey;)Ljava/lang/Object;", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "getLOGGER", "()Lorg/slf4j/Logger;", "Lio/ktor/client/plugins/api/ClientPlugin;", "Lio/ktor/client/plugins/sse/SSEConfig;", "SSE", "Lio/ktor/client/plugins/api/ClientPlugin;", "getSSE", "()Lio/ktor/client/plugins/api/ClientPlugin;", "getSSE$annotations", "()V", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SSEKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.sse.SSE");
    private static final ClientPlugin<SSEConfig> SSE = CreatePluginUtilsKt.createClientPlugin("SSE", SSEKt$SSE$1.INSTANCE, new Function1() { // from class: io.ktor.client.plugins.sse.SSEKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Unit SSE$lambda$0;
            SSE$lambda$0 = SSEKt.SSE$lambda$0((ClientPluginBuilder) obj);
            return SSE$lambda$0;
        }
    });

    public static /* synthetic */ void getSSE$annotations() {
    }

    public static final Logger getLOGGER() {
        return LOGGER;
    }

    public static final ClientPlugin<SSEConfig> getSSE() {
        return SSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SSE$lambda$0(ClientPluginBuilder $this$createClientPlugin) {
        Intrinsics.checkNotNullParameter($this$createClientPlugin, "$this$createClientPlugin");
        long reconnectionTime = ((SSEConfig) $this$createClientPlugin.getPluginConfig()).m3499getReconnectionTimeUwyO8pc();
        boolean showCommentEvents = ((SSEConfig) $this$createClientPlugin.getPluginConfig()).getShowCommentEvents$ktor_client_core();
        boolean showRetryEvents = ((SSEConfig) $this$createClientPlugin.getPluginConfig()).getShowRetryEvents$ktor_client_core();
        $this$createClientPlugin.on(AfterRender.INSTANCE, new SSEKt$SSE$2$1(reconnectionTime, showCommentEvents, showRetryEvents, null));
        $this$createClientPlugin.getClient().getResponsePipeline().intercept(HttpResponsePipeline.Phases.getTransform(), new SSEKt$SSE$2$2(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T getAttributeValue(HttpRequestBuilder request, AttributeKey<T> attributeKey) {
        return (T) request.getAttributes().getOrNull(attributeKey);
    }
}