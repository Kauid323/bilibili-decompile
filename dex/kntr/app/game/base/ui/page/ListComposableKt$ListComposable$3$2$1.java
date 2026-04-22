package kntr.app.game.base.ui.page;

import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.State;
import java.util.List;
import kntr.app.game.base.viewmodel.PageLoadMoreState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ListComposable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.base.ui.page.ListComposableKt$ListComposable$3$2$1", f = "ListComposable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ListComposableKt$ListComposable$3$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ List<Item> $list;
    final /* synthetic */ Function0<Job> $loadMore;
    final /* synthetic */ PageLoadMoreState $loadMoreState;
    final /* synthetic */ State<Boolean> $reachEnd$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ListComposableKt$ListComposable$3$2$1(PageLoadMoreState pageLoadMoreState, Function0<? extends Job> function0, List<? extends Item> list, LazyListState lazyListState, State<Boolean> state, Continuation<? super ListComposableKt$ListComposable$3$2$1> continuation) {
        super(2, continuation);
        this.$loadMoreState = pageLoadMoreState;
        this.$loadMore = function0;
        this.$list = list;
        this.$lazyListState = lazyListState;
        this.$reachEnd$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ListComposableKt$ListComposable$3$2$1(this.$loadMoreState, this.$loadMore, this.$list, this.$lazyListState, this.$reachEnd$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        boolean ListComposable$lambda$3$1;
        LazyListItemInfo lastVisibleItem;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ListComposable$lambda$3$1 = ListComposableKt.ListComposable$lambda$3$1(this.$reachEnd$delegate);
                if (ListComposable$lambda$3$1 && !Intrinsics.areEqual(this.$loadMoreState, PageLoadMoreState.Companion.getNoMore())) {
                    this.$loadMore.invoke();
                    return Unit.INSTANCE;
                }
                if (!this.$list.isEmpty() && !this.$lazyListState.getLayoutInfo().getVisibleItemsInfo().isEmpty() && (lastVisibleItem = (LazyListItemInfo) CollectionsKt.lastOrNull(this.$lazyListState.getLayoutInfo().getVisibleItemsInfo())) != null && lastVisibleItem.getIndex() == CollectionsKt.getLastIndex(this.$list) + 1) {
                    this.$loadMore.invoke();
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}