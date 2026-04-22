package im.base;

import io.grpc.internal.GrpcUtil;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMToast.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.base.IMToastKt", f = "IMToast.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {GrpcUtil.DEFAULT_PORT_PLAINTEXT, 81, 82}, m = "toDisplayString", n = {"$this$toDisplayString", "default", "extraHandler", "defaultErrorMessage", "$this$toDisplayString", "default", "extraHandler", "defaultErrorMessage", "$this$toDisplayString", "default", "extraHandler", "defaultErrorMessage"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"}, v = 1)
public final class IMToastKt$toDisplayString$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMToastKt$toDisplayString$1(Continuation<? super IMToastKt$toDisplayString$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return IMToastKt.toDisplayString(null, null, null, (Continuation) this);
    }
}