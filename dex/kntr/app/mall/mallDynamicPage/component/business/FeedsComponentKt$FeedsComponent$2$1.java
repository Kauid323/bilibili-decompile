package kntr.app.mall.mallDynamicPage.component.business;

import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridLayoutInfo;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.app.mall.mallDynamicPage.component.business.bean.MallRecommendItem;
import kntr.app.mall.mallDynamicPage.component.business.bean.RecommendVO;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FeedsComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.mall.mallDynamicPage.component.business.FeedsComponentKt$FeedsComponent$2$1", f = "FeedsComponent.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FeedsComponentKt$FeedsComponent$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SnapshotStateList<MallRecommendItem> $feeds;
    final /* synthetic */ MutableState<Boolean> $isLoading$delegate;
    final /* synthetic */ MutableIntState $pageNum$delegate;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ LazyStaggeredGridState $state;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedsComponentKt$FeedsComponent$2$1(LazyStaggeredGridState lazyStaggeredGridState, CoroutineScope coroutineScope, MutableState<Boolean> mutableState, SnapshotStateList<MallRecommendItem> snapshotStateList, MutableIntState mutableIntState, Continuation<? super FeedsComponentKt$FeedsComponent$2$1> continuation) {
        super(2, continuation);
        this.$state = lazyStaggeredGridState;
        this.$scope = coroutineScope;
        this.$isLoading$delegate = mutableState;
        this.$feeds = snapshotStateList;
        this.$pageNum$delegate = mutableIntState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FeedsComponentKt$FeedsComponent$2$1(this.$state, this.$scope, this.$isLoading$delegate, this.$feeds, this.$pageNum$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final LazyStaggeredGridState lazyStaggeredGridState = this.$state;
                Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.mall.mallDynamicPage.component.business.FeedsComponentKt$FeedsComponent$2$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        LazyStaggeredGridLayoutInfo layoutInfo;
                        layoutInfo = lazyStaggeredGridState.getLayoutInfo();
                        return layoutInfo;
                    }
                });
                final CoroutineScope coroutineScope = this.$scope;
                final MutableState<Boolean> mutableState = this.$isLoading$delegate;
                final SnapshotStateList<MallRecommendItem> snapshotStateList = this.$feeds;
                final MutableIntState mutableIntState = this.$pageNum$delegate;
                this.label = 1;
                if (snapshotFlow.collect(new FlowCollector() { // from class: kntr.app.mall.mallDynamicPage.component.business.FeedsComponentKt$FeedsComponent$2$1.2
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((LazyStaggeredGridLayoutInfo) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(LazyStaggeredGridLayoutInfo layoutInfo, Continuation<? super Unit> continuation) {
                        boolean FeedsComponent$lambda$12;
                        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo = (LazyStaggeredGridItemInfo) CollectionsKt.lastOrNull(layoutInfo.getVisibleItemsInfo());
                        int lastVisible = lazyStaggeredGridItemInfo != null ? lazyStaggeredGridItemInfo.getIndex() : 0;
                        int total = layoutInfo.getTotalItemsCount();
                        FeedsComponent$lambda$12 = FeedsComponentKt.FeedsComponent$lambda$12(mutableState);
                        if (!FeedsComponent$lambda$12 && lastVisible >= total - 7 && total > 0) {
                            FeedsComponentKt.FeedsComponent$lambda$13(mutableState, true);
                            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(snapshotStateList, mutableIntState, mutableState, null), 3, (Object) null);
                        }
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: FeedsComponent.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "kntr.app.mall.mallDynamicPage.component.business.FeedsComponentKt$FeedsComponent$2$1$2$1", f = "FeedsComponent.kt", i = {0}, l = {105}, m = "invokeSuspend", n = {"nextPage"}, s = {"I$0"}, v = 1)
                    /* renamed from: kntr.app.mall.mallDynamicPage.component.business.FeedsComponentKt$FeedsComponent$2$1$2$1  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ SnapshotStateList<MallRecommendItem> $feeds;
                        final /* synthetic */ MutableState<Boolean> $isLoading$delegate;
                        final /* synthetic */ MutableIntState $pageNum$delegate;
                        int I$0;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(SnapshotStateList<MallRecommendItem> snapshotStateList, MutableIntState mutableIntState, MutableState<Boolean> mutableState, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$feeds = snapshotStateList;
                            this.$pageNum$delegate = mutableIntState;
                            this.$isLoading$delegate = mutableState;
                        }

                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$feeds, this.$pageNum$delegate, this.$isLoading$delegate, continuation);
                        }

                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                        }

                        public final Object invokeSuspend(Object $result) {
                            int FeedsComponent$lambda$9;
                            Object loadData;
                            int nextPage;
                            List newFeeds;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (this.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FeedsComponent$lambda$9 = FeedsComponentKt.FeedsComponent$lambda$9(this.$pageNum$delegate);
                                    int nextPage2 = FeedsComponent$lambda$9 + 1;
                                    this.I$0 = nextPage2;
                                    this.label = 1;
                                    loadData = FeedsComponentKt.loadData(nextPage2, (Continuation) this);
                                    if (loadData == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    nextPage = nextPage2;
                                    break;
                                case 1:
                                    nextPage = this.I$0;
                                    ResultKt.throwOnFailure($result);
                                    loadData = $result;
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            RecommendVO recommendVO = (RecommendVO) loadData;
                            if (recommendVO == null || (newFeeds = recommendVO.getItemList()) == null) {
                                newFeeds = CollectionsKt.emptyList();
                            }
                            if (!newFeeds.isEmpty()) {
                                this.$feeds.addAll(newFeeds);
                                this.$pageNum$delegate.setIntValue(nextPage);
                            }
                            FeedsComponentKt.FeedsComponent$lambda$13(this.$isLoading$delegate, false);
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