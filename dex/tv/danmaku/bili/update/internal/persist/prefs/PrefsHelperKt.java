package tv.danmaku.bili.update.internal.persist.prefs;

import android.content.Context;
import android.text.format.DateUtils;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.update.internal.config.OnlineParams;
import tv.danmaku.bili.update.model.BiliUpgradeInfo;
import tv.danmaku.bili.update.utils.CommonUtilsKt;
import tv.danmaku.bili.update.utils.RuntimeHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PrefsHelper.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0012H\u0000\u001a\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0000\u001a\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u000bH\u0000\u001a\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0018\u0010!\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0001\u001a\u0018\u0010\"\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0001\u001a\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0012H\u0002\u001a\u0010\u0010'\u001a\u00020$2\u0006\u0010&\u001a\u00020$H\u0002\u001a\u0010\u0010(\u001a\u00020\u00122\u0006\u0010&\u001a\u00020$H\u0002\u001a\u0018\u0010*\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0001H\u0002\u001a\u0010\u0010+\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u0018\u0010,\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0000\u001a\u0018\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u001a\u001c\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020$002\u0006\u00101\u001a\u00020\u0001H\u0002\u001a\u0018\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u00122\u0006\u0010.\u001a\u00020$H\u0002\u001a\u0018\u00104\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0000\u001a \u00107\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u00108\u001a\u00020\u00012\u0006\u0010.\u001a\u00020$H\u0002\u001a \u00109\u001a\u00020$2\u0006\u0010\b\u001a\u00020\t2\u0006\u00108\u001a\u00020\u00012\u0006\u0010:\u001a\u00020$H\u0002\u001a\u0010\u0010;\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0001\u001a\u0010\u0010<\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0001\u001a\u0010\u0010=\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u0018\u0010>\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010)\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00105\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u00106\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"TAG", "", "PREF_UPDATE_PACKAGE_PREPARED", "PREF_UPDATE_MANUAL_CLICK", "PREF_UPDATE_INFO_MD5", "PREF_UPDATE_INFO_32_TO_64", "saveUpdateState", "", "context", "Landroid/content/Context;", "isPrepared", "", "isManual", "md5", "getPackagePreparedState", "getUpdateManualClickState", "getUpdateInfoMd5", "getUpdateInfo32To64", "", "PREF_UPDATE_IGNORE_VERSION", "setIgnoreVersion", "ver", "ignore", "info", "Ltv/danmaku/bili/update/model/BiliUpgradeInfo;", "getIgnoreVersion", "isWifiAutoUpdateEnabled", "setWifiAutoUpdateEnabled", "value", "PREF_LAST_STARTUP_CHECK_TIME", "shouldPerformUpdate", "setUpdatePerformed", PrefsHelperKt.PREF_INSTALL_DIALOG_SHOW_COUNT, "lessThanMaxCount", "addCount", "makeShowCount", "", "version", "count", "getVersion", "getCount", "PREF_KEY_UPDATE_PROMPT_TS", "setUpdatePromptTime", "getUpdatePromptTime", "canPrompt", "checkPromptTs", "ts", "decode", "Lkotlin/Pair;", "encoded", "encode", "versionCode", "setPrompt", "PREFS_KEY_CALL_PACKAGE_INSTALLER", "PREFS_KEY_LAST_RUN_VERSION", "saveApkTimeStamp", "key", "getApkTimeStamp", "defaultValue", "isInternalUpdate", "setInternalUpdate", "isUpdate", "onShowPrompt", "updater_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PrefsHelperKt {
    public static final String PREFS_KEY_CALL_PACKAGE_INSTALLER = "prefs.key.call.package.installer";
    public static final String PREFS_KEY_LAST_RUN_VERSION = "prefs.key.last.run.version";
    private static final String PREF_INSTALL_DIALOG_SHOW_COUNT = "PREF_INSTALL_DIALOG_SHOW_COUNT";
    private static final String PREF_KEY_UPDATE_PROMPT_TS = "pref.update.prompt.ts";
    private static final String PREF_LAST_STARTUP_CHECK_TIME = "pref.update.ts";
    private static final String PREF_UPDATE_IGNORE_VERSION = "pref.update.ignore_version";
    private static final String PREF_UPDATE_INFO_32_TO_64 = "pref.update.info.32to64";
    private static final String PREF_UPDATE_INFO_MD5 = "pref.update.info_md5";
    private static final String PREF_UPDATE_MANUAL_CLICK = "pref.update.manual_click";
    private static final String PREF_UPDATE_PACKAGE_PREPARED = "pref.update.package_prepared";
    private static final String TAG = "fawkes.update.prefs";

    public static final void saveUpdateState(Context context, boolean isPrepared, boolean isManual, String md5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(md5, "md5");
        SharedPreferencesHelper.getInstance(context).edit().putBoolean(PREF_UPDATE_PACKAGE_PREPARED, isPrepared).putBoolean(PREF_UPDATE_MANUAL_CLICK, isManual).putString(PREF_UPDATE_INFO_MD5, md5).putInt(PREF_UPDATE_INFO_32_TO_64, RuntimeHelper.INSTANCE.is32To64Int$updater_debug()).apply();
    }

    public static final boolean getPackagePreparedState(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return SharedPreferencesHelper.getInstance(context).optBoolean(PREF_UPDATE_PACKAGE_PREPARED, false);
    }

    public static final boolean getUpdateManualClickState(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return SharedPreferencesHelper.getInstance(context).optBoolean(PREF_UPDATE_MANUAL_CLICK, false);
    }

    public static final String getUpdateInfoMd5(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String optString = SharedPreferencesHelper.getInstance(context).optString(PREF_UPDATE_INFO_MD5, "");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
        return optString;
    }

    public static final int getUpdateInfo32To64(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return SharedPreferencesHelper.getInstance(context).optInteger(PREF_UPDATE_INFO_32_TO_64, 0);
    }

    public static final void setIgnoreVersion(Context context, int ver) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferencesHelper.getInstance(context).setInteger(PREF_UPDATE_IGNORE_VERSION, ver);
    }

    public static final boolean ignore(Context context, BiliUpgradeInfo info) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        return info.versionCode() == getIgnoreVersion(context);
    }

    private static final int getIgnoreVersion(Context context) {
        return SharedPreferencesHelper.getInstance(context).optInteger(PREF_UPDATE_IGNORE_VERSION, 0);
    }

    public static final boolean isWifiAutoUpdateEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return RuntimeHelper.isWifiAutoUpdateEnabled(context, true);
    }

    public static final void setWifiAutoUpdateEnabled(Context context, boolean value) {
        Intrinsics.checkNotNullParameter(context, "context");
        RuntimeHelper.setWifiAutoUpdateEnabled(context, value);
    }

    public static final boolean shouldPerformUpdate(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        long lastUpdateTime = SharedPreferencesHelper.getInstance(context).optLong(PREF_LAST_STARTUP_CHECK_TIME, 0L);
        String format = CommonUtilsKt.access$getDF$p().format(Long.valueOf(lastUpdateTime));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        BLog.vfmt(TAG, "Last update perform at %s.", new Object[]{format});
        return System.currentTimeMillis() - lastUpdateTime > OnlineParams.getUpdateInterval();
    }

    public static final void setUpdatePerformed(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferencesHelper.getInstance(context).setLong(PREF_LAST_STARTUP_CHECK_TIME, System.currentTimeMillis());
    }

    @Deprecated(message = "Using field defined in fawkes api since 5.42.")
    public static final boolean lessThanMaxCount(Context context, BiliUpgradeInfo info) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        long showCount = SharedPreferencesHelper.getInstance(context).optLong(PREF_INSTALL_DIALOG_SHOW_COUNT, 0L);
        long version = getVersion(showCount);
        if (version != info.versionCode()) {
            SharedPreferencesHelper.getInstance(context).setLong(PREF_INSTALL_DIALOG_SHOW_COUNT, makeShowCount(info.versionCode(), 1));
            return true;
        }
        int count = getCount(showCount);
        return count < OnlineParams.getShowDialogTimes();
    }

    @Deprecated(message = "Using field defined in fawkes api since 5.42.")
    public static final void addCount(Context context, BiliUpgradeInfo info) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        long showCount = SharedPreferencesHelper.getInstance(context).optLong(PREF_INSTALL_DIALOG_SHOW_COUNT, 0L);
        int count = getCount(showCount);
        SharedPreferencesHelper.getInstance(context).setLong(PREF_INSTALL_DIALOG_SHOW_COUNT, makeShowCount(info.versionCode(), count + 1));
    }

    private static final long makeShowCount(long version, int count) {
        return (10 * version) + count;
    }

    private static final long getVersion(long count) {
        return count / 10;
    }

    private static final int getCount(long count) {
        return (int) (count % 10);
    }

    private static final void setUpdatePromptTime(Context context, String value) {
        SharedPreferencesHelper.getInstance(context).setString(PREF_KEY_UPDATE_PROMPT_TS, value);
    }

    private static final String getUpdatePromptTime(Context context) {
        String optString = SharedPreferencesHelper.getInstance(context).optString(PREF_KEY_UPDATE_PROMPT_TS, "");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
        return optString;
    }

    public static final boolean canPrompt(Context context, BiliUpgradeInfo info) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        String encoded = getUpdatePromptTime(context);
        Pair<Integer, Long> decode = decode(encoded);
        int versionCode = ((Number) decode.component1()).intValue();
        long ts = ((Number) decode.component2()).longValue();
        if (versionCode != info.versionCode()) {
            ts = 0;
        }
        return checkPromptTs(ts, info);
    }

    private static final boolean checkPromptTs(long ts, BiliUpgradeInfo info) {
        switch (info.getCycle()) {
            case 1:
                return !CommonUtilsKt.isThisWeek(ts);
            case 2:
                return !DateUtils.isToday(ts);
            case 3:
                return true;
            default:
                return false;
        }
    }

    private static final Pair<Integer, Long> decode(String encoded) {
        List values = StringsKt.split$default(encoded, new String[]{","}, false, 0, 6, (Object) null);
        try {
            int versionCode = Integer.parseInt((String) values.get(0));
            long ts = Long.parseLong((String) values.get(1));
            Integer valueOf = Integer.valueOf(versionCode);
            String format = CommonUtilsKt.access$getDF$p().format(Long.valueOf(ts));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            BLog.vfmt(TAG, "Last update prompt version=%d, time=%s.", new Object[]{valueOf, format});
            return new Pair<>(Integer.valueOf(versionCode), Long.valueOf(ts));
        } catch (Throwable th) {
            return new Pair<>(0, 0L);
        }
    }

    private static final String encode(int versionCode, long ts) {
        return versionCode + "," + ts;
    }

    public static final void setPrompt(Context context, BiliUpgradeInfo info) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        setUpdatePromptTime(context, encode(info.versionCode(), System.currentTimeMillis()));
    }

    private static final void saveApkTimeStamp(Context context, String key, long ts) {
        SharedPreferencesHelper.getInstance(context).setLong(key, ts);
    }

    private static final long getApkTimeStamp(Context context, String key, long defaultValue) {
        return SharedPreferencesHelper.getInstance(context).optLong(key, defaultValue);
    }

    public static final boolean isInternalUpdate(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean updated = isUpdate(context);
        if (getApkTimeStamp(context, PREFS_KEY_CALL_PACKAGE_INSTALLER, 0L) > 0) {
            saveApkTimeStamp(context, PREFS_KEY_CALL_PACKAGE_INSTALLER, 0L);
            return updated;
        }
        return false;
    }

    public static final void setInternalUpdate(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        saveApkTimeStamp(context, PREFS_KEY_CALL_PACKAGE_INSTALLER, System.currentTimeMillis());
    }

    private static final boolean isUpdate(Context context) {
        SharedPreferencesHelper prefs = SharedPreferencesHelper.getInstance(context);
        int lastVersion = prefs.optInteger(PREFS_KEY_LAST_RUN_VERSION, 0);
        int thisVersion = RuntimeHelper.versionCode();
        if (thisVersion > lastVersion) {
            prefs.setInteger(PREFS_KEY_LAST_RUN_VERSION, thisVersion);
            return true;
        }
        return false;
    }

    public static final void onShowPrompt(Context context, BiliUpgradeInfo info) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        setUpdatePerformed(context);
        setPrompt(context, info);
    }
}