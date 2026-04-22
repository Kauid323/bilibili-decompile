package kntr.app.im.chat.ui.widget;

import dagger.Module;
import dagger.Provides;
import kntr.app.im.chat.ui.builder.ChatTimeLabelBuilder;
import kntr.app.im.chat.ui.di.ChatMsgModuleScope;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: MessageTime.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lkntr/app/im/chat/ui/widget/DefaultChatTimeLabelBuilderModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provideChatTimeLabelBuilder", "Lkntr/app/im/chat/ui/builder/ChatTimeLabelBuilder;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class DefaultChatTimeLabelBuilderModule {
    public static final int $stable = 0;
    public static final DefaultChatTimeLabelBuilderModule INSTANCE = new DefaultChatTimeLabelBuilderModule();

    private DefaultChatTimeLabelBuilderModule() {
    }

    @Provides
    @ChatMsgModuleScope
    public final ChatTimeLabelBuilder provideChatTimeLabelBuilder() {
        return new ChatTimeLabelBuilderImpl();
    }
}