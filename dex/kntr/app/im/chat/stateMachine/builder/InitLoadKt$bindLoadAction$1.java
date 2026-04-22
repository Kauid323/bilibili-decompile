package kntr.app.im.chat.stateMachine.builder;

import kntr.app.im.chat.core.FetchMessageDirection;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.service.FusionFetchMessageService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InitLoad.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "<unused var>", "Lkntr/app/im/chat/core/model/ChatAction$RequestListPrevious;", "Lkntr/app/im/chat/core/model/ChatPageData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.InitLoadKt$bindLoadAction$1", f = "InitLoad.kt", i = {}, l = {170}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class InitLoadKt$bindLoadAction$1 extends SuspendLambda implements Function3<ChatAction.RequestListPrevious, ChatPageData, Continuation<? super Unit>, Object> {
    final /* synthetic */ FusionFetchMessageService $fetchMessagesService;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitLoadKt$bindLoadAction$1(FusionFetchMessageService fusionFetchMessageService, Continuation<? super InitLoadKt$bindLoadAction$1> continuation) {
        super(3, continuation);
        this.$fetchMessagesService = fusionFetchMessageService;
    }

    public final Object invoke(ChatAction.RequestListPrevious requestListPrevious, ChatPageData chatPageData, Continuation<? super Unit> continuation) {
        return new InitLoadKt$bindLoadAction$1(this.$fetchMessagesService, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.$fetchMessagesService.load(FetchMessageDirection.UP, (Continuation) this) == coroutine_suspended) {
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