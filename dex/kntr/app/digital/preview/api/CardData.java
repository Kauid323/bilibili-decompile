package kntr.app.digital.preview.api;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.ad.protocol.report.SubmitType;
import kntr.app.digital.preview.CardNumberGradientColor;
import kntr.app.digital.preview.CardNumberGradientColor$$serializer;
import kntr.app.digital.preview.api.CardData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: CardPreviewModel.kt */
@SerialName("1")
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\b\u0018\u0000 %2\u00020\u0001:\u0003#$%B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\tHÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001¢\u0006\u0002\b\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0004\u0010\u0011¨\u0006&"}, d2 = {"Lkntr/app/digital/preview/api/CardData;", "Lkntr/app/digital/preview/api/ResultItem;", "data", "Lkntr/app/digital/preview/api/CardData$Data;", "isAnchorItem", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/digital/preview/api/CardData$Data;Z)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/digital/preview/api/CardData$Data;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getData", "()Lkntr/app/digital/preview/api/CardData$Data;", "isAnchorItem$annotations", "()V", "()Z", "component1", "component2", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "Data", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class CardData implements ResultItem {
    private final Data data;
    private final boolean isAnchorItem;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ CardData copy$default(CardData cardData, Data data, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            data = cardData.data;
        }
        if ((i & 2) != 0) {
            z = cardData.isAnchorItem;
        }
        return cardData.copy(data, z);
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

    public final CardData copy(Data data, boolean z) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new CardData(data, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CardData) {
            CardData cardData = (CardData) obj;
            return Intrinsics.areEqual(this.data, cardData.data) && this.isAnchorItem == cardData.isAnchorItem;
        }
        return false;
    }

    public int hashCode() {
        return (this.data.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isAnchorItem);
    }

    public String toString() {
        Data data = this.data;
        return "CardData(data=" + data + ", isAnchorItem=" + this.isAnchorItem + ")";
    }

    /* compiled from: CardPreviewModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/api/CardData$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/api/CardData;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CardData> serializer() {
            return CardData$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ CardData(int seen0, Data data, boolean isAnchorItem, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, CardData$$serializer.INSTANCE.getDescriptor());
        }
        this.data = data;
        if ((seen0 & 2) == 0) {
            this.isAnchorItem = false;
        } else {
            this.isAnchorItem = isAnchorItem;
        }
    }

    public CardData(Data data, boolean isAnchorItem) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.isAnchorItem = isAnchorItem;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$preview_debug(CardData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, CardData$Data$$serializer.INSTANCE, self.data);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.isAnchorItem()) {
            output.encodeBooleanElement(serialDesc, 1, self.isAnchorItem());
        }
    }

    public /* synthetic */ CardData(Data data, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(data, (i & 2) != 0 ? false : z);
    }

    public final Data getData() {
        return this.data;
    }

    /* compiled from: CardPreviewModel.kt */
    @Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b^\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u0095\u00012\u00020\u0001:\u0006\u0093\u0001\u0094\u0001\u0095\u0001B³\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u000e¢\u0006\u0004\b'\u0010(B©\u0002\b\u0010\u0012\u0006\u0010)\u001a\u00020\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0011\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u001d\u001a\u00020\b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\b\u0010!\u001a\u0004\u0018\u00010\"\u0012\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u000e\u0012\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u000e\u0012\b\u0010*\u001a\u0004\u0018\u00010+\u0012\b\u0010,\u001a\u0004\u0018\u00010-¢\u0006\u0004\b'\u0010.J\t\u0010l\u001a\u00020\u0003HÆ\u0003J\t\u0010m\u001a\u00020\u0005HÆ\u0003J\t\u0010n\u001a\u00020\u0005HÆ\u0003J\t\u0010o\u001a\u00020\bHÆ\u0003J\t\u0010p\u001a\u00020\u0003HÆ\u0003J\t\u0010q\u001a\u00020\u0003HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010s\u001a\u00020\u0003HÆ\u0003J\u0011\u0010t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eHÆ\u0003J\u0011\u0010u\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eHÆ\u0003J\t\u0010v\u001a\u00020\u0011HÆ\u0003J\t\u0010w\u001a\u00020\u0011HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0010\u0010z\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010TJ\u000b\u0010{\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010}\u001a\u00020\u0011HÆ\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\t\u0010\u007f\u001a\u00020\bHÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010 HÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\"HÆ\u0003J\u0012\u0010\u0083\u0001\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u000eHÆ\u0003J\u0012\u0010\u0084\u0001\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u000eHÆ\u0003J¼\u0002\u0010\u0085\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00112\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u000e2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u000eHÆ\u0001¢\u0006\u0003\u0010\u0086\u0001J\u0015\u0010\u0087\u0001\u001a\u00020\b2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0011HÖ\u0001J\n\u0010\u008a\u0001\u001a\u00020\u0003HÖ\u0001J-\u0010\u008b\u0001\u001a\u00030\u008c\u00012\u0007\u0010\u008d\u0001\u001a\u00020\u00002\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\b\u0010\u0090\u0001\u001a\u00030\u0091\u0001H\u0001¢\u0006\u0003\b\u0092\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u00100\u001a\u0004\b4\u00105R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u00100\u001a\u0004\b7\u00105R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001c\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u00100\u001a\u0004\b;\u00102R\u001c\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u00100\u001a\u0004\b=\u00102R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u00100\u001a\u0004\b?\u00102R\u001c\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u00100\u001a\u0004\bA\u00102R$\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u00100\u001a\u0004\bC\u0010DR$\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bE\u00100\u001a\u0004\bF\u0010DR\u001c\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bG\u00100\u001a\u0004\bH\u0010IR\u001c\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bJ\u00100\u001a\u0004\bK\u0010IR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bL\u00100\u001a\u0004\bM\u0010NR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bO\u00100\u001a\u0004\bP\u0010QR \u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010U\u0012\u0004\bR\u00100\u001a\u0004\bS\u0010TR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bV\u00100\u001a\u0004\bW\u00102R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bX\u00100\u001a\u0004\bY\u00102R\u001c\u0010\u001a\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bZ\u00100\u001a\u0004\b[\u0010IR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u001c\u0010\u001d\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b^\u00100\u001a\u0004\b_\u00109R\u001c\u0010\u001e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b`\u00100\u001a\u0004\ba\u00102R\u001e\u0010\u001f\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bb\u00100\u001a\u0004\bc\u0010dR\u001e\u0010!\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\be\u00100\u001a\u0004\bf\u0010gR\u0019\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\bh\u0010DR\u0019\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\bi\u0010DR\u0011\u0010*\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\bj\u0010k¨\u0006\u0096\u0001"}, d2 = {"Lkntr/app/digital/preview/api/CardData$Data;", RoomRecommendViewModel.EMPTY_CURSOR, "uniqueId", RoomRecommendViewModel.EMPTY_CURSOR, "cardId", RoomRecommendViewModel.EMPTY_CURSOR, "cardTypeId", "highlighted", RoomRecommendViewModel.EMPTY_CURSOR, "cardName", "cardImage", "cardImageDownload", "cardNo", "cardVideo", RoomRecommendViewModel.EMPTY_CURSOR, "cardVideoDownload", "cardType", RoomRecommendViewModel.EMPTY_CURSOR, "cardSubType", "descTag", "Lkntr/app/digital/preview/api/DescTag;", "topText", "Lkntr/app/digital/preview/api/TopText;", "smeltLockStatus", "holdingRate", "holdingRateUrl", "cardScarcity", SubmitType.MMA_KEY_PLAY, "Lkntr/app/digital/preview/api/Play;", "silence", "badgeUrl", "smeltInfo", "Lkntr/app/digital/preview/api/SmeltInfo;", "colorFormat", "Lkntr/app/digital/preview/CardNumberGradientColor;", "actions", "Lkntr/app/digital/preview/api/ActionItem;", "modules", "Lkntr/app/digital/preview/api/ModuleItem;", "<init>", "(Ljava/lang/String;JJZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;IILkntr/app/digital/preview/api/DescTag;Lkntr/app/digital/preview/api/TopText;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ILkntr/app/digital/preview/api/Play;ZLjava/lang/String;Lkntr/app/digital/preview/api/SmeltInfo;Lkntr/app/digital/preview/CardNumberGradientColor;Ljava/util/List;Ljava/util/List;)V", "seen0", "cardLockStatus", "Lkntr/app/digital/preview/api/CardData$Data$CardLockStatus;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JJZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;IILkntr/app/digital/preview/api/DescTag;Lkntr/app/digital/preview/api/TopText;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ILkntr/app/digital/preview/api/Play;ZLjava/lang/String;Lkntr/app/digital/preview/api/SmeltInfo;Lkntr/app/digital/preview/CardNumberGradientColor;Ljava/util/List;Ljava/util/List;Lkntr/app/digital/preview/api/CardData$Data$CardLockStatus;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUniqueId$annotations", "()V", "getUniqueId", "()Ljava/lang/String;", "getCardId$annotations", "getCardId", "()J", "getCardTypeId$annotations", "getCardTypeId", "getHighlighted", "()Z", "getCardName$annotations", "getCardName", "getCardImage$annotations", "getCardImage", "getCardImageDownload$annotations", "getCardImageDownload", "getCardNo$annotations", "getCardNo", "getCardVideo$annotations", "getCardVideo", "()Ljava/util/List;", "getCardVideoDownload$annotations", "getCardVideoDownload", "getCardType$annotations", "getCardType", "()I", "getCardSubType$annotations", "getCardSubType", "getDescTag$annotations", "getDescTag", "()Lkntr/app/digital/preview/api/DescTag;", "getTopText$annotations", "getTopText", "()Lkntr/app/digital/preview/api/TopText;", "getSmeltLockStatus$annotations", "getSmeltLockStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHoldingRate$annotations", "getHoldingRate", "getHoldingRateUrl$annotations", "getHoldingRateUrl", "getCardScarcity$annotations", "getCardScarcity", "getPlay", "()Lkntr/app/digital/preview/api/Play;", "getSilence$annotations", "getSilence", "getBadgeUrl$annotations", "getBadgeUrl", "getSmeltInfo$annotations", "getSmeltInfo", "()Lkntr/app/digital/preview/api/SmeltInfo;", "getColorFormat$annotations", "getColorFormat", "()Lkntr/app/digital/preview/CardNumberGradientColor;", "getActions", "getModules", "getCardLockStatus", "()Lkntr/app/digital/preview/api/CardData$Data$CardLockStatus;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "(Ljava/lang/String;JJZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;IILkntr/app/digital/preview/api/DescTag;Lkntr/app/digital/preview/api/TopText;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ILkntr/app/digital/preview/api/Play;ZLjava/lang/String;Lkntr/app/digital/preview/api/SmeltInfo;Lkntr/app/digital/preview/CardNumberGradientColor;Ljava/util/List;Ljava/util/List;)Lkntr/app/digital/preview/api/CardData$Data;", "equals", "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "CardLockStatus", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Data {
        private final List<ActionItem> actions;
        private final String badgeUrl;
        private final long cardId;
        private final String cardImage;
        private final String cardImageDownload;
        private final CardLockStatus cardLockStatus;
        private final String cardName;
        private final String cardNo;
        private final int cardScarcity;
        private final int cardSubType;
        private final int cardType;
        private final long cardTypeId;
        private final List<String> cardVideo;
        private final List<String> cardVideoDownload;
        private final CardNumberGradientColor colorFormat;
        private final DescTag descTag;
        private final boolean highlighted;
        private final String holdingRate;
        private final String holdingRateUrl;
        private final List<ModuleItem> modules;
        private final Play play;
        private final boolean silence;
        private final SmeltInfo smeltInfo;
        private final Integer smeltLockStatus;
        private final TopText topText;
        private final String uniqueId;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.digital.preview.api.CardData$Data$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = CardData.Data._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.digital.preview.api.CardData$Data$$ExternalSyntheticLambda1
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$0;
                _childSerializers$_anonymous_$0 = CardData.Data._childSerializers$_anonymous_$0();
                return _childSerializers$_anonymous_$0;
            }
        }), null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.digital.preview.api.CardData$Data$$ExternalSyntheticLambda2
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$1;
                _childSerializers$_anonymous_$1 = CardData.Data._childSerializers$_anonymous_$1();
                return _childSerializers$_anonymous_$1;
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.digital.preview.api.CardData$Data$$ExternalSyntheticLambda3
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$2;
                _childSerializers$_anonymous_$2 = CardData.Data._childSerializers$_anonymous_$2();
                return _childSerializers$_anonymous_$2;
            }
        }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.digital.preview.api.CardData$Data$$ExternalSyntheticLambda4
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_$3;
                _childSerializers$_anonymous_$3 = CardData.Data._childSerializers$_anonymous_$3();
                return _childSerializers$_anonymous_$3;
            }
        })};

        /* compiled from: CardPreviewModel.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lkntr/app/digital/preview/api/CardData$Data$CardLockStatus;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;I)V", "Default", "UNLOCKED", "LOCKED", "PERMANENTLY_LOCKED", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public enum CardLockStatus {
            Default,
            UNLOCKED,
            LOCKED,
            PERMANENTLY_LOCKED;
            
            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

            public static EnumEntries<CardLockStatus> getEntries() {
                return $ENTRIES;
            }
        }

        public Data() {
            this(null, 0L, 0L, false, null, null, null, null, null, null, 0, 0, null, null, null, null, null, 0, null, false, null, null, null, null, null, 33554431, null);
        }

        @SerialName("badge_url")
        public static /* synthetic */ void getBadgeUrl$annotations() {
        }

        @SerialName("card_id")
        public static /* synthetic */ void getCardId$annotations() {
        }

        @SerialName("card_image")
        public static /* synthetic */ void getCardImage$annotations() {
        }

        @SerialName("card_image_download")
        public static /* synthetic */ void getCardImageDownload$annotations() {
        }

        @SerialName("card_name")
        public static /* synthetic */ void getCardName$annotations() {
        }

        @SerialName("card_no")
        public static /* synthetic */ void getCardNo$annotations() {
        }

        @SerialName("card_scarcity")
        public static /* synthetic */ void getCardScarcity$annotations() {
        }

        @SerialName("card_sub_type")
        public static /* synthetic */ void getCardSubType$annotations() {
        }

        @SerialName(ReportBuildInParam.CARD_TYPE)
        public static /* synthetic */ void getCardType$annotations() {
        }

        @SerialName("card_type_id")
        public static /* synthetic */ void getCardTypeId$annotations() {
        }

        @SerialName("card_video")
        public static /* synthetic */ void getCardVideo$annotations() {
        }

        @SerialName("card_video_download")
        public static /* synthetic */ void getCardVideoDownload$annotations() {
        }

        @SerialName("color_format")
        public static /* synthetic */ void getColorFormat$annotations() {
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

        @SerialName("is_mute")
        public static /* synthetic */ void getSilence$annotations() {
        }

        @SerialName("smelt_info")
        public static /* synthetic */ void getSmeltInfo$annotations() {
        }

        @SerialName("smelt_lock_status")
        public static /* synthetic */ void getSmeltLockStatus$annotations() {
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

        public final List<String> component10() {
            return this.cardVideoDownload;
        }

        public final int component11() {
            return this.cardType;
        }

        public final int component12() {
            return this.cardSubType;
        }

        public final DescTag component13() {
            return this.descTag;
        }

        public final TopText component14() {
            return this.topText;
        }

        public final Integer component15() {
            return this.smeltLockStatus;
        }

        public final String component16() {
            return this.holdingRate;
        }

        public final String component17() {
            return this.holdingRateUrl;
        }

        public final int component18() {
            return this.cardScarcity;
        }

        public final Play component19() {
            return this.play;
        }

        public final long component2() {
            return this.cardId;
        }

        public final boolean component20() {
            return this.silence;
        }

        public final String component21() {
            return this.badgeUrl;
        }

        public final SmeltInfo component22() {
            return this.smeltInfo;
        }

        public final CardNumberGradientColor component23() {
            return this.colorFormat;
        }

        public final List<ActionItem> component24() {
            return this.actions;
        }

        public final List<ModuleItem> component25() {
            return this.modules;
        }

        public final long component3() {
            return this.cardTypeId;
        }

        public final boolean component4() {
            return this.highlighted;
        }

        public final String component5() {
            return this.cardName;
        }

        public final String component6() {
            return this.cardImage;
        }

        public final String component7() {
            return this.cardImageDownload;
        }

        public final String component8() {
            return this.cardNo;
        }

        public final List<String> component9() {
            return this.cardVideo;
        }

        public final Data copy(String str, long j2, long j3, boolean z, String str2, String str3, String str4, String str5, List<String> list, List<String> list2, int i, int i2, DescTag descTag, TopText topText, Integer num, String str6, String str7, int i3, Play play, boolean z2, String str8, SmeltInfo smeltInfo, CardNumberGradientColor cardNumberGradientColor, List<? extends ActionItem> list3, List<? extends ModuleItem> list4) {
            Intrinsics.checkNotNullParameter(str, "uniqueId");
            Intrinsics.checkNotNullParameter(str2, "cardName");
            Intrinsics.checkNotNullParameter(str3, "cardImage");
            Intrinsics.checkNotNullParameter(str5, "cardNo");
            Intrinsics.checkNotNullParameter(str8, "badgeUrl");
            return new Data(str, j2, j3, z, str2, str3, str4, str5, list, list2, i, i2, descTag, topText, num, str6, str7, i3, play, z2, str8, smeltInfo, cardNumberGradientColor, list3, list4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Data) {
                Data data = (Data) obj;
                return Intrinsics.areEqual(this.uniqueId, data.uniqueId) && this.cardId == data.cardId && this.cardTypeId == data.cardTypeId && this.highlighted == data.highlighted && Intrinsics.areEqual(this.cardName, data.cardName) && Intrinsics.areEqual(this.cardImage, data.cardImage) && Intrinsics.areEqual(this.cardImageDownload, data.cardImageDownload) && Intrinsics.areEqual(this.cardNo, data.cardNo) && Intrinsics.areEqual(this.cardVideo, data.cardVideo) && Intrinsics.areEqual(this.cardVideoDownload, data.cardVideoDownload) && this.cardType == data.cardType && this.cardSubType == data.cardSubType && Intrinsics.areEqual(this.descTag, data.descTag) && Intrinsics.areEqual(this.topText, data.topText) && Intrinsics.areEqual(this.smeltLockStatus, data.smeltLockStatus) && Intrinsics.areEqual(this.holdingRate, data.holdingRate) && Intrinsics.areEqual(this.holdingRateUrl, data.holdingRateUrl) && this.cardScarcity == data.cardScarcity && Intrinsics.areEqual(this.play, data.play) && this.silence == data.silence && Intrinsics.areEqual(this.badgeUrl, data.badgeUrl) && Intrinsics.areEqual(this.smeltInfo, data.smeltInfo) && Intrinsics.areEqual(this.colorFormat, data.colorFormat) && Intrinsics.areEqual(this.actions, data.actions) && Intrinsics.areEqual(this.modules, data.modules);
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((((((((((this.uniqueId.hashCode() * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cardId)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cardTypeId)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.highlighted)) * 31) + this.cardName.hashCode()) * 31) + this.cardImage.hashCode()) * 31) + (this.cardImageDownload == null ? 0 : this.cardImageDownload.hashCode())) * 31) + this.cardNo.hashCode()) * 31) + (this.cardVideo == null ? 0 : this.cardVideo.hashCode())) * 31) + (this.cardVideoDownload == null ? 0 : this.cardVideoDownload.hashCode())) * 31) + this.cardType) * 31) + this.cardSubType) * 31) + (this.descTag == null ? 0 : this.descTag.hashCode())) * 31) + (this.topText == null ? 0 : this.topText.hashCode())) * 31) + (this.smeltLockStatus == null ? 0 : this.smeltLockStatus.hashCode())) * 31) + (this.holdingRate == null ? 0 : this.holdingRate.hashCode())) * 31) + (this.holdingRateUrl == null ? 0 : this.holdingRateUrl.hashCode())) * 31) + this.cardScarcity) * 31) + (this.play == null ? 0 : this.play.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.silence)) * 31) + this.badgeUrl.hashCode()) * 31) + (this.smeltInfo == null ? 0 : this.smeltInfo.hashCode())) * 31) + (this.colorFormat == null ? 0 : this.colorFormat.hashCode())) * 31) + (this.actions == null ? 0 : this.actions.hashCode())) * 31) + (this.modules != null ? this.modules.hashCode() : 0);
        }

        public String toString() {
            String str = this.uniqueId;
            long j2 = this.cardId;
            long j3 = this.cardTypeId;
            boolean z = this.highlighted;
            String str2 = this.cardName;
            String str3 = this.cardImage;
            String str4 = this.cardImageDownload;
            String str5 = this.cardNo;
            List<String> list = this.cardVideo;
            List<String> list2 = this.cardVideoDownload;
            int i = this.cardType;
            int i2 = this.cardSubType;
            DescTag descTag = this.descTag;
            TopText topText = this.topText;
            Integer num = this.smeltLockStatus;
            String str6 = this.holdingRate;
            String str7 = this.holdingRateUrl;
            int i3 = this.cardScarcity;
            Play play = this.play;
            boolean z2 = this.silence;
            String str8 = this.badgeUrl;
            SmeltInfo smeltInfo = this.smeltInfo;
            CardNumberGradientColor cardNumberGradientColor = this.colorFormat;
            List<ActionItem> list3 = this.actions;
            return "Data(uniqueId=" + str + ", cardId=" + j2 + ", cardTypeId=" + j3 + ", highlighted=" + z + ", cardName=" + str2 + ", cardImage=" + str3 + ", cardImageDownload=" + str4 + ", cardNo=" + str5 + ", cardVideo=" + list + ", cardVideoDownload=" + list2 + ", cardType=" + i + ", cardSubType=" + i2 + ", descTag=" + descTag + ", topText=" + topText + ", smeltLockStatus=" + num + ", holdingRate=" + str6 + ", holdingRateUrl=" + str7 + ", cardScarcity=" + i3 + ", play=" + play + ", silence=" + z2 + ", badgeUrl=" + str8 + ", smeltInfo=" + smeltInfo + ", colorFormat=" + cardNumberGradientColor + ", actions=" + list3 + ", modules=" + this.modules + ")";
        }

        /* compiled from: CardPreviewModel.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/api/CardData$Data$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/api/CardData$Data;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Data> serializer() {
                return CardData$Data$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Data(int seen0, String uniqueId, long cardId, long cardTypeId, boolean highlighted, String cardName, String cardImage, String cardImageDownload, String cardNo, List cardVideo, List cardVideoDownload, int cardType, int cardSubType, DescTag descTag, TopText topText, Integer smeltLockStatus, String holdingRate, String holdingRateUrl, int cardScarcity, Play play, boolean silence, String badgeUrl, SmeltInfo smeltInfo, CardNumberGradientColor colorFormat, List actions, List modules, CardLockStatus cardLockStatus, SerializationConstructorMarker serializationConstructorMarker) {
            if ((seen0 & 1) == 0) {
                this.uniqueId = RoomRecommendViewModel.EMPTY_CURSOR;
            } else {
                this.uniqueId = uniqueId;
            }
            if ((seen0 & 2) == 0) {
                this.cardId = 0L;
            } else {
                this.cardId = cardId;
            }
            if ((seen0 & 4) == 0) {
                this.cardTypeId = 0L;
            } else {
                this.cardTypeId = cardTypeId;
            }
            if ((seen0 & 8) == 0) {
                this.highlighted = false;
            } else {
                this.highlighted = highlighted;
            }
            if ((seen0 & 16) == 0) {
                this.cardName = RoomRecommendViewModel.EMPTY_CURSOR;
            } else {
                this.cardName = cardName;
            }
            if ((seen0 & 32) == 0) {
                this.cardImage = RoomRecommendViewModel.EMPTY_CURSOR;
            } else {
                this.cardImage = cardImage;
            }
            if ((seen0 & 64) == 0) {
                this.cardImageDownload = null;
            } else {
                this.cardImageDownload = cardImageDownload;
            }
            if ((seen0 & 128) == 0) {
                this.cardNo = RoomRecommendViewModel.EMPTY_CURSOR;
            } else {
                this.cardNo = cardNo;
            }
            if ((seen0 & 256) == 0) {
                this.cardVideo = null;
            } else {
                this.cardVideo = cardVideo;
            }
            if ((seen0 & 512) == 0) {
                this.cardVideoDownload = null;
            } else {
                this.cardVideoDownload = cardVideoDownload;
            }
            if ((seen0 & 1024) == 0) {
                this.cardType = 1;
            } else {
                this.cardType = cardType;
            }
            if ((seen0 & 2048) == 0) {
                this.cardSubType = 1;
            } else {
                this.cardSubType = cardSubType;
            }
            if ((seen0 & 4096) == 0) {
                this.descTag = null;
            } else {
                this.descTag = descTag;
            }
            if ((seen0 & 8192) == 0) {
                this.topText = null;
            } else {
                this.topText = topText;
            }
            if ((seen0 & 16384) == 0) {
                this.smeltLockStatus = null;
            } else {
                this.smeltLockStatus = smeltLockStatus;
            }
            if ((seen0 & 32768) == 0) {
                this.holdingRate = null;
            } else {
                this.holdingRate = holdingRate;
            }
            if ((seen0 & 65536) == 0) {
                this.holdingRateUrl = null;
            } else {
                this.holdingRateUrl = holdingRateUrl;
            }
            if ((seen0 & 131072) == 0) {
                this.cardScarcity = 0;
            } else {
                this.cardScarcity = cardScarcity;
            }
            if ((seen0 & 262144) == 0) {
                this.play = null;
            } else {
                this.play = play;
            }
            if ((seen0 & 524288) == 0) {
                this.silence = false;
            } else {
                this.silence = silence;
            }
            if ((seen0 & 1048576) == 0) {
                this.badgeUrl = RoomRecommendViewModel.EMPTY_CURSOR;
            } else {
                this.badgeUrl = badgeUrl;
            }
            if ((seen0 & 2097152) == 0) {
                this.smeltInfo = null;
            } else {
                this.smeltInfo = smeltInfo;
            }
            if ((seen0 & 4194304) == 0) {
                this.colorFormat = null;
            } else {
                this.colorFormat = colorFormat;
            }
            if ((seen0 & 8388608) == 0) {
                this.actions = null;
            } else {
                this.actions = actions;
            }
            if ((seen0 & 16777216) == 0) {
                this.modules = null;
            } else {
                this.modules = modules;
            }
            if ((seen0 & 33554432) != 0) {
                this.cardLockStatus = cardLockStatus;
                return;
            }
            Integer num = this.smeltLockStatus;
            this.cardLockStatus = (num != null && num.intValue() == 1) ? CardLockStatus.UNLOCKED : (num != null && num.intValue() == 2) ? CardLockStatus.LOCKED : (num != null && num.intValue() == 3) ? CardLockStatus.PERMANENTLY_LOCKED : CardLockStatus.Default;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Data(String uniqueId, long cardId, long cardTypeId, boolean highlighted, String cardName, String cardImage, String cardImageDownload, String cardNo, List<String> list, List<String> list2, int cardType, int cardSubType, DescTag descTag, TopText topText, Integer smeltLockStatus, String holdingRate, String holdingRateUrl, int cardScarcity, Play play, boolean silence, String badgeUrl, SmeltInfo smeltInfo, CardNumberGradientColor colorFormat, List<? extends ActionItem> list3, List<? extends ModuleItem> list4) {
            CardLockStatus cardLockStatus;
            Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
            Intrinsics.checkNotNullParameter(cardName, "cardName");
            Intrinsics.checkNotNullParameter(cardImage, "cardImage");
            Intrinsics.checkNotNullParameter(cardNo, "cardNo");
            Intrinsics.checkNotNullParameter(badgeUrl, "badgeUrl");
            this.uniqueId = uniqueId;
            this.cardId = cardId;
            this.cardTypeId = cardTypeId;
            this.highlighted = highlighted;
            this.cardName = cardName;
            this.cardImage = cardImage;
            this.cardImageDownload = cardImageDownload;
            this.cardNo = cardNo;
            this.cardVideo = list;
            this.cardVideoDownload = list2;
            this.cardType = cardType;
            this.cardSubType = cardSubType;
            this.descTag = descTag;
            this.topText = topText;
            this.smeltLockStatus = smeltLockStatus;
            this.holdingRate = holdingRate;
            this.holdingRateUrl = holdingRateUrl;
            this.cardScarcity = cardScarcity;
            this.play = play;
            this.silence = silence;
            this.badgeUrl = badgeUrl;
            this.smeltInfo = smeltInfo;
            this.colorFormat = colorFormat;
            this.actions = list3;
            this.modules = list4;
            Integer num = this.smeltLockStatus;
            if (num != null && num.intValue() == 1) {
                cardLockStatus = CardLockStatus.UNLOCKED;
            } else if (num != null && num.intValue() == 2) {
                cardLockStatus = CardLockStatus.LOCKED;
            } else {
                cardLockStatus = (num != null && num.intValue() == 3) ? CardLockStatus.PERMANENTLY_LOCKED : CardLockStatus.Default;
            }
            this.cardLockStatus = cardLockStatus;
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
            return new ArrayListSerializer(ActionItem.Companion.serializer());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
            return new ArrayListSerializer(ModuleItem.Companion.serializer());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$3() {
            return EnumsKt.createSimpleEnumSerializer("kntr.app.digital.preview.api.CardData.Data.CardLockStatus", CardLockStatus.values());
        }

        /* JADX WARN: Code restructure failed: missing block: B:247:0x02e6, code lost:
            if (r6 != ((r7 != null && r7.intValue() == 1) ? kntr.app.digital.preview.api.CardData.Data.CardLockStatus.UNLOCKED : (r7 != null && r7.intValue() == 2) ? kntr.app.digital.preview.api.CardData.Data.CardLockStatus.LOCKED : (r7 != null && r7.intValue() == 3) ? kntr.app.digital.preview.api.CardData.Data.CardLockStatus.PERMANENTLY_LOCKED : kntr.app.digital.preview.api.CardData.Data.CardLockStatus.Default)) goto L128;
         */
        @JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final /* synthetic */ void write$Self$preview_debug(Data self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            boolean z = false;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.uniqueId, RoomRecommendViewModel.EMPTY_CURSOR)) {
                output.encodeStringElement(serialDesc, 0, self.uniqueId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.cardId != 0) {
                output.encodeLongElement(serialDesc, 1, self.cardId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.cardTypeId != 0) {
                output.encodeLongElement(serialDesc, 2, self.cardTypeId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.highlighted) {
                output.encodeBooleanElement(serialDesc, 3, self.highlighted);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.cardName, RoomRecommendViewModel.EMPTY_CURSOR)) {
                output.encodeStringElement(serialDesc, 4, self.cardName);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.cardImage, RoomRecommendViewModel.EMPTY_CURSOR)) {
                output.encodeStringElement(serialDesc, 5, self.cardImage);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.cardImageDownload != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.cardImageDownload);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.cardNo, RoomRecommendViewModel.EMPTY_CURSOR)) {
                output.encodeStringElement(serialDesc, 7, self.cardNo);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.cardVideo != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, (SerializationStrategy) lazyArr[8].getValue(), self.cardVideo);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 9) || self.cardVideoDownload != null) {
                output.encodeNullableSerializableElement(serialDesc, 9, (SerializationStrategy) lazyArr[9].getValue(), self.cardVideoDownload);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 10) || self.cardType != 1) {
                output.encodeIntElement(serialDesc, 10, self.cardType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 11) || self.cardSubType != 1) {
                output.encodeIntElement(serialDesc, 11, self.cardSubType);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 12) || self.descTag != null) {
                output.encodeNullableSerializableElement(serialDesc, 12, DescTag$$serializer.INSTANCE, self.descTag);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 13) || self.topText != null) {
                output.encodeNullableSerializableElement(serialDesc, 13, TopText$$serializer.INSTANCE, self.topText);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 14) || self.smeltLockStatus != null) {
                output.encodeNullableSerializableElement(serialDesc, 14, IntSerializer.INSTANCE, self.smeltLockStatus);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 15) || self.holdingRate != null) {
                output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.holdingRate);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 16) || self.holdingRateUrl != null) {
                output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.holdingRateUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 17) || self.cardScarcity != 0) {
                output.encodeIntElement(serialDesc, 17, self.cardScarcity);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 18) || self.play != null) {
                output.encodeNullableSerializableElement(serialDesc, 18, Play$$serializer.INSTANCE, self.play);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 19) || self.silence) {
                output.encodeBooleanElement(serialDesc, 19, self.silence);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 20) || !Intrinsics.areEqual(self.badgeUrl, RoomRecommendViewModel.EMPTY_CURSOR)) {
                output.encodeStringElement(serialDesc, 20, self.badgeUrl);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 21) || self.smeltInfo != null) {
                output.encodeNullableSerializableElement(serialDesc, 21, SmeltInfo$$serializer.INSTANCE, self.smeltInfo);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 22) || self.colorFormat != null) {
                output.encodeNullableSerializableElement(serialDesc, 22, CardNumberGradientColor$$serializer.INSTANCE, self.colorFormat);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 23) || self.actions != null) {
                output.encodeNullableSerializableElement(serialDesc, 23, (SerializationStrategy) lazyArr[23].getValue(), self.actions);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 24) || self.modules != null) {
                output.encodeNullableSerializableElement(serialDesc, 24, (SerializationStrategy) lazyArr[24].getValue(), self.modules);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 25)) {
                CardLockStatus cardLockStatus = self.cardLockStatus;
                Integer num = self.smeltLockStatus;
            }
            z = true;
            if (z) {
                output.encodeSerializableElement(serialDesc, 25, (SerializationStrategy) lazyArr[25].getValue(), self.cardLockStatus);
            }
        }

        public /* synthetic */ Data(String str, long j2, long j3, boolean z, String str2, String str3, String str4, String str5, List list, List list2, int i, int i2, DescTag descTag, TopText topText, Integer num, String str6, String str7, int i3, Play play, boolean z2, String str8, SmeltInfo smeltInfo, CardNumberGradientColor cardNumberGradientColor, List list3, List list4, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i4 & 2) != 0 ? 0L : j2, (i4 & 4) == 0 ? j3 : 0L, (i4 & 8) != 0 ? false : z, (i4 & 16) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i4 & 32) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str3, (i4 & 64) != 0 ? null : str4, (i4 & 128) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str5, (i4 & 256) != 0 ? null : list, (i4 & 512) != 0 ? null : list2, (i4 & 1024) != 0 ? 1 : i, (i4 & 2048) == 0 ? i2 : 1, (i4 & 4096) != 0 ? null : descTag, (i4 & 8192) != 0 ? null : topText, (i4 & 16384) != 0 ? null : num, (i4 & 32768) != 0 ? null : str6, (i4 & 65536) != 0 ? null : str7, (i4 & 131072) != 0 ? 0 : i3, (i4 & 262144) != 0 ? null : play, (i4 & 524288) != 0 ? false : z2, (i4 & 1048576) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str8, (i4 & 2097152) != 0 ? null : smeltInfo, (i4 & 4194304) != 0 ? null : cardNumberGradientColor, (i4 & 8388608) != 0 ? null : list3, (i4 & 16777216) != 0 ? null : list4);
        }

        public final String getUniqueId() {
            return this.uniqueId;
        }

        public final long getCardId() {
            return this.cardId;
        }

        public final long getCardTypeId() {
            return this.cardTypeId;
        }

        public final boolean getHighlighted() {
            return this.highlighted;
        }

        public final String getCardName() {
            return this.cardName;
        }

        public final String getCardImage() {
            return this.cardImage;
        }

        public final String getCardImageDownload() {
            return this.cardImageDownload;
        }

        public final String getCardNo() {
            return this.cardNo;
        }

        public final List<String> getCardVideo() {
            return this.cardVideo;
        }

        public final List<String> getCardVideoDownload() {
            return this.cardVideoDownload;
        }

        public final int getCardType() {
            return this.cardType;
        }

        public final int getCardSubType() {
            return this.cardSubType;
        }

        public final DescTag getDescTag() {
            return this.descTag;
        }

        public final TopText getTopText() {
            return this.topText;
        }

        public final Integer getSmeltLockStatus() {
            return this.smeltLockStatus;
        }

        public final String getHoldingRate() {
            return this.holdingRate;
        }

        public final String getHoldingRateUrl() {
            return this.holdingRateUrl;
        }

        public final int getCardScarcity() {
            return this.cardScarcity;
        }

        public final Play getPlay() {
            return this.play;
        }

        public final boolean getSilence() {
            return this.silence;
        }

        public final String getBadgeUrl() {
            return this.badgeUrl;
        }

        public final SmeltInfo getSmeltInfo() {
            return this.smeltInfo;
        }

        public final CardNumberGradientColor getColorFormat() {
            return this.colorFormat;
        }

        public final List<ActionItem> getActions() {
            return this.actions;
        }

        public final List<ModuleItem> getModules() {
            return this.modules;
        }

        public final CardLockStatus getCardLockStatus() {
            return this.cardLockStatus;
        }
    }

    @Override // kntr.app.digital.preview.api.ResultItem
    public boolean isAnchorItem() {
        return this.isAnchorItem;
    }
}