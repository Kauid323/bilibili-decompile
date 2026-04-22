package io.ktor.client.plugins;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: HttpPlainText.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class HttpPlainTextKt$HttpPlainText$1 extends FunctionReferenceImpl implements Function0<HttpPlainTextConfig> {
    public static final HttpPlainTextKt$HttpPlainText$1 INSTANCE = new HttpPlainTextKt$HttpPlainText$1();

    HttpPlainTextKt$HttpPlainText$1() {
        super(0, HttpPlainTextConfig.class, "<init>", "<init>()V", 0);
    }

    /* renamed from: invoke */
    public final HttpPlainTextConfig m3444invoke() {
        return new HttpPlainTextConfig();
    }
}