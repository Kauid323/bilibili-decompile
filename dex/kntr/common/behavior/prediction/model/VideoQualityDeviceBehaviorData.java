package kntr.common.behavior.prediction.model;

import BottomSheetItemData$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.behavior.prediction.IBehaviorData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VideoQualityDeviceBehaviorData.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\f¨\u0006\u0017"}, d2 = {"Lkntr/common/behavior/prediction/model/VideoQualityDeviceBehaviorData;", "Lkntr/common/behavior/prediction/IBehaviorData;", "buvid", "", "actionInfo", "isOverwrite", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getBuvid", "()Ljava/lang/String;", "getActionInfo", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class VideoQualityDeviceBehaviorData implements IBehaviorData {
    private final String actionInfo;
    private final String buvid;
    private final boolean isOverwrite;

    public VideoQualityDeviceBehaviorData() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ VideoQualityDeviceBehaviorData copy$default(VideoQualityDeviceBehaviorData videoQualityDeviceBehaviorData, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = videoQualityDeviceBehaviorData.buvid;
        }
        if ((i & 2) != 0) {
            str2 = videoQualityDeviceBehaviorData.actionInfo;
        }
        if ((i & 4) != 0) {
            z = videoQualityDeviceBehaviorData.isOverwrite;
        }
        return videoQualityDeviceBehaviorData.copy(str, str2, z);
    }

    public final String component1() {
        return this.buvid;
    }

    public final String component2() {
        return this.actionInfo;
    }

    public final boolean component3() {
        return this.isOverwrite;
    }

    public final VideoQualityDeviceBehaviorData copy(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "buvid");
        Intrinsics.checkNotNullParameter(str2, "actionInfo");
        return new VideoQualityDeviceBehaviorData(str, str2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VideoQualityDeviceBehaviorData) {
            VideoQualityDeviceBehaviorData videoQualityDeviceBehaviorData = (VideoQualityDeviceBehaviorData) obj;
            return Intrinsics.areEqual(this.buvid, videoQualityDeviceBehaviorData.buvid) && Intrinsics.areEqual(this.actionInfo, videoQualityDeviceBehaviorData.actionInfo) && this.isOverwrite == videoQualityDeviceBehaviorData.isOverwrite;
        }
        return false;
    }

    public int hashCode() {
        return (((this.buvid.hashCode() * 31) + this.actionInfo.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isOverwrite);
    }

    public String toString() {
        String str = this.buvid;
        String str2 = this.actionInfo;
        return "VideoQualityDeviceBehaviorData(buvid=" + str + ", actionInfo=" + str2 + ", isOverwrite=" + this.isOverwrite + ")";
    }

    public VideoQualityDeviceBehaviorData(String buvid, String actionInfo, boolean isOverwrite) {
        Intrinsics.checkNotNullParameter(buvid, "buvid");
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        this.buvid = buvid;
        this.actionInfo = actionInfo;
        this.isOverwrite = isOverwrite;
    }

    public /* synthetic */ VideoQualityDeviceBehaviorData(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? false : z);
    }

    public final String getBuvid() {
        return this.buvid;
    }

    public final String getActionInfo() {
        return this.actionInfo;
    }

    public final boolean isOverwrite() {
        return this.isOverwrite;
    }
}