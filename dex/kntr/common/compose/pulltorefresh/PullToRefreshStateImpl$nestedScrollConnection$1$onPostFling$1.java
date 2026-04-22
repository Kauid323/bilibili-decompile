package kntr.common.compose.pulltorefresh;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PullToRefreshState.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.compose.pulltorefresh.PullToRefreshStateImpl$nestedScrollConnection$1", f = "PullToRefreshState.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2}, l = {253, KotlinVersion.MAX_COMPONENT_VALUE, 259}, m = "onPostFling-RZ2iAVY", n = {"$v$c$androidx-compose-ui-unit-Velocity$-consumed$0", "$v$c$androidx-compose-ui-unit-Velocity$-available$0", "availableOffset", "offset", "$v$c$androidx-compose-ui-unit-Velocity$-consumed$0", "$v$c$androidx-compose-ui-unit-Velocity$-available$0", "availableOffset", "offset", "$v$c$androidx-compose-ui-unit-Velocity$-consumed$0", "$v$c$androidx-compose-ui-unit-Velocity$-available$0"}, s = {"J$0", "J$1", "F$0", "F$1", "J$0", "J$1", "F$0", "F$1", "J$0", "J$1"}, v = 1)
public final class PullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$1 extends ContinuationImpl {
    float F$0;
    float F$1;
    long J$0;
    long J$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PullToRefreshStateImpl$nestedScrollConnection$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$1(PullToRefreshStateImpl$nestedScrollConnection$1 pullToRefreshStateImpl$nestedScrollConnection$1, Continuation<? super PullToRefreshStateImpl$nestedScrollConnection$1$onPostFling$1> continuation) {
        super(continuation);
        this.this$0 = pullToRefreshStateImpl$nestedScrollConnection$1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m1869onPostFlingRZ2iAVY(0L, 0L, (Continuation) this);
    }
}