package io.ktor.http;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: URLProtocol.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003¨\u0006\u0005"}, d2 = {"Lio/ktor/http/URLProtocol;", "", "isWebsocket", "(Lio/ktor/http/URLProtocol;)Z", "isSecure", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class URLProtocolKt {
    public static final boolean isWebsocket(URLProtocol $this$isWebsocket) {
        Intrinsics.checkNotNullParameter($this$isWebsocket, "<this>");
        return Intrinsics.areEqual($this$isWebsocket.getName(), "ws") || Intrinsics.areEqual($this$isWebsocket.getName(), "wss");
    }

    public static final boolean isSecure(URLProtocol $this$isSecure) {
        Intrinsics.checkNotNullParameter($this$isSecure, "<this>");
        return Intrinsics.areEqual($this$isSecure.getName(), "https") || Intrinsics.areEqual($this$isSecure.getName(), "wss");
    }
}