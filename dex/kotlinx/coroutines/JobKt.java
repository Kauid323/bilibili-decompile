package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

@Metadata(d1 = {"kotlinx/coroutines/JobKt__FutureKt", "kotlinx/coroutines/JobKt__JobKt"}, k = 4, mv = {1, 9, 0}, xi = 48)
public final class JobKt {
    public static final CompletableJob Job(Job parent) {
        return JobKt__JobKt.Job(parent);
    }

    public static final void cancel(CoroutineContext $this$cancel, CancellationException cause) {
        JobKt__JobKt.cancel($this$cancel, cause);
    }

    public static final void cancel(Job $this$cancel, String message, Throwable cause) {
        JobKt__JobKt.cancel($this$cancel, message, cause);
    }

    public static final Object cancelAndJoin(Job $this$cancelAndJoin, Continuation<? super Unit> continuation) {
        return JobKt__JobKt.cancelAndJoin($this$cancelAndJoin, continuation);
    }

    public static final void cancelChildren(CoroutineContext $this$cancelChildren, CancellationException cause) {
        JobKt__JobKt.cancelChildren($this$cancelChildren, cause);
    }

    public static final void cancelChildren(Job $this$cancelChildren, CancellationException cause) {
        JobKt__JobKt.cancelChildren($this$cancelChildren, cause);
    }

    public static final void cancelFutureOnCancellation(CancellableContinuation<?> cancellableContinuation, Future<?> future) {
        JobKt__FutureKt.cancelFutureOnCancellation(cancellableContinuation, future);
    }

    public static final DisposableHandle cancelFutureOnCompletion(Job $this$cancelFutureOnCompletion, Future<?> future) {
        return JobKt__FutureKt.cancelFutureOnCompletion($this$cancelFutureOnCompletion, future);
    }

    public static final DisposableHandle disposeOnCompletion(Job $this$disposeOnCompletion, DisposableHandle handle) {
        return JobKt__JobKt.disposeOnCompletion($this$disposeOnCompletion, handle);
    }

    public static final void ensureActive(CoroutineContext $this$ensureActive) {
        JobKt__JobKt.ensureActive($this$ensureActive);
    }

    public static final void ensureActive(Job $this$ensureActive) {
        JobKt__JobKt.ensureActive($this$ensureActive);
    }

    public static final Job getJob(CoroutineContext $this$job) {
        return JobKt__JobKt.getJob($this$job);
    }

    public static final DisposableHandle invokeOnCompletion(Job $this$invokeOnCompletion, boolean onCancelling, boolean invokeImmediately, InternalCompletionHandler handler) {
        return JobKt__JobKt.invokeOnCompletion($this$invokeOnCompletion, onCancelling, invokeImmediately, handler);
    }

    public static /* synthetic */ DisposableHandle invokeOnCompletion$default(Job job, boolean z, boolean z2, InternalCompletionHandler internalCompletionHandler, int i, Object obj) {
        return JobKt__JobKt.invokeOnCompletion$default(job, z, z2, internalCompletionHandler, i, obj);
    }

    public static final boolean isActive(CoroutineContext $this$isActive) {
        return JobKt__JobKt.isActive($this$isActive);
    }
}