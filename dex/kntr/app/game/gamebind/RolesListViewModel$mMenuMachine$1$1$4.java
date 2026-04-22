package kntr.app.game.gamebind;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.game.gamebind.GameBindEvent;
import kntr.app.game.gamebind.RolesListViewModel;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RolesListViewModel.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/game/gamebind/RolesListViewModel$MenuState;", "event", "Lkntr/app/game/gamebind/RolesListViewModel$MenuEvent$ServerSwitch;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$4", f = "RolesListViewModel.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3}, l = {146, 151, 152, 154}, m = "invokeSuspend", n = {"event", "state", "event", "state", "success", "event", "state", "success", "event", "state", "success"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0"}, v = 1)
public final class RolesListViewModel$mMenuMachine$1$1$4 extends SuspendLambda implements Function3<RolesListViewModel.MenuEvent.ServerSwitch, State<RolesListViewModel.MenuState>, Continuation<? super ChangedState<? extends RolesListViewModel.MenuState>>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ RolesListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RolesListViewModel$mMenuMachine$1$1$4(RolesListViewModel rolesListViewModel, Continuation<? super RolesListViewModel$mMenuMachine$1$1$4> continuation) {
        super(3, continuation);
        this.this$0 = rolesListViewModel;
    }

    public final Object invoke(RolesListViewModel.MenuEvent.ServerSwitch serverSwitch, State<RolesListViewModel.MenuState> state, Continuation<? super ChangedState<? extends RolesListViewModel.MenuState>> continuation) {
        RolesListViewModel$mMenuMachine$1$1$4 rolesListViewModel$mMenuMachine$1$1$4 = new RolesListViewModel$mMenuMachine$1$1$4(this.this$0, continuation);
        rolesListViewModel$mMenuMachine$1$1$4.L$0 = serverSwitch;
        rolesListViewModel$mMenuMachine$1$1$4.L$1 = state;
        return rolesListViewModel$mMenuMachine$1$1$4.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        int i;
        MutableSharedFlow mutableSharedFlow;
        MutableSharedFlow mutableSharedFlow2;
        int i2;
        Object switchRole;
        RolesListViewModel.MenuEvent.ServerSwitch event = (RolesListViewModel.MenuEvent.ServerSwitch) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Throwable th) {
            i = 0;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                KLog_androidKt.getKLog().d("RolesListPage", "onServerSwitch: " + event.getSection().getSectionId());
                this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                this.L$1 = state;
                this.label = 1;
                switchRole = this.this$0.switchRole(event.getRole().getId(), event.getSection().getSectionId(), (Continuation) this);
                if (switchRole == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i = ((Boolean) switchRole).booleanValue();
                if (i != 0) {
                    mutableSharedFlow = this.this$0.toast;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                    this.L$1 = state;
                    this.I$0 = i;
                    this.label = 4;
                    if (mutableSharedFlow.emit("角色信息切换失败", (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                mutableSharedFlow2 = this.this$0.toast;
                this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                this.L$1 = state;
                this.I$0 = i;
                this.label = 2;
                i2 = i;
                if (mutableSharedFlow2.emit("角色信息已切换", (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                this.L$1 = state;
                this.I$0 = i2;
                this.label = 3;
                return GameBindEventStore.INSTANCE.post(GameBindEvent.Changed.INSTANCE, (Continuation) this) != coroutine_suspended ? coroutine_suspended : state.override(new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$4$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = RolesListViewModel$mMenuMachine$1$1$4.invokeSuspend$lambda$0((RolesListViewModel.MenuState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            case 1:
                ResultKt.throwOnFailure($result);
                switchRole = $result;
                i = ((Boolean) switchRole).booleanValue();
                if (i != 0) {
                }
                break;
            case 2:
                int i3 = this.I$0;
                ResultKt.throwOnFailure($result);
                i2 = i3;
                this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                this.L$1 = state;
                this.I$0 = i2;
                this.label = 3;
                if (GameBindEventStore.INSTANCE.post(GameBindEvent.Changed.INSTANCE, (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 3:
                int i4 = this.I$0;
                ResultKt.throwOnFailure($result);
            case 4:
                int i5 = this.I$0;
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$0(RolesListViewModel.MenuState $this$override) {
        return RolesListViewModel.MenuState.Initialize.INSTANCE;
    }
}