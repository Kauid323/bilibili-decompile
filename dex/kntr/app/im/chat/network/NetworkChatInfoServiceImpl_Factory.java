package kntr.app.im.chat.network;

import com.bapis.bilibili.app.im.v1.KSessionId;
import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetworkChatInfoServiceImpl_Factory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/app/im/chat/network/NetworkChatInfoServiceImpl_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/network/NetworkChatInfoServiceImpl;", "sessionIdProvider", "Ljavax/inject/Provider;", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NetworkChatInfoServiceImpl_Factory implements Factory<NetworkChatInfoServiceImpl> {
    public static final Companion Companion = new Companion(null);
    private final Provider<KSessionId> sessionIdProvider;

    public NetworkChatInfoServiceImpl_Factory(Provider<KSessionId> provider) {
        Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
        this.sessionIdProvider = provider;
    }

    public NetworkChatInfoServiceImpl get() {
        Companion companion = Companion;
        KSessionId kSessionId = this.sessionIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(kSessionId, "get(...)");
        return companion.newInstance(kSessionId);
    }

    /* compiled from: NetworkChatInfoServiceImpl_Factory.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/network/NetworkChatInfoServiceImpl_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/network/NetworkChatInfoServiceImpl_Factory;", "sessionIdProvider", "Ljavax/inject/Provider;", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "newInstance", "Lkntr/app/im/chat/network/NetworkChatInfoServiceImpl;", "sessionId", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final NetworkChatInfoServiceImpl_Factory create(Provider<KSessionId> provider) {
            Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
            return new NetworkChatInfoServiceImpl_Factory(provider);
        }

        @JvmStatic
        public final NetworkChatInfoServiceImpl newInstance(KSessionId sessionId) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            return new NetworkChatInfoServiceImpl(sessionId);
        }
    }

    @JvmStatic
    public static final NetworkChatInfoServiceImpl_Factory create(Provider<KSessionId> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final NetworkChatInfoServiceImpl newInstance(KSessionId sessionId) {
        return Companion.newInstance(sessionId);
    }
}