package kntr.app.im.chat.di.module.common;

import dagger.Binds;
import dagger.Module;
import kntr.app.im.chat.core.di.ChatScope;
import kntr.app.im.chat.core.service.ChatFetchEventService;
import kntr.app.im.chat.core.service.ChatInfoDatabaseService;
import kntr.app.im.chat.core.service.MessageDatabaseService;
import kntr.app.im.chat.core.service.NetworkChatInfoService;
import kntr.app.im.chat.core.service.NetworkFetchMessageService;
import kntr.app.im.chat.core.service.NetworkSendMessageService;
import kntr.app.im.chat.core.service.OperateMessageService;
import kntr.app.im.chat.core.service.RangeDatabaseService;
import kntr.app.im.chat.core.service.SessionDatabaseService;
import kntr.app.im.chat.db.service.ChatInfoDatabaseServiceImpl;
import kntr.app.im.chat.db.service.MessageDatabaseServiceImpl;
import kntr.app.im.chat.db.service.RangeDatabaseServiceImpl;
import kntr.app.im.chat.db.service.SessionDatabaseServiceImpl;
import kntr.app.im.chat.network.ChatFetchEventServiceImpl;
import kntr.app.im.chat.network.NetworkChatInfoServiceImpl;
import kntr.app.im.chat.network.NetworkFetchMessagesServiceImpl;
import kntr.app.im.chat.network.NetworkOperateMessageServiceImpl;
import kntr.app.im.chat.network.NetworkSendMessageServiceImpl;
import kntr.app.im.chat.service.sender.image.AssetCopier;
import kntr.app.im.chat.service.sender.image.AssetCopierImpl;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: IMChatModule.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u000eH'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0011H'J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0014H'J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0017H'J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u001aH'J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u001dH'J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H'¨\u0006\"À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/di/module/common/IMChatModule;", RoomRecommendViewModel.EMPTY_CURSOR, "networkChatInfoService", "Lkntr/app/im/chat/core/service/NetworkChatInfoService;", "impl", "Lkntr/app/im/chat/network/NetworkChatInfoServiceImpl;", "networkFetchMessagesService", "Lkntr/app/im/chat/core/service/NetworkFetchMessageService;", "Lkntr/app/im/chat/network/NetworkFetchMessagesServiceImpl;", "sendMessageService", "Lkntr/app/im/chat/core/service/NetworkSendMessageService;", "Lkntr/app/im/chat/network/NetworkSendMessageServiceImpl;", "networkOperateMessageService", "Lkntr/app/im/chat/core/service/OperateMessageService;", "Lkntr/app/im/chat/network/NetworkOperateMessageServiceImpl;", "databaseChatInfoService", "Lkntr/app/im/chat/core/service/ChatInfoDatabaseService;", "Lkntr/app/im/chat/db/service/ChatInfoDatabaseServiceImpl;", "sessionService", "Lkntr/app/im/chat/core/service/SessionDatabaseService;", "Lkntr/app/im/chat/db/service/SessionDatabaseServiceImpl;", "messageDatabaseService", "Lkntr/app/im/chat/core/service/MessageDatabaseService;", "Lkntr/app/im/chat/db/service/MessageDatabaseServiceImpl;", "rangeDatabaseService", "Lkntr/app/im/chat/core/service/RangeDatabaseService;", "Lkntr/app/im/chat/db/service/RangeDatabaseServiceImpl;", "chatBroadcastService", "Lkntr/app/im/chat/core/service/ChatFetchEventService;", "Lkntr/app/im/chat/network/ChatFetchEventServiceImpl;", "assetCopier", "Lkntr/app/im/chat/service/sender/image/AssetCopier;", "copierImpl", "Lkntr/app/im/chat/service/sender/image/AssetCopierImpl;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public interface IMChatModule {
    @ChatScope
    @Binds
    AssetCopier assetCopier(AssetCopierImpl assetCopierImpl);

    @ChatScope
    @Binds
    ChatFetchEventService chatBroadcastService(ChatFetchEventServiceImpl chatFetchEventServiceImpl);

    @ChatScope
    @Binds
    ChatInfoDatabaseService databaseChatInfoService(ChatInfoDatabaseServiceImpl chatInfoDatabaseServiceImpl);

    @ChatScope
    @Binds
    MessageDatabaseService messageDatabaseService(MessageDatabaseServiceImpl messageDatabaseServiceImpl);

    @ChatScope
    @Binds
    NetworkChatInfoService networkChatInfoService(NetworkChatInfoServiceImpl networkChatInfoServiceImpl);

    @ChatScope
    @Binds
    NetworkFetchMessageService networkFetchMessagesService(NetworkFetchMessagesServiceImpl networkFetchMessagesServiceImpl);

    @ChatScope
    @Binds
    OperateMessageService networkOperateMessageService(NetworkOperateMessageServiceImpl networkOperateMessageServiceImpl);

    @ChatScope
    @Binds
    RangeDatabaseService rangeDatabaseService(RangeDatabaseServiceImpl rangeDatabaseServiceImpl);

    @ChatScope
    @Binds
    NetworkSendMessageService sendMessageService(NetworkSendMessageServiceImpl networkSendMessageServiceImpl);

    @ChatScope
    @Binds
    SessionDatabaseService sessionService(SessionDatabaseServiceImpl sessionDatabaseServiceImpl);
}