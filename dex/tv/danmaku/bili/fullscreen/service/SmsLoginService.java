package tv.danmaku.bili.fullscreen.service;

import com.bilibili.lib.accounts.AccountException;
import com.bilibili.lib.accounts.VerifyBundle;
import com.bilibili.lib.accounts.model.SmsInfo;
import com.bilibili.lib.coroutineextension.BiliCallExtKt;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.data.AvailableCountryCode;
import tv.danmaku.bili.fullscreen.data.PhoneCountryCode;
import tv.danmaku.bili.fullscreen.stat.LoginWay;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginPageKt;
import tv.danmaku.bili.sms.SnsPhoneBindingData;

/* compiled from: SmsLoginService.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0007J:\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J8\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ:\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0082@¢\u0006\u0002\u0010\u001bJ:\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0082@¢\u0006\u0002\u0010\u001bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/SmsLoginService;", "Ltv/danmaku/bili/fullscreen/service/ISmsLoginService;", "<init>", "()V", "cachedCountryCode", "Ltv/danmaku/bili/fullscreen/data/AvailableCountryCode;", "getAllCountryCode", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendSmsCode", "Ltv/danmaku/bili/fullscreen/service/SmsCaptchaStatus;", "phone", "", "countryCode", "Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;", "captcha", "", "reportParams", "Ltv/danmaku/bili/fullscreen/service/LoginReportParams;", "(Ljava/lang/String;Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;Ljava/util/Map;Ltv/danmaku/bili/fullscreen/service/LoginReportParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "Ltv/danmaku/bili/fullscreen/service/ILoginResult;", "loginWay", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "captchaStatus", "smsCode", "snsPhoneBindingData", "Ltv/danmaku/bili/sms/SnsPhoneBindingData;", "(Ltv/danmaku/bili/fullscreen/stat/LoginWay;Ltv/danmaku/bili/fullscreen/service/SmsCaptchaStatus;Ljava/lang/String;Ltv/danmaku/bili/fullscreen/service/LoginReportParams;Ltv/danmaku/bili/sms/SnsPhoneBindingData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerBySms", "loginBySms", "Companion", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SmsLoginService implements ISmsLoginService {
    public static final String AREA_CODE_MAINLAND = "86";
    public static final int ERROR_CODE_CAPTCHA_INCORRECT = 86202;
    public static final int ERROR_CODE_CAPTCHA_INVALID = 86205;
    public static final int ERROR_CODE_PHONE_NUM_FORMAT_EMPTY_PHONE_NUM = 86004;
    public static final int ERROR_CODE_PHONE_NUM_FORMAT_FIRST = 86002;
    public static final int ERROR_CODE_PHONE_NUM_FORMAT_FROM_SMS_PLAT = 66031;
    public static final int ERROR_CODE_PHONE_NUM_FORMAT_MISTAKE = 86005;
    public static final int ERROR_CODE_PHONE_NUM_FORMAT_NUKNOW_AREA_CODE = 86003;
    public static final int ERROR_CODE_PHONE_NUM_FORMAT_RISK = 86015;
    public static final int ERROR_CODE_VERIFY_CODE_ERROR = -105;
    private AvailableCountryCode cachedCountryCode;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: SmsLoginService.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/SmsLoginService$Companion;", "", "<init>", "()V", "ERROR_CODE_PHONE_NUM_FORMAT_FIRST", "", "ERROR_CODE_PHONE_NUM_FORMAT_NUKNOW_AREA_CODE", "ERROR_CODE_PHONE_NUM_FORMAT_EMPTY_PHONE_NUM", "ERROR_CODE_PHONE_NUM_FORMAT_MISTAKE", "ERROR_CODE_PHONE_NUM_FORMAT_RISK", "ERROR_CODE_PHONE_NUM_FORMAT_FROM_SMS_PLAT", "ERROR_CODE_CAPTCHA_INCORRECT", "ERROR_CODE_CAPTCHA_INVALID", "ERROR_CODE_VERIFY_CODE_ERROR", "AREA_CODE_MAINLAND", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|8|15|16|(2:18|19)(1:20)))|32|6|7|8|15|16|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0062, code lost:
        kotlinx.coroutines.JobKt.ensureActive(r0.getContext());
        tv.danmaku.android.log.BLog.e(tv.danmaku.bili.fullscreen.state.IFullscreenLoginPageKt.TAG_FULLSCREEN, "Fail to get country code", r2);
        r4 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    @Override // tv.danmaku.bili.fullscreen.service.ISmsLoginService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getAllCountryCode(Continuation<? super AvailableCountryCode> continuation) {
        SmsLoginService$getAllCountryCode$1 smsLoginService$getAllCountryCode$1;
        Object data;
        SmsLoginService smsLoginService;
        if (continuation instanceof SmsLoginService$getAllCountryCode$1) {
            smsLoginService$getAllCountryCode$1 = (SmsLoginService$getAllCountryCode$1) continuation;
            if ((smsLoginService$getAllCountryCode$1.label & Integer.MIN_VALUE) != 0) {
                smsLoginService$getAllCountryCode$1.label -= Integer.MIN_VALUE;
                Object $result = smsLoginService$getAllCountryCode$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (smsLoginService$getAllCountryCode$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        AvailableCountryCode it = this.cachedCountryCode;
                        if (it == null) {
                            BiliCall<GeneralResponse<AvailableCountryCode>> countryCode = ((CountryCodeService) ServiceGenerator.createService(CountryCodeService.class)).getCountryCode();
                            smsLoginService$getAllCountryCode$1.label = 1;
                            data = BiliCallExtKt.getData(countryCode, smsLoginService$getAllCountryCode$1);
                            if (data != coroutine_suspended) {
                                smsLoginService = this;
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        } else {
                            return it;
                        }
                    case 1:
                        smsLoginService = this;
                        ResultKt.throwOnFailure($result);
                        data = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                smsLoginService.cachedCountryCode = (AvailableCountryCode) data;
                AvailableCountryCode availableCountryCode = (AvailableCountryCode) data;
                AvailableCountryCode availableCountryCode2 = availableCountryCode;
                return availableCountryCode2 != null ? AvailableCountryCode.Companion.getDefaultCode() : availableCountryCode2;
            }
        }
        smsLoginService$getAllCountryCode$1 = new SmsLoginService$getAllCountryCode$1(this, continuation);
        Object $result2 = smsLoginService$getAllCountryCode$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (smsLoginService$getAllCountryCode$1.label) {
        }
        smsLoginService.cachedCountryCode = (AvailableCountryCode) data;
        AvailableCountryCode availableCountryCode3 = (AvailableCountryCode) data;
        AvailableCountryCode availableCountryCode22 = availableCountryCode3;
        if (availableCountryCode22 != null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // tv.danmaku.bili.fullscreen.service.ISmsLoginService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object sendSmsCode(String str, PhoneCountryCode phoneCountryCode, Map<String, String> map, LoginReportParams reportParams, Continuation<? super SmsCaptchaStatus> continuation) {
        SmsLoginService$sendSmsCode$1 smsLoginService$sendSmsCode$1;
        ?? r5;
        String phone;
        Object withContext;
        try {
            if (continuation instanceof SmsLoginService$sendSmsCode$1) {
                smsLoginService$sendSmsCode$1 = (SmsLoginService$sendSmsCode$1) continuation;
                if ((smsLoginService$sendSmsCode$1.label & Integer.MIN_VALUE) != 0) {
                    smsLoginService$sendSmsCode$1.label -= Integer.MIN_VALUE;
                    SmsLoginService$sendSmsCode$1 smsLoginService$sendSmsCode$12 = smsLoginService$sendSmsCode$1;
                    Object $result = smsLoginService$sendSmsCode$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    r5 = smsLoginService$sendSmsCode$12.label;
                    switch (r5) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            PhoneCountryCode countryCode = phoneCountryCode;
                            phone = str;
                            BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Sending sms to phone");
                            smsLoginService$sendSmsCode$12.L$0 = phone;
                            smsLoginService$sendSmsCode$12.L$1 = countryCode;
                            smsLoginService$sendSmsCode$12.label = 1;
                            withContext = BuildersKt.withContext(Dispatchers.getIO(), new SmsLoginService$sendSmsCode$smsInfo$1(countryCode, phone, map, reportParams, null), smsLoginService$sendSmsCode$12);
                            r5 = countryCode;
                            if (withContext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            PhoneCountryCode phoneCountryCode2 = (PhoneCountryCode) smsLoginService$sendSmsCode$12.L$1;
                            phone = (String) smsLoginService$sendSmsCode$12.L$0;
                            ResultKt.throwOnFailure($result);
                            withContext = $result;
                            r5 = phoneCountryCode2;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    SmsInfo smsInfo = (SmsInfo) withContext;
                    BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Finish send sms to phone");
                    boolean z = smsInfo.is_new;
                    String str2 = smsInfo.captcha_key;
                    Intrinsics.checkNotNullExpressionValue(str2, "captcha_key");
                    String str3 = smsInfo.recaptcha_url;
                    Intrinsics.checkNotNullExpressionValue(str3, "recaptcha_url");
                    return new SmsCaptchaStatus(phone, r5, z, str2, str3, null, 32, null);
                }
            }
            switch (r5) {
            }
            SmsInfo smsInfo2 = (SmsInfo) withContext;
            BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Finish send sms to phone");
            boolean z2 = smsInfo2.is_new;
            String str22 = smsInfo2.captcha_key;
            Intrinsics.checkNotNullExpressionValue(str22, "captcha_key");
            String str32 = smsInfo2.recaptcha_url;
            Intrinsics.checkNotNullExpressionValue(str32, "recaptcha_url");
            return new SmsCaptchaStatus(phone, r5, z2, str22, str32, null, 32, null);
        } catch (AccountException e) {
            String str4 = phone;
            BLog.e(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Fail to send sms to phone", e);
            return new SmsCaptchaStatus(str4, r5, false, null, null, e, 28, null);
        }
        smsLoginService$sendSmsCode$1 = new SmsLoginService$sendSmsCode$1(this, continuation);
        SmsLoginService$sendSmsCode$1 smsLoginService$sendSmsCode$122 = smsLoginService$sendSmsCode$1;
        Object $result2 = smsLoginService$sendSmsCode$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r5 = smsLoginService$sendSmsCode$122.label;
    }

    @Override // tv.danmaku.bili.fullscreen.service.ISmsLoginService
    public Object login(LoginWay loginWay, SmsCaptchaStatus captchaStatus, String smsCode, LoginReportParams reportParams, SnsPhoneBindingData snsPhoneBindingData, Continuation<? super ILoginResult> continuation) {
        if (captchaStatus.isNewUser()) {
            BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Login by sms, register");
            return registerBySms(loginWay, captchaStatus, smsCode, reportParams, snsPhoneBindingData, continuation);
        }
        BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Login by sms, login");
        return loginBySms(loginWay, captchaStatus, smsCode, reportParams, snsPhoneBindingData, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|46|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004e, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
        r4 = r3;
        r0 = r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c3 A[RETURN] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object registerBySms(LoginWay loginWay, SmsCaptchaStatus captchaStatus, String smsCode, LoginReportParams reportParams, SnsPhoneBindingData snsPhoneBindingData, Continuation<? super ILoginResult> continuation) {
        SmsLoginService$registerBySms$1 smsLoginService$registerBySms$1;
        SmsLoginService$registerBySms$1 smsLoginService$registerBySms$12;
        LoginWay registerLoginWay;
        AccountException accountException;
        Object handleLoginResult$default;
        Object withContext;
        LoginWay registerLoginWay2;
        Object handleLoginResult$default2;
        if (continuation instanceof SmsLoginService$registerBySms$1) {
            smsLoginService$registerBySms$1 = (SmsLoginService$registerBySms$1) continuation;
            LoginWay registerLoginWay3 = -2147483648;
            if ((smsLoginService$registerBySms$1.label & Integer.MIN_VALUE) != 0) {
                smsLoginService$registerBySms$1.label -= Integer.MIN_VALUE;
                smsLoginService$registerBySms$12 = smsLoginService$registerBySms$1;
                Object $result = smsLoginService$registerBySms$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (smsLoginService$registerBySms$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        LoginWay registerLoginWay4 = loginWay.onRegister();
                        try {
                            smsLoginService$registerBySms$12.L$0 = registerLoginWay4;
                            smsLoginService$registerBySms$12.label = 1;
                            withContext = BuildersKt.withContext(Dispatchers.getIO(), new SmsLoginService$registerBySms$bundle$1(captchaStatus, smsCode, reportParams, snsPhoneBindingData, null), smsLoginService$registerBySms$12);
                            if (withContext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            registerLoginWay2 = registerLoginWay4;
                            try {
                                BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Finish register by sms");
                                LoginResultService loginResultService = LoginResultService.INSTANCE;
                                smsLoginService$registerBySms$12.L$0 = registerLoginWay2;
                                smsLoginService$registerBySms$12.label = 2;
                                handleLoginResult$default2 = LoginResultService.handleLoginResult$default(loginResultService, registerLoginWay2, (VerifyBundle) withContext, null, smsLoginService$registerBySms$12, 4, null);
                                if (handleLoginResult$default2 != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                registerLoginWay3 = registerLoginWay2;
                                return (ILoginResult) handleLoginResult$default2;
                            } catch (AccountException e) {
                                registerLoginWay = registerLoginWay2;
                                accountException = e;
                                Throwable th = accountException;
                                BLog.e(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Fail to register by sms", th);
                                LoginResultService loginResultService2 = LoginResultService.INSTANCE;
                                smsLoginService$registerBySms$12.L$0 = null;
                                smsLoginService$registerBySms$12.label = 3;
                                handleLoginResult$default = LoginResultService.handleLoginResult$default(loginResultService2, registerLoginWay, null, th, smsLoginService$registerBySms$12, 2, null);
                                if (handleLoginResult$default == coroutine_suspended) {
                                }
                                return (ILoginResult) handleLoginResult$default;
                            }
                        } catch (AccountException e2) {
                            registerLoginWay = registerLoginWay4;
                            accountException = e2;
                            Throwable th2 = accountException;
                            BLog.e(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Fail to register by sms", th2);
                            LoginResultService loginResultService22 = LoginResultService.INSTANCE;
                            smsLoginService$registerBySms$12.L$0 = null;
                            smsLoginService$registerBySms$12.label = 3;
                            handleLoginResult$default = LoginResultService.handleLoginResult$default(loginResultService22, registerLoginWay, null, th2, smsLoginService$registerBySms$12, 2, null);
                            if (handleLoginResult$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return (ILoginResult) handleLoginResult$default;
                        }
                    case 1:
                        LoginWay registerLoginWay5 = (LoginWay) smsLoginService$registerBySms$12.L$0;
                        ResultKt.throwOnFailure($result);
                        registerLoginWay2 = registerLoginWay5;
                        withContext = $result;
                        BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Finish register by sms");
                        LoginResultService loginResultService3 = LoginResultService.INSTANCE;
                        smsLoginService$registerBySms$12.L$0 = registerLoginWay2;
                        smsLoginService$registerBySms$12.label = 2;
                        handleLoginResult$default2 = LoginResultService.handleLoginResult$default(loginResultService3, registerLoginWay2, (VerifyBundle) withContext, null, smsLoginService$registerBySms$12, 4, null);
                        if (handleLoginResult$default2 != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        LoginWay loginWay2 = (LoginWay) smsLoginService$registerBySms$12.L$0;
                        ResultKt.throwOnFailure($result);
                        handleLoginResult$default2 = $result;
                        registerLoginWay3 = loginWay2;
                        return (ILoginResult) handleLoginResult$default2;
                    case 3:
                        ResultKt.throwOnFailure($result);
                        handleLoginResult$default = $result;
                        return (ILoginResult) handleLoginResult$default;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        smsLoginService$registerBySms$1 = new SmsLoginService$registerBySms$1(this, continuation);
        smsLoginService$registerBySms$12 = smsLoginService$registerBySms$1;
        Object $result2 = smsLoginService$registerBySms$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (smsLoginService$registerBySms$12.label) {
        }
    }

    static /* synthetic */ Object registerBySms$default(SmsLoginService smsLoginService, LoginWay loginWay, SmsCaptchaStatus smsCaptchaStatus, String str, LoginReportParams loginReportParams, SnsPhoneBindingData snsPhoneBindingData, Continuation continuation, int i, Object obj) {
        SnsPhoneBindingData snsPhoneBindingData2;
        if ((i & 16) == 0) {
            snsPhoneBindingData2 = snsPhoneBindingData;
        } else {
            snsPhoneBindingData2 = null;
        }
        return smsLoginService.registerBySms(loginWay, smsCaptchaStatus, str, loginReportParams, snsPhoneBindingData2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|45|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004e, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
        r14 = r3;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ba A[RETURN] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loginBySms(LoginWay loginWay, SmsCaptchaStatus captchaStatus, String smsCode, LoginReportParams reportParams, SnsPhoneBindingData snsPhoneBindingData, Continuation<? super ILoginResult> continuation) {
        SmsLoginService$loginBySms$1 smsLoginService$loginBySms$1;
        SmsLoginService$loginBySms$1 smsLoginService$loginBySms$12;
        LoginWay loginWay2;
        Object handleLoginResult$default;
        Object withContext;
        Object handleLoginResult$default2;
        if (continuation instanceof SmsLoginService$loginBySms$1) {
            smsLoginService$loginBySms$1 = (SmsLoginService$loginBySms$1) continuation;
            LoginWay loginWay3 = -2147483648;
            if ((smsLoginService$loginBySms$1.label & Integer.MIN_VALUE) != 0) {
                smsLoginService$loginBySms$1.label -= Integer.MIN_VALUE;
                smsLoginService$loginBySms$12 = smsLoginService$loginBySms$1;
                Object $result = smsLoginService$loginBySms$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (smsLoginService$loginBySms$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            smsLoginService$loginBySms$12.L$0 = loginWay;
                            smsLoginService$loginBySms$12.label = 1;
                            withContext = BuildersKt.withContext(Dispatchers.getIO(), new SmsLoginService$loginBySms$bundle$1(captchaStatus, smsCode, reportParams, snsPhoneBindingData, null), smsLoginService$loginBySms$12);
                            if (withContext == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            loginWay2 = loginWay;
                            try {
                                VerifyBundle bundle = (VerifyBundle) withContext;
                                BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Finish login by sms");
                                LoginResultService loginResultService = LoginResultService.INSTANCE;
                                smsLoginService$loginBySms$12.L$0 = loginWay2;
                                smsLoginService$loginBySms$12.label = 2;
                                handleLoginResult$default2 = LoginResultService.handleLoginResult$default(loginResultService, loginWay2, bundle, null, smsLoginService$loginBySms$12, 4, null);
                                if (handleLoginResult$default2 != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                loginWay3 = loginWay2;
                                return (ILoginResult) handleLoginResult$default2;
                            } catch (AccountException e) {
                                e = e;
                                BLog.e(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Failed login by sms", (Throwable) e);
                                LoginResultService loginResultService2 = LoginResultService.INSTANCE;
                                smsLoginService$loginBySms$12.L$0 = null;
                                smsLoginService$loginBySms$12.label = 3;
                                handleLoginResult$default = LoginResultService.handleLoginResult$default(loginResultService2, loginWay2, null, e, smsLoginService$loginBySms$12, 2, null);
                                if (handleLoginResult$default == coroutine_suspended) {
                                }
                                return (ILoginResult) handleLoginResult$default;
                            }
                        } catch (AccountException e2) {
                            e = e2;
                            loginWay2 = loginWay;
                            BLog.e(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Failed login by sms", (Throwable) e);
                            LoginResultService loginResultService22 = LoginResultService.INSTANCE;
                            smsLoginService$loginBySms$12.L$0 = null;
                            smsLoginService$loginBySms$12.label = 3;
                            handleLoginResult$default = LoginResultService.handleLoginResult$default(loginResultService22, loginWay2, null, e, smsLoginService$loginBySms$12, 2, null);
                            if (handleLoginResult$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return (ILoginResult) handleLoginResult$default;
                        }
                    case 1:
                        LoginWay loginWay4 = (LoginWay) smsLoginService$loginBySms$12.L$0;
                        ResultKt.throwOnFailure($result);
                        loginWay2 = loginWay4;
                        withContext = $result;
                        VerifyBundle bundle2 = (VerifyBundle) withContext;
                        BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Finish login by sms");
                        LoginResultService loginResultService3 = LoginResultService.INSTANCE;
                        smsLoginService$loginBySms$12.L$0 = loginWay2;
                        smsLoginService$loginBySms$12.label = 2;
                        handleLoginResult$default2 = LoginResultService.handleLoginResult$default(loginResultService3, loginWay2, bundle2, null, smsLoginService$loginBySms$12, 4, null);
                        if (handleLoginResult$default2 != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        LoginWay loginWay5 = (LoginWay) smsLoginService$loginBySms$12.L$0;
                        ResultKt.throwOnFailure($result);
                        handleLoginResult$default2 = $result;
                        loginWay3 = loginWay5;
                        return (ILoginResult) handleLoginResult$default2;
                    case 3:
                        ResultKt.throwOnFailure($result);
                        handleLoginResult$default = $result;
                        return (ILoginResult) handleLoginResult$default;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        smsLoginService$loginBySms$1 = new SmsLoginService$loginBySms$1(this, continuation);
        smsLoginService$loginBySms$12 = smsLoginService$loginBySms$1;
        Object $result2 = smsLoginService$loginBySms$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (smsLoginService$loginBySms$12.label) {
        }
    }

    static /* synthetic */ Object loginBySms$default(SmsLoginService smsLoginService, LoginWay loginWay, SmsCaptchaStatus smsCaptchaStatus, String str, LoginReportParams loginReportParams, SnsPhoneBindingData snsPhoneBindingData, Continuation continuation, int i, Object obj) {
        SnsPhoneBindingData snsPhoneBindingData2;
        if ((i & 16) == 0) {
            snsPhoneBindingData2 = snsPhoneBindingData;
        } else {
            snsPhoneBindingData2 = null;
        }
        return smsLoginService.loginBySms(loginWay, smsCaptchaStatus, str, loginReportParams, snsPhoneBindingData2, continuation);
    }
}