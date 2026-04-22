package kotlinx.coroutines.rx3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RxAwait.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.rx3.RxAwaitKt", f = "RxAwait.kt", i = {0}, l = {109}, m = "awaitOrDefault", n = {"default"}, s = {"L$0"})
public final class RxAwaitKt$awaitOrDefault$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RxAwaitKt$awaitOrDefault$1(Continuation<? super RxAwaitKt$awaitOrDefault$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= IntCompanionObject.MIN_VALUE;
        return RxAwaitKt.awaitOrDefault(null, null, this);
    }
}