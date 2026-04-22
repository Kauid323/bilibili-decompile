package kntr.app.im.chat.network;

import com.bapis.bilibili.app.im.v1.KSessionId;
import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetworkOperateMessageServiceImpl_Factory.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/network/NetworkOperateMessageServiceImpl_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/network/NetworkOperateMessageServiceImpl;", "sessionIdProvider", "Ljavax/inject/Provider;", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "sendEventProvider", "Lkntr/app/im/chat/network/ChatSendEvent;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NetworkOperateMessageServiceImpl_Factory implements Factory<NetworkOperateMessageServiceImpl> {
    public static final Companion Companion = new Companion(null);
    private final Provider<ChatSendEvent> sendEventProvider;
    private final Provider<KSessionId> sessionIdProvider;

    public NetworkOperateMessageServiceImpl_Factory(Provider<KSessionId> provider, Provider<ChatSendEvent> provider2) {
        Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
        Intrinsics.checkNotNullParameter(provider2, "sendEventProvider");
        this.sessionIdProvider = provider;
        this.sendEventProvider = provider2;
    }

    public NetworkOperateMessageServiceImpl get() {
        Companion companion = Companion;
        KSessionId kSessionId = this.sessionIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(kSessionId, "get(...)");
        ChatSendEvent chatSendEvent = this.sendEventProvider.get();
        Intrinsics.checkNotNullExpressionValue(chatSendEvent, "get(...)");
        return companion.newInstance(kSessionId, chatSendEvent);
    }

    /* compiled from: NetworkOperateMessageServiceImpl_Factory.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nH\u0007¨\u0006\u000f"}, d2 = {"Lkntr/app/im/chat/network/NetworkOperateMessageServiceImpl_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/network/NetworkOperateMessageServiceImpl_Factory;", "sessionIdProvider", "Ljavax/inject/Provider;", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "sendEventProvider", "Lkntr/app/im/chat/network/ChatSendEvent;", "newInstance", "Lkntr/app/im/chat/network/NetworkOperateMessageServiceImpl;", "sessionId", "sendEvent", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final NetworkOperateMessageServiceImpl_Factory create(Provider<KSessionId> provider, Provider<ChatSendEvent> provider2) {
            Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
            Intrinsics.checkNotNullParameter(provider2, "sendEventProvider");
            return new NetworkOperateMessageServiceImpl_Factory(provider, provider2);
        }

        @JvmStatic
        public final NetworkOperateMessageServiceImpl newInstance(KSessionId sessionId, ChatSendEvent sendEvent) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
            return new NetworkOperateMessageServiceImpl(sessionId, sendEvent);
        }
    }

    @JvmStatic
    public static final NetworkOperateMessageServiceImpl_Factory create(Provider<KSessionId> provider, Provider<ChatSendEvent> provider2) {
        return Companion.create(provider, provider2);
    }

    @JvmStatic
    public static final NetworkOperateMessageServiceImpl newInstance(KSessionId sessionId, ChatSendEvent sendEvent) {
        return Companion.newInstance(sessionId, sendEvent);
    }
}