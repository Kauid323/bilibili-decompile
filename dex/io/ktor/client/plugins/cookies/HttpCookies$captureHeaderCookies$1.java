package io.ktor.client.plugins.cookies;

import host.R;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpCookies.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cookies.HttpCookies", f = "HttpCookies.kt", i = {0, 0}, l = {R.styleable.CameraView_cameraVideoSizeMinWidth}, m = "captureHeaderCookies$ktor_client_core", n = {"this", "url"}, s = {"L$0", "L$1"})
public final class HttpCookies$captureHeaderCookies$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpCookies this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCookies$captureHeaderCookies$1(HttpCookies httpCookies, Continuation<? super HttpCookies$captureHeaderCookies$1> continuation) {
        super(continuation);
        this.this$0 = httpCookies;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.captureHeaderCookies$ktor_client_core(null, (Continuation) this);
    }
}