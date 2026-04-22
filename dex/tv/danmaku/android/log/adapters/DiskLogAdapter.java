package tv.danmaku.android.log.adapters;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.bilibili.droid.ProcessUtils;
import com.bilibili.lib.IOUtilsKt;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.FileWalkDirection;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.LogAdapter;
import tv.danmaku.android.log.LogDiskCache;
import tv.danmaku.android.log.cache.DayExpiredCache;
import tv.danmaku.android.log.internal.NativeLogger;
import tv.danmaku.android.log.internal.UtilKt;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: DiskLogAdapter.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B;\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\u001a\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\t2\u0006\u0010 \u001a\u00020\tH\u0016J\b\u0010!\u001a\u00020\u001aH\u0016J\b\u0010\"\u001a\u00020\u000bH\u0016J,\u0010#\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\t2\u0006\u0010 \u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u001a\u0010&\u001a\u00020'2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\tH\u0016J,\u0010(\u001a\u00020\u001a2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\t2\u0006\u0010 \u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0002\u0010-J)\u0010.\u001a\u0004\u0018\u00010\u000b2\b\u0010+\u001a\u0004\u0018\u00010,2\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u000100H\u0016¢\u0006\u0002\u00101R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u00063"}, d2 = {"Ltv/danmaku/android/log/adapters/DiskLogAdapter;", "Ltv/danmaku/android/log/LogAdapter;", "Ltv/danmaku/android/log/adapters/BLogController;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "priority", "", "defaultTag", "", "logDir", "Ljava/io/File;", "cacheDir", "cache", "Ltv/danmaku/android/log/LogDiskCache;", "(ILjava/lang/String;Landroid/content/Context;Ljava/io/File;Ljava/io/File;Ltv/danmaku/android/log/LogDiskCache;)V", "getCacheDir", "()Ljava/io/File;", "getContext", "()Landroid/content/Context;", "extraDirs", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getLogDir", "getPriority", "()I", "addExtraDir", "", "dir", "cleanExpiredFiles", FavoritesConstsKt.CLEAR_INVALID_CLEAR, "event", AppConfig.HOST_TAG, "message", "flush", "getCurLogDir", "innerLog", "t", "", "isLoggable", "", "log", "queryLogFiles", "", "time", "", "(Ljava/lang/Long;)[Ljava/io/File;", "zippingLogFiles", "attaches", "", "(Ljava/lang/Long;Ljava/util/List;)Ljava/io/File;", "Companion", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
public final class DiskLogAdapter implements LogAdapter, BLogController {
    public static final String TAG = "DiskLogAdapter";
    private final LogDiskCache cache;
    private final File cacheDir;
    private final Context context;
    private final String defaultTag;
    private final CopyOnWriteArrayList<File> extraDirs;
    private final File logDir;
    private final int priority;
    public static final Companion Companion = new Companion(null);
    private static final ThreadLocal<ThreadResource> local = new ThreadLocal<ThreadResource>() { // from class: tv.danmaku.android.log.adapters.DiskLogAdapter$Companion$local$1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public ThreadResource initialValue() {
            ByteArrayOutputStream b = new ByteArrayOutputStream(4096);
            return new ThreadResource(new PrintWriter(b), b, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()), new StringBuilder().append('(').append(Process.myTid()).append(')').toString());
        }
    };

    public DiskLogAdapter(int priority, String defaultTag, Context context, File logDir, File cacheDir, LogDiskCache cache) {
        Intrinsics.checkNotNullParameter(defaultTag, "defaultTag");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(logDir, "logDir");
        Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
        Intrinsics.checkNotNullParameter(cache, "cache");
        this.priority = priority;
        this.defaultTag = defaultTag;
        this.context = context;
        this.logDir = logDir;
        this.cacheDir = cacheDir;
        this.cache = cache;
        this.extraDirs = new CopyOnWriteArrayList<>();
    }

    public /* synthetic */ DiskLogAdapter(int i, String str, Context context, File file, File file2, LogDiskCache logDiskCache, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 4 : i, (i2 & 2) != 0 ? NativeLogger.DEFAULT_TAG : str, context, file, file2, (i2 & 32) != 0 ? new DayExpiredCache(file, file2, context, 0L, 0, 0L, false, 0, 0, 0, 1016, null) : logDiskCache);
    }

    public final int getPriority() {
        return this.priority;
    }

    public final Context getContext() {
        return this.context;
    }

    public final File getLogDir() {
        return this.logDir;
    }

    public final File getCacheDir() {
        return this.cacheDir;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DiskLogAdapter(Context context) {
        this(0, null, context, Companion.findSuitableDir(context), Companion.findCacheDir(context), null, 35, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // tv.danmaku.android.log.LogAdapter
    public boolean isLoggable(int priority, String tag) {
        return priority >= this.priority;
    }

    @Override // tv.danmaku.android.log.LogAdapter
    public void log(int priority, String tag, String message, Throwable t) {
        Intrinsics.checkNotNullParameter(message, "message");
        innerLog(priority, tag, message, t);
    }

    @Override // tv.danmaku.android.log.LogAdapter
    public void event(String tag, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        innerLog(-1, tag, message, null);
    }

    private final void innerLog(int priority, String tag, String message, Throwable t) {
        try {
            ThreadResource threadResource = local.get();
            Intrinsics.checkNotNull(threadResource);
            ThreadResource threadResource2 = threadResource;
            PrintWriter pr = threadResource2.component1();
            ByteArrayOutputStream bos = threadResource2.component2();
            SimpleDateFormat sdf = threadResource2.component3();
            String tidStr = threadResource2.component4();
            String formattedDate = DiskLogAdapterKt.formattedDate(System.currentTimeMillis(), sdf);
            pr.write(formattedDate);
            pr.write(32);
            pr.write(ProcessUtils.myProcName(this.context));
            pr.write(UtilKt.getPidStr());
            pr.write(47);
            String name = Thread.currentThread().getName();
            if (name == null) {
                name = "null";
            } else {
                Intrinsics.checkNotNull(name);
            }
            pr.write(name);
            pr.write(tidStr);
            pr.write(32);
            pr.write(UtilKt.toName(priority));
            pr.write(47);
            pr.write(tag == null ? this.defaultTag : tag);
            pr.write(32);
            pr.write(message);
            pr.println();
            if (t != null) {
                t.printStackTrace(pr);
            }
            pr.flush();
            OutputStream os = this.cache.getAsSink();
            bos.writeTo(os);
            bos.reset();
        } catch (IOException e) {
            Log.w(TAG, "Log Fail", e);
        }
    }

    @Override // tv.danmaku.android.log.LogAdapter
    public void flush() {
        try {
            this.cache.getAsSink().flush();
        } catch (IOException e) {
            Log.w(TAG, "Flush Fail", e);
        }
    }

    @Override // tv.danmaku.android.log.adapters.BLogController
    public void clear() {
        this.cache.deleteAll();
    }

    @Override // tv.danmaku.android.log.adapters.BLogController
    public void cleanExpiredFiles() {
        this.cache.deleteExpiredFiles(this.extraDirs);
    }

    @Override // tv.danmaku.android.log.adapters.BLogController
    public File zippingLogFiles(Long time, List<File> list) {
        List it;
        boolean z;
        if (list == null || (it = CollectionsKt.plus(list, queryLogFiles(time))) == null) {
            it = ArraysKt.asList(queryLogFiles(time));
        }
        List outFiles = it;
        if (!outFiles.isEmpty() || !this.extraDirs.isEmpty()) {
            try {
                File outFile = UtilKt.makeZipFile(this.logDir, this.context, time);
                Closeable $this$into$iv = new ZipOutputStream(new FileOutputStream(outFile));
                try {
                    try {
                        ZipOutputStream zos = (ZipOutputStream) $this$into$iv;
                        Iterator it2 = outFiles.iterator();
                        while (true) {
                            z = false;
                            if (!it2.hasNext()) {
                                break;
                            }
                            File f = (File) it2.next();
                            zos.putNextEntry(new ZipEntry(f.getName()));
                            Closeable $this$into$iv2 = new FileInputStream(f);
                            try {
                                FileInputStream it3 = (FileInputStream) $this$into$iv2;
                                Iterator it4 = it2;
                                List outFiles2 = outFiles;
                                try {
                                    ByteStreamsKt.copyTo$default(it3, zos, 0, 2, (Object) null);
                                    try {
                                        IOUtilsKt.closeQuietly($this$into$iv2);
                                        it2 = it4;
                                        outFiles = outFiles2;
                                    } catch (Throwable th) {
                                        th = th;
                                        IOUtilsKt.closeQuietly($this$into$iv);
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    IOUtilsKt.closeQuietly($this$into$iv2);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                        Iterator<File> it5 = this.extraDirs.iterator();
                        while (it5.hasNext()) {
                            File extra = it5.next();
                            File it6 = extra.getParentFile();
                            if (it6 != null) {
                                Intrinsics.checkNotNull(it6);
                                URI base = it6.toURI();
                                Intrinsics.checkNotNull(extra);
                                Iterator it7 = FilesKt.walk$default(extra, (FileWalkDirection) null, 1, (Object) null).iterator();
                                while (it7.hasNext()) {
                                    File f2 = (File) it7.next();
                                    if (f2.isFile()) {
                                        zos.putNextEntry(new ZipEntry(String.valueOf(base.relativize(f2.toURI()))));
                                        Closeable $this$into$iv3 = new FileInputStream(f2);
                                        try {
                                            FileInputStream it8 = (FileInputStream) $this$into$iv3;
                                            Iterator<File> it9 = it5;
                                            File extra2 = extra;
                                            File it10 = it6;
                                            try {
                                                ByteStreamsKt.copyTo$default(it8, zos, 0, 2, (Object) null);
                                                IOUtilsKt.closeQuietly($this$into$iv3);
                                                z = false;
                                                it6 = it10;
                                                it5 = it9;
                                                extra = extra2;
                                            } catch (Throwable th4) {
                                                th = th4;
                                                IOUtilsKt.closeQuietly($this$into$iv3);
                                                throw th;
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                        }
                                    } else {
                                        it6 = it6;
                                        extra = extra;
                                    }
                                }
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                        IOUtilsKt.closeQuietly($this$into$iv);
                        return outFile;
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        return null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } else {
            return null;
        }
    }

    @Override // tv.danmaku.android.log.adapters.BLogController
    public File[] queryLogFiles(Long time) {
        return this.cache.logFilesOf(time);
    }

    @Override // tv.danmaku.android.log.adapters.BLogController
    public void addExtraDir(File dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        this.extraDirs.add(dir);
    }

    @Override // tv.danmaku.android.log.adapters.BLogController
    public File getCurLogDir() {
        return this.logDir;
    }

    /* compiled from: DiskLogAdapter.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Ltv/danmaku/android/log/adapters/DiskLogAdapter$Companion;", "", "()V", "TAG", "", "local", "Ljava/lang/ThreadLocal;", "Ltv/danmaku/android/log/adapters/ThreadResource;", "getLocal$blog_android_release", "()Ljava/lang/ThreadLocal;", "findCacheDir", "Ljava/io/File;", "context", "Landroid/content/Context;", "findSuitableDir", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final File findSuitableDir(Context context) {
            File dir = context.getDir("blog_v3", 0);
            Intrinsics.checkNotNullExpressionValue(dir, "getDir(...)");
            return dir;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final File findCacheDir(Context context) {
            File $this$findCacheDir_u24lambda_u240 = new File(findSuitableDir(context), "cache");
            $this$findCacheDir_u24lambda_u240.mkdirs();
            return $this$findCacheDir_u24lambda_u240;
        }

        public final ThreadLocal<ThreadResource> getLocal$blog_android_release() {
            return DiskLogAdapter.local;
        }
    }
}