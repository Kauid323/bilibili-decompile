package tv.danmaku.bili.report;

import com.bilibili.lib.config.BLRemoteConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: OnlineParamsHelper.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000b\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/report/OnlineParamsHelper;", "", "<init>", "()V", "TAG", "", "apiErrorNeuronSampleRate", "", "getApiErrorNeuronSampleRate$annotations", "getApiErrorNeuronSampleRate", "()I", "isHttpsEnabled", "", "isHttpsEnabled$annotations", "()Z", "getConfigInt", "key", "def", "isCDNStrategy", "isCDNStrategy$annotations", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OnlineParamsHelper {
    public static final OnlineParamsHelper INSTANCE = new OnlineParamsHelper();
    private static final String TAG = "tv.danmaku.bili.OnlineParamsHelper";

    @JvmStatic
    public static /* synthetic */ void getApiErrorNeuronSampleRate$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isCDNStrategy$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isHttpsEnabled$annotations() {
    }

    private OnlineParamsHelper() {
    }

    public static final int getApiErrorNeuronSampleRate() {
        return getConfigInt("api_error_neuron_sample_rate", 1000);
    }

    public static final boolean isHttpsEnabled() {
        return getConfigInt("use_https_api", 1) == 1;
    }

    @JvmStatic
    public static final int getConfigInt(String key, int def) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            return BLRemoteConfig.getInstance().getInt(key, def);
        } catch (Throwable th) {
            return def;
        }
    }

    public static final boolean isCDNStrategy() {
        return getConfigInt("cdn_strategy", 1) == 1;
    }
}