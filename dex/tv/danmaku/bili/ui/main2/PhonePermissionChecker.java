package tv.danmaku.bili.ui.main2;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.text.format.DateFormat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import bili.resource.homepage.R;
import com.bilibili.adcommon.utils.AdInfoUtil;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.commons.time.DateUtils;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.ui.PermissionRequestUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.OnlineParamsHelper;

public class PhonePermissionChecker {
    public static final String KEY_APP_FIRST_BOOT_TIME = "app_first_boot_time";
    private static final String KEY_IMEI_PERMISSION_SHOWED = "KEY_IMEI_PERMISSION_SHOWED";
    private static final String KEY_RECORD_BOOT_TIMES = "phone.permission.key.record.boot.times";
    private static final int READ_PHONE_STATE = 1;
    public static final String TAG = "PhonePermissionChecker";

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    private static class SingleInstanceHolder {
        public static PhonePermissionChecker sInstance = new PhonePermissionChecker();

        private SingleInstanceHolder() {
        }
    }

    public static PhonePermissionChecker getInstance() {
        return SingleInstanceHolder.sInstance;
    }

    private PhonePermissionChecker() {
    }

    public void requestReadPhoneState(final Fragment fragment) {
        if (Build.VERSION.SDK_INT >= 26 && Build.VERSION.SDK_INT <= 28 && !TextUtils.isEmpty(AdInfoUtil.getOaid())) {
            BLog.i(TAG, "app has obtained oaid " + AdInfoUtil.getOaid() + " on version " + Build.VERSION.SDK_INT);
            return;
        }
        final FragmentActivity activity = fragment.getActivity();
        if (OnlineParamsHelper.enableRequestPhoneStateDialog() && activity != null && !BiliGlobalPreferenceHelper.getBLKVSharedPreference(activity).getBoolean(KEY_IMEI_PERMISSION_SHOWED, false)) {
            SharedPreferences sharedPreferences = BiliGlobalPreferenceHelper.getBLKVSharedPreference(activity);
            int bootTimesOld = sharedPreferences.getInt(KEY_RECORD_BOOT_TIMES, 0) + 1;
            sharedPreferences.edit().putInt(KEY_RECORD_BOOT_TIMES, bootTimesOld).apply();
            Reporter.Show.report(Reporter.Show.APP_BOOT_TIMES_SHOW, Reporter.generateSingleParamMaps(Reporter.Show.KEY_BOOT_TIMES, String.valueOf(bootTimesOld)));
            BLog.i(TAG, "boot times " + bootTimesOld);
            long appFirstBootTime = sharedPreferences.getLong(KEY_APP_FIRST_BOOT_TIME, 0L);
            BLog.i(TAG, "first boot time " + ((Object) DateFormat.format("yyyy-MM-dd HH:mm:ss", appFirstBootTime)));
            int configRetentionDays = OnlineParamsHelper.getRequestPhoneStateAfterUserRetention();
            Date appFirstBootDate = new Date(appFirstBootTime);
            int daysDiff = DateUtils.daysDifference(appFirstBootDate, new Date());
            BLog.i(TAG, "time after first boot " + daysDiff + " days");
            if (bootTimesOld >= OnlineParamsHelper.getRequestPhoneStateAfterBootTimes() && daysDiff >= configRetentionDays) {
                int permissionResult = activity.checkSelfPermission("android.permission.READ_PHONE_STATE");
                if (permissionResult != 0) {
                    MainDialogManager.addDialog(new MainDialogManager.DialogManagerInfo("phone_state", new MainDialogManager.IDialogInterface() { // from class: tv.danmaku.bili.ui.main2.PhonePermissionChecker.1
                        public void onShow() {
                            try {
                                PermissionRequestUtils.requestPermissionWithTip(fragment, fragment.getLifecycle(), "android.permission.READ_PHONE_STATE", 1, activity.getString(R.string.homepage_global_string_332));
                                Reporter.Show.report(Reporter.Show.APP_CHECK_PHONESTATE_DIALOG_SHOW);
                                BiliGlobalPreferenceHelper.getBLKVSharedPreference(activity).edit().putBoolean(PhonePermissionChecker.KEY_IMEI_PERMISSION_SHOWED, true).apply();
                            } catch (IllegalStateException e) {
                                BLog.d(PhonePermissionChecker.TAG, e.getMessage());
                            }
                        }
                    }, 2020), activity);
                    return;
                }
                return;
            }
            BLog.i(TAG, "boot times is not match online params");
            return;
        }
        BLog.i(TAG, "disable request phone state dialog");
    }

    public void onRequestPermissionsResult(Activity activity, int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == 0) {
                Reporter.Click.report(Reporter.Click.APP_CHECK_PHONESTATE_DIALOG_OK_CLICK);
            } else {
                Reporter.Click.report(Reporter.Click.APP_CHECK_PHONESTATE_DIALOG_NO_CLICK);
            }
            if (activity != null && !activity.isFinishing()) {
                MainDialogManager.showNextDialog("phone_state", false, activity);
            }
        }
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class Reporter {

        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static class Click {
            public static final String APP_CHECK_PHONESTATE_DIALOG_NO_CLICK = "ad.tianma.request-imei.1.click";
            public static final String APP_CHECK_PHONESTATE_DIALOG_OK_CLICK = "ad.tianma.request-imei.0.click";

            public static void report(String eventId) {
                BLog.i(PhonePermissionChecker.TAG + eventId);
                Neurons.reportClick(true, eventId, new HashMap());
            }
        }

        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static class Show {
            public static final String APP_BOOT_TIMES_SHOW = "ad.tianma.request-imei.1.show";
            public static final String APP_CHECK_PHONESTATE_DIALOG_SHOW = "ad.tianma.request-imei.0.show";
            public static final String KEY_BOOT_TIMES = "boot_times";

            public static void report(String eventId) {
                BLog.i(PhonePermissionChecker.TAG + eventId);
                Neurons.reportExposure(true, eventId, new HashMap());
            }

            public static void report(String eventId, Map<String, String> extension) {
                BLog.i(PhonePermissionChecker.TAG + eventId + extension.values());
                Neurons.reportExposure(true, eventId, extension);
            }
        }

        public static Map<String, String> generateSingleParamMaps(String key, String value) {
            Map<String, String> maps = new HashMap<>();
            maps.put(key, value);
            return maps;
        }
    }
}