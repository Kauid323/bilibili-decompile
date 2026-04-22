package kntr.app.digital.preview.shop;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.preview.button.DigitalButtonsService;
import kntr.app.digital.preview.card.DigitalCardDetailInfoUIService;
import kntr.app.digital.preview.card.DigitalCardListUIService;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.digital.preview.card.web.FeaturePanelService;
import kntr.app.digital.preview.topmenu.DigitalTopBarUIService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShopPreviewUIService_Factory.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B[\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkntr/app/digital/preview/shop/ShopPreviewUIService_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/shop/ShopPreviewUIService;", "cardListServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/card/DigitalCardListUIService;", "topBarUIServiceProvider", "Lkntr/app/digital/preview/topmenu/DigitalTopBarUIService;", "cardStateServiceProvider", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "cardDetailInfoUIServiceProvider", "Lkntr/app/digital/preview/card/DigitalCardDetailInfoUIService;", "buttonsServiceProvider", "Lkntr/app/digital/preview/button/DigitalButtonsService;", "featurePanelServiceProvider", "Lkntr/app/digital/preview/card/web/FeaturePanelService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ShopPreviewUIService_Factory implements Factory<ShopPreviewUIService> {
    private final Provider<DigitalButtonsService> buttonsServiceProvider;
    private final Provider<DigitalCardDetailInfoUIService> cardDetailInfoUIServiceProvider;
    private final Provider<DigitalCardListUIService> cardListServiceProvider;
    private final Provider<DigitalCardStateService> cardStateServiceProvider;
    private final Provider<FeaturePanelService> featurePanelServiceProvider;
    private final Provider<DigitalTopBarUIService> topBarUIServiceProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ShopPreviewUIService_Factory(Provider<DigitalCardListUIService> provider, Provider<DigitalTopBarUIService> provider2, Provider<DigitalCardStateService> provider3, Provider<DigitalCardDetailInfoUIService> provider4, Provider<DigitalButtonsService> provider5, Provider<FeaturePanelService> provider6) {
        Intrinsics.checkNotNullParameter(provider, "cardListServiceProvider");
        Intrinsics.checkNotNullParameter(provider2, "topBarUIServiceProvider");
        Intrinsics.checkNotNullParameter(provider3, "cardStateServiceProvider");
        Intrinsics.checkNotNullParameter(provider4, "cardDetailInfoUIServiceProvider");
        Intrinsics.checkNotNullParameter(provider5, "buttonsServiceProvider");
        Intrinsics.checkNotNullParameter(provider6, "featurePanelServiceProvider");
        this.cardListServiceProvider = provider;
        this.topBarUIServiceProvider = provider2;
        this.cardStateServiceProvider = provider3;
        this.cardDetailInfoUIServiceProvider = provider4;
        this.buttonsServiceProvider = provider5;
        this.featurePanelServiceProvider = provider6;
    }

    public ShopPreviewUIService get() {
        Companion companion = Companion;
        DigitalCardListUIService digitalCardListUIService = this.cardListServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalCardListUIService, "get(...)");
        DigitalTopBarUIService digitalTopBarUIService = this.topBarUIServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalTopBarUIService, "get(...)");
        DigitalCardStateService digitalCardStateService = this.cardStateServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalCardStateService, "get(...)");
        DigitalCardDetailInfoUIService digitalCardDetailInfoUIService = this.cardDetailInfoUIServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalCardDetailInfoUIService, "get(...)");
        DigitalButtonsService digitalButtonsService = this.buttonsServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(digitalButtonsService, "get(...)");
        FeaturePanelService featurePanelService = this.featurePanelServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(featurePanelService, "get(...)");
        return companion.newInstance(digitalCardListUIService, digitalTopBarUIService, digitalCardStateService, digitalCardDetailInfoUIService, digitalButtonsService, featurePanelService);
    }

    /* compiled from: ShopPreviewUIService_Factory.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\\\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007H\u0007J8\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0012H\u0007¨\u0006\u001b"}, d2 = {"Lkntr/app/digital/preview/shop/ShopPreviewUIService_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/shop/ShopPreviewUIService_Factory;", "cardListServiceProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/card/DigitalCardListUIService;", "topBarUIServiceProvider", "Lkntr/app/digital/preview/topmenu/DigitalTopBarUIService;", "cardStateServiceProvider", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "cardDetailInfoUIServiceProvider", "Lkntr/app/digital/preview/card/DigitalCardDetailInfoUIService;", "buttonsServiceProvider", "Lkntr/app/digital/preview/button/DigitalButtonsService;", "featurePanelServiceProvider", "Lkntr/app/digital/preview/card/web/FeaturePanelService;", "newInstance", "Lkntr/app/digital/preview/shop/ShopPreviewUIService;", "cardListService", "topBarUIService", "cardStateService", "cardDetailInfoUIService", "buttonsService", "featurePanelService", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ShopPreviewUIService_Factory create(Provider<DigitalCardListUIService> provider, Provider<DigitalTopBarUIService> provider2, Provider<DigitalCardStateService> provider3, Provider<DigitalCardDetailInfoUIService> provider4, Provider<DigitalButtonsService> provider5, Provider<FeaturePanelService> provider6) {
            Intrinsics.checkNotNullParameter(provider, "cardListServiceProvider");
            Intrinsics.checkNotNullParameter(provider2, "topBarUIServiceProvider");
            Intrinsics.checkNotNullParameter(provider3, "cardStateServiceProvider");
            Intrinsics.checkNotNullParameter(provider4, "cardDetailInfoUIServiceProvider");
            Intrinsics.checkNotNullParameter(provider5, "buttonsServiceProvider");
            Intrinsics.checkNotNullParameter(provider6, "featurePanelServiceProvider");
            return new ShopPreviewUIService_Factory(provider, provider2, provider3, provider4, provider5, provider6);
        }

        @JvmStatic
        public final ShopPreviewUIService newInstance(DigitalCardListUIService cardListService, DigitalTopBarUIService topBarUIService, DigitalCardStateService cardStateService, DigitalCardDetailInfoUIService cardDetailInfoUIService, DigitalButtonsService buttonsService, FeaturePanelService featurePanelService) {
            Intrinsics.checkNotNullParameter(cardListService, "cardListService");
            Intrinsics.checkNotNullParameter(topBarUIService, "topBarUIService");
            Intrinsics.checkNotNullParameter(cardStateService, "cardStateService");
            Intrinsics.checkNotNullParameter(cardDetailInfoUIService, "cardDetailInfoUIService");
            Intrinsics.checkNotNullParameter(buttonsService, "buttonsService");
            Intrinsics.checkNotNullParameter(featurePanelService, "featurePanelService");
            return new ShopPreviewUIService(cardListService, topBarUIService, cardStateService, cardDetailInfoUIService, buttonsService, featurePanelService);
        }
    }

    @JvmStatic
    public static final ShopPreviewUIService_Factory create(Provider<DigitalCardListUIService> provider, Provider<DigitalTopBarUIService> provider2, Provider<DigitalCardStateService> provider3, Provider<DigitalCardDetailInfoUIService> provider4, Provider<DigitalButtonsService> provider5, Provider<FeaturePanelService> provider6) {
        return Companion.create(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @JvmStatic
    public static final ShopPreviewUIService newInstance(DigitalCardListUIService cardListService, DigitalTopBarUIService topBarUIService, DigitalCardStateService cardStateService, DigitalCardDetailInfoUIService cardDetailInfoUIService, DigitalButtonsService buttonsService, FeaturePanelService featurePanelService) {
        return Companion.newInstance(cardListService, topBarUIService, cardStateService, cardDetailInfoUIService, buttonsService, featurePanelService);
    }
}