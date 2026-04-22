package tv.danmaku.bili.ui.splash.common.search;

import com.bilibili.app.comm.realtime.RealTime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: QueryItem.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"isValid", "", "Ltv/danmaku/bili/ui/splash/common/search/QueryItem;", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class QueryItemKt {
    public static final boolean isValid(QueryItem $this$isValid) {
        Intrinsics.checkNotNullParameter($this$isValid, "<this>");
        long now = RealTime.unreliableNow();
        if (now > $this$isValid.getETime() || now < $this$isValid.getSTime()) {
            return false;
        }
        return true;
    }
}