package kntr.app.im.chat.ui.builder;

import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.reflect.KClass;

/* compiled from: ChatMsgModuleBuilder.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H&R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilder;", "M", "Lkntr/app/im/chat/core/model/MsgModule;", RoomRecommendViewModel.EMPTY_CURSOR, "buildMsgModule", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleContent;", "acceptClass", "Lkotlin/reflect/KClass;", "getAcceptClass", "()Lkotlin/reflect/KClass;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ChatMsgModuleBuilder<M extends MsgModule> {
    ChatMsgModuleContent<M> buildMsgModule();

    KClass<M> getAcceptClass();
}