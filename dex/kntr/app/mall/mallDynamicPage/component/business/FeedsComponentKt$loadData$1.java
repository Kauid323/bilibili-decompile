package kntr.app.mall.mallDynamicPage.component.business;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FeedsComponent.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.mall.mallDynamicPage.component.business.FeedsComponentKt", f = "FeedsComponent.kt", i = {0, 0}, l = {361}, m = "loadData", n = {"json", "pageNum"}, s = {"L$0", "I$0"}, v = 1)
public final class FeedsComponentKt$loadData$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FeedsComponentKt$loadData$1(Continuation<? super FeedsComponentKt$loadData$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FeedsComponentKt.loadData(0, (Continuation) this);
    }
}