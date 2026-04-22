package kntr.app.im.chat.ui.frame;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.im.chat.ui.builder.ChatMsgModuleBuilderProvider;
import kntr.app.im.chat.ui.neuron.ChatReporter;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatBubbleFrameBuilder_Factory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/im/chat/ui/frame/ChatBubbleFrameBuilder_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/ui/frame/ChatBubbleFrameBuilder;", "chatMsgModuleBuilderProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilderProvider;", "actionHandlerProvider", "Lkntr/app/im/chat/ui/ChatActionHandler;", "reporterProvider", "Lkntr/app/im/chat/ui/neuron/ChatReporter;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatBubbleFrameBuilder_Factory implements Factory<ChatBubbleFrameBuilder> {
    private final Provider<ChatActionHandler> actionHandlerProvider;
    private final Provider<ChatMsgModuleBuilderProvider> chatMsgModuleBuilderProvider;
    private final Provider<ChatReporter> reporterProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ChatBubbleFrameBuilder_Factory(Provider<ChatMsgModuleBuilderProvider> provider, Provider<ChatActionHandler> provider2, Provider<ChatReporter> provider3) {
        Intrinsics.checkNotNullParameter(provider, "chatMsgModuleBuilderProvider");
        Intrinsics.checkNotNullParameter(provider2, "actionHandlerProvider");
        Intrinsics.checkNotNullParameter(provider3, "reporterProvider");
        this.chatMsgModuleBuilderProvider = provider;
        this.actionHandlerProvider = provider2;
        this.reporterProvider = provider3;
    }

    public ChatBubbleFrameBuilder get() {
        Companion companion = Companion;
        ChatMsgModuleBuilderProvider chatMsgModuleBuilderProvider = this.chatMsgModuleBuilderProvider.get();
        Intrinsics.checkNotNullExpressionValue(chatMsgModuleBuilderProvider, "get(...)");
        ChatActionHandler chatActionHandler = this.actionHandlerProvider.get();
        Intrinsics.checkNotNullExpressionValue(chatActionHandler, "get(...)");
        ChatReporter chatReporter = this.reporterProvider.get();
        Intrinsics.checkNotNullExpressionValue(chatReporter, "get(...)");
        return companion.newInstance(chatMsgModuleBuilderProvider, chatActionHandler, chatReporter);
    }

    /* compiled from: ChatBubbleFrameBuilder_Factory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\fH\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/im/chat/ui/frame/ChatBubbleFrameBuilder_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/ui/frame/ChatBubbleFrameBuilder_Factory;", "chatMsgModuleBuilderProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilderProvider;", "actionHandlerProvider", "Lkntr/app/im/chat/ui/ChatActionHandler;", "reporterProvider", "Lkntr/app/im/chat/ui/neuron/ChatReporter;", "newInstance", "Lkntr/app/im/chat/ui/frame/ChatBubbleFrameBuilder;", "actionHandler", "reporter", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ChatBubbleFrameBuilder_Factory create(Provider<ChatMsgModuleBuilderProvider> provider, Provider<ChatActionHandler> provider2, Provider<ChatReporter> provider3) {
            Intrinsics.checkNotNullParameter(provider, "chatMsgModuleBuilderProvider");
            Intrinsics.checkNotNullParameter(provider2, "actionHandlerProvider");
            Intrinsics.checkNotNullParameter(provider3, "reporterProvider");
            return new ChatBubbleFrameBuilder_Factory(provider, provider2, provider3);
        }

        @JvmStatic
        public final ChatBubbleFrameBuilder newInstance(ChatMsgModuleBuilderProvider chatMsgModuleBuilderProvider, ChatActionHandler actionHandler, ChatReporter reporter) {
            Intrinsics.checkNotNullParameter(chatMsgModuleBuilderProvider, "chatMsgModuleBuilderProvider");
            Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
            Intrinsics.checkNotNullParameter(reporter, "reporter");
            return new ChatBubbleFrameBuilder(chatMsgModuleBuilderProvider, actionHandler, reporter);
        }
    }

    @JvmStatic
    public static final ChatBubbleFrameBuilder_Factory create(Provider<ChatMsgModuleBuilderProvider> provider, Provider<ChatActionHandler> provider2, Provider<ChatReporter> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final ChatBubbleFrameBuilder newInstance(ChatMsgModuleBuilderProvider chatMsgModuleBuilderProvider, ChatActionHandler actionHandler, ChatReporter reporter) {
        return Companion.newInstance(chatMsgModuleBuilderProvider, actionHandler, reporter);
    }
}