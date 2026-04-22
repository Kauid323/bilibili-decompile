package tv.danmaku.bili.splash.ad.player.dataprovider;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: SplashCardPlayerConfig.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/splash/ad/player/dataprovider/SplashSurfacePlayerBlackList;", "", "modelBlackList", "", "", "cpuBlackList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getModelBlackList", "()Ljava/util/List;", "getCpuBlackList", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashSurfacePlayerBlackList {
    public static final int $stable = 8;
    @SerializedName("black_cpu_list")
    private final List<String> cpuBlackList;
    @SerializedName("black_model_list")
    private final List<String> modelBlackList;

    public SplashSurfacePlayerBlackList() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SplashSurfacePlayerBlackList copy$default(SplashSurfacePlayerBlackList splashSurfacePlayerBlackList, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = splashSurfacePlayerBlackList.modelBlackList;
        }
        if ((i & 2) != 0) {
            list2 = splashSurfacePlayerBlackList.cpuBlackList;
        }
        return splashSurfacePlayerBlackList.copy(list, list2);
    }

    public final List<String> component1() {
        return this.modelBlackList;
    }

    public final List<String> component2() {
        return this.cpuBlackList;
    }

    public final SplashSurfacePlayerBlackList copy(List<String> list, List<String> list2) {
        return new SplashSurfacePlayerBlackList(list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SplashSurfacePlayerBlackList) {
            SplashSurfacePlayerBlackList splashSurfacePlayerBlackList = (SplashSurfacePlayerBlackList) obj;
            return Intrinsics.areEqual(this.modelBlackList, splashSurfacePlayerBlackList.modelBlackList) && Intrinsics.areEqual(this.cpuBlackList, splashSurfacePlayerBlackList.cpuBlackList);
        }
        return false;
    }

    public int hashCode() {
        return ((this.modelBlackList == null ? 0 : this.modelBlackList.hashCode()) * 31) + (this.cpuBlackList != null ? this.cpuBlackList.hashCode() : 0);
    }

    public String toString() {
        List<String> list = this.modelBlackList;
        return "SplashSurfacePlayerBlackList(modelBlackList=" + list + ", cpuBlackList=" + this.cpuBlackList + ")";
    }

    public SplashSurfacePlayerBlackList(List<String> list, List<String> list2) {
        this.modelBlackList = list;
        this.cpuBlackList = list2;
    }

    public /* synthetic */ SplashSurfacePlayerBlackList(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2);
    }

    public final List<String> getModelBlackList() {
        return this.modelBlackList;
    }

    public final List<String> getCpuBlackList() {
        return this.cpuBlackList;
    }
}