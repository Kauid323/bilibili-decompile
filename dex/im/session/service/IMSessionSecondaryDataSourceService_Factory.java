package im.session.service;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSessionSecondaryDataSourceService_Factory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lim/session/service/IMSessionSecondaryDataSourceService_Factory;", "Ldagger/internal/Factory;", "Lim/session/service/IMSessionSecondaryDataSourceService;", "remoteServiceProvider", "Ljavax/inject/Provider;", "Lim/session/service/IMSessionRequestServiceLike;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSessionSecondaryDataSourceService_Factory implements Factory<IMSessionSecondaryDataSourceService> {
    public static final Companion Companion = new Companion(null);
    private final Provider<IMSessionRequestServiceLike> remoteServiceProvider;

    public IMSessionSecondaryDataSourceService_Factory(Provider<IMSessionRequestServiceLike> provider) {
        Intrinsics.checkNotNullParameter(provider, "remoteServiceProvider");
        this.remoteServiceProvider = provider;
    }

    /* renamed from: get */
    public IMSessionSecondaryDataSourceService m3363get() {
        Companion companion = Companion;
        Object obj = this.remoteServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return companion.newInstance((IMSessionRequestServiceLike) obj);
    }

    /* compiled from: IMSessionSecondaryDataSourceService_Factory.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007¨\u0006\f"}, d2 = {"Lim/session/service/IMSessionSecondaryDataSourceService_Factory$Companion;", "", "<init>", "()V", "create", "Lim/session/service/IMSessionSecondaryDataSourceService_Factory;", "remoteServiceProvider", "Ljavax/inject/Provider;", "Lim/session/service/IMSessionRequestServiceLike;", "newInstance", "Lim/session/service/IMSessionSecondaryDataSourceService;", "remoteService", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final IMSessionSecondaryDataSourceService_Factory create(Provider<IMSessionRequestServiceLike> provider) {
            Intrinsics.checkNotNullParameter(provider, "remoteServiceProvider");
            return new IMSessionSecondaryDataSourceService_Factory(provider);
        }

        @JvmStatic
        public final IMSessionSecondaryDataSourceService newInstance(IMSessionRequestServiceLike remoteService) {
            Intrinsics.checkNotNullParameter(remoteService, "remoteService");
            return new IMSessionSecondaryDataSourceService(remoteService);
        }
    }

    @JvmStatic
    public static final IMSessionSecondaryDataSourceService_Factory create(Provider<IMSessionRequestServiceLike> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final IMSessionSecondaryDataSourceService newInstance(IMSessionRequestServiceLike remoteService) {
        return Companion.newInstance(remoteService);
    }
}