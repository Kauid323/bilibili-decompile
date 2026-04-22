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
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.LogAdapter;
import tv.danmaku.android.log.adapters.MemoryLogAdapter;
import tv.danmaku.android.log.cache.DayExpiredCacheKt;
import tv.danmaku.android.log.cache.MemoryCache;
import tv.danmaku.android.log.internal.NativeLogger;
import tv.danmaku.android.log.internal.UtilKt;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: MemoryLogAdapter.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0004\u0018\u0000 02\u00020\u00012\u00020\u0002:\u000201B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rH\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\u001a\u0010\u001d\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001f\u001a\u00020\tH\u0016J\b\u0010 \u001a\u00020\u0019H\u0016J\b\u0010!\u001a\u00020\rH\u0016J,\u0010\"\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001f\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\u001a\u0010%\u001a\u00020&2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\tH\u0016J,\u0010'\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001f\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\r0)2\b\u0010*\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010+J)\u0010,\u001a\u0004\u0018\u00010\r2\b\u0010*\u001a\u0004\u0018\u00010\u00072\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010.H\u0016¢\u0006\u0002\u0010/R\u0014\u0010\u000f\u001a\u00020\tX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Ltv/danmaku/android/log/adapters/MemoryLogAdapter;", "Ltv/danmaku/android/log/LogAdapter;", "Ltv/danmaku/android/log/adapters/BLogController;", "priority", "", "cacheSize", "maxLogSize", "", "defaultTag", "", "context", "Landroid/content/Context;", "logDir", "Ljava/io/File;", "(IIJLjava/lang/String;Landroid/content/Context;Ljava/io/File;)V", "TAG", "getTAG", "()Ljava/lang/String;", "cache", "Ltv/danmaku/android/log/cache/MemoryCache;", "getCache", "()Ltv/danmaku/android/log/cache/MemoryCache;", "format", "Ljava/text/SimpleDateFormat;", "addExtraDir", "", "dir", "cleanExpiredFiles", FavoritesConstsKt.CLEAR_INVALID_CLEAR, "event", AppConfig.HOST_TAG, "message", "flush", "getCurLogDir", "innerLog", "t", "", "isLoggable", "", "log", "queryLogFiles", "", "time", "(Ljava/lang/Long;)[Ljava/io/File;", "zippingLogFiles", "attaches", "", "(Ljava/lang/Long;Ljava/util/List;)Ljava/io/File;", "Companion", "MemoryThreadResource", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
public final class MemoryLogAdapter implements LogAdapter, BLogController {
    public static final Companion Companion = new Companion(null);
    private static final ThreadLocal<MemoryThreadResource> local = new ThreadLocal<MemoryThreadResource>() { // from class: tv.danmaku.android.log.adapters.MemoryLogAdapter$Companion$local$1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public MemoryLogAdapter.MemoryThreadResource initialValue() {
            ByteArrayOutputStream br = new ByteArrayOutputStream(4096);
            return new MemoryLogAdapter.MemoryThreadResource(new PrintWriter(br), br, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()), new StringBuilder().append('(').append(Process.myTid()).append(')').toString());
        }
    };
    private final String TAG;
    private final MemoryCache cache;
    private final int cacheSize;
    private final Context context;
    private final String defaultTag;
    private final SimpleDateFormat format;
    private final File logDir;
    private final long maxLogSize;
    private final int priority;

    public MemoryLogAdapter(int priority, int cacheSize, long maxLogSize, String defaultTag, Context context, File logDir) {
        Intrinsics.checkNotNullParameter(defaultTag, "defaultTag");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(logDir, "logDir");
        this.priority = priority;
        this.cacheSize = cacheSize;
        this.maxLogSize = maxLogSize;
        this.defaultTag = defaultTag;
        this.context = context;
        this.logDir = logDir;
        this.TAG = "MemoryLogAdapter";
        this.cache = new MemoryCache(this.cacheSize, this.maxLogSize);
        this.format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ MemoryLogAdapter(int i, int i2, long j, String str, Context context, File file, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r2, i2, j, r6, context, file);
        int i4;
        String str2;
        if ((i3 & 1) == 0) {
            i4 = i;
        } else {
            i4 = 4;
        }
        if ((i3 & 8) == 0) {
            str2 = str;
        } else {
            str2 = NativeLogger.DEFAULT_TAG;
        }
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final MemoryCache getCache() {
        return this.cache;
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

    @Override // tv.danmaku.android.log.LogAdapter
    public void flush() {
    }

    @Override // tv.danmaku.android.log.adapters.BLogController
    public File[] queryLogFiles(Long time) {
        File file = this.logDir;
        Context context = this.context;
        String formattedDate = DiskLogAdapterKt.formattedDate(System.currentTimeMillis(), this.format);
        Intrinsics.checkNotNullExpressionValue(formattedDate, "formattedDate(...)");
        File file2 = DayExpiredCacheKt.makeBlogFile(file, context, formattedDate);
        MemoryCache cache = this.cache;
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        try {
            FileOutputStream it = fileOutputStream;
            byte[] data = cache.getBufferData();
            if (!(data.length == 0)) {
                it.write(data);
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
            return new File[]{file2};
        } finally {
        }
    }

    @Override // tv.danmaku.android.log.adapters.BLogController
    public File zippingLogFiles(Long time, List<File> list) {
        List it;
        if (list == null || (it = CollectionsKt.plus(list, queryLogFiles(time))) == null) {
            it = ArraysKt.asList(queryLogFiles(time));
        }
        List outFiles = it;
        if (!outFiles.isEmpty()) {
            try {
            } catch (IOException e) {
                e = e;
            }
            try {
                File outFile = UtilKt.makeZipFile(this.logDir, this.context, time);
                Closeable $this$into$iv = new ZipOutputStream(new FileOutputStream(outFile));
                try {
                    try {
                        ZipOutputStream zos = (ZipOutputStream) $this$into$iv;
                        Iterator it2 = outFiles.iterator();
                        while (it2.hasNext()) {
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
                        Unit unit = Unit.INSTANCE;
                        IOUtilsKt.closeQuietly($this$into$iv);
                        return outFile;
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        return null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    @Override // tv.danmaku.android.log.adapters.BLogController
    public void addExtraDir(File dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
    }

    @Override // tv.danmaku.android.log.adapters.BLogController
    public File getCurLogDir() {
        return this.logDir;
    }

    @Override // tv.danmaku.android.log.adapters.BLogController
    public void clear() {
        this.cache.clear();
    }

    @Override // tv.danmaku.android.log.adapters.BLogController
    public void cleanExpiredFiles() {
    }

    private final void innerLog(int priority, String tag, String message, Throwable t) {
        try {
            MemoryThreadResource memoryThreadResource = local.get();
            Intrinsics.checkNotNull(memoryThreadResource);
            MemoryThreadResource memoryThreadResource2 = memoryThreadResource;
            PrintWriter pr = memoryThreadResource2.component1();
            ByteArrayOutputStream br = memoryThreadResource2.component2();
            SimpleDateFormat sdf = memoryThreadResource2.component3();
            String tidStr = memoryThreadResource2.component4();
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
            br.writeTo(this.cache.getOs());
            br.reset();
        } catch (IOException e) {
            Log.w(this.TAG, "Log Fail", e);
        }
    }

    /* compiled from: MemoryLogAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/android/log/adapters/MemoryLogAdapter$Companion;", "", "()V", "local", "Ljava/lang/ThreadLocal;", "Ltv/danmaku/android/log/adapters/MemoryLogAdapter$MemoryThreadResource;", "getLocal$blog_android_release", "()Ljava/lang/ThreadLocal;", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ThreadLocal<MemoryThreadResource> getLocal$blog_android_release() {
            return MemoryLogAdapter.local;
        }
    }

    /* compiled from: MemoryLogAdapter.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\tHÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Ltv/danmaku/android/log/adapters/MemoryLogAdapter$MemoryThreadResource;", "", "pr", "Ljava/io/PrintWriter;", "br", "Ljava/io/ByteArrayOutputStream;", "fmt", "Ljava/text/SimpleDateFormat;", "tidStr", "", "(Ljava/io/PrintWriter;Ljava/io/ByteArrayOutputStream;Ljava/text/SimpleDateFormat;Ljava/lang/String;)V", "getBr", "()Ljava/io/ByteArrayOutputStream;", "setBr", "(Ljava/io/ByteArrayOutputStream;)V", "getFmt", "()Ljava/text/SimpleDateFormat;", "getPr", "()Ljava/io/PrintWriter;", "getTidStr", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class MemoryThreadResource {
        private ByteArrayOutputStream br;
        private final SimpleDateFormat fmt;
        private final PrintWriter pr;
        private final String tidStr;

        public static /* synthetic */ MemoryThreadResource copy$default(MemoryThreadResource memoryThreadResource, PrintWriter printWriter, ByteArrayOutputStream byteArrayOutputStream, SimpleDateFormat simpleDateFormat, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                printWriter = memoryThreadResource.pr;
            }
            if ((i & 2) != 0) {
                byteArrayOutputStream = memoryThreadResource.br;
            }
            if ((i & 4) != 0) {
                simpleDateFormat = memoryThreadResource.fmt;
            }
            if ((i & 8) != 0) {
                str = memoryThreadResource.tidStr;
            }
            return memoryThreadResource.copy(printWriter, byteArrayOutputStream, simpleDateFormat, str);
        }

        public final PrintWriter component1() {
            return this.pr;
        }

        public final ByteArrayOutputStream component2() {
            return this.br;
        }

        public final SimpleDateFormat component3() {
            return this.fmt;
        }

        public final String component4() {
            return this.tidStr;
        }

        public final MemoryThreadResource copy(PrintWriter printWriter, ByteArrayOutputStream byteArrayOutputStream, SimpleDateFormat simpleDateFormat, String str) {
            Intrinsics.checkNotNullParameter(printWriter, "pr");
            Intrinsics.checkNotNullParameter(byteArrayOutputStream, "br");
            Intrinsics.checkNotNullParameter(simpleDateFormat, "fmt");
            Intrinsics.checkNotNullParameter(str, "tidStr");
            return new MemoryThreadResource(printWriter, byteArrayOutputStream, simpleDateFormat, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MemoryThreadResource) {
                MemoryThreadResource memoryThreadResource = (MemoryThreadResource) obj;
                return Intrinsics.areEqual(this.pr, memoryThreadResource.pr) && Intrinsics.areEqual(this.br, memoryThreadResource.br) && Intrinsics.areEqual(this.fmt, memoryThreadResource.fmt) && Intrinsics.areEqual(this.tidStr, memoryThreadResource.tidStr);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.pr.hashCode() * 31) + this.br.hashCode()) * 31) + this.fmt.hashCode()) * 31) + this.tidStr.hashCode();
        }

        public String toString() {
            return "MemoryThreadResource(pr=" + this.pr + ", br=" + this.br + ", fmt=" + this.fmt + ", tidStr=" + this.tidStr + ')';
        }

        public MemoryThreadResource(PrintWriter pr, ByteArrayOutputStream br, SimpleDateFormat fmt, String tidStr) {
            Intrinsics.checkNotNullParameter(pr, "pr");
            Intrinsics.checkNotNullParameter(br, "br");
            Intrinsics.checkNotNullParameter(fmt, "fmt");
            Intrinsics.checkNotNullParameter(tidStr, "tidStr");
            this.pr = pr;
            this.br = br;
            this.fmt = fmt;
            this.tidStr = tidStr;
        }

        public final PrintWriter getPr() {
            return this.pr;
        }

        public final ByteArrayOutputStream getBr() {
            return this.br;
        }

        public final void setBr(ByteArrayOutputStream byteArrayOutputStream) {
            Intrinsics.checkNotNullParameter(byteArrayOutputStream, "<set-?>");
            this.br = byteArrayOutputStream;
        }

        public final SimpleDateFormat getFmt() {
            return this.fmt;
        }

        public final String getTidStr() {
            return this.tidStr;
        }
    }
}