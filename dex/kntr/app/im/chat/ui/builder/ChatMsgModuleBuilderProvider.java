package kntr.app.im.chat.ui.builder;

import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.reflect.KClass;

/* compiled from: ChatMsgModuleBuilder.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0006H§\u0002R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilderProvider;", RoomRecommendViewModel.EMPTY_CURSOR, "get", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilder;", "Lkntr/app/im/chat/core/model/MsgModule;", "type", "Lkotlin/reflect/KClass;", "defaultBuilder", "getDefaultBuilder", "()Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilder;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ChatMsgModuleBuilderProvider {
    ChatMsgModuleBuilder<MsgModule> get(KClass<? extends MsgModule> kClass);

    ChatMsgModuleBuilder<MsgModule> getDefaultBuilder();
}