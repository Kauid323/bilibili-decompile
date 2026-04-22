package im.setting.stateMachine;

import com.tencent.tauth.AuthActivity;
import im.setting.IMSettingCloseSelectWindowAction;
import im.setting.IMSettingSelectAction;
import im.setting.IMSettingState;
import im.setting.model.extension.SettingItemExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingStateMachine.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", AuthActivity.ACTION_KEY, "Lim/setting/IMSettingSelectAction;", "<unused var>", "Lim/setting/IMSettingState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.setting.stateMachine.SettingStateMachine$1$1$7$1", f = "SettingStateMachine.kt", i = {0}, l = {100}, m = "invokeSuspend", n = {AuthActivity.ACTION_KEY}, s = {"L$0"}, v = 1)
public final class SettingStateMachine$1$1$7$1 extends SuspendLambda implements Function3<IMSettingSelectAction, IMSettingState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SettingStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingStateMachine$1$1$7$1(SettingStateMachine settingStateMachine, Continuation<? super SettingStateMachine$1$1$7$1> continuation) {
        super(3, continuation);
        this.this$0 = settingStateMachine;
    }

    public final Object invoke(IMSettingSelectAction iMSettingSelectAction, IMSettingState iMSettingState, Continuation<? super Unit> continuation) {
        SettingStateMachine$1$1$7$1 settingStateMachine$1$1$7$1 = new SettingStateMachine$1$1$7$1(this.this$0, continuation);
        settingStateMachine$1$1$7$1.L$0 = iMSettingSelectAction;
        return settingStateMachine$1$1$7$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IMSettingSelectAction action = (IMSettingSelectAction) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (SettingItemExtKt.needCloseWindowWhenSelect(action.getItem())) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                    this.label = 1;
                    if (this.this$0.dispatch(IMSettingCloseSelectWindowAction.INSTANCE, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
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