package kntr.app.digital.preview.usage;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.preview.DialogService;
import kntr.app.digital.preview.action.HandleAction;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DigitalUsageMenuDialogService_Factory.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011BM\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkntr/app/digital/preview/usage/DigitalUsageMenuDialogService_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/usage/DigitalUsageMenuDialogService;", "handleActionProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/action/HandleAction;", "usageProvider", "Lkntr/app/digital/preview/usage/Usage;", "cardStateServiceProvider", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "activityIdProvider", RoomRecommendViewModel.EMPTY_CURSOR, "dialogServiceProvider", "Lkntr/app/digital/preview/DialogService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DigitalUsageMenuDialogService_Factory implements Factory<DigitalUsageMenuDialogService> {
    private final Provider<Integer> activityIdProvider;
    private final Provider<DigitalCardStateService> cardStateServiceProvider;
    private final Provider<DialogService> dialogServiceProvider;
    private final Provider<HandleAction> handleActionProvider;
    private final Provider<Usage> usageProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public DigitalUsageMenuDialogService_Factory(Provider<HandleAction> provider, Provider<Usage> provider2, Provider<DigitalCardStateService> provider3, Provider<Integer> provider4, Provider<DialogService> provider5) {
        Intrinsics.checkNotNullParameter(provider, "handleActionProvider");
        Intrinsics.checkNotNullParameter(provider2, "usageProvider");
        Intrinsics.checkNotNullParameter(provider3, "cardStateServiceProvider");
        Intrinsics.checkNotNullParameter(provider4, "activityIdProvider");
        Intrinsics.checkNotNullParameter(provider5, "dialogServiceProvider");
        this.handleActionProvider = provider;
        this.usageProvider = provider2;
        this.cardStateServiceProvider = provider3;
        this.activityIdProvider = provider4;
        this.dialogServiceProvider = provider5;
    }

    public DigitalUsageMenuDialogService get() {
        Companion companion = Companion;
        Lazy<HandleAction> lazy = DoubleCheck.lazy(this.handleActionProvider);
        Intrinsics.checkNotNullExpressionValue(lazy, "lazy(...)");
        Usage usage = this.usageProvider.get();
        Intrinsics.checkNotNullExpressionValue(usage, "get(...)");
        DigitalCardStateService digitalCardStateService = this.cardStateServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalCardStateService, "get(...)");
        Integer num = this.activityIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(num, "get(...)");
        int intValue = num.intValue();
        DialogService dialogService = this.dialogServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(dialogService, "get(...)");
        return companion.newInstance(lazy, usage, digitalCardStateService, intValue, dialogService);
    }

    /* compiled from: DigitalUsageMenuDialogService_Factory.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JN\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007H\u0007J6\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0010H\u0007¨\u0006\u0019"}, d2 = {"Lkntr/app/digital/preview/usage/DigitalUsageMenuDialogService_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/usage/DigitalUsageMenuDialogService_Factory;", "handleActionProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/action/HandleAction;", "usageProvider", "Lkntr/app/digital/preview/usage/Usage;", "cardStateServiceProvider", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "activityIdProvider", RoomRecommendViewModel.EMPTY_CURSOR, "dialogServiceProvider", "Lkntr/app/digital/preview/DialogService;", "newInstance", "Lkntr/app/digital/preview/usage/DigitalUsageMenuDialogService;", "handleAction", "Ldagger/Lazy;", "usage", "cardStateService", "activityId", "dialogService", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DigitalUsageMenuDialogService_Factory create(Provider<HandleAction> provider, Provider<Usage> provider2, Provider<DigitalCardStateService> provider3, Provider<Integer> provider4, Provider<DialogService> provider5) {
            Intrinsics.checkNotNullParameter(provider, "handleActionProvider");
            Intrinsics.checkNotNullParameter(provider2, "usageProvider");
            Intrinsics.checkNotNullParameter(provider3, "cardStateServiceProvider");
            Intrinsics.checkNotNullParameter(provider4, "activityIdProvider");
            Intrinsics.checkNotNullParameter(provider5, "dialogServiceProvider");
            return new DigitalUsageMenuDialogService_Factory(provider, provider2, provider3, provider4, provider5);
        }

        @JvmStatic
        public final DigitalUsageMenuDialogService newInstance(Lazy<HandleAction> lazy, Usage usage, DigitalCardStateService cardStateService, int activityId, DialogService dialogService) {
            Intrinsics.checkNotNullParameter(lazy, "handleAction");
            Intrinsics.checkNotNullParameter(usage, "usage");
            Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
            Intrinsics.checkNotNullParameter(dialogService, "dialogService");
            return new DigitalUsageMenuDialogService(lazy, usage, cardStateService, activityId, dialogService);
        }
    }

    @JvmStatic
    public static final DigitalUsageMenuDialogService_Factory create(Provider<HandleAction> provider, Provider<Usage> provider2, Provider<DigitalCardStateService> provider3, Provider<Integer> provider4, Provider<DialogService> provider5) {
        return Companion.create(provider, provider2, provider3, provider4, provider5);
    }

    @JvmStatic
    public static final DigitalUsageMenuDialogService newInstance(Lazy<HandleAction> lazy, Usage usage, DigitalCardStateService cardStateService, int activityId, DialogService dialogService) {
        return Companion.newInstance(lazy, usage, cardStateService, activityId, dialogService);
    }
}