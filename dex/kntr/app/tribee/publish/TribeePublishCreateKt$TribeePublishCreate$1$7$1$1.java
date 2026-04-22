package kntr.app.tribee.publish;

import androidx.compose.runtime.MutableState;
import kntr.app.tribee.publish.TribeePublishAction;
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
/* compiled from: TribeePublishCreate.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.TribeePublishCreateKt$TribeePublishCreate$1$7$1$1", f = "TribeePublishCreate.kt", i = {}, l = {94, 95}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeePublishCreateKt$TribeePublishCreate$1$7$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $showDraftDialog$delegate;
    final /* synthetic */ TribeePublishViewModel $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeePublishCreateKt$TribeePublishCreate$1$7$1$1(TribeePublishViewModel tribeePublishViewModel, MutableState<Boolean> mutableState, Continuation<? super TribeePublishCreateKt$TribeePublishCreate$1$7$1$1> continuation) {
        super(2, continuation);
        this.$viewModel = tribeePublishViewModel;
        this.$showDraftDialog$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeePublishCreateKt$TribeePublishCreate$1$7$1$1(this.$viewModel, this.$showDraftDialog$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0041 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.$viewModel.dispatch(TribeePublishAction.ClearDraft.INSTANCE, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.label = 2;
                if (this.$viewModel.dispatch(TribeePublishAction.Close.INSTANCE, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                TribeePublishCreateKt.TribeePublishCreate$lambda$1$3(this.$showDraftDialog$delegate, false);
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                this.label = 2;
                if (this.$viewModel.dispatch(TribeePublishAction.Close.INSTANCE, (Continuation) this) == coroutine_suspended) {
                }
                TribeePublishCreateKt.TribeePublishCreate$lambda$1$3(this.$showDraftDialog$delegate, false);
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                TribeePublishCreateKt.TribeePublishCreate$lambda$1$3(this.$showDraftDialog$delegate, false);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}