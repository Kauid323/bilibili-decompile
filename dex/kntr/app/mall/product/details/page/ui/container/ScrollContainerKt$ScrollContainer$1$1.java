package kntr.app.mall.product.details.page.ui.container;

import androidx.compose.runtime.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.compose.pulltorefresh.PullToRefreshState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ScrollContainer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$ScrollContainer$1$1", f = "ScrollContainer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ScrollContainerKt$ScrollContainer$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function0<Unit>> $currentOnRefresh$delegate;
    final /* synthetic */ boolean $isRefreshing;
    final /* synthetic */ PullToRefreshState $pullToRefreshState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollContainerKt$ScrollContainer$1$1(PullToRefreshState pullToRefreshState, boolean z, State<? extends Function0<Unit>> state, Continuation<? super ScrollContainerKt$ScrollContainer$1$1> continuation) {
        super(2, continuation);
        this.$pullToRefreshState = pullToRefreshState;
        this.$isRefreshing = z;
        this.$currentOnRefresh$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ScrollContainerKt$ScrollContainer$1$1(this.$pullToRefreshState, this.$isRefreshing, this.$currentOnRefresh$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Function0 ScrollContainer_dsL6K2w$lambda$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$pullToRefreshState.isRefreshing() && !this.$isRefreshing) {
                    ScrollContainer_dsL6K2w$lambda$0 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$0(this.$currentOnRefresh$delegate);
                    ScrollContainer_dsL6K2w$lambda$0.invoke();
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}