package kntr.app.tribee.invite.page;

import kntr.app.tribee.invite.viewmodel.TribeeInviteUIAction;
import kntr.app.tribee.invite.viewmodel.TribeeInviteViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

/* compiled from: TribeeInvitePage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.invite.page.TribeeInvitePageKt$TribeeInvitePage$2$1", f = "TribeeInvitePage.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class TribeeInvitePageKt$TribeeInvitePage$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<TribeeInviteUIAction, Unit> $onUIAction;
    final /* synthetic */ TribeeInviteViewModel $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TribeeInvitePageKt$TribeeInvitePage$2$1(TribeeInviteViewModel tribeeInviteViewModel, Function1<? super TribeeInviteUIAction, Unit> function1, Continuation<? super TribeeInvitePageKt$TribeeInvitePage$2$1> continuation) {
        super(2, continuation);
        this.$viewModel = tribeeInviteViewModel;
        this.$onUIAction = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeInvitePageKt$TribeeInvitePage$2$1(this.$viewModel, this.$onUIAction, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                SharedFlow<TribeeInviteUIAction> uiActionFlow = this.$viewModel.getUiActionFlow();
                final Function1<TribeeInviteUIAction, Unit> function1 = this.$onUIAction;
                this.label = 1;
                if (uiActionFlow.collect(new FlowCollector() { // from class: kntr.app.tribee.invite.page.TribeeInvitePageKt$TribeeInvitePage$2$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((TribeeInviteUIAction) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(TribeeInviteUIAction uiAction, Continuation<? super Unit> continuation) {
                        function1.invoke(uiAction);
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