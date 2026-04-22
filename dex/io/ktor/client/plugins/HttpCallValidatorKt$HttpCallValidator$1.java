package io.ktor.client.plugins;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: HttpCallValidator.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class HttpCallValidatorKt$HttpCallValidator$1 extends FunctionReferenceImpl implements Function0<HttpCallValidatorConfig> {
    public static final HttpCallValidatorKt$HttpCallValidator$1 INSTANCE = new HttpCallValidatorKt$HttpCallValidator$1();

    HttpCallValidatorKt$HttpCallValidator$1() {
        super(0, HttpCallValidatorConfig.class, "<init>", "<init>()V", 0);
    }

    /* renamed from: invoke */
    public final HttpCallValidatorConfig m3440invoke() {
        return new HttpCallValidatorConfig();
    }
}