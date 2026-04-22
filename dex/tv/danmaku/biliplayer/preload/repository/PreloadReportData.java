package tv.danmaku.biliplayer.preload.repository;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.coreV2.VideoBizType;
import tv.danmaku.videoplayer.coreV2.transformer.P2PParams;

/* compiled from: PreloadElement.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010%\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010BI\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0011J\u001b\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030 H\u0000¢\u0006\u0002\b%J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0017\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eHÆ\u0003Jm\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eHÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001f\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR)\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b!\u0010\u001e¨\u00065"}, d2 = {"Ltv/danmaku/biliplayer/preload/repository/PreloadReportData;", "", "id", "", "spmid", "fromSpmid", "aid", "", "trackerId", "reportBizType", "Ltv/danmaku/videoplayer/coreV2/VideoBizType;", "p2pParams", "Ltv/danmaku/videoplayer/coreV2/transformer/P2PParams;", "extraParams", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLtv/danmaku/videoplayer/coreV2/VideoBizType;Ltv/danmaku/videoplayer/coreV2/transformer/P2PParams;Ljava/util/Map;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLtv/danmaku/videoplayer/coreV2/VideoBizType;Ltv/danmaku/videoplayer/coreV2/transformer/P2PParams;)V", "getId", "()Ljava/lang/String;", "getSpmid", "getFromSpmid", "getAid", "()J", "getTrackerId", "getReportBizType", "()Ltv/danmaku/videoplayer/coreV2/VideoBizType;", "getP2pParams", "()Ltv/danmaku/videoplayer/coreV2/transformer/P2PParams;", "getExtraParams", "()Ljava/util/Map;", "reportMap", "", "getReportMap", "reportMap$delegate", "Lkotlin/Lazy;", "toReportMap", "toReportMap$player_preload_debug", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "player-preload_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PreloadReportData {
    private final long aid;
    private final Map<String, String> extraParams;
    private final String fromSpmid;
    private final String id;
    private final P2PParams p2pParams;
    private final VideoBizType reportBizType;
    private final Lazy reportMap$delegate;
    private final String spmid;
    private final long trackerId;

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.spmid;
    }

    public final String component3() {
        return this.fromSpmid;
    }

    public final long component4() {
        return this.aid;
    }

    public final long component5() {
        return this.trackerId;
    }

    public final VideoBizType component6() {
        return this.reportBizType;
    }

    public final P2PParams component7() {
        return this.p2pParams;
    }

    public final Map<String, String> component8() {
        return this.extraParams;
    }

    public final PreloadReportData copy(String str, String str2, String str3, long j, long j2, VideoBizType videoBizType, P2PParams p2PParams, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(videoBizType, "reportBizType");
        return new PreloadReportData(str, str2, str3, j, j2, videoBizType, p2PParams, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PreloadReportData) {
            PreloadReportData preloadReportData = (PreloadReportData) obj;
            return Intrinsics.areEqual(this.id, preloadReportData.id) && Intrinsics.areEqual(this.spmid, preloadReportData.spmid) && Intrinsics.areEqual(this.fromSpmid, preloadReportData.fromSpmid) && this.aid == preloadReportData.aid && this.trackerId == preloadReportData.trackerId && this.reportBizType == preloadReportData.reportBizType && Intrinsics.areEqual(this.p2pParams, preloadReportData.p2pParams) && Intrinsics.areEqual(this.extraParams, preloadReportData.extraParams);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((this.id.hashCode() * 31) + (this.spmid == null ? 0 : this.spmid.hashCode())) * 31) + (this.fromSpmid == null ? 0 : this.fromSpmid.hashCode())) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.aid)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.trackerId)) * 31) + this.reportBizType.hashCode()) * 31) + (this.p2pParams == null ? 0 : this.p2pParams.hashCode())) * 31) + (this.extraParams != null ? this.extraParams.hashCode() : 0);
    }

    public String toString() {
        String str = this.id;
        String str2 = this.spmid;
        String str3 = this.fromSpmid;
        long j = this.aid;
        long j2 = this.trackerId;
        VideoBizType videoBizType = this.reportBizType;
        P2PParams p2PParams = this.p2pParams;
        return "PreloadReportData(id=" + str + ", spmid=" + str2 + ", fromSpmid=" + str3 + ", aid=" + j + ", trackerId=" + j2 + ", reportBizType=" + videoBizType + ", p2pParams=" + p2PParams + ", extraParams=" + this.extraParams + ")";
    }

    public PreloadReportData(String id, String spmid, String fromSpmid, long aid, long trackerId, VideoBizType reportBizType, P2PParams p2pParams, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(reportBizType, "reportBizType");
        this.id = id;
        this.spmid = spmid;
        this.fromSpmid = fromSpmid;
        this.aid = aid;
        this.trackerId = trackerId;
        this.reportBizType = reportBizType;
        this.p2pParams = p2pParams;
        this.extraParams = map;
        this.reportMap$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: tv.danmaku.biliplayer.preload.repository.PreloadReportData$$ExternalSyntheticLambda0
            public final Object invoke() {
                Map reportMap_delegate$lambda$0;
                reportMap_delegate$lambda$0 = PreloadReportData.reportMap_delegate$lambda$0(PreloadReportData.this);
                return reportMap_delegate$lambda$0;
            }
        });
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PreloadReportData(String str, String str2, String str3, long j, long j2, VideoBizType videoBizType, P2PParams p2PParams, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, j, j2, r10, p2PParams, r12);
        VideoBizType videoBizType2;
        Map map2;
        if ((i & 32) == 0) {
            videoBizType2 = videoBizType;
        } else {
            videoBizType2 = VideoBizType.UNKNOWN;
        }
        if ((i & 128) == 0) {
            map2 = map;
        } else {
            map2 = null;
        }
    }

    public final String getId() {
        return this.id;
    }

    public final String getSpmid() {
        return this.spmid;
    }

    public final String getFromSpmid() {
        return this.fromSpmid;
    }

    public final long getAid() {
        return this.aid;
    }

    public final long getTrackerId() {
        return this.trackerId;
    }

    public final VideoBizType getReportBizType() {
        return this.reportBizType;
    }

    public final P2PParams getP2pParams() {
        return this.p2pParams;
    }

    public final Map<String, String> getExtraParams() {
        return this.extraParams;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PreloadReportData(String str, String str2, String str3, long j, long j2, VideoBizType videoBizType, P2PParams p2PParams, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, j, j2, r9, p2PParams);
        VideoBizType videoBizType2;
        if ((i & 32) == 0) {
            videoBizType2 = videoBizType;
        } else {
            videoBizType2 = VideoBizType.UNKNOWN;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PreloadReportData(String id, String spmid, String fromSpmid, long aid, long trackerId, VideoBizType reportBizType, P2PParams p2pParams) {
        this(id, spmid, fromSpmid, aid, trackerId, reportBizType, p2pParams, null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(reportBizType, "reportBizType");
    }

    private final Map<String, String> getReportMap() {
        return (Map) this.reportMap$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map reportMap_delegate$lambda$0(PreloadReportData this$0) {
        Map currentMap = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("id", this$0.id), TuplesKt.to("spmid", this$0.spmid), TuplesKt.to("fromSpmid", this$0.fromSpmid), TuplesKt.to("aid", String.valueOf(this$0.aid)), TuplesKt.to("cid", String.valueOf(this$0.trackerId))});
        Map it = this$0.extraParams;
        if (it != null) {
            currentMap.putAll(it);
        }
        return currentMap;
    }

    public final Map<String, String> toReportMap$player_preload_debug() {
        return getReportMap();
    }
}