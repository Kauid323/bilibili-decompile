package tv.danmaku.bili.report.startup.v2;

import android.os.SystemClock;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import tv.danmaku.bili.BR;

/* compiled from: StartShowRecorder.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0005J\b\u0010\u000e\u001a\u00020\u0005H\u0007J\b\u0010\u000f\u001a\u00020\bH\u0007J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\bJ\b\u0010\u0011\u001a\u00020\fH\u0007J\b\u0010\u0012\u001a\u00020\fH\u0007J\b\u0010\u0013\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/report/startup/v2/StartShowRecorder;", "", "<init>", "()V", "INVALID_TIME", "", "mStart", "mIsSelfStart", "", "mBrandSplashStart", "mBrandSplashEnd", "startRecord", "", "getStartTime", "getDuration", "isSelfStart", "setIsSelfStart", "onBrandSplashStart", "onBrandSplashEnd", "getBrandSplashDuration", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class StartShowRecorder {
    private static final long INVALID_TIME = -1;
    private static boolean mIsSelfStart;
    public static final StartShowRecorder INSTANCE = new StartShowRecorder();
    private static long mStart = -1;
    private static long mBrandSplashStart = -1;
    private static long mBrandSplashEnd = -1;
    public static final int $stable = 8;

    private StartShowRecorder() {
    }

    public final void startRecord() {
        mStart = SystemClock.elapsedRealtime();
        mIsSelfStart = false;
    }

    public final long getStartTime() {
        return mStart;
    }

    @JvmStatic
    public static final long getDuration() {
        if (mStart <= 0) {
            return -1L;
        }
        return SystemClock.elapsedRealtime() - mStart;
    }

    @JvmStatic
    public static final boolean isSelfStart() {
        return mIsSelfStart;
    }

    public final void setIsSelfStart(boolean isSelfStart) {
        mIsSelfStart = isSelfStart;
    }

    @JvmStatic
    public static final void onBrandSplashStart() {
        mBrandSplashStart = SystemClock.elapsedRealtime();
    }

    @JvmStatic
    public static final void onBrandSplashEnd() {
        mBrandSplashEnd = SystemClock.elapsedRealtime();
    }

    @JvmStatic
    public static final long getBrandSplashDuration() {
        if (mBrandSplashStart == -1 || mBrandSplashEnd == -1) {
            return 0L;
        }
        return mBrandSplashEnd - mBrandSplashStart;
    }
}