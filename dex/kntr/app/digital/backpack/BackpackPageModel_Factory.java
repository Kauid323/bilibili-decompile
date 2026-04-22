package kntr.app.digital.backpack;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.digital.backpack.api.GetBackpackAssetBag;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BackpackPageModel_Factory.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/app/digital/backpack/BackpackPageModel_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/backpack/BackpackPageModel;", "createBackpackKomponentProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/backpack/CreateBackpackKomponent;", "getBackpackAssetBagProvider", "Lkntr/app/digital/backpack/api/GetBackpackAssetBag;", "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BackpackPageModel_Factory implements Factory<BackpackPageModel> {
    private final Provider<CreateBackpackKomponent> createBackpackKomponentProvider;
    private final Provider<GetBackpackAssetBag> getBackpackAssetBagProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public BackpackPageModel_Factory(Provider<CreateBackpackKomponent> provider, Provider<GetBackpackAssetBag> provider2) {
        Intrinsics.checkNotNullParameter(provider, "createBackpackKomponentProvider");
        Intrinsics.checkNotNullParameter(provider2, "getBackpackAssetBagProvider");
        this.createBackpackKomponentProvider = provider;
        this.getBackpackAssetBagProvider = provider2;
    }

    public BackpackPageModel get() {
        Companion companion = Companion;
        CreateBackpackKomponent createBackpackKomponent = this.createBackpackKomponentProvider.get();
        Intrinsics.checkNotNullExpressionValue(createBackpackKomponent, "get(...)");
        GetBackpackAssetBag getBackpackAssetBag = this.getBackpackAssetBagProvider.get();
        Intrinsics.checkNotNullExpressionValue(getBackpackAssetBag, "get(...)");
        return companion.newInstance(createBackpackKomponent, getBackpackAssetBag);
    }

    /* compiled from: BackpackPageModel_Factory.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nH\u0007¨\u0006\u000f"}, d2 = {"Lkntr/app/digital/backpack/BackpackPageModel_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/backpack/BackpackPageModel_Factory;", "createBackpackKomponentProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/backpack/CreateBackpackKomponent;", "getBackpackAssetBagProvider", "Lkntr/app/digital/backpack/api/GetBackpackAssetBag;", "newInstance", "Lkntr/app/digital/backpack/BackpackPageModel;", "createBackpackKomponent", "getBackpackAssetBag", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BackpackPageModel_Factory create(Provider<CreateBackpackKomponent> provider, Provider<GetBackpackAssetBag> provider2) {
            Intrinsics.checkNotNullParameter(provider, "createBackpackKomponentProvider");
            Intrinsics.checkNotNullParameter(provider2, "getBackpackAssetBagProvider");
            return new BackpackPageModel_Factory(provider, provider2);
        }

        @JvmStatic
        public final BackpackPageModel newInstance(CreateBackpackKomponent createBackpackKomponent, GetBackpackAssetBag getBackpackAssetBag) {
            Intrinsics.checkNotNullParameter(createBackpackKomponent, "createBackpackKomponent");
            Intrinsics.checkNotNullParameter(getBackpackAssetBag, "getBackpackAssetBag");
            return new BackpackPageModel(createBackpackKomponent, getBackpackAssetBag);
        }
    }

    @JvmStatic
    public static final BackpackPageModel_Factory create(Provider<CreateBackpackKomponent> provider, Provider<GetBackpackAssetBag> provider2) {
        return Companion.create(provider, provider2);
    }

    @JvmStatic
    public static final BackpackPageModel newInstance(CreateBackpackKomponent createBackpackKomponent, GetBackpackAssetBag getBackpackAssetBag) {
        return Companion.newInstance(createBackpackKomponent, getBackpackAssetBag);
    }
}