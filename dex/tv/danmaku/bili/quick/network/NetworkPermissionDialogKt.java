package tv.danmaku.bili.quick.network;

import android.content.Context;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.model.TInfoLogin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.normal.ui.RouteUtilKt;
import tv.danmaku.bili.quick.core.LoginRuleProcessor;
import tv.danmaku.bili.quick.core.OnePassLoginPathLinkManager;
import tv.danmaku.bili.quick.core.OnePassLoginReportManagerKt;
import tv.danmaku.bili.report.LoginReportHelper;

/* compiled from: NetworkPermissionDialog.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0001¨\u0006\u0007"}, d2 = {"retryQuickLogin", "", "ctx", "Landroid/content/Context;", "tInfo", "Lcom/bilibili/lib/accounts/model/TInfoLogin;", "getPhoneInfoSuc", "accountui_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NetworkPermissionDialogKt {
    public static final boolean retryQuickLogin(Context ctx, TInfoLogin tInfo, boolean getPhoneInfoSuc) {
        TInfoLogin.AB ab;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        boolean isLogin = BiliAccounts.get(ctx).isLogin();
        String fromSpmid = LoginReportHelper.INSTANCE.getFromSpmid();
        if (getPhoneInfoSuc) {
            if (isLogin) {
                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(fromSpmid == null ? "" : fromSpmid, OnePassLoginReportManagerKt.INTERRUPTED_FOR_ALREADY_LOGIN);
                return false;
            }
            int mLoginWay = LoginRuleProcessor.INSTANCE.parseLoginWay(ctx, tInfo, false);
            RouteUtilKt.routeToLoginQuickActivity$default(ctx, null, Boolean.valueOf(mLoginWay == 1 || mLoginWay == 3), true, Boolean.valueOf(mLoginWay == 3), null, null, null, null, 64, null);
            return true;
        } else if (isLogin) {
            return false;
        } else {
            if (tInfo != null && (ab = tInfo.ab) != null) {
                r0 = ab.isSmsLoginExp();
            }
            RouteUtilKt.showSmsLoginDialog$default(ctx, "home", null, null, r0, 12, null);
            return true;
        }
    }
}