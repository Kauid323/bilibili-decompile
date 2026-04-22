package kntr.app.deepsearch.history.stateMachine;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.deepsearch.history.service.DSHistoryLoadService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DSHistoryStateMachine_Factory.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/app/deepsearch/history/stateMachine/DSHistoryStateMachine_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/deepsearch/history/stateMachine/DSHistoryStateMachine;", "sessionIdProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, "loadServiceProvider", "Lkntr/app/deepsearch/history/service/DSHistoryLoadService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "history_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DSHistoryStateMachine_Factory implements Factory<DSHistoryStateMachine> {
    public static final Companion Companion = new Companion(null);
    private final Provider<DSHistoryLoadService> loadServiceProvider;
    private final Provider<String> sessionIdProvider;

    public DSHistoryStateMachine_Factory(Provider<String> provider, Provider<DSHistoryLoadService> provider2) {
        Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
        Intrinsics.checkNotNullParameter(provider2, "loadServiceProvider");
        this.sessionIdProvider = provider;
        this.loadServiceProvider = provider2;
    }

    public DSHistoryStateMachine get() {
        Companion companion = Companion;
        String str = this.sessionIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        DSHistoryLoadService dSHistoryLoadService = this.loadServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(dSHistoryLoadService, "get(...)");
        return companion.newInstance(str, dSHistoryLoadService);
    }

    /* compiled from: DSHistoryStateMachine_Factory.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nH\u0007¨\u0006\u000f"}, d2 = {"Lkntr/app/deepsearch/history/stateMachine/DSHistoryStateMachine_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/deepsearch/history/stateMachine/DSHistoryStateMachine_Factory;", "sessionIdProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, "loadServiceProvider", "Lkntr/app/deepsearch/history/service/DSHistoryLoadService;", "newInstance", "Lkntr/app/deepsearch/history/stateMachine/DSHistoryStateMachine;", "sessionId", "loadService", "history_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DSHistoryStateMachine_Factory create(Provider<String> provider, Provider<DSHistoryLoadService> provider2) {
            Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
            Intrinsics.checkNotNullParameter(provider2, "loadServiceProvider");
            return new DSHistoryStateMachine_Factory(provider, provider2);
        }

        @JvmStatic
        public final DSHistoryStateMachine newInstance(String sessionId, DSHistoryLoadService loadService) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(loadService, "loadService");
            return new DSHistoryStateMachine(sessionId, loadService);
        }
    }

    @JvmStatic
    public static final DSHistoryStateMachine_Factory create(Provider<String> provider, Provider<DSHistoryLoadService> provider2) {
        return Companion.create(provider, provider2);
    }

    @JvmStatic
    public static final DSHistoryStateMachine newInstance(String sessionId, DSHistoryLoadService loadService) {
        return Companion.newInstance(sessionId, loadService);
    }
}