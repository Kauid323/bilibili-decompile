package tv.danmaku.bili.fullscreen.service;

import com.bilibili.lib.accounts.AccountException;
import com.bilibili.lib.accounts.VerifyBundle;
import com.bilibili.lib.accounts.model.AccountInfoMessage;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.stat.LoginWay;

/* compiled from: LoginResultService.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0086@¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/LoginResultService;", "", "<init>", "()V", "handleLoginResult", "Ltv/danmaku/bili/fullscreen/service/ILoginResult;", "loginWay", "Ltv/danmaku/bili/fullscreen/stat/LoginWay;", "bundle", "Lcom/bilibili/lib/accounts/VerifyBundle;", "error", "Lcom/bilibili/lib/accounts/AccountException;", "(Ltv/danmaku/bili/fullscreen/stat/LoginWay;Lcom/bilibili/lib/accounts/VerifyBundle;Lcom/bilibili/lib/accounts/AccountException;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAccountInfo", "Ltv/danmaku/bili/fullscreen/service/IAccountResult;", "login", "Ltv/danmaku/bili/fullscreen/service/LoginSucceed;", "(Ltv/danmaku/bili/fullscreen/service/LoginSucceed;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkRedirectType", "Ltv/danmaku/bili/fullscreen/service/IAccountRedirect;", "status", "", "redirectUrl", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginResultService {
    public static final int $stable = 0;
    public static final LoginResultService INSTANCE = new LoginResultService();

    private LoginResultService() {
    }

    public static /* synthetic */ Object handleLoginResult$default(LoginResultService loginResultService, LoginWay loginWay, VerifyBundle verifyBundle, AccountException accountException, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            verifyBundle = null;
        }
        if ((i & 4) != 0) {
            accountException = null;
        }
        return loginResultService.handleLoginResult(loginWay, verifyBundle, accountException, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleLoginResult(LoginWay loginWay, VerifyBundle bundle, AccountException error, Continuation<? super ILoginResult> continuation) {
        LoginResultService$handleLoginResult$1 loginResultService$handleLoginResult$1;
        LoginWay loginWay2;
        LoginFailed login;
        Object accountInfo;
        ILoginResult login2;
        LoginWay loginWay3;
        IAccountResult account;
        if (continuation instanceof LoginResultService$handleLoginResult$1) {
            loginResultService$handleLoginResult$1 = (LoginResultService$handleLoginResult$1) continuation;
            if ((loginResultService$handleLoginResult$1.label & Integer.MIN_VALUE) != 0) {
                loginResultService$handleLoginResult$1.label -= Integer.MIN_VALUE;
                Object $result = loginResultService$handleLoginResult$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (loginResultService$handleLoginResult$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        loginWay2 = loginWay;
                        Integer boxInt = bundle != null ? Boxing.boxInt(bundle.status) : null;
                        boolean z = false;
                        if (boxInt != null && boxInt.intValue() == 0) {
                            String accessKey = bundle.accessKey;
                            if (accessKey != null && (!StringsKt.isBlank(accessKey))) {
                                z = true;
                            }
                            if (z) {
                                if (bundle.isNew) {
                                    loginWay3 = loginWay2.onRegister();
                                } else {
                                    loginWay3 = loginWay2;
                                }
                                login = new LoginSucceed(loginWay3, accessKey, bundle.isNew, null, 0, 24, null);
                            } else {
                                login = new LoginFailed(loginWay2, null);
                            }
                        } else if (boxInt == null) {
                            if (error != null && error.code() == -105) {
                                z = true;
                            }
                            if (z) {
                                String str = error.payLoad;
                                Intrinsics.checkNotNullExpressionValue(str, "payLoad");
                                login = new LoginCaptcha(loginWay2, str);
                            } else {
                                login = new LoginFailed(loginWay2, (Exception) error);
                            }
                        } else {
                            IAccountRedirect redirect = checkRedirectType(bundle.status, bundle.verifyURL);
                            if (redirect != null) {
                                login = new LoginRedirected(loginWay2, redirect);
                            } else {
                                login = new LoginFailed(loginWay2, null);
                            }
                        }
                        if (!(login instanceof LoginSucceed)) {
                            return login;
                        }
                        loginResultService$handleLoginResult$1.L$0 = loginWay2;
                        loginResultService$handleLoginResult$1.L$1 = login;
                        loginResultService$handleLoginResult$1.label = 1;
                        accountInfo = getAccountInfo(login, loginResultService$handleLoginResult$1);
                        if (accountInfo == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        login2 = login;
                        break;
                    case 1:
                        login2 = (ILoginResult) loginResultService$handleLoginResult$1.L$1;
                        ResultKt.throwOnFailure($result);
                        loginWay2 = (LoginWay) loginResultService$handleLoginResult$1.L$0;
                        accountInfo = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                account = (IAccountResult) accountInfo;
                if (!(account instanceof AccountFailed)) {
                    ILoginResult login3 = new LoginFailed(loginWay2, ((AccountFailed) account).getError());
                    return login3;
                } else if (account instanceof AccountIntercepted) {
                    ILoginResult login4 = new LoginIntercepted(loginWay2, ((AccountIntercepted) account).getIntercepted());
                    return login4;
                } else if (account instanceof AccountSucceed) {
                    return login2;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        loginResultService$handleLoginResult$1 = new LoginResultService$handleLoginResult$1(this, continuation);
        Object $result2 = loginResultService$handleLoginResult$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (loginResultService$handleLoginResult$1.label) {
        }
        account = (IAccountResult) accountInfo;
        if (!(account instanceof AccountFailed)) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getAccountInfo(LoginSucceed login, Continuation<? super IAccountResult> continuation) {
        LoginResultService$getAccountInfo$1 loginResultService$getAccountInfo$1;
        Object withContext;
        LoginSucceed login2;
        LoginResultService loginResultService;
        AccountInfoMessage message;
        if (continuation instanceof LoginResultService$getAccountInfo$1) {
            loginResultService$getAccountInfo$1 = (LoginResultService$getAccountInfo$1) continuation;
            if ((loginResultService$getAccountInfo$1.label & Integer.MIN_VALUE) != 0) {
                loginResultService$getAccountInfo$1.label -= Integer.MIN_VALUE;
                Object $result = loginResultService$getAccountInfo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (loginResultService$getAccountInfo$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        loginResultService$getAccountInfo$1.L$0 = login;
                        loginResultService$getAccountInfo$1.label = 1;
                        withContext = BuildersKt.withContext(Dispatchers.getIO(), new LoginResultService$getAccountInfo$message$1(login, null), loginResultService$getAccountInfo$1);
                        if (withContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        login2 = login;
                        loginResultService = this;
                        break;
                    case 1:
                        loginResultService = this;
                        login2 = (LoginSucceed) loginResultService$getAccountInfo$1.L$0;
                        ResultKt.throwOnFailure($result);
                        withContext = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                message = (AccountInfoMessage) withContext;
                if (!message.isSuccess()) {
                    IAccountRedirect redirect = loginResultService.checkRedirectType(login2.getVerifyStatus(), login2.getVerifyUrl());
                    if (redirect == null) {
                        return new AccountSucceed(login2.getLoginWay());
                    }
                    return new AccountIntercepted(login2.getLoginWay(), redirect);
                }
                return new AccountFailed(message.getException());
            }
        }
        loginResultService$getAccountInfo$1 = new LoginResultService$getAccountInfo$1(this, continuation);
        Object $result2 = loginResultService$getAccountInfo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (loginResultService$getAccountInfo$1.label) {
        }
        message = (AccountInfoMessage) withContext;
        if (!message.isSuccess()) {
        }
    }

    private final IAccountRedirect checkRedirectType(int status, String redirectUrl) {
        String str = redirectUrl;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        if (status == 1) {
            return new AccountRedirectVerify(redirectUrl);
        }
        if (status == 2 || status == 3 || status == 4 || status == 5 || status == 8) {
            return new AccountRedirectSecurity(redirectUrl);
        }
        return null;
    }
}