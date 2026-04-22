package tv.danmaku.bili.ui.garb.manager;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.manager.CollectionSideManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectionSideManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.garb.manager.CollectionSideManager$MenuTagData", f = "CollectionSideManager.kt", i = {}, l = {BR.coverThumbWidth}, m = "reportTagRemoved", n = {}, s = {}, v = 1)
public final class CollectionSideManager$MenuTagData$reportTagRemoved$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CollectionSideManager.MenuTagData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionSideManager$MenuTagData$reportTagRemoved$1(CollectionSideManager.MenuTagData menuTagData, Continuation<? super CollectionSideManager$MenuTagData$reportTagRemoved$1> continuation) {
        super(continuation);
        this.this$0 = menuTagData;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.reportTagRemoved((Continuation) this);
    }
}