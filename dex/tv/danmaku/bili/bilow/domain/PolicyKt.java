package tv.danmaku.bili.bilow.domain;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.bilow.ignet.util.IgExceptionKt;

/* compiled from: Policy.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0006"}, d2 = {"isRetryable", "", "Ljava/io/IOException;", "isJavaTimeoutException", "isJavaSSLException", "isRetryableGatewayException", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PolicyKt {
    public static final boolean isRetryable(IOException $this$isRetryable) {
        Intrinsics.checkNotNullParameter($this$isRetryable, "<this>");
        boolean timeout = isJavaTimeoutException($this$isRetryable) || IgExceptionKt.ignetShouldTryDomainDowngrade($this$isRetryable);
        boolean ssl = isJavaSSLException($this$isRetryable);
        boolean gateway = isRetryableGatewayException($this$isRetryable);
        return timeout || ssl || gateway;
    }

    private static final boolean isJavaTimeoutException(IOException $this$isJavaTimeoutException) {
        return ($this$isJavaTimeoutException instanceof ConnectException) || ($this$isJavaTimeoutException instanceof SocketTimeoutException);
    }

    private static final boolean isJavaSSLException(IOException $this$isJavaSSLException) {
        return ($this$isJavaSSLException instanceof SSLHandshakeException) || ($this$isJavaSSLException instanceof SSLPeerUnverifiedException) || ($this$isJavaSSLException instanceof CertificateException) || ($this$isJavaSSLException instanceof CertPathValidatorException);
    }

    private static final boolean isRetryableGatewayException(IOException $this$isRetryableGatewayException) {
        return $this$isRetryableGatewayException instanceof RetryableGatewayException;
    }
}