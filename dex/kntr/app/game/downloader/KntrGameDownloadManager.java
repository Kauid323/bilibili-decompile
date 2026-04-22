package kntr.app.game.downloader;

import com.bilibili.biligame.kntr.common.bean.KBiligame;
import java.util.List;
import kntr.app.game.downloader.bean.GameDownloadState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GameDownloader.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nJ\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012¨\u0006\u0013"}, d2 = {"Lkntr/app/game/downloader/KntrGameDownloadManager;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "handleClickDownload", RoomRecommendViewModel.EMPTY_CURSOR, "game", "Lcom/bilibili/biligame/kntr/common/bean/KBiligame;", "registerDownloadStatus", "gameList", RoomRecommendViewModel.EMPTY_CURSOR, "reportDownloadClick", "buttonName", RoomRecommendViewModel.EMPTY_CURSOR, "updateDownloadState", "Lkntr/app/game/downloader/bean/GameDownloadState;", "pkgName", "pkgVer", RoomRecommendViewModel.EMPTY_CURSOR, "downloader_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KntrGameDownloadManager {
    public static final KntrGameDownloadManager INSTANCE = new KntrGameDownloadManager();

    private KntrGameDownloadManager() {
    }

    public final void handleClickDownload(KBiligame game) {
        Intrinsics.checkNotNullParameter(game, "game");
        IKntrGameDownloader access$getDownloader$p = GameDownloaderKt.access$getDownloader$p();
        if (access$getDownloader$p != null) {
            access$getDownloader$p.handleClickDownload(game);
        }
    }

    public final void registerDownloadStatus(List<? extends KBiligame> list) {
        IKntrGameDownloader access$getDownloader$p = GameDownloaderKt.access$getDownloader$p();
        if (access$getDownloader$p != null) {
            access$getDownloader$p.registerDownloadStatus(list);
        }
    }

    public final void reportDownloadClick(KBiligame game, String buttonName) {
        Intrinsics.checkNotNullParameter(game, "game");
        Intrinsics.checkNotNullParameter(buttonName, "buttonName");
        IKntrGameDownloader access$getDownloader$p = GameDownloaderKt.access$getDownloader$p();
        if (access$getDownloader$p != null) {
            access$getDownloader$p.reportDownloadClick(game, buttonName);
        }
    }

    public final GameDownloadState updateDownloadState(String pkgName, int pkgVer) {
        GameDownloadState updateDownloadState;
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        IKntrGameDownloader access$getDownloader$p = GameDownloaderKt.access$getDownloader$p();
        return (access$getDownloader$p == null || (updateDownloadState = access$getDownloader$p.updateDownloadState(pkgName, pkgVer)) == null) ? new GameDownloadState(0, "下载", false, 4, null) : updateDownloadState;
    }
}