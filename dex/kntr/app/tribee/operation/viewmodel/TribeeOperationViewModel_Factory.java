package kntr.app.tribee.operation.viewmodel;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TribeeOperationViewModel_Factory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/tribee/operation/viewmodel/TribeeOperationViewModel_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationViewModel;", "scopeProvider", "Ljavax/inject/Provider;", "Lkotlinx/coroutines/CoroutineScope;", "fromTribeeIdProvider", "", "stateMachineProvider", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateMachine;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeOperationViewModel_Factory implements Factory<TribeeOperationViewModel> {
    private final Provider<Long> fromTribeeIdProvider;
    private final Provider<CoroutineScope> scopeProvider;
    private final Provider<TribeeOperationStateMachine> stateMachineProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public TribeeOperationViewModel_Factory(Provider<CoroutineScope> provider, Provider<Long> provider2, Provider<TribeeOperationStateMachine> provider3) {
        Intrinsics.checkNotNullParameter(provider, "scopeProvider");
        Intrinsics.checkNotNullParameter(provider2, "fromTribeeIdProvider");
        Intrinsics.checkNotNullParameter(provider3, "stateMachineProvider");
        this.scopeProvider = provider;
        this.fromTribeeIdProvider = provider2;
        this.stateMachineProvider = provider3;
    }

    public TribeeOperationViewModel get() {
        Companion companion = Companion;
        Object obj = this.scopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = this.fromTribeeIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        long longValue = ((Number) obj2).longValue();
        Object obj3 = this.stateMachineProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj3, "get(...)");
        return companion.newInstance((CoroutineScope) obj, longValue, (TribeeOperationStateMachine) obj3);
    }

    /* compiled from: TribeeOperationViewModel_Factory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/operation/viewmodel/TribeeOperationViewModel_Factory$Companion;", "", "<init>", "()V", "create", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationViewModel_Factory;", "scopeProvider", "Ljavax/inject/Provider;", "Lkotlinx/coroutines/CoroutineScope;", "fromTribeeIdProvider", "", "stateMachineProvider", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateMachine;", "newInstance", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationViewModel;", "scope", "fromTribeeId", "stateMachine", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TribeeOperationViewModel_Factory create(Provider<CoroutineScope> provider, Provider<Long> provider2, Provider<TribeeOperationStateMachine> provider3) {
            Intrinsics.checkNotNullParameter(provider, "scopeProvider");
            Intrinsics.checkNotNullParameter(provider2, "fromTribeeIdProvider");
            Intrinsics.checkNotNullParameter(provider3, "stateMachineProvider");
            return new TribeeOperationViewModel_Factory(provider, provider2, provider3);
        }

        @JvmStatic
        public final TribeeOperationViewModel newInstance(CoroutineScope scope, long fromTribeeId, TribeeOperationStateMachine stateMachine) {
            Intrinsics.checkNotNullParameter(scope, "scope");
            Intrinsics.checkNotNullParameter(stateMachine, "stateMachine");
            return new TribeeOperationViewModel(scope, fromTribeeId, stateMachine);
        }
    }

    @JvmStatic
    public static final TribeeOperationViewModel_Factory create(Provider<CoroutineScope> provider, Provider<Long> provider2, Provider<TribeeOperationStateMachine> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final TribeeOperationViewModel newInstance(CoroutineScope scope, long fromTribeeId, TribeeOperationStateMachine stateMachine) {
        return Companion.newInstance(scope, fromTribeeId, stateMachine);
    }
}