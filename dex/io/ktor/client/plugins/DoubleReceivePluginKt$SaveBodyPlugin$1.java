package io.ktor.client.plugins;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: DoubleReceivePlugin.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class DoubleReceivePluginKt$SaveBodyPlugin$1 extends FunctionReferenceImpl implements Function0<SaveBodyPluginConfig> {
    public static final DoubleReceivePluginKt$SaveBodyPlugin$1 INSTANCE = new DoubleReceivePluginKt$SaveBodyPlugin$1();

    DoubleReceivePluginKt$SaveBodyPlugin$1() {
        super(0, SaveBodyPluginConfig.class, "<init>", "<init>()V", 0);
    }

    /* renamed from: invoke */
    public final SaveBodyPluginConfig m3439invoke() {
        return new SaveBodyPluginConfig();
    }
}