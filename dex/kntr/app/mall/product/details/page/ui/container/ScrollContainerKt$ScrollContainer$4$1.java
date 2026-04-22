package kntr.app.mall.product.details.page.ui.container;

import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.FeedsModel;
import kntr.app.mall.product.details.page.api.model.MallRecommendItem;
import kntr.app.mall.product.details.page.api.model.RecommendVO;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ScrollContainer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$ScrollContainer$4$1", f = "ScrollContainer.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ScrollContainerKt$ScrollContainer$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $feedBlastIsLoading$delegate;
    final /* synthetic */ MutableIntState $feedBlastPageNum$delegate;
    final /* synthetic */ State<FeedsModel> $lastFeedBlastData$delegate;
    final /* synthetic */ LazyStaggeredGridState $listState;
    final /* synthetic */ PageViewModel $pageViewModel;
    final /* synthetic */ CoroutineScope $scope;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollContainerKt$ScrollContainer$4$1(LazyStaggeredGridState lazyStaggeredGridState, CoroutineScope coroutineScope, State<FeedsModel> state, MutableState<Boolean> mutableState, PageViewModel pageViewModel, MutableIntState mutableIntState, Continuation<? super ScrollContainerKt$ScrollContainer$4$1> continuation) {
        super(2, continuation);
        this.$listState = lazyStaggeredGridState;
        this.$scope = coroutineScope;
        this.$lastFeedBlastData$delegate = state;
        this.$feedBlastIsLoading$delegate = mutableState;
        this.$pageViewModel = pageViewModel;
        this.$feedBlastPageNum$delegate = mutableIntState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ScrollContainerKt$ScrollContainer$4$1(this.$listState, this.$scope, this.$lastFeedBlastData$delegate, this.$feedBlastIsLoading$delegate, this.$pageViewModel, this.$feedBlastPageNum$delegate, continuation);
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
                Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$ScrollContainer$4$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        LazyStaggeredGridLayoutInfo layoutInfo;
                        layoutInfo = lazyStaggeredGridState.getLayoutInfo();
                        return layoutInfo;
                    }
                });
                final CoroutineScope coroutineScope = this.$scope;
                final State<FeedsModel> state = this.$lastFeedBlastData$delegate;
                final MutableState<Boolean> mutableState = this.$feedBlastIsLoading$delegate;
                final PageViewModel pageViewModel = this.$pageViewModel;
                final MutableIntState mutableIntState = this.$feedBlastPageNum$delegate;
                this.label = 1;
                if (snapshotFlow.collect(new FlowCollector() { // from class: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$ScrollContainer$4$1.2
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((LazyStaggeredGridLayoutInfo) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(LazyStaggeredGridLayoutInfo layoutInfo, Continuation<? super Unit> continuation) {
                        FeedsModel ScrollContainer_dsL6K2w$lambda$8;
                        boolean ScrollContainer_dsL6K2w$lambda$5;
                        FeedsModel ScrollContainer_dsL6K2w$lambda$82;
                        RecommendVO vo;
                        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo = (LazyStaggeredGridItemInfo) CollectionsKt.lastOrNull(layoutInfo.getVisibleItemsInfo());
                        boolean blockByHasMore = false;
                        int lastVisible = lazyStaggeredGridItemInfo != null ? lazyStaggeredGridItemInfo.getIndex() : 0;
                        int total = layoutInfo.getTotalItemsCount();
                        ScrollContainer_dsL6K2w$lambda$8 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$8(state);
                        if ((ScrollContainer_dsL6K2w$lambda$8 != null ? ScrollContainer_dsL6K2w$lambda$8.getVo() : null) != null) {
                            ScrollContainer_dsL6K2w$lambda$82 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$8(state);
                            if (!((ScrollContainer_dsL6K2w$lambda$82 == null || (vo = ScrollContainer_dsL6K2w$lambda$82.getVo()) == null) ? false : Intrinsics.areEqual(vo.getHasMore(), Boxing.boxBoolean(true)))) {
                                blockByHasMore = true;
                            }
                        }
                        ScrollContainer_dsL6K2w$lambda$5 = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$5(mutableState);
                        if (!ScrollContainer_dsL6K2w$lambda$5 && lastVisible >= total - 7 && total > 0 && !blockByHasMore) {
                            ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$6(mutableState, true);
                            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(pageViewModel, mutableIntState, mutableState, null), 3, (Object) null);
                        }
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: ScrollContainer.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                    @DebugMetadata(c = "kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$ScrollContainer$4$1$2$1", f = "ScrollContainer.kt", i = {0}, l = {143}, m = "invokeSuspend", n = {"nextPage"}, s = {"I$0"}, v = 1)
                    /* renamed from: kntr.app.mall.product.details.page.ui.container.ScrollContainerKt$ScrollContainer$4$1$2$1  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ MutableState<Boolean> $feedBlastIsLoading$delegate;
                        final /* synthetic */ MutableIntState $feedBlastPageNum$delegate;
                        final /* synthetic */ PageViewModel $pageViewModel;
                        int I$0;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(PageViewModel pageViewModel, MutableIntState mutableIntState, MutableState<Boolean> mutableState, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$pageViewModel = pageViewModel;
                            this.$feedBlastPageNum$delegate = mutableIntState;
                            this.$feedBlastIsLoading$delegate = mutableState;
                        }

                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$pageViewModel, this.$feedBlastPageNum$delegate, this.$feedBlastIsLoading$delegate, continuation);
                        }

                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                        }

                        public final Object invokeSuspend(Object $result) {
                            int nextPage;
                            Object loadFeedBlast$product_details_page_debug;
                            int nextPage2;
                            List<MallRecommendItem> itemList;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            boolean z = true;
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    nextPage = ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$2(this.$feedBlastPageNum$delegate);
                                    this.I$0 = nextPage;
                                    this.label = 1;
                                    loadFeedBlast$product_details_page_debug = this.$pageViewModel.loadFeedBlast$product_details_page_debug(nextPage, (Continuation) this);
                                    if (loadFeedBlast$product_details_page_debug == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    nextPage2 = nextPage;
                                    break;
                                case 1:
                                    nextPage2 = this.I$0;
                                    ResultKt.throwOnFailure($result);
                                    loadFeedBlast$product_details_page_debug = $result;
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            FeedsModel newFeeds = (FeedsModel) loadFeedBlast$product_details_page_debug;
                            RecommendVO vo = newFeeds.getVo();
                            if (vo == null || (itemList = vo.getItemList()) == null || !(!itemList.isEmpty())) {
                                z = false;
                            }
                            if (z) {
                                this.$pageViewModel.addMoreFeedBlast$product_details_page_debug(newFeeds, nextPage2);
                                this.$feedBlastPageNum$delegate.setIntValue(nextPage2 + 1);
                            }
                            ScrollContainerKt.ScrollContainer_dsL6K2w$lambda$6(this.$feedBlastIsLoading$delegate, false);
                            return Unit.INSTANCE;
                        }
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
}