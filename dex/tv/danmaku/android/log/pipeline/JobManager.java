package tv.danmaku.android.log.pipeline;

import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.cache.Meta;
import tv.danmaku.bili.BR;

/* compiled from: JobManager.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/android/log/pipeline/JobManager;", "", "()V", "allocateJobId", "", "lastDay", "", "lastMillis", "preLog", "", "sdf", "Ljava/text/SimpleDateFormat;", "dropRestJobs", "newCompressorJob", "Ltv/danmaku/android/log/pipeline/LogBlockJob;", "log", "block", "Ltv/danmaku/android/log/cache/Meta$Block;", "prepareSwitchFile", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
public final class JobManager {
    private long allocateJobId;
    private String lastDay;
    private long lastMillis;
    private byte[] preLog;
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

    public final LogBlockJob newCompressorJob(byte[] log, Meta.Block block) {
        String str;
        LogBlockJob logBlockJob;
        Intrinsics.checkNotNullParameter(log, "log");
        Intrinsics.checkNotNullParameter(block, "block");
        long curMillis = System.currentTimeMillis();
        if (curMillis > this.lastMillis) {
            this.lastMillis = curMillis;
            String it = this.sdf.format(Long.valueOf(curMillis));
            if (!Intrinsics.areEqual(it, this.lastDay)) {
                this.lastDay = it;
                str = it;
            } else {
                str = null;
            }
        } else {
            str = null;
        }
        String day = str;
        synchronized (this) {
            byte[] p = day != null ? null : this.preLog;
            this.preLog = log;
            long id = this.allocateJobId;
            this.allocateJobId = 1 + id;
            logBlockJob = new LogBlockJob(id, block, day, p, log, log.length);
        }
        return logBlockJob;
    }

    public final synchronized long dropRestJobs() {
        this.preLog = null;
        return this.allocateJobId;
    }

    public final synchronized long prepareSwitchFile() {
        this.preLog = null;
        return this.allocateJobId;
    }
}