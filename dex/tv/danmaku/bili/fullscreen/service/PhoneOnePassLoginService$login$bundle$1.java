package tv.danmaku.bili.fullscreen.service;

import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.VerifyBundle;
import com.bilibili.lib.accountsui.quick.LoginQuickManager;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PhoneOnePassLoginService.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/bilibili/lib/accounts/VerifyBundle;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.service.PhoneOnePassLoginService$login$bundle$1", f = "PhoneOnePassLoginService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PhoneOnePassLoginService$login$bundle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super VerifyBundle>, Object> {
    final /* synthetic */ LoginQuickManager.AuthInfoBean $authInfo;
    final /* synthetic */ PhoneInfo $phone;
    final /* synthetic */ LoginReportParams $reportParam;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneOnePassLoginService$login$bundle$1(LoginQuickManager.AuthInfoBean authInfoBean, PhoneInfo phoneInfo, LoginReportParams loginReportParams, Continuation<? super PhoneOnePassLoginService$login$bundle$1> continuation) {
        super(2, continuation);
        this.$authInfo = authInfoBean;
        this.$phone = phoneInfo;
        this.$reportParam = loginReportParams;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PhoneOnePassLoginService$login$bundle$1(this.$authInfo, this.$phone, this.$reportParam, continuation);
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
                String token = this.$authInfo.getToken();
                if (token == null) {
                    token = "";
                }
                return biliAccounts.loginQuick(token, this.$phone.getIspCode().getIspName(), LoginQuickManager.INSTANCE.getCarrierVersion(), this.$authInfo.getAuthCode(), this.$reportParam.getPagePv(), this.$reportParam.getPageRoute(), this.$reportParam.getLoginSessionId(), this.$reportParam.getFromSpmId(), this.$reportParam.getTouristId(), this.$reportParam.getExtend());
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}