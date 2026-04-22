package tv.danmaku.bili.ui.login.helper.reducer;

import android.content.Context;
import com.bilibili.lib.accounts.model.TInfoLogin;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.LoginQualityMonitor;
import tv.danmaku.bili.quick.core.LoginRuleProcessor;
import tv.danmaku.bili.quick.core.OnePassLoginPathLinkManager;
import tv.danmaku.bili.quick.core.OnePassLoginReportManagerKt;
import tv.danmaku.bili.ui.login.helper.AutoLoginCheckResult;
import tv.danmaku.bili.ui.login.helper.AutoLoginData;
import tv.danmaku.bili.ui.login.helper.QuickLoginCheckReducer;

/* compiled from: LoginTypeCheckerReducer.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/login/helper/reducer/LoginTypeCheckerReducer;", "Ltv/danmaku/bili/ui/login/helper/QuickLoginCheckReducer;", "<init>", "()V", "check", "Ltv/danmaku/bili/ui/login/helper/AutoLoginCheckResult;", "context", "Landroid/content/Context;", "fromSpmid", "", "data", "Ltv/danmaku/bili/ui/login/helper/AutoLoginData;", "(Landroid/content/Context;Ljava/lang/String;Ltv/danmaku/bili/ui/login/helper/AutoLoginData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "afterCheck", "", "result", "(Ljava/lang/String;Ltv/danmaku/bili/ui/login/helper/AutoLoginCheckResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginTypeCheckerReducer implements QuickLoginCheckReducer {
    public static final int $stable = 0;

    @Override // tv.danmaku.bili.ui.login.helper.QuickLoginCheckReducer
    /* renamed from: beforeCheck-5k-lyPk */
    public /* synthetic */ Object mo1802beforeCheck5klyPk(Context context, String str, AutoLoginData autoLoginData, Continuation continuation) {
        Object m1804beforeCheck5klyPk$suspendImpl;
        m1804beforeCheck5klyPk$suspendImpl = QuickLoginCheckReducer.CC.m1804beforeCheck5klyPk$suspendImpl(this, context, str, autoLoginData, continuation);
        return m1804beforeCheck5klyPk$suspendImpl;
    }

    @Override // tv.danmaku.bili.ui.login.helper.QuickLoginCheckReducer
    public /* synthetic */ String getTAG() {
        return QuickLoginCheckReducer.CC.$default$getTAG(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
    @Override // tv.danmaku.bili.ui.login.helper.QuickLoginCheckReducer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object check(Context context, String fromSpmid, AutoLoginData data, Continuation<? super AutoLoginCheckResult> continuation) {
        LoginTypeCheckerReducer$check$1 loginTypeCheckerReducer$check$1;
        Object suspendGetLoginType$default;
        String fromSpmid2;
        AutoLoginData autoLoginData;
        boolean goOn;
        if (continuation instanceof LoginTypeCheckerReducer$check$1) {
            loginTypeCheckerReducer$check$1 = (LoginTypeCheckerReducer$check$1) continuation;
            if ((loginTypeCheckerReducer$check$1.label & Integer.MIN_VALUE) != 0) {
                loginTypeCheckerReducer$check$1.label -= Integer.MIN_VALUE;
                Object $result = loginTypeCheckerReducer$check$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (loginTypeCheckerReducer$check$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        LoginRuleProcessor loginRuleProcessor = LoginRuleProcessor.INSTANCE;
                        loginTypeCheckerReducer$check$1.L$0 = fromSpmid;
                        loginTypeCheckerReducer$check$1.L$1 = data;
                        loginTypeCheckerReducer$check$1.label = 1;
                        suspendGetLoginType$default = LoginRuleProcessor.suspendGetLoginType$default(loginRuleProcessor, false, false, loginTypeCheckerReducer$check$1, 3, null);
                        if (suspendGetLoginType$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        fromSpmid2 = fromSpmid;
                        autoLoginData = data;
                        break;
                    case 1:
                        fromSpmid2 = (String) loginTypeCheckerReducer$check$1.L$0;
                        ResultKt.throwOnFailure($result);
                        autoLoginData = (AutoLoginData) loginTypeCheckerReducer$check$1.L$1;
                        suspendGetLoginType$default = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                TInfoLogin infoLogin = (TInfoLogin) ((Pair) suspendGetLoginType$default).getSecond();
                goOn = infoLogin == null;
                if (!goOn) {
                    OnePassLoginPathLinkManager.INSTANCE.stopWithReason(fromSpmid2, OnePassLoginReportManagerKt.INTERRUPTED_FOR_FAILED_TO_GET_LOGIN_INFO);
                }
                return new AutoLoginCheckResult(AutoLoginData.copy$default(autoLoginData, infoLogin, null, null, null, false, 30, null), goOn);
            }
        }
        loginTypeCheckerReducer$check$1 = new LoginTypeCheckerReducer$check$1(this, continuation);
        Object $result2 = loginTypeCheckerReducer$check$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (loginTypeCheckerReducer$check$1.label) {
        }
        TInfoLogin infoLogin2 = (TInfoLogin) ((Pair) suspendGetLoginType$default).getSecond();
        if (infoLogin2 == null) {
        }
        if (!goOn) {
        }
        return new AutoLoginCheckResult(AutoLoginData.copy$default(autoLoginData, infoLogin2, null, null, null, false, 30, null), goOn);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0050  */
    @Override // tv.danmaku.bili.ui.login.helper.QuickLoginCheckReducer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object afterCheck(String fromSpmid, AutoLoginCheckResult result, Continuation<? super Unit> continuation) {
        LoginTypeCheckerReducer$afterCheck$1 loginTypeCheckerReducer$afterCheck$1;
        Object afterCheck$suspendImpl;
        LoginTypeCheckerReducer loginTypeCheckerReducer;
        if (continuation instanceof LoginTypeCheckerReducer$afterCheck$1) {
            loginTypeCheckerReducer$afterCheck$1 = (LoginTypeCheckerReducer$afterCheck$1) continuation;
            if ((loginTypeCheckerReducer$afterCheck$1.label & Integer.MIN_VALUE) != 0) {
                loginTypeCheckerReducer$afterCheck$1.label -= Integer.MIN_VALUE;
                Object $result = loginTypeCheckerReducer$afterCheck$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (loginTypeCheckerReducer$afterCheck$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        loginTypeCheckerReducer$afterCheck$1.L$0 = result;
                        loginTypeCheckerReducer$afterCheck$1.label = 1;
                        afterCheck$suspendImpl = QuickLoginCheckReducer.CC.afterCheck$suspendImpl(this, fromSpmid, result, loginTypeCheckerReducer$afterCheck$1);
                        if (afterCheck$suspendImpl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        loginTypeCheckerReducer = this;
                        break;
                    case 1:
                        loginTypeCheckerReducer = this;
                        result = (AutoLoginCheckResult) loginTypeCheckerReducer$afterCheck$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (result.getData().getLoginWay() == null) {
                    LoginQualityMonitor.report$default(LoginQualityMonitor.INSTANCE, "1", "3", null, null, 12, null);
                    BLog.i(loginTypeCheckerReducer.getTAG(), "cancel quick login because login type is null");
                }
                return Unit.INSTANCE;
            }
        }
        loginTypeCheckerReducer$afterCheck$1 = new LoginTypeCheckerReducer$afterCheck$1(this, continuation);
        Object $result2 = loginTypeCheckerReducer$afterCheck$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (loginTypeCheckerReducer$afterCheck$1.label) {
        }
        if (result.getData().getLoginWay() == null) {
        }
        return Unit.INSTANCE;
    }
}