package kntr.app.tribee.search;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import kntr.app.tribee.search.state.TribeeSearchState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeSearchPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.search.TribeeSearchPageKt$TribeeSearchPage$3$1", f = "TribeeSearchPage.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeSearchPageKt$TribeeSearchPage$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FocusManager $focusManager;
    final /* synthetic */ MutableState<Boolean> $needFocus$delegate;
    final /* synthetic */ FocusRequester $searchBarFocusRequester;
    final /* synthetic */ State<TribeeSearchState> $state$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TribeeSearchPageKt$TribeeSearchPage$3$1(FocusRequester focusRequester, FocusManager focusManager, State<? extends TribeeSearchState> state, MutableState<Boolean> mutableState, Continuation<? super TribeeSearchPageKt$TribeeSearchPage$3$1> continuation) {
        super(2, continuation);
        this.$searchBarFocusRequester = focusRequester;
        this.$focusManager = focusManager;
        this.$state$delegate = state;
        this.$needFocus$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeSearchPageKt$TribeeSearchPage$3$1(this.$searchBarFocusRequester, this.$focusManager, this.$state$delegate, this.$needFocus$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        TribeeSearchState TribeeSearchPage$lambda$2;
        boolean TribeeSearchPage$lambda$5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                TribeeSearchPage$lambda$2 = TribeeSearchPageKt.TribeeSearchPage$lambda$2(this.$state$delegate);
                if (TribeeSearchPage$lambda$2 instanceof TribeeSearchState.Find) {
                    TribeeSearchPage$lambda$5 = TribeeSearchPageKt.TribeeSearchPage$lambda$5(this.$needFocus$delegate);
                    if (TribeeSearchPage$lambda$5) {
                        this.label = 1;
                        if (DelayKt.delay(200L, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Boxing.boxBoolean(FocusRequester.requestFocus-3ESFkO8$default(this.$searchBarFocusRequester, 0, 1, (Object) null));
                        break;
                    } else {
                        FocusManager.-CC.clearFocus$default(this.$focusManager, false, 1, (Object) null);
                        break;
                    }
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                Boxing.boxBoolean(FocusRequester.requestFocus-3ESFkO8$default(this.$searchBarFocusRequester, 0, 1, (Object) null));
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}