package io.ktor.http;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Url.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003\"\u0018\u0010\b\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0003¨\u0006\t"}, d2 = {"Lio/ktor/http/Url;", "", "getAuthority", "(Lio/ktor/http/Url;)Ljava/lang/String;", "authority", "getProtocolWithAuthority", "protocolWithAuthority", "getEncodedUserAndPassword", "encodedUserAndPassword", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class UrlKt {
    public static final String getAuthority(Url $this$authority) {
        Intrinsics.checkNotNullParameter($this$authority, "<this>");
        StringBuilder $this$_get_authority__u24lambda_u240 = new StringBuilder();
        $this$_get_authority__u24lambda_u240.append(getEncodedUserAndPassword($this$authority));
        $this$_get_authority__u24lambda_u240.append(URLUtilsKt.getHostWithPortIfSpecified($this$authority));
        String sb = $this$_get_authority__u24lambda_u240.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    public static final String getProtocolWithAuthority(Url $this$protocolWithAuthority) {
        Intrinsics.checkNotNullParameter($this$protocolWithAuthority, "<this>");
        StringBuilder $this$_get_protocolWithAuthority__u24lambda_u241 = new StringBuilder();
        $this$_get_protocolWithAuthority__u24lambda_u241.append($this$protocolWithAuthority.getProtocol().getName());
        $this$_get_protocolWithAuthority__u24lambda_u241.append("://");
        $this$_get_protocolWithAuthority__u24lambda_u241.append(getEncodedUserAndPassword($this$protocolWithAuthority));
        if ($this$protocolWithAuthority.getSpecifiedPort() == 0 || $this$protocolWithAuthority.getSpecifiedPort() == $this$protocolWithAuthority.getProtocol().getDefaultPort()) {
            $this$_get_protocolWithAuthority__u24lambda_u241.append($this$protocolWithAuthority.getHost());
        } else {
            $this$_get_protocolWithAuthority__u24lambda_u241.append(URLUtilsKt.getHostWithPort($this$protocolWithAuthority));
        }
        String sb = $this$_get_protocolWithAuthority__u24lambda_u241.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    public static final String getEncodedUserAndPassword(Url $this$encodedUserAndPassword) {
        Intrinsics.checkNotNullParameter($this$encodedUserAndPassword, "<this>");
        StringBuilder $this$_get_encodedUserAndPassword__u24lambda_u242 = new StringBuilder();
        URLUtilsKt.appendUserAndPassword($this$_get_encodedUserAndPassword__u24lambda_u242, $this$encodedUserAndPassword.getEncodedUser(), $this$encodedUserAndPassword.getEncodedPassword());
        String sb = $this$_get_encodedUserAndPassword__u24lambda_u242.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }
}