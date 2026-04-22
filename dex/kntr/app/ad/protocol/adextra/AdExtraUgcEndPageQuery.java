package kntr.app.ad.protocol.adextra;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAdExtraQuery.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0013B\u0017\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lkntr/app/ad/protocol/adextra/AdExtraUgcEndPageQuery;", "Lkntr/app/ad/protocol/adextra/IAdExtraQuery;", "ctxAds", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/protocol/adextra/AdExtraUgcEndPageQuery$CtxAd;", "<init>", "(Ljava/util/List;)V", "getCtxAds", "()Ljava/util/List;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "CtxAd", "protocol_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdExtraUgcEndPageQuery implements IAdExtraQuery {
    private final List<CtxAd> ctxAds;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdExtraUgcEndPageQuery copy$default(AdExtraUgcEndPageQuery adExtraUgcEndPageQuery, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = adExtraUgcEndPageQuery.ctxAds;
        }
        return adExtraUgcEndPageQuery.copy(list);
    }

    public final List<CtxAd> component1() {
        return this.ctxAds;
    }

    public final AdExtraUgcEndPageQuery copy(List<CtxAd> list) {
        Intrinsics.checkNotNullParameter(list, "ctxAds");
        return new AdExtraUgcEndPageQuery(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AdExtraUgcEndPageQuery) && Intrinsics.areEqual(this.ctxAds, ((AdExtraUgcEndPageQuery) obj).ctxAds);
    }

    public int hashCode() {
        return this.ctxAds.hashCode();
    }

    public String toString() {
        return "AdExtraUgcEndPageQuery(ctxAds=" + this.ctxAds + ")";
    }

    public AdExtraUgcEndPageQuery(List<CtxAd> list) {
        Intrinsics.checkNotNullParameter(list, "ctxAds");
        this.ctxAds = list;
    }

    public final List<CtxAd> getCtxAds() {
        return this.ctxAds;
    }

    /* compiled from: IAdExtraQuery.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lkntr/app/ad/protocol/adextra/AdExtraUgcEndPageQuery$CtxAd;", RoomRecommendViewModel.EMPTY_CURSOR, "resourceId", RoomRecommendViewModel.EMPTY_CURSOR, "sourceId", "creativeId", "index", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(JJJI)V", "getResourceId", "()J", "getSourceId", "getCreativeId", "getIndex", "()I", "component1", "component2", "component3", "component4", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "protocol_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CtxAd {
        private final long creativeId;
        private final int index;
        private final long resourceId;
        private final long sourceId;

        public final long component1() {
            return this.resourceId;
        }

        public final long component2() {
            return this.sourceId;
        }

        public final long component3() {
            return this.creativeId;
        }

        public final int component4() {
            return this.index;
        }

        public final CtxAd copy(long j2, long j3, long j4, int i) {
            return new CtxAd(j2, j3, j4, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CtxAd) {
                CtxAd ctxAd = (CtxAd) obj;
                return this.resourceId == ctxAd.resourceId && this.sourceId == ctxAd.sourceId && this.creativeId == ctxAd.creativeId && this.index == ctxAd.index;
            }
            return false;
        }

        public int hashCode() {
            return (((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.resourceId) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.sourceId)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.creativeId)) * 31) + this.index;
        }

        public String toString() {
            long j2 = this.resourceId;
            long j3 = this.sourceId;
            long j4 = this.creativeId;
            return "CtxAd(resourceId=" + j2 + ", sourceId=" + j3 + ", creativeId=" + j4 + ", index=" + this.index + ")";
        }

        public CtxAd(long resourceId, long sourceId, long creativeId, int index) {
            this.resourceId = resourceId;
            this.sourceId = sourceId;
            this.creativeId = creativeId;
            this.index = index;
        }

        public final long getResourceId() {
            return this.resourceId;
        }

        public final long getSourceId() {
            return this.sourceId;
        }

        public final long getCreativeId() {
            return this.creativeId;
        }

        public final int getIndex() {
            return this.index;
        }
    }
}