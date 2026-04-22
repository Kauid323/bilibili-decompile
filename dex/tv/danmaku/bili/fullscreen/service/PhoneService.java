package tv.danmaku.bili.fullscreen.service;

import com.bilibili.lib.accountsui.quick.LoginQuickManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.TimeoutKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginPageKt;
import tv.danmaku.bili.quick.core.OnePassLoginPhaseType;

/* compiled from: PhoneService.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/PhoneService;", "Ltv/danmaku/bili/fullscreen/service/IPhoneService;", "loginReportService", "Ltv/danmaku/bili/fullscreen/service/LoginReportService;", "techTrackService", "Ltv/danmaku/bili/fullscreen/service/TechTrackService;", "<init>", "(Ltv/danmaku/bili/fullscreen/service/LoginReportService;Ltv/danmaku/bili/fullscreen/service/TechTrackService;)V", "getPhoneInfo", "Ltv/danmaku/bili/fullscreen/service/PhoneInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PhoneService implements IPhoneService {
    public static final int $stable = 8;
    private final LoginReportService loginReportService;
    private final TechTrackService techTrackService;

    public PhoneService(LoginReportService loginReportService, TechTrackService techTrackService) {
        Intrinsics.checkNotNullParameter(loginReportService, "loginReportService");
        Intrinsics.checkNotNullParameter(techTrackService, "techTrackService");
        this.loginReportService = loginReportService;
        this.techTrackService = techTrackService;
    }

    public /* synthetic */ PhoneService(LoginReportService loginReportService, TechTrackServiceImpl techTrackServiceImpl, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(loginReportService, (i & 2) != 0 ? new TechTrackServiceImpl() : techTrackServiceImpl);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(7:5|6|7|8|15|16|(8:20|(1:36)|24|(1:35)|28|(1:32)|33|34)(4:37|(1:41)|42|43)))|51|6|7|8|15|16|(11:18|20|(1:22)|36|24|(1:26)|35|28|(2:30|32)|33|34)|37|(2:39|41)|42|43) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003e, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006f, code lost:
        r5.techTrackService.stopWithReason(r5.loginReportService.getSpmid(), tv.danmaku.bili.quick.core.OnePassLoginReportManagerKt.INTERRUPTED_FOR_THE_REQUEST_TIME_OUT);
        tv.danmaku.android.log.BLog.e(tv.danmaku.bili.fullscreen.state.IFullscreenLoginPageKt.TAG_FULLSCREEN, "Get phone info timeout", r0);
        r9 = kotlin.TuplesKt.to(kotlin.coroutines.jvm.internal.Boxing.boxInt(2), (java.lang.Object) null);
        r5 = r5;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    @Override // tv.danmaku.bili.fullscreen.service.IPhoneService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getPhoneInfo(Continuation<? super PhoneInfo> continuation) {
        PhoneService$getPhoneInfo$1 phoneService$getPhoneInfo$1;
        PhoneService phoneService;
        PhoneService phoneService2;
        Pair result;
        Integer num;
        String str;
        LoginQuickManager.PhoneInfoBean phoneInfoBean;
        String msg;
        LoginQuickManager.PhoneInfoBean phoneInfoBean2;
        String msg2;
        Object withTimeout;
        if (continuation instanceof PhoneService$getPhoneInfo$1) {
            phoneService$getPhoneInfo$1 = (PhoneService$getPhoneInfo$1) continuation;
            if ((phoneService$getPhoneInfo$1.label & Integer.MIN_VALUE) != 0) {
                phoneService$getPhoneInfo$1.label -= Integer.MIN_VALUE;
                PhoneService$getPhoneInfo$1 phoneService$getPhoneInfo$12 = phoneService$getPhoneInfo$1;
                Object $result = phoneService$getPhoneInfo$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                phoneService = phoneService$getPhoneInfo$12.label;
                switch (phoneService) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        PhoneService phoneService3 = this;
                        BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Start get phone info");
                        phoneService3.techTrackService.onPhase(phoneService3.loginReportService.getSpmid(), OnePassLoginPhaseType.CheckConditions.INSTANCE);
                        phoneService$getPhoneInfo$12.label = 1;
                        withTimeout = TimeoutKt.withTimeout(10000L, new PhoneService$getPhoneInfo$result$1(null), phoneService$getPhoneInfo$12);
                        phoneService = phoneService3;
                        if (withTimeout == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        phoneService = this;
                        ResultKt.throwOnFailure($result);
                        withTimeout = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Pair pair = (Pair) withTimeout;
                phoneService2 = phoneService;
                result = pair;
                num = (Integer) result.getFirst();
                str = "";
                if (num != null && num.intValue() == 1) {
                    phoneService2.techTrackService.onPhase(phoneService2.loginReportService.getSpmid(), OnePassLoginPhaseType.GetNumberSuc.INSTANCE);
                    LoginQuickManager.PhoneInfoBean phoneInfoBean3 = (LoginQuickManager.PhoneInfoBean) result.getSecond();
                    String str2 = (phoneInfoBean3 != null || (str2 = phoneInfoBean3.getResultCode()) == null) ? "" : "";
                    LoginQuickManager.PhoneInfoBean phoneInfoBean4 = (LoginQuickManager.PhoneInfoBean) result.getSecond();
                    String str3 = (phoneInfoBean4 != null || (str3 = phoneInfoBean4.getSecurityPhone()) == null) ? "" : "";
                    phoneInfoBean2 = (LoginQuickManager.PhoneInfoBean) result.getSecond();
                    if (phoneInfoBean2 != null && (msg2 = phoneInfoBean2.getMsg()) != null) {
                        str = msg2;
                    }
                    PhoneInfo phoneInfo = new PhoneInfo(str2, str3, str, IspCode.Companion.getIspCode());
                    BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "End get phone info: " + phoneInfo);
                    return phoneInfo;
                }
                TechTrackService techTrackService = phoneService2.techTrackService;
                String spmid = phoneService2.loginReportService.getSpmid();
                phoneInfoBean = (LoginQuickManager.PhoneInfoBean) result.getSecond();
                if (phoneInfoBean != null && (msg = phoneInfoBean.getMsg()) != null) {
                    str = msg;
                }
                techTrackService.stopWithReason(spmid, "get phone info with error : " + str);
                BLog.w(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Get phone info failed");
                return new PhoneInfo(null, null, null, null, 15, null);
            }
        }
        phoneService$getPhoneInfo$1 = new PhoneService$getPhoneInfo$1(this, continuation);
        PhoneService$getPhoneInfo$1 phoneService$getPhoneInfo$122 = phoneService$getPhoneInfo$1;
        Object $result2 = phoneService$getPhoneInfo$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        phoneService = phoneService$getPhoneInfo$122.label;
        switch (phoneService) {
        }
        Pair pair2 = (Pair) withTimeout;
        phoneService2 = phoneService;
        result = pair2;
        num = (Integer) result.getFirst();
        str = "";
        if (num != null) {
            phoneService2.techTrackService.onPhase(phoneService2.loginReportService.getSpmid(), OnePassLoginPhaseType.GetNumberSuc.INSTANCE);
            LoginQuickManager.PhoneInfoBean phoneInfoBean32 = (LoginQuickManager.PhoneInfoBean) result.getSecond();
            if (phoneInfoBean32 != null) {
            }
            LoginQuickManager.PhoneInfoBean phoneInfoBean42 = (LoginQuickManager.PhoneInfoBean) result.getSecond();
            if (phoneInfoBean42 != null) {
            }
            phoneInfoBean2 = (LoginQuickManager.PhoneInfoBean) result.getSecond();
            if (phoneInfoBean2 != null) {
                str = msg2;
            }
            PhoneInfo phoneInfo2 = new PhoneInfo(str2, str3, str, IspCode.Companion.getIspCode());
            BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "End get phone info: " + phoneInfo2);
            return phoneInfo2;
        }
        TechTrackService techTrackService2 = phoneService2.techTrackService;
        String spmid2 = phoneService2.loginReportService.getSpmid();
        phoneInfoBean = (LoginQuickManager.PhoneInfoBean) result.getSecond();
        if (phoneInfoBean != null) {
            str = msg;
        }
        techTrackService2.stopWithReason(spmid2, "get phone info with error : " + str);
        BLog.w(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Get phone info failed");
        return new PhoneInfo(null, null, null, null, 15, null);
    }
}