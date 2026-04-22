package kntr.app.im.chat.ui.module.pushVideo.di;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.im.chat.ui.builder.ChatMsgModuleBuilder;
import kntr.app.im.chat.ui.module.pushVideo.ChatMsgPushVideoModuleBuilder;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMsgPushVideoModuleModule_ProvideChatMsgPushVideoModuleBuilderFactory.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \n2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\nB\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkntr/app/im/chat/ui/module/pushVideo/di/ChatMsgPushVideoModuleModule_ProvideChatMsgPushVideoModuleBuilderFactory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilder;", "Lkntr/app/im/chat/core/model/MsgModule;", "textProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/ui/module/pushVideo/ChatMsgPushVideoModuleBuilder;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatMsgPushVideoModuleModule_ProvideChatMsgPushVideoModuleBuilderFactory implements Factory<ChatMsgModuleBuilder<MsgModule>> {
    private final Provider<ChatMsgPushVideoModuleBuilder> textProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ChatMsgPushVideoModuleModule_ProvideChatMsgPushVideoModuleBuilderFactory(Provider<ChatMsgPushVideoModuleBuilder> provider) {
        Intrinsics.checkNotNullParameter(provider, "textProvider");
        this.textProvider = provider;
    }

    public ChatMsgModuleBuilder<MsgModule> get() {
        Companion companion = Companion;
        ChatMsgPushVideoModuleBuilder chatMsgPushVideoModuleBuilder = this.textProvider.get();
        Intrinsics.checkNotNullExpressionValue(chatMsgPushVideoModuleBuilder, "get(...)");
        return companion.provideChatMsgPushVideoModuleBuilder(chatMsgPushVideoModuleBuilder);
    }

    /* compiled from: ChatMsgPushVideoModuleModule_ProvideChatMsgPushVideoModuleBuilderFactory.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\bH\u0007¨\u0006\r"}, d2 = {"Lkntr/app/im/chat/ui/module/pushVideo/di/ChatMsgPushVideoModuleModule_ProvideChatMsgPushVideoModuleBuilderFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/ui/module/pushVideo/di/ChatMsgPushVideoModuleModule_ProvideChatMsgPushVideoModuleBuilderFactory;", "textProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/ui/module/pushVideo/ChatMsgPushVideoModuleBuilder;", "provideChatMsgPushVideoModuleBuilder", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilder;", "Lkntr/app/im/chat/core/model/MsgModule;", "text", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ChatMsgPushVideoModuleModule_ProvideChatMsgPushVideoModuleBuilderFactory create(Provider<ChatMsgPushVideoModuleBuilder> provider) {
            Intrinsics.checkNotNullParameter(provider, "textProvider");
            return new ChatMsgPushVideoModuleModule_ProvideChatMsgPushVideoModuleBuilderFactory(provider);
        }

        @JvmStatic
        public final ChatMsgModuleBuilder<MsgModule> provideChatMsgPushVideoModuleBuilder(ChatMsgPushVideoModuleBuilder text) {
            Intrinsics.checkNotNullParameter(text, "text");
            return ChatMsgPushVideoModuleModule.INSTANCE.provideChatMsgPushVideoModuleBuilder(text);
        }
    }

    @JvmStatic
    public static final ChatMsgPushVideoModuleModule_ProvideChatMsgPushVideoModuleBuilderFactory create(Provider<ChatMsgPushVideoModuleBuilder> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final ChatMsgModuleBuilder<MsgModule> provideChatMsgPushVideoModuleBuilder(ChatMsgPushVideoModuleBuilder text) {
        return Companion.provideChatMsgPushVideoModuleBuilder(text);
    }
}