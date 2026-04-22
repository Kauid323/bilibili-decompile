package tv.danmaku.bili.bilow;

import android.content.Context;
import android.text.TextUtils;
import com.bilibili.api.base.util.NetworkManager;
import com.bilibili.app.comm.realtime.RealTimeInterceptor;
import com.bilibili.commons.StringUtils;
import com.bilibili.fd_service.unicom.card.interceptor.FreeDataNetInterceptor;
import com.bilibili.gripper.api.riskcontrol.GRiskControl;
import com.bilibili.lib.okhttp.InMemoryCookieJar;
import com.bilibili.lib.okhttp.OkHttpClientWrapper;
import com.bilibili.lib.ticket.api.BiliTickets;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import tv.danmaku.bili.aurora.api.zone.AuroraZone;
import tv.danmaku.bili.bilow.aurora.AuroraInterceptor;
import tv.danmaku.bili.bilow.cdn.RecordConnectionInfoInterceptor;
import tv.danmaku.bili.bilow.domain.MultiDomainInterceptor;
import tv.danmaku.bili.bilow.flowcontrol.FlowControlInterceptor;
import tv.danmaku.bili.bilow.gaia.GaiaImpl;
import tv.danmaku.bili.bilow.gaia.GaiaInterceptor;
import tv.danmaku.bili.bilow.lb.LoadBalanceInterceptor;
import tv.danmaku.bili.bilow.ticket.TicketInterceptor;
import tv.danmaku.bili.flowcontrol.api.FlowControls;
import tv.danmaku.bili.report.biz.api.consume.OkHttpReporter;
import tv.danmaku.bili.report.biz.api.produce.OkHttpEventListenersKt;

public class BilowEx {
    public static final String TAG = "BilowEx";

    public static void injectInterceptor(Context context, GRiskControl riskControl) {
        OkHttpClientWrapper.instance().cookieJar(new InMemoryCookieJar()).dispatcher(new Dispatcher(NetworkManager.getNetWorkExecutor())).addInterceptor(new BiliUAInterceptor()).addInterceptor(new WorldHttpsInterceptor()).addInterceptor(new LoadBalanceInterceptor()).addInterceptor(FreeDataNetInterceptor.getInstance()).addInterceptor(MultiDomainInterceptor.INSTANCE).addInterceptor(new RealTimeInterceptor()).addInterceptor(new FlowControlInterceptor(FlowControls.INSTANCE)).addInterceptor(new AuroraInterceptor()).addInterceptor(new GaiaInterceptor(new GaiaImpl(riskControl))).addInterceptor(new TicketInterceptor(BiliTickets.INSTANCE)).addNetworkInterceptor(new RecordConnectionInfoInterceptor()).connectTimeout(TimeoutsKt.connectTimeoutMs(), TimeUnit.MILLISECONDS).eventListenerFactory(OkHttpEventListenersKt.factory(new OkHttpReporter(), FlowControls.INSTANCE, AuroraZone.INSTANCE, BiliTickets.INSTANCE, new GaiaImpl(riskControl))).readTimeout(TimeoutsKt.readTimeoutMs(), TimeUnit.MILLISECONDS).writeTimeout(TimeoutsKt.writeTimeoutMs(), TimeUnit.MILLISECONDS);
    }

    public static void injectInterceptor(GRiskControl riskControl) {
        OkHttpClientWrapper.instance().addInterceptor(new BiliUAInterceptor()).addInterceptor(new WorldHttpsInterceptor()).addInterceptor(new LoadBalanceInterceptor()).addInterceptor(FreeDataNetInterceptor.getInstance()).addInterceptor(MultiDomainInterceptor.INSTANCE).addInterceptor(new RealTimeInterceptor()).addInterceptor(new FlowControlInterceptor(FlowControls.INSTANCE)).addInterceptor(new AuroraInterceptor()).addInterceptor(new GaiaInterceptor(new GaiaImpl(riskControl))).addInterceptor(new TicketInterceptor(BiliTickets.INSTANCE)).addNetworkInterceptor(new RecordConnectionInfoInterceptor());
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    private static class BiliUAInterceptor implements Interceptor {
        static String UA;

        private BiliUAInterceptor() {
        }

        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request oRequest = chain.request();
            String oUa = oRequest.header("User-Agent");
            String nUa = null;
            if (TextUtils.isEmpty(oUa)) {
                if (UA == null) {
                    UA = UserAgents.defaultUa();
                }
                nUa = UA;
            } else if (!"apigame.bilibili.com".equals(oRequest.url().host()) && !StringUtils.contains(oUa, UserAgents.version())) {
                nUa = oUa + " " + UserAgents.version();
            }
            Request nRequest = oRequest.newBuilder().header("User-Agent", (nUa == null ? oUa : nUa) + UserAgents.common()).build();
            return chain.proceed(nRequest);
        }
    }
}