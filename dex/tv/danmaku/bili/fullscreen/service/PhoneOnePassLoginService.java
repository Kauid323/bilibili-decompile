package tv.danmaku.bili.fullscreen.service;

import com.bilibili.lib.accounts.AccountException;
import com.bilibili.lib.accounts.VerifyBundle;
import com.bilibili.lib.accountsui.quick.LoginQuickManager;
import com.bilibili.lib.accountsui.quick.QuickLoginTag;
import com.bilibili.lib.foundation.FoundationAlias;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.stat.LoginWay;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginPageKt;

/* compiled from: PhoneOnePassLoginService.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/PhoneOnePassLoginService;", "Ltv/danmaku/bili/fullscreen/service/IPhoneOnePassLoginService;", "<init>", "()V", "login", "Ltv/danmaku/bili/fullscreen/service/ILoginResult;", "loginWay", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "phone", "Ltv/danmaku/bili/fullscreen/service/PhoneInfo;", "reportParam", "Ltv/danmaku/bili/fullscreen/service/LoginReportParams;", "(Ltv/danmaku/bili/fullscreen/stat/LoginWay;Ltv/danmaku/bili/fullscreen/service/PhoneInfo;Ltv/danmaku/bili/fullscreen/service/LoginReportParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PhoneOnePassLoginService implements IPhoneOnePassLoginService {
    public static final int $stable = 0;

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|73|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0065, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0066, code lost:
        r16 = r4;
        r0 = r0;
        r3 = r3;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0134 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x017f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01b1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v26 */
    @Override // tv.danmaku.bili.fullscreen.service.IPhoneOnePassLoginService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object login(LoginWay loginWay, PhoneInfo phone, LoginReportParams reportParam, Continuation<? super ILoginResult> continuation) {
        PhoneOnePassLoginService$login$1 phoneOnePassLoginService$login$1;
        PhoneOnePassLoginService$login$1 phoneOnePassLoginService$login$12;
        LoginWay loginWay2;
        PhoneInfo phone2;
        AccountException e;
        Object handleLoginResult$default;
        Object suspendAuthRequest;
        LoginWay loginWay3;
        PhoneInfo phone3;
        LoginReportParams reportParam2;
        LoginQuickManager.AuthInfoBean authInfo;
        Integer num;
        String token;
        Object withContext;
        LoginWay loginWay4;
        PhoneInfo phone4;
        Object handleLoginResult$default2;
        LoginWay loginWay5;
        if (continuation instanceof PhoneOnePassLoginService$login$1) {
            phoneOnePassLoginService$login$1 = (PhoneOnePassLoginService$login$1) continuation;
            if ((phoneOnePassLoginService$login$1.label & Integer.MIN_VALUE) != 0) {
                phoneOnePassLoginService$login$1.label -= Integer.MIN_VALUE;
                phoneOnePassLoginService$login$12 = phoneOnePassLoginService$login$1;
                Object $result = phoneOnePassLoginService$login$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                PhoneInfo phone5 = 1;
                r3 = true;
                boolean z = true;
                switch (phoneOnePassLoginService$login$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Start login for " + phone);
                        QuickLoginTag quickLoginTag = QuickLoginTag.MAIN;
                        phoneOnePassLoginService$login$12.L$0 = loginWay;
                        phoneOnePassLoginService$login$12.L$1 = phone;
                        phoneOnePassLoginService$login$12.L$2 = reportParam;
                        phoneOnePassLoginService$login$12.label = 1;
                        suspendAuthRequest = LoginQuickManager.INSTANCE.suspendAuthRequest(FoundationAlias.getFapp(), quickLoginTag, phoneOnePassLoginService$login$12);
                        if (suspendAuthRequest == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        loginWay3 = loginWay;
                        phone3 = phone;
                        reportParam2 = reportParam;
                        Pair result = (Pair) suspendAuthRequest;
                        authInfo = (LoginQuickManager.AuthInfoBean) result.getSecond();
                        num = (Integer) result.getFirst();
                        if (num != null && num.intValue() == 1 && authInfo != null) {
                            token = authInfo.getToken();
                            if (token != null && !StringsKt.isBlank(token)) {
                                z = false;
                            }
                            if (!z) {
                                try {
                                    phoneOnePassLoginService$login$12.L$0 = loginWay3;
                                    phoneOnePassLoginService$login$12.L$1 = phone3;
                                    phoneOnePassLoginService$login$12.L$2 = null;
                                    phoneOnePassLoginService$login$12.label = 2;
                                    withContext = BuildersKt.withContext(Dispatchers.getIO(), new PhoneOnePassLoginService$login$bundle$1(authInfo, phone3, reportParam2, null), phoneOnePassLoginService$login$12);
                                    if (withContext == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    loginWay4 = loginWay3;
                                    phone4 = phone3;
                                    try {
                                        VerifyBundle bundle = (VerifyBundle) withContext;
                                        BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Finish login for " + phone4);
                                        LoginResultService loginResultService = LoginResultService.INSTANCE;
                                        phoneOnePassLoginService$login$12.L$0 = loginWay4;
                                        phoneOnePassLoginService$login$12.L$1 = phone4;
                                        phoneOnePassLoginService$login$12.label = 3;
                                        loginWay2 = loginWay4;
                                        try {
                                            handleLoginResult$default2 = LoginResultService.handleLoginResult$default(loginResultService, loginWay4, bundle, null, phoneOnePassLoginService$login$12, 4, null);
                                            if (handleLoginResult$default2 != coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            phone5 = phone4;
                                            loginWay5 = loginWay2;
                                            return (ILoginResult) handleLoginResult$default2;
                                        } catch (AccountException e2) {
                                            phone2 = phone4;
                                            e = e2;
                                            JobKt.ensureActive(phoneOnePassLoginService$login$12.getContext());
                                            BLog.e(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Failed login for " + phone2, (Throwable) e);
                                            LoginResultService loginResultService2 = LoginResultService.INSTANCE;
                                            phoneOnePassLoginService$login$12.L$0 = null;
                                            phoneOnePassLoginService$login$12.L$1 = null;
                                            phoneOnePassLoginService$login$12.L$2 = null;
                                            phoneOnePassLoginService$login$12.label = 4;
                                            handleLoginResult$default = LoginResultService.handleLoginResult$default(loginResultService2, loginWay2, null, e, phoneOnePassLoginService$login$12, 2, null);
                                            if (handleLoginResult$default == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            return (ILoginResult) handleLoginResult$default;
                                        }
                                    } catch (AccountException e3) {
                                        loginWay2 = loginWay4;
                                        phone2 = phone4;
                                        e = e3;
                                    }
                                } catch (AccountException e4) {
                                    phone2 = phone3;
                                    loginWay2 = loginWay3;
                                    e = e4;
                                    JobKt.ensureActive(phoneOnePassLoginService$login$12.getContext());
                                    BLog.e(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Failed login for " + phone2, (Throwable) e);
                                    LoginResultService loginResultService22 = LoginResultService.INSTANCE;
                                    phoneOnePassLoginService$login$12.L$0 = null;
                                    phoneOnePassLoginService$login$12.L$1 = null;
                                    phoneOnePassLoginService$login$12.L$2 = null;
                                    phoneOnePassLoginService$login$12.label = 4;
                                    handleLoginResult$default = LoginResultService.handleLoginResult$default(loginResultService22, loginWay2, null, e, phoneOnePassLoginService$login$12, 2, null);
                                    if (handleLoginResult$default == coroutine_suspended) {
                                    }
                                    return (ILoginResult) handleLoginResult$default;
                                }
                            }
                        }
                        BLog.w(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Login failed for " + phone3);
                        LoginResultService loginResultService3 = LoginResultService.INSTANCE;
                        phoneOnePassLoginService$login$12.L$0 = null;
                        phoneOnePassLoginService$login$12.L$1 = null;
                        phoneOnePassLoginService$login$12.L$2 = null;
                        phoneOnePassLoginService$login$12.label = 5;
                        Object handleLoginResult$default3 = LoginResultService.handleLoginResult$default(loginResultService3, loginWay3, null, null, phoneOnePassLoginService$login$12, 6, null);
                        return handleLoginResult$default3 != coroutine_suspended ? coroutine_suspended : handleLoginResult$default3;
                    case 1:
                        reportParam2 = (LoginReportParams) phoneOnePassLoginService$login$12.L$2;
                        phone3 = (PhoneInfo) phoneOnePassLoginService$login$12.L$1;
                        ResultKt.throwOnFailure($result);
                        loginWay3 = (LoginWay) phoneOnePassLoginService$login$12.L$0;
                        suspendAuthRequest = $result;
                        Pair result2 = (Pair) suspendAuthRequest;
                        authInfo = (LoginQuickManager.AuthInfoBean) result2.getSecond();
                        num = (Integer) result2.getFirst();
                        if (num != null) {
                            token = authInfo.getToken();
                            if (token != null) {
                                z = false;
                                break;
                            }
                            if (!z) {
                            }
                            break;
                        }
                        BLog.w(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Login failed for " + phone3);
                        LoginResultService loginResultService32 = LoginResultService.INSTANCE;
                        phoneOnePassLoginService$login$12.L$0 = null;
                        phoneOnePassLoginService$login$12.L$1 = null;
                        phoneOnePassLoginService$login$12.L$2 = null;
                        phoneOnePassLoginService$login$12.label = 5;
                        Object handleLoginResult$default32 = LoginResultService.handleLoginResult$default(loginResultService32, loginWay3, null, null, phoneOnePassLoginService$login$12, 6, null);
                        if (handleLoginResult$default32 != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        PhoneInfo phone6 = (PhoneInfo) phoneOnePassLoginService$login$12.L$1;
                        LoginWay loginWay6 = (LoginWay) phoneOnePassLoginService$login$12.L$0;
                        ResultKt.throwOnFailure($result);
                        phone4 = phone6;
                        loginWay4 = loginWay6;
                        withContext = $result;
                        VerifyBundle bundle2 = (VerifyBundle) withContext;
                        BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Finish login for " + phone4);
                        LoginResultService loginResultService4 = LoginResultService.INSTANCE;
                        phoneOnePassLoginService$login$12.L$0 = loginWay4;
                        phoneOnePassLoginService$login$12.L$1 = phone4;
                        phoneOnePassLoginService$login$12.label = 3;
                        loginWay2 = loginWay4;
                        handleLoginResult$default2 = LoginResultService.handleLoginResult$default(loginResultService4, loginWay4, bundle2, null, phoneOnePassLoginService$login$12, 4, null);
                        if (handleLoginResult$default2 != coroutine_suspended) {
                        }
                        break;
                    case 3:
                        PhoneInfo phoneInfo = (PhoneInfo) phoneOnePassLoginService$login$12.L$1;
                        loginWay5 = (LoginWay) phoneOnePassLoginService$login$12.L$0;
                        ResultKt.throwOnFailure($result);
                        handleLoginResult$default2 = $result;
                        phone5 = phoneInfo;
                        return (ILoginResult) handleLoginResult$default2;
                    case 4:
                        ResultKt.throwOnFailure($result);
                        handleLoginResult$default = $result;
                        return (ILoginResult) handleLoginResult$default;
                    case 5:
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        phoneOnePassLoginService$login$1 = new PhoneOnePassLoginService$login$1(this, continuation);
        phoneOnePassLoginService$login$12 = phoneOnePassLoginService$login$1;
        Object $result2 = phoneOnePassLoginService$login$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        PhoneInfo phone52 = 1;
        z = true;
        boolean z2 = true;
        switch (phoneOnePassLoginService$login$12.label) {
        }
    }
}