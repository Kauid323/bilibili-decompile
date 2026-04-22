package kntr.app.im.chat.di.module.common;

import com.bapis.bilibili.app.im.v1.KSessionId;
import dagger.Module;
import dagger.Provides;
import im.base.SessionIdConverters;
import im.base.model.SessionId;
import kntr.app.im.chat.core.di.ChatScope;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonKSessionModule.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lkntr/app/im/chat/di/module/common/CommonKSessionModule;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "provideKSession", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "sessionId", "Lim/base/model/SessionId;", "converters", "Lim/base/SessionIdConverters;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public final class CommonKSessionModule {
    public static final int $stable = 0;
    public static final CommonKSessionModule INSTANCE = new CommonKSessionModule();

    private CommonKSessionModule() {
    }

    @Provides
    @ChatScope
    public final KSessionId provideKSession(SessionId sessionId, SessionIdConverters converters) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(converters, "converters");
        return converters.convertToKSessionId(sessionId);
    }
}