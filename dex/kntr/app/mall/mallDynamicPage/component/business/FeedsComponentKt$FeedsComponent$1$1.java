package kntr.app.mall.mallDynamicPage.component.business;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
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
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FeedsComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.mall.mallDynamicPage.component.business.FeedsComponentKt$FeedsComponent$1$1", f = "FeedsComponent.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FeedsComponentKt$FeedsComponent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableIntState $columns$delegate;
    final /* synthetic */ SnapshotStateList<MallRecommendItem> $feeds;
    final /* synthetic */ MutableIntState $pageNum$delegate;
    final /* synthetic */ MutableState<String> $title$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedsComponentKt$FeedsComponent$1$1(SnapshotStateList<MallRecommendItem> snapshotStateList, MutableIntState mutableIntState, MutableState<String> mutableState, MutableIntState mutableIntState2, Continuation<? super FeedsComponentKt$FeedsComponent$1$1> continuation) {
        super(2, continuation);
        this.$feeds = snapshotStateList;
        this.$pageNum$delegate = mutableIntState;
        this.$title$delegate = mutableState;
        this.$columns$delegate = mutableIntState2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FeedsComponentKt$FeedsComponent$1$1(this.$feeds, this.$pageNum$delegate, this.$title$delegate, this.$columns$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        int FeedsComponent$lambda$9;
        Object loadData;
        List<MallRecommendItem> emptyList;
        Integer columnCount;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                FeedsComponent$lambda$9 = FeedsComponentKt.FeedsComponent$lambda$9(this.$pageNum$delegate);
                this.label = 1;
                loadData = FeedsComponentKt.loadData(FeedsComponent$lambda$9, (Continuation) this);
                if (loadData == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                loadData = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        RecommendVO initialData = (RecommendVO) loadData;
        this.$title$delegate.setValue((initialData == null || (r2 = initialData.getTitle()) == null) ? "猜你喜欢" : "猜你喜欢");
        this.$columns$delegate.setIntValue((initialData == null || (columnCount = initialData.getColumnCount()) == null) ? 2 : columnCount.intValue());
        SnapshotStateList<MallRecommendItem> snapshotStateList = this.$feeds;
        if (initialData == null || (emptyList = initialData.getItemList()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        snapshotStateList.addAll(emptyList);
        return Unit.INSTANCE;
    }
}