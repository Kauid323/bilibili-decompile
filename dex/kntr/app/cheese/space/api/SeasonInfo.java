package kntr.app.cheese.space.api;

import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: PageData.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0002./BK\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\u0004\b\r\u0010\u000eB]\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0\u0003HÆ\u0003JM\u0010 \u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\nHÖ\u0001J\t\u0010%\u001a\u00020\bHÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014¨\u00060"}, d2 = {"Lkntr/app/cheese/space/api/SeasonInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "sort_model_list", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/cheese/space/api/SortModel;", "classified_info_list", "Lkntr/app/cheese/space/api/ClassifiedInfo;", "title", RoomRecommendViewModel.EMPTY_CURSOR, "season_count", RoomRecommendViewModel.EMPTY_CURSOR, "season_model_list", "Lkntr/app/cheese/space/api/SeasonModel;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;ILjava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Ljava/lang/String;ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSort_model_list", "()Ljava/util/List;", "getClassified_info_list", "getTitle", "()Ljava/lang/String;", "getSeason_count", "()I", "getSeason_model_list", "component1", "component2", "component3", "component4", "component5", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$space_debug", "$serializer", "Companion", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class SeasonInfo {
    private final List<ClassifiedInfo> classified_info_list;
    private final int season_count;
    private final List<SeasonModel> season_model_list;
    private final List<SortModel> sort_model_list;
    private final String title;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.cheese.space.api.SeasonInfo$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = SeasonInfo._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.cheese.space.api.SeasonInfo$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = SeasonInfo._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.cheese.space.api.SeasonInfo$$ExternalSyntheticLambda2
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = SeasonInfo._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    })};

    public SeasonInfo() {
        this((List) null, (List) null, (String) null, 0, (List) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SeasonInfo copy$default(SeasonInfo seasonInfo, List list, List list2, String str, int i, List list3, int i2, Object obj) {
        List<SortModel> list4 = list;
        if ((i2 & 1) != 0) {
            list4 = seasonInfo.sort_model_list;
        }
        List<ClassifiedInfo> list5 = list2;
        if ((i2 & 2) != 0) {
            list5 = seasonInfo.classified_info_list;
        }
        List list6 = list5;
        if ((i2 & 4) != 0) {
            str = seasonInfo.title;
        }
        String str2 = str;
        if ((i2 & 8) != 0) {
            i = seasonInfo.season_count;
        }
        int i3 = i;
        List<SeasonModel> list7 = list3;
        if ((i2 & 16) != 0) {
            list7 = seasonInfo.season_model_list;
        }
        return seasonInfo.copy(list4, list6, str2, i3, list7);
    }

    public final List<SortModel> component1() {
        return this.sort_model_list;
    }

    public final List<ClassifiedInfo> component2() {
        return this.classified_info_list;
    }

    public final String component3() {
        return this.title;
    }

    public final int component4() {
        return this.season_count;
    }

    public final List<SeasonModel> component5() {
        return this.season_model_list;
    }

    public final SeasonInfo copy(List<SortModel> list, List<ClassifiedInfo> list2, String str, int i, List<SeasonModel> list3) {
        Intrinsics.checkNotNullParameter(list, "sort_model_list");
        Intrinsics.checkNotNullParameter(list2, "classified_info_list");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list3, "season_model_list");
        return new SeasonInfo(list, list2, str, i, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SeasonInfo) {
            SeasonInfo seasonInfo = (SeasonInfo) obj;
            return Intrinsics.areEqual(this.sort_model_list, seasonInfo.sort_model_list) && Intrinsics.areEqual(this.classified_info_list, seasonInfo.classified_info_list) && Intrinsics.areEqual(this.title, seasonInfo.title) && this.season_count == seasonInfo.season_count && Intrinsics.areEqual(this.season_model_list, seasonInfo.season_model_list);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.sort_model_list.hashCode() * 31) + this.classified_info_list.hashCode()) * 31) + this.title.hashCode()) * 31) + this.season_count) * 31) + this.season_model_list.hashCode();
    }

    public String toString() {
        List<SortModel> list = this.sort_model_list;
        List<ClassifiedInfo> list2 = this.classified_info_list;
        String str = this.title;
        int i = this.season_count;
        return "SeasonInfo(sort_model_list=" + list + ", classified_info_list=" + list2 + ", title=" + str + ", season_count=" + i + ", season_model_list=" + this.season_model_list + ")";
    }

    /* compiled from: PageData.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/cheese/space/api/SeasonInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/cheese/space/api/SeasonInfo;", "space_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SeasonInfo> serializer() {
            return SeasonInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SeasonInfo(int seen0, List sort_model_list, List classified_info_list, String title, int season_count, List season_model_list, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.sort_model_list = CollectionsKt.emptyList();
        } else {
            this.sort_model_list = sort_model_list;
        }
        if ((seen0 & 2) == 0) {
            this.classified_info_list = CollectionsKt.emptyList();
        } else {
            this.classified_info_list = classified_info_list;
        }
        if ((seen0 & 4) == 0) {
            this.title = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.title = title;
        }
        if ((seen0 & 8) == 0) {
            this.season_count = 0;
        } else {
            this.season_count = season_count;
        }
        if ((seen0 & 16) == 0) {
            this.season_model_list = CollectionsKt.emptyList();
        } else {
            this.season_model_list = season_model_list;
        }
    }

    public SeasonInfo(List<SortModel> list, List<ClassifiedInfo> list2, String title, int season_count, List<SeasonModel> list3) {
        Intrinsics.checkNotNullParameter(list, "sort_model_list");
        Intrinsics.checkNotNullParameter(list2, "classified_info_list");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(list3, "season_model_list");
        this.sort_model_list = list;
        this.classified_info_list = list2;
        this.title = title;
        this.season_count = season_count;
        this.season_model_list = list3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(SortModel$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(ClassifiedInfo$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(SeasonModel$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$space_debug(SeasonInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.sort_model_list, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy) lazyArr[0].getValue(), self.sort_model_list);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.classified_info_list, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.classified_info_list);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.title, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 2, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.season_count != 0) {
            output.encodeIntElement(serialDesc, 3, self.season_count);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.season_model_list, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.season_model_list);
        }
    }

    public /* synthetic */ SeasonInfo(List list, List list2, String str, int i, List list3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? CollectionsKt.emptyList() : list, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list2, (i2 & 4) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? CollectionsKt.emptyList() : list3);
    }

    public final List<SortModel> getSort_model_list() {
        return this.sort_model_list;
    }

    public final List<ClassifiedInfo> getClassified_info_list() {
        return this.classified_info_list;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getSeason_count() {
        return this.season_count;
    }

    public final List<SeasonModel> getSeason_model_list() {
        return this.season_model_list;
    }
}