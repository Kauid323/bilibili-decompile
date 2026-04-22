package tv.danmaku.android.log.cache;

import android.content.Context;
import java.io.File;
import java.io.FileFilter;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.LogDiskCache;
import tv.danmaku.android.log.adapters.DiskLogAdapterKt;
import tv.danmaku.android.log.cache.DayExpiredCache$meta$2;
import tv.danmaku.android.log.cache.Meta;
import tv.danmaku.android.log.internal.BLogThreadFactory;
import tv.danmaku.android.log.pipeline.DiskWriter;
import tv.danmaku.android.log.pipeline.JobManager;
import tv.danmaku.android.log.pipeline.LogBlockJob;
import tv.danmaku.android.log.pipeline.MultiCoreCompressor;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: DayExpiredCache.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0000\u0018\u0000 .2\u00020\u0001:\u0001.Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n¢\u0006\u0002\u0010\u0011J\b\u0010%\u001a\u00020&H\u0016J\u0016\u0010'\u001a\u00020&2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030)H\u0016J\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030+2\b\u0010,\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010-R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\n $*\u0004\u0018\u00010#0#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Ltv/danmaku/android/log/cache/DayExpiredCache;", "Ltv/danmaku/android/log/LogDiskCache;", "logDir", "Ljava/io/File;", "cacheDir", "context", "Landroid/content/Context;", "maxLogSize", "", "expiredDays", "", "flushMillis", "useLollipopAPI", "", "blockAmount", "pageAmountInBlock", "coreSize", "(Ljava/io/File;Ljava/io/File;Landroid/content/Context;JIJZIII)V", "asSink", "Ljava/io/OutputStream;", "getAsSink", "()Ljava/io/OutputStream;", "compressor", "Ltv/danmaku/android/log/pipeline/MultiCoreCompressor;", "diskWriter", "Ltv/danmaku/android/log/pipeline/DiskWriter;", "jobManager", "Ltv/danmaku/android/log/pipeline/JobManager;", "meta", "Ltv/danmaku/android/log/cache/Meta;", "getMeta", "()Ltv/danmaku/android/log/cache/Meta;", "meta$delegate", "Lkotlin/Lazy;", "submitExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "deleteAll", "", "deleteExpiredFiles", "keep", "", "logFilesOf", "", "date", "(Ljava/lang/Long;)[Ljava/io/File;", "Companion", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
public final class DayExpiredCache implements LogDiskCache {
    public static final Companion Companion = new Companion(null);
    public static final String EXT = ".blog";
    private final OutputStream asSink;
    private final File cacheDir;
    private final MultiCoreCompressor compressor;
    private final DiskWriter diskWriter;
    private final int expiredDays;
    private final long flushMillis;
    private final JobManager jobManager;
    private final File logDir;
    private final Lazy meta$delegate;
    private final ScheduledExecutorService submitExecutor;

    public DayExpiredCache(File logDir, File cacheDir, final Context context, long maxLogSize, int expiredDays, long flushMillis, final boolean useLollipopAPI, final int blockAmount, final int pageAmountInBlock, int coreSize) {
        Intrinsics.checkNotNullParameter(logDir, "logDir");
        Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
        Intrinsics.checkNotNullParameter(context, "context");
        this.logDir = logDir;
        this.cacheDir = cacheDir;
        this.expiredDays = expiredDays;
        this.flushMillis = flushMillis;
        this.jobManager = new JobManager();
        this.submitExecutor = Executors.newScheduledThreadPool(1, new BLogThreadFactory(LoginReporterV2.VALUE_SUBMIT));
        this.diskWriter = new DiskWriter(context, this.jobManager, maxLogSize, this.logDir);
        this.compressor = new MultiCoreCompressor(coreSize, new Function1<LogBlockJob, Unit>() { // from class: tv.danmaku.android.log.cache.DayExpiredCache$compressor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((LogBlockJob) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(LogBlockJob job) {
                DiskWriter diskWriter;
                Intrinsics.checkNotNullParameter(job, "job");
                diskWriter = DayExpiredCache.this.diskWriter;
                diskWriter.submit(job);
            }
        });
        this.meta$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<Meta>() { // from class: tv.danmaku.android.log.cache.DayExpiredCache$meta$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: DayExpiredCache.kt */
            @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "b", "Ltv/danmaku/android/log/cache/Meta$Block;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = BR.badgeVisibility)
            /* renamed from: tv.danmaku.android.log.cache.DayExpiredCache$meta$2$1  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
            public static final class AnonymousClass1 extends Lambda implements Function1<Meta.Block, Unit> {
                final /* synthetic */ DayExpiredCache this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(DayExpiredCache dayExpiredCache) {
                    super(1);
                    this.this$0 = dayExpiredCache;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((Meta.Block) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(final Meta.Block b) {
                    ScheduledExecutorService scheduledExecutorService;
                    Intrinsics.checkNotNullParameter(b, "b");
                    scheduledExecutorService = this.this$0.submitExecutor;
                    final DayExpiredCache dayExpiredCache = this.this$0;
                    scheduledExecutorService.execute(new Runnable() { // from class: tv.danmaku.android.log.cache.DayExpiredCache$meta$2$1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            DayExpiredCache$meta$2.AnonymousClass1.invoke$lambda$0(Meta.Block.this, dayExpiredCache);
                        }
                    });
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void invoke$lambda$0(Meta.Block $b, DayExpiredCache this$0) {
                    JobManager jobManager;
                    MultiCoreCompressor multiCoreCompressor;
                    Intrinsics.checkNotNullParameter($b, "$b");
                    Intrinsics.checkNotNullParameter(this$0, "this$0");
                    byte[] bytes = $b.getAllBytes();
                    jobManager = this$0.jobManager;
                    LogBlockJob job = jobManager.newCompressorJob(bytes, $b);
                    multiCoreCompressor = this$0.compressor;
                    multiCoreCompressor.submit(job);
                }
            }

            public final Meta invoke() {
                File file;
                Meta.Companion companion = Meta.Companion;
                int i = blockAmount;
                int i2 = pageAmountInBlock;
                file = this.cacheDir;
                return companion.newMeta(i, i2, DayExpiredCacheKt.makeCacheFile(file, context), useLollipopAPI, new AnonymousClass1(this));
            }
        });
        this.asSink = new DayExpiredCache$asSink$1(this);
    }

    public /* synthetic */ DayExpiredCache(File file, File file2, Context context, long j, int i, long j2, boolean z, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, file2, context, (i5 & 8) != 0 ? 5242880L : j, (i5 & 16) != 0 ? 2 : i, (i5 & 32) != 0 ? 5000L : j2, (i5 & 64) != 0 ? true : z, (i5 & BR.cover) != 0 ? 4 : i2, (i5 & BR.hallEnterHotText) != 0 ? 8 : i3, (i5 & BR.roleType) != 0 ? 3 : i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Meta getMeta() {
        return (Meta) this.meta$delegate.getValue();
    }

    @Override // tv.danmaku.android.log.LogDiskCache
    public OutputStream getAsSink() {
        return this.asSink;
    }

    @Override // tv.danmaku.android.log.LogDiskCache
    public File[] logFilesOf(Long date) {
        Function1<File, Boolean> validDates;
        if (date != null) {
            String formattedDate$default = DiskLogAdapterKt.formattedDate$default(date.longValue(), null, 1, null);
            Intrinsics.checkNotNullExpressionValue(formattedDate$default, "formattedDate$default(...)");
            final String day = DiskLogAdapterKt.getToDay(formattedDate$default);
            validDates = new Function1<File, Boolean>() { // from class: tv.danmaku.android.log.cache.DayExpiredCache$logFilesOf$check$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final Boolean invoke(File f) {
                    Intrinsics.checkNotNullParameter(f, "f");
                    String name = f.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    return Boolean.valueOf(StringsKt.startsWith$default(name, day, false, 2, (Object) null));
                }
            };
        } else {
            validDates = DiskLogAdapterKt.getValidDates(this.expiredDays);
        }
        final Function1 check = validDates;
        File[] listFiles = this.logDir.listFiles(new FileFilter() { // from class: tv.danmaku.android.log.cache.DayExpiredCache$$ExternalSyntheticLambda0
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                boolean logFilesOf$lambda$0;
                logFilesOf$lambda$0 = DayExpiredCache.logFilesOf$lambda$0(check, file);
                return logFilesOf$lambda$0;
            }
        });
        if (listFiles != null) {
            return listFiles;
        }
        return new File[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean logFilesOf$lambda$0(Function1 $check, File f) {
        Intrinsics.checkNotNullParameter($check, "$check");
        Intrinsics.checkNotNullParameter(f, "f");
        return DayExpiredCacheKt.access$isBlog(f) && ((Boolean) $check.invoke(f)).booleanValue();
    }

    @Override // tv.danmaku.android.log.LogDiskCache
    public void deleteAll() {
        DayExpiredCacheKt.access$deleteRecursively(this.logDir, SetsKt.setOf(this.cacheDir));
    }

    @Override // tv.danmaku.android.log.LogDiskCache
    public void deleteExpiredFiles(List<? extends File> list) {
        Intrinsics.checkNotNullParameter(list, "keep");
        DayExpiredCacheKt.access$deleteRecursively(this.logDir, CollectionsKt.plus(ArraysKt.asList(ArraysKt.plus(logFilesOf(null), this.cacheDir)), list));
    }

    /* compiled from: DayExpiredCache.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Ltv/danmaku/android/log/cache/DayExpiredCache$Companion;", "", "()V", "EXT", "", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}