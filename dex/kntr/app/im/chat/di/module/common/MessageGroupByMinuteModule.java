package kntr.app.im.chat.di.module.common;

import dagger.Module;
import dagger.Provides;
import kntr.app.im.chat.core.service.MessageGroupingService;
import kntr.app.im.chat.service.MessageGroupingBySameMinuteServiceImpl;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: MessageGroupByMinuteModule.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lkntr/app/im/chat/di/module/common/MessageGroupByMinuteModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provideGroupingService", "Lkntr/app/im/chat/core/service/MessageGroupingService;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class MessageGroupByMinuteModule {
    public static final int $stable = 0;
    public static final MessageGroupByMinuteModule INSTANCE = new MessageGroupByMinuteModule();

    private MessageGroupByMinuteModule() {
    }

    @Provides
    public final MessageGroupingService provideGroupingService() {
        return new MessageGroupingBySameMinuteServiceImpl();
    }
}