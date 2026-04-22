package kntr.app.im.chat.network;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import im.base.config.IMConfigSetting;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatLoopFetchService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.network.ChatLoopFetchService$flow$1", f = "ChatLoopFetchService.kt", i = {0, 1}, l = {AdditionVote2.ONLY_FANS_VOTE_FIELD_NUMBER, AdditionVote2.VOTE_OWNER_MID_FIELD_NUMBER}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"}, v = 1)
public final class ChatLoopFetchService$flow$1 extends SuspendLambda implements Function2<FlowCollector<? super Unit>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChatLoopFetchService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatLoopFetchService$flow$1(ChatLoopFetchService chatLoopFetchService, Continuation<? super ChatLoopFetchService$flow$1> continuation) {
        super(2, continuation);
        this.this$0 = chatLoopFetchService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> chatLoopFetchService$flow$1 = new ChatLoopFetchService$flow$1(this.this$0, continuation);
        chatLoopFetchService$flow$1.L$0 = obj;
        return chatLoopFetchService$flow$1;
    }

    public final Object invoke(FlowCollector<? super Unit> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0057 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0059  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0055 -> B:9:0x0023). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        ChatLoopFetchService$flow$1 chatLoopFetchService$flow$1;
        IMConfigSetting iMConfigSetting;
        FlowCollector $this$flow = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                chatLoopFetchService$flow$1 = this;
                if (!JobKt.isActive(chatLoopFetchService$flow$1.getContext())) {
                    iMConfigSetting = chatLoopFetchService$flow$1.this$0.setting;
                    chatLoopFetchService$flow$1.L$0 = $this$flow;
                    chatLoopFetchService$flow$1.label = 1;
                    if (DelayKt.delay-VtjQ1oo(iMConfigSetting.getChatLoopFetchDuration-UwyO8pc(), (Continuation) chatLoopFetchService$flow$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    chatLoopFetchService$flow$1.L$0 = $this$flow;
                    chatLoopFetchService$flow$1.label = 2;
                    if ($this$flow.emit(Unit.INSTANCE, (Continuation) chatLoopFetchService$flow$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (!JobKt.isActive(chatLoopFetchService$flow$1.getContext())) {
                        return Unit.INSTANCE;
                    }
                }
            case 1:
                ResultKt.throwOnFailure($result);
                chatLoopFetchService$flow$1 = this;
                chatLoopFetchService$flow$1.L$0 = $this$flow;
                chatLoopFetchService$flow$1.label = 2;
                if ($this$flow.emit(Unit.INSTANCE, (Continuation) chatLoopFetchService$flow$1) == coroutine_suspended) {
                }
                if (!JobKt.isActive(chatLoopFetchService$flow$1.getContext())) {
                }
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                chatLoopFetchService$flow$1 = this;
                if (!JobKt.isActive(chatLoopFetchService$flow$1.getContext())) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}