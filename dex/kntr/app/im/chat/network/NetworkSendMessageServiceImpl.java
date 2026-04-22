package kntr.app.im.chat.network;

import com.bapis.bilibili.app.im.v1.KChatMoss;
import com.bapis.bilibili.app.im.v1.KEntityMsg;
import com.bapis.bilibili.app.im.v1.KSendMessageReply;
import com.bapis.bilibili.app.im.v1.KSendMessageReq;
import com.bapis.bilibili.app.im.v1.KSessionId;
import im.base.model.SessionId;
import javax.inject.Inject;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.service.NetworkSendMessageService;
import kntr.app.im.chat.network.util.ModelTransformKt;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;

/* compiled from: NetworkSendMessageServiceImpl.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\fH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/app/im/chat/network/NetworkSendMessageServiceImpl;", "Lkntr/app/im/chat/core/service/NetworkSendMessageService;", "sessionId", "Lim/base/model/SessionId;", "kSessionId", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "transformers", "Lkntr/app/im/chat/network/MsgFrameTransformers;", "<init>", "(Lim/base/model/SessionId;Lcom/bapis/bilibili/app/im/v1/KSessionId;Lkntr/app/im/chat/network/MsgFrameTransformers;)V", "send", "Lkotlin/Result;", "Lkntr/app/im/chat/core/model/EntityMessage;", "message", "send-gIAlu-s", "(Lkntr/app/im/chat/core/model/EntityMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NetworkSendMessageServiceImpl implements NetworkSendMessageService {
    private final KSessionId kSessionId;
    private final SessionId sessionId;
    private final MsgFrameTransformers transformers;

    @Inject
    public NetworkSendMessageServiceImpl(SessionId sessionId, KSessionId kSessionId, MsgFrameTransformers transformers) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(kSessionId, "kSessionId");
        Intrinsics.checkNotNullParameter(transformers, "transformers");
        this.sessionId = sessionId;
        this.kSessionId = kSessionId;
        this.transformers = transformers;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(7:5|6|7|8|15|16|(4:20|21|(1:23)(1:29)|(2:25|26)(2:27|28))(2:18|19)))|41|6|7|8|15|16|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008c, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008d, code lost:
        r5 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // kntr.app.im.chat.core.service.NetworkSendMessageService
    /* renamed from: send-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo1362sendgIAlus(EntityMessage message, Continuation<? super Result<EntityMessage>> continuation) {
        NetworkSendMessageServiceImpl$send$1 networkSendMessageServiceImpl$send$1;
        Object obj;
        Object sendMessage;
        if (continuation instanceof NetworkSendMessageServiceImpl$send$1) {
            networkSendMessageServiceImpl$send$1 = (NetworkSendMessageServiceImpl$send$1) continuation;
            if ((networkSendMessageServiceImpl$send$1.label & Integer.MIN_VALUE) != 0) {
                networkSendMessageServiceImpl$send$1.label -= Integer.MIN_VALUE;
                Object $result = networkSendMessageServiceImpl$send$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                boolean z = true;
                switch (networkSendMessageServiceImpl$send$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Result.Companion companion = Result.Companion;
                        KEntityMsg entityMsg = ModelTransformKt.asKEntityMsg(message, this.transformers);
                        KSendMessageReq req = new KSendMessageReq(this.kSessionId, entityMsg, (String) null, 4, (DefaultConstructorMarker) null);
                        KChatMoss kChatMoss = new KChatMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                        networkSendMessageServiceImpl$send$1.L$0 = SpillingKt.nullOutSpilledVariable(message);
                        networkSendMessageServiceImpl$send$1.L$1 = SpillingKt.nullOutSpilledVariable(entityMsg);
                        networkSendMessageServiceImpl$send$1.L$2 = SpillingKt.nullOutSpilledVariable(req);
                        networkSendMessageServiceImpl$send$1.I$0 = 0;
                        networkSendMessageServiceImpl$send$1.I$1 = 0;
                        networkSendMessageServiceImpl$send$1.label = 1;
                        sendMessage = kChatMoss.sendMessage(req, networkSendMessageServiceImpl$send$1);
                        if (sendMessage != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i = networkSendMessageServiceImpl$send$1.I$1;
                        int i2 = networkSendMessageServiceImpl$send$1.I$0;
                        KSendMessageReq kSendMessageReq = (KSendMessageReq) networkSendMessageServiceImpl$send$1.L$2;
                        KEntityMsg kEntityMsg = (KEntityMsg) networkSendMessageServiceImpl$send$1.L$1;
                        EntityMessage entityMessage = (EntityMessage) networkSendMessageServiceImpl$send$1.L$0;
                        ResultKt.throwOnFailure($result);
                        sendMessage = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = Result.constructor-impl((KSendMessageReply) sendMessage);
                JobKt.ensureActive(networkSendMessageServiceImpl$send$1.getContext());
                if (Result.isSuccess-impl(obj)) {
                    return Result.constructor-impl(obj);
                }
                try {
                    Result.Companion companion2 = Result.Companion;
                    KSendMessageReply it = (KSendMessageReply) obj;
                    KEntityMsg msg = it.getMsg();
                    if (msg == null) {
                        z = false;
                    }
                    if (z) {
                        return Result.constructor-impl(ModelTransformKt.asEntityMessage(msg, this.sessionId, this.transformers));
                    }
                    throw new IllegalArgumentException("msg is null".toString());
                } catch (Throwable th) {
                    Result.Companion companion3 = Result.Companion;
                    return Result.constructor-impl(ResultKt.createFailure(th));
                }
            }
        }
        networkSendMessageServiceImpl$send$1 = new NetworkSendMessageServiceImpl$send$1(this, continuation);
        Object $result2 = networkSendMessageServiceImpl$send$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z2 = true;
        switch (networkSendMessageServiceImpl$send$1.label) {
        }
        obj = Result.constructor-impl((KSendMessageReply) sendMessage);
        JobKt.ensureActive(networkSendMessageServiceImpl$send$1.getContext());
        if (Result.isSuccess-impl(obj)) {
        }
    }
}