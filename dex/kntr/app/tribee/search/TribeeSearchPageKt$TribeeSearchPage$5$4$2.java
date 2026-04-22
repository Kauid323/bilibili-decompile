package kntr.app.tribee.search;

import androidx.compose.runtime.State;
import kntr.app.tribee.search.state.TribeeSearchState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.pv.PvEventTrigger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeSearchPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.search.TribeeSearchPageKt$TribeeSearchPage$5$4$2", f = "TribeeSearchPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeSearchPageKt$TribeeSearchPage$5$4$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<PvEventTrigger> $pvEventTrigger;
    final /* synthetic */ State<TribeeSearchState> $state$delegate;
    final /* synthetic */ String $tribeeId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TribeeSearchPageKt$TribeeSearchPage$5$4$2(Ref.ObjectRef<PvEventTrigger> objectRef, String str, State<? extends TribeeSearchState> state, Continuation<? super TribeeSearchPageKt$TribeeSearchPage$5$4$2> continuation) {
        super(2, continuation);
        this.$pvEventTrigger = objectRef;
        this.$tribeeId = str;
        this.$state$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeSearchPageKt$TribeeSearchPage$5$4$2(this.$pvEventTrigger, this.$tribeeId, this.$state$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        TribeeSearchState TribeeSearchPage$lambda$2;
        TribeeSearchState TribeeSearchPage$lambda$22;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                TribeeSearchPage$lambda$2 = TribeeSearchPageKt.TribeeSearchPage$lambda$2(this.$state$delegate);
                TribeeSearchState.Result result = TribeeSearchPage$lambda$2 instanceof TribeeSearchState.Result ? (TribeeSearchState.Result) TribeeSearchPage$lambda$2 : null;
                String trackId = result != null ? result.getTrackId() : null;
                TribeeSearchPage$lambda$22 = TribeeSearchPageKt.TribeeSearchPage$lambda$2(this.$state$delegate);
                String query = TribeeSearchPage$lambda$22.getSearchBarState().getQuery();
                PvEventTrigger pvEventTrigger = (PvEventTrigger) this.$pvEventTrigger.element;
                if (pvEventTrigger != null) {
                    Pair[] pairArr = new Pair[3];
                    pairArr[0] = TuplesKt.to("tribee_id", this.$tribeeId);
                    pairArr[1] = TuplesKt.to("query", query);
                    pairArr[2] = TuplesKt.to("track_id", trackId == null ? "" : trackId);
                    pvEventTrigger.updateExtra(MapsKt.mapOf(pairArr));
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}