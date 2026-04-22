package kntr.app.tribee.steam.viewmodel;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.tribee.steam.service.TribeeSteamDataService;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TribeeSteamStateMachine_Factory.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010BQ\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateMachine_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateMachine;", "hostIdProvider", "Ljavax/inject/Provider;", "", "tribeeIdProvider", "", "fromSpmidProvider", "dataServiceProvider", "Lkntr/app/tribee/steam/service/TribeeSteamDataService;", "shareScopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSteamStateMachine_Factory implements Factory<TribeeSteamStateMachine> {
    private final Provider<TribeeSteamDataService> dataServiceProvider;
    private final Provider<String> fromSpmidProvider;
    private final Provider<Long> hostIdProvider;
    private final Provider<CoroutineScope> shareScopeProvider;
    private final Provider<String> tribeeIdProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public TribeeSteamStateMachine_Factory(Provider<Long> provider, Provider<String> provider2, Provider<String> provider3, Provider<TribeeSteamDataService> provider4, Provider<CoroutineScope> provider5) {
        Intrinsics.checkNotNullParameter(provider, "hostIdProvider");
        Intrinsics.checkNotNullParameter(provider2, "tribeeIdProvider");
        Intrinsics.checkNotNullParameter(provider3, "fromSpmidProvider");
        Intrinsics.checkNotNullParameter(provider4, "dataServiceProvider");
        Intrinsics.checkNotNullParameter(provider5, "shareScopeProvider");
        this.hostIdProvider = provider;
        this.tribeeIdProvider = provider2;
        this.fromSpmidProvider = provider3;
        this.dataServiceProvider = provider4;
        this.shareScopeProvider = provider5;
    }

    public TribeeSteamStateMachine get() {
        Companion companion = Companion;
        Object obj = this.hostIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        long longValue = ((Number) obj).longValue();
        String str = (String) this.tribeeIdProvider.get();
        String str2 = (String) this.fromSpmidProvider.get();
        Object obj2 = this.dataServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        TribeeSteamDataService tribeeSteamDataService = (TribeeSteamDataService) obj2;
        Object obj3 = this.shareScopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj3, "get(...)");
        return companion.newInstance(longValue, str, str2, tribeeSteamDataService, (CoroutineScope) obj3);
    }

    /* compiled from: TribeeSteamStateMachine_Factory.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JR\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00072\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007H\u0007J4\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000fH\u0007¨\u0006\u0017"}, d2 = {"Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateMachine_Factory$Companion;", "", "<init>", "()V", "create", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateMachine_Factory;", "hostIdProvider", "Ljavax/inject/Provider;", "", "tribeeIdProvider", "", "fromSpmidProvider", "dataServiceProvider", "Lkntr/app/tribee/steam/service/TribeeSteamDataService;", "shareScopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "newInstance", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateMachine;", "hostId", "tribeeId", "fromSpmid", "dataService", "shareScope", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TribeeSteamStateMachine_Factory create(Provider<Long> provider, Provider<String> provider2, Provider<String> provider3, Provider<TribeeSteamDataService> provider4, Provider<CoroutineScope> provider5) {
            Intrinsics.checkNotNullParameter(provider, "hostIdProvider");
            Intrinsics.checkNotNullParameter(provider2, "tribeeIdProvider");
            Intrinsics.checkNotNullParameter(provider3, "fromSpmidProvider");
            Intrinsics.checkNotNullParameter(provider4, "dataServiceProvider");
            Intrinsics.checkNotNullParameter(provider5, "shareScopeProvider");
            return new TribeeSteamStateMachine_Factory(provider, provider2, provider3, provider4, provider5);
        }

        @JvmStatic
        public final TribeeSteamStateMachine newInstance(long hostId, String tribeeId, String fromSpmid, TribeeSteamDataService dataService, CoroutineScope shareScope) {
            Intrinsics.checkNotNullParameter(dataService, "dataService");
            Intrinsics.checkNotNullParameter(shareScope, "shareScope");
            return new TribeeSteamStateMachine(hostId, tribeeId, fromSpmid, dataService, shareScope);
        }
    }

    @JvmStatic
    public static final TribeeSteamStateMachine_Factory create(Provider<Long> provider, Provider<String> provider2, Provider<String> provider3, Provider<TribeeSteamDataService> provider4, Provider<CoroutineScope> provider5) {
        return Companion.create(provider, provider2, provider3, provider4, provider5);
    }

    @JvmStatic
    public static final TribeeSteamStateMachine newInstance(long hostId, String tribeeId, String fromSpmid, TribeeSteamDataService dataService, CoroutineScope shareScope) {
        return Companion.newInstance(hostId, tribeeId, fromSpmid, dataService, shareScope);
    }
}