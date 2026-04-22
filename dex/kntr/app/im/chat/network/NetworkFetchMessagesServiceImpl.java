package kntr.app.im.chat.network;

import com.bapis.bilibili.app.im.v1.KChatMoss;
import com.bapis.bilibili.app.im.v1.KFetchMessageReply;
import com.bapis.bilibili.app.im.v1.KFetchMessageReq;
import com.bapis.bilibili.app.im.v1.KMessageDetailReply;
import com.bapis.bilibili.app.im.v1.KMessageDetailReq;
import com.bapis.bilibili.app.im.v1.KMsg;
import com.bapis.bilibili.app.im.v1.KSessionId;
import im.base.IMLog;
import im.base.model.SessionId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kntr.app.im.chat.core.RequestMessagesPolicy;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.FetchMessagesResult;
import kntr.app.im.chat.core.model.MessageId;
import kntr.app.im.chat.core.service.NetworkFetchMessageService;
import kntr.app.im.chat.network.util.ModelTransformKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.JobKt;

/* compiled from: NetworkFetchMessagesServiceImpl.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0004\b\u0011\u0010\u0012J0\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00140\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u0018H\u0096@¢\u0006\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkntr/app/im/chat/network/NetworkFetchMessagesServiceImpl;", "Lkntr/app/im/chat/core/service/NetworkFetchMessageService;", "sessionId", "Lim/base/model/SessionId;", "kSessionId", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "transformers", "Lkntr/app/im/chat/network/MsgFrameTransformers;", "<init>", "(Lim/base/model/SessionId;Lcom/bapis/bilibili/app/im/v1/KSessionId;Lkntr/app/im/chat/network/MsgFrameTransformers;)V", "load", "Lkotlin/Result;", "Lkntr/app/im/chat/core/model/FetchMessagesResult;", "beginSequenceNumber", RoomRecommendViewModel.EMPTY_CURSOR, "policy", "Lkntr/app/im/chat/core/RequestMessagesPolicy;", "load-0E7RQCE", "(JLkntr/app/im/chat/core/RequestMessagesPolicy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "messageDetail", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/MessageId;", "Lkntr/app/im/chat/core/model/EntityMessage;", "ids", RoomRecommendViewModel.EMPTY_CURSOR, "messageDetail-gIAlu-s", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NetworkFetchMessagesServiceImpl implements NetworkFetchMessageService {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "NetworkFetch";
    private final KSessionId kSessionId;
    private final SessionId sessionId;
    private final MsgFrameTransformers transformers;

    @Inject
    public NetworkFetchMessagesServiceImpl(SessionId sessionId, KSessionId kSessionId, MsgFrameTransformers transformers) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(kSessionId, "kSessionId");
        Intrinsics.checkNotNullParameter(transformers, "transformers");
        this.sessionId = sessionId;
        this.kSessionId = kSessionId;
        this.transformers = transformers;
    }

    /* compiled from: NetworkFetchMessagesServiceImpl.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkntr/app/im/chat/network/NetworkFetchMessagesServiceImpl$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "TAG", RoomRecommendViewModel.EMPTY_CURSOR, "network_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|8|15|16|(2:18|19)(2:20|21)))|30|6|7|8|15|16|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0070, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0071, code lost:
        r4 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c4  */
    @Override // kntr.app.im.chat.core.service.NetworkFetchMessageService
    /* renamed from: load-0E7RQCE */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo1360load0E7RQCE(long beginSequenceNumber, RequestMessagesPolicy policy, Continuation<? super Result<FetchMessagesResult>> continuation) {
        NetworkFetchMessagesServiceImpl$load$1 networkFetchMessagesServiceImpl$load$1;
        Throwable it;
        Object fetchMessage;
        if (continuation instanceof NetworkFetchMessagesServiceImpl$load$1) {
            networkFetchMessagesServiceImpl$load$1 = (NetworkFetchMessagesServiceImpl$load$1) continuation;
            if ((networkFetchMessagesServiceImpl$load$1.label & Integer.MIN_VALUE) != 0) {
                networkFetchMessagesServiceImpl$load$1.label -= Integer.MIN_VALUE;
                Object $result = networkFetchMessagesServiceImpl$load$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (networkFetchMessagesServiceImpl$load$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Result.Companion companion = Result.Companion;
                        KChatMoss kChatMoss = new KChatMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                        KFetchMessageReq kFetchMessageReq = new KFetchMessageReq(this.kSessionId, beginSequenceNumber, ModelTransformKt.asKFetchDirection(policy));
                        networkFetchMessagesServiceImpl$load$1.L$0 = policy;
                        networkFetchMessagesServiceImpl$load$1.J$0 = beginSequenceNumber;
                        networkFetchMessagesServiceImpl$load$1.I$0 = 0;
                        networkFetchMessagesServiceImpl$load$1.I$1 = 0;
                        networkFetchMessagesServiceImpl$load$1.label = 1;
                        fetchMessage = kChatMoss.fetchMessage(kFetchMessageReq, networkFetchMessagesServiceImpl$load$1);
                        if (fetchMessage != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i = networkFetchMessagesServiceImpl$load$1.I$1;
                        int i2 = networkFetchMessagesServiceImpl$load$1.I$0;
                        beginSequenceNumber = networkFetchMessagesServiceImpl$load$1.J$0;
                        policy = (RequestMessagesPolicy) networkFetchMessagesServiceImpl$load$1.L$0;
                        ResultKt.throwOnFailure($result);
                        fetchMessage = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Object obj = Result.constructor-impl((KFetchMessageReply) fetchMessage);
                JobKt.ensureActive(networkFetchMessagesServiceImpl$load$1.getContext());
                it = Result.exceptionOrNull-impl(obj);
                if (it == null) {
                    IMLog.Companion.e(TAG, "拉消息接口失败 begin= " + beginSequenceNumber + " policy= " + policy, it);
                    Result.Companion companion2 = Result.Companion;
                    return Result.constructor-impl(ResultKt.createFailure(it));
                }
                IMLog.Companion.i(TAG, "拉消息接口成功 begin= " + beginSequenceNumber + " policy= " + policy);
                Result.Companion companion3 = Result.Companion;
                return Result.constructor-impl(NetworkFetchMessagesServiceImplKt.asResult((KFetchMessageReply) obj, this.sessionId, beginSequenceNumber, policy, this.transformers));
            }
        }
        networkFetchMessagesServiceImpl$load$1 = new NetworkFetchMessagesServiceImpl$load$1(this, continuation);
        Object $result2 = networkFetchMessagesServiceImpl$load$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (networkFetchMessagesServiceImpl$load$1.label) {
        }
        Object obj2 = Result.constructor-impl((KFetchMessageReply) fetchMessage);
        JobKt.ensureActive(networkFetchMessagesServiceImpl$load$1.getContext());
        it = Result.exceptionOrNull-impl(obj2);
        if (it == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0172 A[SYNTHETIC] */
    @Override // kntr.app.im.chat.core.service.NetworkFetchMessageService
    /* renamed from: messageDetail-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo1361messageDetailgIAlus(List<MessageId> list, Continuation<? super Result<? extends Map<MessageId, EntityMessage>>> continuation) {
        NetworkFetchMessagesServiceImpl$messageDetail$1 networkFetchMessagesServiceImpl$messageDetail$1;
        NetworkFetchMessagesServiceImpl$messageDetail$1 networkFetchMessagesServiceImpl$messageDetail$12;
        Object messageDetail;
        Object obj;
        Throwable it;
        NetworkFetchMessagesServiceImpl$messageDetail$1 networkFetchMessagesServiceImpl$messageDetail$13;
        Object obj2;
        Throwable it2;
        EntityMessage entityMessage;
        NetworkFetchMessagesServiceImpl networkFetchMessagesServiceImpl = this;
        List ids = list;
        if (continuation instanceof NetworkFetchMessagesServiceImpl$messageDetail$1) {
            networkFetchMessagesServiceImpl$messageDetail$1 = (NetworkFetchMessagesServiceImpl$messageDetail$1) continuation;
            if ((networkFetchMessagesServiceImpl$messageDetail$1.label & Integer.MIN_VALUE) != 0) {
                networkFetchMessagesServiceImpl$messageDetail$1.label -= Integer.MIN_VALUE;
                networkFetchMessagesServiceImpl$messageDetail$12 = networkFetchMessagesServiceImpl$messageDetail$1;
                Object $result = networkFetchMessagesServiceImpl$messageDetail$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (networkFetchMessagesServiceImpl$messageDetail$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            Result.Companion companion = Result.Companion;
                            List $this$map$iv = ids;
                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                destination$iv$iv.add(((MessageId) item$iv$iv).asKMsgId());
                            }
                            KMessageDetailReq req = new KMessageDetailReq((List) destination$iv$iv, networkFetchMessagesServiceImpl.kSessionId);
                            KChatMoss kChatMoss = new KChatMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                            networkFetchMessagesServiceImpl$messageDetail$12.L$0 = ids;
                            networkFetchMessagesServiceImpl$messageDetail$12.L$1 = SpillingKt.nullOutSpilledVariable(req);
                            networkFetchMessagesServiceImpl$messageDetail$12.I$0 = 0;
                            networkFetchMessagesServiceImpl$messageDetail$12.I$1 = 0;
                            networkFetchMessagesServiceImpl$messageDetail$12.label = 1;
                            messageDetail = kChatMoss.messageDetail(req, networkFetchMessagesServiceImpl$messageDetail$12);
                        } catch (Throwable th) {
                            th = th;
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            JobKt.ensureActive(networkFetchMessagesServiceImpl$messageDetail$12.getContext());
                            it = Result.exceptionOrNull-impl(obj);
                            if (it == null) {
                            }
                        }
                        if (messageDetail == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = Result.constructor-impl((KMessageDetailReply) messageDetail);
                        JobKt.ensureActive(networkFetchMessagesServiceImpl$messageDetail$12.getContext());
                        it = Result.exceptionOrNull-impl(obj);
                        if (it == null) {
                            IMLog.Companion.e(TAG, "批量查询消息详情失败 ids= " + ids, it);
                            Result.Companion companion3 = Result.Companion;
                            return Result.constructor-impl(ResultKt.createFailure(it));
                        }
                        KMessageDetailReply reply = (KMessageDetailReply) obj;
                        IMLog.Companion.i(TAG, "批量查询消息详情成功 ids= " + ids);
                        Iterable $this$mapNotNull$iv = reply.getMsgs();
                        Collection destination$iv$iv2 = new ArrayList();
                        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                            KMsg message = (KMsg) element$iv$iv$iv;
                            KMsg.KEntityMsg content = message.getContent();
                            if (content instanceof KMsg.KEntityMsg) {
                                try {
                                    Result.Companion companion4 = Result.Companion;
                                    NetworkFetchMessagesServiceImpl $this$messageDetail_gIAlu_s_u24lambda_u241_u240_u240 = networkFetchMessagesServiceImpl;
                                    networkFetchMessagesServiceImpl$messageDetail$13 = networkFetchMessagesServiceImpl$messageDetail$12;
                                    try {
                                        obj2 = Result.constructor-impl(ModelTransformKt.asEntityMessage(content.getValue(), $this$messageDetail_gIAlu_s_u24lambda_u241_u240_u240.sessionId, $this$messageDetail_gIAlu_s_u24lambda_u241_u240_u240.transformers));
                                    } catch (Throwable th2) {
                                        th = th2;
                                        Result.Companion companion5 = Result.Companion;
                                        obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                        it2 = Result.exceptionOrNull-impl(obj2);
                                        if (it2 != null) {
                                        }
                                        if (Result.isFailure-impl(obj2)) {
                                        }
                                        entityMessage = (EntityMessage) obj2;
                                        if (entityMessage == null) {
                                        }
                                        networkFetchMessagesServiceImpl = this;
                                        networkFetchMessagesServiceImpl$messageDetail$12 = networkFetchMessagesServiceImpl$messageDetail$13;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    networkFetchMessagesServiceImpl$messageDetail$13 = networkFetchMessagesServiceImpl$messageDetail$12;
                                }
                                it2 = Result.exceptionOrNull-impl(obj2);
                                if (it2 != null) {
                                    IMLog.Companion.e(TAG, "KMsg转换失败", it2);
                                }
                                if (Result.isFailure-impl(obj2)) {
                                    obj2 = null;
                                }
                                entityMessage = (EntityMessage) obj2;
                            } else {
                                networkFetchMessagesServiceImpl$messageDetail$13 = networkFetchMessagesServiceImpl$messageDetail$12;
                                entityMessage = null;
                            }
                            if (entityMessage == null) {
                                destination$iv$iv2.add(entityMessage);
                            }
                            networkFetchMessagesServiceImpl = this;
                            networkFetchMessagesServiceImpl$messageDetail$12 = networkFetchMessagesServiceImpl$messageDetail$13;
                        }
                        Iterable messages = (List) destination$iv$iv2;
                        Result.Companion companion6 = Result.Companion;
                        Iterable $this$associateBy$iv = messages;
                        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
                        Map destination$iv$iv3 = new LinkedHashMap(capacity$iv);
                        for (Object element$iv$iv : $this$associateBy$iv) {
                            destination$iv$iv3.put(((EntityMessage) element$iv$iv).getMsgId(), element$iv$iv);
                        }
                        return Result.constructor-impl(destination$iv$iv3);
                    case 1:
                        int i = networkFetchMessagesServiceImpl$messageDetail$12.I$1;
                        int i2 = networkFetchMessagesServiceImpl$messageDetail$12.I$0;
                        KMessageDetailReq kMessageDetailReq = (KMessageDetailReq) networkFetchMessagesServiceImpl$messageDetail$12.L$1;
                        ids = (List) networkFetchMessagesServiceImpl$messageDetail$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            messageDetail = $result;
                            obj = Result.constructor-impl((KMessageDetailReply) messageDetail);
                        } catch (Throwable th4) {
                            th = th4;
                            Result.Companion companion22 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            JobKt.ensureActive(networkFetchMessagesServiceImpl$messageDetail$12.getContext());
                            it = Result.exceptionOrNull-impl(obj);
                            if (it == null) {
                            }
                        }
                        JobKt.ensureActive(networkFetchMessagesServiceImpl$messageDetail$12.getContext());
                        it = Result.exceptionOrNull-impl(obj);
                        if (it == null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        networkFetchMessagesServiceImpl$messageDetail$1 = new NetworkFetchMessagesServiceImpl$messageDetail$1(networkFetchMessagesServiceImpl, continuation);
        networkFetchMessagesServiceImpl$messageDetail$12 = networkFetchMessagesServiceImpl$messageDetail$1;
        Object $result2 = networkFetchMessagesServiceImpl$messageDetail$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (networkFetchMessagesServiceImpl$messageDetail$12.label) {
        }
    }
}