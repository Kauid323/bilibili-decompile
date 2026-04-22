package kntr.app.digital.preview.shop;

import dagger.internal.Factory;
import java.util.List;
import javax.inject.Provider;
import kntr.app.digital.preview.cardlistmapper.CardItem;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShopPreviewPageDataModule_ProvideInitialPageFactory.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u001f\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\nR\u001e\u0010\u0003\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/app/digital/preview/shop/ShopPreviewPageDataModule_ProvideInitialPageFactory;", "Ldagger/internal/Factory;", RoomRecommendViewModel.EMPTY_CURSOR, "cardListProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/preview/cardlistmapper/CardItem;", "<init>", "(Ljavax/inject/Provider;)V", "get", "()Ljava/lang/Integer;", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ShopPreviewPageDataModule_ProvideInitialPageFactory implements Factory<Integer> {
    private final Provider<List<CardItem<?>>> cardListProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public ShopPreviewPageDataModule_ProvideInitialPageFactory(Provider<List<CardItem<?>>> provider) {
        Intrinsics.checkNotNullParameter(provider, "cardListProvider");
        this.cardListProvider = provider;
    }

    /* renamed from: get */
    public Integer m1000get() {
        Companion companion = Companion;
        List<CardItem<?>> list = this.cardListProvider.get();
        Intrinsics.checkNotNullExpressionValue(list, "get(...)");
        return Integer.valueOf(companion.provideInitialPage(list));
    }

    /* compiled from: ShopPreviewPageDataModule_ProvideInitialPageFactory.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b0\u0007H\u0007J\u001a\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bH\u0007¨\u0006\r"}, d2 = {"Lkntr/app/digital/preview/shop/ShopPreviewPageDataModule_ProvideInitialPageFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/preview/shop/ShopPreviewPageDataModule_ProvideInitialPageFactory;", "cardListProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/preview/cardlistmapper/CardItem;", "provideInitialPage", RoomRecommendViewModel.EMPTY_CURSOR, "cardList", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ShopPreviewPageDataModule_ProvideInitialPageFactory create(Provider<List<CardItem<?>>> provider) {
            Intrinsics.checkNotNullParameter(provider, "cardListProvider");
            return new ShopPreviewPageDataModule_ProvideInitialPageFactory(provider);
        }

        @JvmStatic
        public final int provideInitialPage(List<? extends CardItem<?>> list) {
            Intrinsics.checkNotNullParameter(list, "cardList");
            return ShopPreviewPageDataModule.INSTANCE.provideInitialPage(list);
        }
    }

    @JvmStatic
    public static final ShopPreviewPageDataModule_ProvideInitialPageFactory create(Provider<List<CardItem<?>>> provider) {
        return Companion.create(provider);
    }

    @JvmStatic
    public static final int provideInitialPage(List<? extends CardItem<?>> list) {
        return Companion.provideInitialPage(list);
    }
}