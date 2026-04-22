package tv.danmaku.bili.services.videodownload.utils;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.media.resource.ExtraInfo;
import com.bilibili.lib.media.resource.MediaResource;
import com.bilibili.videodownloader.db.DownloadDatabase;
import com.bilibili.videodownloader.directory.file.VideoFile;
import com.bilibili.videodownloader.model.DegradeEntryFactory;
import com.bilibili.videodownloader.model.VideoDownloadAVPageEntry;
import com.bilibili.videodownloader.model.VideoDownloadEntry;
import com.bilibili.videodownloader.model.VideoDownloadSeasonEpEntry;
import com.bilibili.videodownloader.model.av.Page;
import com.bilibili.videodownloader.model.season.Episode;
import com.bilibili.videodownloader.resolver.downloaded.DownloadedParams;
import com.bilibili.videodownloader.resolver.downloaded.DownloadedResolver;
import com.bilibili.videodownloader.resolver.downloaded.ResolveCallback;
import com.bilibili.videodownloader.utils.DBUtilsKt;
import com.bilibili.videodownloader.utils.Jsonable;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.services.videodownload.VideoDownloadHelper;
import tv.danmaku.bili.services.videodownload.strategy.VideoDownloadStorageStrategy;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.loginv2.LoginActivityV2;

/* compiled from: FileTransfer.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J$\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J$\u0010\u0015\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J$\u0010\u0016\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013H\u0002J2\u0010\u0019\u001a\u0004\u0018\u00010\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\u001d\u001a\u00020\tH\u0002J$\u0010\u001e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010\u0013H\u0002J\u001a\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$J\u0018\u0010%\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u0013H\u0002J\b\u0010'\u001a\u00020\u0013H\u0002J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u0013H\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010-*\u0006\u0012\u0002\b\u00030\rH\u0002¨\u0006."}, d2 = {"Ltv/danmaku/bili/services/videodownload/utils/FileTransfer;", "Ltv/danmaku/bili/services/videodownload/utils/DownloadTransfer;", "<init>", "()V", "transfer", "", "src", "Landroid/net/Uri;", "parseVideoEntry", "", "ctx", "Landroid/content/Context;", LoginActivityV2.LOGIN_ENTRY_KEY, "Lcom/bilibili/videodownloader/model/VideoDownloadEntry;", "toVideoFile", "Lcom/bilibili/videodownloader/directory/file/VideoFile;", "insertToDb", "Lcom/bilibili/videodownloader/utils/Jsonable;", "root", "Ljava/io/File;", "child", "deleteFromDb", "copyDir", "fromFile", "aimFile", "getChild", "displayName", "", "create", "isDir", "copyFile", "aim", "copy", "inputStream", "Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "copyPreCheck", "toFile", "getAimDir", "findDownloadItems", "", "Ltv/danmaku/bili/services/videodownload/utils/FileTransferItem;", "file", "toResolveParams", "Lcom/bilibili/videodownloader/resolver/downloaded/DownloadedParams;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FileTransfer extends DownloadTransfer {
    public static final FileTransfer INSTANCE = new FileTransfer();
    public static final int $stable = 8;

    private FileTransfer() {
    }

    @Override // tv.danmaku.bili.services.videodownload.utils.DownloadTransfer
    public void transfer(final Uri src) {
        Intrinsics.checkNotNullParameter(src, "src");
        if (isProcessing()) {
            return;
        }
        setProcessing(true);
        final Application app = getApplication();
        if (app == null) {
            return;
        }
        final long startTime = System.currentTimeMillis();
        VideoDownloadHelper.init(app);
        getPauseDownloadObservable(app).map(new Function() { // from class: tv.danmaku.bili.services.videodownload.utils.FileTransfer$transfer$1
            public final Uri apply(Boolean it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return src;
            }
        }).observeOn(Schedulers.io()).map(new Function() { // from class: tv.danmaku.bili.services.videodownload.utils.FileTransfer$transfer$2
            public final List<FileTransferItem> apply(Uri uri) {
                List<FileTransferItem> findDownloadItems;
                Intrinsics.checkNotNullParameter(uri, AudioIntentHelper.ARGS_URI);
                findDownloadItems = FileTransfer.INSTANCE.findDownloadItems(app, new File(new URI(uri.toString())));
                return findDownloadItems;
            }
        }).observeOn(Schedulers.io()).map(new FileTransfer$transfer$3(app)).observeOn(AndroidSchedulers.mainThread()).flatMap(new Function() { // from class: tv.danmaku.bili.services.videodownload.utils.FileTransfer$transfer$4
            public final ObservableSource<? extends Boolean> apply(Boolean it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return FileTransfer.INSTANCE.getForceLoadObservable(app, it.booleanValue());
            }
        }).subscribe(new Consumer() { // from class: tv.danmaku.bili.services.videodownload.utils.FileTransfer$transfer$5
            public final void accept(Boolean it) {
                Intrinsics.checkNotNullParameter(it, "it");
                FileTransfer.INSTANCE.setProcessing(false);
                if (it.booleanValue()) {
                    FileTransfer.INSTANCE.log("transfer success");
                    DownloadTaskTransfer.recordTransfered(app);
                    FileTransfer.INSTANCE.trackSuccess(System.currentTimeMillis() - startTime, FileTransfer.INSTANCE.getEntryCount());
                    TransferListener listener = FileTransfer.INSTANCE.getListener();
                    if (listener != null) {
                        listener.onSuccess();
                        return;
                    }
                    return;
                }
                FileTransfer.INSTANCE.log("transfer fail");
                FileTransfer.INSTANCE.trackFail("");
                TransferListener listener2 = FileTransfer.INSTANCE.getListener();
                if (listener2 != null) {
                    listener2.onFail(null);
                }
            }
        }, new Consumer() { // from class: tv.danmaku.bili.services.videodownload.utils.FileTransfer$transfer$6
            public final void accept(Throwable it) {
                Intrinsics.checkNotNullParameter(it, "it");
                FileTransfer.INSTANCE.setProcessing(false);
                Throwable $this$accept_u24lambda_u240 = it.getCause();
                if ($this$accept_u24lambda_u240 != null) {
                    BLog.e(FileTransfer.INSTANCE.getTag(), $this$accept_u24lambda_u240);
                }
                FileTransfer fileTransfer = FileTransfer.INSTANCE;
                Throwable cause = it.getCause();
                fileTransfer.trackFail(cause != null ? cause.getMessage() : null);
                FileTransfer.INSTANCE.log("transfer fail");
                TransferListener listener = FileTransfer.INSTANCE.getListener();
                if (listener != null) {
                    listener.onFail(it.getCause());
                }
            }
        }, new Action() { // from class: tv.danmaku.bili.services.videodownload.utils.FileTransfer$$ExternalSyntheticLambda0
            public final void run() {
                FileTransfer.transfer$lambda$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void transfer$lambda$0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean parseVideoEntry(Context ctx, VideoDownloadEntry<?> videoDownloadEntry, VideoFile toVideoFile) {
        ExtraInfo extraInfo;
        ExtraInfo.DownloadedResolveErrLimit downloadedResolveErrLimit;
        DownloadedParams it = toResolveParams(videoDownloadEntry);
        if (it != null) {
            MediaResource resolveResult = new DownloadedResolver((ResolveCallback) null).resolve(ctx, new VideoFile[]{toVideoFile}, it);
            return ((resolveResult == null || (extraInfo = resolveResult.getExtraInfo()) == null || (downloadedResolveErrLimit = extraInfo.getDownloadedResolveErrLimit()) == null) ? 0 : downloadedResolveErrLimit.getErrCode()) == 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void insertToDb(Jsonable entry, File root, File child) {
        VideoDownloadEntry downloadEntry;
        Application app = BiliContext.application();
        if (app == null) {
            return;
        }
        if (entry instanceof VideoDownloadAVPageEntry) {
            downloadEntry = (VideoDownloadEntry) entry;
        } else {
            downloadEntry = entry instanceof VideoDownloadSeasonEpEntry ? (VideoDownloadEntry) entry : null;
        }
        if (downloadEntry == null) {
            return;
        }
        DownloadDatabase.Companion.get(app).downloadDao().insertOrUpdate(DBUtilsKt.toDownloadEntry(Uri.fromFile(root).toString(), Uri.fromFile(child).toString(), downloadEntry));
    }

    private final void deleteFromDb(Jsonable entry, File root, File child) {
        VideoDownloadEntry downloadEntry;
        Application app = BiliContext.application();
        if (app == null) {
            return;
        }
        if (entry instanceof VideoDownloadAVPageEntry) {
            downloadEntry = (VideoDownloadEntry) entry;
        } else {
            downloadEntry = entry instanceof VideoDownloadSeasonEpEntry ? (VideoDownloadEntry) entry : null;
        }
        if (downloadEntry == null) {
            return;
        }
        DownloadDatabase.Companion.get(app).downloadDao().delete(DBUtilsKt.toDownloadEntry(Uri.fromFile(root).toString(), Uri.fromFile(child).toString(), downloadEntry));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void copyDir(Context ctx, File fromFile, File aimFile) {
        File[] listFiles;
        if (fromFile == null || aimFile == null || !fromFile.isDirectory() || !fromFile.isDirectory() || (listFiles = fromFile.listFiles()) == null) {
            return;
        }
        for (File file : listFiles) {
            if (file.isDirectory()) {
                File nextChild = INSTANCE.getChild(aimFile, file.getName(), true, true);
                INSTANCE.copyDir(ctx, file, nextChild);
            } else {
                File aim = INSTANCE.getChild(aimFile, file.getName(), true, false);
                INSTANCE.copyFile(ctx, file, aim);
            }
        }
    }

    static /* synthetic */ File getChild$default(FileTransfer fileTransfer, File file, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        return fileTransfer.getChild(file, str, z, z2);
    }

    private final File getChild(File src, String displayName, boolean create, boolean isDir) {
        if (src == null || displayName == null) {
            return null;
        }
        File child = new File(src, displayName);
        if (create) {
            if (isDir) {
                child.mkdirs();
            } else {
                child.createNewFile();
            }
        }
        return child;
    }

    private final void copyFile(Context ctx, File src, File aim) {
        if (src == null || aim == null) {
            return;
        }
        FileInputStream input = new FileInputStream(src);
        FileOutputStream output = new FileOutputStream(aim);
        copy(input, output);
    }

    public final void copy(InputStream inputStream, OutputStream outputStream) {
        if (inputStream == null || outputStream == null) {
            return;
        }
        try {
            byte[] buffer = new byte[4096];
            while (true) {
                int it = inputStream.read(buffer);
                if (it >= 0) {
                    outputStream.write(buffer, 0, it);
                } else {
                    return;
                }
            }
        } finally {
            outputStream.flush();
            outputStream.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean copyPreCheck(File fromFile, File toFile) {
        return fromFile.exists() && toFile.exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getAimDir() {
        File driFile;
        File dir = VideoDownloadStorageStrategy.getSecondaryDirectoryFile(getApplication());
        if (dir == null) {
            dir = VideoDownloadStorageStrategy.getPrimaryDirectoryFile(getApplication());
        }
        if (dir != null) {
            driFile = dir;
        } else {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            Application application = getApplication();
            driFile = new File(externalStorageDirectory, "Android/data/" + (application != null ? application.getPackageName() : null) + "/download");
        }
        if (dir != null && !dir.exists()) {
            dir.mkdirs();
        }
        return driFile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<FileTransferItem> findDownloadItems(Context ctx, File file) {
        ArrayList result = new ArrayList();
        Iterable entries = new DegradeEntryFactory().loadAllEntriesInDirectory(ctx, VideoFile.fromFile(file));
        if (entries == null) {
            return result;
        }
        Iterable $this$forEach$iv = entries;
        for (Object element$iv : $this$forEach$iv) {
            VideoDownloadEntry it = (VideoDownloadEntry) element$iv;
            String uri = Uri.fromFile(file).toString();
            Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
            Intrinsics.checkNotNull(it);
            result.add(new FileTransferItem(uri, it));
        }
        return result;
    }

    private final DownloadedParams toResolveParams(VideoDownloadEntry<?> videoDownloadEntry) {
        if (videoDownloadEntry instanceof VideoDownloadAVPageEntry) {
            long avid = ((VideoDownloadAVPageEntry) videoDownloadEntry).getAvid();
            Page page = ((VideoDownloadAVPageEntry) videoDownloadEntry).mPageData;
            return new DownloadedParams(avid, page != null ? page.page : 0, 0L, "", "downloaded", videoDownloadEntry.mStoragePath, ((VideoDownloadAVPageEntry) videoDownloadEntry).getCid());
        } else if (videoDownloadEntry instanceof VideoDownloadSeasonEpEntry) {
            Episode episode = ((VideoDownloadSeasonEpEntry) videoDownloadEntry).mEpisode;
            return new DownloadedParams(0L, 0, episode != null ? episode.id : 0L, ((VideoDownloadSeasonEpEntry) videoDownloadEntry).getSeasonId(), "downloaded", videoDownloadEntry.mStoragePath, ((VideoDownloadSeasonEpEntry) videoDownloadEntry).getCid());
        } else {
            return null;
        }
    }
}