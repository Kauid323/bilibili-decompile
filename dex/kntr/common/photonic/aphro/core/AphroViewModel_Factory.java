package kntr.common.photonic.aphro.core;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.core.AphroState;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AphroViewModel_Factory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroViewModel_Factory;", "Ldagger/internal/Factory;", "Lkntr/common/photonic/aphro/core/AphroViewModel;", "coroutineScopeProvider", "Ljavax/inject/Provider;", "Lkotlinx/coroutines/CoroutineScope;", "initStateProvider", "Lkntr/common/photonic/aphro/core/AphroState$Init;", "stateMachineProvider", "Lkntr/common/photonic/aphro/core/AphroStateMachine;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AphroViewModel_Factory implements Factory<AphroViewModel> {
    private final Provider<CoroutineScope> coroutineScopeProvider;
    private final Provider<AphroState.Init> initStateProvider;
    private final Provider<AphroStateMachine> stateMachineProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public AphroViewModel_Factory(Provider<CoroutineScope> provider, Provider<AphroState.Init> provider2, Provider<AphroStateMachine> provider3) {
        Intrinsics.checkNotNullParameter(provider, "coroutineScopeProvider");
        Intrinsics.checkNotNullParameter(provider2, "initStateProvider");
        Intrinsics.checkNotNullParameter(provider3, "stateMachineProvider");
        this.coroutineScopeProvider = provider;
        this.initStateProvider = provider2;
        this.stateMachineProvider = provider3;
    }

    public AphroViewModel get() {
        Companion companion = Companion;
        Object obj = this.coroutineScopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = this.initStateProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        Object obj3 = this.stateMachineProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj3, "get(...)");
        return companion.newInstance((CoroutineScope) obj, (AphroState.Init) obj2, (AphroStateMachine) obj3);
    }

    /* compiled from: AphroViewModel_Factory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0007¨\u0006\u0012"}, d2 = {"Lkntr/common/photonic/aphro/core/AphroViewModel_Factory$Companion;", "", "<init>", "()V", "create", "Lkntr/common/photonic/aphro/core/AphroViewModel_Factory;", "coroutineScopeProvider", "Ljavax/inject/Provider;", "Lkotlinx/coroutines/CoroutineScope;", "initStateProvider", "Lkntr/common/photonic/aphro/core/AphroState$Init;", "stateMachineProvider", "Lkntr/common/photonic/aphro/core/AphroStateMachine;", "newInstance", "Lkntr/common/photonic/aphro/core/AphroViewModel;", "coroutineScope", "initState", "stateMachine", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AphroViewModel_Factory create(Provider<CoroutineScope> provider, Provider<AphroState.Init> provider2, Provider<AphroStateMachine> provider3) {
            Intrinsics.checkNotNullParameter(provider, "coroutineScopeProvider");
            Intrinsics.checkNotNullParameter(provider2, "initStateProvider");
            Intrinsics.checkNotNullParameter(provider3, "stateMachineProvider");
            return new AphroViewModel_Factory(provider, provider2, provider3);
        }

        @JvmStatic
        public final AphroViewModel newInstance(CoroutineScope coroutineScope, AphroState.Init initState, AphroStateMachine stateMachine) {
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            Intrinsics.checkNotNullParameter(initState, "initState");
            Intrinsics.checkNotNullParameter(stateMachine, "stateMachine");
            return new AphroViewModel(coroutineScope, initState, stateMachine);
        }
    }

    @JvmStatic
    public static final AphroViewModel_Factory create(Provider<CoroutineScope> provider, Provider<AphroState.Init> provider2, Provider<AphroStateMachine> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final AphroViewModel newInstance(CoroutineScope coroutineScope, AphroState.Init initState, AphroStateMachine stateMachine) {
        return Companion.newInstance(coroutineScope, initState, stateMachine);
    }
}