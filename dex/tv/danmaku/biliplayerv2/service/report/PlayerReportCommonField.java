package tv.danmaku.biliplayerv2.service.report;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.report.ReportStrategy;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: IReporterService.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b,\b\u0086\b\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0007HÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J\t\u00103\u001a\u00020\u0007HÆ\u0003J\t\u00104\u001a\u00020\u000bHÆ\u0003J\t\u00105\u001a\u00020\u000bHÆ\u0003J\t\u00106\u001a\u00020\u0007HÆ\u0003J\t\u00107\u001a\u00020\u000fHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010(J\t\u0010:\u001a\u00020\u0014HÆ\u0003J\u0011\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016HÆ\u0003J¦\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016HÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020\u000f2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\u000bHÖ\u0001J\t\u0010A\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010%R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010)\u001a\u0004\b\u0012\u0010(R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006B"}, d2 = {"Ltv/danmaku/biliplayerv2/service/report/PlayerReportCommonField;", "", "avid", "", "videoId", "seasonid", "epid", "", "fromSpmid", "spmid", "type", "", "subType", "trackid", "isVertical", "", "videoFormat", "Ltv/danmaku/biliplayerv2/service/report/VideoFormat;", "isLocalVideo", "customized", "Ltv/danmaku/biliplayerv2/service/report/ReportStrategy;", "progressStrategy", "Lkotlin/Function0;", "<init>", "(JJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ZLtv/danmaku/biliplayerv2/service/report/VideoFormat;Ljava/lang/Boolean;Ltv/danmaku/biliplayerv2/service/report/ReportStrategy;Lkotlin/jvm/functions/Function0;)V", "getAvid", "()J", "getVideoId", "getSeasonid", "getEpid", "()Ljava/lang/String;", "getFromSpmid", "getSpmid", "getType", "()I", "getSubType", "getTrackid", "()Z", "getVideoFormat", "()Ltv/danmaku/biliplayerv2/service/report/VideoFormat;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCustomized", "()Ltv/danmaku/biliplayerv2/service/report/ReportStrategy;", "getProgressStrategy", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(JJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ZLtv/danmaku/biliplayerv2/service/report/VideoFormat;Ljava/lang/Boolean;Ltv/danmaku/biliplayerv2/service/report/ReportStrategy;Lkotlin/jvm/functions/Function0;)Ltv/danmaku/biliplayerv2/service/report/PlayerReportCommonField;", "equals", "other", "hashCode", "toString", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerReportCommonField {
    private final long avid;
    private final ReportStrategy customized;
    private final String epid;
    private final String fromSpmid;
    private final Boolean isLocalVideo;
    private final boolean isVertical;
    private final Function0<Long> progressStrategy;
    private final long seasonid;
    private final String spmid;
    private final int subType;
    private final String trackid;
    private final int type;
    private final VideoFormat videoFormat;
    private final long videoId;

    public final long component1() {
        return this.avid;
    }

    public final boolean component10() {
        return this.isVertical;
    }

    public final VideoFormat component11() {
        return this.videoFormat;
    }

    public final Boolean component12() {
        return this.isLocalVideo;
    }

    public final ReportStrategy component13() {
        return this.customized;
    }

    public final Function0<Long> component14() {
        return this.progressStrategy;
    }

    public final long component2() {
        return this.videoId;
    }

    public final long component3() {
        return this.seasonid;
    }

    public final String component4() {
        return this.epid;
    }

    public final String component5() {
        return this.fromSpmid;
    }

    public final String component6() {
        return this.spmid;
    }

    public final int component7() {
        return this.type;
    }

    public final int component8() {
        return this.subType;
    }

    public final String component9() {
        return this.trackid;
    }

    public final PlayerReportCommonField copy(long j, long j2, long j3, String str, String str2, String str3, int i, int i2, String str4, boolean z, VideoFormat videoFormat, Boolean bool, ReportStrategy reportStrategy, Function0<Long> function0) {
        Intrinsics.checkNotNullParameter(str, "epid");
        Intrinsics.checkNotNullParameter(str2, "fromSpmid");
        Intrinsics.checkNotNullParameter(str3, "spmid");
        Intrinsics.checkNotNullParameter(str4, "trackid");
        Intrinsics.checkNotNullParameter(reportStrategy, "customized");
        return new PlayerReportCommonField(j, j2, j3, str, str2, str3, i, i2, str4, z, videoFormat, bool, reportStrategy, function0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PlayerReportCommonField) {
            PlayerReportCommonField playerReportCommonField = (PlayerReportCommonField) obj;
            return this.avid == playerReportCommonField.avid && this.videoId == playerReportCommonField.videoId && this.seasonid == playerReportCommonField.seasonid && Intrinsics.areEqual(this.epid, playerReportCommonField.epid) && Intrinsics.areEqual(this.fromSpmid, playerReportCommonField.fromSpmid) && Intrinsics.areEqual(this.spmid, playerReportCommonField.spmid) && this.type == playerReportCommonField.type && this.subType == playerReportCommonField.subType && Intrinsics.areEqual(this.trackid, playerReportCommonField.trackid) && this.isVertical == playerReportCommonField.isVertical && Intrinsics.areEqual(this.videoFormat, playerReportCommonField.videoFormat) && Intrinsics.areEqual(this.isLocalVideo, playerReportCommonField.isLocalVideo) && Intrinsics.areEqual(this.customized, playerReportCommonField.customized) && Intrinsics.areEqual(this.progressStrategy, playerReportCommonField.progressStrategy);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.avid) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.videoId)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.seasonid)) * 31) + this.epid.hashCode()) * 31) + this.fromSpmid.hashCode()) * 31) + this.spmid.hashCode()) * 31) + this.type) * 31) + this.subType) * 31) + this.trackid.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isVertical)) * 31) + (this.videoFormat == null ? 0 : this.videoFormat.hashCode())) * 31) + (this.isLocalVideo == null ? 0 : this.isLocalVideo.hashCode())) * 31) + this.customized.hashCode()) * 31) + (this.progressStrategy != null ? this.progressStrategy.hashCode() : 0);
    }

    public String toString() {
        long j = this.avid;
        long j2 = this.videoId;
        long j3 = this.seasonid;
        String str = this.epid;
        String str2 = this.fromSpmid;
        String str3 = this.spmid;
        int i = this.type;
        int i2 = this.subType;
        String str4 = this.trackid;
        boolean z = this.isVertical;
        VideoFormat videoFormat = this.videoFormat;
        Boolean bool = this.isLocalVideo;
        ReportStrategy reportStrategy = this.customized;
        return "PlayerReportCommonField(avid=" + j + ", videoId=" + j2 + ", seasonid=" + j3 + ", epid=" + str + ", fromSpmid=" + str2 + ", spmid=" + str3 + ", type=" + i + ", subType=" + i2 + ", trackid=" + str4 + ", isVertical=" + z + ", videoFormat=" + videoFormat + ", isLocalVideo=" + bool + ", customized=" + reportStrategy + ", progressStrategy=" + this.progressStrategy + ")";
    }

    public PlayerReportCommonField(long avid, long videoId, long seasonid, String epid, String fromSpmid, String spmid, int type, int subType, String trackid, boolean isVertical, VideoFormat videoFormat, Boolean isLocalVideo, ReportStrategy customized, Function0<Long> function0) {
        Intrinsics.checkNotNullParameter(epid, "epid");
        Intrinsics.checkNotNullParameter(fromSpmid, "fromSpmid");
        Intrinsics.checkNotNullParameter(spmid, "spmid");
        Intrinsics.checkNotNullParameter(trackid, "trackid");
        Intrinsics.checkNotNullParameter(customized, "customized");
        this.avid = avid;
        this.videoId = videoId;
        this.seasonid = seasonid;
        this.epid = epid;
        this.fromSpmid = fromSpmid;
        this.spmid = spmid;
        this.type = type;
        this.subType = subType;
        this.trackid = trackid;
        this.isVertical = isVertical;
        this.videoFormat = videoFormat;
        this.isLocalVideo = isLocalVideo;
        this.customized = customized;
        this.progressStrategy = function0;
    }

    public /* synthetic */ PlayerReportCommonField(long j, long j2, long j3, String str, String str2, String str3, int i, int i2, String str4, boolean z, VideoFormat videoFormat, Boolean bool, ReportStrategy reportStrategy, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j, (i3 & 2) != 0 ? 0L : j2, (i3 & 4) != 0 ? 0L : j3, (i3 & 8) != 0 ? "" : str, (i3 & 16) != 0 ? "" : str2, (i3 & 32) != 0 ? "" : str3, (i3 & 64) != 0 ? 0 : i, (i3 & 128) != 0 ? 0 : i2, str4, z, (i3 & 1024) != 0 ? null : videoFormat, (i3 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? null : bool, (i3 & 4096) != 0 ? ReportStrategy.DEFAULT.INSTANCE : reportStrategy, (i3 & 8192) != 0 ? null : function0);
    }

    public final long getAvid() {
        return this.avid;
    }

    public final long getVideoId() {
        return this.videoId;
    }

    public final long getSeasonid() {
        return this.seasonid;
    }

    public final String getEpid() {
        return this.epid;
    }

    public final String getFromSpmid() {
        return this.fromSpmid;
    }

    public final String getSpmid() {
        return this.spmid;
    }

    public final int getType() {
        return this.type;
    }

    public final int getSubType() {
        return this.subType;
    }

    public final String getTrackid() {
        return this.trackid;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public final VideoFormat getVideoFormat() {
        return this.videoFormat;
    }

    public final Boolean isLocalVideo() {
        return this.isLocalVideo;
    }

    public final ReportStrategy getCustomized() {
        return this.customized;
    }

    public final Function0<Long> getProgressStrategy() {
        return this.progressStrategy;
    }
}