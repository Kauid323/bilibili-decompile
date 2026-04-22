package tv.danmaku.bili.ui.main.usergrow;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bapis.bilibili.account.fission.v1.WindowReply;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.base.BiliContext;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteResponse;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.lib.homepage.util.BottomTabSelectedHelper;
import com.bilibili.lib.homepage.util.UriUtils;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.MainActivityV2;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.router.MainRouteUris;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.splash.ClipboardJumpHelper;
import tv.danmaku.bili.ui.splash.ad.page.HotSplashActivityKt;

/* compiled from: UserGrowManager.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001.B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0006\u0010\u0014\u001a\u00020\u0011J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0016\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005J,\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001cH\u0002J\u001c\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010!\u001a\u00020\u0016H\u0002J\u0012\u0010\"\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010&\u001a\u00020\u0011H\u0007J\b\u0010'\u001a\u00020\u0011H\u0002J\b\u0010(\u001a\u00020\u0016H\u0007J\b\u0010)\u001a\u00020\u0016H\u0002J\u0012\u0010*\u001a\u00020\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010+\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005J\u0010\u0010,\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005J\u0010\u0010-\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u000e\u0010#\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Ltv/danmaku/bili/ui/main/usergrow/UserGrowManager;", "", "<init>", "()V", "TAG", "", "URL_MAIN", "URL_MINE", "KEY_TRACK_ENABLE", "KEY_TRACK_DATA", "FISSION_URL_REGEX", "FISSION_WORD_REGEX", "getFISSION_WORD_REGEX", "()Ljava/lang/String;", "SHARE_WORD_REGEX", "getSHARE_WORD_REGEX", "checkLazyShow", "", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "notifyHotSplashDismiss", "skipCheck", "", "showUserGrowDialog", "context", "Landroid/content/Context;", "url", AuthResultCbHelper.ARGS_CALLBACK, "Lkotlin/Function0;", "jumpPage", "data", "Ltv/danmaku/bili/ui/main/usergrow/UserGrowManager$JumpData;", "trackData", "canShowDialog", "checkPage", "isCheckingWindow", "windowChecker", "checkClipboardJump", "checkActivityWindow", "checkWindowInternal", "checkHomePage", "canJump", "isInMutiWindowMode", "reportParseUrl", "reportExParseUrl", "reportDialogShow", "JumpData", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class UserGrowManager {
    public static final int $stable;
    public static final String FISSION_URL_REGEX = "^([\\u4e00-\\u9fa5\\sa-zA-Z0-9,.#?。!！]{1,60})\\s(https?://www\\.bilibili\\.com/blackboard/redpack/[a-zA-Z0-9-]+(\\.html)?)(\\?from=[a-zA-Z0-9]+)?$";
    public static final String KEY_TRACK_DATA = "key_track_data";
    public static final String KEY_TRACK_ENABLE = "key_track_enable";
    public static final String TAG = "UserGrow";
    public static final String URL_MAIN = "bilibili://main/home";
    private static final String URL_MINE = "bilibili://user_center/mine";
    private static boolean checkClipboardJump;
    private static boolean isCheckingWindow;
    private static Function0<Unit> windowChecker;
    public static final UserGrowManager INSTANCE = new UserGrowManager();
    private static final String FISSION_WORD_REGEX = UserGrowHelperKt.getFissionWordRegex();
    private static final String SHARE_WORD_REGEX = UserGrowHelperKt.getShareWordRegex();

    private UserGrowManager() {
    }

    static {
        Application context = BiliContext.application();
        if (context != null && BiliContext.isMainProcess()) {
            UserGrowSpHelper.Companion.setDialogShowing(context, false);
        }
        checkClipboardJump = true;
        $stable = 8;
    }

    public final String getFISSION_WORD_REGEX() {
        return FISSION_WORD_REGEX;
    }

    public final String getSHARE_WORD_REGEX() {
        return SHARE_WORD_REGEX;
    }

    @JvmStatic
    public static final void checkLazyShow(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        if (UserGrowSpHelper.Companion.needShowForLogin(activity) && BiliAccounts.get(activity).isLogin()) {
            String jumpUrl = UserGrowSpHelper.Companion.getJumpUrlForLogin(activity);
            if (TextUtils.isEmpty(jumpUrl)) {
                UserGrowSpHelper.Companion.setNeedShowForLogin(activity, false, "");
            }
            INSTANCE.showUserGrowDialog(activity, jumpUrl, new Function0() { // from class: tv.danmaku.bili.ui.main.usergrow.UserGrowManager$$ExternalSyntheticLambda3
                public final Object invoke() {
                    Unit checkLazyShow$lambda$0;
                    checkLazyShow$lambda$0 = UserGrowManager.checkLazyShow$lambda$0(activity);
                    return checkLazyShow$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkLazyShow$lambda$0(Activity $activity) {
        UserGrowSpHelper.Companion.setNeedShowForLogin($activity, false, "");
        return Unit.INSTANCE;
    }

    public final void notifyHotSplashDismiss() {
        Function0<Unit> function0 = windowChecker;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final boolean skipCheck() {
        return RestrictedMode.isRestrictedMode() || isInMutiWindowMode(BiliContext.topActivitiy());
    }

    public final void showUserGrowDialog(final Context context, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        UserGrowSpHelper.Companion.setNeedShowForLogin(context, true, url);
        showUserGrowDialog(context, url, new Function0() { // from class: tv.danmaku.bili.ui.main.usergrow.UserGrowManager$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit showUserGrowDialog$lambda$0;
                showUserGrowDialog$lambda$0 = UserGrowManager.showUserGrowDialog$lambda$0(context);
                return showUserGrowDialog$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showUserGrowDialog$lambda$0(Context $context) {
        UserGrowSpHelper.Companion.setNeedShowForLogin($context, false, "");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void showUserGrowDialog$default(UserGrowManager userGrowManager, Context context, String str, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        userGrowManager.showUserGrowDialog(context, str, function0);
    }

    private final void showUserGrowDialog(final Context context, final String url, final Function0<Unit> function0) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        MainDialogManager.DialogManagerInfo dialogInfo = new MainDialogManager.DialogManagerInfo("clipboard", new MainDialogManager.IDialogInterface() { // from class: tv.danmaku.bili.ui.main.usergrow.UserGrowManager$$ExternalSyntheticLambda9
            public final void onShow() {
                UserGrowManager.showUserGrowDialog$lambda$1(context, url, function0);
            }
        }, 1010, false);
        dialogInfo.setMultiProcess(true);
        MainDialogManager.addDialog(dialogInfo, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showUserGrowDialog$lambda$1(Context $context, String $url, Function0 $callback) {
        if (!INSTANCE.canShowDialog()) {
            MainDialogManager.showNextDialog("clipboard", false, $context);
            return;
        }
        try {
            Activity activity = BiliContext.topActivitiy();
            RouteRequest request = new RouteRequest.Builder(MainRouteUris.ROUTE_ACTIVIRY_USER_GROW).data(Uri.parse($url)).build();
            RouteResponse response = BLRouter.routeTo(request, activity);
            if (response.isSuccess()) {
                INSTANCE.reportDialogShow($url);
                if ($callback != null) {
                    $callback.invoke();
                }
            } else {
                MainDialogManager.showNextDialog("clipboard", false, activity);
            }
        } catch (Throwable e) {
            BLog.e(TAG, "start user grow dialog error", e);
        }
    }

    static /* synthetic */ void jumpPage$default(UserGrowManager userGrowManager, JumpData jumpData, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        userGrowManager.jumpPage(jumpData, str);
    }

    private final void jumpPage(final JumpData data, final String trackData) {
        final Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        MainDialogManager.DialogManagerInfo dialogInfo = new MainDialogManager.DialogManagerInfo("fission_act", new MainDialogManager.IDialogInterface() { // from class: tv.danmaku.bili.ui.main.usergrow.UserGrowManager$$ExternalSyntheticLambda2
            public final void onShow() {
                UserGrowManager.jumpPage$lambda$0(context, data, trackData);
            }
        }, 2005, false);
        dialogInfo.setMultiProcess(true);
        MainDialogManager.addDialog(dialogInfo, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jumpPage$lambda$0(Application $context, JumpData $data, final String $trackData) {
        RouteRequest req;
        if (!INSTANCE.canJump()) {
            Pair[] pairArr = new Pair[2];
            pairArr[0] = TuplesKt.to("isShow", "false");
            Activity activity = BiliContext.topActivitiy();
            pairArr[1] = TuplesKt.to("currentPage", activity != null ? activity.getLocalClassName() : null);
            Neurons.trackT$default(false, "main.7days.window.show", MapsKt.mapOf(pairArr), 0, new Function0() { // from class: tv.danmaku.bili.ui.main.usergrow.UserGrowManager$$ExternalSyntheticLambda4
                public final Object invoke() {
                    boolean jumpPage$lambda$0$0;
                    jumpPage$lambda$0$0 = UserGrowManager.jumpPage$lambda$0$0();
                    return Boolean.valueOf(jumpPage$lambda$0$0);
                }
            }, 8, (Object) null);
            MainDialogManager.showNextDialog("fission_act", false, $context);
            return;
        }
        switch ($data.getType()) {
            case 0:
                req = new RouteRequest.Builder(MainRouteUris.ROUTE_ACTIVIRY_USER_GROW).data(Uri.parse($data.getUrl())).extras(new Function1() { // from class: tv.danmaku.bili.ui.main.usergrow.UserGrowManager$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        Unit jumpPage$lambda$0$1;
                        jumpPage$lambda$0$1 = UserGrowManager.jumpPage$lambda$0$1($trackData, (MutableBundleLike) obj);
                        return jumpPage$lambda$0$1;
                    }
                }).addFlag(268435456).build();
                break;
            case 1:
                Uri parse = Uri.parse($data.getUrl());
                Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                req = new RouteRequest.Builder(parse).addFlag(268435456).build();
                break;
            default:
                MainDialogManager.showNextDialog("fission_act", false, $context);
                return;
        }
        BLRouter.routeTo(req, $context);
        Neurons.trackT$default(false, "main.7days.window.show", MapsKt.mapOf(TuplesKt.to("isShow", "true")), 0, new Function0() { // from class: tv.danmaku.bili.ui.main.usergrow.UserGrowManager$$ExternalSyntheticLambda6
            public final Object invoke() {
                boolean jumpPage$lambda$0$2;
                jumpPage$lambda$0$2 = UserGrowManager.jumpPage$lambda$0$2();
                return Boolean.valueOf(jumpPage$lambda$0$2);
            }
        }, 8, (Object) null);
        if ($data.getType() == 0) {
            Neurons.report$default(false, 0, "growth.recommended.window.0.other", MapsKt.mapOf(TuplesKt.to("report_data", $trackData)), (String) null, 0, 48, (Object) null);
        }
        BLog.i(TAG, "Jump to page: " + $data.getUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean jumpPage$lambda$0$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit jumpPage$lambda$0$1(String $trackData, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        $this$extras.put(KEY_TRACK_ENABLE, "true");
        $this$extras.put(KEY_TRACK_DATA, $trackData == null ? "" : $trackData);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean jumpPage$lambda$0$2() {
        return true;
    }

    private final boolean canShowDialog() {
        Activity topActivity = BiliContext.topActivitiy();
        return (topActivity instanceof MainActivityV2) && checkPage(BottomTabSelectedHelper.INSTANCE.getCurrentBottomTabUrl()) && ConnectivityMonitor.getInstance().isNetworkActive() && !RestrictedMode.isRestrictedMode() && !isInMutiWindowMode(topActivity);
    }

    @JvmStatic
    public static final boolean checkPage(String url) {
        return UriUtils.equals(url, "bilibili://main/home") || UriUtils.equals(url, "bilibili://user_center/mine");
    }

    @JvmStatic
    public static final void checkActivityWindow() {
        if (isCheckingWindow || INSTANCE.skipCheck()) {
            return;
        }
        if (checkClipboardJump && ClipboardJumpHelper.isClipboardJumped()) {
            BLog.d(TAG, "skip check window cause clipboard jump on startup");
            checkClipboardJump = false;
            return;
        }
        checkClipboardJump = false;
        if (HotSplashActivityKt.isHotSplashShowing || tv.danmaku.bili.splash.ad.page.HotSplashActivityKt.isHotSplashShowing) {
            windowChecker = new Function0() { // from class: tv.danmaku.bili.ui.main.usergrow.UserGrowManager$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit checkActivityWindow$lambda$0;
                    checkActivityWindow$lambda$0 = UserGrowManager.checkActivityWindow$lambda$0();
                    return checkActivityWindow$lambda$0;
                }
            };
        } else {
            INSTANCE.checkWindowInternal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkActivityWindow$lambda$0() {
        INSTANCE.checkWindowInternal();
        windowChecker = null;
        return Unit.INSTANCE;
    }

    private final void checkWindowInternal() {
        if (DeviceDecision.INSTANCE.getBoolean("dd.bilibili_account_fission_v1_disable", true)) {
            return;
        }
        isCheckingWindow = true;
        BLog.d(TAG, "start check activity window");
        UserGrowApiHelper.Companion.checkActivityWindow(new Function1() { // from class: tv.danmaku.bili.ui.main.usergrow.UserGrowManager$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                Unit checkWindowInternal$lambda$0;
                checkWindowInternal$lambda$0 = UserGrowManager.checkWindowInternal$lambda$0((WindowReply) obj);
                return checkWindowInternal$lambda$0;
            }
        }, new Function0() { // from class: tv.danmaku.bili.ui.main.usergrow.UserGrowManager$$ExternalSyntheticLambda8
            public final Object invoke() {
                Unit checkWindowInternal$lambda$1;
                checkWindowInternal$lambda$1 = UserGrowManager.checkWindowInternal$lambda$1();
                return checkWindowInternal$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkWindowInternal$lambda$0(WindowReply reply) {
        if (reply != null) {
            WindowReply it = !TextUtils.isEmpty(reply.getUrl()) ? reply : null;
            if (it != null) {
                String reportData = it.getReportData();
                if (reportData == null) {
                    reportData = "";
                }
                INSTANCE.jumpPage(new JumpData(it.getType(), it.getUrl()), reportData);
                Neurons.report$default(false, 0, "growth.recommended.window.middle.other", MapsKt.mapOf(TuplesKt.to("report_data", reportData)), (String) null, 0, 48, (Object) null);
            }
        }
        isCheckingWindow = false;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkWindowInternal$lambda$1() {
        isCheckingWindow = false;
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final boolean checkHomePage() {
        return UriUtils.equals(BottomTabSelectedHelper.INSTANCE.getCurrentBottomTabUrl(), "bilibili://main/home");
    }

    private final boolean canJump() {
        Activity topActivity = BiliContext.topActivitiy();
        boolean result = BiliContext.isVisible() && ConnectivityMonitor.getInstance().isNetworkActive() && !RestrictedMode.isRestrictedMode() && !isInMutiWindowMode(topActivity);
        boolean isMain = (topActivity instanceof MainActivityV2) && MainDialogManager.isMainVisible && UriUtils.equals(BottomTabSelectedHelper.INSTANCE.getCurrentBottomTabUrl(), "bilibili://main/home");
        boolean isFission = topActivity instanceof UserGrowDialogWebActivity;
        return (isMain || isFission) && result;
    }

    private final boolean isInMutiWindowMode(Activity activity) {
        return activity != null && Build.VERSION.SDK_INT >= 24 && activity.isInMultiWindowMode();
    }

    public final void reportParseUrl(String url) {
        Neurons.report$default(false, 0, "main.GrowthHacker.FirstbootfromCopyLink.other", MapsKt.mapOf(TuplesKt.to("copy_url", url)), (String) null, 0, 48, (Object) null);
    }

    public final void reportExParseUrl(String url) {
        Neurons.report$default(false, 0, "main.GrowthHacker.fromActCopyLink.other", MapsKt.mapOf(TuplesKt.to("copy_url", url)), (String) null, 0, 48, (Object) null);
    }

    public final void reportDialogShow(String url) {
        Neurons.reportExposure$default(false, "traffic.home-page-my-page-webview.tianmawebview.0.show", MapsKt.mapOf(TuplesKt.to("copy_url", url)), (List) null, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UserGrowManager.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/ui/main/usergrow/UserGrowManager$JumpData;", "", "type", "", "url", "", "<init>", "(ILjava/lang/String;)V", "getType", "()I", "getUrl", "()Ljava/lang/String;", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class JumpData {
        public static final Companion Companion = new Companion(null);
        public static final int DIALOG_VIEW_TYPE = 0;
        public static final int PAGE_VIEW_TYPE = 1;
        private final int type;
        private final String url;

        /* compiled from: UserGrowManager.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/ui/main/usergrow/UserGrowManager$JumpData$Companion;", "", "<init>", "()V", "DIALOG_VIEW_TYPE", "", "PAGE_VIEW_TYPE", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public JumpData(int type, String url) {
            this.type = type;
            this.url = url;
        }

        public final int getType() {
            return this.type;
        }

        public final String getUrl() {
            return this.url;
        }
    }
}