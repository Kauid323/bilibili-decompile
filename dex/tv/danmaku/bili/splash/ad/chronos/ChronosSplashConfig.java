package tv.danmaku.bili.splash.ad.chronos;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplashChronosView.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0083\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/splash/ad/chronos/ChronosSplashConfig;", "", "url", "", "md5", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getMd5", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ChronosSplashConfig {
    @SerializedName("md5")
    private final String md5;
    @SerializedName("url")
    private final String url;

    public ChronosSplashConfig() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ ChronosSplashConfig copy$default(ChronosSplashConfig chronosSplashConfig, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = chronosSplashConfig.url;
        }
        if ((i & 2) != 0) {
            str2 = chronosSplashConfig.md5;
        }
        return chronosSplashConfig.copy(str, str2);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.md5;
    }

    public final ChronosSplashConfig copy(String str, String str2) {
        return new ChronosSplashConfig(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChronosSplashConfig) {
            ChronosSplashConfig chronosSplashConfig = (ChronosSplashConfig) obj;
            return Intrinsics.areEqual(this.url, chronosSplashConfig.url) && Intrinsics.areEqual(this.md5, chronosSplashConfig.md5);
        }
        return false;
    }

    public int hashCode() {
        return ((this.url == null ? 0 : this.url.hashCode()) * 31) + (this.md5 != null ? this.md5.hashCode() : 0);
    }

    public String toString() {
        String str = this.url;
        return "ChronosSplashConfig(url=" + str + ", md5=" + this.md5 + ")";
    }

    public ChronosSplashConfig(String url, String md5) {
        this.url = url;
        this.md5 = md5;
    }

    public /* synthetic */ ChronosSplashConfig(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getMd5() {
        return this.md5;
    }
}