package tv.danmaku.bili.update.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.bilibili.app.updater.R;
import com.bilibili.lib.foundation.FoundationAlias;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.update.api.DefaultDialogManager;
import tv.danmaku.bili.update.api.FawkesUpdates;
import tv.danmaku.bili.update.api.ReportTracker;
import tv.danmaku.bili.update.api.UpdateDialogManager;
import tv.danmaku.bili.update.api.UpdaterOptions;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: RuntimeHelper.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001WB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050!J\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050!J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001fJ\b\u0010&\u001a\u00020\u000fH\u0007J\b\u0010'\u001a\u00020\u0015H\u0007J\b\u0010(\u001a\u00020\u0005H\u0007J\u0010\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020+H\u0007J\u001a\u0010,\u001a\u0004\u0018\u00010\u00052\u0006\u0010*\u001a\u00020+2\u0006\u0010-\u001a\u00020\u0005H\u0007J\u0018\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0015H\u0007J\u001c\u00101\u001a\u00020\u00052\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050!H\u0007J1\u00103\u001a\u00020$2\u0006\u00104\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u00052\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000507\"\u00020\u0005H\u0007¢\u0006\u0002\u00108J)\u00109\u001a\u0004\u0018\u0001H:\"\u0004\b\u0000\u0010:2\u0006\u0010;\u001a\u00020\u00052\f\u0010<\u001a\b\u0012\u0004\u0012\u0002H:0=¢\u0006\u0002\u0010>J\u000e\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u0001J\u0017\u0010A\u001a\u0004\u0018\u00010\u000f2\u0006\u0010/\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010BJ\u0018\u0010C\u001a\u00020D2\u0006\u0010*\u001a\u00020+2\u0006\u0010E\u001a\u00020\u0005H\u0007J\u001a\u0010F\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010G\u001a\u00020\u0005H\u0007J\u001f\u0010H\u001a\u0004\u0018\u00010$2\u0006\u0010*\u001a\u00020+2\u0006\u0010I\u001a\u00020JH\u0007¢\u0006\u0002\u0010KJ\u001f\u0010L\u001a\u0004\u0018\u00010$2\u0006\u0010M\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010NJ\u001f\u0010O\u001a\u0004\u0018\u00010$2\u0006\u0010*\u001a\u00020+2\u0006\u0010I\u001a\u00020JH\u0007¢\u0006\u0002\u0010KJ\u001f\u0010P\u001a\u0004\u0018\u00010$2\u0006\u0010M\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010NJ\b\u0010Q\u001a\u00020RH\u0007J\u0018\u0010S\u001a\u00020$2\u0006\u0010*\u001a\u00020+2\u0006\u0010T\u001a\u00020\u000fH\u0007J\u0018\u0010U\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020+2\u0006\u0010V\u001a\u00020\u000fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001a8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Ltv/danmaku/bili/update/utils/RuntimeHelper;", "", "<init>", "()V", "PLATFORM", "", "NETWORK", "DEVICE_ID", "APP_KEY", "ABI", "BUVID", "USER_AGENT", "FAWKES_APP_KEY", RuntimeHelper.ENV, "is32To64", "", "is32To64$updater_debug", "()Z", "is32To64$delegate", "Lkotlin/Lazy;", "is32To64Int", "", "is32To64Int$updater_debug", "()I", "is32To64Int$delegate", "reportTracker", "Ltv/danmaku/bili/update/api/ReportTracker;", "getReportTracker$annotations", "getReportTracker", "()Ltv/danmaku/bili/update/api/ReportTracker;", "sDelegate", "Ltv/danmaku/bili/update/utils/RuntimeHelper$Delegate;", "params", "", "headers", "setDelegate", "", "delegate", "checkInit", "versionCode", "channel", "checkApkUpdateFreeDataAvailable", "context", "Landroid/content/Context;", "processApkDownloadUrl", "originUrl", "getConfigInt", "key", "def", "signQuery", "map", "reportV2", "forceReport", "taskId", "values", "", "(ZLjava/lang/String;[Ljava/lang/String;)V", "parseObject", "T", "json", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "toJSONString", "any", "abtest", "(Ljava/lang/String;)Ljava/lang/Boolean;", "getSharedPreferences", "Landroid/content/SharedPreferences;", "name", "showToastShort", "message", "addUpdateDialog", "runnable", "Ljava/lang/Runnable;", "(Landroid/content/Context;Ljava/lang/Runnable;)Lkotlin/Unit;", "showUpdateNextDialog", "pause", "(ZLandroid/content/Context;)Lkotlin/Unit;", "addInstallCheckDialog", "showInstallCheckNextDialog", "getUpdaterOptions", "Ltv/danmaku/bili/update/api/UpdaterOptions;", "setWifiAutoUpdateEnabled", "value", "isWifiAutoUpdateEnabled", "defaultValue", "Delegate", "updater_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RuntimeHelper {
    private static final String ABI = "abi";
    private static final String APP_KEY = "appkey";
    private static final String BUVID = "Buvid";
    private static final String DEVICE_ID = "deviceid";
    private static final String ENV = "ENV";
    private static final String FAWKES_APP_KEY = "APP-KEY";
    private static final String NETWORK = "nt";
    private static final String PLATFORM = "platform";
    private static final String USER_AGENT = "User-Agent";
    private static Delegate sDelegate;
    public static final RuntimeHelper INSTANCE = new RuntimeHelper();
    private static final Lazy is32To64$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.update.utils.RuntimeHelper$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean is32To64_delegate$lambda$0;
            is32To64_delegate$lambda$0 = RuntimeHelper.is32To64_delegate$lambda$0();
            return Boolean.valueOf(is32To64_delegate$lambda$0);
        }
    });
    private static final Lazy is32To64Int$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.update.utils.RuntimeHelper$$ExternalSyntheticLambda1
        public final Object invoke() {
            int is32To64Int_delegate$lambda$0;
            is32To64Int_delegate$lambda$0 = RuntimeHelper.is32To64Int_delegate$lambda$0();
            return Integer.valueOf(is32To64Int_delegate$lambda$0);
        }
    });

    @JvmStatic
    public static /* synthetic */ void getReportTracker$annotations() {
    }

    private RuntimeHelper() {
    }

    public final boolean is32To64$updater_debug() {
        return ((Boolean) is32To64$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean is32To64_delegate$lambda$0() {
        String paramsKey = INSTANCE.headers().get(FAWKES_APP_KEY);
        return (paramsKey != null && kotlin.text.StringsKt.contains$default(paramsKey, "64", false, 2, (Object) null)) && !kotlin.text.StringsKt.contains$default(FoundationAlias.getFapps().getFawkesAppKey(), "64", false, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int is32To64Int_delegate$lambda$0() {
        return INSTANCE.is32To64$updater_debug() ? 1 : 0;
    }

    public final int is32To64Int$updater_debug() {
        return ((Number) is32To64Int$delegate.getValue()).intValue();
    }

    public static final ReportTracker getReportTracker() {
        Delegate delegate = sDelegate;
        if (delegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sDelegate");
            delegate = null;
        }
        return delegate.getReportTracker();
    }

    public final Map<String, String> params() {
        Map params = new LinkedHashMap();
        Delegate delegate = sDelegate;
        Delegate delegate2 = null;
        if (delegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sDelegate");
            delegate = null;
        }
        FawkesUpdates.Params $this$params_u24lambda_u240 = delegate.getParams();
        params.put(PLATFORM, $this$params_u24lambda_u240.getPlatform());
        params.put(NETWORK, $this$params_u24lambda_u240.getNt());
        params.put(DEVICE_ID, $this$params_u24lambda_u240.getDeviceId());
        params.put(APP_KEY, $this$params_u24lambda_u240.getAppKey());
        params.put(ABI, $this$params_u24lambda_u240.getAbi());
        params.putAll(FoundationHelperKt.foundationParams());
        Delegate delegate3 = sDelegate;
        if (delegate3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sDelegate");
        } else {
            delegate2 = delegate3;
        }
        Map it = delegate2.getParams().getExtra();
        if (it != null) {
            params.putAll(it);
        }
        return params;
    }

    public final Map<String, String> headers() {
        Map headers = new LinkedHashMap();
        Delegate delegate = sDelegate;
        Delegate delegate2 = null;
        if (delegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sDelegate");
            delegate = null;
        }
        Map it = delegate.getHeaders().getExtra();
        if (it != null) {
            headers.putAll(it);
        }
        Delegate delegate3 = sDelegate;
        if (delegate3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sDelegate");
        } else {
            delegate2 = delegate3;
        }
        FawkesUpdates.Headers $this$headers_u24lambda_u241 = delegate2.getHeaders();
        headers.put(BUVID, $this$headers_u24lambda_u241.getBuvid());
        headers.put(USER_AGENT, $this$headers_u24lambda_u241.getUa());
        headers.put(FAWKES_APP_KEY, $this$headers_u24lambda_u241.getFawkesAppKey());
        headers.put(ENV, $this$headers_u24lambda_u241.getEnv());
        return headers;
    }

    public final void setDelegate(Delegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        sDelegate = delegate;
    }

    @JvmStatic
    public static final boolean checkInit() {
        if (sDelegate != null) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final int versionCode() {
        Delegate delegate = sDelegate;
        if (delegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sDelegate");
            delegate = null;
        }
        return delegate.getVersionCode();
    }

    @JvmStatic
    public static final String channel() {
        Delegate delegate = sDelegate;
        if (delegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sDelegate");
            delegate = null;
        }
        return delegate.getChannel();
    }

    @JvmStatic
    public static final boolean checkApkUpdateFreeDataAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Delegate delegate = sDelegate;
        if (delegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sDelegate");
            delegate = null;
        }
        return delegate.checkApkUpdateFreeDataAvailable(context);
    }

    @JvmStatic
    public static final String processApkDownloadUrl(Context context, String originUrl) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(originUrl, "originUrl");
        Delegate delegate = sDelegate;
        if (delegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sDelegate");
            delegate = null;
        }
        return delegate.processApkDownloadUrl(context, originUrl);
    }

    @JvmStatic
    public static final int getConfigInt(String key, int def) {
        Intrinsics.checkNotNullParameter(key, "key");
        Delegate delegate = sDelegate;
        if (delegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sDelegate");
            delegate = null;
        }
        return delegate.getConfigInt(key, def);
    }

    @JvmStatic
    public static final String signQuery(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        Delegate delegate = sDelegate;
        if (delegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sDelegate");
            delegate = null;
        }
        return delegate.signQuery(map);
    }

    @JvmStatic
    public static final void reportV2(boolean forceReport, String taskId, String... values) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(values, "values");
        Delegate delegate = sDelegate;
        if (delegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sDelegate");
            delegate = null;
        }
        ReportTracker reportTracker = delegate.getReportTracker();
        if (reportTracker != null) {
            reportTracker.reportV2(forceReport, taskId, (String[]) Arrays.copyOf(values, values.length));
        }
    }

    public final <T> T parseObject(String json, Class<T> cls) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Delegate delegate = sDelegate;
        if (delegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sDelegate");
            delegate = null;
        }
        return (T) delegate.getJsonParser().fromJson(json, cls);
    }

    public final String toJSONString(Object any) {
        Intrinsics.checkNotNullParameter(any, "any");
        Delegate delegate = sDelegate;
        if (delegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sDelegate");
            delegate = null;
        }
        return delegate.getJsonParser().toJson(any);
    }

    @JvmStatic
    public static final Boolean abtest(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Delegate delegate = sDelegate;
        if (delegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sDelegate");
            delegate = null;
        }
        return delegate.abtest(key);
    }

    @JvmStatic
    public static final SharedPreferences getSharedPreferences(Context context, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        Delegate delegate = sDelegate;
        if (delegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sDelegate");
            delegate = null;
        }
        return delegate.getSharedPreferences(context, name);
    }

    @JvmStatic
    public static final void showToastShort(Context context, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Delegate delegate = sDelegate;
        if (delegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sDelegate");
            delegate = null;
        }
        delegate.showToastShort(context, message);
    }

    @JvmStatic
    public static final Unit addUpdateDialog(Context context, Runnable runnable) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Delegate delegate = sDelegate;
        if (delegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sDelegate");
            delegate = null;
        }
        UpdateDialogManager updateDialogManager = delegate.getUpdateDialogManager();
        if (updateDialogManager != null) {
            updateDialogManager.addUpdateDialog(context, new RuntimeHelper$addUpdateDialog$1(runnable));
            return Unit.INSTANCE;
        }
        return null;
    }

    @JvmStatic
    public static final Unit showUpdateNextDialog(boolean pause, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Delegate delegate = sDelegate;
        if (delegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sDelegate");
            delegate = null;
        }
        UpdateDialogManager updateDialogManager = delegate.getUpdateDialogManager();
        if (updateDialogManager != null) {
            updateDialogManager.showUpdateNextDialog(pause, context);
            return Unit.INSTANCE;
        }
        return null;
    }

    @JvmStatic
    public static final Unit addInstallCheckDialog(Context context, Runnable runnable) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Delegate delegate = sDelegate;
        if (delegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sDelegate");
            delegate = null;
        }
        UpdateDialogManager updateDialogManager = delegate.getUpdateDialogManager();
        if (updateDialogManager != null) {
            updateDialogManager.addInstallCheckDialog(context, new RuntimeHelper$addInstallCheckDialog$1(runnable));
            return Unit.INSTANCE;
        }
        return null;
    }

    @JvmStatic
    public static final Unit showInstallCheckNextDialog(boolean pause, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Delegate delegate = sDelegate;
        if (delegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sDelegate");
            delegate = null;
        }
        UpdateDialogManager updateDialogManager = delegate.getUpdateDialogManager();
        if (updateDialogManager != null) {
            updateDialogManager.showInstallCheckNextDialog(pause, context);
            return Unit.INSTANCE;
        }
        return null;
    }

    @JvmStatic
    public static final UpdaterOptions getUpdaterOptions() {
        Delegate delegate = sDelegate;
        if (delegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sDelegate");
            delegate = null;
        }
        UpdaterOptions updaterOptions = delegate.getUpdaterOptions();
        return updaterOptions == null ? UpdaterOptions.Companion.getDEFAULT_OPTIONS$updater_debug() : updaterOptions;
    }

    @JvmStatic
    public static final void setWifiAutoUpdateEnabled(Context context, boolean value) {
        Intrinsics.checkNotNullParameter(context, "context");
        Delegate delegate = sDelegate;
        if (delegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sDelegate");
            delegate = null;
        }
        delegate.setWifiAutoUpdateEnabled(context, value);
    }

    @JvmStatic
    public static final boolean isWifiAutoUpdateEnabled(Context context, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        Delegate delegate = sDelegate;
        if (delegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sDelegate");
            delegate = null;
        }
        return delegate.isWifiAutoUpdateEnabled(context, defaultValue);
    }

    /* compiled from: RuntimeHelper.kt */
    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H&J\u001a\u0010&\u001a\u0004\u0018\u00010\u000f2\u0006\u0010$\u001a\u00020%2\u0006\u0010'\u001a\u00020\u000fH&J\u0018\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u000bH&J\u001c\u0010+\u001a\u00020\u000f2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0-H&J\u0017\u0010.\u001a\u0004\u0018\u00010#2\u0006\u0010)\u001a\u00020\u000fH&¢\u0006\u0002\u0010/J\u0018\u00100\u001a\u0002012\u0006\u0010$\u001a\u00020%2\u0006\u00102\u001a\u00020\u000fH&J\u001a\u00103\u001a\u0002042\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u00105\u001a\u00020\u000fH&J\u0018\u00106\u001a\u0002042\u0006\u0010$\u001a\u00020%2\u0006\u00107\u001a\u00020#H\u0016J\u0018\u00108\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u00109\u001a\u00020#H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u00020\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006:À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/update/utils/RuntimeHelper$Delegate;", "", "params", "Ltv/danmaku/bili/update/api/FawkesUpdates$Params;", "getParams", "()Ltv/danmaku/bili/update/api/FawkesUpdates$Params;", "headers", "Ltv/danmaku/bili/update/api/FawkesUpdates$Headers;", "getHeaders", "()Ltv/danmaku/bili/update/api/FawkesUpdates$Headers;", "versionCode", "", "getVersionCode", "()I", "channel", "", "getChannel", "()Ljava/lang/String;", "updateDialogManager", "Ltv/danmaku/bili/update/api/UpdateDialogManager;", "getUpdateDialogManager", "()Ltv/danmaku/bili/update/api/UpdateDialogManager;", "updaterOptions", "Ltv/danmaku/bili/update/api/UpdaterOptions;", "getUpdaterOptions", "()Ltv/danmaku/bili/update/api/UpdaterOptions;", "reportTracker", "Ltv/danmaku/bili/update/api/ReportTracker;", "getReportTracker", "()Ltv/danmaku/bili/update/api/ReportTracker;", "jsonParser", "Ltv/danmaku/bili/update/api/FawkesUpdates$JsonParser;", "getJsonParser", "()Ltv/danmaku/bili/update/api/FawkesUpdates$JsonParser;", "checkApkUpdateFreeDataAvailable", "", "context", "Landroid/content/Context;", "processApkDownloadUrl", "originUrl", "getConfigInt", "key", "def", "signQuery", "map", "", "abtest", "(Ljava/lang/String;)Ljava/lang/Boolean;", "getSharedPreferences", "Landroid/content/SharedPreferences;", "name", "showToastShort", "", "message", "setWifiAutoUpdateEnabled", "value", "isWifiAutoUpdateEnabled", "defaultValue", "updater_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface Delegate {
        Boolean abtest(String str);

        boolean checkApkUpdateFreeDataAvailable(Context context);

        String getChannel();

        int getConfigInt(String str, int i);

        FawkesUpdates.Headers getHeaders();

        FawkesUpdates.JsonParser getJsonParser();

        FawkesUpdates.Params getParams();

        ReportTracker getReportTracker();

        SharedPreferences getSharedPreferences(Context context, String str);

        UpdateDialogManager getUpdateDialogManager();

        UpdaterOptions getUpdaterOptions();

        int getVersionCode();

        boolean isWifiAutoUpdateEnabled(Context context, boolean z);

        String processApkDownloadUrl(Context context, String str);

        void setWifiAutoUpdateEnabled(Context context, boolean z);

        void showToastShort(Context context, String str);

        String signQuery(Map<String, String> map);

        /* compiled from: RuntimeHelper.kt */
        /* renamed from: tv.danmaku.bili.update.utils.RuntimeHelper$Delegate$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public final /* synthetic */ class CC {
            public static UpdateDialogManager $default$getUpdateDialogManager(Delegate _this) {
                return new DefaultDialogManager();
            }

            public static ReportTracker $default$getReportTracker(Delegate _this) {
                return null;
            }

            public static void $default$setWifiAutoUpdateEnabled(Delegate _this, Context context, boolean value) {
                Intrinsics.checkNotNullParameter(context, "context");
                _this.getSharedPreferences(context, "bili_main_settings_preferences").edit().putBoolean(context.getString(R.string.update_pref_key_wifi_auto_update), value).apply();
            }

            public static boolean $default$isWifiAutoUpdateEnabled(Delegate _this, Context context, boolean defaultValue) {
                Intrinsics.checkNotNullParameter(context, "context");
                return _this.getSharedPreferences(context, "bili_main_settings_preferences").getBoolean(context.getString(R.string.update_pref_key_wifi_auto_update), true);
            }
        }
    }
}