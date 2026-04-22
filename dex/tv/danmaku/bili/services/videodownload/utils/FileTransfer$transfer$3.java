package tv.danmaku.bili.services.videodownload.utils;

import android.app.Application;
import android.net.Uri;
import com.bilibili.base.MainThread;
import com.bilibili.commons.io.FileUtils;
import com.bilibili.videodownloader.directory.VideoDownloadDirectory;
import com.bilibili.videodownloader.directory.VideoDownloadDirectoryFactory;
import com.bilibili.videodownloader.directory.file.VideoFile;
import io.reactivex.rxjava3.functions.Function;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: FileTransfer.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
final class FileTransfer$transfer$3<T, R> implements Function {
    final /* synthetic */ Application $app;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileTransfer$transfer$3(Application application) {
        this.$app = application;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0141, code lost:
        if (r5 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x016c, code lost:
        if (r6 == null) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0253 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0243 A[Catch: all -> 0x02ac, TryCatch #5 {all -> 0x02ac, blocks: (B:60:0x01a9, B:62:0x01e1, B:65:0x021e, B:67:0x0224, B:69:0x022e, B:71:0x0235, B:80:0x0243, B:82:0x0253, B:83:0x02a3, B:84:0x02ab), top: B:111:0x01a9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Boolean apply(List<FileTransferItem> list) {
        File privateDownloadDir;
        String str;
        String uri;
        String uri2;
        boolean preCheckResult;
        boolean preParseResult;
        boolean copyParseResult;
        boolean z;
        File toFile;
        String uri3;
        Intrinsics.checkNotNullParameter(list, "entries");
        if (!list.isEmpty()) {
            privateDownloadDir = FileTransfer.INSTANCE.getAimDir();
            FileTransfer.INSTANCE.setEntryCount(list.size());
            FileTransfer.INSTANCE.log("find " + FileTransfer.INSTANCE.getEntryCount() + " entry");
            List<FileTransferItem> $this$filter$iv = list;
            Application application = this.$app;
            Collection destination$iv$iv = new ArrayList();
            Iterator<T> it = $this$filter$iv.iterator();
            while (true) {
                str = "";
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                VideoDownloadDirectory to = VideoDownloadDirectoryFactory.create(VideoFile.fromFile(privateDownloadDir), ((FileTransferItem) next).getEntry());
                Iterable $this$filter$iv2 = $this$filter$iv;
                Application application2 = application;
                Uri uri4 = to.getEntryDirectory(application, false).getUri();
                if (uri4 != null && (uri3 = uri4.toString()) != null) {
                    str = uri3;
                }
                boolean isEntryExist = new File(new File(new URI(str)), "entry.json").exists();
                if (isEntryExist) {
                    FileTransfer.INSTANCE.log("custom dir has same entry, so filter it > " + toFile.getAbsolutePath());
                }
                if (!isEntryExist) {
                    destination$iv$iv.add(next);
                }
                $this$filter$iv = $this$filter$iv2;
                application = application2;
            }
            Application application3 = this.$app;
            Iterable $this$forEachIndexed$iv = (List) destination$iv$iv;
            boolean z2 = false;
            int index$iv = 0;
            Iterator<T> it2 = $this$forEachIndexed$iv.iterator();
            while (it2.hasNext()) {
                Object item$iv = it2.next();
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                FileTransferItem fileTransferItem = (FileTransferItem) item$iv;
                int index = index$iv;
                try {
                    VideoFile fromVideoFile = VideoFile.fromPath(application3, fileTransferItem.getCacheRoot());
                    VideoFile toVideoFile = VideoFile.fromFile(privateDownloadDir);
                    VideoDownloadDirectory from = VideoDownloadDirectoryFactory.create(fromVideoFile, fileTransferItem.getEntry());
                    VideoDownloadDirectory to2 = VideoDownloadDirectoryFactory.create(toVideoFile, fileTransferItem.getEntry());
                    Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                    try {
                        boolean z3 = z2;
                        try {
                            Iterator<T> it3 = it2;
                            Uri uri5 = from.getDirectoryForEntry(application3, false).getUri();
                            if (uri5 != null) {
                                try {
                                    uri = uri5.toString();
                                } catch (Throwable th) {
                                    t = th;
                                    BLog.e(FileTransfer.INSTANCE.getTag(), t);
                                    throw t;
                                }
                            }
                            uri = str;
                            File fromFile = new File(new URI(uri));
                            try {
                                Uri uri6 = to2.getEntryDirectory(application3, false).getUri();
                                if (uri6 != null) {
                                    try {
                                        uri2 = uri6.toString();
                                    } catch (Throwable th2) {
                                        t = th2;
                                        BLog.e(FileTransfer.INSTANCE.getTag(), t);
                                        throw t;
                                    }
                                }
                                uri2 = str;
                                File toFile2 = new File(new URI(uri2));
                                if (!toFile2.exists()) {
                                    toFile2.mkdirs();
                                }
                                preCheckResult = FileTransfer.INSTANCE.copyPreCheck(fromFile, toFile2);
                                try {
                                    preParseResult = FileTransfer.INSTANCE.parseVideoEntry(application3, fileTransferItem.getEntry(), fromVideoFile);
                                    try {
                                        String str2 = str;
                                        FileTransfer.INSTANCE.log("current transfer: \n from > " + fromFile.getAbsolutePath() + " \n to > " + toFile2.getAbsolutePath() + " \n file status > " + preCheckResult + " \n download entry status > " + preParseResult);
                                        if (preCheckResult) {
                                            FileTransfer.INSTANCE.copyDir(application3, fromFile, toFile2);
                                            FileTransfer.INSTANCE.insertToDb(fileTransferItem.getEntry(), privateDownloadDir, toFile2);
                                            copyParseResult = FileTransfer.INSTANCE.parseVideoEntry(application3, fileTransferItem.getEntry(), toVideoFile);
                                            FileTransfer.INSTANCE.log("parse download entry after copy > " + copyParseResult);
                                            if (preParseResult && !copyParseResult) {
                                                return false;
                                            }
                                            FileUtils.deleteQuietly(fromFile);
                                            File $this$apply_u24lambda_u241_u240 = fromFile.getParentFile();
                                            if ($this$apply_u24lambda_u241_u240 != null) {
                                                File[] listFiles = $this$apply_u24lambda_u241_u240.listFiles();
                                                if (listFiles != null) {
                                                    if (!(listFiles.length == 0)) {
                                                        z = false;
                                                        if (!z) {
                                                            FileTransfer.INSTANCE.log("parent file is empty, delete it");
                                                            FileUtils.deleteQuietly(fromFile.getParentFile());
                                                        }
                                                    }
                                                }
                                                z = true;
                                                if (!z) {
                                                }
                                            }
                                            FileTransfer.INSTANCE.setCurrntIndex(index + 1);
                                            FileTransfer.INSTANCE.log("progress > " + FileTransfer.INSTANCE.getEntryCount() + ", " + FileTransfer.INSTANCE.getCurrntIndex());
                                            MainThread.runOnMainThread(new Function0() { // from class: tv.danmaku.bili.services.videodownload.utils.FileTransfer$transfer$3$$ExternalSyntheticLambda0
                                                public final Object invoke() {
                                                    Unit apply$lambda$1$1;
                                                    apply$lambda$1$1 = FileTransfer$transfer$3.apply$lambda$1$1();
                                                    return apply$lambda$1$1;
                                                }
                                            });
                                            $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                                            z2 = z3;
                                            it2 = it3;
                                            index$iv = index$iv2;
                                            str = str2;
                                        } else {
                                            throw new IllegalStateException("pre check fail");
                                        }
                                    } catch (Throwable th3) {
                                        t = th3;
                                        BLog.e(FileTransfer.INSTANCE.getTag(), t);
                                        throw t;
                                    }
                                } catch (Throwable th4) {
                                    t = th4;
                                }
                            } catch (Throwable th5) {
                                t = th5;
                            }
                        } catch (Throwable th6) {
                            t = th6;
                        }
                    } catch (Throwable th7) {
                        t = th7;
                    }
                } catch (Throwable th8) {
                    t = th8;
                }
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit apply$lambda$1$1() {
        TransferListener listener = FileTransfer.INSTANCE.getListener();
        if (listener != null) {
            listener.onProgress(FileTransfer.INSTANCE.getEntryCount(), FileTransfer.INSTANCE.getCurrntIndex());
        }
        return Unit.INSTANCE;
    }
}