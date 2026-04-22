package tv.danmaku.bili.splash.ad.model;

import ComposableSingletons$CustomBottomSheetKt$;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.v2.InnerPushReceiverKt;
import tv.danmaku.bili.ui.garb.NftCardJsBridgeCallHandler;

/* compiled from: SplashPeakTask.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\u0017\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R,\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Ltv/danmaku/bili/splash/ad/model/SplashPeakTask;", "", "taskId", "", "url", "hash", "effectTime", "", InnerPushReceiverKt.KEY_EXTRA, "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/util/Map;)V", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "getUrl", "getHash", "getEffectTime", "()J", NftCardJsBridgeCallHandler.GET_EXTRA, "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashPeakTask {
    public static final int $stable = 8;
    @SerializedName("effect_time")
    private final long effectTime;
    @SerializedName(InnerPushReceiverKt.KEY_EXTRA)
    private Map<String, String> extra;
    @SerializedName("hash")
    private final String hash;
    @SerializedName("task_id")
    private String taskId;
    @SerializedName("url")
    private final String url;

    public SplashPeakTask() {
        this(null, null, null, 0L, null, 31, null);
    }

    public static /* synthetic */ SplashPeakTask copy$default(SplashPeakTask splashPeakTask, String str, String str2, String str3, long j, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = splashPeakTask.taskId;
        }
        if ((i & 2) != 0) {
            str2 = splashPeakTask.url;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = splashPeakTask.hash;
        }
        String str5 = str3;
        if ((i & 8) != 0) {
            j = splashPeakTask.effectTime;
        }
        long j2 = j;
        Map<String, String> map2 = map;
        if ((i & 16) != 0) {
            map2 = splashPeakTask.extra;
        }
        return splashPeakTask.copy(str, str4, str5, j2, map2);
    }

    public final String component1() {
        return this.taskId;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.hash;
    }

    public final long component4() {
        return this.effectTime;
    }

    public final Map<String, String> component5() {
        return this.extra;
    }

    public final SplashPeakTask copy(String str, String str2, String str3, long j, Map<String, String> map) {
        return new SplashPeakTask(str, str2, str3, j, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SplashPeakTask) {
            SplashPeakTask splashPeakTask = (SplashPeakTask) obj;
            return Intrinsics.areEqual(this.taskId, splashPeakTask.taskId) && Intrinsics.areEqual(this.url, splashPeakTask.url) && Intrinsics.areEqual(this.hash, splashPeakTask.hash) && this.effectTime == splashPeakTask.effectTime && Intrinsics.areEqual(this.extra, splashPeakTask.extra);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.taskId == null ? 0 : this.taskId.hashCode()) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.hash == null ? 0 : this.hash.hashCode())) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.effectTime)) * 31) + (this.extra != null ? this.extra.hashCode() : 0);
    }

    public String toString() {
        String str = this.taskId;
        String str2 = this.url;
        String str3 = this.hash;
        long j = this.effectTime;
        return "SplashPeakTask(taskId=" + str + ", url=" + str2 + ", hash=" + str3 + ", effectTime=" + j + ", extra=" + this.extra + ")";
    }

    public SplashPeakTask(String taskId, String url, String hash, long effectTime, Map<String, String> map) {
        this.taskId = taskId;
        this.url = url;
        this.hash = hash;
        this.effectTime = effectTime;
        this.extra = map;
    }

    public /* synthetic */ SplashPeakTask(String str, String str2, String str3, long j, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? 0L : j, (i & 16) != 0 ? null : map);
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final void setTaskId(String str) {
        this.taskId = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getHash() {
        return this.hash;
    }

    public final long getEffectTime() {
        return this.effectTime;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final void setExtra(Map<String, String> map) {
        this.extra = map;
    }
}