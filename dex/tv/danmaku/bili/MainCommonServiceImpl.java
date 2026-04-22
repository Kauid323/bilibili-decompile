package tv.danmaku.bili;

import android.app.Activity;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.app.comm.restrict.RestrictedType;
import com.bilibili.app.preferences.Settings;
import com.bilibili.app.provider.UtilKt;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.BundleUtil;
import com.bilibili.droid.ProcessUtils;
import com.bilibili.freedata.ui.FreeDataMainModuleHelper;
import com.bilibili.gripper.api.updater.GUpdater;
import com.bilibili.gripper.api.updater.UpdaterActionType;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.ui.helper.FloatWindowPermissionHelper;
import com.bilibili.moduleservice.main.MainCommonService;
import com.bilibili.moduleservice.main.OnModifyNameCallback;
import com.bilibili.offline.StorageInfo;
import com.bilibili.teenagersmode.TeenagersMode;
import com.bilibili.videodownloader.utils.CustomDirUtils;
import dagger.hilt.EntryPoints;
import java.util.List;
import java.util.Map;
import javax.inject.Singleton;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.httpdns.AppHttpDnsProvider;
import tv.danmaku.bili.httpdns.api.AppHttpDnsKt;
import tv.danmaku.bili.push.pushsetting.manager.PushGuidanceManagerKt;
import tv.danmaku.bili.push.pushsetting.reporter.PushSettingReporterKt;
import tv.danmaku.bili.push.pushsetting.reporter.TrackTKt;
import tv.danmaku.bili.push.pushsetting.system.SystemPushDialogHelperKt;
import tv.danmaku.bili.router.actions.ImageSaveHelper;
import tv.danmaku.bili.router.actions.LocationHelper;
import tv.danmaku.bili.router.actions.NotificationSettingActions;
import tv.danmaku.bili.services.videodownload.utils.DownloadTaskTransfer;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.authority.AuthorityDialog;
import tv.danmaku.bili.ui.cheese.CheeseThemeSwitch;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.floatvideo.FloatWindowSizeActivity;
import tv.danmaku.bili.ui.freedata.FreeDataEntranceActivity;
import tv.danmaku.bili.ui.garb.GarbManagerDelegate;
import tv.danmaku.bili.ui.garb.core.GarbStorageHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;
import tv.danmaku.bili.ui.main2.resource.MainResourceManager;
import tv.danmaku.bili.ui.personinfo.ModifyNicknameDialog;
import tv.danmaku.bili.ui.splash.LaunchInitialization;
import tv.danmaku.bili.ui.splash.mod.SplashModHelper;
import tv.danmaku.bili.ui.theme.BiliTheme;
import tv.danmaku.bili.ui.userfeedback.JsBridgeCallHandlerFeedback;
import tv.danmaku.bili.ui.watchlater.widget.WatchLaterManagerV2;
import tv.danmaku.bili.update.api.updater.IUpdater;
import tv.danmaku.bili.utils.storage.StorageHelper;
import tv.danmaku.bili.videopage.common.watchlater.WatchLaterManager;
import tv.danmaku.bili.widget.preference.custom.BLPreference_ResetPreference;

/* compiled from: MainCommonServiceImpl.kt */
@Singleton
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J0\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J$\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u001a\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J&\u0010\u001b\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0016J(\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0096@¢\u0006\u0002\u0010\u001fJ\u0012\u0010 \u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\rH\u0016J$\u0010!\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\"\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010$\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010%\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010&\u001a\u00020'H\u0016J$\u0010(\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010)\u001a\u0004\u0018\u00010\r2\u0006\u0010*\u001a\u00020\u0011H\u0016J\u0012\u0010+\u001a\u00020\r2\b\u0010,\u001a\u0004\u0018\u00010\rH\u0016J\u0014\u0010-\u001a\u0004\u0018\u00010.2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010/\u001a\u00020\u0005H\u0016J&\u00100\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u00101\u001a\u0004\u0018\u00010\r2\b\u0010#\u001a\u0004\u0018\u00010\rH\u0017JF\u00102\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u00101\u001a\u0004\u0018\u00010\r2\b\u0010#\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u0011H\u0016J>\u00102\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010'2\b\u00101\u001a\u0004\u0018\u00010\r2\b\u0010#\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u00103\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u0011H\u0016J,\u00106\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u00107\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u00103\u001a\u00020\u0011H\u0016J\u0012\u00108\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0014\u00109\u001a\u0004\u0018\u00010.2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010:\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010;\u001a\u00020\u0005H\u0016J\u001a\u0010<\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010=\u001a\u00020\u0005H\u0016J\b\u0010>\u001a\u00020\u0011H\u0016J\u001a\u0010?\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010@\u001a\u00020\u0011H\u0016J\u001e\u0010A\u001a\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020C0B2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010D\u001a\u0004\u0018\u00010\bH\u0016JS\u0010E\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010F\u001a\u0004\u0018\u00010\r2\b\u00101\u001a\u0004\u0018\u00010C2\b\u0010G\u001a\u0004\u0018\u00010C2\b\u0010H\u001a\u0004\u0018\u00010C2\b\u0010\u001d\u001a\u0004\u0018\u00010\r2\b\u0010I\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010JJ:\u0010K\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010L\u001a\u0004\u0018\u00010\r2\b\u0010#\u001a\u0004\u0018\u00010\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\r2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\u001a\u0010O\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010P\u001a\u00020\u0005H\u0016J\u0010\u0010Q\u001a\u00020R2\u0006\u0010\t\u001a\u00020\nH\u0016J,\u0010S\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0006\u0010T\u001a\u00020R2\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u00020R\u0012\u0004\u0012\u00020\u00130UH\u0016J\b\u0010V\u001a\u00020\u0005H\u0016J\b\u0010W\u001a\u00020\u0005H\u0016J\u0012\u0010X\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010Y\u001a\u00020\rH\u0016J\u000e\u0010Z\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010[¨\u0006\\"}, d2 = {"Ltv/danmaku/bili/MainCommonServiceImpl;", "Lcom/bilibili/moduleservice/main/MainCommonService;", "<init>", "()V", "isTeenagerModeEnable", "", "isSplashModLoaded", "saveImage", "", "context", "Landroid/content/Context;", "isCanceled", "imageUrl", "", "base64Data", "getLocation", "locType", "", "changeTeenagersModeStatus", "", "isEnable", "checkUpdate", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "getSuperMenuTitle", "scene", "launchInit", "showNotificationSettingDialog", "showFrom", FavoritesConstsKt.SPMID, "showNotificationSettingDialogSuspend", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeNotificationSettingDialogInDialogQueue", "showPushSettingDialog", "message", "from", "resetPreference", "resetHdPreference", "fragment", "Landroidx/fragment/app/Fragment;", "showAuthorityDialog", AuthResultCbHelper.ARGS_MSG, LoginReporterV2.Show.SIGNUP_KEY_CODE, "getSearchEasterEggUrl", "url", "getFreeDataEntranceActivityIntent", "Landroid/content/Intent;", "isNightTheme", "addWatchLater", "avid", "addToWatchLater", "offset", "popupWindow", "style", "batchAddToWatchLater", "resources", "askFloatWindowPermission", "getFloatWindowSizeIntent", "isBangumiAutoPlay", "isDownloadMediaSourceUseDolby", "setDownloadMediaSourceUseDolby", "useDolby", "obtainDownloadSourceQuality", "setDownloadSourceQuality", "quality", "getVideoCacheVolume", "Lkotlin/Pair;", "", "getCheeseThemeSwitch", "gotoCheesePlayerFeedBack", "reportKeyType", "cid", "sid", "fromSpmid", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "showModifyNicknameDialog", ReportUtilKt.POS_TITLE, AuthResultCbHelper.ARGS_CALLBACK, "Lcom/bilibili/moduleservice/main/OnModifyNameCallback;", "changeNightMode", "showToast", "getFeedbackParams", "Lcom/alibaba/fastjson/JSONObject;", "uploadFeedbackLog", "data", "Lkotlin/Function1;", "isUserNewUploadImageApi", "isAbandonCustomDir", "removeCustomTransfered", "getDnsClientIp", "awaitSystemPushDialogResult", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MainCommonServiceImpl implements MainCommonService {
    public static final int $stable = 0;

    public /* synthetic */ boolean checkNotification(Activity activity, String str) {
        return MainCommonService.-CC.$default$checkNotification(this, activity, str);
    }

    public /* synthetic */ void showNotificationSettingDialog(Context context, String str) {
        MainCommonService.-CC.$default$showNotificationSettingDialog(this, context, str);
    }

    public /* synthetic */ Object showNotificationSettingDialogSuspend(Activity activity, String str, Continuation continuation) {
        return MainCommonService.-CC.$default$showNotificationSettingDialogSuspend(this, activity, str, continuation);
    }

    public boolean isTeenagerModeEnable() {
        return TeenagersMode.getInstance().isEnable();
    }

    public boolean isSplashModLoaded() {
        Application context = BiliContext.application();
        if (context != null && SplashModHelper.checkX86So(context)) {
            return SplashModHelper.isModLoaded();
        }
        return true;
    }

    public Object saveImage(Context context, boolean isCanceled, String imageUrl, String base64Data) {
        return ImageSaveHelper.saveImage(context, isCanceled, imageUrl, base64Data);
    }

    public Object getLocation(Context context, int locType, boolean isCanceled) {
        if (context != null) {
            return LocationHelper.getLocation(context, locType, isCanceled);
        }
        return null;
    }

    public void changeTeenagersModeStatus(boolean isEnable) {
        MainResourceManager.getInstance().resetToDefaultResource(isEnable, RestrictedMode.isEnable(RestrictedType.LESSONS));
        MainResourceManager.getInstance().fetchInBackGround(false);
    }

    public void checkUpdate(Activity activity) {
        GUpdater obj;
        if (activity == null || (obj = ((GUpdater.Fetcher) EntryPoints.get(activity.getApplication(), GUpdater.Fetcher.class)).getObj()) == null) {
            return;
        }
        GUpdater.-CC.checkUpdate$default(obj, activity, UpdaterActionType.MANUAL, (IUpdater) null, 4, (Object) null);
    }

    public String getSuperMenuTitle(String scene) {
        JSONObject configJsonObj = OnlineParamsHelper.getConfigJson("share_title_define");
        if (configJsonObj == null) {
            return null;
        }
        String sceneLocal = scene == null ? MineReporter.MINE_ICON_TYPE_DEFAULT : scene;
        String title = configJsonObj.getString(sceneLocal);
        if (TextUtils.isEmpty(title) && !Intrinsics.areEqual(scene, MineReporter.MINE_ICON_TYPE_DEFAULT)) {
            return configJsonObj.getString(MineReporter.MINE_ICON_TYPE_DEFAULT);
        }
        return title;
    }

    public void launchInit(Context context) {
        if (context != null) {
            LaunchInitialization.init$default(LaunchInitialization.INSTANCE, context, (Boolean) null, 2, (Object) null);
        }
    }

    public void showNotificationSettingDialog(Context context, String showFrom, String spmid) {
        if (context != null) {
            String str = showFrom;
            if (str == null || StringsKt.isBlank(str)) {
                return;
            }
            PushGuidanceManagerKt.showPushGuidanceDialog(context, showFrom, spmid == null ? "" : spmid);
        }
    }

    public Object showNotificationSettingDialogSuspend(Activity activity, String showFrom, String spmid, Continuation<? super Boolean> continuation) {
        if (activity instanceof AppCompatActivity) {
            return PushGuidanceManagerKt.showPushGuidanceDialogSuspend((AppCompatActivity) activity, showFrom, spmid == null ? "" : spmid, continuation);
        }
        PushSettingReporterKt.reportSettingDialogShowV3(showFrom, spmid, "illegal_activity_type", (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? 1 : 0, (r13 & 32) != 0 ? null : null);
        return Boxing.boxBoolean(false);
    }

    public void removeNotificationSettingDialogInDialogQueue(String showFrom) {
        PushGuidanceManagerKt.removeDialogInDialogQueue(showFrom);
    }

    public void showPushSettingDialog(Context context, String message, String from) {
        Intrinsics.checkNotNullParameter(message, "message");
        Activity activity = UtilKt.findActivityOrNull(context);
        if (activity == null) {
            return;
        }
        TrackTKt.reportOldDialogInvoke(from, activity);
        if (NotificationSettingActions.canShowDialogV1(activity)) {
            String messageLocal = message;
            if (TextUtils.isEmpty(messageLocal)) {
                String string = activity.getString(bili.resource.homepage.R.string.homepage_global_string_174);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                messageLocal = string;
            }
            NotificationSettingActions.showSettingDialog(activity, from, messageLocal);
        }
    }

    public void resetPreference(Context context) {
        if (context != null) {
            BLPreference_ResetPreference preference = new BLPreference_ResetPreference(context);
            preference.showAlertDialog(context);
        }
    }

    public void resetHdPreference(Context context, Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [tv.danmaku.bili.MainCommonServiceImpl$showAuthorityDialog$observer$1] */
    public void showAuthorityDialog(final Activity activity, String msg, int code) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        AuthorityDialog.AuthorityState state = new AuthorityDialog.AuthorityState(code, msg);
        final AuthorityDialog dialog = new AuthorityDialog(activity, state);
        if (activity instanceof AppCompatActivity) {
            final ?? r2 = new LifecycleObserver() { // from class: tv.danmaku.bili.MainCommonServiceImpl$showAuthorityDialog$observer$1
                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                public final void onDestroy() {
                    activity.getLifecycle().removeObserver(this);
                    dialog.dismiss();
                }
            };
            ((AppCompatActivity) activity).getLifecycle().addObserver((LifecycleObserver) r2);
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: tv.danmaku.bili.MainCommonServiceImpl$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    MainCommonServiceImpl.showAuthorityDialog$lambda$0(activity, r2, dialogInterface);
                }
            });
        }
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAuthorityDialog$lambda$0(Activity $activity, MainCommonServiceImpl$showAuthorityDialog$observer$1 $observer, DialogInterface it) {
        ((AppCompatActivity) $activity).getLifecycle().removeObserver($observer);
    }

    public String getSearchEasterEggUrl(String url) {
        if (url == null) {
            return "";
        }
        try {
            String processSearchEasterEggUrl = FreeDataMainModuleHelper.processSearchEasterEggUrl(Uri.parse(url));
            return processSearchEasterEggUrl == null ? "" : processSearchEasterEggUrl;
        } catch (Exception e) {
            return "";
        }
    }

    public Intent getFreeDataEntranceActivityIntent(Context context) {
        if (context != null) {
            return FreeDataEntranceActivity.createIntent(context, Uri.parse(FreeDataEntranceActivity.TARGET_WEB_SITE));
        }
        return null;
    }

    public boolean isNightTheme() {
        Application it = BiliContext.application();
        if (it != null) {
            return BiliTheme.isNightTheme(it);
        }
        return false;
    }

    @Deprecated(message = "Use addToWatchLater(activity, avid, from, offset) or addToWatchLater(fragment, avid, from, offset) instead.")
    public boolean addWatchLater(Context context, String avid, String from) {
        if (context == null) {
            return false;
        }
        WatchLaterManager.getInstance().addWatchLater(avid == null ? "" : avid, context, from != null ? from : "");
        return true;
    }

    public boolean addToWatchLater(Activity activity, String avid, String from, String spmid, int offset, boolean popupWindow, int style) {
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        if (activity == null || avid == null) {
            return false;
        }
        WatchLaterManagerV2.INSTANCE.addWatchLater(activity, avid, from, spmid, offset, popupWindow, style);
        return true;
    }

    public boolean addToWatchLater(Fragment fragment, String avid, String from, String spmid, int offset, int style) {
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        if (fragment == null || avid == null) {
            return false;
        }
        WatchLaterManagerV2.INSTANCE.addWatchLater(fragment, avid, from, spmid, offset, style);
        return true;
    }

    public boolean batchAddToWatchLater(Activity activity, String resources, String spmid, int offset) {
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        if (activity != null) {
            String str = resources;
            if (!(str == null || StringsKt.isBlank(str))) {
                WatchLaterManagerV2.batchAddWatchLater$default(WatchLaterManagerV2.INSTANCE, activity, resources, spmid, offset, 0, 16, (Object) null);
                return true;
            }
        }
        return false;
    }

    public boolean askFloatWindowPermission(Context context) {
        if (!FloatWindowPermissionHelper.checkFloatWindowPermission()) {
            FloatWindowPermissionHelper.askForFloatWindowPermission$default(context, (String) null, (String) null, (String) null, new FloatWindowPermissionHelper.FloatPermissionDialogCallback() { // from class: tv.danmaku.bili.MainCommonServiceImpl$askFloatWindowPermission$permissionReport$1
                public void onPositiveClick() {
                    Neurons.reportClick(false, "app.miniplayer.permission-floating-window.0.click", MapsKt.mapOf(TuplesKt.to("option", "1")));
                }

                public void onNegativeClick() {
                    Neurons.reportClick(false, "app.miniplayer.permission-floating-window.0.click", MapsKt.mapOf(TuplesKt.to("option", "0")));
                }

                public void onShow() {
                    Neurons.reportExposure$default(false, "app.miniplayer.permission-floating-window.0.show", (Map) null, (List) null, 12, (Object) null);
                }
            }, 14, (Object) null);
            return false;
        }
        return true;
    }

    public Intent getFloatWindowSizeIntent(Context context) {
        if (context != null) {
            return FloatWindowSizeActivity.createIntent(context);
        }
        return null;
    }

    public boolean isBangumiAutoPlay(Context context) {
        if (context == null) {
            return false;
        }
        return Settings.Player.isAutoPlay(context);
    }

    public boolean isDownloadMediaSourceUseDolby() {
        return Settings.General.isDownloadMediaSourceUseDolby(BiliContext.application());
    }

    public boolean setDownloadMediaSourceUseDolby(Context context, boolean useDolby) {
        if (context == null) {
            return false;
        }
        Settings.General.setDownloadMediaSourceUseDolby(context, useDolby);
        return true;
    }

    public int obtainDownloadSourceQuality() {
        return Settings.General.getDownloadMediaSourceQuality(BiliContext.application());
    }

    public boolean setDownloadSourceQuality(Context context, int quality) {
        if (context == null) {
            return false;
        }
        Settings.General.setDownloadMediaSourceQuality(context, quality);
        return true;
    }

    public Pair<Long, Long> getVideoCacheVolume(Context context) {
        if (context == null) {
            return new Pair<>(0L, 0L);
        }
        int currentSelectedStorage = Settings.Download.getDownloadStorage(context);
        StorageInfo[] storageInfos = StorageHelper.getDownloadVideoStorage(context);
        long usedVolume = 0;
        long availableVolume = 0;
        Intrinsics.checkNotNull(storageInfos);
        if (!(storageInfos.length == 0)) {
            switch (currentSelectedStorage) {
                case 1:
                case 3:
                    usedVolume = storageInfos[0].offlineUsedBytes;
                    availableVolume = storageInfos[0].diskAvailableBytes;
                    break;
                case 2:
                    if (storageInfos.length > 1) {
                        usedVolume = storageInfos[1].offlineUsedBytes;
                        availableVolume = storageInfos[1].diskAvailableBytes;
                        break;
                    }
                    break;
            }
        }
        return new Pair<>(Long.valueOf(usedVolume), Long.valueOf(availableVolume));
    }

    public Object getCheeseThemeSwitch() {
        return new CheeseThemeSwitch();
    }

    public void gotoCheesePlayerFeedBack(Context context, String reportKeyType, Long avid, Long cid, Long sid, String spmid, String fromSpmid) {
        final Bundle options = new Bundle();
        if (avid != null) {
            long it = avid.longValue();
            options.putLong("key_avid", it);
        }
        if (cid != null) {
            long it2 = cid.longValue();
            options.putLong("key_cid", it2);
        }
        if (sid != null) {
            long it3 = sid.longValue();
            options.putLong("key_season_id", it3);
        }
        options.putBoolean("key_is_bangumi", false);
        options.putBoolean("key_is_show_bangumi_skip_head_option", false);
        options.putBoolean("key_from_player", false);
        options.putString("key_player_tag", "");
        if (spmid != null) {
            options.putString("key_spmid", spmid);
        }
        if (fromSpmid != null) {
            options.putString("key_from_spmid", fromSpmid);
        }
        BLRouter.routeTo(new RouteRequest.Builder("bilibili://feedback/player").extras(new Function1() { // from class: tv.danmaku.bili.MainCommonServiceImpl$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit gotoCheesePlayerFeedBack$lambda$5;
                gotoCheesePlayerFeedBack$lambda$5 = MainCommonServiceImpl.gotoCheesePlayerFeedBack$lambda$5(options, (MutableBundleLike) obj);
                return gotoCheesePlayerFeedBack$lambda$5;
            }
        }).build(), context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit gotoCheesePlayerFeedBack$lambda$5(Bundle $options, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        String str = BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE;
        Intrinsics.checkNotNullExpressionValue(str, "KEY_DEFAULT_EXTRA_BUNDLE");
        $this$extras.put(str, $options);
        return Unit.INSTANCE;
    }

    public void showModifyNicknameDialog(Context context, String title, String from, String scene, OnModifyNameCallback callback) {
        if (context == null) {
            return;
        }
        ModifyNicknameDialog dialog = new ModifyNicknameDialog(context, title, from, scene);
        dialog.setOnModifyNameCallback(callback);
        dialog.show();
    }

    public boolean changeNightMode(Context context, boolean showToast) {
        if (context == null) {
            return false;
        }
        if (BiliTheme.getCurrentTheme(context) == 1) {
            Garb lastGarb = GarbStorageHelper.INSTANCE.readLastGarbWrapper(context);
            if (lastGarb == null) {
                BiliTheme.switchNightTheme(context);
            } else if (lastGarb.isNight()) {
                BiliTheme.switchNightTheme(context);
            } else {
                if (!lastGarb.isPure()) {
                    BiliTheme.setCurrentTheme(context, 8, false);
                } else {
                    BiliTheme.setCurrentTheme(context, GarbManagerDelegate.INSTANCE.getPureThemeId(lastGarb.getColorName()), false);
                }
                GarbManagerDelegate.setCurGarb(lastGarb);
            }
        } else {
            Garb garbCurrent = GarbManager.getCurGarb();
            GarbStorageHelper.INSTANCE.saveLastGarb(garbCurrent);
            BiliTheme.switchNightTheme(context);
        }
        return true;
    }

    public JSONObject getFeedbackParams(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        JSONObject buildFeedbackParams = JsBridgeCallHandlerFeedback.buildFeedbackParams(context);
        Intrinsics.checkNotNullExpressionValue(buildFeedbackParams, "buildFeedbackParams(...)");
        return buildFeedbackParams;
    }

    public void uploadFeedbackLog(Context context, JSONObject data, Function1<? super JSONObject, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(function1, AuthResultCbHelper.ARGS_CALLBACK);
        JsBridgeCallHandlerFeedback.uploadLog(context, data, function1);
    }

    public boolean isUserNewUploadImageApi() {
        return Intrinsics.areEqual(Contract.-CC.get$default(ConfigManager.Companion.ab(), "is_use_upload_image_api", (Object) null, 2, (Object) null), true);
    }

    public boolean isAbandonCustomDir() {
        return CustomDirUtils.Companion.isAbandonCustomDir();
    }

    public void removeCustomTransfered(Context context) {
        if (context != null) {
            DownloadTaskTransfer.removeTransfered(context);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003e A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getDnsClientIp() {
        String str;
        if (ProcessUtils.isMainProcess()) {
            return AppHttpDnsKt.getClientIp();
        }
        Application context = BiliContext.application();
        if (context != null) {
            ContentResolver contentResolver = context.getContentResolver();
            Bundle call = contentResolver != null ? contentResolver.call(AppHttpDnsProvider.Companion.getContentUri(context), AppHttpDnsProvider.FUNC_GET_DNS, (String) null, (Bundle) null) : null;
            if (call != null) {
                str = call.getString(AppHttpDnsProvider.EXTRA_KEY_DNS);
                return str != null ? "" : str;
            }
        }
        str = null;
        if (str != null) {
        }
    }

    public Object awaitSystemPushDialogResult(Continuation<? super Unit> continuation) {
        Object awaitSystemPushDialog = SystemPushDialogHelperKt.awaitSystemPushDialog(continuation);
        return awaitSystemPushDialog == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitSystemPushDialog : Unit.INSTANCE;
    }
}