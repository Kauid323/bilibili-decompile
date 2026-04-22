package tv.danmaku.bili.ui.garb.nft.model;

import BottomSheetItemData$;
import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: DLCPlayModel.kt */
@Bson
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/model/DLCPlayModel;", "", "duration", "", "trialDuration", "showSubtitles", "", "showProgressBar", "<init>", "(IIZZ)V", "getDuration", "()I", "getTrialDuration", "getShowSubtitles", "()Z", "getShowProgressBar", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DLCPlayModel {
    public static final int $stable = 0;
    @SerializedName("duration")
    private final int duration;
    @SerializedName("show_progress_bar")
    private final boolean showProgressBar;
    @SerializedName("show_subtitles")
    private final boolean showSubtitles;
    @SerializedName("trial_duration")
    private final int trialDuration;

    public static /* synthetic */ DLCPlayModel copy$default(DLCPlayModel dLCPlayModel, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = dLCPlayModel.duration;
        }
        if ((i3 & 2) != 0) {
            i2 = dLCPlayModel.trialDuration;
        }
        if ((i3 & 4) != 0) {
            z = dLCPlayModel.showSubtitles;
        }
        if ((i3 & 8) != 0) {
            z2 = dLCPlayModel.showProgressBar;
        }
        return dLCPlayModel.copy(i, i2, z, z2);
    }

    public final int component1() {
        return this.duration;
    }

    public final int component2() {
        return this.trialDuration;
    }

    public final boolean component3() {
        return this.showSubtitles;
    }

    public final boolean component4() {
        return this.showProgressBar;
    }

    public final DLCPlayModel copy(int i, int i2, boolean z, boolean z2) {
        return new DLCPlayModel(i, i2, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DLCPlayModel) {
            DLCPlayModel dLCPlayModel = (DLCPlayModel) obj;
            return this.duration == dLCPlayModel.duration && this.trialDuration == dLCPlayModel.trialDuration && this.showSubtitles == dLCPlayModel.showSubtitles && this.showProgressBar == dLCPlayModel.showProgressBar;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.duration * 31) + this.trialDuration) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showSubtitles)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showProgressBar);
    }

    public String toString() {
        int i = this.duration;
        int i2 = this.trialDuration;
        boolean z = this.showSubtitles;
        return "DLCPlayModel(duration=" + i + ", trialDuration=" + i2 + ", showSubtitles=" + z + ", showProgressBar=" + this.showProgressBar + ")";
    }

    public DLCPlayModel(int duration, int trialDuration, boolean showSubtitles, boolean showProgressBar) {
        this.duration = duration;
        this.trialDuration = trialDuration;
        this.showSubtitles = showSubtitles;
        this.showProgressBar = showProgressBar;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final int getTrialDuration() {
        return this.trialDuration;
    }

    public final boolean getShowSubtitles() {
        return this.showSubtitles;
    }

    public final boolean getShowProgressBar() {
        return this.showProgressBar;
    }
}