package tv.danmaku.bili.report.biz.api.consume.consumer.track.apm.sample;

import kotlin.Metadata;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.api.consume.consumer.track.apm.config.TrackConfig;

/* compiled from: DefSample.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0003"}, d2 = {"trackDefSample", "", "trackDefErrorSample", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DefSampleKt {
    public static final int trackDefSample() {
        Integer intOrNull;
        String defSample = TrackConfig.INSTANCE.getDefSample();
        if (defSample == null || (intOrNull = StringsKt.toIntOrNull(defSample)) == null) {
            return 10;
        }
        return intOrNull.intValue();
    }

    public static final int trackDefErrorSample() {
        Integer intOrNull;
        String defErrorSample = TrackConfig.INSTANCE.getDefErrorSample();
        if (defErrorSample == null || (intOrNull = StringsKt.toIntOrNull(defErrorSample)) == null) {
            return 10000;
        }
        return intOrNull.intValue();
    }
}