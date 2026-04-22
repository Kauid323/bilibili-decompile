package kntr.app.tribee.repost.page.selectTribeeBottomSheet;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SelectTribeeBottomSheetViewModel.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.repost.page.selectTribeeBottomSheet.SelectTribeeBottomSheetViewModel", f = "SelectTribeeBottomSheetViewModel.kt", i = {0}, l = {169}, m = "handleLoadMore", n = {"currentState"}, s = {"L$0"}, v = 1)
public final class SelectTribeeBottomSheetViewModel$handleLoadMore$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SelectTribeeBottomSheetViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTribeeBottomSheetViewModel$handleLoadMore$1(SelectTribeeBottomSheetViewModel selectTribeeBottomSheetViewModel, Continuation<? super SelectTribeeBottomSheetViewModel$handleLoadMore$1> continuation) {
        super(continuation);
        this.this$0 = selectTribeeBottomSheetViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        Object handleLoadMore;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        handleLoadMore = this.this$0.handleLoadMore((Continuation) this);
        return handleLoadMore;
    }
}