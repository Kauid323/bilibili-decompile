package tv.danmaku.bili.splash.ad.model;

import ComposableSingletons$CustomBottomSheetKt$;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: SplashEgg.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/splash/ad/model/SplashEgg;", "", "videoUrl", "", "videoHash", "duration", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getVideoUrl", "()Ljava/lang/String;", "getVideoHash", "getDuration", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashEgg {
    public static final int $stable = 0;
    @SerializedName("duration")
    private final long duration;
    @SerializedName("video_hash")
    private final String videoHash;
    @SerializedName("video_url")
    private final String videoUrl;

    public SplashEgg() {
        this(null, null, 0L, 7, null);
    }

    public static /* synthetic */ SplashEgg copy$default(SplashEgg splashEgg, String str, String str2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = splashEgg.videoUrl;
        }
        if ((i & 2) != 0) {
            str2 = splashEgg.videoHash;
        }
        if ((i & 4) != 0) {
            j = splashEgg.duration;
        }
        return splashEgg.copy(str, str2, j);
    }

    public final String component1() {
        return this.videoUrl;
    }

    public final String component2() {
        return this.videoHash;
    }

    public final long component3() {
        return this.duration;
    }

    public final SplashEgg copy(String str, String str2, long j) {
        return new SplashEgg(str, str2, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SplashEgg) {
            SplashEgg splashEgg = (SplashEgg) obj;
            return Intrinsics.areEqual(this.videoUrl, splashEgg.videoUrl) && Intrinsics.areEqual(this.videoHash, splashEgg.videoHash) && this.duration == splashEgg.duration;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.videoUrl == null ? 0 : this.videoUrl.hashCode()) * 31) + (this.videoHash != null ? this.videoHash.hashCode() : 0)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.duration);
    }

    public String toString() {
        String str = this.videoUrl;
        String str2 = this.videoHash;
        return "SplashEgg(videoUrl=" + str + ", videoHash=" + str2 + ", duration=" + this.duration + ")";
    }

    public SplashEgg(String videoUrl, String videoHash, long duration) {
        this.videoUrl = videoUrl;
        this.videoHash = videoHash;
        this.duration = duration;
    }

    public /* synthetic */ SplashEgg(String str, String str2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? 0L : j);
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public final String getVideoHash() {
        return this.videoHash;
    }

    public final long getDuration() {
        return this.duration;
    }
}