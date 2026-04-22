package kntr.app.ad.protocol.adextra;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAdExtraQuery.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bu\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jz\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006,"}, d2 = {"Lkntr/app/ad/protocol/adextra/AdViewQuery;", RoomRecommendViewModel.EMPTY_CURSOR, "requestId", RoomRecommendViewModel.EMPTY_CURSOR, "resourceId", RoomRecommendViewModel.EMPTY_CURSOR, "fromTrackId", "titleEncode", "titleMaterialId", "imageMaterialId", "tabClickFrom", "cardAdStyle", "cmBackhaulExtra", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRequestId", "()Ljava/lang/String;", "getResourceId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFromTrackId", "getTitleEncode", "getTitleMaterialId", "getImageMaterialId", "getTabClickFrom", "getCardAdStyle", "getCmBackhaulExtra", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/ad/protocol/adextra/AdViewQuery;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "protocol_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdViewQuery {
    private final String cardAdStyle;
    private final String cmBackhaulExtra;
    private final String fromTrackId;
    private final String imageMaterialId;
    private final String requestId;
    private final Long resourceId;
    private final String tabClickFrom;
    private final String titleEncode;
    private final String titleMaterialId;

    public AdViewQuery() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public final String component1() {
        return this.requestId;
    }

    public final Long component2() {
        return this.resourceId;
    }

    public final String component3() {
        return this.fromTrackId;
    }

    public final String component4() {
        return this.titleEncode;
    }

    public final String component5() {
        return this.titleMaterialId;
    }

    public final String component6() {
        return this.imageMaterialId;
    }

    public final String component7() {
        return this.tabClickFrom;
    }

    public final String component8() {
        return this.cardAdStyle;
    }

    public final String component9() {
        return this.cmBackhaulExtra;
    }

    public final AdViewQuery copy(String str, Long l, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        return new AdViewQuery(str, l, str2, str3, str4, str5, str6, str7, str8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdViewQuery) {
            AdViewQuery adViewQuery = (AdViewQuery) obj;
            return Intrinsics.areEqual(this.requestId, adViewQuery.requestId) && Intrinsics.areEqual(this.resourceId, adViewQuery.resourceId) && Intrinsics.areEqual(this.fromTrackId, adViewQuery.fromTrackId) && Intrinsics.areEqual(this.titleEncode, adViewQuery.titleEncode) && Intrinsics.areEqual(this.titleMaterialId, adViewQuery.titleMaterialId) && Intrinsics.areEqual(this.imageMaterialId, adViewQuery.imageMaterialId) && Intrinsics.areEqual(this.tabClickFrom, adViewQuery.tabClickFrom) && Intrinsics.areEqual(this.cardAdStyle, adViewQuery.cardAdStyle) && Intrinsics.areEqual(this.cmBackhaulExtra, adViewQuery.cmBackhaulExtra);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((this.requestId == null ? 0 : this.requestId.hashCode()) * 31) + (this.resourceId == null ? 0 : this.resourceId.hashCode())) * 31) + (this.fromTrackId == null ? 0 : this.fromTrackId.hashCode())) * 31) + (this.titleEncode == null ? 0 : this.titleEncode.hashCode())) * 31) + (this.titleMaterialId == null ? 0 : this.titleMaterialId.hashCode())) * 31) + (this.imageMaterialId == null ? 0 : this.imageMaterialId.hashCode())) * 31) + (this.tabClickFrom == null ? 0 : this.tabClickFrom.hashCode())) * 31) + (this.cardAdStyle == null ? 0 : this.cardAdStyle.hashCode())) * 31) + (this.cmBackhaulExtra != null ? this.cmBackhaulExtra.hashCode() : 0);
    }

    public String toString() {
        String str = this.requestId;
        Long l = this.resourceId;
        String str2 = this.fromTrackId;
        String str3 = this.titleEncode;
        String str4 = this.titleMaterialId;
        String str5 = this.imageMaterialId;
        String str6 = this.tabClickFrom;
        String str7 = this.cardAdStyle;
        return "AdViewQuery(requestId=" + str + ", resourceId=" + l + ", fromTrackId=" + str2 + ", titleEncode=" + str3 + ", titleMaterialId=" + str4 + ", imageMaterialId=" + str5 + ", tabClickFrom=" + str6 + ", cardAdStyle=" + str7 + ", cmBackhaulExtra=" + this.cmBackhaulExtra + ")";
    }

    public AdViewQuery(String requestId, Long resourceId, String fromTrackId, String titleEncode, String titleMaterialId, String imageMaterialId, String tabClickFrom, String cardAdStyle, String cmBackhaulExtra) {
        this.requestId = requestId;
        this.resourceId = resourceId;
        this.fromTrackId = fromTrackId;
        this.titleEncode = titleEncode;
        this.titleMaterialId = titleMaterialId;
        this.imageMaterialId = imageMaterialId;
        this.tabClickFrom = tabClickFrom;
        this.cardAdStyle = cardAdStyle;
        this.cmBackhaulExtra = cmBackhaulExtra;
    }

    public /* synthetic */ AdViewQuery(String str, Long l, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) == 0 ? str8 : null);
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final Long getResourceId() {
        return this.resourceId;
    }

    public final String getFromTrackId() {
        return this.fromTrackId;
    }

    public final String getTitleEncode() {
        return this.titleEncode;
    }

    public final String getTitleMaterialId() {
        return this.titleMaterialId;
    }

    public final String getImageMaterialId() {
        return this.imageMaterialId;
    }

    public final String getTabClickFrom() {
        return this.tabClickFrom;
    }

    public final String getCardAdStyle() {
        return this.cardAdStyle;
    }

    public final String getCmBackhaulExtra() {
        return this.cmBackhaulExtra;
    }
}