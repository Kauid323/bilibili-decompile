package tv.danmaku.bili.flowcontrol.internal.config;

import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;

/* compiled from: FlowControlConfig.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u001c\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0003R\u0016\u0010\u0011\u001a\u00020\u000f8\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0003R\u0016\u0010\u0013\u001a\u00020\u000f8\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0003R\u0016\u0010\u0015\u001a\u00020\u00168\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0003R\u0016\u0010\u0018\u001a\u00020\u00168\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0003R\u0016\u0010\u001a\u001a\u00020\n8\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u0003R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\n8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0003\u001a\u0004\b\u001e\u0010\rR\u0016\u0010\u001f\u001a\u00020\n8\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b \u0010\u0003R\u001c\u0010!\u001a\u0004\u0018\u00010\n8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010\rR\u000e\u0010$\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010%\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b&\u0010\rR\u000e\u0010'\u001a\u00020\u0016X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010(\u001a\u0004\u0018\u00010\u00168F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010,\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u0013\u00100\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b1\u0010.¨\u00062"}, d2 = {"Ltv/danmaku/bili/flowcontrol/internal/config/FlowControlConfig;", "", "<init>", "()V", "ENABLED", "", "enabled", "getEnabled", "()Ljava/lang/Boolean;", "DISABLE_LIST", "", "disableList", "getDisableList", "()Ljava/lang/String;", "RETRY_MAX_TIMES", "", "getRETRY_MAX_TIMES$annotations", "INITIAL_DELAY_SECONDS", "getINITIAL_DELAY_SECONDS$annotations", "MAX_DELAY_SECONDS", "getMAX_DELAY_SECONDS$annotations", "FACTOR", "", "getFACTOR$annotations", "JITTER", "getJITTER$annotations", "DEF_BACKOFF", "getDEF_BACKOFF$annotations", "defBackoff", "getDefBackoff$annotations", "getDefBackoff", "BIZ_BACKOFF", "getBIZ_BACKOFF$annotations", "bizBackoff", "getBizBackoff$annotations", "getBizBackoff", "BIZ_SAMPLE", "bizSample", "getBizSample", "DEF_SAMPLE", "defSample", "getDefSample", "()Ljava/lang/Float;", "MIN_RETRY_AFTER", "minRetryAfter", "getMinRetryAfter", "()Ljava/lang/Integer;", "MAX_RETRY_AFTER", "maxRetryAfter", "getMaxRetryAfter", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
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

    @Deprecated(message = "使用接口下发常量")
    public static /* synthetic */ void getBIZ_BACKOFF$annotations() {
    }

    @Deprecated(message = "使用接口下发常量")
    public static /* synthetic */ void getBizBackoff$annotations() {
    }

    @Deprecated(message = "使用接口下发常量")
    public static /* synthetic */ void getDEF_BACKOFF$annotations() {
    }

    @Deprecated(message = "使用接口下发常量")
    public static /* synthetic */ void getDefBackoff$annotations() {
    }

    @Deprecated(message = "使用接口下发常量")
    public static /* synthetic */ void getFACTOR$annotations() {
    }

    @Deprecated(message = "使用接口下发常量")
    public static /* synthetic */ void getINITIAL_DELAY_SECONDS$annotations() {
    }

    @Deprecated(message = "使用接口下发常量")
    public static /* synthetic */ void getJITTER$annotations() {
    }

    @Deprecated(message = "使用接口下发常量")
    public static /* synthetic */ void getMAX_DELAY_SECONDS$annotations() {
    }

    @Deprecated(message = "使用接口下发常量")
    public static /* synthetic */ void getRETRY_MAX_TIMES$annotations() {
    }

    private FlowControlConfig() {
    }

    public final Boolean getEnabled() {
        return (Boolean) Contract.-CC.get$default(ConfigManager.Companion.ab(), "net_flow_control_enabled", (Object) null, 2, (Object) null);
    }

    public final String getDisableList() {
        return (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "net.flow_control_disable_list", (Object) null, 2, (Object) null);
    }

    public final String getDefBackoff() {
        return (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "net.flow_control_def_backoff", (Object) null, 2, (Object) null);
    }

    public final String getBizBackoff() {
        return (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "net.flow_control_biz_backoff", (Object) null, 2, (Object) null);
    }

    public final String getBizSample() {
        return (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "net.flow_control_biz_report_sample", (Object) null, 2, (Object) null);
    }

    public final Float getDefSample() {
        String str = (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "net.flow_control_def_report_sample", (Object) null, 2, (Object) null);
        if (str != null) {
            return StringsKt.toFloatOrNull(str);
        }
        return null;
    }

    public final Integer getMinRetryAfter() {
        String str = (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "net.flow_control_min_retry_after", (Object) null, 2, (Object) null);
        if (str != null) {
            return StringsKt.toIntOrNull(str);
        }
        return null;
    }

    public final Integer getMaxRetryAfter() {
        String str = (String) Contract.-CC.get$default(ConfigManager.Companion.config(), "net.flow_control_max_retry_after", (Object) null, 2, (Object) null);
        if (str != null) {
            return StringsKt.toIntOrNull(str);
        }
        return null;
    }
}