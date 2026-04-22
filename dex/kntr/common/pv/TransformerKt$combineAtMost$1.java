package kntr.common.pv;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Transformer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lkntr/common/pv/PvState;", "state1", "state2"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.pv.TransformerKt$combineAtMost$1", f = "Transformer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TransformerKt$combineAtMost$1 extends SuspendLambda implements Function3<PvState, PvState, Continuation<? super PvState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransformerKt$combineAtMost$1(Continuation<? super TransformerKt$combineAtMost$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(PvState pvState, PvState pvState2, Continuation<? super PvState> continuation) {
        TransformerKt$combineAtMost$1 transformerKt$combineAtMost$1 = new TransformerKt$combineAtMost$1(continuation);
        transformerKt$combineAtMost$1.L$0 = pvState;
        transformerKt$combineAtMost$1.L$1 = pvState2;
        return transformerKt$combineAtMost$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        PvState state1 = (PvState) this.L$0;
        PvState state2 = (PvState) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return RangesKt.coerceAtMost(state1, state2);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}