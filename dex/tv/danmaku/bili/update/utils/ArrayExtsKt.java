package tv.danmaku.bili.update.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ArrayExts.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toHexString", "", "", "updater_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ArrayExtsKt {
    public static final String toHexString(byte[] $this$toHexString) {
        Intrinsics.checkNotNullParameter($this$toHexString, "<this>");
        StringBuilder hexString = new StringBuilder();
        for (byte b : $this$toHexString) {
            int intVal = b & 255;
            if (intVal < 16) {
                hexString.append('0');
            }
            hexString.append(Integer.toHexString(intVal));
        }
        return hexString.toString();
    }
}