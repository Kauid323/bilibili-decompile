package kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SelectTribeeList.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListKt$SelectTribeeList$3$1", f = "SelectTribeeList.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SelectTribeeListKt$SelectTribeeList$3$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ SelectTribeeListState $listState;
    final /* synthetic */ Function0<Unit> $onLoadMore;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTribeeListKt$SelectTribeeList$3$1(SelectTribeeListState selectTribeeListState, Function0<Unit> function0, Continuation<? super SelectTribeeListKt$SelectTribeeList$3$1> continuation) {
        super(1, continuation);
        this.$listState = selectTribeeListState;
        this.$onLoadMore = function0;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new SelectTribeeListKt$SelectTribeeList$3$1(this.$listState, this.$onLoadMore, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$listState.getHasMore() && !this.$listState.isLoadingMore()) {
                    this.$onLoadMore.invoke();
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}