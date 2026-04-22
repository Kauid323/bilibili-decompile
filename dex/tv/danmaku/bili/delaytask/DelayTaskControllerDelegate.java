package tv.danmaku.bili.delaytask;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.ActivityCompat$;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.base.util.DelayTaskController;
import com.bilibili.droid.ProcessUtils;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.crashreport.CrashReporter;
import com.bilibili.lib.neuron.api.Neurons;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.MainActivityV2;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: DelayTaskControllerDelegate.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001a\u0010\u0015\u001a\u00020\r2\u0010\u0010\u0016\u001a\f\u0012\u0004\u0012\u00020\r0\fj\u0002`\u000eH\u0002J\u001a\u0010\u0017\u001a\u00020\r2\u0010\u0010\u0016\u001a\f\u0012\u0004\u0012\u00020\r0\fj\u0002`\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0003J\b\u0010\u001b\u001a\u00020\u0005H\u0002J\b\u0010\u001c\u001a\u00020\rH\u0002J\u0012\u0010\u001d\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0003J\b\u0010 \u001a\u00020\rH\u0016J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020\rH\u0003J\b\u0010$\u001a\u00020\rH\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\r0\fj\u0002`\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Ltv/danmaku/bili/delaytask/DelayTaskControllerDelegate;", "Lcom/bilibili/base/util/DelayTaskController$Delegate;", "<init>", "()V", "triggered", "", "getTriggered", "()Z", "setTriggered", "(Z)V", "tasks", "", "Lkotlin/Function0;", "", "Lcom/bilibili/base/util/DelayTask;", "init", "app", "Landroid/app/Application;", "exitActivity", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "addDelayTask", "task", "execute", "shouldBlock", "makeProtect", "restartApp", "hasCrashed", "delayExecute", "handleError", "e", "", "reportErrorIfExist", "triggerExecute", "isMainProcInitializing", "allowNetwork", "allowPrivacy", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DelayTaskControllerDelegate implements DelayTaskController.Delegate {
    private static final String KEY_PRIVACY_ALLOWED = "bili.privacy.allowed";
    private static final int MAX_RESTART_TIMES = 3;
    private static final String PREF_KEY_DELAY_TASK_ERROR_MESSAGE = "bili.delay_task_error_message";
    private static final String PREF_KEY_DELAY_TASK_HAS_ERROR = "bili.delay_task_has_error";
    private static final String PREF_KEY_DELAY_TASK_MAIN_PROC_START = "bili.delay_task_main_proc_start";
    private static final String PREF_KEY_DELAY_TASK_RESTART_TIMES = "bili.delay_task_restart_times";
    private static final String TAG = "DelayTaskController";
    private final List<Function0<Unit>> tasks = new ArrayList();
    private boolean triggered;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public /* synthetic */ DelayTaskController.BlockReason getBlockReason() {
        return DelayTaskController.Delegate.-CC.$default$getBlockReason(this);
    }

    private static void __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(Object activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
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

    /* compiled from: DelayTaskControllerDelegate.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/delaytask/DelayTaskControllerDelegate$Companion;", "", "<init>", "()V", "TAG", "", "PREF_KEY_DELAY_TASK_HAS_ERROR", "PREF_KEY_DELAY_TASK_ERROR_MESSAGE", "PREF_KEY_DELAY_TASK_RESTART_TIMES", "PREF_KEY_DELAY_TASK_MAIN_PROC_START", "MAX_RESTART_TIMES", "", "KEY_PRIVACY_ALLOWED", "isPrivacyAllow", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isPrivacyAllow() {
            Application application = BiliContext.application();
            Intrinsics.checkNotNull(application);
            return BiliGlobalPreferenceHelper.getBLKVSharedPreference(application).getBoolean(DelayTaskControllerDelegate.KEY_PRIVACY_ALLOWED, false);
        }
    }

    public final boolean getTriggered() {
        return this.triggered;
    }

    public final void setTriggered(boolean z) {
        this.triggered = z;
    }

    public void init(final Application app) {
        Intrinsics.checkNotNullParameter(app, "app");
        this.tasks.clear();
        if (shouldBlock()) {
            makeProtect(app);
            BiliGlobalPreferenceHelper.getBLKVSharedPreference(app).registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: tv.danmaku.bili.delaytask.DelayTaskControllerDelegate$init$1
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                    if (TextUtils.equals(key, "bili.privacy.allowed")) {
                        BiliGlobalPreferenceHelper.getBLKVSharedPreference(app).unregisterOnSharedPreferenceChangeListener(this);
                        boolean z = false;
                        if (sharedPreferences != null && sharedPreferences.getBoolean("bili.privacy.allowed", false)) {
                            z = true;
                        }
                        if (z && !this.getTriggered()) {
                            this.delayExecute();
                        }
                    }
                }
            });
            if (ProcessUtils.isMainProcess()) {
                BiliGlobalPreferenceHelper.getBLKVSharedPreference(app).edit().putBoolean(PREF_KEY_DELAY_TASK_MAIN_PROC_START, true).apply();
            }
        } else if (ProcessUtils.isMainProcess()) {
            BiliGlobalPreferenceHelper.getBLKVSharedPreference(app).edit().putBoolean(PREF_KEY_DELAY_TASK_MAIN_PROC_START, false).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void exitActivity(Activity activity) {
        if (!activity.isFinishing()) {
            activity.finishAndRemoveTask();
        }
    }

    private final void addDelayTask(Function0<Unit> function0) {
        this.tasks.add(function0);
        BLog.d(TAG, "Add delay task.");
    }

    public void execute(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "task");
        if (shouldBlock()) {
            addDelayTask(function0);
        } else {
            function0.invoke();
        }
    }

    public boolean shouldBlock() {
        boolean shouldBlock = (hasCrashed() || Companion.isPrivacyAllow()) ? false : true;
        Log.d(TAG, "shouldBlock = " + shouldBlock);
        return shouldBlock;
    }

    private final void makeProtect(final Application app) {
        final Thread.UncaughtExceptionHandler handler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: tv.danmaku.bili.delaytask.DelayTaskControllerDelegate$$ExternalSyntheticLambda0
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, Throwable th) {
                DelayTaskControllerDelegate.makeProtect$lambda$0(DelayTaskControllerDelegate.this, handler, thread, th);
            }
        });
        app.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: tv.danmaku.bili.delaytask.DelayTaskControllerDelegate$makeProtect$2
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
                Intrinsics.checkNotNullParameter(outState, "outState");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
                if (!(activity instanceof DelayTaskController.IInterceptDialogHost) && DelayTaskControllerDelegate.this.shouldBlock()) {
                    DelayTaskControllerDelegate.this.exitActivity(activity);
                }
                app.unregisterActivityLifecycleCallbacks(this);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void makeProtect$lambda$0(DelayTaskControllerDelegate this$0, Thread.UncaughtExceptionHandler $handler, Thread t, Throwable e) {
        if (!Companion.isPrivacyAllow()) {
            Log.d(TAG, "isPrivacyAllow == false");
            if (this$0.restartApp()) {
                return;
            }
            this$0.handleError(e);
        }
        if ($handler != null) {
            $handler.uncaughtException(t, e);
        }
    }

    private final boolean restartApp() {
        Application context = BiliContext.application();
        if (context == null) {
            return false;
        }
        SharedPreferences sp = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context);
        int restartTimes = sp.getInt(PREF_KEY_DELAY_TASK_RESTART_TIMES, 0);
        Log.d(TAG, "restartTimes = " + restartTimes);
        if (restartTimes > 3) {
            return false;
        }
        Log.d(TAG, "try start mainActivity");
        sp.edit().putInt(PREF_KEY_DELAY_TASK_RESTART_TIMES, restartTimes + 1).commit();
        Intent intent = new Intent(context, MainActivityV2.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
        Process.killProcess(Process.myPid());
        return true;
    }

    private final boolean hasCrashed() {
        Application application = BiliContext.application();
        Intrinsics.checkNotNull(application);
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference(application).getBoolean(PREF_KEY_DELAY_TASK_HAS_ERROR, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void delayExecute() {
        Application it;
        try {
            BLog.d(TAG, "Execute delay task start.");
            for (Function0 task : this.tasks) {
                task.invoke();
            }
            this.tasks.clear();
            BLog.d(TAG, "Execute delay task end.");
        } catch (Exception e) {
            if (tv.danmaku.bili.BuildConfig.DEBUG) {
                throw e;
            }
            handleError(e);
            BLog.e(TAG, "Execute delay task error.", e);
        }
        if (ProcessUtils.isMainProcess() && (it = BiliContext.application()) != null) {
            BiliGlobalPreferenceHelper.getBLKVSharedPreference(it).edit().putBoolean(PREF_KEY_DELAY_TASK_MAIN_PROC_START, false).apply();
        }
    }

    private final void handleError(Throwable e) {
        Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        Log.d(TAG, "handleError success");
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putBoolean(PREF_KEY_DELAY_TASK_HAS_ERROR, true).commit();
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).edit().putString(PREF_KEY_DELAY_TASK_ERROR_MESSAGE, (e == null || (r2 = e.getMessage()) == null) ? "UNKNOWN ERROR" : "UNKNOWN ERROR").commit();
    }

    public void reportErrorIfExist() {
        Application context = BiliContext.application();
        if (context == null || !hasCrashed() || !Companion.isPrivacyAllow()) {
            return;
        }
        String errorMsg = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getString(PREF_KEY_DELAY_TASK_ERROR_MESSAGE, "UNKNOWN ERROR");
        CrashReporter.INSTANCE.postCaughtException(new DelayTaskException(errorMsg));
        Application application = BiliContext.application();
        Intrinsics.checkNotNull(application);
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(application).edit().remove(PREF_KEY_DELAY_TASK_HAS_ERROR).remove(PREF_KEY_DELAY_TASK_ERROR_MESSAGE).apply();
    }

    public void triggerExecute(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        this.triggered = true;
        allowNetwork();
        allowPrivacy();
        delayExecute();
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        Iterable $this$forEach$iv = BiliContext.getCallbacks();
        for (Object element$iv : $this$forEach$iv) {
            Application.ActivityLifecycleCallbacks it = (Application.ActivityLifecycleCallbacks) element$iv;
            it.onActivityCreated(activity, null);
            it.onActivityStarted(activity);
            it.onActivityResumed(activity);
        }
        Iterable $this$forEach$iv2 = BiliContext.getStateCallbacks();
        for (Object element$iv2 : $this$forEach$iv2) {
            BiliContext.ActivityStateCallback it2 = (BiliContext.ActivityStateCallback) element$iv2;
            it2.onActivityCreated(activity);
            it2.onActivityStarted(activity);
            it2.onActivityResumed(activity);
        }
    }

    public boolean isMainProcInitializing() {
        Application context = BiliContext.application();
        if (context == null) {
            return false;
        }
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getBoolean(PREF_KEY_DELAY_TASK_MAIN_PROC_START, false);
    }

    private final void allowNetwork() {
        Application application = BiliContext.application();
        Intrinsics.checkNotNull(application);
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(application).edit().putBoolean("bili.network.allowed", true).commit();
    }

    private final void allowPrivacy() {
        Application application = BiliContext.application();
        Intrinsics.checkNotNull(application);
        BiliGlobalPreferenceHelper.getBLKVSharedPreference(application).edit().putBoolean(KEY_PRIVACY_ALLOWED, true).commit();
    }
}