package leakcanary.internal;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import com.squareup.leakcanary.core.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.AppWatcher;
import leakcanary.LeakCanary;

/* compiled from: HeapDumpControl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001 B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001d\u001a\u00020\u0016J\u0006\u0010\u001e\u001a\u00020\u001fR\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0013\u0010\u0010R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lleakcanary/internal/HeapDumpControl;", "", "()V", "app", "Landroid/app/Application;", "getApp", "()Landroid/app/Application;", "backgroundUpdateHandler", "Landroid/os/Handler;", "getBackgroundUpdateHandler", "()Landroid/os/Handler;", "backgroundUpdateHandler$delegate", "Lkotlin/Lazy;", "hasLeakAssertionsClass", "", "getHasLeakAssertionsClass", "()Z", "hasLeakAssertionsClass$delegate", "hasTestClass", "getHasTestClass", "hasTestClass$delegate", "latest", "Lleakcanary/internal/HeapDumpControl$ICanHazHeap;", "leakAssertionsClassName", "", "testClassName", "getTestClassName", "()Ljava/lang/String;", "testClassName$delegate", "iCanHasHeap", "updateICanHasHeapInBackground", "", "ICanHazHeap", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class HeapDumpControl {
    private static volatile ICanHazHeap latest = null;
    private static final String leakAssertionsClassName = "leakcanary.LeakAssertions";
    public static final HeapDumpControl INSTANCE = new HeapDumpControl();
    private static final Lazy testClassName$delegate = LazyKt.lazy(new Function0<String>() { // from class: leakcanary.internal.HeapDumpControl$testClassName$2
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return InternalLeakCanary.INSTANCE.getApplication().getString(R.string.leak_canary_test_class_name);
        }
    });
    private static final Lazy hasTestClass$delegate = LazyKt.lazy(new Function0<Boolean>() { // from class: leakcanary.internal.HeapDumpControl$hasTestClass$2
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            String testClassName;
            try {
                testClassName = HeapDumpControl.INSTANCE.getTestClassName();
                Class.forName(testClassName);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    });
    private static final Lazy backgroundUpdateHandler$delegate = LazyKt.lazy(new Function0<Handler>() { // from class: leakcanary.internal.HeapDumpControl$backgroundUpdateHandler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            HandlerThread handlerThread = new HandlerThread("LeakCanary-Background-iCanHasHeap-Updater");
            handlerThread.start();
            return new Handler(handlerThread.getLooper());
        }
    });
    private static final Lazy hasLeakAssertionsClass$delegate = LazyKt.lazy(new Function0<Boolean>() { // from class: leakcanary.internal.HeapDumpControl$hasLeakAssertionsClass$2
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            try {
                Class.forName("leakcanary.LeakAssertions");
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    });

    private final Handler getBackgroundUpdateHandler() {
        return (Handler) backgroundUpdateHandler$delegate.getValue();
    }

    private final boolean getHasLeakAssertionsClass() {
        return ((Boolean) hasLeakAssertionsClass$delegate.getValue()).booleanValue();
    }

    private final boolean getHasTestClass() {
        return ((Boolean) hasTestClass$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getTestClassName() {
        return (String) testClassName$delegate.getValue();
    }

    private HeapDumpControl() {
    }

    public static final /* synthetic */ ICanHazHeap access$getLatest$p(HeapDumpControl $this) {
        ICanHazHeap iCanHazHeap = latest;
        if (iCanHazHeap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("latest");
        }
        return iCanHazHeap;
    }

    /* compiled from: HeapDumpControl.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lleakcanary/internal/HeapDumpControl$ICanHazHeap;", "", "()V", "Nope", "NotifyingNope", "SilentNope", "Yup", "Lleakcanary/internal/HeapDumpControl$ICanHazHeap$Yup;", "Lleakcanary/internal/HeapDumpControl$ICanHazHeap$Nope;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static abstract class ICanHazHeap {

        /* compiled from: HeapDumpControl.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lleakcanary/internal/HeapDumpControl$ICanHazHeap$Yup;", "Lleakcanary/internal/HeapDumpControl$ICanHazHeap;", "()V", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final class Yup extends ICanHazHeap {
            public static final Yup INSTANCE = new Yup();

            private Yup() {
                super(null);
            }
        }

        private ICanHazHeap() {
        }

        public /* synthetic */ ICanHazHeap(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        /* compiled from: HeapDumpControl.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lleakcanary/internal/HeapDumpControl$ICanHazHeap$Nope;", "Lleakcanary/internal/HeapDumpControl$ICanHazHeap;", "reason", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "getReason", "()Lkotlin/jvm/functions/Function0;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static abstract class Nope extends ICanHazHeap {
            private final Function0<String> reason;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Nope(Function0<String> reason) {
                super(null);
                Intrinsics.checkParameterIsNotNull(reason, "reason");
                this.reason = reason;
            }

            public final Function0<String> getReason() {
                return this.reason;
            }
        }

        /* compiled from: HeapDumpControl.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lleakcanary/internal/HeapDumpControl$ICanHazHeap$SilentNope;", "Lleakcanary/internal/HeapDumpControl$ICanHazHeap$Nope;", "reason", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final class SilentNope extends Nope {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SilentNope(Function0<String> reason) {
                super(reason);
                Intrinsics.checkParameterIsNotNull(reason, "reason");
            }
        }

        /* compiled from: HeapDumpControl.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lleakcanary/internal/HeapDumpControl$ICanHazHeap$NotifyingNope;", "Lleakcanary/internal/HeapDumpControl$ICanHazHeap$Nope;", "reason", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final class NotifyingNope extends Nope {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NotifyingNope(Function0<String> reason) {
                super(reason);
                Intrinsics.checkParameterIsNotNull(reason, "reason");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Application getApp() {
        return InternalLeakCanary.INSTANCE.getApplication();
    }

    public final void updateICanHasHeapInBackground() {
        getBackgroundUpdateHandler().post(new Runnable() { // from class: leakcanary.internal.HeapDumpControl$updateICanHasHeapInBackground$1
            @Override // java.lang.Runnable
            public final void run() {
                HeapDumpControl.INSTANCE.iCanHasHeap();
            }
        });
    }

    public final ICanHazHeap iCanHasHeap() {
        ICanHazHeap.Yup dumpHeap;
        LeakCanary.Config config = LeakCanary.getConfig();
        if (!AppWatcher.INSTANCE.isInstalled()) {
            dumpHeap = new ICanHazHeap.SilentNope(new Function0<String>() { // from class: leakcanary.internal.HeapDumpControl$iCanHasHeap$dumpHeap$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "AppWatcher is not installed.";
                }
            });
        } else if (!InternalLeakCanary.INSTANCE.getDumpEnabledInAboutScreen$leakcanary_android_core_release()) {
            dumpHeap = new ICanHazHeap.NotifyingNope(new Function0<String>() { // from class: leakcanary.internal.HeapDumpControl$iCanHasHeap$dumpHeap$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    Application app;
                    app = HeapDumpControl.INSTANCE.getApp();
                    String string = app.getString(R.string.leak_canary_heap_dump_disabled_from_ui);
                    Intrinsics.checkExpressionValueIsNotNull(string, "app.getString(R.string.l…ap_dump_disabled_from_ui)");
                    return string;
                }
            });
        } else if (!config.getDumpHeap()) {
            dumpHeap = new ICanHazHeap.SilentNope(new Function0<String>() { // from class: leakcanary.internal.HeapDumpControl$iCanHasHeap$dumpHeap$3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    Application app;
                    app = HeapDumpControl.INSTANCE.getApp();
                    String string = app.getString(R.string.leak_canary_heap_dump_disabled_by_app);
                    Intrinsics.checkExpressionValueIsNotNull(string, "app.getString(R.string.l…eap_dump_disabled_by_app)");
                    return string;
                }
            });
        } else if (getHasTestClass()) {
            dumpHeap = new ICanHazHeap.SilentNope(new Function0<String>() { // from class: leakcanary.internal.HeapDumpControl$iCanHasHeap$dumpHeap$4
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    Application app;
                    String testClassName;
                    app = HeapDumpControl.INSTANCE.getApp();
                    int i = R.string.leak_canary_heap_dump_disabled_running_tests;
                    testClassName = HeapDumpControl.INSTANCE.getTestClassName();
                    String string = app.getString(i, new Object[]{testClassName});
                    Intrinsics.checkExpressionValueIsNotNull(string, "app.getString(R.string.l…ing_tests, testClassName)");
                    return string;
                }
            });
        } else if (getHasLeakAssertionsClass()) {
            dumpHeap = new ICanHazHeap.SilentNope(new Function0<String>() { // from class: leakcanary.internal.HeapDumpControl$iCanHasHeap$dumpHeap$5
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    Application app;
                    app = HeapDumpControl.INSTANCE.getApp();
                    String string = app.getString(R.string.leak_canary_heap_dump_disabled_running_tests, new Object[]{"leakcanary.LeakAssertions"});
                    Intrinsics.checkExpressionValueIsNotNull(string, "app.getString(\n         …rtionsClassName\n        )");
                    return string;
                }
            });
        } else if (!config.getDumpHeapWhenDebugging() && DebuggerControl.INSTANCE.isDebuggerAttached()) {
            getBackgroundUpdateHandler().postDelayed(new Runnable() { // from class: leakcanary.internal.HeapDumpControl$iCanHasHeap$dumpHeap$6
                @Override // java.lang.Runnable
                public final void run() {
                    HeapDumpControl.INSTANCE.iCanHasHeap();
                }
            }, 20000L);
            dumpHeap = new ICanHazHeap.NotifyingNope(new Function0<String>() { // from class: leakcanary.internal.HeapDumpControl$iCanHasHeap$dumpHeap$7
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    Application app;
                    app = HeapDumpControl.INSTANCE.getApp();
                    String string = app.getString(R.string.leak_canary_notification_retained_debugger_attached);
                    Intrinsics.checkExpressionValueIsNotNull(string, "app.getString(R.string.l…tained_debugger_attached)");
                    return string;
                }
            });
        } else {
            dumpHeap = ICanHazHeap.Yup.INSTANCE;
        }
        synchronized (this) {
            if (latest != null && (dumpHeap instanceof ICanHazHeap.Yup)) {
                ICanHazHeap iCanHazHeap = latest;
                if (iCanHazHeap == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("latest");
                }
                if (iCanHazHeap instanceof ICanHazHeap.Nope) {
                    InternalLeakCanary.INSTANCE.scheduleRetainedObjectCheck();
                }
            }
            latest = dumpHeap;
            Unit unit = Unit.INSTANCE;
        }
        return dumpHeap;
    }
}