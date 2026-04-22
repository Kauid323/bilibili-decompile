package io.ktor.client.plugins.cookies;

import io.ktor.client.HttpClient;
import io.ktor.http.Url;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpCookies.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cookies.HttpCookiesKt", f = "HttpCookies.kt", i = {}, l = {136}, m = "cookies", n = {}, s = {})
public final class HttpCookiesKt$cookies$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpCookiesKt$cookies$1(Continuation<? super HttpCookiesKt$cookies$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return HttpCookiesKt.cookies((HttpClient) null, (Url) null, (Continuation) this);
    }
}