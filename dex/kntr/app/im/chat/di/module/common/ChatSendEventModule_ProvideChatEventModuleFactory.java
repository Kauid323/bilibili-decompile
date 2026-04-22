package kntr.app.im.chat.di.module.common;

import dagger.internal.Factory;
import im.base.model.SessionId;
import javax.inject.Provider;
import kntr.app.im.chat.network.ChatSendEvent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatSendEventModule_ProvideChatEventModuleFactory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/app/im/chat/di/module/common/ChatSendEventModule_ProvideChatEventModuleFactory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/network/ChatSendEvent;", "sessionIdProvider", "Ljavax/inject/Provider;", "Lim/base/model/SessionId;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatSendEventModule_ProvideChatEventModuleFactory implements Factory<ChatSendEvent> {
    private final Provider<SessionId> sessionIdProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ChatSendEventModule_ProvideChatEventModuleFactory(Provider<SessionId> provider) {
        Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
        this.sessionIdProvider = provider;
    }

    public ChatSendEvent get() {
        Companion companion = Companion;
        SessionId sessionId = this.sessionIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(sessionId, "get(...)");
        return companion.provideChatEventModule(sessionId);
    }

    /* compiled from: ChatSendEventModule_ProvideChatEventModuleFactory.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/di/module/common/ChatSendEventModule_ProvideChatEventModuleFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/di/module/common/ChatSendEventModule_ProvideChatEventModuleFactory;", "sessionIdProvider", "Ljavax/inject/Provider;", "Lim/base/model/SessionId;", "provideChatEventModule", "Lkntr/app/im/chat/network/ChatSendEvent;", "sessionId", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ChatSendEventModule_ProvideChatEventModuleFactory create(Provider<SessionId> provider) {
            Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
            return new ChatSendEventModule_ProvideChatEventModuleFactory(provider);
        }

        @JvmStatic
        public final ChatSendEvent provideChatEventModule(SessionId sessionId) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            return ChatSendEventModule.INSTANCE.provideChatEventModule(sessionId);
        }
    }

    @JvmStatic
    public static final ChatSendEventModule_ProvideChatEventModuleFactory create(Provider<SessionId> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final ChatSendEvent provideChatEventModule(SessionId sessionId) {
        return Companion.provideChatEventModule(sessionId);
    }
}