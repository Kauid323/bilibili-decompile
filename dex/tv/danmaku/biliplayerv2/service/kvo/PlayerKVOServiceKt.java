package tv.danmaku.biliplayerv2.service.kvo;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerKVOService.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"positiveValue", "", "", "biliplayerv2_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerKVOServiceKt {
    public static final /* synthetic */ boolean access$positiveValue(String $receiver) {
        return positiveValue($receiver);
    }

    public static final boolean positiveValue(String $this$positiveValue) {
        return Intrinsics.areEqual($this$positiveValue, "1");
    }
}