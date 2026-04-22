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

/* compiled from: OuroStateMachine_Factory.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB/\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/common/ouro/core/OuroStateMachine_Factory;", "Ldagger/internal/Factory;", "Lkntr/common/ouro/core/OuroStateMachine;", "initialStateProvider", "Ljavax/inject/Provider;", "Lkntr/common/ouro/core/OuroState;", "pluginsProvider", "", "Lkntr/common/ouro/core/plugin/OuroPlugin;", "Lkntr/common/ouro/core/plugin/OuroPluginState;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroStateMachine_Factory implements Factory<OuroStateMachine> {
    public static final Companion Companion = new Companion(null);
    private final Provider<OuroState> initialStateProvider;
    private final Provider<Set<OuroPlugin<OuroPluginState>>> pluginsProvider;

    public OuroStateMachine_Factory(Provider<OuroState> provider, Provider<Set<OuroPlugin<OuroPluginState>>> provider2) {
        Intrinsics.checkNotNullParameter(provider, "initialStateProvider");
        Intrinsics.checkNotNullParameter(provider2, "pluginsProvider");
        this.initialStateProvider = provider;
        this.pluginsProvider = provider2;
    }

    public OuroStateMachine get() {
        Companion companion = Companion;
        Object obj = this.initialStateProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = this.pluginsProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        return companion.newInstance((OuroState) obj, (Set) obj2);
    }

    /* compiled from: OuroStateMachine_Factory.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\u0007H\u0007J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH\u0007¨\u0006\u0011"}, d2 = {"Lkntr/common/ouro/core/OuroStateMachine_Factory$Companion;", "", "<init>", "()V", "create", "Lkntr/common/ouro/core/OuroStateMachine_Factory;", "initialStateProvider", "Ljavax/inject/Provider;", "Lkntr/common/ouro/core/OuroState;", "pluginsProvider", "", "Lkntr/common/ouro/core/plugin/OuroPlugin;", "Lkntr/common/ouro/core/plugin/OuroPluginState;", "newInstance", "Lkntr/common/ouro/core/OuroStateMachine;", "initialState", "plugins", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final OuroStateMachine_Factory create(Provider<OuroState> provider, Provider<Set<OuroPlugin<OuroPluginState>>> provider2) {
            Intrinsics.checkNotNullParameter(provider, "initialStateProvider");
            Intrinsics.checkNotNullParameter(provider2, "pluginsProvider");
            return new OuroStateMachine_Factory(provider, provider2);
        }

        @JvmStatic
        public final OuroStateMachine newInstance(OuroState initialState, Set<? extends OuroPlugin<OuroPluginState>> set) {
            Intrinsics.checkNotNullParameter(initialState, "initialState");
            Intrinsics.checkNotNullParameter(set, "plugins");
            return new OuroStateMachine(initialState, set);
        }
    }

    @JvmStatic
    public static final OuroStateMachine_Factory create(Provider<OuroState> provider, Provider<Set<OuroPlugin<OuroPluginState>>> provider2) {
        return Companion.create(provider, provider2);
    }

    @JvmStatic
    public static final OuroStateMachine newInstance(OuroState initialState, Set<? extends OuroPlugin<OuroPluginState>> set) {
        return Companion.newInstance(initialState, set);
    }
}