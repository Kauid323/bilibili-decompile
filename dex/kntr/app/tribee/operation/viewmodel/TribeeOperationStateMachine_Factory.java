package kntr.app.tribee.operation.viewmodel;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.tribee.operation.viewmodel.service.TribeeOperationDataService;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeOperationStateMachine_Factory.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateMachine_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateMachine;", "dataServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/tribee/operation/viewmodel/service/TribeeOperationDataService;", "fromTribeeIdProvider", "", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeOperationStateMachine_Factory implements Factory<TribeeOperationStateMachine> {
    private final Provider<TribeeOperationDataService> dataServiceProvider;
    private final Provider<Long> fromTribeeIdProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public TribeeOperationStateMachine_Factory(Provider<TribeeOperationDataService> provider, Provider<Long> provider2) {
        Intrinsics.checkNotNullParameter(provider, "dataServiceProvider");
        Intrinsics.checkNotNullParameter(provider2, "fromTribeeIdProvider");
        this.dataServiceProvider = provider;
        this.fromTribeeIdProvider = provider2;
    }

    public TribeeOperationStateMachine get() {
        Companion companion = Companion;
        Object obj = this.dataServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        Object obj2 = this.fromTribeeIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj2, "get(...)");
        return companion.newInstance((TribeeOperationDataService) obj, ((Number) obj2).longValue());
    }

    /* compiled from: TribeeOperationStateMachine_Factory.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nH\u0007¨\u0006\u000f"}, d2 = {"Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateMachine_Factory$Companion;", "", "<init>", "()V", "create", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateMachine_Factory;", "dataServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/tribee/operation/viewmodel/service/TribeeOperationDataService;", "fromTribeeIdProvider", "", "newInstance", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateMachine;", "dataService", "fromTribeeId", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TribeeOperationStateMachine_Factory create(Provider<TribeeOperationDataService> provider, Provider<Long> provider2) {
            Intrinsics.checkNotNullParameter(provider, "dataServiceProvider");
            Intrinsics.checkNotNullParameter(provider2, "fromTribeeIdProvider");
            return new TribeeOperationStateMachine_Factory(provider, provider2);
        }

        @JvmStatic
        public final TribeeOperationStateMachine newInstance(TribeeOperationDataService dataService, long fromTribeeId) {
            Intrinsics.checkNotNullParameter(dataService, "dataService");
            return new TribeeOperationStateMachine(dataService, fromTribeeId);
        }
    }

    @JvmStatic
    public static final TribeeOperationStateMachine_Factory create(Provider<TribeeOperationDataService> provider, Provider<Long> provider2) {
        return Companion.create(provider, provider2);
    }

    @JvmStatic
    public static final TribeeOperationStateMachine newInstance(TribeeOperationDataService dataService, long fromTribeeId) {
        return Companion.newInstance(dataService, fromTribeeId);
    }
}