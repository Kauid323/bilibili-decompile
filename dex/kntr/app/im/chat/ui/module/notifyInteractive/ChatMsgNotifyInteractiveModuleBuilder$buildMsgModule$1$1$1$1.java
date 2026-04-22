package kntr.app.im.chat.ui.module.notifyInteractive;

import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.module.NotifyInteractiveMsgModule;
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
/* compiled from: ChatMsgNotifyInteractiveModuleBuilder.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.module.notifyInteractive.ChatMsgNotifyInteractiveModuleBuilder$buildMsgModule$1$1$1$1", f = "ChatMsgNotifyInteractiveModuleBuilder.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ChatMsgNotifyInteractiveModuleBuilder$buildMsgModule$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NotifyInteractiveMsgModule $msgModule;
    int label;
    final /* synthetic */ ChatMsgNotifyInteractiveModuleBuilder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatMsgNotifyInteractiveModuleBuilder$buildMsgModule$1$1$1$1(ChatMsgNotifyInteractiveModuleBuilder chatMsgNotifyInteractiveModuleBuilder, NotifyInteractiveMsgModule notifyInteractiveMsgModule, Continuation<? super ChatMsgNotifyInteractiveModuleBuilder$buildMsgModule$1$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = chatMsgNotifyInteractiveModuleBuilder;
        this.$msgModule = notifyInteractiveMsgModule;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChatMsgNotifyInteractiveModuleBuilder$buildMsgModule$1$1$1$1(this.this$0, this.$msgModule, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ChatActionHandler chatActionHandler;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                chatActionHandler = this.this$0.chatActionHandler;
                this.label = 1;
                if (chatActionHandler.invoke(new ChatAction.RouteTo(this.$msgModule.getValue().getUrl()), (Continuation) this) == coroutine_suspended) {
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