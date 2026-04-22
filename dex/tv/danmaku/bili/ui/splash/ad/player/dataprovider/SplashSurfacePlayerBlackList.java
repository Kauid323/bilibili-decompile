package tv.danmaku.bili.ui.splash.ad.player.dataprovider;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashCardPlayerConfig.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/player/dataprovider/SplashSurfacePlayerBlackList;", "", "<init>", "()V", "modelBlackList", "", "", "getModelBlackList", "()Ljava/util/List;", "setModelBlackList", "(Ljava/util/List;)V", "cpuBlackList", "getCpuBlackList", "setCpuBlackList", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashSurfacePlayerBlackList {
    public static final int $stable = 8;
    @JSONField(name = "black_model_list")
    private List<String> modelBlackList = new ArrayList();
    @JSONField(name = "black_cpu_list")
    private List<String> cpuBlackList = new ArrayList();

    public final List<String> getModelBlackList() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.modelBlackList);
    }

    public final void setModelBlackList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.modelBlackList = list;
    }

    public final List<String> getCpuBlackList() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.cpuBlackList);
    }

    public final void setCpuBlackList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.cpuBlackList = list;
    }
}