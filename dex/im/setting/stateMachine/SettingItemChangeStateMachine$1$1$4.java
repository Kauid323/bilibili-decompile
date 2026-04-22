package im.setting.stateMachine;

import com.bapis.bilibili.app.im.v1.KIMSettingType;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.setting.model.SettingItem;
import im.setting.stateMachine.IMSettingItemAction;
import im.setting.stateMachine.IMSettingItemStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingItemChangeStateMachine.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lim/setting/stateMachine/IMSettingItemStatus;", "<unused var>", "Lim/setting/stateMachine/IMSettingItemAction$Cancel;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lim/setting/stateMachine/IMSettingItemStatus$Pending;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.setting.stateMachine.SettingItemChangeStateMachine$1$1$4", f = "SettingItemChangeStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SettingItemChangeStateMachine$1$1$4 extends SuspendLambda implements Function3<IMSettingItemAction.Cancel, State<IMSettingItemStatus.Pending>, Continuation<? super ChangedState<? extends IMSettingItemStatus>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SettingItemChangeStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingItemChangeStateMachine$1$1$4(SettingItemChangeStateMachine settingItemChangeStateMachine, Continuation<? super SettingItemChangeStateMachine$1$1$4> continuation) {
        super(3, continuation);
        this.this$0 = settingItemChangeStateMachine;
    }

    public final Object invoke(IMSettingItemAction.Cancel cancel, State<IMSettingItemStatus.Pending> state, Continuation<? super ChangedState<? extends IMSettingItemStatus>> continuation) {
        SettingItemChangeStateMachine$1$1$4 settingItemChangeStateMachine$1$1$4 = new SettingItemChangeStateMachine$1$1$4(this.this$0, continuation);
        settingItemChangeStateMachine$1$1$4.L$0 = state;
        return settingItemChangeStateMachine$1$1$4.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final SettingItemChangeStateMachine settingItemChangeStateMachine = this.this$0;
                return state.override(new Function1() { // from class: im.setting.stateMachine.SettingItemChangeStateMachine$1$1$4$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        IMSettingItemStatus.Done invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = SettingItemChangeStateMachine$1$1$4.invokeSuspend$lambda$0(SettingItemChangeStateMachine.this, (IMSettingItemStatus.Pending) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IMSettingItemStatus.Done invokeSuspend$lambda$0(SettingItemChangeStateMachine this$0, IMSettingItemStatus.Pending $this$override) {
        SettingItem.Setting setting;
        SettingItem.Setting setting2;
        setting = this$0.item;
        KIMSettingType type = setting.getType();
        setting2 = this$0.item;
        return new IMSettingItemStatus.Done(type, false, SettingItem.Setting.copy$default(setting2, null, null, false, false, 7, null), null);
    }
}