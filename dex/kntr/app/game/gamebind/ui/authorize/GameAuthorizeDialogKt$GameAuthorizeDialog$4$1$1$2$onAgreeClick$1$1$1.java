package kntr.app.game.gamebind.ui.authorize;

import androidx.compose.runtime.MutableState;
import kntr.app.game.gamebind.AuthorizeEvent;
import kntr.app.game.gamebind.GameAuthorizeViewModel;
import kntr.app.game.gamebind.bean.AuthorizeInfo;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GameAuthorizeDialog.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.gamebind.ui.authorize.GameAuthorizeDialogKt$GameAuthorizeDialog$4$1$1$2$onAgreeClick$1$1$1", f = "GameAuthorizeDialog.kt", i = {}, l = {185}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class GameAuthorizeDialogKt$GameAuthorizeDialog$4$1$1$2$onAgreeClick$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $authorizeAllChecked$delegate;
    final /* synthetic */ AuthorizeInfo $authorizeInfo;
    final /* synthetic */ GameAuthorizeViewModel $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameAuthorizeDialogKt$GameAuthorizeDialog$4$1$1$2$onAgreeClick$1$1$1(GameAuthorizeViewModel gameAuthorizeViewModel, AuthorizeInfo authorizeInfo, MutableState<Boolean> mutableState, Continuation<? super GameAuthorizeDialogKt$GameAuthorizeDialog$4$1$1$2$onAgreeClick$1$1$1> continuation) {
        super(2, continuation);
        this.$viewModel = gameAuthorizeViewModel;
        this.$authorizeInfo = authorizeInfo;
        this.$authorizeAllChecked$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GameAuthorizeDialogKt$GameAuthorizeDialog$4$1$1$2$onAgreeClick$1$1$1(this.$viewModel, this.$authorizeInfo, this.$authorizeAllChecked$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        boolean GameAuthorizeDialog$lambda$10$0$0$1$4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                GameAuthorizeViewModel gameAuthorizeViewModel = this.$viewModel;
                GameAuthorizeDialog$lambda$10$0$0$1$4 = GameAuthorizeDialogKt.GameAuthorizeDialog$lambda$10$0$0$1$4(this.$authorizeAllChecked$delegate);
                boolean z = GameAuthorizeDialog$lambda$10$0$0$1$4 && this.$authorizeInfo.getCanBatchAuth();
                this.label = 1;
                if (gameAuthorizeViewModel.dispatch(new AuthorizeEvent.Bind(z, this.$authorizeInfo), (Continuation) this) == coroutine_suspended) {
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