package kntr.app.game.gamebind.ui;

import androidx.compose.runtime.MutableState;
import kntr.app.game.gamebind.RolesListViewModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RoleListPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.gamebind.ui.RoleListPageKt$RoleListPage$2$1", f = "RoleListPage.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class RoleListPageKt$RoleListPage$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.BooleanRef $bottomSheetShowing;
    final /* synthetic */ MutableState<Boolean> $openBottomSheet$delegate;
    final /* synthetic */ RolesListViewModel $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoleListPageKt$RoleListPage$2$1(Ref.BooleanRef booleanRef, RolesListViewModel rolesListViewModel, MutableState<Boolean> mutableState, Continuation<? super RoleListPageKt$RoleListPage$2$1> continuation) {
        super(2, continuation);
        this.$bottomSheetShowing = booleanRef;
        this.$viewModel = rolesListViewModel;
        this.$openBottomSheet$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RoleListPageKt$RoleListPage$2$1(this.$bottomSheetShowing, this.$viewModel, this.$openBottomSheet$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        boolean RoleListPage$lambda$1$7;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                RoleListPage$lambda$1$7 = RoleListPageKt.RoleListPage$lambda$1$7(this.$openBottomSheet$delegate);
                if (!RoleListPage$lambda$1$7 && this.$bottomSheetShowing.element) {
                    this.label = 1;
                    if (this.$viewModel.dispatch((RolesListViewModel.MenuEvent) RolesListViewModel.MenuEvent.HideMenuDialog.INSTANCE, (Continuation) this) == coroutine_suspended) {
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