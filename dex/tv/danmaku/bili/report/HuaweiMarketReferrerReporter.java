package tv.danmaku.bili.report;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.privacy.PrivacyHelper;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: HuaweiMarketReferrerReporter.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001d\u001a\u00020\u001eH\u0007J6\u0010\u001f\u001a\u00020\u001e*\"\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050 j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005`!2\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010#\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Ltv/danmaku/bili/report/HuaweiMarketReferrerReporter;", "", "<init>", "()V", "CHANNEL_HUAWEI", "", "PACKAGE_NAME_HUAWEI", "QUERY_URL", "INDEX_REFERRER", "", "INDEX_ENTER_AG_TIME", "INDEX_INSTALLED_FINISH_TIME", "INDEX_TRACKID", "TRACK_EXTRA_KEY_CHANNEL", "TRACK_EXTRA_KEY_CALLBACK", "TRACK_EXTRA_KEY_TASKID", "REPORTER_ID", "KEY_CODE", "KEY_MSG", "KEY_MARKET_VER", "KEY_CHANNEL", "KEY_CLICK_TIME", "KEY_INSTALL_TIME", "KEY_TASK_ID", "KEY_CALLBACK", "KEY_TRACK_DATA", "CODE_SUCCESS", "CODE_ERROR", "CODE_NODATA", "report", "", "fillTrackData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", HuaweiMarketReferrerReporter.KEY_TRACK_DATA, "getMarketVerName", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HuaweiMarketReferrerReporter {
    public static final int $stable = 0;
    private static final String CHANNEL_HUAWEI = "huawei";
    private static final int CODE_ERROR = 1;
    private static final int CODE_NODATA = 2;
    private static final int CODE_SUCCESS = 0;
    private static final int INDEX_ENTER_AG_TIME = 1;
    private static final int INDEX_INSTALLED_FINISH_TIME = 2;
    private static final int INDEX_REFERRER = 0;
    private static final int INDEX_TRACKID = 4;
    public static final HuaweiMarketReferrerReporter INSTANCE = new HuaweiMarketReferrerReporter();
    private static final String KEY_CALLBACK = "callback";
    private static final String KEY_CHANNEL = "referrer";
    private static final String KEY_CLICK_TIME = "clickTime";
    private static final String KEY_CODE = "code";
    private static final String KEY_INSTALL_TIME = "installTime";
    private static final String KEY_MARKET_VER = "marketVer";
    private static final String KEY_MSG = "msg";
    private static final String KEY_TASK_ID = "taskId";
    private static final String KEY_TRACK_DATA = "trackData";
    private static final String PACKAGE_NAME_HUAWEI = "com.huawei.appmarket";
    private static final String QUERY_URL = "content://com.huawei.appmarket.commondata/item/5";
    private static final String REPORTER_ID = "infra.huawei.market.referrer";
    private static final String TRACK_EXTRA_KEY_CALLBACK = "callback";
    private static final String TRACK_EXTRA_KEY_CHANNEL = "channel";
    private static final String TRACK_EXTRA_KEY_TASKID = "taskid";

    private HuaweiMarketReferrerReporter() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00e9, code lost:
        if (0 == 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ec, code lost:
        r2.put(tv.danmaku.bili.report.HuaweiMarketReferrerReporter.KEY_MARKET_VER, tv.danmaku.bili.report.HuaweiMarketReferrerReporter.INSTANCE.getMarketVerName());
        com.bilibili.lib.neuron.api.Neurons.trackT(false, tv.danmaku.bili.report.HuaweiMarketReferrerReporter.REPORTER_ID, r2, 1, new tv.danmaku.bili.report.HuaweiMarketReferrerReporter$$ExternalSyntheticLambda0());
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0108, code lost:
        return;
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void report() {
        if (!Intrinsics.areEqual(CHANNEL_HUAWEI, FoundationAlias.getFapps().getChannel())) {
            return;
        }
        HashMap map = new HashMap();
        Cursor cursor = null;
        try {
            try {
                cursor = FoundationAlias.getFapp().getContentResolver().query(Uri.parse(QUERY_URL), null, null, new String[]{FoundationAlias.getFapps().getAppId()}, null);
                if (cursor != null) {
                    cursor.moveToFirst();
                    int columnCount = cursor.getColumnCount();
                    if (columnCount >= 1) {
                        map.put(KEY_CHANNEL, cursor.getString(0));
                    }
                    if (columnCount >= 2) {
                        map.put(KEY_CLICK_TIME, cursor.getString(1));
                    }
                    if (columnCount >= 3) {
                        map.put(KEY_INSTALL_TIME, cursor.getString(2));
                    }
                    if (columnCount > 4) {
                        INSTANCE.fillTrackData(map, cursor.getString(4));
                    }
                    map.put("code", "0");
                    map.put("msg", "success");
                } else {
                    map.put("code", "2");
                    map.put("msg", "no referrer data");
                }
            } catch (Exception e) {
                BLog.w("fail to get huawei referrer", e);
                map.put("code", "1");
                String name = e.getClass().getName();
                map.put("msg", name + ": " + e.getMessage());
            }
        } finally {
            if (0 != 0) {
                cursor.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean report$lambda$0() {
        return true;
    }

    private final void fillTrackData(HashMap<String, String> hashMap, String trackData) {
        String str = trackData;
        if (str == null || str.length() == 0) {
            return;
        }
        hashMap.put(KEY_TRACK_DATA, trackData);
        try {
            JSONObject jsonObject = new JSONObject(trackData);
            hashMap.put(AuthResultCbHelper.ARGS_CALLBACK, jsonObject.optString(AuthResultCbHelper.ARGS_CALLBACK));
            hashMap.put(KEY_TASK_ID, jsonObject.optString(TRACK_EXTRA_KEY_TASKID));
        } catch (Exception e) {
            BLog.w("fail to parse track data", e);
        }
    }

    private final String getMarketVerName() {
        try {
            return String.valueOf(__Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo(FoundationAlias.getFapp().getPackageManager(), PACKAGE_NAME_HUAWEI, 0).versionName);
        } catch (Exception e) {
            BLog.w("can not get huawei market version name", e);
            return "";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0049, code lost:
        if (kotlin.text.StringsKt.contains$default(r5, r9, false, 2, (java.lang.Object) null) == true) goto L19;
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static PackageInfo __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo(PackageManager pm, String pkg, int flag) {
        boolean agreeGetPackageInfo;
        Intrinsics.checkNotNullParameter(pm, "pm");
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        boolean inPkgWhiteLst = true;
        try {
            agreeGetPackageInfo = ConfigManager.Companion.ab2().getWithDefault("ff.privacy.hook.agree.get_package_info", true);
        } catch (Exception e) {
            agreeGetPackageInfo = true;
        }
        if (!PrivacyHelper.INSTANCE.checkPrivacy$privacy_debug("pm_get_package_info") || !agreeGetPackageInfo) {
            try {
                String str = (String) ConfigManager.Companion.config().get("privacy.pkg_info_whitelist", (Object) null);
                if (str != null) {
                }
                inPkgWhiteLst = false;
            } catch (Exception e2) {
            }
            if (!inPkgWhiteLst) {
                if (Intrinsics.areEqual(pkg, FoundationAlias.getFapps().getAppId())) {
                    PackageInfo fake = pm.getPackageArchiveInfo(FoundationAlias.getFapp().getPackageCodePath(), 0);
                    if (fake == null) {
                        PackageInfo it = new PackageInfo();
                        it.versionCode = 2233;
                        return it;
                    }
                    return fake;
                }
                throw new PackageManager.NameNotFoundException(pkg);
            }
        }
        PackageInfo packageInfo = pm.getPackageInfo(pkg, Integer.valueOf(flag).intValue());
        if (packageInfo instanceof PackageInfo) {
            return packageInfo;
        }
        return null;
    }
}