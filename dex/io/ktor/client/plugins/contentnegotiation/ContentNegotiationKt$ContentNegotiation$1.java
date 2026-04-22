package io.ktor.client.plugins.contentnegotiation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: ContentNegotiation.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class ContentNegotiationKt$ContentNegotiation$1 extends FunctionReferenceImpl implements Function0<ContentNegotiationConfig> {
    public static final ContentNegotiationKt$ContentNegotiation$1 INSTANCE = new ContentNegotiationKt$ContentNegotiation$1();

    ContentNegotiationKt$ContentNegotiation$1() {
        super(0, ContentNegotiationConfig.class, "<init>", "<init>()V", 0);
    }

    /* renamed from: invoke */
    public final ContentNegotiationConfig m3465invoke() {
        return new ContentNegotiationConfig();
    }
}