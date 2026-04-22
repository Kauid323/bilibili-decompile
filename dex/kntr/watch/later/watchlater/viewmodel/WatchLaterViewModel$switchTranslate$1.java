package kntr.watch.later.watchlater.viewmodel;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.watch.later.watchlater.api.TranslateApiKt;
import kntr.watch.later.watchlater.data.WatchLaterItem;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchLaterViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.watch.later.watchlater.viewmodel.WatchLaterViewModel$switchTranslate$1", f = "WatchLaterViewModel.kt", i = {}, l = {681}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class WatchLaterViewModel$switchTranslate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WatchLaterItem $item;
    int label;
    final /* synthetic */ WatchLaterViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchLaterViewModel$switchTranslate$1(WatchLaterViewModel watchLaterViewModel, WatchLaterItem watchLaterItem, Continuation<? super WatchLaterViewModel$switchTranslate$1> continuation) {
        super(2, continuation);
        this.this$0 = watchLaterViewModel;
        this.$item = watchLaterItem;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchLaterViewModel$switchTranslate$1(this.this$0, this.$item, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
        r9.this$0.updateItemTranslateState(r9.$item, 2, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object translateArcTitle;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    WatchLaterViewModel.updateItemTranslateState$default(this.this$0, this.$item, 10, null, 4, null);
                    this.label = 1;
                    translateArcTitle = TranslateApiKt.translateArcTitle(this.$item, (Continuation) this);
                    if (translateArcTitle == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    translateArcTitle = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String translateResult = (String) translateArcTitle;
            String str = translateResult;
            if (str != null && !StringsKt.isBlank(str)) {
                z = false;
            }
            throw new IllegalStateException("Check failed.");
        } catch (Exception e) {
            WatchLaterViewModel.updateItemTranslateState$default(this.this$0, this.$item, 1, null, 4, null);
            KLog_androidKt.getKLog().e("WatchLaterViewModel", "translate failed", e);
        }
        return Unit.INSTANCE;
    }
}