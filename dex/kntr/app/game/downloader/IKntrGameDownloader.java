package kntr.app.game.downloader;

import com.bilibili.biligame.kntr.common.bean.KBiligame;
import java.util.List;
import kntr.app.game.downloader.bean.GameDownloadState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: GameDownloader.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lkntr/app/game/downloader/IKntrGameDownloader;", RoomRecommendViewModel.EMPTY_CURSOR, "handleClickDownload", RoomRecommendViewModel.EMPTY_CURSOR, "game", "Lcom/bilibili/biligame/kntr/common/bean/KBiligame;", "registerDownloadStatus", "gameList", RoomRecommendViewModel.EMPTY_CURSOR, "reportDownloadClick", "buttonName", RoomRecommendViewModel.EMPTY_CURSOR, "updateDownloadState", "Lkntr/app/game/downloader/bean/GameDownloadState;", "pkgName", "pkgVer", RoomRecommendViewModel.EMPTY_CURSOR, "downloader_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IKntrGameDownloader {
    void handleClickDownload(KBiligame kBiligame);

    void registerDownloadStatus(List<? extends KBiligame> list);

    void reportDownloadClick(KBiligame kBiligame, String str);

    GameDownloadState updateDownloadState(String str, int i);
}