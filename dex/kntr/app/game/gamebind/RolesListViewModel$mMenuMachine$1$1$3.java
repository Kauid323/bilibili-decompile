package kntr.app.game.gamebind;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.game.gamebind.RolesListViewModel;
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
/* compiled from: RolesListViewModel.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/game/gamebind/RolesListViewModel$MenuState;", "<unused var>", "Lkntr/app/game/gamebind/RolesListViewModel$MenuEvent$HideMenuDialog;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$3", f = "RolesListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class RolesListViewModel$mMenuMachine$1$1$3 extends SuspendLambda implements Function3<RolesListViewModel.MenuEvent.HideMenuDialog, State<RolesListViewModel.MenuState>, Continuation<? super ChangedState<? extends RolesListViewModel.MenuState>>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RolesListViewModel$mMenuMachine$1$1$3(Continuation<? super RolesListViewModel$mMenuMachine$1$1$3> continuation) {
        super(3, continuation);
    }

    public final Object invoke(RolesListViewModel.MenuEvent.HideMenuDialog hideMenuDialog, State<RolesListViewModel.MenuState> state, Continuation<? super ChangedState<? extends RolesListViewModel.MenuState>> continuation) {
        RolesListViewModel$mMenuMachine$1$1$3 rolesListViewModel$mMenuMachine$1$1$3 = new RolesListViewModel$mMenuMachine$1$1$3(continuation);
        rolesListViewModel$mMenuMachine$1$1$3.L$0 = state;
        return rolesListViewModel$mMenuMachine$1$1$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.override(new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$3$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = RolesListViewModel$mMenuMachine$1$1$3.invokeSuspend$lambda$0((RolesListViewModel.MenuState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$0(RolesListViewModel.MenuState $this$override) {
        return RolesListViewModel.MenuState.Initialize.INSTANCE;
    }
}