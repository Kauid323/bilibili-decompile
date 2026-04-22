package video.base.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: VBStriingExt.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002¨\u0006\u0005"}, d2 = {"toLongOrZero", "", "", "isDigitsOnly", "", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VBStriingExtKt {
    public static final long toLongOrZero(String $this$toLongOrZero) {
        Intrinsics.checkNotNullParameter($this$toLongOrZero, "<this>");
        try {
            return Long.parseLong($this$toLongOrZero);
        } catch (Exception e) {
            return 0L;
        }
    }

    public static final boolean isDigitsOnly(String $this$isDigitsOnly) {
        Intrinsics.checkNotNullParameter($this$isDigitsOnly, "<this>");
        if ($this$isDigitsOnly.length() == 0) {
            return false;
        }
        int length = $this$isDigitsOnly.length();
        for (int i = 0; i < length; i++) {
            char c = $this$isDigitsOnly.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}