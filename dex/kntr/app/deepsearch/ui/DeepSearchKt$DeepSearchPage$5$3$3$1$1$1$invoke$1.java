package kntr.app.deepsearch.ui;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeepSearch.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.ui.DeepSearchKt$DeepSearchPage$5$3$3$1$1$1", f = "DeepSearch.kt", i = {0, 1}, l = {332, 337}, m = "invoke", n = {"$this$pointerInput", "$this$pointerInput"}, s = {"L$0", "L$0"}, v = 1)
public final class DeepSearchKt$DeepSearchPage$5$3$3$1$1$1$invoke$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeepSearchKt$DeepSearchPage$5$3$3$1$1$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepSearchKt$DeepSearchPage$5$3$3$1$1$1$invoke$1(DeepSearchKt$DeepSearchPage$5$3$3$1$1$1 deepSearchKt$DeepSearchPage$5$3$3$1$1$1, Continuation<? super DeepSearchKt$DeepSearchPage$5$3$3$1$1$1$invoke$1> continuation) {
        super(continuation);
        this.this$0 = deepSearchKt$DeepSearchPage$5$3$3$1$1$1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(null, (Continuation) this);
    }
}