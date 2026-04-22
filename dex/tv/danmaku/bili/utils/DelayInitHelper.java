package tv.danmaku.bili.utils;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bilibili.base.BiliContext;
import com.bilibili.base.util.GlobalNetworkController;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DelayInitHelper.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/utils/DelayInitHelper;", "", "<init>", "()V", "DelayInitTask", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DelayInitHelper {
    public static final int $stable = 0;
    private static ArrayList<DelayInitTask> cbs;
    private static BroadcastReceiver receiver;
    private static boolean triggered;
    public static final Companion Companion = new Companion(null);
    private static final String ACTION_DELAY_APP_INIT = "bili_action_delay_app_init";

    /* compiled from: DelayInitHelper.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/utils/DelayInitHelper$DelayInitTask;", "", "onExecute", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface DelayInitTask {
        void onExecute();
    }

    /* compiled from: DelayInitHelper.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\nH\u0007J\b\u0010\u000e\u001a\u00020\nH\u0003J\b\u0010\u000f\u001a\u00020\nH\u0003J\b\u0010\u0010\u001a\u00020\nH\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0002X\u0083D¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R.\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Ltv/danmaku/bili/utils/DelayInitHelper$Companion;", "", "<init>", "()V", "ACTION_DELAY_APP_INIT", "", "getACTION_DELAY_APP_INIT$annotations", "needDelayInit", "", "registerDelayInitTask", "", "cb", "Ltv/danmaku/bili/utils/DelayInitHelper$DelayInitTask;", "triggerExecute", "registerImpl", "runTask", "clean", "receiver", "Landroid/content/BroadcastReceiver;", "getReceiver", "()Landroid/content/BroadcastReceiver;", "setReceiver", "(Landroid/content/BroadcastReceiver;)V", "cbs", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCbs", "()Ljava/util/ArrayList;", "setCbs", "(Ljava/util/ArrayList;)V", "triggered", "getTriggered", "()Z", "setTriggered", "(Z)V", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        private static /* synthetic */ void getACTION_DELAY_APP_INIT$annotations() {
        }

        private Companion() {
        }

        @JvmStatic
        public final boolean needDelayInit() {
            return !GlobalNetworkController.Companion.isNetworkAllowed();
        }

        @JvmStatic
        public final void registerDelayInitTask(DelayInitTask cb) {
            Intrinsics.checkNotNullParameter(cb, "cb");
            if (getTriggered()) {
                cb.onExecute();
                return;
            }
            if (getCbs() == null) {
                setCbs(new ArrayList<>());
            }
            ArrayList<DelayInitTask> cbs = getCbs();
            Intrinsics.checkNotNull(cbs);
            cbs.add(cb);
            registerImpl();
        }

        @JvmStatic
        public final void triggerExecute() {
            Application application = BiliContext.application();
            Intrinsics.checkNotNull(application);
            LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(application);
            Intrinsics.checkNotNullExpressionValue(lbm, "getInstance(...)");
            Intent intent = new Intent(DelayInitHelper.ACTION_DELAY_APP_INIT);
            lbm.sendBroadcast(intent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void registerImpl() {
            if (getReceiver() == null) {
                setReceiver(new BroadcastReceiver() { // from class: tv.danmaku.bili.utils.DelayInitHelper$Companion$registerImpl$1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        DelayInitHelper.Companion.setTriggered(true);
                        DelayInitHelper.Companion.runTask();
                        DelayInitHelper.Companion.clean();
                    }
                });
                Application application = BiliContext.application();
                Intrinsics.checkNotNull(application);
                LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(application);
                Intrinsics.checkNotNullExpressionValue(lbm, "getInstance(...)");
                BroadcastReceiver receiver = getReceiver();
                Intrinsics.checkNotNull(receiver);
                lbm.registerReceiver(receiver, new IntentFilter(DelayInitHelper.ACTION_DELAY_APP_INIT));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void runTask() {
            BLog.d("DelayInitHelper.runTask");
            if (getCbs() != null) {
                ArrayList<DelayInitTask> cbs = getCbs();
                Intrinsics.checkNotNull(cbs);
                Iterator<DelayInitTask> it = cbs.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    DelayInitTask next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    DelayInitTask item = next;
                    item.onExecute();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void clean() {
            if (getReceiver() != null) {
                Application application = BiliContext.application();
                Intrinsics.checkNotNull(application);
                LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(application);
                Intrinsics.checkNotNullExpressionValue(lbm, "getInstance(...)");
                BroadcastReceiver receiver = getReceiver();
                Intrinsics.checkNotNull(receiver);
                lbm.unregisterReceiver(receiver);
                setReceiver(null);
            }
            ArrayList<DelayInitTask> cbs = getCbs();
            if (cbs != null) {
                cbs.clear();
            }
            setCbs(null);
        }

        public final BroadcastReceiver getReceiver() {
            return DelayInitHelper.receiver;
        }

        public final void setReceiver(BroadcastReceiver broadcastReceiver) {
            DelayInitHelper.receiver = broadcastReceiver;
        }

        public final ArrayList<DelayInitTask> getCbs() {
            return DelayInitHelper.cbs;
        }

        public final void setCbs(ArrayList<DelayInitTask> arrayList) {
            DelayInitHelper.cbs = arrayList;
        }

        public final boolean getTriggered() {
            return DelayInitHelper.triggered;
        }

        public final void setTriggered(boolean z) {
            DelayInitHelper.triggered = z;
        }
    }

    @JvmStatic
    public static final boolean needDelayInit() {
        return Companion.needDelayInit();
    }

    @JvmStatic
    public static final void registerDelayInitTask(DelayInitTask cb) {
        Companion.registerDelayInitTask(cb);
    }

    @JvmStatic
    public static final void triggerExecute() {
        Companion.triggerExecute();
    }

    @JvmStatic
    private static final void registerImpl() {
        Companion.registerImpl();
    }

    @JvmStatic
    private static final void runTask() {
        Companion.runTask();
    }

    @JvmStatic
    private static final void clean() {
        Companion.clean();
    }
}