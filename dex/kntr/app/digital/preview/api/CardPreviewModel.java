package kntr.app.digital.preview.api;

import BottomSheetItemData$;
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
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;

/* compiled from: CardPreviewModel.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 =2\u00020\u0001:\u0002<=BQ\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010Ba\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000f\u0010\u0014J\u0006\u0010'\u001a\u00020\u000bJ\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\t\u0010-\u001a\u00020\u000bHÆ\u0003J\t\u0010.\u001a\u00020\u000eHÆ\u0003JU\u0010/\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u00100\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u000eHÖ\u0001J\t\u00103\u001a\u00020\u000bHÖ\u0001J%\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0001¢\u0006\u0002\b;R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010!R\u001c\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010!R\u001c\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010&¨\u0006>"}, d2 = {"Lkntr/app/digital/preview/api/CardPreviewModel;", RoomRecommendViewModel.EMPTY_CURSOR, "result", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/preview/api/ResultItem;", "extra", "Lkotlinx/serialization/json/JsonElement;", "frontHasMore", RoomRecommendViewModel.EMPTY_CURSOR, "backHasMore", "backAnchorId", RoomRecommendViewModel.EMPTY_CURSOR, "frontAnchorId", "activityStatus", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/util/List;Lkotlinx/serialization/json/JsonElement;ZZLjava/lang/String;Ljava/lang/String;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/json/JsonElement;ZZLjava/lang/String;Ljava/lang/String;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getResult", "()Ljava/util/List;", "getExtra", "()Lkotlinx/serialization/json/JsonElement;", "getFrontHasMore$annotations", "()V", "getFrontHasMore", "()Z", "getBackHasMore$annotations", "getBackHasMore", "getBackAnchorId$annotations", "getBackAnchorId", "()Ljava/lang/String;", "getFrontAnchorId$annotations", "getFrontAnchorId", "getActivityStatus$annotations", "getActivityStatus", "()I", "extraJsonString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class CardPreviewModel {
    private final int activityStatus;
    private final String backAnchorId;
    private final boolean backHasMore;
    private final JsonElement extra;
    private final String frontAnchorId;
    private final boolean frontHasMore;
    private final List<ResultItem> result;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.digital.preview.api.CardPreviewModel$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = CardPreviewModel._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, null, null, null};

    public static /* synthetic */ CardPreviewModel copy$default(CardPreviewModel cardPreviewModel, List list, JsonElement jsonElement, boolean z, boolean z2, String str, String str2, int i, int i2, Object obj) {
        List<ResultItem> list2 = list;
        if ((i2 & 1) != 0) {
            list2 = cardPreviewModel.result;
        }
        if ((i2 & 2) != 0) {
            jsonElement = cardPreviewModel.extra;
        }
        JsonElement jsonElement2 = jsonElement;
        if ((i2 & 4) != 0) {
            z = cardPreviewModel.frontHasMore;
        }
        boolean z3 = z;
        if ((i2 & 8) != 0) {
            z2 = cardPreviewModel.backHasMore;
        }
        boolean z4 = z2;
        if ((i2 & 16) != 0) {
            str = cardPreviewModel.backAnchorId;
        }
        String str3 = str;
        if ((i2 & 32) != 0) {
            str2 = cardPreviewModel.frontAnchorId;
        }
        String str4 = str2;
        if ((i2 & 64) != 0) {
            i = cardPreviewModel.activityStatus;
        }
        return cardPreviewModel.copy(list2, jsonElement2, z3, z4, str3, str4, i);
    }

    @SerialName("permanent_activity_status")
    public static /* synthetic */ void getActivityStatus$annotations() {
    }

    @SerialName("back_anchor_id")
    public static /* synthetic */ void getBackAnchorId$annotations() {
    }

    @SerialName("back_has_more")
    public static /* synthetic */ void getBackHasMore$annotations() {
    }

    @SerialName("front_anchor_id")
    public static /* synthetic */ void getFrontAnchorId$annotations() {
    }

    @SerialName("front_has_more")
    public static /* synthetic */ void getFrontHasMore$annotations() {
    }

    public final List<ResultItem> component1() {
        return this.result;
    }

    public final JsonElement component2() {
        return this.extra;
    }

    public final boolean component3() {
        return this.frontHasMore;
    }

    public final boolean component4() {
        return this.backHasMore;
    }

    public final String component5() {
        return this.backAnchorId;
    }

    public final String component6() {
        return this.frontAnchorId;
    }

    public final int component7() {
        return this.activityStatus;
    }

    public final CardPreviewModel copy(List<? extends ResultItem> list, JsonElement jsonElement, boolean z, boolean z2, String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(list, "result");
        Intrinsics.checkNotNullParameter(jsonElement, "extra");
        Intrinsics.checkNotNullParameter(str, "backAnchorId");
        Intrinsics.checkNotNullParameter(str2, "frontAnchorId");
        return new CardPreviewModel(list, jsonElement, z, z2, str, str2, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CardPreviewModel) {
            CardPreviewModel cardPreviewModel = (CardPreviewModel) obj;
            return Intrinsics.areEqual(this.result, cardPreviewModel.result) && Intrinsics.areEqual(this.extra, cardPreviewModel.extra) && this.frontHasMore == cardPreviewModel.frontHasMore && this.backHasMore == cardPreviewModel.backHasMore && Intrinsics.areEqual(this.backAnchorId, cardPreviewModel.backAnchorId) && Intrinsics.areEqual(this.frontAnchorId, cardPreviewModel.frontAnchorId) && this.activityStatus == cardPreviewModel.activityStatus;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.result.hashCode() * 31) + this.extra.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.frontHasMore)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.backHasMore)) * 31) + this.backAnchorId.hashCode()) * 31) + this.frontAnchorId.hashCode()) * 31) + this.activityStatus;
    }

    public String toString() {
        List<ResultItem> list = this.result;
        JsonElement jsonElement = this.extra;
        boolean z = this.frontHasMore;
        boolean z2 = this.backHasMore;
        String str = this.backAnchorId;
        String str2 = this.frontAnchorId;
        return "CardPreviewModel(result=" + list + ", extra=" + jsonElement + ", frontHasMore=" + z + ", backHasMore=" + z2 + ", backAnchorId=" + str + ", frontAnchorId=" + str2 + ", activityStatus=" + this.activityStatus + ")";
    }

    /* compiled from: CardPreviewModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/api/CardPreviewModel$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/api/CardPreviewModel;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CardPreviewModel> serializer() {
            return CardPreviewModel$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ CardPreviewModel(int seen0, List result, JsonElement extra, boolean frontHasMore, boolean backHasMore, String backAnchorId, String frontAnchorId, int activityStatus, SerializationConstructorMarker serializationConstructorMarker) {
        if (2 != (seen0 & 2)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 2, CardPreviewModel$$serializer.INSTANCE.getDescriptor());
        }
        if ((seen0 & 1) == 0) {
            this.result = CollectionsKt.emptyList();
        } else {
            this.result = result;
        }
        this.extra = extra;
        if ((seen0 & 4) == 0) {
            this.frontHasMore = false;
        } else {
            this.frontHasMore = frontHasMore;
        }
        if ((seen0 & 8) == 0) {
            this.backHasMore = false;
        } else {
            this.backHasMore = backHasMore;
        }
        if ((seen0 & 16) == 0) {
            this.backAnchorId = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.backAnchorId = backAnchorId;
        }
        if ((seen0 & 32) == 0) {
            this.frontAnchorId = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.frontAnchorId = frontAnchorId;
        }
        if ((seen0 & 64) == 0) {
            this.activityStatus = 0;
        } else {
            this.activityStatus = activityStatus;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CardPreviewModel(List<? extends ResultItem> list, JsonElement extra, boolean frontHasMore, boolean backHasMore, String backAnchorId, String frontAnchorId, int activityStatus) {
        Intrinsics.checkNotNullParameter(list, "result");
        Intrinsics.checkNotNullParameter(extra, "extra");
        Intrinsics.checkNotNullParameter(backAnchorId, "backAnchorId");
        Intrinsics.checkNotNullParameter(frontAnchorId, "frontAnchorId");
        this.result = list;
        this.extra = extra;
        this.frontHasMore = frontHasMore;
        this.backHasMore = backHasMore;
        this.backAnchorId = backAnchorId;
        this.frontAnchorId = frontAnchorId;
        this.activityStatus = activityStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(ResultItem.Companion.serializer());
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$preview_debug(CardPreviewModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.result, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy) lazyArr[0].getValue(), self.result);
        }
        output.encodeSerializableElement(serialDesc, 1, JsonElementSerializer.INSTANCE, self.extra);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.frontHasMore) {
            output.encodeBooleanElement(serialDesc, 2, self.frontHasMore);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.backHasMore) {
            output.encodeBooleanElement(serialDesc, 3, self.backHasMore);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.backAnchorId, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 4, self.backAnchorId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.frontAnchorId, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 5, self.frontAnchorId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.activityStatus != 0) {
            output.encodeIntElement(serialDesc, 6, self.activityStatus);
        }
    }

    public /* synthetic */ CardPreviewModel(List list, JsonElement jsonElement, boolean z, boolean z2, String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? CollectionsKt.emptyList() : list, jsonElement, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i2 & 32) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i2 & 64) != 0 ? 0 : i);
    }

    public final List<ResultItem> getResult() {
        return this.result;
    }

    public final JsonElement getExtra() {
        return this.extra;
    }

    public final boolean getFrontHasMore() {
        return this.frontHasMore;
    }

    public final boolean getBackHasMore() {
        return this.backHasMore;
    }

    public final String getBackAnchorId() {
        return this.backAnchorId;
    }

    public final String getFrontAnchorId() {
        return this.frontAnchorId;
    }

    public final int getActivityStatus() {
        return this.activityStatus;
    }

    public final String extraJsonString() {
        return Json.Default.encodeToString(JsonElement.Companion.serializer(), this.extra);
    }
}