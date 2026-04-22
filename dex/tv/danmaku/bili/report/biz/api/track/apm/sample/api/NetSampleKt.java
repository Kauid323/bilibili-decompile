package tv.danmaku.bili.report.biz.api.track.apm.sample.api;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.api.consume.consumer.track.apm.config.TrackConfig;
import tv.danmaku.bili.report.biz.api.consume.consumer.track.apm.sample.DefSampleKt;
import tv.danmaku.bili.report.biz.api.consume.filter.HostFilters;
import tv.danmaku.bili.report.biz.api.consume.sample.ProtocolSample;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.report.sample.Sample;
import tv.danmaku.bili.report.sample.Whitelist;
import tv.danmaku.bili.report.sample.rule.url.BizSample;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;

/* compiled from: NetSample.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005H\u0007\"\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"netTrackSample", "Lkotlin/Pair;", "", "", ReportEvent.Tag.HOST, "", FileChooserActivity.PATH, "protocol", "sBizSampleRules", "", "Ltv/danmaku/bili/report/sample/rule/url/BizSample;", "sProtocolSampleRules", "Ltv/danmaku/bili/report/biz/api/consume/sample/ProtocolSample;", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NetSampleKt {
    private static final List<BizSample> sBizSampleRules;
    private static final List<ProtocolSample> sProtocolSampleRules;

    public static /* synthetic */ Pair netTrackSample$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        return netTrackSample(str, str2, str3);
    }

    public static final Pair<Boolean, Float> netTrackSample(String host, String path, String protocol) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        if (HostFilters.Companion.reportRequest(host)) {
            return new Pair<>(false, Float.valueOf(0.0f));
        }
        if (Whitelist.Companion.wl()) {
            return new Pair<>(true, Float.valueOf(1.0f));
        }
        BizSample bizRate = BizSample.Companion.find(host, path, sBizSampleRules);
        if (bizRate != null) {
            return Sample.Companion.sample(bizRate.getSample());
        }
        ProtocolSample protocolRate = ProtocolSample.Companion.find(protocol, sProtocolSampleRules);
        if (protocolRate != null) {
            return Sample.Companion.sample(protocolRate.getSample());
        }
        return Sample.Companion.sample(DefSampleKt.trackDefSample());
    }

    static {
        BizSample.Companion companion = BizSample.Companion;
        String netSample = TrackConfig.INSTANCE.getNetSample();
        if (netSample == null) {
            netSample = "[]";
        }
        List<BizSample> parse = companion.parse(netSample);
        if (parse == null) {
            parse = CollectionsKt.emptyList();
        }
        sBizSampleRules = parse;
        ProtocolSample.Companion companion2 = ProtocolSample.Companion;
        String netProtocolSample = TrackConfig.INSTANCE.getNetProtocolSample();
        List<ProtocolSample> parse2 = companion2.parse(netProtocolSample != null ? netProtocolSample : "[]");
        if (parse2 == null) {
            parse2 = CollectionsKt.emptyList();
        }
        sProtocolSampleRules = parse2;
    }
}