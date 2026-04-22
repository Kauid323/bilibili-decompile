package kntr.watch.later.watchlater.compose;

import androidx.compose.runtime.ProduceStateScope;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.data.WatchLaterItem;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: WatchLaterCard.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/ProduceStateScope;", ""}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.watch.later.watchlater.compose.WatchLaterCardKt$WatchLaterCard$displayTitle$1$1", f = "WatchLaterCard.kt", i = {0}, l = {58}, m = "invokeSuspend", n = {"$this$produceState"}, s = {"L$0"}, v = 1)
final class WatchLaterCardKt$WatchLaterCard$displayTitle$1$1 extends SuspendLambda implements Function2<ProduceStateScope<String>, Continuation<? super Unit>, Object> {
    final /* synthetic */ WatchLaterItem $item;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchLaterCardKt$WatchLaterCard$displayTitle$1$1(WatchLaterItem watchLaterItem, Continuation<? super WatchLaterCardKt$WatchLaterCard$displayTitle$1$1> continuation) {
        super(2, continuation);
        this.$item = watchLaterItem;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> watchLaterCardKt$WatchLaterCard$displayTitle$1$1 = new WatchLaterCardKt$WatchLaterCard$displayTitle$1$1(this.$item, continuation);
        watchLaterCardKt$WatchLaterCard$displayTitle$1$1.L$0 = obj;
        return watchLaterCardKt$WatchLaterCard$displayTitle$1$1;
    }

    public final Object invoke(ProduceStateScope<String> produceStateScope, Continuation<? super Unit> continuation) {
        return create(produceStateScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final ProduceStateScope $this$produceState = (ProduceStateScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                WatchLaterItem watchLaterItem = this.$item;
                final WatchLaterItem watchLaterItem2 = this.$item;
                watchLaterItem.setOnTranslateStateChagne(new Function0() { // from class: kntr.watch.later.watchlater.compose.WatchLaterCardKt$WatchLaterCard$displayTitle$1$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = WatchLaterCardKt$WatchLaterCard$displayTitle$1$1.invokeSuspend$lambda$0($this$produceState, watchLaterItem2);
                        return invokeSuspend$lambda$0;
                    }
                });
                final WatchLaterItem watchLaterItem3 = this.$item;
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$produceState);
                this.label = 1;
                if ($this$produceState.awaitDispose(new Function0() { // from class: kntr.watch.later.watchlater.compose.WatchLaterCardKt$WatchLaterCard$displayTitle$1$1$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = WatchLaterCardKt$WatchLaterCard$displayTitle$1$1.invokeSuspend$lambda$1(WatchLaterItem.this);
                        return invokeSuspend$lambda$1;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(ProduceStateScope $$this$produceState, WatchLaterItem $item) {
        String displayTitle = $item.getDisplayTitle();
        if (displayTitle == null) {
            displayTitle = "";
        }
        $$this$produceState.setValue(displayTitle);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(WatchLaterItem $item) {
        $item.setOnTranslateStateChagne(null);
        return Unit.INSTANCE;
    }
}