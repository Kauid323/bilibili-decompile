package leakcanary.internal;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.bilibili.infra.base.aop.PendingIntentCreateHook;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import shark.SharkLog;

/* compiled from: NotificationReceiver.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"Lleakcanary/internal/NotificationReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Action", "Companion", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class NotificationReceiver extends BroadcastReceiver {
    public static final Companion Companion = new Companion(null);

    /* compiled from: NotificationReceiver.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lleakcanary/internal/NotificationReceiver$Action;", "", "(Ljava/lang/String;I)V", "DUMP_HEAP", "CANCEL_NOTIFICATION", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public enum Action {
        DUMP_HEAP,
        CANCEL_NOTIFICATION
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        String action = intent.getAction();
        if (Intrinsics.areEqual(action, Action.DUMP_HEAP.name())) {
            InternalLeakCanary.INSTANCE.onDumpHeapReceived(false);
        } else if (!Intrinsics.areEqual(action, Action.CANCEL_NOTIFICATION.name())) {
            SharkLog this_$iv = SharkLog.INSTANCE;
            SharkLog.Logger logger$iv = this_$iv.getLogger();
            if (logger$iv != null) {
                logger$iv.d("NotificationReceiver received unknown intent action for " + intent);
            }
        }
    }

    /* compiled from: NotificationReceiver.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lleakcanary/internal/NotificationReceiver$Companion;", "", "()V", "pendingIntent", "Landroid/app/PendingIntent;", "context", "Landroid/content/Context;", "action", "Lleakcanary/internal/NotificationReceiver$Action;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final PendingIntent pendingIntent(Context context, Action action) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(action, "action");
            Intent broadcastIntent = new Intent(context, NotificationReceiver.class);
            broadcastIntent.setAction(action.name());
            PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast(context, 0, broadcastIntent, 67108864);
            Intrinsics.checkExpressionValueIsNotNull(__Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast, "PendingIntent.getBroadca…, broadcastIntent, flags)");
            return __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast;
        }

        private static PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast(Context context, int requestCode, Intent intent, int flags) {
            PendingIntentCreateHook.setPackageIfAbsent(context, intent, flags);
            if (Build.VERSION.SDK_INT >= 30) {
                try {
                    return PendingIntent.getBroadcast(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(flags).intValue());
                } catch (IllegalArgumentException e) {
                    return PendingIntent.getBroadcast(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(33554432 | flags).intValue());
                }
            }
            return PendingIntent.getBroadcast(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(flags).intValue());
        }
    }
}