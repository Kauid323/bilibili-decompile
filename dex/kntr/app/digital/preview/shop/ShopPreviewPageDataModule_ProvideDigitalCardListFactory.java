package kntr.app.digital.preview.shop;

import dagger.internal.Factory;
import java.util.List;
import java.util.Map;
import javax.inject.Provider;
import kntr.app.digital.preview.api.CardPreviewModel;
import kntr.app.digital.preview.cardlistmapper.CardItem;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShopPreviewPageDataModule_ProvideDigitalCardListFactory.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u000f2\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00020\u0001:\u0001\u000fB=\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b0\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/app/digital/preview/shop/ShopPreviewPageDataModule_ProvideDigitalCardListFactory;", "Ldagger/internal/Factory;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/preview/cardlistmapper/CardItem;", "vMidProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, "fromParamsProvider", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "originModelProvider", "Lkntr/app/digital/preview/api/CardPreviewModel;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ShopPreviewPageDataModule_ProvideDigitalCardListFactory implements Factory<List<? extends CardItem<?>>> {
    private final Provider<Map<String, String>> fromParamsProvider;
    private final Provider<CardPreviewModel> originModelProvider;
    private final Provider<Long> vMidProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ShopPreviewPageDataModule_ProvideDigitalCardListFactory(Provider<Long> provider, Provider<Map<String, String>> provider2, Provider<CardPreviewModel> provider3) {
        Intrinsics.checkNotNullParameter(provider, "vMidProvider");
        Intrinsics.checkNotNullParameter(provider2, "fromParamsProvider");
        Intrinsics.checkNotNullParameter(provider3, "originModelProvider");
        this.vMidProvider = provider;
        this.fromParamsProvider = provider2;
        this.originModelProvider = provider3;
    }

    public List<CardItem<?>> get() {
        Companion companion = Companion;
        Long l = this.vMidProvider.get();
        Intrinsics.checkNotNullExpressionValue(l, "get(...)");
        long longValue = l.longValue();
        Map<String, String> map = this.fromParamsProvider.get();
        Intrinsics.checkNotNullExpressionValue(map, "get(...)");
        CardPreviewModel cardPreviewModel = this.originModelProvider.get();
        Intrinsics.checkNotNullExpressionValue(cardPreviewModel, "get(...)");
        return companion.provideDigitalCardList(longValue, map, cardPreviewModel);
    }

    /* compiled from: ShopPreviewPageDataModule_ProvideDigitalCardListFactory.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n0\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0007H\u0007J6\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0013\u001a\u00020\rH\u0007¨\u0006\u0014"}, d2 = {"Lkntr/app/digital/preview/shop/ShopPreviewPageDataModule_ProvideDigitalCardListFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/shop/ShopPreviewPageDataModule_ProvideDigitalCardListFactory;", "vMidProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, "fromParamsProvider", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "originModelProvider", "Lkntr/app/digital/preview/api/CardPreviewModel;", "provideDigitalCardList", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/preview/cardlistmapper/CardItem;", "vMid", "fromParams", "originModel", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ShopPreviewPageDataModule_ProvideDigitalCardListFactory create(Provider<Long> provider, Provider<Map<String, String>> provider2, Provider<CardPreviewModel> provider3) {
            Intrinsics.checkNotNullParameter(provider, "vMidProvider");
            Intrinsics.checkNotNullParameter(provider2, "fromParamsProvider");
            Intrinsics.checkNotNullParameter(provider3, "originModelProvider");
            return new ShopPreviewPageDataModule_ProvideDigitalCardListFactory(provider, provider2, provider3);
        }

        @JvmStatic
        public final List<CardItem<?>> provideDigitalCardList(long vMid, Map<String, String> map, CardPreviewModel originModel) {
            Intrinsics.checkNotNullParameter(map, "fromParams");
            Intrinsics.checkNotNullParameter(originModel, "originModel");
            return ShopPreviewPageDataModule.INSTANCE.provideDigitalCardList(vMid, map, originModel);
        }
    }

    @JvmStatic
    public static final ShopPreviewPageDataModule_ProvideDigitalCardListFactory create(Provider<Long> provider, Provider<Map<String, String>> provider2, Provider<CardPreviewModel> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final List<CardItem<?>> provideDigitalCardList(long vMid, Map<String, String> map, CardPreviewModel originModel) {
        return Companion.provideDigitalCardList(vMid, map, originModel);
    }
}