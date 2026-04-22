package leakcanary.internal;

import android.app.Activity;
import android.app.Application;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.squareup.leakcanary.core.R;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.AppWatcher;
import leakcanary.EventListener;
import leakcanary.GcTrigger;
import leakcanary.LeakCanary;
import leakcanary.OnObjectRetainedListener;
import leakcanary.internal.HeapDumpControl;
import leakcanary.internal.InternalLeakCanary;
import leakcanary.internal.tv.TvOnRetainInstanceListener;
import shark.SharkLog;

/* compiled from: InternalLeakCanary.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001IB\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\u0010\u00107\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u00108\u001a\u00020\u0003H\u0002J\u000e\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<J\u0011\u0010=\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0002J\u000e\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u000fJ\b\u0010@\u001a\u00020\u0003H\u0016J\u0010\u0010A\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0006\u0010B\u001a\u00020\u0003J\u000e\u0010C\u001a\u00020\u00032\u0006\u0010D\u001a\u00020EJ\u0016\u0010F\u001a\u00020\u00032\u0006\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0005R\u0011\u0010\u000b\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR#\u0010\u001e\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001d\u001a\u0004\b!\u0010\"R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u001d\u001a\u0004\b&\u0010\u0012R\u001b\u0010(\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u001d\u001a\u0004\b(\u0010\u0012R\u001b\u0010*\u001a\u00020+8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u001d\u001a\u0004\b,\u0010-R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0018\u00105\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b6\u0010\u0005¨\u0006J"}, d2 = {"Lleakcanary/internal/InternalLeakCanary;", "Lkotlin/Function1;", "Landroid/app/Application;", "", "Lleakcanary/OnObjectRetainedListener;", "()V", "DYNAMIC_SHORTCUT_ID", "", "LEAK_CANARY_THREAD_NAME", "_application", "get_application$annotations", "application", "getApplication", "()Landroid/app/Application;", "<set-?>", "", "applicationVisible", "getApplicationVisible", "()Z", "value", "dumpEnabledInAboutScreen", "getDumpEnabledInAboutScreen$leakcanary_android_core_release", "setDumpEnabledInAboutScreen$leakcanary_android_core_release", "(Z)V", "formFactor", "Lleakcanary/internal/InternalLeakCanary$FormFactor;", "getFormFactor", "()Lleakcanary/internal/InternalLeakCanary$FormFactor;", "formFactor$delegate", "Lkotlin/Lazy;", "heapDumpPrefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getHeapDumpPrefs", "()Landroid/content/SharedPreferences;", "heapDumpPrefs$delegate", "heapDumpTrigger", "Lleakcanary/internal/HeapDumpTrigger;", "isDebuggableBuild", "isDebuggableBuild$delegate", "isInstantApp", "isInstantApp$delegate", "onRetainInstanceListener", "Lleakcanary/internal/OnRetainInstanceListener;", "getOnRetainInstanceListener", "()Lleakcanary/internal/OnRetainInstanceListener;", "onRetainInstanceListener$delegate", "resumedActivity", "Landroid/app/Activity;", "getResumedActivity", "()Landroid/app/Activity;", "setResumedActivity", "(Landroid/app/Activity;)V", "version", "getVersion$annotations", "addDynamicShortcut", "checkRunningInDebuggableBuild", "createLeakDirectoryProvider", "Lleakcanary/internal/LeakDirectoryProvider;", "context", "Landroid/content/Context;", "invoke", "onDumpHeapReceived", "forceDump", "onObjectRetained", "registerResumedActivityListener", "scheduleRetainedObjectCheck", "sendEvent", "event", "Lleakcanary/EventListener$Event;", "setEnabledBlocking", "componentClassName", "enabled", "FormFactor", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class InternalLeakCanary implements Function1<Application, Unit>, OnObjectRetainedListener {
    private static final String DYNAMIC_SHORTCUT_ID = "com.squareup.leakcanary.dynamic_shortcut";
    private static final String LEAK_CANARY_THREAD_NAME = "LeakCanary-Heap-Dump";
    private static Application _application;
    private static volatile boolean applicationVisible;
    private static HeapDumpTrigger heapDumpTrigger;
    private static Activity resumedActivity;
    public static final InternalLeakCanary INSTANCE = new InternalLeakCanary();
    private static String version = "2.13";
    private static final Lazy isDebuggableBuild$delegate = LazyKt.lazy(new Function0<Boolean>() { // from class: leakcanary.internal.InternalLeakCanary$isDebuggableBuild$2
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return (InternalLeakCanary.INSTANCE.getApplication().getApplicationInfo().flags & 2) != 0;
        }
    });
    private static final Lazy formFactor$delegate = LazyKt.lazy(new Function0<FormFactor>() { // from class: leakcanary.internal.InternalLeakCanary$formFactor$2
        @Override // kotlin.jvm.functions.Function0
        public final InternalLeakCanary.FormFactor invoke() {
            Object systemService = InternalLeakCanary.INSTANCE.getApplication().getSystemService("uimode");
            if (systemService != null) {
                switch (((UiModeManager) systemService).getCurrentModeType()) {
                    case 4:
                        return InternalLeakCanary.FormFactor.TV;
                    case 5:
                    default:
                        return InternalLeakCanary.FormFactor.MOBILE;
                    case 6:
                        return InternalLeakCanary.FormFactor.WATCH;
                }
            }
            throw new TypeCastException("null cannot be cast to non-null type android.app.UiModeManager");
        }
    });
    private static final Lazy isInstantApp$delegate = LazyKt.lazy(new Function0<Boolean>() { // from class: leakcanary.internal.InternalLeakCanary$isInstantApp$2
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            if (Build.VERSION.SDK_INT >= 26) {
                PackageManager packageManager = InternalLeakCanary.INSTANCE.getApplication().getPackageManager();
                Intrinsics.checkExpressionValueIsNotNull(packageManager, "application.packageManager");
                if (packageManager.isInstantApp()) {
                    return true;
                }
            }
            return false;
        }
    });
    private static final Lazy onRetainInstanceListener$delegate = LazyKt.lazy(new Function0<OnRetainInstanceListener>() { // from class: leakcanary.internal.InternalLeakCanary$onRetainInstanceListener$2
        @Override // kotlin.jvm.functions.Function0
        public final OnRetainInstanceListener invoke() {
            switch (InternalLeakCanary.INSTANCE.getFormFactor()) {
                case TV:
                    return new TvOnRetainInstanceListener(InternalLeakCanary.INSTANCE.getApplication());
                default:
                    return new DefaultOnRetainInstanceListener();
            }
        }
    });
    private static final Lazy heapDumpPrefs$delegate = LazyKt.lazy(new Function0<SharedPreferences>() { // from class: leakcanary.internal.InternalLeakCanary$heapDumpPrefs$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SharedPreferences invoke() {
            return InternalLeakCanary.INSTANCE.getApplication().getSharedPreferences("LeakCanaryHeapDumpPrefs", 0);
        }
    });

    /* compiled from: InternalLeakCanary.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lleakcanary/internal/InternalLeakCanary$FormFactor;", "", "(Ljava/lang/String;I)V", "MOBILE", "TV", "WATCH", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public enum FormFactor {
        MOBILE,
        TV,
        WATCH
    }

    private final SharedPreferences getHeapDumpPrefs() {
        return (SharedPreferences) heapDumpPrefs$delegate.getValue();
    }

    @JvmStatic
    private static /* synthetic */ void getVersion$annotations() {
    }

    private static /* synthetic */ void get_application$annotations() {
    }

    private final boolean isDebuggableBuild() {
        return ((Boolean) isDebuggableBuild$delegate.getValue()).booleanValue();
    }

    public final FormFactor getFormFactor() {
        return (FormFactor) formFactor$delegate.getValue();
    }

    public final OnRetainInstanceListener getOnRetainInstanceListener() {
        return (OnRetainInstanceListener) onRetainInstanceListener$delegate.getValue();
    }

    public final boolean isInstantApp() {
        return ((Boolean) isInstantApp$delegate.getValue()).booleanValue();
    }

    private InternalLeakCanary() {
    }

    public static final /* synthetic */ HeapDumpTrigger access$getHeapDumpTrigger$p(InternalLeakCanary $this) {
        HeapDumpTrigger heapDumpTrigger2 = heapDumpTrigger;
        if (heapDumpTrigger2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("heapDumpTrigger");
        }
        return heapDumpTrigger2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Application application) {
        invoke2(application);
        return Unit.INSTANCE;
    }

    public final Application getApplication() {
        if (!(_application != null)) {
            throw new IllegalStateException("LeakCanary not installed, see AppWatcher.manualInstall()".toString());
        }
        Application application = _application;
        if (application == null) {
            Intrinsics.throwNpe();
        }
        return application;
    }

    public final boolean getApplicationVisible() {
        return applicationVisible;
    }

    public final LeakDirectoryProvider createLeakDirectoryProvider(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Context appContext = context.getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(appContext, "appContext");
        return new LeakDirectoryProvider(appContext, new Function0<Integer>() { // from class: leakcanary.internal.InternalLeakCanary$createLeakDirectoryProvider$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return LeakCanary.getConfig().getMaxStoredHeapDumps();
            }
        }, new Function0<Boolean>() { // from class: leakcanary.internal.InternalLeakCanary$createLeakDirectoryProvider$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                return LeakCanary.getConfig().getRequestWriteExternalStoragePermission();
            }
        });
    }

    public final Activity getResumedActivity() {
        return resumedActivity;
    }

    public final void setResumedActivity(Activity activity) {
        resumedActivity = activity;
    }

    public final boolean getDumpEnabledInAboutScreen$leakcanary_android_core_release() {
        return getHeapDumpPrefs().getBoolean("AboutScreenDumpEnabled", true);
    }

    public final void setDumpEnabledInAboutScreen$leakcanary_android_core_release(boolean value) {
        getHeapDumpPrefs().edit().putBoolean("AboutScreenDumpEnabled", value).apply();
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public void invoke2(final Application application) {
        Intrinsics.checkParameterIsNotNull(application, "application");
        _application = application;
        checkRunningInDebuggableBuild();
        AppWatcher.INSTANCE.getObjectWatcher().addOnObjectRetainedListener(this);
        GcTrigger.Default gcTrigger = GcTrigger.Default.INSTANCE;
        Function0 configProvider = new Function0<LeakCanary.Config>() { // from class: leakcanary.internal.InternalLeakCanary$invoke$configProvider$1
            @Override // kotlin.jvm.functions.Function0
            public final LeakCanary.Config invoke() {
                return LeakCanary.getConfig();
            }
        };
        HandlerThread handlerThread = new HandlerThread(LEAK_CANARY_THREAD_NAME);
        handlerThread.start();
        final Handler backgroundHandler = new Handler(handlerThread.getLooper());
        heapDumpTrigger = new HeapDumpTrigger(application, backgroundHandler, AppWatcher.INSTANCE.getObjectWatcher(), gcTrigger, configProvider);
        VisibilityTrackerKt.registerVisibilityListener(application, new Function1<Boolean, Unit>() { // from class: leakcanary.internal.InternalLeakCanary$invoke$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean applicationVisible2) {
                InternalLeakCanary internalLeakCanary = InternalLeakCanary.INSTANCE;
                InternalLeakCanary.applicationVisible = applicationVisible2;
                InternalLeakCanary.access$getHeapDumpTrigger$p(InternalLeakCanary.INSTANCE).onApplicationVisibilityChanged(applicationVisible2);
            }
        });
        registerResumedActivityListener(application);
        addDynamicShortcut(application);
        HandlersKt.getMainHandler().post(new Runnable() { // from class: leakcanary.internal.InternalLeakCanary$invoke$2
            @Override // java.lang.Runnable
            public final void run() {
                backgroundHandler.post(new Runnable() { // from class: leakcanary.internal.InternalLeakCanary$invoke$2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        String string;
                        SharkLog this_$iv = SharkLog.INSTANCE;
                        SharkLog.Logger logger$iv = this_$iv.getLogger();
                        if (logger$iv != null) {
                            HeapDumpControl.ICanHazHeap iCanHasHeap = HeapDumpControl.INSTANCE.iCanHasHeap();
                            if (iCanHasHeap instanceof HeapDumpControl.ICanHazHeap.Yup) {
                                string = application.getString(R.string.leak_canary_heap_dump_enabled_text);
                                Intrinsics.checkExpressionValueIsNotNull(string, "application.getString(R.…y_heap_dump_enabled_text)");
                            } else if (iCanHasHeap instanceof HeapDumpControl.ICanHazHeap.Nope) {
                                string = application.getString(R.string.leak_canary_heap_dump_disabled_text, new Object[]{((HeapDumpControl.ICanHazHeap.Nope) iCanHasHeap).getReason().invoke()});
                                Intrinsics.checkExpressionValueIsNotNull(string, "application.getString(\n …ap.reason()\n            )");
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                            logger$iv.d(string);
                        }
                    }
                });
            }
        });
    }

    private final void checkRunningInDebuggableBuild() {
        if (!isDebuggableBuild() && !getApplication().getResources().getBoolean(R.bool.leak_canary_allow_in_non_debuggable_build)) {
            throw new Error("LeakCanary in non-debuggable build\n\nLeakCanary should only be used in debug builds, but this APK is not debuggable.\nPlease follow the instructions on the \"Getting started\" page to only include LeakCanary in\ndebug builds: https://square.github.io/leakcanary/getting_started/\n\nIf you're sure you want to include LeakCanary in a non-debuggable build, follow the\ninstructions here: https://square.github.io/leakcanary/recipes/#leakcanary-in-release-builds");
        }
    }

    private final void registerResumedActivityListener(Application application) {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: leakcanary.internal.InternalLeakCanary$registerResumedActivityListener$1
            private final /* synthetic */ Application.ActivityLifecycleCallbacks $$delegate_0;

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity p0, Bundle bundle) {
                Intrinsics.checkParameterIsNotNull(p0, "p0");
                this.$$delegate_0.onActivityCreated(p0, bundle);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity p0) {
                Intrinsics.checkParameterIsNotNull(p0, "p0");
                this.$$delegate_0.onActivityDestroyed(p0);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity p0, Bundle p1) {
                Intrinsics.checkParameterIsNotNull(p0, "p0");
                Intrinsics.checkParameterIsNotNull(p1, "p1");
                this.$$delegate_0.onActivitySaveInstanceState(p0, p1);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity p0) {
                Intrinsics.checkParameterIsNotNull(p0, "p0");
                this.$$delegate_0.onActivityStarted(p0);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity p0) {
                Intrinsics.checkParameterIsNotNull(p0, "p0");
                this.$$delegate_0.onActivityStopped(p0);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                Object newProxyInstance = Proxy.newProxyInstance(Application.ActivityLifecycleCallbacks.class.getClassLoader(), new Class[]{Application.ActivityLifecycleCallbacks.class}, ObjectsKt.access$getNO_OP_HANDLER$p());
                if (newProxyInstance == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.app.Application.ActivityLifecycleCallbacks");
                }
                this.$$delegate_0 = (Application.ActivityLifecycleCallbacks) newProxyInstance;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                Intrinsics.checkParameterIsNotNull(activity, "activity");
                InternalLeakCanary.INSTANCE.setResumedActivity(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                Intrinsics.checkParameterIsNotNull(activity, "activity");
                if (InternalLeakCanary.INSTANCE.getResumedActivity() == activity) {
                    InternalLeakCanary.INSTANCE.setResumedActivity(null);
                }
            }
        });
    }

    private final void addDynamicShortcut(Application application) {
        ShortcutManager shortcutManager;
        int i;
        String firstLauncherActivityLabel;
        String shortLabel;
        String shortLabel2;
        int count$iv;
        int i2;
        if (Build.VERSION.SDK_INT < 25 || !application.getResources().getBoolean(R.bool.leak_canary_add_dynamic_shortcut) || isInstantApp() || (shortcutManager = (ShortcutManager) application.getSystemService(ShortcutManager.class)) == null) {
            return;
        }
        Iterable dynamicShortcuts = shortcutManager.getDynamicShortcuts();
        Intrinsics.checkExpressionValueIsNotNull(dynamicShortcuts, "shortcutManager.dynamicShortcuts");
        Iterable $this$any$iv = dynamicShortcuts;
        if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
            Iterator<T> it = $this$any$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    Object element$iv = it.next();
                    ShortcutInfo shortcut = (ShortcutInfo) element$iv;
                    Intrinsics.checkExpressionValueIsNotNull(shortcut, "shortcut");
                    if (Intrinsics.areEqual(shortcut.getId(), DYNAMIC_SHORTCUT_ID)) {
                        i = 1;
                        break;
                    }
                } else {
                    i = 0;
                    break;
                }
            }
        } else {
            i = 0;
        }
        int $i$f$any = i;
        if ($i$f$any != 0) {
            return;
        }
        Intent mainIntent = new Intent("android.intent.action.MAIN", (Uri) null);
        mainIntent.addCategory("android.intent.category.LAUNCHER");
        mainIntent.setPackage(application.getPackageName());
        Iterable queryIntentActivities = application.getPackageManager().queryIntentActivities(mainIntent, 0);
        Intrinsics.checkExpressionValueIsNotNull(queryIntentActivities, "application.packageManag…Activities(mainIntent, 0)");
        Iterable $this$filter$iv = queryIntentActivities;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            ResolveInfo it2 = (ResolveInfo) element$iv$iv;
            if (!Intrinsics.areEqual(it2.activityInfo.name, "leakcanary.internal.activity.LeakLauncherActivity")) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List activities = (List) destination$iv$iv;
        if (activities.isEmpty()) {
            return;
        }
        ActivityInfo firstMainActivity = ((ResolveInfo) CollectionsKt.first((List<? extends Object>) activities)).activityInfo;
        String leakActivityLabel = application.getString(R.string.leak_canary_shortcut_label);
        Intrinsics.checkExpressionValueIsNotNull(leakActivityLabel, "application.getString(R.…ak_canary_shortcut_label)");
        if (activities.isEmpty()) {
            shortLabel = leakActivityLabel;
            shortLabel2 = leakActivityLabel;
        } else {
            if (firstMainActivity.labelRes != 0) {
                firstLauncherActivityLabel = application.getString(firstMainActivity.labelRes);
            } else {
                firstLauncherActivityLabel = application.getPackageManager().getApplicationLabel(application.getApplicationInfo());
            }
            Intrinsics.checkExpressionValueIsNotNull(firstLauncherActivityLabel, "if (firstMainActivity.la….applicationInfo)\n      }");
            String fullLengthLabel = firstLauncherActivityLabel + ' ' + leakActivityLabel;
            if (fullLengthLabel.length() > 10) {
                if (fullLengthLabel.length() <= 25) {
                    shortLabel = leakActivityLabel;
                    shortLabel2 = fullLengthLabel;
                } else {
                    shortLabel = leakActivityLabel;
                    shortLabel2 = leakActivityLabel;
                }
            } else {
                shortLabel = fullLengthLabel;
                shortLabel2 = fullLengthLabel;
            }
        }
        ComponentName componentName = new ComponentName(firstMainActivity.packageName, firstMainActivity.name);
        Iterable $this$count$iv = dynamicShortcuts;
        if (($this$count$iv instanceof Collection) && ((Collection) $this$count$iv).isEmpty()) {
            count$iv = 0;
        } else {
            count$iv = 0;
            for (Object element$iv2 : $this$count$iv) {
                Iterable $this$count$iv2 = $this$count$iv;
                ShortcutInfo shortcutInfo = (ShortcutInfo) element$iv2;
                Intrinsics.checkExpressionValueIsNotNull(shortcutInfo, "shortcutInfo");
                List activities2 = activities;
                if (Intrinsics.areEqual(shortcutInfo.getActivity(), componentName) && (count$iv = count$iv + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
                $this$count$iv = $this$count$iv2;
                activities = activities2;
            }
        }
        Iterable $this$count$iv3 = shortcutManager.getManifestShortcuts();
        Intrinsics.checkExpressionValueIsNotNull($this$count$iv3, "shortcutManager.manifestShortcuts");
        Iterable $this$count$iv4 = $this$count$iv3;
        boolean z = false;
        if (($this$count$iv4 instanceof Collection) && ((Collection) $this$count$iv4).isEmpty()) {
            i2 = 0;
        } else {
            int count$iv2 = 0;
            for (Object element$iv3 : $this$count$iv4) {
                Iterable $this$count$iv5 = $this$count$iv4;
                ShortcutInfo shortcutInfo2 = (ShortcutInfo) element$iv3;
                Intrinsics.checkExpressionValueIsNotNull(shortcutInfo2, "shortcutInfo");
                boolean z2 = z;
                if (Intrinsics.areEqual(shortcutInfo2.getActivity(), componentName) && (count$iv2 = count$iv2 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
                $this$count$iv4 = $this$count$iv5;
                z = z2;
            }
            i2 = count$iv2;
        }
        int shortcutCount = count$iv + i2;
        if (shortcutCount >= shortcutManager.getMaxShortcutCountPerActivity()) {
            return;
        }
        Intent intent = LeakCanary.INSTANCE.newLeakDisplayActivityIntent();
        intent.setAction("Dummy Action because Android is stupid");
        ShortcutInfo shortcut2 = new ShortcutInfo.Builder(application, DYNAMIC_SHORTCUT_ID).setLongLabel(shortLabel2).setShortLabel(shortLabel).setActivity(componentName).setIcon(Icon.createWithResource(application, R.mipmap.leak_canary_icon)).setIntent(intent).build();
        Intrinsics.checkExpressionValueIsNotNull(shortcut2, "Builder(application, DYN…nt(intent)\n      .build()");
        try {
            shortcutManager.addDynamicShortcuts(CollectionsKt.listOf(shortcut2));
        } catch (Throwable ignored) {
            SharkLog this_$iv = SharkLog.INSTANCE;
            SharkLog.Logger logger$iv = this_$iv.getLogger();
            if (logger$iv != null) {
                logger$iv.d(ignored, "Could not add dynamic shortcut. shortcutCount=" + shortcutCount + ", maxShortcutCountPerActivity=" + shortcutManager.getMaxShortcutCountPerActivity());
            }
        }
    }

    @Override // leakcanary.OnObjectRetainedListener
    public void onObjectRetained() {
        scheduleRetainedObjectCheck();
    }

    public final void scheduleRetainedObjectCheck() {
        if (heapDumpTrigger != null) {
            HeapDumpTrigger heapDumpTrigger2 = heapDumpTrigger;
            if (heapDumpTrigger2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("heapDumpTrigger");
            }
            HeapDumpTrigger.scheduleRetainedObjectCheck$default(heapDumpTrigger2, 0L, 1, null);
        }
    }

    public final void onDumpHeapReceived(boolean forceDump) {
        if (heapDumpTrigger != null) {
            HeapDumpTrigger heapDumpTrigger2 = heapDumpTrigger;
            if (heapDumpTrigger2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("heapDumpTrigger");
            }
            heapDumpTrigger2.onDumpHeapReceived(forceDump);
        }
    }

    public final void setEnabledBlocking(String componentClassName, boolean enabled) {
        Intrinsics.checkParameterIsNotNull(componentClassName, "componentClassName");
        ComponentName component = new ComponentName(getApplication(), componentClassName);
        int newState = enabled ? 1 : 2;
        getApplication().getPackageManager().setComponentEnabledSetting(component, newState, 1);
    }

    public final void sendEvent(EventListener.Event event) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        for (EventListener listener : LeakCanary.getConfig().getEventListeners()) {
            listener.onEvent(event);
        }
    }
}