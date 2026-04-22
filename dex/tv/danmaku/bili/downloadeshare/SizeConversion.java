package tv.danmaku.bili.downloadeshare;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: DownloadShareTaskManager.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ltv/danmaku/bili/downloadeshare/SizeConversion;", "", "<init>", "()V", "Companion", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SizeConversion {
    public static final Companion Companion = new Companion(null);
    private static final long GB = 1073741824;
    private static final long KB = 1024;
    private static final long MB = 1048576;

    /* compiled from: DownloadShareTaskManager.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0015\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/downloadeshare/SizeConversion$Companion;", "", "<init>", "()V", "KB", "", "MB", "GB", "byteToSize", "", "size", "(Ljava/lang/Long;)Ljava/lang/String;", "getRoundValue", "dividend", "divisor", "getReportVideoSize", "getReportVideoSize$downloadsharecommon_debug", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final String byteToSize(Long size) {
            if (size == null) {
                return "";
            }
            if (size.longValue() >= SizeConversion.GB) {
                return getRoundValue(size.longValue(), SizeConversion.GB) + "G";
            } else if (size.longValue() >= SizeConversion.MB) {
                return getRoundValue(size.longValue(), SizeConversion.MB) + "M";
            } else {
                return getRoundValue(size.longValue(), SizeConversion.KB) + "KB";
            }
        }

        private final String getRoundValue(long dividend, long divisor) {
            String format = new DecimalFormat("#.#").format(new BigDecimal(dividend).divide(new BigDecimal(divisor)).setScale(1, RoundingMode.UP));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        }

        public final String getReportVideoSize$downloadsharecommon_debug(long size) {
            return getRoundValue(size, SizeConversion.MB);
        }
    }

    @JvmStatic
    public static final String byteToSize(Long size) {
        return Companion.byteToSize(size);
    }
}