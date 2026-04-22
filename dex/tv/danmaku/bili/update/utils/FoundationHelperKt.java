package tv.danmaku.bili.update.utils;

import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.foundation.env.EnvManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: FoundationHelper.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"foundationParams", "", "", "updater_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class FoundationHelperKt {
    public static final Map<String, String> foundationParams() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("mobi_app", FoundationAlias.getFapps().getMobiApp()), TuplesKt.to("appid", FoundationAlias.getFapps().getAppId()), TuplesKt.to("sn", FoundationAlias.getFapps().getFawkesBuildSN()), TuplesKt.to("vn", FoundationAlias.getFapps().getVersionName()), TuplesKt.to("iv", String.valueOf(FoundationAlias.getFapps().getInternalVersionCode())), TuplesKt.to("build", String.valueOf(FoundationAlias.getFapps().getVersionCode())), TuplesKt.to("screen", FoundationAlias.getFdevices().getScreen()), TuplesKt.to("brand", FoundationAlias.getFdevices().getBrand()), TuplesKt.to("model", FoundationAlias.getFdevices().getModel()), TuplesKt.to("env", EnvManager.getCurrent().getLabel()), TuplesKt.to("ov", String.valueOf(FoundationAlias.getFdevices().getOsVersion())), TuplesKt.to("channel", FoundationAlias.getFapps().getChannel())});
    }
}