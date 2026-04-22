package tv.danmaku.bili.ui.login.helper;

import android.app.Activity;
import com.bilibili.lib.accounts.model.TInfoLogin;
import com.bilibili.lib.accounts.utils.AutoLoginHelper;
import com.bilibili.lib.accounts.utils.LoginCheckFailed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.core.OnePassLoginPathLinkManager;
import tv.danmaku.bili.quick.core.OnePassLoginReportManagerKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.login.helper.reducer.ExperimentCheckReducer;

/* compiled from: QuickLoginHelper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/ui/login/helper/HistoryAutoLogin;", "Lcom/bilibili/lib/accounts/utils/AutoLoginHelper;", "<init>", "()V", "tryLogin", "", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@Named("history")
public final class HistoryAutoLogin implements AutoLoginHelper {
    public static final int $stable = 0;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object tryLogin(Activity activity, Continuation<? super Unit> continuation) {
        HistoryAutoLogin$tryLogin$1 historyAutoLogin$tryLogin$1;
        Activity activity2;
        String spmId;
        QuickLoginHelper helper;
        Object goLogin;
        boolean result;
        if (continuation instanceof HistoryAutoLogin$tryLogin$1) {
            historyAutoLogin$tryLogin$1 = (HistoryAutoLogin$tryLogin$1) continuation;
            if ((historyAutoLogin$tryLogin$1.label & Integer.MIN_VALUE) != 0) {
                historyAutoLogin$tryLogin$1.label -= Integer.MIN_VALUE;
                Object $result = historyAutoLogin$tryLogin$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (historyAutoLogin$tryLogin$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        activity2 = activity;
                        spmId = OnePassLoginReportManagerKt.SPM_ID_MY_HISTORY;
                        OnePassLoginPathLinkManager.onPhase$default(OnePassLoginPathLinkManager.INSTANCE, OnePassLoginReportManagerKt.SPM_ID_MY_HISTORY, null, 2, null);
                        Iterable $this$map$iv = QuickLoginHelperKt.defaultReducerMap();
                        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        for (Object item$iv$iv : $this$map$iv) {
                            QuickLoginCheckReducer it = (QuickLoginCheckReducer) item$iv$iv;
                            if (it instanceof ExperimentCheckReducer) {
                                it = new ExperimentCheckReducer(new Function1() { // from class: tv.danmaku.bili.ui.login.helper.HistoryAutoLogin$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj) {
                                        Pair tryLogin$lambda$0$0;
                                        tryLogin$lambda$0$0 = HistoryAutoLogin.tryLogin$lambda$0$0((TInfoLogin.AB) obj);
                                        return tryLogin$lambda$0$0;
                                    }
                                });
                            }
                            destination$iv$iv.add(it);
                        }
                        List defaultReducer = (List) destination$iv$iv;
                        helper = new QuickLoginHelper(defaultReducer);
                        historyAutoLogin$tryLogin$1.L$0 = activity2;
                        historyAutoLogin$tryLogin$1.L$1 = OnePassLoginReportManagerKt.SPM_ID_MY_HISTORY;
                        historyAutoLogin$tryLogin$1.L$2 = helper;
                        historyAutoLogin$tryLogin$1.label = 1;
                        if (helper.doCheck(OnePassLoginReportManagerKt.SPM_ID_MY_HISTORY, activity2, historyAutoLogin$tryLogin$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        historyAutoLogin$tryLogin$1.L$0 = null;
                        historyAutoLogin$tryLogin$1.L$1 = null;
                        historyAutoLogin$tryLogin$1.L$2 = null;
                        historyAutoLogin$tryLogin$1.label = 2;
                        goLogin = helper.goLogin(activity2, spmId, 2111, historyAutoLogin$tryLogin$1);
                        if (goLogin == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        result = ((Boolean) goLogin).booleanValue();
                        if (!result) {
                            throw new LoginCheckFailed((String) null);
                        }
                        return Unit.INSTANCE;
                    case 1:
                        helper = (QuickLoginHelper) historyAutoLogin$tryLogin$1.L$2;
                        spmId = (String) historyAutoLogin$tryLogin$1.L$1;
                        activity2 = (Activity) historyAutoLogin$tryLogin$1.L$0;
                        ResultKt.throwOnFailure($result);
                        historyAutoLogin$tryLogin$1.L$0 = null;
                        historyAutoLogin$tryLogin$1.L$1 = null;
                        historyAutoLogin$tryLogin$1.L$2 = null;
                        historyAutoLogin$tryLogin$1.label = 2;
                        goLogin = helper.goLogin(activity2, spmId, 2111, historyAutoLogin$tryLogin$1);
                        if (goLogin == coroutine_suspended) {
                        }
                        result = ((Boolean) goLogin).booleanValue();
                        if (!result) {
                        }
                        break;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        goLogin = $result;
                        result = ((Boolean) goLogin).booleanValue();
                        if (!result) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        historyAutoLogin$tryLogin$1 = new HistoryAutoLogin$tryLogin$1(this, continuation);
        Object $result2 = historyAutoLogin$tryLogin$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (historyAutoLogin$tryLogin$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair tryLogin$lambda$0$0(TInfoLogin.AB $this$ExperimentCheckReducer) {
        Intrinsics.checkNotNullParameter($this$ExperimentCheckReducer, "$this$ExperimentCheckReducer");
        return TuplesKt.to(Boolean.valueOf($this$ExperimentCheckReducer.isLoginAutoPopInHistory()), "dynamic_history_auto_popup = " + $this$ExperimentCheckReducer.dynamicHistoryAutoPopup);
    }
}