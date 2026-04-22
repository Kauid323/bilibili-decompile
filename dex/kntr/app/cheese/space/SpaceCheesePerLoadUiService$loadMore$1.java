package kntr.app.cheese.space;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpaceCheesePerLoadUiService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.cheese.space.SpaceCheesePerLoadUiService", f = "SpaceCheesePerLoadUiService.kt", i = {0, 0, 0}, l = {170}, m = "loadMore", n = {"classifiedTypeId", "sortTypeId", "isAppend"}, s = {"I$0", "I$1", "Z$0"}, v = 1)
public final class SpaceCheesePerLoadUiService$loadMore$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SpaceCheesePerLoadUiService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpaceCheesePerLoadUiService$loadMore$1(SpaceCheesePerLoadUiService spaceCheesePerLoadUiService, Continuation<? super SpaceCheesePerLoadUiService$loadMore$1> continuation) {
        super(continuation);
        this.this$0 = spaceCheesePerLoadUiService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadMore(0, 0, false, (Continuation) this);
    }
}