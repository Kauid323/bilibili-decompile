package kntr.base.net.comm.flowcontrol.internal.config;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.KConfig;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* compiled from: FlowControlConfig.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u000e\u0010\u0018\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\rR\u000e\u0010\u001b\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\rR\u000e\u0010\u001e\u001a\u00020\u0013X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010#\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010'\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b(\u0010%¨\u0006)"}, d2 = {"Lkntr/base/net/comm/flowcontrol/internal/config/FlowControlConfig;", "", "<init>", "()V", "ENABLED", "", "enabled", "getEnabled", "()Z", "DISABLE_LIST", "", "disableList", "getDisableList", "()Ljava/lang/String;", "RETRY_MAX_TIMES", "", "INITIAL_DELAY_SECONDS", "MAX_DELAY_SECONDS", "FACTOR", "", "JITTER", "DEF_BACKOFF", "defBackoff", "getDefBackoff", "BIZ_BACKOFF", "bizBackoff", "getBizBackoff", "BIZ_SAMPLE", "bizSample", "getBizSample", "DEF_SAMPLE", "defSample", "getDefSample", "()Ljava/lang/Float;", "MIN_RETRY_AFTER", "minRetryAfter", "getMinRetryAfter", "()Ljava/lang/Integer;", "MAX_RETRY_AFTER", "maxRetryAfter", "getMaxRetryAfter", "flow_control_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FlowControlConfig {
    public static final String BIZ_BACKOFF = "";
    public static final String BIZ_SAMPLE = "";
    public static final String DEF_BACKOFF = "";
    public static final float DEF_SAMPLE = 1.0f;
    public static final String DISABLE_LIST = "[]";
    public static final boolean ENABLED = true;
    public static final float FACTOR = 1.5f;
    public static final int INITIAL_DELAY_SECONDS = 1;
    public static final FlowControlConfig INSTANCE = new FlowControlConfig();
    public static final float JITTER = 0.2f;
    public static final int MAX_DELAY_SECONDS = 5;
    public static final int MAX_RETRY_AFTER = 15;
    public static final int MIN_RETRY_AFTER = 3;
    public static final int RETRY_MAX_TIMES = Integer.MAX_VALUE;

    private FlowControlConfig() {
    }

    public final boolean getEnabled() {
        return KConfig.INSTANCE.ff("net_flow_control_enabled", true);
    }

    public final String getDisableList() {
        return KConfig.INSTANCE.config("net.flow_control_disable_list", null);
    }

    public final String getDefBackoff() {
        return KConfig.INSTANCE.config("net.flow_control_def_backoff", null);
    }

    public final String getBizBackoff() {
        return KConfig.INSTANCE.config("net.flow_control_biz_backoff", null);
    }

    public final String getBizSample() {
        return KConfig.INSTANCE.config("net.flow_control_biz_report_sample", null);
    }

    public final Float getDefSample() {
        String config = KConfig.INSTANCE.config("net.flow_control_def_report_sample", null);
        if (config != null) {
            return StringsKt.toFloatOrNull(config);
        }
        return null;
    }

    public final Integer getMinRetryAfter() {
        String config = KConfig.INSTANCE.config("net.flow_control_min_retry_after", null);
        if (config != null) {
            return StringsKt.toIntOrNull(config);
        }
        return null;
    }

    public final Integer getMaxRetryAfter() {
        String config = KConfig.INSTANCE.config("net.flow_control_max_retry_after", null);
        if (config != null) {
            return StringsKt.toIntOrNull(config);
        }
        return null;
    }
}