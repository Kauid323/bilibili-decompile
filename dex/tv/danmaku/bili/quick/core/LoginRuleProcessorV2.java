package tv.danmaku.bili.quick.core;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.lib.accounts.AccountException;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.model.TInfoLogin;
import com.bilibili.lib.accountsui.quick.LoginQuickManager;
import com.bilibili.lib.gson.GsonKt;
import com.bilibili.lib.oaid.MsaHelper;
import com.google.gson.JsonObject;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fast.FastReLoginSettingKt;
import tv.danmaku.bili.quick.core.LoginRuleProcessor;

/* compiled from: LoginRuleProcessorV2.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/quick/core/LoginRuleProcessorV2;", "", "<init>", "()V", "TAG", "", LoginRuleProcessorV2.PREF_KEY_INFO_LOGIN, "getLoginType", "", "callBack", "Ltv/danmaku/bili/quick/core/LoginRuleProcessor$GetLoginTypeCallBack;", "cacheEnable", "", "asFirstBoot", "switch", "parseLoginWay", "", "context", "Landroid/content/Context;", "tInfoLogin", "Lcom/bilibili/lib/accounts/model/TInfoLogin;", "skipFastLogin", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginRuleProcessorV2 {
    public static final int $stable = 0;
    public static final LoginRuleProcessorV2 INSTANCE = new LoginRuleProcessorV2();
    public static final String PREF_KEY_INFO_LOGIN = "PREF_KEY_INFO_LOGIN";
    private static final String TAG = "LoginRuleProcessorV2";

    public final void getLoginType(LoginRuleProcessor.GetLoginTypeCallBack getLoginTypeCallBack, boolean z, boolean z2) {
        getLoginType$default(this, getLoginTypeCallBack, z, z2, false, 8, null);
    }

    private LoginRuleProcessorV2() {
    }

    public static /* synthetic */ void getLoginType$default(LoginRuleProcessorV2 loginRuleProcessorV2, LoginRuleProcessor.GetLoginTypeCallBack getLoginTypeCallBack, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 8) != 0) {
            z3 = false;
        }
        loginRuleProcessorV2.getLoginType(getLoginTypeCallBack, z, z2, z3);
    }

    public final void getLoginType(final LoginRuleProcessor.GetLoginTypeCallBack callBack, boolean cacheEnable, final boolean asFirstBoot, boolean z) {
        if (callBack != null) {
            callBack.startGetLoginType();
        }
        if (BiliAccounts.get(BiliContext.application()).isLogin() && !z) {
            if (callBack != null) {
                callBack.endGetLoginType(2, null);
            }
        } else if (LoginRuleProcessor.INSTANCE.getMTInfoLogin() != null && cacheEnable) {
            if (callBack != null) {
                callBack.endGetLoginType(1, LoginRuleProcessor.INSTANCE.getMTInfoLogin());
            }
        } else {
            Application application = BiliContext.application();
            Intrinsics.checkNotNull(application);
            final SharedPreferences blkv = BiliGlobalPreferenceHelper.getBLKVSharedPreference(application);
            Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.quick.core.LoginRuleProcessorV2$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    TInfoLogin loginType$lambda$0;
                    loginType$lambda$0 = LoginRuleProcessorV2.getLoginType$lambda$0(asFirstBoot, blkv);
                    return loginType$lambda$0;
                }
            }).continueWith(new Continuation() { // from class: tv.danmaku.bili.quick.core.LoginRuleProcessorV2$$ExternalSyntheticLambda1
                public final Object then(Task task) {
                    Void loginType$lambda$1;
                    loginType$lambda$1 = LoginRuleProcessorV2.getLoginType$lambda$1(LoginRuleProcessor.GetLoginTypeCallBack.this, task);
                    return loginType$lambda$1;
                }
            }, Task.UI_THREAD_EXECUTOR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TInfoLogin getLoginType$lambda$0(boolean $asFirstBoot, SharedPreferences $blkv) {
        String oaid;
        JsonObject jsonObject;
        if ($asFirstBoot) {
            try {
                oaid = MsaHelper.getOaid();
            } catch (AccountException e) {
                BLog.i(TAG, "get login type e " + e.getMessage());
                TInfoLogin localInfo = (TInfoLogin) GsonKt.getSGlobalGson().fromJson($blkv.getString(PREF_KEY_INFO_LOGIN, null), TInfoLogin.class);
                BLog.i(TAG, "get login type localInfo = " + localInfo);
                return localInfo;
            }
        } else {
            oaid = "";
        }
        TInfoLogin infoLogin = BiliAccounts.get(BiliContext.application()).getLoginType($asFirstBoot, oaid);
        BLog.i(TAG, "get login type " + infoLogin);
        LoginRuleProcessor.INSTANCE.setMTInfoLogin(infoLogin);
        SharedPreferences.Editor edit = $blkv.edit();
        Intrinsics.checkNotNull(infoLogin);
        edit.putString(PREF_KEY_INFO_LOGIN, GsonKt.toJsonString(infoLogin)).apply();
        SharedPreferences.Editor edit2 = $blkv.edit();
        TInfoLogin mTInfoLogin = LoginRuleProcessor.INSTANCE.getMTInfoLogin();
        edit2.putString(LoginRuleProcessor.PREF_KEY_SCENE_PROMPT, (mTInfoLogin == null || (jsonObject = mTInfoLogin.scenePrompt) == null) ? null : GsonKt.toJsonString(jsonObject)).apply();
        return infoLogin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void getLoginType$lambda$1(LoginRuleProcessor.GetLoginTypeCallBack $callBack, Task task) {
        task.isCancelled();
        if ($callBack != null) {
            $callBack.endGetLoginType(task.getResult() != null ? 1 : 2, (TInfoLogin) task.getResult());
            return null;
        }
        return null;
    }

    public static /* synthetic */ int parseLoginWay$default(LoginRuleProcessorV2 loginRuleProcessorV2, Context context, TInfoLogin tInfoLogin, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return loginRuleProcessorV2.parseLoginWay(context, tInfoLogin, z);
    }

    public final int parseLoginWay(Context context, TInfoLogin tInfoLogin, boolean skipFastLogin) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (tInfoLogin != null && tInfoLogin.isLoginOkV2()) {
            TInfoLogin.LoginBean.FastLoginBean fastLoginBean = tInfoLogin.login.fastLogin;
            Integer valueOf = fastLoginBean != null ? Integer.valueOf(fastLoginBean.rank) : null;
            boolean isFastReLoginEnabled = FastReLoginSettingKt.isFastReLoginEnabled();
            TInfoLogin.QuickBean quickBean = tInfoLogin.login.quick;
            Integer valueOf2 = quickBean != null ? Integer.valueOf(quickBean.rank) : null;
            TInfoLogin.LoginBean.PwdBean pwdBean = tInfoLogin.login.pwd;
            Integer valueOf3 = pwdBean != null ? Integer.valueOf(pwdBean.rank) : null;
            TInfoLogin.LoginBean.SmsBean smsBean = tInfoLogin.login.sms;
            BLog.i(TAG, "parseLoginWay fast = " + valueOf + ", isFastReLoginEnabled " + isFastReLoginEnabled + ", skip fast = " + skipFastLogin + ", quick.rank = " + valueOf2 + " , pwd.rank = " + valueOf3 + " , sms.rank = " + (smsBean != null ? Integer.valueOf(smsBean.rank) : null));
            if (FastReLoginSettingKt.isFastReLoginEnabled() && !skipFastLogin && tInfoLogin.login != null && tInfoLogin.login.fastLogin != null && tInfoLogin.login.fastLogin.rank != 0 && ((tInfoLogin.login.fastLogin.rank <= tInfoLogin.login.quick.rank || tInfoLogin.login.quick.rank == 0) && ((tInfoLogin.login.fastLogin.rank <= tInfoLogin.login.pwd.rank || tInfoLogin.login.pwd.rank == 0) && (tInfoLogin.login.fastLogin.rank <= tInfoLogin.login.sms.rank || tInfoLogin.login.sms.rank == 0)))) {
                return 10;
            }
            if (tInfoLogin.isQuickLoginOk() && ((tInfoLogin.login.quick.rank <= tInfoLogin.login.pwd.rank || tInfoLogin.login.pwd.rank == 0) && (tInfoLogin.login.quick.rank <= tInfoLogin.login.sms.rank || tInfoLogin.login.sms.rank == 0))) {
                if (tInfoLogin.login.sms.rank > 0) {
                    if (tInfoLogin.login.pwd.rank < tInfoLogin.login.sms.rank && tInfoLogin.login.pwd.rank > 0) {
                        return 1;
                    }
                    return 3;
                } else if (tInfoLogin.login.sms.rank == 0) {
                    return 2;
                }
            } else if (tInfoLogin.login.sms.rank > 0) {
                if (tInfoLogin.login.pwd.rank < tInfoLogin.login.sms.rank && tInfoLogin.login.pwd.rank > 0) {
                    if (tInfoLogin.login.quick.rank > 0) {
                        LoginQuickManager loginQuickManager = LoginQuickManager.INSTANCE;
                        TInfoLogin.QuickBean quickBean2 = tInfoLogin.login.quick;
                        Intrinsics.checkNotNullExpressionValue(quickBean2, "quick");
                        if (loginQuickManager.isNetOk(context, quickBean2)) {
                            return 5;
                        }
                    }
                    return 4;
                } else if (tInfoLogin.login.quick.rank > 0) {
                    LoginQuickManager loginQuickManager2 = LoginQuickManager.INSTANCE;
                    TInfoLogin.QuickBean quickBean3 = tInfoLogin.login.quick;
                    Intrinsics.checkNotNullExpressionValue(quickBean3, "quick");
                    if (!loginQuickManager2.isNetOk(context, quickBean3)) {
                        return 8;
                    }
                    return 9;
                } else {
                    return 8;
                }
            } else if (tInfoLogin.login.sms.rank == 0) {
                if (tInfoLogin.login.quick.rank > 0) {
                    LoginQuickManager loginQuickManager3 = LoginQuickManager.INSTANCE;
                    TInfoLogin.QuickBean quickBean4 = tInfoLogin.login.quick;
                    Intrinsics.checkNotNullExpressionValue(quickBean4, "quick");
                    if (loginQuickManager3.isNetOk(context, quickBean4)) {
                        return 7;
                    }
                }
                return 6;
            }
        }
        return 8;
    }
}