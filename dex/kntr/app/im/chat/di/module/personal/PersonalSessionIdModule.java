package kntr.app.im.chat.di.module.personal;

import dagger.Module;
import dagger.Provides;
import im.base.model.SessionId;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.im.chat.core.di.ChatScope;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PersonalSessionIdModule.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lkntr/app/im/chat/di/module/personal/PersonalSessionIdModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provideSessionId", "Lim/base/model/SessionId;", ReportBuildInParam.ID, "Lkntr/app/im/chat/di/module/personal/PersonalChat;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class PersonalSessionIdModule {
    public static final int $stable = 0;
    public static final PersonalSessionIdModule INSTANCE = new PersonalSessionIdModule();

    private PersonalSessionIdModule() {
    }

    @Provides
    @ChatScope
    public final SessionId provideSessionId(PersonalChat id) {
        Intrinsics.checkNotNullParameter(id, ReportBuildInParam.ID);
        return id;
    }
}