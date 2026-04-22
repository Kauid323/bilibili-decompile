package kntr.app.im.chat.utils;

import com.bapis.bilibili.app.im.v1.KMsgFrame;
import kntr.app.im.chat.core.model.MsgFrame;
import kntr.app.im.chat.core.model.UnknownFrame;
import kntr.app.im.chat.network.DefaultFrameTransformer;
import kotlin.Metadata;

/* compiled from: UnknownFrameTransformer.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lkntr/app/im/chat/utils/UnknownFrameTransformer;", "Lkntr/app/im/chat/network/DefaultFrameTransformer;", "<init>", "()V", "buildDefaultFrame", "Lkntr/app/im/chat/core/model/MsgFrame;", "frame", "Lcom/bapis/bilibili/app/im/v1/KMsgFrame$IFrame;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UnknownFrameTransformer implements DefaultFrameTransformer {
    public static final int $stable = 0;

    @Override // kntr.app.im.chat.network.DefaultFrameTransformer
    public MsgFrame buildDefaultFrame(KMsgFrame.IFrame frame) {
        return UnknownFrame.INSTANCE;
    }
}