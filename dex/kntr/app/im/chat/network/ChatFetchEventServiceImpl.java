package kntr.app.im.chat.network;

import javax.inject.Inject;
import kntr.app.im.chat.core.service.ChatFetchEventService;
import kntr.app.im.chat.core.service.FetchEventType;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: ChatFetchEventServiceImpl.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lkntr/app/im/chat/network/ChatFetchEventServiceImpl;", "Lkntr/app/im/chat/core/service/ChatFetchEventService;", "broadcastFlow", "Lkntr/app/im/chat/network/ChatBroadcastFetchEvent;", "sendEvent", "Lkntr/app/im/chat/network/ChatSendEvent;", "loopFlow", "Lkntr/app/im/chat/network/ChatLoopFetchService;", "<init>", "(Lkntr/app/im/chat/network/ChatBroadcastFetchEvent;Lkntr/app/im/chat/network/ChatSendEvent;Lkntr/app/im/chat/network/ChatLoopFetchService;)V", "fetchMessageFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/app/im/chat/core/service/FetchEventType;", "getFetchMessageFlow", "()Lkotlinx/coroutines/flow/Flow;", "Companion", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatFetchEventServiceImpl implements ChatFetchEventService {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ChatFetchEventService";
    private final ChatBroadcastFetchEvent broadcastFlow;
    private final ChatLoopFetchService loopFlow;
    private final ChatSendEvent sendEvent;

    @Inject
    public ChatFetchEventServiceImpl(ChatBroadcastFetchEvent broadcastFlow, ChatSendEvent sendEvent, ChatLoopFetchService loopFlow) {
        Intrinsics.checkNotNullParameter(broadcastFlow, "broadcastFlow");
        Intrinsics.checkNotNullParameter(sendEvent, "sendEvent");
        Intrinsics.checkNotNullParameter(loopFlow, "loopFlow");
        this.broadcastFlow = broadcastFlow;
        this.sendEvent = sendEvent;
        this.loopFlow = loopFlow;
    }

    /* compiled from: ChatFetchEventServiceImpl.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkntr/app/im/chat/network/ChatFetchEventServiceImpl$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "TAG", RoomRecommendViewModel.EMPTY_CURSOR, "network_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // kntr.app.im.chat.core.service.ChatFetchEventService
    public Flow<FetchEventType> getFetchMessageFlow() {
        return FlowKt.channelFlow(new ChatFetchEventServiceImpl$fetchMessageFlow$1(this, null));
    }
}