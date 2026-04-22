package tv.danmaku.bili.ui.login.helper.reducer;

import android.content.Context;
import com.bilibili.lib.accounts.model.TInfoLogin;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.core.OnePassLoginPathLinkManager;
import tv.danmaku.bili.ui.login.helper.AutoLoginCheckResult;
import tv.danmaku.bili.ui.login.helper.AutoLoginData;
import tv.danmaku.bili.ui.login.helper.QuickLoginCheckReducer;

/* compiled from: ExperimentCheckReducer.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B.\u0012%\b\u0002\u0010\u0002\u001a\u001f\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0003¢\u0006\u0002\b\b¢\u0006\u0004\b\t\u0010\nJ&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012R+\u0010\u0002\u001a\u001f\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0003¢\u0006\u0002\b\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/ui/login/helper/reducer/ExperimentCheckReducer;", "Ltv/danmaku/bili/ui/login/helper/QuickLoginCheckReducer;", "exp", "Lkotlin/Function1;", "Lcom/bilibili/lib/accounts/model/TInfoLogin$AB;", "Lkotlin/Pair;", "", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "check", "Ltv/danmaku/bili/ui/login/helper/AutoLoginCheckResult;", "context", "Landroid/content/Context;", "fromSpmid", "data", "Ltv/danmaku/bili/ui/login/helper/AutoLoginData;", "(Landroid/content/Context;Ljava/lang/String;Ltv/danmaku/bili/ui/login/helper/AutoLoginData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ExperimentCheckReducer implements QuickLoginCheckReducer {
    public static final int $stable = 0;
    private final Function1<TInfoLogin.AB, Pair<Boolean, String>> exp;

    public ExperimentCheckReducer() {
        this(null, 1, null);
    }

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

    public ExperimentCheckReducer(Function1<? super TInfoLogin.AB, Pair<Boolean, String>> function1) {
        Intrinsics.checkNotNullParameter(function1, "exp");
        this.exp = function1;
    }

    public /* synthetic */ ExperimentCheckReducer(Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function1() { // from class: tv.danmaku.bili.ui.login.helper.reducer.ExperimentCheckReducer$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Pair _init_$lambda$0;
                _init_$lambda$0 = ExperimentCheckReducer._init_$lambda$0((TInfoLogin.AB) obj);
                return _init_$lambda$0;
            }
        } : function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair _init_$lambda$0(TInfoLogin.AB ab) {
        Intrinsics.checkNotNullParameter(ab, "<this>");
        return TuplesKt.to(true, "");
    }

    @Override // tv.danmaku.bili.ui.login.helper.QuickLoginCheckReducer
    public Object check(Context context, String fromSpmid, AutoLoginData data, Continuation<? super AutoLoginCheckResult> continuation) {
        TInfoLogin.AB ab;
        TInfoLogin loginInfo = data.getLoginInfo();
        Pair expResult = (loginInfo == null || (ab = loginInfo.ab) == null) ? null : (Pair) this.exp.invoke(ab);
        boolean goOn = false;
        if (expResult != null && ((Boolean) expResult.getFirst()).booleanValue()) {
            goOn = true;
        }
        if (!goOn) {
            OnePassLoginPathLinkManager.INSTANCE.stopWithReason(fromSpmid, "hit the login experiment : " + (expResult != null ? (String) expResult.getSecond() : null));
        }
        return new AutoLoginCheckResult(data, goOn);
    }
}