package kntr.app.game.gamebind;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.game.gamebind.GameBindEvent;
import kntr.app.game.gamebind.RolesListViewModel;
import kntr.app.game.gamebind.bean.RoleItem;
import kntr.app.game.gamebind.bean.RoleMenuItem;
import kntr.app.game.gamebind.bean.RoleMenuItemKt;
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
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/game/gamebind/RolesListViewModel$MenuState;", "event", "Lkntr/app/game/gamebind/RolesListViewModel$MenuEvent$MenuClick;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$2", f = "RolesListViewModel.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER, AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER, AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER, AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER, AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER, AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER, AdditionVote2.ADDITION_VOTE_DEFAULE_FIELD_NUMBER, AdditionVote2.ADDITION_VOTE_DEFAULE_FIELD_NUMBER, AdditionVote2.ADDITION_VOTE_DEFAULE_FIELD_NUMBER, AdditionVote2.ADDITION_VOTE_DEFAULE_FIELD_NUMBER, AdditionVote2.ADDITION_VOTE_DEFAULE_FIELD_NUMBER, AdditionVote2.BIZ_TYPE_FIELD_NUMBER, AdditionVote2.BIZ_TYPE_FIELD_NUMBER, AdditionVote2.BIZ_TYPE_FIELD_NUMBER, AdditionVote2.BIZ_TYPE_FIELD_NUMBER, AdditionVote2.BIZ_TYPE_FIELD_NUMBER, AdditionVote2.BIZ_TYPE_FIELD_NUMBER, AdditionVote2.TOTAL_FIELD_NUMBER, AdditionVote2.TOTAL_FIELD_NUMBER, AdditionVote2.TOTAL_FIELD_NUMBER, AdditionVote2.TOTAL_FIELD_NUMBER, AdditionVote2.TOTAL_FIELD_NUMBER, AdditionVote2.TOTAL_FIELD_NUMBER, AdditionVote2.CARD_TYPE_FIELD_NUMBER, AdditionVote2.CARD_TYPE_FIELD_NUMBER, AdditionVote2.CARD_TYPE_FIELD_NUMBER, AdditionVote2.CARD_TYPE_FIELD_NUMBER, AdditionVote2.CARD_TYPE_FIELD_NUMBER, AdditionVote2.CARD_TYPE_FIELD_NUMBER}, l = {64, 69, 70, 72, 80, 85, 86, 88, 96, 101, 102, 104, 112, 117, 118, 120}, m = "invokeSuspend", n = {"event", "state", "role", "roleId", "menuItem", "event", "state", "role", "roleId", "menuItem", "success", "event", "state", "role", "roleId", "menuItem", "success", "event", "state", "role", "roleId", "menuItem", "success", "event", "state", "role", "roleId", "menuItem", "event", "state", "role", "roleId", "menuItem", "success", "event", "state", "role", "roleId", "menuItem", "success", "event", "state", "role", "roleId", "menuItem", "success", "event", "state", "role", "roleId", "menuItem", "event", "state", "role", "roleId", "menuItem", "success", "event", "state", "role", "roleId", "menuItem", "success", "event", "state", "role", "roleId", "menuItem", "success", "event", "state", "role", "roleId", "menuItem", "event", "state", "role", "roleId", "menuItem", "success", "event", "state", "role", "roleId", "menuItem", "success", "event", "state", "role", "roleId", "menuItem", "success"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
public final class RolesListViewModel$mMenuMachine$1$1$2 extends SuspendLambda implements Function3<RolesListViewModel.MenuEvent.MenuClick, State<RolesListViewModel.MenuState>, Continuation<? super ChangedState<? extends RolesListViewModel.MenuState>>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ RolesListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RolesListViewModel$mMenuMachine$1$1$2(RolesListViewModel rolesListViewModel, Continuation<? super RolesListViewModel$mMenuMachine$1$1$2> continuation) {
        super(3, continuation);
        this.this$0 = rolesListViewModel;
    }

    public final Object invoke(RolesListViewModel.MenuEvent.MenuClick menuClick, State<RolesListViewModel.MenuState> state, Continuation<? super ChangedState<? extends RolesListViewModel.MenuState>> continuation) {
        RolesListViewModel$mMenuMachine$1$1$2 rolesListViewModel$mMenuMachine$1$1$2 = new RolesListViewModel$mMenuMachine$1$1$2(this.this$0, continuation);
        rolesListViewModel$mMenuMachine$1$1$2.L$0 = menuClick;
        rolesListViewModel$mMenuMachine$1$1$2.L$1 = state;
        return rolesListViewModel$mMenuMachine$1$1$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0408 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x04f5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x04fd  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0228 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0319 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0321  */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v46 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v54 */
    /* JADX WARN: Type inference failed for: r3v55 */
    /* JADX WARN: Type inference failed for: r3v56 */
    /* JADX WARN: Type inference failed for: r3v57 */
    /* JADX WARN: Type inference failed for: r3v58 */
    /* JADX WARN: Type inference failed for: r3v59 */
    /* JADX WARN: Type inference failed for: r3v60 */
    /* JADX WARN: Type inference failed for: r3v61 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v13, types: [int] */
    /* JADX WARN: Type inference failed for: r4v21, types: [int] */
    /* JADX WARN: Type inference failed for: r4v29, types: [int] */
    /* JADX WARN: Type inference failed for: r4v37, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v44, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v5, types: [int] */
    /* JADX WARN: Type inference failed for: r4v51, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v58, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v65 */
    /* JADX WARN: Type inference failed for: r4v66 */
    /* JADX WARN: Type inference failed for: r4v67 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        MutableSharedFlow mutableSharedFlow;
        String roleId;
        RoleItem role;
        MutableSharedFlow mutableSharedFlow2;
        RoleMenuItem menuItem;
        int i;
        final RoleItem role2;
        String roleId2;
        String roleId3;
        RoleItem role3;
        MutableSharedFlow mutableSharedFlow3;
        String roleId4;
        RoleItem role4;
        MutableSharedFlow mutableSharedFlow4;
        RoleMenuItem menuItem2;
        int i2;
        String roleId5;
        RoleItem role5;
        MutableSharedFlow mutableSharedFlow5;
        String roleId6;
        RoleItem role6;
        MutableSharedFlow mutableSharedFlow6;
        RoleMenuItem menuItem3;
        int i3;
        String roleId7;
        RoleItem role7;
        MutableSharedFlow mutableSharedFlow7;
        String roleId8;
        RoleItem role8;
        MutableSharedFlow mutableSharedFlow8;
        RoleMenuItem menuItem4;
        int i4;
        String roleId9;
        RoleItem role9;
        Object pinOrUnpin;
        Object pinOrUnpin2;
        Object changeVisible;
        Object changeVisible2;
        RolesListViewModel.MenuEvent.MenuClick event = (RolesListViewModel.MenuEvent.MenuClick) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r3 = this.label;
        ?? r4 = 0;
        ?? r42 = 0;
        ?? r43 = 0;
        ?? r44 = 0;
        switch (r3) {
            case 0:
                ResultKt.throwOnFailure($result);
                role2 = event.getRole();
                roleId2 = role2.getId();
                final RoleMenuItem menuItem5 = event.getMenuItem();
                String menuId = menuItem5.getMenuId();
                switch (menuId.hashCode()) {
                    case -840745386:
                        if (menuId.equals(RoleMenuItemKt.MENU_UNBIND)) {
                            return state.override(new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$2$$ExternalSyntheticLambda5
                                public final Object invoke(Object obj) {
                                    RolesListViewModel.MenuState.UnbindDialog invokeSuspend$lambda$5;
                                    invokeSuspend$lambda$5 = RolesListViewModel$mMenuMachine$1$1$2.invokeSuspend$lambda$5(RoleItem.this, (RolesListViewModel.MenuState) obj);
                                    return invokeSuspend$lambda$5;
                                }
                            });
                        }
                        break;
                    case 110997:
                        if (menuId.equals(RoleMenuItemKt.MENU_PIN)) {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                            this.L$1 = state;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(role2);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(roleId2);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(menuItem5);
                            this.label = 1;
                            pinOrUnpin = this.this$0.pinOrUnpin(roleId2, true, (Continuation) this);
                            r3 = menuItem5;
                            if (pinOrUnpin == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            r42 = ((Boolean) pinOrUnpin).booleanValue();
                            if (r42 != 0) {
                                mutableSharedFlow = this.this$0.toast;
                                this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                                this.L$1 = state;
                                this.L$2 = SpillingKt.nullOutSpilledVariable(role2);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(roleId2);
                                this.L$4 = SpillingKt.nullOutSpilledVariable((Object) r3);
                                this.I$0 = r42;
                                this.label = 4;
                                if (mutableSharedFlow.emit("置顶失败", (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                roleId = roleId2;
                                role = role2;
                                return state.override(new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$2$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj) {
                                        RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$0;
                                        invokeSuspend$lambda$0 = RolesListViewModel$mMenuMachine$1$1$2.invokeSuspend$lambda$0((RolesListViewModel.MenuState) obj);
                                        return invokeSuspend$lambda$0;
                                    }
                                });
                            }
                            mutableSharedFlow2 = this.this$0.toast;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                            this.L$1 = state;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(role2);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(roleId2);
                            this.L$4 = SpillingKt.nullOutSpilledVariable((Object) r3);
                            this.I$0 = r42;
                            this.label = 2;
                            if (mutableSharedFlow2.emit("已置顶", (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            int i5 = r42;
                            menuItem = r3;
                            i = i5;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                            this.L$1 = state;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(role2);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(roleId2);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(menuItem);
                            this.I$0 = i;
                            this.label = 3;
                            if (GameBindEventStore.INSTANCE.post(GameBindEvent.Changed.INSTANCE, (Continuation) this) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            roleId3 = roleId2;
                            role3 = role2;
                            return state.override(new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$2$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$0;
                                    invokeSuspend$lambda$0 = RolesListViewModel$mMenuMachine$1$1$2.invokeSuspend$lambda$0((RolesListViewModel.MenuState) obj);
                                    return invokeSuspend$lambda$0;
                                }
                            });
                        }
                        break;
                    case 111439964:
                        if (menuId.equals(RoleMenuItemKt.MENU_UNPIN)) {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                            this.L$1 = state;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(role2);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(roleId2);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(menuItem5);
                            this.label = 5;
                            pinOrUnpin2 = this.this$0.pinOrUnpin(roleId2, false, (Continuation) this);
                            r3 = menuItem5;
                            if (pinOrUnpin2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            r4 = ((Boolean) pinOrUnpin2).booleanValue();
                            if (r4 != 0) {
                                mutableSharedFlow3 = this.this$0.toast;
                                this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                                this.L$1 = state;
                                this.L$2 = SpillingKt.nullOutSpilledVariable(role2);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(roleId2);
                                this.L$4 = SpillingKt.nullOutSpilledVariable((Object) r3);
                                this.I$0 = r4;
                                this.label = 8;
                                if (mutableSharedFlow3.emit("取消置顶失败", (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                roleId4 = roleId2;
                                role4 = role2;
                                return state.override(new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$2$$ExternalSyntheticLambda1
                                    public final Object invoke(Object obj) {
                                        RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$1;
                                        invokeSuspend$lambda$1 = RolesListViewModel$mMenuMachine$1$1$2.invokeSuspend$lambda$1((RolesListViewModel.MenuState) obj);
                                        return invokeSuspend$lambda$1;
                                    }
                                });
                            }
                            mutableSharedFlow4 = this.this$0.toast;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                            this.L$1 = state;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(role2);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(roleId2);
                            this.L$4 = SpillingKt.nullOutSpilledVariable((Object) r3);
                            this.I$0 = r4;
                            this.label = 6;
                            if (mutableSharedFlow4.emit("已取消置顶", (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            int i6 = r4;
                            menuItem2 = r3;
                            i2 = i6;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                            this.L$1 = state;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(role2);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(roleId2);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(menuItem2);
                            this.I$0 = i2;
                            this.label = 7;
                            if (GameBindEventStore.INSTANCE.post(GameBindEvent.Changed.INSTANCE, (Continuation) this) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            roleId5 = roleId2;
                            role5 = role2;
                            return state.override(new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$2$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj) {
                                    RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$1;
                                    invokeSuspend$lambda$1 = RolesListViewModel$mMenuMachine$1$1$2.invokeSuspend$lambda$1((RolesListViewModel.MenuState) obj);
                                    return invokeSuspend$lambda$1;
                                }
                            });
                        }
                        break;
                    case 577965313:
                        if (menuId.equals(RoleMenuItemKt.MENU_SELF_VISIBLE)) {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                            this.L$1 = state;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(role2);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(roleId2);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(menuItem5);
                            this.label = 9;
                            changeVisible = this.this$0.changeVisible(roleId2, false, (Continuation) this);
                            r3 = menuItem5;
                            if (changeVisible == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            r44 = ((Boolean) changeVisible).booleanValue();
                            if (r44 != 0) {
                                mutableSharedFlow5 = this.this$0.toast;
                                this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                                this.L$1 = state;
                                this.L$2 = SpillingKt.nullOutSpilledVariable(role2);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(roleId2);
                                this.L$4 = SpillingKt.nullOutSpilledVariable((Object) r3);
                                this.I$0 = r44;
                                this.label = 12;
                                if (mutableSharedFlow5.emit("自见失败", (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                roleId6 = roleId2;
                                role6 = role2;
                                return state.override(new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$2$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj) {
                                        RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$2;
                                        invokeSuspend$lambda$2 = RolesListViewModel$mMenuMachine$1$1$2.invokeSuspend$lambda$2((RolesListViewModel.MenuState) obj);
                                        return invokeSuspend$lambda$2;
                                    }
                                });
                            }
                            mutableSharedFlow6 = this.this$0.toast;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                            this.L$1 = state;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(role2);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(roleId2);
                            this.L$4 = SpillingKt.nullOutSpilledVariable((Object) r3);
                            this.I$0 = r44;
                            this.label = 10;
                            if (mutableSharedFlow6.emit("已设置自见", (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            int i7 = r44;
                            menuItem3 = r3;
                            i3 = i7;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                            this.L$1 = state;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(role2);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(roleId2);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(menuItem3);
                            this.I$0 = i3;
                            this.label = 11;
                            if (GameBindEventStore.INSTANCE.post(GameBindEvent.Changed.INSTANCE, (Continuation) this) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            roleId7 = roleId2;
                            role7 = role2;
                            return state.override(new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$2$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj) {
                                    RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$2;
                                    invokeSuspend$lambda$2 = RolesListViewModel$mMenuMachine$1$1$2.invokeSuspend$lambda$2((RolesListViewModel.MenuState) obj);
                                    return invokeSuspend$lambda$2;
                                }
                            });
                        }
                        break;
                    case 1970336281:
                        if (menuId.equals(RoleMenuItemKt.MENU_PUBLIC_VISIBLE)) {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                            this.L$1 = state;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(role2);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(roleId2);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(menuItem5);
                            this.label = 13;
                            changeVisible2 = this.this$0.changeVisible(roleId2, true, (Continuation) this);
                            r3 = menuItem5;
                            if (changeVisible2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            r43 = ((Boolean) changeVisible2).booleanValue();
                            if (r43 != 0) {
                                mutableSharedFlow7 = this.this$0.toast;
                                this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                                this.L$1 = state;
                                this.L$2 = SpillingKt.nullOutSpilledVariable(role2);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(roleId2);
                                this.L$4 = SpillingKt.nullOutSpilledVariable((Object) r3);
                                this.I$0 = r43;
                                this.label = 16;
                                if (mutableSharedFlow7.emit("公开展示失败", (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                roleId8 = roleId2;
                                role8 = role2;
                                return state.override(new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$2$$ExternalSyntheticLambda3
                                    public final Object invoke(Object obj) {
                                        RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$3;
                                        invokeSuspend$lambda$3 = RolesListViewModel$mMenuMachine$1$1$2.invokeSuspend$lambda$3((RolesListViewModel.MenuState) obj);
                                        return invokeSuspend$lambda$3;
                                    }
                                });
                            }
                            mutableSharedFlow8 = this.this$0.toast;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                            this.L$1 = state;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(role2);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(roleId2);
                            this.L$4 = SpillingKt.nullOutSpilledVariable((Object) r3);
                            this.I$0 = r43;
                            this.label = 14;
                            if (mutableSharedFlow8.emit("已公开展示", (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            int i8 = r43;
                            menuItem4 = r3;
                            i4 = i8;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                            this.L$1 = state;
                            this.L$2 = SpillingKt.nullOutSpilledVariable(role2);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(roleId2);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(menuItem4);
                            this.I$0 = i4;
                            this.label = 15;
                            if (GameBindEventStore.INSTANCE.post(GameBindEvent.Changed.INSTANCE, (Continuation) this) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            roleId9 = roleId2;
                            role9 = role2;
                            return state.override(new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$2$$ExternalSyntheticLambda3
                                public final Object invoke(Object obj) {
                                    RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$3;
                                    invokeSuspend$lambda$3 = RolesListViewModel$mMenuMachine$1$1$2.invokeSuspend$lambda$3((RolesListViewModel.MenuState) obj);
                                    return invokeSuspend$lambda$3;
                                }
                            });
                        }
                        break;
                    case 2129322657:
                        if (menuId.equals(RoleMenuItemKt.MENU_SWITCH_SERVER)) {
                            return state.override(new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$2$$ExternalSyntheticLambda4
                                public final Object invoke(Object obj) {
                                    RolesListViewModel.MenuState.ShowRoleSwitchDialog invokeSuspend$lambda$4;
                                    invokeSuspend$lambda$4 = RolesListViewModel$mMenuMachine$1$1$2.invokeSuspend$lambda$4(RoleItem.this, menuItem5, (RolesListViewModel.MenuState) obj);
                                    return invokeSuspend$lambda$4;
                                }
                            });
                        }
                        break;
                }
                return state.override(new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$2$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj) {
                        RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$6;
                        invokeSuspend$lambda$6 = RolesListViewModel$mMenuMachine$1$1$2.invokeSuspend$lambda$6((RolesListViewModel.MenuState) obj);
                        return invokeSuspend$lambda$6;
                    }
                });
            case 1:
                RoleMenuItem roleMenuItem = (RoleMenuItem) this.L$4;
                roleId2 = (String) this.L$3;
                role2 = (RoleItem) this.L$2;
                ResultKt.throwOnFailure($result);
                pinOrUnpin = $result;
                r3 = roleMenuItem;
                r42 = ((Boolean) pinOrUnpin).booleanValue();
                if (r42 != 0) {
                }
                break;
            case 2:
                i = this.I$0;
                menuItem = (RoleMenuItem) this.L$4;
                roleId2 = (String) this.L$3;
                role2 = (RoleItem) this.L$2;
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                this.L$1 = state;
                this.L$2 = SpillingKt.nullOutSpilledVariable(role2);
                this.L$3 = SpillingKt.nullOutSpilledVariable(roleId2);
                this.L$4 = SpillingKt.nullOutSpilledVariable(menuItem);
                this.I$0 = i;
                this.label = 3;
                if (GameBindEventStore.INSTANCE.post(GameBindEvent.Changed.INSTANCE, (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 3:
                int i9 = this.I$0;
                RoleMenuItem roleMenuItem2 = (RoleMenuItem) this.L$4;
                roleId3 = (String) this.L$3;
                role3 = (RoleItem) this.L$2;
                ResultKt.throwOnFailure($result);
                return state.override(new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = RolesListViewModel$mMenuMachine$1$1$2.invokeSuspend$lambda$0((RolesListViewModel.MenuState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            case 4:
                int i10 = this.I$0;
                RoleMenuItem roleMenuItem3 = (RoleMenuItem) this.L$4;
                roleId = (String) this.L$3;
                role = (RoleItem) this.L$2;
                ResultKt.throwOnFailure($result);
                return state.override(new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = RolesListViewModel$mMenuMachine$1$1$2.invokeSuspend$lambda$0((RolesListViewModel.MenuState) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            case 5:
                RoleMenuItem roleMenuItem4 = (RoleMenuItem) this.L$4;
                roleId2 = (String) this.L$3;
                role2 = (RoleItem) this.L$2;
                ResultKt.throwOnFailure($result);
                pinOrUnpin2 = $result;
                r3 = roleMenuItem4;
                r4 = ((Boolean) pinOrUnpin2).booleanValue();
                if (r4 != 0) {
                }
                break;
            case 6:
                i2 = this.I$0;
                menuItem2 = (RoleMenuItem) this.L$4;
                roleId2 = (String) this.L$3;
                role2 = (RoleItem) this.L$2;
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                this.L$1 = state;
                this.L$2 = SpillingKt.nullOutSpilledVariable(role2);
                this.L$3 = SpillingKt.nullOutSpilledVariable(roleId2);
                this.L$4 = SpillingKt.nullOutSpilledVariable(menuItem2);
                this.I$0 = i2;
                this.label = 7;
                if (GameBindEventStore.INSTANCE.post(GameBindEvent.Changed.INSTANCE, (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 7:
                int i11 = this.I$0;
                RoleMenuItem roleMenuItem5 = (RoleMenuItem) this.L$4;
                roleId5 = (String) this.L$3;
                role5 = (RoleItem) this.L$2;
                ResultKt.throwOnFailure($result);
                return state.override(new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$2$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = RolesListViewModel$mMenuMachine$1$1$2.invokeSuspend$lambda$1((RolesListViewModel.MenuState) obj);
                        return invokeSuspend$lambda$1;
                    }
                });
            case 8:
                int i12 = this.I$0;
                RoleMenuItem roleMenuItem6 = (RoleMenuItem) this.L$4;
                roleId4 = (String) this.L$3;
                role4 = (RoleItem) this.L$2;
                ResultKt.throwOnFailure($result);
                return state.override(new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$2$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = RolesListViewModel$mMenuMachine$1$1$2.invokeSuspend$lambda$1((RolesListViewModel.MenuState) obj);
                        return invokeSuspend$lambda$1;
                    }
                });
            case 9:
                RoleMenuItem roleMenuItem7 = (RoleMenuItem) this.L$4;
                roleId2 = (String) this.L$3;
                role2 = (RoleItem) this.L$2;
                ResultKt.throwOnFailure($result);
                changeVisible = $result;
                r3 = roleMenuItem7;
                r44 = ((Boolean) changeVisible).booleanValue();
                if (r44 != 0) {
                }
                break;
            case 10:
                i3 = this.I$0;
                menuItem3 = (RoleMenuItem) this.L$4;
                roleId2 = (String) this.L$3;
                role2 = (RoleItem) this.L$2;
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                this.L$1 = state;
                this.L$2 = SpillingKt.nullOutSpilledVariable(role2);
                this.L$3 = SpillingKt.nullOutSpilledVariable(roleId2);
                this.L$4 = SpillingKt.nullOutSpilledVariable(menuItem3);
                this.I$0 = i3;
                this.label = 11;
                if (GameBindEventStore.INSTANCE.post(GameBindEvent.Changed.INSTANCE, (Continuation) this) != coroutine_suspended) {
                }
                break;
            case AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER /* 11 */:
                int i13 = this.I$0;
                RoleMenuItem roleMenuItem8 = (RoleMenuItem) this.L$4;
                roleId7 = (String) this.L$3;
                role7 = (RoleItem) this.L$2;
                ResultKt.throwOnFailure($result);
                return state.override(new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$2$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$2;
                        invokeSuspend$lambda$2 = RolesListViewModel$mMenuMachine$1$1$2.invokeSuspend$lambda$2((RolesListViewModel.MenuState) obj);
                        return invokeSuspend$lambda$2;
                    }
                });
            case AdditionVote2.ADDITION_VOTE_DEFAULE_FIELD_NUMBER /* 12 */:
                int i14 = this.I$0;
                RoleMenuItem roleMenuItem9 = (RoleMenuItem) this.L$4;
                roleId6 = (String) this.L$3;
                role6 = (RoleItem) this.L$2;
                ResultKt.throwOnFailure($result);
                return state.override(new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$2$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$2;
                        invokeSuspend$lambda$2 = RolesListViewModel$mMenuMachine$1$1$2.invokeSuspend$lambda$2((RolesListViewModel.MenuState) obj);
                        return invokeSuspend$lambda$2;
                    }
                });
            case AdditionVote2.BIZ_TYPE_FIELD_NUMBER /* 13 */:
                RoleMenuItem roleMenuItem10 = (RoleMenuItem) this.L$4;
                roleId2 = (String) this.L$3;
                role2 = (RoleItem) this.L$2;
                ResultKt.throwOnFailure($result);
                changeVisible2 = $result;
                r3 = roleMenuItem10;
                r43 = ((Boolean) changeVisible2).booleanValue();
                if (r43 != 0) {
                }
                break;
            case AdditionVote2.TOTAL_FIELD_NUMBER /* 14 */:
                i4 = this.I$0;
                menuItem4 = (RoleMenuItem) this.L$4;
                roleId2 = (String) this.L$3;
                role2 = (RoleItem) this.L$2;
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(event);
                this.L$1 = state;
                this.L$2 = SpillingKt.nullOutSpilledVariable(role2);
                this.L$3 = SpillingKt.nullOutSpilledVariable(roleId2);
                this.L$4 = SpillingKt.nullOutSpilledVariable(menuItem4);
                this.I$0 = i4;
                this.label = 15;
                if (GameBindEventStore.INSTANCE.post(GameBindEvent.Changed.INSTANCE, (Continuation) this) != coroutine_suspended) {
                }
                break;
            case AdditionVote2.CARD_TYPE_FIELD_NUMBER /* 15 */:
                int i15 = this.I$0;
                RoleMenuItem roleMenuItem11 = (RoleMenuItem) this.L$4;
                roleId9 = (String) this.L$3;
                role9 = (RoleItem) this.L$2;
                ResultKt.throwOnFailure($result);
                return state.override(new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$2$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$3;
                        invokeSuspend$lambda$3 = RolesListViewModel$mMenuMachine$1$1$2.invokeSuspend$lambda$3((RolesListViewModel.MenuState) obj);
                        return invokeSuspend$lambda$3;
                    }
                });
            case AdditionVote2.TIPS_FIELD_NUMBER /* 16 */:
                int i16 = this.I$0;
                RoleMenuItem roleMenuItem12 = (RoleMenuItem) this.L$4;
                roleId8 = (String) this.L$3;
                role8 = (RoleItem) this.L$2;
                ResultKt.throwOnFailure($result);
                return state.override(new Function1() { // from class: kntr.app.game.gamebind.RolesListViewModel$mMenuMachine$1$1$2$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$3;
                        invokeSuspend$lambda$3 = RolesListViewModel$mMenuMachine$1$1$2.invokeSuspend$lambda$3((RolesListViewModel.MenuState) obj);
                        return invokeSuspend$lambda$3;
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$1(RolesListViewModel.MenuState $this$override) {
        return RolesListViewModel.MenuState.Initialize.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$2(RolesListViewModel.MenuState $this$override) {
        return RolesListViewModel.MenuState.Initialize.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$3(RolesListViewModel.MenuState $this$override) {
        return RolesListViewModel.MenuState.Initialize.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RolesListViewModel.MenuState.ShowRoleSwitchDialog invokeSuspend$lambda$4(RoleItem $role, RoleMenuItem $menuItem, RolesListViewModel.MenuState $this$override) {
        return new RolesListViewModel.MenuState.ShowRoleSwitchDialog($role, $menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RolesListViewModel.MenuState.UnbindDialog invokeSuspend$lambda$5(RoleItem $role, RolesListViewModel.MenuState $this$override) {
        return new RolesListViewModel.MenuState.UnbindDialog($role);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RolesListViewModel.MenuState.Initialize invokeSuspend$lambda$6(RolesListViewModel.MenuState $this$override) {
        return RolesListViewModel.MenuState.Initialize.INSTANCE;
    }
}