package im.session.service;

import dagger.internal.Factory;
import im.session.base.IMConversationDraftService;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSummaryCacheService_Factory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lim/session/service/IMSummaryCacheService_Factory;", "Ldagger/internal/Factory;", "Lim/session/service/IMSummaryCacheService;", "serviceProvider", "Ljavax/inject/Provider;", "Lim/session/base/IMConversationDraftService;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSummaryCacheService_Factory implements Factory<IMSummaryCacheService> {
    public static final Companion Companion = new Companion(null);
    private final Provider<IMConversationDraftService> serviceProvider;

    public IMSummaryCacheService_Factory(Provider<IMConversationDraftService> provider) {
        Intrinsics.checkNotNullParameter(provider, "serviceProvider");
        this.serviceProvider = provider;
    }

    /* renamed from: get */
    public IMSummaryCacheService m3369get() {
        Companion companion = Companion;
        Object obj = this.serviceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return companion.newInstance((IMConversationDraftService) obj);
    }

    /* compiled from: IMSummaryCacheService_Factory.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007¨\u0006\f"}, d2 = {"Lim/session/service/IMSummaryCacheService_Factory$Companion;", "", "<init>", "()V", "create", "Lim/session/service/IMSummaryCacheService_Factory;", "serviceProvider", "Ljavax/inject/Provider;", "Lim/session/base/IMConversationDraftService;", "newInstance", "Lim/session/service/IMSummaryCacheService;", "service", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final IMSummaryCacheService_Factory create(Provider<IMConversationDraftService> provider) {
            Intrinsics.checkNotNullParameter(provider, "serviceProvider");
            return new IMSummaryCacheService_Factory(provider);
        }

        @JvmStatic
        public final IMSummaryCacheService newInstance(IMConversationDraftService service) {
            Intrinsics.checkNotNullParameter(service, "service");
            return new IMSummaryCacheService(service);
        }
    }

    @JvmStatic
    public static final IMSummaryCacheService_Factory create(Provider<IMConversationDraftService> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final IMSummaryCacheService newInstance(IMConversationDraftService service) {
        return Companion.newInstance(service);
    }
}