package io.ktor.http;

import com.vivo.vturbo.VturboNetworkConstantsProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpStatusCode.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0004*\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "Lio/ktor/http/HttpStatusCode;", "allStatusCodes", "()Ljava/util/List;", "", VturboNetworkConstantsProxy.APPTOSYS_KEY_PRELOAD_FEEDBACK_RESULT, "(Lio/ktor/http/HttpStatusCode;)Z", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HttpStatusCodeKt {
    public static final List<HttpStatusCode> allStatusCodes() {
        return CollectionsKt.listOf(new HttpStatusCode[]{HttpStatusCode.Companion.getContinue(), HttpStatusCode.Companion.getSwitchingProtocols(), HttpStatusCode.Companion.getProcessing(), HttpStatusCode.Companion.getOK(), HttpStatusCode.Companion.getCreated(), HttpStatusCode.Companion.getAccepted(), HttpStatusCode.Companion.getNonAuthoritativeInformation(), HttpStatusCode.Companion.getNoContent(), HttpStatusCode.Companion.getResetContent(), HttpStatusCode.Companion.getPartialContent(), HttpStatusCode.Companion.getMultiStatus(), HttpStatusCode.Companion.getMultipleChoices(), HttpStatusCode.Companion.getMovedPermanently(), HttpStatusCode.Companion.getFound(), HttpStatusCode.Companion.getSeeOther(), HttpStatusCode.Companion.getNotModified(), HttpStatusCode.Companion.getUseProxy(), HttpStatusCode.Companion.getSwitchProxy(), HttpStatusCode.Companion.getTemporaryRedirect(), HttpStatusCode.Companion.getPermanentRedirect(), HttpStatusCode.Companion.getBadRequest(), HttpStatusCode.Companion.getUnauthorized(), HttpStatusCode.Companion.getPaymentRequired(), HttpStatusCode.Companion.getForbidden(), HttpStatusCode.Companion.getNotFound(), HttpStatusCode.Companion.getMethodNotAllowed(), HttpStatusCode.Companion.getNotAcceptable(), HttpStatusCode.Companion.getProxyAuthenticationRequired(), HttpStatusCode.Companion.getRequestTimeout(), HttpStatusCode.Companion.getConflict(), HttpStatusCode.Companion.getGone(), HttpStatusCode.Companion.getLengthRequired(), HttpStatusCode.Companion.getPreconditionFailed(), HttpStatusCode.Companion.getPayloadTooLarge(), HttpStatusCode.Companion.getRequestURITooLong(), HttpStatusCode.Companion.getUnsupportedMediaType(), HttpStatusCode.Companion.getRequestedRangeNotSatisfiable(), HttpStatusCode.Companion.getExpectationFailed(), HttpStatusCode.Companion.getUnprocessableEntity(), HttpStatusCode.Companion.getLocked(), HttpStatusCode.Companion.getFailedDependency(), HttpStatusCode.Companion.getTooEarly(), HttpStatusCode.Companion.getUpgradeRequired(), HttpStatusCode.Companion.getTooManyRequests(), HttpStatusCode.Companion.getRequestHeaderFieldTooLarge(), HttpStatusCode.Companion.getInternalServerError(), HttpStatusCode.Companion.getNotImplemented(), HttpStatusCode.Companion.getBadGateway(), HttpStatusCode.Companion.getServiceUnavailable(), HttpStatusCode.Companion.getGatewayTimeout(), HttpStatusCode.Companion.getVersionNotSupported(), HttpStatusCode.Companion.getVariantAlsoNegotiates(), HttpStatusCode.Companion.getInsufficientStorage()});
    }

    public static final boolean isSuccess(HttpStatusCode $this$isSuccess) {
        Intrinsics.checkNotNullParameter($this$isSuccess, "<this>");
        int value = $this$isSuccess.getValue();
        return 200 <= value && value < 300;
    }
}