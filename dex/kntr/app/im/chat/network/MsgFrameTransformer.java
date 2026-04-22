package kntr.app.im.chat.network;

import com.bapis.bilibili.app.im.v1.KMsgFrame;
import com.bapis.bilibili.app.im.v1.KMsgFrame.IFrame;
import kntr.app.im.chat.core.model.MsgFrame;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.reflect.KClass;

/* compiled from: MsgFrameTransformer.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005J\u0017\u0010\f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000eJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0012R\u001a\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/network/MsgFrameTransformer;", "KF", "Lcom/bapis/bilibili/app/im/v1/KMsgFrame$IFrame;", "F", "Lkntr/app/im/chat/core/model/MsgFrame;", RoomRecommendViewModel.EMPTY_CURSOR, "kType", "Lkotlin/reflect/KClass;", "getKType", "()Lkotlin/reflect/KClass;", "type", "getType", "transformToMsgFrame", "kFrame", "(Lcom/bapis/bilibili/app/im/v1/KMsgFrame$IFrame;)Lkntr/app/im/chat/core/model/MsgFrame;", "transformToKFrame", "Lcom/bapis/bilibili/app/im/v1/KMsgFrame;", "msgFrame", "(Lkntr/app/im/chat/core/model/MsgFrame;)Lcom/bapis/bilibili/app/im/v1/KMsgFrame;", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface MsgFrameTransformer<KF extends KMsgFrame.IFrame, F extends MsgFrame> {
    KClass<? extends KF> getKType();

    KClass<? extends F> getType();

    KMsgFrame transformToKFrame(F f);

    F transformToMsgFrame(KF kf);
}