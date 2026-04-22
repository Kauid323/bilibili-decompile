package kntr.app.im.chat.network;

import com.bapis.bilibili.app.im.v1.KChatInfoReply;
import com.bapis.bilibili.app.im.v1.KChatInfoReq;
import com.bapis.bilibili.app.im.v1.KChatMoss;
import com.bapis.bilibili.app.im.v1.KSessionId;
import im.base.IMLog;
import javax.inject.Inject;
import kntr.app.im.chat.core.model.ChatInfo;
import kntr.app.im.chat.core.service.NetworkChatInfoService;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;

/* compiled from: NetworkChatInfoServiceImpl.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096@¢\u0006\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkntr/app/im/chat/network/NetworkChatInfoServiceImpl;", "Lkntr/app/im/chat/core/service/NetworkChatInfoService;", "sessionId", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KSessionId;)V", "load", "Lkotlin/Result;", "Lkntr/app/im/chat/core/model/ChatInfo;", "load-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NetworkChatInfoServiceImpl implements NetworkChatInfoService {
    private final KSessionId sessionId;

    @Inject
    public NetworkChatInfoServiceImpl(KSessionId sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.sessionId = sessionId;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(8:5|6|7|8|15|16|(1:18)|19))|28|6|7|8|15|16|(0)|19) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0074, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0075, code lost:
        r6 = kotlin.Result.Companion;
        r0 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r0));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008e  */
    @Override // kntr.app.im.chat.core.service.NetworkChatInfoService
    /* renamed from: load-IoAF18A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo1359loadIoAF18A(Continuation<? super Result<ChatInfo>> continuation) {
        NetworkChatInfoServiceImpl$load$1 networkChatInfoServiceImpl$load$1;
        NetworkChatInfoServiceImpl$load$1 networkChatInfoServiceImpl$load$12;
        Throwable it;
        Object chatInfo;
        if (continuation instanceof NetworkChatInfoServiceImpl$load$1) {
            networkChatInfoServiceImpl$load$1 = (NetworkChatInfoServiceImpl$load$1) continuation;
            if ((networkChatInfoServiceImpl$load$1.label & Integer.MIN_VALUE) != 0) {
                networkChatInfoServiceImpl$load$1.label -= Integer.MIN_VALUE;
                networkChatInfoServiceImpl$load$12 = networkChatInfoServiceImpl$load$1;
                Object $result = networkChatInfoServiceImpl$load$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (networkChatInfoServiceImpl$load$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Result.Companion companion = Result.Companion;
                        KChatMoss kChatMoss = new KChatMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                        KChatInfoReq kChatInfoReq = new KChatInfoReq(this.sessionId);
                        networkChatInfoServiceImpl$load$12.I$0 = 0;
                        networkChatInfoServiceImpl$load$12.I$1 = 0;
                        networkChatInfoServiceImpl$load$12.label = 1;
                        chatInfo = kChatMoss.chatInfo(kChatInfoReq, networkChatInfoServiceImpl$load$12);
                        if (chatInfo != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i = networkChatInfoServiceImpl$load$12.I$1;
                        int i2 = networkChatInfoServiceImpl$load$12.I$0;
                        ResultKt.throwOnFailure($result);
                        chatInfo = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                KChatInfoReply resp = (KChatInfoReply) chatInfo;
                Object obj = Result.constructor-impl(new ChatInfo(resp, null, null, null, null, null, 62, null));
                JobKt.ensureActive(networkChatInfoServiceImpl$load$12.getContext());
                it = Result.exceptionOrNull-impl(obj);
                if (it != null) {
                    IMLog.Companion.e("NetworkChatInfoService", "Fail to load chat info from net", it);
                }
                return obj;
            }
        }
        networkChatInfoServiceImpl$load$1 = new NetworkChatInfoServiceImpl$load$1(this, continuation);
        networkChatInfoServiceImpl$load$12 = networkChatInfoServiceImpl$load$1;
        Object $result2 = networkChatInfoServiceImpl$load$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (networkChatInfoServiceImpl$load$12.label) {
        }
        KChatInfoReply resp2 = (KChatInfoReply) chatInfo;
        Object obj2 = Result.constructor-impl(new ChatInfo(resp2, null, null, null, null, null, 62, null));
        JobKt.ensureActive(networkChatInfoServiceImpl$load$12.getContext());
        it = Result.exceptionOrNull-impl(obj2);
        if (it != null) {
        }
        return obj2;
    }
}