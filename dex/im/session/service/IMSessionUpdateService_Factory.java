package im.session.service;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSessionUpdateService_Factory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lim/session/service/IMSessionUpdateService_Factory;", "Ldagger/internal/Factory;", "Lim/session/service/IMSessionUpdateService;", "summaryServiceProvider", "Ljavax/inject/Provider;", "Lim/session/service/IMSummaryCacheService;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSessionUpdateService_Factory implements Factory<IMSessionUpdateService> {
    public static final Companion Companion = new Companion(null);
    private final Provider<IMSummaryCacheService> summaryServiceProvider;

    public IMSessionUpdateService_Factory(Provider<IMSummaryCacheService> provider) {
        Intrinsics.checkNotNullParameter(provider, "summaryServiceProvider");
        this.summaryServiceProvider = provider;
    }

    /* renamed from: get */
    public IMSessionUpdateService m3368get() {
        Companion companion = Companion;
        Object obj = this.summaryServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return companion.newInstance((IMSummaryCacheService) obj);
    }

    /* compiled from: IMSessionUpdateService_Factory.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007¨\u0006\f"}, d2 = {"Lim/session/service/IMSessionUpdateService_Factory$Companion;", "", "<init>", "()V", "create", "Lim/session/service/IMSessionUpdateService_Factory;", "summaryServiceProvider", "Ljavax/inject/Provider;", "Lim/session/service/IMSummaryCacheService;", "newInstance", "Lim/session/service/IMSessionUpdateService;", "summaryService", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final IMSessionUpdateService_Factory create(Provider<IMSummaryCacheService> provider) {
            Intrinsics.checkNotNullParameter(provider, "summaryServiceProvider");
            return new IMSessionUpdateService_Factory(provider);
        }

        @JvmStatic
        public final IMSessionUpdateService newInstance(IMSummaryCacheService summaryService) {
            Intrinsics.checkNotNullParameter(summaryService, "summaryService");
            return new IMSessionUpdateService(summaryService);
        }
    }

    @JvmStatic
    public static final IMSessionUpdateService_Factory create(Provider<IMSummaryCacheService> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final IMSessionUpdateService newInstance(IMSummaryCacheService summaryService) {
        return Companion.newInstance(summaryService);
    }
}