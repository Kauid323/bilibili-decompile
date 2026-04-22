package kntr.common.ouro.core;

import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.plugin.OuroPlugin;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: OuroStore_Factory.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011BK\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0018\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkntr/common/ouro/core/OuroStore_Factory;", "Ldagger/internal/Factory;", "Lkntr/common/ouro/core/OuroStore;", "parentScopeProvider", "Ljavax/inject/Provider;", "Lkotlinx/coroutines/CoroutineScope;", "initialStateProvider", "Lkntr/common/ouro/core/OuroState;", "pluginsProvider", "", "Lkntr/common/ouro/core/plugin/OuroPlugin;", "Lkntr/common/ouro/core/plugin/OuroPluginState;", "stateMachineProvider", "Lkntr/common/ouro/core/OuroStateMachine;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroStore_Factory implements Factory<OuroStore> {
    public static final Companion Companion = new Companion(null);
    private final Provider<OuroState> initialStateProvider;
    private final Provider<CoroutineScope> parentScopeProvider;
    private final Provider<Set<OuroPlugin<OuroPluginState>>> pluginsProvider;
    private final Provider<OuroStateMachine> stateMachineProvider;

    public OuroStore_Factory(Provider<CoroutineScope> provider, Provider<OuroState> provider2, Provider<Set<OuroPlugin<OuroPluginState>>> provider3, Provider<OuroStateMachine> provider4) {
        Intrinsics.checkNotNullParameter(provider, "parentScopeProvider");
        Intrinsics.checkNotNullParameter(provider2, "initialStateProvider");
        Intrinsics.checkNotNullParameter(provider3, "pluginsProvider");
        Intrinsics.checkNotNullParameter(provider4, "stateMachineProvider");
        this.parentScopeProvider = provider;
        this.initialStateProvider = provider2;
        this.pluginsProvider = provider3;
        this.stateMachineProvider = provider4;
    }

    public OuroStore get() {
        Companion companion = Companion;
        Object obj = this.parentScopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = this.initialStateProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        Object obj3 = this.pluginsProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj3, "get(...)");
        Object obj4 = this.stateMachineProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj4, "get(...)");
        return companion.newInstance((CoroutineScope) obj, (OuroState) obj2, (Set) obj3, (OuroStateMachine) obj4);
    }

    /* compiled from: OuroStore_Factory.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JL\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f0\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007H\u0007J4\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\n2\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010\u0016\u001a\u00020\u0010H\u0007¨\u0006\u0017"}, d2 = {"Lkntr/common/ouro/core/OuroStore_Factory$Companion;", "", "<init>", "()V", "create", "Lkntr/common/ouro/core/OuroStore_Factory;", "parentScopeProvider", "Ljavax/inject/Provider;", "Lkotlinx/coroutines/CoroutineScope;", "initialStateProvider", "Lkntr/common/ouro/core/OuroState;", "pluginsProvider", "", "Lkntr/common/ouro/core/plugin/OuroPlugin;", "Lkntr/common/ouro/core/plugin/OuroPluginState;", "stateMachineProvider", "Lkntr/common/ouro/core/OuroStateMachine;", "newInstance", "Lkntr/common/ouro/core/OuroStore;", "parentScope", "initialState", "plugins", "stateMachine", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final OuroStore_Factory create(Provider<CoroutineScope> provider, Provider<OuroState> provider2, Provider<Set<OuroPlugin<OuroPluginState>>> provider3, Provider<OuroStateMachine> provider4) {
            Intrinsics.checkNotNullParameter(provider, "parentScopeProvider");
            Intrinsics.checkNotNullParameter(provider2, "initialStateProvider");
            Intrinsics.checkNotNullParameter(provider3, "pluginsProvider");
            Intrinsics.checkNotNullParameter(provider4, "stateMachineProvider");
            return new OuroStore_Factory(provider, provider2, provider3, provider4);
        }

        @JvmStatic
        public final OuroStore newInstance(CoroutineScope parentScope, OuroState initialState, Set<? extends OuroPlugin<OuroPluginState>> set, OuroStateMachine stateMachine) {
            Intrinsics.checkNotNullParameter(parentScope, "parentScope");
            Intrinsics.checkNotNullParameter(initialState, "initialState");
            Intrinsics.checkNotNullParameter(set, "plugins");
            Intrinsics.checkNotNullParameter(stateMachine, "stateMachine");
            return new OuroStore(parentScope, initialState, set, stateMachine);
        }
    }

    @JvmStatic
    public static final OuroStore_Factory create(Provider<CoroutineScope> provider, Provider<OuroState> provider2, Provider<Set<OuroPlugin<OuroPluginState>>> provider3, Provider<OuroStateMachine> provider4) {
        return Companion.create(provider, provider2, provider3, provider4);
    }

    @JvmStatic
    public static final OuroStore newInstance(CoroutineScope parentScope, OuroState initialState, Set<? extends OuroPlugin<OuroPluginState>> set, OuroStateMachine stateMachine) {
        return Companion.newInstance(parentScope, initialState, set, stateMachine);
    }
}