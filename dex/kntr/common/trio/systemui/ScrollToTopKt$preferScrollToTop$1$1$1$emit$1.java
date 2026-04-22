package kntr.common.trio.systemui;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.trio.systemui.ScrollToTopKt$preferScrollToTop$1$1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ScrollToTop.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.trio.systemui.ScrollToTopKt$preferScrollToTop$1$1$1", f = "ScrollToTop.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {41, 47, 49, ConstantsKt.DAY_CONTENT_PREVIEW_ROW_HEIGHT}, m = "emit", n = {"it", "snapLayoutCoordinates", "parentBounds", "itemBounds", "isVisible", "it", "snapLayoutCoordinates", "parentBounds", "itemBounds", "isVisible", "idx", "it", "snapLayoutCoordinates", "parentBounds", "itemBounds", "isVisible", "idx", "it", "snapLayoutCoordinates", "parentBounds", "itemBounds", "isVisible", "idx"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 1)
public final class ScrollToTopKt$preferScrollToTop$1$1$1$emit$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ScrollToTopKt$preferScrollToTop$1$1.AnonymousClass1<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ScrollToTopKt$preferScrollToTop$1$1$1$emit$1(ScrollToTopKt$preferScrollToTop$1$1.AnonymousClass1<? super T> anonymousClass1, Continuation<? super ScrollToTopKt$preferScrollToTop$1$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Unit) null, (Continuation) this);
    }
}