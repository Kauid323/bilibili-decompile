package tv.danmaku.bili.report.biz.api.consume.consumer.misaka.apm.internal.filter;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.api.consume.consumer.misaka.apm.internal.config.MisakaConfig;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.report.sample.rule.path.PathRule;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;

/* compiled from: Filter.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"misakaFilter", "", ReportEvent.Tag.HOST, "", FileChooserActivity.PATH, "sBizFilterRules", "", "Ltv/danmaku/bili/report/sample/rule/path/PathRule;", "defaultList", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FilterKt {
    private static final List<PathRule> sBizFilterRules;

    public static final boolean misakaFilter(String host, String path) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        return PathRule.Companion.matches(host, path, sBizFilterRules);
    }

    static {
        PathRule.Companion companion = PathRule.Companion;
        String bizFilter = MisakaConfig.INSTANCE.getBizFilter();
        if (bizFilter == null) {
            bizFilter = "";
        }
        List<PathRule> parse = companion.parse(bizFilter);
        if (parse == null) {
            parse = defaultList();
        }
        sBizFilterRules = parse;
    }

    private static final List<PathRule> defaultList() {
        return CollectionsKt.listOf(new PathRule[]{new PathRule("data.bilibili.com", ""), new PathRule("live-trace.bilibili.com", ""), new PathRule("api.bilibili.com", "/x/report/heartbeat"), new PathRule("api.bilibili.com", "/x/report/heartbeat/mobile")});
    }
}