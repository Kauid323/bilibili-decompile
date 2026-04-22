package tv.danmaku.bili.moss.hassan;

import android.app.Application;
import android.content.SharedPreferences;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.lib.blconfig.ConfigManager;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;
import tv.danmaku.bili.ui.garb.GarbJsBridgeCallHandlerKt;

/* compiled from: HassanMoss.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0014J\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/moss/hassan/HassanMoss;", "", "<init>", "()V", "CONFIG_KEY", "", "UAT_HEADER_NAME", "MOCK_IP_HEADER_NAME", "KEY_ENV", "KEY_COLOR", "KEY_IP", "sp", "Landroid/content/SharedPreferences;", "env", "spyColor", "mockIp", "enable", "", ReportEvent.Tag.HOST, GarbJsBridgeCallHandlerKt.PURE_THEME, "", "mockIpHeader", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HassanMoss {
    public static final int $stable;
    private static final String CONFIG_KEY = "uat.unsupported_hosts";
    public static final HassanMoss INSTANCE = new HassanMoss();
    private static final String KEY_COLOR = "uat.color";
    private static final String KEY_ENV = "uat.env";
    private static final String KEY_IP = "debug_custom_ip_address";
    public static final String MOCK_IP_HEADER_NAME = "x-backend-bili-real-ip";
    public static final String UAT_HEADER_NAME = "x1-bilispy-color";
    private static SharedPreferences sp;

    private HassanMoss() {
    }

    static {
        Application application = BiliContext.application();
        Intrinsics.checkNotNull(application);
        SharedPreferences bLKVSharedPreference = BiliGlobalPreferenceHelper.getBLKVSharedPreference(application);
        Intrinsics.checkNotNullExpressionValue(bLKVSharedPreference, "getBLKVSharedPreference(...)");
        sp = bLKVSharedPreference;
        $stable = 8;
    }

    private final String env() {
        String string = sp.getString(KEY_ENV, "prod");
        Intrinsics.checkNotNull(string);
        return string;
    }

    private final String spyColor() {
        String string = sp.getString(KEY_COLOR, "");
        Intrinsics.checkNotNull(string);
        return string;
    }

    private final String mockIp() {
        String string = sp.getString(KEY_IP, "");
        Intrinsics.checkNotNull(string);
        return string;
    }

    public final boolean enable(String host) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        String env = env();
        if (!Intrinsics.areEqual(env, "prod")) {
            Object obj = ConfigManager.Companion.config().get(CONFIG_KEY, "");
            Intrinsics.checkNotNull(obj);
            if (!Pattern.matches((String) obj, host)) {
                return true;
            }
        }
        return false;
    }

    public final String host(String host) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        String env = env();
        if (StringsKt.startsWith$default(host, env + "-", false, 2, (Object) null)) {
            return host;
        }
        return env + "-" + host;
    }

    public final Map<String, String> color() {
        String c = spyColor();
        if (!StringsKt.isBlank(c)) {
            return MapsKt.mapOf(TuplesKt.to(UAT_HEADER_NAME, c));
        }
        return MapsKt.emptyMap();
    }

    public final Map<String, String> mockIpHeader() {
        String ip = mockIp();
        if (!StringsKt.isBlank(ip)) {
            return MapsKt.mapOf(TuplesKt.to(MOCK_IP_HEADER_NAME, ip));
        }
        return MapsKt.emptyMap();
    }
}