package kntr.app.digital.preview.shop;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.preview.api.CardPreviewModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShopPreviewPageDataModule_ProvideInitialFrontAnchorIdFactory.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/app/digital/preview/shop/ShopPreviewPageDataModule_ProvideInitialFrontAnchorIdFactory;", "Ldagger/internal/Factory;", RoomRecommendViewModel.EMPTY_CURSOR, "originModelProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/api/CardPreviewModel;", "<init>", "(Ljavax/inject/Provider;)V", "get", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ShopPreviewPageDataModule_ProvideInitialFrontAnchorIdFactory implements Factory<String> {
    private final Provider<CardPreviewModel> originModelProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ShopPreviewPageDataModule_ProvideInitialFrontAnchorIdFactory(Provider<CardPreviewModel> provider) {
        Intrinsics.checkNotNullParameter(provider, "originModelProvider");
        this.originModelProvider = provider;
    }

    public String get() {
        Companion companion = Companion;
        CardPreviewModel cardPreviewModel = this.originModelProvider.get();
        Intrinsics.checkNotNullExpressionValue(cardPreviewModel, "get(...)");
        return companion.provideInitialFrontAnchorId(cardPreviewModel);
    }

    /* compiled from: ShopPreviewPageDataModule_ProvideInitialFrontAnchorIdFactory.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0007¨\u0006\f"}, d2 = {"Lkntr/app/digital/preview/shop/ShopPreviewPageDataModule_ProvideInitialFrontAnchorIdFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/shop/ShopPreviewPageDataModule_ProvideInitialFrontAnchorIdFactory;", "originModelProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/api/CardPreviewModel;", "provideInitialFrontAnchorId", RoomRecommendViewModel.EMPTY_CURSOR, "originModel", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ShopPreviewPageDataModule_ProvideInitialFrontAnchorIdFactory create(Provider<CardPreviewModel> provider) {
            Intrinsics.checkNotNullParameter(provider, "originModelProvider");
            return new ShopPreviewPageDataModule_ProvideInitialFrontAnchorIdFactory(provider);
        }

        @JvmStatic
        public final String provideInitialFrontAnchorId(CardPreviewModel originModel) {
            Intrinsics.checkNotNullParameter(originModel, "originModel");
            return ShopPreviewPageDataModule.INSTANCE.provideInitialFrontAnchorId(originModel);
        }
    }

    @JvmStatic
    public static final ShopPreviewPageDataModule_ProvideInitialFrontAnchorIdFactory create(Provider<CardPreviewModel> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final String provideInitialFrontAnchorId(CardPreviewModel originModel) {
        return Companion.provideInitialFrontAnchorId(originModel);
    }
}