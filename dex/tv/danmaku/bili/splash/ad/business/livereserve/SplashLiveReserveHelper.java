package tv.danmaku.bili.splash.ad.business.livereserve;

import android.content.Context;
import com.bilibili.api.BiliApiException;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.arch.lifecycle.Resource;
import com.bilibili.lib.arch.lifecycle.Status;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import retrofit2.HttpException;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: SplashLiveReserveHelper.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010\u000bJ@\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\n\u001a\u00020\u00072\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/splash/ad/business/livereserve/SplashLiveReserveHelper;", "", "<init>", "()V", "TAG", "", "reserveLive", "", UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH, "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "needToast", "(Ltv/danmaku/bili/splash/ad/model/SplashOrder;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleLiveBooking", "", "context", "Landroid/content/Context;", "type", "", "bookingListener", "Lkotlin/Function1;", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashLiveReserveHelper {
    public static final int $stable = 0;
    public static final SplashLiveReserveHelper INSTANCE = new SplashLiveReserveHelper();
    private static final String TAG = "[Splash]SplashLiveReserveHelper";

    private SplashLiveReserveHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(2:3|(6:5|6|7|8|15|(4:17|(1:19)|20|21)(9:22|(1:24)|25|(1:27)(2:34|(1:36)(1:37))|28|29|(1:31)|32|33)))|45|6|7|8|15|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00fd, code lost:
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00fe, code lost:
        r13 = kotlin.Result.Companion;
        r12 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r12));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0066 A[Catch: all -> 0x00fd, TryCatch #0 {all -> 0x00fd, blocks: (B:13:0x0037, B:20:0x0059, B:22:0x0066, B:24:0x0083, B:25:0x008f, B:27:0x00a1, B:29:0x00bf, B:30:0x00cb, B:32:0x00d0, B:37:0x00e3, B:33:0x00d6, B:35:0x00da, B:16:0x0041), top: B:46:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a1 A[Catch: all -> 0x00fd, TryCatch #0 {all -> 0x00fd, blocks: (B:13:0x0037, B:20:0x0059, B:22:0x0066, B:24:0x0083, B:25:0x008f, B:27:0x00a1, B:29:0x00bf, B:30:0x00cb, B:32:0x00d0, B:37:0x00e3, B:33:0x00d6, B:35:0x00da, B:16:0x0041), top: B:46:0x0025 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object reserveLive(SplashOrder splash, boolean needToast, Continuation<? super Boolean> continuation) {
        SplashLiveReserveHelper$reserveLive$1 splashLiveReserveHelper$reserveLive$1;
        Object reserveLiveBySid;
        SplashOrder splash2;
        Resource res;
        int code;
        if (continuation instanceof SplashLiveReserveHelper$reserveLive$1) {
            splashLiveReserveHelper$reserveLive$1 = (SplashLiveReserveHelper$reserveLive$1) continuation;
            if ((splashLiveReserveHelper$reserveLive$1.label & Integer.MIN_VALUE) != 0) {
                splashLiveReserveHelper$reserveLive$1.label -= Integer.MIN_VALUE;
                Object $result = splashLiveReserveHelper$reserveLive$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (splashLiveReserveHelper$reserveLive$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Result.Companion companion = Result.Companion;
                        SplashLiveReserveHelper splashLiveReserveHelper = this;
                        long liveBookingId = splash.getLiveBookingId();
                        splashLiveReserveHelper$reserveLive$1.L$0 = splash;
                        splashLiveReserveHelper$reserveLive$1.Z$0 = needToast;
                        splashLiveReserveHelper$reserveLive$1.label = 1;
                        reserveLiveBySid = LiveReserveServiceKt.reserveLiveBySid(liveBookingId, splashLiveReserveHelper$reserveLive$1);
                        if (reserveLiveBySid == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        splash2 = splash;
                        break;
                    case 1:
                        needToast = splashLiveReserveHelper$reserveLive$1.Z$0;
                        splash2 = (SplashOrder) splashLiveReserveHelper$reserveLive$1.L$0;
                        ResultKt.throwOnFailure($result);
                        reserveLiveBySid = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                res = (Resource) reserveLiveBySid;
                if (res.getStatus() != Status.SUCCESS) {
                    BLog.i(TAG, "requestReserve success result: " + res.getData());
                    if (needToast) {
                        ToastHelper.showToast(BiliContext.application(), "预约成功", 0, 17);
                    }
                    SplashAdHelper.INSTANCE.reportLiveReservationSuc(splash2.getLiveBookingId(), splash2.getAdCb());
                    return Boxing.boxBoolean(true);
                }
                BiliApiException error = res.getError();
                BLog.e(TAG, "requestReserve error: " + error);
                if (needToast) {
                    ToastHelper.showToast(BiliContext.application(), "预约失败", 0, 17);
                }
                if (error instanceof BiliApiException) {
                    code = error.mCode;
                } else {
                    code = error instanceof HttpException ? ((HttpException) error).code() : -1;
                }
                SplashAdHelper.INSTANCE.reportLiveReservationFail(splash2.getLiveBookingId(), String.valueOf(code), splash2.getAdCb());
                Object obj = Result.constructor-impl(Unit.INSTANCE);
                Throwable e = Result.exceptionOrNull-impl(obj);
                if (e != null) {
                    BLog.e(TAG, "onJumpClick error: ", e);
                }
                return Boxing.boxBoolean(false);
            }
        }
        splashLiveReserveHelper$reserveLive$1 = new SplashLiveReserveHelper$reserveLive$1(this, continuation);
        Object $result2 = splashLiveReserveHelper$reserveLive$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (splashLiveReserveHelper$reserveLive$1.label) {
        }
        res = (Resource) reserveLiveBySid;
        if (res.getStatus() != Status.SUCCESS) {
        }
    }

    static /* synthetic */ Object reserveLive$default(SplashLiveReserveHelper splashLiveReserveHelper, SplashOrder splashOrder, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return splashLiveReserveHelper.reserveLive(splashOrder, z, continuation);
    }

    public static /* synthetic */ void handleLiveBooking$default(SplashLiveReserveHelper splashLiveReserveHelper, Context context, SplashOrder splashOrder, int i, boolean z, Function1 function1, int i2, Object obj) {
        boolean z2;
        Function1 function12;
        if ((i2 & 8) == 0) {
            z2 = z;
        } else {
            z2 = true;
        }
        if ((i2 & 16) == 0) {
            function12 = function1;
        } else {
            function12 = new Function1() { // from class: tv.danmaku.bili.splash.ad.business.livereserve.SplashLiveReserveHelper$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    Unit handleLiveBooking$lambda$0;
                    handleLiveBooking$lambda$0 = SplashLiveReserveHelper.handleLiveBooking$lambda$0(((Boolean) obj2).booleanValue());
                    return handleLiveBooking$lambda$0;
                }
            };
        }
        splashLiveReserveHelper.handleLiveBooking(context, splashOrder, i, z2, function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleLiveBooking$lambda$0(boolean it) {
        return Unit.INSTANCE;
    }

    public final void handleLiveBooking(Context context, SplashOrder splash, int type, boolean needToast, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        Intrinsics.checkNotNullParameter(function1, "bookingListener");
        boolean isLogin = BiliAccounts.get(context).isLogin();
        List<Integer> liveBookingTriggerType = splash.getLiveBookingTriggerType();
        boolean isInTriggerType = liveBookingTriggerType != null ? liveBookingTriggerType.contains(Integer.valueOf(type)) : false;
        if (isLogin && splash.getLiveBookingId() != 0 && isInTriggerType) {
            BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), (CoroutineStart) null, new SplashLiveReserveHelper$handleLiveBooking$2(splash, needToast, function1, null), 2, (Object) null);
        }
    }
}