package io.ktor.client.engine;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DisposableHandle;

/* compiled from: Utils.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
public final class UtilsKt$attachToUserJob$2 implements Function1<Throwable, Unit> {
    final /* synthetic */ DisposableHandle $cleanupHandler;

    public UtilsKt$attachToUserJob$2(DisposableHandle disposableHandle) {
        this.$cleanupHandler = disposableHandle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((Throwable) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable it) {
        this.$cleanupHandler.dispose();
    }
}