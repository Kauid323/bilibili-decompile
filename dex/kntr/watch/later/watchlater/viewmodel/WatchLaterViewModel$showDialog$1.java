package kntr.watch.later.watchlater.viewmodel;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.data.DialogType;
import kntr.watch.later.watchlater.data.WLEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchLaterViewModel.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lkntr/watch/later/watchlater/data/WLEvent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.watch.later.watchlater.viewmodel.WatchLaterViewModel$showDialog$1", f = "WatchLaterViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class WatchLaterViewModel$showDialog$1 extends SuspendLambda implements Function1<Continuation<? super WLEvent>, Object> {
    final /* synthetic */ DialogType $dialogType;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchLaterViewModel$showDialog$1(DialogType dialogType, Continuation<? super WatchLaterViewModel$showDialog$1> continuation) {
        super(1, continuation);
        this.$dialogType = dialogType;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new WatchLaterViewModel$showDialog$1(this.$dialogType, continuation);
    }

    public final Object invoke(Continuation<? super WLEvent> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return new WLEvent.ShowDeleteDialog(this.$dialogType);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}