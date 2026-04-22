package kntr.app.mall.product.details.page.api.model;

import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
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
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: FeedsModel.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bM\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 u2\u00020\u0001:\u0002tuBÕ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0018\b\u0002\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001b\u0010\u001cBÉ\u0001\b\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u001b\u0010 J\u0010\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010W\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0019\u0010c\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0016HÆ\u0003J\u0010\u0010d\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010MJ\u0010\u0010e\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0002\u0010RJÜ\u0001\u0010f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0018\b\u0002\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÆ\u0001¢\u0006\u0002\u0010gJ\u0013\u0010h\u001a\u00020\u00182\b\u0010i\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010j\u001a\u00020\u001aHÖ\u0001J\t\u0010k\u001a\u00020\u0005HÖ\u0001J%\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020\u00002\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020rH\u0001¢\u0006\u0002\bsR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010'\"\u0004\b3\u0010)R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010'\"\u0004\b9\u0010)R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010'\"\u0004\b?\u0010)R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010'\"\u0004\bA\u0010)R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010'\"\u0004\bC\u0010)R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR*\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u0010\n\u0002\u0010P\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u0010\n\u0002\u0010U\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010T¨\u0006v"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/MallRecommendItem;", "", "itemId", "", "itemType", "", "title", "cover", "tags", "Lkntr/app/mall/product/details/page/api/model/ItemTags;", "tag", "feedTag", "Lkntr/app/mall/product/details/page/api/model/FeedTag;", "url", "price", "Lkntr/app/mall/product/details/page/api/model/PriceInfo;", "like", "detailInfo", "vvType", "reportInfo", "Lkntr/app/mall/product/details/page/api/model/ReportInfo;", "reportParams", "", "teamBLind", "", "pageNum", "", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ItemTags;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/FeedTag;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/PriceInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ReportInfo;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ItemTags;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/FeedTag;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/PriceInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ReportInfo;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getItemId", "()Ljava/lang/Long;", "setItemId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getItemType", "()Ljava/lang/String;", "setItemType", "(Ljava/lang/String;)V", "getTitle", "setTitle", "getCover", "setCover", "getTags", "()Lkntr/app/mall/product/details/page/api/model/ItemTags;", "setTags", "(Lkntr/app/mall/product/details/page/api/model/ItemTags;)V", "getTag", "setTag", "getFeedTag", "()Lkntr/app/mall/product/details/page/api/model/FeedTag;", "setFeedTag", "(Lkntr/app/mall/product/details/page/api/model/FeedTag;)V", "getUrl", "setUrl", "getPrice", "()Lkntr/app/mall/product/details/page/api/model/PriceInfo;", "setPrice", "(Lkntr/app/mall/product/details/page/api/model/PriceInfo;)V", "getLike", "setLike", "getDetailInfo", "setDetailInfo", "getVvType", "setVvType", "getReportInfo", "()Lkntr/app/mall/product/details/page/api/model/ReportInfo;", "setReportInfo", "(Lkntr/app/mall/product/details/page/api/model/ReportInfo;)V", "getReportParams", "()Ljava/util/Map;", "setReportParams", "(Ljava/util/Map;)V", "getTeamBLind", "()Ljava/lang/Boolean;", "setTeamBLind", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getPageNum", "()Ljava/lang/Integer;", "setPageNum", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ItemTags;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/FeedTag;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/PriceInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/mall/product/details/page/api/model/ReportInfo;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/Integer;)Lkntr/app/mall/product/details/page/api/model/MallRecommendItem;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class MallRecommendItem {
    private String cover;
    private String detailInfo;
    private FeedTag feedTag;
    private Long itemId;
    private String itemType;
    private String like;
    private Integer pageNum;
    private PriceInfo price;
    private ReportInfo reportInfo;
    private Map<String, String> reportParams;
    private String tag;
    private ItemTags tags;
    private Boolean teamBLind;
    private String title;
    private String url;
    private String vvType;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.MallRecommendItem$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = MallRecommendItem._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null};

    public MallRecommendItem() {
        this((Long) null, (String) null, (String) null, (String) null, (ItemTags) null, (String) null, (FeedTag) null, (String) null, (PriceInfo) null, (String) null, (String) null, (String) null, (ReportInfo) null, (Map) null, (Boolean) null, (Integer) null, 65535, (DefaultConstructorMarker) null);
    }

    public final Long component1() {
        return this.itemId;
    }

    public final String component10() {
        return this.like;
    }

    public final String component11() {
        return this.detailInfo;
    }

    public final String component12() {
        return this.vvType;
    }

    public final ReportInfo component13() {
        return this.reportInfo;
    }

    public final Map<String, String> component14() {
        return this.reportParams;
    }

    public final Boolean component15() {
        return this.teamBLind;
    }

    public final Integer component16() {
        return this.pageNum;
    }

    public final String component2() {
        return this.itemType;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.cover;
    }

    public final ItemTags component5() {
        return this.tags;
    }

    public final String component6() {
        return this.tag;
    }

    public final FeedTag component7() {
        return this.feedTag;
    }

    public final String component8() {
        return this.url;
    }

    public final PriceInfo component9() {
        return this.price;
    }

    public final MallRecommendItem copy(Long l, String str, String str2, String str3, ItemTags itemTags, String str4, FeedTag feedTag, String str5, PriceInfo priceInfo, String str6, String str7, String str8, ReportInfo reportInfo, Map<String, String> map, Boolean bool, Integer num) {
        return new MallRecommendItem(l, str, str2, str3, itemTags, str4, feedTag, str5, priceInfo, str6, str7, str8, reportInfo, map, bool, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MallRecommendItem) {
            MallRecommendItem mallRecommendItem = (MallRecommendItem) obj;
            return Intrinsics.areEqual(this.itemId, mallRecommendItem.itemId) && Intrinsics.areEqual(this.itemType, mallRecommendItem.itemType) && Intrinsics.areEqual(this.title, mallRecommendItem.title) && Intrinsics.areEqual(this.cover, mallRecommendItem.cover) && Intrinsics.areEqual(this.tags, mallRecommendItem.tags) && Intrinsics.areEqual(this.tag, mallRecommendItem.tag) && Intrinsics.areEqual(this.feedTag, mallRecommendItem.feedTag) && Intrinsics.areEqual(this.url, mallRecommendItem.url) && Intrinsics.areEqual(this.price, mallRecommendItem.price) && Intrinsics.areEqual(this.like, mallRecommendItem.like) && Intrinsics.areEqual(this.detailInfo, mallRecommendItem.detailInfo) && Intrinsics.areEqual(this.vvType, mallRecommendItem.vvType) && Intrinsics.areEqual(this.reportInfo, mallRecommendItem.reportInfo) && Intrinsics.areEqual(this.reportParams, mallRecommendItem.reportParams) && Intrinsics.areEqual(this.teamBLind, mallRecommendItem.teamBLind) && Intrinsics.areEqual(this.pageNum, mallRecommendItem.pageNum);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((this.itemId == null ? 0 : this.itemId.hashCode()) * 31) + (this.itemType == null ? 0 : this.itemType.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.cover == null ? 0 : this.cover.hashCode())) * 31) + (this.tags == null ? 0 : this.tags.hashCode())) * 31) + (this.tag == null ? 0 : this.tag.hashCode())) * 31) + (this.feedTag == null ? 0 : this.feedTag.hashCode())) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.price == null ? 0 : this.price.hashCode())) * 31) + (this.like == null ? 0 : this.like.hashCode())) * 31) + (this.detailInfo == null ? 0 : this.detailInfo.hashCode())) * 31) + (this.vvType == null ? 0 : this.vvType.hashCode())) * 31) + (this.reportInfo == null ? 0 : this.reportInfo.hashCode())) * 31) + (this.reportParams == null ? 0 : this.reportParams.hashCode())) * 31) + (this.teamBLind == null ? 0 : this.teamBLind.hashCode())) * 31) + (this.pageNum != null ? this.pageNum.hashCode() : 0);
    }

    public String toString() {
        Long l = this.itemId;
        String str = this.itemType;
        String str2 = this.title;
        String str3 = this.cover;
        ItemTags itemTags = this.tags;
        String str4 = this.tag;
        FeedTag feedTag = this.feedTag;
        String str5 = this.url;
        PriceInfo priceInfo = this.price;
        String str6 = this.like;
        String str7 = this.detailInfo;
        String str8 = this.vvType;
        ReportInfo reportInfo = this.reportInfo;
        Map<String, String> map = this.reportParams;
        Boolean bool = this.teamBLind;
        return "MallRecommendItem(itemId=" + l + ", itemType=" + str + ", title=" + str2 + ", cover=" + str3 + ", tags=" + itemTags + ", tag=" + str4 + ", feedTag=" + feedTag + ", url=" + str5 + ", price=" + priceInfo + ", like=" + str6 + ", detailInfo=" + str7 + ", vvType=" + str8 + ", reportInfo=" + reportInfo + ", reportParams=" + map + ", teamBLind=" + bool + ", pageNum=" + this.pageNum + ")";
    }

    /* compiled from: FeedsModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/MallRecommendItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/MallRecommendItem;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<MallRecommendItem> serializer() {
            return MallRecommendItem$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ MallRecommendItem(int seen0, Long itemId, String itemType, String title, String cover, ItemTags tags, String tag, FeedTag feedTag, String url, PriceInfo price, String like, String detailInfo, String vvType, ReportInfo reportInfo, Map reportParams, Boolean teamBLind, Integer pageNum, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.itemId = null;
        } else {
            this.itemId = itemId;
        }
        if ((seen0 & 2) == 0) {
            this.itemType = null;
        } else {
            this.itemType = itemType;
        }
        if ((seen0 & 4) == 0) {
            this.title = null;
        } else {
            this.title = title;
        }
        if ((seen0 & 8) == 0) {
            this.cover = null;
        } else {
            this.cover = cover;
        }
        if ((seen0 & 16) == 0) {
            this.tags = null;
        } else {
            this.tags = tags;
        }
        if ((seen0 & 32) == 0) {
            this.tag = null;
        } else {
            this.tag = tag;
        }
        if ((seen0 & 64) == 0) {
            this.feedTag = null;
        } else {
            this.feedTag = feedTag;
        }
        if ((seen0 & 128) == 0) {
            this.url = null;
        } else {
            this.url = url;
        }
        if ((seen0 & 256) == 0) {
            this.price = null;
        } else {
            this.price = price;
        }
        if ((seen0 & 512) == 0) {
            this.like = null;
        } else {
            this.like = like;
        }
        if ((seen0 & 1024) == 0) {
            this.detailInfo = null;
        } else {
            this.detailInfo = detailInfo;
        }
        if ((seen0 & 2048) == 0) {
            this.vvType = null;
        } else {
            this.vvType = vvType;
        }
        if ((seen0 & 4096) == 0) {
            this.reportInfo = null;
        } else {
            this.reportInfo = reportInfo;
        }
        if ((seen0 & 8192) == 0) {
            this.reportParams = null;
        } else {
            this.reportParams = reportParams;
        }
        if ((seen0 & 16384) == 0) {
            this.teamBLind = null;
        } else {
            this.teamBLind = teamBLind;
        }
        if ((seen0 & 32768) == 0) {
            this.pageNum = null;
        } else {
            this.pageNum = pageNum;
        }
    }

    public MallRecommendItem(Long itemId, String itemType, String title, String cover, ItemTags tags, String tag, FeedTag feedTag, String url, PriceInfo price, String like, String detailInfo, String vvType, ReportInfo reportInfo, Map<String, String> map, Boolean teamBLind, Integer pageNum) {
        this.itemId = itemId;
        this.itemType = itemType;
        this.title = title;
        this.cover = cover;
        this.tags = tags;
        this.tag = tag;
        this.feedTag = feedTag;
        this.url = url;
        this.price = price;
        this.like = like;
        this.detailInfo = detailInfo;
        this.vvType = vvType;
        this.reportInfo = reportInfo;
        this.reportParams = map;
        this.teamBLind = teamBLind;
        this.pageNum = pageNum;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new LinkedHashMapSerializer(StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(MallRecommendItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.itemId != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.itemId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.itemType != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.itemType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.title != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.cover != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.cover);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.tags != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, ItemTags$$serializer.INSTANCE, self.tags);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.tag != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.tag);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.feedTag != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, FeedTag$$serializer.INSTANCE, self.feedTag);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.url != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.url);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.price != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, PriceInfo$$serializer.INSTANCE, self.price);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.like != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.like);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.detailInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.detailInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.vvType != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.vvType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.reportInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, ReportInfo$$serializer.INSTANCE, self.reportInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.reportParams != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, lazyArr[13].getValue(), self.reportParams);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.teamBLind != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, BooleanSerializer.INSTANCE, self.teamBLind);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.pageNum != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, IntSerializer.INSTANCE, self.pageNum);
        }
    }

    public /* synthetic */ MallRecommendItem(Long l, String str, String str2, String str3, ItemTags itemTags, String str4, FeedTag feedTag, String str5, PriceInfo priceInfo, String str6, String str7, String str8, ReportInfo reportInfo, Map map, Boolean bool, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : itemTags, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : feedTag, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : priceInfo, (i & 512) != 0 ? null : str6, (i & 1024) != 0 ? null : str7, (i & 2048) != 0 ? null : str8, (i & 4096) != 0 ? null : reportInfo, (i & 8192) != 0 ? null : map, (i & 16384) != 0 ? null : bool, (i & 32768) != 0 ? null : num);
    }

    public final Long getItemId() {
        return this.itemId;
    }

    public final void setItemId(Long l) {
        this.itemId = l;
    }

    public final String getItemType() {
        return this.itemType;
    }

    public final void setItemType(String str) {
        this.itemType = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getCover() {
        return this.cover;
    }

    public final void setCover(String str) {
        this.cover = str;
    }

    public final ItemTags getTags() {
        return this.tags;
    }

    public final void setTags(ItemTags itemTags) {
        this.tags = itemTags;
    }

    public final String getTag() {
        return this.tag;
    }

    public final void setTag(String str) {
        this.tag = str;
    }

    public final FeedTag getFeedTag() {
        return this.feedTag;
    }

    public final void setFeedTag(FeedTag feedTag) {
        this.feedTag = feedTag;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final PriceInfo getPrice() {
        return this.price;
    }

    public final void setPrice(PriceInfo priceInfo) {
        this.price = priceInfo;
    }

    public final String getLike() {
        return this.like;
    }

    public final void setLike(String str) {
        this.like = str;
    }

    public final String getDetailInfo() {
        return this.detailInfo;
    }

    public final void setDetailInfo(String str) {
        this.detailInfo = str;
    }

    public final String getVvType() {
        return this.vvType;
    }

    public final void setVvType(String str) {
        this.vvType = str;
    }

    public final ReportInfo getReportInfo() {
        return this.reportInfo;
    }

    public final void setReportInfo(ReportInfo reportInfo) {
        this.reportInfo = reportInfo;
    }

    public final Map<String, String> getReportParams() {
        return this.reportParams;
    }

    public final void setReportParams(Map<String, String> map) {
        this.reportParams = map;
    }

    public final Boolean getTeamBLind() {
        return this.teamBLind;
    }

    public final void setTeamBLind(Boolean bool) {
        this.teamBLind = bool;
    }

    public final Integer getPageNum() {
        return this.pageNum;
    }

    public final void setPageNum(Integer num) {
        this.pageNum = num;
    }
}