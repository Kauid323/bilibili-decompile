package tv.danmaku.bili.distributable;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.droid.PhoneUtils;
import com.bilibili.lib.accounts.model.TInfoLogin;
import com.bilibili.lib.accountsui.quick.LoginQuickManager;
import com.bilibili.lib.accountsui.quick.QuickLoginTag;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.route.LoginPageType;
import tv.danmaku.bili.fullscreen.route.LoginTypeRuleKt;
import tv.danmaku.bili.fullscreen.route.ValidLoginType;
import tv.danmaku.bili.fullscreen.service.IspCode;
import tv.danmaku.bili.fullscreen.service.PhoneInfo;
import tv.danmaku.bili.fullscreen.service.PhoneServiceKt;
import tv.danmaku.bili.fullscreen.service.TechTrackServiceImplKt;
import tv.danmaku.bili.quick.core.LoginRuleProcessor;
import tv.danmaku.bili.quick.core.OnePassLoginPathLinkManager;
import tv.danmaku.bili.quick.core.OnePassLoginPhaseType;
import tv.danmaku.bili.quick.core.OnePassLoginPhoneData;
import tv.danmaku.bili.quick.core.OnePassLoginReportManagerKt;
import tv.danmaku.bili.report.LoginReportHelper;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: DistributableLogin.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a4\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0086@¢\u0006\u0002\u0010\n\u001a(\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0001H\u0082@¢\u0006\u0002\u0010\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"TAG", "", "tryDistributableStartupLogin", "", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "loginBlock", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Landroidx/fragment/app/FragmentActivity;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkQuickLogin", "Ltv/danmaku/bili/fullscreen/service/PhoneInfo;", "infoLogin", "Lcom/bilibili/lib/accounts/model/TInfoLogin;", FavoritesConstsKt.SPMID, "(Landroidx/fragment/app/FragmentActivity;Lcom/bilibili/lib/accounts/model/TInfoLogin;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accountui_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DistributableLoginKt {
    private static final String TAG = "DistributableLogin";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0139 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0182 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object tryDistributableStartupLogin(FragmentActivity activity, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        Continuation<? super RouteRequest> distributableLoginKt$tryDistributableStartupLogin$1;
        Object suspendGetLoginType$default;
        FragmentActivity activity2;
        Function1 loginBlock;
        String spmid;
        TInfoLogin loginType;
        String str;
        LoginPageType loginPageType;
        PhoneInfo phoneInfo;
        Object checkQuickLogin;
        TInfoLogin.Guide guide;
        FragmentActivity activity3;
        Object buildLoginRequest;
        if (continuation instanceof DistributableLoginKt$tryDistributableStartupLogin$1) {
            distributableLoginKt$tryDistributableStartupLogin$1 = (DistributableLoginKt$tryDistributableStartupLogin$1) continuation;
            if ((distributableLoginKt$tryDistributableStartupLogin$1.label & Integer.MIN_VALUE) != 0) {
                distributableLoginKt$tryDistributableStartupLogin$1.label -= Integer.MIN_VALUE;
                Object $result = distributableLoginKt$tryDistributableStartupLogin$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (distributableLoginKt$tryDistributableStartupLogin$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        OnePassLoginPathLinkManager.INSTANCE.onPhase("app.active.fst-startup.0", OnePassLoginPhaseType.Trigger.INSTANCE);
                        LoginRuleProcessor loginRuleProcessor = LoginRuleProcessor.INSTANCE;
                        distributableLoginKt$tryDistributableStartupLogin$1.L$0 = activity;
                        distributableLoginKt$tryDistributableStartupLogin$1.L$1 = function1;
                        distributableLoginKt$tryDistributableStartupLogin$1.L$2 = "app.active.fst-startup.0";
                        distributableLoginKt$tryDistributableStartupLogin$1.label = 1;
                        suspendGetLoginType$default = LoginRuleProcessor.suspendGetLoginType$default(loginRuleProcessor, false, true, distributableLoginKt$tryDistributableStartupLogin$1, 1, null);
                        if (suspendGetLoginType$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        activity2 = activity;
                        loginBlock = function1;
                        spmid = "app.active.fst-startup.0";
                        loginType = (TInfoLogin) ((Pair) suspendGetLoginType$default).getSecond();
                        str = (loginType != null || (guide = loginType.guide) == null) ? null : guide.loginStyle;
                        if (str != null) {
                            switch (str.hashCode()) {
                                case -1677116865:
                                    if (str.equals("full_page")) {
                                        loginPageType = LoginPageType.PhoneOnePassFullscreen;
                                        break;
                                    }
                                    break;
                                case -3226379:
                                    if (str.equals("classical_na")) {
                                        loginPageType = LoginPageType.SmsLoginPage;
                                        break;
                                    }
                                    break;
                                case 1654640726:
                                    if (str.equals("login_popup")) {
                                        loginPageType = LoginPageType.QuickLoginDialog;
                                        break;
                                    }
                                    break;
                            }
                            if (loginPageType != null || loginType == null) {
                                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(spmid, OnePassLoginReportManagerKt.INTERRUPTED_FOR_FAILED_TO_GET_LOGIN_INFO);
                                return Unit.INSTANCE;
                            } else if (loginPageType.getType() == ValidLoginType.QuickLogin) {
                                distributableLoginKt$tryDistributableStartupLogin$1.L$0 = activity2;
                                distributableLoginKt$tryDistributableStartupLogin$1.L$1 = loginBlock;
                                distributableLoginKt$tryDistributableStartupLogin$1.L$2 = spmid;
                                distributableLoginKt$tryDistributableStartupLogin$1.L$3 = loginType;
                                distributableLoginKt$tryDistributableStartupLogin$1.L$4 = loginPageType;
                                distributableLoginKt$tryDistributableStartupLogin$1.label = 2;
                                checkQuickLogin = checkQuickLogin(activity2, loginType, spmid, distributableLoginKt$tryDistributableStartupLogin$1);
                                if (checkQuickLogin == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                phoneInfo = (PhoneInfo) checkQuickLogin;
                                if (phoneInfo == null) {
                                    return Unit.INSTANCE;
                                }
                                LoginReportHelper.INSTANCE.setFromSpmid(spmid);
                                distributableLoginKt$tryDistributableStartupLogin$1.L$0 = activity2;
                                distributableLoginKt$tryDistributableStartupLogin$1.L$1 = spmid;
                                distributableLoginKt$tryDistributableStartupLogin$1.L$2 = loginType;
                                distributableLoginKt$tryDistributableStartupLogin$1.L$3 = loginPageType;
                                distributableLoginKt$tryDistributableStartupLogin$1.L$4 = phoneInfo;
                                distributableLoginKt$tryDistributableStartupLogin$1.label = 3;
                                if (loginBlock.invoke(distributableLoginKt$tryDistributableStartupLogin$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                activity3 = activity2;
                                Context context = (Context) activity3;
                                List<ValidLoginType> loginTypeList = LoginTypeRuleKt.getLoginTypeList(loginType);
                                Bundle $this$tryDistributableStartupLogin_u24lambda_u240 = new Bundle();
                                if (phoneInfo != null) {
                                    $this$tryDistributableStartupLogin_u24lambda_u240.putParcelable(PhoneServiceKt.KEY_QUICK_LOGIN_PHONE_SERVICE, new PhoneInfoProvider(phoneInfo));
                                    $this$tryDistributableStartupLogin_u24lambda_u240.putParcelable(TechTrackServiceImplKt.KEY_LOGIN_TECH_TRACK_SERVICE, new PrivateTechTrackService());
                                }
                                Unit unit = Unit.INSTANCE;
                                distributableLoginKt$tryDistributableStartupLogin$1.L$0 = activity3;
                                distributableLoginKt$tryDistributableStartupLogin$1.L$1 = null;
                                distributableLoginKt$tryDistributableStartupLogin$1.L$2 = null;
                                distributableLoginKt$tryDistributableStartupLogin$1.L$3 = null;
                                distributableLoginKt$tryDistributableStartupLogin$1.L$4 = null;
                                distributableLoginKt$tryDistributableStartupLogin$1.label = 4;
                                buildLoginRequest = loginPageType.buildLoginRequest(context, spmid, loginTypeList, $this$tryDistributableStartupLogin_u24lambda_u240, distributableLoginKt$tryDistributableStartupLogin$1);
                                if (buildLoginRequest == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                BLRouter.routeTo((RouteRequest) buildLoginRequest, (Context) activity3);
                                return Unit.INSTANCE;
                            } else {
                                phoneInfo = null;
                                LoginReportHelper.INSTANCE.setFromSpmid(spmid);
                                distributableLoginKt$tryDistributableStartupLogin$1.L$0 = activity2;
                                distributableLoginKt$tryDistributableStartupLogin$1.L$1 = spmid;
                                distributableLoginKt$tryDistributableStartupLogin$1.L$2 = loginType;
                                distributableLoginKt$tryDistributableStartupLogin$1.L$3 = loginPageType;
                                distributableLoginKt$tryDistributableStartupLogin$1.L$4 = phoneInfo;
                                distributableLoginKt$tryDistributableStartupLogin$1.label = 3;
                                if (loginBlock.invoke(distributableLoginKt$tryDistributableStartupLogin$1) == coroutine_suspended) {
                                }
                            }
                        }
                        loginPageType = null;
                        if (loginPageType != null) {
                        }
                        OnePassLoginPathLinkManager.INSTANCE.stopWithReason(spmid, OnePassLoginReportManagerKt.INTERRUPTED_FOR_FAILED_TO_GET_LOGIN_INFO);
                        return Unit.INSTANCE;
                    case 1:
                        String spmid2 = (String) distributableLoginKt$tryDistributableStartupLogin$1.L$2;
                        Function1 loginBlock2 = (Function1) distributableLoginKt$tryDistributableStartupLogin$1.L$1;
                        ResultKt.throwOnFailure($result);
                        loginBlock = loginBlock2;
                        activity2 = (FragmentActivity) distributableLoginKt$tryDistributableStartupLogin$1.L$0;
                        spmid = spmid2;
                        suspendGetLoginType$default = $result;
                        loginType = (TInfoLogin) ((Pair) suspendGetLoginType$default).getSecond();
                        if (loginType != null) {
                            break;
                        }
                        if (str != null) {
                        }
                        loginPageType = null;
                        if (loginPageType != null) {
                        }
                        OnePassLoginPathLinkManager.INSTANCE.stopWithReason(spmid, OnePassLoginReportManagerKt.INTERRUPTED_FOR_FAILED_TO_GET_LOGIN_INFO);
                        return Unit.INSTANCE;
                    case 2:
                        loginPageType = (LoginPageType) distributableLoginKt$tryDistributableStartupLogin$1.L$4;
                        loginType = (TInfoLogin) distributableLoginKt$tryDistributableStartupLogin$1.L$3;
                        spmid = (String) distributableLoginKt$tryDistributableStartupLogin$1.L$2;
                        loginBlock = (Function1) distributableLoginKt$tryDistributableStartupLogin$1.L$1;
                        activity2 = (FragmentActivity) distributableLoginKt$tryDistributableStartupLogin$1.L$0;
                        ResultKt.throwOnFailure($result);
                        checkQuickLogin = $result;
                        phoneInfo = (PhoneInfo) checkQuickLogin;
                        if (phoneInfo == null) {
                        }
                        LoginReportHelper.INSTANCE.setFromSpmid(spmid);
                        distributableLoginKt$tryDistributableStartupLogin$1.L$0 = activity2;
                        distributableLoginKt$tryDistributableStartupLogin$1.L$1 = spmid;
                        distributableLoginKt$tryDistributableStartupLogin$1.L$2 = loginType;
                        distributableLoginKt$tryDistributableStartupLogin$1.L$3 = loginPageType;
                        distributableLoginKt$tryDistributableStartupLogin$1.L$4 = phoneInfo;
                        distributableLoginKt$tryDistributableStartupLogin$1.label = 3;
                        if (loginBlock.invoke(distributableLoginKt$tryDistributableStartupLogin$1) == coroutine_suspended) {
                        }
                        break;
                    case 3:
                        PhoneInfo phoneInfo2 = (PhoneInfo) distributableLoginKt$tryDistributableStartupLogin$1.L$4;
                        LoginPageType loginPageType2 = (LoginPageType) distributableLoginKt$tryDistributableStartupLogin$1.L$3;
                        String spmid3 = (String) distributableLoginKt$tryDistributableStartupLogin$1.L$1;
                        ResultKt.throwOnFailure($result);
                        phoneInfo = phoneInfo2;
                        loginPageType = loginPageType2;
                        loginType = (TInfoLogin) distributableLoginKt$tryDistributableStartupLogin$1.L$2;
                        spmid = spmid3;
                        activity3 = (FragmentActivity) distributableLoginKt$tryDistributableStartupLogin$1.L$0;
                        Context context2 = (Context) activity3;
                        List<ValidLoginType> loginTypeList2 = LoginTypeRuleKt.getLoginTypeList(loginType);
                        Bundle $this$tryDistributableStartupLogin_u24lambda_u2402 = new Bundle();
                        if (phoneInfo != null) {
                        }
                        Unit unit2 = Unit.INSTANCE;
                        distributableLoginKt$tryDistributableStartupLogin$1.L$0 = activity3;
                        distributableLoginKt$tryDistributableStartupLogin$1.L$1 = null;
                        distributableLoginKt$tryDistributableStartupLogin$1.L$2 = null;
                        distributableLoginKt$tryDistributableStartupLogin$1.L$3 = null;
                        distributableLoginKt$tryDistributableStartupLogin$1.L$4 = null;
                        distributableLoginKt$tryDistributableStartupLogin$1.label = 4;
                        buildLoginRequest = loginPageType.buildLoginRequest(context2, spmid, loginTypeList2, $this$tryDistributableStartupLogin_u24lambda_u2402, distributableLoginKt$tryDistributableStartupLogin$1);
                        if (buildLoginRequest == coroutine_suspended) {
                        }
                        BLRouter.routeTo((RouteRequest) buildLoginRequest, (Context) activity3);
                        return Unit.INSTANCE;
                    case 4:
                        ResultKt.throwOnFailure($result);
                        activity3 = (FragmentActivity) distributableLoginKt$tryDistributableStartupLogin$1.L$0;
                        buildLoginRequest = $result;
                        BLRouter.routeTo((RouteRequest) buildLoginRequest, (Context) activity3);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        distributableLoginKt$tryDistributableStartupLogin$1 = new DistributableLoginKt$tryDistributableStartupLogin$1(continuation);
        Object $result2 = distributableLoginKt$tryDistributableStartupLogin$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (distributableLoginKt$tryDistributableStartupLogin$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object checkQuickLogin(final FragmentActivity activity, TInfoLogin infoLogin, String spmid, Continuation<? super PhoneInfo> continuation) {
        DistributableLoginKt$checkQuickLogin$1 distributableLoginKt$checkQuickLogin$1;
        Object suspendGetPhoneInfo;
        Integer code;
        LoginQuickManager.PhoneInfoBean phoneInfo;
        String resultCode;
        String securityPhone;
        if (continuation instanceof DistributableLoginKt$checkQuickLogin$1) {
            distributableLoginKt$checkQuickLogin$1 = (DistributableLoginKt$checkQuickLogin$1) continuation;
            if ((distributableLoginKt$checkQuickLogin$1.label & Integer.MIN_VALUE) != 0) {
                distributableLoginKt$checkQuickLogin$1.label -= Integer.MIN_VALUE;
                Object $result = distributableLoginKt$checkQuickLogin$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (distributableLoginKt$checkQuickLogin$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (!infoLogin.isQuickLoginOk()) {
                            OnePassLoginPathLinkManager.INSTANCE.stopWithReason(spmid, OnePassLoginReportManagerKt.INTERRUPTED_FOR_THE_LOGIN_WAY_IS_NOT_QUICK_WAY);
                            return null;
                        }
                        final String netTypeString = LoginQuickManager.INSTANCE.getNetType((Context) activity);
                        OnePassLoginPathLinkManager.INSTANCE.updateData(spmid, new Function1() { // from class: tv.danmaku.bili.distributable.DistributableLoginKt$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                OnePassLoginPhoneData checkQuickLogin$lambda$0;
                                checkQuickLogin$lambda$0 = DistributableLoginKt.checkQuickLogin$lambda$0(netTypeString, activity, (OnePassLoginPhoneData) obj);
                                return checkQuickLogin$lambda$0;
                            }
                        });
                        OnePassLoginPathLinkManager.INSTANCE.onPhase(spmid, OnePassLoginPhaseType.CheckConditions.INSTANCE);
                        LoginQuickManager loginQuickManager = LoginQuickManager.INSTANCE;
                        TInfoLogin.QuickBean quickBean = infoLogin.login.quick;
                        Intrinsics.checkNotNullExpressionValue(quickBean, "quick");
                        if (!loginQuickManager.isNetOk(netTypeString, quickBean)) {
                            OnePassLoginPathLinkManager.INSTANCE.stopWithReason(spmid, OnePassLoginReportManagerKt.INTERRUPTED_FOR_OPERATOR_DISALLOW);
                            return null;
                        }
                        QuickLoginTag quickLoginTag = QuickLoginTag.MAIN;
                        distributableLoginKt$checkQuickLogin$1.L$0 = spmid;
                        distributableLoginKt$checkQuickLogin$1.label = 1;
                        suspendGetPhoneInfo = LoginQuickManager.INSTANCE.suspendGetPhoneInfo((Context) activity, quickLoginTag, distributableLoginKt$checkQuickLogin$1);
                        if (suspendGetPhoneInfo == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        spmid = (String) distributableLoginKt$checkQuickLogin$1.L$0;
                        suspendGetPhoneInfo = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Pair pair = (Pair) suspendGetPhoneInfo;
                code = (Integer) pair.component1();
                phoneInfo = (LoginQuickManager.PhoneInfoBean) pair.component2();
                if (code == null || code.intValue() != 1 || phoneInfo == null) {
                    OnePassLoginPathLinkManager.INSTANCE.stopWithReason(spmid, "get phone info with error : " + (phoneInfo == null ? phoneInfo.getMsg() : null));
                    return null;
                }
                OnePassLoginPathLinkManager.INSTANCE.onPhase(spmid, OnePassLoginPhaseType.GetNumberSuc.INSTANCE);
                resultCode = phoneInfo.getResultCode();
                if (resultCode == null) {
                    resultCode = "";
                }
                securityPhone = phoneInfo.getSecurityPhone();
                if (securityPhone == null) {
                    securityPhone = "";
                }
                String msg = phoneInfo.getMsg();
                return new PhoneInfo(resultCode, securityPhone, msg != null ? msg : "", IspCode.Companion.getIspCode());
            }
        }
        distributableLoginKt$checkQuickLogin$1 = new DistributableLoginKt$checkQuickLogin$1(continuation);
        Object $result2 = distributableLoginKt$checkQuickLogin$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (distributableLoginKt$checkQuickLogin$1.label) {
        }
        Pair pair2 = (Pair) suspendGetPhoneInfo;
        code = (Integer) pair2.component1();
        phoneInfo = (LoginQuickManager.PhoneInfoBean) pair2.component2();
        if (code == null) {
            OnePassLoginPathLinkManager.INSTANCE.onPhase(spmid, OnePassLoginPhaseType.GetNumberSuc.INSTANCE);
            resultCode = phoneInfo.getResultCode();
            if (resultCode == null) {
            }
            securityPhone = phoneInfo.getSecurityPhone();
            if (securityPhone == null) {
            }
            String msg2 = phoneInfo.getMsg();
            return new PhoneInfo(resultCode, securityPhone, msg2 != null ? msg2 : "", IspCode.Companion.getIspCode());
        }
        OnePassLoginPathLinkManager.INSTANCE.stopWithReason(spmid, "get phone info with error : " + (phoneInfo == null ? phoneInfo.getMsg() : null));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OnePassLoginPhoneData checkQuickLogin$lambda$0(String $netTypeString, FragmentActivity $activity, OnePassLoginPhoneData it) {
        return new OnePassLoginPhoneData($netTypeString, PhoneUtils.getOriginSimOperator((Context) $activity) != null, PhoneUtils.isPad((Context) $activity));
    }
}