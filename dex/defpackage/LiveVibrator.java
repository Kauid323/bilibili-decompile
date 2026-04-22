package defpackage;

import android.os.Build;
import android.os.SystemClock;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.bilibili.bililive.infra.log.LiveLog;
import com.bilibili.bililive.infra.log.LiveLogDelegate;
import com.bilibili.bililive.infra.log.LiveLogger;
import com.bilibili.bililive.room.biz.vibrate.ILiveVibrator;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import tv.danmaku.android.log.BLog;

/* compiled from: LiveVibrator.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0018\b\u0007\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u001b\u001a\u00020\u001cH\u0017J\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0016H\u0016J\b\u0010 \u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020\u001cH\u0016J\u0018\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u0016H\u0002J\u0010\u0010%\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010'\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u0016H\u0002J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u0018H\u0002J\b\u0010.\u001a\u00020\u001cH\u0002J\b\u0010/\u001a\u00020\u0011H\u0002J\b\u00100\u001a\u00020\u0016H\u0002J\b\u00101\u001a\u00020\u0013H\u0002J\b\u00102\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"LLiveVibrator;", "Lcom/bilibili/bililive/room/biz/vibrate/ILiveVibrator;", "Lcom/bilibili/bililive/infra/log/LiveLogger;", "vibrator", "Landroid/os/Vibrator;", "<init>", "(Landroid/os/Vibrator;)V", "logTag", "", "getLogTag", "()Ljava/lang/String;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "condition", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "isRunning", "", "advancedVibrateMotorPercent", "", "motorPercent", "latestMotorSpeed", "", "latestVibrateTimeMillis", "", "biliVibrateNewTask", "Ljava/lang/Runnable;", "initVibrator", "", "startVibrate", "leftSpeed", "rightSpeed", "stopVibrate", "destroy", "setVibrateState", "wLeftMotorSpeed", "wRightMotorSpeed", "getAdvancedVibrateMotorPercent", "doAdvancedVibrate", "doHighVibrate", "doMidVibrate", "doLowVibrate", "doVibrateOneShot", "time", "amplitude", "doVibrateShot", "cancelVibrate", "getIsRunningValue", "getLatestMotorSpeedValue", "getMotorPercentValue", "getAdvancedVibrateMotorPercentValue", "Companion", "room_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: LiveVibrator  reason: default package */
public final class LiveVibrator implements ILiveVibrator, LiveLogger {
    public static final String TAG = "BiliVibrate";
    private static final long VIBRATE_TIME_OUT_MS = 1000;
    private volatile double advancedVibrateMotorPercent;
    private final Runnable biliVibrateNewTask;
    private final Condition condition;
    private volatile boolean isRunning;
    private volatile int latestMotorSpeed;
    private volatile long latestVibrateTimeMillis;
    private final ReentrantLock lock;
    private final String logTag;
    private volatile double motorPercent;
    private Vibrator vibrator;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public LiveVibrator(Vibrator vibrator) {
        Intrinsics.checkNotNullParameter(vibrator, "vibrator");
        this.vibrator = vibrator;
        this.logTag = TAG;
        this.lock = new ReentrantLock();
        this.condition = this.lock.newCondition();
        this.biliVibrateNewTask = new Runnable() { // from class: LiveVibrator$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                LiveVibrator.biliVibrateNewTask$lambda$0(LiveVibrator.this);
            }
        };
    }

    public String getLogTag() {
        return this.logTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void biliVibrateNewTask$lambda$0(LiveVibrator this$0) {
        while (true) {
            if (!this$0.getIsRunningValue()) {
                break;
            }
            double motorPercent = this$0.getMotorPercentValue();
            if (motorPercent > 0.0d) {
                double advancedVibrateMotorPercent = this$0.getAdvancedVibrateMotorPercentValue();
                if (Build.VERSION.SDK_INT >= 26 && this$0.vibrator.hasAmplitudeControl()) {
                    this$0.doAdvancedVibrate(advancedVibrateMotorPercent);
                } else if (motorPercent < 0.075d) {
                    this$0.doLowVibrate(motorPercent);
                } else if (motorPercent < 0.88d) {
                    this$0.doMidVibrate(motorPercent);
                } else {
                    this$0.doHighVibrate(motorPercent);
                }
                long curTimeMillis = SystemClock.elapsedRealtime();
                if (curTimeMillis - this$0.latestVibrateTimeMillis > VIBRATE_TIME_OUT_MS) {
                    this$0.setVibrateState(0, 0);
                }
            } else {
                this$0.cancelVibrate();
                this$0.lock.lock();
                LiveVibrator $this$logInfo_u24default$iv = this$0;
                LiveLog.Companion this_$iv$iv = LiveLog.Companion;
                String tag$iv$iv = $this$logInfo_u24default$iv.getLogTag();
                if (this_$iv$iv.matchLevel(3)) {
                    String msg$iv$iv$iv = "thread sleep" != 0 ? "thread sleep" : "";
                    LiveLogDelegate logDelegate = this_$iv$iv.getLogDelegate();
                    if (logDelegate != null) {
                        LiveLogDelegate.-CC.onLog$default(logDelegate, 3, tag$iv$iv, msg$iv$iv$iv, (Throwable) null, 8, (Object) null);
                    }
                    BLog.i(tag$iv$iv, msg$iv$iv$iv);
                }
                this$0.condition.await();
                this$0.lock.unlock();
            }
        }
        this$0.cancelVibrate();
        LiveVibrator $this$logError_u24default$iv = this$0;
        LiveLog.Companion this_$iv$iv2 = LiveLog.Companion;
        String tag$iv$iv2 = $this$logError_u24default$iv.getLogTag();
        if (this_$iv$iv2.matchLevel(1)) {
            String msg$iv$iv$iv2 = "Disposed   " != 0 ? "Disposed   " : "";
            LiveLogDelegate logDelegate2 = this_$iv$iv2.getLogDelegate();
            if (logDelegate2 != null) {
                logDelegate2.onLog(1, tag$iv$iv2, msg$iv$iv$iv2, (Throwable) null);
            }
            BLog.e(tag$iv$iv2, msg$iv$iv$iv2);
        }
    }

    public synchronized void initVibrator() {
        this.isRunning = true;
        new Thread(this.biliVibrateNewTask, "liveVibrate-thread").start();
    }

    public void startVibrate(int leftSpeed, int rightSpeed) {
        setVibrateState(leftSpeed, rightSpeed);
    }

    public void stopVibrate() {
        setVibrateState(0, 0);
    }

    public void destroy() {
        String msg$iv$iv$iv;
        stopVibrate();
        this.isRunning = false;
        this.lock.lock();
        LiveVibrator $this$logInfo_u24default$iv = this;
        LiveLog.Companion this_$iv$iv = LiveLog.Companion;
        String tag$iv$iv = $this$logInfo_u24default$iv.getLogTag();
        if (this_$iv$iv.matchLevel(3)) {
            msg$iv$iv$iv = "thread dispose signalAll";
            msg$iv$iv$iv = msg$iv$iv$iv == null ? "" : "thread dispose signalAll";
            String message$iv$iv = msg$iv$iv$iv;
            LiveLogDelegate logDelegate = this_$iv$iv.getLogDelegate();
            if (logDelegate != null) {
                LiveLogDelegate.-CC.onLog$default(logDelegate, 3, tag$iv$iv, message$iv$iv, (Throwable) null, 8, (Object) null);
            }
            BLog.i(tag$iv$iv, message$iv$iv);
        }
        this.condition.signalAll();
        this.lock.unlock();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:55:0x0153
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private final void setVibrateState(int r34, int r35) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.LiveVibrator.setVibrateState(int, int):void");
    }

    private final double getAdvancedVibrateMotorPercent(double motorPercent) {
        double power = 1 / ((0.5d * motorPercent) + 1.0d);
        return Math.pow(motorPercent, power);
    }

    private final void doAdvancedVibrate(double motorPercent) {
        double amplitude = 255 * motorPercent;
        long waitTimeMs = 50;
        if (amplitude > 16.0d) {
            doVibrateOneShot(50L, (int) amplitude);
        } else {
            double percent = amplitude / 16.0d;
            long vibrateMs = RangesKt.coerceAtLeast(1L, (long) (50 * percent));
            long fullVibrateMs = 50 - 50;
            waitTimeMs = (long) (((1 - percent) * fullVibrateMs) + 50);
            doVibrateOneShot(vibrateMs, (int) 16.0d);
        }
        Thread.sleep(waitTimeMs);
    }

    private final void doHighVibrate(double motorPercent) {
        double vibrateMs = RangesKt.coerceAtLeast(100 * motorPercent, 0.0d);
        doVibrateShot((long) vibrateMs);
        Thread.sleep((long) vibrateMs);
    }

    private final void doMidVibrate(double motorPercent) {
        double vibrateMs = RangesKt.coerceAtLeast(50 * motorPercent, 0.0d);
        doVibrateShot((long) vibrateMs);
        Thread.sleep((long) vibrateMs);
    }

    private final void doLowVibrate(double motorPercent) {
        double waitTime = RangesKt.coerceAtLeast(100 - ((motorPercent / 0.025d) * 100), 0.0d);
        doVibrateShot(2);
        Thread.sleep((long) waitTime);
    }

    private final synchronized void doVibrateOneShot(long time, int amplitude) {
        if (time > 0 && amplitude > 0) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.vibrator.vibrate(VibrationEffect.createOneShot(time, RangesKt.coerceAtMost(RangesKt.coerceAtLeast(amplitude, 3), 255)));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d5 A[Catch: all -> 0x00df, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0005, B:7:0x0020, B:14:0x0046, B:16:0x0051, B:38:0x00d5, B:10:0x0035, B:18:0x0062, B:20:0x0069, B:24:0x007e, B:31:0x00ae, B:33:0x00b5, B:34:0x00c4, B:27:0x0099), top: B:48:0x0005, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final synchronized void doVibrateShot(long time) {
        String str;
        String str2;
        LiveVibrator $this$logDebug_u24default$iv = this;
        LiveLog.Companion this_$iv$iv = LiveLog.Companion;
        String tag$iv$iv = $this$logDebug_u24default$iv.getLogTag();
        if (this_$iv$iv.isDebug()) {
            try {
                str2 = "doVibrateShot time: " + time;
            } catch (Exception e$iv$iv$iv) {
                BLog.e("LiveLog", "getLogMessage", e$iv$iv$iv);
                str2 = null;
            }
            String msg$iv$iv$iv = str2;
            if (msg$iv$iv$iv == null) {
                msg$iv$iv$iv = "";
            }
            BLog.d(tag$iv$iv, msg$iv$iv$iv);
            LiveLogDelegate logDelegate = this_$iv$iv.getLogDelegate();
            if (logDelegate != null) {
                LiveLogDelegate.-CC.onLog$default(logDelegate, 4, tag$iv$iv, msg$iv$iv$iv, (Throwable) null, 8, (Object) null);
            }
            if (time > 0) {
                cancelVibrate();
                this.vibrator.vibrate(time);
            }
        } else {
            if (this_$iv$iv.matchLevel(4) && this_$iv$iv.matchLevel(3)) {
                try {
                    str = "doVibrateShot time: " + time;
                } catch (Exception e$iv$iv$iv$iv) {
                    BLog.e("LiveLog", "getLogMessage", e$iv$iv$iv$iv);
                    str = null;
                }
                String msg$iv$iv$iv$iv = str;
                if (msg$iv$iv$iv$iv == null) {
                    msg$iv$iv$iv$iv = "";
                }
                LiveLogDelegate logDelegate2 = this_$iv$iv.getLogDelegate();
                if (logDelegate2 != null) {
                    LiveLogDelegate.-CC.onLog$default(logDelegate2, 3, tag$iv$iv, msg$iv$iv$iv$iv, (Throwable) null, 8, (Object) null);
                }
                BLog.i(tag$iv$iv, msg$iv$iv$iv$iv);
            }
            if (time > 0) {
            }
        }
    }

    private final synchronized void cancelVibrate() {
        this.vibrator.cancel();
    }

    private final synchronized boolean getIsRunningValue() {
        return this.isRunning;
    }

    private final synchronized int getLatestMotorSpeedValue() {
        return this.latestMotorSpeed;
    }

    private final synchronized double getMotorPercentValue() {
        return this.motorPercent;
    }

    private final synchronized double getAdvancedVibrateMotorPercentValue() {
        return this.advancedVibrateMotorPercent;
    }

    /* compiled from: LiveVibrator.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"LLiveVibrator$Companion;", "", "<init>", "()V", "TAG", "", "VIBRATE_TIME_OUT_MS", "", "room_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: LiveVibrator$Companion */
    /* loaded from: /data/np/file-convert/2026022807222197de6f91-6104-46cc-91cf-b90bdc19816e/2026022807222197de6f91-6104-46cc-91cf-b90bdc19816e.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}