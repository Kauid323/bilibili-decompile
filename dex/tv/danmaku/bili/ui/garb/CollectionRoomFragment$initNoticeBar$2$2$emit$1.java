package tv.danmaku.bili.ui.garb;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.CollectionRoomFragment$initNoticeBar$2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectionRoomFragment.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.garb.CollectionRoomFragment$initNoticeBar$2$2", f = "CollectionRoomFragment.kt", i = {}, l = {BR.onScreen}, m = "emit", n = {}, s = {}, v = 1)
public final class CollectionRoomFragment$initNoticeBar$2$2$emit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CollectionRoomFragment$initNoticeBar$2.AnonymousClass2<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CollectionRoomFragment$initNoticeBar$2$2$emit$1(CollectionRoomFragment$initNoticeBar$2.AnonymousClass2<? super T> anonymousClass2, Continuation<? super CollectionRoomFragment$initNoticeBar$2$2$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass2;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Lifecycle.Event) null, (Continuation) this);
    }
}