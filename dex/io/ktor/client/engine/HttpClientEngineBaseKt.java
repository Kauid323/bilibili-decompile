package io.ktor.client.engine;

import java.io.Closeable;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* compiled from: HttpClientEngineBase.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher;", "", "close", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HttpClientEngineBaseKt {
    private static final void close(CoroutineDispatcher $this$close) {
        try {
            if ($this$close instanceof ExecutorCoroutineDispatcher) {
                ((ExecutorCoroutineDispatcher) $this$close).close();
            } else if ($this$close instanceof Closeable) {
                ((Closeable) $this$close).close();
            }
        } catch (Throwable th) {
        }
    }
}