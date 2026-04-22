package leakcanary.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Environment;
import com.squareup.leakcanary.core.R;
import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import shark.SharkLog;

/* compiled from: LeakDirectoryProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0007J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u0017\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lleakcanary/internal/LeakDirectoryProvider;", "", "context", "Landroid/content/Context;", "maxStoredHeapDumps", "Lkotlin/Function0;", "", "requestExternalStoragePermission", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "appStorageDirectory", "Ljava/io/File;", "cleanupOldHeapDumps", "", "directoryWritableAfterMkdirs", "directory", "externalStorageDirectory", "hasStoragePermission", "listWritableFiles", "", "filter", "Ljava/io/FilenameFilter;", "newHeapDumpFile", "requestWritePermissionNotification", "Companion", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class LeakDirectoryProvider {
    private static final String HPROF_SUFFIX = ".hprof";
    private static volatile boolean permissionNotificationDisplayed;
    private static volatile boolean writeExternalStorageGranted;
    private final Context context;
    private final Function0<Integer> maxStoredHeapDumps;
    private final Function0<Boolean> requestExternalStoragePermission;
    public static final Companion Companion = new Companion(null);
    private static final List<String> filesDeletedTooOld = new ArrayList();
    private static final List<String> filesDeletedRemoveLeak = new ArrayList();

    public LeakDirectoryProvider(Context context, Function0<Integer> maxStoredHeapDumps, Function0<Boolean> requestExternalStoragePermission) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(maxStoredHeapDumps, "maxStoredHeapDumps");
        Intrinsics.checkParameterIsNotNull(requestExternalStoragePermission, "requestExternalStoragePermission");
        this.maxStoredHeapDumps = maxStoredHeapDumps;
        this.requestExternalStoragePermission = requestExternalStoragePermission;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "context.applicationContext");
        this.context = applicationContext;
    }

    public final File newHeapDumpFile() {
        cleanupOldHeapDumps();
        File externalStorageDirectory = externalStorageDirectory();
        if (!directoryWritableAfterMkdirs(externalStorageDirectory)) {
            if (!hasStoragePermission()) {
                if (this.requestExternalStoragePermission.invoke().booleanValue()) {
                    SharkLog this_$iv = SharkLog.INSTANCE;
                    SharkLog.Logger logger$iv = this_$iv.getLogger();
                    if (logger$iv != null) {
                        logger$iv.d("WRITE_EXTERNAL_STORAGE permission not granted, requesting");
                    }
                    requestWritePermissionNotification();
                } else {
                    SharkLog this_$iv2 = SharkLog.INSTANCE;
                    SharkLog.Logger logger$iv2 = this_$iv2.getLogger();
                    if (logger$iv2 != null) {
                        logger$iv2.d("WRITE_EXTERNAL_STORAGE permission not granted, ignoring");
                    }
                }
            } else {
                String state = Environment.getExternalStorageState();
                if (!Intrinsics.areEqual("mounted", state)) {
                    SharkLog this_$iv3 = SharkLog.INSTANCE;
                    SharkLog.Logger logger$iv3 = this_$iv3.getLogger();
                    if (logger$iv3 != null) {
                        logger$iv3.d("External storage not mounted, state: " + state);
                    }
                } else {
                    SharkLog this_$iv4 = SharkLog.INSTANCE;
                    SharkLog.Logger logger$iv4 = this_$iv4.getLogger();
                    if (logger$iv4 != null) {
                        logger$iv4.d("Could not create heap dump directory in external storage: [" + externalStorageDirectory.getAbsolutePath() + AbstractJsonLexerKt.END_LIST);
                    }
                }
            }
            externalStorageDirectory = appStorageDirectory();
            if (!directoryWritableAfterMkdirs(externalStorageDirectory)) {
                SharkLog this_$iv5 = SharkLog.INSTANCE;
                SharkLog.Logger logger$iv5 = this_$iv5.getLogger();
                if (logger$iv5 != null) {
                    logger$iv5.d("Could not create heap dump directory in app storage: [" + externalStorageDirectory.getAbsolutePath() + AbstractJsonLexerKt.END_LIST);
                    return null;
                }
                return null;
            }
        }
        String fileName = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SSS'.hprof'", Locale.US).format(new Date());
        return new File(externalStorageDirectory, fileName);
    }

    public final boolean hasStoragePermission() {
        if (writeExternalStorageGranted) {
            return true;
        }
        writeExternalStorageGranted = this.context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        return writeExternalStorageGranted;
    }

    public final void requestWritePermissionNotification() {
        if (permissionNotificationDisplayed || !Notifications.INSTANCE.getCanShowNotification()) {
            return;
        }
        permissionNotificationDisplayed = true;
        PendingIntent pendingIntent = RequestPermissionActivity.Companion.createPendingIntent(this.context, "android.permission.WRITE_EXTERNAL_STORAGE");
        String contentTitle = this.context.getString(R.string.leak_canary_permission_notification_title);
        Intrinsics.checkExpressionValueIsNotNull(contentTitle, "context.getString(\n     …_notification_title\n    )");
        String packageName = this.context.getPackageName();
        String contentText = this.context.getString(R.string.leak_canary_permission_notification_text, packageName);
        Intrinsics.checkExpressionValueIsNotNull(contentText, "context.getString(R.stri…cation_text, packageName)");
        Notifications.INSTANCE.showNotification(this.context, contentTitle, contentText, pendingIntent, R.id.leak_canary_notification_write_permission, NotificationType.LEAKCANARY_LOW);
    }

    private final File externalStorageDirectory() {
        File downloadsDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        return new File(downloadsDirectory, "leakcanary-" + this.context.getPackageName());
    }

    private final File appStorageDirectory() {
        File appFilesDirectory = this.context.getCacheDir();
        return new File(appFilesDirectory, "leakcanary");
    }

    private final boolean directoryWritableAfterMkdirs(File directory) {
        boolean success = directory.mkdirs();
        return (success || directory.exists()) && directory.canWrite();
    }

    private final void cleanupOldHeapDumps() {
        List hprofFiles = listWritableFiles(new FilenameFilter() { // from class: leakcanary.internal.LeakDirectoryProvider$cleanupOldHeapDumps$hprofFiles$1
            @Override // java.io.FilenameFilter
            public final boolean accept(File $noName_0, String name) {
                Intrinsics.checkExpressionValueIsNotNull(name, "name");
                return StringsKt.endsWith$default(name, ".hprof", false, 2, (Object) null);
            }
        });
        int maxStoredHeapDumps = this.maxStoredHeapDumps.invoke().intValue();
        if (maxStoredHeapDumps < 1) {
            throw new IllegalArgumentException("maxStoredHeapDumps must be at least 1");
        }
        int filesToRemove = hprofFiles.size() - maxStoredHeapDumps;
        if (filesToRemove > 0) {
            SharkLog this_$iv = SharkLog.INSTANCE;
            SharkLog.Logger logger$iv = this_$iv.getLogger();
            if (logger$iv != null) {
                logger$iv.d("Removing " + filesToRemove + " heap dumps");
            }
            CollectionsKt.sortWith(hprofFiles, new Comparator<File>() { // from class: leakcanary.internal.LeakDirectoryProvider$cleanupOldHeapDumps$2
                @Override // java.util.Comparator
                public final int compare(File lhs, File rhs) {
                    return (lhs.lastModified() > rhs.lastModified() ? 1 : (lhs.lastModified() == rhs.lastModified() ? 0 : -1));
                }
            });
            for (int i = 0; i < filesToRemove; i++) {
                String path = hprofFiles.get(i).getAbsolutePath();
                boolean deleted = hprofFiles.get(i).delete();
                if (deleted) {
                    filesDeletedTooOld.add(path);
                } else {
                    SharkLog this_$iv2 = SharkLog.INSTANCE;
                    SharkLog.Logger logger$iv2 = this_$iv2.getLogger();
                    if (logger$iv2 != null) {
                        logger$iv2.d("Could not delete old hprof file " + hprofFiles.get(i).getPath());
                    }
                }
            }
        }
    }

    private final List<File> listWritableFiles(FilenameFilter filter) {
        File[] externalFiles;
        ArrayList files = new ArrayList();
        File externalStorageDirectory = externalStorageDirectory();
        if (externalStorageDirectory.exists() && externalStorageDirectory.canWrite() && (externalFiles = externalStorageDirectory.listFiles(filter)) != null) {
            CollectionsKt.addAll(files, externalFiles);
        }
        File[] appFiles = appStorageDirectory().listFiles(filter);
        if (appFiles != null) {
            CollectionsKt.addAll(files, appFiles);
        }
        return files;
    }

    /* compiled from: LeakDirectoryProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lleakcanary/internal/LeakDirectoryProvider$Companion;", "", "()V", "HPROF_SUFFIX", "", "filesDeletedRemoveLeak", "", "getFilesDeletedRemoveLeak", "()Ljava/util/List;", "filesDeletedTooOld", "permissionNotificationDisplayed", "", "writeExternalStorageGranted", "hprofDeleteReason", "file", "Ljava/io/File;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final List<String> getFilesDeletedRemoveLeak() {
            return LeakDirectoryProvider.filesDeletedRemoveLeak;
        }

        public final String hprofDeleteReason(File file) {
            Intrinsics.checkParameterIsNotNull(file, "file");
            String path = file.getAbsolutePath();
            return LeakDirectoryProvider.filesDeletedTooOld.contains(path) ? "older than all other hprof files" : getFilesDeletedRemoveLeak().contains(path) ? "leak manually removed" : "unknown";
        }
    }
}