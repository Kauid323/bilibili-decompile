package tv.danmaku.bili.fullscreen.service;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.data.AvailableCountryCode;
import tv.danmaku.bili.fullscreen.data.PhoneCountryCode;
import tv.danmaku.bili.fullscreen.stat.LoginWay;
import tv.danmaku.bili.sms.SnsPhoneBindingData;

/* compiled from: interface.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J:\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u000fJ:\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H¦@¢\u0006\u0002\u0010\u0018ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0019À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/ISmsLoginService;", "", "getAllCountryCode", "Ltv/danmaku/bili/fullscreen/data/AvailableCountryCode;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendSmsCode", "Ltv/danmaku/bili/fullscreen/service/SmsCaptchaStatus;", "phone", "", "countryCode", "Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;", "captcha", "", "reportParams", "Ltv/danmaku/bili/fullscreen/service/LoginReportParams;", "(Ljava/lang/String;Ltv/danmaku/bili/fullscreen/data/PhoneCountryCode;Ljava/util/Map;Ltv/danmaku/bili/fullscreen/service/LoginReportParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "Ltv/danmaku/bili/fullscreen/service/ILoginResult;", "loginWay", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "captchaStatus", "smsCode", "snsPhoneBindingData", "Ltv/danmaku/bili/sms/SnsPhoneBindingData;", "(Ltv/danmaku/bili/fullscreen/stat/LoginWay;Ltv/danmaku/bili/fullscreen/service/SmsCaptchaStatus;Ljava/lang/String;Ltv/danmaku/bili/fullscreen/service/LoginReportParams;Ltv/danmaku/bili/sms/SnsPhoneBindingData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface ISmsLoginService {
    Object getAllCountryCode(Continuation<? super AvailableCountryCode> continuation);

    Object login(LoginWay loginWay, SmsCaptchaStatus smsCaptchaStatus, String str, LoginReportParams loginReportParams, SnsPhoneBindingData snsPhoneBindingData, Continuation<? super ILoginResult> continuation);

    Object sendSmsCode(String str, PhoneCountryCode phoneCountryCode, Map<String, String> map, LoginReportParams loginReportParams, Continuation<? super SmsCaptchaStatus> continuation);

    /* compiled from: interface.kt */
    /* renamed from: tv.danmaku.bili.fullscreen.service.ISmsLoginService$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Object login$default(ISmsLoginService iSmsLoginService, LoginWay loginWay, SmsCaptchaStatus smsCaptchaStatus, String str, LoginReportParams loginReportParams, SnsPhoneBindingData snsPhoneBindingData, Continuation continuation, int i, Object obj) {
            SnsPhoneBindingData snsPhoneBindingData2;
            if (obj == null) {
                if ((i & 16) == 0) {
                    snsPhoneBindingData2 = snsPhoneBindingData;
                } else {
                    snsPhoneBindingData2 = null;
                }
                return iSmsLoginService.login(loginWay, smsCaptchaStatus, str, loginReportParams, snsPhoneBindingData2, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: login");
        }
    }
}