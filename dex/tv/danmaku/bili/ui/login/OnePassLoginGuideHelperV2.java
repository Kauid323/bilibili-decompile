package tv.danmaku.bili.ui.login;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.app.comm.list.common.growth.july2025.GrowthAction;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.droid.PhoneUtils;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.FastLoginInfo;
import com.bilibili.lib.accounts.model.SimpleAccountItem;
import com.bilibili.lib.accounts.model.TInfoLogin;
import com.bilibili.lib.accountsui.quick.LoginQuickManager;
import com.bilibili.lib.accountsui.quick.QuickLoginTag;
import com.bilibili.lib.accountsui.utils.ILoginLimitUpdate;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.homepage.util.BottomTabSelectedHelper;
import com.bilibili.lib.homepage.util.UriUtils;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.ui.IDrawerHost;
import com.bilibili.module.account.LoginPlayStatusHelper;
import java.util.HashMap;
import java.util.List;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.OnlineParamsHelper;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.july2025.GrowthCenterImpl;
import tv.danmaku.bili.normal.ui.RouteUtilKt;
import tv.danmaku.bili.quick.LoginQualityMonitor;
import tv.danmaku.bili.quick.core.LoginRuleProcessor;
import tv.danmaku.bili.quick.core.LoginSceneProcessor;
import tv.danmaku.bili.quick.core.OnePassLoginPathLinkManager;
import tv.danmaku.bili.quick.core.OnePassLoginPhaseType;
import tv.danmaku.bili.quick.core.OnePassLoginPhoneData;
import tv.danmaku.bili.quick.core.OnePassLoginReportManagerKt;
import tv.danmaku.bili.quick.network.NetworkDialogResult;
import tv.danmaku.bili.quick.network.NetworkPermissionDialog;
import tv.danmaku.bili.quick.network.NetworkPermissionDialogKt;
import tv.danmaku.bili.quick.ui.LoginQuickActivityV2;
import tv.danmaku.bili.report.LoginReportHelper;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.login.LoginDialogInterceptor;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.ui.login.OnePassLoginGuideHelperV2;

/* compiled from: OnePassLoginGuideHelperV2.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/login/OnePassLoginGuideHelperV2;", "Lcom/bilibili/lib/accountsui/utils/ILoginLimitUpdate;", "<init>", "()V", "updateOnePass", "", "context", "Landroid/content/Context;", "updateSms", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@Named("homepage")
public final class OnePassLoginGuideHelperV2 implements ILoginLimitUpdate {
    public static final int $stable = 0;
    private static final long DEFAULT_MAIN_SHOW_GAP_TIME = 86400000;
    private static final String KEY_CONFIG_MAIN_SHOW_GAP = "login.home_login_show_gap";
    private static final String PREF_LAST_ONE_PASS_LOGIN_GUIDE_SHOW_TIME = "prefLastOnePassLoginGuideShowTime";
    private static final String PREF_LAST_SMS_LOGIN_GUIDE_SHOW_TIME = "prefLastSmsLoginGuideShowTime";
    private static final String PREF_LOGIN_ONE_PASS_GUIDE_TIMES = "prefOnePassLoginGuideTimes";
    public static final String TAG = "OnePassLoginGuideHelper";
    private static final String URI_MAIN_TAB = "bilibili://main/home";
    private static boolean mTryShowOnePassGuide;
    public static final Companion Companion = new Companion(null);
    private static final boolean mIsFirstStart = EnvironmentManager.getInstance().isFirstStart();

    /* compiled from: OnePassLoginGuideHelperV2.kt */
    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u000bH\u0002J$\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0003J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J&\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u0019JD\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010 JU\u0010!\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\"2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020$2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b'J\u001a\u0010(\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\"2\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J\u001f\u0010+\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\"2\b\u0010)\u001a\u0004\u0018\u00010*H\u0000¢\u0006\u0002\b,Jj\u0010-\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000e2\u0014\u00100\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u000e012\u0006\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u000e2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0002J\u009d\u0001\u00105\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020$2\u0014\u00100\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u000e012\u0006\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020$2\b\b\u0002\u00108\u001a\u00020\u00052\b\b\u0002\u00102\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u000e2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0002\b9J\\\u0010:\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000e2\u0014\u00100\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u000e012\u0006\u0010\u0016\u001a\u00020\u000e2\b\b\u0002\u00103\u001a\u00020\u000e2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J@\u0010;\u001a\u00020\u00122\u0006\u0010<\u001a\u00020=2\b\b\u0002\u0010\u0013\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u000e0@H\u0007J>\u0010;\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u000e0@H\u0087@¢\u0006\u0002\u0010AJ6\u0010B\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010C\u001a\u00020\u000e2\b\b\u0002\u0010D\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u0005H\u0083@¢\u0006\u0002\u0010EJ\b\u0010F\u001a\u00020\u000eH\u0007J\u0018\u0010G\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Ltv/danmaku/bili/ui/login/OnePassLoginGuideHelperV2$Companion;", "", "<init>", "()V", "TAG", "", "URI_MAIN_TAB", "PREF_LAST_ONE_PASS_LOGIN_GUIDE_SHOW_TIME", "PREF_LOGIN_ONE_PASS_GUIDE_TIMES", "KEY_CONFIG_MAIN_SHOW_GAP", "DEFAULT_MAIN_SHOW_GAP_TIME", "", "PREF_LAST_SMS_LOGIN_GUIDE_SHOW_TIME", "mIsFirstStart", "", "mTryShowOnePassGuide", "getInterval", "showOnePassLoginGuide", "", "fromSpmid", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "fromVideo", "limitBeforeShow", "limitOrShowOnePass", "(Ljava/lang/String;Landroidx/fragment/app/FragmentActivity;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "routeToSmsLoginDialogIfEnableV2", "getPhoneInfoError", "ctx", "info", "Lcom/bilibili/lib/accounts/model/TInfoLogin;", "ignoreOnlineParams", "(ZLandroidx/fragment/app/FragmentActivity;Lcom/bilibili/lib/accounts/model/TInfoLogin;ZZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "routeToSmsLoginDialogIfEnable", "Landroid/content/Context;", "showDialogTime", "", "independentLimit", "priority", "routeToSmsLoginDialogIfEnable$core_apinkDebug", "routeToFastReLoginV2", "accountInfo", "Lcom/bilibili/lib/accounts/model/SimpleAccountItem;", "routeToFastReLogin", "routeToFastReLogin$core_apinkDebug", "routeToLoginQuickV2", "enableSms", LoginQuickActivityV2.INTENT_KEY_SMS_DIRECT, "pair", "Lkotlin/Pair;", LoginQuickActivityV2.INTENT_KEY_LOGIN_EXPERIMENT, "loginExperimentForPeagsus", LoginQuickActivityV2.INTENT_KEY_LOGIN_EXPERIMENT_VALUE, "routeToLoginQuick", "skipTime", "lastMaxTimes", "priorityKey", "routeToLoginQuick$core_apinkDebug", "routeToLoginQuickDirectly", "startCheckShowOnePassLoginGuide", "fragment", "Landroidx/fragment/app/Fragment;", "isStartUpFragment", AuthResultCbHelper.ARGS_CALLBACK, "Lkotlin/Function1;", "(Ljava/lang/String;ZLandroidx/fragment/app/FragmentActivity;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "realCheckShowOnePassLoginGuide", "selectChange", "isSatisfyCondition", "(Landroidx/fragment/app/FragmentActivity;ZZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkMainPage", "reportLoginDialog", "isOnepass", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final long getInterval() {
            Long longOrNull = StringsKt.toLongOrNull(ConfigManager.Companion.getConfig(OnePassLoginGuideHelperV2.KEY_CONFIG_MAIN_SHOW_GAP, ""));
            return longOrNull != null ? longOrNull.longValue() : OnePassLoginGuideHelperV2.DEFAULT_MAIN_SHOW_GAP_TIME;
        }

        static /* synthetic */ void showOnePassLoginGuide$default(Companion companion, String str, FragmentActivity fragmentActivity, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "enter_homepage";
            }
            companion.showOnePassLoginGuide(str, fragmentActivity, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void showOnePassLoginGuide(final String fromSpmid, final FragmentActivity activity, final boolean fromVideo) {
            if (activity == null) {
                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(fromSpmid, OnePassLoginReportManagerKt.INTERRUPTED_FOR_OUT_OF_LIFECYCLE_SCOPE);
                return;
            }
            MainDialogManager.DialogManagerInfo managerInfo = new MainDialogManager.DialogManagerInfo("login_guide", new MainDialogManager.IDialogInterface() { // from class: tv.danmaku.bili.ui.login.OnePassLoginGuideHelperV2$Companion$$ExternalSyntheticLambda3
                public final void onShow() {
                    OnePassLoginGuideHelperV2.Companion.showOnePassLoginGuide$lambda$0(fromSpmid, activity, fromVideo);
                }
            }, 2050);
            managerInfo.setMainOnly(false);
            MainDialogManager.addDialog(managerInfo, (Context) activity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showOnePassLoginGuide$lambda$0(String $fromSpmid, FragmentActivity $activity, boolean $fromVideo) {
            if (OnePassLoginGuideHelperV2.Companion.limitBeforeShow($fromSpmid, $activity)) {
                MainDialogManager.showNextDialog("login_guide", false, (Context) $activity);
            } else {
                BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) $activity), (CoroutineContext) null, (CoroutineStart) null, new OnePassLoginGuideHelperV2$Companion$showOnePassLoginGuide$managerInfo$1$1($fromSpmid, $activity, $fromVideo, null), 3, (Object) null);
            }
        }

        private final boolean limitBeforeShow(String fromSpmid, FragmentActivity activity) {
            if (!OnlineParamsHelper.getEnableOnePassLoginGuide()) {
                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(fromSpmid, "hit config : onepassguide_show");
                return true;
            } else if (BiliAccounts.get((Context) activity).isLogin()) {
                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(fromSpmid, OnePassLoginReportManagerKt.INTERRUPTED_FOR_ALREADY_LOGIN);
                return true;
            } else if (RestrictedMode.isRestrictedMode()) {
                BLog.i(OnePassLoginGuideHelperV2.TAG, "cancel quick login because teenager mode");
                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(fromSpmid, OnePassLoginReportManagerKt.INTERRUPTED_FOR_IN_TEENAGER_MODE);
                return true;
            } else {
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:101:0x0384  */
        /* JADX WARN: Removed duplicated region for block: B:102:0x039f  */
        /* JADX WARN: Removed duplicated region for block: B:109:0x03f3  */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:113:0x03fa  */
        /* JADX WARN: Removed duplicated region for block: B:116:0x03ff  */
        /* JADX WARN: Removed duplicated region for block: B:117:0x0402  */
        /* JADX WARN: Removed duplicated region for block: B:120:0x0407  */
        /* JADX WARN: Removed duplicated region for block: B:121:0x040a  */
        /* JADX WARN: Removed duplicated region for block: B:125:0x0425  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:138:0x0490  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:140:0x0496  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0179  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x019d  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x01bc  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x01e7  */
        /* JADX WARN: Removed duplicated region for block: B:95:0x032a  */
        /* JADX WARN: Type inference failed for: r37v0, types: [java.lang.Object, androidx.fragment.app.FragmentActivity] */
        /* JADX WARN: Type inference failed for: r3v23 */
        /* JADX WARN: Type inference failed for: r7v16 */
        /* JADX WARN: Type inference failed for: r8v4, types: [boolean] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object limitOrShowOnePass(String fromSpmid, FragmentActivity fragmentActivity, boolean fromVideo, Continuation<? super Boolean> continuation) {
            OnePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1 onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1;
            Companion companion;
            boolean z;
            String str;
            boolean z2;
            Object suspendGetLoginType$default;
            boolean fromVideo2;
            String fromSpmid2;
            final Context context;
            TInfoLogin infoLogin;
            boolean z3;
            boolean z4;
            TInfoLogin.AB ab;
            Object loadAccount;
            boolean fromVideo3;
            String fromSpmid3;
            TInfoLogin infoLogin2;
            int i;
            Companion companion2;
            TInfoLogin.AB ab2;
            int mLoginWay;
            boolean z5;
            Pair pair;
            String str2;
            Object routeToSmsLoginDialogIfEnableV2$default;
            Object suspendGetPhoneInfo;
            Companion companion3;
            Pair pair2;
            String fromSpmid4;
            Context context2;
            int i2;
            int mLoginWay2;
            Object routeToSmsLoginDialogIfEnableV2$default2;
            Integer result;
            LoginQuickManager.PhoneInfoBean rep;
            TInfoLogin infoLogin3;
            Object obj;
            Object routeToSmsLoginDialogIfEnableV2$default3;
            int i3;
            boolean z6;
            if (continuation instanceof OnePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1) {
                onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1 = (OnePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1) continuation;
                if ((onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.label & Integer.MIN_VALUE) != 0) {
                    onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.label -= Integer.MIN_VALUE;
                    Object $result = onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            SharedPreferences sharedPreferences = BiliGlobalPreferenceHelper.getBLKVSharedPreference((Context) fragmentActivity);
                            companion = this;
                            long lastShowTime = sharedPreferences.getLong(OnePassLoginGuideHelperV2.PREF_LAST_ONE_PASS_LOGIN_GUIDE_SHOW_TIME, 0L);
                            long interval = companion.getInterval();
                            if (System.currentTimeMillis() - lastShowTime < interval) {
                                BLog.i(OnePassLoginGuideHelperV2.TAG, "cancel quick login because last show time is not to, current time is " + lastShowTime + " and online time limit is " + interval);
                                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(fromSpmid, OnePassLoginReportManagerKt.INTERRUPTED_FOR_TIME_INTERVAL);
                                return Boxing.boxBoolean(true);
                            }
                            int onlineParamMaxTimes = OnlineParamsHelper.getOnePassLoginGuideMaxTimes();
                            int lastMaxTimes = sharedPreferences.getInt(OnePassLoginGuideHelperV2.PREF_LOGIN_ONE_PASS_GUIDE_TIMES, 0);
                            if (lastMaxTimes >= onlineParamMaxTimes) {
                                BLog.i(OnePassLoginGuideHelperV2.TAG, "cancel quick login because show time is limit current time is " + lastMaxTimes + " and online time limit is " + onlineParamMaxTimes);
                                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(fromSpmid, OnePassLoginReportManagerKt.INTERRUPTED_FOR_EXCEEDED_THE_DISPLAY_TIMES);
                                return Boxing.boxBoolean(true);
                            }
                            OnePassLoginPathLinkManager.INSTANCE.onPhase(fromSpmid, OnePassLoginPhaseType.PrepareRemoteLoginInfo.INSTANCE);
                            LoginRuleProcessor loginRuleProcessor = LoginRuleProcessor.INSTANCE;
                            onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$0 = fromSpmid;
                            onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$1 = fragmentActivity;
                            onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.Z$0 = fromVideo;
                            onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.label = 1;
                            z = true;
                            str = null;
                            z2 = false;
                            suspendGetLoginType$default = LoginRuleProcessor.suspendGetLoginType$default(loginRuleProcessor, false, false, onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1, 3, null);
                            if (suspendGetLoginType$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            fromVideo2 = fromVideo;
                            fromSpmid2 = fromSpmid;
                            context = fragmentActivity;
                            infoLogin = (TInfoLogin) ((Pair) suspendGetLoginType$default).component2();
                            if (infoLogin != null) {
                                LoginQualityMonitor.report$default(LoginQualityMonitor.INSTANCE, "1", "3", null, null, 12, null);
                                BLog.i(OnePassLoginGuideHelperV2.TAG, "cancel quick login because login type is null");
                                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(fromSpmid2, OnePassLoginReportManagerKt.INTERRUPTED_FOR_FAILED_TO_GET_LOGIN_INFO);
                                return Boxing.boxBoolean(z);
                            }
                            LoginReporterV2.Click.report(fromVideo2 ? LoginReporterV2.Click.CLICK_HOMEPAGE_FROM_VIDEO : LoginReporterV2.Click.CLICK_HOMEPAGE_TMCARD);
                            TInfoLogin.AB ab3 = infoLogin.ab;
                            if (ab3 != null) {
                                z3 = z;
                                if (ab3.isC() == z3) {
                                    z4 = z3;
                                    if (!z4) {
                                        BLog.i(OnePassLoginGuideHelperV2.TAG, "infoLogin AB test is C: no dialog.");
                                        OnePassLoginPathLinkManager.INSTANCE.stopWithReason(fromSpmid2, "hit the login experiment : login_popup = " + (infoLogin.ab != null ? ab2.loginPopup : str));
                                        return Boxing.boxBoolean((boolean) z3);
                                    }
                                    TInfoLogin.AB ab4 = infoLogin.ab;
                                    int i4 = ((ab4 == null || ab4.isB() != z3) ? z2 : z3) ^ z3;
                                    BLog.i(OnePassLoginGuideHelperV2.TAG, "infoLogin AB test is " + (infoLogin.ab != null ? ab.loginPopup : str));
                                    FastLoginInfo fastLoginInfo = BiliAccounts.get(context).getFastLoginInfo();
                                    onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$0 = fromSpmid2;
                                    onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$1 = context;
                                    onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$2 = infoLogin;
                                    onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.Z$0 = fromVideo2;
                                    onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.I$0 = i4;
                                    onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.label = 2;
                                    loadAccount = OnePassLoginGuideHelperV2Kt.loadAccount(context, fastLoginInfo, onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1);
                                    if (loadAccount == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    fromVideo3 = fromVideo2;
                                    fromSpmid3 = fromSpmid2;
                                    infoLogin2 = infoLogin;
                                    i = i4;
                                    companion2 = companion;
                                    SimpleAccountItem account = loadAccount;
                                    mLoginWay = LoginRuleProcessor.INSTANCE.parseLoginWay(context, infoLogin2, z2);
                                    if (mLoginWay != 10 && account != null) {
                                        OnePassLoginPathLinkManager.INSTANCE.stopWithReason(fromSpmid3, OnePassLoginReportManagerKt.INTERRUPTED_FOR_TRY_FAST_LOGIN);
                                        return Boxing.boxBoolean(!companion2.routeToFastReLoginV2(context, account) ? true : z2);
                                    }
                                    z5 = true;
                                    if (mLoginWay == 1 && mLoginWay != 2 && mLoginWay != 3) {
                                        if (i != 0) {
                                            OnePassLoginPathLinkManager.INSTANCE.stopWithReason(fromSpmid3, "the login way is not a quick way : " + mLoginWay);
                                            LoginQualityMonitor.report$default(LoginQualityMonitor.INSTANCE, "1", "2", null, null, 12, null);
                                            BLog.i(OnePassLoginGuideHelperV2.TAG, "try show login sms dialog because login type is not allow quick login");
                                            boolean z7 = fromVideo3 ? true : z2;
                                            onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$0 = null;
                                            onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$1 = null;
                                            onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$2 = null;
                                            onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.label = 6;
                                            routeToSmsLoginDialogIfEnableV2$default2 = routeToSmsLoginDialogIfEnableV2$default(companion2, false, context, infoLogin2, z7, false, null, onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1, 33, null);
                                            if (routeToSmsLoginDialogIfEnableV2$default2 == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            return Boxing.boxBoolean(z5 ^ ((Boolean) routeToSmsLoginDialogIfEnableV2$default2).booleanValue());
                                        }
                                        return Boxing.boxBoolean(true);
                                    }
                                    LoginQualityMonitor.report$default(LoginQualityMonitor.INSTANCE, "1", "1", null, null, 12, null);
                                    OnePassLoginPathLinkManager.INSTANCE.onPhase(fromSpmid3, OnePassLoginPhaseType.CheckConditions.INSTANCE);
                                    final String netType = LoginQuickManager.INSTANCE.getNetType(context);
                                    OnePassLoginPathLinkManager.INSTANCE.updateData(fromSpmid3, new Function1() { // from class: tv.danmaku.bili.ui.login.OnePassLoginGuideHelperV2$Companion$$ExternalSyntheticLambda1
                                        public final Object invoke(Object obj2) {
                                            OnePassLoginPhoneData limitOrShowOnePass$lambda$0;
                                            limitOrShowOnePass$lambda$0 = OnePassLoginGuideHelperV2.Companion.limitOrShowOnePass$lambda$0(netType, context, (OnePassLoginPhoneData) obj2);
                                            return limitOrShowOnePass$lambda$0;
                                        }
                                    });
                                    LoginQuickManager loginQuickManager = LoginQuickManager.INSTANCE;
                                    TInfoLogin.LoginBean loginBean = infoLogin2.login;
                                    Intrinsics.checkNotNull(loginBean);
                                    TInfoLogin.QuickBean quickBean = loginBean.quick;
                                    Intrinsics.checkNotNullExpressionValue(quickBean, "quick");
                                    pair = loginQuickManager.isNetOkWhitType(netType, quickBean);
                                    if (((Boolean) pair.getSecond()).booleanValue()) {
                                        if (i != 0) {
                                            OnePassLoginPathLinkManager.INSTANCE.stopWithReason(fromSpmid3, "network operator disallow to quick login -> " + (((String) pair.getFirst()) != null ? OnePassLoginReportManagerKt.getNetworkOperatorNameFromType(str2) : null));
                                            LoginReporterV2.Error.report(LoginReporterV2.Error.APP_ONE_PASS_LOGIN_FAIL, "enter_homepage", "1");
                                            BLog.i(OnePassLoginGuideHelperV2.TAG, "try show login sms dialog because net is not ok");
                                            boolean z8 = fromVideo3;
                                            onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$0 = null;
                                            onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$1 = null;
                                            onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$2 = null;
                                            onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.label = 5;
                                            routeToSmsLoginDialogIfEnableV2$default = routeToSmsLoginDialogIfEnableV2$default(companion2, false, context, infoLogin2, z8, false, null, onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1, 33, null);
                                            if (routeToSmsLoginDialogIfEnableV2$default == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            return Boxing.boxBoolean(!((Boolean) routeToSmsLoginDialogIfEnableV2$default).booleanValue());
                                        }
                                        return Boxing.boxBoolean(true);
                                    }
                                    QuickLoginTag quickLoginTag = QuickLoginTag.MAIN;
                                    onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$0 = fromSpmid3;
                                    onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$1 = context;
                                    onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$2 = infoLogin2;
                                    onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$3 = pair;
                                    onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.Z$0 = fromVideo3;
                                    onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.I$0 = i;
                                    onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.I$1 = mLoginWay;
                                    onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.label = 3;
                                    suspendGetPhoneInfo = LoginQuickManager.INSTANCE.suspendGetPhoneInfo(context, quickLoginTag, onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1);
                                    if (suspendGetPhoneInfo == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    companion3 = companion2;
                                    pair2 = pair;
                                    fromSpmid4 = fromSpmid3;
                                    context2 = context;
                                    i2 = i;
                                    mLoginWay2 = mLoginWay;
                                    Pair pair3 = (Pair) suspendGetPhoneInfo;
                                    result = (Integer) pair3.component1();
                                    rep = (LoginQuickManager.PhoneInfoBean) pair3.component2();
                                    BLog.i(OnePassLoginGuideHelperV2.TAG, "endGetPhoneInfo result=" + result + ", rep=" + rep);
                                    if (rep == null) {
                                        obj = coroutine_suspended;
                                        infoLogin3 = infoLogin2;
                                        LoginQualityMonitor.INSTANCE.report("3", rep.getResultCode(), LoginQualityMonitor.INSTANCE.endMarkSpendTime(), rep.getSecurityPhone());
                                    } else {
                                        infoLogin3 = infoLogin2;
                                        obj = coroutine_suspended;
                                        LoginQualityMonitor.report$default(LoginQualityMonitor.INSTANCE, "3", LoginQualityMonitor.OTHER_RESULT_CODE_MOBILE_API_ERROR, LoginQualityMonitor.INSTANCE.endMarkSpendTime(), null, 8, null);
                                    }
                                    if (result != null && result.intValue() == 1) {
                                        OnePassLoginPathLinkManager.INSTANCE.onPhase(fromSpmid4, OnePassLoginPhaseType.GetNumberSuc.INSTANCE);
                                        BLog.i(OnePassLoginGuideHelperV2.TAG, "mLoginWay=" + mLoginWay2 + ", start quick login");
                                        Context context3 = context2;
                                        if (mLoginWay2 == 1) {
                                            i3 = 3;
                                            if (mLoginWay2 != 3) {
                                                z6 = false;
                                                return Boxing.boxBoolean(!routeToLoginQuickV2$default(companion3, context3, z6, mLoginWay2 == i3, pair2, fromVideo3, false, false, null, null, BR.reportVo, null));
                                            }
                                        } else {
                                            i3 = 3;
                                        }
                                        z6 = true;
                                        return Boxing.boxBoolean(!routeToLoginQuickV2$default(companion3, context3, z6, mLoginWay2 == i3, pair2, fromVideo3, false, false, null, null, BR.reportVo, null));
                                    } else if (i2 == 0) {
                                        OnePassLoginPathLinkManager.INSTANCE.stopWithReason(fromSpmid4, "get phone info with error : " + (rep != null ? rep.getMsg() : null));
                                        LoginReporterV2.Error.report(LoginReporterV2.Error.APP_ONE_PASS_LOGIN_FAIL, "enter_homepage", "2");
                                        BLog.i(OnePassLoginGuideHelperV2.TAG, "try show login sms dialog because get phone info error");
                                        boolean z9 = fromVideo3;
                                        onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$0 = null;
                                        onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$1 = null;
                                        onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$2 = null;
                                        onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$3 = null;
                                        onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.label = 4;
                                        routeToSmsLoginDialogIfEnableV2$default3 = routeToSmsLoginDialogIfEnableV2$default(companion3, true, context2, infoLogin3, z9, false, null, onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1, 32, null);
                                        Object obj2 = obj;
                                        if (routeToSmsLoginDialogIfEnableV2$default3 == obj2) {
                                            return obj2;
                                        }
                                        return Boxing.boxBoolean(!((Boolean) routeToSmsLoginDialogIfEnableV2$default3).booleanValue());
                                    } else {
                                        return Boxing.boxBoolean(true);
                                    }
                                }
                            } else {
                                z3 = z;
                            }
                            z4 = z2;
                            if (!z4) {
                            }
                            break;
                        case 1:
                            fromVideo2 = onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.Z$0;
                            context = (FragmentActivity) onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$1;
                            fromSpmid2 = (String) onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$0;
                            ResultKt.throwOnFailure($result);
                            companion = this;
                            suspendGetLoginType$default = $result;
                            str = null;
                            z2 = false;
                            z = true;
                            infoLogin = (TInfoLogin) ((Pair) suspendGetLoginType$default).component2();
                            if (infoLogin != null) {
                            }
                            break;
                        case 2:
                            companion2 = this;
                            i = onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.I$0;
                            boolean fromVideo4 = onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.Z$0;
                            infoLogin2 = (TInfoLogin) onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$2;
                            fromSpmid3 = (String) onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$0;
                            ResultKt.throwOnFailure($result);
                            fromVideo3 = fromVideo4;
                            context = (FragmentActivity) onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$1;
                            loadAccount = $result;
                            z2 = false;
                            SimpleAccountItem account2 = loadAccount;
                            mLoginWay = LoginRuleProcessor.INSTANCE.parseLoginWay(context, infoLogin2, z2);
                            if (mLoginWay != 10) {
                            }
                            z5 = true;
                            if (mLoginWay == 1) {
                                break;
                            }
                            LoginQualityMonitor.report$default(LoginQualityMonitor.INSTANCE, "1", "1", null, null, 12, null);
                            OnePassLoginPathLinkManager.INSTANCE.onPhase(fromSpmid3, OnePassLoginPhaseType.CheckConditions.INSTANCE);
                            final String netType2 = LoginQuickManager.INSTANCE.getNetType(context);
                            OnePassLoginPathLinkManager.INSTANCE.updateData(fromSpmid3, new Function1() { // from class: tv.danmaku.bili.ui.login.OnePassLoginGuideHelperV2$Companion$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj22) {
                                    OnePassLoginPhoneData limitOrShowOnePass$lambda$0;
                                    limitOrShowOnePass$lambda$0 = OnePassLoginGuideHelperV2.Companion.limitOrShowOnePass$lambda$0(netType2, context, (OnePassLoginPhoneData) obj22);
                                    return limitOrShowOnePass$lambda$0;
                                }
                            });
                            LoginQuickManager loginQuickManager2 = LoginQuickManager.INSTANCE;
                            TInfoLogin.LoginBean loginBean2 = infoLogin2.login;
                            Intrinsics.checkNotNull(loginBean2);
                            TInfoLogin.QuickBean quickBean2 = loginBean2.quick;
                            Intrinsics.checkNotNullExpressionValue(quickBean2, "quick");
                            pair = loginQuickManager2.isNetOkWhitType(netType2, quickBean2);
                            if (((Boolean) pair.getSecond()).booleanValue()) {
                            }
                            break;
                        case 3:
                            mLoginWay2 = onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.I$1;
                            i2 = onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.I$0;
                            fromVideo3 = onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.Z$0;
                            context2 = (FragmentActivity) onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$1;
                            ResultKt.throwOnFailure($result);
                            companion3 = this;
                            fromSpmid4 = (String) onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$0;
                            pair2 = (Pair) onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$3;
                            infoLogin2 = (TInfoLogin) onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.L$2;
                            suspendGetPhoneInfo = $result;
                            Pair pair32 = (Pair) suspendGetPhoneInfo;
                            result = (Integer) pair32.component1();
                            rep = (LoginQuickManager.PhoneInfoBean) pair32.component2();
                            BLog.i(OnePassLoginGuideHelperV2.TAG, "endGetPhoneInfo result=" + result + ", rep=" + rep);
                            if (rep == null) {
                            }
                            if (result != null) {
                                OnePassLoginPathLinkManager.INSTANCE.onPhase(fromSpmid4, OnePassLoginPhaseType.GetNumberSuc.INSTANCE);
                                BLog.i(OnePassLoginGuideHelperV2.TAG, "mLoginWay=" + mLoginWay2 + ", start quick login");
                                Context context32 = context2;
                                if (mLoginWay2 == 1) {
                                }
                                z6 = true;
                                return Boxing.boxBoolean(!routeToLoginQuickV2$default(companion3, context32, z6, mLoginWay2 == i3, pair2, fromVideo3, false, false, null, null, BR.reportVo, null));
                            }
                            if (i2 == 0) {
                            }
                            break;
                        case 4:
                            ResultKt.throwOnFailure($result);
                            routeToSmsLoginDialogIfEnableV2$default3 = $result;
                            return Boxing.boxBoolean(!((Boolean) routeToSmsLoginDialogIfEnableV2$default3).booleanValue());
                        case 5:
                            ResultKt.throwOnFailure($result);
                            routeToSmsLoginDialogIfEnableV2$default = $result;
                            return Boxing.boxBoolean(!((Boolean) routeToSmsLoginDialogIfEnableV2$default).booleanValue());
                        case 6:
                            ResultKt.throwOnFailure($result);
                            routeToSmsLoginDialogIfEnableV2$default2 = $result;
                            z5 = true;
                            return Boxing.boxBoolean(z5 ^ ((Boolean) routeToSmsLoginDialogIfEnableV2$default2).booleanValue());
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1 = new OnePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1(this, continuation);
            Object $result2 = onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (onePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1.label) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final OnePassLoginPhoneData limitOrShowOnePass$lambda$0(String $netType, FragmentActivity $activity, OnePassLoginPhoneData it) {
            return new OnePassLoginPhoneData($netType, PhoneUtils.getOriginSimOperator((Context) $activity) != null, PhoneUtils.isPad((Context) $activity));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:94:0x01c7, code lost:
            if (r28.isSmsLoginEnable() == true) goto L94;
         */
        /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0108  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x010b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object routeToSmsLoginDialogIfEnableV2(boolean getPhoneInfoError, FragmentActivity fragmentActivity, TInfoLogin info, boolean fromVideo, boolean ignoreOnlineParams, String fromSpmid, Continuation<? super Boolean> continuation) {
            OnePassLoginGuideHelperV2$Companion$routeToSmsLoginDialogIfEnableV2$1 onePassLoginGuideHelperV2$Companion$routeToSmsLoginDialogIfEnableV2$1;
            FragmentActivity ctx;
            boolean z;
            boolean z2;
            boolean z3;
            Object suspendShow;
            Companion companion;
            boolean fromVideo2;
            TInfoLogin info2;
            NetworkDialogResult networkRes;
            if (continuation instanceof OnePassLoginGuideHelperV2$Companion$routeToSmsLoginDialogIfEnableV2$1) {
                onePassLoginGuideHelperV2$Companion$routeToSmsLoginDialogIfEnableV2$1 = (OnePassLoginGuideHelperV2$Companion$routeToSmsLoginDialogIfEnableV2$1) continuation;
                if ((onePassLoginGuideHelperV2$Companion$routeToSmsLoginDialogIfEnableV2$1.label & Integer.MIN_VALUE) != 0) {
                    onePassLoginGuideHelperV2$Companion$routeToSmsLoginDialogIfEnableV2$1.label -= Integer.MIN_VALUE;
                    Object $result = onePassLoginGuideHelperV2$Companion$routeToSmsLoginDialogIfEnableV2$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (onePassLoginGuideHelperV2$Companion$routeToSmsLoginDialogIfEnableV2$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            ctx = fragmentActivity;
                            SharedPreferences sharedPreferences = BiliGlobalPreferenceHelper.getBLKVSharedPreference((Context) ctx);
                            long lastShowTime = sharedPreferences.getLong(OnePassLoginGuideHelperV2.PREF_LAST_SMS_LOGIN_GUIDE_SHOW_TIME, 0L);
                            boolean isShowTime = System.currentTimeMillis() - lastShowTime >= getInterval();
                            if ((info != null && info.isSmsLoginEnable()) && isShowTime) {
                                boolean isLogin = BiliAccounts.get((Context) ctx).isLogin();
                                LoginDialogInterceptor.Companion companion2 = LoginDialogInterceptor.Companion;
                                boolean ignoreOnlineParams2 = ignoreOnlineParams;
                                boolean isIntercepted = companion2.onInterceptHomeSmsLoginDialog(ignoreOnlineParams2);
                                if (isLogin) {
                                    z3 = false;
                                } else if (isIntercepted) {
                                    z3 = false;
                                } else if (BiliContext.topActivitiy() instanceof IDrawerHost) {
                                    LoginReportHelper.INSTANCE.setFromSpmid(fromSpmid);
                                    if (getPhoneInfoError) {
                                        TInfoLogin.AB ab = info.ab;
                                        if ((ab != null && ab.isLoginPopupNonNet()) && RouteUtilKt.hasCardAndOnlyWifi((Context) ctx)) {
                                            NetworkPermissionDialog newInstance = NetworkPermissionDialog.Companion.newInstance(info);
                                            FragmentManager supportFragmentManager = ctx.getSupportFragmentManager();
                                            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                                            onePassLoginGuideHelperV2$Companion$routeToSmsLoginDialogIfEnableV2$1.L$0 = ctx;
                                            onePassLoginGuideHelperV2$Companion$routeToSmsLoginDialogIfEnableV2$1.L$1 = info;
                                            onePassLoginGuideHelperV2$Companion$routeToSmsLoginDialogIfEnableV2$1.Z$0 = fromVideo;
                                            onePassLoginGuideHelperV2$Companion$routeToSmsLoginDialogIfEnableV2$1.label = 1;
                                            suspendShow = newInstance.suspendShow(supportFragmentManager, null, onePassLoginGuideHelperV2$Companion$routeToSmsLoginDialogIfEnableV2$1);
                                            if (suspendShow == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            companion = this;
                                            fromVideo2 = fromVideo;
                                            info2 = info;
                                            networkRes = (NetworkDialogResult) suspendShow;
                                            if (!Intrinsics.areEqual(networkRes, NetworkDialogResult.Default.INSTANCE)) {
                                                z2 = false;
                                            } else if (Intrinsics.areEqual(networkRes, NetworkDialogResult.OtherWays.INSTANCE)) {
                                                Context context = (Context) ctx;
                                                TInfoLogin.AB ab2 = info2.ab;
                                                RouteUtilKt.showSmsLoginDialog$default(context, "home", null, null, ab2 != null ? ab2.isSmsLoginExp() : false, 12, null);
                                                companion.reportLoginDialog(fromVideo2, false);
                                                z2 = true;
                                            } else if (!(networkRes instanceof NetworkDialogResult.HasOpenNetwork)) {
                                                throw new NoWhenBranchMatchedException();
                                            } else {
                                                boolean res = NetworkPermissionDialogKt.retryQuickLogin((Context) ctx, info2, ((NetworkDialogResult.HasOpenNetwork) networkRes).getGetPhoneInfoSuc());
                                                if (res) {
                                                    companion.reportLoginDialog(fromVideo2, ((NetworkDialogResult.HasOpenNetwork) networkRes).getGetPhoneInfoSuc());
                                                }
                                                z2 = res;
                                            }
                                        }
                                    }
                                    BLog.i(OnePassLoginGuideHelperV2.TAG, "show sms login dialog");
                                    Context context2 = (Context) ctx;
                                    TInfoLogin.AB ab3 = info.ab;
                                    RouteUtilKt.showSmsLoginDialog$default(context2, "home", null, null, ab3 != null ? ab3.isSmsLoginExp() : false, 12, null);
                                    reportLoginDialog(fromVideo, false);
                                    z2 = true;
                                } else {
                                    BLog.i(OnePassLoginGuideHelperV2.TAG, "cancel show sms because is not main,show next dialog");
                                    LoginReporterV2.Error.report(LoginReporterV2.Error.APP_SMS_LOGIN2_FAIL, "enter_homepage", "3");
                                    z2 = false;
                                }
                                if (isLogin) {
                                    BLog.i(OnePassLoginGuideHelperV2.TAG, "user is login,show next dialog");
                                } else if (isIntercepted) {
                                    BLog.i(OnePassLoginGuideHelperV2.TAG, "home > showing sms dialog has been intercepted.");
                                }
                                z2 = z3;
                            } else {
                                if (info != null) {
                                    z = true;
                                    break;
                                }
                                z = false;
                                if (z) {
                                    LoginReporterV2.Error.report(LoginReporterV2.Error.APP_SMS_LOGIN2_FAIL, "enter_homepage", "3");
                                    BLog.i(OnePassLoginGuideHelperV2.TAG, "cancel show sms login dialog because last show time is " + lastShowTime);
                                } else {
                                    LoginReporterV2.Error.report(LoginReporterV2.Error.APP_SMS_LOGIN2_FAIL, "enter_homepage", "3");
                                    BLog.i(OnePassLoginGuideHelperV2.TAG, "cancel show sms login dialog because rule not allow sms login");
                                }
                                z2 = false;
                            }
                            return Boxing.boxBoolean(z2);
                        case 1:
                            companion = this;
                            fromVideo2 = onePassLoginGuideHelperV2$Companion$routeToSmsLoginDialogIfEnableV2$1.Z$0;
                            info2 = (TInfoLogin) onePassLoginGuideHelperV2$Companion$routeToSmsLoginDialogIfEnableV2$1.L$1;
                            ctx = (FragmentActivity) onePassLoginGuideHelperV2$Companion$routeToSmsLoginDialogIfEnableV2$1.L$0;
                            ResultKt.throwOnFailure($result);
                            suspendShow = $result;
                            networkRes = (NetworkDialogResult) suspendShow;
                            if (!Intrinsics.areEqual(networkRes, NetworkDialogResult.Default.INSTANCE)) {
                            }
                            return Boxing.boxBoolean(z2);
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            onePassLoginGuideHelperV2$Companion$routeToSmsLoginDialogIfEnableV2$1 = new OnePassLoginGuideHelperV2$Companion$routeToSmsLoginDialogIfEnableV2$1(this, continuation);
            Object $result2 = onePassLoginGuideHelperV2$Companion$routeToSmsLoginDialogIfEnableV2$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (onePassLoginGuideHelperV2$Companion$routeToSmsLoginDialogIfEnableV2$1.label) {
            }
        }

        static /* synthetic */ Object routeToSmsLoginDialogIfEnableV2$default(Companion companion, boolean z, FragmentActivity fragmentActivity, TInfoLogin tInfoLogin, boolean z2, boolean z3, String str, Continuation continuation, int i, Object obj) {
            boolean z4;
            String str2;
            if ((i & 1) == 0) {
                z4 = z;
            } else {
                z4 = false;
            }
            if ((i & 32) == 0) {
                str2 = str;
            } else {
                str2 = "enter_homepage";
            }
            return companion.routeToSmsLoginDialogIfEnableV2(z4, fragmentActivity, tInfoLogin, z2, z3, str2, continuation);
        }

        public static /* synthetic */ boolean routeToSmsLoginDialogIfEnable$core_apinkDebug$default(Companion companion, Context context, TInfoLogin tInfoLogin, int i, boolean z, boolean z2, boolean z3, int i2, String str, int i3, Object obj) {
            int i4;
            String str2;
            if ((i3 & 64) == 0) {
                i4 = i2;
            } else {
                i4 = 2050;
            }
            if ((i3 & BR.cover) == 0) {
                str2 = str;
            } else {
                str2 = "enter_homepage";
            }
            return companion.routeToSmsLoginDialogIfEnable$core_apinkDebug(context, tInfoLogin, i, z, z2, z3, i4, str2);
        }

        public final boolean routeToSmsLoginDialogIfEnable$core_apinkDebug(final Context ctx, final TInfoLogin info, int showDialogTime, final boolean fromVideo, final boolean ignoreOnlineParams, boolean independentLimit, int priority, final String fromSpmid) {
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            SharedPreferences sharedPreferences = BiliGlobalPreferenceHelper.getBLKVSharedPreference(ctx);
            long lastShowTime = sharedPreferences.getLong(OnePassLoginGuideHelperV2.PREF_LAST_SMS_LOGIN_GUIDE_SHOW_TIME, 0L);
            boolean z = true;
            boolean isShowTime = System.currentTimeMillis() - lastShowTime >= getInterval();
            if ((info != null && info.isSmsLoginEnable()) && isShowTime) {
                MainDialogManager.DialogManagerInfo managerInfo = new MainDialogManager.DialogManagerInfo("login_guide", new MainDialogManager.IDialogInterface() { // from class: tv.danmaku.bili.ui.login.OnePassLoginGuideHelperV2$Companion$$ExternalSyntheticLambda4
                    public final void onShow() {
                        OnePassLoginGuideHelperV2.Companion.routeToSmsLoginDialogIfEnable$lambda$0(ctx, ignoreOnlineParams, fromSpmid, info, fromVideo);
                    }
                }, priority);
                MainDialogManager.addDialog(managerInfo, ctx);
                return true;
            }
            if (info == null || !info.isSmsLoginEnable()) {
                z = false;
            }
            if (z) {
                LoginReporterV2.Error.report(LoginReporterV2.Error.APP_SMS_LOGIN2_FAIL, "enter_homepage", "3");
                BLog.i(OnePassLoginGuideHelperV2.TAG, "cancel show sms login dialog because last show time is " + lastShowTime);
            } else {
                LoginReporterV2.Error.report(LoginReporterV2.Error.APP_SMS_LOGIN2_FAIL, "enter_homepage", "3");
                BLog.i(OnePassLoginGuideHelperV2.TAG, "cancel show sms login dialog because rule not allow sms login");
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void routeToSmsLoginDialogIfEnable$lambda$0(Context $ctx, boolean $ignoreOnlineParams, String $fromSpmid, TInfoLogin $info, boolean $fromVideo) {
            boolean isLogin = BiliAccounts.get($ctx).isLogin();
            boolean isIntercepted = LoginDialogInterceptor.Companion.onInterceptHomeSmsLoginDialog($ignoreOnlineParams);
            if (isLogin || isIntercepted) {
                if (isLogin) {
                    BLog.i(OnePassLoginGuideHelperV2.TAG, "user is login,show next dialog");
                } else if (isIntercepted) {
                    BLog.i(OnePassLoginGuideHelperV2.TAG, "home > showing sms dialog has been intercepted.");
                }
                MainDialogManager.showNextDialog("login_guide", false, $ctx);
            } else if (BiliContext.topActivitiy() instanceof IDrawerHost) {
                BLog.i(OnePassLoginGuideHelperV2.TAG, "show sms login dialog");
                LoginReportHelper.INSTANCE.setFromSpmid($fromSpmid);
                TInfoLogin.AB ab = $info.ab;
                RouteUtilKt.showSmsLoginDialog$default($ctx, "home", null, null, ab != null ? ab.isSmsLoginExp() : false, 12, null);
                OnePassLoginGuideHelperV2.Companion.reportLoginDialog($fromVideo, false);
            } else {
                BLog.i(OnePassLoginGuideHelperV2.TAG, "cancel show sms because is not main,show next dialog");
                LoginReporterV2.Error.report(LoginReporterV2.Error.APP_SMS_LOGIN2_FAIL, "enter_homepage", "3");
                MainDialogManager.showNextDialog("login_guide", false, $ctx);
            }
        }

        private final boolean routeToFastReLoginV2(Context ctx, SimpleAccountItem accountInfo) {
            boolean isLogin = BiliAccounts.get(ctx).isLogin();
            if (isLogin || accountInfo == null) {
                return false;
            }
            RouteUtilKt.routeFastReLoginDialog(ctx, null, null, null, true, accountInfo);
            return true;
        }

        public final void routeToFastReLogin$core_apinkDebug(final Context ctx, final SimpleAccountItem accountInfo) {
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            MainDialogManager.DialogManagerInfo managerInfo = new MainDialogManager.DialogManagerInfo("login_guide", new MainDialogManager.IDialogInterface() { // from class: tv.danmaku.bili.ui.login.OnePassLoginGuideHelperV2$Companion$$ExternalSyntheticLambda0
                public final void onShow() {
                    OnePassLoginGuideHelperV2.Companion.routeToFastReLogin$lambda$0(ctx, accountInfo);
                }
            }, 2050);
            MainDialogManager.addDialog(managerInfo, ctx);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void routeToFastReLogin$lambda$0(Context $ctx, SimpleAccountItem $accountInfo) {
            boolean isLogin = BiliAccounts.get($ctx).isLogin();
            if (isLogin || $accountInfo == null) {
                MainDialogManager.showNextDialog("login_guide", false, $ctx);
            } else {
                RouteUtilKt.routeFastReLoginDialog($ctx, null, null, null, true, $accountInfo);
            }
        }

        static /* synthetic */ boolean routeToLoginQuickV2$default(Companion companion, Context context, boolean z, boolean z2, Pair pair, boolean z3, boolean z4, boolean z5, String str, String str2, int i, Object obj) {
            return companion.routeToLoginQuickV2(context, z, z2, pair, z3, (i & 32) != 0 ? false : z4, (i & 64) != 0 ? false : z5, (i & BR.cover) != 0 ? null : str, (i & BR.hallEnterHotText) != 0 ? "enter_homepage" : str2);
        }

        private final boolean routeToLoginQuickV2(Context ctx, boolean enableSms, boolean smsDirect, Pair<String, Boolean> pair, boolean fromVideo, boolean loginExperiment, boolean loginExperimentForPeagsus, String loginExperimentValue, String fromSpmid) {
            boolean isLogin = BiliAccounts.get(ctx).isLogin();
            boolean isIntercepted = LoginDialogInterceptor.Companion.onInterceptHomeLoginQuickDialog();
            if ((isLogin || isIntercepted) && !loginExperiment) {
                String str = "";
                if (isLogin) {
                    OnePassLoginPathLinkManager onePassLoginPathLinkManager = OnePassLoginPathLinkManager.INSTANCE;
                    if (fromSpmid != null) {
                        str = fromSpmid;
                    }
                    onePassLoginPathLinkManager.stopWithReason(str, OnePassLoginReportManagerKt.INTERRUPTED_FOR_ALREADY_LOGIN);
                    BLog.i(OnePassLoginGuideHelperV2.TAG, "user is login,show next dialog");
                } else if (isIntercepted) {
                    OnePassLoginPathLinkManager onePassLoginPathLinkManager2 = OnePassLoginPathLinkManager.INSTANCE;
                    if (fromSpmid != null) {
                        str = fromSpmid;
                    }
                    onePassLoginPathLinkManager2.stopWithReason(str, "hit config : tm_onepassguide_switch");
                    BLog.i(OnePassLoginGuideHelperV2.TAG, "home > showing login quick dialog has been intercepted.");
                }
                return false;
            }
            LoginSceneProcessor.INSTANCE.setScene("main_new");
            LoginReportHelper.INSTANCE.setFromSpmid(fromSpmid);
            HashMap params = new HashMap();
            params.put(LoginReporterV2.APP_ONEPASS_KEY_OPERATOR, pair.getFirst());
            Neurons.reportExposure$default(false, "main.homepage.onepass-popup.0.show", params, (List) null, 8, (Object) null);
            if (loginExperiment) {
                MainDialogManager.sShowedPriorities.clear();
            }
            RouteUtilKt.routeToLoginQuickActivity$default(ctx, null, Boolean.valueOf(enableSms), true, Boolean.valueOf(smsDirect), null, null, null, null, true, null, Boolean.valueOf(loginExperimentForPeagsus), loginExperimentValue, 1088, null);
            reportLoginDialog(fromVideo, true);
            return true;
        }

        public final void routeToLoginQuick$core_apinkDebug(final Context ctx, final boolean enableSms, final boolean smsDirect, long skipTime, int lastMaxTimes, final Pair<String, Boolean> pair, final boolean fromVideo, boolean independentLimit, int priority, final String priorityKey, final boolean loginExperiment, final boolean loginExperimentForPeagsus, final String loginExperimentValue, final String fromSpmid) {
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            Intrinsics.checkNotNullParameter(pair, "pair");
            Intrinsics.checkNotNullParameter(priorityKey, "priorityKey");
            final boolean notOnlyMain = Intrinsics.areEqual(fromSpmid, "enter_homepage");
            MainDialogManager.DialogManagerInfo managerInfo = new MainDialogManager.DialogManagerInfo(priorityKey, new MainDialogManager.IDialogInterface() { // from class: tv.danmaku.bili.ui.login.OnePassLoginGuideHelperV2$Companion$$ExternalSyntheticLambda2
                public final void onShow() {
                    OnePassLoginGuideHelperV2.Companion.routeToLoginQuick$lambda$0(ctx, loginExperiment, fromSpmid, priorityKey, notOnlyMain, pair, enableSms, smsDirect, loginExperimentForPeagsus, loginExperimentValue, fromVideo);
                }
            }, priority);
            managerInfo.setMainOnly(!notOnlyMain);
            MainDialogManager.addDialog(managerInfo, ctx);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void routeToLoginQuick$lambda$0(Context $ctx, boolean $loginExperiment, String $fromSpmid, String $priorityKey, boolean $notOnlyMain, Pair $pair, boolean $enableSms, boolean $smsDirect, boolean $loginExperimentForPeagsus, String $loginExperimentValue, boolean $fromVideo) {
            boolean isLogin = BiliAccounts.get($ctx).isLogin();
            boolean isIntercepted = LoginDialogInterceptor.Companion.onInterceptHomeLoginQuickDialog();
            if ((isLogin || isIntercepted) && !$loginExperiment) {
                if (isLogin) {
                    OnePassLoginPathLinkManager.INSTANCE.stopWithReason($fromSpmid != null ? $fromSpmid : "", OnePassLoginReportManagerKt.INTERRUPTED_FOR_ALREADY_LOGIN);
                    BLog.i(OnePassLoginGuideHelperV2.TAG, "user is login,show next dialog");
                } else if (isIntercepted) {
                    OnePassLoginPathLinkManager.INSTANCE.stopWithReason($fromSpmid != null ? $fromSpmid : "", "hit config : tm_onepassguide_switch");
                    BLog.i(OnePassLoginGuideHelperV2.TAG, "home > showing login quick dialog has been intercepted.");
                }
                MainDialogManager.showNextDialog($priorityKey, false, $ctx);
            } else if ($notOnlyMain || (BiliContext.topActivitiy() instanceof IDrawerHost)) {
                LoginSceneProcessor.INSTANCE.setScene("main_new");
                LoginReportHelper.INSTANCE.setFromSpmid($fromSpmid);
                HashMap params = new HashMap();
                params.put(LoginReporterV2.APP_ONEPASS_KEY_OPERATOR, $pair.getFirst());
                Neurons.reportExposure$default(false, "main.homepage.onepass-popup.0.show", params, (List) null, 8, (Object) null);
                if ($loginExperiment) {
                    MainDialogManager.sShowedPriorities.clear();
                }
                RouteUtilKt.routeToLoginQuickActivity$default($ctx, null, Boolean.valueOf($enableSms), true, Boolean.valueOf($smsDirect), null, null, null, null, true, null, Boolean.valueOf($loginExperimentForPeagsus), $loginExperimentValue, 1088, null);
                OnePassLoginGuideHelperV2.Companion.reportLoginDialog($fromVideo, true);
            } else {
                OnePassLoginPathLinkManager.INSTANCE.stopWithReason($fromSpmid != null ? $fromSpmid : "", OnePassLoginReportManagerKt.INTERRUPTED_FOR_NOT_IN_HOME_PAGE);
                BLog.i(OnePassLoginGuideHelperV2.TAG, "is not main,show next dialog");
                LoginReporterV2.Error.report(LoginReporterV2.Error.APP_ONE_PASS_LOGIN_FAIL, "enter_homepage", "3");
                MainDialogManager.showNextDialog($priorityKey, false, $ctx);
            }
        }

        static /* synthetic */ void routeToLoginQuickDirectly$default(Companion companion, Context context, boolean z, boolean z2, Pair pair, boolean z3, boolean z4, String str, String str2, int i, Object obj) {
            boolean z5;
            String str3;
            if ((i & 32) == 0) {
                z5 = z4;
            } else {
                z5 = false;
            }
            if ((i & 64) == 0) {
                str3 = str;
            } else {
                str3 = null;
            }
            companion.routeToLoginQuickDirectly(context, z, z2, pair, z3, z5, str3, str2);
        }

        private final void routeToLoginQuickDirectly(Context ctx, boolean enableSms, boolean smsDirect, Pair<String, Boolean> pair, boolean fromVideo, boolean loginExperimentForPeagsus, String loginExperimentValue, String fromSpmid) {
            if (!(BiliContext.topActivitiy() instanceof IDrawerHost)) {
                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(fromSpmid, OnePassLoginReportManagerKt.INTERRUPTED_FOR_NOT_IN_HOME_PAGE);
                return;
            }
            LoginSceneProcessor.INSTANCE.setScene("main_new");
            LoginReportHelper.INSTANCE.setFromSpmid("enter_homepage");
            HashMap params = new HashMap();
            params.put(LoginReporterV2.APP_ONEPASS_KEY_OPERATOR, pair.getFirst());
            Neurons.reportExposure$default(false, "main.homepage.onepass-popup.0.show", params, (List) null, 8, (Object) null);
            LoginReportHelper.INSTANCE.setFromSpmid(fromSpmid);
            RouteUtilKt.routeToLoginQuickActivity$default(ctx, null, Boolean.valueOf(enableSms), true, Boolean.valueOf(smsDirect), null, null, null, null, true, null, Boolean.valueOf(loginExperimentForPeagsus), loginExperimentValue, 1088, null);
            reportLoginDialog(fromVideo, true);
        }

        public static /* synthetic */ void startCheckShowOnePassLoginGuide$default(Companion companion, Fragment fragment, String str, boolean z, FragmentActivity fragmentActivity, Function1 function1, int i, Object obj) {
            String str2;
            if ((i & 2) == 0) {
                str2 = str;
            } else {
                str2 = "enter_homepage";
            }
            companion.startCheckShowOnePassLoginGuide(fragment, str2, z, fragmentActivity, function1);
        }

        @JvmStatic
        public final void startCheckShowOnePassLoginGuide(Fragment fragment, String fromSpmid, boolean isStartUpFragment, FragmentActivity activity, Function1<? super Integer, Boolean> function1) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(fromSpmid, "fromSpmid");
            Intrinsics.checkNotNullParameter(function1, AuthResultCbHelper.ARGS_CALLBACK);
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) fragment), (CoroutineContext) null, (CoroutineStart) null, new OnePassLoginGuideHelperV2$Companion$startCheckShowOnePassLoginGuide$1(fragment, fromSpmid, isStartUpFragment, activity, function1, null), 3, (Object) null);
        }

        public static /* synthetic */ Object startCheckShowOnePassLoginGuide$default(Companion companion, String str, boolean z, FragmentActivity fragmentActivity, Function1 function1, Continuation continuation, int i, Object obj) {
            String str2;
            if ((i & 1) == 0) {
                str2 = str;
            } else {
                str2 = "enter_homepage";
            }
            return companion.startCheckShowOnePassLoginGuide(str2, z, fragmentActivity, function1, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00a4  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00aa  */
        @JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object startCheckShowOnePassLoginGuide(String fromSpmid, boolean isStartUpFragment, FragmentActivity activity, Function1<? super Integer, Boolean> function1, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> onePassLoginGuideHelperV2$Companion$startCheckShowOnePassLoginGuide$2;
            boolean isStartUpFragment2;
            if (continuation instanceof OnePassLoginGuideHelperV2$Companion$startCheckShowOnePassLoginGuide$2) {
                onePassLoginGuideHelperV2$Companion$startCheckShowOnePassLoginGuide$2 = (OnePassLoginGuideHelperV2$Companion$startCheckShowOnePassLoginGuide$2) continuation;
                if ((onePassLoginGuideHelperV2$Companion$startCheckShowOnePassLoginGuide$2.label & Integer.MIN_VALUE) != 0) {
                    onePassLoginGuideHelperV2$Companion$startCheckShowOnePassLoginGuide$2.label -= Integer.MIN_VALUE;
                    Object $result = onePassLoginGuideHelperV2$Companion$startCheckShowOnePassLoginGuide$2.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (onePassLoginGuideHelperV2$Companion$startCheckShowOnePassLoginGuide$2.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            boolean isSatisfyCondition = LoginPlayStatusHelper.INSTANCE.hasPlayed(new String[]{"ugc", ReportUtilKt.CONTENT_TYPE_OGV, AppConfig.HOST_STORY});
                            if (BiliAccounts.get((Context) activity).isLogin()) {
                                OnePassLoginPathLinkManager.INSTANCE.stopWithReason(fromSpmid, OnePassLoginReportManagerKt.INTERRUPTED_FOR_ALREADY_LOGIN);
                                if (isSatisfyCondition && OnePassLoginGuideHelperV2.mIsFirstStart) {
                                    GrowthCenterImpl.INSTANCE.onAction((GrowthAction) new GrowthAction.Resume(true));
                                }
                                return Unit.INSTANCE;
                            } else if (((Boolean) function1.invoke(Boxing.boxInt(1))).booleanValue()) {
                                boolean z = !isStartUpFragment;
                                boolean z2 = isSatisfyCondition;
                                onePassLoginGuideHelperV2$Companion$startCheckShowOnePassLoginGuide$2.Z$0 = isStartUpFragment;
                                onePassLoginGuideHelperV2$Companion$startCheckShowOnePassLoginGuide$2.label = 1;
                                if (realCheckShowOnePassLoginGuide(activity, z, z2, fromSpmid, onePassLoginGuideHelperV2$Companion$startCheckShowOnePassLoginGuide$2) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                isStartUpFragment2 = isStartUpFragment;
                                if (!isStartUpFragment2) {
                                    BLog.i(OnePassLoginGuideHelperV2.TAG, "hit rule B,check enter ugc");
                                    break;
                                } else {
                                    BLog.i(OnePassLoginGuideHelperV2.TAG, "hit rule B,check enter ugc by selectChange");
                                    break;
                                }
                            }
                            break;
                        case 1:
                            isStartUpFragment2 = onePassLoginGuideHelperV2$Companion$startCheckShowOnePassLoginGuide$2.Z$0;
                            ResultKt.throwOnFailure($result);
                            if (!isStartUpFragment2) {
                            }
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }
            onePassLoginGuideHelperV2$Companion$startCheckShowOnePassLoginGuide$2 = new OnePassLoginGuideHelperV2$Companion$startCheckShowOnePassLoginGuide$2(this, continuation);
            Object $result2 = onePassLoginGuideHelperV2$Companion$startCheckShowOnePassLoginGuide$2.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (onePassLoginGuideHelperV2$Companion$startCheckShowOnePassLoginGuide$2.label) {
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final Object realCheckShowOnePassLoginGuide(FragmentActivity activity, boolean selectChange, boolean isSatisfyCondition, String fromSpmid, Continuation<? super Unit> continuation) {
            if (OnePassLoginGuideHelperV2.mIsFirstStart) {
                if (isSatisfyCondition) {
                    OnePassLoginPathLinkManager.INSTANCE.onPhase("enter_homepage", OnePassLoginPhaseType.Trigger.INSTANCE);
                    showOnePassLoginGuide(fromSpmid, activity, true);
                }
            } else if (!isSatisfyCondition) {
                if (!OnePassLoginGuideHelperV2.mTryShowOnePassGuide && !selectChange) {
                    OnePassLoginPathLinkManager.INSTANCE.onPhase("enter_homepage", OnePassLoginPhaseType.Trigger.INSTANCE);
                    showOnePassLoginGuide(fromSpmid, activity, false);
                    OnePassLoginGuideHelperV2.mTryShowOnePassGuide = true;
                }
            } else {
                MainDialogManager.sShowedPriorities.clear();
                OnePassLoginPathLinkManager.INSTANCE.onPhase("enter_homepage", OnePassLoginPhaseType.Trigger.INSTANCE);
                showOnePassLoginGuide(fromSpmid, activity, true);
            }
            return Unit.INSTANCE;
        }

        @JvmStatic
        public final boolean checkMainPage() {
            return UriUtils.equals(BottomTabSelectedHelper.INSTANCE.getCurrentBottomTabUrl(), "bilibili://main/home");
        }

        private final void reportLoginDialog(boolean fromVideo, boolean isOnepass) {
            HashMap map = new HashMap();
            map.put("event_id_from", fromVideo ? "return-from-video" : "slide-tmcard");
            map.put("popup_type", isOnepass ? "onepass" : "sms");
            LoginReporterV2.Show.report(LoginReporterV2.Show.HOMEPAGE_LOGIN_POPUP_SHOW, map);
        }
    }

    @JvmStatic
    private static final void showOnePassLoginGuide(String fromSpmid, FragmentActivity activity, boolean fromVideo) {
        Companion.showOnePassLoginGuide(fromSpmid, activity, fromVideo);
    }

    @JvmStatic
    public static final void startCheckShowOnePassLoginGuide(Fragment fragment, String fromSpmid, boolean isStartUpFragment, FragmentActivity activity, Function1<? super Integer, Boolean> function1) {
        Companion.startCheckShowOnePassLoginGuide(fragment, fromSpmid, isStartUpFragment, activity, function1);
    }

    @JvmStatic
    public static final Object startCheckShowOnePassLoginGuide(String fromSpmid, boolean isStartUpFragment, FragmentActivity activity, Function1<? super Integer, Boolean> function1, Continuation<? super Unit> continuation) {
        return Companion.startCheckShowOnePassLoginGuide(fromSpmid, isStartUpFragment, activity, function1, continuation);
    }

    @JvmStatic
    private static final Object realCheckShowOnePassLoginGuide(FragmentActivity activity, boolean selectChange, boolean isSatisfyCondition, String fromSpmid, Continuation<? super Unit> continuation) {
        return Companion.realCheckShowOnePassLoginGuide(activity, selectChange, isSatisfyCondition, fromSpmid, continuation);
    }

    @JvmStatic
    public static final boolean checkMainPage() {
        return Companion.checkMainPage();
    }

    public void updateOnePass(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context);
        int lastMaxTimes = sharedPreferences.getInt(PREF_LOGIN_ONE_PASS_GUIDE_TIMES, 0);
        sharedPreferences.edit().putInt(PREF_LOGIN_ONE_PASS_GUIDE_TIMES, lastMaxTimes + 1).putLong(PREF_LAST_ONE_PASS_LOGIN_GUIDE_SHOW_TIME, System.currentTimeMillis()).apply();
    }

    public void updateSms(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context);
        sharedPreferences.edit().putLong(PREF_LAST_SMS_LOGIN_GUIDE_SHOW_TIME, System.currentTimeMillis()).apply();
    }
}