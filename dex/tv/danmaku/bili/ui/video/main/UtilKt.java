package tv.danmaku.bili.ui.video.main;

import android.app.Activity;
import android.content.SharedPreferences;
import android.net.Uri;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.base.util.DelayTaskController;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.neuron.api.Neurons;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: Util.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001\u001a\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001\u001a\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0005\u001a\u000e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0005\u001a\u000e\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0005\u001a\u0006\u0010\u0017\u001a\u00020\u0005\u001a\u0006\u0010\u0018\u001a\u00020\u0005\u001a\u0006\u0010\u0019\u001a\u00020\u0005\u001a\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001b\u001a\u00020\u001c\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"DEEPLINK_TRACKER_TAG", "", "DEEPLINK_URL_KEY", "DEEPLINK_TIME_KEY", "disableFFIvkFrom", "", "deepLinkTrack", "", "message", "e", "", "checkEqual", "origin", "target", "ALLOW_REPORT_FLAG", "ALLOW_REPORT_FLAG_1", "ALLOW_REPORT_FLAG_2", "globalKv", "Landroid/content/SharedPreferences;", "setAllowReport", "allow", "setAllowReport1", "setAllowReport2", "checkAllowReport", "checkAllowReport1", "checkAllowReport2", "reportAwakeRef", "activity", "Landroid/app/Activity;", "reflectGetReferrer", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class UtilKt {
    private static final String ALLOW_REPORT_FLAG = "deeplink_allow_report";
    private static final String ALLOW_REPORT_FLAG_1 = "deeplink_allow_report_1";
    private static final String ALLOW_REPORT_FLAG_2 = "deeplink_allow_report_2";
    public static final String DEEPLINK_TIME_KEY = "deeplink_time_sp";
    public static final String DEEPLINK_TRACKER_TAG = "deeplink_track_tag";
    public static final String DEEPLINK_URL_KEY = "deeplink_url_sp";
    private static final SharedPreferences globalKv = BiliGlobalPreferenceHelper.getBLKVSharedPreference();

    public static final boolean disableFFIvkFrom() {
        Boolean bool = (Boolean) ConfigManager.Companion.ab().get("ff_ivk_from_rec_disable", true);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public static final void deepLinkTrack(String message, Throwable e) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(e, "e");
        BLog.i(DEEPLINK_TRACKER_TAG, message, e);
    }

    public static final void deepLinkTrack(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        BLog.i(DEEPLINK_TRACKER_TAG, message);
    }

    public static final boolean checkEqual(String origin, String target) {
        boolean checkQuery;
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(target, "target");
        try {
            Uri o1 = Uri.parse(origin);
            Uri o2 = Uri.parse(target);
            if (o1.getQueryParameterNames().size() == o2.getQueryParameterNames().size()) {
                Set<String> queryParameterNames = o1.getQueryParameterNames();
                Set<String> queryParameterNames2 = o2.getQueryParameterNames();
                Intrinsics.checkNotNullExpressionValue(queryParameterNames2, "getQueryParameterNames(...)");
                if (queryParameterNames.containsAll(queryParameterNames2)) {
                    checkQuery = true;
                    if (!Intrinsics.areEqual(o1.getScheme(), o2.getScheme()) && Intrinsics.areEqual(o1.getHost(), o2.getHost())) {
                        return Intrinsics.areEqual(o1.getPath(), o2.getPath()) && checkQuery;
                    }
                }
            }
            checkQuery = false;
            return !Intrinsics.areEqual(o1.getScheme(), o2.getScheme()) ? false : false;
        } catch (Exception e) {
            BLog.e("deeplink_", "checkEqual parse uri fail", e);
            return false;
        }
    }

    public static final void setAllowReport(boolean allow) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putBoolean;
        SharedPreferences sharedPreferences = globalKv;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null || (putBoolean = edit.putBoolean(ALLOW_REPORT_FLAG, allow)) == null) {
            return;
        }
        putBoolean.apply();
    }

    public static final void setAllowReport1(boolean allow) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putBoolean;
        SharedPreferences sharedPreferences = globalKv;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null || (putBoolean = edit.putBoolean(ALLOW_REPORT_FLAG_1, allow)) == null) {
            return;
        }
        putBoolean.apply();
    }

    public static final void setAllowReport2(boolean allow) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putBoolean;
        SharedPreferences sharedPreferences = globalKv;
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null || (putBoolean = edit.putBoolean(ALLOW_REPORT_FLAG_2, allow)) == null) {
            return;
        }
        putBoolean.apply();
    }

    public static final boolean checkAllowReport() {
        SharedPreferences sharedPreferences;
        Boolean bool = (Boolean) ConfigManager.Companion.ab().get("ff_enable_clear_deeplink_tag_abtest", true);
        boolean open = bool != null ? bool.booleanValue() : true;
        if (!open || (sharedPreferences = globalKv) == null) {
            return true;
        }
        return sharedPreferences.getBoolean(ALLOW_REPORT_FLAG, true);
    }

    public static final boolean checkAllowReport1() {
        SharedPreferences sharedPreferences = globalKv;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(ALLOW_REPORT_FLAG_1, true);
        }
        return true;
    }

    public static final boolean checkAllowReport2() {
        SharedPreferences sharedPreferences = globalKv;
        if (sharedPreferences != null) {
            return sharedPreferences.getBoolean(ALLOW_REPORT_FLAG_2, true);
        }
        return true;
    }

    public static final void reportAwakeRef(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Pair[] pairArr = new Pair[3];
        String reflectGetReferrer = reflectGetReferrer(activity);
        if (reflectGetReferrer == null) {
            reflectGetReferrer = IjkMediaMeta.IJKM_VAL_TYPE__UNKNOWN;
        }
        pairArr[0] = TuplesKt.to("from_pkg", reflectGetReferrer);
        Uri data = activity.getIntent().getData();
        pairArr[1] = TuplesKt.to("url", (data == null || (r1 = data.toString()) == null) ? "" : "");
        pairArr[2] = TuplesKt.to("privacy", DelayTaskController.shouldBlock() ? "1" : "0");
        Map map = MapsKt.mapOf(pairArr);
        BLog.i("DeepLink_", "reportAwakeRef " + map);
        Neurons.trackT(true, "infra.deeplink", map, 1, new Function0() { // from class: tv.danmaku.bili.ui.video.main.UtilKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean reportAwakeRef$lambda$0;
                reportAwakeRef$lambda$0 = UtilKt.reportAwakeRef$lambda$0();
                return Boolean.valueOf(reportAwakeRef$lambda$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean reportAwakeRef$lambda$0() {
        return true;
    }

    public static final String reflectGetReferrer(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            Field referrerField = Activity.class.getDeclaredField("mReferrer");
            Intrinsics.checkNotNullExpressionValue(referrerField, "getDeclaredField(...)");
            referrerField.setAccessible(true);
            Object obj = referrerField.get(activity);
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}