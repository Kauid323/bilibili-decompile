package kntr.app.tribee.search;

import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kntr.app.tribee.search.event.TribeeSearchEvent;
import kntr.app.tribee.search.state.TribeeSearchState;
import kntr.app.tribee.search.viewModels.TribeeSearchViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeSearchPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.search.TribeeSearchPageKt$TribeeSearchPage$4$1", f = "TribeeSearchPage.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeSearchPageKt$TribeeSearchPage$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OnBackPressedDispatcher $backHandler;
    final /* synthetic */ MutableState<Boolean> $isFromFindPage$delegate;
    final /* synthetic */ State<TribeeSearchState> $state$delegate;
    final /* synthetic */ TribeeSearchViewModel $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TribeeSearchPageKt$TribeeSearchPage$4$1(OnBackPressedDispatcher onBackPressedDispatcher, TribeeSearchViewModel tribeeSearchViewModel, State<? extends TribeeSearchState> state, MutableState<Boolean> mutableState, Continuation<? super TribeeSearchPageKt$TribeeSearchPage$4$1> continuation) {
        super(2, continuation);
        this.$backHandler = onBackPressedDispatcher;
        this.$viewModel = tribeeSearchViewModel;
        this.$state$delegate = state;
        this.$isFromFindPage$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeSearchPageKt$TribeeSearchPage$4$1(this.$backHandler, this.$viewModel, this.$state$delegate, this.$isFromFindPage$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        TribeeSearchState TribeeSearchPage$lambda$2;
        TribeeSearchState TribeeSearchPage$lambda$22;
        boolean TribeeSearchPage$lambda$9;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                TribeeSearchPage$lambda$2 = TribeeSearchPageKt.TribeeSearchPage$lambda$2(this.$state$delegate);
                if (TribeeSearchPage$lambda$2.getSearchBarState().getTextFieldState().getText().length() == 0) {
                    TribeeSearchPage$lambda$22 = TribeeSearchPageKt.TribeeSearchPage$lambda$2(this.$state$delegate);
                    if (TribeeSearchPage$lambda$22 instanceof TribeeSearchState.Result) {
                        TribeeSearchPage$lambda$9 = TribeeSearchPageKt.TribeeSearchPage$lambda$9(this.$isFromFindPage$delegate);
                        if (TribeeSearchPage$lambda$9) {
                            this.$backHandler.onBackPressed();
                            break;
                        } else {
                            this.label = 1;
                            if (this.$viewModel.dispatch2((TribeeSearchEvent) TribeeSearchEvent.GotoFindPage.INSTANCE, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
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