package kntr.app.im.chat.stateMachine.builder.send;

import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.service.MessageSendService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InputBoxAction.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "it", "Lkntr/app/im/chat/core/model/ChatPageData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.send.InputBoxActionKt$bindInputBoxAction$1", f = "InputBoxAction.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class InputBoxActionKt$bindInputBoxAction$1 extends SuspendLambda implements Function2<ChatPageData, Continuation<? super Unit>, Object> {
    final /* synthetic */ MessageSendService $sendMessageService;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputBoxActionKt$bindInputBoxAction$1(MessageSendService messageSendService, Continuation<? super InputBoxActionKt$bindInputBoxAction$1> continuation) {
        super(2, continuation);
        this.$sendMessageService = messageSendService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InputBoxActionKt$bindInputBoxAction$1(this.$sendMessageService, continuation);
    }

    public final Object invoke(ChatPageData chatPageData, Continuation<? super Unit> continuation) {
        return create(chatPageData, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.$sendMessageService.start((Continuation) this) == coroutine_suspended) {
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