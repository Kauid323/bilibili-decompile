package tv.danmaku.android.log.pipeline;

import android.content.Context;
import android.util.Log;
import com.bilibili.lib.IOUtilsKt;
import java.io.File;
import java.io.FileOutputStream;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.cache.DayExpiredCacheKt;
import tv.danmaku.android.log.internal.BLogThreadFactory;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: DiskWriter.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001*B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020%J\b\u0010)\u001a\u00020%H\u0002R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0018\u00010\u000fR\u00020\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n \u0017*\u0004\u0018\u00010\u00190\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Ltv/danmaku/android/log/pipeline/DiskWriter;", "", "context", "Landroid/content/Context;", "jobManager", "Ltv/danmaku/android/log/pipeline/JobManager;", "maxLogSize", "", "logDir", "Ljava/io/File;", "(Landroid/content/Context;Ltv/danmaku/android/log/pipeline/JobManager;JLjava/io/File;)V", "consumesJobId", "getContext", "()Landroid/content/Context;", "dayFile", "Ltv/danmaku/android/log/pipeline/DiskWriter$DayFile;", "getDayFile", "()Ltv/danmaku/android/log/pipeline/DiskWriter$DayFile;", "setDayFile", "(Ltv/danmaku/android/log/pipeline/DiskWriter$DayFile;)V", "dropLessThan", "executor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "hasJob", "Ljava/util/concurrent/locks/Condition;", "getJobManager", "()Ltv/danmaku/android/log/pipeline/JobManager;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "logFileFullId", "getLogFileFullId", "()J", "setLogFileFullId", "(J)V", "queue", "Ljava/util/PriorityQueue;", "Ltv/danmaku/android/log/pipeline/LogBlockJob;", LoginReporterV2.VALUE_SUBMIT, "", "job", "takeOrderedJob", "DayFile", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
public final class DiskWriter {
    private long consumesJobId;
    private final Context context;
    private DayFile dayFile;
    private long dropLessThan;
    private final ExecutorService executor;
    private final Condition hasJob;
    private final JobManager jobManager;
    private final ReentrantLock lock;
    private long logFileFullId;
    private final long maxLogSize;
    private final PriorityQueue<LogBlockJob> queue;

    public DiskWriter(Context context, JobManager jobManager, long maxLogSize, final File logDir) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jobManager, "jobManager");
        Intrinsics.checkNotNullParameter(logDir, "logDir");
        this.context = context;
        this.jobManager = jobManager;
        this.maxLogSize = maxLogSize;
        this.lock = new ReentrantLock();
        this.hasJob = this.lock.newCondition();
        this.queue = new PriorityQueue<>();
        this.executor = Executors.newSingleThreadExecutor(new BLogThreadFactory("write"));
        this.dropLessThan = -1L;
        this.logFileFullId = -1L;
        this.executor.execute(new Runnable() { // from class: tv.danmaku.android.log.pipeline.DiskWriter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DiskWriter._init_$lambda$0(DiskWriter.this, logDir);
            }
        });
    }

    public final Context getContext() {
        return this.context;
    }

    public final JobManager getJobManager() {
        return this.jobManager;
    }

    public final DayFile getDayFile() {
        return this.dayFile;
    }

    public final void setDayFile(DayFile dayFile) {
        this.dayFile = dayFile;
    }

    public final long getLogFileFullId() {
        return this.logFileFullId;
    }

    public final void setLogFileFullId(long j) {
        this.logFileFullId = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(DiskWriter this$0, File $logDir) {
        DayFile dayFile;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($logDir, "$logDir");
        while (true) {
            LogBlockJob job = this$0.takeOrderedJob();
            if (job.getDay() != null) {
                DayFile dayFile2 = this$0.dayFile;
                if (dayFile2 != null) {
                    dayFile2.resetFile(false);
                }
                this$0.dayFile = new DayFile(this$0, DayExpiredCacheKt.makeBlogFile($logDir, this$0.context, job.getDay()), DayExpiredCacheKt.makePreBlogFile($logDir, this$0.context, job.getDay()), this$0.maxLogSize);
                this$0.dropLessThan = -1L;
                this$0.logFileFullId = -1L;
            } else if (this$0.logFileFullId == job.getId() && (dayFile = this$0.dayFile) != null) {
                dayFile.resetFile(true);
            }
            if (job.getSize() <= 0) {
                job.getBlock().recycle();
            } else if (job.getId() < this$0.dropLessThan) {
                job.getBlock().recycle();
                try {
                    DayFile dayFile3 = this$0.dayFile;
                    if (dayFile3 != null) {
                        DayFile.write$default(dayFile3, DefaltedConstants.INSTANCE.getDROP_LOG(), 0, 2, null);
                    }
                } catch (Exception e) {
                    Log.w(DayExpiredCacheKt.TAG, "fos error", e);
                }
            } else {
                try {
                    try {
                        DayFile dayFile4 = this$0.dayFile;
                        if (dayFile4 != null) {
                            dayFile4.write(job.getCurLog(), job.getSize());
                        }
                    } catch (Exception e2) {
                        this$0.dropLessThan = this$0.jobManager.dropRestJobs();
                        Log.w(DayExpiredCacheKt.TAG, "fos error", e2);
                    }
                    job.getBlock().recycle();
                } catch (Throwable th) {
                    job.getBlock().recycle();
                    throw th;
                }
            }
            this$0.consumesJobId++;
        }
    }

    private final LogBlockJob takeOrderedJob() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                LogBlockJob top = this.queue.peek();
                if (top != null && top.getId() == this.consumesJobId) {
                    LogBlockJob poll = this.queue.poll();
                    Intrinsics.checkNotNull(poll);
                    return poll;
                }
                this.hasJob.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final void submit(LogBlockJob job) {
        Intrinsics.checkNotNullParameter(job, "job");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.queue.offer(job);
            if (job.getId() <= this.consumesJobId) {
                this.hasJob.signal();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* compiled from: DiskWriter.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\b\u0081\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bJ\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Ltv/danmaku/android/log/pipeline/DiskWriter$DayFile;", "", "logFile", "Ljava/io/File;", "preLogFile", "maxLogSize", "", "(Ltv/danmaku/android/log/pipeline/DiskWriter;Ljava/io/File;Ljava/io/File;J)V", "_fos", "Ljava/io/FileOutputStream;", "append", "", "fos", "getFos", "()Ljava/io/FileOutputStream;", "resetFile", "", "rename", "write", "bytes", "", "size", "", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final class DayFile {
        private FileOutputStream _fos;
        private boolean append;
        private final File logFile;
        private final long maxLogSize;
        private final File preLogFile;
        final /* synthetic */ DiskWriter this$0;

        public DayFile(DiskWriter this$0, File logFile, File preLogFile, long maxLogSize) {
            Intrinsics.checkNotNullParameter(logFile, "logFile");
            Intrinsics.checkNotNullParameter(preLogFile, "preLogFile");
            this.this$0 = this$0;
            this.logFile = logFile;
            this.preLogFile = preLogFile;
            this.maxLogSize = maxLogSize;
            this.append = true;
        }

        private final FileOutputStream getFos() {
            FileOutputStream fileOutputStream = this._fos;
            if (fileOutputStream == null) {
                FileOutputStream $this$_get_fos__u24lambda_u240 = new FileOutputStream(this.logFile, this.append);
                this._fos = $this$_get_fos__u24lambda_u240;
                return $this$_get_fos__u24lambda_u240;
            }
            return fileOutputStream;
        }

        public final void resetFile(boolean rename) {
            if (this._fos != null) {
                IOUtilsKt.closeQuietly(this._fos);
                this._fos = null;
            }
            if (rename) {
                this.logFile.renameTo(this.preLogFile);
                this.append = false;
            }
        }

        public static /* synthetic */ void write$default(DayFile dayFile, byte[] bArr, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = bArr.length;
            }
            dayFile.write(bArr, i);
        }

        public final void write(byte[] bytes, int size) {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            long l = this.logFile.length();
            if (size + l >= this.maxLogSize) {
                this.this$0.setLogFileFullId(this.this$0.getJobManager().prepareSwitchFile());
            }
            getFos().write(bytes, 0, size);
        }
    }
}