package tv.danmaku.bili.push.innerpush.model;

import ComposableSingletons$CustomBottomSheetKt$;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: InnerPushConfig.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003JG\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\nHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Ltv/danmaku/bili/push/innerpush/model/InnerPushConfig;", "", "maxCacheCount", "", "cacheStrategy", "displayInterval", "", "maxExposure", "maxBusinessExposure", "", "", "<init>", "(IIJILjava/util/Map;)V", "getMaxCacheCount", "()I", "getCacheStrategy", "getDisplayInterval", "()J", "getMaxExposure", "getMaxBusinessExposure", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class InnerPushConfig {
    public static final int $stable = 8;
    @SerializedName("cache_strategy")
    private final int cacheStrategy;
    @SerializedName("display_interval")
    private final long displayInterval;
    @SerializedName("max_business_exposure")
    private final Map<String, Integer> maxBusinessExposure;
    @SerializedName("cache_maximum")
    private final int maxCacheCount;
    @SerializedName("max_exposure")
    private final int maxExposure;

    public InnerPushConfig() {
        this(0, 0, 0L, 0, null, 31, null);
    }

    public static /* synthetic */ InnerPushConfig copy$default(InnerPushConfig innerPushConfig, int i, int i2, long j, int i3, Map map, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = innerPushConfig.maxCacheCount;
        }
        if ((i4 & 2) != 0) {
            i2 = innerPushConfig.cacheStrategy;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            j = innerPushConfig.displayInterval;
        }
        long j2 = j;
        if ((i4 & 8) != 0) {
            i3 = innerPushConfig.maxExposure;
        }
        int i6 = i3;
        Map<String, Integer> map2 = map;
        if ((i4 & 16) != 0) {
            map2 = innerPushConfig.maxBusinessExposure;
        }
        return innerPushConfig.copy(i, i5, j2, i6, map2);
    }

    public final int component1() {
        return this.maxCacheCount;
    }

    public final int component2() {
        return this.cacheStrategy;
    }

    public final long component3() {
        return this.displayInterval;
    }

    public final int component4() {
        return this.maxExposure;
    }

    public final Map<String, Integer> component5() {
        return this.maxBusinessExposure;
    }

    public final InnerPushConfig copy(int i, int i2, long j, int i3, Map<String, Integer> map) {
        Intrinsics.checkNotNullParameter(map, "maxBusinessExposure");
        return new InnerPushConfig(i, i2, j, i3, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InnerPushConfig) {
            InnerPushConfig innerPushConfig = (InnerPushConfig) obj;
            return this.maxCacheCount == innerPushConfig.maxCacheCount && this.cacheStrategy == innerPushConfig.cacheStrategy && this.displayInterval == innerPushConfig.displayInterval && this.maxExposure == innerPushConfig.maxExposure && Intrinsics.areEqual(this.maxBusinessExposure, innerPushConfig.maxBusinessExposure);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.maxCacheCount * 31) + this.cacheStrategy) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.displayInterval)) * 31) + this.maxExposure) * 31) + this.maxBusinessExposure.hashCode();
    }

    public String toString() {
        int i = this.maxCacheCount;
        int i2 = this.cacheStrategy;
        long j = this.displayInterval;
        int i3 = this.maxExposure;
        return "InnerPushConfig(maxCacheCount=" + i + ", cacheStrategy=" + i2 + ", displayInterval=" + j + ", maxExposure=" + i3 + ", maxBusinessExposure=" + this.maxBusinessExposure + ")";
    }

    public InnerPushConfig(int maxCacheCount, int cacheStrategy, long displayInterval, int maxExposure, Map<String, Integer> map) {
        Intrinsics.checkNotNullParameter(map, "maxBusinessExposure");
        this.maxCacheCount = maxCacheCount;
        this.cacheStrategy = cacheStrategy;
        this.displayInterval = displayInterval;
        this.maxExposure = maxExposure;
        this.maxBusinessExposure = map;
    }

    public /* synthetic */ InnerPushConfig(int i, int i2, long j, int i3, Map map, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 1 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0L : j, (i4 & 8) != 0 ? -1 : i3, (i4 & 16) != 0 ? MapsKt.emptyMap() : map);
    }

    public final int getMaxCacheCount() {
        return this.maxCacheCount;
    }

    public final int getCacheStrategy() {
        return this.cacheStrategy;
    }

    public final long getDisplayInterval() {
        return this.displayInterval;
    }

    public final int getMaxExposure() {
        return this.maxExposure;
    }

    public final Map<String, Integer> getMaxBusinessExposure() {
        return this.maxBusinessExposure;
    }
}