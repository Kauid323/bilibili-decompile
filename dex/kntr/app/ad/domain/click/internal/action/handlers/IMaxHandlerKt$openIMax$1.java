package kntr.app.ad.domain.click.internal.action.handlers;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMaxHandler.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.domain.click.internal.action.handlers.IMaxHandlerKt", f = "IMaxHandler.kt", i = {0, 0}, l = {35}, m = "openIMax", n = {"context", "param"}, s = {"L$0", "L$1"}, v = 1)
public final class IMaxHandlerKt$openIMax$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMaxHandlerKt$openIMax$1(Continuation<? super IMaxHandlerKt$openIMax$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object openIMax;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        openIMax = IMaxHandlerKt.openIMax(null, null, (Continuation) this);
        return openIMax;
    }
}