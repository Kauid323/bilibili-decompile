package kntr.app.im.chat.di.module.personal;

import dagger.Binds;
import dagger.Module;
import kntr.app.im.chat.core.di.ChatScope;
import kntr.app.im.chat.core.service.FusionFetchMessageService;
import kntr.app.im.chat.core.service.MessageSendService;
import kntr.app.im.chat.service.FetchMessagesWithSendingProgressService;
import kntr.app.im.chat.service.MessageSendServiceImpl;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: PersonalSendModule.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/di/module/personal/PersonalSendModule;", RoomRecommendViewModel.EMPTY_CURSOR, "fusionSendMessageService", "Lkntr/app/im/chat/core/service/MessageSendService;", "impl", "Lkntr/app/im/chat/service/MessageSendServiceImpl;", "fetchService", "Lkntr/app/im/chat/core/service/FusionFetchMessageService;", "Lkntr/app/im/chat/service/FetchMessagesWithSendingProgressService;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public interface PersonalSendModule {
    @ChatScope
    @Binds
    FusionFetchMessageService fetchService(FetchMessagesWithSendingProgressService fetchMessagesWithSendingProgressService);

    @ChatScope
    @Binds
    MessageSendService fusionSendMessageService(MessageSendServiceImpl messageSendServiceImpl);
}