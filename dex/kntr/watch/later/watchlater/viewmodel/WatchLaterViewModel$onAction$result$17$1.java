package kntr.watch.later.watchlater.viewmodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.data.WLAction;
import kntr.watch.later.watchlater.data.WatchLaterItem;
import kntr.watch.later.watchlater.data.WatchLaterState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchLaterViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.watch.later.watchlater.viewmodel.WatchLaterViewModel$onAction$result$17$1", f = "WatchLaterViewModel.kt", i = {0}, l = {569}, m = "invokeSuspend", n = {"deleteList"}, s = {"L$0"}, v = 1)
public final class WatchLaterViewModel$onAction$result$17$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WLAction $action;
    final /* synthetic */ WatchLaterState $state;
    Object L$0;
    int label;
    final /* synthetic */ WatchLaterViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchLaterViewModel$onAction$result$17$1(WatchLaterViewModel watchLaterViewModel, WatchLaterState watchLaterState, WLAction wLAction, Continuation<? super WatchLaterViewModel$onAction$result$17$1> continuation) {
        super(2, continuation);
        this.this$0 = watchLaterViewModel;
        this.$state = watchLaterState;
        this.$action = wLAction;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchLaterViewModel$onAction$result$17$1(this.this$0, this.$state, this.$action, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        List list;
        Object deleteVideos;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (((Number) this.this$0.curPageIndex.getValue()).intValue() == 0) {
                    Iterable $this$filter$iv = this.$state.getTabAll().getData().getList();
                    WLAction wLAction = this.$action;
                    Collection destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        WatchLaterItem it = (WatchLaterItem) element$iv$iv;
                        WatchLaterItem it2 = it.getAid() == ((WLAction.DeleteItem) wLAction).getAid() ? 1 : null;
                        if (it2 != null) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                    }
                    list = (List) destination$iv$iv;
                } else {
                    Iterable $this$filter$iv2 = this.$state.getTabToView().getData().getList();
                    WLAction wLAction2 = this.$action;
                    Collection destination$iv$iv2 = new ArrayList();
                    for (Object element$iv$iv2 : $this$filter$iv2) {
                        WatchLaterItem it3 = (WatchLaterItem) element$iv$iv2;
                        if (it3.getAid() == ((WLAction.DeleteItem) wLAction2).getAid()) {
                            destination$iv$iv2.add(element$iv$iv2);
                        }
                    }
                    list = (List) destination$iv$iv2;
                }
                List deleteList = list;
                this.L$0 = SpillingKt.nullOutSpilledVariable(deleteList);
                this.label = 1;
                deleteVideos = this.this$0.deleteVideos(WatchLaterViewModelKt.toResourceString(deleteList), (Continuation) this);
                if (deleteVideos != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                List list2 = (List) this.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}