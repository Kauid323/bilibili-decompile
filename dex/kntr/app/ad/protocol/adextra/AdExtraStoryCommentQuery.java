package kntr.app.ad.protocol.adextra;

import BottomSheetItemData$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAdExtraQuery.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Be\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jl\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011¨\u0006*"}, d2 = {"Lkntr/app/ad/protocol/adextra/AdExtraStoryCommentQuery;", "Lkntr/app/ad/protocol/adextra/IAdExtraQuery;", "isAd", RoomRecommendViewModel.EMPTY_CURSOR, "natureAd", RoomRecommendViewModel.EMPTY_CURSOR, "ocpxTargetType", "linkedCreativeId", RoomRecommendViewModel.EMPTY_CURSOR, "trackId", "aiTrackId", "sourceId", "requestId", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "()Z", "getNatureAd", "()Ljava/lang/String;", "getOcpxTargetType", "getLinkedCreativeId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTrackId", "getAiTrackId", "getSourceId", "getRequestId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lkntr/app/ad/protocol/adextra/AdExtraStoryCommentQuery;", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "protocol_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdExtraStoryCommentQuery implements IAdExtraQuery {
    private final String aiTrackId;
    private final boolean isAd;
    private final Long linkedCreativeId;
    private final String natureAd;
    private final String ocpxTargetType;
    private final String requestId;
    private final Long sourceId;
    private final String trackId;

    public final boolean component1() {
        return this.isAd;
    }

    public final String component2() {
        return this.natureAd;
    }

    public final String component3() {
        return this.ocpxTargetType;
    }

    public final Long component4() {
        return this.linkedCreativeId;
    }

    public final String component5() {
        return this.trackId;
    }

    public final String component6() {
        return this.aiTrackId;
    }

    public final Long component7() {
        return this.sourceId;
    }

    public final String component8() {
        return this.requestId;
    }

    public final AdExtraStoryCommentQuery copy(boolean z, String str, String str2, Long l, String str3, String str4, Long l2, String str5) {
        return new AdExtraStoryCommentQuery(z, str, str2, l, str3, str4, l2, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdExtraStoryCommentQuery) {
            AdExtraStoryCommentQuery adExtraStoryCommentQuery = (AdExtraStoryCommentQuery) obj;
            return this.isAd == adExtraStoryCommentQuery.isAd && Intrinsics.areEqual(this.natureAd, adExtraStoryCommentQuery.natureAd) && Intrinsics.areEqual(this.ocpxTargetType, adExtraStoryCommentQuery.ocpxTargetType) && Intrinsics.areEqual(this.linkedCreativeId, adExtraStoryCommentQuery.linkedCreativeId) && Intrinsics.areEqual(this.trackId, adExtraStoryCommentQuery.trackId) && Intrinsics.areEqual(this.aiTrackId, adExtraStoryCommentQuery.aiTrackId) && Intrinsics.areEqual(this.sourceId, adExtraStoryCommentQuery.sourceId) && Intrinsics.areEqual(this.requestId, adExtraStoryCommentQuery.requestId);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isAd) * 31) + (this.natureAd == null ? 0 : this.natureAd.hashCode())) * 31) + (this.ocpxTargetType == null ? 0 : this.ocpxTargetType.hashCode())) * 31) + (this.linkedCreativeId == null ? 0 : this.linkedCreativeId.hashCode())) * 31) + (this.trackId == null ? 0 : this.trackId.hashCode())) * 31) + (this.aiTrackId == null ? 0 : this.aiTrackId.hashCode())) * 31) + (this.sourceId == null ? 0 : this.sourceId.hashCode())) * 31) + (this.requestId != null ? this.requestId.hashCode() : 0);
    }

    public String toString() {
        boolean z = this.isAd;
        String str = this.natureAd;
        String str2 = this.ocpxTargetType;
        Long l = this.linkedCreativeId;
        String str3 = this.trackId;
        String str4 = this.aiTrackId;
        Long l2 = this.sourceId;
        return "AdExtraStoryCommentQuery(isAd=" + z + ", natureAd=" + str + ", ocpxTargetType=" + str2 + ", linkedCreativeId=" + l + ", trackId=" + str3 + ", aiTrackId=" + str4 + ", sourceId=" + l2 + ", requestId=" + this.requestId + ")";
    }

    public AdExtraStoryCommentQuery(boolean isAd, String natureAd, String ocpxTargetType, Long linkedCreativeId, String trackId, String aiTrackId, Long sourceId, String requestId) {
        this.isAd = isAd;
        this.natureAd = natureAd;
        this.ocpxTargetType = ocpxTargetType;
        this.linkedCreativeId = linkedCreativeId;
        this.trackId = trackId;
        this.aiTrackId = aiTrackId;
        this.sourceId = sourceId;
        this.requestId = requestId;
    }

    public /* synthetic */ AdExtraStoryCommentQuery(boolean z, String str, String str2, Long l, String str3, String str4, Long l2, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : l2, (i & 128) == 0 ? str5 : null);
    }

    public final boolean isAd() {
        return this.isAd;
    }

    public final String getNatureAd() {
        return this.natureAd;
    }

    public final String getOcpxTargetType() {
        return this.ocpxTargetType;
    }

    public final Long getLinkedCreativeId() {
        return this.linkedCreativeId;
    }

    public final String getTrackId() {
        return this.trackId;
    }

    public final String getAiTrackId() {
        return this.aiTrackId;
    }

    public final Long getSourceId() {
        return this.sourceId;
    }

    public final String getRequestId() {
        return this.requestId;
    }
}