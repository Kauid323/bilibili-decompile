package kntr.app.im.chat.di.module.assistant;

import dagger.internal.Factory;
import im.base.model.SessionId;
import javax.inject.Provider;
import kntr.app.im.chat.core.service.ChatInfoDatabaseService;
import kntr.app.im.chat.core.service.FusionChatInfoService;
import kntr.app.im.chat.core.service.NetworkChatInfoService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssistantChatInfoModule_FusionChatInfoServiceFactory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/im/chat/di/module/assistant/AssistantChatInfoModule_FusionChatInfoServiceFactory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/core/service/FusionChatInfoService;", "sessionIdProvider", "Ljavax/inject/Provider;", "Lim/base/model/SessionId;", "networkServiceProvider", "Lkntr/app/im/chat/core/service/NetworkChatInfoService;", "databaseServiceProvider", "Lkntr/app/im/chat/core/service/ChatInfoDatabaseService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AssistantChatInfoModule_FusionChatInfoServiceFactory implements Factory<FusionChatInfoService> {
    private final Provider<ChatInfoDatabaseService> databaseServiceProvider;
    private final Provider<NetworkChatInfoService> networkServiceProvider;
    private final Provider<SessionId> sessionIdProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public AssistantChatInfoModule_FusionChatInfoServiceFactory(Provider<SessionId> provider, Provider<NetworkChatInfoService> provider2, Provider<ChatInfoDatabaseService> provider3) {
        Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
        Intrinsics.checkNotNullParameter(provider2, "networkServiceProvider");
        Intrinsics.checkNotNullParameter(provider3, "databaseServiceProvider");
        this.sessionIdProvider = provider;
        this.networkServiceProvider = provider2;
        this.databaseServiceProvider = provider3;
    }

    public FusionChatInfoService get() {
        Companion companion = Companion;
        SessionId sessionId = this.sessionIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(sessionId, "get(...)");
        NetworkChatInfoService networkChatInfoService = this.networkServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(networkChatInfoService, "get(...)");
        ChatInfoDatabaseService chatInfoDatabaseService = this.databaseServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(chatInfoDatabaseService, "get(...)");
        return companion.fusionChatInfoService(sessionId, networkChatInfoService, chatInfoDatabaseService);
    }

    /* compiled from: AssistantChatInfoModule_FusionChatInfoServiceFactory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/im/chat/di/module/assistant/AssistantChatInfoModule_FusionChatInfoServiceFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/di/module/assistant/AssistantChatInfoModule_FusionChatInfoServiceFactory;", "sessionIdProvider", "Ljavax/inject/Provider;", "Lim/base/model/SessionId;", "networkServiceProvider", "Lkntr/app/im/chat/core/service/NetworkChatInfoService;", "databaseServiceProvider", "Lkntr/app/im/chat/core/service/ChatInfoDatabaseService;", "fusionChatInfoService", "Lkntr/app/im/chat/core/service/FusionChatInfoService;", "sessionId", "networkService", "databaseService", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AssistantChatInfoModule_FusionChatInfoServiceFactory create(Provider<SessionId> provider, Provider<NetworkChatInfoService> provider2, Provider<ChatInfoDatabaseService> provider3) {
            Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
            Intrinsics.checkNotNullParameter(provider2, "networkServiceProvider");
            Intrinsics.checkNotNullParameter(provider3, "databaseServiceProvider");
            return new AssistantChatInfoModule_FusionChatInfoServiceFactory(provider, provider2, provider3);
        }

        @JvmStatic
        public final FusionChatInfoService fusionChatInfoService(SessionId sessionId, NetworkChatInfoService networkService, ChatInfoDatabaseService databaseService) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(networkService, "networkService");
            Intrinsics.checkNotNullParameter(databaseService, "databaseService");
            return AssistantChatInfoModule.INSTANCE.fusionChatInfoService(sessionId, networkService, databaseService);
        }
    }

    @JvmStatic
    public static final AssistantChatInfoModule_FusionChatInfoServiceFactory create(Provider<SessionId> provider, Provider<NetworkChatInfoService> provider2, Provider<ChatInfoDatabaseService> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final FusionChatInfoService fusionChatInfoService(SessionId sessionId, NetworkChatInfoService networkService, ChatInfoDatabaseService databaseService) {
        return Companion.fusionChatInfoService(sessionId, networkService, databaseService);
    }
}