package tv.danmaku.bili.flowcontrol.internal.protocol;

import com.alibaba.fastjson.JSON;
import com.bilibili.lib.moss.utils.backoff.BackoffConfig;
import com.bilibili.lib.moss.utils.backoff.BackoffConfigKt;
import com.bilibili.lib.moss.utils.backoff.BackoffPolicy;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.flowcontrol.internal.config.FlowControlConfig;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.report.sample.rule.backoff.PathBackoff;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;

/* compiled from: Backoff.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0007\u001a\b\u0010\u0006\u001a\u00020\u0007H\u0003\u001a\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0001H\u0003\u001a\b\u0010\n\u001a\u00020\u0007H\u0003\u001a\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"TAG", "", "blockPolicy", "Lcom/bilibili/lib/moss/utils/backoff/BackoffPolicy;", ReportEvent.Tag.HOST, FileChooserActivity.PATH, "defConfig", "Lcom/bilibili/lib/moss/utils/backoff/BackoffConfig;", "parseConfig", "config", "defaultConfig", "bizConfig", "", "Ltv/danmaku/bili/report/sample/rule/backoff/PathBackoff;", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BackoffKt {
    public static final String TAG = "net.flowcontrol.backoff";

    @Deprecated(message = "使用接口下发常量")
    public static final BackoffPolicy blockPolicy(String host, String path) {
        BackoffConfig defConfig;
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        PathBackoff biz = PathBackoff.Companion.matches(host, path, bizConfig());
        if (biz == null || (defConfig = biz.getBackoff()) == null) {
            defConfig = defConfig();
        }
        BackoffPolicy result = BackoffConfigKt.newPolicy(defConfig);
        BLog.ifmt(TAG, "Block config %s.", result.toJsonString());
        return result;
    }

    @Deprecated(message = "使用接口下发常量")
    private static final BackoffConfig defConfig() {
        String defBackoff = FlowControlConfig.INSTANCE.getDefBackoff();
        if (defBackoff == null) {
            defBackoff = "";
        }
        BackoffConfig parseConfig = parseConfig(defBackoff);
        if (parseConfig != null) {
            return parseConfig;
        }
        return defaultConfig();
    }

    @Deprecated(message = "使用接口下发常量")
    private static final BackoffConfig parseConfig(String config) {
        try {
            return (BackoffConfig) JSON.parseObject(config, BackoffConfig.class);
        } catch (Throwable th) {
            return null;
        }
    }

    @Deprecated(message = "使用接口下发常量")
    private static final BackoffConfig defaultConfig() {
        return new BackoffConfig((int) FlowControlConfig.RETRY_MAX_TIMES, 1, 5, 1.5f, 0.2f);
    }

    @Deprecated(message = "使用接口下发常量")
    private static final List<PathBackoff> bizConfig() {
        PathBackoff.Companion companion = PathBackoff.Companion;
        String bizBackoff = FlowControlConfig.INSTANCE.getBizBackoff();
        if (bizBackoff == null) {
            bizBackoff = "";
        }
        List<PathBackoff> parse = companion.parse(bizBackoff);
        if (parse != null) {
            return parse;
        }
        return CollectionsKt.emptyList();
    }
}