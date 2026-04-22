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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: MallFeedsModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b@\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 j2\u00020\u0001:\u0002ijB¹\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0004\b\u0017\u0010\u0018B§\u0002\b\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u0017\u0010\u001dJ\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0011\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0011\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0011\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0011\u0010O\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010R\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010T\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010V\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0011\u0010W\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0011\u0010X\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0011\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0011\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J»\u0002\u0010[\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010_\u001a\u00020\u001aHÖ\u0001J\t\u0010`\u001a\u00020\u0003HÖ\u0001J%\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\u00002\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020gH\u0001¢\u0006\u0002\bhR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001f\"\u0004\b+\u0010!R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010#\"\u0004\b-\u0010%R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010#\"\u0004\b/\u0010%R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010#\"\u0004\b1\u0010%R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001f\"\u0004\b3\u0010!R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001f\"\u0004\b5\u0010!R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010#\"\u0004\b7\u0010%R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001f\"\u0004\b9\u0010!R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010#\"\u0004\b;\u0010%R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001f\"\u0004\b=\u0010!R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010#\"\u0004\b?\u0010%R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010#\"\u0004\bA\u0010%R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010#\"\u0004\bC\u0010%R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010#\"\u0004\bE\u0010%R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010#\"\u0004\bG\u0010%¨\u0006k"}, d2 = {"Lkntr/app/mall/mallDynamicPage/component/business/bean/ItemTags;", RoomRecommendViewModel.EMPTY_CURSOR, "promotionTagV2", RoomRecommendViewModel.EMPTY_CURSOR, "promotionTagNames", RoomRecommendViewModel.EMPTY_CURSOR, "marketingTagNames", "saleTypeTagNames", "typeAndLimitTagName", "itemTagNames", "recommendTagNames", "attributeTagNames", "rankAndSellPointTagNames", "blindBoxHideTypeNames", "titleTagNames", "ticketTag", "starBoxSalePoints", "exclusiveSalePoints", "otherSalePoints", "serviceTagNames", "tagsSort", "adTagNames", "serviceRightsTags", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPromotionTagV2", "()Ljava/lang/String;", "setPromotionTagV2", "(Ljava/lang/String;)V", "getPromotionTagNames", "()Ljava/util/List;", "setPromotionTagNames", "(Ljava/util/List;)V", "getMarketingTagNames", "setMarketingTagNames", "getSaleTypeTagNames", "setSaleTypeTagNames", "getTypeAndLimitTagName", "setTypeAndLimitTagName", "getItemTagNames", "setItemTagNames", "getRecommendTagNames", "setRecommendTagNames", "getAttributeTagNames", "setAttributeTagNames", "getRankAndSellPointTagNames", "setRankAndSellPointTagNames", "getBlindBoxHideTypeNames", "setBlindBoxHideTypeNames", "getTitleTagNames", "setTitleTagNames", "getTicketTag", "setTicketTag", "getStarBoxSalePoints", "setStarBoxSalePoints", "getExclusiveSalePoints", "setExclusiveSalePoints", "getOtherSalePoints", "setOtherSalePoints", "getServiceTagNames", "setServiceTagNames", "getTagsSort", "setTagsSort", "getAdTagNames", "setAdTagNames", "getServiceRightsTags", "setServiceRightsTags", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$mallDynamicPage_debug", "$serializer", "Companion", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class ItemTags {
    private List<String> adTagNames;
    private List<String> attributeTagNames;
    private String blindBoxHideTypeNames;
    private String exclusiveSalePoints;
    private List<String> itemTagNames;
    private List<String> marketingTagNames;
    private List<String> otherSalePoints;
    private List<String> promotionTagNames;
    private String promotionTagV2;
    private String rankAndSellPointTagNames;
    private List<String> recommendTagNames;
    private List<String> saleTypeTagNames;
    private List<String> serviceRightsTags;
    private List<String> serviceTagNames;
    private List<String> starBoxSalePoints;
    private List<String> tagsSort;
    private String ticketTag;
    private List<String> titleTagNames;
    private String typeAndLimitTagName;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.mallDynamicPage.component.business.bean.ItemTags$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = ItemTags._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.mallDynamicPage.component.business.bean.ItemTags$$ExternalSyntheticLambda7
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = ItemTags._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.mallDynamicPage.component.business.bean.ItemTags$$ExternalSyntheticLambda8
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = ItemTags._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    }), null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.mallDynamicPage.component.business.bean.ItemTags$$ExternalSyntheticLambda9
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$2;
            _childSerializers$_anonymous_$2 = ItemTags._childSerializers$_anonymous_$2();
            return _childSerializers$_anonymous_$2;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.mallDynamicPage.component.business.bean.ItemTags$$ExternalSyntheticLambda10
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$3;
            _childSerializers$_anonymous_$3 = ItemTags._childSerializers$_anonymous_$3();
            return _childSerializers$_anonymous_$3;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.mallDynamicPage.component.business.bean.ItemTags$$ExternalSyntheticLambda11
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$4;
            _childSerializers$_anonymous_$4 = ItemTags._childSerializers$_anonymous_$4();
            return _childSerializers$_anonymous_$4;
        }
    }), null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.mallDynamicPage.component.business.bean.ItemTags$$ExternalSyntheticLambda12
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$5;
            _childSerializers$_anonymous_$5 = ItemTags._childSerializers$_anonymous_$5();
            return _childSerializers$_anonymous_$5;
        }
    }), null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.mallDynamicPage.component.business.bean.ItemTags$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$6;
            _childSerializers$_anonymous_$6 = ItemTags._childSerializers$_anonymous_$6();
            return _childSerializers$_anonymous_$6;
        }
    }), null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.mallDynamicPage.component.business.bean.ItemTags$$ExternalSyntheticLambda2
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$7;
            _childSerializers$_anonymous_$7 = ItemTags._childSerializers$_anonymous_$7();
            return _childSerializers$_anonymous_$7;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.mallDynamicPage.component.business.bean.ItemTags$$ExternalSyntheticLambda3
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$8;
            _childSerializers$_anonymous_$8 = ItemTags._childSerializers$_anonymous_$8();
            return _childSerializers$_anonymous_$8;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.mallDynamicPage.component.business.bean.ItemTags$$ExternalSyntheticLambda4
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$9;
            _childSerializers$_anonymous_$9 = ItemTags._childSerializers$_anonymous_$9();
            return _childSerializers$_anonymous_$9;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.mallDynamicPage.component.business.bean.ItemTags$$ExternalSyntheticLambda5
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$10;
            _childSerializers$_anonymous_$10 = ItemTags._childSerializers$_anonymous_$10();
            return _childSerializers$_anonymous_$10;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.mallDynamicPage.component.business.bean.ItemTags$$ExternalSyntheticLambda6
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$11;
            _childSerializers$_anonymous_$11 = ItemTags._childSerializers$_anonymous_$11();
            return _childSerializers$_anonymous_$11;
        }
    })};

    public ItemTags() {
        this((String) null, (List) null, (List) null, (List) null, (String) null, (List) null, (List) null, (List) null, (String) null, (String) null, (List) null, (String) null, (List) null, (String) null, (List) null, (List) null, (List) null, (List) null, (List) null, 524287, (DefaultConstructorMarker) null);
    }

    public final String component1() {
        return this.promotionTagV2;
    }

    public final String component10() {
        return this.blindBoxHideTypeNames;
    }

    public final List<String> component11() {
        return this.titleTagNames;
    }

    public final String component12() {
        return this.ticketTag;
    }

    public final List<String> component13() {
        return this.starBoxSalePoints;
    }

    public final String component14() {
        return this.exclusiveSalePoints;
    }

    public final List<String> component15() {
        return this.otherSalePoints;
    }

    public final List<String> component16() {
        return this.serviceTagNames;
    }

    public final List<String> component17() {
        return this.tagsSort;
    }

    public final List<String> component18() {
        return this.adTagNames;
    }

    public final List<String> component19() {
        return this.serviceRightsTags;
    }

    public final List<String> component2() {
        return this.promotionTagNames;
    }

    public final List<String> component3() {
        return this.marketingTagNames;
    }

    public final List<String> component4() {
        return this.saleTypeTagNames;
    }

    public final String component5() {
        return this.typeAndLimitTagName;
    }

    public final List<String> component6() {
        return this.itemTagNames;
    }

    public final List<String> component7() {
        return this.recommendTagNames;
    }

    public final List<String> component8() {
        return this.attributeTagNames;
    }

    public final String component9() {
        return this.rankAndSellPointTagNames;
    }

    public final ItemTags copy(String str, List<String> list, List<String> list2, List<String> list3, String str2, List<String> list4, List<String> list5, List<String> list6, String str3, String str4, List<String> list7, String str5, List<String> list8, String str6, List<String> list9, List<String> list10, List<String> list11, List<String> list12, List<String> list13) {
        return new ItemTags(str, list, list2, list3, str2, list4, list5, list6, str3, str4, list7, str5, list8, str6, list9, list10, list11, list12, list13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ItemTags) {
            ItemTags itemTags = (ItemTags) obj;
            return Intrinsics.areEqual(this.promotionTagV2, itemTags.promotionTagV2) && Intrinsics.areEqual(this.promotionTagNames, itemTags.promotionTagNames) && Intrinsics.areEqual(this.marketingTagNames, itemTags.marketingTagNames) && Intrinsics.areEqual(this.saleTypeTagNames, itemTags.saleTypeTagNames) && Intrinsics.areEqual(this.typeAndLimitTagName, itemTags.typeAndLimitTagName) && Intrinsics.areEqual(this.itemTagNames, itemTags.itemTagNames) && Intrinsics.areEqual(this.recommendTagNames, itemTags.recommendTagNames) && Intrinsics.areEqual(this.attributeTagNames, itemTags.attributeTagNames) && Intrinsics.areEqual(this.rankAndSellPointTagNames, itemTags.rankAndSellPointTagNames) && Intrinsics.areEqual(this.blindBoxHideTypeNames, itemTags.blindBoxHideTypeNames) && Intrinsics.areEqual(this.titleTagNames, itemTags.titleTagNames) && Intrinsics.areEqual(this.ticketTag, itemTags.ticketTag) && Intrinsics.areEqual(this.starBoxSalePoints, itemTags.starBoxSalePoints) && Intrinsics.areEqual(this.exclusiveSalePoints, itemTags.exclusiveSalePoints) && Intrinsics.areEqual(this.otherSalePoints, itemTags.otherSalePoints) && Intrinsics.areEqual(this.serviceTagNames, itemTags.serviceTagNames) && Intrinsics.areEqual(this.tagsSort, itemTags.tagsSort) && Intrinsics.areEqual(this.adTagNames, itemTags.adTagNames) && Intrinsics.areEqual(this.serviceRightsTags, itemTags.serviceRightsTags);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((this.promotionTagV2 == null ? 0 : this.promotionTagV2.hashCode()) * 31) + (this.promotionTagNames == null ? 0 : this.promotionTagNames.hashCode())) * 31) + (this.marketingTagNames == null ? 0 : this.marketingTagNames.hashCode())) * 31) + (this.saleTypeTagNames == null ? 0 : this.saleTypeTagNames.hashCode())) * 31) + (this.typeAndLimitTagName == null ? 0 : this.typeAndLimitTagName.hashCode())) * 31) + (this.itemTagNames == null ? 0 : this.itemTagNames.hashCode())) * 31) + (this.recommendTagNames == null ? 0 : this.recommendTagNames.hashCode())) * 31) + (this.attributeTagNames == null ? 0 : this.attributeTagNames.hashCode())) * 31) + (this.rankAndSellPointTagNames == null ? 0 : this.rankAndSellPointTagNames.hashCode())) * 31) + (this.blindBoxHideTypeNames == null ? 0 : this.blindBoxHideTypeNames.hashCode())) * 31) + (this.titleTagNames == null ? 0 : this.titleTagNames.hashCode())) * 31) + (this.ticketTag == null ? 0 : this.ticketTag.hashCode())) * 31) + (this.starBoxSalePoints == null ? 0 : this.starBoxSalePoints.hashCode())) * 31) + (this.exclusiveSalePoints == null ? 0 : this.exclusiveSalePoints.hashCode())) * 31) + (this.otherSalePoints == null ? 0 : this.otherSalePoints.hashCode())) * 31) + (this.serviceTagNames == null ? 0 : this.serviceTagNames.hashCode())) * 31) + (this.tagsSort == null ? 0 : this.tagsSort.hashCode())) * 31) + (this.adTagNames == null ? 0 : this.adTagNames.hashCode())) * 31) + (this.serviceRightsTags != null ? this.serviceRightsTags.hashCode() : 0);
    }

    public String toString() {
        String str = this.promotionTagV2;
        List<String> list = this.promotionTagNames;
        List<String> list2 = this.marketingTagNames;
        List<String> list3 = this.saleTypeTagNames;
        String str2 = this.typeAndLimitTagName;
        List<String> list4 = this.itemTagNames;
        List<String> list5 = this.recommendTagNames;
        List<String> list6 = this.attributeTagNames;
        String str3 = this.rankAndSellPointTagNames;
        String str4 = this.blindBoxHideTypeNames;
        List<String> list7 = this.titleTagNames;
        String str5 = this.ticketTag;
        List<String> list8 = this.starBoxSalePoints;
        String str6 = this.exclusiveSalePoints;
        List<String> list9 = this.otherSalePoints;
        List<String> list10 = this.serviceTagNames;
        List<String> list11 = this.tagsSort;
        List<String> list12 = this.adTagNames;
        return "ItemTags(promotionTagV2=" + str + ", promotionTagNames=" + list + ", marketingTagNames=" + list2 + ", saleTypeTagNames=" + list3 + ", typeAndLimitTagName=" + str2 + ", itemTagNames=" + list4 + ", recommendTagNames=" + list5 + ", attributeTagNames=" + list6 + ", rankAndSellPointTagNames=" + str3 + ", blindBoxHideTypeNames=" + str4 + ", titleTagNames=" + list7 + ", ticketTag=" + str5 + ", starBoxSalePoints=" + list8 + ", exclusiveSalePoints=" + str6 + ", otherSalePoints=" + list9 + ", serviceTagNames=" + list10 + ", tagsSort=" + list11 + ", adTagNames=" + list12 + ", serviceRightsTags=" + this.serviceRightsTags + ")";
    }

    /* compiled from: MallFeedsModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/mallDynamicPage/component/business/bean/ItemTags$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/mallDynamicPage/component/business/bean/ItemTags;", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ItemTags> serializer() {
            return ItemTags$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ItemTags(int seen0, String promotionTagV2, List promotionTagNames, List marketingTagNames, List saleTypeTagNames, String typeAndLimitTagName, List itemTagNames, List recommendTagNames, List attributeTagNames, String rankAndSellPointTagNames, String blindBoxHideTypeNames, List titleTagNames, String ticketTag, List starBoxSalePoints, String exclusiveSalePoints, List otherSalePoints, List serviceTagNames, List tagsSort, List adTagNames, List serviceRightsTags, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.promotionTagV2 = null;
        } else {
            this.promotionTagV2 = promotionTagV2;
        }
        if ((seen0 & 2) == 0) {
            this.promotionTagNames = null;
        } else {
            this.promotionTagNames = promotionTagNames;
        }
        if ((seen0 & 4) == 0) {
            this.marketingTagNames = null;
        } else {
            this.marketingTagNames = marketingTagNames;
        }
        if ((seen0 & 8) == 0) {
            this.saleTypeTagNames = null;
        } else {
            this.saleTypeTagNames = saleTypeTagNames;
        }
        if ((seen0 & 16) == 0) {
            this.typeAndLimitTagName = null;
        } else {
            this.typeAndLimitTagName = typeAndLimitTagName;
        }
        if ((seen0 & 32) == 0) {
            this.itemTagNames = null;
        } else {
            this.itemTagNames = itemTagNames;
        }
        if ((seen0 & 64) == 0) {
            this.recommendTagNames = null;
        } else {
            this.recommendTagNames = recommendTagNames;
        }
        if ((seen0 & 128) == 0) {
            this.attributeTagNames = null;
        } else {
            this.attributeTagNames = attributeTagNames;
        }
        if ((seen0 & 256) == 0) {
            this.rankAndSellPointTagNames = null;
        } else {
            this.rankAndSellPointTagNames = rankAndSellPointTagNames;
        }
        if ((seen0 & 512) == 0) {
            this.blindBoxHideTypeNames = null;
        } else {
            this.blindBoxHideTypeNames = blindBoxHideTypeNames;
        }
        if ((seen0 & 1024) == 0) {
            this.titleTagNames = null;
        } else {
            this.titleTagNames = titleTagNames;
        }
        if ((seen0 & 2048) == 0) {
            this.ticketTag = null;
        } else {
            this.ticketTag = ticketTag;
        }
        if ((seen0 & 4096) == 0) {
            this.starBoxSalePoints = null;
        } else {
            this.starBoxSalePoints = starBoxSalePoints;
        }
        if ((seen0 & 8192) == 0) {
            this.exclusiveSalePoints = null;
        } else {
            this.exclusiveSalePoints = exclusiveSalePoints;
        }
        if ((seen0 & 16384) == 0) {
            this.otherSalePoints = null;
        } else {
            this.otherSalePoints = otherSalePoints;
        }
        if ((seen0 & 32768) == 0) {
            this.serviceTagNames = null;
        } else {
            this.serviceTagNames = serviceTagNames;
        }
        if ((seen0 & 65536) == 0) {
            this.tagsSort = null;
        } else {
            this.tagsSort = tagsSort;
        }
        if ((seen0 & 131072) == 0) {
            this.adTagNames = null;
        } else {
            this.adTagNames = adTagNames;
        }
        if ((seen0 & 262144) == 0) {
            this.serviceRightsTags = null;
        } else {
            this.serviceRightsTags = serviceRightsTags;
        }
    }

    public ItemTags(String promotionTagV2, List<String> list, List<String> list2, List<String> list3, String typeAndLimitTagName, List<String> list4, List<String> list5, List<String> list6, String rankAndSellPointTagNames, String blindBoxHideTypeNames, List<String> list7, String ticketTag, List<String> list8, String exclusiveSalePoints, List<String> list9, List<String> list10, List<String> list11, List<String> list12, List<String> list13) {
        this.promotionTagV2 = promotionTagV2;
        this.promotionTagNames = list;
        this.marketingTagNames = list2;
        this.saleTypeTagNames = list3;
        this.typeAndLimitTagName = typeAndLimitTagName;
        this.itemTagNames = list4;
        this.recommendTagNames = list5;
        this.attributeTagNames = list6;
        this.rankAndSellPointTagNames = rankAndSellPointTagNames;
        this.blindBoxHideTypeNames = blindBoxHideTypeNames;
        this.titleTagNames = list7;
        this.ticketTag = ticketTag;
        this.starBoxSalePoints = list8;
        this.exclusiveSalePoints = exclusiveSalePoints;
        this.otherSalePoints = list9;
        this.serviceTagNames = list10;
        this.tagsSort = list11;
        this.adTagNames = list12;
        this.serviceRightsTags = list13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$10() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$11() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$3() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$4() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$5() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$6() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$7() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$8() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$9() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$mallDynamicPage_debug(ItemTags self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.promotionTagV2 != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.promotionTagV2);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.promotionTagNames != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.promotionTagNames);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.marketingTagNames != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.marketingTagNames);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.saleTypeTagNames != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.saleTypeTagNames);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.typeAndLimitTagName != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.typeAndLimitTagName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.itemTagNames != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, (SerializationStrategy) lazyArr[5].getValue(), self.itemTagNames);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.recommendTagNames != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, (SerializationStrategy) lazyArr[6].getValue(), self.recommendTagNames);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.attributeTagNames != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, (SerializationStrategy) lazyArr[7].getValue(), self.attributeTagNames);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.rankAndSellPointTagNames != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.rankAndSellPointTagNames);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.blindBoxHideTypeNames != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.blindBoxHideTypeNames);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.titleTagNames != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, (SerializationStrategy) lazyArr[10].getValue(), self.titleTagNames);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.ticketTag != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.ticketTag);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.starBoxSalePoints != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, (SerializationStrategy) lazyArr[12].getValue(), self.starBoxSalePoints);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.exclusiveSalePoints != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.exclusiveSalePoints);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.otherSalePoints != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, (SerializationStrategy) lazyArr[14].getValue(), self.otherSalePoints);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.serviceTagNames != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, (SerializationStrategy) lazyArr[15].getValue(), self.serviceTagNames);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.tagsSort != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, (SerializationStrategy) lazyArr[16].getValue(), self.tagsSort);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.adTagNames != null) {
            output.encodeNullableSerializableElement(serialDesc, 17, (SerializationStrategy) lazyArr[17].getValue(), self.adTagNames);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 18) || self.serviceRightsTags != null) {
            output.encodeNullableSerializableElement(serialDesc, 18, (SerializationStrategy) lazyArr[18].getValue(), self.serviceRightsTags);
        }
    }

    public /* synthetic */ ItemTags(String str, List list, List list2, List list3, String str2, List list4, List list5, List list6, String str3, String str4, List list7, String str5, List list8, String str6, List list9, List list10, List list11, List list12, List list13, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : list3, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : list4, (i & 64) != 0 ? null : list5, (i & 128) != 0 ? null : list6, (i & 256) != 0 ? null : str3, (i & 512) != 0 ? null : str4, (i & 1024) != 0 ? null : list7, (i & 2048) != 0 ? null : str5, (i & 4096) != 0 ? null : list8, (i & 8192) != 0 ? null : str6, (i & 16384) != 0 ? null : list9, (i & 32768) != 0 ? null : list10, (i & 65536) != 0 ? null : list11, (i & 131072) != 0 ? null : list12, (i & 262144) != 0 ? null : list13);
    }

    public final String getPromotionTagV2() {
        return this.promotionTagV2;
    }

    public final void setPromotionTagV2(String str) {
        this.promotionTagV2 = str;
    }

    public final List<String> getPromotionTagNames() {
        return this.promotionTagNames;
    }

    public final void setPromotionTagNames(List<String> list) {
        this.promotionTagNames = list;
    }

    public final List<String> getMarketingTagNames() {
        return this.marketingTagNames;
    }

    public final void setMarketingTagNames(List<String> list) {
        this.marketingTagNames = list;
    }

    public final List<String> getSaleTypeTagNames() {
        return this.saleTypeTagNames;
    }

    public final void setSaleTypeTagNames(List<String> list) {
        this.saleTypeTagNames = list;
    }

    public final String getTypeAndLimitTagName() {
        return this.typeAndLimitTagName;
    }

    public final void setTypeAndLimitTagName(String str) {
        this.typeAndLimitTagName = str;
    }

    public final List<String> getItemTagNames() {
        return this.itemTagNames;
    }

    public final void setItemTagNames(List<String> list) {
        this.itemTagNames = list;
    }

    public final List<String> getRecommendTagNames() {
        return this.recommendTagNames;
    }

    public final void setRecommendTagNames(List<String> list) {
        this.recommendTagNames = list;
    }

    public final List<String> getAttributeTagNames() {
        return this.attributeTagNames;
    }

    public final void setAttributeTagNames(List<String> list) {
        this.attributeTagNames = list;
    }

    public final String getRankAndSellPointTagNames() {
        return this.rankAndSellPointTagNames;
    }

    public final void setRankAndSellPointTagNames(String str) {
        this.rankAndSellPointTagNames = str;
    }

    public final String getBlindBoxHideTypeNames() {
        return this.blindBoxHideTypeNames;
    }

    public final void setBlindBoxHideTypeNames(String str) {
        this.blindBoxHideTypeNames = str;
    }

    public final List<String> getTitleTagNames() {
        return this.titleTagNames;
    }

    public final void setTitleTagNames(List<String> list) {
        this.titleTagNames = list;
    }

    public final String getTicketTag() {
        return this.ticketTag;
    }

    public final void setTicketTag(String str) {
        this.ticketTag = str;
    }

    public final List<String> getStarBoxSalePoints() {
        return this.starBoxSalePoints;
    }

    public final void setStarBoxSalePoints(List<String> list) {
        this.starBoxSalePoints = list;
    }

    public final String getExclusiveSalePoints() {
        return this.exclusiveSalePoints;
    }

    public final void setExclusiveSalePoints(String str) {
        this.exclusiveSalePoints = str;
    }

    public final List<String> getOtherSalePoints() {
        return this.otherSalePoints;
    }

    public final void setOtherSalePoints(List<String> list) {
        this.otherSalePoints = list;
    }

    public final List<String> getServiceTagNames() {
        return this.serviceTagNames;
    }

    public final void setServiceTagNames(List<String> list) {
        this.serviceTagNames = list;
    }

    public final List<String> getTagsSort() {
        return this.tagsSort;
    }

    public final void setTagsSort(List<String> list) {
        this.tagsSort = list;
    }

    public final List<String> getAdTagNames() {
        return this.adTagNames;
    }

    public final void setAdTagNames(List<String> list) {
        this.adTagNames = list;
    }

    public final List<String> getServiceRightsTags() {
        return this.serviceRightsTags;
    }

    public final void setServiceRightsTags(List<String> list) {
        this.serviceRightsTags = list;
    }
}