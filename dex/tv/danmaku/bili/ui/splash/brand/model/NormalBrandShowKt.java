package tv.danmaku.bili.ui.splash.brand.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: NormalBrandShow.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"uniqueId", "", "Ltv/danmaku/bili/ui/splash/brand/model/NormalBrandShow;", "getUniqueId", "(Ltv/danmaku/bili/ui/splash/brand/model/NormalBrandShow;)Ljava/lang/String;", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class NormalBrandShowKt {
    public static final String getUniqueId(NormalBrandShow $this$uniqueId) {
        Intrinsics.checkNotNullParameter($this$uniqueId, "<this>");
        long id = $this$uniqueId.getId();
        return id + "-" + $this$uniqueId.getSource();
    }
}