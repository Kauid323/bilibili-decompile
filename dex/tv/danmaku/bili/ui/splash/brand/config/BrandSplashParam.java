package tv.danmaku.bili.ui.splash.brand.config;

import android.content.Context;
import bili.resource.settings.R;
import com.bilibili.lib.config.BLRemoteConfig;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashParam.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0011H\u0002¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/config/BrandSplashParam;", "", "<init>", "()V", "brandSplashEnable", "", "getDefaultDuration", "", "defaultBrandEnable", "getSplashSettingTitle", "", "context", "Landroid/content/Context;", "getConfigLong", "key", "def", "getConfigInt", "", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashParam {
    public static final int $stable = 0;
    public static final BrandSplashParam INSTANCE = new BrandSplashParam();

    private BrandSplashParam() {
    }

    public final boolean brandSplashEnable() {
        return getConfigInt("brandsplash_show", 1) == 1;
    }

    public final long getDefaultDuration() {
        return getConfigLong("brandsplash_baseline_duration", 700L);
    }

    public final boolean defaultBrandEnable() {
        return getConfigInt("brandsplash_baseline_show", 1) == 1;
    }

    public final String getSplashSettingTitle(Context context) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        String string = context2.getString(R.string.settings_global_string_37);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String dd = DeviceDecision.INSTANCE.dd("brandsplash_setting_name", string);
        return dd == null ? string : dd;
    }

    private final long getConfigLong(String key, long def) {
        try {
            return BLRemoteConfig.getInstance().getLong(key, def);
        } catch (NumberFormatException e) {
            return def;
        }
    }

    private final int getConfigInt(String key, int def) {
        try {
            return BLRemoteConfig.getInstance().getInt(key, def);
        } catch (NumberFormatException e) {
            return def;
        }
    }
}