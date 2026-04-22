package kntr.app.digital.preview.card.web;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FeaturePanelService_Factory.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011BM\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkntr/app/digital/preview/card/web/FeaturePanelService_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/card/web/FeaturePanelService;", "featureDescDialogServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/card/web/FeatureDescDialogService;", "vmidProvider", RoomRecommendViewModel.EMPTY_CURSOR, "coroutineScopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "cardStateServiceProvider", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "getWebCardDescInfoProvider", "Lkntr/app/digital/preview/card/web/GetWebCardDescInfo;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FeaturePanelService_Factory implements Factory<FeaturePanelService> {
    private final Provider<DigitalCardStateService> cardStateServiceProvider;
    private final Provider<CoroutineScope> coroutineScopeProvider;
    private final Provider<FeatureDescDialogService> featureDescDialogServiceProvider;
    private final Provider<GetWebCardDescInfo> getWebCardDescInfoProvider;
    private final Provider<Long> vmidProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public FeaturePanelService_Factory(Provider<FeatureDescDialogService> provider, Provider<Long> provider2, Provider<CoroutineScope> provider3, Provider<DigitalCardStateService> provider4, Provider<GetWebCardDescInfo> provider5) {
        Intrinsics.checkNotNullParameter(provider, "featureDescDialogServiceProvider");
        Intrinsics.checkNotNullParameter(provider2, "vmidProvider");
        Intrinsics.checkNotNullParameter(provider3, "coroutineScopeProvider");
        Intrinsics.checkNotNullParameter(provider4, "cardStateServiceProvider");
        Intrinsics.checkNotNullParameter(provider5, "getWebCardDescInfoProvider");
        this.featureDescDialogServiceProvider = provider;
        this.vmidProvider = provider2;
        this.coroutineScopeProvider = provider3;
        this.cardStateServiceProvider = provider4;
        this.getWebCardDescInfoProvider = provider5;
    }

    public FeaturePanelService get() {
        Companion companion = Companion;
        FeatureDescDialogService featureDescDialogService = this.featureDescDialogServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(featureDescDialogService, "get(...)");
        Long l = this.vmidProvider.get();
        Intrinsics.checkNotNullExpressionValue(l, "get(...)");
        long longValue = l.longValue();
        CoroutineScope coroutineScope = this.coroutineScopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(coroutineScope, "get(...)");
        DigitalCardStateService digitalCardStateService = this.cardStateServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalCardStateService, "get(...)");
        GetWebCardDescInfo getWebCardDescInfo = this.getWebCardDescInfoProvider.get();
        Intrinsics.checkNotNullExpressionValue(getWebCardDescInfo, "get(...)");
        return companion.newInstance(featureDescDialogService, longValue, coroutineScope, digitalCardStateService, getWebCardDescInfo);
    }

    /* compiled from: FeaturePanelService_Factory.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JN\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007H\u0007J0\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0010H\u0007¨\u0006\u0018"}, d2 = {"Lkntr/app/digital/preview/card/web/FeaturePanelService_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/card/web/FeaturePanelService_Factory;", "featureDescDialogServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/card/web/FeatureDescDialogService;", "vmidProvider", RoomRecommendViewModel.EMPTY_CURSOR, "coroutineScopeProvider", "Lkotlinx/coroutines/CoroutineScope;", "cardStateServiceProvider", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "getWebCardDescInfoProvider", "Lkntr/app/digital/preview/card/web/GetWebCardDescInfo;", "newInstance", "Lkntr/app/digital/preview/card/web/FeaturePanelService;", "featureDescDialogService", "vmid", "coroutineScope", "cardStateService", "getWebCardDescInfo", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FeaturePanelService_Factory create(Provider<FeatureDescDialogService> provider, Provider<Long> provider2, Provider<CoroutineScope> provider3, Provider<DigitalCardStateService> provider4, Provider<GetWebCardDescInfo> provider5) {
            Intrinsics.checkNotNullParameter(provider, "featureDescDialogServiceProvider");
            Intrinsics.checkNotNullParameter(provider2, "vmidProvider");
            Intrinsics.checkNotNullParameter(provider3, "coroutineScopeProvider");
            Intrinsics.checkNotNullParameter(provider4, "cardStateServiceProvider");
            Intrinsics.checkNotNullParameter(provider5, "getWebCardDescInfoProvider");
            return new FeaturePanelService_Factory(provider, provider2, provider3, provider4, provider5);
        }

        @JvmStatic
        public final FeaturePanelService newInstance(FeatureDescDialogService featureDescDialogService, long vmid, CoroutineScope coroutineScope, DigitalCardStateService cardStateService, GetWebCardDescInfo getWebCardDescInfo) {
            Intrinsics.checkNotNullParameter(featureDescDialogService, "featureDescDialogService");
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
            Intrinsics.checkNotNullParameter(getWebCardDescInfo, "getWebCardDescInfo");
            return new FeaturePanelService(featureDescDialogService, vmid, coroutineScope, cardStateService, getWebCardDescInfo);
        }
    }

    @JvmStatic
    public static final FeaturePanelService_Factory create(Provider<FeatureDescDialogService> provider, Provider<Long> provider2, Provider<CoroutineScope> provider3, Provider<DigitalCardStateService> provider4, Provider<GetWebCardDescInfo> provider5) {
        return Companion.create(provider, provider2, provider3, provider4, provider5);
    }

    @JvmStatic
    public static final FeaturePanelService newInstance(FeatureDescDialogService featureDescDialogService, long vmid, CoroutineScope coroutineScope, DigitalCardStateService cardStateService, GetWebCardDescInfo getWebCardDescInfo) {
        return Companion.newInstance(featureDescDialogService, vmid, coroutineScope, cardStateService, getWebCardDescInfo);
    }
}