package tv.danmaku.bili.ui.login.helper.reducer;

import android.content.Context;
import com.bilibili.lib.accountsui.quick.LoginQuickManager;
import com.bilibili.lib.accountsui.quick.QuickLoginTag;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.LoginQualityMonitor;
import tv.danmaku.bili.quick.core.OnePassLoginPathLinkManager;
import tv.danmaku.bili.quick.core.OnePassLoginPhaseType;
import tv.danmaku.bili.ui.login.helper.AutoLoginCheckResult;
import tv.danmaku.bili.ui.login.helper.AutoLoginData;
import tv.danmaku.bili.ui.login.helper.LoginWay;
import tv.danmaku.bili.ui.login.helper.QuickLoginCheckReducer;
import tv.danmaku.bili.ui.login.helper.Skip;

/* compiled from: PhoneInfoCheckReducer.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\f\u0010\rJ&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\rJ\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/ui/login/helper/reducer/PhoneInfoCheckReducer;", "Ltv/danmaku/bili/ui/login/helper/QuickLoginCheckReducer;", "<init>", "()V", "beforeCheck", "Ltv/danmaku/bili/ui/login/helper/Skip;", "context", "Landroid/content/Context;", "fromSpmid", "", "data", "Ltv/danmaku/bili/ui/login/helper/AutoLoginData;", "beforeCheck-5k-lyPk", "(Landroid/content/Context;Ljava/lang/String;Ltv/danmaku/bili/ui/login/helper/AutoLoginData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "check", "Ltv/danmaku/bili/ui/login/helper/AutoLoginCheckResult;", "afterCheck", "", "result", "(Ljava/lang/String;Ltv/danmaku/bili/ui/login/helper/AutoLoginCheckResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PhoneInfoCheckReducer implements QuickLoginCheckReducer {
    public static final int $stable = 0;

    @Override // tv.danmaku.bili.ui.login.helper.QuickLoginCheckReducer
    public /* synthetic */ String getTAG() {
        return QuickLoginCheckReducer.CC.$default$getTAG(this);
    }

    @Override // tv.danmaku.bili.ui.login.helper.QuickLoginCheckReducer
    /* renamed from: beforeCheck-5k-lyPk */
    public Object mo1802beforeCheck5klyPk(Context context, String fromSpmid, AutoLoginData data, Continuation<? super Skip> continuation) {
        LoginWay loginWay = data.getLoginWay();
        return Skip.m1805boximpl(!(loginWay != null && loginWay.getQuick()) ? Skip.m1806constructorimpl(true) : Skip.m1806constructorimpl(false));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d2  */
    @Override // tv.danmaku.bili.ui.login.helper.QuickLoginCheckReducer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object check(Context context, String str, AutoLoginData data, Continuation<? super AutoLoginCheckResult> continuation) {
        PhoneInfoCheckReducer$check$1 phoneInfoCheckReducer$check$1;
        String fromSpmid;
        Object suspendGetPhoneInfo;
        AutoLoginData data2;
        Integer result;
        LoginWay this_$iv;
        LoginWay loginWay;
        if (continuation instanceof PhoneInfoCheckReducer$check$1) {
            phoneInfoCheckReducer$check$1 = (PhoneInfoCheckReducer$check$1) continuation;
            if ((phoneInfoCheckReducer$check$1.label & Integer.MIN_VALUE) != 0) {
                phoneInfoCheckReducer$check$1.label -= Integer.MIN_VALUE;
                Object $result = phoneInfoCheckReducer$check$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (phoneInfoCheckReducer$check$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        fromSpmid = str;
                        LoginQuickManager loginQuickManager = LoginQuickManager.INSTANCE;
                        QuickLoginTag quickLoginTag = QuickLoginTag.MAIN;
                        phoneInfoCheckReducer$check$1.L$0 = fromSpmid;
                        phoneInfoCheckReducer$check$1.L$1 = data;
                        phoneInfoCheckReducer$check$1.label = 1;
                        suspendGetPhoneInfo = loginQuickManager.suspendGetPhoneInfo(context, quickLoginTag, phoneInfoCheckReducer$check$1);
                        if (suspendGetPhoneInfo == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        data2 = data;
                        break;
                    case 1:
                        fromSpmid = (String) phoneInfoCheckReducer$check$1.L$0;
                        ResultKt.throwOnFailure($result);
                        suspendGetPhoneInfo = $result;
                        data2 = (AutoLoginData) phoneInfoCheckReducer$check$1.L$1;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Pair pair = (Pair) suspendGetPhoneInfo;
                result = (Integer) pair.getFirst();
                LoginQuickManager.PhoneInfoBean phoneInfo = (LoginQuickManager.PhoneInfoBean) pair.getSecond();
                this_$iv = data2.getLoginWay();
                if (this_$iv != null) {
                    loginWay = null;
                } else {
                    loginWay = ((result != null && result.intValue() == 1) ? 0 : 1) != 0 ? LoginWay.copy$default(this_$iv, 0, false, false, 5, null) : this_$iv;
                }
                if (result == null || result.intValue() != 1) {
                    OnePassLoginPathLinkManager.INSTANCE.stopWithReason(fromSpmid, "get phone info with error : " + (phoneInfo == null ? phoneInfo.getMsg() : null));
                } else {
                    OnePassLoginPathLinkManager.INSTANCE.onPhase(fromSpmid, OnePassLoginPhaseType.GetNumberSuc.INSTANCE);
                }
                return new AutoLoginCheckResult(AutoLoginData.copy$default(data2, null, loginWay, phoneInfo, null, result == null || result.intValue() != 1, 9, null), false, 2, null);
            }
        }
        phoneInfoCheckReducer$check$1 = new PhoneInfoCheckReducer$check$1(this, continuation);
        Object $result2 = phoneInfoCheckReducer$check$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (phoneInfoCheckReducer$check$1.label) {
        }
        Pair pair2 = (Pair) suspendGetPhoneInfo;
        result = (Integer) pair2.getFirst();
        LoginQuickManager.PhoneInfoBean phoneInfo2 = (LoginQuickManager.PhoneInfoBean) pair2.getSecond();
        this_$iv = data2.getLoginWay();
        if (this_$iv != null) {
        }
        if (result == null) {
            OnePassLoginPathLinkManager.INSTANCE.onPhase(fromSpmid, OnePassLoginPhaseType.GetNumberSuc.INSTANCE);
            if (result == null) {
                return new AutoLoginCheckResult(AutoLoginData.copy$default(data2, null, loginWay, phoneInfo2, null, result == null || result.intValue() != 1, 9, null), false, 2, null);
            }
            return new AutoLoginCheckResult(AutoLoginData.copy$default(data2, null, loginWay, phoneInfo2, null, result == null || result.intValue() != 1, 9, null), false, 2, null);
        }
        OnePassLoginPathLinkManager.INSTANCE.stopWithReason(fromSpmid, "get phone info with error : " + (phoneInfo2 == null ? phoneInfo2.getMsg() : null));
        return new AutoLoginCheckResult(AutoLoginData.copy$default(data2, null, loginWay, phoneInfo2, null, result == null || result.intValue() != 1, 9, null), false, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
    @Override // tv.danmaku.bili.ui.login.helper.QuickLoginCheckReducer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object afterCheck(String fromSpmid, AutoLoginCheckResult result, Continuation<? super Unit> continuation) {
        PhoneInfoCheckReducer$afterCheck$1 phoneInfoCheckReducer$afterCheck$1;
        Object afterCheck$suspendImpl;
        AutoLoginCheckResult result2;
        LoginQuickManager.PhoneInfoBean phoneInfo;
        if (continuation instanceof PhoneInfoCheckReducer$afterCheck$1) {
            phoneInfoCheckReducer$afterCheck$1 = (PhoneInfoCheckReducer$afterCheck$1) continuation;
            if ((phoneInfoCheckReducer$afterCheck$1.label & Integer.MIN_VALUE) != 0) {
                phoneInfoCheckReducer$afterCheck$1.label -= Integer.MIN_VALUE;
                Object $result = phoneInfoCheckReducer$afterCheck$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (phoneInfoCheckReducer$afterCheck$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        phoneInfoCheckReducer$afterCheck$1.L$0 = result;
                        phoneInfoCheckReducer$afterCheck$1.label = 1;
                        afterCheck$suspendImpl = QuickLoginCheckReducer.CC.afterCheck$suspendImpl(this, fromSpmid, result, phoneInfoCheckReducer$afterCheck$1);
                        if (afterCheck$suspendImpl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        result2 = result;
                        break;
                    case 1:
                        result2 = (AutoLoginCheckResult) phoneInfoCheckReducer$afterCheck$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                phoneInfo = result2.getData().getPhoneInfo();
                if (phoneInfo == null) {
                    LoginQualityMonitor.INSTANCE.report("3", phoneInfo.getResultCode(), LoginQualityMonitor.INSTANCE.endMarkSpendTime(), phoneInfo.getSecurityPhone());
                } else {
                    LoginQualityMonitor.report$default(LoginQualityMonitor.INSTANCE, "3", LoginQualityMonitor.OTHER_RESULT_CODE_MOBILE_API_ERROR, LoginQualityMonitor.INSTANCE.endMarkSpendTime(), null, 8, null);
                }
                return Unit.INSTANCE;
            }
        }
        phoneInfoCheckReducer$afterCheck$1 = new PhoneInfoCheckReducer$afterCheck$1(this, continuation);
        Object $result2 = phoneInfoCheckReducer$afterCheck$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (phoneInfoCheckReducer$afterCheck$1.label) {
        }
        phoneInfo = result2.getData().getPhoneInfo();
        if (phoneInfo == null) {
        }
        return Unit.INSTANCE;
    }
}