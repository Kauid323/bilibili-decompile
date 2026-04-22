package kntr.app.ad.domain.click;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Clicker.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.domain.click.Clicker", f = "Clicker.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7}, l = {86, 108, 124, 129, 141, 147, 158, 164}, m = "innerClick", n = {"request", "current", "dlSucCallUpUrl", "request", "current", "dlSucCallUpUrl", "request", "current", "dlSucCallUpUrl", "request", "current", "dlSucCallUpUrl", "mainResult", "$i$a$-run-Clicker$innerClick$minorResult$1", "request", "current", "dlSucCallUpUrl", "request", "current", "dlSucCallUpUrl", "request", "current", "dlSucCallUpUrl", "request", "current", "dlSucCallUpUrl"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 1)
public final class Clicker$innerClick$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Clicker this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Clicker$innerClick$1(Clicker clicker, Continuation<? super Clicker$innerClick$1> continuation) {
        super(continuation);
        this.this$0 = clicker;
    }

    public final Object invokeSuspend(Object obj) {
        Object innerClick;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        innerClick = this.this$0.innerClick(null, (Continuation) this);
        return innerClick;
    }
}