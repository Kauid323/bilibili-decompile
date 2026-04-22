package tv.danmaku.biliplayerv2.monitor;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Printer;
import com.bilibili.base.util.MainLopperPrinters;
import com.bilibili.droid.thread.HandlerThreads;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.biliplayerv2.BuildConfig;
import tv.danmaku.biliplayerv2.monitor.PlayerMonitor;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;

/* compiled from: PlayerMonitor.kt */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0014\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0003J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0003J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\t\u001a&\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b \f*\u0012\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\r0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006\u001f"}, d2 = {"Ltv/danmaku/biliplayerv2/monitor/PlayerMonitor;", "", "mModule", "", "<init>", "(Ljava/lang/String;)V", "mActionStartTimeMs", "", "", "mPendingPrintMsgs", "", "Ltv/danmaku/biliplayerv2/monitor/PlayerMonitor$MsgRecord;", "kotlin.jvm.PlatformType", "", "mPrintMsgRunnableScheduled", "", "mLock", "mPrintMsgRunnable", "Ljava/lang/Runnable;", "mMainLooperPrinter", "tv/danmaku/biliplayerv2/monitor/PlayerMonitor$mMainLooperPrinter$1", "Ltv/danmaku/biliplayerv2/monitor/PlayerMonitor$mMainLooperPrinter$1;", "schedulePrintMsg", "", "trackStart", "action", "trackEnd", "startTrackMainLooper", "stopTrackMainLooper", "Companion", "MsgRecord", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerMonitor {
    private static final String BASE_MODULE = "PlayerMonitor";
    public static final Companion Companion = new Companion(null);
    private static final String END_EXECUTE_MSG_PREFIX = "<<<<< Finished";
    private static final String START_EXECUTE_MSG_PREFIX = ">>>>> Dispatching";
    private static final String SUB_MODULE_MAIN_LOOPER = "MainLooper";
    private static PlayerMonitor sPlayerMainLooperMonitor;
    private final Map<String, Long> mActionStartTimeMs;
    private final Object mLock;
    private final PlayerMonitor$mMainLooperPrinter$1 mMainLooperPrinter;
    private final String mModule;
    private final List<MsgRecord> mPendingPrintMsgs;
    private final Runnable mPrintMsgRunnable;
    private boolean mPrintMsgRunnableScheduled;

    /* compiled from: PlayerMonitor.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Ltv/danmaku/biliplayerv2/monitor/PlayerMonitor$Companion;", "", "<init>", "()V", "BASE_MODULE", "", "SUB_MODULE_MAIN_LOOPER", "START_EXECUTE_MSG_PREFIX", "END_EXECUTE_MSG_PREFIX", "sPlayerMainLooperMonitor", "Ltv/danmaku/biliplayerv2/monitor/PlayerMonitor;", "startTrackMainLooper", "", "stopTrackMainLooper", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void startTrackMainLooper() {
            if (PlayerMonitor.sPlayerMainLooperMonitor == null) {
                PlayerMonitor.sPlayerMainLooperMonitor = new PlayerMonitor(PlayerMonitor.SUB_MODULE_MAIN_LOOPER);
                PlayerMonitor playerMonitor = PlayerMonitor.sPlayerMainLooperMonitor;
                if (playerMonitor != null) {
                    playerMonitor.startTrackMainLooper();
                }
            }
        }

        public final void stopTrackMainLooper() {
            PlayerMonitor playerMonitor = PlayerMonitor.sPlayerMainLooperMonitor;
            if (playerMonitor != null) {
                playerMonitor.stopTrackMainLooper();
            }
            PlayerMonitor.sPlayerMainLooperMonitor = null;
        }
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [tv.danmaku.biliplayerv2.monitor.PlayerMonitor$mMainLooperPrinter$1] */
    public PlayerMonitor(String mModule) {
        Intrinsics.checkNotNullParameter(mModule, "mModule");
        this.mModule = mModule;
        this.mActionStartTimeMs = new HashMap();
        this.mPendingPrintMsgs = Collections.synchronizedList(new LinkedList());
        this.mLock = new Object();
        this.mPrintMsgRunnable = new Runnable() { // from class: tv.danmaku.biliplayerv2.monitor.PlayerMonitor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PlayerMonitor.mPrintMsgRunnable$lambda$0(PlayerMonitor.this);
            }
        };
        this.mMainLooperPrinter = new Printer() { // from class: tv.danmaku.biliplayerv2.monitor.PlayerMonitor$mMainLooperPrinter$1
            private String mStartMsg = "";
            private long mStartTimeMs;

            @Override // android.util.Printer
            public void println(String x) {
                Object obj;
                List list;
                if (TextUtils.isEmpty(x)) {
                    return;
                }
                boolean z = true;
                if (x != null && StringsKt.startsWith$default(x, ">>>>> Dispatching", false, 2, (Object) null)) {
                    this.mStartTimeMs = SystemClock.elapsedRealtime();
                    this.mStartMsg = x;
                }
                if (x == null || !StringsKt.startsWith$default(x, "<<<<< Finished", false, 2, (Object) null)) {
                    z = false;
                }
                if (z && this.mStartTimeMs > 0) {
                    long consume = SystemClock.elapsedRealtime() - this.mStartTimeMs;
                    if (consume > 10) {
                        obj = PlayerMonitor.this.mLock;
                        PlayerMonitor playerMonitor = PlayerMonitor.this;
                        synchronized (obj) {
                            list = playerMonitor.mPendingPrintMsgs;
                            list.add(new PlayerMonitor.MsgRecord(this.mStartMsg, consume));
                        }
                        PlayerMonitor.this.schedulePrintMsg();
                    }
                    this.mStartMsg = "";
                    this.mStartTimeMs = 0L;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mPrintMsgRunnable$lambda$0(PlayerMonitor this$0) {
        while (true) {
            LinkedList tempMsgs = new LinkedList();
            synchronized (this$0.mLock) {
                tempMsgs.addAll(this$0.mPendingPrintMsgs);
                this$0.mPendingPrintMsgs.clear();
                Unit unit = Unit.INSTANCE;
            }
            if (!tempMsgs.isEmpty()) {
                while (tempMsgs.size() > 0) {
                    MsgRecord record = (MsgRecord) tempMsgs.removeFirst();
                    String str = this$0.mModule;
                    String msg = record.getMsg();
                    PlayerLog.d(BASE_MODULE, "module:" + str + ",{msg=" + msg + ",timeConsume=" + record.getTimeConsume() + "}");
                }
            } else {
                this$0.mPrintMsgRunnableScheduled = false;
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void schedulePrintMsg() {
        if (this.mPrintMsgRunnableScheduled) {
            return;
        }
        this.mPrintMsgRunnableScheduled = true;
        HandlerThreads.post(3, this.mPrintMsgRunnable);
    }

    public final void trackStart(String action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (BuildConfig.DEBUG) {
            long startTimeMs = SystemClock.elapsedRealtime();
            this.mActionStartTimeMs.put(action, Long.valueOf(startTimeMs));
            PlayerLog.i(BASE_MODULE, "track start --> module:" + this.mModule + ", action:" + action);
        }
    }

    public final void trackEnd(String action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (BuildConfig.DEBUG) {
            Long remove = this.mActionStartTimeMs.remove(action);
            long startTimeMs = remove != null ? remove.longValue() : 0L;
            long delay = SystemClock.elapsedRealtime() - startTimeMs;
            if (delay >= 2) {
                PlayerLog.e(BASE_MODULE, "track end --> module:" + this.mModule + ", action:" + action + ", delay:" + delay);
            } else {
                PlayerLog.i(BASE_MODULE, "track end --> module:" + this.mModule + ", action:" + action + ", delay:" + delay);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startTrackMainLooper() {
        if (BuildConfig.DEBUG) {
            MainLopperPrinters.INSTANCE.addPrinter(this.mMainLooperPrinter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopTrackMainLooper() {
        if (BuildConfig.DEBUG) {
            MainLopperPrinters.INSTANCE.removePrinter(this.mMainLooperPrinter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlayerMonitor.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ltv/danmaku/biliplayerv2/monitor/PlayerMonitor$MsgRecord;", "", "msg", "", "timeConsume", "", "<init>", "(Ljava/lang/String;J)V", "getMsg", "()Ljava/lang/String;", "getTimeConsume", "()J", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class MsgRecord {
        private final String msg;
        private final long timeConsume;

        public MsgRecord(String msg, long timeConsume) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            this.msg = msg;
            this.timeConsume = timeConsume;
        }

        public final String getMsg() {
            return this.msg;
        }

        public final long getTimeConsume() {
            return this.timeConsume;
        }
    }
}