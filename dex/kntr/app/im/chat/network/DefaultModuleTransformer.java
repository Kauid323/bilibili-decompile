package kntr.app.im.chat.network;

import com.bapis.bilibili.app.im.v1.KMsgModule;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: MsgModuleTransformer.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/network/DefaultModuleTransformer;", RoomRecommendViewModel.EMPTY_CURSOR, "buildDefaultModule", "Lkntr/app/im/chat/core/model/MsgModule;", "module", "Lcom/bapis/bilibili/app/im/v1/KMsgModule$IModule;", "index", RoomRecommendViewModel.EMPTY_CURSOR, "network_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DefaultModuleTransformer {
    MsgModule buildDefaultModule(KMsgModule.IModule iModule, int i);
}