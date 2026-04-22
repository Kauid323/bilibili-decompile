package kntr.common.behavior.prediction.predictor;

import BottomSheetItemData$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoQualityPredictor.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÂ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lkntr/common/behavior/prediction/predictor/VideoQualityDeviceTagInfo;", "", "vipTag", "Lkntr/common/behavior/prediction/predictor/VideoQualityTagType;", "deviceTag", "deviceMaxQn", "", "isFromLstm", "", "<init>", "(Lkntr/common/behavior/prediction/predictor/VideoQualityTagType;Lkntr/common/behavior/prediction/predictor/VideoQualityTagType;IZ)V", "getVipTag", "()Lkntr/common/behavior/prediction/predictor/VideoQualityTagType;", "getDeviceTag", "getDeviceMaxQn", "()I", "isHigh", "()Z", "message", "", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class VideoQualityDeviceTagInfo {
    private final int deviceMaxQn;
    private final VideoQualityTagType deviceTag;
    private final boolean isFromLstm;
    private final VideoQualityTagType vipTag;

    private final boolean component4() {
        return this.isFromLstm;
    }

    public static /* synthetic */ VideoQualityDeviceTagInfo copy$default(VideoQualityDeviceTagInfo videoQualityDeviceTagInfo, VideoQualityTagType videoQualityTagType, VideoQualityTagType videoQualityTagType2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            videoQualityTagType = videoQualityDeviceTagInfo.vipTag;
        }
        if ((i2 & 2) != 0) {
            videoQualityTagType2 = videoQualityDeviceTagInfo.deviceTag;
        }
        if ((i2 & 4) != 0) {
            i = videoQualityDeviceTagInfo.deviceMaxQn;
        }
        if ((i2 & 8) != 0) {
            z = videoQualityDeviceTagInfo.isFromLstm;
        }
        return videoQualityDeviceTagInfo.copy(videoQualityTagType, videoQualityTagType2, i, z);
    }

    public final VideoQualityTagType component1() {
        return this.vipTag;
    }

    public final VideoQualityTagType component2() {
        return this.deviceTag;
    }

    public final int component3() {
        return this.deviceMaxQn;
    }

    public final VideoQualityDeviceTagInfo copy(VideoQualityTagType videoQualityTagType, VideoQualityTagType videoQualityTagType2, int i, boolean z) {
        Intrinsics.checkNotNullParameter(videoQualityTagType, "vipTag");
        Intrinsics.checkNotNullParameter(videoQualityTagType2, "deviceTag");
        return new VideoQualityDeviceTagInfo(videoQualityTagType, videoQualityTagType2, i, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VideoQualityDeviceTagInfo) {
            VideoQualityDeviceTagInfo videoQualityDeviceTagInfo = (VideoQualityDeviceTagInfo) obj;
            return this.vipTag == videoQualityDeviceTagInfo.vipTag && this.deviceTag == videoQualityDeviceTagInfo.deviceTag && this.deviceMaxQn == videoQualityDeviceTagInfo.deviceMaxQn && this.isFromLstm == videoQualityDeviceTagInfo.isFromLstm;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.vipTag.hashCode() * 31) + this.deviceTag.hashCode()) * 31) + this.deviceMaxQn) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isFromLstm);
    }

    public String toString() {
        VideoQualityTagType videoQualityTagType = this.vipTag;
        VideoQualityTagType videoQualityTagType2 = this.deviceTag;
        int i = this.deviceMaxQn;
        return "VideoQualityDeviceTagInfo(vipTag=" + videoQualityTagType + ", deviceTag=" + videoQualityTagType2 + ", deviceMaxQn=" + i + ", isFromLstm=" + this.isFromLstm + ")";
    }

    public VideoQualityDeviceTagInfo(VideoQualityTagType vipTag, VideoQualityTagType deviceTag, int deviceMaxQn, boolean isFromLstm) {
        Intrinsics.checkNotNullParameter(vipTag, "vipTag");
        Intrinsics.checkNotNullParameter(deviceTag, "deviceTag");
        this.vipTag = vipTag;
        this.deviceTag = deviceTag;
        this.deviceMaxQn = deviceMaxQn;
        this.isFromLstm = isFromLstm;
    }

    public final VideoQualityTagType getVipTag() {
        return this.vipTag;
    }

    public final VideoQualityTagType getDeviceTag() {
        return this.deviceTag;
    }

    public final int getDeviceMaxQn() {
        return this.deviceMaxQn;
    }

    public final boolean isHigh() {
        return SetsKt.setOf(new VideoQualityTagType[]{this.vipTag, this.deviceTag}).contains(VideoQualityTagType.High);
    }

    public final String getMessage() {
        String displayName = this.vipTag.getDisplayName();
        String displayName2 = this.deviceTag.getDisplayName();
        int i = this.deviceMaxQn;
        return "vip_tag: " + displayName + ", device_tag: " + displayName2 + ", device_qn: " + i + ", lstm: " + this.isFromLstm;
    }
}