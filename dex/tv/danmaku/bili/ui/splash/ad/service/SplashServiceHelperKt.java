package tv.danmaku.bili.ui.splash.ad.service;

import android.graphics.Point;
import com.bilibili.base.BiliContext;
import com.bilibili.gripper.api.ad.core.GAdCoreKt;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import com.bilibili.okretro.utils.ExBilowUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import retrofit2.Response;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.SplashAdHelper;
import tv.danmaku.bili.ui.splash.ad.customreporter.SplashCustomReporterKt;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.model.SplashData;
import tv.danmaku.bili.ui.splash.ad.model.SplashShowData;
import tv.danmaku.bili.ui.splash.ad.model.SplashShowStrategy;
import tv.danmaku.bili.ui.splash.ad.util.SplashLocalInfoHelper;
import tv.danmaku.bili.ui.splash.utils.SplashConfigKt;
import tv.danmaku.bili.ui.splash.utils.SplashUtils;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashServiceHelper.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0000\u001a\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"service", "Ltv/danmaku/bili/ui/splash/ad/service/SplashService;", "requestSplashList", "Ltv/danmaku/bili/ui/splash/ad/model/SplashData;", "loadedResSplashList", "", "keepIds", "openEvent", "requestSplashShow", "Ltv/danmaku/bili/ui/splash/ad/model/SplashShowData;", "topviewIds", "TAG", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashServiceHelperKt {
    private static final String TAG = "[Splash]SplashServiceHelper";
    private static SplashService service;

    static {
        Object createService = ServiceGenerator.createService(SplashService.class);
        Intrinsics.checkNotNullExpressionValue(createService, "createService(...)");
        service = (SplashService) createService;
    }

    public static final SplashData requestSplashList(String loadedResSplashList, String keepIds, String openEvent) {
        SplashData data;
        Response response;
        List<Splash> splashList;
        String network = SplashUtils.isWifiConnected() ? Splash.NETWORK_WIFI : Splash.NETWORK_MOBILE;
        try {
            BiliCall<GeneralResponse<SplashData>> splashList2 = service.getSplashList(loadedResSplashList, keepIds, openEvent);
            if (splashList2 == null) {
                response = null;
            } else {
                response = splashList2.execute();
            }
            data = (SplashData) ExBilowUtil.extractResponseData(response);
            BLog.i(TAG, "get splash finish, size = " + ((data == null || (splashList = data.getSplashList()) == null) ? null : Integer.valueOf(splashList.size())) + "， requestId = " + (data != null ? data.getSplashRequestId() : null));
        } catch (Throwable err) {
            try {
                BLog.i(TAG, "requestSplashList, api error = " + err);
                SplashCustomReporterKt.reportRequestList(loadedResSplashList);
                data = null;
            } finally {
                SplashCustomReporterKt.reportRequestList(loadedResSplashList);
            }
        }
        if (data != null) {
            SplashData splashData = data;
            SplashAdHelper.INSTANCE.setLastSplashRequestId(splashData.getSplashRequestId());
            SplashConfigKt.setSplashRequestDisperseInterval(splashData.getDisperseInterval());
            List splashList3 = splashData.getSplashList();
            if (splashList3 == null) {
                splashList3 = new ArrayList();
            }
            Iterator it = splashList3.iterator();
            while (it.hasNext()) {
                Splash splash = it.next();
                splash.networkType = network;
                if (!splash.isCardTypeSupport() || !splash.isSplashTypeSupport()) {
                    it.remove();
                }
            }
            return splashData;
        }
        return null;
    }

    public static final SplashShowData requestSplashShow(String topviewIds) {
        SplashShowData showStrategy;
        Iterable strategyList;
        String accessKey = BiliAccounts.get(BiliContext.application()).getAccessKey();
        Point point = SplashLocalInfoHelper.getDeviceSize();
        int width = Math.min(point.x, point.y);
        int height = Math.max(point.x, point.y);
        String adExtra = GAdCoreKt.getGAdExtra().get();
        String network = SplashUtils.isWifiConnected() ? Splash.NETWORK_WIFI : Splash.NETWORK_MOBILE;
        try {
            showStrategy = (SplashShowData) BuildersKt.runBlocking$default((CoroutineContext) null, new SplashServiceHelperKt$requestSplashShow$showStrategy$1(accessKey, width, height, adExtra, network, topviewIds, null), 1, (Object) null);
        } catch (Throwable err) {
            BLog.i(TAG, "requestSplashShow, api error = " + err);
            showStrategy = null;
        }
        SplashAdHelper.INSTANCE.setLastSplashRequestId(showStrategy != null ? showStrategy.getSplashRequestId() : null);
        if (showStrategy != null && (strategyList = showStrategy.getStrategyList()) != null) {
            Iterable $this$forEachIndexed$iv = strategyList;
            int index = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv = index + 1;
                if (index < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SplashShowStrategy strategy = (SplashShowStrategy) item$iv;
                strategy.setOriginIndex(index);
                index = index$iv;
            }
        }
        return showStrategy;
    }
}