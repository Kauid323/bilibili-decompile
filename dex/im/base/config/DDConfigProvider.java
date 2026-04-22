package im.base.config;

import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* compiled from: DDConfigProvider.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lim/base/config/DDConfigProvider;", "Lim/base/config/IMConfigSettingProvider;", "<init>", "()V", "getIMConfigSetting", "Lim/base/config/IMConfigSetting;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DDConfigProvider implements IMConfigSettingProvider {
    @Override // im.base.config.IMConfigSettingProvider
    public IMConfigSetting getIMConfigSetting() {
        long j;
        long j2;
        Long longOrNull;
        Long longOrNull2;
        boolean ff$default = IPlatformConfig.-CC.ff$default(KConfig.INSTANCE, "im_session_refactor", false, 2, (Object) null);
        boolean ff$default2 = IPlatformConfig.-CC.ff$default(KConfig.INSTANCE, "im_chat_refactor", false, 2, (Object) null);
        String config$default = IPlatformConfig.-CC.config$default(KConfig.INSTANCE, "im_chat_loop_fetch_ms", (String) null, 2, (Object) null);
        if (config$default != null && (longOrNull2 = StringsKt.toLongOrNull(config$default)) != null) {
            Duration.Companion companion = Duration.Companion;
            j = DurationKt.toDuration(longOrNull2.longValue(), DurationUnit.MILLISECONDS);
        } else {
            j = Duration.Companion.getZERO-UwyO8pc();
        }
        String config$default2 = IPlatformConfig.-CC.config$default(KConfig.INSTANCE, "im_chat_send_delay_ms", (String) null, 2, (Object) null);
        if (config$default2 != null && (longOrNull = StringsKt.toLongOrNull(config$default2)) != null) {
            Duration.Companion companion2 = Duration.Companion;
            j2 = DurationKt.toDuration(longOrNull.longValue(), DurationUnit.MILLISECONDS);
        } else {
            j2 = Duration.Companion.getZERO-UwyO8pc();
        }
        return new IMConfigSetting(ff$default, ff$default2, j, j2, null);
    }
}