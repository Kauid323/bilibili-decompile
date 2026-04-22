package kntr.app.im.chat.module;

import com.bapis.bilibili.app.im.v1.KMsgModule;
import kntr.app.im.chat.network.MsgModuleTransformer;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: NotifyInteractiveModuleTransformer.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001c\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u0010"}, d2 = {"Lkntr/app/im/chat/module/NotifyInteractiveModuleTransformer;", "Lkntr/app/im/chat/network/MsgModuleTransformer;", "Lcom/bapis/bilibili/app/im/v1/KMsgModule$KNotifyInteractiveModule;", "Lkntr/app/im/chat/module/NotifyInteractiveMsgModule;", "<init>", "()V", "kType", "Lkotlin/reflect/KClass;", "getKType", "()Lkotlin/reflect/KClass;", "type", "getType", "transformToMsgModule", "module", "index", RoomRecommendViewModel.EMPTY_CURSOR, "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NotifyInteractiveModuleTransformer implements MsgModuleTransformer<KMsgModule.KNotifyInteractiveModule, NotifyInteractiveMsgModule> {
    public static final int $stable = 0;

    @Override // kntr.app.im.chat.network.MsgModuleTransformer
    public KClass<? extends KMsgModule.KNotifyInteractiveModule> getKType() {
        return Reflection.getOrCreateKotlinClass(KMsgModule.KNotifyInteractiveModule.class);
    }

    @Override // kntr.app.im.chat.network.MsgModuleTransformer
    public KClass<? extends NotifyInteractiveMsgModule> getType() {
        return Reflection.getOrCreateKotlinClass(NotifyInteractiveMsgModule.class);
    }

    @Override // kntr.app.im.chat.network.MsgModuleTransformer
    public NotifyInteractiveMsgModule transformToMsgModule(KMsgModule.KNotifyInteractiveModule module, int index) {
        Intrinsics.checkNotNullParameter(module, "module");
        return new NotifyInteractiveMsgModule(module.getValue());
    }
}