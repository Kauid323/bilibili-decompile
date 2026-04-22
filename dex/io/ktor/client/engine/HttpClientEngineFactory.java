package io.ktor.client.engine;

import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.client.engine.HttpClientEngineFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpClientEngine.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\u00020\u0003J*\u0010\t\u001a\u00020\b2\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lio/ktor/client/engine/HttpClientEngineFactory;", "Lio/ktor/client/engine/HttpClientEngineConfig;", "T", "", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lio/ktor/client/engine/HttpClientEngine;", "create", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/engine/HttpClientEngine;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface HttpClientEngineFactory<T extends HttpClientEngineConfig> {
    HttpClientEngine create(Function1<? super T, Unit> function1);

    /* compiled from: HttpClientEngine.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HttpClientEngine create$default(HttpClientEngineFactory httpClientEngineFactory, Function1 function1, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    function1 = new Function1() { // from class: io.ktor.client.engine.HttpClientEngineFactory$DefaultImpls$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj2) {
                            Unit create$lambda$0;
                            create$lambda$0 = HttpClientEngineFactory.DefaultImpls.create$lambda$0((HttpClientEngineConfig) obj2);
                            return create$lambda$0;
                        }
                    };
                }
                return httpClientEngineFactory.create(function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Unit create$lambda$0(HttpClientEngineConfig httpClientEngineConfig) {
            Intrinsics.checkNotNullParameter(httpClientEngineConfig, "<this>");
            return Unit.INSTANCE;
        }
    }
}