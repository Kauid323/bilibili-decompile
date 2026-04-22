package tv.danmaku.bili.ui.splash.brand.model;

import com.bilibili.app.comm.realtime.RealTime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PreloadBrandData.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"isTimeValid", "", "Ltv/danmaku/bili/ui/splash/brand/model/PreloadBrandData;", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PreloadBrandDataKt {
    public static final boolean isTimeValid(PreloadBrandData $this$isTimeValid) {
        Intrinsics.checkNotNullParameter($this$isTimeValid, "<this>");
        long now = RealTime.unreliableNow();
        if (now > $this$isTimeValid.getEndTime() || now < $this$isTimeValid.getBeginTime()) {
            return false;
        }
        return true;
    }
}