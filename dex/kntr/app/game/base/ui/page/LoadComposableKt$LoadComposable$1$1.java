package kntr.app.game.base.ui.page;

import kntr.app.game.base.viewmodel.BaseViewModel;
import kntr.app.game.base.viewmodel.event.PageEvent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.compose.pulltorefresh.PullToRefreshState;
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
/* JADX WARN: Incorrect field signature: TVM; */
/* compiled from: LoadComposable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.base.ui.page.LoadComposableKt$LoadComposable$1$1", f = "LoadComposable.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class LoadComposableKt$LoadComposable$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PullToRefreshState $pullToRefreshState;
    final /* synthetic */ BaseViewModel $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect types in method signature: (Lkntr/common/compose/pulltorefresh/PullToRefreshState;TVM;Lkotlin/coroutines/Continuation<-Lkntr/app/game/base/ui/page/LoadComposableKt$LoadComposable$1$1;>;)V */
    public LoadComposableKt$LoadComposable$1$1(PullToRefreshState pullToRefreshState, BaseViewModel baseViewModel, Continuation continuation) {
        super(2, continuation);
        this.$pullToRefreshState = pullToRefreshState;
        this.$viewModel = baseViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoadComposableKt$LoadComposable$1$1(this.$pullToRefreshState, this.$viewModel, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$pullToRefreshState.isRefreshing()) {
                    this.label = 1;
                    if (this.$viewModel.dispatch((PageEvent) PageEvent.Refresh.INSTANCE, (Continuation) this) == coroutine_suspended) {
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