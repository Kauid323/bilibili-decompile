package im.setting.stateMachine;

import im.setting.stateMachine.IMSettingItemAction;
import im.setting.stateMachine.IMSettingItemStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingItemChangeStateMachine.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lim/setting/stateMachine/IMSettingItemStatus$Pending;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.setting.stateMachine.SettingItemChangeStateMachine$1$1$2$1", f = "SettingItemChangeStateMachine.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SettingItemChangeStateMachine$1$1$2$1 extends SuspendLambda implements Function2<IMSettingItemStatus.Pending, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SettingItemChangeStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingItemChangeStateMachine$1$1$2$1(SettingItemChangeStateMachine settingItemChangeStateMachine, Continuation<? super SettingItemChangeStateMachine$1$1$2$1> continuation) {
        super(2, continuation);
        this.this$0 = settingItemChangeStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingItemChangeStateMachine$1$1$2$1(this.this$0, continuation);
    }

    public final Object invoke(IMSettingItemStatus.Pending pending, Continuation<? super Unit> continuation) {
        return create(pending, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.this$0.dispatch(IMSettingItemAction.Confirm.INSTANCE, (Continuation) this) == coroutine_suspended) {
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