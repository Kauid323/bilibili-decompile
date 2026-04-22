package io.ktor.client.plugins.observer;

import faceverify.q;
import io.ktor.client.call.HttpClientCall;
import io.ktor.http.Headers;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DelegatedCall.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u0003\u0010\u0007\u001a!\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/utils/io/ByteReadChannel;", q.KEY_RES_9_CONTENT, "wrapWithContent", "(Lio/ktor/client/call/HttpClientCall;Lio/ktor/utils/io/ByteReadChannel;)Lio/ktor/client/call/HttpClientCall;", "Lkotlin/Function0;", "block", "(Lio/ktor/client/call/HttpClientCall;Lkotlin/jvm/functions/Function0;)Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/http/Headers;", "headers", "wrap", "(Lio/ktor/client/call/HttpClientCall;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/http/Headers;)Lio/ktor/client/call/HttpClientCall;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DelegatedCallKt {
    public static final HttpClientCall wrapWithContent(HttpClientCall $this$wrapWithContent, ByteReadChannel content) {
        Intrinsics.checkNotNullParameter($this$wrapWithContent, "<this>");
        Intrinsics.checkNotNullParameter(content, q.KEY_RES_9_CONTENT);
        return new DelegatedCall($this$wrapWithContent.getClient(), content, $this$wrapWithContent, (Headers) null, 8, (DefaultConstructorMarker) null);
    }

    public static final HttpClientCall wrapWithContent(HttpClientCall $this$wrapWithContent, Function0<? extends ByteReadChannel> function0) {
        Intrinsics.checkNotNullParameter($this$wrapWithContent, "<this>");
        Intrinsics.checkNotNullParameter(function0, "block");
        return new DelegatedCall($this$wrapWithContent.getClient(), function0, $this$wrapWithContent, (Headers) null, 8, (DefaultConstructorMarker) null);
    }

    public static final HttpClientCall wrap(HttpClientCall $this$wrap, ByteReadChannel content, Headers headers) {
        Intrinsics.checkNotNullParameter($this$wrap, "<this>");
        Intrinsics.checkNotNullParameter(content, q.KEY_RES_9_CONTENT);
        Intrinsics.checkNotNullParameter(headers, "headers");
        return new DelegatedCall($this$wrap.getClient(), content, $this$wrap, headers);
    }
}