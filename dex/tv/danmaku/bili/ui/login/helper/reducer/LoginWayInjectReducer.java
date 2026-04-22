package tv.danmaku.bili.ui.login.helper.reducer;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.core.LoginRuleProcessor;
import tv.danmaku.bili.ui.login.helper.AutoLoginCheckResult;
import tv.danmaku.bili.ui.login.helper.AutoLoginData;
import tv.danmaku.bili.ui.login.helper.LoginWay;
import tv.danmaku.bili.ui.login.helper.QuickLoginCheckReducer;

/* compiled from: LoginWayInjectReducer.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/ui/login/helper/reducer/LoginWayInjectReducer;", "Ltv/danmaku/bili/ui/login/helper/QuickLoginCheckReducer;", "<init>", "()V", "check", "Ltv/danmaku/bili/ui/login/helper/AutoLoginCheckResult;", "context", "Landroid/content/Context;", "fromSpmid", "", "data", "Ltv/danmaku/bili/ui/login/helper/AutoLoginData;", "(Landroid/content/Context;Ljava/lang/String;Ltv/danmaku/bili/ui/login/helper/AutoLoginData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginWayInjectReducer implements QuickLoginCheckReducer {
    public static final int $stable = 0;

    @Override // tv.danmaku.bili.ui.login.helper.QuickLoginCheckReducer
    public /* synthetic */ Object afterCheck(String str, AutoLoginCheckResult autoLoginCheckResult, Continuation continuation) {
        Object afterCheck$suspendImpl;
        afterCheck$suspendImpl = QuickLoginCheckReducer.CC.afterCheck$suspendImpl(this, str, autoLoginCheckResult, continuation);
        return afterCheck$suspendImpl;
    }

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

    @Override // tv.danmaku.bili.ui.login.helper.QuickLoginCheckReducer
    public Object check(Context context, String fromSpmid, AutoLoginData data, Continuation<? super AutoLoginCheckResult> continuation) {
        int loginWay = LoginRuleProcessor.parseLoginWay$default(LoginRuleProcessor.INSTANCE, context, data.getLoginInfo(), false, 4, null);
        return new AutoLoginCheckResult(AutoLoginData.copy$default(data, null, new LoginWay(loginWay, false, false, 6, null), null, null, false, 29, null), false, 2, null);
    }
}