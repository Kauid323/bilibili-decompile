package io.ktor.client.plugins;

import com.xiaomi.mipush.sdk.Constants;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.TextContent;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.Charsets;
import kotlinx.io.Source;
import org.slf4j.Logger;

/* compiled from: HttpPlainText.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a.\u0010\u0006\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0004\b\u0006\u0010\u0007\"\u0018\u0010\n\u001a\u00060\bj\u0002`\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/client/HttpClientConfig;", "Lkotlin/Function1;", "Lio/ktor/client/plugins/HttpPlainTextConfig;", "", "Lkotlin/ExtensionFunctionType;", "block", "Charsets", "(Lio/ktor/client/HttpClientConfig;Lkotlin/jvm/functions/Function1;)V", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "Lio/ktor/client/plugins/api/ClientPlugin;", "HttpPlainText", "Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpPlainText", "()Lio/ktor/client/plugins/api/ClientPlugin;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HttpPlainTextKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpPlainText");
    private static final ClientPlugin<HttpPlainTextConfig> HttpPlainText = CreatePluginUtilsKt.createClientPlugin("HttpPlainText", HttpPlainTextKt$HttpPlainText$1.INSTANCE, new Function1() { // from class: io.ktor.client.plugins.HttpPlainTextKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Unit HttpPlainText$lambda$6;
            HttpPlainText$lambda$6 = HttpPlainTextKt.HttpPlainText$lambda$6((ClientPluginBuilder) obj);
            return HttpPlainText$lambda$6;
        }
    });

    public static final ClientPlugin<HttpPlainTextConfig> getHttpPlainText() {
        return HttpPlainText;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HttpPlainText$lambda$6(ClientPluginBuilder $this$createClientPlugin) {
        Intrinsics.checkNotNullParameter($this$createClientPlugin, "$this$createClientPlugin");
        Iterable $this$sortedByDescending$iv = MapsKt.toList(((HttpPlainTextConfig) $this$createClientPlugin.getPluginConfig()).getCharsetQuality$ktor_client_core());
        List withQuality = CollectionsKt.sortedWith($this$sortedByDescending$iv, new Comparator() { // from class: io.ktor.client.plugins.HttpPlainTextKt$HttpPlainText$lambda$6$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Pair it = (Pair) t2;
                Pair it2 = (Pair) t;
                return ComparisonsKt.compareValues((Float) it.getSecond(), (Float) it2.getSecond());
            }
        });
        Charset responseCharsetFallback = ((HttpPlainTextConfig) $this$createClientPlugin.getPluginConfig()).getResponseCharsetFallback();
        Iterable $this$filter$iv = ((HttpPlainTextConfig) $this$createClientPlugin.getPluginConfig()).getCharsets$ktor_client_core();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            Charset it = (Charset) element$iv$iv;
            if (!((HttpPlainTextConfig) $this$createClientPlugin.getPluginConfig()).getCharsetQuality$ktor_client_core().containsKey(it)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$sortedBy$iv = (List) destination$iv$iv;
        List withoutQuality = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: io.ktor.client.plugins.HttpPlainTextKt$HttpPlainText$lambda$6$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Charset it2 = (Charset) t;
                Charset it3 = (Charset) t2;
                return ComparisonsKt.compareValues(CharsetJVMKt.getName(it2), CharsetJVMKt.getName(it3));
            }
        });
        StringBuilder $this$HttpPlainText_u24lambda_u246_u24lambda_u245 = new StringBuilder();
        boolean z = false;
        for (Object element$iv : withoutQuality) {
            Charset it2 = (Charset) element$iv;
            if ($this$HttpPlainText_u24lambda_u246_u24lambda_u245.length() > 0) {
                $this$HttpPlainText_u24lambda_u246_u24lambda_u245.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            $this$HttpPlainText_u24lambda_u246_u24lambda_u245.append(CharsetJVMKt.getName(it2));
        }
        List $this$forEach$iv = withQuality;
        for (Object element$iv2 : $this$forEach$iv) {
            Pair pair = (Pair) element$iv2;
            Charset charset = (Charset) pair.component1();
            float quality = ((Number) pair.component2()).floatValue();
            if ($this$HttpPlainText_u24lambda_u246_u24lambda_u245.length() > 0) {
                $this$HttpPlainText_u24lambda_u246_u24lambda_u245.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            double d2 = quality;
            if (!(0.0d <= d2 && d2 <= 1.0d)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            double truncatedQuality = MathKt.roundToInt(100 * quality) / 100.0d;
            $this$HttpPlainText_u24lambda_u246_u24lambda_u245.append(CharsetJVMKt.getName(charset) + ";q=" + truncatedQuality);
            z = z;
            $this$forEach$iv = $this$forEach$iv;
        }
        if ($this$HttpPlainText_u24lambda_u246_u24lambda_u245.length() == 0) {
            $this$HttpPlainText_u24lambda_u246_u24lambda_u245.append(CharsetJVMKt.getName(responseCharsetFallback));
        }
        String acceptCharsetHeader = $this$HttpPlainText_u24lambda_u246_u24lambda_u245.toString();
        Intrinsics.checkNotNullExpressionValue(acceptCharsetHeader, "toString(...)");
        Charset requestCharset = ((HttpPlainTextConfig) $this$createClientPlugin.getPluginConfig()).getSendCharset();
        if (requestCharset == null && (requestCharset = (Charset) CollectionsKt.firstOrNull(withoutQuality)) == null) {
            Pair pair2 = (Pair) CollectionsKt.firstOrNull(withQuality);
            requestCharset = pair2 != null ? (Charset) pair2.getFirst() : null;
            if (requestCharset == null) {
                requestCharset = Charsets.UTF_8;
            }
        }
        $this$createClientPlugin.on(RenderRequestHook.INSTANCE, new HttpPlainTextKt$HttpPlainText$2$1(acceptCharsetHeader, requestCharset, null));
        $this$createClientPlugin.transformResponseBody(new HttpPlainTextKt$HttpPlainText$2$2(responseCharsetFallback, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OutgoingContent HttpPlainText$lambda$6$wrapContent(Charset requestCharset, HttpRequestBuilder request, String content, ContentType requestContentType) {
        Charset charset;
        ContentType contentType = requestContentType == null ? ContentType.Text.INSTANCE.getPlain() : requestContentType;
        if (requestContentType == null || (charset = ContentTypesKt.charset(requestContentType)) == null) {
            charset = requestCharset;
        }
        LOGGER.trace("Sending request body to " + request.getUrl() + " as text/plain with charset " + charset);
        return new TextContent(content, ContentTypesKt.withCharset(contentType, charset), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String HttpPlainText$lambda$6$read(Charset responseCharsetFallback, HttpClientCall call, Source body) {
        Charset actualCharset = HttpMessagePropertiesKt.charset(call.getResponse());
        if (actualCharset == null) {
            actualCharset = responseCharsetFallback;
        }
        LOGGER.trace("Reading response body for " + call.getRequest().getUrl() + " as String with charset " + actualCharset);
        return StringsKt.readText$default(body, actualCharset, 0, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HttpPlainText$lambda$6$addCharsetHeaders(String acceptCharsetHeader, HttpRequestBuilder context) {
        if (context.getHeaders().get(HttpHeaders.INSTANCE.getAcceptCharset()) != null) {
            return;
        }
        LOGGER.trace("Adding Accept-Charset=" + acceptCharsetHeader + " to " + context.getUrl());
        context.getHeaders().set(HttpHeaders.INSTANCE.getAcceptCharset(), acceptCharsetHeader);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void Charsets(HttpClientConfig<?> httpClientConfig, Function1<? super HttpPlainTextConfig, Unit> function1) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        httpClientConfig.install(HttpPlainText, function1);
    }
}