package kntr.app.im.chat.network;

import com.bapis.bilibili.app.im.v1.KMsgFrame;
import kntr.app.im.chat.core.model.MsgFrame;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: MsgFrameTransformer.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/network/DefaultFrameTransformer;", RoomRecommendViewModel.EMPTY_CURSOR, "buildDefaultFrame", "Lkntr/app/im/chat/core/model/MsgFrame;", "frame", "Lcom/bapis/bilibili/app/im/v1/KMsgFrame$IFrame;", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DefaultFrameTransformer {
    MsgFrame buildDefaultFrame(KMsgFrame.IFrame iFrame);
}