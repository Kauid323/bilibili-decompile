package kntr.app.game.gamebind;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import java.util.List;
import kntr.app.game.gamebind.RolesListViewModel;
import kntr.app.game.gamebind.bean.RoleItem;
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
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/game/gamebind/RolesListViewModel$MenuState;", "event", "Lkntr/app/game/gamebind/RolesListViewModel$MenuEvent$LoadMenuList;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$1", f = "RolesListViewModel.kt", i = {0, 0, 0}, l = {50}, m = "invokeSuspend", n = {"event", "state", "role"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class RolesListViewModel$mMenuMachine$1$1$1 extends SuspendLambda implements Function3<RolesListViewModel.MenuEvent.LoadMenuList, State<RolesListViewModel.MenuState>, Continuation<? super ChangedState<? extends RolesListViewModel.MenuState>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ RolesListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RolesListViewModel$mMenuMachine$1$1$1(RolesListViewModel rolesListViewModel, Continuation<? super RolesListViewModel$mMenuMachine$1$1$1> continuation) {
        super(3, continuation);
        this.this$0 = rolesListViewModel;
    }

    public final Object invoke(RolesListViewModel.MenuEvent.LoadMenuList loadMenuList, State<RolesListViewModel.MenuState> state, Continuation<? super ChangedState<? extends RolesListViewModel.MenuState>> continuation) {
        RolesListViewModel$mMenuMachine$1$1$1 rolesListViewModel$mMenuMachine$1$1$1 = new RolesListViewModel$mMenuMachine$1$1$1(this.this$0, continuation);
        rolesListViewModel$mMenuMachine$1$1$1.L$0 = loadMenuList;
        rolesListViewModel$mMenuMachine$1$1$1.L$1 = state;
        return rolesListViewModel$mMenuMachine$1$1$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object loadMenuList;
        final RoleItem role;
        RolesListViewModel.MenuEvent.LoadMenuList event = (RolesListViewModel.MenuEvent.LoadMenuList) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                RoleItem role2 = event.getRole();
                try {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                    this.L$1 = state;
                    this.L$2 = role2;
                    this.label = 1;
                    loadMenuList = this.this$0.loadMenuList(role2.getId(), (Continuation) this);
                    if (loadMenuList == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    role = role2;
                    final List menuList = (List) loadMenuList;
                    return state.override(new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            RolesListViewModel.MenuState.ShowMenuDialog invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = RolesListViewModel$mMenuMachine$1$1$1.invokeSuspend$lambda$0(RoleItem.this, menuList, (RolesListViewModel.MenuState) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                } catch (Throwable th) {
                    return state.override(new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$1$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = RolesListViewModel$mMenuMachine$1$1$1.invokeSuspend$lambda$1((RolesListViewModel.MenuState) obj);
                            return invokeSuspend$lambda$1;
                        }
                    });
                }
            case 1:
                role = (RoleItem) this.L$2;
                try {
                    ResultKt.throwOnFailure($result);
                    loadMenuList = $result;
                    final List menuList2 = (List) loadMenuList;
                    return state.override(new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$1$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            RolesListViewModel.MenuState.ShowMenuDialog invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = RolesListViewModel$mMenuMachine$1$1$1.invokeSuspend$lambda$0(RoleItem.this, menuList2, (RolesListViewModel.MenuState) obj);
                            return invokeSuspend$lambda$0;
                        }
                    });
                } catch (Throwable th2) {
                    return state.override(new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$1$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$1;
                            invokeSuspend$lambda$1 = RolesListViewModel$mMenuMachine$1$1$1.invokeSuspend$lambda$1((RolesListViewModel.MenuState) obj);
                            return invokeSuspend$lambda$1;
                        }
                    });
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RolesListViewModel.MenuState.ShowMenuDialog invokeSuspend$lambda$0(RoleItem $role, List $menuList, RolesListViewModel.MenuState $this$override) {
        return new RolesListViewModel.MenuState.ShowMenuDialog($role, $menuList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$1(RolesListViewModel.MenuState $this$override) {
        return RolesListViewModel.MenuState.Initialize.INSTANCE;
    }
}