package kntr.app.mall.product.details.page.api.model;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
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
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: AttrFloor.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 82\u00020\u0001:\u000278Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eBg\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nHÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0019Jh\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\bHÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001d\u0010\u0019R\u0015\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\u001f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b \u0010\u0014¨\u00069"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/AttrListItem;", "", "attrName", "", "attrValue", "Lkotlinx/serialization/json/JsonElement;", "attrGroupName", "attrId", "", "attrValueIds", "", "groupAttrScore", "groupScore", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAttrName", "()Ljava/lang/String;", "getAttrValue", "()Lkotlinx/serialization/json/JsonElement;", "getAttrGroupName", "getAttrId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAttrValueIds", "()Ljava/util/List;", "getGroupAttrScore", "getGroupScore", "display", "getDisplay", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lkntr/app/mall/product/details/page/api/model/AttrListItem;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$product_details_page_debug", "$serializer", "Companion", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class AttrListItem {
    private final String attrGroupName;
    private final Integer attrId;
    private final String attrName;
    private final JsonElement attrValue;
    private final List<Integer> attrValueIds;
    private final Integer groupAttrScore;
    private final Integer groupScore;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.mall.product.details.page.api.model.AttrListItem$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AttrListItem._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null};

    public AttrListItem() {
        this((String) null, (JsonElement) null, (String) null, (Integer) null, (List) null, (Integer) null, (Integer) null, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AttrListItem copy$default(AttrListItem attrListItem, String str, JsonElement jsonElement, String str2, Integer num, List list, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = attrListItem.attrName;
        }
        if ((i & 2) != 0) {
            jsonElement = attrListItem.attrValue;
        }
        JsonElement jsonElement2 = jsonElement;
        if ((i & 4) != 0) {
            str2 = attrListItem.attrGroupName;
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            num = attrListItem.attrId;
        }
        Integer num4 = num;
        List<Integer> list2 = list;
        if ((i & 16) != 0) {
            list2 = attrListItem.attrValueIds;
        }
        List list3 = list2;
        if ((i & 32) != 0) {
            num2 = attrListItem.groupAttrScore;
        }
        Integer num5 = num2;
        if ((i & 64) != 0) {
            num3 = attrListItem.groupScore;
        }
        return attrListItem.copy(str, jsonElement2, str3, num4, list3, num5, num3);
    }

    public final String component1() {
        return this.attrName;
    }

    public final JsonElement component2() {
        return this.attrValue;
    }

    public final String component3() {
        return this.attrGroupName;
    }

    public final Integer component4() {
        return this.attrId;
    }

    public final List<Integer> component5() {
        return this.attrValueIds;
    }

    public final Integer component6() {
        return this.groupAttrScore;
    }

    public final Integer component7() {
        return this.groupScore;
    }

    public final AttrListItem copy(String str, JsonElement jsonElement, String str2, Integer num, List<Integer> list, Integer num2, Integer num3) {
        return new AttrListItem(str, jsonElement, str2, num, list, num2, num3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AttrListItem) {
            AttrListItem attrListItem = (AttrListItem) obj;
            return Intrinsics.areEqual(this.attrName, attrListItem.attrName) && Intrinsics.areEqual(this.attrValue, attrListItem.attrValue) && Intrinsics.areEqual(this.attrGroupName, attrListItem.attrGroupName) && Intrinsics.areEqual(this.attrId, attrListItem.attrId) && Intrinsics.areEqual(this.attrValueIds, attrListItem.attrValueIds) && Intrinsics.areEqual(this.groupAttrScore, attrListItem.groupAttrScore) && Intrinsics.areEqual(this.groupScore, attrListItem.groupScore);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((this.attrName == null ? 0 : this.attrName.hashCode()) * 31) + (this.attrValue == null ? 0 : this.attrValue.hashCode())) * 31) + (this.attrGroupName == null ? 0 : this.attrGroupName.hashCode())) * 31) + (this.attrId == null ? 0 : this.attrId.hashCode())) * 31) + (this.attrValueIds == null ? 0 : this.attrValueIds.hashCode())) * 31) + (this.groupAttrScore == null ? 0 : this.groupAttrScore.hashCode())) * 31) + (this.groupScore != null ? this.groupScore.hashCode() : 0);
    }

    public String toString() {
        String str = this.attrName;
        JsonElement jsonElement = this.attrValue;
        String str2 = this.attrGroupName;
        Integer num = this.attrId;
        List<Integer> list = this.attrValueIds;
        Integer num2 = this.groupAttrScore;
        return "AttrListItem(attrName=" + str + ", attrValue=" + jsonElement + ", attrGroupName=" + str2 + ", attrId=" + num + ", attrValueIds=" + list + ", groupAttrScore=" + num2 + ", groupScore=" + this.groupScore + ")";
    }

    /* compiled from: AttrFloor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/mall/product/details/page/api/model/AttrListItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/mall/product/details/page/api/model/AttrListItem;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AttrListItem> serializer() {
            return AttrListItem$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AttrListItem(int seen0, String attrName, JsonElement attrValue, String attrGroupName, Integer attrId, List attrValueIds, Integer groupAttrScore, Integer groupScore, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.attrName = null;
        } else {
            this.attrName = attrName;
        }
        if ((seen0 & 2) == 0) {
            this.attrValue = null;
        } else {
            this.attrValue = attrValue;
        }
        if ((seen0 & 4) == 0) {
            this.attrGroupName = null;
        } else {
            this.attrGroupName = attrGroupName;
        }
        if ((seen0 & 8) == 0) {
            this.attrId = null;
        } else {
            this.attrId = attrId;
        }
        if ((seen0 & 16) == 0) {
            this.attrValueIds = null;
        } else {
            this.attrValueIds = attrValueIds;
        }
        if ((seen0 & 32) == 0) {
            this.groupAttrScore = null;
        } else {
            this.groupAttrScore = groupAttrScore;
        }
        if ((seen0 & 64) == 0) {
            this.groupScore = null;
        } else {
            this.groupScore = groupScore;
        }
    }

    public AttrListItem(String attrName, JsonElement attrValue, String attrGroupName, Integer attrId, List<Integer> list, Integer groupAttrScore, Integer groupScore) {
        this.attrName = attrName;
        this.attrValue = attrValue;
        this.attrGroupName = attrGroupName;
        this.attrId = attrId;
        this.attrValueIds = list;
        this.groupAttrScore = groupAttrScore;
        this.groupScore = groupScore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(IntSerializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$product_details_page_debug(AttrListItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.attrName != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.attrName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.attrValue != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, JsonElementSerializer.INSTANCE, self.attrValue);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.attrGroupName != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.attrGroupName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.attrId != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.attrId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.attrValueIds != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.attrValueIds);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.groupAttrScore != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, IntSerializer.INSTANCE, self.groupAttrScore);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.groupScore != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, IntSerializer.INSTANCE, self.groupScore);
        }
    }

    public /* synthetic */ AttrListItem(String str, JsonElement jsonElement, String str2, Integer num, List list, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : jsonElement, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : list, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : num3);
    }

    public final String getAttrName() {
        return this.attrName;
    }

    public final JsonElement getAttrValue() {
        return this.attrValue;
    }

    public final String getAttrGroupName() {
        return this.attrGroupName;
    }

    public final Integer getAttrId() {
        return this.attrId;
    }

    public final List<Integer> getAttrValueIds() {
        return this.attrValueIds;
    }

    public final Integer getGroupAttrScore() {
        return this.groupAttrScore;
    }

    public final Integer getGroupScore() {
        return this.groupScore;
    }

    public final String getDisplay() {
        JsonPrimitive jsonPrimitive;
        if (this.attrValue == null || (this.attrValue instanceof JsonNull)) {
            return "--";
        }
        if ((this.attrValue instanceof JsonPrimitive) && this.attrValue.isString()) {
            return this.attrValue.getContent();
        }
        if ((this.attrValue instanceof JsonPrimitive) && JsonElementKt.getBooleanOrNull(this.attrValue) != null) {
            return JsonElementKt.getBoolean(this.attrValue) ? "Yes" : "No";
        } else if (this.attrValue instanceof JsonArray) {
            JsonElement jsonElement = (JsonElement) CollectionsKt.firstOrNull(this.attrValue);
            boolean z = false;
            if (jsonElement != null && (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement)) != null && jsonPrimitive.isString()) {
                z = true;
            }
            return z ? JsonElementKt.getJsonPrimitive((JsonElement) CollectionsKt.first(this.attrValue)).getContent() : "--";
        } else {
            return "--";
        }
    }
}