package kntr.app.digital.preview;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.preview.api.GetCardList;
import kntr.app.digital.preview.shop.ShopPreviewComponent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CardPreviewPageModel_Factory.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011BO\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkntr/app/digital/preview/CardPreviewPageModel_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/preview/CardPreviewPageModel;", "shopPreviewComponentFactoryProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/shop/ShopPreviewComponent$Factory;", "paramsProvider", "Lkntr/app/digital/preview/api/GetCardList$RequestParams;", "getCardListProvider", "Lkntr/app/digital/preview/api/GetCardList;", "simpleCardProvider", "Lkntr/app/digital/preview/SimpleCard;", "dialogServiceProvider", "Lkntr/app/digital/preview/DialogService;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CardPreviewPageModel_Factory implements Factory<CardPreviewPageModel> {
    private final Provider<DialogService> dialogServiceProvider;
    private final Provider<GetCardList> getCardListProvider;
    private final Provider<GetCardList.RequestParams> paramsProvider;
    private final Provider<ShopPreviewComponent.Factory> shopPreviewComponentFactoryProvider;
    private final Provider<SimpleCard> simpleCardProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public CardPreviewPageModel_Factory(Provider<ShopPreviewComponent.Factory> provider, Provider<GetCardList.RequestParams> provider2, Provider<GetCardList> provider3, Provider<SimpleCard> provider4, Provider<DialogService> provider5) {
        Intrinsics.checkNotNullParameter(provider, "shopPreviewComponentFactoryProvider");
        Intrinsics.checkNotNullParameter(provider2, "paramsProvider");
        Intrinsics.checkNotNullParameter(provider3, "getCardListProvider");
        Intrinsics.checkNotNullParameter(provider4, "simpleCardProvider");
        Intrinsics.checkNotNullParameter(provider5, "dialogServiceProvider");
        this.shopPreviewComponentFactoryProvider = provider;
        this.paramsProvider = provider2;
        this.getCardListProvider = provider3;
        this.simpleCardProvider = provider4;
        this.dialogServiceProvider = provider5;
    }

    public CardPreviewPageModel get() {
        Companion companion = Companion;
        ShopPreviewComponent.Factory factory = this.shopPreviewComponentFactoryProvider.get();
        Intrinsics.checkNotNullExpressionValue(factory, "get(...)");
        GetCardList.RequestParams requestParams = this.paramsProvider.get();
        Intrinsics.checkNotNullExpressionValue(requestParams, "get(...)");
        GetCardList getCardList = this.getCardListProvider.get();
        Intrinsics.checkNotNullExpressionValue(getCardList, "get(...)");
        DialogService dialogService = this.dialogServiceProvider.get();
        Intrinsics.checkNotNullExpressionValue(dialogService, "get(...)");
        return companion.newInstance(factory, requestParams, getCardList, this.simpleCardProvider.get(), dialogService);
    }

    /* compiled from: CardPreviewPageModel_Factory.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JP\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007H\u0007J2\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\u0010H\u0007¨\u0006\u0018"}, d2 = {"Lkntr/app/digital/preview/CardPreviewPageModel_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/CardPreviewPageModel_Factory;", "shopPreviewComponentFactoryProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/shop/ShopPreviewComponent$Factory;", "paramsProvider", "Lkntr/app/digital/preview/api/GetCardList$RequestParams;", "getCardListProvider", "Lkntr/app/digital/preview/api/GetCardList;", "simpleCardProvider", "Lkntr/app/digital/preview/SimpleCard;", "dialogServiceProvider", "Lkntr/app/digital/preview/DialogService;", "newInstance", "Lkntr/app/digital/preview/CardPreviewPageModel;", "shopPreviewComponentFactory", "params", "getCardList", "simpleCard", "dialogService", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CardPreviewPageModel_Factory create(Provider<ShopPreviewComponent.Factory> provider, Provider<GetCardList.RequestParams> provider2, Provider<GetCardList> provider3, Provider<SimpleCard> provider4, Provider<DialogService> provider5) {
            Intrinsics.checkNotNullParameter(provider, "shopPreviewComponentFactoryProvider");
            Intrinsics.checkNotNullParameter(provider2, "paramsProvider");
            Intrinsics.checkNotNullParameter(provider3, "getCardListProvider");
            Intrinsics.checkNotNullParameter(provider4, "simpleCardProvider");
            Intrinsics.checkNotNullParameter(provider5, "dialogServiceProvider");
            return new CardPreviewPageModel_Factory(provider, provider2, provider3, provider4, provider5);
        }

        @JvmStatic
        public final CardPreviewPageModel newInstance(ShopPreviewComponent.Factory shopPreviewComponentFactory, GetCardList.RequestParams params, GetCardList getCardList, SimpleCard simpleCard, DialogService dialogService) {
            Intrinsics.checkNotNullParameter(shopPreviewComponentFactory, "shopPreviewComponentFactory");
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(getCardList, "getCardList");
            Intrinsics.checkNotNullParameter(dialogService, "dialogService");
            return new CardPreviewPageModel(shopPreviewComponentFactory, params, getCardList, simpleCard, dialogService);
        }
    }

    @JvmStatic
    public static final CardPreviewPageModel_Factory create(Provider<ShopPreviewComponent.Factory> provider, Provider<GetCardList.RequestParams> provider2, Provider<GetCardList> provider3, Provider<SimpleCard> provider4, Provider<DialogService> provider5) {
        return Companion.create(provider, provider2, provider3, provider4, provider5);
    }

    @JvmStatic
    public static final CardPreviewPageModel newInstance(ShopPreviewComponent.Factory shopPreviewComponentFactory, GetCardList.RequestParams params, GetCardList getCardList, SimpleCard simpleCard, DialogService dialogService) {
        return Companion.newInstance(shopPreviewComponentFactory, params, getCardList, simpleCard, dialogService);
    }
}