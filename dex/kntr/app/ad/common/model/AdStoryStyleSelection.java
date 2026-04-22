package kntr.app.ad.common.model;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: AdStoryStyleSelection.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB?\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\rJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J5\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006)"}, d2 = {"Lkntr/app/ad/common/model/AdStoryStyleSelection;", RoomRecommendViewModel.EMPTY_CURSOR, "showTime", RoomRecommendViewModel.EMPTY_CURSOR, "delayTime", "basicCard", "Lkntr/app/ad/common/model/AdStorySelectionCard;", "reinforcedCard", "<init>", "(IILkntr/app/ad/common/model/AdStorySelectionCard;Lkntr/app/ad/common/model/AdStorySelectionCard;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIILkntr/app/ad/common/model/AdStorySelectionCard;Lkntr/app/ad/common/model/AdStorySelectionCard;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getShowTime", "()I", "getDelayTime", "getBasicCard", "()Lkntr/app/ad/common/model/AdStorySelectionCard;", "getReinforcedCard", "component1", "component2", "component3", "component4", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdStoryStyleSelection {
    public static final Companion Companion = new Companion(null);
    private final AdStorySelectionCard basicCard;
    private final int delayTime;
    private final AdStorySelectionCard reinforcedCard;
    private final int showTime;

    public AdStoryStyleSelection() {
        this(0, 0, (AdStorySelectionCard) null, (AdStorySelectionCard) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdStoryStyleSelection copy$default(AdStoryStyleSelection adStoryStyleSelection, int i, int i2, AdStorySelectionCard adStorySelectionCard, AdStorySelectionCard adStorySelectionCard2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = adStoryStyleSelection.showTime;
        }
        if ((i3 & 2) != 0) {
            i2 = adStoryStyleSelection.delayTime;
        }
        if ((i3 & 4) != 0) {
            adStorySelectionCard = adStoryStyleSelection.basicCard;
        }
        if ((i3 & 8) != 0) {
            adStorySelectionCard2 = adStoryStyleSelection.reinforcedCard;
        }
        return adStoryStyleSelection.copy(i, i2, adStorySelectionCard, adStorySelectionCard2);
    }

    public final int component1() {
        return this.showTime;
    }

    public final int component2() {
        return this.delayTime;
    }

    public final AdStorySelectionCard component3() {
        return this.basicCard;
    }

    public final AdStorySelectionCard component4() {
        return this.reinforcedCard;
    }

    public final AdStoryStyleSelection copy(int i, int i2, AdStorySelectionCard adStorySelectionCard, AdStorySelectionCard adStorySelectionCard2) {
        return new AdStoryStyleSelection(i, i2, adStorySelectionCard, adStorySelectionCard2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdStoryStyleSelection) {
            AdStoryStyleSelection adStoryStyleSelection = (AdStoryStyleSelection) obj;
            return this.showTime == adStoryStyleSelection.showTime && this.delayTime == adStoryStyleSelection.delayTime && Intrinsics.areEqual(this.basicCard, adStoryStyleSelection.basicCard) && Intrinsics.areEqual(this.reinforcedCard, adStoryStyleSelection.reinforcedCard);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.showTime * 31) + this.delayTime) * 31) + (this.basicCard == null ? 0 : this.basicCard.hashCode())) * 31) + (this.reinforcedCard != null ? this.reinforcedCard.hashCode() : 0);
    }

    public String toString() {
        int i = this.showTime;
        int i2 = this.delayTime;
        AdStorySelectionCard adStorySelectionCard = this.basicCard;
        return "AdStoryStyleSelection(showTime=" + i + ", delayTime=" + i2 + ", basicCard=" + adStorySelectionCard + ", reinforcedCard=" + this.reinforcedCard + ")";
    }

    /* compiled from: AdStoryStyleSelection.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdStoryStyleSelection$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdStoryStyleSelection;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdStoryStyleSelection> serializer() {
            return AdStoryStyleSelection$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdStoryStyleSelection(int seen0, int showTime, int delayTime, AdStorySelectionCard basicCard, AdStorySelectionCard reinforcedCard, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.showTime = 0;
        } else {
            this.showTime = showTime;
        }
        if ((seen0 & 2) == 0) {
            this.delayTime = 0;
        } else {
            this.delayTime = delayTime;
        }
        if ((seen0 & 4) == 0) {
            this.basicCard = null;
        } else {
            this.basicCard = basicCard;
        }
        if ((seen0 & 8) == 0) {
            this.reinforcedCard = null;
        } else {
            this.reinforcedCard = reinforcedCard;
        }
    }

    public AdStoryStyleSelection(int showTime, int delayTime, AdStorySelectionCard basicCard, AdStorySelectionCard reinforcedCard) {
        this.showTime = showTime;
        this.delayTime = delayTime;
        this.basicCard = basicCard;
        this.reinforcedCard = reinforcedCard;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdStoryStyleSelection self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.showTime != 0) {
            output.encodeIntElement(serialDesc, 0, self.showTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.delayTime != 0) {
            output.encodeIntElement(serialDesc, 1, self.delayTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.basicCard != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, AdStorySelectionCard$$serializer.INSTANCE, self.basicCard);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.reinforcedCard != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, AdStorySelectionCard$$serializer.INSTANCE, self.reinforcedCard);
        }
    }

    public /* synthetic */ AdStoryStyleSelection(int i, int i2, AdStorySelectionCard adStorySelectionCard, AdStorySelectionCard adStorySelectionCard2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? null : adStorySelectionCard, (i3 & 8) != 0 ? null : adStorySelectionCard2);
    }

    public final int getShowTime() {
        return this.showTime;
    }

    public final int getDelayTime() {
        return this.delayTime;
    }

    public final AdStorySelectionCard getBasicCard() {
        return this.basicCard;
    }

    public final AdStorySelectionCard getReinforcedCard() {
        return this.reinforcedCard;
    }
}