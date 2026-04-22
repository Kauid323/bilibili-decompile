package kntr.app.tribee.search;

import com.bilibili.lib.brouter.uri.Uri;
import kntr.app.tribee.search.event.UIEvent;
import kntr.app.tribee.search.viewModels.TribeeSearchViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.Router;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeSearchPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.search.TribeeSearchPageKt$TribeeSearchPage$5$2$1", f = "TribeeSearchPage.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeSearchPageKt$TribeeSearchPage$5$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Router $router;
    final /* synthetic */ TribeeSearchViewModel $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeSearchPageKt$TribeeSearchPage$5$2$1(TribeeSearchViewModel tribeeSearchViewModel, Router router, Continuation<? super TribeeSearchPageKt$TribeeSearchPage$5$2$1> continuation) {
        super(2, continuation);
        this.$viewModel = tribeeSearchViewModel;
        this.$router = router;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeSearchPageKt$TribeeSearchPage$5$2$1(this.$viewModel, this.$router, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                SharedFlow<UIEvent> uiEventFlow = this.$viewModel.getUiEventFlow();
                final Router router = this.$router;
                this.label = 1;
                if (uiEventFlow.collect(new FlowCollector() { // from class: kntr.app.tribee.search.TribeeSearchPageKt$TribeeSearchPage$5$2$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((UIEvent) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(UIEvent event, Continuation<? super Unit> continuation) {
                        if (!(event instanceof UIEvent.Navigate)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        Router.this.launch(Uri.Companion.parse(((UIEvent.Navigate) event).getUri()));
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
        throw new KotlinNothingValueException();
    }
}