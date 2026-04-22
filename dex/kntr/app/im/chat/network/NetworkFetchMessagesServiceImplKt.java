package kntr.app.im.chat.network;

import com.bapis.bilibili.app.im.v1.KFetchMessageReply;
import com.bapis.bilibili.app.im.v1.KMsg;
import im.base.IMLog;
import im.base.model.SessionId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kntr.app.im.chat.core.RequestMessagesPolicy;
import kntr.app.im.chat.core.model.FetchMessagesResult;
import kntr.app.im.chat.core.model.Message;
import kntr.app.im.chat.network.util.ModelTransformKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;

/* compiled from: NetworkFetchMessagesServiceImpl.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000¨\u0006\u000b"}, d2 = {"asResult", "Lkntr/app/im/chat/core/model/FetchMessagesResult;", "Lcom/bapis/bilibili/app/im/v1/KFetchMessageReply;", "sessionId", "Lim/base/model/SessionId;", "beginSequenceNumber", RoomRecommendViewModel.EMPTY_CURSOR, "policy", "Lkntr/app/im/chat/core/RequestMessagesPolicy;", "transformers", "Lkntr/app/im/chat/network/MsgFrameTransformers;", "network_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NetworkFetchMessagesServiceImplKt {

    /* compiled from: NetworkFetchMessagesServiceImpl.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RequestMessagesPolicy.values().length];
            try {
                iArr[RequestMessagesPolicy.SEQUENCE_NUMBER_BEFORE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[RequestMessagesPolicy.SEQUENCE_NUMBER_AFTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final FetchMessagesResult asResult(KFetchMessageReply $this$asResult, SessionId sessionId, long beginSequenceNumber, RequestMessagesPolicy policy, MsgFrameTransformers transformers) {
        LongRange longRange;
        LongRange range;
        Iterable $this$mapNotNull$iv;
        MsgFrameTransformers msgFrameTransformers = transformers;
        Intrinsics.checkNotNullParameter($this$asResult, "<this>");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(policy, "policy");
        Intrinsics.checkNotNullParameter(msgFrameTransformers, "transformers");
        Iterable $this$mapNotNull$iv2 = $this$asResult.getMessages();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv2) {
            KMsg message = (KMsg) element$iv$iv$iv;
            KMsg.KGhostMsg content = message.getContent();
            Object obj = null;
            if (content instanceof KMsg.KEntityMsg) {
                try {
                    obj = ModelTransformKt.asEntityMessage(((KMsg.KEntityMsg) content).getValue(), sessionId, msgFrameTransformers);
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                } catch (IllegalArgumentException e) {
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                    IMLog.Companion.e(NetworkFetchMessagesServiceImpl.TAG, "KMsg转换失败", e);
                }
                obj = (Message) obj;
            } else {
                $this$mapNotNull$iv = $this$mapNotNull$iv2;
                if (content instanceof KMsg.KGhostMsg) {
                    try {
                        obj = ModelTransformKt.asGhostMessage(content.getValue(), sessionId);
                    } catch (IllegalArgumentException e2) {
                        IMLog.Companion.e(NetworkFetchMessagesServiceImpl.TAG, "KMsg转换失败", e2);
                    }
                    obj = (Message) obj;
                }
            }
            if (obj != null) {
                Object it$iv$iv = obj;
                destination$iv$iv.add(it$iv$iv);
            }
            msgFrameTransformers = transformers;
            $this$mapNotNull$iv2 = $this$mapNotNull$iv;
        }
        List messages = (List) destination$iv$iv;
        LongRange resultRange = new LongRange($this$asResult.getMinSeqNo(), $this$asResult.getMaxSeqNo());
        if (messages.isEmpty()) {
            longRange = resultRange;
        } else {
            long first = resultRange.getFirst();
            Iterator it = messages.iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            Message it2 = (Message) it.next();
            long sequenceNumber = it2.getMsgId().getSequenceNumber();
            while (it.hasNext()) {
                Message it3 = (Message) it.next();
                long sequenceNumber2 = it3.getMsgId().getSequenceNumber();
                if (sequenceNumber > sequenceNumber2) {
                    sequenceNumber = sequenceNumber2;
                }
            }
            long min = Math.min(first, sequenceNumber);
            long last = resultRange.getLast();
            Iterator it4 = messages.iterator();
            if (!it4.hasNext()) {
                throw new NoSuchElementException();
            }
            Message it5 = (Message) it4.next();
            long sequenceNumber3 = it5.getMsgId().getSequenceNumber();
            while (it4.hasNext()) {
                Message it6 = (Message) it4.next();
                long sequenceNumber4 = it6.getMsgId().getSequenceNumber();
                if (sequenceNumber3 < sequenceNumber4) {
                    sequenceNumber3 = sequenceNumber4;
                }
            }
            longRange = new LongRange(min, Math.max(last, sequenceNumber3));
        }
        LongRange mergedRange = longRange;
        switch (WhenMappings.$EnumSwitchMapping$0[policy.ordinal()]) {
            case 1:
                if ($this$asResult.getHasMore()) {
                    range = mergedRange;
                    break;
                } else {
                    range = new LongRange(0L, mergedRange.getLast());
                    break;
                }
            case 2:
                range = new LongRange(beginSequenceNumber, mergedRange.getLast());
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        IMLog.Companion.i(NetworkFetchMessagesServiceImpl.TAG, "此次请求消息范围 " + range);
        return new FetchMessagesResult(messages, range, FetchMessagesResult.LoadFrom.Network, beginSequenceNumber);
    }
}