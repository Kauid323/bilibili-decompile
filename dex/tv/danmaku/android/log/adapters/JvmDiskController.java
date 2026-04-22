package tv.danmaku.android.log.adapters;

import android.content.Context;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FileWalkDirection;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.internal.UtilKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: DiskController.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0003H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0002\u0010!J)\u0010\"\u001a\u0004\u0018\u00010\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010$H\u0016¢\u0006\u0002\u0010%R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00140\u0013*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006'"}, d2 = {"Ltv/danmaku/android/log/adapters/JvmDiskController;", "Ltv/danmaku/android/log/adapters/BLogController;", "logDir", "Ljava/io/File;", "cacheDir", "expiredDays", "", "context", "Landroid/content/Context;", "(Ljava/io/File;Ljava/io/File;ILandroid/content/Context;)V", "extraDirs", "Ljava/util/concurrent/CopyOnWriteArrayList;", "fmt", "Ljava/text/SimpleDateFormat;", "toDay", "", "getToDay", "(Ljava/lang/String;)Ljava/lang/String;", "validDates", "Lkotlin/Function1;", "", "getValidDates", "(I)Lkotlin/jvm/functions/Function1;", "addExtraDir", "", "dir", "cleanExpiredFiles", FavoritesConstsKt.CLEAR_INVALID_CLEAR, "getCurLogDir", "queryLogFiles", "", "time", "", "(Ljava/lang/Long;)[Ljava/io/File;", "zippingLogFiles", "attaches", "", "(Ljava/lang/Long;Ljava/util/List;)Ljava/io/File;", "Companion", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
public final class JvmDiskController implements BLogController {
    public static final Companion Companion = new Companion(null);
    private static final String EXT = ".blog";
    private final File cacheDir;
    private final Context context;
    private final int expiredDays;
    private final CopyOnWriteArrayList<File> extraDirs;
    private final SimpleDateFormat fmt;
    private final File logDir;

    public JvmDiskController(File logDir, File cacheDir, int expiredDays, Context context) {
        Intrinsics.checkNotNullParameter(logDir, "logDir");
        Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
        Intrinsics.checkNotNullParameter(context, "context");
        this.logDir = logDir;
        this.cacheDir = cacheDir;
        this.expiredDays = expiredDays;
        this.context = context;
        this.extraDirs = new CopyOnWriteArrayList<>();
        this.fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
    }

    @Override // tv.danmaku.android.log.adapters.BLogController
    public void clear() {
        DiskControllerKt.access$deleteRecursively(this.logDir, SetsKt.setOf(this.cacheDir));
    }

    @Override // tv.danmaku.android.log.adapters.BLogController
    public void cleanExpiredFiles() {
        File file = this.logDir;
        Set $this$cleanExpiredFiles_u24lambda_u240 = new LinkedHashSet();
        CollectionsKt.addAll($this$cleanExpiredFiles_u24lambda_u240, queryLogFiles(null));
        $this$cleanExpiredFiles_u24lambda_u240.add(this.cacheDir);
        CollectionsKt.addAll($this$cleanExpiredFiles_u24lambda_u240, this.extraDirs);
        DiskControllerKt.access$deleteRecursively(file, $this$cleanExpiredFiles_u24lambda_u240);
    }

    @Override // tv.danmaku.android.log.adapters.BLogController
    public File zippingLogFiles(Long time, List<File> list) {
        List it;
        char c;
        boolean z;
        Iterator<File> it2;
        File extra;
        char c2;
        boolean z2;
        Throwable th;
        FileInputStream it3;
        if (list == null || (it = CollectionsKt.plus(list, queryLogFiles(time))) == null) {
            it = ArraysKt.asList(queryLogFiles(time));
        }
        List outFiles = it;
        if (!outFiles.isEmpty() || !this.extraDirs.isEmpty()) {
            try {
                try {
                    try {
                        File outFile = UtilKt.makeZipFile(this.logDir, this.context, time);
                        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(outFile));
                        try {
                            ZipOutputStream zos = zipOutputStream;
                            Iterator it4 = outFiles.iterator();
                            while (true) {
                                c = 2;
                                z = false;
                                if (!it4.hasNext()) {
                                    break;
                                }
                                File f = (File) it4.next();
                                zos.putNextEntry(new ZipEntry(f.getName()));
                                FileInputStream fileInputStream = new FileInputStream(f);
                                try {
                                    FileInputStream it5 = fileInputStream;
                                    List outFiles2 = outFiles;
                                    try {
                                        ByteStreamsKt.copyTo$default(it5, zos, 0, 2, (Object) null);
                                        try {
                                            CloseableKt.closeFinally(fileInputStream, (Throwable) null);
                                            outFiles = outFiles2;
                                        } catch (Throwable th2) {
                                            throw th2;
                                        }
                                    } catch (Throwable th3) {
                                        throw th3;
                                    }
                                } catch (Throwable th4) {
                                    throw th4;
                                }
                            }
                            Iterator<File> it6 = this.extraDirs.iterator();
                            loop1: while (it6.hasNext()) {
                                File extra2 = it6.next();
                                File it7 = extra2.getParentFile();
                                if (it7 != null) {
                                    Intrinsics.checkNotNull(it7);
                                    URI base = it7.toURI();
                                    Intrinsics.checkNotNull(extra2);
                                    Iterator it8 = FilesKt.walk$default(extra2, (FileWalkDirection) null, 1, (Object) null).iterator();
                                    while (it8.hasNext()) {
                                        File f2 = (File) it8.next();
                                        try {
                                            if (!f2.isFile()) {
                                                it6 = it6;
                                            } else {
                                                try {
                                                    zos.putNextEntry(new ZipEntry(String.valueOf(base.relativize(f2.toURI()))));
                                                    FileInputStream fileInputStream2 = new FileInputStream(f2);
                                                    try {
                                                        it3 = fileInputStream2;
                                                        try {
                                                            it2 = it6;
                                                            extra = extra2;
                                                            c2 = 2;
                                                            z2 = false;
                                                        } catch (Throwable th5) {
                                                            th = th5;
                                                            it2 = it6;
                                                            extra = extra2;
                                                            c2 = 2;
                                                            z2 = false;
                                                            th = th;
                                                            try {
                                                                throw th;
                                                            } catch (Throwable th6) {
                                                                CloseableKt.closeFinally(fileInputStream2, th);
                                                                throw th6;
                                                                break loop1;
                                                            }
                                                        }
                                                    } catch (Throwable th7) {
                                                        th = th7;
                                                        it2 = it6;
                                                        extra = extra2;
                                                        z2 = z;
                                                        c2 = 2;
                                                    }
                                                    try {
                                                        ByteStreamsKt.copyTo$default(it3, zos, 0, 2, (Object) null);
                                                        try {
                                                            CloseableKt.closeFinally(fileInputStream2, (Throwable) null);
                                                            c = 2;
                                                            z = false;
                                                            it6 = it2;
                                                            extra2 = extra;
                                                        } catch (Exception e) {
                                                            c = c2;
                                                            z = z2;
                                                            it6 = it2;
                                                            extra2 = extra;
                                                        }
                                                    } catch (Throwable th8) {
                                                        th = th8;
                                                        throw th;
                                                    }
                                                } catch (Exception e2) {
                                                    it2 = it6;
                                                    extra = extra2;
                                                    z2 = z;
                                                    c2 = 2;
                                                }
                                            }
                                        } catch (Exception e3) {
                                            it2 = it6;
                                            extra = extra2;
                                            c2 = c;
                                            z2 = z;
                                        }
                                    }
                                    it6 = it6;
                                } else {
                                    it6 = it6;
                                }
                            }
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(zipOutputStream, (Throwable) null);
                            return outFile;
                        } catch (Throwable th9) {
                            throw th9;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        e.printStackTrace();
                        return null;
                    }
                } catch (IOException e5) {
                    e = e5;
                    e.printStackTrace();
                    return null;
                }
            } catch (IOException e6) {
                e = e6;
            }
        } else {
            return null;
        }
    }

    @Override // tv.danmaku.android.log.adapters.BLogController
    public File[] queryLogFiles(Long time) {
        Function1<File, Boolean> validDates;
        if (time != null) {
            String format = this.fmt.format(time);
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            final String day = getToDay(format);
            validDates = new Function1<File, Boolean>() { // from class: tv.danmaku.android.log.adapters.JvmDiskController$queryLogFiles$check$1
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
            validDates = getValidDates(this.expiredDays);
        }
        final Function1 check = validDates;
        File[] listFiles = this.logDir.listFiles(new FileFilter() { // from class: tv.danmaku.android.log.adapters.JvmDiskController$$ExternalSyntheticLambda0
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                boolean queryLogFiles$lambda$6;
                queryLogFiles$lambda$6 = JvmDiskController.queryLogFiles$lambda$6(check, file);
                return queryLogFiles$lambda$6;
            }
        });
        if (listFiles != null) {
            return listFiles;
        }
        return new File[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean queryLogFiles$lambda$6(Function1 $check, File f) {
        Intrinsics.checkNotNullParameter($check, "$check");
        Intrinsics.checkNotNullParameter(f, "f");
        return Companion.isBlog(f) && ((Boolean) $check.invoke(f)).booleanValue();
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

    private final Function1<File, Boolean> getValidDates(int $this$validDates) {
        JvmDiskController jvmDiskController = this;
        Calendar c = Calendar.getInstance();
        Iterable $this$map$iv = RangesKt.until(0, $this$validDates);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        IntIterator it = $this$map$iv.iterator();
        while (it.hasNext()) {
            it.nextInt();
            String format = jvmDiskController.fmt.format(Long.valueOf(c.getTimeInMillis()));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            String toDay = jvmDiskController.getToDay(format);
            c.add(5, -1);
            destination$iv$iv.add(toDay);
            jvmDiskController = this;
        }
        final List l = (List) destination$iv$iv;
        return new Function1<File, Boolean>() { // from class: tv.danmaku.android.log.adapters.JvmDiskController$validDates$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Boolean invoke(File f) {
                Intrinsics.checkNotNullParameter(f, "f");
                String name = f.getName();
                Iterable $this$any$iv = l;
                boolean z = false;
                if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                    Iterator<T> it2 = $this$any$iv.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Object element$iv = it2.next();
                        String it3 = (String) element$iv;
                        Intrinsics.checkNotNull(name);
                        if (StringsKt.startsWith$default(name, it3, false, 2, (Object) null)) {
                            z = true;
                            break;
                        }
                    }
                }
                return Boolean.valueOf(z);
            }
        };
    }

    private final String getToDay(String $this$toDay) {
        String substring = $this$toDay.substring(0, StringsKt.indexOf$default($this$toDay, ' ', 0, false, 6, (Object) null));
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    /* compiled from: DiskController.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/android/log/adapters/JvmDiskController$Companion;", "", "()V", "EXT", "", "isBlog", "", "Ljava/io/File;", "blog_android_release"}, k = 1, mv = {1, 9, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isBlog(File $this$isBlog) {
            String name = $this$isBlog.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            return StringsKt.endsWith$default(name, ".blog", false, 2, (Object) null);
        }
    }
}