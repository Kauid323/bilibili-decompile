package tv.danmaku.bili.ui.splash.ad.config;

import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LowerPhoneConfig.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/config/LowerPerformancePhoneConfig;", "", "modelList", "", "", "<init>", "(Ljava/util/List;)V", "getModelList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class LowerPerformancePhoneConfig {
    public static final int $stable = 8;
    @SerializedName("black_model_list")
    private final List<String> modelList;

    public LowerPerformancePhoneConfig() {
        this(null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LowerPerformancePhoneConfig copy$default(LowerPerformancePhoneConfig lowerPerformancePhoneConfig, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = lowerPerformancePhoneConfig.modelList;
        }
        return lowerPerformancePhoneConfig.copy(list);
    }

    public final List<String> component1() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.modelList);
    }

    public final LowerPerformancePhoneConfig copy(List<String> list) {
        return new LowerPerformancePhoneConfig(EnhancedUnmodifiabilityKt.unmodifiable(list));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LowerPerformancePhoneConfig) && Intrinsics.areEqual(this.modelList, ((LowerPerformancePhoneConfig) obj).modelList);
    }

    public int hashCode() {
        if (this.modelList == null) {
            return 0;
        }
        return this.modelList.hashCode();
    }

    public String toString() {
        return "LowerPerformancePhoneConfig(modelList=" + this.modelList + ")";
    }

    public LowerPerformancePhoneConfig(List<String> list) {
        List modelList = EnhancedUnmodifiabilityKt.unmodifiable(list);
        this.modelList = modelList;
    }

    public /* synthetic */ LowerPerformancePhoneConfig(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    public final List<String> getModelList() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.modelList);
    }
}