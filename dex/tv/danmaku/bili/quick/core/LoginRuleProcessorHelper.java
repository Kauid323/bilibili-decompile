package tv.danmaku.bili.quick.core;

import kotlin.Metadata;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.core.LoginRuleProcessor;

/* compiled from: LoginRuleProcessorHelper.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/quick/core/LoginRuleProcessorHelper;", "", "<init>", "()V", "TAG", "", "getLoginType", "", "callBack", "Ltv/danmaku/bili/quick/core/LoginRuleProcessor$GetLoginTypeCallBack;", "cacheEnable", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginRuleProcessorHelper {
    public static final int $stable = 0;
    public static final LoginRuleProcessorHelper INSTANCE = new LoginRuleProcessorHelper();
    private static final String TAG = "LoginRuleProcessorHelpe";

    private LoginRuleProcessorHelper() {
    }

    public final void getLoginType(LoginRuleProcessor.GetLoginTypeCallBack callBack, boolean cacheEnable) {
        BLog.i(TAG, "get login rule");
        LoginRuleProcessor.getLoginType$default(LoginRuleProcessor.INSTANCE, callBack, cacheEnable, false, false, 12, null);
    }
}