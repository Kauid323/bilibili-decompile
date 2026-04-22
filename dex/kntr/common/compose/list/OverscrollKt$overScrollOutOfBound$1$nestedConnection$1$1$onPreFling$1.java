package kntr.common.compose.list;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Overscroll.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.compose.list.OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1", f = "Overscroll.kt", i = {0, 1, 2, 2, 2, 2}, l = {281, 284, 307}, m = "onPreFling-QWom1Mo", n = {"$v$c$androidx-compose-ui-unit-Velocity$-available$0", "$v$c$androidx-compose-ui-unit-Velocity$-available$0", "leftVelocity", "$v$c$androidx-compose-ui-unit-Velocity$-available$0", "parentConsumed", "realAvailable"}, s = {"J$0", "J$0", "L$0", "J$0", "J$1", "J$2"}, v = 1)
public final class OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    long J$2;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1(OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1 overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1, Continuation<? super OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPreFling$1> continuation) {
        super(continuation);
        this.this$0 = overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m1863onPreFlingQWom1Mo(0L, (Continuation) this);
    }
}