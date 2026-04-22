package kntr.app.im.chat.network;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatFetchEventServiceImpl_Factory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/im/chat/network/ChatFetchEventServiceImpl_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/network/ChatFetchEventServiceImpl;", "broadcastFlowProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/network/ChatBroadcastFetchEvent;", "sendEventProvider", "Lkntr/app/im/chat/network/ChatSendEvent;", "loopFlowProvider", "Lkntr/app/im/chat/network/ChatLoopFetchService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatFetchEventServiceImpl_Factory implements Factory<ChatFetchEventServiceImpl> {
    public static final Companion Companion = new Companion(null);
    private final Provider<ChatBroadcastFetchEvent> broadcastFlowProvider;
    private final Provider<ChatLoopFetchService> loopFlowProvider;
    private final Provider<ChatSendEvent> sendEventProvider;

    public ChatFetchEventServiceImpl_Factory(Provider<ChatBroadcastFetchEvent> provider, Provider<ChatSendEvent> provider2, Provider<ChatLoopFetchService> provider3) {
        Intrinsics.checkNotNullParameter(provider, "broadcastFlowProvider");
        Intrinsics.checkNotNullParameter(provider2, "sendEventProvider");
        Intrinsics.checkNotNullParameter(provider3, "loopFlowProvider");
        this.broadcastFlowProvider = provider;
        this.sendEventProvider = provider2;
        this.loopFlowProvider = provider3;
    }

    public ChatFetchEventServiceImpl get() {
        Companion companion = Companion;
        ChatBroadcastFetchEvent chatBroadcastFetchEvent = this.broadcastFlowProvider.get();
        Intrinsics.checkNotNullExpressionValue(chatBroadcastFetchEvent, "get(...)");
        ChatSendEvent chatSendEvent = this.sendEventProvider.get();
        Intrinsics.checkNotNullExpressionValue(chatSendEvent, "get(...)");
        ChatLoopFetchService chatLoopFetchService = this.loopFlowProvider.get();
        Intrinsics.checkNotNullExpressionValue(chatLoopFetchService, "get(...)");
        return companion.newInstance(chatBroadcastFetchEvent, chatSendEvent, chatLoopFetchService);
    }

    /* compiled from: ChatFetchEventServiceImpl_Factory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/im/chat/network/ChatFetchEventServiceImpl_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/network/ChatFetchEventServiceImpl_Factory;", "broadcastFlowProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/network/ChatBroadcastFetchEvent;", "sendEventProvider", "Lkntr/app/im/chat/network/ChatSendEvent;", "loopFlowProvider", "Lkntr/app/im/chat/network/ChatLoopFetchService;", "newInstance", "Lkntr/app/im/chat/network/ChatFetchEventServiceImpl;", "broadcastFlow", "sendEvent", "loopFlow", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ChatFetchEventServiceImpl_Factory create(Provider<ChatBroadcastFetchEvent> provider, Provider<ChatSendEvent> provider2, Provider<ChatLoopFetchService> provider3) {
            Intrinsics.checkNotNullParameter(provider, "broadcastFlowProvider");
            Intrinsics.checkNotNullParameter(provider2, "sendEventProvider");
            Intrinsics.checkNotNullParameter(provider3, "loopFlowProvider");
            return new ChatFetchEventServiceImpl_Factory(provider, provider2, provider3);
        }

        @JvmStatic
        public final ChatFetchEventServiceImpl newInstance(ChatBroadcastFetchEvent broadcastFlow, ChatSendEvent sendEvent, ChatLoopFetchService loopFlow) {
            Intrinsics.checkNotNullParameter(broadcastFlow, "broadcastFlow");
            Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
            Intrinsics.checkNotNullParameter(loopFlow, "loopFlow");
            return new ChatFetchEventServiceImpl(broadcastFlow, sendEvent, loopFlow);
        }
    }

    @JvmStatic
    public static final ChatFetchEventServiceImpl_Factory create(Provider<ChatBroadcastFetchEvent> provider, Provider<ChatSendEvent> provider2, Provider<ChatLoopFetchService> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final ChatFetchEventServiceImpl newInstance(ChatBroadcastFetchEvent broadcastFlow, ChatSendEvent sendEvent, ChatLoopFetchService loopFlow) {
        return Companion.newInstance(broadcastFlow, sendEvent, loopFlow);
    }
}