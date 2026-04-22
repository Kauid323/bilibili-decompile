package kntr.app.digital.preview.topmenu;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.preview.action.HandleAction;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.digital.preview.viewmore.DigitalViewMoreService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DigitalTopBarUIService_Factory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/digital/preview/topmenu/DigitalTopBarUIService_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/topmenu/DigitalTopBarUIService;", "handleActionProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/action/HandleAction;", "viewMoreServiceProvider", "Lkntr/app/digital/preview/viewmore/DigitalViewMoreService;", "cardStateServiceProvider", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DigitalTopBarUIService_Factory implements Factory<DigitalTopBarUIService> {
    private final Provider<DigitalCardStateService> cardStateServiceProvider;
    private final Provider<HandleAction> handleActionProvider;
    private final Provider<DigitalViewMoreService> viewMoreServiceProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public DigitalTopBarUIService_Factory(Provider<HandleAction> provider, Provider<DigitalViewMoreService> provider2, Provider<DigitalCardStateService> provider3) {
        Intrinsics.checkNotNullParameter(provider, "handleActionProvider");
        Intrinsics.checkNotNullParameter(provider2, "viewMoreServiceProvider");
        Intrinsics.checkNotNullParameter(provider3, "cardStateServiceProvider");
        this.handleActionProvider = provider;
        this.viewMoreServiceProvider = provider2;
        this.cardStateServiceProvider = provider3;
    }

    public DigitalTopBarUIService get() {
        Companion companion = Companion;
        HandleAction handleAction = this.handleActionProvider.get();
        Intrinsics.checkNotNullExpressionValue(handleAction, "get(...)");
        DigitalViewMoreService digitalViewMoreService = this.viewMoreServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalViewMoreService, "get(...)");
        DigitalCardStateService digitalCardStateService = this.cardStateServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalCardStateService, "get(...)");
        return companion.newInstance(handleAction, digitalViewMoreService, digitalCardStateService);
    }

    /* compiled from: DigitalTopBarUIService_Factory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/digital/preview/topmenu/DigitalTopBarUIService_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/topmenu/DigitalTopBarUIService_Factory;", "handleActionProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/action/HandleAction;", "viewMoreServiceProvider", "Lkntr/app/digital/preview/viewmore/DigitalViewMoreService;", "cardStateServiceProvider", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "newInstance", "Lkntr/app/digital/preview/topmenu/DigitalTopBarUIService;", "handleAction", "viewMoreService", "cardStateService", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DigitalTopBarUIService_Factory create(Provider<HandleAction> provider, Provider<DigitalViewMoreService> provider2, Provider<DigitalCardStateService> provider3) {
            Intrinsics.checkNotNullParameter(provider, "handleActionProvider");
            Intrinsics.checkNotNullParameter(provider2, "viewMoreServiceProvider");
            Intrinsics.checkNotNullParameter(provider3, "cardStateServiceProvider");
            return new DigitalTopBarUIService_Factory(provider, provider2, provider3);
        }

        @JvmStatic
        public final DigitalTopBarUIService newInstance(HandleAction handleAction, DigitalViewMoreService viewMoreService, DigitalCardStateService cardStateService) {
            Intrinsics.checkNotNullParameter(handleAction, "handleAction");
            Intrinsics.checkNotNullParameter(viewMoreService, "viewMoreService");
            Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
            return new DigitalTopBarUIService(handleAction, viewMoreService, cardStateService);
        }
    }

    @JvmStatic
    public static final DigitalTopBarUIService_Factory create(Provider<HandleAction> provider, Provider<DigitalViewMoreService> provider2, Provider<DigitalCardStateService> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final DigitalTopBarUIService newInstance(HandleAction handleAction, DigitalViewMoreService viewMoreService, DigitalCardStateService cardStateService) {
        return Companion.newInstance(handleAction, viewMoreService, cardStateService);
    }
}