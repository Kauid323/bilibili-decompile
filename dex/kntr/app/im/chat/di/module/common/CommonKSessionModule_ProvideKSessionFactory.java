package kntr.app.im.chat.di.module.common;

import com.bapis.bilibili.app.im.v1.KSessionId;
import dagger.internal.Factory;
import im.base.SessionIdConverters;
import im.base.model.SessionId;
import javax.inject.Provider;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonKSessionModule_ProvideKSessionFactory.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/di/module/common/CommonKSessionModule_ProvideKSessionFactory;", "Ldagger/internal/Factory;", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "sessionIdProvider", "Ljavax/inject/Provider;", "Lim/base/model/SessionId;", "convertersProvider", "Lim/base/SessionIdConverters;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CommonKSessionModule_ProvideKSessionFactory implements Factory<KSessionId> {
    private final Provider<SessionIdConverters> convertersProvider;
    private final Provider<SessionId> sessionIdProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public CommonKSessionModule_ProvideKSessionFactory(Provider<SessionId> provider, Provider<SessionIdConverters> provider2) {
        Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
        Intrinsics.checkNotNullParameter(provider2, "convertersProvider");
        this.sessionIdProvider = provider;
        this.convertersProvider = provider2;
    }

    /* renamed from: get */
    public KSessionId m1434get() {
        Companion companion = Companion;
        SessionId sessionId = this.sessionIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(sessionId, "get(...)");
        SessionIdConverters sessionIdConverters = this.convertersProvider.get();
        Intrinsics.checkNotNullExpressionValue(sessionIdConverters, "get(...)");
        return companion.provideKSession(sessionId, sessionIdConverters);
    }

    /* compiled from: CommonKSessionModule_ProvideKSessionFactory.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nH\u0007¨\u0006\u000f"}, d2 = {"Lkntr/app/im/chat/di/module/common/CommonKSessionModule_ProvideKSessionFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/di/module/common/CommonKSessionModule_ProvideKSessionFactory;", "sessionIdProvider", "Ljavax/inject/Provider;", "Lim/base/model/SessionId;", "convertersProvider", "Lim/base/SessionIdConverters;", "provideKSession", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "sessionId", "converters", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CommonKSessionModule_ProvideKSessionFactory create(Provider<SessionId> provider, Provider<SessionIdConverters> provider2) {
            Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
            Intrinsics.checkNotNullParameter(provider2, "convertersProvider");
            return new CommonKSessionModule_ProvideKSessionFactory(provider, provider2);
        }

        @JvmStatic
        public final KSessionId provideKSession(SessionId sessionId, SessionIdConverters converters) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(converters, "converters");
            return CommonKSessionModule.INSTANCE.provideKSession(sessionId, converters);
        }
    }

    @JvmStatic
    public static final CommonKSessionModule_ProvideKSessionFactory create(Provider<SessionId> provider, Provider<SessionIdConverters> provider2) {
        return Companion.create(provider, provider2);
    }

    @JvmStatic
    public static final KSessionId provideKSession(SessionId sessionId, SessionIdConverters converters) {
        return Companion.provideKSession(sessionId, converters);
    }
}