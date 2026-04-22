package tv.danmaku.bili;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import bolts.Continuation;
import bolts.Task;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.api.BiliConfig;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.config.BLRemoteConfig;
import java.util.zip.Adler32;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.report.misaka.MisakaHelper;

/* compiled from: OnlineParamsHelper.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010*\u001a\u00020\u0014H\u0007J\b\u0010+\u001a\u00020\u0014H\u0007J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00140-H\u0007J\b\u0010.\u001a\u00020\u0014H\u0007J\b\u0010/\u001a\u00020\u0014H\u0007J\b\u00100\u001a\u00020\u0014H\u0007J\b\u00101\u001a\u00020\u0014H\u0007J\u0012\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010>\u001a\u00020\u0005H\u0007J\u0018\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u000bH\u0007J\b\u0010D\u001a\u00020@H\u0007J\u0018\u0010E\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u0007H\u0007J\u001e\u0010G\u001a\u0004\u0018\u00010\u00052\u0006\u0010>\u001a\u00020\u00052\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010H\u001a\u00020\u00142\b\u0010I\u001a\u0004\u0018\u00010\u00052\b\u0010J\u001a\u0004\u0018\u00010\u0005H\u0003J\b\u0010K\u001a\u00020@H\u0002J\b\u0010L\u001a\u00020\u0014H\u0002J\b\u0010M\u001a\u00020\u0007H\u0002J\b\u0010N\u001a\u00020\u0014H\u0007J\b\u0010O\u001a\u00020\u0014H\u0007J\b\u0010]\u001a\u00020\u0014H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u00148FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0013\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0019\u0010\u000fR\u001a\u0010\u001a\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001c\u0010\u000fR\u001a\u0010\u001d\u001a\u00020\u00148FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001d\u0010\u0016R\u001a\u0010\u001f\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\u0003\u001a\u0004\b!\u0010\u000fR\u001a\u0010\"\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0003\u001a\u0004\b$\u0010\u000fR\u001a\u0010%\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0003\u001a\u0004\b'\u0010\u000fR\u001a\u0010(\u001a\u00020\u00148FX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0003\u001a\u0004\b(\u0010\u0016R\u001a\u00102\u001a\u00020\u00148FX\u0087\u0004¢\u0006\f\u0012\u0004\b3\u0010\u0003\u001a\u0004\b2\u0010\u0016R\u001a\u00104\u001a\u00020\u00148FX\u0087\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0003\u001a\u0004\b4\u0010\u0016R\u001a\u00106\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b7\u0010\u0003\u001a\u0004\b8\u0010\u000fR\u001a\u00109\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b:\u0010\u0003\u001a\u0004\b;\u0010\u000fR\u001a\u0010P\u001a\u00020\u00148FX\u0087\u0004¢\u0006\f\u0012\u0004\bQ\u0010\u0003\u001a\u0004\bR\u0010\u0016R\u001a\u0010S\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\bT\u0010\u0003\u001a\u0004\bU\u0010VR\u001a\u0010W\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\bX\u0010\u0003\u001a\u0004\bY\u0010\u000fR\u001a\u0010Z\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b[\u0010\u0003\u001a\u0004\b\\\u0010V¨\u0006^"}, d2 = {"Ltv/danmaku/bili/OnlineParamsHelper;", "", "<init>", "()V", "TAG", "", "sRate", "", "sLastTime", "", "sBuvidGetter", "Ltv/danmaku/bili/BuvidCallback;", "infoEyesReportSize", "getInfoEyesReportSize$annotations", "getInfoEyesReportSize", "()I", "infoEyesReportTimeInterval", "getInfoEyesReportTimeInterval$annotations", "getInfoEyesReportTimeInterval", "isInfoEyesErrorReportEnabled", "", "isInfoEyesErrorReportEnabled$annotations", "()Z", "apiErrorNeuronSampleRate", "getApiErrorNeuronSampleRate$annotations", "getApiErrorNeuronSampleRate", "misakaReportLimite", "getMisakaReportLimite$annotations", "getMisakaReportLimite", "isMisakaReportEnable", "isMisakaReportEnable$annotations", "misakaApmDateSampleRate", "getMisakaApmDateSampleRate$annotations", "getMisakaApmDateSampleRate", "requestPhoneStateAfterBootTimes", "getRequestPhoneStateAfterBootTimes$annotations", "getRequestPhoneStateAfterBootTimes", "requestPhoneStateAfterUserRetention", "getRequestPhoneStateAfterUserRetention$annotations", "getRequestPhoneStateAfterUserRetention", "isHttpsEnabled", "isHttpsEnabled$annotations", "showGameCenterInToolbar", "enableDeviceManagement", "appOnepassMode", "Ltv/danmaku/bili/PResult;", "enableAppActiveReport", "enableRequestPhoneStateDialog", "enableDocumentProvider", "enableUnicomUpgrade", "isLoginOutSetPassword", "isLoginOutSetPassword$annotations", "isCDNStrategy", "isCDNStrategy$annotations", "imageConnectTimeout", "getImageConnectTimeout$annotations", "getImageConnectTimeout", "imageReadTimeout", "getImageReadTimeout$annotations", "getImageReadTimeout", "getConfigJson", "Lcom/alibaba/fastjson/JSONObject;", "key", "initialize", "", "context", "Landroid/content/Context;", "buvidGetter", "tryUpdateInBackground", "getConfigInt", "def", "getConfigString", "safetyContains", "value", "filter", "upToDate", "needUpdate", "myRate", "enableUserProtocol", "enableAccountDestroy", "enableOnePassLoginGuide", "getEnableOnePassLoginGuide$annotations", "getEnableOnePassLoginGuide", "onePassLoginGuideInterval", "getOnePassLoginGuideInterval$annotations", "getOnePassLoginGuideInterval", "()J", "onePassLoginGuideMaxTimes", "getOnePassLoginGuideMaxTimes$annotations", "getOnePassLoginGuideMaxTimes", "onePassLoginGuideSkipTime", "getOnePassLoginGuideSkipTime$annotations", "getOnePassLoginGuideSkipTime", "enableHomepageNetworkToast", "onlineparam_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OnlineParamsHelper {
    private static final String TAG = "tv.danmaku.bili.OnlineParamsHelper";
    private static BuvidCallback sBuvidGetter;
    private static long sLastTime;
    public static final OnlineParamsHelper INSTANCE = new OnlineParamsHelper();
    private static int sRate = -1;

    @JvmStatic
    public static /* synthetic */ void getApiErrorNeuronSampleRate$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getEnableOnePassLoginGuide$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getImageConnectTimeout$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getImageReadTimeout$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getInfoEyesReportSize$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getInfoEyesReportTimeInterval$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getMisakaApmDateSampleRate$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getMisakaReportLimite$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOnePassLoginGuideInterval$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOnePassLoginGuideMaxTimes$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getOnePassLoginGuideSkipTime$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getRequestPhoneStateAfterBootTimes$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getRequestPhoneStateAfterUserRetention$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isCDNStrategy$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isHttpsEnabled$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isInfoEyesErrorReportEnabled$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isLoginOutSetPassword$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isMisakaReportEnable$annotations() {
    }

    private OnlineParamsHelper() {
    }

    public static final int getInfoEyesReportSize() {
        return getConfigInt("info_eyes_size_threshold", 10);
    }

    public static final int getInfoEyesReportTimeInterval() {
        return getConfigInt("info_eyes_time_interval", 20);
    }

    public static final boolean isInfoEyesErrorReportEnabled() {
        return getConfigInt("info_eyes_error_enable_report", 0) == 1;
    }

    public static final int getApiErrorNeuronSampleRate() {
        return getConfigInt("api_error_neuron_sample_rate", 1000);
    }

    public static final int getMisakaReportLimite() {
        return getConfigInt("misaka_error_msg_size", MisakaHelper.MAX_REPORT_SIZE);
    }

    public static final boolean isMisakaReportEnable() {
        return getConfigInt("misaka_enable", 1) == 1;
    }

    public static final int getMisakaApmDateSampleRate() {
        return getConfigInt("apm_data_rate", 20);
    }

    public static final int getRequestPhoneStateAfterBootTimes() {
        return getConfigInt("request_phone_state_after_boot_times", 4);
    }

    public static final int getRequestPhoneStateAfterUserRetention() {
        return getConfigInt("phone_state_dialog_after_user_retention", 1);
    }

    public static final boolean isHttpsEnabled() {
        return getConfigInt("use_https_api", 1) == 1;
    }

    @JvmStatic
    public static final boolean showGameCenterInToolbar() {
        String value = getConfigString$default("hide_gamecenter_in_toolbar_channels", null, 2, null);
        return !safetyContains(value, BiliConfig.getChannel());
    }

    @JvmStatic
    public static final boolean enableDeviceManagement() {
        int rate = getConfigInt("device_verify_management", 0);
        if (rate == 0) {
            return false;
        }
        return rate % 1000 == 0 || INSTANCE.myRate() % 1000 <= rate;
    }

    @JvmStatic
    public static final PResult<Boolean> appOnepassMode() {
        PResult param = new PResult();
        boolean z = false;
        if (!BLRemoteConfig.getInstance().contains("app_onepass_mode")) {
            param.setExist(false);
            return param;
        }
        param.setExist(true);
        int rate = getConfigInt("app_onepass_mode", 0);
        if (rate == 0) {
            param.setResult(false);
        } else {
            if (rate % 1000 == 0 || INSTANCE.myRate() % 1000 <= rate) {
                z = true;
            }
            param.setResult(Boolean.valueOf(z));
        }
        return param;
    }

    @JvmStatic
    public static final boolean enableAppActiveReport() {
        int rate = getConfigInt("enable_app_active_report", 0);
        if (rate == 0) {
            return false;
        }
        return rate % 1000 == 0 || INSTANCE.myRate() % 1000 <= rate;
    }

    @JvmStatic
    public static final boolean enableRequestPhoneStateDialog() {
        int rate = getConfigInt("enable_request_phone_state_dialog", 0);
        if (rate == 0) {
            return false;
        }
        return rate % 1000 == 0 || INSTANCE.myRate() % 1000 <= rate;
    }

    @JvmStatic
    public static final boolean enableDocumentProvider() {
        return getConfigInt("document_provider", 1) == 1;
    }

    @JvmStatic
    public static final boolean enableUnicomUpgrade() {
        return getConfigInt("unicomcard_upgrade", 0) == 1;
    }

    public static final boolean isLoginOutSetPassword() {
        return getConfigInt("app_exit_pwd", 0) == 1;
    }

    public static final boolean isCDNStrategy() {
        return getConfigInt("cdn_strategy", 1) == 1;
    }

    public static final int getImageConnectTimeout() {
        return getConfigInt("image_connect_timeout", 10);
    }

    public static final int getImageReadTimeout() {
        return getConfigInt("image_read_timeout", 15);
    }

    @JvmStatic
    public static final JSONObject getConfigJson(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String value = getConfigString$default(key, null, 2, null);
        if (value == null) {
            return null;
        }
        try {
            return JSON.parseObject(value);
        } catch (JSONException e) {
            return null;
        }
    }

    @JvmStatic
    public static final void initialize(Context context, BuvidCallback buvidGetter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(buvidGetter, "buvidGetter");
        sBuvidGetter = buvidGetter;
        BLRemoteConfig.createInstance(context);
    }

    @JvmStatic
    public static final void tryUpdateInBackground() {
        Task.forResult((Object) null).cast().continueWithTask(new Continuation<Unit, Task<Boolean>>() { // from class: tv.danmaku.bili.OnlineParamsHelper$tryUpdateInBackground$1
            private int times = 30;

            /* renamed from: then  reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m650then(Task p0) {
                return then((Task<Unit>) p0);
            }

            public Task<Boolean> then(Task<Unit> task) throws Exception {
                Intrinsics.checkNotNullParameter(task, "task");
                Application application = BiliContext.application();
                ConnectivityManager manager = (ConnectivityManager) (application != null ? application.getSystemService("connectivity") : null);
                NetworkInfo info = manager != null ? manager.getActiveNetworkInfo() : null;
                boolean connected = info != null && info.isConnected();
                if (!connected) {
                    int i = this.times;
                    this.times = i - 1;
                    if (i > 0) {
                        BLog.d("tv.danmaku.bili.OnlineParamsHelper", "no active network, try later..");
                        Task<Boolean> onSuccessTask = Task.delay(1000L).cast().onSuccessTask(this);
                        Intrinsics.checkNotNullExpressionValue(onSuccessTask, "onSuccessTask(...)");
                        return onSuccessTask;
                    }
                }
                Task<Boolean> forResult = Task.forResult(Boolean.valueOf(connected));
                Intrinsics.checkNotNullExpressionValue(forResult, "forResult(...)");
                return forResult;
            }
        }, Task.BACKGROUND_EXECUTOR).onSuccess(new Continuation() { // from class: tv.danmaku.bili.OnlineParamsHelper$$ExternalSyntheticLambda0
            public final Object then(Task task) {
                Unit tryUpdateInBackground$lambda$0;
                tryUpdateInBackground$lambda$0 = OnlineParamsHelper.tryUpdateInBackground$lambda$0(task);
                return tryUpdateInBackground$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit tryUpdateInBackground$lambda$0(Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (((Boolean) task.getResult()).booleanValue()) {
            INSTANCE.upToDate();
        }
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final int getConfigInt(String key, int def) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            return BLRemoteConfig.getInstance().getInt(key, def);
        } catch (Throwable th) {
            return def;
        }
    }

    public static /* synthetic */ String getConfigString$default(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return getConfigString(str, str2);
    }

    @JvmStatic
    public static final String getConfigString(String key, String def) {
        Intrinsics.checkNotNullParameter(key, "key");
        return BLRemoteConfig.getInstance().getString(key, def);
    }

    @JvmStatic
    private static final boolean safetyContains(String value, String filter) {
        if (TextUtils.isEmpty(value) || TextUtils.isEmpty(filter)) {
            return false;
        }
        String valueWrapper = StringsKt.replace$default("," + value + ",", " ", "", false, 4, (Object) null);
        String filterWrapper = StringsKt.replace$default("," + filter + ",", " ", "", false, 4, (Object) null);
        return StringsKt.contains(valueWrapper, filterWrapper, true);
    }

    private final void upToDate() {
        if (needUpdate()) {
            BLRemoteConfig.getInstance().update(BiliConfig.getChannel(), BiliConfig.getBiliVersionCode(), BiliConfig.getMobiApp());
            sLastTime = SystemClock.elapsedRealtime();
            BLog.dfmt(TAG, " upTodate sLastTime = %d", Long.valueOf(sLastTime));
            return;
        }
        BLog.d(TAG, " upToDate Interval smaller than 300_000");
    }

    private final boolean needUpdate() {
        return sLastTime == 0 || SystemClock.elapsedRealtime() - sLastTime > 300000;
    }

    private final int myRate() {
        int rate = sRate;
        if (rate == -1) {
            BuvidCallback buvidCallback = sBuvidGetter;
            String buvid = buvidCallback != null ? buvidCallback.getBuvid() : null;
            if (buvid != null) {
                Adler32 sum = new Adler32();
                byte[] bytes = buvid.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                sum.update(bytes);
                int rate2 = Math.abs((int) sum.getValue());
                sRate = rate2;
                return rate2;
            }
            return rate;
        }
        return rate;
    }

    @JvmStatic
    public static final boolean enableUserProtocol() {
        int rate = getConfigInt("use_privacy_agreement", 0);
        if (rate == 0) {
            return false;
        }
        return rate % 1000 == 0 || INSTANCE.myRate() % 1000 <= rate;
    }

    @JvmStatic
    public static final boolean enableAccountDestroy() {
        return getConfigInt("account_cancel_entrance", 1) == 1;
    }

    public static final boolean getEnableOnePassLoginGuide() {
        return getConfigInt("onepassguide_show", 1) == 1;
    }

    public static final long getOnePassLoginGuideInterval() {
        return getConfigInt("onepassguide_gaptime", 86400) * 1000;
    }

    public static final int getOnePassLoginGuideMaxTimes() {
        return getConfigInt("onepassguide_maxtimes", 10);
    }

    public static final long getOnePassLoginGuideSkipTime() {
        return getConfigInt("onepassguide_skiptime", 5) * 1000;
    }

    @JvmStatic
    public static final boolean enableHomepageNetworkToast() {
        return getConfigInt("android_homepage_flow_toast", 0) == 1;
    }
}