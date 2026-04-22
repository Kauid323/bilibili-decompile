package kntr.app.im.chat.ui.builder;

import kntr.app.im.chat.core.model.MsgFrame;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.reflect.KClass;

/* compiled from: ChatMsgFrameBuilder.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0006H§\u0002R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/ui/builder/ChatMsgFrameBuilderProvider;", RoomRecommendViewModel.EMPTY_CURSOR, "get", "Lkntr/app/im/chat/ui/builder/ChatMsgFrameBuilder;", "Lkntr/app/im/chat/core/model/MsgFrame;", "type", "Lkotlin/reflect/KClass;", "defaultBuilder", "getDefaultBuilder", "()Lkntr/app/im/chat/ui/builder/ChatMsgFrameBuilder;", "timeLabelBuilder", "Lkntr/app/im/chat/ui/builder/ChatTimeLabelBuilder;", "getTimeLabelBuilder", "()Lkntr/app/im/chat/ui/builder/ChatTimeLabelBuilder;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ChatMsgFrameBuilderProvider {
    ChatMsgFrameBuilder<MsgFrame> get(KClass<? extends MsgFrame> kClass);

    ChatMsgFrameBuilder<MsgFrame> getDefaultBuilder();

    ChatTimeLabelBuilder getTimeLabelBuilder();
}