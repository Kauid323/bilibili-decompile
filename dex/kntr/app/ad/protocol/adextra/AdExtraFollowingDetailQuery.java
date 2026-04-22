package kntr.app.ad.protocol.adextra;

import BottomSheetItemData$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAdExtraQuery.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003JT\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006%"}, d2 = {"Lkntr/app/ad/protocol/adextra/AdExtraFollowingDetailQuery;", "Lkntr/app/ad/protocol/adextra/IAdExtraQuery;", "forceReqType", RoomRecommendViewModel.EMPTY_CURSOR, "trackId", RoomRecommendViewModel.EMPTY_CURSOR, "fromSpmid", "linkedCreativeId", RoomRecommendViewModel.EMPTY_CURSOR, "requestId", "bizExtra", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getForceReqType", "()Z", "getTrackId", "()Ljava/lang/String;", "getFromSpmid", "getLinkedCreativeId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getRequestId", "getBizExtra", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/ad/protocol/adextra/AdExtraFollowingDetailQuery;", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "protocol_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdExtraFollowingDetailQuery implements IAdExtraQuery {
    private final String bizExtra;
    private final boolean forceReqType;
    private final String fromSpmid;
    private final Long linkedCreativeId;
    private final String requestId;
    private final String trackId;

    public static /* synthetic */ AdExtraFollowingDetailQuery copy$default(AdExtraFollowingDetailQuery adExtraFollowingDetailQuery, boolean z, String str, String str2, Long l, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = adExtraFollowingDetailQuery.forceReqType;
        }
        if ((i & 2) != 0) {
            str = adExtraFollowingDetailQuery.trackId;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = adExtraFollowingDetailQuery.fromSpmid;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            l = adExtraFollowingDetailQuery.linkedCreativeId;
        }
        Long l2 = l;
        if ((i & 16) != 0) {
            str3 = adExtraFollowingDetailQuery.requestId;
        }
        String str7 = str3;
        if ((i & 32) != 0) {
            str4 = adExtraFollowingDetailQuery.bizExtra;
        }
        return adExtraFollowingDetailQuery.copy(z, str5, str6, l2, str7, str4);
    }

    public final boolean component1() {
        return this.forceReqType;
    }

    public final String component2() {
        return this.trackId;
    }

    public final String component3() {
        return this.fromSpmid;
    }

    public final Long component4() {
        return this.linkedCreativeId;
    }

    public final String component5() {
        return this.requestId;
    }

    public final String component6() {
        return this.bizExtra;
    }

    public final AdExtraFollowingDetailQuery copy(boolean z, String str, String str2, Long l, String str3, String str4) {
        return new AdExtraFollowingDetailQuery(z, str, str2, l, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdExtraFollowingDetailQuery) {
            AdExtraFollowingDetailQuery adExtraFollowingDetailQuery = (AdExtraFollowingDetailQuery) obj;
            return this.forceReqType == adExtraFollowingDetailQuery.forceReqType && Intrinsics.areEqual(this.trackId, adExtraFollowingDetailQuery.trackId) && Intrinsics.areEqual(this.fromSpmid, adExtraFollowingDetailQuery.fromSpmid) && Intrinsics.areEqual(this.linkedCreativeId, adExtraFollowingDetailQuery.linkedCreativeId) && Intrinsics.areEqual(this.requestId, adExtraFollowingDetailQuery.requestId) && Intrinsics.areEqual(this.bizExtra, adExtraFollowingDetailQuery.bizExtra);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.forceReqType) * 31) + (this.trackId == null ? 0 : this.trackId.hashCode())) * 31) + (this.fromSpmid == null ? 0 : this.fromSpmid.hashCode())) * 31) + (this.linkedCreativeId == null ? 0 : this.linkedCreativeId.hashCode())) * 31) + (this.requestId == null ? 0 : this.requestId.hashCode())) * 31) + (this.bizExtra != null ? this.bizExtra.hashCode() : 0);
    }

    public String toString() {
        boolean z = this.forceReqType;
        String str = this.trackId;
        String str2 = this.fromSpmid;
        Long l = this.linkedCreativeId;
        String str3 = this.requestId;
        return "AdExtraFollowingDetailQuery(forceReqType=" + z + ", trackId=" + str + ", fromSpmid=" + str2 + ", linkedCreativeId=" + l + ", requestId=" + str3 + ", bizExtra=" + this.bizExtra + ")";
    }

    public AdExtraFollowingDetailQuery(boolean forceReqType, String trackId, String fromSpmid, Long linkedCreativeId, String requestId, String bizExtra) {
        this.forceReqType = forceReqType;
        this.trackId = trackId;
        this.fromSpmid = fromSpmid;
        this.linkedCreativeId = linkedCreativeId;
        this.requestId = requestId;
        this.bizExtra = bizExtra;
    }

    public /* synthetic */ AdExtraFollowingDetailQuery(boolean z, String str, String str2, Long l, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : str3, (i & 32) == 0 ? str4 : null);
    }

    public final boolean getForceReqType() {
        return this.forceReqType;
    }

    public final String getTrackId() {
        return this.trackId;
    }

    public final String getFromSpmid() {
        return this.fromSpmid;
    }

    public final Long getLinkedCreativeId() {
        return this.linkedCreativeId;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getBizExtra() {
        return this.bizExtra;
    }
}