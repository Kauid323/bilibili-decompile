package kntr.app.cheese.space;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.cheese.space.api.SpaceCheesePageApi;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpaceCheesePageModel_Factory.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/app/cheese/space/SpaceCheesePageModel_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/cheese/space/SpaceCheesePageModel;", "pgcPageChannelApiProvider", "Ljavax/inject/Provider;", "Lkntr/app/cheese/space/api/SpaceCheesePageApi;", "createPerLoadKomponentProvider", "Lkntr/app/cheese/space/CreatePerLoadKomponent;", "upIdProvider", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SpaceCheesePageModel_Factory implements Factory<SpaceCheesePageModel> {
    private final Provider<CreatePerLoadKomponent> createPerLoadKomponentProvider;
    private final Provider<SpaceCheesePageApi> pgcPageChannelApiProvider;
    private final Provider<Long> upIdProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public SpaceCheesePageModel_Factory(Provider<SpaceCheesePageApi> provider, Provider<CreatePerLoadKomponent> provider2, Provider<Long> provider3) {
        Intrinsics.checkNotNullParameter(provider, "pgcPageChannelApiProvider");
        Intrinsics.checkNotNullParameter(provider2, "createPerLoadKomponentProvider");
        Intrinsics.checkNotNullParameter(provider3, "upIdProvider");
        this.pgcPageChannelApiProvider = provider;
        this.createPerLoadKomponentProvider = provider2;
        this.upIdProvider = provider3;
    }

    public SpaceCheesePageModel get() {
        Companion companion = Companion;
        SpaceCheesePageApi spaceCheesePageApi = this.pgcPageChannelApiProvider.get();
        Intrinsics.checkNotNullExpressionValue(spaceCheesePageApi, "get(...)");
        CreatePerLoadKomponent createPerLoadKomponent = this.createPerLoadKomponentProvider.get();
        Intrinsics.checkNotNullExpressionValue(createPerLoadKomponent, "get(...)");
        Long l = this.upIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(l, "get(...)");
        return companion.newInstance(spaceCheesePageApi, createPerLoadKomponent, l.longValue());
    }

    /* compiled from: SpaceCheesePageModel_Factory.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007H\u0007J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/cheese/space/SpaceCheesePageModel_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/cheese/space/SpaceCheesePageModel_Factory;", "pgcPageChannelApiProvider", "Ljavax/inject/Provider;", "Lkntr/app/cheese/space/api/SpaceCheesePageApi;", "createPerLoadKomponentProvider", "Lkntr/app/cheese/space/CreatePerLoadKomponent;", "upIdProvider", RoomRecommendViewModel.EMPTY_CURSOR, "newInstance", "Lkntr/app/cheese/space/SpaceCheesePageModel;", "pgcPageChannelApi", "createPerLoadKomponent", "upId", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SpaceCheesePageModel_Factory create(Provider<SpaceCheesePageApi> provider, Provider<CreatePerLoadKomponent> provider2, Provider<Long> provider3) {
            Intrinsics.checkNotNullParameter(provider, "pgcPageChannelApiProvider");
            Intrinsics.checkNotNullParameter(provider2, "createPerLoadKomponentProvider");
            Intrinsics.checkNotNullParameter(provider3, "upIdProvider");
            return new SpaceCheesePageModel_Factory(provider, provider2, provider3);
        }

        @JvmStatic
        public final SpaceCheesePageModel newInstance(SpaceCheesePageApi pgcPageChannelApi, CreatePerLoadKomponent createPerLoadKomponent, long upId) {
            Intrinsics.checkNotNullParameter(pgcPageChannelApi, "pgcPageChannelApi");
            Intrinsics.checkNotNullParameter(createPerLoadKomponent, "createPerLoadKomponent");
            return new SpaceCheesePageModel(pgcPageChannelApi, createPerLoadKomponent, upId);
        }
    }

    @JvmStatic
    public static final SpaceCheesePageModel_Factory create(Provider<SpaceCheesePageApi> provider, Provider<CreatePerLoadKomponent> provider2, Provider<Long> provider3) {
        return Companion.create(provider, provider2, provider3);
    }

    @JvmStatic
    public static final SpaceCheesePageModel newInstance(SpaceCheesePageApi pgcPageChannelApi, CreatePerLoadKomponent createPerLoadKomponent, long upId) {
        return Companion.newInstance(pgcPageChannelApi, createPerLoadKomponent, upId);
    }
}