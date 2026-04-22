package tv.danmaku.bili.ui.login.helper;

import android.app.Activity;
import com.bilibili.lib.accounts.utils.AutoLoginHelper;
import com.bilibili.lib.accounts.utils.LoginCheckFailed;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.core.OnePassLoginReportManagerKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: QuickLoginHelper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/ui/login/helper/PegasusAutoLogin;", "Lcom/bilibili/lib/accounts/utils/AutoLoginHelper;", "<init>", "()V", "tryLogin", "", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@Named("pegasus")
public final class PegasusAutoLogin implements AutoLoginHelper {
    public static final int $stable = 0;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object tryLogin(Activity activity, Continuation<? super Unit> continuation) {
        PegasusAutoLogin$tryLogin$1 pegasusAutoLogin$tryLogin$1;
        Activity activity2;
        QuickLoginHelper helper;
        String fromSpmid;
        Object goLogin;
        boolean result;
        if (continuation instanceof PegasusAutoLogin$tryLogin$1) {
            pegasusAutoLogin$tryLogin$1 = (PegasusAutoLogin$tryLogin$1) continuation;
            if ((pegasusAutoLogin$tryLogin$1.label & Integer.MIN_VALUE) != 0) {
                pegasusAutoLogin$tryLogin$1.label -= Integer.MIN_VALUE;
                Object $result = pegasusAutoLogin$tryLogin$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (pegasusAutoLogin$tryLogin$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        activity2 = activity;
                        helper = new QuickLoginHelper(QuickLoginHelperKt.defaultReducerMap());
                        fromSpmid = OnePassLoginReportManagerKt.SPM_ID_INTEREST_SELECT;
                        pegasusAutoLogin$tryLogin$1.L$0 = activity2;
                        pegasusAutoLogin$tryLogin$1.L$1 = helper;
                        pegasusAutoLogin$tryLogin$1.L$2 = OnePassLoginReportManagerKt.SPM_ID_INTEREST_SELECT;
                        pegasusAutoLogin$tryLogin$1.label = 1;
                        if (helper.doCheck(OnePassLoginReportManagerKt.SPM_ID_INTEREST_SELECT, activity2, pegasusAutoLogin$tryLogin$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        pegasusAutoLogin$tryLogin$1.L$0 = null;
                        pegasusAutoLogin$tryLogin$1.L$1 = null;
                        pegasusAutoLogin$tryLogin$1.L$2 = null;
                        pegasusAutoLogin$tryLogin$1.label = 2;
                        goLogin = helper.goLogin(activity2, fromSpmid, 2050, pegasusAutoLogin$tryLogin$1);
                        if (goLogin == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        result = ((Boolean) goLogin).booleanValue();
                        if (!result) {
                            throw new LoginCheckFailed((String) null);
                        }
                        return Unit.INSTANCE;
                    case 1:
                        fromSpmid = (String) pegasusAutoLogin$tryLogin$1.L$2;
                        helper = (QuickLoginHelper) pegasusAutoLogin$tryLogin$1.L$1;
                        activity2 = (Activity) pegasusAutoLogin$tryLogin$1.L$0;
                        ResultKt.throwOnFailure($result);
                        pegasusAutoLogin$tryLogin$1.L$0 = null;
                        pegasusAutoLogin$tryLogin$1.L$1 = null;
                        pegasusAutoLogin$tryLogin$1.L$2 = null;
                        pegasusAutoLogin$tryLogin$1.label = 2;
                        goLogin = helper.goLogin(activity2, fromSpmid, 2050, pegasusAutoLogin$tryLogin$1);
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
        pegasusAutoLogin$tryLogin$1 = new PegasusAutoLogin$tryLogin$1(this, continuation);
        Object $result2 = pegasusAutoLogin$tryLogin$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (pegasusAutoLogin$tryLogin$1.label) {
        }
    }
}