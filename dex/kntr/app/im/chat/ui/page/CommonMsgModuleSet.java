package kntr.app.im.chat.ui.page;

import dagger.Module;
import dagger.Provides;
import java.util.Map;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.im.chat.ui.builder.ChatMsgModuleBuilder;
import kntr.app.im.chat.ui.builder.ChatMsgModuleBuilderProvider;
import kntr.app.im.chat.ui.builder.ChatMsgModuleBuilderProviderImpl;
import kntr.app.im.chat.ui.builder.EmptyChatMsgModuleBuilder;
import kntr.app.im.chat.ui.di.ChatMsgModuleScope;
import kntr.app.im.chat.ui.di.DefaultChatMsgModuleBuilder;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonMsgModule.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u0004\u001a\u00020\u00052\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\b\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000b0\u00072\u0010\b\u0001\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\n0\tH\u0007J\u0010\u0010\r\u001a\n\u0012\u0006\b\u0000\u0012\u00020\n0\tH\u0007¨\u0006\u000e"}, d2 = {"Lkntr/app/im/chat/ui/page/CommonMsgModuleSet;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "bindChatMsgModuleBuilderProvider", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilderProvider;", "map", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilder;", "Lkntr/app/im/chat/core/model/MsgModule;", "Lkotlin/jvm/JvmSuppressWildcards;", "defaultBuilder", "bindDefaultChatMsgModuleBuilder", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class CommonMsgModuleSet {
    public static final int $stable = 0;
    public static final CommonMsgModuleSet INSTANCE = new CommonMsgModuleSet();

    private CommonMsgModuleSet() {
    }

    @Provides
    @ChatMsgModuleScope
    public final ChatMsgModuleBuilderProvider bindChatMsgModuleBuilderProvider(Map<String, ChatMsgModuleBuilder<MsgModule>> map, @DefaultChatMsgModuleBuilder ChatMsgModuleBuilder<? super MsgModule> chatMsgModuleBuilder) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(chatMsgModuleBuilder, "defaultBuilder");
        return new ChatMsgModuleBuilderProviderImpl(map, chatMsgModuleBuilder);
    }

    @Provides
    @ChatMsgModuleScope
    @DefaultChatMsgModuleBuilder
    public final ChatMsgModuleBuilder<? super MsgModule> bindDefaultChatMsgModuleBuilder() {
        return new EmptyChatMsgModuleBuilder();
    }
}