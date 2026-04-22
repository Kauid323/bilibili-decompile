package im.base;

import im.base.IMToast;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMToast.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.base.IMToast$Companion", f = "IMToast.kt", i = {0, 0, 0, 0}, l = {38}, m = "create", n = {"error", "default", "ts", "extraHandler"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
public final class IMToast$Companion$create$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IMToast.Companion this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMToast$Companion$create$1(IMToast.Companion companion, Continuation<? super IMToast$Companion$create$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.create(null, null, null, null, (Continuation) this);
    }
}