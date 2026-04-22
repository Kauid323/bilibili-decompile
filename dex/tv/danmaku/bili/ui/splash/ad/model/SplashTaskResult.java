package tv.danmaku.bili.ui.splash.ad.model;

import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashTaskResult.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003J?\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\nHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006#"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/model/SplashTaskResult;", "", "splashData", "Ltv/danmaku/bili/ui/splash/ad/model/SplashData;", "splash", "Ltv/danmaku/bili/ui/splash/ad/model/Splash;", "realTimeShowStrategies", "", "Ltv/danmaku/bili/ui/splash/ad/model/SplashShowStrategy;", "requestId", "", "<init>", "(Ltv/danmaku/bili/ui/splash/ad/model/SplashData;Ltv/danmaku/bili/ui/splash/ad/model/Splash;Ljava/util/List;Ljava/lang/String;)V", "getSplashData", "()Ltv/danmaku/bili/ui/splash/ad/model/SplashData;", "getSplash", "()Ltv/danmaku/bili/ui/splash/ad/model/Splash;", "getRealTimeShowStrategies", "()Ljava/util/List;", "getRequestId", "()Ljava/lang/String;", "requestShowSuccess", "", "getRequestShowSuccess", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashTaskResult {
    public static final int $stable = 8;
    private final List<SplashShowStrategy> realTimeShowStrategies;
    private final String requestId;
    private final Splash splash;
    private final SplashData splashData;

    public SplashTaskResult() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SplashTaskResult copy$default(SplashTaskResult splashTaskResult, SplashData splashData, Splash splash, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            splashData = splashTaskResult.splashData;
        }
        if ((i & 2) != 0) {
            splash = splashTaskResult.splash;
        }
        if ((i & 4) != 0) {
            list = splashTaskResult.realTimeShowStrategies;
        }
        if ((i & 8) != 0) {
            str = splashTaskResult.requestId;
        }
        return splashTaskResult.copy(splashData, splash, list, str);
    }

    public final SplashData component1() {
        return this.splashData;
    }

    public final Splash component2() {
        return this.splash;
    }

    public final List<SplashShowStrategy> component3() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.realTimeShowStrategies);
    }

    public final String component4() {
        return this.requestId;
    }

    public final SplashTaskResult copy(SplashData splashData, Splash splash, List<SplashShowStrategy> list, String str) {
        return new SplashTaskResult(splashData, splash, EnhancedUnmodifiabilityKt.unmodifiable(list), str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SplashTaskResult) {
            SplashTaskResult splashTaskResult = (SplashTaskResult) obj;
            return Intrinsics.areEqual(this.splashData, splashTaskResult.splashData) && Intrinsics.areEqual(this.splash, splashTaskResult.splash) && Intrinsics.areEqual(this.realTimeShowStrategies, splashTaskResult.realTimeShowStrategies) && Intrinsics.areEqual(this.requestId, splashTaskResult.requestId);
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.splashData == null ? 0 : this.splashData.hashCode()) * 31) + (this.splash == null ? 0 : this.splash.hashCode())) * 31) + (this.realTimeShowStrategies == null ? 0 : this.realTimeShowStrategies.hashCode())) * 31) + (this.requestId != null ? this.requestId.hashCode() : 0);
    }

    public String toString() {
        SplashData splashData = this.splashData;
        Splash splash = this.splash;
        List<SplashShowStrategy> list = this.realTimeShowStrategies;
        return "SplashTaskResult(splashData=" + splashData + ", splash=" + splash + ", realTimeShowStrategies=" + list + ", requestId=" + this.requestId + ")";
    }

    public SplashTaskResult(SplashData splashData, Splash splash, List<SplashShowStrategy> list, String requestId) {
        List realTimeShowStrategies = EnhancedUnmodifiabilityKt.unmodifiable(list);
        this.splashData = splashData;
        this.splash = splash;
        this.realTimeShowStrategies = realTimeShowStrategies;
        this.requestId = requestId;
    }

    public /* synthetic */ SplashTaskResult(SplashData splashData, Splash splash, List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : splashData, (i & 2) != 0 ? null : splash, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : str);
    }

    public final SplashData getSplashData() {
        return this.splashData;
    }

    public final Splash getSplash() {
        return this.splash;
    }

    public final List<SplashShowStrategy> getRealTimeShowStrategies() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.realTimeShowStrategies);
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final boolean getRequestShowSuccess() {
        List<SplashShowStrategy> list = this.realTimeShowStrategies;
        return !(list == null || list.isEmpty());
    }
}