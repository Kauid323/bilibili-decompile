package kntr.common.compose.list;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Overscroll.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.compose.list.OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1", f = "Overscroll.kt", i = {0, 0, 1, 1, 1, 1, 1}, l = {331, 343}, m = "onPostFling-RZ2iAVY", n = {"$v$c$androidx-compose-ui-unit-Velocity$-consumed$0", "$v$c$androidx-compose-ui-unit-Velocity$-available$0", "lastDelta", "lastVelocity", "$v$c$androidx-compose-ui-unit-Velocity$-consumed$0", "$v$c$androidx-compose-ui-unit-Velocity$-available$0", "realAvailable"}, s = {"J$0", "J$1", "L$0", "L$1", "J$0", "J$1", "J$2"}, v = 1)
public final class OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$1 extends ContinuationImpl {
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
    public OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$1(OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1 overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1, Continuation<? super OverscrollKt$overScrollOutOfBound$1$nestedConnection$1$1$onPostFling$1> continuation) {
        super(continuation);
        this.this$0 = overscrollKt$overScrollOutOfBound$1$nestedConnection$1$1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m1861onPostFlingRZ2iAVY(0L, 0L, (Continuation) this);
    }
}