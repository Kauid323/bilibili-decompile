package leakcanary.internal;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import com.squareup.leakcanary.core.R;
import java.io.File;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.AppWatcher;
import leakcanary.EventListener;
import leakcanary.GcTrigger;
import leakcanary.KeyedWeakReference;
import leakcanary.LeakCanary;
import leakcanary.ObjectWatcher;
import leakcanary.internal.HeapDumpControl;
import leakcanary.internal.NotificationReceiver;
import leakcanary.internal.RetainInstanceEvent;
import shark.AndroidResourceIdNames;
import shark.SharkLog;

/* compiled from: HeapDumpTrigger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0018\b\u0000\u0018\u0000 82\u00020\u0001:\u00018B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ$\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u001a2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010'\u001a\u00020!H\u0002J\b\u0010(\u001a\u00020!H\u0002J\b\u0010)\u001a\u00020!H\u0002J \u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u0018H\u0002J\u000e\u0010.\u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u0011J\u000e\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\u0011J\b\u00101\u001a\u00020!H\u0002J\u0010\u00102\u001a\u00020!2\b\b\u0002\u00103\u001a\u00020\u000fJ\b\u00104\u001a\u00020!H\u0002J\u0018\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lleakcanary/internal/HeapDumpTrigger;", "", "application", "Landroid/app/Application;", "backgroundHandler", "Landroid/os/Handler;", "objectWatcher", "Lleakcanary/ObjectWatcher;", "gcTrigger", "Lleakcanary/GcTrigger;", "configProvider", "Lkotlin/Function0;", "Lleakcanary/LeakCanary$Config;", "(Landroid/app/Application;Landroid/os/Handler;Lleakcanary/ObjectWatcher;Lleakcanary/GcTrigger;Lkotlin/jvm/functions/Function0;)V", "applicationInvisibleAt", "", "applicationInvisibleLessThanWatchPeriod", "", "getApplicationInvisibleLessThanWatchPeriod", "()Z", "applicationVisible", "getApplicationVisible", "checkScheduledAt", "currentEventUniqueId", "", "lastDisplayedRetainedObjectCount", "", "lastHeapDumpUptimeMillis", "notificationManager", "Landroid/app/NotificationManager;", "getNotificationManager", "()Landroid/app/NotificationManager;", "scheduleDismissNoRetainedOnTapNotification", "", "scheduleDismissRetainedCountNotification", "checkRetainedCount", "retainedKeysCount", "retainedVisibleThreshold", "nopeReason", "checkRetainedObjects", "dismissNoRetainedOnTapNotification", "dismissRetainedCountNotification", "dumpHeap", "retainedReferenceCount", "retry", "reason", "onApplicationVisibilityChanged", "onDumpHeapReceived", "forceDump", "saveResourceIdNamesToMemory", "scheduleRetainedObjectCheck", "delayMillis", "showNoMoreRetainedObjectNotification", "showRetainedCountNotification", "objectCount", "contentText", "Companion", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class HeapDumpTrigger {
    public static final Companion Companion = new Companion(null);
    private static final long DISMISS_NO_RETAINED_OBJECT_NOTIFICATION_MILLIS = 30000;
    public static final long WAIT_AFTER_DUMP_FAILED_MILLIS = 5000;
    private static final long WAIT_BETWEEN_HEAP_DUMPS_MILLIS = 60000;
    private static final long WAIT_FOR_OBJECT_THRESHOLD_MILLIS = 2000;
    private final Application application;
    private volatile long applicationInvisibleAt;
    private final Handler backgroundHandler;
    private volatile long checkScheduledAt;
    private final Function0<LeakCanary.Config> configProvider;
    private String currentEventUniqueId;
    private final GcTrigger gcTrigger;
    private int lastDisplayedRetainedObjectCount;
    private long lastHeapDumpUptimeMillis;
    private final ObjectWatcher objectWatcher;
    private final Function0<Unit> scheduleDismissNoRetainedOnTapNotification;
    private final Function0<Unit> scheduleDismissRetainedCountNotification;

    public HeapDumpTrigger(Application application, Handler backgroundHandler, ObjectWatcher objectWatcher, GcTrigger gcTrigger, Function0<LeakCanary.Config> configProvider) {
        Intrinsics.checkParameterIsNotNull(application, "application");
        Intrinsics.checkParameterIsNotNull(backgroundHandler, "backgroundHandler");
        Intrinsics.checkParameterIsNotNull(objectWatcher, "objectWatcher");
        Intrinsics.checkParameterIsNotNull(gcTrigger, "gcTrigger");
        Intrinsics.checkParameterIsNotNull(configProvider, "configProvider");
        this.application = application;
        this.backgroundHandler = backgroundHandler;
        this.objectWatcher = objectWatcher;
        this.gcTrigger = gcTrigger;
        this.configProvider = configProvider;
        this.scheduleDismissRetainedCountNotification = new Function0<Unit>() { // from class: leakcanary.internal.HeapDumpTrigger$scheduleDismissRetainedCountNotification$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                HeapDumpTrigger.this.dismissRetainedCountNotification();
            }
        };
        this.scheduleDismissNoRetainedOnTapNotification = new Function0<Unit>() { // from class: leakcanary.internal.HeapDumpTrigger$scheduleDismissNoRetainedOnTapNotification$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                HeapDumpTrigger.this.dismissNoRetainedOnTapNotification();
            }
        };
        this.applicationInvisibleAt = -1L;
    }

    public final NotificationManager getNotificationManager() {
        Object systemService = this.application.getSystemService("notification");
        if (systemService != null) {
            return (NotificationManager) systemService;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.NotificationManager");
    }

    private final boolean getApplicationVisible() {
        return this.applicationInvisibleAt == -1;
    }

    private final boolean getApplicationInvisibleLessThanWatchPeriod() {
        long applicationInvisibleAt = this.applicationInvisibleAt;
        return applicationInvisibleAt != -1 && SystemClock.uptimeMillis() - applicationInvisibleAt < AppWatcher.INSTANCE.getRetainedDelayMillis();
    }

    public final void onApplicationVisibilityChanged(boolean applicationVisible) {
        if (applicationVisible) {
            this.applicationInvisibleAt = -1L;
            return;
        }
        this.applicationInvisibleAt = SystemClock.uptimeMillis();
        scheduleRetainedObjectCheck(AppWatcher.INSTANCE.getRetainedDelayMillis());
    }

    public final void checkRetainedObjects() {
        HeapDumpControl.ICanHazHeap iCanHasHeap = HeapDumpControl.INSTANCE.iCanHasHeap();
        LeakCanary.Config config = this.configProvider.invoke();
        if (iCanHasHeap instanceof HeapDumpControl.ICanHazHeap.Nope) {
            if (iCanHasHeap instanceof HeapDumpControl.ICanHazHeap.NotifyingNope) {
                int retainedReferenceCount = this.objectWatcher.getRetainedObjectCount();
                if (retainedReferenceCount > 0) {
                    this.gcTrigger.runGc();
                    retainedReferenceCount = this.objectWatcher.getRetainedObjectCount();
                }
                String nopeReason = ((HeapDumpControl.ICanHazHeap.Nope) iCanHasHeap).getReason().invoke();
                boolean wouldDump = !checkRetainedCount(retainedReferenceCount, config.getRetainedVisibleThreshold(), nopeReason);
                if (wouldDump) {
                    char upperCase = Character.toUpperCase(nopeReason.charAt(0));
                    if (nopeReason == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String substring = nopeReason.substring(1);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                    String uppercaseReason = String.valueOf(upperCase) + substring;
                    InternalLeakCanary.INSTANCE.getOnRetainInstanceListener().onEvent(new RetainInstanceEvent.CountChanged.DumpingDisabled(uppercaseReason));
                    showRetainedCountNotification(retainedReferenceCount, uppercaseReason);
                    return;
                }
                return;
            }
            SharkLog this_$iv = SharkLog.INSTANCE;
            SharkLog.Logger logger$iv = this_$iv.getLogger();
            if (logger$iv != null) {
                String string = this.application.getString(R.string.leak_canary_heap_dump_disabled_text, new Object[]{((HeapDumpControl.ICanHazHeap.Nope) iCanHasHeap).getReason().invoke()});
                Intrinsics.checkExpressionValueIsNotNull(string, "application.getString(\n …Heap.reason()\n          )");
                logger$iv.d(string);
                return;
            }
            return;
        }
        int retainedReferenceCount2 = this.objectWatcher.getRetainedObjectCount();
        if (retainedReferenceCount2 > 0) {
            this.gcTrigger.runGc();
            retainedReferenceCount2 = this.objectWatcher.getRetainedObjectCount();
        }
        if (checkRetainedCount$default(this, retainedReferenceCount2, config.getRetainedVisibleThreshold(), null, 4, null)) {
            return;
        }
        long now = SystemClock.uptimeMillis();
        long elapsedSinceLastDumpMillis = now - this.lastHeapDumpUptimeMillis;
        if (elapsedSinceLastDumpMillis < WAIT_BETWEEN_HEAP_DUMPS_MILLIS) {
            InternalLeakCanary.INSTANCE.getOnRetainInstanceListener().onEvent(RetainInstanceEvent.CountChanged.DumpHappenedRecently.INSTANCE);
            String string2 = this.application.getString(R.string.leak_canary_notification_retained_dump_wait);
            Intrinsics.checkExpressionValueIsNotNull(string2, "application.getString(R.…ation_retained_dump_wait)");
            showRetainedCountNotification(retainedReferenceCount2, string2);
            scheduleRetainedObjectCheck(WAIT_BETWEEN_HEAP_DUMPS_MILLIS - elapsedSinceLastDumpMillis);
            return;
        }
        dismissRetainedCountNotification();
        String visibility = getApplicationVisible() ? "visible" : "not visible";
        dumpHeap(retainedReferenceCount2, true, retainedReferenceCount2 + " retained objects, app is " + visibility);
    }

    public final void dumpHeap(int retainedReferenceCount, boolean retry, String reason) {
        LeakDirectoryProvider directoryProvider = InternalLeakCanary.INSTANCE.createLeakDirectoryProvider(InternalLeakCanary.INSTANCE.getApplication());
        File heapDumpFile = directoryProvider.newHeapDumpFile();
        if (this.currentEventUniqueId == null) {
            this.currentEventUniqueId = UUID.randomUUID().toString();
        }
        try {
            InternalLeakCanary internalLeakCanary = InternalLeakCanary.INSTANCE;
            String str = this.currentEventUniqueId;
            if (str == null) {
                Intrinsics.throwNpe();
            }
            internalLeakCanary.sendEvent(new EventListener.Event.DumpingHeap(str));
            if (heapDumpFile == null) {
                throw new RuntimeException("Could not create heap dump file");
            }
            saveResourceIdNamesToMemory();
            long heapDumpUptimeMillis = SystemClock.uptimeMillis();
            KeyedWeakReference.Companion.setHeapDumpUptimeMillis(heapDumpUptimeMillis);
            long start$iv$iv = SystemClock.uptimeMillis();
            this.configProvider.invoke().getHeapDumper().dumpHeap(heapDumpFile);
            long durationMillis = SystemClock.uptimeMillis() - start$iv$iv;
            try {
                long durationMillis2 = heapDumpFile.length();
                if (durationMillis2 == 0) {
                    throw new RuntimeException("Dumped heap file is 0 byte length");
                }
                this.lastDisplayedRetainedObjectCount = 0;
                this.lastHeapDumpUptimeMillis = SystemClock.uptimeMillis();
                this.objectWatcher.clearObjectsWatchedBefore(heapDumpUptimeMillis);
                this.currentEventUniqueId = UUID.randomUUID().toString();
                InternalLeakCanary internalLeakCanary2 = InternalLeakCanary.INSTANCE;
                String str2 = this.currentEventUniqueId;
                if (str2 == null) {
                    Intrinsics.throwNpe();
                }
                internalLeakCanary2.sendEvent(new EventListener.Event.HeapDump(str2, heapDumpFile, durationMillis, reason));
            } catch (Throwable th) {
                throwable = th;
                InternalLeakCanary internalLeakCanary3 = InternalLeakCanary.INSTANCE;
                String str3 = this.currentEventUniqueId;
                if (str3 == null) {
                    Intrinsics.throwNpe();
                }
                internalLeakCanary3.sendEvent(new EventListener.Event.HeapDumpFailed(str3, throwable, retry));
                if (retry) {
                    scheduleRetainedObjectCheck(WAIT_AFTER_DUMP_FAILED_MILLIS);
                }
                String string = this.application.getString(R.string.leak_canary_notification_retained_dump_failed);
                Intrinsics.checkExpressionValueIsNotNull(string, "application.getString(\n …ned_dump_failed\n        )");
                showRetainedCountNotification(retainedReferenceCount, string);
            }
        } catch (Throwable th2) {
            throwable = th2;
        }
    }

    private final void saveResourceIdNamesToMemory() {
        final Resources resources = this.application.getResources();
        AndroidResourceIdNames.Companion.saveToMemory(new Function1<Integer, String>() { // from class: leakcanary.internal.HeapDumpTrigger$saveResourceIdNamesToMemory$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final String invoke(int id) {
                try {
                    return resources.getResourceTypeName(id);
                } catch (Resources.NotFoundException e) {
                    return null;
                }
            }
        }, new Function1<Integer, String>() { // from class: leakcanary.internal.HeapDumpTrigger$saveResourceIdNamesToMemory$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final String invoke(int id) {
                try {
                    return resources.getResourceEntryName(id);
                } catch (Resources.NotFoundException e) {
                    return null;
                }
            }
        });
    }

    public final void onDumpHeapReceived(final boolean forceDump) {
        this.backgroundHandler.post(new Runnable() { // from class: leakcanary.internal.HeapDumpTrigger$onDumpHeapReceived$1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r6v1, types: [leakcanary.internal.HeapDumpTrigger$sam$java_lang_Runnable$0] */
            @Override // java.lang.Runnable
            public final void run() {
                GcTrigger gcTrigger;
                ObjectWatcher objectWatcher;
                Application application;
                Application application2;
                Application application3;
                Application application4;
                Application application5;
                NotificationManager notificationManager;
                Handler handler;
                Function0 function0;
                HeapDumpTrigger.this.dismissNoRetainedOnTapNotification();
                gcTrigger = HeapDumpTrigger.this.gcTrigger;
                gcTrigger.runGc();
                objectWatcher = HeapDumpTrigger.this.objectWatcher;
                int retainedReferenceCount = objectWatcher.getRetainedObjectCount();
                if (!forceDump && retainedReferenceCount == 0) {
                    SharkLog this_$iv = SharkLog.INSTANCE;
                    SharkLog.Logger logger$iv = this_$iv.getLogger();
                    if (logger$iv != null) {
                        logger$iv.d("Ignoring user request to dump heap: no retained objects remaining after GC");
                    }
                    application = HeapDumpTrigger.this.application;
                    Notification.Builder builder = new Notification.Builder(application);
                    application2 = HeapDumpTrigger.this.application;
                    Notification.Builder contentTitle = builder.setContentTitle(application2.getString(R.string.leak_canary_notification_no_retained_object_title));
                    application3 = HeapDumpTrigger.this.application;
                    Notification.Builder autoCancel = contentTitle.setContentText(application3.getString(R.string.leak_canary_notification_no_retained_object_content)).setAutoCancel(true);
                    NotificationReceiver.Companion companion = NotificationReceiver.Companion;
                    application4 = HeapDumpTrigger.this.application;
                    Notification.Builder builder2 = autoCancel.setContentIntent(companion.pendingIntent(application4, NotificationReceiver.Action.CANCEL_NOTIFICATION));
                    Intrinsics.checkExpressionValueIsNotNull(builder2, "Notification.Builder(app…on, CANCEL_NOTIFICATION))");
                    Notifications notifications = Notifications.INSTANCE;
                    application5 = HeapDumpTrigger.this.application;
                    Notification notification = notifications.buildNotification(application5, builder2, NotificationType.LEAKCANARY_LOW);
                    notificationManager = HeapDumpTrigger.this.getNotificationManager();
                    notificationManager.notify(R.id.leak_canary_notification_no_retained_object_on_tap, notification);
                    handler = HeapDumpTrigger.this.backgroundHandler;
                    function0 = HeapDumpTrigger.this.scheduleDismissNoRetainedOnTapNotification;
                    if (function0 != null) {
                        function0 = new HeapDumpTrigger$sam$java_lang_Runnable$0(function0);
                    }
                    handler.postDelayed((Runnable) function0, 30000L);
                    HeapDumpTrigger.this.lastDisplayedRetainedObjectCount = 0;
                    return;
                }
                SharkLog this_$iv2 = SharkLog.INSTANCE;
                SharkLog.Logger logger$iv2 = this_$iv2.getLogger();
                if (logger$iv2 != null) {
                    logger$iv2.d("Dumping the heap because user requested it");
                }
                HeapDumpTrigger.this.dumpHeap(retainedReferenceCount, false, "user request");
            }
        });
    }

    static /* synthetic */ boolean checkRetainedCount$default(HeapDumpTrigger heapDumpTrigger, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str = null;
        }
        return heapDumpTrigger.checkRetainedCount(i, i2, str);
    }

    private final boolean checkRetainedCount(int retainedKeysCount, int retainedVisibleThreshold, String nopeReason) {
        String whatsNext;
        boolean countChanged = this.lastDisplayedRetainedObjectCount != retainedKeysCount;
        this.lastDisplayedRetainedObjectCount = retainedKeysCount;
        if (retainedKeysCount == 0) {
            if (countChanged) {
                SharkLog this_$iv = SharkLog.INSTANCE;
                SharkLog.Logger logger$iv = this_$iv.getLogger();
                if (logger$iv != null) {
                    logger$iv.d("All retained objects have been garbage collected");
                }
                InternalLeakCanary.INSTANCE.getOnRetainInstanceListener().onEvent(RetainInstanceEvent.NoMoreObjects.INSTANCE);
                showNoMoreRetainedObjectNotification();
            }
            return true;
        }
        boolean applicationVisible = getApplicationVisible();
        boolean applicationInvisibleLessThanWatchPeriod = getApplicationInvisibleLessThanWatchPeriod();
        if (countChanged) {
            if (applicationVisible) {
                if (retainedKeysCount < retainedVisibleThreshold) {
                    whatsNext = "not dumping heap yet (app is visible & < " + retainedVisibleThreshold + " threshold)";
                } else {
                    whatsNext = nopeReason != null ? "would dump heap now (app is visible & >=" + retainedVisibleThreshold + " threshold) but " + nopeReason : "dumping heap now (app is visible & >=" + retainedVisibleThreshold + " threshold)";
                }
            } else if (applicationInvisibleLessThanWatchPeriod) {
                long wait = AppWatcher.INSTANCE.getRetainedDelayMillis() - (SystemClock.uptimeMillis() - this.applicationInvisibleAt);
                if (nopeReason != null) {
                    whatsNext = "would dump heap in " + wait + " ms (app just became invisible) but " + nopeReason;
                } else {
                    whatsNext = "dumping heap in " + wait + " ms (app just became invisible)";
                }
            } else if (nopeReason != null) {
                whatsNext = "would dump heap now (app is invisible) but " + nopeReason;
            } else {
                whatsNext = "dumping heap now (app is invisible)";
            }
            SharkLog this_$iv2 = SharkLog.INSTANCE;
            SharkLog.Logger logger$iv2 = this_$iv2.getLogger();
            if (logger$iv2 != null) {
                String s = retainedKeysCount > 1 ? "s" : "";
                logger$iv2.d("Found " + retainedKeysCount + " object" + s + " retained, " + whatsNext);
            }
        }
        if (retainedKeysCount < retainedVisibleThreshold) {
            if (applicationVisible || applicationInvisibleLessThanWatchPeriod) {
                if (countChanged) {
                    InternalLeakCanary.INSTANCE.getOnRetainInstanceListener().onEvent(new RetainInstanceEvent.CountChanged.BelowThreshold(retainedKeysCount));
                }
                String string = this.application.getString(R.string.leak_canary_notification_retained_visible, new Object[]{Integer.valueOf(retainedVisibleThreshold)});
                Intrinsics.checkExpressionValueIsNotNull(string, "application.getString(\n …ibleThreshold\n          )");
                showRetainedCountNotification(retainedKeysCount, string);
                scheduleRetainedObjectCheck(WAIT_FOR_OBJECT_THRESHOLD_MILLIS);
                return true;
            }
            return false;
        }
        return false;
    }

    public static /* synthetic */ void scheduleRetainedObjectCheck$default(HeapDumpTrigger heapDumpTrigger, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        heapDumpTrigger.scheduleRetainedObjectCheck(j);
    }

    public final void scheduleRetainedObjectCheck(long delayMillis) {
        long checkCurrentlyScheduledAt = this.checkScheduledAt;
        if (checkCurrentlyScheduledAt > 0) {
            return;
        }
        this.checkScheduledAt = SystemClock.uptimeMillis() + delayMillis;
        this.backgroundHandler.postDelayed(new Runnable() { // from class: leakcanary.internal.HeapDumpTrigger$scheduleRetainedObjectCheck$1
            @Override // java.lang.Runnable
            public final void run() {
                HeapDumpTrigger.this.checkScheduledAt = 0L;
                HeapDumpTrigger.this.checkRetainedObjects();
            }
        }, delayMillis);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v8, types: [leakcanary.internal.HeapDumpTrigger$sam$java_lang_Runnable$0] */
    /* JADX WARN: Type inference failed for: r4v1, types: [leakcanary.internal.HeapDumpTrigger$sam$java_lang_Runnable$0] */
    private final void showNoMoreRetainedObjectNotification() {
        Handler handler = this.backgroundHandler;
        Function0<Unit> function0 = this.scheduleDismissRetainedCountNotification;
        if (function0 != null) {
            function0 = new HeapDumpTrigger$sam$java_lang_Runnable$0(function0);
        }
        handler.removeCallbacks((Runnable) function0);
        if (!Notifications.INSTANCE.getCanShowNotification()) {
            return;
        }
        Notification.Builder builder = new Notification.Builder(this.application).setContentTitle(this.application.getString(R.string.leak_canary_notification_no_retained_object_title)).setContentText(this.application.getString(R.string.leak_canary_notification_no_retained_object_content)).setAutoCancel(true).setContentIntent(NotificationReceiver.Companion.pendingIntent(this.application, NotificationReceiver.Action.CANCEL_NOTIFICATION));
        Intrinsics.checkExpressionValueIsNotNull(builder, "Notification.Builder(app…on, CANCEL_NOTIFICATION))");
        Notification notification = Notifications.INSTANCE.buildNotification(this.application, builder, NotificationType.LEAKCANARY_LOW);
        getNotificationManager().notify(R.id.leak_canary_notification_retained_objects, notification);
        Handler handler2 = this.backgroundHandler;
        Function0<Unit> function02 = this.scheduleDismissRetainedCountNotification;
        if (function02 != null) {
            function02 = new HeapDumpTrigger$sam$java_lang_Runnable$0(function02);
        }
        handler2.postDelayed((Runnable) function02, DISMISS_NO_RETAINED_OBJECT_NOTIFICATION_MILLIS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [leakcanary.internal.HeapDumpTrigger$sam$java_lang_Runnable$0] */
    private final void showRetainedCountNotification(int objectCount, String contentText) {
        Handler handler = this.backgroundHandler;
        Function0<Unit> function0 = this.scheduleDismissRetainedCountNotification;
        if (function0 != null) {
            function0 = new HeapDumpTrigger$sam$java_lang_Runnable$0(function0);
        }
        handler.removeCallbacks((Runnable) function0);
        if (!Notifications.INSTANCE.getCanShowNotification()) {
            return;
        }
        Notification.Builder builder = new Notification.Builder(this.application).setContentTitle(this.application.getString(R.string.leak_canary_notification_retained_title, new Object[]{Integer.valueOf(objectCount)})).setContentText(contentText).setAutoCancel(true).setContentIntent(NotificationReceiver.Companion.pendingIntent(this.application, NotificationReceiver.Action.DUMP_HEAP));
        Intrinsics.checkExpressionValueIsNotNull(builder, "Notification.Builder(app…(application, DUMP_HEAP))");
        Notification notification = Notifications.INSTANCE.buildNotification(this.application, builder, NotificationType.LEAKCANARY_LOW);
        getNotificationManager().notify(R.id.leak_canary_notification_retained_objects, notification);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [leakcanary.internal.HeapDumpTrigger$sam$java_lang_Runnable$0] */
    public final void dismissRetainedCountNotification() {
        Handler handler = this.backgroundHandler;
        Function0<Unit> function0 = this.scheduleDismissRetainedCountNotification;
        if (function0 != null) {
            function0 = new HeapDumpTrigger$sam$java_lang_Runnable$0(function0);
        }
        handler.removeCallbacks((Runnable) function0);
        getNotificationManager().cancel(R.id.leak_canary_notification_retained_objects);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [leakcanary.internal.HeapDumpTrigger$sam$java_lang_Runnable$0] */
    public final void dismissNoRetainedOnTapNotification() {
        Handler handler = this.backgroundHandler;
        Function0<Unit> function0 = this.scheduleDismissNoRetainedOnTapNotification;
        if (function0 != null) {
            function0 = new HeapDumpTrigger$sam$java_lang_Runnable$0(function0);
        }
        handler.removeCallbacks((Runnable) function0);
        getNotificationManager().cancel(R.id.leak_canary_notification_no_retained_object_on_tap);
    }

    /* compiled from: HeapDumpTrigger.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lleakcanary/internal/HeapDumpTrigger$Companion;", "", "()V", "DISMISS_NO_RETAINED_OBJECT_NOTIFICATION_MILLIS", "", "WAIT_AFTER_DUMP_FAILED_MILLIS", "WAIT_BETWEEN_HEAP_DUMPS_MILLIS", "WAIT_FOR_OBJECT_THRESHOLD_MILLIS", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}