package tv.danmaku.bili.report.biz.api.consume.consumer.misaka.apm;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.api.consume.consumer.misaka.apm.internal.filter.FilterKt;
import tv.danmaku.bili.report.biz.api.consume.consumer.misaka.apm.internal.sample.SampleKt;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;

/* compiled from: MisakaApmApi.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a\u001f\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0006\u001a\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"MISAKA_APM_LOGID_API", "", "misakaHit", ReportEvent.Tag.HOST, "", FileChooserActivity.PATH, "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Long;", "okhttpMisakaSample", "", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MisakaApmApiKt {
    private static final long MISAKA_APM_LOGID_API = 100001;

    @Deprecated(message = "使用标准采样定义")
    public static final Long misakaHit(String host, String path) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        if (!FilterKt.misakaFilter(host, path) && SampleKt.misakaSample(host, path)) {
            return Long.valueOf((long) MISAKA_APM_LOGID_API);
        }
        return null;
    }

    public static final boolean okhttpMisakaSample(String host, String path) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        if (FilterKt.misakaFilter(host, path)) {
            return false;
        }
        return SampleKt.misakaSample(host, path);
    }
}