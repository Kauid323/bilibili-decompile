package kntr.watch.later.watchlater.viewmodel;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.data.WatchLaterState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchLaterViewModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "index", "", "pageState", "Lkntr/watch/later/watchlater/data/WatchLaterState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.watch.later.watchlater.viewmodel.WatchLaterViewModel$buttonClickable$1", f = "WatchLaterViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class WatchLaterViewModel$buttonClickable$1 extends SuspendLambda implements Function3<Integer, WatchLaterState, Continuation<? super Boolean>, Object> {
    /* synthetic */ int I$0;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WatchLaterViewModel$buttonClickable$1(Continuation<? super WatchLaterViewModel$buttonClickable$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(int i, WatchLaterState watchLaterState, Continuation<? super Boolean> continuation) {
        WatchLaterViewModel$buttonClickable$1 watchLaterViewModel$buttonClickable$1 = new WatchLaterViewModel$buttonClickable$1(continuation);
        watchLaterViewModel$buttonClickable$1.I$0 = i;
        watchLaterViewModel$buttonClickable$1.L$0 = watchLaterState;
        return watchLaterViewModel$buttonClickable$1.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Number) obj).intValue(), (WatchLaterState) obj2, (Continuation) obj3);
    }

    public final Object invokeSuspend(Object $result) {
        int index = this.I$0;
        WatchLaterState pageState = (WatchLaterState) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                boolean z = true;
                if ((index != 0 || pageState.getTabAll().getData().getList().isEmpty()) && (index != 1 || pageState.getTabToView().getData().getList().isEmpty())) {
                    z = false;
                }
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}