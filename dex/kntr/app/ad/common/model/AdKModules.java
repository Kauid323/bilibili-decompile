package kntr.app.ad.common.model;

import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: AdKModules.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001$Bw\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003Jy\u0010\u001c\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e¨\u0006%"}, d2 = {"Lkntr/app/ad/common/model/AdKModules;", RoomRecommendViewModel.EMPTY_CURSOR, "kModel", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/common/model/AdSlot;", "kExtraFetcher", "kReporter", "kClicker", "kTrack", "kVM", "kInspector", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getKModel", "()Ljava/util/List;", "getKExtraFetcher", "getKReporter", "getKClicker", "getKTrack", "getKVM", "getKInspector", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable(with = AdKModulesSerializer.class)
public final class AdKModules {
    public static final Companion Companion = new Companion(null);
    private final List<AdSlot> kClicker;
    private final List<AdSlot> kExtraFetcher;
    private final List<AdSlot> kInspector;
    private final List<AdSlot> kModel;
    private final List<AdSlot> kReporter;
    private final List<AdSlot> kTrack;
    private final List<AdSlot> kVM;

    public AdKModules() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ AdKModules copy$default(AdKModules adKModules, List list, List list2, List list3, List list4, List list5, List list6, List list7, int i, Object obj) {
        List<AdSlot> list8 = list;
        if ((i & 1) != 0) {
            list8 = adKModules.kModel;
        }
        List<AdSlot> list9 = list2;
        if ((i & 2) != 0) {
            list9 = adKModules.kExtraFetcher;
        }
        List list10 = list9;
        List<AdSlot> list11 = list3;
        if ((i & 4) != 0) {
            list11 = adKModules.kReporter;
        }
        List list12 = list11;
        List<AdSlot> list13 = list4;
        if ((i & 8) != 0) {
            list13 = adKModules.kClicker;
        }
        List list14 = list13;
        List<AdSlot> list15 = list5;
        if ((i & 16) != 0) {
            list15 = adKModules.kTrack;
        }
        List list16 = list15;
        List<AdSlot> list17 = list6;
        if ((i & 32) != 0) {
            list17 = adKModules.kVM;
        }
        List list18 = list17;
        List<AdSlot> list19 = list7;
        if ((i & 64) != 0) {
            list19 = adKModules.kInspector;
        }
        return adKModules.copy(list8, list10, list12, list14, list16, list18, list19);
    }

    public final List<AdSlot> component1() {
        return this.kModel;
    }

    public final List<AdSlot> component2() {
        return this.kExtraFetcher;
    }

    public final List<AdSlot> component3() {
        return this.kReporter;
    }

    public final List<AdSlot> component4() {
        return this.kClicker;
    }

    public final List<AdSlot> component5() {
        return this.kTrack;
    }

    public final List<AdSlot> component6() {
        return this.kVM;
    }

    public final List<AdSlot> component7() {
        return this.kInspector;
    }

    public final AdKModules copy(List<? extends AdSlot> list, List<? extends AdSlot> list2, List<? extends AdSlot> list3, List<? extends AdSlot> list4, List<? extends AdSlot> list5, List<? extends AdSlot> list6, List<? extends AdSlot> list7) {
        Intrinsics.checkNotNullParameter(list, "kModel");
        Intrinsics.checkNotNullParameter(list2, "kExtraFetcher");
        Intrinsics.checkNotNullParameter(list3, "kReporter");
        Intrinsics.checkNotNullParameter(list4, "kClicker");
        Intrinsics.checkNotNullParameter(list5, "kTrack");
        Intrinsics.checkNotNullParameter(list6, "kVM");
        Intrinsics.checkNotNullParameter(list7, "kInspector");
        return new AdKModules(list, list2, list3, list4, list5, list6, list7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdKModules) {
            AdKModules adKModules = (AdKModules) obj;
            return Intrinsics.areEqual(this.kModel, adKModules.kModel) && Intrinsics.areEqual(this.kExtraFetcher, adKModules.kExtraFetcher) && Intrinsics.areEqual(this.kReporter, adKModules.kReporter) && Intrinsics.areEqual(this.kClicker, adKModules.kClicker) && Intrinsics.areEqual(this.kTrack, adKModules.kTrack) && Intrinsics.areEqual(this.kVM, adKModules.kVM) && Intrinsics.areEqual(this.kInspector, adKModules.kInspector);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.kModel.hashCode() * 31) + this.kExtraFetcher.hashCode()) * 31) + this.kReporter.hashCode()) * 31) + this.kClicker.hashCode()) * 31) + this.kTrack.hashCode()) * 31) + this.kVM.hashCode()) * 31) + this.kInspector.hashCode();
    }

    public String toString() {
        List<AdSlot> list = this.kModel;
        List<AdSlot> list2 = this.kExtraFetcher;
        List<AdSlot> list3 = this.kReporter;
        List<AdSlot> list4 = this.kClicker;
        List<AdSlot> list5 = this.kTrack;
        List<AdSlot> list6 = this.kVM;
        return "AdKModules(kModel=" + list + ", kExtraFetcher=" + list2 + ", kReporter=" + list3 + ", kClicker=" + list4 + ", kTrack=" + list5 + ", kVM=" + list6 + ", kInspector=" + this.kInspector + ")";
    }

    /* compiled from: AdKModules.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdKModules$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdKModules;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdKModules> serializer() {
            return AdKModulesSerializer.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AdKModules(List<? extends AdSlot> list, List<? extends AdSlot> list2, List<? extends AdSlot> list3, List<? extends AdSlot> list4, List<? extends AdSlot> list5, List<? extends AdSlot> list6, List<? extends AdSlot> list7) {
        Intrinsics.checkNotNullParameter(list, "kModel");
        Intrinsics.checkNotNullParameter(list2, "kExtraFetcher");
        Intrinsics.checkNotNullParameter(list3, "kReporter");
        Intrinsics.checkNotNullParameter(list4, "kClicker");
        Intrinsics.checkNotNullParameter(list5, "kTrack");
        Intrinsics.checkNotNullParameter(list6, "kVM");
        Intrinsics.checkNotNullParameter(list7, "kInspector");
        this.kModel = list;
        this.kExtraFetcher = list2;
        this.kReporter = list3;
        this.kClicker = list4;
        this.kTrack = list5;
        this.kVM = list6;
        this.kInspector = list7;
    }

    public /* synthetic */ AdKModules(List list, List list2, List list3, List list4, List list5, List list6, List list7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? CollectionsKt.emptyList() : list3, (i & 8) != 0 ? CollectionsKt.emptyList() : list4, (i & 16) != 0 ? CollectionsKt.emptyList() : list5, (i & 32) != 0 ? CollectionsKt.emptyList() : list6, (i & 64) != 0 ? CollectionsKt.emptyList() : list7);
    }

    public final List<AdSlot> getKModel() {
        return this.kModel;
    }

    public final List<AdSlot> getKExtraFetcher() {
        return this.kExtraFetcher;
    }

    public final List<AdSlot> getKReporter() {
        return this.kReporter;
    }

    public final List<AdSlot> getKClicker() {
        return this.kClicker;
    }

    public final List<AdSlot> getKTrack() {
        return this.kTrack;
    }

    public final List<AdSlot> getKVM() {
        return this.kVM;
    }

    public final List<AdSlot> getKInspector() {
        return this.kInspector;
    }
}