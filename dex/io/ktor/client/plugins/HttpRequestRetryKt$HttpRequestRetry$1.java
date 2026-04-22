package io.ktor.client.plugins;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: HttpRequestRetry.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class HttpRequestRetryKt$HttpRequestRetry$1 extends FunctionReferenceImpl implements Function0<HttpRequestRetryConfig> {
    public static final HttpRequestRetryKt$HttpRequestRetry$1 INSTANCE = new HttpRequestRetryKt$HttpRequestRetry$1();

    HttpRequestRetryKt$HttpRequestRetry$1() {
        super(0, HttpRequestRetryConfig.class, "<init>", "<init>()V", 0);
    }

    /* renamed from: invoke */
    public final HttpRequestRetryConfig m3451invoke() {
        return new HttpRequestRetryConfig();
    }
}