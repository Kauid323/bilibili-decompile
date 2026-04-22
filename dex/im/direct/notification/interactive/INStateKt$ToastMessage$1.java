package im.direct.notification.interactive;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: INState.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.direct.notification.interactive.INStateKt", f = "INState.kt", i = {0, 0}, l = {339}, m = "ToastMessage", n = {"t", "default"}, s = {"L$0", "L$1"}, v = 1)
public final class INStateKt$ToastMessage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public INStateKt$ToastMessage$1(Continuation<? super INStateKt$ToastMessage$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return INStateKt.ToastMessage(null, null, (Continuation) this);
    }
}