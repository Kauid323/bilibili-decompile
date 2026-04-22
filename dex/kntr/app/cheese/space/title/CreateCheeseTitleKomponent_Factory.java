package kntr.app.cheese.space.title;

import dagger.internal.Factory;
import javax.inject.Provider;
import kntr.app.cheese.space.filter.ClassifiedTypeIndex;
import kntr.app.cheese.space.filter.SortTypeIndex;
import kntr.app.cheese.space.operable.CreateReportableModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CreateCheeseTitleKomponent_Factory.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB?\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkntr/app/cheese/space/title/CreateCheeseTitleKomponent_Factory;", "Ldagger/internal/Factory;", "Lkntr/app/cheese/space/title/CreateCheeseTitleKomponent;", "classifiedTypeIndexProvider", "Ljavax/inject/Provider;", "Lkntr/app/cheese/space/filter/ClassifiedTypeIndex;", "sortTypeIndexProvider", "Lkntr/app/cheese/space/filter/SortTypeIndex;", "createReportableModelProvider", "Lkntr/app/cheese/space/operable/CreateReportableModel;", "upIdProvider", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V", "get", "Companion", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateCheeseTitleKomponent_Factory implements Factory<CreateCheeseTitleKomponent> {
    private final Provider<ClassifiedTypeIndex> classifiedTypeIndexProvider;
    private final Provider<CreateReportableModel> createReportableModelProvider;
    private final Provider<SortTypeIndex> sortTypeIndexProvider;
    private final Provider<Long> upIdProvider;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public CreateCheeseTitleKomponent_Factory(Provider<ClassifiedTypeIndex> provider, Provider<SortTypeIndex> provider2, Provider<CreateReportableModel> provider3, Provider<Long> provider4) {
        Intrinsics.checkNotNullParameter(provider, "classifiedTypeIndexProvider");
        Intrinsics.checkNotNullParameter(provider2, "sortTypeIndexProvider");
        Intrinsics.checkNotNullParameter(provider3, "createReportableModelProvider");
        Intrinsics.checkNotNullParameter(provider4, "upIdProvider");
        this.classifiedTypeIndexProvider = provider;
        this.sortTypeIndexProvider = provider2;
        this.createReportableModelProvider = provider3;
        this.upIdProvider = provider4;
    }

    public CreateCheeseTitleKomponent get() {
        Companion companion = Companion;
        ClassifiedTypeIndex classifiedTypeIndex = this.classifiedTypeIndexProvider.get();
        Intrinsics.checkNotNullExpressionValue(classifiedTypeIndex, "get(...)");
        SortTypeIndex sortTypeIndex = this.sortTypeIndexProvider.get();
        Intrinsics.checkNotNullExpressionValue(sortTypeIndex, "get(...)");
        CreateReportableModel createReportableModel = this.createReportableModelProvider.get();
        Intrinsics.checkNotNullExpressionValue(createReportableModel, "get(...)");
        Long l = this.upIdProvider.get();
        Intrinsics.checkNotNullExpressionValue(l, "get(...)");
        return companion.newInstance(classifiedTypeIndex, sortTypeIndex, createReportableModel, l.longValue());
    }

    /* compiled from: CreateCheeseTitleKomponent_Factory.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007H\u0007J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000eH\u0007¨\u0006\u0015"}, d2 = {"Lkntr/app/cheese/space/title/CreateCheeseTitleKomponent_Factory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "create", "Lkntr/app/cheese/space/title/CreateCheeseTitleKomponent_Factory;", "classifiedTypeIndexProvider", "Ljavax/inject/Provider;", "Lkntr/app/cheese/space/filter/ClassifiedTypeIndex;", "sortTypeIndexProvider", "Lkntr/app/cheese/space/filter/SortTypeIndex;", "createReportableModelProvider", "Lkntr/app/cheese/space/operable/CreateReportableModel;", "upIdProvider", RoomRecommendViewModel.EMPTY_CURSOR, "newInstance", "Lkntr/app/cheese/space/title/CreateCheeseTitleKomponent;", "classifiedTypeIndex", "sortTypeIndex", "createReportableModel", "upId", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CreateCheeseTitleKomponent_Factory create(Provider<ClassifiedTypeIndex> provider, Provider<SortTypeIndex> provider2, Provider<CreateReportableModel> provider3, Provider<Long> provider4) {
            Intrinsics.checkNotNullParameter(provider, "classifiedTypeIndexProvider");
            Intrinsics.checkNotNullParameter(provider2, "sortTypeIndexProvider");
            Intrinsics.checkNotNullParameter(provider3, "createReportableModelProvider");
            Intrinsics.checkNotNullParameter(provider4, "upIdProvider");
            return new CreateCheeseTitleKomponent_Factory(provider, provider2, provider3, provider4);
        }

        @JvmStatic
        public final CreateCheeseTitleKomponent newInstance(ClassifiedTypeIndex classifiedTypeIndex, SortTypeIndex sortTypeIndex, CreateReportableModel createReportableModel, long upId) {
            Intrinsics.checkNotNullParameter(classifiedTypeIndex, "classifiedTypeIndex");
            Intrinsics.checkNotNullParameter(sortTypeIndex, "sortTypeIndex");
            Intrinsics.checkNotNullParameter(createReportableModel, "createReportableModel");
            return new CreateCheeseTitleKomponent(classifiedTypeIndex, sortTypeIndex, createReportableModel, upId);
        }
    }

    @JvmStatic
    public static final CreateCheeseTitleKomponent_Factory create(Provider<ClassifiedTypeIndex> provider, Provider<SortTypeIndex> provider2, Provider<CreateReportableModel> provider3, Provider<Long> provider4) {
        return Companion.create(provider, provider2, provider3, provider4);
    }

    @JvmStatic
    public static final CreateCheeseTitleKomponent newInstance(ClassifiedTypeIndex classifiedTypeIndex, SortTypeIndex sortTypeIndex, CreateReportableModel createReportableModel, long upId) {
        return Companion.newInstance(classifiedTypeIndex, sortTypeIndex, createReportableModel, upId);
    }
}