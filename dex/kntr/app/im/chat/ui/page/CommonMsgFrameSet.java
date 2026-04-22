package kntr.app.im.chat.ui.page;

import dagger.Module;
import dagger.Provides;
import java.util.Map;
import kntr.app.im.chat.core.model.MsgFrame;
import kntr.app.im.chat.ui.builder.ChatMsgFrameBuilder;
import kntr.app.im.chat.ui.builder.ChatMsgFrameBuilderProvider;
import kntr.app.im.chat.ui.builder.ChatMsgFrameBuilderProviderImpl;
import kntr.app.im.chat.ui.builder.ChatTimeLabelBuilder;
import kntr.app.im.chat.ui.builder.EmptyChatMsgFrameBuilder;
import kntr.app.im.chat.ui.di.ChatMsgModuleScope;
import kntr.app.im.chat.ui.di.DefaultChatMsgFrameBuilder;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonMsgModule.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u0004\u001a\u00020\u00052\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\b\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000b0\u00072\u0010\b\u0001\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\n0\t2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\n\u0012\u0006\b\u0000\u0012\u00020\n0\tH\u0007¨\u0006\u0010"}, d2 = {"Lkntr/app/im/chat/ui/page/CommonMsgFrameSet;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "bindsChatMsgFrameBuilderProvider", "Lkntr/app/im/chat/ui/builder/ChatMsgFrameBuilderProvider;", "map", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/ui/builder/ChatMsgFrameBuilder;", "Lkntr/app/im/chat/core/model/MsgFrame;", "Lkotlin/jvm/JvmSuppressWildcards;", "defaultBuilder", "chatTimeLabelBuilder", "Lkntr/app/im/chat/ui/builder/ChatTimeLabelBuilder;", "bindsDefaultChatMsgFrameBuilder", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class CommonMsgFrameSet {
    public static final int $stable = 0;
    public static final CommonMsgFrameSet INSTANCE = new CommonMsgFrameSet();

    private CommonMsgFrameSet() {
    }

    @Provides
    @ChatMsgModuleScope
    public final ChatMsgFrameBuilderProvider bindsChatMsgFrameBuilderProvider(Map<String, ChatMsgFrameBuilder<MsgFrame>> map, @DefaultChatMsgFrameBuilder ChatMsgFrameBuilder<? super MsgFrame> chatMsgFrameBuilder, ChatTimeLabelBuilder chatTimeLabelBuilder) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(chatMsgFrameBuilder, "defaultBuilder");
        Intrinsics.checkNotNullParameter(chatTimeLabelBuilder, "chatTimeLabelBuilder");
        return new ChatMsgFrameBuilderProviderImpl(map, chatMsgFrameBuilder, chatTimeLabelBuilder);
    }

    @Provides
    @ChatMsgModuleScope
    @DefaultChatMsgFrameBuilder
    public final ChatMsgFrameBuilder<? super MsgFrame> bindsDefaultChatMsgFrameBuilder() {
        return new EmptyChatMsgFrameBuilder();
    }
}