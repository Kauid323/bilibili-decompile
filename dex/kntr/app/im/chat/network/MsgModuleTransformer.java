package kntr.app.im.chat.network;

import com.bapis.bilibili.app.im.v1.KMsgModule;
import com.bapis.bilibili.app.im.v1.KMsgModule.IModule;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.reflect.KClass;

/* compiled from: MsgModuleTransformer.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005J\u001f\u0010\f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000fH&¢\u0006\u0002\u0010\u0010R\u001a\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/network/MsgModuleTransformer;", "KMsg", "Lcom/bapis/bilibili/app/im/v1/KMsgModule$IModule;", "Msg", "Lkntr/app/im/chat/core/model/MsgModule;", RoomRecommendViewModel.EMPTY_CURSOR, "kType", "Lkotlin/reflect/KClass;", "getKType", "()Lkotlin/reflect/KClass;", "type", "getType", "transformToMsgModule", "module", "index", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bapis/bilibili/app/im/v1/KMsgModule$IModule;I)Lkntr/app/im/chat/core/model/MsgModule;", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface MsgModuleTransformer<KMsg extends KMsgModule.IModule, Msg extends MsgModule> {
    KClass<? extends KMsg> getKType();

    KClass<? extends Msg> getType();

    Msg transformToMsgModule(KMsg kmsg, int i);
}