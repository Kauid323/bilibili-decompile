package kntr.common.ouro.ui.textField;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.OuroStore;
import kntr.common.ouro.core.action.OuroUpdateCompositionRangeAction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: OuroTextField.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkntr/common/ouro/core/OuroState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.ui.textField.OuroTextField_androidKt$OuroTextField$9$1$2$handleFinishComposingText$1", f = "OuroTextField.android.kt", i = {}, l = {358}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class OuroTextField_androidKt$OuroTextField$9$1$2$handleFinishComposingText$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OuroState>, Object> {
    final /* synthetic */ OuroStore $store;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OuroTextField_androidKt$OuroTextField$9$1$2$handleFinishComposingText$1(OuroStore ouroStore, Continuation<? super OuroTextField_androidKt$OuroTextField$9$1$2$handleFinishComposingText$1> continuation) {
        super(2, continuation);
        this.$store = ouroStore;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OuroTextField_androidKt$OuroTextField$9$1$2$handleFinishComposingText$1(this.$store, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super OuroState> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object dispatchAndWait = this.$store.dispatchAndWait(new OuroUpdateCompositionRangeAction(null, null, 2, null), (Continuation) this);
                if (dispatchAndWait == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return dispatchAndWait;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}