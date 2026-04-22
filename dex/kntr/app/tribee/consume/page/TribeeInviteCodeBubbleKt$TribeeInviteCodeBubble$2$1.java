package kntr.app.tribee.consume.page;

import androidx.compose.runtime.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeeInviteCodeBubble.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.consume.page.TribeeInviteCodeBubbleKt$TribeeInviteCodeBubble$2$1", f = "TribeeInviteCodeBubble.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeeInviteCodeBubbleKt$TribeeInviteCodeBubble$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function0<Unit>> $currentOnDismiss$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeeInviteCodeBubbleKt$TribeeInviteCodeBubble$2$1(State<? extends Function0<Unit>> state, Continuation<? super TribeeInviteCodeBubbleKt$TribeeInviteCodeBubble$2$1> continuation) {
        super(2, continuation);
        this.$currentOnDismiss$delegate = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeInviteCodeBubbleKt$TribeeInviteCodeBubble$2$1(this.$currentOnDismiss$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Function0 TribeeInviteCodeBubble$lambda$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (DelayKt.delay(3000L, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        TribeeInviteCodeBubble$lambda$0 = TribeeInviteCodeBubbleKt.TribeeInviteCodeBubble$lambda$0(this.$currentOnDismiss$delegate);
        TribeeInviteCodeBubble$lambda$0.invoke();
        return Unit.INSTANCE;
    }
}