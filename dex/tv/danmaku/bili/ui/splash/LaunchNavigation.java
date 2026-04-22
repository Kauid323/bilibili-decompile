package tv.danmaku.bili.ui.splash;

import android.content.Context;
import android.content.SharedPreferences;
import com.bilibili.api.BiliConfig;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.commons.io.FileUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.utils.storage.StorageHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LaunchNavigation.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0018R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Ltv/danmaku/bili/ui/splash/LaunchNavigation;", "", "<init>", "()V", "isFirst", "", "hasCheckStorage", "getHasCheckStorage", "()Z", "setHasCheckStorage", "(Z)V", "STORAGE_STATE_ENOUGH", "", "STORAGE_STATE_TIGHT", "STORAGE_STATE_NOT_ENOUGH", "SPLASH_CHECK_STORAGE_PROMPT", "", "STORAGE_WARNING_INTERVAL_MILLS", "", "KEY_FINISH_COUNT", "KEY_APP_VERSION", "MAX_FINISH_COUNT", "getStorageState", "context", "Landroid/content/Context;", "clearApiAndImageCache", "", "needDialogPrompt", "needJudgeTaskRoot", "increaseFinishTimes", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class LaunchNavigation {
    public static final int $stable;
    private static final String KEY_APP_VERSION = "prefs.launch.app_version";
    private static final String KEY_FINISH_COUNT = "prefs.launch.finish_times";
    private static final int MAX_FINISH_COUNT = 3;
    private static final String SPLASH_CHECK_STORAGE_PROMPT = "persist.splash.storage.prompt";
    public static final int STORAGE_STATE_ENOUGH = 1;
    public static final int STORAGE_STATE_NOT_ENOUGH = 3;
    public static final int STORAGE_STATE_TIGHT = 2;
    private static final long STORAGE_WARNING_INTERVAL_MILLS;
    private static boolean hasCheckStorage;
    public static final LaunchNavigation INSTANCE = new LaunchNavigation();
    public static boolean isFirst = true;

    private LaunchNavigation() {
    }

    static {
        STORAGE_WARNING_INTERVAL_MILLS = tv.danmaku.bili.BuildConfig.DEBUG ? 15000 : 21600000;
        $stable = 8;
    }

    public final boolean getHasCheckStorage() {
        return hasCheckStorage;
    }

    public final void setHasCheckStorage(boolean z) {
        hasCheckStorage = z;
    }

    public final int getStorageState(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        StorageHelper.Storage storage = StorageHelper.getPrimaryStorage(context);
        if (storage != null) {
            long currentSize = storage.getAvailableByte();
            if (currentSize <= 83886080) {
                return 3;
            }
            if (currentSize <= 104857600) {
                return 2;
            }
            return 1;
        }
        return 1;
    }

    public final void clearApiAndImageCache(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File cacheDir = context.getExternalCacheDir();
        if (cacheDir != null) {
            FileUtils.deleteQuietly(cacheDir);
        }
    }

    public final boolean needDialogPrompt(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        long lastUpdateTime = BiliGlobalPreferenceHelper.getInstance(context).optLong(SPLASH_CHECK_STORAGE_PROMPT, 0L);
        long currentTime = System.currentTimeMillis();
        if (lastUpdateTime == 0 || currentTime - lastUpdateTime >= STORAGE_WARNING_INTERVAL_MILLS || lastUpdateTime >= currentTime) {
            BiliGlobalPreferenceHelper.getInstance(context).edit().putLong(SPLASH_CHECK_STORAGE_PROMPT, currentTime).apply();
            return true;
        }
        return false;
    }

    public final boolean needJudgeTaskRoot(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences preference = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context);
        int lastVersion = preference.getInt(KEY_APP_VERSION, 0);
        int thisVersion = BiliConfig.getBiliVersionCode();
        if (thisVersion <= lastVersion) {
            return preference.getInt(KEY_FINISH_COUNT, 0) < 3;
        }
        SharedPreferences.Editor editor = preference.edit();
        editor.putInt(KEY_FINISH_COUNT, 0);
        editor.putInt(KEY_APP_VERSION, thisVersion);
        editor.apply();
        return true;
    }

    public final void increaseFinishTimes(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences preference = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context);
        SharedPreferences.Editor editor = preference.edit();
        int times = preference.getInt(KEY_FINISH_COUNT, 0);
        editor.putInt(KEY_FINISH_COUNT, times + 1).apply();
    }
}