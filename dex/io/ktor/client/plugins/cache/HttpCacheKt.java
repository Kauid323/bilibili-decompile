package io.ktor.client.plugins.cache;

import com.tencent.smtt.sdk.TbsVideoCacheTask;
import faceverify.q;
import io.ktor.client.engine.UtilsKt;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.URLProtocol;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;

/* compiled from: HttpCache.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aU\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00050\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\u000b\u001a\u00020\n*\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\f\"\u001e\u0010\u000f\u001a\u00060\rj\u0002`\u000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/http/content/OutgoingContent;", q.KEY_RES_9_CONTENT, "Lkotlin/Function1;", "", "headerExtractor", "", "allHeadersExtractor", "mergedHeadersLookup", "(Lio/ktor/http/content/OutgoingContent;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "Lio/ktor/http/URLProtocol;", "", "canStore", "(Lio/ktor/http/URLProtocol;)Z", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "getLOGGER", "()Lorg/slf4j/Logger;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HttpCacheKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpCache");

    public static final Logger getLOGGER() {
        return LOGGER;
    }

    public static final Function1<String, String> mergedHeadersLookup(final OutgoingContent content, final Function1<? super String, String> function1, final Function1<? super String, ? extends List<String>> function12) {
        Intrinsics.checkNotNullParameter(content, q.KEY_RES_9_CONTENT);
        Intrinsics.checkNotNullParameter(function1, "headerExtractor");
        Intrinsics.checkNotNullParameter(function12, "allHeadersExtractor");
        return new Function1() { // from class: io.ktor.client.plugins.cache.HttpCacheKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                String mergedHeadersLookup$lambda$0;
                mergedHeadersLookup$lambda$0 = HttpCacheKt.mergedHeadersLookup$lambda$0(OutgoingContent.this, function1, function12, (String) obj);
                return mergedHeadersLookup$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String mergedHeadersLookup$lambda$0(OutgoingContent $content, Function1 $headerExtractor, Function1 $allHeadersExtractor, String header) {
        String contentType;
        String l;
        Intrinsics.checkNotNullParameter(header, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
        if (Intrinsics.areEqual(header, HttpHeaders.INSTANCE.getContentLength())) {
            Long contentLength = $content.getContentLength();
            return (contentLength == null || (l = contentLength.toString()) == null) ? "" : l;
        } else if (Intrinsics.areEqual(header, HttpHeaders.INSTANCE.getContentType())) {
            ContentType contentType2 = $content.getContentType();
            return (contentType2 == null || (contentType = contentType2.toString()) == null) ? "" : contentType;
        } else if (Intrinsics.areEqual(header, HttpHeaders.INSTANCE.getUserAgent())) {
            String str = $content.getHeaders().get(HttpHeaders.INSTANCE.getUserAgent());
            if (str == null) {
                String str2 = (String) $headerExtractor.invoke(HttpHeaders.INSTANCE.getUserAgent());
                return str2 == null ? UtilsKt.getKTOR_DEFAULT_USER_AGENT() : str2;
            }
            return str;
        } else {
            List value = $content.getHeaders().getAll(header);
            if (value == null && (value = (List) $allHeadersExtractor.invoke(header)) == null) {
                value = CollectionsKt.emptyList();
            }
            return CollectionsKt.joinToString$default(value, ";", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean canStore(URLProtocol $this$canStore) {
        return Intrinsics.areEqual($this$canStore.getName(), "http") || Intrinsics.areEqual($this$canStore.getName(), "https");
    }
}