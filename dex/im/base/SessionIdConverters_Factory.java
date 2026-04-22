package im.base;

import dagger.internal.Factory;
import im.base.model.SessionId;
import java.util.Map;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SessionIdConverters_Factory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB'\u0012\u001e\u0010\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00050\u0004¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\u0002H\u0016R&\u0010\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lim/base/SessionIdConverters_Factory;", "Ldagger/internal/Factory;", "Lim/base/SessionIdConverters;", "converterMapProvider", "Ljavax/inject/Provider;", "", "", "Lim/base/SessionIdConverter;", "Lim/base/model/SessionId;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SessionIdConverters_Factory implements Factory<SessionIdConverters> {
    public static final Companion Companion = new Companion(null);
    private final Provider<Map<Integer, SessionIdConverter<SessionId>>> converterMapProvider;

    public SessionIdConverters_Factory(Provider<Map<Integer, SessionIdConverter<SessionId>>> provider) {
        Intrinsics.checkNotNullParameter(provider, "converterMapProvider");
        this.converterMapProvider = provider;
    }

    /* renamed from: get */
    public SessionIdConverters m3101get() {
        Companion companion = Companion;
        Object obj = this.converterMapProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return companion.newInstance((Map) obj);
    }

    /* compiled from: SessionIdConverters_Factory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u001e\u0010\u0006\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b0\u0007H\u0007J\"\u0010\f\u001a\u00020\r2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\bH\u0007¨\u0006\u000f"}, d2 = {"Lim/base/SessionIdConverters_Factory$Companion;", "", "<init>", "()V", "create", "Lim/base/SessionIdConverters_Factory;", "converterMapProvider", "Ljavax/inject/Provider;", "", "", "Lim/base/SessionIdConverter;", "Lim/base/model/SessionId;", "newInstance", "Lim/base/SessionIdConverters;", "converterMap", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SessionIdConverters_Factory create(Provider<Map<Integer, SessionIdConverter<SessionId>>> provider) {
            Intrinsics.checkNotNullParameter(provider, "converterMapProvider");
            return new SessionIdConverters_Factory(provider);
        }

        @JvmStatic
        public final SessionIdConverters newInstance(Map<Integer, ? extends SessionIdConverter<SessionId>> map) {
            Intrinsics.checkNotNullParameter(map, "converterMap");
            return new SessionIdConverters(map);
        }
    }

    @JvmStatic
    public static final SessionIdConverters_Factory create(Provider<Map<Integer, SessionIdConverter<SessionId>>> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final SessionIdConverters newInstance(Map<Integer, ? extends SessionIdConverter<SessionId>> map) {
        return Companion.newInstance(map);
    }
}