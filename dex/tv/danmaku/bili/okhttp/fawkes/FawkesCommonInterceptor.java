package tv.danmaku.bili.okhttp.fawkes;

import com.bilibili.api.BiliConfig;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.lib.biliid.api.BuvidHelper;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.foundation.env.EnvManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import tv.danmaku.android.util.CpuUtils;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.okhttp.CustomParamsAndHeaderInterceptor;

/* compiled from: FawkesCommonInterceptor.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0016J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/okhttp/fawkes/FawkesCommonInterceptor;", "Ltv/danmaku/bili/okhttp/CustomParamsAndHeaderInterceptor;", "<init>", "()V", "addParams", "", "", "addHeaders", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FawkesCommonInterceptor extends CustomParamsAndHeaderInterceptor {
    public static final int $stable = 0;

    @Override // tv.danmaku.bili.okhttp.CustomParamsAndHeaderInterceptor
    public Map<String, String> addParams() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("mobi_app", FoundationAlias.getFapps().getMobiApp()), TuplesKt.to("appid", FoundationAlias.getFapps().getAppId()), TuplesKt.to("sn", FoundationAlias.getFapps().getFawkesBuildSN()), TuplesKt.to("vn", FoundationAlias.getFapps().getVersionName()), TuplesKt.to("iv", String.valueOf(FoundationAlias.getFapps().getInternalVersionCode())), TuplesKt.to("build", String.valueOf(FoundationAlias.getFapps().getVersionCode())), TuplesKt.to("screen", FoundationAlias.getFdevices().getScreen()), TuplesKt.to("brand", FoundationAlias.getFdevices().getBrand()), TuplesKt.to("model", FoundationAlias.getFdevices().getModel()), TuplesKt.to("env", EnvManager.getCurrent().getLabel()), TuplesKt.to("ov", String.valueOf(FoundationAlias.getFdevices().getOsVersion())), TuplesKt.to("channel", FoundationAlias.getFapps().getChannel()), TuplesKt.to("platform", "android"), TuplesKt.to("nt", String.valueOf(ConnectivityMonitor.getInstance().getNetwork())), TuplesKt.to("deviceid", BuvidHelper.getBuvid()), TuplesKt.to("appkey", BiliConfig.getAppKey()), TuplesKt.to("abi", CpuUtils.getMyCpuArch2(FoundationAlias.getFapp()).getValue())});
    }

    @Override // tv.danmaku.bili.okhttp.CustomParamsAndHeaderInterceptor
    public Map<String, String> addHeaders() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("APP-KEY", FoundationAlias.getFapps().getFawkesAppKey()), TuplesKt.to("ENV", EnvManager.getCurrent().getLabel()), TuplesKt.to("Buvid", BuvidHelper.getBuvid()), TuplesKt.to("User-Agent", BiliConfig.getAppDefaultUA())});
    }
}