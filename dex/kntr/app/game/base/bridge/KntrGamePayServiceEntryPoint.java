package kntr.app.game.base.bridge;

import com.google.common.base.Optional;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: GamePayBridge.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lkntr/app/game/base/bridge/KntrGamePayServiceEntryPoint;", RoomRecommendViewModel.EMPTY_CURSOR, "getKntrGamePayService", "Lcom/google/common/base/Optional;", "Lkntr/app/game/base/bridge/IKntrGamePayService;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface KntrGamePayServiceEntryPoint {
    Optional<IKntrGamePayService> getKntrGamePayService();
}