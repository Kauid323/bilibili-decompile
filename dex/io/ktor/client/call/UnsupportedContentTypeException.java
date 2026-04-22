package io.ktor.client.call;

import faceverify.q;
import io.ktor.http.content.OutgoingContent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: utils.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/client/call/UnsupportedContentTypeException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "Lio/ktor/http/content/OutgoingContent;", q.KEY_RES_9_CONTENT, "<init>", "(Lio/ktor/http/content/OutgoingContent;)V", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UnsupportedContentTypeException extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnsupportedContentTypeException(OutgoingContent content) {
        super("Failed to write body: " + Reflection.getOrCreateKotlinClass(content.getClass()));
        Intrinsics.checkNotNullParameter(content, q.KEY_RES_9_CONTENT);
    }
}