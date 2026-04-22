package kntr.app.im.chat.di.module.assistant;

import dagger.Module;
import dagger.Provides;
import im.base.model.SessionId;
import kntr.app.im.chat.core.di.ChatScope;
import kntr.app.im.chat.core.service.ChatInfoDatabaseService;
import kntr.app.im.chat.core.service.FusionChatInfoService;
import kntr.app.im.chat.core.service.NetworkChatInfoService;
import kntr.app.im.chat.service.FusionChatInfoServiceImpl;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssistantNotifyModule.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/di/module/assistant/AssistantChatInfoModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "fusionChatInfoService", "Lkntr/app/im/chat/core/service/FusionChatInfoService;", "sessionId", "Lim/base/model/SessionId;", "networkService", "Lkntr/app/im/chat/core/service/NetworkChatInfoService;", "databaseService", "Lkntr/app/im/chat/core/service/ChatInfoDatabaseService;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class AssistantChatInfoModule {
    public static final int $stable = 0;
    public static final AssistantChatInfoModule INSTANCE = new AssistantChatInfoModule();

    private AssistantChatInfoModule() {
    }

    @Provides
    @ChatScope
    public final FusionChatInfoService fusionChatInfoService(SessionId sessionId, NetworkChatInfoService networkService, ChatInfoDatabaseService databaseService) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(networkService, "networkService");
        Intrinsics.checkNotNullParameter(databaseService, "databaseService");
        return new FusionChatInfoServiceImpl(sessionId, networkService, databaseService, null, 8, null);
    }
}