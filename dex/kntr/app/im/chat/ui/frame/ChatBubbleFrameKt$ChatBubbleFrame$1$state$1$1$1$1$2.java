package kntr.app.im.chat.ui.frame;

import com.bapis.bilibili.app.dynamic.v2.KTextNode;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.ui.ChatActionHandler;
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
/* compiled from: ChatBubbleFrame.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.frame.ChatBubbleFrameKt$ChatBubbleFrame$1$state$1$1$1$1$2", f = "ChatBubbleFrame.kt", i = {}, l = {246}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ChatBubbleFrameKt$ChatBubbleFrame$1$state$1$1$1$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChatActionHandler $actionHandler;
    final /* synthetic */ KTextNode.KLink $node;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatBubbleFrameKt$ChatBubbleFrame$1$state$1$1$1$1$2(ChatActionHandler chatActionHandler, KTextNode.KLink kLink, Continuation<? super ChatBubbleFrameKt$ChatBubbleFrame$1$state$1$1$1$1$2> continuation) {
        super(2, continuation);
        this.$actionHandler = chatActionHandler;
        this.$node = kLink;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChatBubbleFrameKt$ChatBubbleFrame$1$state$1$1$1$1$2(this.$actionHandler, this.$node, continuation);
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
                if (this.$actionHandler.invoke(new ChatAction.RouteTo(this.$node.getValue().getLink()), (Continuation) this) == coroutine_suspended) {
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