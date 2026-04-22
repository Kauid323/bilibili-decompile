package kntr.watch.later.watchlater.viewmodel;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchLaterViewModel.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.watch.later.watchlater.viewmodel.WatchLaterViewModel", f = "WatchLaterViewModel.kt", i = {0, 0, 0}, l = {802}, m = "requestData", n = {"pageIndex", "isLoadMore", "isRefresh"}, s = {"I$0", "Z$0", "Z$1"}, v = 1)
public final class WatchLaterViewModel$requestData$1 extends ContinuationImpl {
    int I$0;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WatchLaterViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchLaterViewModel$requestData$1(WatchLaterViewModel watchLaterViewModel, Continuation<? super WatchLaterViewModel$requestData$1> continuation) {
        super(continuation);
        this.this$0 = watchLaterViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        Object requestData;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        requestData = this.this$0.requestData(0, false, false, (Continuation) this);
        return requestData;
    }
}