package kntr.app.im.chat.ui.frame;

import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.frame.push.PushEmptyFrame;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.im.chat.ui.neuron.ChatReporter;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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
/* compiled from: PushEmptyFrame.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.frame.PushEmptyFrameKt$PushEmptyFrame$1$1$2$1", f = "PushEmptyFrame.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PushEmptyFrameKt$PushEmptyFrame$1$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChatActionHandler $actionHandler;
    final /* synthetic */ PushEmptyFrame $empty;
    final /* synthetic */ EntityMessage $message;
    final /* synthetic */ ChatReporter $reporter;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushEmptyFrameKt$PushEmptyFrame$1$1$2$1(ChatActionHandler chatActionHandler, PushEmptyFrame pushEmptyFrame, ChatReporter chatReporter, EntityMessage entityMessage, Continuation<? super PushEmptyFrameKt$PushEmptyFrame$1$1$2$1> continuation) {
        super(2, continuation);
        this.$actionHandler = chatActionHandler;
        this.$empty = pushEmptyFrame;
        this.$reporter = chatReporter;
        this.$message = entityMessage;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PushEmptyFrameKt$PushEmptyFrame$1$1$2$1(this.$actionHandler, this.$empty, this.$reporter, this.$message, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.$actionHandler.invoke(new ChatAction.RouteTo(this.$empty.getValue().getUrl()), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ChatReporter chatReporter = this.$reporter;
        if (chatReporter != null) {
            chatReporter.reportMsgClick("msg", this.$message.getTraceParams());
        }
        return Unit.INSTANCE;
    }
}