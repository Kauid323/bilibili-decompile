package kntr.app.im.chat.network;

import com.bapis.bilibili.app.im.v1.KChatMoss;
import com.bapis.bilibili.app.im.v1.KDeleteMessageReply;
import com.bapis.bilibili.app.im.v1.KDeleteMessageReq;
import com.bapis.bilibili.app.im.v1.KRecallMessageReply;
import com.bapis.bilibili.app.im.v1.KRecallMessageReq;
import com.bapis.bilibili.app.im.v1.KSessionId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kntr.app.im.chat.core.model.MessageId;
import kntr.app.im.chat.core.service.OperateMessageService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;

/* compiled from: NetworkOperateMessageServiceImpl.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0011\u001a\u00020\rH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkntr/app/im/chat/network/NetworkOperateMessageServiceImpl;", "Lkntr/app/im/chat/core/service/OperateMessageService;", "sessionId", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "sendEvent", "Lkntr/app/im/chat/network/ChatSendEvent;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KSessionId;Lkntr/app/im/chat/network/ChatSendEvent;)V", "deleteMessage", "Lkotlin/Result;", RoomRecommendViewModel.EMPTY_CURSOR, "messageIds", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/MessageId;", "deleteMessage-gIAlu-s", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recallMessage", "messageId", "recallMessage-gIAlu-s", "(Lkntr/app/im/chat/core/model/MessageId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NetworkOperateMessageServiceImpl implements OperateMessageService {
    private final ChatSendEvent sendEvent;
    private final KSessionId sessionId;

    @Inject
    public NetworkOperateMessageServiceImpl(KSessionId sessionId, ChatSendEvent sendEvent) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        this.sessionId = sessionId;
        this.sendEvent = sendEvent;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c7  */
    @Override // kntr.app.im.chat.core.service.OperateMessageService
    /* renamed from: deleteMessage-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo1364deleteMessagegIAlus(List<MessageId> list, Continuation<? super Result<Unit>> continuation) {
        NetworkOperateMessageServiceImpl$deleteMessage$1 networkOperateMessageServiceImpl$deleteMessage$1;
        NetworkOperateMessageServiceImpl$deleteMessage$1 networkOperateMessageServiceImpl$deleteMessage$12;
        Object deleteMessage;
        Object obj;
        if (continuation instanceof NetworkOperateMessageServiceImpl$deleteMessage$1) {
            networkOperateMessageServiceImpl$deleteMessage$1 = (NetworkOperateMessageServiceImpl$deleteMessage$1) continuation;
            if ((networkOperateMessageServiceImpl$deleteMessage$1.label & Integer.MIN_VALUE) != 0) {
                networkOperateMessageServiceImpl$deleteMessage$1.label -= Integer.MIN_VALUE;
                networkOperateMessageServiceImpl$deleteMessage$12 = networkOperateMessageServiceImpl$deleteMessage$1;
                Object $result = networkOperateMessageServiceImpl$deleteMessage$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (networkOperateMessageServiceImpl$deleteMessage$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            Result.Companion companion = Result.Companion;
                            KChatMoss kChatMoss = new KChatMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                            KSessionId kSessionId = this.sessionId;
                            List<MessageId> $this$map$iv = list;
                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                MessageId it = (MessageId) item$iv$iv;
                                destination$iv$iv.add(it.asKMsgId());
                            }
                            KDeleteMessageReq kDeleteMessageReq = new KDeleteMessageReq(kSessionId, (List) destination$iv$iv);
                            networkOperateMessageServiceImpl$deleteMessage$12.L$0 = SpillingKt.nullOutSpilledVariable(list);
                            networkOperateMessageServiceImpl$deleteMessage$12.I$0 = 0;
                            networkOperateMessageServiceImpl$deleteMessage$12.I$1 = 0;
                            networkOperateMessageServiceImpl$deleteMessage$12.label = 1;
                            deleteMessage = kChatMoss.deleteMessage(kDeleteMessageReq, networkOperateMessageServiceImpl$deleteMessage$12);
                        } catch (Throwable th) {
                            th = th;
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            JobKt.ensureActive(networkOperateMessageServiceImpl$deleteMessage$12.getContext());
                            if (Result.isSuccess-impl(obj)) {
                            }
                            return Result.constructor-impl(obj);
                        }
                        if (deleteMessage == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = Result.constructor-impl((KDeleteMessageReply) deleteMessage);
                        JobKt.ensureActive(networkOperateMessageServiceImpl$deleteMessage$12.getContext());
                        if (Result.isSuccess-impl(obj)) {
                            Result.Companion companion3 = Result.Companion;
                            KDeleteMessageReply kDeleteMessageReply = (KDeleteMessageReply) obj;
                            obj = Unit.INSTANCE;
                        }
                        return Result.constructor-impl(obj);
                    case 1:
                        int i = networkOperateMessageServiceImpl$deleteMessage$12.I$1;
                        int i2 = networkOperateMessageServiceImpl$deleteMessage$12.I$0;
                        List list2 = (List) networkOperateMessageServiceImpl$deleteMessage$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            deleteMessage = $result;
                            obj = Result.constructor-impl((KDeleteMessageReply) deleteMessage);
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion22 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            JobKt.ensureActive(networkOperateMessageServiceImpl$deleteMessage$12.getContext());
                            if (Result.isSuccess-impl(obj)) {
                            }
                            return Result.constructor-impl(obj);
                        }
                        JobKt.ensureActive(networkOperateMessageServiceImpl$deleteMessage$12.getContext());
                        if (Result.isSuccess-impl(obj)) {
                        }
                        return Result.constructor-impl(obj);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        networkOperateMessageServiceImpl$deleteMessage$1 = new NetworkOperateMessageServiceImpl$deleteMessage$1(this, continuation);
        networkOperateMessageServiceImpl$deleteMessage$12 = networkOperateMessageServiceImpl$deleteMessage$1;
        Object $result2 = networkOperateMessageServiceImpl$deleteMessage$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (networkOperateMessageServiceImpl$deleteMessage$12.label) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:1|(2:3|(4:5|6|7|8))|36|6|7|8) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007b, code lost:
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007c, code lost:
        r5 = kotlin.Result.Companion;
        r3 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r3));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cf  */
    @Override // kntr.app.im.chat.core.service.OperateMessageService
    /* renamed from: recallMessage-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo1365recallMessagegIAlus(MessageId messageId, Continuation<? super Result<Unit>> continuation) {
        NetworkOperateMessageServiceImpl$recallMessage$1 networkOperateMessageServiceImpl$recallMessage$1;
        Object obj;
        int $i$f$runSuspendCatching;
        Object recallMessage;
        if (continuation instanceof NetworkOperateMessageServiceImpl$recallMessage$1) {
            networkOperateMessageServiceImpl$recallMessage$1 = (NetworkOperateMessageServiceImpl$recallMessage$1) continuation;
            if ((networkOperateMessageServiceImpl$recallMessage$1.label & Integer.MIN_VALUE) != 0) {
                networkOperateMessageServiceImpl$recallMessage$1.label -= Integer.MIN_VALUE;
                Object $result = networkOperateMessageServiceImpl$recallMessage$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (networkOperateMessageServiceImpl$recallMessage$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $i$f$runSuspendCatching = 0;
                        Result.Companion companion = Result.Companion;
                        KChatMoss kChatMoss = new KChatMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                        KRecallMessageReq kRecallMessageReq = new KRecallMessageReq(messageId.asKMsgId(), this.sessionId);
                        networkOperateMessageServiceImpl$recallMessage$1.L$0 = messageId;
                        networkOperateMessageServiceImpl$recallMessage$1.I$0 = 0;
                        networkOperateMessageServiceImpl$recallMessage$1.I$1 = 0;
                        networkOperateMessageServiceImpl$recallMessage$1.label = 1;
                        recallMessage = kChatMoss.recallMessage(kRecallMessageReq, networkOperateMessageServiceImpl$recallMessage$1);
                        if (recallMessage == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Object obj2 = Result.constructor-impl((KRecallMessageReply) recallMessage);
                        obj = obj2;
                        JobKt.ensureActive(networkOperateMessageServiceImpl$recallMessage$1.getContext());
                        if (Result.isSuccess-impl(obj)) {
                            KRecallMessageReply it = (KRecallMessageReply) obj;
                            ChatSendEvent chatSendEvent = this.sendEvent;
                            networkOperateMessageServiceImpl$recallMessage$1.L$0 = SpillingKt.nullOutSpilledVariable(messageId);
                            networkOperateMessageServiceImpl$recallMessage$1.L$1 = obj;
                            networkOperateMessageServiceImpl$recallMessage$1.L$2 = SpillingKt.nullOutSpilledVariable(it);
                            networkOperateMessageServiceImpl$recallMessage$1.I$0 = 0;
                            networkOperateMessageServiceImpl$recallMessage$1.label = 2;
                            if (chatSendEvent.notifyMessageRecalled(messageId, networkOperateMessageServiceImpl$recallMessage$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        if (Result.isSuccess-impl(obj)) {
                            Result.Companion companion2 = Result.Companion;
                            KRecallMessageReply kRecallMessageReply = (KRecallMessageReply) obj;
                            return Result.constructor-impl(Unit.INSTANCE);
                        }
                        return Result.constructor-impl(obj);
                    case 1:
                        int i = networkOperateMessageServiceImpl$recallMessage$1.I$1;
                        $i$f$runSuspendCatching = networkOperateMessageServiceImpl$recallMessage$1.I$0;
                        messageId = (MessageId) networkOperateMessageServiceImpl$recallMessage$1.L$0;
                        ResultKt.throwOnFailure($result);
                        recallMessage = $result;
                        Object obj22 = Result.constructor-impl((KRecallMessageReply) recallMessage);
                        obj = obj22;
                        JobKt.ensureActive(networkOperateMessageServiceImpl$recallMessage$1.getContext());
                        if (Result.isSuccess-impl(obj)) {
                        }
                        if (Result.isSuccess-impl(obj)) {
                        }
                        break;
                    case 2:
                        int i2 = networkOperateMessageServiceImpl$recallMessage$1.I$0;
                        KRecallMessageReply kRecallMessageReply2 = (KRecallMessageReply) networkOperateMessageServiceImpl$recallMessage$1.L$2;
                        obj = networkOperateMessageServiceImpl$recallMessage$1.L$1;
                        MessageId messageId2 = (MessageId) networkOperateMessageServiceImpl$recallMessage$1.L$0;
                        ResultKt.throwOnFailure($result);
                        if (Result.isSuccess-impl(obj)) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        networkOperateMessageServiceImpl$recallMessage$1 = new NetworkOperateMessageServiceImpl$recallMessage$1(this, continuation);
        Object $result2 = networkOperateMessageServiceImpl$recallMessage$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (networkOperateMessageServiceImpl$recallMessage$1.label) {
        }
    }
}