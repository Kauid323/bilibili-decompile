package tv.danmaku.bili.ui.loginv2;

import android.content.Context;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.ui.LoginQuickActivityV2;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: LoginAnswerDialogHelper.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0007J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015J$\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u001e\u001a\u00020\u00172\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005J\u000e\u0010 \u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010!\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\"\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010#\u001a\u00020\u0013J\b\u0010$\u001a\u0004\u0018\u00010\rJ\u0006\u0010%\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006&"}, d2 = {"Ltv/danmaku/bili/ui/loginv2/LoginAnswerDialogHelper;", "", "<init>", "()V", "TAG", "", "PREF_KEY_NEED_SHOW_ANSWER_DIALOG_FOR_LOGIN", "PREF_KEY_ANSWER_DIALOG_FROM", "PREF_KEY_ANSWER_DIALOG_SPMID", "PREF_KEY_ANSWER_DIALOG_LOGIN_EXPERIMENT", "PREF_KEY_ANSWER_DIALOG_LOGIN_EXPERIMENT_VALUE", "PREF_KEY_ANSWER_DIALOG_LOGIN_EXPERIMENT_VALUE_A2", "countDownLatch", "Ljava/util/concurrent/CountDownLatch;", "getCountDownLatch", "()Ljava/util/concurrent/CountDownLatch;", "setCountDownLatch", "(Ljava/util/concurrent/CountDownLatch;)V", "setNeedShowAnswerDialog", "", "context", "Landroid/content/Context;", "needShow", "", "from", FavoritesConstsKt.SPMID, "needShowAnswerDialog", "getAnswerDialogFrom", "getAnswerDialogSpmid", "setAnswerDialogLoginExperimentParam", "fromExperiment", LoginQuickActivityV2.INTENT_KEY_LOGIN_EXPERIMENT_VALUE, "getAnswerDialogLoginExperiment", "getAnswerDialogLoginExperimentValue", "answerDialogLoginExperimentValueA1", "newLoginCountDownLaunch", "getLoginCountDownLaunch", "clearLoginCountDownLaunch", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginAnswerDialogHelper {
    private static final String PREF_KEY_ANSWER_DIALOG_FROM = "pref_key_answer_dialog_from";
    private static final String PREF_KEY_ANSWER_DIALOG_LOGIN_EXPERIMENT = "pref_key_answer_login_experiment";
    private static final String PREF_KEY_ANSWER_DIALOG_LOGIN_EXPERIMENT_VALUE = "pref_key_answer_login_experiment_value";
    private static final String PREF_KEY_ANSWER_DIALOG_LOGIN_EXPERIMENT_VALUE_A2 = "A2";
    private static final String PREF_KEY_ANSWER_DIALOG_SPMID = "pref_key_answer_dialog_spmid";
    private static final String PREF_KEY_NEED_SHOW_ANSWER_DIALOG_FOR_LOGIN = "pref_key_answer_dialog_need_show_for_login";
    private static final String TAG = "LoginAnswerDialogHelper";
    private static CountDownLatch countDownLatch;
    public static final LoginAnswerDialogHelper INSTANCE = new LoginAnswerDialogHelper();
    public static final int $stable = 8;

    public final void setNeedShowAnswerDialog(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        setNeedShowAnswerDialog$default(this, context, z, null, null, 12, null);
    }

    public final void setNeedShowAnswerDialog(Context context, boolean z, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        setNeedShowAnswerDialog$default(this, context, z, str, null, 8, null);
    }

    private LoginAnswerDialogHelper() {
    }

    public final CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public final void setCountDownLatch(CountDownLatch countDownLatch2) {
        countDownLatch = countDownLatch2;
    }

    public static /* synthetic */ void setNeedShowAnswerDialog$default(LoginAnswerDialogHelper loginAnswerDialogHelper, Context context, boolean z, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        loginAnswerDialogHelper.setNeedShowAnswerDialog(context, z, str, str2);
    }

    public final void setNeedShowAnswerDialog(Context context, boolean needShow, String from, String spmid) {
        Intrinsics.checkNotNullParameter(context, "context");
        BLog.i(TAG, "setNeedShowAnswerDialog = " + needShow);
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putBoolean(PREF_KEY_NEED_SHOW_ANSWER_DIALOG_FOR_LOGIN, needShow).putString(PREF_KEY_ANSWER_DIALOG_FROM, from).putString(PREF_KEY_ANSWER_DIALOG_SPMID, spmid).apply();
    }

    public final boolean needShowAnswerDialog(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getBoolean(PREF_KEY_NEED_SHOW_ANSWER_DIALOG_FOR_LOGIN, false);
    }

    public final String getAnswerDialogFrom(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getString(PREF_KEY_ANSWER_DIALOG_FROM, null);
        if (string != null) {
            return string;
        }
        return "";
    }

    public final String getAnswerDialogSpmid(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getString(PREF_KEY_ANSWER_DIALOG_SPMID, null);
        if (string != null) {
            return string;
        }
        return "";
    }

    public static /* synthetic */ void setAnswerDialogLoginExperimentParam$default(LoginAnswerDialogHelper loginAnswerDialogHelper, Context context, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        loginAnswerDialogHelper.setAnswerDialogLoginExperimentParam(context, z, str);
    }

    public final void setAnswerDialogLoginExperimentParam(Context context, boolean fromExperiment, String loginExperimentValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putBoolean(PREF_KEY_ANSWER_DIALOG_LOGIN_EXPERIMENT, fromExperiment).putString(PREF_KEY_ANSWER_DIALOG_LOGIN_EXPERIMENT_VALUE, loginExperimentValue).apply();
    }

    public final boolean getAnswerDialogLoginExperiment(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getBoolean(PREF_KEY_ANSWER_DIALOG_LOGIN_EXPERIMENT, false);
    }

    public final String getAnswerDialogLoginExperimentValue(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getString(PREF_KEY_ANSWER_DIALOG_LOGIN_EXPERIMENT_VALUE, null);
        return string == null ? "" : string;
    }

    public final boolean answerDialogLoginExperimentValueA1(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String value = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getString(PREF_KEY_ANSWER_DIALOG_LOGIN_EXPERIMENT_VALUE, null);
        if (value == null) {
            value = "";
        }
        return StringsKt.equals(value, "A1", true);
    }

    public final void newLoginCountDownLaunch() {
        countDownLatch = new CountDownLatch(1);
    }

    public final CountDownLatch getLoginCountDownLaunch() {
        return countDownLatch;
    }

    public final void clearLoginCountDownLaunch() {
        try {
            CountDownLatch countDownLatch2 = countDownLatch;
            if (countDownLatch2 != null) {
                countDownLatch2.countDown();
            }
        } catch (Exception e) {
        } catch (Throwable th) {
            countDownLatch = null;
            throw th;
        }
        countDownLatch = null;
    }
}