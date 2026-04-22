package tv.danmaku.biliplayerv2.service.report.heartbeat;

import com.bilibili.lib.dd.DeviceDecision;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IHeartbeatService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"hitPlayExtraMerge", "", "getHitPlayExtraMerge", "()Z", "hitPlayExtraMerge$delegate", "Lkotlin/Lazy;", "biliplayerv2_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class IHeartbeatServiceKt {
    private static final Lazy hitPlayExtraMerge$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.biliplayerv2.service.report.heartbeat.IHeartbeatServiceKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean hitPlayExtraMerge_delegate$lambda$0;
            hitPlayExtraMerge_delegate$lambda$0 = IHeartbeatServiceKt.hitPlayExtraMerge_delegate$lambda$0();
            return Boolean.valueOf(hitPlayExtraMerge_delegate$lambda$0);
        }
    });

    public static final boolean getHitPlayExtraMerge() {
        return ((Boolean) hitPlayExtraMerge$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hitPlayExtraMerge_delegate$lambda$0() {
        return DeviceDecision.INSTANCE.getBoolean("ff_player_extra_merge_869", true);
    }
}