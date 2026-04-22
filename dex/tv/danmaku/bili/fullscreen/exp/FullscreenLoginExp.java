package tv.danmaku.bili.fullscreen.exp;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.app.comm.list.common.cache.PersistedPropertyKt;
import com.bilibili.app.comm.list.common.cache.PersistedValue;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.biliid.api.BuvidHelper;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.neuron.api.Neurons;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginPageKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: FullscreenLoginExp.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010!\u001a\u00020 J\b\u0010\"\u001a\u00020 H\u0002J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\b\u0010'\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R$\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Ltv/danmaku/bili/fullscreen/exp/FullscreenLoginExp;", "", "<init>", "()V", "KEY_LOGIN_EXP", "", "SPMID_STARTUP_EXP", "KEY_FULLSCREEN_GROUP_A", "KEY_FULLSCREEN_GROUP_B", "KEY_FULLSCREEN_GROUP_C", "KEY_LOGIN_EXP_DATE_FROM_MS", "", "KEY_LOGIN_EXP_DATE_TO_MS", "KEY_PERSISTED_CHECK_EXP", "LOGIN_SKIP_CHECK_KEY", "<set-?>", "", "needCheckExp", "getNeedCheckExp", "()Z", "setNeedCheckExp", "(Z)V", "needCheckExp$delegate", "Lcom/bilibili/app/comm/list/common/cache/PersistedValue;", "value", "fullScreenShown", "getFullScreenShown", "setFullScreenShown", "expLoginDialogShown", "getExpLoginDialogShown", "setExpLoginDialogShown", "cachedLoginExpType", "Ltv/danmaku/bili/fullscreen/exp/LoginExpType;", "checkLoginExpType", "parseLoginType", "onAppStart", "", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "checkExpLoginDialogShow", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FullscreenLoginExp {
    private static final String KEY_FULLSCREEN_GROUP_A = "ff_login_fullscreen_group_a";
    private static final String KEY_FULLSCREEN_GROUP_B = "ff_login_fullscreen_group_b";
    private static final String KEY_FULLSCREEN_GROUP_C = "ff_login_fullscreen_group_c";
    public static final String KEY_LOGIN_EXP = "login_exp_group";
    private static final long KEY_LOGIN_EXP_DATE_FROM_MS = 1701273600000L;
    private static final long KEY_LOGIN_EXP_DATE_TO_MS = 1701878400000L;
    public static final String LOGIN_SKIP_CHECK_KEY = "skip_check";
    public static final String SPMID_STARTUP_EXP = "app.start-up.0.0";
    private static LoginExpType cachedLoginExpType;
    private static boolean expLoginDialogShown;
    private static boolean fullScreenShown;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(FullscreenLoginExp.class, "needCheckExp", "getNeedCheckExp()Z", 0))};
    public static final FullscreenLoginExp INSTANCE = new FullscreenLoginExp();
    private static final String KEY_PERSISTED_CHECK_EXP = "login_fullscreen_check_exp";
    private static final PersistedValue needCheckExp$delegate = PersistedPropertyKt.persistedBoolean$default(KEY_PERSISTED_CHECK_EXP, (String) null, false, 2, (Object) null);
    public static final int $stable = 8;

    private FullscreenLoginExp() {
    }

    private final boolean getNeedCheckExp() {
        return ((Boolean) needCheckExp$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    private final void setNeedCheckExp(boolean z) {
        needCheckExp$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    public final boolean getFullScreenShown() {
        return fullScreenShown;
    }

    public final void setFullScreenShown(boolean value) {
        fullScreenShown = value;
        BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "fullscreen shown: " + value);
    }

    public final boolean getExpLoginDialogShown() {
        return expLoginDialogShown;
    }

    public final void setExpLoginDialogShown(boolean value) {
        expLoginDialogShown = value;
        BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "exp login dialog shown: " + value);
    }

    public final LoginExpType checkLoginExpType() {
        if (EnvironmentManager.getInstance().isFirstStart()) {
            BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Set exp check flag to true");
            setNeedCheckExp(true);
        }
        if (!getNeedCheckExp()) {
            BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Skip login exp check for upgrade user");
            return LoginExpType.CONTROL;
        }
        LoginExpType it = cachedLoginExpType;
        if (it != null) {
            return it;
        }
        LoginExpType it2 = parseLoginType();
        cachedLoginExpType = it2;
        Neurons.reportClick(false, "app.active.abtest.0.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("local_buvid", BuvidHelper.getLocalBuvid()), TuplesKt.to("exp_id", "login_fullscreen"), TuplesKt.to("abtest", it2.getReportName())}));
        return it2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final LoginExpType parseLoginType() {
        LoginExpType loginExpType;
        LoginExpType preBuiltExp;
        Long longOrNull = StringsKt.toLongOrNull("null");
        long expFromMs = longOrNull != null ? longOrNull.longValue() : KEY_LOGIN_EXP_DATE_FROM_MS;
        Long longOrNull2 = StringsKt.toLongOrNull("null");
        long expToMs = longOrNull2 != null ? longOrNull2.longValue() : KEY_LOGIN_EXP_DATE_TO_MS;
        BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Exp date config from " + expFromMs + " to " + expToMs);
        long currentTimeMillis = System.currentTimeMillis();
        if (!(expFromMs <= currentTimeMillis && currentTimeMillis < expToMs)) {
            BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Current time not in exp date range, return control");
            cachedLoginExpType = LoginExpType.CONTROL;
            return LoginExpType.CONTROL;
        }
        BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "build config value: null");
        if (!StringsKt.isBlank("null")) {
            BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Pre built-in group null");
            switch ("null".hashCode()) {
                case BR.chatRoomConfig /* 97 */:
                    if ("null".equals("a")) {
                        preBuiltExp = LoginExpType.A_PHONE;
                        break;
                    }
                    preBuiltExp = null;
                    break;
                case BR.check /* 98 */:
                    if ("null".equals("b")) {
                        preBuiltExp = LoginExpType.B_PHONE_SMS;
                        break;
                    }
                    preBuiltExp = null;
                    break;
                case BR.checkContent /* 99 */:
                    if ("null".equals("c")) {
                        preBuiltExp = LoginExpType.C_PHONE_SMS_STRONG;
                        break;
                    }
                    preBuiltExp = null;
                    break;
                default:
                    preBuiltExp = null;
                    break;
            }
            if (preBuiltExp != null) {
                cachedLoginExpType = preBuiltExp;
                return preBuiltExp;
            }
        }
        if (ConfigManager.Companion.ab2().getWithDefault(KEY_FULLSCREEN_GROUP_A, false)) {
            loginExpType = LoginExpType.A_PHONE;
        } else if (ConfigManager.Companion.ab2().getWithDefault(KEY_FULLSCREEN_GROUP_B, false)) {
            loginExpType = LoginExpType.B_PHONE_SMS;
        } else {
            loginExpType = ConfigManager.Companion.ab2().getWithDefault(KEY_FULLSCREEN_GROUP_C, false) ? LoginExpType.C_PHONE_SMS_STRONG : LoginExpType.CONTROL;
        }
        LoginExpType it = loginExpType;
        BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "LoginExpType: " + it);
        return loginExpType;
    }

    public final void onAppStart(FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Context context = activity.getApplicationContext();
        if (BiliAccounts.get(context).isLogin()) {
            BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Already logged in, skip");
        } else if (checkExpLoginDialogShow()) {
            LoginExpType exp = checkLoginExpType();
            BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Goto login dialog with login exp type: " + exp);
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) activity), (CoroutineContext) null, (CoroutineStart) null, new FullscreenLoginExp$onAppStart$1(activity, context, exp, null), 3, (Object) null);
        } else {
            BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "Check login show condition failed, skip");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkExpLoginDialogShow() {
        return (checkLoginExpType().getQuickReloginSkippable() || fullScreenShown || expLoginDialogShown) ? false : true;
    }
}