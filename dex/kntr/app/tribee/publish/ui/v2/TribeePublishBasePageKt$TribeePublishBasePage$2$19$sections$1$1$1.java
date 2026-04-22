package kntr.app.tribee.publish.ui.v2;

import androidx.compose.runtime.State;
import kntr.app.tribee.publish.core.v2.TribeePublishAction;
import kntr.app.upcomingEpisode.ConstantsKt;
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
/* compiled from: TribeePublishBasePage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.ui.v2.TribeePublishBasePageKt$TribeePublishBasePage$2$19$sections$1$1$1", f = "TribeePublishBasePage.kt", i = {}, l = {459}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeePublishBasePageKt$TribeePublishBasePage$2$19$sections$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function2<TribeePublishAction, Continuation<? super Unit>, Object>> $handleAction$delegate;
    final /* synthetic */ TribeePublishAction $it;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeePublishBasePageKt$TribeePublishBasePage$2$19$sections$1$1$1(TribeePublishAction tribeePublishAction, State<? extends Function2<? super TribeePublishAction, ? super Continuation<? super Unit>, ? extends Object>> state, Continuation<? super TribeePublishBasePageKt$TribeePublishBasePage$2$19$sections$1$1$1> continuation) {
        super(2, continuation);
        this.$it = tribeePublishAction;
        this.$handleAction$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeePublishBasePageKt$TribeePublishBasePage$2$19$sections$1$1$1(this.$it, this.$handleAction$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Function2 TribeePublishBasePage$lambda$5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                TribeePublishBasePage$lambda$5 = TribeePublishBasePageKt.TribeePublishBasePage$lambda$5(this.$handleAction$delegate);
                TribeePublishAction tribeePublishAction = this.$it;
                this.label = 1;
                if (TribeePublishBasePage$lambda$5.invoke(tribeePublishAction, this) == coroutine_suspended) {
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