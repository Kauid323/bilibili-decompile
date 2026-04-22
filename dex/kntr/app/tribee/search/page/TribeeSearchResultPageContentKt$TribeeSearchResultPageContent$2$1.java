package kntr.app.tribee.search.page;

import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.SnapshotStateKt;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDyn;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSearchCard;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSearchDyn;
import java.util.List;
import java.util.Set;
import kntr.app.tribee.search.state.TribeeSearchState;
import kntr.app.tribee.search.track.SearchTrackerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeSearchResultPageContent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.search.page.TribeeSearchResultPageContentKt$TribeeSearchResultPageContent$2$1", f = "TribeeSearchResultPageContent.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeSearchResultPageContentKt$TribeeSearchResultPageContent$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Set<String> $exposedCard;
    final /* synthetic */ Set<String> $initialExposedCard;
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ TribeeSearchState.Result.Success $state;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeSearchResultPageContentKt$TribeeSearchResultPageContent$2$1(LazyListState lazyListState, TribeeSearchState.Result.Success success, Set<String> set, Set<String> set2, Continuation<? super TribeeSearchResultPageContentKt$TribeeSearchResultPageContent$2$1> continuation) {
        super(2, continuation);
        this.$listState = lazyListState;
        this.$state = success;
        this.$exposedCard = set;
        this.$initialExposedCard = set2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeSearchResultPageContentKt$TribeeSearchResultPageContent$2$1(this.$listState, this.$state, this.$exposedCard, this.$initialExposedCard, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final LazyListState lazyListState = this.$listState;
                Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.tribee.search.page.TribeeSearchResultPageContentKt$TribeeSearchResultPageContent$2$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        List invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = TribeeSearchResultPageContentKt$TribeeSearchResultPageContent$2$1.invokeSuspend$lambda$0(lazyListState);
                        return invokeSuspend$lambda$0;
                    }
                });
                final TribeeSearchState.Result.Success success = this.$state;
                final Set<String> set = this.$exposedCard;
                final Set<String> set2 = this.$initialExposedCard;
                this.label = 1;
                if (snapshotFlow.collect(new FlowCollector() { // from class: kntr.app.tribee.search.page.TribeeSearchResultPageContentKt$TribeeSearchResultPageContent$2$1.2
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((List) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(List<? extends LazyListItemInfo> list, Continuation<? super Unit> continuation) {
                        KTribeeSearchDyn value;
                        KTribeeDyn dyn;
                        LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) CollectionsKt.firstOrNull(list);
                        if (lazyListItemInfo == null) {
                            return Unit.INSTANCE;
                        }
                        int startIndex = lazyListItemInfo.getIndex();
                        LazyListItemInfo lazyListItemInfo2 = (LazyListItemInfo) CollectionsKt.lastOrNull(list);
                        if (lazyListItemInfo2 == null) {
                            return Unit.INSTANCE;
                        }
                        int endIndex = lazyListItemInfo2.getIndex();
                        int index = startIndex;
                        if (index <= endIndex) {
                            while (true) {
                                KTribeeSearchCard card = (KTribeeSearchCard) CollectionsKt.getOrNull(TribeeSearchState.Result.Success.this.getContents(), index);
                                if (card != null) {
                                    KTribeeSearchCard.KDyn data = card.getData();
                                    KTribeeSearchCard.KDyn kDyn = data instanceof KTribeeSearchCard.KDyn ? data : null;
                                    if (kDyn != null && (value = kDyn.getValue()) != null && (dyn = value.getDyn()) != null) {
                                        long dynCardId = dyn.getDynId();
                                        if (set.add(String.valueOf(dynCardId))) {
                                            String tribeeId = TribeeSearchState.Result.Success.this.getTribeeId();
                                            String query = TribeeSearchState.Result.Success.this.getSearchBarState().getQuery();
                                            String trackId = TribeeSearchState.Result.Success.this.getTrackId();
                                            if (trackId == null) {
                                                trackId = "";
                                            }
                                            SearchTrackerKt.searchResultCardExposure$default(tribeeId, query, trackId, null, (Math.max(index - 1, 0) / 20) + 1, index, set2.isEmpty(), card.getTraceParam(), 8, null);
                                        }
                                    }
                                }
                                if (index == endIndex) {
                                    break;
                                }
                                index++;
                            }
                        }
                        if (set2.isEmpty()) {
                            set2.addAll(set);
                        }
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
    public static final List invokeSuspend$lambda$0(LazyListState $listState) {
        return $listState.getLayoutInfo().getVisibleItemsInfo();
    }
}