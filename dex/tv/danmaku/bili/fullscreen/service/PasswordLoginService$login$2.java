package tv.danmaku.bili.fullscreen.service;

import com.bilibili.lib.accounts.AccountException;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.VerifyBundle;
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
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.stat.LoginWay;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginPageKt;

/* compiled from: PasswordLoginService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/fullscreen/service/ILoginResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.service.PasswordLoginService$login$2", f = "PasswordLoginService.kt", i = {}, l = {BR.backgroundUrl, BR.badgeBgColorNight}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class PasswordLoginService$login$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ILoginResult>, Object> {
    final /* synthetic */ String $account;
    final /* synthetic */ Map<String, String> $captcha;
    final /* synthetic */ LoginReportParams $loginReportParams;
    final /* synthetic */ LoginWay $loginWay;
    final /* synthetic */ String $password;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PasswordLoginService$login$2(String str, String str2, LoginReportParams loginReportParams, Map<String, String> map, LoginWay loginWay, Continuation<? super PasswordLoginService$login$2> continuation) {
        super(2, continuation);
        this.$account = str;
        this.$password = str2;
        this.$loginReportParams = loginReportParams;
        this.$captcha = map;
        this.$loginWay = loginWay;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PasswordLoginService$login$2(this.$account, this.$password, this.$loginReportParams, this.$captcha, this.$loginWay, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ILoginResult> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object $result2;
        AccountException e;
        Object $result3;
        Object $result4;
        Object $result5;
        Object $result6;
        Object $result7;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (AccountException e2) {
            Object obj = $result2;
            e = e2;
            $result3 = obj;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                VerifyBundle bundle = BiliAccounts.get(FoundationAlias.getFapp()).loginV3(this.$account, this.$password, this.$loginReportParams.getPagePv(), this.$loginReportParams.getPageRoute(), this.$captcha, this.$loginReportParams.getLoginSessionId(), this.$loginReportParams.getFromSpmId(), this.$loginReportParams.getTouristId(), this.$loginReportParams.getExtend());
                BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Finish login for account " + this.$account);
                this.label = 1;
                Object handleLoginResult$default = LoginResultService.handleLoginResult$default(LoginResultService.INSTANCE, this.$loginWay, bundle, null, (Continuation) this, 4, null);
                if (handleLoginResult$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result6 = $result;
                $result7 = handleLoginResult$default;
                try {
                    return (ILoginResult) $result7;
                } catch (AccountException e3) {
                    e = e3;
                    $result3 = $result6;
                    BLog.e(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Failed login for account " + this.$account, (Throwable) e);
                    this.label = 2;
                    Object handleLoginResult$default2 = LoginResultService.handleLoginResult$default(LoginResultService.INSTANCE, this.$loginWay, null, e, (Continuation) this, 2, null);
                    if (handleLoginResult$default2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result4 = $result3;
                    $result5 = handleLoginResult$default2;
                    return (ILoginResult) $result5;
                }
            case 1:
                $result7 = $result;
                ResultKt.throwOnFailure($result7);
                $result6 = $result7;
                return (ILoginResult) $result7;
            case 2:
                $result5 = $result;
                ResultKt.throwOnFailure($result5);
                $result4 = $result5;
                return (ILoginResult) $result5;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}