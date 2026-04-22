package io.ktor.client;

import io.ktor.client.engine.HttpClientEngineFactory;
import io.ktor.utils.io.KtorDsl;
import java.util.Iterator;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* compiled from: HttpClientJvm.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a.\u0010\u0006\u001a\u00020\u00052\u001d\b\u0002\u0010\u0004\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\"\u001e\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u0012\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkotlin/Function1;", "Lio/ktor/client/HttpClientConfig;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lio/ktor/client/HttpClient;", "HttpClient", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/HttpClient;", "Lio/ktor/client/engine/HttpClientEngineFactory;", "FACTORY", "Lio/ktor/client/engine/HttpClientEngineFactory;", "getFACTORY$annotations", "()V", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HttpClientJvmKt {
    private static final HttpClientEngineFactory<?> FACTORY;

    private static /* synthetic */ void getFACTORY$annotations() {
    }

    public static /* synthetic */ HttpClient HttpClient$default(Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.HttpClientJvmKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    Unit HttpClient$lambda$0;
                    HttpClient$lambda$0 = HttpClientJvmKt.HttpClient$lambda$0((HttpClientConfig) obj2);
                    return HttpClient$lambda$0;
                }
            };
        }
        return HttpClient(function1);
    }

    @KtorDsl
    public static final HttpClient HttpClient(Function1<? super HttpClientConfig<?>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        return HttpClientKt.HttpClient(FACTORY, function1);
    }

    static {
        HttpClientEngineFactory<?> factory;
        Iterator it = ServiceLoader.load(HttpClientEngineContainer.class, HttpClientEngineContainer.class.getClassLoader()).iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        HttpClientEngineContainer httpClientEngineContainer = (HttpClientEngineContainer) SequencesKt.firstOrNull(SequencesKt.asSequence(it));
        if (httpClientEngineContainer == null || (factory = httpClientEngineContainer.getFactory()) == null) {
            throw new IllegalStateException("Failed to find HTTP client engine implementation: consider adding client engine dependency. See https://ktor.io/docs/http-client-engines.html".toString());
        }
        FACTORY = factory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HttpClient$lambda$0(HttpClientConfig httpClientConfig) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "<this>");
        return Unit.INSTANCE;
    }
}