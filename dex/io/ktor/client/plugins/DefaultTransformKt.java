package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;

/* compiled from: DefaultTransform.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a!\u0010\u0007\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\b\"\u0018\u0010\u000b\u001a\u00060\tj\u0002`\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/client/HttpClient;", "", "defaultTransformers", "(Lio/ktor/client/HttpClient;)V", "", "contentLength", "bytes", "checkContentLength", "(Ljava/lang/Long;J)V", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DefaultTransformKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.defaultTransformers");

    public static final void defaultTransformers(HttpClient $this$defaultTransformers) {
        Intrinsics.checkNotNullParameter($this$defaultTransformers, "<this>");
        $this$defaultTransformers.getRequestPipeline().intercept(HttpRequestPipeline.Phases.getRender(), new DefaultTransformKt$defaultTransformers$1(null));
        $this$defaultTransformers.getResponsePipeline().intercept(HttpResponsePipeline.Phases.getParse(), new DefaultTransformKt$defaultTransformers$2($this$defaultTransformers, null));
        DefaultTransformersJvmKt.platformResponseDefaultTransformers($this$defaultTransformers);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkContentLength(Long contentLength, long bytes) {
        if (!(contentLength == null || contentLength.longValue() == bytes)) {
            throw new IllegalStateException(("Content-Length mismatch: expected " + contentLength + " bytes, but received " + bytes + " bytes").toString());
        }
    }
}