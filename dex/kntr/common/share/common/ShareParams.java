package kntr.common.share.common;

import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareParams.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001#BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0003JK\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lkntr/common/share/common/ShareParams;", "", "shareId", "", "oid", "shareOrigin", "sid", "pageInfo", "Lkntr/common/share/common/ShareParams$PageInfo;", "customChannels", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/common/share/common/ShareParams$PageInfo;Ljava/util/List;)V", "getShareId", "()Ljava/lang/String;", "getOid", "getShareOrigin", "getSid", "getPageInfo", "()Lkntr/common/share/common/ShareParams$PageInfo;", "getCustomChannels", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "PageInfo", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareParams {
    public static final int $stable = 8;
    private final List<String> customChannels;
    private final String oid;
    private final PageInfo pageInfo;
    private final String shareId;
    private final String shareOrigin;
    private final String sid;

    public static /* synthetic */ ShareParams copy$default(ShareParams shareParams, String str, String str2, String str3, String str4, PageInfo pageInfo, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shareParams.shareId;
        }
        if ((i & 2) != 0) {
            str2 = shareParams.oid;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = shareParams.shareOrigin;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = shareParams.sid;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            pageInfo = shareParams.pageInfo;
        }
        PageInfo pageInfo2 = pageInfo;
        List<String> list2 = list;
        if ((i & 32) != 0) {
            list2 = shareParams.customChannels;
        }
        return shareParams.copy(str, str5, str6, str7, pageInfo2, list2);
    }

    public final String component1() {
        return this.shareId;
    }

    public final String component2() {
        return this.oid;
    }

    public final String component3() {
        return this.shareOrigin;
    }

    public final String component4() {
        return this.sid;
    }

    public final PageInfo component5() {
        return this.pageInfo;
    }

    public final List<String> component6() {
        return this.customChannels;
    }

    public final ShareParams copy(String str, String str2, String str3, String str4, PageInfo pageInfo, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "shareId");
        Intrinsics.checkNotNullParameter(str2, "oid");
        Intrinsics.checkNotNullParameter(str3, "shareOrigin");
        Intrinsics.checkNotNullParameter(str4, "sid");
        Intrinsics.checkNotNullParameter(pageInfo, "pageInfo");
        Intrinsics.checkNotNullParameter(list, "customChannels");
        return new ShareParams(str, str2, str3, str4, pageInfo, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShareParams) {
            ShareParams shareParams = (ShareParams) obj;
            return Intrinsics.areEqual(this.shareId, shareParams.shareId) && Intrinsics.areEqual(this.oid, shareParams.oid) && Intrinsics.areEqual(this.shareOrigin, shareParams.shareOrigin) && Intrinsics.areEqual(this.sid, shareParams.sid) && Intrinsics.areEqual(this.pageInfo, shareParams.pageInfo) && Intrinsics.areEqual(this.customChannels, shareParams.customChannels);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.shareId.hashCode() * 31) + this.oid.hashCode()) * 31) + this.shareOrigin.hashCode()) * 31) + this.sid.hashCode()) * 31) + this.pageInfo.hashCode()) * 31) + this.customChannels.hashCode();
    }

    public String toString() {
        String str = this.shareId;
        String str2 = this.oid;
        String str3 = this.shareOrigin;
        String str4 = this.sid;
        PageInfo pageInfo = this.pageInfo;
        return "ShareParams(shareId=" + str + ", oid=" + str2 + ", shareOrigin=" + str3 + ", sid=" + str4 + ", pageInfo=" + pageInfo + ", customChannels=" + this.customChannels + ")";
    }

    public ShareParams(String shareId, String oid, String shareOrigin, String sid, PageInfo pageInfo, List<String> list) {
        Intrinsics.checkNotNullParameter(shareId, "shareId");
        Intrinsics.checkNotNullParameter(oid, "oid");
        Intrinsics.checkNotNullParameter(shareOrigin, "shareOrigin");
        Intrinsics.checkNotNullParameter(sid, "sid");
        Intrinsics.checkNotNullParameter(pageInfo, "pageInfo");
        Intrinsics.checkNotNullParameter(list, "customChannels");
        this.shareId = shareId;
        this.oid = oid;
        this.shareOrigin = shareOrigin;
        this.sid = sid;
        this.pageInfo = pageInfo;
        this.customChannels = list;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ShareParams(String str, String str2, String str3, String str4, PageInfo pageInfo, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, r14, r15);
        PageInfo pageInfo2;
        List list2;
        if ((i & 16) == 0) {
            pageInfo2 = pageInfo;
        } else {
            pageInfo2 = new PageInfo(null, null, null, null, null, 31, null);
        }
        if ((i & 32) == 0) {
            list2 = list;
        } else {
            list2 = CollectionsKt.emptyList();
        }
    }

    public final String getShareId() {
        return this.shareId;
    }

    public final String getOid() {
        return this.oid;
    }

    public final String getShareOrigin() {
        return this.shareOrigin;
    }

    public final String getSid() {
        return this.sid;
    }

    public final PageInfo getPageInfo() {
        return this.pageInfo;
    }

    public final List<String> getCustomChannels() {
        return this.customChannels;
    }

    /* compiled from: ShareParams.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JO\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lkntr/common/share/common/ShareParams$PageInfo;", "", "spmid", "", "from", "fromSpmid", "extraFields", "", "tag", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "getSpmid", "()Ljava/lang/String;", "getFrom", "getFromSpmid", "getExtraFields", "()Ljava/util/Map;", "getTag", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class PageInfo {
        public static final int $stable = 8;
        private final Map<String, String> extraFields;
        private final String from;
        private final String fromSpmid;
        private final String spmid;
        private final String tag;

        public PageInfo() {
            this(null, null, null, null, null, 31, null);
        }

        public static /* synthetic */ PageInfo copy$default(PageInfo pageInfo, String str, String str2, String str3, Map map, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pageInfo.spmid;
            }
            if ((i & 2) != 0) {
                str2 = pageInfo.from;
            }
            String str5 = str2;
            if ((i & 4) != 0) {
                str3 = pageInfo.fromSpmid;
            }
            String str6 = str3;
            Map<String, String> map2 = map;
            if ((i & 8) != 0) {
                map2 = pageInfo.extraFields;
            }
            Map map3 = map2;
            if ((i & 16) != 0) {
                str4 = pageInfo.tag;
            }
            return pageInfo.copy(str, str5, str6, map3, str4);
        }

        public final String component1() {
            return this.spmid;
        }

        public final String component2() {
            return this.from;
        }

        public final String component3() {
            return this.fromSpmid;
        }

        public final Map<String, String> component4() {
            return this.extraFields;
        }

        public final String component5() {
            return this.tag;
        }

        public final PageInfo copy(String str, String str2, String str3, Map<String, String> map, String str4) {
            Intrinsics.checkNotNullParameter(str, "spmid");
            return new PageInfo(str, str2, str3, map, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PageInfo) {
                PageInfo pageInfo = (PageInfo) obj;
                return Intrinsics.areEqual(this.spmid, pageInfo.spmid) && Intrinsics.areEqual(this.from, pageInfo.from) && Intrinsics.areEqual(this.fromSpmid, pageInfo.fromSpmid) && Intrinsics.areEqual(this.extraFields, pageInfo.extraFields) && Intrinsics.areEqual(this.tag, pageInfo.tag);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.spmid.hashCode() * 31) + (this.from == null ? 0 : this.from.hashCode())) * 31) + (this.fromSpmid == null ? 0 : this.fromSpmid.hashCode())) * 31) + (this.extraFields == null ? 0 : this.extraFields.hashCode())) * 31) + (this.tag != null ? this.tag.hashCode() : 0);
        }

        public String toString() {
            String str = this.spmid;
            String str2 = this.from;
            String str3 = this.fromSpmid;
            Map<String, String> map = this.extraFields;
            return "PageInfo(spmid=" + str + ", from=" + str2 + ", fromSpmid=" + str3 + ", extraFields=" + map + ", tag=" + this.tag + ")";
        }

        public PageInfo(String spmid, String from, String fromSpmid, Map<String, String> map, String tag) {
            Intrinsics.checkNotNullParameter(spmid, "spmid");
            this.spmid = spmid;
            this.from = from;
            this.fromSpmid = fromSpmid;
            this.extraFields = map;
            this.tag = tag;
        }

        public /* synthetic */ PageInfo(String str, String str2, String str3, Map map, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) == 0 ? map : null, (i & 16) != 0 ? "" : str4);
        }

        public final String getSpmid() {
            return this.spmid;
        }

        public final String getFrom() {
            return this.from;
        }

        public final String getFromSpmid() {
            return this.fromSpmid;
        }

        public final Map<String, String> getExtraFields() {
            return this.extraFields;
        }

        public final String getTag() {
            return this.tag;
        }
    }
}