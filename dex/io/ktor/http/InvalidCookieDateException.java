package io.ktor.http;

import com.vivo.vturbo.VturboNetworkConstantsProxy;
import im.setting.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CookieUtils.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/http/InvalidCookieDateException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "", UtilsKt.DATA_KEY, VturboNetworkConstantsProxy.NETWORK_BLOCK_REASON_KEY, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InvalidCookieDateException extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidCookieDateException(String data, String reason) {
        super("Failed to parse date string: \"" + data + "\". Reason: \"" + reason + '\"');
        Intrinsics.checkNotNullParameter(data, UtilsKt.DATA_KEY);
        Intrinsics.checkNotNullParameter(reason, VturboNetworkConstantsProxy.NETWORK_BLOCK_REASON_KEY);
    }
}