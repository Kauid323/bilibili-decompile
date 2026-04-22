package io.ktor.client.plugins.cookies;

import io.ktor.http.Cookie;
import io.ktor.http.Url;
import java.io.Closeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: CookiesStorage.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00060\u0001j\u0002`\u0002J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H¦@¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0006H¦@¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/client/plugins/cookies/CookiesStorage;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "Lio/ktor/http/Url;", "requestUrl", "", "Lio/ktor/http/Cookie;", "get", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cookie", "", "addCookie", "(Lio/ktor/http/Url;Lio/ktor/http/Cookie;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface CookiesStorage extends Closeable {
    Object addCookie(Url url, Cookie cookie, Continuation<? super Unit> continuation);

    Object get(Url url, Continuation<? super List<Cookie>> continuation);
}