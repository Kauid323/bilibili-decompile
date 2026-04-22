package tv.danmaku.bili.ui.main;

import android.app.Application;
import com.bilibili.droid.AppsFlyerWrapper;
import com.bilibili.droid.BVCompat;
import com.bilibili.lib.biliid.api.BuvidHelper;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.utils.DelayInitHelper;

/* compiled from: AppsFlyerManager.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/main/AppsFlyerManager;", "", "<init>", "()V", "jumpPerformed", "", "getJumpPerformed", "()Z", "setJumpPerformed", "(Z)V", "init", "", "app", "Landroid/app/Application;", "parseTimeStamp", "", "time", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AppsFlyerManager {
    private static volatile boolean jumpPerformed;
    public static final AppsFlyerManager INSTANCE = new AppsFlyerManager();
    public static final int $stable = 8;

    private AppsFlyerManager() {
    }

    public final boolean getJumpPerformed() {
        return jumpPerformed;
    }

    public final void setJumpPerformed(boolean z) {
        jumpPerformed = z;
    }

    public final void init(Application app) {
        Intrinsics.checkNotNullParameter(app, "app");
        AppsFlyerWrapper.init(AppsFlyerManagerKt.APPS_FLYER_DEV_KEY, new AppsFlyerWrapper.ConversationListener() { // from class: tv.danmaku.bili.ui.main.AppsFlyerManager$init$listener$1
            public void onConversionDataSuccess(Map<String, ? extends Object> map) {
                Intrinsics.checkNotNullParameter(map, "map");
                BLog.w(AppsFlyerManagerKt.APPS_FLYER_LOG_KEY, "onConversionDataSuccess, params:" + map);
                String bvParam = parseBvParam(map);
                boolean launchCheck = checkFirstLaunch(map);
                boolean bvParamCheck = BVCompat.isBvOpen() && BVCompat.isBvid(bvParam, true);
                boolean durationCheck = checkDuration(map);
                boolean installTypeCheck = checkInstallType(map);
                if (launchCheck && installTypeCheck && !AppsFlyerManager.INSTANCE.getJumpPerformed()) {
                    AppsFlyerManager.INSTANCE.setJumpPerformed(true);
                    DelayInitHelper.Companion.registerDelayInitTask(new AppsFlyerManager$init$listener$1$onConversionDataSuccess$1(installTypeCheck, bvParamCheck, durationCheck, bvParam));
                }
            }

            public void onConversionDataFail(String s) {
                Intrinsics.checkNotNullParameter(s, "s");
                if (AppsFlyerManager.INSTANCE.getJumpPerformed()) {
                    return;
                }
                AppsFlyerManager.INSTANCE.setJumpPerformed(true);
                BLog.w(AppsFlyerManagerKt.APPS_FLYER_LOG_KEY, "onConversionDataFail, params:" + s);
                DelayInitHelper.Companion.registerDelayInitTask(new AppsFlyerManager$init$listener$1$onConversionDataFail$1());
            }

            public final boolean checkDuration(Map<String, ? extends Object> map) {
                Intrinsics.checkNotNullParameter(map, "map");
                AppsFlyerManager appsFlyerManager = AppsFlyerManager.INSTANCE;
                Object obj = map.get("install_time");
                long it = appsFlyerManager.parseTimeStamp(obj instanceof String ? (String) obj : null);
                long it2 = TimeUnit.MILLISECONDS.toMinutes(it);
                AppsFlyerManager appsFlyerManager2 = AppsFlyerManager.INSTANCE;
                Object obj2 = map.get("click_time");
                long it3 = appsFlyerManager2.parseTimeStamp(obj2 instanceof String ? (String) obj2 : null);
                long duration = Math.abs(it2 - TimeUnit.MILLISECONDS.toMinutes(it3));
                return duration <= 30;
            }

            public final boolean checkFirstLaunch(Map<String, ? extends Object> map) {
                Intrinsics.checkNotNullParameter(map, "map");
                Object obj = map.get("is_first_launch");
                return Intrinsics.areEqual(obj instanceof Boolean ? (Boolean) obj : null, true);
            }

            public final String parseBvParam(Map<String, ? extends Object> map) {
                List split$default;
                String str;
                Intrinsics.checkNotNullParameter(map, "map");
                Object obj = map.get("campaign");
                String str2 = obj instanceof String ? (String) obj : null;
                return (str2 == null || (split$default = StringsKt.split$default(str2, new String[]{"-"}, false, 0, 6, (Object) null)) == null || (str = (String) CollectionsKt.last(split$default)) == null) ? "" : str;
            }

            public final boolean checkInstallType(Map<String, ? extends Object> map) {
                Intrinsics.checkNotNullParameter(map, "map");
                Object obj = map.get("af_status");
                return Intrinsics.areEqual(obj instanceof String ? (String) obj : null, "Non-organic");
            }
        }, app);
        AppsFlyerWrapper.setCustomerUserId(BuvidHelper.getBuvid());
        AppsFlyerWrapper.checkEvent();
    }

    public final long parseTimeStamp(String time) {
        String str = time;
        if (str == null || StringsKt.isBlank(str)) {
            return 0L;
        }
        return new SimpleDateFormat("yyyy-MM-DD hh:mm:ss", Locale.CHINA).parse(time).getTime();
    }
}