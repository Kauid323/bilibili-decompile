package io.ktor.client.plugins.cookies;

import external.org.apache.commons.lang3.ClassUtils;
import io.ktor.http.Cookie;
import io.ktor.http.IpParserKt;
import io.ktor.http.URLProtocolKt;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.util.TextKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CookiesStorage.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a$\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\u000b\u001a\u00020\n*\u00020\u00032\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f\u001a\u0019\u0010\r\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/plugins/cookies/CookiesStorage;", "", "urlString", "Lio/ktor/http/Cookie;", "cookie", "", "addCookie", "(Lio/ktor/client/plugins/cookies/CookiesStorage;Ljava/lang/String;Lio/ktor/http/Cookie;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/http/Url;", "requestUrl", "", "matches", "(Lio/ktor/http/Cookie;Lio/ktor/http/Url;)Z", "fillDefaults", "(Lio/ktor/http/Cookie;Lio/ktor/http/Url;)Lio/ktor/http/Cookie;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CookiesStorageKt {
    public static final Object addCookie(CookiesStorage $this$addCookie, String urlString, Cookie cookie, Continuation<? super Unit> continuation) {
        Object addCookie = $this$addCookie.addCookie(URLUtilsKt.Url(urlString), cookie, continuation);
        return addCookie == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? addCookie : Unit.INSTANCE;
    }

    public static final boolean matches(Cookie $this$matches, Url requestUrl) {
        String lowerCasePreservingASCIIRules;
        String domain;
        Intrinsics.checkNotNullParameter($this$matches, "<this>");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        String domain2 = $this$matches.getDomain();
        if (domain2 == null || (lowerCasePreservingASCIIRules = TextKt.toLowerCasePreservingASCIIRules(domain2)) == null || (domain = StringsKt.trimStart(lowerCasePreservingASCIIRules, new char[]{ClassUtils.PACKAGE_SEPARATOR_CHAR})) == null) {
            throw new IllegalStateException("Domain field should have the default value".toString());
        }
        $this$matches.getPath();
        String current = $this$matches.getPath();
        if (current == null) {
            throw new IllegalStateException("Path field should have the default value".toString());
        }
        if (!StringsKt.endsWith$default(current, '/', false, 2, (Object) null)) {
            current = $this$matches.getPath() + '/';
        }
        String $this$matches_u24lambda_u240 = current;
        String host2 = TextKt.toLowerCasePreservingASCIIRules(requestUrl.getHost());
        String pathInRequest = requestUrl.getEncodedPath();
        if (!StringsKt.endsWith$default(pathInRequest, '/', false, 2, (Object) null)) {
            pathInRequest = pathInRequest + '/';
        }
        String requestPath = pathInRequest;
        if (Intrinsics.areEqual(host2, domain) || (!IpParserKt.hostIsIp(host2) && StringsKt.endsWith$default(host2, ClassUtils.PACKAGE_SEPARATOR_CHAR + domain, false, 2, (Object) null))) {
            if (Intrinsics.areEqual($this$matches_u24lambda_u240, "/") || Intrinsics.areEqual(requestPath, $this$matches_u24lambda_u240) || StringsKt.startsWith$default(requestPath, $this$matches_u24lambda_u240, false, 2, (Object) null)) {
                return !$this$matches.getSecure() || URLProtocolKt.isSecure(requestUrl.getProtocol());
            }
            return false;
        }
        return false;
    }

    public static final Cookie fillDefaults(Cookie $this$fillDefaults, Url requestUrl) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter($this$fillDefaults, "<this>");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Cookie result = $this$fillDefaults;
        String path = result.getPath();
        if (path != null && StringsKt.startsWith$default(path, "/", false, 2, (Object) null)) {
            z = false;
            z2 = true;
        } else {
            z = false;
            z2 = true;
            result = Cookie.copy$default(result, null, null, null, null, null, null, requestUrl.getEncodedPath(), false, false, null, 959, null);
        }
        String domain = result.getDomain();
        if ((domain == null || StringsKt.isBlank(domain)) ? z2 : z) {
            return Cookie.copy$default(result, null, null, null, null, null, requestUrl.getHost(), null, false, false, null, 991, null);
        }
        return result;
    }
}