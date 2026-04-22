package kntr.base.net.comm.muiltidomain;

import com.bilibili.ignet.exception.IgNetworkException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.RetryableGatewayException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u0003\u001a\u0010\u0010\u0004\u001a\u00020\u0001*\u00060\u0002j\u0002`\u0003H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u0001*\u00060\u0002j\u0002`\u0003H\u0002\u001a\u0010\u0010\u0006\u001a\u00020\u0001*\u00060\u0002j\u0002`\u0003H\u0002\u001a\u0012\u0010\u0007\u001a\u00020\u00012\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003¨\u0006\t"}, d2 = {"isRetryable", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "isJavaTimeoutException", "isJavaSSLException", "isRetryableGatewayException", "ignetShouldTryDomainDowngrade", "e", "multi_domain_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UtilsKt {
    public static final boolean isRetryable(Exception $this$isRetryable) {
        Intrinsics.checkNotNullParameter($this$isRetryable, "<this>");
        boolean timeout = isJavaTimeoutException($this$isRetryable) || ignetShouldTryDomainDowngrade($this$isRetryable);
        boolean ssl = isJavaSSLException($this$isRetryable);
        boolean gateway = isRetryableGatewayException($this$isRetryable);
        return timeout || ssl || gateway;
    }

    private static final boolean isJavaTimeoutException(Exception $this$isJavaTimeoutException) {
        return ($this$isJavaTimeoutException instanceof ConnectException) || ($this$isJavaTimeoutException instanceof SocketTimeoutException);
    }

    private static final boolean isJavaSSLException(Exception $this$isJavaSSLException) {
        return ($this$isJavaSSLException instanceof SSLHandshakeException) || ($this$isJavaSSLException instanceof SSLPeerUnverifiedException) || ($this$isJavaSSLException instanceof CertificateException) || ($this$isJavaSSLException instanceof CertPathValidatorException);
    }

    private static final boolean isRetryableGatewayException(Exception $this$isRetryableGatewayException) {
        return $this$isRetryableGatewayException instanceof RetryableGatewayException;
    }

    public static final boolean ignetShouldTryDomainDowngrade(Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        IgNetworkException cause = e.getCause();
        IgNetworkException igNetworkException = cause instanceof IgNetworkException ? cause : null;
        Boolean shouldTry = igNetworkException != null ? Boolean.valueOf(igNetworkException.tryDomainDowngrade()) : null;
        if (shouldTry != null) {
            return shouldTry.booleanValue();
        }
        return false;
    }
}