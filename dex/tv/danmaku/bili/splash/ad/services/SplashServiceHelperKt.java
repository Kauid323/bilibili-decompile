package tv.danmaku.bili.splash.ad.services;

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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import retrofit2.Response;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.model.SplashListResponse;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.model.SplashShowResponse;
import tv.danmaku.bili.splash.ad.model.SplashShowStrategy;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;
import tv.danmaku.bili.splash.ad.utils.NetworkUtilsKt;
import tv.danmaku.bili.splash.ad.utils.SplashConfigKt;
import tv.danmaku.bili.splash.ad.utils.SplashLocalInfoHelper;

/* compiled from: SplashServiceHelper.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0000\u001a\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0005H\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"service", "Ltv/danmaku/bili/splash/ad/services/SplashService;", "requestSplashList", "Ltv/danmaku/bili/splash/ad/model/SplashListResponse;", "loadedResSplashList", "", "keepIds", "openEvent", "requestSplashShow", "Ltv/danmaku/bili/splash/ad/model/SplashShowResponse;", "topviewIds", "TAG", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashServiceHelperKt {
    private static final String TAG = "[Splash]SplashServiceHelper";
    private static SplashService service;

    static {
        Object createService = ServiceGenerator.createService(SplashService.class);
        Intrinsics.checkNotNullExpressionValue(createService, "createService(...)");
        service = (SplashService) createService;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008e A[Catch: all -> 0x00a0, TryCatch #0 {all -> 0x00a0, blocks: (B:7:0x0013, B:9:0x001f, B:11:0x002d, B:13:0x0033, B:15:0x003d, B:17:0x0043, B:20:0x004f, B:22:0x0055, B:24:0x0078, B:26:0x007e, B:28:0x0082, B:34:0x008e, B:36:0x0092, B:38:0x0098), top: B:62:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final SplashListResponse requestSplashList(String loadedResSplashList, String keepIds, String openEvent) {
        SplashListResponse data;
        Response response;
        String splashRequestId;
        boolean z;
        List<SplashOrder> splashList;
        BiliCall parser;
        String network = NetworkUtilsKt.isWifiConnected() ? NetworkUtilsKt.NETWORK_TYPE_WIFI : NetworkUtilsKt.NETWORK_TYPE_MOBILE;
        try {
            BiliCall<GeneralResponse<SplashListResponse>> splashList2 = service.getSplashList(loadedResSplashList, keepIds, openEvent);
            if (splashList2 == null || (parser = splashList2.setParser(new SplashListGsonParser())) == null) {
                response = null;
            } else {
                response = parser.execute();
            }
            data = (SplashListResponse) ExBilowUtil.extractResponseData(response);
            BLog.i(TAG, "get splash finish, size = " + ((data == null || (splashList = data.getSplashList()) == null) ? null : Integer.valueOf(splashList.size())) + "， requestId = " + (data != null ? data.getSplashRequestId() : null));
            splashRequestId = data != null ? data.getSplashRequestId() : null;
        } catch (Throwable err) {
            try {
                BLog.i(TAG, "requestSplashList, api error = " + err);
                SplashCustomReporterKt.reportRequestList(loadedResSplashList);
                data = null;
            } finally {
                SplashCustomReporterKt.reportRequestList(loadedResSplashList);
            }
        }
        if (splashRequestId != null && !StringsKt.isBlank(splashRequestId)) {
            z = false;
            if (!z) {
                SplashAdHelper.INSTANCE.setLastSplashRequestId$adsplash_debug(data != null ? data.getSplashRequestId() : null);
            }
            if (data == null) {
                SplashListResponse splashData = data;
                SplashConfigKt.setSplashRequestDisperseInterval(splashData.getDisperseInterval());
                List splashList3 = splashData.getSplashList();
                if (splashList3 == null) {
                    splashList3 = new ArrayList();
                }
                Iterator it = splashList3.iterator();
                while (it.hasNext()) {
                    SplashOrder splash = it.next();
                    if (splash != null) {
                        splash.setNetworkType(network);
                    }
                    if (splash == null || !ExtSplashOrderKt.isCardTypeSupport(splash)) {
                        it.remove();
                    }
                }
                return splashData;
            }
            return null;
        }
        z = true;
        if (!z) {
        }
        if (data == null) {
        }
    }

    public static final SplashShowResponse requestSplashShow(String topviewIds) {
        SplashShowResponse showStrategy;
        Iterable strategyList;
        Response response;
        BiliCall parser;
        Intrinsics.checkNotNullParameter(topviewIds, "topviewIds");
        String accessKey = BiliAccounts.get(BiliContext.application()).getAccessKey();
        Point point = SplashLocalInfoHelper.getDeviceSize();
        int width = Math.min(point.x, point.y);
        int height = Math.max(point.x, point.y);
        String adExtra = GAdCoreKt.getGAdExtra().get();
        String network = NetworkUtilsKt.isWifiConnected() ? NetworkUtilsKt.NETWORK_TYPE_WIFI : NetworkUtilsKt.NETWORK_TYPE_MOBILE;
        try {
            BiliCall<GeneralResponse<SplashShowResponse>> splashShowList = service.getSplashShowList(accessKey, width, height, adExtra, network, topviewIds);
            if (splashShowList == null || (parser = splashShowList.setParser(new SplashShowGsonParser())) == null) {
                response = null;
            } else {
                response = parser.execute();
            }
            showStrategy = (SplashShowResponse) ExBilowUtil.extractResponseData(response);
        } catch (Throwable err) {
            BLog.i(TAG, "requestSplashShow, api error = " + err);
            showStrategy = null;
        }
        String splashRequestId = showStrategy != null ? showStrategy.getSplashRequestId() : null;
        if (!(splashRequestId == null || StringsKt.isBlank(splashRequestId))) {
            SplashAdHelper.INSTANCE.setLastSplashRequestId$adsplash_debug(showStrategy != null ? showStrategy.getSplashRequestId() : null);
        }
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