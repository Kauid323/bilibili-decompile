package kntr.app.digital.backpack.aggregate;

import dagger.internal.Factory;
import io.ktor.client.HttpClient;
import javax.inject.Provider;
import kntr.app.digital.backpack.aggregate.BackpackPageComponent;
import kntr.app.digital.backpack.api.GetBackpackAssetBag;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BackpackPageComponent_Impl_ProvideGetBackpackAssetBagFactory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/digital/backpack/aggregate/BackpackPageComponent_Impl_ProvideGetBackpackAssetBagFactory;", "Ldagger/internal/Factory;", "Lkntr/app/digital/backpack/api/GetBackpackAssetBag;", "httpClientProvider", "Ljavax/inject/Provider;", "Lio/ktor/client/HttpClient;", "actIdProvider", RoomRecommendViewModel.EMPTY_CURSOR, "vmidProvider", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BackpackPageComponent_Impl_ProvideGetBackpackAssetBagFactory implements Factory<GetBackpackAssetBag> {
    private final Provider<Integer> actIdProvider;
    private final Provider<HttpClient> httpClientProvider;
    private final Provider<Long> vmidProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public BackpackPageComponent_Impl_ProvideGetBackpackAssetBagFactory(Provider<HttpClient> provider, Provider<Integer> provider2, Provider<Long> provider3) {
        Intrinsics.checkNotNullParameter(provider, "httpClientProvider");
        Intrinsics.checkNotNullParameter(provider2, "actIdProvider");
        Intrinsics.checkNotNullParameter(provider3, "vmidProvider");
        this.httpClientProvider = provider;
        this.actIdProvider = provider2;
        this.vmidProvider = provider3;
    }

    public GetBackpackAssetBag get() {
        Companion companion = Companion;
        HttpClient httpClient = this.httpClientProvider.get();
        Intrinsics.checkNotNullExpressionValue(httpClient, "get(...)");
        Integer num = this.actIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(num, "get(...)");
        int intValue = num.intValue();
        Long l = this.vmidProvider.get();
        Intrinsics.checkNotNullExpressionValue(l, "get(...)");
        return companion.provideGetBackpackAssetBag(httpClient, intValue, l.longValue());
    }

    /* compiled from: BackpackPageComponent_Impl_ProvideGetBackpackAssetBagFactory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/digital/backpack/aggregate/BackpackPageComponent_Impl_ProvideGetBackpackAssetBagFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/digital/backpack/aggregate/BackpackPageComponent_Impl_ProvideGetBackpackAssetBagFactory;", "httpClientProvider", "Ljavax/inject/Provider;", "Lio/ktor/client/HttpClient;", "actIdProvider", RoomRecommendViewModel.EMPTY_CURSOR, "vmidProvider", RoomRecommendViewModel.EMPTY_CURSOR, "provideGetBackpackAssetBag", "Lkntr/app/digital/backpack/api/GetBackpackAssetBag;", "httpClient", "actId", "vmid", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BackpackPageComponent_Impl_ProvideGetBackpackAssetBagFactory create(Provider<HttpClient> provider, Provider<Integer> provider2, Provider<Long> provider3) {
            Intrinsics.checkNotNullParameter(provider, "httpClientProvider");
            Intrinsics.checkNotNullParameter(provider2, "actIdProvider");
            Intrinsics.checkNotNullParameter(provider3, "vmidProvider");
            return new BackpackPageComponent_Impl_ProvideGetBackpackAssetBagFactory(provider, provider2, provider3);
        }

        @JvmStatic
        public final GetBackpackAssetBag provideGetBackpackAssetBag(HttpClient httpClient, int actId, long vmid) {
            Intrinsics.checkNotNullParameter(httpClient, "httpClient");
            return BackpackPageComponent.Impl.INSTANCE.provideGetBackpackAssetBag(httpClient, actId, vmid);
        }
    }

    @JvmStatic
    public static final BackpackPageComponent_Impl_ProvideGetBackpackAssetBagFactory create(Provider<HttpClient> provider, Provider<Integer> provider2, Provider<Long> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final GetBackpackAssetBag provideGetBackpackAssetBag(HttpClient httpClient, int actId, long vmid) {
        return Companion.provideGetBackpackAssetBag(httpClient, actId, vmid);
    }
}