package tv.danmaku.bili.services.videodownload;

import android.content.Context;
import android.os.Parcelable;
import com.bilibili.koffline.resolver.OfflineResolveParams;
import com.bilibili.koffline.resolver.OfflineResolverKt;
import com.bilibili.moduleservice.videodownload.LocalDMResource;
import com.bilibili.moduleservice.videodownload.VideoDownloadService;
import com.bilibili.offline.OfflineABServiceKt;
import com.bilibili.videodownloader.directory.file.VideoFile;
import com.bilibili.videodownloader.model.VideoDownloadEntry;
import com.bilibili.videodownloader.resolver.downloaded.DownloadResolveApi;
import com.bilibili.videodownloader.resolver.downloaded.DownloadedParams;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.services.videodownload.strategy.VideoDownloadStorageStrategy;
import tv.danmaku.bili.ui.filechooser.FileChooserActivity;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: VideoDownloadServiceImpl.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J_\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0012J7\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\u0014J_\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u000fH\u0016¨\u0006\u001e"}, d2 = {"Ltv/danmaku/bili/services/videodownload/VideoDownloadServiceImpl;", "Lcom/bilibili/moduleservice/videodownload/VideoDownloadService;", "<init>", "()V", "resolveDanmaku", "Lcom/bilibili/moduleservice/videodownload/LocalDMResource;", "context", "Landroid/content/Context;", "avid", "", "cid", LoginReporterV2.PAGE_FROM_KEY, "", "epId", "sid", "", "from", "dir", "(Landroid/content/Context;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bilibili/moduleservice/videodownload/LocalDMResource;", "resolveChronos", "(Landroid/content/Context;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/String;", "resolveMedia", "", "(Landroid/content/Context;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "resolveDownloadPath", "videoDownloadEntry", "Landroid/os/Parcelable;", "getVideoFileInputStreamFromPath", "Ljava/io/FileInputStream;", FileChooserActivity.PATH, "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class VideoDownloadServiceImpl implements VideoDownloadService {
    public static final int $stable = 0;

    public LocalDMResource resolveDanmaku(Context context, Long avid, Long cid, Integer page, Long epId, String sid, String from, String dir) throws FileNotFoundException {
        Long longOrNull;
        if (context == null) {
            return null;
        }
        if (OfflineABServiceKt.hitsKOffline()) {
            return OfflineResolverKt.getOfflineDanmakuFile(new OfflineResolveParams(avid != null ? avid.longValue() : 0L, cid != null ? cid.longValue() : 0L, (sid == null || (longOrNull = StringsKt.toLongOrNull(sid)) == null) ? 0L : longOrNull.longValue(), epId != null ? epId.longValue() : 0L));
        }
        VideoFile localDanmakuFile = DownloadResolveApi.getLocalDanmakuFile(context, new DownloadedParams(avid != null ? avid.longValue() : 0L, page != null ? page.intValue() : 0, epId != null ? epId.longValue() : 0L, sid == null ? "" : sid, from == null ? "" : from, dir == null ? "" : dir, cid != null ? cid.longValue() : 0L), VideoDownloadStorageStrategy.getCurrentSortedDownloadDirs(context));
        return new LocalDMResource("XML", localDanmakuFile != null ? localDanmakuFile.getFileInputStream() : null);
    }

    public String resolveChronos(Context context, Long avid, String sid, Long epId) {
        if (context != null) {
            if (OfflineABServiceKt.hitsKOffline()) {
                return OfflineResolverKt.getOfflineChronosFile();
            }
            return DownloadResolveApi.getLocalChronosFile(context, new DownloadedParams(avid != null ? avid.longValue() : 0L, 0, epId != null ? epId.longValue() : 0L, sid, "", "", 0L), VideoDownloadStorageStrategy.getCurrentSortedDownloadDirs(context));
        }
        return null;
    }

    public Object resolveMedia(Context context, Long avid, Long cid, Integer page, Long epId, String sid, String from, String dir) {
        Long longOrNull;
        if (context != null) {
            if (OfflineABServiceKt.hitsKOffline()) {
                return OfflineResolverKt.getOfflineMediaResource(context, new OfflineResolveParams(avid != null ? avid.longValue() : 0L, cid != null ? cid.longValue() : 0L, (sid == null || (longOrNull = StringsKt.toLongOrNull(sid)) == null) ? 0L : longOrNull.longValue(), epId != null ? epId.longValue() : 0L));
            }
            return DownloadResolveApi.getDownloadedMediaResource(context, new DownloadedParams(avid != null ? avid.longValue() : 0L, page != null ? page.intValue() : 0, epId != null ? epId.longValue() : 0L, sid == null ? "" : sid, from == null ? "" : from, dir == null ? "" : dir, cid != null ? cid.longValue() : 0L), VideoDownloadStorageStrategy.getCurrentSortedDownloadDirs(context));
        }
        return null;
    }

    public String resolveDownloadPath(Context context, Parcelable videoDownloadEntry) {
        VideoDownloadEntry entry = videoDownloadEntry instanceof VideoDownloadEntry ? (VideoDownloadEntry) videoDownloadEntry : null;
        if (entry == null || context == null) {
            return null;
        }
        return VideoDownloadStorageStrategy.getDownloadPath(context, entry);
    }

    public FileInputStream getVideoFileInputStreamFromPath(Context context, String path) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, FileChooserActivity.PATH);
        VideoFile fromPath = VideoFile.fromPath(context, path);
        if (fromPath != null) {
            return fromPath.getFileInputStream();
        }
        return null;
    }
}