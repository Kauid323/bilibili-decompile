package im.direct.notification.interactive;

import com.bapis.bilibili.im.gateway.interfaces.v1.KCommonMsgCard;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgFeedMsgCard;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.protobuf.ProtoBuf;

/* compiled from: DataTransformUtils.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r¨\u0006\u000e"}, d2 = {"Lim/direct/notification/interactive/DataTransformUtils;", "", "<init>", "()V", "msgFeedMsgCardToByteArray", "", "msgFeedMsgCard", "Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgFeedMsgCard;", "commonMsgCardToByteArray", "commonMsgCard", "Lcom/bapis/bilibili/im/gateway/interfaces/v1/KCommonMsgCard;", "msgCardToByteArray", "msgCard", "Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgItem$IMsgCard;", "interactive_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DataTransformUtils {
    public static final DataTransformUtils INSTANCE = new DataTransformUtils();

    private DataTransformUtils() {
    }

    public final byte[] msgFeedMsgCardToByteArray(KMsgFeedMsgCard msgFeedMsgCard) {
        Intrinsics.checkNotNullParameter(msgFeedMsgCard, "msgFeedMsgCard");
        BinaryFormat $this$encodeToByteArray$iv = ProtoBuf.Default;
        $this$encodeToByteArray$iv.getSerializersModule();
        return $this$encodeToByteArray$iv.encodeToByteArray(KMsgFeedMsgCard.Companion.serializer(), msgFeedMsgCard);
    }

    public final byte[] commonMsgCardToByteArray(KCommonMsgCard commonMsgCard) {
        if (commonMsgCard != null) {
            BinaryFormat $this$encodeToByteArray$iv = ProtoBuf.Default;
            $this$encodeToByteArray$iv.getSerializersModule();
            return $this$encodeToByteArray$iv.encodeToByteArray(KCommonMsgCard.Companion.serializer(), commonMsgCard);
        }
        return null;
    }

    public final byte[] msgCardToByteArray(KMsgItem.IMsgCard msgCard) {
        if (msgCard != null) {
            BinaryFormat $this$encodeToByteArray$iv = ProtoBuf.Default;
            $this$encodeToByteArray$iv.getSerializersModule();
            return $this$encodeToByteArray$iv.encodeToByteArray(KMsgItem.IMsgCard.Companion.serializer(), msgCard);
        }
        return null;
    }
}