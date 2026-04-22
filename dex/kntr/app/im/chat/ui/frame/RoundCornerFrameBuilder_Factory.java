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

/* compiled from: RoundCornerFrameBuilder_Factory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/im/chat/ui/frame/RoundCornerFrameBuilder_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/ui/frame/RoundCornerFrameBuilder;", "actionHandlerProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/ui/ChatActionHandler;", "chatMsgModuleBuilderProvider", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilderProvider;", "reporterProvider", "Lkntr/app/im/chat/ui/neuron/ChatReporter;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RoundCornerFrameBuilder_Factory implements Factory<RoundCornerFrameBuilder> {
    private final Provider<ChatActionHandler> actionHandlerProvider;
    private final Provider<ChatMsgModuleBuilderProvider> chatMsgModuleBuilderProvider;
    private final Provider<ChatReporter> reporterProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public RoundCornerFrameBuilder_Factory(Provider<ChatActionHandler> provider, Provider<ChatMsgModuleBuilderProvider> provider2, Provider<ChatReporter> provider3) {
        Intrinsics.checkNotNullParameter(provider, "actionHandlerProvider");
        Intrinsics.checkNotNullParameter(provider2, "chatMsgModuleBuilderProvider");
        Intrinsics.checkNotNullParameter(provider3, "reporterProvider");
        this.actionHandlerProvider = provider;
        this.chatMsgModuleBuilderProvider = provider2;
        this.reporterProvider = provider3;
    }

    public RoundCornerFrameBuilder get() {
        Companion companion = Companion;
        ChatActionHandler chatActionHandler = this.actionHandlerProvider.get();
        Intrinsics.checkNotNullExpressionValue(chatActionHandler, "get(...)");
        ChatMsgModuleBuilderProvider chatMsgModuleBuilderProvider = this.chatMsgModuleBuilderProvider.get();
        Intrinsics.checkNotNullExpressionValue(chatMsgModuleBuilderProvider, "get(...)");
        ChatReporter chatReporter = this.reporterProvider.get();
        Intrinsics.checkNotNullExpressionValue(chatReporter, "get(...)");
        return companion.newInstance(chatActionHandler, chatMsgModuleBuilderProvider, chatReporter);
    }

    /* compiled from: RoundCornerFrameBuilder_Factory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\fH\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/im/chat/ui/frame/RoundCornerFrameBuilder_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/ui/frame/RoundCornerFrameBuilder_Factory;", "actionHandlerProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/ui/ChatActionHandler;", "chatMsgModuleBuilderProvider", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilderProvider;", "reporterProvider", "Lkntr/app/im/chat/ui/neuron/ChatReporter;", "newInstance", "Lkntr/app/im/chat/ui/frame/RoundCornerFrameBuilder;", "actionHandler", "reporter", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final RoundCornerFrameBuilder_Factory create(Provider<ChatActionHandler> provider, Provider<ChatMsgModuleBuilderProvider> provider2, Provider<ChatReporter> provider3) {
            Intrinsics.checkNotNullParameter(provider, "actionHandlerProvider");
            Intrinsics.checkNotNullParameter(provider2, "chatMsgModuleBuilderProvider");
            Intrinsics.checkNotNullParameter(provider3, "reporterProvider");
            return new RoundCornerFrameBuilder_Factory(provider, provider2, provider3);
        }

        @JvmStatic
        public final RoundCornerFrameBuilder newInstance(ChatActionHandler actionHandler, ChatMsgModuleBuilderProvider chatMsgModuleBuilderProvider, ChatReporter reporter) {
            Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
            Intrinsics.checkNotNullParameter(chatMsgModuleBuilderProvider, "chatMsgModuleBuilderProvider");
            Intrinsics.checkNotNullParameter(reporter, "reporter");
            return new RoundCornerFrameBuilder(actionHandler, chatMsgModuleBuilderProvider, reporter);
        }
    }

    @JvmStatic
    public static final RoundCornerFrameBuilder_Factory create(Provider<ChatActionHandler> provider, Provider<ChatMsgModuleBuilderProvider> provider2, Provider<ChatReporter> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final RoundCornerFrameBuilder newInstance(ChatActionHandler actionHandler, ChatMsgModuleBuilderProvider chatMsgModuleBuilderProvider, ChatReporter reporter) {
        return Companion.newInstance(actionHandler, chatMsgModuleBuilderProvider, reporter);
    }
}