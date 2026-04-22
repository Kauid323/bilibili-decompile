package kntr.app.game.base.bridge;

import java.util.Map;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: GameRouterBridge.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH&J\u001e\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lkntr/app/game/base/bridge/GameRouterService;", RoomRecommendViewModel.EMPTY_CURSOR, "isAppStoreUrl", RoomRecommendViewModel.EMPTY_CURSOR, "url", RoomRecommendViewModel.EMPTY_CURSOR, "openAppStorePage", RoomRecommendViewModel.EMPTY_CURSOR, "params", RoomRecommendViewModel.EMPTY_CURSOR, "getCommonRouterParams", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface GameRouterService {
    Map<String, String> getCommonRouterParams(String str);

    boolean isAppStoreUrl(String str);

    void openAppStorePage(String str, Map<String, String> map);
}