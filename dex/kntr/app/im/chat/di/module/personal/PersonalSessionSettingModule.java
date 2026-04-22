package kntr.app.im.chat.di.module.personal;

import dagger.Module;
import dagger.Provides;
import im.base.SessionIdConverters;
import im.base.model.SessionId;
import kntr.app.im.base.IMEventHub;
import kntr.app.im.chat.core.service.ConversationSettingNotifier;
import kntr.app.im.chat.service.personal.ConversationSettingNotifierImpl;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PersonalSessionSettingModule.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lkntr/app/im/chat/di/module/personal/PersonalSessionSettingModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "providePersonalSessionSettingNotifier", "Lkntr/app/im/chat/core/service/ConversationSettingNotifier;", "sessionId", "Lim/base/model/SessionId;", "sessionIdConverters", "Lim/base/SessionIdConverters;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class PersonalSessionSettingModule {
    public static final int $stable = 0;
    public static final PersonalSessionSettingModule INSTANCE = new PersonalSessionSettingModule();

    private PersonalSessionSettingModule() {
    }

    @Provides
    public final ConversationSettingNotifier providePersonalSessionSettingNotifier(SessionId sessionId, SessionIdConverters sessionIdConverters) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(sessionIdConverters, "sessionIdConverters");
        return new ConversationSettingNotifierImpl(sessionId, sessionIdConverters, IMEventHub.INSTANCE.getChatSettingFlow());
    }
}