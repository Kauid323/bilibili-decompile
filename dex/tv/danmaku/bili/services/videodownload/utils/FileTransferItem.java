package tv.danmaku.bili.services.videodownload.utils;

import com.bilibili.videodownloader.model.VideoDownloadEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.loginv2.LoginActivityV2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileTransfer.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/services/videodownload/utils/FileTransferItem;", "", "cacheRoot", "", LoginActivityV2.LOGIN_ENTRY_KEY, "Lcom/bilibili/videodownloader/model/VideoDownloadEntry;", "<init>", "(Ljava/lang/String;Lcom/bilibili/videodownloader/model/VideoDownloadEntry;)V", "getCacheRoot", "()Ljava/lang/String;", "getEntry", "()Lcom/bilibili/videodownloader/model/VideoDownloadEntry;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FileTransferItem {
    private final String cacheRoot;
    private final VideoDownloadEntry<?> entry;

    public FileTransferItem(String cacheRoot, VideoDownloadEntry<?> videoDownloadEntry) {
        Intrinsics.checkNotNullParameter(cacheRoot, "cacheRoot");
        Intrinsics.checkNotNullParameter(videoDownloadEntry, LoginActivityV2.LOGIN_ENTRY_KEY);
        this.cacheRoot = cacheRoot;
        this.entry = videoDownloadEntry;
    }

    public final String getCacheRoot() {
        return this.cacheRoot;
    }

    public final VideoDownloadEntry<?> getEntry() {
        return this.entry;
    }
}