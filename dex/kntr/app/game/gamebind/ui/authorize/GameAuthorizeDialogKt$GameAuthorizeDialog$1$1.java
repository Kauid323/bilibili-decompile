package kntr.app.game.gamebind.ui.authorize;

import androidx.compose.runtime.MutableState;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import kntr.app.game.gamebind.AuthorizeEvent;
import kntr.app.game.gamebind.GameAuthorizeViewModel;
import kntr.app.game.gamebind.bean.AuthorizeParams;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
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
@DebugMetadata(c = "kntr.app.game.gamebind.ui.authorize.GameAuthorizeDialogKt$GameAuthorizeDialog$1$1", f = "GameAuthorizeDialog.kt", i = {}, l = {102, 104}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class GameAuthorizeDialogKt$GameAuthorizeDialog$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AuthorizeParams $authorizeParams;
    final /* synthetic */ MutableState<Boolean> $backFromTencentBind$delegate;
    final /* synthetic */ LifecycleOwner $lifecycle;
    final /* synthetic */ GameAuthorizeViewModel $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameAuthorizeDialogKt$GameAuthorizeDialog$1$1(AuthorizeParams authorizeParams, GameAuthorizeViewModel gameAuthorizeViewModel, LifecycleOwner lifecycleOwner, MutableState<Boolean> mutableState, Continuation<? super GameAuthorizeDialogKt$GameAuthorizeDialog$1$1> continuation) {
        super(2, continuation);
        this.$authorizeParams = authorizeParams;
        this.$viewModel = gameAuthorizeViewModel;
        this.$lifecycle = lifecycleOwner;
        this.$backFromTencentBind$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GameAuthorizeDialogKt$GameAuthorizeDialog$1$1(this.$authorizeParams, this.$viewModel, this.$lifecycle, this.$backFromTencentBind$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0061 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$authorizeParams.getAuthStatus() == 1 && !this.$authorizeParams.getOnlyAuth()) {
                    this.label = 1;
                    if (this.$viewModel.dispatch(new AuthorizeEvent.Bind(false, null, 3, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                this.label = 2;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(this.$lifecycle, Lifecycle.State.RESUMED, new AnonymousClass1(this.$viewModel, this.$backFromTencentBind$delegate, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                this.label = 2;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(this.$lifecycle, Lifecycle.State.RESUMED, new AnonymousClass1(this.$viewModel, this.$backFromTencentBind$delegate, null), (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GameAuthorizeDialog.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "kntr.app.game.gamebind.ui.authorize.GameAuthorizeDialogKt$GameAuthorizeDialog$1$1$1", f = "GameAuthorizeDialog.kt", i = {}, l = {108}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.game.gamebind.ui.authorize.GameAuthorizeDialogKt$GameAuthorizeDialog$1$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableState<Boolean> $backFromTencentBind$delegate;
        final /* synthetic */ GameAuthorizeViewModel $viewModel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(GameAuthorizeViewModel gameAuthorizeViewModel, MutableState<Boolean> mutableState, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$viewModel = gameAuthorizeViewModel;
            this.$backFromTencentBind$delegate = mutableState;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$viewModel, this.$backFromTencentBind$delegate, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            boolean GameAuthorizeDialog$lambda$5;
            boolean GameAuthorizeDialog$lambda$52;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    ILogger kLog = KLog_androidKt.getKLog();
                    GameAuthorizeDialog$lambda$5 = GameAuthorizeDialogKt.GameAuthorizeDialog$lambda$5(this.$backFromTencentBind$delegate);
                    kLog.d("RolesListPage", "---GameAuthorizeDialog resumed: " + GameAuthorizeDialog$lambda$5);
                    GameAuthorizeDialog$lambda$52 = GameAuthorizeDialogKt.GameAuthorizeDialog$lambda$5(this.$backFromTencentBind$delegate);
                    if (GameAuthorizeDialog$lambda$52) {
                        KLog_androidKt.getKLog().d("RolesListPage", "---backFromTencent");
                        this.label = 1;
                        if (this.$viewModel.dispatch(AuthorizeEvent.CheckBind.INSTANCE, (Continuation) this) == coroutine_suspended) {
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
}