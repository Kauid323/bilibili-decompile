package tv.danmaku.bili.fullscreen.service;

import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.model.SmsInfo;
import com.bilibili.lib.foundation.FoundationAlias;
import java.util.Map;
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
import tv.danmaku.bili.fullscreen.data.PhoneCountryCode;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmsLoginService.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/bilibili/lib/accounts/model/SmsInfo;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.service.SmsLoginService$sendSmsCode$smsInfo$1", f = "SmsLoginService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SmsLoginService$sendSmsCode$smsInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SmsInfo>, Object> {
    final /* synthetic */ Map<String, String> $captcha;
    final /* synthetic */ PhoneCountryCode $countryCode;
    final /* synthetic */ String $phone;
    final /* synthetic */ LoginReportParams $reportParams;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmsLoginService$sendSmsCode$smsInfo$1(PhoneCountryCode phoneCountryCode, String str, Map<String, String> map, LoginReportParams loginReportParams, Continuation<? super SmsLoginService$sendSmsCode$smsInfo$1> continuation) {
        super(2, continuation);
        this.$countryCode = phoneCountryCode;
        this.$phone = str;
        this.$captcha = map;
        this.$reportParams = loginReportParams;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SmsLoginService$sendSmsCode$smsInfo$1(this.$countryCode, this.$phone, this.$captcha, this.$reportParams, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SmsInfo> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                return BiliAccounts.get(FoundationAlias.getFapp()).sendLoginSms(this.$countryCode.getCountryCode(), this.$phone, this.$captcha, this.$reportParams.getLoginSessionId(), this.$reportParams.getFromSpmId(), this.$reportParams.getTouristId(), this.$reportParams.getExtend());
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}