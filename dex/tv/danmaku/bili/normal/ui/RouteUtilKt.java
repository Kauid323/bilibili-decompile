package tv.danmaku.bili.normal.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.bilibili.droid.BundleUtil;
import com.bilibili.droid.PhoneUtils;
import com.bilibili.lib.accounts.model.SimpleAccountItem;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteRequestKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fast.FastReLoginActivityKt;
import tv.danmaku.bili.quick.ui.LoginQuickActivityV2;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.loginv2.LoginActivityV2;
import tv.danmaku.bili.ui.loginv2.LoginOriginalActivityV2;

/* compiled from: RouteUtil.kt */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u001au\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u0019\u001am\u0010\u001a\u001a\u00020\u001b2\b\u0010\r\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u001c\u001aG\u0010\u001d\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007¢\u0006\u0002\u0010 \u001au\u0010!\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010#\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010$\u001am\u0010%\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007¢\u0006\u0002\u0010&\u001a\u009b\u0001\u0010%\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010+\u001aH\u0010,\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010.\u001a\u00020\u000f2\b\u0010/\u001a\u0004\u0018\u000100H\u0007\u001aA\u00101\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u00102\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u00104\u001a\u00020\u000fH\u0007¢\u0006\u0002\u00105\u001a-\u00106\u001a\u00020\u001b2\b\u00102\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u00107\u001a-\u00108\u001a\u00020\u001b2\b\u00102\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u00107\u001a\u0012\u00109\u001a\u0004\u0018\u00010\u001b2\b\u0010:\u001a\u0004\u0018\u00010;\u001a\u000e\u0010<\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"LOGIN_ROUTE", "", "LOGIN_ORIGIN_ROUTE", "LOGIN_QUICK_ROUTE", "LOGIN_FAST_ROUTE", "LOGIN_SMS_DIALOG", "LOGIN_SMS_EXP_DIALOG", "LOGIN_SMS_EXP_PAGE", "LOGIN_ROUTE_TAG", "routeToLoginActivity", "", "context", "Landroid/content/Context;", LoginQuickActivityV2.INTENT_KEY_OUT_ROUTE, "enableSms", "", "enableQuick", LoginQuickActivityV2.INTENT_KEY_SMS_DIRECT, "promptScene", "mRouteFrom", "flags", "", "noFastLogin", "extras", "Landroid/os/Bundle;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLandroid/os/Bundle;)V", "toLoginActivityRequest", "Lcom/bilibili/lib/blrouter/RouteRequest;", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLandroid/os/Bundle;)Lcom/bilibili/lib/blrouter/RouteRequest;", "routeToLoginOriginActivity", "ctx", "smsEnable", "(Landroid/content/Context;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Landroid/os/Bundle;)V", "routeToLoginOriginActivityV2", LoginQuickActivityV2.INTENT_KEY_LOGIN_EXPERIMENT, "smsExp", "(Landroid/content/Context;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Z)V", "routeToLoginQuickActivity", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Landroid/os/Bundle;)V", "loginQuickGuide", "skipTime", "", LoginQuickActivityV2.INTENT_KEY_LOGIN_EXPERIMENT_VALUE, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Landroid/os/Bundle;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;)V", "routeFastReLoginDialog", "routeFrom", "inDialogManager", "showAccount", "Lcom/bilibili/lib/accounts/model/SimpleAccountItem;", "showSmsLoginDialog", "from", "skipCheck", "exp", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Z)V", "getSmsLoginDialogRequest", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/bilibili/lib/blrouter/RouteRequest;", "getSmsExpLoginDialogRequest", "getForwardRequest", "intent", "Landroid/content/Intent;", "hasCardAndOnlyWifi", "accountui_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RouteUtilKt {
    public static final String LOGIN_FAST_ROUTE = "bilibili://login/fast";
    public static final String LOGIN_ORIGIN_ROUTE = "bilibili://login/origin";
    public static final String LOGIN_QUICK_ROUTE = "bilibili://login/quick";
    public static final String LOGIN_ROUTE = "bilibili://login";
    public static final String LOGIN_ROUTE_TAG = "LoginRouteUtils";
    public static final String LOGIN_SMS_DIALOG = "bilibili://main/login/sms/dialog";
    public static final String LOGIN_SMS_EXP_DIALOG = "bilibili://login/step_by_step/bottom_sheet";
    public static final String LOGIN_SMS_EXP_PAGE = "bilibili://login/step_by_step/sms";

    public static final void routeFastReLoginDialog(Context context, SimpleAccountItem simpleAccountItem) {
        Intrinsics.checkNotNullParameter(context, "context");
        routeFastReLoginDialog$default(context, null, null, null, false, simpleAccountItem, 30, null);
    }

    public static final void routeFastReLoginDialog(Context context, String str, SimpleAccountItem simpleAccountItem) {
        Intrinsics.checkNotNullParameter(context, "context");
        routeFastReLoginDialog$default(context, str, null, null, false, simpleAccountItem, 28, null);
    }

    public static final void routeFastReLoginDialog(Context context, String str, String str2, Bundle bundle, SimpleAccountItem simpleAccountItem) {
        Intrinsics.checkNotNullParameter(context, "context");
        routeFastReLoginDialog$default(context, str, str2, bundle, false, simpleAccountItem, 16, null);
    }

    public static final void routeFastReLoginDialog(Context context, String str, String str2, SimpleAccountItem simpleAccountItem) {
        Intrinsics.checkNotNullParameter(context, "context");
        routeFastReLoginDialog$default(context, str, str2, null, false, simpleAccountItem, 24, null);
    }

    public static final void routeToLoginOriginActivity(Context context) {
        routeToLoginOriginActivity$default(context, null, null, null, null, 30, null);
    }

    public static final void routeToLoginOriginActivity(Context context, Boolean bool) {
        routeToLoginOriginActivity$default(context, bool, null, null, null, 28, null);
    }

    public static final void routeToLoginOriginActivity(Context context, Boolean bool, Boolean bool2) {
        routeToLoginOriginActivity$default(context, bool, bool2, null, null, 24, null);
    }

    public static final void routeToLoginOriginActivity(Context context, Boolean bool, Boolean bool2, Integer num) {
        routeToLoginOriginActivity$default(context, bool, bool2, num, null, 16, null);
    }

    public static final void routeToLoginOriginActivityV2(Context context) {
        routeToLoginOriginActivityV2$default(context, null, null, null, null, null, null, null, false, BR.roleName, null);
    }

    public static final void routeToLoginOriginActivityV2(Context context, Boolean bool) {
        routeToLoginOriginActivityV2$default(context, bool, null, null, null, null, null, null, false, BR.roleList, null);
    }

    public static final void routeToLoginOriginActivityV2(Context context, Boolean bool, Boolean bool2) {
        routeToLoginOriginActivityV2$default(context, bool, bool2, null, null, null, null, null, false, BR.rightText, null);
    }

    public static final void routeToLoginOriginActivityV2(Context context, Boolean bool, Boolean bool2, Integer num) {
        routeToLoginOriginActivityV2$default(context, bool, bool2, num, null, null, null, null, false, BR.rightBottomBadgeUrl, null);
    }

    public static final void routeToLoginOriginActivityV2(Context context, Boolean bool, Boolean bool2, Integer num, Bundle bundle) {
        routeToLoginOriginActivityV2$default(context, bool, bool2, num, bundle, null, null, null, false, BR.reportVo, null);
    }

    public static final void routeToLoginOriginActivityV2(Context context, Boolean bool, Boolean bool2, Integer num, Bundle bundle, String str) {
        routeToLoginOriginActivityV2$default(context, bool, bool2, num, bundle, str, null, null, false, BR.playingVideo, null);
    }

    public static final void routeToLoginOriginActivityV2(Context context, Boolean bool, Boolean bool2, Integer num, Bundle bundle, String str, String str2) {
        routeToLoginOriginActivityV2$default(context, bool, bool2, num, bundle, str, str2, null, false, BR.negativeBtnVisible, null);
    }

    public static final void routeToLoginOriginActivityV2(Context context, Boolean bool, Boolean bool2, Integer num, Bundle bundle, String str, String str2, Boolean bool3) {
        routeToLoginOriginActivityV2$default(context, bool, bool2, num, bundle, str, str2, bool3, false, BR.hallEnterHotText, null);
    }

    public static final void routeToLoginQuickActivity(Context context, String str, Boolean bool, Boolean bool2, Boolean bool3) {
        Intrinsics.checkNotNullParameter(context, "context");
        routeToLoginQuickActivity$default(context, str, bool, bool2, bool3, null, null, null, null, BR.reportVo, null);
    }

    public static final void routeToLoginQuickActivity(Context context, String str, Boolean bool, Boolean bool2, Boolean bool3, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        routeToLoginQuickActivity$default(context, str, bool, bool2, bool3, str2, null, null, null, BR.playingVideo, null);
    }

    public static final void routeToLoginQuickActivity(Context context, String str, Boolean bool, Boolean bool2, Boolean bool3, String str2, String str3) {
        Intrinsics.checkNotNullParameter(context, "context");
        routeToLoginQuickActivity$default(context, str, bool, bool2, bool3, str2, str3, null, null, BR.negativeBtnVisible, null);
    }

    public static final void routeToLoginQuickActivity(Context context, String str, Boolean bool, Boolean bool2, Boolean bool3, String str2, String str3, Integer num) {
        Intrinsics.checkNotNullParameter(context, "context");
        routeToLoginQuickActivity$default(context, str, bool, bool2, bool3, str2, str3, num, null, BR.hallEnterHotText, null);
    }

    public static final void showSmsLoginDialog(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        showSmsLoginDialog$default(context, str, null, null, false, 28, null);
    }

    public static final void showSmsLoginDialog(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        showSmsLoginDialog$default(context, str, str2, null, false, 24, null);
    }

    public static final void showSmsLoginDialog(Context context, String str, String str2, Boolean bool) {
        Intrinsics.checkNotNullParameter(context, "context");
        showSmsLoginDialog$default(context, str, str2, bool, false, 16, null);
    }

    public static final void routeToLoginActivity(Context context, final String outRoute, final Boolean enableSms, final Boolean enableQuick, final Boolean smsDirect, final String promptScene, final String mRouteFrom, Integer flags, final boolean noFastLogin, final Bundle extras) {
        Intrinsics.checkNotNullParameter(context, "context");
        RouteRequest.Builder request = RouteRequestKt.toRouteRequest("bilibili://login").newBuilder().extras(new Function1() { // from class: tv.danmaku.bili.normal.ui.RouteUtilKt$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit routeToLoginActivity$lambda$0;
                routeToLoginActivity$lambda$0 = RouteUtilKt.routeToLoginActivity$lambda$0(outRoute, enableSms, enableQuick, promptScene, noFastLogin, extras, smsDirect, mRouteFrom, (MutableBundleLike) obj);
                return routeToLoginActivity$lambda$0;
            }
        });
        if (flags != null) {
            int it = flags.intValue();
            request.setFlags(it);
        }
        BLRouter.routeTo(request.build(), context);
    }

    public static final Unit routeToLoginActivity$lambda$0(String $outRoute, Boolean $enableSms, Boolean $enableQuick, String $promptScene, boolean $noFastLogin, Bundle $extras, Boolean $smsDirect, String $mRouteFrom, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        if ($outRoute != null) {
            $this$extras.put(LoginQuickActivityV2.INTENT_KEY_OUT_ROUTE, $outRoute);
        }
        if ($enableSms != null) {
            boolean it = $enableSms.booleanValue();
            $this$extras.put("smsEnable", String.valueOf(it));
        }
        if ($enableQuick != null) {
            boolean it2 = $enableQuick.booleanValue();
            $this$extras.put("quickEnable", String.valueOf(it2));
        }
        if ($promptScene != null) {
            $this$extras.put(LoginOriginalActivityV2.KEY_PROMPT_SCENE, $promptScene);
        }
        $this$extras.put(LoginActivityV2.LOGIN_SKIP_FAST_LOGIN, $noFastLogin ? "1" : "0");
        if ($extras != null) {
            String str = BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE;
            Intrinsics.checkNotNullExpressionValue(str, "KEY_DEFAULT_EXTRA_BUNDLE");
            $this$extras.put(str, $extras);
        }
        if ($smsDirect != null) {
            boolean it3 = $smsDirect.booleanValue();
            $this$extras.put(LoginQuickActivityV2.INTENT_KEY_SMS_DIRECT, String.valueOf(it3));
        }
        if ($mRouteFrom != null) {
            $this$extras.put(LoginOriginalActivityV2.KEY_ROUTER_FROM, $mRouteFrom);
        }
        return Unit.INSTANCE;
    }

    public static final RouteRequest toLoginActivityRequest(final String outRoute, final Boolean enableSms, final Boolean enableQuick, final Boolean smsDirect, final String promptScene, final String mRouteFrom, Integer flags, final boolean noFastLogin, final Bundle extras) {
        RouteRequest.Builder request = RouteRequestKt.toRouteRequest("bilibili://login").newBuilder().extras(new Function1() { // from class: tv.danmaku.bili.normal.ui.RouteUtilKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit loginActivityRequest$lambda$0;
                loginActivityRequest$lambda$0 = RouteUtilKt.toLoginActivityRequest$lambda$0(outRoute, enableSms, enableQuick, promptScene, noFastLogin, extras, smsDirect, mRouteFrom, (MutableBundleLike) obj);
                return loginActivityRequest$lambda$0;
            }
        });
        if (flags != null) {
            int it = flags.intValue();
            request.setFlags(it);
        }
        return request.build();
    }

    public static final Unit toLoginActivityRequest$lambda$0(String $outRoute, Boolean $enableSms, Boolean $enableQuick, String $promptScene, boolean $noFastLogin, Bundle $extras, Boolean $smsDirect, String $mRouteFrom, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        if ($outRoute != null) {
            $this$extras.put(LoginQuickActivityV2.INTENT_KEY_OUT_ROUTE, $outRoute);
        }
        if ($enableSms != null) {
            boolean it = $enableSms.booleanValue();
            $this$extras.put("smsEnable", String.valueOf(it));
        }
        if ($enableQuick != null) {
            boolean it2 = $enableQuick.booleanValue();
            $this$extras.put("quickEnable", String.valueOf(it2));
        }
        if ($promptScene != null) {
            $this$extras.put(LoginOriginalActivityV2.KEY_PROMPT_SCENE, $promptScene);
        }
        $this$extras.put(LoginActivityV2.LOGIN_SKIP_FAST_LOGIN, $noFastLogin ? "1" : "0");
        if ($extras != null) {
            String str = BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE;
            Intrinsics.checkNotNullExpressionValue(str, "KEY_DEFAULT_EXTRA_BUNDLE");
            $this$extras.put(str, $extras);
        }
        if ($smsDirect != null) {
            boolean it3 = $smsDirect.booleanValue();
            $this$extras.put(LoginQuickActivityV2.INTENT_KEY_SMS_DIRECT, String.valueOf(it3));
        }
        if ($mRouteFrom != null) {
            $this$extras.put(LoginOriginalActivityV2.KEY_ROUTER_FROM, $mRouteFrom);
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void routeToLoginOriginActivity$default(Context context, Boolean bool, Boolean bool2, Integer num, Bundle bundle, int i, Object obj) {
        if ((i & 2) != 0) {
            bool = false;
        }
        if ((i & 4) != 0) {
            bool2 = false;
        }
        if ((i & 8) != 0) {
            num = null;
        }
        if ((i & 16) != 0) {
            bundle = null;
        }
        routeToLoginOriginActivity(context, bool, bool2, num, bundle);
    }

    public static final void routeToLoginOriginActivity(Context ctx, final Boolean smsEnable, final Boolean smsDirect, Integer flags, final Bundle extras) {
        RouteRequest.Builder request = RouteRequestKt.toRouteRequest("bilibili://login/origin").newBuilder().extras(new Function1() { // from class: tv.danmaku.bili.normal.ui.RouteUtilKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit routeToLoginOriginActivity$lambda$0;
                routeToLoginOriginActivity$lambda$0 = RouteUtilKt.routeToLoginOriginActivity$lambda$0(smsEnable, smsDirect, extras, (MutableBundleLike) obj);
                return routeToLoginOriginActivity$lambda$0;
            }
        });
        if (flags != null) {
            int it = flags.intValue();
            request.setFlags(it);
        }
        BLRouter.routeTo(request.build(), ctx);
    }

    public static final Unit routeToLoginOriginActivity$lambda$0(Boolean $smsEnable, Boolean $smsDirect, Bundle $extras, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        if ($smsEnable != null) {
            $smsEnable.booleanValue();
            $this$extras.put(LoginOriginalActivityV2.KEY_SMS_LOGIN_ENABLE, String.valueOf($smsEnable.booleanValue()));
        }
        if ($smsDirect != null) {
            $smsDirect.booleanValue();
            $this$extras.put(LoginOriginalActivityV2.KEY_SMS_LOGIN_DIRECT, String.valueOf($smsDirect.booleanValue()));
        }
        if ($extras != null) {
            String str = BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE;
            Intrinsics.checkNotNullExpressionValue(str, "KEY_DEFAULT_EXTRA_BUNDLE");
            $this$extras.put(str, $extras);
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void routeToLoginOriginActivityV2$default(Context context, Boolean bool, Boolean bool2, Integer num, Bundle bundle, String str, String str2, Boolean bool3, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            bool = false;
        }
        if ((i & 4) != 0) {
            bool2 = false;
        }
        if ((i & 8) != 0) {
            num = null;
        }
        if ((i & 16) != 0) {
            bundle = null;
        }
        if ((i & 32) != 0) {
            str = null;
        }
        if ((i & 64) != 0) {
            str2 = null;
        }
        if ((i & BR.cover) != 0) {
            bool3 = false;
        }
        if ((i & BR.hallEnterHotText) != 0) {
            z = false;
        }
        routeToLoginOriginActivityV2(context, bool, bool2, num, bundle, str, str2, bool3, z);
    }

    public static final void routeToLoginOriginActivityV2(Context ctx, Boolean smsEnable, Boolean smsDirect, Integer flags, Bundle extras, String promptScene, String mRouteFrom, Boolean loginExperiment, boolean smsExp) {
        if (ctx == null) {
            return;
        }
        showSmsLoginDialog$default(ctx, mRouteFrom, promptScene, true, false, 16, null);
    }

    public static /* synthetic */ void routeToLoginQuickActivity$default(Context context, String str, Boolean bool, Boolean bool2, Boolean bool3, String str2, String str3, Integer num, Bundle bundle, int i, Object obj) {
        routeToLoginQuickActivity(context, str, bool, bool2, bool3, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : str3, (i & BR.cover) != 0 ? null : num, (i & BR.hallEnterHotText) != 0 ? null : bundle);
    }

    public static final void routeToLoginQuickActivity(Context context, String outRoute, Boolean enableSms, Boolean enableQuick, Boolean smsDirect, String promptScene, String mRouteFrom, Integer flags, Bundle extras) {
        Intrinsics.checkNotNullParameter(context, "context");
        routeToLoginQuickActivity$default(context, outRoute, enableSms, enableQuick, smsDirect, promptScene, mRouteFrom, flags, extras, null, null, null, null, 6144, null);
    }

    public static /* synthetic */ void routeToLoginQuickActivity$default(Context context, String str, Boolean bool, Boolean bool2, Boolean bool3, String str2, String str3, Integer num, Bundle bundle, Boolean bool4, Long l, Boolean bool5, String str4, int i, Object obj) {
        routeToLoginQuickActivity(context, str, bool, bool2, bool3, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : str3, (i & BR.cover) != 0 ? null : num, (i & BR.hallEnterHotText) != 0 ? null : bundle, (i & BR.roleType) != 0 ? false : bool4, (i & MisakaHelper.MAX_REPORT_SIZE) != 0 ? 0L : l, (i & 2048) != 0 ? false : bool5, (i & 4096) != 0 ? null : str4);
    }

    public static final void routeToLoginQuickActivity(Context context, final String outRoute, final Boolean enableSms, final Boolean enableQuick, final Boolean smsDirect, final String promptScene, final String mRouteFrom, Integer flags, final Bundle extras, final Boolean loginQuickGuide, final Long skipTime, final Boolean loginExperiment, final String loginExperimentValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        RouteRequest.Builder request = RouteRequestKt.toRouteRequest(LOGIN_QUICK_ROUTE).newBuilder().extras(new Function1() { // from class: tv.danmaku.bili.normal.ui.RouteUtilKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit routeToLoginQuickActivity$lambda$0;
                routeToLoginQuickActivity$lambda$0 = RouteUtilKt.routeToLoginQuickActivity$lambda$0(outRoute, enableSms, enableQuick, promptScene, extras, smsDirect, loginQuickGuide, skipTime, mRouteFrom, loginExperiment, loginExperimentValue, (MutableBundleLike) obj);
                return routeToLoginQuickActivity$lambda$0;
            }
        });
        if (flags != null) {
            int it = flags.intValue();
            request.setFlags(it);
        }
        BLRouter.routeTo(request.build(), context);
    }

    public static final Unit routeToLoginQuickActivity$lambda$0(String $outRoute, Boolean $enableSms, Boolean $enableQuick, String $promptScene, Bundle $extras, Boolean $smsDirect, Boolean $loginQuickGuide, Long $skipTime, String $mRouteFrom, Boolean $loginExperiment, String $loginExperimentValue, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        if ($outRoute != null) {
            $this$extras.put(LoginQuickActivityV2.INTENT_KEY_OUT_ROUTE, $outRoute);
        }
        if ($enableSms != null) {
            boolean it = $enableSms.booleanValue();
            $this$extras.put("smsEnable", String.valueOf(it));
        }
        if ($enableQuick != null) {
            boolean it2 = $enableQuick.booleanValue();
            $this$extras.put("quickEnable", String.valueOf(it2));
        }
        if ($promptScene != null) {
            $this$extras.put(LoginOriginalActivityV2.KEY_PROMPT_SCENE, $promptScene);
        }
        if ($extras != null) {
            String str = BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE;
            Intrinsics.checkNotNullExpressionValue(str, "KEY_DEFAULT_EXTRA_BUNDLE");
            $this$extras.put(str, $extras);
        }
        if ($smsDirect != null) {
            boolean it3 = $smsDirect.booleanValue();
            $this$extras.put(LoginQuickActivityV2.INTENT_KEY_SMS_DIRECT, String.valueOf(it3));
        }
        if ($loginQuickGuide != null) {
            $loginQuickGuide.booleanValue();
            $this$extras.put(LoginQuickActivityV2.INTENT_KEY_LOGIN_GUIDE_ENABLE, String.valueOf($loginQuickGuide.booleanValue()));
        }
        if ($skipTime != null) {
            $skipTime.longValue();
            $this$extras.put(LoginQuickActivityV2.INTENT_KEY_LOGIN_GUIDE_SKIP_TIME, String.valueOf($skipTime.longValue()));
        }
        if ($mRouteFrom != null) {
            $this$extras.put(LoginOriginalActivityV2.KEY_ROUTER_FROM, $mRouteFrom);
        }
        if ($loginExperiment != null) {
            boolean it4 = $loginExperiment.booleanValue();
            $this$extras.put(LoginQuickActivityV2.INTENT_KEY_LOGIN_EXPERIMENT, String.valueOf(it4));
        }
        if ($loginExperimentValue != null) {
            $this$extras.put(LoginQuickActivityV2.INTENT_KEY_LOGIN_EXPERIMENT_VALUE, $loginExperimentValue.toString());
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void routeFastReLoginDialog$default(Context context, String str, String str2, Bundle bundle, boolean z, SimpleAccountItem simpleAccountItem, int i, Object obj) {
        routeFastReLoginDialog(context, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : bundle, (i & 16) != 0 ? false : z, simpleAccountItem);
    }

    public static final void routeFastReLoginDialog(Context context, final String promptScene, final String routeFrom, final Bundle extras, final boolean inDialogManager, final SimpleAccountItem showAccount) {
        Intrinsics.checkNotNullParameter(context, "context");
        BLog.i(LOGIN_ROUTE_TAG, "Attempt to show fast login dialog, account " + showAccount);
        if (showAccount == null) {
            routeToLoginQuickActivity(context, null, true, true, true, promptScene, routeFrom, 33554432, extras);
            return;
        }
        RouteRequest request = new RouteRequest.Builder(LOGIN_FAST_ROUTE).extras(new Function1() { // from class: tv.danmaku.bili.normal.ui.RouteUtilKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit routeFastReLoginDialog$lambda$0;
                routeFastReLoginDialog$lambda$0 = RouteUtilKt.routeFastReLoginDialog$lambda$0(promptScene, extras, routeFrom, inDialogManager, showAccount, (MutableBundleLike) obj);
                return routeFastReLoginDialog$lambda$0;
            }
        }).flags(33554432).build();
        BLRouter.routeTo(request, context);
    }

    public static final Unit routeFastReLoginDialog$lambda$0(String $promptScene, Bundle $extras, String $routeFrom, boolean $inDialogManager, SimpleAccountItem $showAccount, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        if ($promptScene != null) {
            $this$extras.put(LoginOriginalActivityV2.KEY_PROMPT_SCENE, $promptScene);
        }
        Bundle bundle = $extras == null ? new Bundle() : $extras;
        bundle.putParcelable(FastReLoginActivityKt.KEY_ACCOUNT, (Parcelable) $showAccount);
        String str = BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE;
        Intrinsics.checkNotNullExpressionValue(str, "KEY_DEFAULT_EXTRA_BUNDLE");
        $this$extras.put(str, bundle);
        if ($routeFrom != null) {
            $this$extras.put(LoginOriginalActivityV2.KEY_ROUTER_FROM, $routeFrom);
        }
        if ($inDialogManager) {
            $this$extras.put(FastReLoginActivityKt.KEY_IN_DIALOG_MANAGER, "1");
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void showSmsLoginDialog$default(Context context, String str, String str2, Boolean bool, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            bool = null;
        }
        if ((i & 16) != 0) {
            z = false;
        }
        showSmsLoginDialog(context, str, str2, bool, z);
    }

    public static final void showSmsLoginDialog(Context context, String from, String promptScene, Boolean skipCheck, boolean exp) {
        Intrinsics.checkNotNullParameter(context, "context");
        RouteRequest request = getSmsLoginDialogRequest(from, promptScene, skipCheck);
        BLRouter.routeTo(request, context);
    }

    public static /* synthetic */ RouteRequest getSmsLoginDialogRequest$default(String str, String str2, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        return getSmsLoginDialogRequest(str, str2, bool);
    }

    public static final RouteRequest getSmsLoginDialogRequest(final String from, final String promptScene, final Boolean skipCheck) {
        return RouteRequestKt.toRouteRequest(LOGIN_SMS_DIALOG).newBuilder().extras(new Function1() { // from class: tv.danmaku.bili.normal.ui.RouteUtilKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit smsLoginDialogRequest$lambda$0;
                smsLoginDialogRequest$lambda$0 = RouteUtilKt.getSmsLoginDialogRequest$lambda$0(from, promptScene, skipCheck, (MutableBundleLike) obj);
                return smsLoginDialogRequest$lambda$0;
            }
        }).build();
    }

    public static final Unit getSmsLoginDialogRequest$lambda$0(String $from, String $promptScene, Boolean $skipCheck, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        if ($from != null) {
            $this$extras.put("from", $from);
        }
        if ($promptScene != null) {
            $this$extras.put(LoginOriginalActivityV2.KEY_PROMPT_SCENE, $promptScene);
        }
        if ($skipCheck != null) {
            boolean it = $skipCheck.booleanValue();
            $this$extras.put("skip_check", it ? "1" : "0");
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ RouteRequest getSmsExpLoginDialogRequest$default(String str, String str2, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        return getSmsExpLoginDialogRequest(str, str2, bool);
    }

    public static final RouteRequest getSmsExpLoginDialogRequest(final String from, final String promptScene, final Boolean skipCheck) {
        return RouteRequestKt.toRouteRequest(LOGIN_SMS_EXP_DIALOG).newBuilder().extras(new Function1() { // from class: tv.danmaku.bili.normal.ui.RouteUtilKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit smsExpLoginDialogRequest$lambda$0;
                smsExpLoginDialogRequest$lambda$0 = RouteUtilKt.getSmsExpLoginDialogRequest$lambda$0(from, promptScene, skipCheck, (MutableBundleLike) obj);
                return smsExpLoginDialogRequest$lambda$0;
            }
        }).build();
    }

    public static final Unit getSmsExpLoginDialogRequest$lambda$0(String $from, String $promptScene, Boolean $skipCheck, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        if ($from != null) {
            $this$extras.put("from", $from);
        }
        if ($promptScene != null) {
            $this$extras.put(LoginOriginalActivityV2.KEY_PROMPT_SCENE, $promptScene);
        }
        if ($skipCheck != null) {
            boolean it = $skipCheck.booleanValue();
            $this$extras.put("skip_check", it ? "1" : "0");
        }
        return Unit.INSTANCE;
    }

    public static final RouteRequest getForwardRequest(Intent intent) {
        Bundle extras;
        Bundle it;
        RouteRequest $this$getForwardRequest_u24lambda_u241_u240;
        RouteRequest $this$getForwardRequest_u24lambda_u240;
        if (intent == null || ($this$getForwardRequest_u24lambda_u240 = intent.getParcelableExtra("blrouter.forward")) == null) {
            if (intent != null && (extras = intent.getExtras()) != null && (it = extras.getBundle(BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE)) != null && ($this$getForwardRequest_u24lambda_u241_u240 = it.getParcelable("blrouter.forward")) != null) {
                return $this$getForwardRequest_u24lambda_u241_u240;
            }
            return null;
        }
        return $this$getForwardRequest_u24lambda_u240;
    }

    public static final boolean hasCardAndOnlyWifi(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return CollectionsKt.listOf(new String[]{"中国移动", "中国联通", "中国电信"}).contains(PhoneUtils.getSimOperatorByMnc(context)) && PhoneUtils.netType(context) == 2;
    }
}