package kntr.app.game.base.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseListViewModel.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.base.viewmodel.BaseListViewModel", f = "BaseListViewModel.kt", i = {0, 0}, l = {28}, m = "loadData$suspendImpl", n = {"$this", "refresh"}, s = {"L$0", "Z$0"}, v = 1)
public final class BaseListViewModel$loadData$1<Data> extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BaseListViewModel<Data> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseListViewModel$loadData$1(BaseListViewModel<Data> baseListViewModel, Continuation<? super BaseListViewModel$loadData$1> continuation) {
        super(continuation);
        this.this$0 = baseListViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return BaseListViewModel.loadData$suspendImpl(this.this$0, false, (Continuation) this);
    }
}