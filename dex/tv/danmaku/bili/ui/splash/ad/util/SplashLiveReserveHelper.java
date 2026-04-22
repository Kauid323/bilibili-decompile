package tv.danmaku.bili.ui.splash.ad.util;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.api.BiliApiException;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.model.CookieInfo;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import com.bilibili.okretro.BiliApiDataCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.HttpException;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.SplashAdHelper;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.service.LiveServiceHelperKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashLiveReserveHelper.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0003J:\u0010\t\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\u0010H\u0003JB\u0010\u0011\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\n0\u0010H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/util/SplashLiveReserveHelper;", "", "<init>", "()V", "TAG", "", "getCsrfValueFromCookie", "context", "Landroid/content/Context;", "reserveLive", "", "splash", "Ltv/danmaku/bili/ui/splash/ad/model/Splash;", "needToast", "", "listener", "Lkotlin/Function1;", "handleLiveBooking", "type", "", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashLiveReserveHelper {
    public static final int $stable = 0;
    public static final SplashLiveReserveHelper INSTANCE = new SplashLiveReserveHelper();
    private static final String TAG = "[Splash]SplashLiveReserveHelper";

    @JvmStatic
    public static final void handleLiveBooking(Context context, Splash splash, int i) {
        Intrinsics.checkNotNullParameter(splash, "splash");
        handleLiveBooking$default(context, splash, i, false, null, 24, null);
    }

    @JvmStatic
    public static final void handleLiveBooking(Context context, Splash splash, int i, boolean z) {
        Intrinsics.checkNotNullParameter(splash, "splash");
        handleLiveBooking$default(context, splash, i, z, null, 16, null);
    }

    private SplashLiveReserveHelper() {
    }

    @JvmStatic
    private static final String getCsrfValueFromCookie(Context context) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        CookieInfo accountCookie = BiliAccounts.get(context2).getAccountCookie();
        List<CookieInfo.CookieBean> cookies = accountCookie != null ? accountCookie.cookies : null;
        if (cookies != null) {
            for (CookieInfo.CookieBean cookie : cookies) {
                if (Intrinsics.areEqual(cookie.name, "bili_jct")) {
                    String str = cookie.value;
                    Intrinsics.checkNotNullExpressionValue(str, "value");
                    return str;
                }
            }
            return "";
        }
        return "";
    }

    static /* synthetic */ void reserveLive$default(Context context, Splash splash, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1() { // from class: tv.danmaku.bili.ui.splash.ad.util.SplashLiveReserveHelper$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    Unit reserveLive$lambda$0;
                    reserveLive$lambda$0 = SplashLiveReserveHelper.reserveLive$lambda$0(((Boolean) obj2).booleanValue());
                    return reserveLive$lambda$0;
                }
            };
        }
        reserveLive(context, splash, z, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reserveLive$lambda$0(boolean it) {
        return Unit.INSTANCE;
    }

    @JvmStatic
    private static final void reserveLive(Context context, final Splash splash, final boolean needToast, final Function1<? super Boolean, Unit> function1) {
        final Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        try {
            LiveServiceHelperKt.requestReserve(splash.liveBookingId, getCsrfValueFromCookie(context2), new BiliApiDataCallback<JSONObject>() { // from class: tv.danmaku.bili.ui.splash.ad.util.SplashLiveReserveHelper$reserveLive$2
                public void onDataSuccess(JSONObject result) {
                    BLog.i("[Splash]SplashLiveReserveHelper", "requestReserve success result: " + result);
                    if (needToast) {
                        ToastHelper.showToast(context2, "预约成功", 0, 17);
                    }
                    SplashAdHelper.reportLiveReservationSuc(splash.liveBookingId, splash.adCb);
                    function1.invoke(true);
                }

                public void onError(Throwable t) {
                    Intrinsics.checkNotNullParameter(t, "t");
                    BLog.e("[Splash]SplashLiveReserveHelper", "requestReserve error: " + t);
                    if (needToast) {
                        ToastHelper.showToast(context2, "预约失败", 0, 17);
                    }
                    int code = t instanceof BiliApiException ? ((BiliApiException) t).mCode : t instanceof HttpException ? ((HttpException) t).code() : -1;
                    SplashAdHelper.reportLiveReservationFail(splash.liveBookingId, String.valueOf(code), splash.adCb);
                    function1.invoke(false);
                }
            });
        } catch (Exception e) {
            BLog.e(TAG, "onJumpClick error: ", e);
            function1.invoke(false);
        }
    }

    public static /* synthetic */ void handleLiveBooking$default(Context context, Splash splash, int i, boolean z, Function1 function1, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = true;
        }
        if ((i2 & 16) != 0) {
            function1 = new Function1() { // from class: tv.danmaku.bili.ui.splash.ad.util.SplashLiveReserveHelper$$ExternalSyntheticLambda1
                public final Object invoke(Object obj2) {
                    Unit handleLiveBooking$lambda$0;
                    handleLiveBooking$lambda$0 = SplashLiveReserveHelper.handleLiveBooking$lambda$0(((Boolean) obj2).booleanValue());
                    return handleLiveBooking$lambda$0;
                }
            };
        }
        handleLiveBooking(context, splash, i, z, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleLiveBooking$lambda$0(boolean it) {
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void handleLiveBooking(Context context, Splash splash, int type, boolean needToast, Function1<? super Boolean, Unit> function1) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(splash, "splash");
        Intrinsics.checkNotNullParameter(function1, "listener");
        boolean isLogin = BiliAccounts.get(context2).isLogin();
        List<Integer> list = splash.liveBookingTriggerType;
        boolean isInTriggerType = list != null ? list.contains(Integer.valueOf(type)) : false;
        if (isLogin && splash.liveBookingId != 0 && isInTriggerType) {
            reserveLive(context2, splash, needToast, function1);
        }
    }
}