package kntr.app.tribee.search.page;

import androidx.compose.runtime.State;
import kntr.app.tribee.search.event.TribeeSearchEvent;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeSearchResultPageContent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.search.page.TribeeSearchResultPageContentKt$TribeeSearchResultPageContent$3$1", f = "TribeeSearchResultPageContent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeSearchResultPageContentKt$TribeeSearchResultPageContent$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function1<TribeeSearchEvent, Unit>> $currentOnEvent$delegate;
    final /* synthetic */ State<Boolean> $shouldLoadMore$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeSearchResultPageContentKt$TribeeSearchResultPageContent$3$1(State<Boolean> state, State<? extends Function1<? super TribeeSearchEvent, Unit>> state2, Continuation<? super TribeeSearchResultPageContentKt$TribeeSearchResultPageContent$3$1> continuation) {
        super(2, continuation);
        this.$shouldLoadMore$delegate = state;
        this.$currentOnEvent$delegate = state2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeSearchResultPageContentKt$TribeeSearchResultPageContent$3$1(this.$shouldLoadMore$delegate, this.$currentOnEvent$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        boolean TribeeSearchResultPageContent$lambda$2;
        Function1 TribeeSearchResultPageContent$lambda$3;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                TribeeSearchResultPageContent$lambda$2 = TribeeSearchResultPageContentKt.TribeeSearchResultPageContent$lambda$2(this.$shouldLoadMore$delegate);
                if (TribeeSearchResultPageContent$lambda$2) {
                    TribeeSearchResultPageContent$lambda$3 = TribeeSearchResultPageContentKt.TribeeSearchResultPageContent$lambda$3(this.$currentOnEvent$delegate);
                    TribeeSearchResultPageContent$lambda$3.invoke(TribeeSearchEvent.LoadMore.INSTANCE);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}