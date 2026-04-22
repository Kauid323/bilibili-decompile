package kntr.app.game.base.bridge;

import dagger.BindsOptionalOf;
import dagger.Module;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: GamePayBridge.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lkntr/app/game/base/bridge/KntrGamePayModule;", RoomRecommendViewModel.EMPTY_CURSOR, "bindEmptyKntrGamePayService", "Lkntr/app/game/base/bridge/IKntrGamePayService;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public interface KntrGamePayModule {
    @BindsOptionalOf
    IKntrGamePayService bindEmptyKntrGamePayService();
}