package kntr.app.tribee.publish;

import kntr.app.tribee.publish.TribeePublishAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.trio.toast.Toaster;
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
/* compiled from: TribeePublishPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.TribeePublishPageKt$TribeePublishPage$3$1", f = "TribeePublishPage.kt", i = {}, l = {306}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeePublishPageKt$TribeePublishPage$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<TribeePublishAction, Continuation<? super Unit>, Object> $onAction;
    final /* synthetic */ String $toast;
    final /* synthetic */ Toaster $toaster;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TribeePublishPageKt$TribeePublishPage$3$1(String str, Toaster toaster, Function2<? super TribeePublishAction, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super TribeePublishPageKt$TribeePublishPage$3$1> continuation) {
        super(2, continuation);
        this.$toast = str;
        this.$toaster = toaster;
        this.$onAction = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeePublishPageKt$TribeePublishPage$3$1(this.$toast, this.$toaster, this.$onAction, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String str = this.$toast;
                if (!(str == null || StringsKt.isBlank(str))) {
                    Toaster.CC.showToast$default(this.$toaster, this.$toast, null, 2, null);
                    Function2<TribeePublishAction, Continuation<? super Unit>, Object> function2 = this.$onAction;
                    TribeePublishAction.ConsumeToast consumeToast = TribeePublishAction.ConsumeToast.INSTANCE;
                    this.label = 1;
                    if (function2.invoke(consumeToast, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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