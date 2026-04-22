package kntr.app.im.chat.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.FetchMessagesData;
import kntr.app.im.chat.core.model.SendStatus;
import kntr.app.im.chat.core.service.MessageSendService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FetchMessagesWithSendingProgressService.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "state", "Lkntr/app/im/chat/core/model/FetchMessagesData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.FetchMessagesWithSendingProgressService$bindSendingProgress$6$2$1", f = "FetchMessagesWithSendingProgressService.kt", i = {0, 0, 0, 0}, l = {452}, m = "invokeSuspend", n = {"state", "sendingTokens", "finishedTokens", "errorTokens"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
public final class FetchMessagesWithSendingProgressService$bindSendingProgress$6$2$1 extends SuspendLambda implements Function2<FetchMessagesData, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ FetchMessagesWithSendingProgressService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FetchMessagesWithSendingProgressService$bindSendingProgress$6$2$1(FetchMessagesWithSendingProgressService fetchMessagesWithSendingProgressService, Continuation<? super FetchMessagesWithSendingProgressService$bindSendingProgress$6$2$1> continuation) {
        super(2, continuation);
        this.this$0 = fetchMessagesWithSendingProgressService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> fetchMessagesWithSendingProgressService$bindSendingProgress$6$2$1 = new FetchMessagesWithSendingProgressService$bindSendingProgress$6$2$1(this.this$0, continuation);
        fetchMessagesWithSendingProgressService$bindSendingProgress$6$2$1.L$0 = obj;
        return fetchMessagesWithSendingProgressService$bindSendingProgress$6$2$1;
    }

    public final Object invoke(FetchMessagesData fetchMessagesData, Continuation<? super Unit> continuation) {
        return create(fetchMessagesData, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        MessageSendService messageSendService;
        Iterable $this$mapNotNull$iv;
        FetchMessagesData state = (FetchMessagesData) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterable $this$mapNotNull$iv2 = state.getMessages().getSendingMessages();
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv2) {
                    EntityMessage msg = (EntityMessage) element$iv$iv$iv;
                    String token = msg.getToken();
                    if (token != null) {
                        destination$iv$iv.add(token);
                    }
                }
                Set sendingTokens = CollectionsKt.toSet((List) destination$iv$iv);
                Iterable $this$mapNotNull$iv3 = state.getMessages().getEntityMessages();
                Collection destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv$iv2 : $this$mapNotNull$iv3) {
                    EntityMessage it = (EntityMessage) element$iv$iv$iv2;
                    String token2 = it.getToken();
                    if (token2 != null) {
                        destination$iv$iv2.add(token2);
                    }
                }
                Iterable $this$filter$iv = (List) destination$iv$iv2;
                Collection destination$iv$iv3 = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    String it2 = (String) element$iv$iv;
                    if (sendingTokens.contains(it2)) {
                        destination$iv$iv3.add(element$iv$iv);
                    }
                }
                Set finishedTokens = CollectionsKt.toSet((List) destination$iv$iv3);
                Iterable $this$filter$iv2 = state.getMessages().getSendingMessages();
                Collection destination$iv$iv4 = new ArrayList();
                for (Object element$iv$iv2 : $this$filter$iv2) {
                    EntityMessage it3 = (EntityMessage) element$iv$iv2;
                    if (it3.getSendStatus() == SendStatus.Failure) {
                        destination$iv$iv4.add(element$iv$iv2);
                    }
                }
                Iterable $this$mapNotNull$iv4 = (List) destination$iv$iv4;
                Collection destination$iv$iv5 = new ArrayList();
                for (Object element$iv$iv$iv3 : $this$mapNotNull$iv4) {
                    EntityMessage it4 = (EntityMessage) element$iv$iv$iv3;
                    String token3 = it4.getToken();
                    if (token3 != null) {
                        $this$mapNotNull$iv = $this$mapNotNull$iv4;
                        destination$iv$iv5.add(token3);
                    } else {
                        $this$mapNotNull$iv = $this$mapNotNull$iv4;
                    }
                    $this$mapNotNull$iv4 = $this$mapNotNull$iv;
                }
                Set errorTokens = CollectionsKt.toSet((List) destination$iv$iv5);
                messageSendService = this.this$0.sendService;
                this.L$0 = SpillingKt.nullOutSpilledVariable(state);
                this.L$1 = SpillingKt.nullOutSpilledVariable(sendingTokens);
                this.L$2 = SpillingKt.nullOutSpilledVariable(finishedTokens);
                this.L$3 = SpillingKt.nullOutSpilledVariable(errorTokens);
                this.label = 1;
                if (messageSendService.consumeResult(SetsKt.plus(finishedTokens, errorTokens), (Continuation) this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                Set set = (Set) this.L$3;
                Set set2 = (Set) this.L$2;
                Set set3 = (Set) this.L$1;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}