package tv.danmaku.bili.splash.ad.model;

import BottomSheetItemData$;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: SplashPeakInfo.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/splash/ad/model/SplashPeakInfo;", "", "enable", "", "taskList", "", "Ltv/danmaku/bili/splash/ad/model/SplashPeakTask;", "<init>", "(ZLjava/util/List;)V", "getEnable", "()Z", "getTaskList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashPeakInfo {
    public static final int $stable = 8;
    @SerializedName("enable")
    private final boolean enable;
    @SerializedName("task_list")
    private final List<SplashPeakTask> taskList;

    public SplashPeakInfo() {
        this(false, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SplashPeakInfo copy$default(SplashPeakInfo splashPeakInfo, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = splashPeakInfo.enable;
        }
        if ((i & 2) != 0) {
            list = splashPeakInfo.taskList;
        }
        return splashPeakInfo.copy(z, list);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final List<SplashPeakTask> component2() {
        return this.taskList;
    }

    public final SplashPeakInfo copy(boolean z, List<SplashPeakTask> list) {
        return new SplashPeakInfo(z, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SplashPeakInfo) {
            SplashPeakInfo splashPeakInfo = (SplashPeakInfo) obj;
            return this.enable == splashPeakInfo.enable && Intrinsics.areEqual(this.taskList, splashPeakInfo.taskList);
        }
        return false;
    }

    public int hashCode() {
        return (BottomSheetItemData$.ExternalSyntheticBackport0.m(this.enable) * 31) + (this.taskList == null ? 0 : this.taskList.hashCode());
    }

    public String toString() {
        boolean z = this.enable;
        return "SplashPeakInfo(enable=" + z + ", taskList=" + this.taskList + ")";
    }

    public SplashPeakInfo(boolean enable, List<SplashPeakTask> list) {
        this.enable = enable;
        this.taskList = list;
    }

    public /* synthetic */ SplashPeakInfo(boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : list);
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final List<SplashPeakTask> getTaskList() {
        return this.taskList;
    }
}