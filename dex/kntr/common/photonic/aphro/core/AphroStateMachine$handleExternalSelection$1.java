package kntr.common.photonic.aphro.core;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.common.photonic.aphro.core.AphroAction;
import kntr.common.photonic.aphro.core.AphroState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: AphroStateMachine.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "useOrigin", "", "<unused var>", "Lkntr/common/photonic/aphro/core/AphroState$AphroContent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.core.AphroStateMachine$handleExternalSelection$1", f = "AphroStateMachine.kt", i = {0}, l = {185}, m = "invokeSuspend", n = {"useOrigin"}, s = {"Z$0"}, v = 1)
final class AphroStateMachine$handleExternalSelection$1 extends SuspendLambda implements Function3<Boolean, AphroState.AphroContent, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ AphroStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AphroStateMachine$handleExternalSelection$1(AphroStateMachine aphroStateMachine, Continuation<? super AphroStateMachine$handleExternalSelection$1> continuation) {
        super(3, continuation);
        this.this$0 = aphroStateMachine;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Boolean) obj).booleanValue(), (AphroState.AphroContent) obj2, (Continuation) obj3);
    }

    public final Object invoke(boolean z, AphroState.AphroContent aphroContent, Continuation<? super Unit> continuation) {
        AphroStateMachine$handleExternalSelection$1 aphroStateMachine$handleExternalSelection$1 = new AphroStateMachine$handleExternalSelection$1(this.this$0, continuation);
        aphroStateMachine$handleExternalSelection$1.Z$0 = z;
        return aphroStateMachine$handleExternalSelection$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        boolean useOrigin = this.Z$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KLog_androidKt.getKLog().i(AphroStateMachineKt.TAG, "useOrigin: " + useOrigin + " from external event");
                this.Z$0 = useOrigin;
                this.label = 1;
                if (this.this$0.dispatch(new AphroAction.CheckUseOriginImage(useOrigin), (Continuation) this) == coroutine_suspended) {
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