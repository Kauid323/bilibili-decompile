package kntr.app.game.base.ui.page;

import androidx.compose.runtime.State;
import kntr.app.game.base.viewmodel.PageState;
import kntr.app.game.base.viewmodel.RefreshState;
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
/* compiled from: LoadComposable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.base.ui.page.LoadComposableKt$LoadComposable$2$1", f = "LoadComposable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class LoadComposableKt$LoadComposable$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<PageState> $pageState$delegate;
    final /* synthetic */ PullToRefreshState $pullToRefreshState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LoadComposableKt$LoadComposable$2$1(PullToRefreshState pullToRefreshState, State<? extends PageState> state, Continuation<? super LoadComposableKt$LoadComposable$2$1> continuation) {
        super(2, continuation);
        this.$pullToRefreshState = pullToRefreshState;
        this.$pageState$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoadComposableKt$LoadComposable$2$1(this.$pullToRefreshState, this.$pageState$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        PageState LoadComposable$lambda$1;
        RefreshState refreshState;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                LoadComposable$lambda$1 = LoadComposableKt.LoadComposable$lambda$1(this.$pageState$delegate);
                PageState.Content content = LoadComposable$lambda$1 instanceof PageState.Content ? (PageState.Content) LoadComposable$lambda$1 : null;
                boolean z = false;
                if (content != null && (refreshState = content.getRefreshState()) != null && refreshState.getRefreshing()) {
                    z = true;
                }
                if (!z) {
                    this.$pullToRefreshState.endRefresh();
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}