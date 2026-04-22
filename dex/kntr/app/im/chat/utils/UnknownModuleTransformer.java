package kntr.app.im.chat.utils;

import com.bapis.bilibili.app.im.v1.KMsgModule;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.im.chat.network.DefaultModuleTransformer;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: UnknownFrameTransformer.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lkntr/app/im/chat/utils/UnknownModuleTransformer;", "Lkntr/app/im/chat/network/DefaultModuleTransformer;", "<init>", "()V", "buildDefaultModule", "Lkntr/app/im/chat/core/model/MsgModule;", "module", "Lcom/bapis/bilibili/app/im/v1/KMsgModule$IModule;", "index", RoomRecommendViewModel.EMPTY_CURSOR, "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UnknownModuleTransformer implements DefaultModuleTransformer {
    public static final int $stable = 0;

    @Override // kntr.app.im.chat.network.DefaultModuleTransformer
    public MsgModule buildDefaultModule(KMsgModule.IModule module, int index) {
        return MsgModule.UnknownModule.INSTANCE;
    }
}