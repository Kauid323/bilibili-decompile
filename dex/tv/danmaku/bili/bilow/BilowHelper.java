package tv.danmaku.bili.bilow;

import android.content.Context;
import com.bilibili.gripper.api.riskcontrol.GRiskControl;
import com.bilibili.lib.dblconfig.MockIPInterceptor;
import com.bilibili.lib.dblconfig.UatInterceptor;
import com.bilibili.lib.okhttp.OkHttpClientWrapper;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.interceptor.DefaultRequestInterceptor;
import tv.danmaku.bili.bilow.debug.DebugLog;
import tv.danmaku.bili.httpdns.api.AppHttpDnsKt;
import tv.danmaku.bili.report.biz.api.consume.BilowBizReporter;
import tv.danmaku.bili.report.biz.api.produce.BilowBizTrackersKt;

public class BilowHelper {
    public static final String TAG = "bilowhelper";

    private BilowHelper() {
    }

    public static void preFetchHttpDNS(Context context) {
        AppHttpDnsKt.prefetch();
    }

    public static void init(Context context, GRiskControl riskControl) {
        context.getApplicationContext();
        MockIPInterceptor.INSTANCE.injectOkhttp(OkHttpClientWrapper.instance());
        UatInterceptor.INSTANCE.injectOkhttp(context, OkHttpClientWrapper.instance());
        DebugLog.inject(OkHttpClientWrapper.instance());
        ServiceGenerator.sTrackerFactory = BilowBizTrackersKt.factory(new BilowBizReporter());
    }

    public static void setGuestIdEnable(boolean enable) {
        DefaultRequestInterceptor.setGuestIdEnable(enable);
    }
}