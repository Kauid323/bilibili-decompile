package io.ktor.client.plugins.websocket;

import io.ktor.client.request.ClientUpgradeContent;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.websocket.UtilsKt;
import io.ktor.util.Base64Kt;
import io.ktor.util.CryptoKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebSocketContent.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/client/plugins/websocket/WebSocketContent;", "Lio/ktor/client/request/ClientUpgradeContent;", "<init>", "()V", "Lio/ktor/http/Headers;", "headers", "", "verify", "(Lio/ktor/http/Headers;)V", "", "toString", "()Ljava/lang/String;", "nonce", "Ljava/lang/String;", "Lio/ktor/http/Headers;", "getHeaders", "()Lio/ktor/http/Headers;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WebSocketContent extends ClientUpgradeContent {
    private final Headers headers;
    private final String nonce;

    public WebSocketContent() {
        StringBuilder $this$nonce_u24lambda_u240 = new StringBuilder();
        byte[] nonce = CryptoKt.generateNonce(16);
        $this$nonce_u24lambda_u240.append(Base64Kt.encodeBase64(nonce));
        String sb = $this$nonce_u24lambda_u240.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        this.nonce = sb;
        HeadersBuilder $this$headers_u24lambda_u241 = new HeadersBuilder(0, 1, null);
        $this$headers_u24lambda_u241.append(HttpHeaders.INSTANCE.getUpgrade(), "websocket");
        $this$headers_u24lambda_u241.append(HttpHeaders.INSTANCE.getConnection(), "Upgrade");
        $this$headers_u24lambda_u241.append(HttpHeaders.INSTANCE.getSecWebSocketKey(), this.nonce);
        $this$headers_u24lambda_u241.append(HttpHeaders.INSTANCE.getSecWebSocketVersion(), "13");
        this.headers = $this$headers_u24lambda_u241.m3526build();
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Headers getHeaders() {
        return this.headers;
    }

    @Override // io.ktor.client.request.ClientUpgradeContent
    public void verify(Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        String serverAccept = headers.get(HttpHeaders.INSTANCE.getSecWebSocketAccept());
        if (serverAccept == null) {
            throw new IllegalStateException(("Server should specify header " + HttpHeaders.INSTANCE.getSecWebSocketAccept()).toString());
        }
        String expectedAccept = UtilsKt.websocketServerAccept(this.nonce);
        if (!Intrinsics.areEqual(expectedAccept, serverAccept)) {
            throw new IllegalStateException(("Failed to verify server accept header. Expected: " + expectedAccept + ", received: " + serverAccept).toString());
        }
    }

    public String toString() {
        return "WebSocketContent";
    }
}