package kntr.watch.later.watchlater.viewmodel;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.data.WLAction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchLaterViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.watch.later.watchlater.viewmodel.WatchLaterViewModel$onAction$result$1$1", f = "WatchLaterViewModel.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class WatchLaterViewModel$onAction$result$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WLAction $action;
    int label;
    final /* synthetic */ WatchLaterViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchLaterViewModel$onAction$result$1$1(WatchLaterViewModel watchLaterViewModel, WLAction wLAction, Continuation<? super WatchLaterViewModel$onAction$result$1$1> continuation) {
        super(2, continuation);
        this.this$0 = watchLaterViewModel;
        this.$action = wLAction;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchLaterViewModel$onAction$result$1$1(this.this$0, this.$action, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object requestData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                requestData = this.this$0.requestData(((WLAction.LoadAction) this.$action).getPageIndex(), ((WLAction.LoadAction) this.$action).isLoadMore(), false, (Continuation) this);
                if (requestData == coroutine_suspended) {
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