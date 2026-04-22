package io.ktor.client.plugins.observer;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: ResponseObserver.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class ResponseObserverKt$ResponseObserver$1 extends FunctionReferenceImpl implements Function0<ResponseObserverConfig> {
    public static final ResponseObserverKt$ResponseObserver$1 INSTANCE = new ResponseObserverKt$ResponseObserver$1();

    ResponseObserverKt$ResponseObserver$1() {
        super(0, ResponseObserverConfig.class, "<init>", "<init>()V", 0);
    }

    /* renamed from: invoke */
    public final ResponseObserverConfig m3469invoke() {
        return new ResponseObserverConfig();
    }
}