package kntr.app.tribee.repost.page.selectTribeeBottomSheet;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SelectTribeeBottomSheetViewModel.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.repost.page.selectTribeeBottomSheet.SelectTribeeBottomSheetViewModel", f = "SelectTribeeBottomSheetViewModel.kt", i = {}, l = {88}, m = "handleLoading", n = {}, s = {}, v = 1)
public final class SelectTribeeBottomSheetViewModel$handleLoading$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SelectTribeeBottomSheetViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectTribeeBottomSheetViewModel$handleLoading$1(SelectTribeeBottomSheetViewModel selectTribeeBottomSheetViewModel, Continuation<? super SelectTribeeBottomSheetViewModel$handleLoading$1> continuation) {
        super(continuation);
        this.this$0 = selectTribeeBottomSheetViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        Object handleLoading;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        handleLoading = this.this$0.handleLoading((Continuation) this);
        return handleLoading;
    }
}