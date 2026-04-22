package kntr.app.tribee.invite.viewmodel;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.tribee.invite.service.TribeeInviteDataService;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeInviteStateMachine_Factory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/app/tribee/invite/viewmodel/TribeeInviteStateMachine_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/tribee/invite/viewmodel/TribeeInviteStateMachine;", "dataServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/tribee/invite/service/TribeeInviteDataService;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeInviteStateMachine_Factory implements Factory<TribeeInviteStateMachine> {
    private final Provider<TribeeInviteDataService> dataServiceProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public TribeeInviteStateMachine_Factory(Provider<TribeeInviteDataService> provider) {
        Intrinsics.checkNotNullParameter(provider, "dataServiceProvider");
        this.dataServiceProvider = provider;
    }

    public TribeeInviteStateMachine get() {
        Companion companion = Companion;
        Object obj = this.dataServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        return companion.newInstance((TribeeInviteDataService) obj);
    }

    /* compiled from: TribeeInviteStateMachine_Factory.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007¨\u0006\f"}, d2 = {"Lkntr/app/tribee/invite/viewmodel/TribeeInviteStateMachine_Factory$Companion;", "", "<init>", "()V", "create", "Lkntr/app/tribee/invite/viewmodel/TribeeInviteStateMachine_Factory;", "dataServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/tribee/invite/service/TribeeInviteDataService;", "newInstance", "Lkntr/app/tribee/invite/viewmodel/TribeeInviteStateMachine;", "dataService", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TribeeInviteStateMachine_Factory create(Provider<TribeeInviteDataService> provider) {
            Intrinsics.checkNotNullParameter(provider, "dataServiceProvider");
            return new TribeeInviteStateMachine_Factory(provider);
        }

        @JvmStatic
        public final TribeeInviteStateMachine newInstance(TribeeInviteDataService dataService) {
            Intrinsics.checkNotNullParameter(dataService, "dataService");
            return new TribeeInviteStateMachine(dataService);
        }
    }

    @JvmStatic
    public static final TribeeInviteStateMachine_Factory create(Provider<TribeeInviteDataService> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final TribeeInviteStateMachine newInstance(TribeeInviteDataService dataService) {
        return Companion.newInstance(dataService);
    }
}