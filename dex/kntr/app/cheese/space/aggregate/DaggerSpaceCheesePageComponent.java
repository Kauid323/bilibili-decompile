package kntr.app.cheese.space.aggregate;

import com.bilibili.ogv.operation3.module.HttpClientModule_ProvideFactory;
import com.bilibili.ogv.operation3.module.JsonModule_Companion_ProvideFactory;
import com.bilibili.ogv.operation3.module.aggregate.ModuleTypes_ProvideModuleTypesFactory;
import com.bilibili.ogv.operation3.module.concept.ModuleSerializersModule_ProvideFactory;
import com.google.common.base.Optional;
import dagger.internal.DoubleCheck;
import io.ktor.client.HttpClient;
import java.util.Set;
import javax.inject.Provider;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.cheese.space.CreatePerLoadKomponent;
import kntr.app.cheese.space.SpaceCheesePageModel;
import kntr.app.cheese.space.SpaceCheesePerLoadUiService;
import kntr.app.cheese.space.aggregate.SpaceCheesePageComponent;
import kntr.app.cheese.space.aggregate.SpaceCheesePagePerLoadComponent;
import kntr.app.cheese.space.api.PageData;
import kntr.app.cheese.space.api.SpaceCheesePageApi;
import kntr.app.cheese.space.feed.CreateCheeseFeedKomponent;
import kntr.app.cheese.space.filter.ClassifiedTypeIndex;
import kntr.app.cheese.space.filter.SortTypeIndex;
import kntr.app.cheese.space.operable.CreateOperableModel;
import kntr.app.cheese.space.operable.CreateReportableModel;
import kntr.app.cheese.space.product.CreateCheeseProductKomponent;
import kntr.app.cheese.space.title.CreateCheeseTitleKomponent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.KomponentScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: DaggerSpaceCheesePageComponent.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\t"}, d2 = {"Lkntr/app/cheese/space/aggregate/DaggerSpaceCheesePageComponent;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "Factory", "SpaceCheesePagePerLoadComponentFactory", "SpaceCheesePagePerLoadComponentImpl", "SpaceCheesePageComponentImpl", "Companion", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DaggerSpaceCheesePageComponent {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);

    private DaggerSpaceCheesePageComponent() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DaggerSpaceCheesePageComponent.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lkntr/app/cheese/space/aggregate/DaggerSpaceCheesePageComponent$Factory;", "Lkntr/app/cheese/space/aggregate/SpaceCheesePageComponent$Factory;", "<init>", "()V", "create", "Lkntr/app/cheese/space/aggregate/SpaceCheesePageComponent;", "upId", RoomRecommendViewModel.EMPTY_CURSOR, "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Factory implements SpaceCheesePageComponent.Factory {
        @Override // kntr.app.cheese.space.aggregate.SpaceCheesePageComponent.Factory
        public SpaceCheesePageComponent create(long upId) {
            return new SpaceCheesePageComponentImpl(upId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DaggerSpaceCheesePageComponent.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkntr/app/cheese/space/aggregate/DaggerSpaceCheesePageComponent$SpaceCheesePagePerLoadComponentFactory;", "Lkntr/app/cheese/space/aggregate/SpaceCheesePagePerLoadComponent$Factory;", "spaceCheesePageComponentImpl", "Lkntr/app/cheese/space/aggregate/DaggerSpaceCheesePageComponent$SpaceCheesePageComponentImpl;", "<init>", "(Lkntr/app/cheese/space/aggregate/DaggerSpaceCheesePageComponent$SpaceCheesePageComponentImpl;)V", "create", "Lkntr/app/cheese/space/aggregate/SpaceCheesePagePerLoadComponent;", "pageData", "Lkntr/app/cheese/space/api/PageData;", "komponentScope", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SpaceCheesePagePerLoadComponentFactory implements SpaceCheesePagePerLoadComponent.Factory {
        private final SpaceCheesePageComponentImpl spaceCheesePageComponentImpl;

        public SpaceCheesePagePerLoadComponentFactory(SpaceCheesePageComponentImpl spaceCheesePageComponentImpl) {
            Intrinsics.checkNotNullParameter(spaceCheesePageComponentImpl, "spaceCheesePageComponentImpl");
            this.spaceCheesePageComponentImpl = spaceCheesePageComponentImpl;
        }

        @Override // kntr.app.cheese.space.aggregate.SpaceCheesePagePerLoadComponent.Factory
        public SpaceCheesePagePerLoadComponent create(PageData pageData, KomponentScope<? super Unit> komponentScope) {
            Intrinsics.checkNotNullParameter(pageData, "pageData");
            Intrinsics.checkNotNullParameter(komponentScope, "komponentScope");
            return new SpaceCheesePagePerLoadComponentImpl(this.spaceCheesePageComponentImpl, pageData, komponentScope);
        }
    }

    /* compiled from: DaggerSpaceCheesePageComponent.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001-B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020(J\u0006\u0010)\u001a\u00020*J\u001e\u0010+\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\b\u0010,\u001a\u00020\u001eH\u0016R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018¨\u0006."}, d2 = {"Lkntr/app/cheese/space/aggregate/DaggerSpaceCheesePageComponent$SpaceCheesePagePerLoadComponentImpl;", "Lkntr/app/cheese/space/aggregate/SpaceCheesePagePerLoadComponent;", "spaceCheesePageComponentImpl", "Lkntr/app/cheese/space/aggregate/DaggerSpaceCheesePageComponent$SpaceCheesePageComponentImpl;", "pageDataParam", "Lkntr/app/cheese/space/api/PageData;", "komponentScopeParam", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/cheese/space/aggregate/DaggerSpaceCheesePageComponent$SpaceCheesePageComponentImpl;Lkntr/app/cheese/space/api/PageData;Lkntr/common/komponent/KomponentScope;)V", "komponentScope", "getKomponentScope", "()Lkntr/common/komponent/KomponentScope;", "pageData", "getPageData", "()Lkntr/app/cheese/space/api/PageData;", "spaceCheesePagePerLoadComponentImpl", "classifiedTypeIndexProvider", "Ljavax/inject/Provider;", "Lkntr/app/cheese/space/filter/ClassifiedTypeIndex;", "getClassifiedTypeIndexProvider", "()Ljavax/inject/Provider;", "setClassifiedTypeIndexProvider", "(Ljavax/inject/Provider;)V", "sortTypeIndexProvider", "Lkntr/app/cheese/space/filter/SortTypeIndex;", "getSortTypeIndexProvider", "setSortTypeIndexProvider", "spaceCheesePerLoadUiServiceProvider", "Lkntr/app/cheese/space/SpaceCheesePerLoadUiService;", "getSpaceCheesePerLoadUiServiceProvider", "setSpaceCheesePerLoadUiServiceProvider", "createOperableModel", "Lkntr/app/cheese/space/operable/CreateOperableModel;", "createCheeseFeedKomponent", "Lkntr/app/cheese/space/feed/CreateCheeseFeedKomponent;", "createCheeseProductKomponent", "Lkntr/app/cheese/space/product/CreateCheeseProductKomponent;", "createReportableModel", "Lkntr/app/cheese/space/operable/CreateReportableModel;", "createCheeseTitleKomponent", "Lkntr/app/cheese/space/title/CreateCheeseTitleKomponent;", "initialize", "uiService", "SwitchingProvider", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    private static final class SpaceCheesePagePerLoadComponentImpl implements SpaceCheesePagePerLoadComponent {
        public Provider<ClassifiedTypeIndex> classifiedTypeIndexProvider;
        private final KomponentScope<Unit> komponentScope;
        private final PageData pageData;
        public Provider<SortTypeIndex> sortTypeIndexProvider;
        private final SpaceCheesePageComponentImpl spaceCheesePageComponentImpl;
        private final SpaceCheesePagePerLoadComponentImpl spaceCheesePagePerLoadComponentImpl;
        public Provider<SpaceCheesePerLoadUiService> spaceCheesePerLoadUiServiceProvider;

        public SpaceCheesePagePerLoadComponentImpl(SpaceCheesePageComponentImpl spaceCheesePageComponentImpl, PageData pageDataParam, KomponentScope<? super Unit> komponentScope) {
            Intrinsics.checkNotNullParameter(spaceCheesePageComponentImpl, "spaceCheesePageComponentImpl");
            Intrinsics.checkNotNullParameter(pageDataParam, "pageDataParam");
            Intrinsics.checkNotNullParameter(komponentScope, "komponentScopeParam");
            this.spaceCheesePagePerLoadComponentImpl = this;
            this.spaceCheesePageComponentImpl = spaceCheesePageComponentImpl;
            this.komponentScope = komponentScope;
            this.pageData = pageDataParam;
            initialize(pageDataParam, komponentScope);
        }

        public final KomponentScope<Unit> getKomponentScope() {
            return this.komponentScope;
        }

        public final PageData getPageData() {
            return this.pageData;
        }

        public final Provider<ClassifiedTypeIndex> getClassifiedTypeIndexProvider() {
            Provider<ClassifiedTypeIndex> provider = this.classifiedTypeIndexProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("classifiedTypeIndexProvider");
            return null;
        }

        public final void setClassifiedTypeIndexProvider(Provider<ClassifiedTypeIndex> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.classifiedTypeIndexProvider = provider;
        }

        public final Provider<SortTypeIndex> getSortTypeIndexProvider() {
            Provider<SortTypeIndex> provider = this.sortTypeIndexProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("sortTypeIndexProvider");
            return null;
        }

        public final void setSortTypeIndexProvider(Provider<SortTypeIndex> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.sortTypeIndexProvider = provider;
        }

        public final Provider<SpaceCheesePerLoadUiService> getSpaceCheesePerLoadUiServiceProvider() {
            Provider<SpaceCheesePerLoadUiService> provider = this.spaceCheesePerLoadUiServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("spaceCheesePerLoadUiServiceProvider");
            return null;
        }

        public final void setSpaceCheesePerLoadUiServiceProvider(Provider<SpaceCheesePerLoadUiService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.spaceCheesePerLoadUiServiceProvider = provider;
        }

        public final CreateOperableModel createOperableModel() {
            return new CreateOperableModel(SpaceCheesePageComponent_Impl_ProvideNeuronReportFactory.Companion.provideNeuronReport());
        }

        public final CreateCheeseFeedKomponent createCheeseFeedKomponent() {
            return new CreateCheeseFeedKomponent(createOperableModel(), this.spaceCheesePageComponentImpl.getUpId());
        }

        public final CreateCheeseProductKomponent createCheeseProductKomponent() {
            return new CreateCheeseProductKomponent(createOperableModel(), this.spaceCheesePageComponentImpl.getUpId());
        }

        public final CreateReportableModel createReportableModel() {
            return new CreateReportableModel(SpaceCheesePageComponent_Impl_ProvideNeuronReportFactory.Companion.provideNeuronReport());
        }

        public final CreateCheeseTitleKomponent createCheeseTitleKomponent() {
            ClassifiedTypeIndex classifiedTypeIndex = getClassifiedTypeIndexProvider().get();
            Intrinsics.checkNotNullExpressionValue(classifiedTypeIndex, "get(...)");
            ClassifiedTypeIndex classifiedTypeIndex2 = classifiedTypeIndex;
            SortTypeIndex sortTypeIndex = getSortTypeIndexProvider().get();
            Intrinsics.checkNotNullExpressionValue(sortTypeIndex, "get(...)");
            return new CreateCheeseTitleKomponent(classifiedTypeIndex2, sortTypeIndex, createReportableModel(), this.spaceCheesePageComponentImpl.getUpId());
        }

        private final void initialize(PageData pageDataParam, KomponentScope<? super Unit> komponentScope) {
            Provider<ClassifiedTypeIndex> provider = DoubleCheck.provider(new SwitchingProvider(this.spaceCheesePageComponentImpl, this.spaceCheesePagePerLoadComponentImpl, 1));
            Intrinsics.checkNotNullExpressionValue(provider, "provider(...)");
            setClassifiedTypeIndexProvider(provider);
            Provider<SortTypeIndex> provider2 = DoubleCheck.provider(new SwitchingProvider(this.spaceCheesePageComponentImpl, this.spaceCheesePagePerLoadComponentImpl, 2));
            Intrinsics.checkNotNullExpressionValue(provider2, "provider(...)");
            setSortTypeIndexProvider(provider2);
            Provider<SpaceCheesePerLoadUiService> provider3 = DoubleCheck.provider(new SwitchingProvider(this.spaceCheesePageComponentImpl, this.spaceCheesePagePerLoadComponentImpl, 0));
            Intrinsics.checkNotNullExpressionValue(provider3, "provider(...)");
            setSpaceCheesePerLoadUiServiceProvider(provider3);
        }

        @Override // kntr.app.cheese.space.aggregate.SpaceCheesePagePerLoadComponent
        public SpaceCheesePerLoadUiService uiService() {
            SpaceCheesePerLoadUiService spaceCheesePerLoadUiService = getSpaceCheesePerLoadUiServiceProvider().get();
            Intrinsics.checkNotNullExpressionValue(spaceCheesePerLoadUiService, "get(...)");
            return spaceCheesePerLoadUiService;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: DaggerSpaceCheesePageComponent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkntr/app/cheese/space/aggregate/DaggerSpaceCheesePageComponent$SpaceCheesePagePerLoadComponentImpl$SwitchingProvider;", "T", "Ljavax/inject/Provider;", "spaceCheesePageComponentImpl", "Lkntr/app/cheese/space/aggregate/DaggerSpaceCheesePageComponent$SpaceCheesePageComponentImpl;", "spaceCheesePagePerLoadComponentImpl", "Lkntr/app/cheese/space/aggregate/DaggerSpaceCheesePageComponent$SpaceCheesePagePerLoadComponentImpl;", ReportBuildInParam.ID, RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/cheese/space/aggregate/DaggerSpaceCheesePageComponent$SpaceCheesePageComponentImpl;Lkntr/app/cheese/space/aggregate/DaggerSpaceCheesePageComponent$SpaceCheesePagePerLoadComponentImpl;I)V", "get", "()Ljava/lang/Object;", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class SwitchingProvider<T> implements Provider<T> {
            private final int id;
            private final SpaceCheesePageComponentImpl spaceCheesePageComponentImpl;
            private final SpaceCheesePagePerLoadComponentImpl spaceCheesePagePerLoadComponentImpl;

            public SwitchingProvider(SpaceCheesePageComponentImpl spaceCheesePageComponentImpl, SpaceCheesePagePerLoadComponentImpl spaceCheesePagePerLoadComponentImpl, int id) {
                Intrinsics.checkNotNullParameter(spaceCheesePageComponentImpl, "spaceCheesePageComponentImpl");
                Intrinsics.checkNotNullParameter(spaceCheesePagePerLoadComponentImpl, "spaceCheesePagePerLoadComponentImpl");
                this.spaceCheesePageComponentImpl = spaceCheesePageComponentImpl;
                this.spaceCheesePagePerLoadComponentImpl = spaceCheesePagePerLoadComponentImpl;
                this.id = id;
            }

            @Override // javax.inject.Provider
            public T get() {
                switch (this.id) {
                    case 0:
                        KomponentScope<Unit> komponentScope = this.spaceCheesePagePerLoadComponentImpl.getKomponentScope();
                        PageData pageData = this.spaceCheesePagePerLoadComponentImpl.getPageData();
                        SpaceCheesePageApi spaceCheesePageApi = this.spaceCheesePageComponentImpl.spaceCheesePageApi();
                        CreateCheeseFeedKomponent createCheeseFeedKomponent = this.spaceCheesePagePerLoadComponentImpl.createCheeseFeedKomponent();
                        CreateCheeseProductKomponent createCheeseProductKomponent = this.spaceCheesePagePerLoadComponentImpl.createCheeseProductKomponent();
                        CreateCheeseTitleKomponent createCheeseTitleKomponent = this.spaceCheesePagePerLoadComponentImpl.createCheeseTitleKomponent();
                        ClassifiedTypeIndex classifiedTypeIndex = this.spaceCheesePagePerLoadComponentImpl.getClassifiedTypeIndexProvider().get();
                        Intrinsics.checkNotNullExpressionValue(classifiedTypeIndex, "get(...)");
                        ClassifiedTypeIndex classifiedTypeIndex2 = classifiedTypeIndex;
                        SortTypeIndex sortTypeIndex = this.spaceCheesePagePerLoadComponentImpl.getSortTypeIndexProvider().get();
                        Intrinsics.checkNotNullExpressionValue(sortTypeIndex, "get(...)");
                        return (T) new SpaceCheesePerLoadUiService(komponentScope, pageData, spaceCheesePageApi, createCheeseFeedKomponent, createCheeseProductKomponent, createCheeseTitleKomponent, classifiedTypeIndex2, sortTypeIndex, this.spaceCheesePageComponentImpl.getUpId());
                    case 1:
                        return (T) new ClassifiedTypeIndex();
                    case 2:
                        return (T) new SortTypeIndex();
                    default:
                        throw new AssertionError(this.id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DaggerSpaceCheesePageComponent.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010!\u001a\u00020\u0016H\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010¨\u0006#"}, d2 = {"Lkntr/app/cheese/space/aggregate/DaggerSpaceCheesePageComponent$SpaceCheesePageComponentImpl;", "Lkntr/app/cheese/space/aggregate/SpaceCheesePageComponent;", "upIdParam", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(J)V", "upId", "getUpId", "()J", "spaceCheesePageComponentImpl", "provideProvider", "Ljavax/inject/Provider;", "Lkotlinx/serialization/json/Json;", "getProvideProvider", "()Ljavax/inject/Provider;", "setProvideProvider", "(Ljavax/inject/Provider;)V", "provideProvider2", "Lio/ktor/client/HttpClient;", "getProvideProvider2", "setProvideProvider2", "spaceCheesePageModelProvider", "Lkntr/app/cheese/space/SpaceCheesePageModel;", "getSpaceCheesePageModelProvider", "setSpaceCheesePageModelProvider", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "spaceCheesePageApi", "Lkntr/app/cheese/space/api/SpaceCheesePageApi;", "createPerLoadKomponent", "Lkntr/app/cheese/space/CreatePerLoadKomponent;", "initialize", RoomRecommendViewModel.EMPTY_CURSOR, "pageModel", "SwitchingProvider", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SpaceCheesePageComponentImpl implements SpaceCheesePageComponent {
        public Provider<Json> provideProvider;
        public Provider<HttpClient> provideProvider2;
        private final SpaceCheesePageComponentImpl spaceCheesePageComponentImpl = this;
        public Provider<SpaceCheesePageModel> spaceCheesePageModelProvider;
        private final long upId;

        public SpaceCheesePageComponentImpl(long upIdParam) {
            this.upId = upIdParam;
            initialize(upIdParam);
        }

        public final long getUpId() {
            return this.upId;
        }

        public final Provider<Json> getProvideProvider() {
            Provider<Json> provider = this.provideProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("provideProvider");
            return null;
        }

        public final void setProvideProvider(Provider<Json> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.provideProvider = provider;
        }

        public final Provider<HttpClient> getProvideProvider2() {
            Provider<HttpClient> provider = this.provideProvider2;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("provideProvider2");
            return null;
        }

        public final void setProvideProvider2(Provider<HttpClient> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.provideProvider2 = provider;
        }

        public final Provider<SpaceCheesePageModel> getSpaceCheesePageModelProvider() {
            Provider<SpaceCheesePageModel> provider = this.spaceCheesePageModelProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("spaceCheesePageModelProvider");
            return null;
        }

        public final void setSpaceCheesePageModelProvider(Provider<SpaceCheesePageModel> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.spaceCheesePageModelProvider = provider;
        }

        public final SerializersModule serializersModule() {
            return ModuleSerializersModule_ProvideFactory.Companion.provide(ModuleTypes_ProvideModuleTypesFactory.Companion.provideModuleTypes());
        }

        public final SpaceCheesePageApi spaceCheesePageApi() {
            HttpClient httpClient = getProvideProvider2().get();
            Intrinsics.checkNotNullExpressionValue(httpClient, "get(...)");
            return new SpaceCheesePageApi(httpClient, SpaceCheesePageComponent_Impl_ProvideBaseUrlFactory.Companion.provideBaseUrl());
        }

        public final CreatePerLoadKomponent createPerLoadKomponent() {
            return SpaceCheesePageComponent_Impl_ProvideCreatePerLoadKomponentFactory.Companion.provideCreatePerLoadKomponent(new SpaceCheesePagePerLoadComponentFactory(this.spaceCheesePageComponentImpl));
        }

        private final void initialize(long upIdParam) {
            Provider<Json> provider = DoubleCheck.provider(new SwitchingProvider(this.spaceCheesePageComponentImpl, 2));
            Intrinsics.checkNotNullExpressionValue(provider, "provider(...)");
            setProvideProvider(provider);
            Provider<HttpClient> provider2 = DoubleCheck.provider(new SwitchingProvider(this.spaceCheesePageComponentImpl, 1));
            Intrinsics.checkNotNullExpressionValue(provider2, "provider(...)");
            setProvideProvider2(provider2);
            Provider<SpaceCheesePageModel> provider3 = DoubleCheck.provider(new SwitchingProvider(this.spaceCheesePageComponentImpl, 0));
            Intrinsics.checkNotNullExpressionValue(provider3, "provider(...)");
            setSpaceCheesePageModelProvider(provider3);
        }

        @Override // kntr.app.cheese.space.aggregate.SpaceCheesePageComponent
        public SpaceCheesePageModel pageModel() {
            SpaceCheesePageModel spaceCheesePageModel = getSpaceCheesePageModelProvider().get();
            Intrinsics.checkNotNullExpressionValue(spaceCheesePageModel, "get(...)");
            return spaceCheesePageModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: DaggerSpaceCheesePageComponent.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkntr/app/cheese/space/aggregate/DaggerSpaceCheesePageComponent$SpaceCheesePageComponentImpl$SwitchingProvider;", "T", "Ljavax/inject/Provider;", "spaceCheesePageComponentImpl", "Lkntr/app/cheese/space/aggregate/DaggerSpaceCheesePageComponent$SpaceCheesePageComponentImpl;", ReportBuildInParam.ID, RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/cheese/space/aggregate/DaggerSpaceCheesePageComponent$SpaceCheesePageComponentImpl;I)V", "get", "()Ljava/lang/Object;", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class SwitchingProvider<T> implements Provider<T> {
            private final int id;
            private final SpaceCheesePageComponentImpl spaceCheesePageComponentImpl;

            public SwitchingProvider(SpaceCheesePageComponentImpl spaceCheesePageComponentImpl, int id) {
                Intrinsics.checkNotNullParameter(spaceCheesePageComponentImpl, "spaceCheesePageComponentImpl");
                this.spaceCheesePageComponentImpl = spaceCheesePageComponentImpl;
                this.id = id;
            }

            @Override // javax.inject.Provider
            public T get() {
                switch (this.id) {
                    case 0:
                        return (T) new SpaceCheesePageModel(this.spaceCheesePageComponentImpl.spaceCheesePageApi(), this.spaceCheesePageComponentImpl.createPerLoadKomponent(), this.spaceCheesePageComponentImpl.getUpId());
                    case 1:
                        HttpClientModule_ProvideFactory.Companion companion = HttpClientModule_ProvideFactory.Companion;
                        Json json = this.spaceCheesePageComponentImpl.getProvideProvider().get();
                        Intrinsics.checkNotNullExpressionValue(json, "get(...)");
                        return (T) companion.provide(json);
                    case 2:
                        JsonModule_Companion_ProvideFactory.Companion companion2 = JsonModule_Companion_ProvideFactory.Companion;
                        Set emptySet = SetsKt.emptySet();
                        Optional of = Optional.of(this.spaceCheesePageComponentImpl.serializersModule());
                        Intrinsics.checkNotNullExpressionValue(of, "of(...)");
                        return (T) companion2.provide(emptySet, of);
                    default:
                        throw new AssertionError(this.id);
                }
            }
        }
    }

    /* compiled from: DaggerSpaceCheesePageComponent.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lkntr/app/cheese/space/aggregate/DaggerSpaceCheesePageComponent$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "factory", "Lkntr/app/cheese/space/aggregate/SpaceCheesePageComponent$Factory;", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SpaceCheesePageComponent.Factory factory() {
            return new Factory();
        }
    }
}