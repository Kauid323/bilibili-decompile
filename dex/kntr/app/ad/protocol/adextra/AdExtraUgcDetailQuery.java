package kntr.app.ad.protocol.adextra;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAdExtraQuery.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B}\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0084\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\u0003HÖ\u0001J\t\u00102\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015¨\u00063"}, d2 = {"Lkntr/app/ad/protocol/adextra/AdExtraUgcDetailQuery;", "Lkntr/app/ad/protocol/adextra/IAdExtraQuery;", "nativeMode", RoomRecommendViewModel.EMPTY_CURSOR, "caid", RoomRecommendViewModel.EMPTY_CURSOR, "ocpxTargetType", "linkedCreativeId", RoomRecommendViewModel.EMPTY_CURSOR, "sourceId", "fromSpmid", "trackId", "natureAd", "viewQuery", "Lkntr/app/ad/protocol/adextra/AdViewQuery;", "bizExtra", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/protocol/adextra/AdViewQuery;Ljava/lang/String;)V", "getNativeMode", "()I", "getCaid", "()Ljava/lang/String;", "getOcpxTargetType", "getLinkedCreativeId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSourceId", "getFromSpmid", "getTrackId", "getNatureAd", "getViewQuery", "()Lkntr/app/ad/protocol/adextra/AdViewQuery;", "getBizExtra", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/protocol/adextra/AdViewQuery;Ljava/lang/String;)Lkntr/app/ad/protocol/adextra/AdExtraUgcDetailQuery;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "protocol_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdExtraUgcDetailQuery implements IAdExtraQuery {
    private final String bizExtra;
    private final String caid;
    private final String fromSpmid;
    private final Long linkedCreativeId;
    private final int nativeMode;
    private final String natureAd;
    private final String ocpxTargetType;
    private final Long sourceId;
    private final String trackId;
    private final AdViewQuery viewQuery;

    public final int component1() {
        return this.nativeMode;
    }

    public final String component10() {
        return this.bizExtra;
    }

    public final String component2() {
        return this.caid;
    }

    public final String component3() {
        return this.ocpxTargetType;
    }

    public final Long component4() {
        return this.linkedCreativeId;
    }

    public final Long component5() {
        return this.sourceId;
    }

    public final String component6() {
        return this.fromSpmid;
    }

    public final String component7() {
        return this.trackId;
    }

    public final String component8() {
        return this.natureAd;
    }

    public final AdViewQuery component9() {
        return this.viewQuery;
    }

    public final AdExtraUgcDetailQuery copy(int i, String str, String str2, Long l, Long l2, String str3, String str4, String str5, AdViewQuery adViewQuery, String str6) {
        return new AdExtraUgcDetailQuery(i, str, str2, l, l2, str3, str4, str5, adViewQuery, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdExtraUgcDetailQuery) {
            AdExtraUgcDetailQuery adExtraUgcDetailQuery = (AdExtraUgcDetailQuery) obj;
            return this.nativeMode == adExtraUgcDetailQuery.nativeMode && Intrinsics.areEqual(this.caid, adExtraUgcDetailQuery.caid) && Intrinsics.areEqual(this.ocpxTargetType, adExtraUgcDetailQuery.ocpxTargetType) && Intrinsics.areEqual(this.linkedCreativeId, adExtraUgcDetailQuery.linkedCreativeId) && Intrinsics.areEqual(this.sourceId, adExtraUgcDetailQuery.sourceId) && Intrinsics.areEqual(this.fromSpmid, adExtraUgcDetailQuery.fromSpmid) && Intrinsics.areEqual(this.trackId, adExtraUgcDetailQuery.trackId) && Intrinsics.areEqual(this.natureAd, adExtraUgcDetailQuery.natureAd) && Intrinsics.areEqual(this.viewQuery, adExtraUgcDetailQuery.viewQuery) && Intrinsics.areEqual(this.bizExtra, adExtraUgcDetailQuery.bizExtra);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((this.nativeMode * 31) + (this.caid == null ? 0 : this.caid.hashCode())) * 31) + (this.ocpxTargetType == null ? 0 : this.ocpxTargetType.hashCode())) * 31) + (this.linkedCreativeId == null ? 0 : this.linkedCreativeId.hashCode())) * 31) + (this.sourceId == null ? 0 : this.sourceId.hashCode())) * 31) + (this.fromSpmid == null ? 0 : this.fromSpmid.hashCode())) * 31) + (this.trackId == null ? 0 : this.trackId.hashCode())) * 31) + (this.natureAd == null ? 0 : this.natureAd.hashCode())) * 31) + (this.viewQuery == null ? 0 : this.viewQuery.hashCode())) * 31) + (this.bizExtra != null ? this.bizExtra.hashCode() : 0);
    }

    public String toString() {
        int i = this.nativeMode;
        String str = this.caid;
        String str2 = this.ocpxTargetType;
        Long l = this.linkedCreativeId;
        Long l2 = this.sourceId;
        String str3 = this.fromSpmid;
        String str4 = this.trackId;
        String str5 = this.natureAd;
        AdViewQuery adViewQuery = this.viewQuery;
        return "AdExtraUgcDetailQuery(nativeMode=" + i + ", caid=" + str + ", ocpxTargetType=" + str2 + ", linkedCreativeId=" + l + ", sourceId=" + l2 + ", fromSpmid=" + str3 + ", trackId=" + str4 + ", natureAd=" + str5 + ", viewQuery=" + adViewQuery + ", bizExtra=" + this.bizExtra + ")";
    }

    public AdExtraUgcDetailQuery(int nativeMode, String caid, String ocpxTargetType, Long linkedCreativeId, Long sourceId, String fromSpmid, String trackId, String natureAd, AdViewQuery viewQuery, String bizExtra) {
        this.nativeMode = nativeMode;
        this.caid = caid;
        this.ocpxTargetType = ocpxTargetType;
        this.linkedCreativeId = linkedCreativeId;
        this.sourceId = sourceId;
        this.fromSpmid = fromSpmid;
        this.trackId = trackId;
        this.natureAd = natureAd;
        this.viewQuery = viewQuery;
        this.bizExtra = bizExtra;
    }

    public /* synthetic */ AdExtraUgcDetailQuery(int i, String str, String str2, Long l, Long l2, String str3, String str4, String str5, AdViewQuery adViewQuery, String str6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : l, (i2 & 16) != 0 ? null : l2, (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? null : str4, (i2 & 128) != 0 ? null : str5, (i2 & 256) != 0 ? null : adViewQuery, (i2 & 512) == 0 ? str6 : null);
    }

    public final int getNativeMode() {
        return this.nativeMode;
    }

    public final String getCaid() {
        return this.caid;
    }

    public final String getOcpxTargetType() {
        return this.ocpxTargetType;
    }

    public final Long getLinkedCreativeId() {
        return this.linkedCreativeId;
    }

    public final Long getSourceId() {
        return this.sourceId;
    }

    public final String getFromSpmid() {
        return this.fromSpmid;
    }

    public final String getTrackId() {
        return this.trackId;
    }

    public final String getNatureAd() {
        return this.natureAd;
    }

    public final AdViewQuery getViewQuery() {
        return this.viewQuery;
    }

    public final String getBizExtra() {
        return this.bizExtra;
    }
}