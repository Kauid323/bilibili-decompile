package tv.danmaku.bili.report.biz.api.consume.consumer.misaka.apm.internal.sample;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.api.consume.consumer.misaka.apm.internal.config.MisakaConfig;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.report.sample.Whitelist;
import tv.danmaku.bili.report.sample.rule.url.BizSample;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;

/* compiled from: Sample.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007\u001a\b\u0010\b\u001a\u00020\tH\u0002\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"misakaSample", "", ReportEvent.Tag.HOST, "", FileChooserActivity.PATH, "sBizSampleRules", "", "Ltv/danmaku/bili/report/sample/rule/url/BizSample;", "defSample", "", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SampleKt {
    private static final List<BizSample> sBizSampleRules;

    public static final boolean misakaSample(String host, String path) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        if (Whitelist.Companion.wl()) {
            return true;
        }
        BizSample bizRate = BizSample.Companion.find(host, path, sBizSampleRules);
        if (bizRate != null) {
            return SamplesKt.sample2(bizRate.getSample());
        }
        return SamplesKt.sample(defSample());
    }

    static {
        BizSample.Companion companion = BizSample.Companion;
        String bizSample = MisakaConfig.INSTANCE.getBizSample();
        if (bizSample == null) {
            bizSample = "[]";
        }
        List<BizSample> parse = companion.parse(bizSample);
        if (parse == null) {
            parse = CollectionsKt.emptyList();
        }
        sBizSampleRules = parse;
    }

    private static final int defSample() {
        Integer intOrNull;
        String defSample = MisakaConfig.INSTANCE.getDefSample();
        if (defSample == null || (intOrNull = StringsKt.toIntOrNull(defSample)) == null) {
            return 100;
        }
        return intOrNull.intValue();
    }
}