package tv.danmaku.bili.services;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import bolts.Task;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.app.comm.servercomm.ServerClock;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.H5UrlConfigHelper;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accountinfo.model.AccountInfo;
import com.bilibili.lib.accounts.AccountException;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.biliid.api.BuvidHelper;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.config.BLRemoteConfig;
import com.bilibili.moduleservice.account.AccountService;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.quick.LoginQualityMonitor;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: AccountServiceImpl.kt */
@Singleton
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0016J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/services/AccountServiceImpl;", "Lcom/bilibili/moduleservice/account/AccountService;", "<init>", "()V", "bindPhone", "", "context", "Landroid/content/Context;", "logoutWithBack", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "revokeApi", "", "logout", "isNewVipLabel", "", "updateUserInfo", "getUserInfoLegacy", "getUserInfo", "type", "getAvatar", "getUserName", "getBuvid", "getMid", "", "getAccessToken", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AccountServiceImpl implements AccountService {
    public static final int $stable = 0;

    public void bindPhone(Context context) {
        if (context != null) {
            String url = H5UrlConfigHelper.INSTANCE.getUrl("core", "url_bind_phone", AccountServiceImplKt.BIND_PHONE_URI);
            Uri parse = Uri.parse("activity://main/web/ap");
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            RouteRequest request = new RouteRequest.Builder(parse).data(Uri.parse(url)).build();
            BLRouter.routeTo(request, context);
        }
    }

    public void logoutWithBack(Activity activity, String revokeApi) {
        Intrinsics.checkNotNullParameter(revokeApi, "revokeApi");
        logout(revokeApi);
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    public void logout(final String revokeApi) {
        Intrinsics.checkNotNullParameter(revokeApi, "revokeApi");
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.services.AccountServiceImpl$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit logout$lambda$0;
                logout$lambda$0 = AccountServiceImpl.logout$lambda$0(revokeApi);
                return logout$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit logout$lambda$0(String $revokeApi) {
        BiliAccounts.get(BiliContext.application()).logout($revokeApi);
        return Unit.INSTANCE;
    }

    public boolean isNewVipLabel() {
        long vipLabelEnableTs = BLRemoteConfig.getInstance().getLong("vip_label_enable_ts", 0L);
        if (vipLabelEnableTs == 0) {
            return false;
        }
        long now = ServerClock.unreliableNow();
        return now > vipLabelEnableTs;
    }

    public void updateUserInfo() {
        BiliAccountInfo client;
        if (BiliContext.application() != null && (client = BiliAccountInfo.Companion.get()) != null) {
            try {
                client.requestForMyAccountInfo();
            } catch (AccountException e) {
                BLog.w("AccountRoutes", e);
            }
        }
    }

    public String getUserInfoLegacy() {
        if (BiliContext.application() != null) {
            Map jSONObject = new JSONObject();
            BiliAccountInfo client = BiliAccountInfo.Companion.get();
            AccountInfo myInfo = null;
            if (client != null) {
                myInfo = client.getAccountInfoFromCache();
            }
            if (myInfo == null) {
                jSONObject.put(LoginReporterV2.Show.SIGNUP_KEY_CODE, LoginQualityMonitor.OTHER_RESULT_CODE_MOBILE_API_ERROR);
                jSONObject.put("message", "not login");
            } else {
                jSONObject.put("mid", Long.valueOf(myInfo.getMid()));
                jSONObject.put("face", myInfo.getAvatar());
                jSONObject.put("userName", myInfo.getUserName());
            }
            return JSON.toJSONString(jSONObject);
        }
        return null;
    }

    public String getUserInfo(String type) {
        if (BiliContext.application() != null) {
            Map jSONObject = new JSONObject();
            BiliAccountInfo client = BiliAccountInfo.Companion.get();
            AccountInfo myInfo = null;
            if (client != null) {
                myInfo = client.getAccountInfoFromCache();
            }
            if (myInfo == null) {
                jSONObject.put(AuthResultCbHelper.ARGS_STATE, "0");
                jSONObject.put("message", "not login");
            } else {
                jSONObject.put(AuthResultCbHelper.ARGS_STATE, "1");
                jSONObject.put("mid", Long.valueOf(myInfo.getMid()));
                jSONObject.put("face", myInfo.getAvatar());
                jSONObject.put("userName", myInfo.getUserName());
                if (type != null) {
                    Object value = jSONObject.get(type);
                    jSONObject = new JSONObject();
                    jSONObject.put(type, value);
                }
            }
            return JSON.toJSONString(jSONObject);
        }
        return null;
    }

    public String getAvatar() {
        AccountInfo accountInfo;
        if (BiliContext.application() == null || (accountInfo = BiliAccountInfo.Companion.get().getAccountInfoFromCache()) == null) {
            return null;
        }
        return accountInfo.getAvatar();
    }

    public String getUserName() {
        AccountInfo accountInfo;
        if (BiliContext.application() == null || (accountInfo = BiliAccountInfo.Companion.get().getAccountInfoFromCache()) == null) {
            return null;
        }
        return accountInfo.getUserName();
    }

    public String getBuvid() {
        return BuvidHelper.getBuvid();
    }

    public long getMid() {
        Application it = BiliContext.application();
        if (it == null) {
            return 0L;
        }
        return BiliAccounts.get(it).mid();
    }

    public String getAccessToken() {
        Application it = BiliContext.application();
        if (it != null) {
            return BiliAccounts.get(it).getAccessKey();
        }
        return null;
    }
}