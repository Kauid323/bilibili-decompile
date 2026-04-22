package tv.danmaku.bili.update.internal;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.bilibili.app.updater.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.personinfo.PersonInfoLoadHelper;
import tv.danmaku.bili.update.internal.network.download.UpdateService2;
import tv.danmaku.bili.update.model.BiliUpgradeInfo;
import tv.danmaku.bili.update.utils.RuntimeHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: Updater.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u001a(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0000\u001a \u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0000\u001a\u001a\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u001a\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0001H\u0002\u001a\u001a\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"PACKAGE_NAME_GOOGLE_PLAY", "", "TAG", "downloadUpdateApk", "", "activity", "Landroid/app/Activity;", "info", "Ltv/danmaku/bili/update/model/BiliUpgradeInfo;", "silent", "", "isManual", "doUpgrade", "tryOpenMarket", "context", "Landroid/content/Context;", "policyUrl", "tryOpenGooglePlay", "isGooglePlayActivity", "activityName", "HTTPS_APP_BILIBILI_COM", "openWebUpdatePage", "url", "tryOpenWebPage", "openBrowserPage", "updater_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class UpdaterKt {
    public static final String HTTPS_APP_BILIBILI_COM = "https://app.bilibili.com";
    private static final String PACKAGE_NAME_GOOGLE_PLAY = "com.android.vending";
    private static final String TAG = "fawkes.update.updater";

    public static final void downloadUpdateApk(Activity activity, BiliUpgradeInfo info, boolean silent, boolean isManual) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(info, "info");
        Intent intent = new Intent(activity, UpdateService2.class);
        intent.putExtra(UpdateService2.EXTRA_UPDATE_INFO, info);
        intent.putExtra(UpdateService2.EXTRA_SILENT, silent);
        intent.putExtra(UpdateService2.EXTRA_MANUAL, isManual);
        activity.startService(intent);
    }

    public static final boolean doUpgrade(Activity activity, BiliUpgradeInfo info, boolean isManual) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(info, "info");
        if (activity.isFinishing()) {
            return false;
        }
        int versionCode = info.versionCode();
        BLog.event("try up to date: new build " + versionCode + ", via " + info.getPolicy());
        switch (info.getPolicy()) {
            case 0:
                downloadUpdateApk(activity, info, false, isManual);
                return false;
            case 1:
                if (tryOpenMarket(activity, info.getPolicyUrl())) {
                    return true;
                }
                openWebUpdatePage(activity, info.getPolicyUrl());
                return false;
            case 2:
                openWebUpdatePage(activity, info.getPolicyUrl());
                return true;
            default:
                return false;
        }
    }

    public static final boolean tryOpenMarket(Context context, String policyUrl) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + context.getPackageName()));
        ResolveInfo info = context.getPackageManager().resolveActivity(intent, 65536);
        if ((info != null ? info.activityInfo : null) == null) {
            return false;
        }
        String targetActivity = info.activityInfo.name;
        if (!TextUtils.isEmpty(targetActivity)) {
            Intrinsics.checkNotNull(targetActivity);
            if (!isGooglePlayActivity(targetActivity)) {
                try {
                    intent.addFlags(268435456);
                    context.startActivity(intent);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026 A[Catch: Exception -> 0x0051, TryCatch #0 {Exception -> 0x0051, blocks: (B:6:0x0010, B:8:0x001a, B:14:0x0026, B:16:0x003b), top: B:21:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final boolean tryOpenGooglePlay(Context context, String policyUrl) {
        boolean z;
        String appPackageName = context.getPackageName();
        if (TextUtils.isEmpty(appPackageName)) {
            return false;
        }
        try {
            String str = policyUrl;
            if (str != null && str.length() != 0) {
                z = false;
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(!z ? "market://details?id=" + appPackageName : policyUrl));
                intent.setPackage(PACKAGE_NAME_GOOGLE_PLAY);
                intent.addFlags(268435456);
                context.startActivity(intent);
                return true;
            }
            z = true;
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(!z ? "market://details?id=" + appPackageName : policyUrl));
            intent2.setPackage(PACKAGE_NAME_GOOGLE_PLAY);
            intent2.addFlags(268435456);
            context.startActivity(intent2);
            return true;
        } catch (Exception e) {
            String string = context.getString(R.string.bili_jump_google_play_failed);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            RuntimeHelper.showToastShort(context, string);
            return false;
        }
    }

    private static final boolean isGooglePlayActivity(String activityName) {
        return StringsKt.startsWith$default(activityName, "com.google.android.finsky", false, 2, (Object) null);
    }

    public static final void openWebUpdatePage(Context context, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        tryOpenWebPage(context, url);
    }

    private static final void tryOpenWebPage(Context context, String url) {
        PackageManager pm = context.getPackageManager();
        Uri target = Uri.parse(TextUtils.isEmpty(url) ? HTTPS_APP_BILIBILI_COM : url);
        Intent browserIntent = new Intent("android.intent.action.VIEW", target);
        List list = pm.queryIntentActivities(browserIntent, 65536);
        Intrinsics.checkNotNullExpressionValue(list, "queryIntentActivities(...)");
        for (ResolveInfo info : list) {
            ActivityInfo activityInfo = info.activityInfo;
            if (activityInfo != null) {
                String str = activityInfo.packageName;
                Intrinsics.checkNotNullExpressionValue(str, "packageName");
                if (StringsKt.contains$default(str, PersonInfoLoadHelper.PHOTO_DIR, false, 2, (Object) null)) {
                    continue;
                } else {
                    String str2 = activityInfo.packageName;
                    Intrinsics.checkNotNullExpressionValue(str2, "packageName");
                    if (!StringsKt.contains$default(str2, "bilibili", false, 2, (Object) null) && info.activityInfo != null) {
                        try {
                            BLog.i(TAG, "open browser: " + activityInfo.packageName + ", " + activityInfo.name);
                            browserIntent.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                            browserIntent.addFlags(268435456);
                            context.startActivity(browserIntent);
                            return;
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
        String string = context.getString(R.string.update_cannot_find_web);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        RuntimeHelper.showToastShort(context, string);
    }

    private static final void openBrowserPage(Context context, String url) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
            context.startActivity(intent);
        } catch (Exception e) {
        }
    }
}