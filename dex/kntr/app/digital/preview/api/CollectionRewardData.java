package kntr.app.digital.preview.api;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kntr.app.ad.ad.biz.search.AdSearchSubCardType;
import kntr.app.digital.preview.api.CollectionRewardData;
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
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: CardPreviewModel.kt */
@SerialName(AdSearchSubCardType.CARD_TYPE_2)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\b\u0018\u0000 %2\u00020\u0001:\u0003#$%B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\tHÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001¢\u0006\u0002\b\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0004\u0010\u0011¨\u0006&"}, d2 = {"Lkntr/app/digital/preview/api/CollectionRewardData;", "Lkntr/app/digital/preview/api/ResultItem;", "data", "Lkntr/app/digital/preview/api/CollectionRewardData$Data;", "isAnchorItem", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/digital/preview/api/CollectionRewardData$Data;Z)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/digital/preview/api/CollectionRewardData$Data;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getData", "()Lkntr/app/digital/preview/api/CollectionRewardData$Data;", "isAnchorItem$annotations", "()V", "()Z", "component1", "component2", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "Data", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class CollectionRewardData implements ResultItem {
    private final Data data;
    private final boolean isAnchorItem;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ CollectionRewardData copy$default(CollectionRewardData collectionRewardData, Data data, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            data = collectionRewardData.data;
        }
        if ((i & 2) != 0) {
            z = collectionRewardData.isAnchorItem;
        }
        return collectionRewardData.copy(data, z);
    }

    @SerialName("is_anchor_item")
    public static /* synthetic */ void isAnchorItem$annotations() {
    }

    public final Data component1() {
        return this.data;
    }

    public final boolean component2() {
        return this.isAnchorItem;
    }

    public final CollectionRewardData copy(Data data, boolean z) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new CollectionRewardData(data, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CollectionRewardData) {
            CollectionRewardData collectionRewardData = (CollectionRewardData) obj;
            return Intrinsics.areEqual(this.data, collectionRewardData.data) && this.isAnchorItem == collectionRewardData.isAnchorItem;
        }
        return false;
    }

    public int hashCode() {
        return (this.data.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isAnchorItem);
    }

    public String toString() {
        Data data = this.data;
        return "CollectionRewardData(data=" + data + ", isAnchorItem=" + this.isAnchorItem + ")";
    }

    /* compiled from: CardPreviewModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/api/CollectionRewardData$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/api/CollectionRewardData;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CollectionRewardData> serializer() {
            return CollectionRewardData$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ CollectionRewardData(int seen0, Data data, boolean isAnchorItem, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, CollectionRewardData$$serializer.INSTANCE.getDescriptor());
        }
        this.data = data;
        if ((seen0 & 2) == 0) {
            this.isAnchorItem = false;
        } else {
            this.isAnchorItem = isAnchorItem;
        }
    }

    public CollectionRewardData(Data data, boolean isAnchorItem) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.isAnchorItem = isAnchorItem;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$preview_debug(CollectionRewardData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, CollectionRewardData$Data$$serializer.INSTANCE, self.data);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.isAnchorItem()) {
            output.encodeBooleanElement(serialDesc, 1, self.isAnchorItem());
        }
    }

    public /* synthetic */ CollectionRewardData(Data data, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(data, (i & 2) != 0 ? false : z);
    }

    public final Data getData() {
        return this.data;
    }

    /* compiled from: CardPreviewModel.kt */
    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 `2\u00020\u0001:\u0002_`B¿\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001a\u0010\u001bB½\u0001\b\u0010\u0012\u0006\u0010\u001c\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000e\u0012\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000e\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001a\u0010\u001fJ\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0005HÆ\u0003J\t\u0010E\u001a\u00020\u0007HÆ\u0003J\t\u0010F\u001a\u00020\tHÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\u0011\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0011\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000eHÆ\u0003J\u0011\u0010O\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000eHÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÁ\u0001\u0010R\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000e2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010S\u001a\u00020\u00072\b\u0010T\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010U\u001a\u00020\tHÖ\u0001J\t\u0010V\u001a\u00020\u0003HÖ\u0001J%\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]H\u0001¢\u0006\u0002\b^R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010!\u001a\u0004\b%\u0010&R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010!\u001a\u0004\b*\u0010+R\u001c\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010!\u001a\u0004\b-\u0010#R\u001c\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010!\u001a\u0004\b/\u0010#R\u001c\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010!\u001a\u0004\b1\u0010#R$\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010!\u001a\u0004\b3\u00104R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010!\u001a\u0004\b6\u0010#R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b7\u0010!\u001a\u0004\b8\u00109R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010!\u001a\u0004\b;\u0010<R\u0019\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u00104R\u0019\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b>\u00104R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b?\u0010!\u001a\u0004\b@\u0010#R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bA\u0010!\u001a\u0004\bB\u0010#¨\u0006a"}, d2 = {"Lkntr/app/digital/preview/api/CollectionRewardData$Data;", RoomRecommendViewModel.EMPTY_CURSOR, "uniqueId", RoomRecommendViewModel.EMPTY_CURSOR, "collectionId", RoomRecommendViewModel.EMPTY_CURSOR, "highlighted", RoomRecommendViewModel.EMPTY_CURSOR, "redeemItemType", RoomRecommendViewModel.EMPTY_CURSOR, "redeemItemId", "redeemItemName", "redeemItemImage", "redeemItemVideo", RoomRecommendViewModel.EMPTY_CURSOR, "cardVideoDownload", "descTag", "Lkntr/app/digital/preview/api/DescTag;", "topText", "Lkntr/app/digital/preview/api/TopText;", "actions", "Lkntr/app/digital/preview/api/ActionItem;", "modules", "Lkntr/app/digital/preview/api/ModuleItem;", "holdingRate", "holdingRateUrl", "<init>", "(Ljava/lang/String;JZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lkntr/app/digital/preview/api/DescTag;Lkntr/app/digital/preview/api/TopText;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lkntr/app/digital/preview/api/DescTag;Lkntr/app/digital/preview/api/TopText;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUniqueId$annotations", "()V", "getUniqueId", "()Ljava/lang/String;", "getCollectionId$annotations", "getCollectionId", "()J", "getHighlighted", "()Z", "getRedeemItemType$annotations", "getRedeemItemType", "()I", "getRedeemItemId$annotations", "getRedeemItemId", "getRedeemItemName$annotations", "getRedeemItemName", "getRedeemItemImage$annotations", "getRedeemItemImage", "getRedeemItemVideo$annotations", "getRedeemItemVideo", "()Ljava/util/List;", "getCardVideoDownload$annotations", "getCardVideoDownload", "getDescTag$annotations", "getDescTag", "()Lkntr/app/digital/preview/api/DescTag;", "getTopText$annotations", "getTopText", "()Lkntr/app/digital/preview/api/TopText;", "getActions", "getModules", "getHoldingRate$annotations", "getHoldingRate", "getHoldingRateUrl$annotations", "getHoldingRateUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Data {
        private final List<ActionItem> actions;
        private final String cardVideoDownload;
        private final long collectionId;
        private final DescTag descTag;
        private final boolean highlighted;
        private final String holdingRate;
        private final String holdingRateUrl;
        private final List<ModuleItem> modules;
        private final String redeemItemId;
        private final String redeemItemImage;
        private final String redeemItemName;
        private final int redeemItemType;
        private final List<String> redeemItemVideo;
        private final TopText topText;
        private final String uniqueId;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.digital.preview.api.CollectionRewardData$Data$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = CollectionRewardData.Data._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        }), null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.digital.preview.api.CollectionRewardData$Data$$ExternalSyntheticLambda1
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$0;
                _childSerializers$_anonymous_$0 = CollectionRewardData.Data._childSerializers$_anonymous_$0();
                return _childSerializers$_anonymous_$0;
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.digital.preview.api.CollectionRewardData$Data$$ExternalSyntheticLambda2
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$1;
                _childSerializers$_anonymous_$1 = CollectionRewardData.Data._childSerializers$_anonymous_$1();
                return _childSerializers$_anonymous_$1;
            }
        }), null, null};

        public Data() {
            this((String) null, 0L, false, 0, (String) null, (String) null, (String) null, (List) null, (String) null, (DescTag) null, (TopText) null, (List) null, (List) null, (String) null, (String) null, 32767, (DefaultConstructorMarker) null);
        }

        @SerialName("card_video_download")
        public static /* synthetic */ void getCardVideoDownload$annotations() {
        }

        @SerialName("collect_id")
        public static /* synthetic */ void getCollectionId$annotations() {
        }

        @SerialName("desc_tag")
        public static /* synthetic */ void getDescTag$annotations() {
        }

        @SerialName("holding_rate")
        public static /* synthetic */ void getHoldingRate$annotations() {
        }

        @SerialName("holding_rate_url")
        public static /* synthetic */ void getHoldingRateUrl$annotations() {
        }

        @SerialName("redeem_item_id")
        public static /* synthetic */ void getRedeemItemId$annotations() {
        }

        @SerialName("redeem_item_image")
        public static /* synthetic */ void getRedeemItemImage$annotations() {
        }

        @SerialName("redeem_item_name")
        public static /* synthetic */ void getRedeemItemName$annotations() {
        }

        @SerialName("redeem_item_type")
        public static /* synthetic */ void getRedeemItemType$annotations() {
        }

        @SerialName("redeem_item_video")
        public static /* synthetic */ void getRedeemItemVideo$annotations() {
        }

        @SerialName("top_text")
        public static /* synthetic */ void getTopText$annotations() {
        }

        @SerialName("unique_id")
        public static /* synthetic */ void getUniqueId$annotations() {
        }

        public final String component1() {
            return this.uniqueId;
        }

        public final DescTag component10() {
            return this.descTag;
        }

        public final TopText component11() {
            return this.topText;
        }

        public final List<ActionItem> component12() {
            return this.actions;
        }

        public final List<ModuleItem> component13() {
            return this.modules;
        }

        public final String component14() {
            return this.holdingRate;
        }

        public final String component15() {
            return this.holdingRateUrl;
        }

        public final long component2() {
            return this.collectionId;
        }

        public final boolean component3() {
            return this.highlighted;
        }

        public final int component4() {
            return this.redeemItemType;
        }

        public final String component5() {
            return this.redeemItemId;
        }

        public final String component6() {
            return this.redeemItemName;
        }

        public final String component7() {
            return this.redeemItemImage;
        }

        public final List<String> component8() {
            return this.redeemItemVideo;
        }

        public final String component9() {
            return this.cardVideoDownload;
        }

        public final Data copy(String str, long j2, boolean z, int i, String str2, String str3, String str4, List<String> list, String str5, DescTag descTag, TopText topText, List<? extends ActionItem> list2, List<? extends ModuleItem> list3, String str6, String str7) {
            Intrinsics.checkNotNullParameter(str, "uniqueId");
            Intrinsics.checkNotNullParameter(str2, "redeemItemId");
            Intrinsics.checkNotNullParameter(str3, "redeemItemName");
            Intrinsics.checkNotNullParameter(str4, "redeemItemImage");
            return new Data(str, j2, z, i, str2, str3, str4, list, str5, descTag, topText, list2, list3, str6, str7);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Data) {
                Data data = (Data) obj;
                return Intrinsics.areEqual(this.uniqueId, data.uniqueId) && this.collectionId == data.collectionId && this.highlighted == data.highlighted && this.redeemItemType == data.redeemItemType && Intrinsics.areEqual(this.redeemItemId, data.redeemItemId) && Intrinsics.areEqual(this.redeemItemName, data.redeemItemName) && Intrinsics.areEqual(this.redeemItemImage, data.redeemItemImage) && Intrinsics.areEqual(this.redeemItemVideo, data.redeemItemVideo) && Intrinsics.areEqual(this.cardVideoDownload, data.cardVideoDownload) && Intrinsics.areEqual(this.descTag, data.descTag) && Intrinsics.areEqual(this.topText, data.topText) && Intrinsics.areEqual(this.actions, data.actions) && Intrinsics.areEqual(this.modules, data.modules) && Intrinsics.areEqual(this.holdingRate, data.holdingRate) && Intrinsics.areEqual(this.holdingRateUrl, data.holdingRateUrl);
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((this.uniqueId.hashCode() * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.collectionId)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.highlighted)) * 31) + this.redeemItemType) * 31) + this.redeemItemId.hashCode()) * 31) + this.redeemItemName.hashCode()) * 31) + this.redeemItemImage.hashCode()) * 31) + (this.redeemItemVideo == null ? 0 : this.redeemItemVideo.hashCode())) * 31) + (this.cardVideoDownload == null ? 0 : this.cardVideoDownload.hashCode())) * 31) + (this.descTag == null ? 0 : this.descTag.hashCode())) * 31) + (this.topText == null ? 0 : this.topText.hashCode())) * 31) + (this.actions == null ? 0 : this.actions.hashCode())) * 31) + (this.modules == null ? 0 : this.modules.hashCode())) * 31) + (this.holdingRate == null ? 0 : this.holdingRate.hashCode())) * 31) + (this.holdingRateUrl != null ? this.holdingRateUrl.hashCode() : 0);
        }

        public String toString() {
            String str = this.uniqueId;
            long j2 = this.collectionId;
            boolean z = this.highlighted;
            int i = this.redeemItemType;
            String str2 = this.redeemItemId;
            String str3 = this.redeemItemName;
            String str4 = this.redeemItemImage;
            List<String> list = this.redeemItemVideo;
            String str5 = this.cardVideoDownload;
            DescTag descTag = this.descTag;
            TopText topText = this.topText;
            List<ActionItem> list2 = this.actions;
            List<ModuleItem> list3 = this.modules;
            String str6 = this.holdingRate;
            return "Data(uniqueId=" + str + ", collectionId=" + j2 + ", highlighted=" + z + ", redeemItemType=" + i + ", redeemItemId=" + str2 + ", redeemItemName=" + str3 + ", redeemItemImage=" + str4 + ", redeemItemVideo=" + list + ", cardVideoDownload=" + str5 + ", descTag=" + descTag + ", topText=" + topText + ", actions=" + list2 + ", modules=" + list3 + ", holdingRate=" + str6 + ", holdingRateUrl=" + this.holdingRateUrl + ")";
        }

        /* compiled from: CardPreviewModel.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/api/CollectionRewardData$Data$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/api/CollectionRewardData$Data;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Data> serializer() {
                return CollectionRewardData$Data$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Data(int seen0, String uniqueId, long collectionId, boolean highlighted, int redeemItemType, String redeemItemId, String redeemItemName, String redeemItemImage, List redeemItemVideo, String cardVideoDownload, DescTag descTag, TopText topText, List actions, List modules, String holdingRate, String holdingRateUrl, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.uniqueId = RoomRecommendViewModel.EMPTY_CURSOR;
            } else {
                this.uniqueId = uniqueId;
            }
            if ((seen0 & 2) == 0) {
                this.collectionId = 0L;
            } else {
                this.collectionId = collectionId;
            }
            if ((seen0 & 4) == 0) {
                this.highlighted = false;
            } else {
                this.highlighted = highlighted;
            }
            if ((seen0 & 8) == 0) {
                this.redeemItemType = 0;
            } else {
                this.redeemItemType = redeemItemType;
            }
            if ((seen0 & 16) == 0) {
                this.redeemItemId = RoomRecommendViewModel.EMPTY_CURSOR;
            } else {
                this.redeemItemId = redeemItemId;
            }
            if ((seen0 & 32) == 0) {
                this.redeemItemName = RoomRecommendViewModel.EMPTY_CURSOR;
            } else {
                this.redeemItemName = redeemItemName;
            }
            if ((seen0 & 64) == 0) {
                this.redeemItemImage = RoomRecommendViewModel.EMPTY_CURSOR;
            } else {
                this.redeemItemImage = redeemItemImage;
            }
            if ((seen0 & 128) == 0) {
                this.redeemItemVideo = null;
            } else {
                this.redeemItemVideo = redeemItemVideo;
            }
            if ((seen0 & 256) == 0) {
                this.cardVideoDownload = null;
            } else {
                this.cardVideoDownload = cardVideoDownload;
            }
            if ((seen0 & 512) == 0) {
                this.descTag = null;
            } else {
                this.descTag = descTag;
            }
            if ((seen0 & 1024) == 0) {
                this.topText = null;
            } else {
                this.topText = topText;
            }
            if ((seen0 & 2048) == 0) {
                this.actions = null;
            } else {
                this.actions = actions;
            }
            if ((seen0 & 4096) == 0) {
                this.modules = null;
            } else {
                this.modules = modules;
            }
            if ((seen0 & 8192) == 0) {
                this.holdingRate = null;
            } else {
                this.holdingRate = holdingRate;
            }
            if ((seen0 & 16384) == 0) {
                this.holdingRateUrl = null;
            } else {
                this.holdingRateUrl = holdingRateUrl;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Data(String uniqueId, long collectionId, boolean highlighted, int redeemItemType, String redeemItemId, String redeemItemName, String redeemItemImage, List<String> list, String cardVideoDownload, DescTag descTag, TopText topText, List<? extends ActionItem> list2, List<? extends ModuleItem> list3, String holdingRate, String holdingRateUrl) {
            Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
            Intrinsics.checkNotNullParameter(redeemItemId, "redeemItemId");
            Intrinsics.checkNotNullParameter(redeemItemName, "redeemItemName");
            Intrinsics.checkNotNullParameter(redeemItemImage, "redeemItemImage");
            this.uniqueId = uniqueId;
            this.collectionId = collectionId;
            this.highlighted = highlighted;
            this.redeemItemType = redeemItemType;
            this.redeemItemId = redeemItemId;
            this.redeemItemName = redeemItemName;
            this.redeemItemImage = redeemItemImage;
            this.redeemItemVideo = list;
            this.cardVideoDownload = cardVideoDownload;
            this.descTag = descTag;
            this.topText = topText;
            this.actions = list2;
            this.modules = list3;
            this.holdingRate = holdingRate;
            this.holdingRateUrl = holdingRateUrl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
            return new ArrayListSerializer(ActionItem.Companion.serializer());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
            return new ArrayListSerializer(ModuleItem.Companion.serializer());
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$preview_debug(Data self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.uniqueId, RoomRecommendViewModel.EMPTY_CURSOR)) {
                output.encodeStringElement(serialDesc, 0, self.uniqueId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.collectionId != 0) {
                output.encodeLongElement(serialDesc, 1, self.collectionId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.highlighted) {
                output.encodeBooleanElement(serialDesc, 2, self.highlighted);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.redeemItemType != 0) {
                output.encodeIntElement(serialDesc, 3, self.redeemItemType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.redeemItemId, RoomRecommendViewModel.EMPTY_CURSOR)) {
                output.encodeStringElement(serialDesc, 4, self.redeemItemId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.redeemItemName, RoomRecommendViewModel.EMPTY_CURSOR)) {
                output.encodeStringElement(serialDesc, 5, self.redeemItemName);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.redeemItemImage, RoomRecommendViewModel.EMPTY_CURSOR)) {
                output.encodeStringElement(serialDesc, 6, self.redeemItemImage);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || self.redeemItemVideo != null) {
                output.encodeNullableSerializableElement(serialDesc, 7, (SerializationStrategy) lazyArr[7].getValue(), self.redeemItemVideo);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.cardVideoDownload != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.cardVideoDownload);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.descTag != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, DescTag$$serializer.INSTANCE, self.descTag);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.topText != null) {
                output.encodeNullableSerializableElement(serialDesc, 10, TopText$$serializer.INSTANCE, self.topText);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 11) || self.actions != null) {
                output.encodeNullableSerializableElement(serialDesc, 11, (SerializationStrategy) lazyArr[11].getValue(), self.actions);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 12) || self.modules != null) {
                output.encodeNullableSerializableElement(serialDesc, 12, (SerializationStrategy) lazyArr[12].getValue(), self.modules);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 13) || self.holdingRate != null) {
                output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.holdingRate);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 14) || self.holdingRateUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.holdingRateUrl);
            }
        }

        public /* synthetic */ Data(String str, long j2, boolean z, int i, String str2, String str3, String str4, List list, String str5, DescTag descTag, TopText topText, List list2, List list3, String str6, String str7, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i2 & 2) != 0 ? 0L : j2, (i2 & 4) != 0 ? false : z, (i2 & 8) == 0 ? i : 0, (i2 & 16) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i2 & 32) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str3, (i2 & 64) == 0 ? str4 : RoomRecommendViewModel.EMPTY_CURSOR, (i2 & 128) != 0 ? null : list, (i2 & 256) != 0 ? null : str5, (i2 & 512) != 0 ? null : descTag, (i2 & 1024) != 0 ? null : topText, (i2 & 2048) != 0 ? null : list2, (i2 & 4096) != 0 ? null : list3, (i2 & 8192) != 0 ? null : str6, (i2 & 16384) != 0 ? null : str7);
        }

        public final String getUniqueId() {
            return this.uniqueId;
        }

        public final long getCollectionId() {
            return this.collectionId;
        }

        public final boolean getHighlighted() {
            return this.highlighted;
        }

        public final int getRedeemItemType() {
            return this.redeemItemType;
        }

        public final String getRedeemItemId() {
            return this.redeemItemId;
        }

        public final String getRedeemItemName() {
            return this.redeemItemName;
        }

        public final String getRedeemItemImage() {
            return this.redeemItemImage;
        }

        public final List<String> getRedeemItemVideo() {
            return this.redeemItemVideo;
        }

        public final String getCardVideoDownload() {
            return this.cardVideoDownload;
        }

        public final DescTag getDescTag() {
            return this.descTag;
        }

        public final TopText getTopText() {
            return this.topText;
        }

        public final List<ActionItem> getActions() {
            return this.actions;
        }

        public final List<ModuleItem> getModules() {
            return this.modules;
        }

        public final String getHoldingRate() {
            return this.holdingRate;
        }

        public final String getHoldingRateUrl() {
            return this.holdingRateUrl;
        }
    }

    @Override // kntr.app.digital.preview.api.ResultItem
    public boolean isAnchorItem() {
        return this.isAnchorItem;
    }
}