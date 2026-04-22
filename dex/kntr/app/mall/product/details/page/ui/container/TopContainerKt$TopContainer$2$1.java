package kntr.app.mall.product.details.page.ui.container;

import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.IntOffset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kntr.app.mall.product.details.page.vm.FloorType;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TopContainer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.container.TopContainerKt$TopContainer$2$1", f = "TopContainer.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TopContainerKt$TopContainer$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LazyStaggeredGridState $listState;
    final /* synthetic */ PageViewModel $pageViewModel;
    final /* synthetic */ State<Integer> $topContainerHeightInPixel$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopContainerKt$TopContainer$2$1(LazyStaggeredGridState lazyStaggeredGridState, State<Integer> state, PageViewModel pageViewModel, Continuation<? super TopContainerKt$TopContainer$2$1> continuation) {
        super(2, continuation);
        this.$listState = lazyStaggeredGridState;
        this.$topContainerHeightInPixel$delegate = state;
        this.$pageViewModel = pageViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TopContainerKt$TopContainer$2$1(this.$listState, this.$topContainerHeightInPixel$delegate, this.$pageViewModel, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final LazyStaggeredGridState lazyStaggeredGridState = this.$listState;
                final State<Integer> state = this.$topContainerHeightInPixel$delegate;
                Flow distinctUntilChanged = FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$TopContainer$2$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        int invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = TopContainerKt$TopContainer$2$1.invokeSuspend$lambda$0(lazyStaggeredGridState, state);
                        return Integer.valueOf(invokeSuspend$lambda$0);
                    }
                }));
                final PageViewModel pageViewModel = this.$pageViewModel;
                this.label = 1;
                if (distinctUntilChanged.collect(new FlowCollector() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$TopContainer$2$1.2
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit(((Number) value).intValue(), $completion);
                    }

                    public final Object emit(int index, Continuation<? super Unit> continuation) {
                        Integer commentIndex = PageViewModel.this.getListKeyToIndexMap().get(FloorType.COMMENT.getKey());
                        Integer detailIndex = PageViewModel.this.getListKeyToIndexMap().get(FloorType.DETAIL_DESC.getKey());
                        Integer feedBlastIndex = (Integer) CollectionsKt.maxOrNull(PageViewModel.this.getListKeyToIndexMap().values());
                        boolean showComment = PageViewModel.this.showTopTabCommentItem$product_details_page_debug();
                        boolean showDetail = PageViewModel.this.showTopTabDetailItem$product_details_page_debug();
                        boolean showFeedBlast = PageViewModel.this.showTopTabFeedBlastItem$product_details_page_debug();
                        int newTabIndex = 0;
                        if (commentIndex != null && index >= commentIndex.intValue() && showComment) {
                            newTabIndex = 1;
                        }
                        if (detailIndex != null && index >= detailIndex.intValue() && showDetail) {
                            newTabIndex = 2;
                        }
                        if (feedBlastIndex != null && index >= feedBlastIndex.intValue() && showFeedBlast) {
                            newTabIndex = 3;
                        }
                        PageViewModel.this.updateSelectedTab$product_details_page_debug(newTabIndex);
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final int invokeSuspend$lambda$0(LazyStaggeredGridState $listState, State $topContainerHeightInPixel$delegate) {
        int TopContainer_EUb7tLY$lambda$4;
        Object element$iv;
        Object element$iv2;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo;
        int bottom;
        LazyStaggeredGridLayoutInfo li = $listState.getLayoutInfo();
        int vpStart = li.getViewportStartOffset();
        TopContainer_EUb7tLY$lambda$4 = TopContainerKt.TopContainer_EUb7tLY$lambda$4($topContainerHeightInPixel$delegate);
        int threshold = TopContainer_EUb7tLY$lambda$4 + vpStart;
        Iterable $this$sortedBy$iv = li.getVisibleItemsInfo();
        List items = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$TopContainer$2$1$invokeSuspend$lambda$0$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                LazyStaggeredGridItemInfo it = (LazyStaggeredGridItemInfo) t;
                LazyStaggeredGridItemInfo it2 = (LazyStaggeredGridItemInfo) t2;
                return ComparisonsKt.compareValues(Integer.valueOf(IntOffset.getY-impl(it.getOffset-nOcc-ac())), Integer.valueOf(IntOffset.getY-impl(it2.getOffset-nOcc-ac())));
            }
        });
        List $this$firstOrNull$iv = items;
        Iterator it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                LazyStaggeredGridItemInfo info = (LazyStaggeredGridItemInfo) element$iv;
                int top = IntOffset.getY-impl(info.getOffset-nOcc-ac());
                int bottom2 = ((int) (info.getSize-YbymL2g() & 4294967295L)) + top;
                if (top > threshold || threshold >= bottom2) {
                    bottom = 0;
                    continue;
                } else {
                    bottom = 1;
                    continue;
                }
                if (bottom != 0) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        LazyStaggeredGridItemInfo crossing = (LazyStaggeredGridItemInfo) element$iv;
        List $this$firstOrNull$iv2 = items;
        Iterator it2 = $this$firstOrNull$iv2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                element$iv2 = null;
                break;
            }
            element$iv2 = it2.next();
            LazyStaggeredGridItemInfo info2 = (LazyStaggeredGridItemInfo) element$iv2;
            LazyStaggeredGridLayoutInfo li2 = li;
            int vpStart2 = vpStart;
            if (IntOffset.getY-impl(info2.getOffset-nOcc-ac()) + ((int) (info2.getSize-YbymL2g() & 4294967295L)) >= threshold) {
                break;
            }
            li = li2;
            vpStart = vpStart2;
        }
        LazyStaggeredGridItemInfo fallbackBelow = (LazyStaggeredGridItemInfo) element$iv2;
        if (crossing != null) {
            lazyStaggeredGridItemInfo = crossing;
        } else {
            lazyStaggeredGridItemInfo = fallbackBelow == null ? (LazyStaggeredGridItemInfo) CollectionsKt.firstOrNull(items) : fallbackBelow;
        }
        if (lazyStaggeredGridItemInfo != null) {
            return lazyStaggeredGridItemInfo.getIndex();
        }
        return 0;
    }
}