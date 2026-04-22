package kntr.app.im.chat.stateMachine;

import dagger.internal.Factory;
import im.base.IMBroadcastManager;
import im.base.SessionIdConverters;
import javax.inject.Provider;
import kntr.app.im.chat.core.service.ChatFetchEventService;
import kntr.app.im.chat.core.service.FusionChatInfoService;
import kntr.app.im.chat.core.service.FusionFetchMessageService;
import kntr.app.im.chat.core.service.MessageDatabaseService;
import kntr.app.im.chat.core.service.MessageGroupingService;
import kntr.app.im.chat.core.service.NotifyMessageService;
import kntr.app.im.chat.core.service.OperateMessageService;
import kntr.app.im.chat.core.service.SessionDatabaseService;
import kntr.app.im.chat.di.module.assistant.Assistant;
import kntr.app.im.chat.sticker.service.StickerManagerService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.account.KAccountStore;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssistantChatStateMachine_Factory.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B½\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0004\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0004\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010 \u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lkntr/app/im/chat/stateMachine/AssistantChatStateMachine_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/stateMachine/AssistantChatStateMachine;", "sessionIdProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/di/module/assistant/Assistant;", "sessionServiceProvider", "Lkntr/app/im/chat/core/service/SessionDatabaseService;", "chatInfoServiceProvider", "Lkntr/app/im/chat/core/service/FusionChatInfoService;", "fetchMessagesServiceProvider", "Lkntr/app/im/chat/core/service/FusionFetchMessageService;", "broadcastServiceProvider", "Lkntr/app/im/chat/core/service/ChatFetchEventService;", "stickerServiceProvider", "Lkntr/app/im/chat/sticker/service/StickerManagerService;", "broadcastManagerProvider", "Lim/base/IMBroadcastManager;", "accountStoreProvider", "Lkntr/base/account/KAccountStore;", "operateMessageServiceProvider", "Lkntr/app/im/chat/core/service/OperateMessageService;", "notifyMessageServiceProvider", "Lkntr/app/im/chat/core/service/NotifyMessageService;", "messageDatabaseServiceProvider", "Lkntr/app/im/chat/core/service/MessageDatabaseService;", "convertersProvider", "Lim/base/SessionIdConverters;", "groupingServiceProvider", "Lkntr/app/im/chat/core/service/MessageGroupingService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AssistantChatStateMachine_Factory implements Factory<AssistantChatStateMachine> {
    private final Provider<KAccountStore> accountStoreProvider;
    private final Provider<IMBroadcastManager> broadcastManagerProvider;
    private final Provider<ChatFetchEventService> broadcastServiceProvider;
    private final Provider<FusionChatInfoService> chatInfoServiceProvider;
    private final Provider<SessionIdConverters> convertersProvider;
    private final Provider<FusionFetchMessageService> fetchMessagesServiceProvider;
    private final Provider<MessageGroupingService> groupingServiceProvider;
    private final Provider<MessageDatabaseService> messageDatabaseServiceProvider;
    private final Provider<NotifyMessageService> notifyMessageServiceProvider;
    private final Provider<OperateMessageService> operateMessageServiceProvider;
    private final Provider<Assistant> sessionIdProvider;
    private final Provider<SessionDatabaseService> sessionServiceProvider;
    private final Provider<StickerManagerService> stickerServiceProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public AssistantChatStateMachine_Factory(Provider<Assistant> provider, Provider<SessionDatabaseService> provider2, Provider<FusionChatInfoService> provider3, Provider<FusionFetchMessageService> provider4, Provider<ChatFetchEventService> provider5, Provider<StickerManagerService> provider6, Provider<IMBroadcastManager> provider7, Provider<KAccountStore> provider8, Provider<OperateMessageService> provider9, Provider<NotifyMessageService> provider10, Provider<MessageDatabaseService> provider11, Provider<SessionIdConverters> provider12, Provider<MessageGroupingService> provider13) {
        Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
        Intrinsics.checkNotNullParameter(provider2, "sessionServiceProvider");
        Intrinsics.checkNotNullParameter(provider3, "chatInfoServiceProvider");
        Intrinsics.checkNotNullParameter(provider4, "fetchMessagesServiceProvider");
        Intrinsics.checkNotNullParameter(provider5, "broadcastServiceProvider");
        Intrinsics.checkNotNullParameter(provider6, "stickerServiceProvider");
        Intrinsics.checkNotNullParameter(provider7, "broadcastManagerProvider");
        Intrinsics.checkNotNullParameter(provider8, "accountStoreProvider");
        Intrinsics.checkNotNullParameter(provider9, "operateMessageServiceProvider");
        Intrinsics.checkNotNullParameter(provider10, "notifyMessageServiceProvider");
        Intrinsics.checkNotNullParameter(provider11, "messageDatabaseServiceProvider");
        Intrinsics.checkNotNullParameter(provider12, "convertersProvider");
        Intrinsics.checkNotNullParameter(provider13, "groupingServiceProvider");
        this.sessionIdProvider = provider;
        this.sessionServiceProvider = provider2;
        this.chatInfoServiceProvider = provider3;
        this.fetchMessagesServiceProvider = provider4;
        this.broadcastServiceProvider = provider5;
        this.stickerServiceProvider = provider6;
        this.broadcastManagerProvider = provider7;
        this.accountStoreProvider = provider8;
        this.operateMessageServiceProvider = provider9;
        this.notifyMessageServiceProvider = provider10;
        this.messageDatabaseServiceProvider = provider11;
        this.convertersProvider = provider12;
        this.groupingServiceProvider = provider13;
    }

    public AssistantChatStateMachine get() {
        Companion companion = Companion;
        Assistant assistant = this.sessionIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(assistant, "get(...)");
        SessionDatabaseService sessionDatabaseService = this.sessionServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(sessionDatabaseService, "get(...)");
        FusionChatInfoService fusionChatInfoService = this.chatInfoServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(fusionChatInfoService, "get(...)");
        FusionFetchMessageService fusionFetchMessageService = this.fetchMessagesServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(fusionFetchMessageService, "get(...)");
        ChatFetchEventService chatFetchEventService = this.broadcastServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(chatFetchEventService, "get(...)");
        StickerManagerService stickerManagerService = this.stickerServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(stickerManagerService, "get(...)");
        IMBroadcastManager iMBroadcastManager = this.broadcastManagerProvider.get();
        Intrinsics.checkNotNullExpressionValue(iMBroadcastManager, "get(...)");
        KAccountStore kAccountStore = this.accountStoreProvider.get();
        Intrinsics.checkNotNullExpressionValue(kAccountStore, "get(...)");
        OperateMessageService operateMessageService = this.operateMessageServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(operateMessageService, "get(...)");
        NotifyMessageService notifyMessageService = this.notifyMessageServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(notifyMessageService, "get(...)");
        MessageDatabaseService messageDatabaseService = this.messageDatabaseServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(messageDatabaseService, "get(...)");
        SessionIdConverters sessionIdConverters = this.convertersProvider.get();
        Intrinsics.checkNotNullExpressionValue(sessionIdConverters, "get(...)");
        MessageGroupingService messageGroupingService = this.groupingServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(messageGroupingService, "get(...)");
        return companion.newInstance(assistant, sessionDatabaseService, fusionChatInfoService, fusionFetchMessageService, chatFetchEventService, stickerManagerService, iMBroadcastManager, kAccountStore, operateMessageService, notifyMessageService, messageDatabaseService, sessionIdConverters, messageGroupingService);
    }

    /* compiled from: AssistantChatStateMachine_Factory.kt */
    @Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J¾\u0001\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00072\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00072\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00072\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0007H\u0007Jp\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020 H\u0007¨\u00060"}, d2 = {"Lkntr/app/im/chat/stateMachine/AssistantChatStateMachine_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/stateMachine/AssistantChatStateMachine_Factory;", "sessionIdProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/di/module/assistant/Assistant;", "sessionServiceProvider", "Lkntr/app/im/chat/core/service/SessionDatabaseService;", "chatInfoServiceProvider", "Lkntr/app/im/chat/core/service/FusionChatInfoService;", "fetchMessagesServiceProvider", "Lkntr/app/im/chat/core/service/FusionFetchMessageService;", "broadcastServiceProvider", "Lkntr/app/im/chat/core/service/ChatFetchEventService;", "stickerServiceProvider", "Lkntr/app/im/chat/sticker/service/StickerManagerService;", "broadcastManagerProvider", "Lim/base/IMBroadcastManager;", "accountStoreProvider", "Lkntr/base/account/KAccountStore;", "operateMessageServiceProvider", "Lkntr/app/im/chat/core/service/OperateMessageService;", "notifyMessageServiceProvider", "Lkntr/app/im/chat/core/service/NotifyMessageService;", "messageDatabaseServiceProvider", "Lkntr/app/im/chat/core/service/MessageDatabaseService;", "convertersProvider", "Lim/base/SessionIdConverters;", "groupingServiceProvider", "Lkntr/app/im/chat/core/service/MessageGroupingService;", "newInstance", "Lkntr/app/im/chat/stateMachine/AssistantChatStateMachine;", "sessionId", "sessionService", "chatInfoService", "fetchMessagesService", "broadcastService", "stickerService", "broadcastManager", "accountStore", "operateMessageService", "notifyMessageService", "messageDatabaseService", "converters", "groupingService", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AssistantChatStateMachine_Factory create(Provider<Assistant> provider, Provider<SessionDatabaseService> provider2, Provider<FusionChatInfoService> provider3, Provider<FusionFetchMessageService> provider4, Provider<ChatFetchEventService> provider5, Provider<StickerManagerService> provider6, Provider<IMBroadcastManager> provider7, Provider<KAccountStore> provider8, Provider<OperateMessageService> provider9, Provider<NotifyMessageService> provider10, Provider<MessageDatabaseService> provider11, Provider<SessionIdConverters> provider12, Provider<MessageGroupingService> provider13) {
            Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
            Intrinsics.checkNotNullParameter(provider2, "sessionServiceProvider");
            Intrinsics.checkNotNullParameter(provider3, "chatInfoServiceProvider");
            Intrinsics.checkNotNullParameter(provider4, "fetchMessagesServiceProvider");
            Intrinsics.checkNotNullParameter(provider5, "broadcastServiceProvider");
            Intrinsics.checkNotNullParameter(provider6, "stickerServiceProvider");
            Intrinsics.checkNotNullParameter(provider7, "broadcastManagerProvider");
            Intrinsics.checkNotNullParameter(provider8, "accountStoreProvider");
            Intrinsics.checkNotNullParameter(provider9, "operateMessageServiceProvider");
            Intrinsics.checkNotNullParameter(provider10, "notifyMessageServiceProvider");
            Intrinsics.checkNotNullParameter(provider11, "messageDatabaseServiceProvider");
            Intrinsics.checkNotNullParameter(provider12, "convertersProvider");
            Intrinsics.checkNotNullParameter(provider13, "groupingServiceProvider");
            return new AssistantChatStateMachine_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
        }

        @JvmStatic
        public final AssistantChatStateMachine newInstance(Assistant sessionId, SessionDatabaseService sessionService, FusionChatInfoService chatInfoService, FusionFetchMessageService fetchMessagesService, ChatFetchEventService broadcastService, StickerManagerService stickerService, IMBroadcastManager broadcastManager, KAccountStore accountStore, OperateMessageService operateMessageService, NotifyMessageService notifyMessageService, MessageDatabaseService messageDatabaseService, SessionIdConverters converters, MessageGroupingService groupingService) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(sessionService, "sessionService");
            Intrinsics.checkNotNullParameter(chatInfoService, "chatInfoService");
            Intrinsics.checkNotNullParameter(fetchMessagesService, "fetchMessagesService");
            Intrinsics.checkNotNullParameter(broadcastService, "broadcastService");
            Intrinsics.checkNotNullParameter(stickerService, "stickerService");
            Intrinsics.checkNotNullParameter(broadcastManager, "broadcastManager");
            Intrinsics.checkNotNullParameter(accountStore, "accountStore");
            Intrinsics.checkNotNullParameter(operateMessageService, "operateMessageService");
            Intrinsics.checkNotNullParameter(notifyMessageService, "notifyMessageService");
            Intrinsics.checkNotNullParameter(messageDatabaseService, "messageDatabaseService");
            Intrinsics.checkNotNullParameter(converters, "converters");
            Intrinsics.checkNotNullParameter(groupingService, "groupingService");
            return new AssistantChatStateMachine(sessionId, sessionService, chatInfoService, fetchMessagesService, broadcastService, stickerService, broadcastManager, accountStore, operateMessageService, notifyMessageService, messageDatabaseService, converters, groupingService);
        }
    }

    @JvmStatic
    public static final AssistantChatStateMachine_Factory create(Provider<Assistant> provider, Provider<SessionDatabaseService> provider2, Provider<FusionChatInfoService> provider3, Provider<FusionFetchMessageService> provider4, Provider<ChatFetchEventService> provider5, Provider<StickerManagerService> provider6, Provider<IMBroadcastManager> provider7, Provider<KAccountStore> provider8, Provider<OperateMessageService> provider9, Provider<NotifyMessageService> provider10, Provider<MessageDatabaseService> provider11, Provider<SessionIdConverters> provider12, Provider<MessageGroupingService> provider13) {
        return Companion.create(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    @JvmStatic
    public static final AssistantChatStateMachine newInstance(Assistant sessionId, SessionDatabaseService sessionService, FusionChatInfoService chatInfoService, FusionFetchMessageService fetchMessagesService, ChatFetchEventService broadcastService, StickerManagerService stickerService, IMBroadcastManager broadcastManager, KAccountStore accountStore, OperateMessageService operateMessageService, NotifyMessageService notifyMessageService, MessageDatabaseService messageDatabaseService, SessionIdConverters converters, MessageGroupingService groupingService) {
        return Companion.newInstance(sessionId, sessionService, chatInfoService, fetchMessagesService, broadcastService, stickerService, broadcastManager, accountStore, operateMessageService, notifyMessageService, messageDatabaseService, converters, groupingService);
    }
}