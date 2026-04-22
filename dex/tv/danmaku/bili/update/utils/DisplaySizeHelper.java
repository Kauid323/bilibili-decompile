package tv.danmaku.bili.update.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DisplaySizeHelper.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"ONE_KB", "", "ONE_MB", "ONE_GB", "HUN_KB", "HUN_MB", "byteCountToDisplaySize", "", "size", "updater_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DisplaySizeHelper {
    private static final long HUN_KB = 100000;
    private static final long HUN_MB = 100000000;
    private static final long ONE_GB = 1000000000;
    private static final long ONE_KB = 1000;
    private static final long ONE_MB = 1000000;

    public static final String byteCountToDisplaySize(long size) {
        StringBuilder sb = new StringBuilder();
        if (size >= ONE_GB) {
            long decimal = ((size % ONE_GB) / ONE_MB) / 100;
            sb.append(String.valueOf(size / ONE_GB));
            sb.append(".");
            sb.append(String.valueOf(decimal));
            sb.append("GB");
        } else if (size >= HUN_MB) {
            sb.append(String.valueOf(size / ONE_MB));
            sb.append("MB");
        } else if (size >= ONE_MB) {
            long decimal2 = ((size % ONE_MB) / 1000) / 100;
            sb.append(String.valueOf(size / ONE_MB));
            sb.append(".");
            sb.append(String.valueOf(decimal2));
            sb.append("MB");
        } else if (size >= 100000) {
            sb.append(String.valueOf(size / 1000));
            sb.append("KB");
        } else if (size >= 1000) {
            long decimal3 = (size % 1000) / 100;
            sb.append(String.valueOf(size / 1000));
            sb.append(".");
            sb.append(String.valueOf(decimal3));
            sb.append("KB");
        } else {
            sb.append(String.valueOf(size));
            sb.append("B");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}