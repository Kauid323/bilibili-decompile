package tv.danmaku.bili.report.biz.api.consume.consumer.track.apm.sample;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.api.consume.consumer.track.apm.config.TrackConfig;
import tv.danmaku.bili.report.biz.api.consume.filter.HostFilters;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.report.sample.Sample;
import tv.danmaku.bili.report.sample.Whitelist;
import tv.danmaku.bili.report.sample.rule.url.BizSample;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;

/* compiled from: NetErrorSample.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007\"\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"netErrorTrackSample", "Lkotlin/Pair;", "", "", ReportEvent.Tag.HOST, "", FileChooserActivity.PATH, "sBizNetErrorSample", "", "Ltv/danmaku/bili/report/sample/rule/url/BizSample;", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NetErrorSampleKt {
    private static final List<BizSample> sBizNetErrorSample;

    public static final Pair<Boolean, Float> netErrorTrackSample(String host, String path) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        if (HostFilters.Companion.reportRequest(host)) {
            return new Pair<>(false, Float.valueOf(0.0f));
        }
        if (Whitelist.Companion.wl()) {
            return new Pair<>(true, Float.valueOf(1.0f));
        }
        BizSample bizRate = BizSample.Companion.find(host, path, sBizNetErrorSample);
        if (bizRate != null) {
            return Sample.Companion.sample(bizRate.getSample());
        }
        return Sample.Companion.sample(DefSampleKt.trackDefErrorSample());
    }

    static {
        BizSample.Companion companion = BizSample.Companion;
        String netErrorSample = TrackConfig.INSTANCE.getNetErrorSample();
        if (netErrorSample == null) {
            netErrorSample = "[]";
        }
        List<BizSample> parse = companion.parse(netErrorSample);
        if (parse == null) {
            parse = CollectionsKt.emptyList();
        }
        sBizNetErrorSample = parse;
    }
}