package kntr.app.cheese.space;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.cheese.space.api.PageData;
import kntr.app.cheese.space.api.SpaceCheesePageApi;
import kntr.app.cheese.space.feed.CreateCheeseFeedKomponent;
import kntr.app.cheese.space.filter.ClassifiedTypeIndex;
import kntr.app.cheese.space.filter.SortTypeIndex;
import kntr.app.cheese.space.product.CreateCheeseProductKomponent;
import kntr.app.cheese.space.title.CreateCheeseTitleKomponent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.KomponentScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpaceCheesePerLoadUiService_Factory.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u008b\u0001\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0002H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkntr/app/cheese/space/SpaceCheesePerLoadUiService_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/cheese/space/SpaceCheesePerLoadUiService;", "komponentScopeProvider", "Ljavax/inject/Provider;", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "pageDataProvider", "Lkntr/app/cheese/space/api/PageData;", "filmListHubChannelApiProvider", "Lkntr/app/cheese/space/api/SpaceCheesePageApi;", "createCheeseFeedKomponentProvider", "Lkntr/app/cheese/space/feed/CreateCheeseFeedKomponent;", "createCheeseProductKomponentProvider", "Lkntr/app/cheese/space/product/CreateCheeseProductKomponent;", "createCheeseTitleKomponentProvider", "Lkntr/app/cheese/space/title/CreateCheeseTitleKomponent;", "classifiedTypeIndexProvider", "Lkntr/app/cheese/space/filter/ClassifiedTypeIndex;", "sortTypeIndexProvider", "Lkntr/app/cheese/space/filter/SortTypeIndex;", "upIdProvider", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SpaceCheesePerLoadUiService_Factory implements Factory<SpaceCheesePerLoadUiService> {
    private final Provider<ClassifiedTypeIndex> classifiedTypeIndexProvider;
    private final Provider<CreateCheeseFeedKomponent> createCheeseFeedKomponentProvider;
    private final Provider<CreateCheeseProductKomponent> createCheeseProductKomponentProvider;
    private final Provider<CreateCheeseTitleKomponent> createCheeseTitleKomponentProvider;
    private final Provider<SpaceCheesePageApi> filmListHubChannelApiProvider;
    private final Provider<KomponentScope<Unit>> komponentScopeProvider;
    private final Provider<PageData> pageDataProvider;
    private final Provider<SortTypeIndex> sortTypeIndexProvider;
    private final Provider<Long> upIdProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public SpaceCheesePerLoadUiService_Factory(Provider<KomponentScope<Unit>> provider, Provider<PageData> provider2, Provider<SpaceCheesePageApi> provider3, Provider<CreateCheeseFeedKomponent> provider4, Provider<CreateCheeseProductKomponent> provider5, Provider<CreateCheeseTitleKomponent> provider6, Provider<ClassifiedTypeIndex> provider7, Provider<SortTypeIndex> provider8, Provider<Long> provider9) {
        Intrinsics.checkNotNullParameter(provider, "komponentScopeProvider");
        Intrinsics.checkNotNullParameter(provider2, "pageDataProvider");
        Intrinsics.checkNotNullParameter(provider3, "filmListHubChannelApiProvider");
        Intrinsics.checkNotNullParameter(provider4, "createCheeseFeedKomponentProvider");
        Intrinsics.checkNotNullParameter(provider5, "createCheeseProductKomponentProvider");
        Intrinsics.checkNotNullParameter(provider6, "createCheeseTitleKomponentProvider");
        Intrinsics.checkNotNullParameter(provider7, "classifiedTypeIndexProvider");
        Intrinsics.checkNotNullParameter(provider8, "sortTypeIndexProvider");
        Intrinsics.checkNotNullParameter(provider9, "upIdProvider");
        this.komponentScopeProvider = provider;
        this.pageDataProvider = provider2;
        this.filmListHubChannelApiProvider = provider3;
        this.createCheeseFeedKomponentProvider = provider4;
        this.createCheeseProductKomponentProvider = provider5;
        this.createCheeseTitleKomponentProvider = provider6;
        this.classifiedTypeIndexProvider = provider7;
        this.sortTypeIndexProvider = provider8;
        this.upIdProvider = provider9;
    }

    public SpaceCheesePerLoadUiService get() {
        Companion companion = Companion;
        KomponentScope<Unit> komponentScope = this.komponentScopeProvider.get();
        Intrinsics.checkNotNullExpressionValue(komponentScope, "get(...)");
        PageData pageData = this.pageDataProvider.get();
        Intrinsics.checkNotNullExpressionValue(pageData, "get(...)");
        SpaceCheesePageApi spaceCheesePageApi = this.filmListHubChannelApiProvider.get();
        Intrinsics.checkNotNullExpressionValue(spaceCheesePageApi, "get(...)");
        CreateCheeseFeedKomponent createCheeseFeedKomponent = this.createCheeseFeedKomponentProvider.get();
        Intrinsics.checkNotNullExpressionValue(createCheeseFeedKomponent, "get(...)");
        CreateCheeseProductKomponent createCheeseProductKomponent = this.createCheeseProductKomponentProvider.get();
        Intrinsics.checkNotNullExpressionValue(createCheeseProductKomponent, "get(...)");
        CreateCheeseTitleKomponent createCheeseTitleKomponent = this.createCheeseTitleKomponentProvider.get();
        Intrinsics.checkNotNullExpressionValue(createCheeseTitleKomponent, "get(...)");
        ClassifiedTypeIndex classifiedTypeIndex = this.classifiedTypeIndexProvider.get();
        Intrinsics.checkNotNullExpressionValue(classifiedTypeIndex, "get(...)");
        SortTypeIndex sortTypeIndex = this.sortTypeIndexProvider.get();
        Intrinsics.checkNotNullExpressionValue(sortTypeIndex, "get(...)");
        Long l = this.upIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(l, "get(...)");
        return companion.newInstance(komponentScope, pageData, spaceCheesePageApi, createCheeseFeedKomponent, createCheeseProductKomponent, createCheeseTitleKomponent, classifiedTypeIndex, sortTypeIndex, l.longValue());
    }

    /* compiled from: SpaceCheesePerLoadUiService_Factory.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u008c\u0001\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0007H\u0007JV\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u0019H\u0007¨\u0006%"}, d2 = {"Lkntr/app/cheese/space/SpaceCheesePerLoadUiService_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/cheese/space/SpaceCheesePerLoadUiService_Factory;", "komponentScopeProvider", "Ljavax/inject/Provider;", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "pageDataProvider", "Lkntr/app/cheese/space/api/PageData;", "filmListHubChannelApiProvider", "Lkntr/app/cheese/space/api/SpaceCheesePageApi;", "createCheeseFeedKomponentProvider", "Lkntr/app/cheese/space/feed/CreateCheeseFeedKomponent;", "createCheeseProductKomponentProvider", "Lkntr/app/cheese/space/product/CreateCheeseProductKomponent;", "createCheeseTitleKomponentProvider", "Lkntr/app/cheese/space/title/CreateCheeseTitleKomponent;", "classifiedTypeIndexProvider", "Lkntr/app/cheese/space/filter/ClassifiedTypeIndex;", "sortTypeIndexProvider", "Lkntr/app/cheese/space/filter/SortTypeIndex;", "upIdProvider", RoomRecommendViewModel.EMPTY_CURSOR, "newInstance", "Lkntr/app/cheese/space/SpaceCheesePerLoadUiService;", "komponentScope", "pageData", "filmListHubChannelApi", "createCheeseFeedKomponent", "createCheeseProductKomponent", "createCheeseTitleKomponent", "classifiedTypeIndex", "sortTypeIndex", "upId", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SpaceCheesePerLoadUiService_Factory create(Provider<KomponentScope<Unit>> provider, Provider<PageData> provider2, Provider<SpaceCheesePageApi> provider3, Provider<CreateCheeseFeedKomponent> provider4, Provider<CreateCheeseProductKomponent> provider5, Provider<CreateCheeseTitleKomponent> provider6, Provider<ClassifiedTypeIndex> provider7, Provider<SortTypeIndex> provider8, Provider<Long> provider9) {
            Intrinsics.checkNotNullParameter(provider, "komponentScopeProvider");
            Intrinsics.checkNotNullParameter(provider2, "pageDataProvider");
            Intrinsics.checkNotNullParameter(provider3, "filmListHubChannelApiProvider");
            Intrinsics.checkNotNullParameter(provider4, "createCheeseFeedKomponentProvider");
            Intrinsics.checkNotNullParameter(provider5, "createCheeseProductKomponentProvider");
            Intrinsics.checkNotNullParameter(provider6, "createCheeseTitleKomponentProvider");
            Intrinsics.checkNotNullParameter(provider7, "classifiedTypeIndexProvider");
            Intrinsics.checkNotNullParameter(provider8, "sortTypeIndexProvider");
            Intrinsics.checkNotNullParameter(provider9, "upIdProvider");
            return new SpaceCheesePerLoadUiService_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
        }

        @JvmStatic
        public final SpaceCheesePerLoadUiService newInstance(KomponentScope<? super Unit> komponentScope, PageData pageData, SpaceCheesePageApi filmListHubChannelApi, CreateCheeseFeedKomponent createCheeseFeedKomponent, CreateCheeseProductKomponent createCheeseProductKomponent, CreateCheeseTitleKomponent createCheeseTitleKomponent, ClassifiedTypeIndex classifiedTypeIndex, SortTypeIndex sortTypeIndex, long upId) {
            Intrinsics.checkNotNullParameter(komponentScope, "komponentScope");
            Intrinsics.checkNotNullParameter(pageData, "pageData");
            Intrinsics.checkNotNullParameter(filmListHubChannelApi, "filmListHubChannelApi");
            Intrinsics.checkNotNullParameter(createCheeseFeedKomponent, "createCheeseFeedKomponent");
            Intrinsics.checkNotNullParameter(createCheeseProductKomponent, "createCheeseProductKomponent");
            Intrinsics.checkNotNullParameter(createCheeseTitleKomponent, "createCheeseTitleKomponent");
            Intrinsics.checkNotNullParameter(classifiedTypeIndex, "classifiedTypeIndex");
            Intrinsics.checkNotNullParameter(sortTypeIndex, "sortTypeIndex");
            return new SpaceCheesePerLoadUiService(komponentScope, pageData, filmListHubChannelApi, createCheeseFeedKomponent, createCheeseProductKomponent, createCheeseTitleKomponent, classifiedTypeIndex, sortTypeIndex, upId);
        }
    }

    @JvmStatic
    public static final SpaceCheesePerLoadUiService_Factory create(Provider<KomponentScope<Unit>> provider, Provider<PageData> provider2, Provider<SpaceCheesePageApi> provider3, Provider<CreateCheeseFeedKomponent> provider4, Provider<CreateCheeseProductKomponent> provider5, Provider<CreateCheeseTitleKomponent> provider6, Provider<ClassifiedTypeIndex> provider7, Provider<SortTypeIndex> provider8, Provider<Long> provider9) {
        return Companion.create(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    @JvmStatic
    public static final SpaceCheesePerLoadUiService newInstance(KomponentScope<? super Unit> komponentScope, PageData pageData, SpaceCheesePageApi filmListHubChannelApi, CreateCheeseFeedKomponent createCheeseFeedKomponent, CreateCheeseProductKomponent createCheeseProductKomponent, CreateCheeseTitleKomponent createCheeseTitleKomponent, ClassifiedTypeIndex classifiedTypeIndex, SortTypeIndex sortTypeIndex, long upId) {
        return Companion.newInstance(komponentScope, pageData, filmListHubChannelApi, createCheeseFeedKomponent, createCheeseProductKomponent, createCheeseTitleKomponent, classifiedTypeIndex, sortTypeIndex, upId);
    }
}