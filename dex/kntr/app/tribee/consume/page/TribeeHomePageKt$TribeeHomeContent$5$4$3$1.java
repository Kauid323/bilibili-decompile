package kntr.app.tribee.consume.page;

import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.bapis.bilibili.app.dynamic.v2.KTribeeCategory;
import kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeContentState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeHomePage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.page.TribeeHomePageKt$TribeeHomeContent$5$4$3$1", f = "TribeeHomePage.kt", i = {}, l = {571}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeHomePageKt$TribeeHomeContent$5$4$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function1<TribeeHomeStateAction, Unit>> $currentOnStateAction$delegate;
    final /* synthetic */ TribeeHomeContentState $pageState;
    final /* synthetic */ PagerState $pagerState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeHomePageKt$TribeeHomeContent$5$4$3$1(PagerState pagerState, TribeeHomeContentState tribeeHomeContentState, State<? extends Function1<? super TribeeHomeStateAction, Unit>> state, Continuation<? super TribeeHomePageKt$TribeeHomeContent$5$4$3$1> continuation) {
        super(2, continuation);
        this.$pagerState = pagerState;
        this.$pageState = tribeeHomeContentState;
        this.$currentOnStateAction$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeHomePageKt$TribeeHomeContent$5$4$3$1(this.$pagerState, this.$pageState, this.$currentOnStateAction$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final PagerState pagerState = this.$pagerState;
                Flow distinctUntilChanged = FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$TribeeHomeContent$5$4$3$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        int settledPage;
                        settledPage = pagerState.getSettledPage();
                        return Integer.valueOf(settledPage);
                    }
                }));
                final TribeeHomeContentState tribeeHomeContentState = this.$pageState;
                final State<Function1<TribeeHomeStateAction, Unit>> state = this.$currentOnStateAction$delegate;
                this.label = 1;
                if (distinctUntilChanged.collect(new FlowCollector() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$TribeeHomeContent$5$4$3$1.2
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit(((Number) value).intValue(), $completion);
                    }

                    public final Object emit(int page, Continuation<? super Unit> continuation) {
                        Function1 TribeeHomeContent$lambda$13;
                        KTribeeCategory it = (KTribeeCategory) CollectionsKt.getOrNull(CollectionsKt.toList(TribeeHomeContentState.this.getCategoryList().keySet()), page);
                        if (it != null) {
                            TribeeHomeContent$lambda$13 = TribeeHomePageKt.TribeeHomeContent$lambda$13(state);
                            TribeeHomeContent$lambda$13.invoke(new TribeeHomeStateAction.SwitchSubarea(it));
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}