package kntr.app.tribee.consume.viewmodel;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeHomeStateMachine.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.viewmodel.TribeeHomeStateMachine", f = "TribeeHomeStateMachine.kt", i = {0, 0, 0, 0}, l = {877}, m = "handleLoadMore", n = {"action", "state", "currentEntry", "nextPage"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
public final class TribeeHomeStateMachine$handleLoadMore$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TribeeHomeStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeHomeStateMachine$handleLoadMore$1(TribeeHomeStateMachine tribeeHomeStateMachine, Continuation<? super TribeeHomeStateMachine$handleLoadMore$1> continuation) {
        super(continuation);
        this.this$0 = tribeeHomeStateMachine;
    }

    public final Object invokeSuspend(Object obj) {
        Object handleLoadMore;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        handleLoadMore = this.this$0.handleLoadMore(null, null, (Continuation) this);
        return handleLoadMore;
    }
}