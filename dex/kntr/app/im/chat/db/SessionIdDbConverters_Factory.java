package kntr.app.im.chat.db;

import dagger.internal.Factory;
import im.base.model.SessionId;
import java.util.Map;
import javax.inject.Provider;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SessionIdDbConverters_Factory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB'\u0012\u001e\u0010\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00050\u0004¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0002H\u0016R&\u0010\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkntr/app/im/chat/db/SessionIdDbConverters_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/db/SessionIdDbConverters;", "converterMapProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/db/SessionIdDbConverter;", "Lim/base/model/SessionId;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SessionIdDbConverters_Factory implements Factory<SessionIdDbConverters> {
    public static final Companion Companion = new Companion(null);
    private final Provider<Map<Integer, SessionIdDbConverter<SessionId>>> converterMapProvider;

    public SessionIdDbConverters_Factory(Provider<Map<Integer, SessionIdDbConverter<SessionId>>> provider) {
        Intrinsics.checkNotNullParameter(provider, "converterMapProvider");
        this.converterMapProvider = provider;
    }

    public SessionIdDbConverters get() {
        Companion companion = Companion;
        Map<Integer, SessionIdDbConverter<SessionId>> map = this.converterMapProvider.get();
        Intrinsics.checkNotNullExpressionValue(map, "get(...)");
        return companion.newInstance(map);
    }

    /* compiled from: SessionIdDbConverters_Factory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u001e\u0010\u0006\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b0\u0007H\u0007J\"\u0010\f\u001a\u00020\r2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\bH\u0007¨\u0006\u000f"}, d2 = {"Lkntr/app/im/chat/db/SessionIdDbConverters_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/im/chat/db/SessionIdDbConverters_Factory;", "converterMapProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/db/SessionIdDbConverter;", "Lim/base/model/SessionId;", "newInstance", "Lkntr/app/im/chat/db/SessionIdDbConverters;", "converterMap", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SessionIdDbConverters_Factory create(Provider<Map<Integer, SessionIdDbConverter<SessionId>>> provider) {
            Intrinsics.checkNotNullParameter(provider, "converterMapProvider");
            return new SessionIdDbConverters_Factory(provider);
        }

        @JvmStatic
        public final SessionIdDbConverters newInstance(Map<Integer, ? extends SessionIdDbConverter<SessionId>> map) {
            Intrinsics.checkNotNullParameter(map, "converterMap");
            return new SessionIdDbConverters(map);
        }
    }

    @JvmStatic
    public static final SessionIdDbConverters_Factory create(Provider<Map<Integer, SessionIdDbConverter<SessionId>>> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final SessionIdDbConverters newInstance(Map<Integer, ? extends SessionIdDbConverter<SessionId>> map) {
        return Companion.newInstance(map);
    }
}