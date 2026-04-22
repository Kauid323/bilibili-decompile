package kntr.app.ad.protocol.adextra;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAdExtraQuery.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u00015B\u008d\u0001\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0092\u0001\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013¨\u00066"}, d2 = {"Lkntr/app/ad/protocol/adextra/AdExtraUgcCommentQuery;", "Lkntr/app/ad/protocol/adextra/IAdExtraQuery;", "caid", RoomRecommendViewModel.EMPTY_CURSOR, "aiFromTrackId", "aiTrackId", "natureAd", "ocpxTargetType", "linkedCreativeId", RoomRecommendViewModel.EMPTY_CURSOR, "sourceId", "fromSpmid", "trackId", "commentQuery", "Lkntr/app/ad/protocol/adextra/AdExtraUgcCommentQuery$CommentQuery;", "bizExtra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/protocol/adextra/AdExtraUgcCommentQuery$CommentQuery;Ljava/lang/String;)V", "getCaid", "()Ljava/lang/String;", "getAiFromTrackId", "getAiTrackId", "getNatureAd", "getOcpxTargetType", "getLinkedCreativeId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSourceId", "getFromSpmid", "getTrackId", "getCommentQuery", "()Lkntr/app/ad/protocol/adextra/AdExtraUgcCommentQuery$CommentQuery;", "getBizExtra", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lkntr/app/ad/protocol/adextra/AdExtraUgcCommentQuery$CommentQuery;Ljava/lang/String;)Lkntr/app/ad/protocol/adextra/AdExtraUgcCommentQuery;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "CommentQuery", "protocol_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdExtraUgcCommentQuery implements IAdExtraQuery {
    private final String aiFromTrackId;
    private final String aiTrackId;
    private final String bizExtra;
    private final String caid;
    private final CommentQuery commentQuery;
    private final String fromSpmid;
    private final Long linkedCreativeId;
    private final String natureAd;
    private final String ocpxTargetType;
    private final Long sourceId;
    private final String trackId;

    public AdExtraUgcCommentQuery() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public final String component1() {
        return this.caid;
    }

    public final CommentQuery component10() {
        return this.commentQuery;
    }

    public final String component11() {
        return this.bizExtra;
    }

    public final String component2() {
        return this.aiFromTrackId;
    }

    public final String component3() {
        return this.aiTrackId;
    }

    public final String component4() {
        return this.natureAd;
    }

    public final String component5() {
        return this.ocpxTargetType;
    }

    public final Long component6() {
        return this.linkedCreativeId;
    }

    public final Long component7() {
        return this.sourceId;
    }

    public final String component8() {
        return this.fromSpmid;
    }

    public final String component9() {
        return this.trackId;
    }

    public final AdExtraUgcCommentQuery copy(String str, String str2, String str3, String str4, String str5, Long l, Long l2, String str6, String str7, CommentQuery commentQuery, String str8) {
        return new AdExtraUgcCommentQuery(str, str2, str3, str4, str5, l, l2, str6, str7, commentQuery, str8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdExtraUgcCommentQuery) {
            AdExtraUgcCommentQuery adExtraUgcCommentQuery = (AdExtraUgcCommentQuery) obj;
            return Intrinsics.areEqual(this.caid, adExtraUgcCommentQuery.caid) && Intrinsics.areEqual(this.aiFromTrackId, adExtraUgcCommentQuery.aiFromTrackId) && Intrinsics.areEqual(this.aiTrackId, adExtraUgcCommentQuery.aiTrackId) && Intrinsics.areEqual(this.natureAd, adExtraUgcCommentQuery.natureAd) && Intrinsics.areEqual(this.ocpxTargetType, adExtraUgcCommentQuery.ocpxTargetType) && Intrinsics.areEqual(this.linkedCreativeId, adExtraUgcCommentQuery.linkedCreativeId) && Intrinsics.areEqual(this.sourceId, adExtraUgcCommentQuery.sourceId) && Intrinsics.areEqual(this.fromSpmid, adExtraUgcCommentQuery.fromSpmid) && Intrinsics.areEqual(this.trackId, adExtraUgcCommentQuery.trackId) && Intrinsics.areEqual(this.commentQuery, adExtraUgcCommentQuery.commentQuery) && Intrinsics.areEqual(this.bizExtra, adExtraUgcCommentQuery.bizExtra);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((this.caid == null ? 0 : this.caid.hashCode()) * 31) + (this.aiFromTrackId == null ? 0 : this.aiFromTrackId.hashCode())) * 31) + (this.aiTrackId == null ? 0 : this.aiTrackId.hashCode())) * 31) + (this.natureAd == null ? 0 : this.natureAd.hashCode())) * 31) + (this.ocpxTargetType == null ? 0 : this.ocpxTargetType.hashCode())) * 31) + (this.linkedCreativeId == null ? 0 : this.linkedCreativeId.hashCode())) * 31) + (this.sourceId == null ? 0 : this.sourceId.hashCode())) * 31) + (this.fromSpmid == null ? 0 : this.fromSpmid.hashCode())) * 31) + (this.trackId == null ? 0 : this.trackId.hashCode())) * 31) + (this.commentQuery == null ? 0 : this.commentQuery.hashCode())) * 31) + (this.bizExtra != null ? this.bizExtra.hashCode() : 0);
    }

    public String toString() {
        String str = this.caid;
        String str2 = this.aiFromTrackId;
        String str3 = this.aiTrackId;
        String str4 = this.natureAd;
        String str5 = this.ocpxTargetType;
        Long l = this.linkedCreativeId;
        Long l2 = this.sourceId;
        String str6 = this.fromSpmid;
        String str7 = this.trackId;
        CommentQuery commentQuery = this.commentQuery;
        return "AdExtraUgcCommentQuery(caid=" + str + ", aiFromTrackId=" + str2 + ", aiTrackId=" + str3 + ", natureAd=" + str4 + ", ocpxTargetType=" + str5 + ", linkedCreativeId=" + l + ", sourceId=" + l2 + ", fromSpmid=" + str6 + ", trackId=" + str7 + ", commentQuery=" + commentQuery + ", bizExtra=" + this.bizExtra + ")";
    }

    public AdExtraUgcCommentQuery(String caid, String aiFromTrackId, String aiTrackId, String natureAd, String ocpxTargetType, Long linkedCreativeId, Long sourceId, String fromSpmid, String trackId, CommentQuery commentQuery, String bizExtra) {
        this.caid = caid;
        this.aiFromTrackId = aiFromTrackId;
        this.aiTrackId = aiTrackId;
        this.natureAd = natureAd;
        this.ocpxTargetType = ocpxTargetType;
        this.linkedCreativeId = linkedCreativeId;
        this.sourceId = sourceId;
        this.fromSpmid = fromSpmid;
        this.trackId = trackId;
        this.commentQuery = commentQuery;
        this.bizExtra = bizExtra;
    }

    public /* synthetic */ AdExtraUgcCommentQuery(String str, String str2, String str3, String str4, String str5, Long l, Long l2, String str6, String str7, CommentQuery commentQuery, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : l, (i & 64) != 0 ? null : l2, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : commentQuery, (i & 1024) == 0 ? str8 : null);
    }

    public final String getCaid() {
        return this.caid;
    }

    public final String getAiFromTrackId() {
        return this.aiFromTrackId;
    }

    public final String getAiTrackId() {
        return this.aiTrackId;
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

    public final Long getSourceId() {
        return this.sourceId;
    }

    public final String getFromSpmid() {
        return this.fromSpmid;
    }

    public final String getTrackId() {
        return this.trackId;
    }

    public final CommentQuery getCommentQuery() {
        return this.commentQuery;
    }

    public final String getBizExtra() {
        return this.bizExtra;
    }

    /* compiled from: IAdExtraQuery.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bi\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003Jn\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006)"}, d2 = {"Lkntr/app/ad/protocol/adextra/AdExtraUgcCommentQuery$CommentQuery;", RoomRecommendViewModel.EMPTY_CURSOR, "requestId", RoomRecommendViewModel.EMPTY_CURSOR, "resourceId", RoomRecommendViewModel.EMPTY_CURSOR, "fromTrackId", "titleEncode", "titleMaterialId", "imageMaterialId", "tabClickFrom", "cardAdStyle", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRequestId", "()Ljava/lang/String;", "getResourceId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFromTrackId", "getTitleEncode", "getTitleMaterialId", "getImageMaterialId", "getTabClickFrom", "getCardAdStyle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/ad/protocol/adextra/AdExtraUgcCommentQuery$CommentQuery;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "protocol_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CommentQuery {
        private final String cardAdStyle;
        private final String fromTrackId;
        private final String imageMaterialId;
        private final String requestId;
        private final Long resourceId;
        private final String tabClickFrom;
        private final String titleEncode;
        private final String titleMaterialId;

        public CommentQuery() {
            this(null, null, null, null, null, null, null, null, 255, null);
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

        public final CommentQuery copy(String str, Long l, String str2, String str3, String str4, String str5, String str6, String str7) {
            return new CommentQuery(str, l, str2, str3, str4, str5, str6, str7);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CommentQuery) {
                CommentQuery commentQuery = (CommentQuery) obj;
                return Intrinsics.areEqual(this.requestId, commentQuery.requestId) && Intrinsics.areEqual(this.resourceId, commentQuery.resourceId) && Intrinsics.areEqual(this.fromTrackId, commentQuery.fromTrackId) && Intrinsics.areEqual(this.titleEncode, commentQuery.titleEncode) && Intrinsics.areEqual(this.titleMaterialId, commentQuery.titleMaterialId) && Intrinsics.areEqual(this.imageMaterialId, commentQuery.imageMaterialId) && Intrinsics.areEqual(this.tabClickFrom, commentQuery.tabClickFrom) && Intrinsics.areEqual(this.cardAdStyle, commentQuery.cardAdStyle);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((this.requestId == null ? 0 : this.requestId.hashCode()) * 31) + (this.resourceId == null ? 0 : this.resourceId.hashCode())) * 31) + (this.fromTrackId == null ? 0 : this.fromTrackId.hashCode())) * 31) + (this.titleEncode == null ? 0 : this.titleEncode.hashCode())) * 31) + (this.titleMaterialId == null ? 0 : this.titleMaterialId.hashCode())) * 31) + (this.imageMaterialId == null ? 0 : this.imageMaterialId.hashCode())) * 31) + (this.tabClickFrom == null ? 0 : this.tabClickFrom.hashCode())) * 31) + (this.cardAdStyle != null ? this.cardAdStyle.hashCode() : 0);
        }

        public String toString() {
            String str = this.requestId;
            Long l = this.resourceId;
            String str2 = this.fromTrackId;
            String str3 = this.titleEncode;
            String str4 = this.titleMaterialId;
            String str5 = this.imageMaterialId;
            String str6 = this.tabClickFrom;
            return "CommentQuery(requestId=" + str + ", resourceId=" + l + ", fromTrackId=" + str2 + ", titleEncode=" + str3 + ", titleMaterialId=" + str4 + ", imageMaterialId=" + str5 + ", tabClickFrom=" + str6 + ", cardAdStyle=" + this.cardAdStyle + ")";
        }

        public CommentQuery(String requestId, Long resourceId, String fromTrackId, String titleEncode, String titleMaterialId, String imageMaterialId, String tabClickFrom, String cardAdStyle) {
            this.requestId = requestId;
            this.resourceId = resourceId;
            this.fromTrackId = fromTrackId;
            this.titleEncode = titleEncode;
            this.titleMaterialId = titleMaterialId;
            this.imageMaterialId = imageMaterialId;
            this.tabClickFrom = tabClickFrom;
            this.cardAdStyle = cardAdStyle;
        }

        public /* synthetic */ CommentQuery(String str, Long l, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) == 0 ? str7 : null);
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
    }
}