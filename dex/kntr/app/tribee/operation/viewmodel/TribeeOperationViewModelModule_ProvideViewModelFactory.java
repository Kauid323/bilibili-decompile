package kntr.app.tribee.operation.viewmodel;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TribeeOperationViewModelModule_ProvideViewModelFactory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/tribee/operation/viewmodel/TribeeOperationViewModelModule_ProvideViewModelFactory;", "Ldagger/internal/Factory;", "Lkntr/app/tribee/operation/viewmodel/ITribeeOperationViewModel;", "scopeProvider", "Ljavax/inject/Provider;", "Lkotlinx/coroutines/CoroutineScope;", "stateMachineProvider", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateMachine;", "fromTribeeIdProvider", "", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeOperationViewModelModule_ProvideViewModelFactory implements Factory<ITribeeOperationViewModel> {
    private final Provider<Long> fromTribeeIdProvider;
    private final Provider<CoroutineScope> scopeProvider;
    private final Provider<TribeeOperationStateMachine> stateMachineProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public TribeeOperationViewModelModule_ProvideViewModelFactory(Provider<CoroutineScope> provider, Provider<TribeeOperationStateMachine> provider2, Provider<Long> provider3) {
        Intrinsics.checkNotNullParameter(provider, "scopeProvider");
        Intrinsics.checkNotNullParameter(provider2, "stateMachineProvider");
        Intrinsics.checkNotNullParameter(provider3, "fromTribeeIdProvider");
        this.scopeProvider = provider;
        this.stateMachineProvider = provider2;
        this.fromTribeeIdProvider = provider3;
    }

    public ITribeeOperationViewModel get() {
        Companion companion = Companion;
        Object obj = this.scopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = this.stateMachineProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        Object obj3 = this.fromTribeeIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj3, "get(...)");
        return companion.provideViewModel((CoroutineScope) obj, (TribeeOperationStateMachine) obj2, ((Number) obj3).longValue());
    }

    /* compiled from: TribeeOperationViewModelModule_ProvideViewModelFactory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/operation/viewmodel/TribeeOperationViewModelModule_ProvideViewModelFactory$Companion;", "", "<init>", "()V", "create", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationViewModelModule_ProvideViewModelFactory;", "scopeProvider", "Ljavax/inject/Provider;", "Lkotlinx/coroutines/CoroutineScope;", "stateMachineProvider", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateMachine;", "fromTribeeIdProvider", "", "provideViewModel", "Lkntr/app/tribee/operation/viewmodel/ITribeeOperationViewModel;", "scope", "stateMachine", "fromTribeeId", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TribeeOperationViewModelModule_ProvideViewModelFactory create(Provider<CoroutineScope> provider, Provider<TribeeOperationStateMachine> provider2, Provider<Long> provider3) {
            Intrinsics.checkNotNullParameter(provider, "scopeProvider");
            Intrinsics.checkNotNullParameter(provider2, "stateMachineProvider");
            Intrinsics.checkNotNullParameter(provider3, "fromTribeeIdProvider");
            return new TribeeOperationViewModelModule_ProvideViewModelFactory(provider, provider2, provider3);
        }

        @JvmStatic
        public final ITribeeOperationViewModel provideViewModel(CoroutineScope scope, TribeeOperationStateMachine stateMachine, long fromTribeeId) {
            Intrinsics.checkNotNullParameter(scope, "scope");
            Intrinsics.checkNotNullParameter(stateMachine, "stateMachine");
            return TribeeOperationViewModelModule.INSTANCE.provideViewModel(scope, stateMachine, fromTribeeId);
        }
    }

    @JvmStatic
    public static final TribeeOperationViewModelModule_ProvideViewModelFactory create(Provider<CoroutineScope> provider, Provider<TribeeOperationStateMachine> provider2, Provider<Long> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final ITribeeOperationViewModel provideViewModel(CoroutineScope scope, TribeeOperationStateMachine stateMachine, long fromTribeeId) {
        return Companion.provideViewModel(scope, stateMachine, fromTribeeId);
    }
}