package kntr.app.game.base.bridge;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: GameTeenagerModeBridge.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\nH&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lkntr/app/game/base/bridge/IKntrGameTeenagerModeService;", RoomRecommendViewModel.EMPTY_CURSOR, "isForbiddenPay", RoomRecommendViewModel.EMPTY_CURSOR, "isForbiddenDownload", "isForbiddenSmall", "isForbiddenDetailPage", "isEnable", "isLessonEnable", "openSmallInterceptPage", RoomRecommendViewModel.EMPTY_CURSOR, "openInterceptPage", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IKntrGameTeenagerModeService {
    boolean isEnable();

    boolean isForbiddenDetailPage();

    boolean isForbiddenDownload();

    boolean isForbiddenPay();

    boolean isForbiddenSmall();

    boolean isLessonEnable();

    void openInterceptPage();

    void openSmallInterceptPage();
}