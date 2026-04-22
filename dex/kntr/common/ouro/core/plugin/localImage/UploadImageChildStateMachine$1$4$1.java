package kntr.common.ouro.core.plugin.localImage;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.renderable.UploadTaskState;
import kntr.common.ouro.core.plugin.localImage.UploadImageChildAction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UploadImageChildStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState;", "action", "Lkntr/common/ouro/core/plugin/localImage/UploadImageChildAction$Retry;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Failure;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.core.plugin.localImage.UploadImageChildStateMachine$1$4$1", f = "UploadImageChildStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class UploadImageChildStateMachine$1$4$1 extends SuspendLambda implements Function3<UploadImageChildAction.Retry, State<UploadTaskState.Failure>, Continuation<? super ChangedState<? extends UploadTaskState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UploadImageChildStateMachine$1$4$1(Continuation<? super UploadImageChildStateMachine$1$4$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(UploadImageChildAction.Retry retry, State<UploadTaskState.Failure> state, Continuation<? super ChangedState<? extends UploadTaskState>> continuation) {
        UploadImageChildStateMachine$1$4$1 uploadImageChildStateMachine$1$4$1 = new UploadImageChildStateMachine$1$4$1(continuation);
        uploadImageChildStateMachine$1$4$1.L$0 = retry;
        uploadImageChildStateMachine$1$4$1.L$1 = state;
        return uploadImageChildStateMachine$1$4$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        UploadImageChildAction.Retry action = (UploadImageChildAction.Retry) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (Intrinsics.areEqual(action.getIdentifier(), ((UploadTaskState.Failure) state.getSnapshot()).getIdentifier())) {
                    return state.override(new Function1() { // from class: kntr.common.ouro.core.plugin.localImage.UploadImageChildStateMachine$1$4$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            UploadTaskState.Idle invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = UploadImageChildStateMachine$1$4$1.invokeSuspend$lambda$0((UploadTaskState.Failure) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                }
                return state.noChange();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UploadTaskState.Idle invokeSuspend$lambda$0(UploadTaskState.Failure $this$override) {
        return new UploadTaskState.Idle($this$override.getIdentifier());
    }
}