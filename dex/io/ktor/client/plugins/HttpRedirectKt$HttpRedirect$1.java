package io.ktor.client.plugins;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: HttpRedirect.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class HttpRedirectKt$HttpRedirect$1 extends FunctionReferenceImpl implements Function0<HttpRedirectConfig> {
    public static final HttpRedirectKt$HttpRedirect$1 INSTANCE = new HttpRedirectKt$HttpRedirect$1();

    HttpRedirectKt$HttpRedirect$1() {
        super(0, HttpRedirectConfig.class, "<init>", "<init>()V", 0);
    }

    /* renamed from: invoke */
    public final HttpRedirectConfig m3445invoke() {
        return new HttpRedirectConfig();
    }
}