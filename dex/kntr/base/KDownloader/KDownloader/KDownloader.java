package kntr.base.KDownloader.KDownloader;

import com.bilibili.lib.foundation.FoundationAlias;
import java.io.File;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.KDownloader.KDownloader.IDownloader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: KDownloader.android.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u0010"}, d2 = {"Lkntr/base/KDownloader/KDownloader/KDownloader;", "Lkntr/base/KDownloader/KDownloader/IDownloader;", "<init>", "()V", "create", "Lkntr/base/KDownloader/KDownloader/IDownloader$DownloadRequest;", "url", "", "dir", "fileName", "tag", "fullPath", "pause", "", "taskId", "cancel", "downloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KDownloader implements IDownloader {
    @Override // kntr.base.KDownloader.KDownloader.IDownloader
    public IDownloader.DownloadRequest create(String url, String dir, String fileName, String tag) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (StringsKt.startsWith$default(dir, "/", false, 2, (Object) null)) {
            throw new IllegalArgumentException("downloader into dir should be a relative path and not start with /");
        }
        String file = FoundationAlias.getFapp().getFilesDir().toString();
        String dirPath = new File(file + "/" + KDownloaderKt.getDOWNLOAD_DIR_PREFIX(), dir).getAbsolutePath();
        IDownloader iDownloader = KDownloaderKt.getIDownloader();
        Intrinsics.checkNotNull(dirPath);
        return iDownloader.create(url, dirPath, fileName, tag);
    }

    @Override // kntr.base.KDownloader.KDownloader.IDownloader
    public IDownloader.DownloadRequest create(String url, String fullPath, String tag) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(fullPath, "fullPath");
        Intrinsics.checkNotNullParameter(tag, "tag");
        File file = new File(fullPath);
        String parent = file.getParent();
        String directory = (parent == null || (directory = parent.toString()) == null) ? "" : "";
        String fileName = file.getName();
        if (!StringsKt.startsWith$default(directory, "/", false, 2, (Object) null)) {
            throw new IllegalArgumentException("downloader into dir should be a absolute path and start with /");
        }
        Intrinsics.checkNotNull(fileName);
        if (StringsKt.isBlank(fileName)) {
            throw new IllegalArgumentException("downloader into name should not be empty");
        }
        return KDownloaderKt.getIDownloader().create(url, directory, fileName, tag);
    }

    @Override // kntr.base.KDownloader.KDownloader.IDownloader
    public boolean pause(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        return KDownloaderKt.getIDownloader().pause(taskId);
    }

    @Override // kntr.base.KDownloader.KDownloader.IDownloader
    public boolean cancel(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        return KDownloaderKt.getIDownloader().cancel(taskId);
    }
}