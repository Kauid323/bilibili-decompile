package kntr.app.ad.common.model;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: AdGood.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bB;\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\nHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006("}, d2 = {"Lkntr/app/ad/common/model/AdGood;", RoomRecommendViewModel.EMPTY_CURSOR, "itemId", RoomRecommendViewModel.EMPTY_CURSOR, "skuId", "shopId", "skuNum", "<init>", "(JJJJ)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJJJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getItemId", "()J", "getSkuId", "getShopId", "getSkuNum", "component1", "component2", "component3", "component4", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdGood {
    public static final Companion Companion = new Companion(null);
    private final long itemId;
    private final long shopId;
    private final long skuId;
    private final long skuNum;

    public AdGood() {
        this(0L, 0L, 0L, 0L, 15, (DefaultConstructorMarker) null);
    }

    public final long component1() {
        return this.itemId;
    }

    public final long component2() {
        return this.skuId;
    }

    public final long component3() {
        return this.shopId;
    }

    public final long component4() {
        return this.skuNum;
    }

    public final AdGood copy(long j2, long j3, long j4, long j5) {
        return new AdGood(j2, j3, j4, j5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdGood) {
            AdGood adGood = (AdGood) obj;
            return this.itemId == adGood.itemId && this.skuId == adGood.skuId && this.shopId == adGood.shopId && this.skuNum == adGood.skuNum;
        }
        return false;
    }

    public int hashCode() {
        return (((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.itemId) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.skuId)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.shopId)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.skuNum);
    }

    public String toString() {
        long j2 = this.itemId;
        long j3 = this.skuId;
        long j4 = this.shopId;
        return "AdGood(itemId=" + j2 + ", skuId=" + j3 + ", shopId=" + j4 + ", skuNum=" + this.skuNum + ")";
    }

    /* compiled from: AdGood.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdGood$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdGood;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdGood> serializer() {
            return AdGood$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdGood(int seen0, long itemId, long skuId, long shopId, long skuNum, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.itemId = 0L;
        } else {
            this.itemId = itemId;
        }
        if ((seen0 & 2) == 0) {
            this.skuId = 0L;
        } else {
            this.skuId = skuId;
        }
        if ((seen0 & 4) == 0) {
            this.shopId = 0L;
        } else {
            this.shopId = shopId;
        }
        if ((seen0 & 8) == 0) {
            this.skuNum = 0L;
        } else {
            this.skuNum = skuNum;
        }
    }

    public AdGood(long itemId, long skuId, long shopId, long skuNum) {
        this.itemId = itemId;
        this.skuId = skuId;
        this.shopId = shopId;
        this.skuNum = skuNum;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdGood self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.itemId != 0) {
            output.encodeLongElement(serialDesc, 0, self.itemId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.skuId != 0) {
            output.encodeLongElement(serialDesc, 1, self.skuId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.shopId != 0) {
            output.encodeLongElement(serialDesc, 2, self.shopId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.skuNum != 0) {
            output.encodeLongElement(serialDesc, 3, self.skuNum);
        }
    }

    public /* synthetic */ AdGood(long j2, long j3, long j4, long j5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j2, (i & 2) != 0 ? 0L : j3, (i & 4) != 0 ? 0L : j4, (i & 8) == 0 ? j5 : 0L);
    }

    public final long getItemId() {
        return this.itemId;
    }

    public final long getSkuId() {
        return this.skuId;
    }

    public final long getShopId() {
        return this.shopId;
    }

    public final long getSkuNum() {
        return this.skuNum;
    }
}