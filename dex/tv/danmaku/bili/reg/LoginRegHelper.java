package tv.danmaku.bili.reg;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: LoginRegHelper.kt */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003*\u0001\"\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001a\u001a\u00020\u0019J\u001a\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0012\u0010$\u001a\u00020\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010%H\u0007J\u001c\u0010&\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010%2\b\u0010'\u001a\u0004\u0018\u00010 H\u0007J\b\u0010(\u001a\u00020\u0013H\u0007J9\u0010)\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010%2%\b\u0002\u0010*\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u0013\u0018\u00010+H\u0007J\u0012\u0010/\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010%H\u0007J\b\u00100\u001a\u00020\u0013H\u0007J\u0010\u00101\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u0013H\u0007J\u0010\u00102\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0012\u00103\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u00010%H\u0007JL\u00105\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000506j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`72\u0006\u00108\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00052\u0016\b\u0002\u00109\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010:H\u0007J\u001a\u0010;\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010%H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0004\n\u0002\u0010#¨\u0006="}, d2 = {"Ltv/danmaku/bili/reg/LoginRegHelper;", "", "<init>", "()V", "TAG", "", "SWITCH_LOGIN_REG_STATUTE", "SWITCH_LOGIN_REG_INITIALIZE", "KEY_PREF_REG_CHECK_STATUS", "LOGIN_REG_INITIALIZE_VALUE_DEFAULT", "LOGIN_REG_INITIALIZE_VALUE_ANY", "LOGIN_REG_INITIALIZE_VALUE_LOCAL", "countDownLatch", "", "getCountDownLatch", "()I", "setCountDownLatch", "(I)V", "regCheckStatus", "", "getRegCheckStatus", "()Z", "setRegCheckStatus", "(Z)V", "currentLoginReg", "Ltv/danmaku/bili/reg/ILoginReg;", "getLoginRegStrategy", "showRegPopView", "", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", "regPopRunnable", "tv/danmaku/bili/reg/LoginRegHelper$regPopRunnable$1", "Ltv/danmaku/bili/reg/LoginRegHelper$regPopRunnable$1;", "checkViewVisibleAndUnCheck", "Landroid/widget/CheckBox;", "updateRegCheckbox", "container", "isAnyPageLoginReg", "initOnChangeListener", "interrupt", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "isChecked", "clearOnChangeListener", "isLoginRegHasChecked", "saveLoginRegHasCheckStatus", "getProvisionReportValue", "getAgreeReportValue", "checkBox", "getClickReportInfoValue", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "isShow", "hashMap", "", "reportRegCheckboxClick", "eventId", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginRegHelper {
    public static final String KEY_PREF_REG_CHECK_STATUS = "key_pref_reg_check_status";
    public static final String LOGIN_REG_INITIALIZE_VALUE_ANY = "1";
    public static final String LOGIN_REG_INITIALIZE_VALUE_DEFAULT = "0";
    public static final String LOGIN_REG_INITIALIZE_VALUE_LOCAL = "2";
    public static final String SWITCH_LOGIN_REG_INITIALIZE = "login.reg_initialize";
    public static final String SWITCH_LOGIN_REG_STATUTE = "login.reg_statute";
    private static final String TAG = "LoginRegHelper";
    private static int countDownLatch;
    private static ILoginReg currentLoginReg;
    private static boolean regCheckStatus;
    public static final LoginRegHelper INSTANCE = new LoginRegHelper();
    private static LoginRegHelper$regPopRunnable$1 regPopRunnable = new LoginRegHelper$regPopRunnable$1();
    public static final int $stable = 8;

    @JvmStatic
    public static final HashMap<String, String> getClickReportInfoValue(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "isShow");
        Intrinsics.checkNotNullParameter(str2, "isChecked");
        return getClickReportInfoValue$default(str, str2, null, 4, null);
    }

    @JvmStatic
    public static final void initOnChangeListener(CheckBox checkBox) {
        initOnChangeListener$default(checkBox, null, 2, null);
    }

    private LoginRegHelper() {
    }

    public final int getCountDownLatch() {
        return countDownLatch;
    }

    public final void setCountDownLatch(int i) {
        countDownLatch = i;
    }

    public final boolean getRegCheckStatus() {
        return regCheckStatus;
    }

    public final void setRegCheckStatus(boolean z) {
        regCheckStatus = z;
    }

    public final ILoginReg getLoginRegStrategy() {
        String switchValue = (String) Contract.-CC.get$default(ConfigManager.Companion.config(), SWITCH_LOGIN_REG_INITIALIZE, (Object) null, 2, (Object) null);
        if (switchValue == null) {
            switchValue = "0";
        }
        if (currentLoginReg == null) {
            if (Intrinsics.areEqual(switchValue, "1")) {
                currentLoginReg = new AnyPageLoginReg();
            } else if (Intrinsics.areEqual(switchValue, "2")) {
                currentLoginReg = new LocalLoginReg();
            } else {
                currentLoginReg = new OnceLoginReg();
            }
            ILoginReg iLoginReg = currentLoginReg;
            Intrinsics.checkNotNull(iLoginReg);
            return iLoginReg;
        } else if (Intrinsics.areEqual(switchValue, "1") && (currentLoginReg instanceof AnyPageLoginReg)) {
            ILoginReg iLoginReg2 = currentLoginReg;
            Intrinsics.checkNotNull(iLoginReg2);
            return iLoginReg2;
        } else if (Intrinsics.areEqual(switchValue, "2") && (currentLoginReg instanceof LocalLoginReg)) {
            ILoginReg iLoginReg3 = currentLoginReg;
            Intrinsics.checkNotNull(iLoginReg3);
            return iLoginReg3;
        } else if ((currentLoginReg instanceof OnceLoginReg) && !Intrinsics.areEqual(switchValue, "1") && !Intrinsics.areEqual(switchValue, "2")) {
            ILoginReg iLoginReg4 = currentLoginReg;
            Intrinsics.checkNotNull(iLoginReg4);
            return iLoginReg4;
        } else {
            currentLoginReg = null;
            return getLoginRegStrategy();
        }
    }

    public final void showRegPopView(Context context, View view) {
        if (context != null && view != null) {
            view.setVisibility(0);
            view.bringToFront();
            view.removeCallbacks(regPopRunnable);
            LoginRegHelper$regPopRunnable$1 $this$showRegPopView_u24lambda_u240_u240 = regPopRunnable;
            $this$showRegPopView_u24lambda_u240_u240.updateView(view);
            view.postDelayed($this$showRegPopView_u24lambda_u240_u240, 3000L);
        }
    }

    @JvmStatic
    public static final boolean checkViewVisibleAndUnCheck(CheckBox view) {
        return (view == null || view.getVisibility() != 0 || view.isChecked()) ? false : true;
    }

    @JvmStatic
    public static final void updateRegCheckbox(CheckBox view, View container) {
        if (view == null || container == null) {
            return;
        }
        ILoginReg loginReg = INSTANCE.getLoginRegStrategy();
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (loginReg.showReg(context)) {
            container.setVisibility(0);
            view.setVisibility(0);
            view.setChecked(loginReg.selectedReg());
            return;
        }
        container.setVisibility(8);
        view.setVisibility(8);
    }

    @JvmStatic
    public static final boolean isAnyPageLoginReg() {
        return INSTANCE.getLoginRegStrategy() instanceof AnyPageLoginReg;
    }

    public static /* synthetic */ void initOnChangeListener$default(CheckBox checkBox, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        initOnChangeListener(checkBox, function1);
    }

    @JvmStatic
    public static final void initOnChangeListener(CheckBox view, final Function1<? super Boolean, Boolean> function1) {
        if (view != null) {
            view.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.reg.LoginRegHelper$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    LoginRegHelper.initOnChangeListener$lambda$0$0(function1, compoundButton, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initOnChangeListener$lambda$0$0(Function1 $interrupt, CompoundButton compoundButton, boolean isChecked) {
        boolean z = false;
        if ($interrupt != null && ((Boolean) $interrupt.invoke(Boolean.valueOf(isChecked))).booleanValue()) {
            z = true;
        }
        if (!z) {
            INSTANCE.getLoginRegStrategy().changeRegCheckValue(isChecked);
        }
    }

    @JvmStatic
    public static final void clearOnChangeListener(CheckBox view) {
        if (view != null) {
            view.setOnCheckedChangeListener(null);
        }
    }

    @JvmStatic
    public static final boolean isLoginRegHasChecked() {
        Application application = BiliContext.application();
        Intrinsics.checkNotNull(application);
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference(application).getBoolean(KEY_PREF_REG_CHECK_STATUS, false);
    }

    @JvmStatic
    public static final void saveLoginRegHasCheckStatus(boolean isChecked) {
        Application application = BiliContext.application();
        Intrinsics.checkNotNull(application);
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(application).edit().putBoolean(KEY_PREF_REG_CHECK_STATUS, isChecked).apply();
    }

    @JvmStatic
    public static final String getProvisionReportValue(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BLog.d(TAG, "getProvisionReportValue = " + INSTANCE.getLoginRegStrategy().showReg(context));
        if (INSTANCE.getLoginRegStrategy().showReg(context)) {
            return "1";
        }
        return "0";
    }

    @JvmStatic
    public static final String getAgreeReportValue(CheckBox checkBox) {
        BLog.d(TAG, "getAgreeReportValue = " + (checkBox != null ? Boolean.valueOf(checkBox.isChecked()) : null));
        boolean z = false;
        if (checkBox != null && checkBox.isChecked()) {
            z = true;
        }
        if (z && checkBox.getVisibility() != 8) {
            return "1";
        }
        return "0";
    }

    public static /* synthetic */ HashMap getClickReportInfoValue$default(String str, String str2, Map map, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        return getClickReportInfoValue(str, str2, map);
    }

    @JvmStatic
    public static final HashMap<String, String> getClickReportInfoValue(String isShow, String isChecked, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(isShow, "isShow");
        Intrinsics.checkNotNullParameter(isChecked, "isChecked");
        BLog.d(TAG, "getClickReportInfoValue isChecked = " + isChecked + " , isShow = " + isShow);
        HashMap $this$getClickReportInfoValue_u24lambda_u240 = new HashMap();
        if (map != null) {
            $this$getClickReportInfoValue_u24lambda_u240.putAll(map);
        }
        $this$getClickReportInfoValue_u24lambda_u240.put(LoginReporterV2.SHOW_PROVISION_KEY, isShow);
        if (Intrinsics.areEqual("1", isShow)) {
            $this$getClickReportInfoValue_u24lambda_u240.put("is_agree", isChecked);
        }
        return $this$getClickReportInfoValue_u24lambda_u240;
    }

    @JvmStatic
    public static final void reportRegCheckboxClick(String eventId, CheckBox view) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        if (view != null) {
            HashMap $this$reportRegCheckboxClick_u24lambda_u240_u240 = new HashMap();
            $this$reportRegCheckboxClick_u24lambda_u240_u240.put("is_agree", view.isChecked() ? "1" : "0");
            LoginReporterV2.Click.report(eventId, $this$reportRegCheckboxClick_u24lambda_u240_u240);
        }
    }
}