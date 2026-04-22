package kntr.common.compose.list;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.compose.list.OverscrollKt$overScrollOutOfBound$1$2$1;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Overscroll.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.compose.list.OverscrollKt$overScrollOutOfBound$1$2$1$1", f = "Overscroll.kt", i = {0, 1}, l = {448, 450}, m = "emit", n = {"itemCount", "itemCount"}, s = {"I$0", "I$0"}, v = 1)
public final class OverscrollKt$overScrollOutOfBound$1$2$1$1$emit$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OverscrollKt$overScrollOutOfBound$1$2$1.AnonymousClass1<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OverscrollKt$overScrollOutOfBound$1$2$1$1$emit$1(OverscrollKt$overScrollOutOfBound$1$2$1.AnonymousClass1<? super T> anonymousClass1, Continuation<? super OverscrollKt$overScrollOutOfBound$1$2$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(0, (Continuation) this);
    }
}