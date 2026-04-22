package kntr.watch.later.watchlater;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.viewmodel.WatchLaterViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatcherLaterScreen.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "index", ""}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.watch.later.watchlater.WatcherLaterScreenKt$WatchLaterScreen$2$9$1", f = "WatcherLaterScreen.kt", i = {0}, l = {153}, m = "invokeSuspend", n = {"index"}, s = {"I$0"}, v = 1)
public final class WatcherLaterScreenKt$WatchLaterScreen$2$9$1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    final /* synthetic */ WatchLaterViewModel $viewModel;
    /* synthetic */ int I$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatcherLaterScreenKt$WatchLaterScreen$2$9$1(WatchLaterViewModel watchLaterViewModel, Continuation<? super WatcherLaterScreenKt$WatchLaterScreen$2$9$1> continuation) {
        super(2, continuation);
        this.$viewModel = watchLaterViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> watcherLaterScreenKt$WatchLaterScreen$2$9$1 = new WatcherLaterScreenKt$WatchLaterScreen$2$9$1(this.$viewModel, continuation);
        watcherLaterScreenKt$WatchLaterScreen$2$9$1.I$0 = ((Number) obj).intValue();
        return watcherLaterScreenKt$WatchLaterScreen$2$9$1;
    }

    public final Object invoke(int i, Continuation<? super Unit> continuation) {
        return create(Integer.valueOf(i), continuation).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (Continuation) obj2);
    }

    public final Object invokeSuspend(Object $result) {
        int index = this.I$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.I$0 = index;
                this.label = 1;
                if (this.$viewModel.onTabClick(index, (Continuation) this) == coroutine_suspended) {
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