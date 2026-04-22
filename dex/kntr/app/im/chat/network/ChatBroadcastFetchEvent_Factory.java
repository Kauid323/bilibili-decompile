package kntr.app.im.chat.network;

import dagger.internal.Factory;
import im.base.IMBroadcastManager;
import im.base.SessionIdConverters;
import im.base.model.SessionId;
import javax.inject.Provider;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatBroadcastFetchEvent_Factory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/im/chat/network/ChatBroadcastFetchEvent_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/network/ChatBroadcastFetchEvent;", "managerProvider", "Ljavax/inject/Provider;", "Lim/base/IMBroadcastManager;", "sessionIdProvider", "Lim/base/model/SessionId;", "sessionIdConvertersProvider", "Lim/base/SessionIdConverters;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatBroadcastFetchEvent_Factory implements Factory<ChatBroadcastFetchEvent> {
    public static final Companion Companion = new Companion(null);
    private final Provider<IMBroadcastManager> managerProvider;
    private final Provider<SessionIdConverters> sessionIdConvertersProvider;
    private final Provider<SessionId> sessionIdProvider;

    public ChatBroadcastFetchEvent_Factory(Provider<IMBroadcastManager> provider, Provider<SessionId> provider2, Provider<SessionIdConverters> provider3) {
        Intrinsics.checkNotNullParameter(provider, "managerProvider");
        Intrinsics.checkNotNullParameter(provider2, "sessionIdProvider");
        Intrinsics.checkNotNullParameter(provider3, "sessionIdConvertersProvider");
        this.managerProvider = provider;
        this.sessionIdProvider = provider2;
        this.sessionIdConvertersProvider = provider3;
    }

    public ChatBroadcastFetchEvent get() {
        Companion companion = Companion;
        IMBroadcastManager iMBroadcastManager = this.managerProvider.get();
        Intrinsics.checkNotNullExpressionValue(iMBroadcastManager, "get(...)");
        SessionId sessionId = this.sessionIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(sessionId, "get(...)");
        SessionIdConverters sessionIdConverters = this.sessionIdConvertersProvider.get();
        Intrinsics.checkNotNullExpressionValue(sessionIdConverters, "get(...)");
        return companion.newInstance(iMBroadcastManager, sessionId, sessionIdConverters);
    }

    /* compiled from: ChatBroadcastFetchEvent_Factory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/im/chat/network/ChatBroadcastFetchEvent_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/network/ChatBroadcastFetchEvent_Factory;", "managerProvider", "Ljavax/inject/Provider;", "Lim/base/IMBroadcastManager;", "sessionIdProvider", "Lim/base/model/SessionId;", "sessionIdConvertersProvider", "Lim/base/SessionIdConverters;", "newInstance", "Lkntr/app/im/chat/network/ChatBroadcastFetchEvent;", "manager", "sessionId", "sessionIdConverters", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ChatBroadcastFetchEvent_Factory create(Provider<IMBroadcastManager> provider, Provider<SessionId> provider2, Provider<SessionIdConverters> provider3) {
            Intrinsics.checkNotNullParameter(provider, "managerProvider");
            Intrinsics.checkNotNullParameter(provider2, "sessionIdProvider");
            Intrinsics.checkNotNullParameter(provider3, "sessionIdConvertersProvider");
            return new ChatBroadcastFetchEvent_Factory(provider, provider2, provider3);
        }

        @JvmStatic
        public final ChatBroadcastFetchEvent newInstance(IMBroadcastManager manager, SessionId sessionId, SessionIdConverters sessionIdConverters) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(sessionIdConverters, "sessionIdConverters");
            return new ChatBroadcastFetchEvent(manager, sessionId, sessionIdConverters);
        }
    }

    @JvmStatic
    public static final ChatBroadcastFetchEvent_Factory create(Provider<IMBroadcastManager> provider, Provider<SessionId> provider2, Provider<SessionIdConverters> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final ChatBroadcastFetchEvent newInstance(IMBroadcastManager manager, SessionId sessionId, SessionIdConverters sessionIdConverters) {
        return Companion.newInstance(manager, sessionId, sessionIdConverters);
    }
}