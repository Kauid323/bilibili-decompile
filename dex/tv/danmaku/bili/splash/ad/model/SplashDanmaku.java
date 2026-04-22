package tv.danmaku.bili.splash.ad.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: SplashDanmaku.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/splash/ad/model/SplashDanmaku;", "", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashDanmaku {
    public static final int $stable = 0;
    @SerializedName("message")
    private final String message;

    public SplashDanmaku() {
        this(null, 1, null);
    }

    public static /* synthetic */ SplashDanmaku copy$default(SplashDanmaku splashDanmaku, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = splashDanmaku.message;
        }
        return splashDanmaku.copy(str);
    }

    public final String component1() {
        return this.message;
    }

    public final SplashDanmaku copy(String str) {
        return new SplashDanmaku(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SplashDanmaku) && Intrinsics.areEqual(this.message, ((SplashDanmaku) obj).message);
    }

    public int hashCode() {
        if (this.message == null) {
            return 0;
        }
        return this.message.hashCode();
    }

    public String toString() {
        return "SplashDanmaku(message=" + this.message + ")";
    }

    public SplashDanmaku(String message) {
        this.message = message;
    }

    public /* synthetic */ SplashDanmaku(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getMessage() {
        return this.message;
    }
}