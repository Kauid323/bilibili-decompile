package kntr.watch.later.watchlater.viewmodel;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.data.WLEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchLaterBaseViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.watch.later.watchlater.viewmodel.WatchLaterBaseViewModel$emitEvent$1", f = "WatchLaterBaseViewModel.kt", i = {1, 1}, l = {34, 35}, m = "invokeSuspend", n = {"it", "$i$a$-let-WatchLaterBaseViewModel$emitEvent$1$1"}, s = {"L$0", "I$0"}, v = 1)
public final class WatchLaterBaseViewModel$emitEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super WLEvent>, Object> $builder;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ WatchLaterBaseViewModel<S> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchLaterBaseViewModel$emitEvent$1(Function1<? super Continuation<? super WLEvent>, ? extends Object> function1, WatchLaterBaseViewModel<S> watchLaterBaseViewModel, Continuation<? super WatchLaterBaseViewModel$emitEvent$1> continuation) {
        super(2, continuation);
        this.$builder = function1;
        this.this$0 = watchLaterBaseViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchLaterBaseViewModel$emitEvent$1(this.$builder, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object invoke;
        WLEvent it;
        MutableSharedFlow mutableSharedFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function1<Continuation<? super WLEvent>, Object> function1 = this.$builder;
                this.label = 1;
                invoke = function1.invoke(this);
                if (invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                it = (WLEvent) invoke;
                if (it != null) {
                    mutableSharedFlow = ((WatchLaterBaseViewModel) this.this$0)._event;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.I$0 = 0;
                    this.label = 2;
                    if (mutableSharedFlow.emit(it, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                invoke = $result;
                it = (WLEvent) invoke;
                if (it != null) {
                }
                return Unit.INSTANCE;
            case 2:
                int i = this.I$0;
                WLEvent wLEvent = (WLEvent) this.L$0;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}