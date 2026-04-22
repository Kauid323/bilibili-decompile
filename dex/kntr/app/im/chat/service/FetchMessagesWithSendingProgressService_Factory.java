package kntr.app.im.chat.service;

import com.bapis.bilibili.app.im.v1.KSessionId;
import dagger.internal.Factory;
import im.base.model.SessionId;
import javax.inject.Provider;
import kntr.app.im.chat.core.service.MessageDatabaseService;
import kntr.app.im.chat.core.service.MessageSendService;
import kntr.app.im.chat.core.service.NetworkFetchMessageService;
import kntr.app.im.chat.core.service.RangeDatabaseService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.account.KAccountStore;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FetchMessagesWithSendingProgressService_Factory.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015Bi\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lkntr/app/im/chat/service/FetchMessagesWithSendingProgressService_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/service/FetchMessagesWithSendingProgressService;", "sessionIdProvider", "Ljavax/inject/Provider;", "Lim/base/model/SessionId;", "kSessionIdProvider", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "networkServiceProvider", "Lkntr/app/im/chat/core/service/NetworkFetchMessageService;", "messageDatabaseServiceProvider", "Lkntr/app/im/chat/core/service/MessageDatabaseService;", "rangeDatabaseServiceProvider", "Lkntr/app/im/chat/core/service/RangeDatabaseService;", "sendServiceProvider", "Lkntr/app/im/chat/core/service/MessageSendService;", "accountProvider", "Lkntr/base/account/KAccountStore;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FetchMessagesWithSendingProgressService_Factory implements Factory<FetchMessagesWithSendingProgressService> {
    private final Provider<KAccountStore> accountProvider;
    private final Provider<KSessionId> kSessionIdProvider;
    private final Provider<MessageDatabaseService> messageDatabaseServiceProvider;
    private final Provider<NetworkFetchMessageService> networkServiceProvider;
    private final Provider<RangeDatabaseService> rangeDatabaseServiceProvider;
    private final Provider<MessageSendService> sendServiceProvider;
    private final Provider<SessionId> sessionIdProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public FetchMessagesWithSendingProgressService_Factory(Provider<SessionId> provider, Provider<KSessionId> provider2, Provider<NetworkFetchMessageService> provider3, Provider<MessageDatabaseService> provider4, Provider<RangeDatabaseService> provider5, Provider<MessageSendService> provider6, Provider<KAccountStore> provider7) {
        Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
        Intrinsics.checkNotNullParameter(provider2, "kSessionIdProvider");
        Intrinsics.checkNotNullParameter(provider3, "networkServiceProvider");
        Intrinsics.checkNotNullParameter(provider4, "messageDatabaseServiceProvider");
        Intrinsics.checkNotNullParameter(provider5, "rangeDatabaseServiceProvider");
        Intrinsics.checkNotNullParameter(provider6, "sendServiceProvider");
        Intrinsics.checkNotNullParameter(provider7, "accountProvider");
        this.sessionIdProvider = provider;
        this.kSessionIdProvider = provider2;
        this.networkServiceProvider = provider3;
        this.messageDatabaseServiceProvider = provider4;
        this.rangeDatabaseServiceProvider = provider5;
        this.sendServiceProvider = provider6;
        this.accountProvider = provider7;
    }

    public FetchMessagesWithSendingProgressService get() {
        Companion companion = Companion;
        SessionId sessionId = this.sessionIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(sessionId, "get(...)");
        KSessionId kSessionId = this.kSessionIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(kSessionId, "get(...)");
        NetworkFetchMessageService networkFetchMessageService = this.networkServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(networkFetchMessageService, "get(...)");
        MessageDatabaseService messageDatabaseService = this.messageDatabaseServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(messageDatabaseService, "get(...)");
        RangeDatabaseService rangeDatabaseService = this.rangeDatabaseServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(rangeDatabaseService, "get(...)");
        MessageSendService messageSendService = this.sendServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(messageSendService, "get(...)");
        KAccountStore kAccountStore = this.accountProvider.get();
        Intrinsics.checkNotNullExpressionValue(kAccountStore, "get(...)");
        return companion.newInstance(sessionId, kSessionId, networkFetchMessageService, messageDatabaseService, rangeDatabaseService, messageSendService, kAccountStore);
    }

    /* compiled from: FetchMessagesWithSendingProgressService_Factory.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jj\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0007H\u0007J@\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0014H\u0007¨\u0006\u001e"}, d2 = {"Lkntr/app/im/chat/service/FetchMessagesWithSendingProgressService_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/service/FetchMessagesWithSendingProgressService_Factory;", "sessionIdProvider", "Ljavax/inject/Provider;", "Lim/base/model/SessionId;", "kSessionIdProvider", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "networkServiceProvider", "Lkntr/app/im/chat/core/service/NetworkFetchMessageService;", "messageDatabaseServiceProvider", "Lkntr/app/im/chat/core/service/MessageDatabaseService;", "rangeDatabaseServiceProvider", "Lkntr/app/im/chat/core/service/RangeDatabaseService;", "sendServiceProvider", "Lkntr/app/im/chat/core/service/MessageSendService;", "accountProvider", "Lkntr/base/account/KAccountStore;", "newInstance", "Lkntr/app/im/chat/service/FetchMessagesWithSendingProgressService;", "sessionId", "kSessionId", "networkService", "messageDatabaseService", "rangeDatabaseService", "sendService", "account", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FetchMessagesWithSendingProgressService_Factory create(Provider<SessionId> provider, Provider<KSessionId> provider2, Provider<NetworkFetchMessageService> provider3, Provider<MessageDatabaseService> provider4, Provider<RangeDatabaseService> provider5, Provider<MessageSendService> provider6, Provider<KAccountStore> provider7) {
            Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
            Intrinsics.checkNotNullParameter(provider2, "kSessionIdProvider");
            Intrinsics.checkNotNullParameter(provider3, "networkServiceProvider");
            Intrinsics.checkNotNullParameter(provider4, "messageDatabaseServiceProvider");
            Intrinsics.checkNotNullParameter(provider5, "rangeDatabaseServiceProvider");
            Intrinsics.checkNotNullParameter(provider6, "sendServiceProvider");
            Intrinsics.checkNotNullParameter(provider7, "accountProvider");
            return new FetchMessagesWithSendingProgressService_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
        }

        @JvmStatic
        public final FetchMessagesWithSendingProgressService newInstance(SessionId sessionId, KSessionId kSessionId, NetworkFetchMessageService networkService, MessageDatabaseService messageDatabaseService, RangeDatabaseService rangeDatabaseService, MessageSendService sendService, KAccountStore account) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(kSessionId, "kSessionId");
            Intrinsics.checkNotNullParameter(networkService, "networkService");
            Intrinsics.checkNotNullParameter(messageDatabaseService, "messageDatabaseService");
            Intrinsics.checkNotNullParameter(rangeDatabaseService, "rangeDatabaseService");
            Intrinsics.checkNotNullParameter(sendService, "sendService");
            Intrinsics.checkNotNullParameter(account, "account");
            return new FetchMessagesWithSendingProgressService(sessionId, kSessionId, networkService, messageDatabaseService, rangeDatabaseService, sendService, account);
        }
    }

    @JvmStatic
    public static final FetchMessagesWithSendingProgressService_Factory create(Provider<SessionId> provider, Provider<KSessionId> provider2, Provider<NetworkFetchMessageService> provider3, Provider<MessageDatabaseService> provider4, Provider<RangeDatabaseService> provider5, Provider<MessageSendService> provider6, Provider<KAccountStore> provider7) {
        return Companion.create(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @JvmStatic
    public static final FetchMessagesWithSendingProgressService newInstance(SessionId sessionId, KSessionId kSessionId, NetworkFetchMessageService networkService, MessageDatabaseService messageDatabaseService, RangeDatabaseService rangeDatabaseService, MessageSendService sendService, KAccountStore account) {
        return Companion.newInstance(sessionId, kSessionId, networkService, messageDatabaseService, rangeDatabaseService, sendService, account);
    }
}