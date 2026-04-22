package kntr.app.im.chat.stateMachine;

import dagger.internal.Factory;
import im.base.IMBroadcastManager;
import im.base.SessionIdConverters;
import javax.inject.Provider;
import kntr.app.im.chat.core.service.ChatFetchEventService;
import kntr.app.im.chat.core.service.ConversationService;
import kntr.app.im.chat.core.service.DraftDatabaseService;
import kntr.app.im.chat.core.service.FusionChatInfoService;
import kntr.app.im.chat.core.service.FusionFetchMessageService;
import kntr.app.im.chat.core.service.MessageDatabaseService;
import kntr.app.im.chat.core.service.MessageGroupingService;
import kntr.app.im.chat.core.service.MessageSendService;
import kntr.app.im.chat.core.service.OperateMessageService;
import kntr.app.im.chat.core.service.SessionDatabaseService;
import kntr.app.im.chat.di.module.personal.PersonalChat;
import kntr.app.im.chat.service.personal.PushInfoMsgService;
import kntr.app.im.chat.sticker.service.StickerManagerService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.account.KAccountStore;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PersonalChatStateMachine_Factory.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'Bç\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0004\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0004\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0004\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0004\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0004\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0004¢\u0006\u0004\b$\u0010%J\b\u0010&\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lkntr/app/im/chat/stateMachine/PersonalChatStateMachine_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/stateMachine/PersonalChatStateMachine;", "sessionIdProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/di/module/personal/PersonalChat;", "sessionServiceProvider", "Lkntr/app/im/chat/core/service/SessionDatabaseService;", "chatInfoServiceProvider", "Lkntr/app/im/chat/core/service/FusionChatInfoService;", "fetchMessagesServiceProvider", "Lkntr/app/im/chat/core/service/FusionFetchMessageService;", "sendMessageServiceProvider", "Lkntr/app/im/chat/core/service/MessageSendService;", "broadcastServiceProvider", "Lkntr/app/im/chat/core/service/ChatFetchEventService;", "broadcastManagerProvider", "Lim/base/IMBroadcastManager;", "draftServiceProvider", "Lkntr/app/im/chat/core/service/DraftDatabaseService;", "stickerServiceProvider", "Lkntr/app/im/chat/sticker/service/StickerManagerService;", "accountStoreProvider", "Lkntr/base/account/KAccountStore;", "operateMessageServiceProvider", "Lkntr/app/im/chat/core/service/OperateMessageService;", "conversationServiceProvider", "Lkntr/app/im/chat/core/service/ConversationService;", "messageDatabaseServiceProvider", "Lkntr/app/im/chat/core/service/MessageDatabaseService;", "pushInfoMsgServiceProvider", "Lkntr/app/im/chat/service/personal/PushInfoMsgService;", "convertersProvider", "Lim/base/SessionIdConverters;", "groupingServiceProvider", "Lkntr/app/im/chat/core/service/MessageGroupingService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PersonalChatStateMachine_Factory implements Factory<PersonalChatStateMachine> {
    private final Provider<KAccountStore> accountStoreProvider;
    private final Provider<IMBroadcastManager> broadcastManagerProvider;
    private final Provider<ChatFetchEventService> broadcastServiceProvider;
    private final Provider<FusionChatInfoService> chatInfoServiceProvider;
    private final Provider<ConversationService> conversationServiceProvider;
    private final Provider<SessionIdConverters> convertersProvider;
    private final Provider<DraftDatabaseService> draftServiceProvider;
    private final Provider<FusionFetchMessageService> fetchMessagesServiceProvider;
    private final Provider<MessageGroupingService> groupingServiceProvider;
    private final Provider<MessageDatabaseService> messageDatabaseServiceProvider;
    private final Provider<OperateMessageService> operateMessageServiceProvider;
    private final Provider<PushInfoMsgService> pushInfoMsgServiceProvider;
    private final Provider<MessageSendService> sendMessageServiceProvider;
    private final Provider<PersonalChat> sessionIdProvider;
    private final Provider<SessionDatabaseService> sessionServiceProvider;
    private final Provider<StickerManagerService> stickerServiceProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public PersonalChatStateMachine_Factory(Provider<PersonalChat> provider, Provider<SessionDatabaseService> provider2, Provider<FusionChatInfoService> provider3, Provider<FusionFetchMessageService> provider4, Provider<MessageSendService> provider5, Provider<ChatFetchEventService> provider6, Provider<IMBroadcastManager> provider7, Provider<DraftDatabaseService> provider8, Provider<StickerManagerService> provider9, Provider<KAccountStore> provider10, Provider<OperateMessageService> provider11, Provider<ConversationService> provider12, Provider<MessageDatabaseService> provider13, Provider<PushInfoMsgService> provider14, Provider<SessionIdConverters> provider15, Provider<MessageGroupingService> provider16) {
        Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
        Intrinsics.checkNotNullParameter(provider2, "sessionServiceProvider");
        Intrinsics.checkNotNullParameter(provider3, "chatInfoServiceProvider");
        Intrinsics.checkNotNullParameter(provider4, "fetchMessagesServiceProvider");
        Intrinsics.checkNotNullParameter(provider5, "sendMessageServiceProvider");
        Intrinsics.checkNotNullParameter(provider6, "broadcastServiceProvider");
        Intrinsics.checkNotNullParameter(provider7, "broadcastManagerProvider");
        Intrinsics.checkNotNullParameter(provider8, "draftServiceProvider");
        Intrinsics.checkNotNullParameter(provider9, "stickerServiceProvider");
        Intrinsics.checkNotNullParameter(provider10, "accountStoreProvider");
        Intrinsics.checkNotNullParameter(provider11, "operateMessageServiceProvider");
        Intrinsics.checkNotNullParameter(provider12, "conversationServiceProvider");
        Intrinsics.checkNotNullParameter(provider13, "messageDatabaseServiceProvider");
        Intrinsics.checkNotNullParameter(provider14, "pushInfoMsgServiceProvider");
        Intrinsics.checkNotNullParameter(provider15, "convertersProvider");
        Intrinsics.checkNotNullParameter(provider16, "groupingServiceProvider");
        this.sessionIdProvider = provider;
        this.sessionServiceProvider = provider2;
        this.chatInfoServiceProvider = provider3;
        this.fetchMessagesServiceProvider = provider4;
        this.sendMessageServiceProvider = provider5;
        this.broadcastServiceProvider = provider6;
        this.broadcastManagerProvider = provider7;
        this.draftServiceProvider = provider8;
        this.stickerServiceProvider = provider9;
        this.accountStoreProvider = provider10;
        this.operateMessageServiceProvider = provider11;
        this.conversationServiceProvider = provider12;
        this.messageDatabaseServiceProvider = provider13;
        this.pushInfoMsgServiceProvider = provider14;
        this.convertersProvider = provider15;
        this.groupingServiceProvider = provider16;
    }

    public PersonalChatStateMachine get() {
        Companion companion = Companion;
        PersonalChat personalChat = this.sessionIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(personalChat, "get(...)");
        SessionDatabaseService sessionDatabaseService = this.sessionServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(sessionDatabaseService, "get(...)");
        FusionChatInfoService fusionChatInfoService = this.chatInfoServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(fusionChatInfoService, "get(...)");
        FusionFetchMessageService fusionFetchMessageService = this.fetchMessagesServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(fusionFetchMessageService, "get(...)");
        MessageSendService messageSendService = this.sendMessageServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(messageSendService, "get(...)");
        ChatFetchEventService chatFetchEventService = this.broadcastServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(chatFetchEventService, "get(...)");
        IMBroadcastManager iMBroadcastManager = this.broadcastManagerProvider.get();
        Intrinsics.checkNotNullExpressionValue(iMBroadcastManager, "get(...)");
        DraftDatabaseService draftDatabaseService = this.draftServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(draftDatabaseService, "get(...)");
        StickerManagerService stickerManagerService = this.stickerServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(stickerManagerService, "get(...)");
        KAccountStore kAccountStore = this.accountStoreProvider.get();
        Intrinsics.checkNotNullExpressionValue(kAccountStore, "get(...)");
        OperateMessageService operateMessageService = this.operateMessageServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(operateMessageService, "get(...)");
        ConversationService conversationService = this.conversationServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(conversationService, "get(...)");
        MessageDatabaseService messageDatabaseService = this.messageDatabaseServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(messageDatabaseService, "get(...)");
        PushInfoMsgService pushInfoMsgService = this.pushInfoMsgServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(pushInfoMsgService, "get(...)");
        PushInfoMsgService pushInfoMsgService2 = pushInfoMsgService;
        SessionIdConverters sessionIdConverters = this.convertersProvider.get();
        Intrinsics.checkNotNullExpressionValue(sessionIdConverters, "get(...)");
        SessionIdConverters sessionIdConverters2 = sessionIdConverters;
        MessageGroupingService messageGroupingService = this.groupingServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(messageGroupingService, "get(...)");
        return companion.newInstance(personalChat, sessionDatabaseService, fusionChatInfoService, fusionFetchMessageService, messageSendService, chatFetchEventService, iMBroadcastManager, draftDatabaseService, stickerManagerService, kAccountStore, operateMessageService, conversationService, messageDatabaseService, pushInfoMsgService2, sessionIdConverters2, messageGroupingService);
    }

    /* compiled from: PersonalChatStateMachine_Factory.kt */
    @Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jè\u0001\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00072\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00072\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00072\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00072\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00072\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0007H\u0007J\u0088\u0001\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u001c2\u0006\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u00020 2\u0006\u00106\u001a\u00020\"2\u0006\u00107\u001a\u00020$2\u0006\u00108\u001a\u00020&H\u0007¨\u00069"}, d2 = {"Lkntr/app/im/chat/stateMachine/PersonalChatStateMachine_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/stateMachine/PersonalChatStateMachine_Factory;", "sessionIdProvider", "Ljavax/inject/Provider;", "Lkntr/app/im/chat/di/module/personal/PersonalChat;", "sessionServiceProvider", "Lkntr/app/im/chat/core/service/SessionDatabaseService;", "chatInfoServiceProvider", "Lkntr/app/im/chat/core/service/FusionChatInfoService;", "fetchMessagesServiceProvider", "Lkntr/app/im/chat/core/service/FusionFetchMessageService;", "sendMessageServiceProvider", "Lkntr/app/im/chat/core/service/MessageSendService;", "broadcastServiceProvider", "Lkntr/app/im/chat/core/service/ChatFetchEventService;", "broadcastManagerProvider", "Lim/base/IMBroadcastManager;", "draftServiceProvider", "Lkntr/app/im/chat/core/service/DraftDatabaseService;", "stickerServiceProvider", "Lkntr/app/im/chat/sticker/service/StickerManagerService;", "accountStoreProvider", "Lkntr/base/account/KAccountStore;", "operateMessageServiceProvider", "Lkntr/app/im/chat/core/service/OperateMessageService;", "conversationServiceProvider", "Lkntr/app/im/chat/core/service/ConversationService;", "messageDatabaseServiceProvider", "Lkntr/app/im/chat/core/service/MessageDatabaseService;", "pushInfoMsgServiceProvider", "Lkntr/app/im/chat/service/personal/PushInfoMsgService;", "convertersProvider", "Lim/base/SessionIdConverters;", "groupingServiceProvider", "Lkntr/app/im/chat/core/service/MessageGroupingService;", "newInstance", "Lkntr/app/im/chat/stateMachine/PersonalChatStateMachine;", "sessionId", "sessionService", "chatInfoService", "fetchMessagesService", "sendMessageService", "broadcastService", "broadcastManager", "draftService", "stickerService", "accountStore", "operateMessageService", "conversationService", "messageDatabaseService", "pushInfoMsgService", "converters", "groupingService", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PersonalChatStateMachine_Factory create(Provider<PersonalChat> provider, Provider<SessionDatabaseService> provider2, Provider<FusionChatInfoService> provider3, Provider<FusionFetchMessageService> provider4, Provider<MessageSendService> provider5, Provider<ChatFetchEventService> provider6, Provider<IMBroadcastManager> provider7, Provider<DraftDatabaseService> provider8, Provider<StickerManagerService> provider9, Provider<KAccountStore> provider10, Provider<OperateMessageService> provider11, Provider<ConversationService> provider12, Provider<MessageDatabaseService> provider13, Provider<PushInfoMsgService> provider14, Provider<SessionIdConverters> provider15, Provider<MessageGroupingService> provider16) {
            Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
            Intrinsics.checkNotNullParameter(provider2, "sessionServiceProvider");
            Intrinsics.checkNotNullParameter(provider3, "chatInfoServiceProvider");
            Intrinsics.checkNotNullParameter(provider4, "fetchMessagesServiceProvider");
            Intrinsics.checkNotNullParameter(provider5, "sendMessageServiceProvider");
            Intrinsics.checkNotNullParameter(provider6, "broadcastServiceProvider");
            Intrinsics.checkNotNullParameter(provider7, "broadcastManagerProvider");
            Intrinsics.checkNotNullParameter(provider8, "draftServiceProvider");
            Intrinsics.checkNotNullParameter(provider9, "stickerServiceProvider");
            Intrinsics.checkNotNullParameter(provider10, "accountStoreProvider");
            Intrinsics.checkNotNullParameter(provider11, "operateMessageServiceProvider");
            Intrinsics.checkNotNullParameter(provider12, "conversationServiceProvider");
            Intrinsics.checkNotNullParameter(provider13, "messageDatabaseServiceProvider");
            Intrinsics.checkNotNullParameter(provider14, "pushInfoMsgServiceProvider");
            Intrinsics.checkNotNullParameter(provider15, "convertersProvider");
            Intrinsics.checkNotNullParameter(provider16, "groupingServiceProvider");
            return new PersonalChatStateMachine_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16);
        }

        @JvmStatic
        public final PersonalChatStateMachine newInstance(PersonalChat sessionId, SessionDatabaseService sessionService, FusionChatInfoService chatInfoService, FusionFetchMessageService fetchMessagesService, MessageSendService sendMessageService, ChatFetchEventService broadcastService, IMBroadcastManager broadcastManager, DraftDatabaseService draftService, StickerManagerService stickerService, KAccountStore accountStore, OperateMessageService operateMessageService, ConversationService conversationService, MessageDatabaseService messageDatabaseService, PushInfoMsgService pushInfoMsgService, SessionIdConverters converters, MessageGroupingService groupingService) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(sessionService, "sessionService");
            Intrinsics.checkNotNullParameter(chatInfoService, "chatInfoService");
            Intrinsics.checkNotNullParameter(fetchMessagesService, "fetchMessagesService");
            Intrinsics.checkNotNullParameter(sendMessageService, "sendMessageService");
            Intrinsics.checkNotNullParameter(broadcastService, "broadcastService");
            Intrinsics.checkNotNullParameter(broadcastManager, "broadcastManager");
            Intrinsics.checkNotNullParameter(draftService, "draftService");
            Intrinsics.checkNotNullParameter(stickerService, "stickerService");
            Intrinsics.checkNotNullParameter(accountStore, "accountStore");
            Intrinsics.checkNotNullParameter(operateMessageService, "operateMessageService");
            Intrinsics.checkNotNullParameter(conversationService, "conversationService");
            Intrinsics.checkNotNullParameter(messageDatabaseService, "messageDatabaseService");
            Intrinsics.checkNotNullParameter(pushInfoMsgService, "pushInfoMsgService");
            Intrinsics.checkNotNullParameter(converters, "converters");
            Intrinsics.checkNotNullParameter(groupingService, "groupingService");
            return new PersonalChatStateMachine(sessionId, sessionService, chatInfoService, fetchMessagesService, sendMessageService, broadcastService, broadcastManager, draftService, stickerService, accountStore, operateMessageService, conversationService, messageDatabaseService, pushInfoMsgService, converters, groupingService);
        }
    }

    @JvmStatic
    public static final PersonalChatStateMachine_Factory create(Provider<PersonalChat> provider, Provider<SessionDatabaseService> provider2, Provider<FusionChatInfoService> provider3, Provider<FusionFetchMessageService> provider4, Provider<MessageSendService> provider5, Provider<ChatFetchEventService> provider6, Provider<IMBroadcastManager> provider7, Provider<DraftDatabaseService> provider8, Provider<StickerManagerService> provider9, Provider<KAccountStore> provider10, Provider<OperateMessageService> provider11, Provider<ConversationService> provider12, Provider<MessageDatabaseService> provider13, Provider<PushInfoMsgService> provider14, Provider<SessionIdConverters> provider15, Provider<MessageGroupingService> provider16) {
        return Companion.create(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16);
    }

    @JvmStatic
    public static final PersonalChatStateMachine newInstance(PersonalChat sessionId, SessionDatabaseService sessionService, FusionChatInfoService chatInfoService, FusionFetchMessageService fetchMessagesService, MessageSendService sendMessageService, ChatFetchEventService broadcastService, IMBroadcastManager broadcastManager, DraftDatabaseService draftService, StickerManagerService stickerService, KAccountStore accountStore, OperateMessageService operateMessageService, ConversationService conversationService, MessageDatabaseService messageDatabaseService, PushInfoMsgService pushInfoMsgService, SessionIdConverters converters, MessageGroupingService groupingService) {
        return Companion.newInstance(sessionId, sessionService, chatInfoService, fetchMessagesService, sendMessageService, broadcastService, broadcastManager, draftService, stickerService, accountStore, operateMessageService, conversationService, messageDatabaseService, pushInfoMsgService, converters, groupingService);
    }
}