package kntr.base.net.comm.flowcontrol.internal.protocol;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfig;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffPolicy;
import kntr.base.net.comm.flowcontrol.internal.backoff.PathBackoff;
import kntr.base.net.comm.flowcontrol.internal.config.FlowControlConfig;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;

/* compiled from: Backoff.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001\u001a\b\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0001H\u0002\u001a\b\u0010\n\u001a\u00020\u0007H\u0002\u001a\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"TAG", "", "blockPolicy", "Lkntr/base/net/comm/flowcontrol/internal/backoff/BackoffPolicy;", "host", "path", "defConfig", "Lkntr/base/net/comm/flowcontrol/internal/backoff/BackoffConfig;", "parseConfig", RedirectImpKt.REDIRECT_KV_CONFIG, "defaultConfig", "bizConfig", "", "Lkntr/base/net/comm/flowcontrol/internal/backoff/PathBackoff;", "flow_control_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BackoffKt {
    public static final String TAG = "net.flowcontrol.backoff";

    public static final BackoffPolicy blockPolicy(String host, String path) {
        BackoffConfig defConfig;
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(path, "path");
        PathBackoff biz = PathBackoff.Companion.matches(host, path, bizConfig());
        if (biz == null || (defConfig = biz.getBackoff()) == null) {
            defConfig = defConfig();
        }
        BackoffPolicy result = BackoffConfigKt.newPolicy(defConfig);
        KLog_androidKt.getKLog().i(TAG, "Block config %s." + result.toJsonString());
        return result;
    }

    private static final BackoffConfig defConfig() {
        String defBackoff = FlowControlConfig.INSTANCE.getDefBackoff();
        if (defBackoff == null) {
            defBackoff = "";
        }
        BackoffConfig parseConfig = parseConfig(defBackoff);
        return parseConfig == null ? defaultConfig() : parseConfig;
    }

    private static final BackoffConfig parseConfig(String config) {
        try {
            Json this_$iv = Json.Default;
            this_$iv.getSerializersModule();
            return (BackoffConfig) this_$iv.decodeFromString(BackoffConfig.Companion.serializer(), config);
        } catch (Throwable th) {
            return null;
        }
    }

    private static final BackoffConfig defaultConfig() {
        return new BackoffConfig(FlowControlConfig.RETRY_MAX_TIMES, 1, 5, 1.5f, 0.2f);
    }

    private static final List<PathBackoff> bizConfig() {
        PathBackoff.Companion companion = PathBackoff.Companion;
        String bizBackoff = FlowControlConfig.INSTANCE.getBizBackoff();
        if (bizBackoff == null) {
            bizBackoff = "";
        }
        List<PathBackoff> parse = companion.parse(bizBackoff);
        return parse == null ? CollectionsKt.emptyList() : parse;
    }
}