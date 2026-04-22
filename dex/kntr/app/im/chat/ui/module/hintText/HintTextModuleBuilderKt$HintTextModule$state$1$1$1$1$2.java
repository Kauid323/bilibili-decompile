package kntr.app.im.chat.ui.module.hintText;

import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.MessageSequence;
import kntr.app.im.chat.module.notifyText.HintTextModule;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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
import kotlinx.datetime.Instant;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HintTextModuleBuilder.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.module.hintText.HintTextModuleBuilderKt$HintTextModule$state$1$1$1$1$2", f = "HintTextModuleBuilder.kt", i = {0, 0}, l = {96}, m = "invokeSuspend", n = {"seq", "ts"}, s = {"L$0", "L$1"}, v = 1)
public final class HintTextModuleBuilderKt$HintTextModule$state$1$1$1$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChatActionHandler $actionHandler;
    final /* synthetic */ HintTextModule $module;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HintTextModuleBuilderKt$HintTextModule$state$1$1$1$1$2(HintTextModule hintTextModule, ChatActionHandler chatActionHandler, Continuation<? super HintTextModuleBuilderKt$HintTextModule$state$1$1$1$1$2> continuation) {
        super(2, continuation);
        this.$module = hintTextModule;
        this.$actionHandler = chatActionHandler;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HintTextModuleBuilderKt$HintTextModule$state$1$1$1$1$2(this.$module, this.$actionHandler, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Instant ts;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                MessageSequence seq = this.$module.getRelatedMessage();
                Instant ts2 = this.$module.getRelatedTimeStamp();
                if (seq != null && ts2 != null) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(seq);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(ts2);
                    this.label = 1;
                    if (this.$actionHandler.invoke(new ChatAction.ShowPhaseTwoPushMessage(seq, ts2), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ts = ts2;
                    break;
                }
                break;
            case 1:
                ts = (Instant) this.L$1;
                MessageSequence messageSequence = (MessageSequence) this.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}