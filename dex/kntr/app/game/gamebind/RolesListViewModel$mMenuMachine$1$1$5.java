package kntr.app.game.gamebind;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.game.gamebind.GameBindEvent;
import kntr.app.game.gamebind.RolesListViewModel;
import kntr.app.game.gamebind.bean.RoleItem;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RolesListViewModel.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/game/gamebind/RolesListViewModel$MenuState;", "event", "Lkntr/app/game/gamebind/RolesListViewModel$MenuEvent$Unbind;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$5", f = "RolesListViewModel.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {163, 168}, m = "invokeSuspend", n = {"event", "state", "role", "event", "state", "role", "success"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "I$0"}, v = 1)
public final class RolesListViewModel$mMenuMachine$1$1$5 extends SuspendLambda implements Function3<RolesListViewModel.MenuEvent.Unbind, State<RolesListViewModel.MenuState>, Continuation<? super ChangedState<? extends RolesListViewModel.MenuState>>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ RolesListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RolesListViewModel$mMenuMachine$1$1$5(RolesListViewModel rolesListViewModel, Continuation<? super RolesListViewModel$mMenuMachine$1$1$5> continuation) {
        super(3, continuation);
        this.this$0 = rolesListViewModel;
    }

    public final Object invoke(RolesListViewModel.MenuEvent.Unbind unbind, State<RolesListViewModel.MenuState> state, Continuation<? super ChangedState<? extends RolesListViewModel.MenuState>> continuation) {
        RolesListViewModel$mMenuMachine$1$1$5 rolesListViewModel$mMenuMachine$1$1$5 = new RolesListViewModel$mMenuMachine$1$1$5(this.this$0, continuation);
        rolesListViewModel$mMenuMachine$1$1$5.L$0 = unbind;
        rolesListViewModel$mMenuMachine$1$1$5.L$1 = state;
        return rolesListViewModel$mMenuMachine$1$1$5.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    public final Object invokeSuspend(Object $result) {
        int i;
        Object obj;
        int i2;
        Object unbind;
        RolesListViewModel.MenuEvent.Unbind event = (RolesListViewModel.MenuEvent.Unbind) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
        } catch (Throwable th) {
            i = 0;
            obj = i3;
        }
        switch (i3) {
            case 0:
                ResultKt.throwOnFailure($result);
                RoleItem role = event.getRole();
                KLog_androidKt.getKLog().d("RolesListPage", "unbind: " + role.getId());
                this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                this.L$1 = state;
                this.L$2 = SpillingKt.nullOutSpilledVariable(role);
                this.label = 1;
                unbind = this.this$0.unbind(role.getId(), (Continuation) this);
                i3 = role;
                if (unbind == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                RoleItem roleItem = (RoleItem) this.L$2;
                ResultKt.throwOnFailure($result);
                unbind = $result;
                i3 = roleItem;
                break;
            case 2:
                i2 = this.I$0;
                RoleItem roleItem2 = (RoleItem) this.L$2;
                ResultKt.throwOnFailure($result);
                return state.override(new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$5$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = RolesListViewModel$mMenuMachine$1$1$5.invokeSuspend$lambda$0((RolesListViewModel.MenuState) obj2);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj = i3;
        i = ((Boolean) unbind).booleanValue();
        if (i != 0) {
            this.L$0 = SpillingKt.nullOutSpilledVariable(event);
            this.L$1 = state;
            this.L$2 = SpillingKt.nullOutSpilledVariable(obj);
            this.I$0 = i;
            this.label = 2;
            if (GameBindEventStore.INSTANCE.post(GameBindEvent.Unbind.INSTANCE, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            i2 = i;
        }
        return state.override(new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$5$$ExternalSyntheticLambda0
            public final Object invoke(Object obj2) {
                RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = RolesListViewModel$mMenuMachine$1$1$5.invokeSuspend$lambda$0((RolesListViewModel.MenuState) obj2);
                return invokeSuspend$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$0(RolesListViewModel.MenuState $this$override) {
        return RolesListViewModel.MenuState.Initialize.INSTANCE;
    }
}