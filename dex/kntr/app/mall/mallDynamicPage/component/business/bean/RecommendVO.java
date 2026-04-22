package kntr.app.mall.mallDynamicPage.component.business.bean;

import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: MallFeedsModel.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 62\u00020\u0001:\u000256B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fBI\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003JD\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0005HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001J%\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\b4R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00067"}, d2 = {"Lkntr/app/mall/mallDynamicPage/component/business/bean/RecommendVO;", RoomRecommendViewModel.EMPTY_CURSOR, "title", RoomRecommendViewModel.EMPTY_CURSOR, "columnCount", RoomRecommendViewModel.EMPTY_CURSOR, "hasMore", RoomRecommendViewModel.EMPTY_CURSOR, "itemList", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/mall/mallDynamicPage/component/business/bean/MallRecommendItem;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getColumnCount", "()Ljava/lang/Integer;", "setColumnCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getHasMore", "()Ljava/lang/Boolean;", "setHasMore", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getItemList", "()Ljava/util/List;", "setItemList", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;)Lkntr/app/mall/mallDynamicPage/component/business/bean/RecommendVO;", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$mallDynamicPage_debug", "$serializer", "Companion", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class RecommendVO {
    private Integer columnCount;
    private Boolean hasMore;
    private List<MallRecommendItem> itemList;
    private String title;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.mallDynamicPage.component.business.bean.RecommendVO$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = RecommendVO._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public RecommendVO() {
        this((String) null, (Integer) null, (Boolean) null, (List) null, 15, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecommendVO copy$default(RecommendVO recommendVO, String str, Integer num, Boolean bool, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = recommendVO.title;
        }
        if ((i & 2) != 0) {
            num = recommendVO.columnCount;
        }
        if ((i & 4) != 0) {
            bool = recommendVO.hasMore;
        }
        if ((i & 8) != 0) {
            list = recommendVO.itemList;
        }
        return recommendVO.copy(str, num, bool, list);
    }

    public final String component1() {
        return this.title;
    }

    public final Integer component2() {
        return this.columnCount;
    }

    public final Boolean component3() {
        return this.hasMore;
    }

    public final List<MallRecommendItem> component4() {
        return this.itemList;
    }

    public final RecommendVO copy(String str, Integer num, Boolean bool, List<MallRecommendItem> list) {
        return new RecommendVO(str, num, bool, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RecommendVO) {
            RecommendVO recommendVO = (RecommendVO) obj;
            return Intrinsics.areEqual(this.title, recommendVO.title) && Intrinsics.areEqual(this.columnCount, recommendVO.columnCount) && Intrinsics.areEqual(this.hasMore, recommendVO.hasMore) && Intrinsics.areEqual(this.itemList, recommendVO.itemList);
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.columnCount == null ? 0 : this.columnCount.hashCode())) * 31) + (this.hasMore == null ? 0 : this.hasMore.hashCode())) * 31) + (this.itemList != null ? this.itemList.hashCode() : 0);
    }

    public String toString() {
        String str = this.title;
        Integer num = this.columnCount;
        Boolean bool = this.hasMore;
        return "RecommendVO(title=" + str + ", columnCount=" + num + ", hasMore=" + bool + ", itemList=" + this.itemList + ")";
    }

    /* compiled from: MallFeedsModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/mallDynamicPage/component/business/bean/RecommendVO$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/mallDynamicPage/component/business/bean/RecommendVO;", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<RecommendVO> serializer() {
            return RecommendVO$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ RecommendVO(int seen0, String title, Integer columnCount, Boolean hasMore, List itemList, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.title = null;
        } else {
            this.title = title;
        }
        if ((seen0 & 2) == 0) {
            this.columnCount = null;
        } else {
            this.columnCount = columnCount;
        }
        if ((seen0 & 4) == 0) {
            this.hasMore = null;
        } else {
            this.hasMore = hasMore;
        }
        if ((seen0 & 8) == 0) {
            this.itemList = null;
        } else {
            this.itemList = itemList;
        }
    }

    public RecommendVO(String title, Integer columnCount, Boolean hasMore, List<MallRecommendItem> list) {
        this.title = title;
        this.columnCount = columnCount;
        this.hasMore = hasMore;
        this.itemList = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(MallRecommendItem$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$mallDynamicPage_debug(RecommendVO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.title != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.columnCount != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.columnCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.hasMore != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.hasMore);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.itemList != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.itemList);
        }
    }

    public /* synthetic */ RecommendVO(String str, Integer num, Boolean bool, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : list);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final Integer getColumnCount() {
        return this.columnCount;
    }

    public final void setColumnCount(Integer num) {
        this.columnCount = num;
    }

    public final Boolean getHasMore() {
        return this.hasMore;
    }

    public final void setHasMore(Boolean bool) {
        this.hasMore = bool;
    }

    public final List<MallRecommendItem> getItemList() {
        return this.itemList;
    }

    public final void setItemList(List<MallRecommendItem> list) {
        this.itemList = list;
    }
}