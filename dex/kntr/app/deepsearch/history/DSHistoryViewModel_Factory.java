package kntr.app.deepsearch.history;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.deepsearch.history.stateMachine.DSHistoryStateMachine;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DSHistoryViewModel_Factory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/deepsearch/history/DSHistoryViewModel_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/deepsearch/history/DSHistoryViewModel;", "sessionIdProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, "stateMachineProvider", "Lkntr/app/deepsearch/history/stateMachine/DSHistoryStateMachine;", "scopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "history_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DSHistoryViewModel_Factory implements Factory<DSHistoryViewModel> {
    public static final Companion Companion = new Companion(null);
    private final Provider<CoroutineScope> scopeProvider;
    private final Provider<String> sessionIdProvider;
    private final Provider<DSHistoryStateMachine> stateMachineProvider;

    public DSHistoryViewModel_Factory(Provider<String> provider, Provider<DSHistoryStateMachine> provider2, Provider<CoroutineScope> provider3) {
        Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
        Intrinsics.checkNotNullParameter(provider2, "stateMachineProvider");
        Intrinsics.checkNotNullParameter(provider3, "scopeProvider");
        this.sessionIdProvider = provider;
        this.stateMachineProvider = provider2;
        this.scopeProvider = provider3;
    }

    public DSHistoryViewModel get() {
        Companion companion = Companion;
        String str = this.sessionIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        DSHistoryStateMachine dSHistoryStateMachine = this.stateMachineProvider.get();
        Intrinsics.checkNotNullExpressionValue(dSHistoryStateMachine, "get(...)");
        CoroutineScope coroutineScope = this.scopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(coroutineScope, "get(...)");
        return companion.newInstance(str, dSHistoryStateMachine, coroutineScope);
    }

    /* compiled from: DSHistoryViewModel_Factory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/deepsearch/history/DSHistoryViewModel_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/deepsearch/history/DSHistoryViewModel_Factory;", "sessionIdProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, "stateMachineProvider", "Lkntr/app/deepsearch/history/stateMachine/DSHistoryStateMachine;", "scopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "newInstance", "Lkntr/app/deepsearch/history/DSHistoryViewModel;", "sessionId", "stateMachine", "scope", "history_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DSHistoryViewModel_Factory create(Provider<String> provider, Provider<DSHistoryStateMachine> provider2, Provider<CoroutineScope> provider3) {
            Intrinsics.checkNotNullParameter(provider, "sessionIdProvider");
            Intrinsics.checkNotNullParameter(provider2, "stateMachineProvider");
            Intrinsics.checkNotNullParameter(provider3, "scopeProvider");
            return new DSHistoryViewModel_Factory(provider, provider2, provider3);
        }

        @JvmStatic
        public final DSHistoryViewModel newInstance(String sessionId, DSHistoryStateMachine stateMachine, CoroutineScope scope) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(stateMachine, "stateMachine");
            Intrinsics.checkNotNullParameter(scope, "scope");
            return new DSHistoryViewModel(sessionId, stateMachine, scope);
        }
    }

    @JvmStatic
    public static final DSHistoryViewModel_Factory create(Provider<String> provider, Provider<DSHistoryStateMachine> provider2, Provider<CoroutineScope> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final DSHistoryViewModel newInstance(String sessionId, DSHistoryStateMachine stateMachine, CoroutineScope scope) {
        return Companion.newInstance(sessionId, stateMachine, scope);
    }
}