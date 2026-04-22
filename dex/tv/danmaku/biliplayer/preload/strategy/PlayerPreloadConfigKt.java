package tv.danmaku.biliplayer.preload.strategy;

import android.content.SharedPreferences;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.neuron.util.SamplesKt;
import com.bilibili.player.preload.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;
import tv.danmaku.bili.update.internal.report.ConstsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerPreloadConfig.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\"\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"KEY_FF_PRELOAD", "", "KEY_SP_PRELOAD", "sampler", "", "preloadSwitchState", "", "getPreloadSwitchState", "()Z", "preloadSwitchState$delegate", "Lkotlin/Lazy;", "reportSampler", "Lkotlin/Function0;", "getReportSampler", "()Lkotlin/jvm/functions/Function0;", "getDebugSpValue", "key", "player-preload_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerPreloadConfigKt {
    public static final String KEY_FF_PRELOAD = "ff_key_player_preload";
    public static final String KEY_SP_PRELOAD = "key_sp_player_preload";
    private static final Lazy preloadSwitchState$delegate;
    private static final Function0<Boolean> reportSampler;
    private static final int sampler;

    static {
        Integer intOrNull;
        String str = (String) ConfigManager.Companion.config().get("player_common.preload_report_sampler", ConstsKt.ARG_INCREMENT_DOWNLOAD_FAILURE);
        sampler = (str == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) ? 5 : intOrNull.intValue();
        preloadSwitchState$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.biliplayer.preload.strategy.PlayerPreloadConfigKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean preloadSwitchState_delegate$lambda$0;
                preloadSwitchState_delegate$lambda$0 = PlayerPreloadConfigKt.preloadSwitchState_delegate$lambda$0();
                return Boolean.valueOf(preloadSwitchState_delegate$lambda$0);
            }
        });
        reportSampler = new Function0() { // from class: tv.danmaku.biliplayer.preload.strategy.PlayerPreloadConfigKt$$ExternalSyntheticLambda1
            public final Object invoke() {
                boolean reportSampler$lambda$0;
                reportSampler$lambda$0 = PlayerPreloadConfigKt.reportSampler$lambda$0();
                return Boolean.valueOf(reportSampler$lambda$0);
            }
        };
    }

    public static final boolean getPreloadSwitchState() {
        return ((Boolean) preloadSwitchState$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean preloadSwitchState_delegate$lambda$0() {
        boolean result = ConfigManager.Companion.isHitFF(KEY_FF_PRELOAD);
        int spValue = getDebugSpValue(KEY_SP_PRELOAD);
        return spValue == 0 ? result : spValue == 1;
    }

    public static final Function0<Boolean> getReportSampler() {
        return reportSampler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean reportSampler$lambda$0() {
        return SamplesKt.randInt(0, 99) < sampler;
    }

    private static final int getDebugSpValue(String key) {
        SharedPreferences bLKVSharedPreference;
        if (!BuildConfig.DEBUG || (bLKVSharedPreference = BiliGlobalPreferenceHelper.getBLKVSharedPreference()) == null) {
            return 0;
        }
        return bLKVSharedPreference.getInt(key, 0);
    }
}