package kntr.app.game.base.bridge;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;

/* compiled from: GameTeenagerModeBridge.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u0005J\r\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\r\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\r¨\u0006\u000f"}, d2 = {"Lkntr/app/game/base/bridge/KntrGameTeenagerModeService;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "isForbiddenPay", RoomRecommendViewModel.EMPTY_CURSOR, "isForbiddenDownload", "isForbiddenSmall", "isForbiddenDetailPage", "isEnable", "isLessonEnable", "openSmallInterceptPage", RoomRecommendViewModel.EMPTY_CURSOR, "()Lkotlin/Unit;", "openInterceptPage", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KntrGameTeenagerModeService {
    public static final int $stable = 0;
    public static final KntrGameTeenagerModeService INSTANCE = new KntrGameTeenagerModeService();

    private KntrGameTeenagerModeService() {
    }

    public final boolean isForbiddenPay() {
        IKntrGameTeenagerModeService iKntrGameTeenagerModeService;
        iKntrGameTeenagerModeService = GameTeenagerModeBridgeKt.gameTeenagerModeService;
        return iKntrGameTeenagerModeService != null && iKntrGameTeenagerModeService.isForbiddenPay();
    }

    public final boolean isForbiddenDownload() {
        IKntrGameTeenagerModeService iKntrGameTeenagerModeService;
        iKntrGameTeenagerModeService = GameTeenagerModeBridgeKt.gameTeenagerModeService;
        return iKntrGameTeenagerModeService != null && iKntrGameTeenagerModeService.isForbiddenDownload();
    }

    public final boolean isForbiddenSmall() {
        IKntrGameTeenagerModeService iKntrGameTeenagerModeService;
        iKntrGameTeenagerModeService = GameTeenagerModeBridgeKt.gameTeenagerModeService;
        return iKntrGameTeenagerModeService != null && iKntrGameTeenagerModeService.isForbiddenSmall();
    }

    public final boolean isForbiddenDetailPage() {
        IKntrGameTeenagerModeService iKntrGameTeenagerModeService;
        iKntrGameTeenagerModeService = GameTeenagerModeBridgeKt.gameTeenagerModeService;
        return iKntrGameTeenagerModeService != null && iKntrGameTeenagerModeService.isForbiddenDetailPage();
    }

    public final boolean isEnable() {
        IKntrGameTeenagerModeService iKntrGameTeenagerModeService;
        iKntrGameTeenagerModeService = GameTeenagerModeBridgeKt.gameTeenagerModeService;
        return iKntrGameTeenagerModeService != null && iKntrGameTeenagerModeService.isEnable();
    }

    public final boolean isLessonEnable() {
        IKntrGameTeenagerModeService iKntrGameTeenagerModeService;
        iKntrGameTeenagerModeService = GameTeenagerModeBridgeKt.gameTeenagerModeService;
        return iKntrGameTeenagerModeService != null && iKntrGameTeenagerModeService.isLessonEnable();
    }

    public final Unit openSmallInterceptPage() {
        IKntrGameTeenagerModeService iKntrGameTeenagerModeService;
        iKntrGameTeenagerModeService = GameTeenagerModeBridgeKt.gameTeenagerModeService;
        if (iKntrGameTeenagerModeService != null) {
            iKntrGameTeenagerModeService.openSmallInterceptPage();
            return Unit.INSTANCE;
        }
        return null;
    }

    public final Unit openInterceptPage() {
        IKntrGameTeenagerModeService iKntrGameTeenagerModeService;
        iKntrGameTeenagerModeService = GameTeenagerModeBridgeKt.gameTeenagerModeService;
        if (iKntrGameTeenagerModeService != null) {
            iKntrGameTeenagerModeService.openInterceptPage();
            return Unit.INSTANCE;
        }
        return null;
    }
}