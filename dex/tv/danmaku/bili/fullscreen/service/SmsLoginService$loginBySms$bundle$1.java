package tv.danmaku.bili.fullscreen.service;

import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.LoginParams;
import com.bilibili.lib.accounts.VerifyBundle;
import com.bilibili.lib.foundation.FoundationAlias;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.sms.SnsPhoneBindingData;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmsLoginService.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/bilibili/lib/accounts/VerifyBundle;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.service.SmsLoginService$loginBySms$bundle$1", f = "SmsLoginService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SmsLoginService$loginBySms$bundle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super VerifyBundle>, Object> {
    final /* synthetic */ SmsCaptchaStatus $captchaStatus;
    final /* synthetic */ LoginReportParams $reportParams;
    final /* synthetic */ String $smsCode;
    final /* synthetic */ SnsPhoneBindingData $snsPhoneBindingData;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmsLoginService$loginBySms$bundle$1(SmsCaptchaStatus smsCaptchaStatus, String str, LoginReportParams loginReportParams, SnsPhoneBindingData snsPhoneBindingData, Continuation<? super SmsLoginService$loginBySms$bundle$1> continuation) {
        super(2, continuation);
        this.$captchaStatus = smsCaptchaStatus;
        this.$smsCode = str;
        this.$reportParams = loginReportParams;
        this.$snsPhoneBindingData = snsPhoneBindingData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SmsLoginService$loginBySms$bundle$1(this.$captchaStatus, this.$smsCode, this.$reportParams, this.$snsPhoneBindingData, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super VerifyBundle> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                BiliAccounts biliAccounts = BiliAccounts.get(FoundationAlias.getFapp());
                String countryCode = this.$captchaStatus.getCountryCode().getCountryCode();
                String phone = this.$captchaStatus.getPhone();
                String str = this.$smsCode;
                String captchaKey = this.$captchaStatus.getCaptchaKey();
                String pagePv = this.$reportParams.getPagePv();
                String pageRoute = this.$reportParams.getPageRoute();
                String loginSessionId = this.$reportParams.getLoginSessionId();
                String fromSpmId = this.$reportParams.getFromSpmId();
                String touristId = this.$reportParams.getTouristId();
                String extend = this.$reportParams.getExtend();
                SnsPhoneBindingData snsPhoneBindingData = this.$snsPhoneBindingData;
                String platform = snsPhoneBindingData != null ? snsPhoneBindingData.getPlatform() : null;
                SnsPhoneBindingData snsPhoneBindingData2 = this.$snsPhoneBindingData;
                String appId = snsPhoneBindingData2 != null ? snsPhoneBindingData2.getAppId() : null;
                SnsPhoneBindingData snsPhoneBindingData3 = this.$snsPhoneBindingData;
                return biliAccounts.loginBySms(new LoginParams(countryCode, phone, str, captchaKey, "", pagePv, pageRoute, loginSessionId, fromSpmId, touristId, extend, platform, appId, snsPhoneBindingData3 != null ? snsPhoneBindingData3.getOpenId() : null));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}