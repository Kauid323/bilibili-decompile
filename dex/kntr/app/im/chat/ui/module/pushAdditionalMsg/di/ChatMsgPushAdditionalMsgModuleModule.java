package kntr.app.im.chat.ui.module.pushAdditionalMsg.di;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.im.chat.ui.builder.ChatMsgModuleBuilder;
import kntr.app.im.chat.ui.module.pushAdditionalMsg.ChatMsgPushAdditionalMsgModuleBuilder;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMsgPushAdditionalMsgModuleModule.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lkntr/app/im/chat/ui/module/pushAdditionalMsg/di/ChatMsgPushAdditionalMsgModuleModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provideChatMsgPushAdditionalMsgModuleBuilder", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilder;", "Lkntr/app/im/chat/core/model/MsgModule;", "text", "Lkntr/app/im/chat/ui/module/pushAdditionalMsg/ChatMsgPushAdditionalMsgModuleBuilder;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class ChatMsgPushAdditionalMsgModuleModule {
    public static final int $stable = 0;
    public static final ChatMsgPushAdditionalMsgModuleModule INSTANCE = new ChatMsgPushAdditionalMsgModuleModule();

    private ChatMsgPushAdditionalMsgModuleModule() {
    }

    @Provides
    @IntoMap
    @StringKey("PushAdditionalMsgModule")
    public final ChatMsgModuleBuilder<MsgModule> provideChatMsgPushAdditionalMsgModuleBuilder(ChatMsgPushAdditionalMsgModuleBuilder text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return text;
    }
}