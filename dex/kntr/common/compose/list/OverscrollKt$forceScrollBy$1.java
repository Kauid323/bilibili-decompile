package kntr.common.compose.list;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Overscroll.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.compose.list.OverscrollKt", f = "Overscroll.kt", i = {0, 0, 0}, l = {465}, m = "forceScrollBy", n = {"$this$forceScrollBy", "consumed", "offset"}, s = {"L$0", "L$1", "F$0"}, v = 1)
public final class OverscrollKt$forceScrollBy$1 extends ContinuationImpl {
    float F$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OverscrollKt$forceScrollBy$1(Continuation<? super OverscrollKt$forceScrollBy$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object forceScrollBy;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        forceScrollBy = OverscrollKt.forceScrollBy(null, 0.0f, (Continuation) this);
        return forceScrollBy;
    }
}