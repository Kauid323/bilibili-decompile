package leakcanary;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.bilibili.infra.base.aop.PendingIntentCreateHook;
import com.squareup.leakcanary.core.R;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import leakcanary.EventListener;
import leakcanary.internal.InternalLeakCanary;
import leakcanary.internal.NotificationType;
import leakcanary.internal.Notifications;
import shark.HeapAnalysisSuccess;
import shark.Leak;

/* compiled from: NotificationEventListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lleakcanary/NotificationEventListener;", "Lleakcanary/EventListener;", "()V", "appContext", "Landroid/app/Application;", "notificationManager", "Landroid/app/NotificationManager;", "onEvent", "", "event", "Lleakcanary/EventListener$Event;", "showHeapAnalysisResultNotification", "contentTitle", "", "showIntent", "Landroid/app/PendingIntent;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class NotificationEventListener implements EventListener {
    public static final NotificationEventListener INSTANCE = new NotificationEventListener();
    private static final Application appContext = InternalLeakCanary.INSTANCE.getApplication();
    private static final NotificationManager notificationManager;

    static {
        Object systemService = appContext.getSystemService("notification");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.app.NotificationManager");
        }
        notificationManager = (NotificationManager) systemService;
    }

    private NotificationEventListener() {
    }

    private static PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity(Context context, int requestCode, Intent intent, int flags) {
        PendingIntentCreateHook.setPackageIfAbsent(context, intent, flags);
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                return PendingIntent.getActivity(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(flags).intValue());
            } catch (IllegalArgumentException e) {
                return PendingIntent.getActivity(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(33554432 | flags).intValue());
            }
        }
        return PendingIntent.getActivity(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(flags).intValue());
    }

    @Override // leakcanary.EventListener
    public void onEvent(EventListener.Event event) {
        String contentTitle;
        Intrinsics.checkParameterIsNotNull(event, "event");
        if (!Notifications.INSTANCE.getCanShowNotification()) {
            return;
        }
        if (event instanceof EventListener.Event.DumpingHeap) {
            String dumpingHeap = appContext.getString(R.string.leak_canary_notification_dumping);
            Intrinsics.checkExpressionValueIsNotNull(dumpingHeap, "appContext.getString(R.s…ary_notification_dumping)");
            Notification.Builder builder = new Notification.Builder(appContext).setContentTitle(dumpingHeap);
            Intrinsics.checkExpressionValueIsNotNull(builder, "Notification.Builder(app…ContentTitle(dumpingHeap)");
            Notification notification = Notifications.INSTANCE.buildNotification(appContext, builder, NotificationType.LEAKCANARY_LOW);
            notificationManager.notify(R.id.leak_canary_notification_dumping_heap, notification);
        } else if ((event instanceof EventListener.Event.HeapDumpFailed) || (event instanceof EventListener.Event.HeapDump)) {
            notificationManager.cancel(R.id.leak_canary_notification_dumping_heap);
        } else if (event instanceof EventListener.Event.HeapAnalysisProgress) {
            int progress = (int) (((EventListener.Event.HeapAnalysisProgress) event).getProgressPercent() * 100);
            Notification.Builder builder2 = new Notification.Builder(appContext).setContentTitle(appContext.getString(R.string.leak_canary_notification_analysing)).setContentText(((EventListener.Event.HeapAnalysisProgress) event).getStep().getHumanReadableName()).setProgress(100, progress, false);
            Intrinsics.checkExpressionValueIsNotNull(builder2, "Notification.Builder(app…ess(100, progress, false)");
            Notification notification2 = Notifications.INSTANCE.buildNotification(appContext, builder2, NotificationType.LEAKCANARY_LOW);
            notificationManager.notify(R.id.leak_canary_notification_analyzing_heap, notification2);
        } else if (event instanceof EventListener.Event.HeapAnalysisDone) {
            notificationManager.cancel(R.id.leak_canary_notification_analyzing_heap);
            if (event instanceof EventListener.Event.HeapAnalysisDone.HeapAnalysisSucceeded) {
                HeapAnalysisSuccess heapAnalysis = ((EventListener.Event.HeapAnalysisDone.HeapAnalysisSucceeded) event).getHeapAnalysis();
                Sequence $this$sumBy$iv = heapAnalysis.getAllLeaks();
                int sum$iv = 0;
                for (Object element$iv : $this$sumBy$iv) {
                    Leak it = (Leak) element$iv;
                    sum$iv += it.getLeakTraces().size();
                }
                int retainedObjectCount = sum$iv;
                int leakTypeCount = heapAnalysis.getApplicationLeaks().size() + heapAnalysis.getLibraryLeaks().size();
                int unreadLeakCount = ((EventListener.Event.HeapAnalysisDone.HeapAnalysisSucceeded) event).getUnreadLeakSignatures().size();
                contentTitle = appContext.getString(R.string.leak_canary_analysis_success_notification, new Object[]{Integer.valueOf(retainedObjectCount), Integer.valueOf(leakTypeCount), Integer.valueOf(unreadLeakCount)});
            } else {
                contentTitle = appContext.getString(R.string.leak_canary_analysis_failed);
            }
            Intrinsics.checkExpressionValueIsNotNull(contentTitle, "if (event is HeapAnalysi…nalysis_failed)\n        }");
            PendingIntent pendingIntent = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity(appContext, 1, ((EventListener.Event.HeapAnalysisDone) event).getShowIntent(), 201326592);
            Intrinsics.checkExpressionValueIsNotNull(pendingIntent, "pendingIntent");
            showHeapAnalysisResultNotification(contentTitle, pendingIntent);
        }
    }

    private final void showHeapAnalysisResultNotification(String contentTitle, PendingIntent showIntent) {
        String contentText = appContext.getString(R.string.leak_canary_notification_message);
        Intrinsics.checkExpressionValueIsNotNull(contentText, "appContext.getString(R.s…ary_notification_message)");
        Notifications.INSTANCE.showNotification(appContext, contentTitle, contentText, showIntent, R.id.leak_canary_notification_analysis_result, NotificationType.LEAKCANARY_MAX);
    }
}