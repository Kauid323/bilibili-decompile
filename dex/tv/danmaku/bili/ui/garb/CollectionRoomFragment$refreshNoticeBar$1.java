package tv.danmaku.bili.ui.garb;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectionRoomFragment.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.garb.CollectionRoomFragment", f = "CollectionRoomFragment.kt", i = {}, l = {BR.paddingEnd}, m = "refreshNoticeBar", n = {}, s = {}, v = 1)
public final class CollectionRoomFragment$refreshNoticeBar$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CollectionRoomFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionRoomFragment$refreshNoticeBar$1(CollectionRoomFragment collectionRoomFragment, Continuation<? super CollectionRoomFragment$refreshNoticeBar$1> continuation) {
        super(continuation);
        this.this$0 = collectionRoomFragment;
    }

    public final Object invokeSuspend(Object obj) {
        Object refreshNoticeBar;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        refreshNoticeBar = this.this$0.refreshNoticeBar(0L, (Continuation) this);
        return refreshNoticeBar;
    }
}