package io.ktor.client.plugins;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* compiled from: HttpTimeout.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class HttpTimeoutKt$HttpTimeout$1 extends AdaptedFunctionReference implements Function0<HttpTimeoutConfig> {
    public static final HttpTimeoutKt$HttpTimeout$1 INSTANCE = new HttpTimeoutKt$HttpTimeout$1();

    HttpTimeoutKt$HttpTimeout$1() {
        super(0, HttpTimeoutConfig.class, "<init>", "<init>(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", 0);
    }

    /* renamed from: invoke */
    public final HttpTimeoutConfig m3453invoke() {
        return new HttpTimeoutConfig(null, null, null, 7, null);
    }
}