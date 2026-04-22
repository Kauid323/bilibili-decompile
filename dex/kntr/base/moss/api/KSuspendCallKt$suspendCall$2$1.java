package kntr.base.moss.api;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: Add missing generic type declarations: [KRespT] */
/* compiled from: KSuspendCall.kt */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0012\u0010\u0002\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0003¨\u0006\f"}, d2 = {"kntr/base/moss/api/KSuspendCallKt$suspendCall$2$1", "Lkntr/base/moss/api/KMossResponseHandler;", "resp", "Ljava/lang/Object;", "onNext", "", "value", "(Ljava/lang/Object;)V", "onCompleted", "onError", "t", "Lkntr/base/moss/api/KMossException;", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = 176)
public final class KSuspendCallKt$suspendCall$2$1<KRespT> implements KMossResponseHandler<KRespT> {
    final /* synthetic */ CancellableContinuation<KRespT> $it;
    private KRespT resp;

    /* JADX WARN: Multi-variable type inference failed */
    public KSuspendCallKt$suspendCall$2$1(CancellableContinuation<? super KRespT> cancellableContinuation) {
        this.$it = cancellableContinuation;
    }

    @Override // kntr.base.moss.api.KMossResponseHandler
    public void onNext(KRespT krespt) {
        this.resp = krespt;
    }

    @Override // kntr.base.moss.api.KMossResponseHandler
    public void onCompleted() {
        if (this.$it.isActive()) {
            Object result = this.resp;
            if (result != null) {
                Result.Companion companion = Result.Companion;
                this.$it.resumeWith(Result.m2636constructorimpl(result));
                return;
            }
            Result.Companion companion2 = Result.Companion;
            this.$it.resumeWith(Result.m2636constructorimpl(ResultKt.createFailure(new KMossException("Unlikely null response without exception", null))));
        }
    }

    @Override // kntr.base.moss.api.KMossResponseHandler
    public void onError(KMossException t) {
        KMossException kMossException;
        if (this.$it.isActive()) {
            Continuation continuation = this.$it;
            Result.Companion companion = Result.Companion;
            if (t != null) {
                kMossException = t;
            } else {
                kMossException = new KMossException("Unknown exception in kmoss coroutine", null);
            }
            continuation.resumeWith(Result.m2636constructorimpl(ResultKt.createFailure(kMossException)));
        }
    }
}