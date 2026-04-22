package io.ktor.client.engine;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: HttpClientEngine.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J(\u0010\u0007\u001a\u00020\u00062\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"io/ktor/client/engine/HttpClientEngineKt$config$1", "Lio/ktor/client/engine/HttpClientEngineFactory;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lio/ktor/client/engine/HttpClientEngine;", "create", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/engine/HttpClientEngine;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HttpClientEngineKt$config$1<T> implements HttpClientEngineFactory<T> {
    final /* synthetic */ Function1<T, Unit> $nested;
    final /* synthetic */ HttpClientEngineFactory<T> $parent;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public HttpClientEngineKt$config$1(HttpClientEngineFactory<? extends T> httpClientEngineFactory, Function1<? super T, Unit> function1) {
        this.$parent = httpClientEngineFactory;
        this.$nested = function1;
    }

    @Override // io.ktor.client.engine.HttpClientEngineFactory
    public HttpClientEngine create(final Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        HttpClientEngineFactory<T> httpClientEngineFactory = this.$parent;
        final Function1<T, Unit> function12 = this.$nested;
        return httpClientEngineFactory.create(new Function1() { // from class: io.ktor.client.engine.HttpClientEngineKt$config$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit create$lambda$0;
                create$lambda$0 = HttpClientEngineKt$config$1.create$lambda$0(function12, function1, (HttpClientEngineConfig) obj);
                return create$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit create$lambda$0(Function1 $nested, Function1 $block, HttpClientEngineConfig $this$create) {
        Intrinsics.checkNotNullParameter($this$create, "$this$create");
        $nested.invoke($this$create);
        $block.invoke($this$create);
        return Unit.INSTANCE;
    }
}