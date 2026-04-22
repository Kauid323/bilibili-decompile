package kntr.app.im.chat.ui.module.autoReply;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.im.chat.ui.builder.ChatMsgModuleBuilder;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: AutoReplyModule.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lkntr/app/im/chat/ui/module/autoReply/AutoReplyModuleModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provideAutoReplyModuleBuilder", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilder;", "Lkntr/app/im/chat/core/model/MsgModule;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class AutoReplyModuleModule {
    public static final int $stable = 0;
    public static final AutoReplyModuleModule INSTANCE = new AutoReplyModuleModule();

    private AutoReplyModuleModule() {
    }

    @Provides
    @IntoMap
    @StringKey("AutoReplyModule")
    public final ChatMsgModuleBuilder<MsgModule> provideAutoReplyModuleBuilder() {
        return new AutoReplyModuleBuilder();
    }
}