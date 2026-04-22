package tv.danmaku.bili.quick.core;

import android.content.Context;
import com.bilibili.lib.accounts.model.TInfoLogin;
import com.bilibili.module.account.ILoginExperiment;
import com.bilibili.module.account.LoginExperimentHelperKt;
import com.bilibili.module.account.LoginInterestExperiment;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.annotation.AnnotationTarget;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.core.LoginRuleProcessor;

/* compiled from: LoginRuleProcessor.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0004/012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020 H\u0007J2\u0010#\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00050$2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020 H\u0087@¢\u0006\u0002\u0010%J<\u0010&\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00050$2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020 H\u0086@¢\u0006\u0002\u0010'J\u0010\u0010(\u001a\u00020\u000f2\b\b\u0001\u0010)\u001a\u00020\u000fJ$\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010.\u001a\u00020 H\u0007R(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Ltv/danmaku/bili/quick/core/LoginRuleProcessor;", "", "<init>", "()V", "value", "Lcom/bilibili/lib/accounts/model/TInfoLogin;", "mTInfoLogin", "getMTInfoLogin", "()Lcom/bilibili/lib/accounts/model/TInfoLogin;", "setMTInfoLogin", "(Lcom/bilibili/lib/accounts/model/TInfoLogin;)V", "TAG", "", LoginRuleProcessor.PREF_KEY_SCENE_PROMPT, "LOGIN_WAY_QUICK_PWD_SMS", "", "LOGIN_WAY_QUICK_PWD_NO_SMS", "LOGIN_WAY_QUICK_SMS_PWD", "LOGIN_WAY_PWD_SMS", "LOGIN_WAY_PWD_SMS_Q", "LOGIN_WAY_PWD_NO_SMS", "LOGIN_WAY_PWD_NO_SMS_Q", "LOGIN_WAY_SMS_PWD", "LOGIN_WAY_SMS_PWD_Q", "LOGIN_WAY_FAST_RE_LOGIN", "RESULT_SUCCESS", "RESULT_FAIL", "getLoginType", "", "callBack", "Ltv/danmaku/bili/quick/core/LoginRuleProcessor$GetLoginTypeCallBack;", "cacheEnable", "", "asFirstBoot", "switch", "suspendGetLoginType", "Lkotlin/Pair;", "(ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suspendGetLoginTypeForSwitch", "(ZZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "degradeHandle", "loginWay", "parseLoginWay", "context", "Landroid/content/Context;", "tInfoLogin", "skipFastLogin", "RESULT", "LoginQuickWay", "LoginAllWay", "GetLoginTypeCallBack", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginRuleProcessor {
    public static final int LOGIN_WAY_FAST_RE_LOGIN = 10;
    public static final int LOGIN_WAY_PWD_NO_SMS = 6;
    public static final int LOGIN_WAY_PWD_NO_SMS_Q = 7;
    public static final int LOGIN_WAY_PWD_SMS = 4;
    public static final int LOGIN_WAY_PWD_SMS_Q = 5;
    public static final int LOGIN_WAY_QUICK_PWD_NO_SMS = 2;
    public static final int LOGIN_WAY_QUICK_PWD_SMS = 1;
    public static final int LOGIN_WAY_QUICK_SMS_PWD = 3;
    public static final int LOGIN_WAY_SMS_PWD = 8;
    public static final int LOGIN_WAY_SMS_PWD_Q = 9;
    public static final String PREF_KEY_SCENE_PROMPT = "PREF_KEY_SCENE_PROMPT";
    public static final int RESULT_FAIL = 2;
    public static final int RESULT_SUCCESS = 1;
    private static final String TAG = "LoginRuleProcessor";
    private static TInfoLogin mTInfoLogin;
    public static final LoginRuleProcessor INSTANCE = new LoginRuleProcessor();
    public static final int $stable = 8;

    /* compiled from: LoginRuleProcessor.kt */
    @Target({ElementType.PARAMETER})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Ltv/danmaku/bili/quick/core/LoginRuleProcessor$LoginAllWay;", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public @interface LoginAllWay {
    }

    /* compiled from: LoginRuleProcessor.kt */
    @Target({ElementType.PARAMETER})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Ltv/danmaku/bili/quick/core/LoginRuleProcessor$LoginQuickWay;", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public @interface LoginQuickWay {
    }

    /* compiled from: LoginRuleProcessor.kt */
    @Target({ElementType.PARAMETER})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Ltv/danmaku/bili/quick/core/LoginRuleProcessor$RESULT;", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public @interface RESULT {
    }

    public final void getLoginType(GetLoginTypeCallBack getLoginTypeCallBack) {
        getLoginType$default(this, getLoginTypeCallBack, false, false, false, 14, null);
    }

    public final void getLoginType(GetLoginTypeCallBack getLoginTypeCallBack, boolean z) {
        getLoginType$default(this, getLoginTypeCallBack, z, false, false, 12, null);
    }

    public final void getLoginType(GetLoginTypeCallBack getLoginTypeCallBack, boolean z, boolean z2) {
        getLoginType$default(this, getLoginTypeCallBack, z, z2, false, 8, null);
    }

    public final int parseLoginWay(Context context, TInfoLogin tInfoLogin) {
        Intrinsics.checkNotNullParameter(context, "context");
        return parseLoginWay$default(this, context, tInfoLogin, false, 4, null);
    }

    public final Object suspendGetLoginType(Continuation<? super Pair<Integer, ? extends TInfoLogin>> continuation) {
        return suspendGetLoginType$default(this, false, false, continuation, 3, null);
    }

    public final Object suspendGetLoginType(boolean z, Continuation<? super Pair<Integer, ? extends TInfoLogin>> continuation) {
        return suspendGetLoginType$default(this, z, false, continuation, 2, null);
    }

    private LoginRuleProcessor() {
    }

    public final TInfoLogin getMTInfoLogin() {
        return mTInfoLogin;
    }

    public final void setMTInfoLogin(TInfoLogin value) {
        LoginInterestExperiment interestExp;
        mTInfoLogin = value;
        if (value != null) {
            TInfoLogin.AB ab = value.ab;
            boolean z = true;
            if (ab != null && ab.isLoginSkipRecommendationA()) {
                interestExp = LoginInterestExperiment.DismissInterest;
            } else {
                TInfoLogin.AB ab2 = value.ab;
                if (ab2 == null || !ab2.isLoginSkipRecommendationB()) {
                    z = false;
                }
                if (z) {
                    interestExp = LoginInterestExperiment.DismissInterestForOld;
                } else {
                    interestExp = LoginInterestExperiment.Control;
                }
            }
            ILoginExperiment loginExperimentHelper = LoginExperimentHelperKt.getLoginExperimentHelper();
            if (loginExperimentHelper != null) {
                loginExperimentHelper.setInterestDismissFlag(interestExp);
            }
        }
    }

    public static /* synthetic */ void getLoginType$default(LoginRuleProcessor loginRuleProcessor, GetLoginTypeCallBack getLoginTypeCallBack, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        if ((i & 8) != 0) {
            z3 = false;
        }
        loginRuleProcessor.getLoginType(getLoginTypeCallBack, z, z2, z3);
    }

    public final void getLoginType(GetLoginTypeCallBack callBack, boolean cacheEnable, boolean asFirstBoot, boolean z) {
        LoginRuleProcessorV2.INSTANCE.getLoginType(callBack, cacheEnable, asFirstBoot, z);
    }

    public static /* synthetic */ Object suspendGetLoginType$default(LoginRuleProcessor loginRuleProcessor, boolean z, boolean z2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        return loginRuleProcessor.suspendGetLoginType(z, z2, continuation);
    }

    public final Object suspendGetLoginType(boolean cacheEnable, boolean asFirstBoot, Continuation<? super Pair<Integer, ? extends TInfoLogin>> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuation it = cancellableContinuationImpl;
        getLoginType$default(INSTANCE, new GetLoginTypeCallBack() { // from class: tv.danmaku.bili.quick.core.LoginRuleProcessor$suspendGetLoginType$2$1
            @Override // tv.danmaku.bili.quick.core.LoginRuleProcessor.GetLoginTypeCallBack
            public /* synthetic */ void startGetLoginType() {
                LoginRuleProcessor.GetLoginTypeCallBack.CC.$default$startGetLoginType(this);
            }

            @Override // tv.danmaku.bili.quick.core.LoginRuleProcessor.GetLoginTypeCallBack
            public void endGetLoginType(int result, TInfoLogin infoLogin) {
                Result.Companion companion = Result.Companion;
                it.resumeWith(Result.constructor-impl(TuplesKt.to(Integer.valueOf(result), infoLogin)));
            }
        }, cacheEnable, asFirstBoot, false, 8, null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static /* synthetic */ Object suspendGetLoginTypeForSwitch$default(LoginRuleProcessor loginRuleProcessor, boolean z, boolean z2, boolean z3, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        return loginRuleProcessor.suspendGetLoginTypeForSwitch(z, z2, z3, continuation);
    }

    public final Object suspendGetLoginTypeForSwitch(boolean cacheEnable, boolean asFirstBoot, boolean z, Continuation<? super Pair<Integer, ? extends TInfoLogin>> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuation it = cancellableContinuationImpl;
        INSTANCE.getLoginType(new GetLoginTypeCallBack() { // from class: tv.danmaku.bili.quick.core.LoginRuleProcessor$suspendGetLoginTypeForSwitch$2$1
            @Override // tv.danmaku.bili.quick.core.LoginRuleProcessor.GetLoginTypeCallBack
            public /* synthetic */ void startGetLoginType() {
                LoginRuleProcessor.GetLoginTypeCallBack.CC.$default$startGetLoginType(this);
            }

            @Override // tv.danmaku.bili.quick.core.LoginRuleProcessor.GetLoginTypeCallBack
            public void endGetLoginType(int result, TInfoLogin infoLogin) {
                Result.Companion companion = Result.Companion;
                it.resumeWith(Result.constructor-impl(TuplesKt.to(Integer.valueOf(result), infoLogin)));
            }
        }, cacheEnable, asFirstBoot, z);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final int degradeHandle(int loginWay) {
        switch (loginWay) {
            case 1:
            default:
                return 4;
            case 2:
                return 6;
            case 3:
                return 8;
        }
    }

    public static /* synthetic */ int parseLoginWay$default(LoginRuleProcessor loginRuleProcessor, Context context, TInfoLogin tInfoLogin, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return loginRuleProcessor.parseLoginWay(context, tInfoLogin, z);
    }

    public final int parseLoginWay(Context context, TInfoLogin tInfoLogin, boolean skipFastLogin) {
        Intrinsics.checkNotNullParameter(context, "context");
        return LoginRuleProcessorV2.INSTANCE.parseLoginWay(context, tInfoLogin, skipFastLogin);
    }

    /* compiled from: LoginRuleProcessor.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001c\u0010\u0004\u001a\u00020\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/quick/core/LoginRuleProcessor$GetLoginTypeCallBack;", "", "startGetLoginType", "", "endGetLoginType", "result", "", "infoLogin", "Lcom/bilibili/lib/accounts/model/TInfoLogin;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface GetLoginTypeCallBack {
        void endGetLoginType(int i, TInfoLogin tInfoLogin);

        void startGetLoginType();

        /* compiled from: LoginRuleProcessor.kt */
        /* renamed from: tv.danmaku.bili.quick.core.LoginRuleProcessor$GetLoginTypeCallBack$-CC */
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public final /* synthetic */ class CC {
            public static void $default$startGetLoginType(GetLoginTypeCallBack _this) {
            }
        }
    }
}