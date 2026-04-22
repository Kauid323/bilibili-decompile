package tv.danmaku.bili.sleepmode;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.SystemClock;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.thread.HandlerThreads;
import tv.danmaku.bili.proc.ActivityCallBack;

public class SleepModeManager {
    public static final String BROADCAST_SLEEP_MODE_ON_TIME = "sleep_mode_on_time";
    private static final long MINUTE = 60000;
    private static final int SLEEP_MODE_NOT_STARTED = Integer.MIN_VALUE;
    private static SleepModeManager sInstance;
    private ActivityCallBack.ActivityStateCallback mActivityStateCallback;
    private boolean mContinueTimerInBackground;
    private long mTimeWhenGotoBackground = 0;
    private long mTotalTime = 0;
    private long mTimeWhenStart = 0;
    private Runnable mRunnable = new Runnable() { // from class: tv.danmaku.bili.sleepmode.SleepModeManager.1
        @Override // java.lang.Runnable
        public void run() {
            if (!SleepModeManager.this.isRunning()) {
                return;
            }
            long leftTime = SleepModeManager.this.getLeftTimeInMillis();
            if (leftTime <= 0) {
                SleepModeManager.this.notifyOnTime();
                SleepModeManager.this.mTotalTime = 0L;
            }
            SleepModeManager.this.postDelay(this, 5000L);
        }
    };

    private SleepModeManager() {
    }

    public static SleepModeManager getInstance() {
        if (sInstance == null) {
            sInstance = new SleepModeManager();
        }
        return sInstance;
    }

    public void start(long totalMinutes) {
        this.mTotalTime = totalMinutes;
        if (totalMinutes > 0) {
            this.mTimeWhenStart = currentTimeMillis();
            postDelay(this.mRunnable, 0L);
        } else {
            this.mTimeWhenStart = 0L;
            removeCallbacks(this.mRunnable);
        }
        checkAndRegisterAppLifecycle();
    }

    public long getLeftTimeInMillis() {
        if (this.mTotalTime <= 0) {
            return -2147483648L;
        }
        long now = currentTimeMillis();
        return ((this.mTotalTime * 60) * 1000) - (now - this.mTimeWhenStart);
    }

    public long getTotalTime() {
        return this.mTotalTime;
    }

    public boolean isRunning() {
        return this.mTotalTime > 0;
    }

    public void setContinueTimerInBackground(boolean continueTimerInBackground) {
        this.mContinueTimerInBackground = continueTimerInBackground;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnTime() {
        Application application = BiliContext.application();
        if (application == null) {
            return;
        }
        LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(application.getApplicationContext());
        lbm.sendBroadcast(new Intent(BROADCAST_SLEEP_MODE_ON_TIME));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long currentTimeMillis() {
        return SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postDelay(Runnable r, long delay) {
        if (delay <= 0) {
            HandlerThreads.getHandler(0).post(r);
        } else {
            HandlerThreads.getHandler(0).postDelayed(r, delay);
        }
    }

    private void removeCallbacks(Runnable r) {
        HandlerThreads.getHandler(0).removeCallbacks(r);
    }

    private void checkAndRegisterAppLifecycle() {
        if (this.mActivityStateCallback == null) {
            this.mActivityStateCallback = new ActivityCallBack.ActivityStateCallback() { // from class: tv.danmaku.bili.sleepmode.SleepModeManager.2
                @Override // tv.danmaku.bili.proc.ActivityCallBack.ActivityStateCallback
                public void onVisibleCountChanged(Activity activity, int lastVisibleCount, int currentVisibleCount) {
                    if (currentVisibleCount == 0) {
                        SleepModeManager.this.mTimeWhenGotoBackground = SleepModeManager.this.currentTimeMillis();
                        return;
                    }
                    if (SleepModeManager.this.mTimeWhenGotoBackground > 0) {
                        long timeInBackground = SleepModeManager.this.currentTimeMillis() - SleepModeManager.this.mTimeWhenGotoBackground;
                        if (timeInBackground > 120000 && !SleepModeManager.this.mContinueTimerInBackground) {
                            SleepModeManager.this.postDelay(new Runnable() { // from class: tv.danmaku.bili.sleepmode.SleepModeManager.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    SleepModeManager.this.start(0L);
                                }
                            }, 1000L);
                        }
                    }
                    SleepModeManager.this.mTimeWhenGotoBackground = 0L;
                }

                @Override // tv.danmaku.bili.proc.ActivityCallBack.ActivityStateCallback
                public void onForegroundActivitiesChanged(Activity activity, int lastForegroundCount, int currentForegroundCount) {
                }
            };
        }
        if (isRunning()) {
            ActivityCallBack.addActivityStateCallback(this.mActivityStateCallback);
        } else {
            ActivityCallBack.removeActivityStateCallback(this.mActivityStateCallback);
        }
    }
}