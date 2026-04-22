package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;

/* compiled from: RxCancellable.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"handleUndeliverableException", "", "cause", "", "context", "Lkotlin/coroutines/CoroutineContext;", "kotlinx-coroutines-rx3"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RxCancellableKt {
    public static final void handleUndeliverableException(Throwable cause, CoroutineContext context) {
        if (cause instanceof CancellationException) {
            return;
        }
        try {
            RxJavaPlugins.onError(cause);
        } catch (Throwable e) {
            ExceptionsKt.addSuppressed(cause, e);
            CoroutineExceptionHandlerKt.handleCoroutineException(context, cause);
        }
    }
}