package tv.danmaku.bili.moss.test.configs;

import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.BuildConfig;

/* compiled from: MossDevConfig.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/moss/test/configs/MossDevConfig;", "", "<init>", "()V", "DEF_ENABLE", "", "getDEF_ENABLE", "()Z", "enable", "getEnable", "()Ljava/lang/Boolean;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MossDevConfig {
    public static final int $stable = 0;
    public static final MossDevConfig INSTANCE = new MossDevConfig();
    private static final boolean DEF_ENABLE = BuildConfig.DEBUG;

    private MossDevConfig() {
    }

    public final boolean getDEF_ENABLE() {
        return DEF_ENABLE;
    }

    public final Boolean getEnable() {
        return (Boolean) Contract.-CC.get$default(ConfigManager.Companion.ab(), "grpc_dev_enable", (Object) null, 2, (Object) null);
    }
}