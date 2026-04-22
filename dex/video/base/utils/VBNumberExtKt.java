package video.base.utils;

import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.String2_commonMainKt;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: VBNumberExt.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0004\u001a(\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\"\u000e\u0010\n\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0002X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"toFileSize", "", "", "toCountStr", "", "formatPlayTime", "forceShowHour", "", "isShowZeroOfMinute", "isShowZeroOfHour", "KB", "MB", "GB", "ONE_HOUR", "ONE_MINUTE", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VBNumberExtKt {
    public static final long GB = 1073741824;
    public static final long KB = 1024;
    public static final long MB = 1048576;
    public static final int ONE_HOUR = 3600;
    public static final int ONE_MINUTE = 60;

    public static final String toFileSize(long $this$toFileSize) {
        return $this$toFileSize >= 1073741824 ? StriingExt_androidKt.format("%.1fGB", Float.valueOf(((float) $this$toFileSize) / ((float) 1073741824))) : $this$toFileSize >= MB ? StriingExt_androidKt.format("%.1fMB", Float.valueOf(((float) $this$toFileSize) / ((float) MB))) : $this$toFileSize >= 1024 ? StriingExt_androidKt.format("%.1fKB", Float.valueOf(((float) $this$toFileSize) / ((float) 1024))) : $this$toFileSize + "B";
    }

    public static final String toCountStr(int $this$toCountStr) {
        if ($this$toCountStr <= 0) {
            return "0";
        }
        if ($this$toCountStr < 10000) {
            return String.valueOf($this$toCountStr);
        }
        if ($this$toCountStr < 100000000) {
            double value = $this$toCountStr / 10000.0d;
            return StringsKt.replace$default(StriingExt_androidKt.format(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2279(PlayerbaseresRes.INSTANCE.getString())), Double.valueOf(value)), ".0", "", false, 4, (Object) null);
        }
        double value2 = $this$toCountStr / 1.0E8d;
        return StringsKt.replace$default(StriingExt_androidKt.format(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2280(PlayerbaseresRes.INSTANCE.getString())), Double.valueOf(value2)), ".0", "", false, 4, (Object) null);
    }

    public static /* synthetic */ String formatPlayTime$default(long j, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            z3 = true;
        }
        return formatPlayTime(j, z, z2, z3);
    }

    public static final String formatPlayTime(long $this$formatPlayTime, boolean forceShowHour, boolean isShowZeroOfMinute, boolean isShowZeroOfHour) {
        long totalSeconds = (long) Math.ceil($this$formatPlayTime / 1000.0d);
        long j = (long) ONE_HOUR;
        int hours = (int) (totalSeconds / j);
        long j2 = 60;
        int minutes = (int) ((totalSeconds % j) / j2);
        int seconds = (int) (totalSeconds % j2);
        return totalSeconds < 3600 ? forceShowHour ? isShowZeroOfMinute ? StriingExt_androidKt.format("%02d:%02d:%02d", Integer.valueOf(hours), Integer.valueOf(minutes), Integer.valueOf(seconds)) : StriingExt_androidKt.format("%02d:%d:%02d", Integer.valueOf(hours), Integer.valueOf(minutes), Integer.valueOf(seconds)) : isShowZeroOfMinute ? StriingExt_androidKt.format("%02d:%02d", Integer.valueOf(minutes), Integer.valueOf(seconds)) : StriingExt_androidKt.format("%d:%02d", Integer.valueOf(minutes), Integer.valueOf(seconds)) : (totalSeconds < 3600 || totalSeconds >= 36000) ? StriingExt_androidKt.format("%d:%02d:%02d", Integer.valueOf(hours), Integer.valueOf(minutes), Integer.valueOf(seconds)) : isShowZeroOfHour ? StriingExt_androidKt.format("%02d:%02d:%02d", Integer.valueOf(hours), Integer.valueOf(minutes), Integer.valueOf(seconds)) : StriingExt_androidKt.format("%01d:%02d:%02d", Integer.valueOf(hours), Integer.valueOf(minutes), Integer.valueOf(seconds));
    }
}