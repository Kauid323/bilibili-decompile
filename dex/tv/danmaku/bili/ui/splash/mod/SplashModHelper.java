package tv.danmaku.bili.ui.splash.mod;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat$;
import androidx.core.content.ContextCompat;
import bolts.Task;
import com.alibaba.fastjson.JSON;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliContextKt;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.droid.StringUtil;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.biliid.internal.fingerprint.Fingerprint;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.mod.ModErrorInfo;
import com.bilibili.lib.mod.ModProgress;
import com.bilibili.lib.mod.ModResource;
import com.bilibili.lib.mod.ModResourceClient;
import com.bilibili.lib.mod.request.ModUpdateRequest;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import com.facebook.soloader.DirectorySoSource;
import com.facebook.soloader.SoLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.util.CpuUtils;
import tv.danmaku.bili.ui.splash.ad.page.ISplash;
import tv.danmaku.bili.ui.splash.utils.X86SoLoader;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashModHelper.kt */
@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0003*\u0001?\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010\u001f\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010!\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\"\u001a\u00020\u000fH\u0007J\u0010\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010%J\b\u0010&\u001a\u00020\u001bH\u0002J\u0018\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020*H\u0002J\u0016\u0010+\u001a\u00020\u000f2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-H\u0002J\u001e\u0010/\u001a\u00020\u000f2\f\u00100\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u00101\u001a\u00020\u0005H\u0002J\u0010\u00102\u001a\u00020\u001b2\u0006\u0010(\u001a\u000203H\u0007J\u0010\u00104\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u001dH\u0007J\u0010\u00105\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u000203H\u0007J\b\u00106\u001a\u00020\u000fH\u0002J\u0010\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u00020*H\u0002J\u0010\u00109\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u0005H\u0002J\u0012\u0010:\u001a\u00020\u001b2\b\b\u0002\u0010;\u001a\u00020\u000fH\u0002J\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u0010=\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0012\u001a\u00020\u000f8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0004\n\u0002\u0010@¨\u0006A"}, d2 = {"Ltv/danmaku/bili/ui/splash/mod/SplashModHelper;", "", "<init>", "()V", "X86_ARCH_NAME", "", "PREF_KEY_SO_LIBS_NAME", "POOL_NAME", "MOD_NAME", "KEY_SO_PATH", "ACTION_X86_SO_READY", "PREF_KEY_X86_SO_PATH", "PROC_NAME_WEB", "sInstallSoTask", "Ljava/util/concurrent/Future;", "", "sIsLoaded", "sIsChecked", "sIsX86Device", "getSIsX86Device$annotations", "getSIsX86Device", "()Z", "sIsX86Device$delegate", "Lkotlin/Lazy;", "sReceiver", "Landroid/content/BroadcastReceiver;", "unregister", "", "app", "Landroid/content/Context;", "register", "loadFrescoSoForWebProcess", "path", "loadLibraryInOtherProcess", "isModLoaded", "getSplashMod", "callback", "Ltv/danmaku/bili/ui/splash/mod/SplashModCallback;", "listenToModUpdate", "recordLibraryName", "context", "mod", "Lcom/bilibili/lib/mod/ModResource;", "checkSoFile", "soLibs", "", "Ljava/io/File;", "hasFile", "files", "name", "checkResource", "Landroid/app/Application;", "checkX86So", "preLoad", "isWebProcess", "loadLibrary", "modResource", "sendBroadCast", "doDelayInit", "isMainProcess", "getArchSoSet", "rootPath", "mActivityCallback", "tv/danmaku/bili/ui/splash/mod/SplashModHelper$mActivityCallback$1", "Ltv/danmaku/bili/ui/splash/mod/SplashModHelper$mActivityCallback$1;", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashModHelper {
    private static final String ACTION_X86_SO_READY = "bili_action_x86_so_ready";
    private static final String KEY_SO_PATH = "key_so_path";
    private static final String MOD_NAME = "x86so";
    private static final String POOL_NAME = "pink";
    private static final String PREF_KEY_SO_LIBS_NAME = "pref_x86_so_libs_name";
    private static final String PREF_KEY_X86_SO_PATH = "pref_x86_so_path";
    private static final String PROC_NAME_WEB = ":web";
    private static final String X86_ARCH_NAME = "x86";
    private static Future<Boolean> sInstallSoTask;
    private static volatile boolean sIsChecked;
    private static volatile boolean sIsLoaded;
    private static BroadcastReceiver sReceiver;
    public static final SplashModHelper INSTANCE = new SplashModHelper();
    private static final Lazy sIsX86Device$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.splash.mod.SplashModHelper$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean sIsX86Device_delegate$lambda$0;
            sIsX86Device_delegate$lambda$0 = SplashModHelper.sIsX86Device_delegate$lambda$0();
            return Boolean.valueOf(sIsX86Device_delegate$lambda$0);
        }
    });
    private static final SplashModHelper$mActivityCallback$1 mActivityCallback = new Application.ActivityLifecycleCallbacks() { // from class: tv.danmaku.bili.ui.splash.mod.SplashModHelper$mActivityCallback$1
        private static void __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(Object activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (Intrinsics.areEqual(ConfigManager.Companion.ab().get("bgthread_ui_access_detect_enable", true), true)) {
                Thread thread = Thread.currentThread();
                if (!Intrinsics.areEqual(thread, Looper.getMainLooper().getThread())) {
                    IllegalStateException exp = new IllegalStateException("Activity.finish() called from non-UI thread: " + thread + ", 请联系 Jackin");
                    BLog.e("BgThreadUIAccess", "Activity.finish() called from non-UI thread: " + thread, exp);
                    Neurons.trackT(false, "app.bgthread.ui.access", MapsKt.mapOf(new Pair[]{TuplesKt.to("stacktrace", ExceptionsKt.stackTraceToString(exp)), TuplesKt.to("threadName", thread.getName())}), 1, new ActivityCompat$.ExternalSyntheticLambda0());
                    if (BuildConfig.DEBUG) {
                        throw exp;
                    }
                }
            }
            ((Activity) activity).finish();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (!(activity instanceof ISplash.SplashHost) && !SplashModHelper.isModLoaded()) {
                BLog.d(SplashModHelperKt.TAG, "x86 so is not ready");
                try {
                    RouteRequest request = new RouteRequest.Builder("bilibili://home").build();
                    BLRouter.routeTo(request, activity);
                    __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(activity);
                } catch (Exception e) {
                    BLog.d(SplashModHelperKt.TAG, "Splash activity start error");
                }
            }
            Application application = BiliContext.application();
            if (application != null) {
                application.unregisterActivityLifecycleCallbacks(this);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }
    };
    public static final int $stable = 8;

    @JvmStatic
    public static /* synthetic */ void getSIsX86Device$annotations() {
    }

    private SplashModHelper() {
    }

    public static final boolean getSIsX86Device() {
        return ((Boolean) sIsX86Device$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean sIsX86Device_delegate$lambda$0() {
        return CpuUtils.isX86(BiliContext.application());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unregister(Context context) {
        Context app = EnhancedUnmodifiabilityKt.unmodifiable(context);
        if (sReceiver != null) {
            BroadcastReceiver broadcastReceiver = sReceiver;
            Intrinsics.checkNotNull(broadcastReceiver);
            app.unregisterReceiver(broadcastReceiver);
            sReceiver = null;
        }
    }

    private final void register(Context context) {
        final Context app = EnhancedUnmodifiabilityKt.unmodifiable(context);
        if (sReceiver == null) {
            sReceiver = new BroadcastReceiver() { // from class: tv.danmaku.bili.ui.splash.mod.SplashModHelper$register$1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    boolean isWebProcess;
                    EnhancedUnmodifiabilityKt.unmodifiable(context2);
                    BLog.d(SplashModHelperKt.TAG, "broadcast receiver onReceive");
                    String path = intent != null ? intent.getStringExtra("key_so_path") : null;
                    SplashModHelper.INSTANCE.loadLibraryInOtherProcess(path);
                    isWebProcess = SplashModHelper.INSTANCE.isWebProcess();
                    if (isWebProcess) {
                        SplashModHelper.INSTANCE.loadFrescoSoForWebProcess(path);
                    }
                    SplashModHelper.INSTANCE.unregister(app);
                }
            };
            BroadcastReceiver broadcastReceiver = sReceiver;
            Intrinsics.checkNotNull(broadcastReceiver);
            ContextCompat.registerReceiver(app, broadcastReceiver, new IntentFilter(ACTION_X86_SO_READY), 4);
            BLog.d(SplashModHelperKt.TAG, "register broadcast receiver");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadFrescoSoForWebProcess(String path) {
        String str = path;
        if (str == null || StringsKt.isBlank(str)) {
            return;
        }
        try {
            SoLoader.prependSoSource(new DirectorySoSource(new File(path), 2));
            BLog.d(SplashModHelperKt.TAG, "fresco so load success in web process");
        } catch (Throwable e) {
            BLog.e(SplashModHelperKt.TAG, "fresco so load error in web process", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadLibraryInOtherProcess(final String path) {
        if (path == null || BiliContext.isMainProcess()) {
            return;
        }
        sInstallSoTask = Task.BACKGROUND_EXECUTOR.submit(new Callable() { // from class: tv.danmaku.bili.ui.splash.mod.SplashModHelper$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean loadLibraryInOtherProcess$lambda$0;
                loadLibraryInOtherProcess$lambda$0 = SplashModHelper.loadLibraryInOtherProcess$lambda$0(path);
                return loadLibraryInOtherProcess$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean loadLibraryInOtherProcess$lambda$0(String $path) {
        try {
            X86SoLoader.installNativeLibraryPath(INSTANCE.getClass().getClassLoader(), new File($path));
            INSTANCE.doDelayInit(false);
            BLog.d(SplashModHelperKt.TAG, "x86 so file load success in other process");
            return true;
        } catch (Throwable e) {
            BLog.e(SplashModHelperKt.TAG, "x86 so file load success in other process", e);
            return false;
        }
    }

    @JvmStatic
    public static final synchronized boolean isModLoaded() {
        Boolean bool;
        synchronized (SplashModHelper.class) {
            if (sIsChecked) {
                return sIsLoaded;
            }
            try {
                Future<Boolean> future = sInstallSoTask;
                sIsLoaded = (future == null || (bool = future.get()) == null) ? false : bool.booleanValue();
                sInstallSoTask = null;
            } catch (Exception e) {
                BLog.e(SplashModHelperKt.TAG, "get is resource loaded result failed", e);
                sInstallSoTask = null;
            }
            sIsChecked = true;
            return sIsLoaded;
        }
    }

    public final void getSplashMod(final SplashModCallback callback) {
        final Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        ModUpdateRequest request = new ModUpdateRequest.Builder("pink", MOD_NAME).isImmediate(true).build();
        ModResourceClient.getInstance().update(context, request, new ModResourceClient.OnUpdateCallback() { // from class: tv.danmaku.bili.ui.splash.mod.SplashModHelper$getSplashMod$1
            public /* synthetic */ void onMeetUpgradeCondition(String str, String str2) {
                ModResourceClient.OnUpdateObserver.-CC.$default$onMeetUpgradeCondition(this, str, str2);
            }

            public /* synthetic */ void onPreparing(ModUpdateRequest modUpdateRequest) {
                ModResourceClient.OnUpdateCallback.-CC.$default$onPreparing(this, modUpdateRequest);
            }

            public /* synthetic */ void onRemove(String str, String str2) {
                ModResourceClient.OnUpdateObserver.-CC.$default$onRemove(this, str, str2);
            }

            public /* synthetic */ void onVerifying(ModUpdateRequest modUpdateRequest) {
                ModResourceClient.OnUpdateCallback.-CC.$default$onVerifying(this, modUpdateRequest);
            }

            public void onSuccess(ModResource mod) {
                Intrinsics.checkNotNullParameter(mod, "mod");
                SplashModCallback splashModCallback = SplashModCallback.this;
                if (splashModCallback != null) {
                    splashModCallback.onSuccess();
                }
                SplashModHelper.INSTANCE.recordLibraryName(context, mod);
                SplashModHelper.INSTANCE.loadLibrary(mod);
                SplashModHelper splashModHelper = SplashModHelper.INSTANCE;
                SplashModHelper.sIsLoaded = true;
            }

            public void onProgress(ModUpdateRequest request2, ModProgress progress) {
                SplashModCallback splashModCallback = SplashModCallback.this;
                if (splashModCallback != null) {
                    splashModCallback.onProgress(progress != null ? Float.valueOf(progress.getProgress()) : null);
                }
            }

            public void onFail(ModUpdateRequest request2, ModErrorInfo errorInfo) {
                SplashModCallback splashModCallback = SplashModCallback.this;
                if (splashModCallback != null) {
                    splashModCallback.onFail();
                }
            }

            public boolean isCancelled() {
                SplashModCallback splashModCallback = SplashModCallback.this;
                if (splashModCallback != null) {
                    return splashModCallback.isCancel();
                }
                return false;
            }
        });
    }

    private final void listenToModUpdate() {
        final Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        ModResourceClient.getInstance().subscribe("pink", MOD_NAME, new ModResourceClient.OnUpdateObserver() { // from class: tv.danmaku.bili.ui.splash.mod.SplashModHelper$$ExternalSyntheticLambda3
            public /* synthetic */ void onFail(ModUpdateRequest modUpdateRequest, ModErrorInfo modErrorInfo) {
                ModResourceClient.OnUpdateObserver.-CC.$default$onFail(this, modUpdateRequest, modErrorInfo);
            }

            public /* synthetic */ void onMeetUpgradeCondition(String str, String str2) {
                ModResourceClient.OnUpdateObserver.-CC.$default$onMeetUpgradeCondition(this, str, str2);
            }

            public /* synthetic */ void onRemove(String str, String str2) {
                ModResourceClient.OnUpdateObserver.-CC.$default$onRemove(this, str, str2);
            }

            public final void onSuccess(ModResource modResource) {
                SplashModHelper.listenToModUpdate$lambda$0(context, modResource);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenToModUpdate$lambda$0(Application $context, ModResource it) {
        Intrinsics.checkNotNullParameter(it, "it");
        INSTANCE.recordLibraryName($context, it);
        BLog.d(SplashModHelperKt.TAG, "mod resource updated");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordLibraryName(Context context, ModResource mod) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        if (!mod.isAvailable()) {
            return;
        }
        String resourceDirPath = mod.getResourceDirPath();
        Intrinsics.checkNotNull(resourceDirPath);
        Set soLibs = getArchSoSet(resourceDirPath);
        List nameList = new ArrayList();
        for (File lib : soLibs) {
            String name = lib.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            nameList.add(name);
        }
        SharedPreferences sharedPreferences = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context2);
        sharedPreferences.edit().putString(PREF_KEY_SO_LIBS_NAME, JSON.toJSONString(nameList)).apply();
    }

    private final boolean checkSoFile(Set<? extends File> set) {
        Set soLibs = EnhancedUnmodifiabilityKt.unmodifiable(set);
        Application context = BiliContext.application();
        if (context == null) {
            return false;
        }
        try {
            List<String> nameList = JSON.parseArray(BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getString(PREF_KEY_SO_LIBS_NAME, ""), String.class);
            if (nameList == null || nameList.isEmpty()) {
                return false;
            }
            for (String filename : nameList) {
                if (!hasFile(soLibs, filename)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            BLog.e(SplashModHelperKt.TAG, "parse so name failed", e);
            return false;
        }
    }

    private final boolean hasFile(Set<? extends File> set, String name) {
        Set<File> files = EnhancedUnmodifiabilityKt.unmodifiable(set);
        for (File item : files) {
            String name2 = item.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            if (StringsKt.contains$default(name2, name, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final void checkResource(final Application context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!getSIsX86Device() || sIsChecked) {
            return;
        }
        boolean isMainProcess = BiliContext.isMainProcess();
        if (isMainProcess) {
            sInstallSoTask = Task.BACKGROUND_EXECUTOR.submit(new Callable() { // from class: tv.danmaku.bili.ui.splash.mod.SplashModHelper$$ExternalSyntheticLambda2
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Boolean checkResource$lambda$0;
                    checkResource$lambda$0 = SplashModHelper.checkResource$lambda$0(context);
                    return checkResource$lambda$0;
                }
            });
        }
        if (INSTANCE.isWebProcess()) {
            String path = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getString(PREF_KEY_X86_SO_PATH, "");
            if (!TextUtils.isEmpty(path)) {
                INSTANCE.loadFrescoSoForWebProcess(path);
            }
        }
        context.registerActivityLifecycleCallbacks(mActivityCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean checkResource$lambda$0(Application $context) {
        ModResource modResource = ModResourceClient.getInstance().get($context, "pink", MOD_NAME);
        Intrinsics.checkNotNullExpressionValue(modResource, "get(...)");
        if (modResource.isAvailable()) {
            SplashModHelper splashModHelper = INSTANCE;
            String resourceDirPath = modResource.getResourceDirPath();
            Intrinsics.checkNotNull(resourceDirPath);
            Set soLibs = splashModHelper.getArchSoSet(resourceDirPath);
            if (!INSTANCE.checkSoFile(soLibs)) {
                BLog.e(SplashModHelperKt.TAG, "check so file failed");
                return false;
            }
            boolean loadSuccess = INSTANCE.loadLibrary(modResource);
            if (loadSuccess) {
                INSTANCE.listenToModUpdate();
            }
            return Boolean.valueOf(loadSuccess);
        }
        return false;
    }

    @JvmStatic
    public static final boolean checkX86So(Context context) {
        Context context2 = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(context2, "context");
        return getSIsX86Device();
    }

    @JvmStatic
    public static final void preLoad(Application app) {
        Intrinsics.checkNotNullParameter(app, "app");
        if (BiliContext.isMainProcess() || !getSIsX86Device()) {
            return;
        }
        String path = BiliGlobalPreferenceHelper.getBLKVSharedPreference(app).getString(PREF_KEY_X86_SO_PATH, "");
        if (TextUtils.isEmpty(path)) {
            INSTANCE.register(app);
        } else {
            INSTANCE.loadLibraryInOtherProcess(path);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isWebProcess() {
        String process = BiliContext.currentProcessName();
        if (StringUtil.endsWith(process, PROC_NAME_WEB)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean loadLibrary(ModResource modResource) {
        try {
            String resourceDirPath = modResource.getResourceDirPath();
            Intrinsics.checkNotNull(resourceDirPath);
            String path = resourceDirPath + File.separator + X86_ARCH_NAME;
            Intrinsics.checkNotNullExpressionValue(path, "toString(...)");
            Application application = BiliContext.application();
            Intrinsics.checkNotNull(application);
            BiliGlobalPreferenceHelper.getBLKVSharedPreference(application).edit().putString(PREF_KEY_X86_SO_PATH, path).commit();
            sendBroadCast(path);
            X86SoLoader.installNativeLibraryPath(getClass().getClassLoader(), new File(path));
            SoLoader.prependSoSource(new DirectorySoSource(new File(path), 2));
            doDelayInit$default(this, false, 1, null);
            BLog.d(SplashModHelperKt.TAG, "x86 so file load success in main process");
            return true;
        } catch (Throwable t) {
            BLog.e(SplashModHelperKt.TAG, "load library error", t);
            return false;
        }
    }

    private final void sendBroadCast(String path) {
        Intent intent = new Intent(ACTION_X86_SO_READY);
        intent.setPackage(BiliContextKt.getPackageName(BiliContext.INSTANCE));
        intent.putExtra(KEY_SO_PATH, path);
        Application application = BiliContext.application();
        if (application != null) {
            application.sendBroadcast(intent);
        }
        BLog.d(SplashModHelperKt.TAG, "send broadcast");
    }

    static /* synthetic */ void doDelayInit$default(SplashModHelper splashModHelper, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        splashModHelper.doDelayInit(z);
    }

    private final void doDelayInit(boolean isMainProcess) {
        try {
            BLog.d(SplashModHelperKt.TAG, "so lazy init start");
            if (isMainProcess) {
                Fingerprint.INSTANCE.doInit();
            }
            BLog.d(SplashModHelperKt.TAG, "so lazy init success");
        } catch (UnsatisfiedLinkError e) {
            BLog.e(SplashModHelperKt.TAG, "so lazy init error");
        }
    }

    private final Set<File> getArchSoSet(String rootPath) {
        StringBuilder path = new StringBuilder().append(rootPath).append(File.separator).append(X86_ARCH_NAME);
        File soDir = new File(path.toString());
        if (!soDir.exists()) {
            return EnhancedUnmodifiabilityKt.unmodifiable(new HashSet());
        }
        File[] list = soDir.listFiles();
        if (list == null) {
            return EnhancedUnmodifiabilityKt.unmodifiable(new HashSet());
        }
        HashSet result = new HashSet();
        for (File f : list) {
            result.add(f);
        }
        return EnhancedUnmodifiabilityKt.unmodifiable(result);
    }
}