package kntr.app.tribee.consume.viewmodel;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.tribee.consume.viewmodel.service.TribeeHomeDataService;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.KAccountStore;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeHomeStateMachine_Factory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eBC\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateMachine_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateMachine;", "dataServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/tribee/consume/viewmodel/service/TribeeHomeDataService;", "accountStoreProvider", "Lkntr/base/account/KAccountStore;", "inviteCodeFromRouterProvider", "", "categoryIdFromRouterProvider", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeHomeStateMachine_Factory implements Factory<TribeeHomeStateMachine> {
    private final Provider<KAccountStore> accountStoreProvider;
    private final Provider<String> categoryIdFromRouterProvider;
    private final Provider<TribeeHomeDataService> dataServiceProvider;
    private final Provider<String> inviteCodeFromRouterProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public TribeeHomeStateMachine_Factory(Provider<TribeeHomeDataService> provider, Provider<KAccountStore> provider2, Provider<String> provider3, Provider<String> provider4) {
        Intrinsics.checkNotNullParameter(provider, "dataServiceProvider");
        Intrinsics.checkNotNullParameter(provider2, "accountStoreProvider");
        Intrinsics.checkNotNullParameter(provider3, "inviteCodeFromRouterProvider");
        Intrinsics.checkNotNullParameter(provider4, "categoryIdFromRouterProvider");
        this.dataServiceProvider = provider;
        this.accountStoreProvider = provider2;
        this.inviteCodeFromRouterProvider = provider3;
        this.categoryIdFromRouterProvider = provider4;
    }

    public TribeeHomeStateMachine get() {
        Companion companion = Companion;
        Object obj = this.dataServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = this.accountStoreProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        return companion.newInstance((TribeeHomeDataService) obj, (KAccountStore) obj2, (String) this.inviteCodeFromRouterProvider.get(), (String) this.categoryIdFromRouterProvider.get());
    }

    /* compiled from: TribeeHomeStateMachine_Factory.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JD\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00072\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0007H\u0007J,\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0007¨\u0006\u0014"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateMachine_Factory$Companion;", "", "<init>", "()V", "create", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateMachine_Factory;", "dataServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/tribee/consume/viewmodel/service/TribeeHomeDataService;", "accountStoreProvider", "Lkntr/base/account/KAccountStore;", "inviteCodeFromRouterProvider", "", "categoryIdFromRouterProvider", "newInstance", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateMachine;", "dataService", "accountStore", "inviteCodeFromRouter", "categoryIdFromRouter", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TribeeHomeStateMachine_Factory create(Provider<TribeeHomeDataService> provider, Provider<KAccountStore> provider2, Provider<String> provider3, Provider<String> provider4) {
            Intrinsics.checkNotNullParameter(provider, "dataServiceProvider");
            Intrinsics.checkNotNullParameter(provider2, "accountStoreProvider");
            Intrinsics.checkNotNullParameter(provider3, "inviteCodeFromRouterProvider");
            Intrinsics.checkNotNullParameter(provider4, "categoryIdFromRouterProvider");
            return new TribeeHomeStateMachine_Factory(provider, provider2, provider3, provider4);
        }

        @JvmStatic
        public final TribeeHomeStateMachine newInstance(TribeeHomeDataService dataService, KAccountStore accountStore, String inviteCodeFromRouter, String categoryIdFromRouter) {
            Intrinsics.checkNotNullParameter(dataService, "dataService");
            Intrinsics.checkNotNullParameter(accountStore, "accountStore");
            return new TribeeHomeStateMachine(dataService, accountStore, inviteCodeFromRouter, categoryIdFromRouter);
        }
    }

    @JvmStatic
    public static final TribeeHomeStateMachine_Factory create(Provider<TribeeHomeDataService> provider, Provider<KAccountStore> provider2, Provider<String> provider3, Provider<String> provider4) {
        return Companion.create(provider, provider2, provider3, provider4);
    }

    @JvmStatic
    public static final TribeeHomeStateMachine newInstance(TribeeHomeDataService dataService, KAccountStore accountStore, String inviteCodeFromRouter, String categoryIdFromRouter) {
        return Companion.newInstance(dataService, accountStore, inviteCodeFromRouter, categoryIdFromRouter);
    }
}