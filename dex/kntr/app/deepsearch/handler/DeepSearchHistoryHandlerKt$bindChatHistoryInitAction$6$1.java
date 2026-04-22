package kntr.app.deepsearch.handler;

import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryReply;
import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryReq;
import com.bapis.bilibili.app.search.deepsearch.v1.KDeepSearchMoss;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchPageData;
import kntr.app.deepsearch.stateMachine.DeepSearchStateMachine;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeepSearchHistoryHandler.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "it", "Lkntr/app/deepsearch/base/model/biz/DeepSearchPageData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.handler.DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$6$1", f = "DeepSearchHistoryHandler.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {68, 69, 71}, m = "invokeSuspend", n = {"it", "req", "it", "req", "response", "it", "e"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1"}, v = 1)
public final class DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$6$1 extends SuspendLambda implements Function2<DeepSearchPageData, Continuation<? super Unit>, Object> {
    final /* synthetic */ DeepSearchStateMachine $machine;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$6$1(DeepSearchStateMachine deepSearchStateMachine, Continuation<? super DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$6$1> continuation) {
        super(2, continuation);
        this.$machine = deepSearchStateMachine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> deepSearchHistoryHandlerKt$bindChatHistoryInitAction$6$1 = new DeepSearchHistoryHandlerKt$bindChatHistoryInitAction$6$1(this.$machine, continuation);
        deepSearchHistoryHandlerKt$bindChatHistoryInitAction$6$1.L$0 = obj;
        return deepSearchHistoryHandlerKt$bindChatHistoryInitAction$6$1;
    }

    public final Object invoke(DeepSearchPageData deepSearchPageData, Continuation<? super Unit> continuation) {
        return create(deepSearchPageData, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x008a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        KChatHistoryReq req;
        Object chatHistory;
        DeepSearchPageData it = (DeepSearchPageData) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Exception e) {
            this.L$0 = SpillingKt.nullOutSpilledVariable(it);
            this.L$1 = SpillingKt.nullOutSpilledVariable(e);
            this.L$2 = null;
            this.label = 3;
            if (this.$machine.dispatch(new DeepSearchAction.ChatHistoryAction.UpdateList(null, e, 1, null), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                req = new KChatHistoryReq(it.getSessionId(), it.getHistoryCursor());
                this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                this.L$1 = SpillingKt.nullOutSpilledVariable(req);
                this.label = 1;
                chatHistory = new KDeepSearchMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).chatHistory(req, (Continuation) this);
                if (chatHistory == coroutine_suspended) {
                    return coroutine_suspended;
                }
                KChatHistoryReply response = (KChatHistoryReply) chatHistory;
                this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                this.L$1 = SpillingKt.nullOutSpilledVariable(req);
                this.L$2 = SpillingKt.nullOutSpilledVariable(response);
                this.label = 2;
                return this.$machine.dispatch(new DeepSearchAction.ChatHistoryAction.UpdateList(response, null, 2, null), (Continuation) this) != coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
            case 1:
                req = (KChatHistoryReq) this.L$1;
                ResultKt.throwOnFailure($result);
                chatHistory = $result;
                KChatHistoryReply response2 = (KChatHistoryReply) chatHistory;
                this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                this.L$1 = SpillingKt.nullOutSpilledVariable(req);
                this.L$2 = SpillingKt.nullOutSpilledVariable(response2);
                this.label = 2;
                if (this.$machine.dispatch(new DeepSearchAction.ChatHistoryAction.UpdateList(response2, null, 2, null), (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 2:
                KChatHistoryReply kChatHistoryReply = (KChatHistoryReply) this.L$2;
                KChatHistoryReq kChatHistoryReq = (KChatHistoryReq) this.L$1;
                ResultKt.throwOnFailure($result);
            case 3:
                Exception exc = (Exception) this.L$1;
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}